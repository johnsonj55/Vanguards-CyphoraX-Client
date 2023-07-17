package com.client.graphics.interfaces.impl;

import com.client.Client;
import com.client.Rasterizer3D;
import com.client.Sprite;
import com.client.engine.impl.MouseHandler;
import com.client.features.settings.Preferences;
import com.client.graphics.interfaces.RSInterface;
import com.client.sound.WavPlayer;

public class Slider {

	private int position = 86;

	private double value;

	private int x, y;

	private final double minValue, maxValue, length;

	private final Sprite[] images = new Sprite[2];

	public Slider(Sprite icon, Sprite background, double minimumValue, double maximumValue) {
		this.images[0] = icon;
		this.images[1] = background;
		this.minValue = this.value = minimumValue;
		this.maxValue = maximumValue;
		this.length = this.images[1].myWidth;
	}

	public void draw(int x, int y, int alpha) {
		this.x = x;
		this.y = y;
		images[1].drawSprite(x, y);
		images[0].drawTransparentSprite(x + position - (int) (position / length * images[0].myWidth), y - images[0].myHeight / 2 + images[1].myHeight / 2, alpha);
	}

	public void handleClick(int mouseX, int mouseY, int offsetX, int offsetY, int contentType) {
		int mX = Client.instance.getMouseX();
		int mY = Client.instance.getMouseY();
		if (mX - offsetX >= x && mX - offsetX <= x + length
				&& mY - offsetY >= y + (images[1].myHeight / 2) - (images[0].myHeight / 2)
				&& mY - offsetY <= y + (images[1].myHeight / 2) + (images[0].myHeight / 2))
		{
			position = mouseX - x - offsetX;
			if (position >= length) {
				position = (int) length;
			}
			if (position <= 0) {
				position = 0;
			}
			value = minValue + ((mouseX - x - offsetX) / length) * (maxValue - minValue);
			if (value < minValue) {
				value = minValue;
			}
			if (value > maxValue) {
				value = maxValue;
			}
			int xxx = 525;

			//System.out.println("mX: " + (mouseX - xxx));
			//System.out.println("spriteX: " + images[0].xPosition);
			handleContent(contentType);
		}
	}

	public void handleClickSlide(int mouseX, int mouseY, int offsetX, int offsetY, int contentType) {
		int mX = Client.instance.getMouseX();
		int mY = Client.instance.getMouseY();
		if (mX - offsetX >= x && mX - offsetX <= x + length
				&& mY - offsetY >= y + images[1].myHeight / 2 - images[0].myHeight / 2
				&& mY - offsetY <= y + images[1].myHeight / 2 + images[0].myHeight / 2)
		{
			position = mouseX - x - offsetX;
			if (position >= length) {
				position = (int) length;
			}
			if (position <= 0) {
				position = 0;
			}
			value = minValue + ((mouseX - x - offsetX) / length) * (maxValue - minValue);
			if (value < minValue) {
				value = minValue;
			}
			if (value > maxValue) {
				value = maxValue;
			}
			handleContent(contentType);
		} else {
			return;
		}
	}

	public final static int ZOOM = 1;
	public final static int BRIGHTNESS = 2;
	public final static int MUSIC = 3;
	public final static int SOUND = 4;
	public final static int AREA_SOUND = 5;

	private void handleContent(int contentType) {
		switch(contentType) {
			case ZOOM:
				Client.cameraZoom = (int) (minValue + maxValue - value);
				break;
			case BRIGHTNESS:
				Preferences.getPreferences().brightness = minValue + maxValue - value;
				Rasterizer3D.setBrightness(Preferences.getPreferences().brightness);
				break;
			case MUSIC:
				Preferences.getPreferences().musicVolume = value;
				WavPlayer.player.setVolume((float) ((256f * value) / 10));
				System.out.println(WavPlayer.volume);
				break;
			case SOUND:
				Preferences.getPreferences().soundVolume = value;

				break;
			case AREA_SOUND:
				Preferences.getPreferences().areaSoundVolume = value;

				break;
		}
	}

	public double getPercentage() {
		return ((position / length) * 100);
	}

	public static void handleSlider(int mX, int mY) {

		int tabInterfaceId = Client.tabInterfaceIDs[Client.tabID];

		if (tabInterfaceId != -1) {

			if (tabInterfaceId == 42500) { tabInterfaceId = RSInterface.interfaceCache[42500].children[9]; } // Settings tab adjustment
			RSInterface widget = RSInterface.interfaceCache[tabInterfaceId];

			if (widget.children == null) {
				return;
			}

			for (int childId : widget.children) {
				RSInterface child = RSInterface.interfaceCache[childId];
				if (child == null || child.slider == null)
					continue;
				child.slider.handleClick(mX, mY, !Client.instance.isResized() ? 516 : 0, !Client.instance.isResized() ? 168 : 0, child.contentType);
				if (MouseHandler.instance.clickType == 0) {
					return;
				}
				if (MouseHandler.instance.clickType == 2) {
					child.slider.handleClickSlide(mX, mY, !Client.instance.isResized() ? 516 : 0, !Client.instance.isResized() ? 168 : 0, child.contentType);
				}
			}
			Client.instance.tabAreaAltered = true;
		}

		int interfaceId = Client.instance.openInterfaceID;
		if (interfaceId != -1) {
			RSInterface widget = RSInterface.interfaceCache[interfaceId];
			for (int childId : widget.children) {
				RSInterface child = RSInterface.interfaceCache[childId];
				if (child == null || child.slider == null)
					continue;
				child.slider.handleClick(mX, mY, 4, 4, child.contentType);
			}
		}
	}

	public void setValue(double value) {

		if (value < minValue) {
			value = minValue;
		}
		else if (value > maxValue) {
			value = maxValue;
		}

		this.value = value;
		double shift = 1 - ((value - minValue) / (maxValue - minValue));

		position = (int) (length * shift);
	}
}
