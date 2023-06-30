package com.client.engine.impl;

import com.client.Client;
import net.runelite.rs.api.RSMouseWheelHandler;

import java.awt.*;
import java.awt.event.*;

import com.client.graphics.interfaces.RSInterface;
import com.client.graphics.interfaces.impl.SettingsTabWidget;

import static com.client.engine.impl.MouseHandler.mouseX;

public class MouseWheelHandler implements MouseWheelListener, RSMouseWheelHandler {

    int rotation;
    public static boolean mouseWheelDown;
    public static int mouseWheelX;
    public static int mouseWheelY;

    public synchronized int useRotation() {
        int rotation = this.rotation; 
        this.rotation = 0; 
        return rotation; 
    }

    public void addTo(Component component) {
        component.addMouseWheelListener(this);
    }

    public void removeFrom(Component component) {
        component.removeMouseWheelListener(this);
    }

    public boolean canZoom = true;

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int rotation = e.getWheelRotation();
        if (!handleInterfaceScrolling(e)) {
            if (mouseX > 0 && mouseX < 512 && MouseHandler.mouseY > Client.canvasHeight - 165
                    && MouseHandler.mouseY < Client.canvasHeight - 25) {
                int scrollPos = Client.anInt1089;
                scrollPos -= rotation * 30;
                if (scrollPos < 0)
                    scrollPos = 0;

                if (Client.anInt1089 != scrollPos) {
                    Client.anInt1089 = scrollPos;
                }
            } else if (Client.loggedIn) {

                /** ZOOMING **/
                boolean zoom = !Client.instance.isResized() ? (mouseX < 512) : (mouseX < Client.canvasWidth - 200);
                if(zoom && Client.openInterfaceID == -1) {
                    int zoom_in = !Client.instance.isResized() ? 195 : 240;

                    int zoom_out = !Client.instance.isResized() ? 1105 : 1220;

                    if (rotation != -1) {
                        if (Client.cameraZoom > zoom_in) {
                            Client.cameraZoom -= 45;
                        }
                    } else {
                        if (Client.cameraZoom < zoom_out) {
                            Client.cameraZoom += 45;
                        }
                    }

                }

                Client.inputTaken = true;


                if (Client.openInterfaceID == -1 && zoom) {

                    RSInterface.interfaceCache[SettingsTabWidget.ZOOMTOGGLE].active = true;
                    RSInterface.interfaceCache[SettingsTabWidget.ZOOM_SLIDER].slider.setValue(Client.cameraZoom);
                }
            }
        }
    }

    public boolean handleInterfaceScrolling(MouseWheelEvent event) {
        int rotation = event.getWheelRotation();
        int offsetX;
        int offsetY;

        /* Tab interface scrolling */
        int tabInterfaceID = Client.tabInterfaceIDs[Client.tabID];
        if (tabInterfaceID != -1) {
            offsetX = !Client.instance.isResized() ? 765 - 218 : Client.canvasWidth - 197;
            offsetY = !Client.instance.isResized() ? 503 - 298
                    : Client.canvasHeight - (Client.canvasWidth >= 960 ? 37 : 74) - 267;

            handleTabInterfaceScrolling(RSInterface.get(tabInterfaceID), rotation, offsetX, offsetY);
        }

        /* Main interface scrolling */
        if (Client.openInterfaceID != -1) {
            offsetX = !Client.instance.isResized() ? 4
                    : (Client.canvasWidth / 2) - 356;
            offsetY = !Client.instance.isResized()? 4
                    : (Client.canvasHeight / 2) - 230;
            return handleMainInterfaceScrolling(Client.openInterfaceID, offsetX, offsetY, rotation);
        }

        return false;
    }

    private void handleTabInterfaceScrolling(RSInterface tab, int rotation, int offsetX, int offsetY) {
        int positionX = 0;
        int positionY = 0;
        int width = 0;
        int height = 0;
        int childID = 0;


        if (tab.children != null) {
            for (int index = 0; index < tab.children.length; index++) {
                RSInterface child = RSInterface.interfaceCache[tab.children[index]];
                handleTabInterfaceScrolling(child, rotation, offsetX + tab.childX[index], offsetY + tab.childY[index]);
                if (child.scrollMax > 0) {
                    childID = index;
                    positionX = tab.childX[index];
                    positionY = tab.childY[index];
                    width = child.width + 16;
                    height = child.height;
                    break;
                }
            }
        }
        if (mouseX > offsetX + positionX && MouseHandler.mouseY > offsetY + positionY && mouseX < offsetX + positionX + width
                && MouseHandler.mouseY < offsetY + positionY + height) {
            RSInterface rsInterface = RSInterface.interfaceCache[tab.children[childID]];
            rsInterface.scrollPosition += rotation * 30;
            if (rsInterface.scrollPosition < 0)
                rsInterface.scrollPosition = 0;
            if (rsInterface.scrollPosition > rsInterface.scrollMax - rsInterface.height)
                rsInterface.scrollPosition = rsInterface.scrollMax - rsInterface.height;
            Client.tabAreaAltered = true;
            Client.needDrawTabArea = true;
            return;
        }
    }

    private boolean handleMainInterfaceScrolling(int interfaceId, int offsetX, int offsetY, int rotation) {
        RSInterface rsi = RSInterface.interfaceCache[interfaceId];
        if (rsi.children != null) {
            for (int index = 0; index < rsi.children.length; index++) {
                handleMainInterfaceScrolling(rsi.children[index], offsetX + rsi.childX[index], offsetY + rsi.childY[index], rotation);
                if (RSInterface.interfaceCache[rsi.children[index]].scrollMax <= 0) {
                    continue;
                }
                if (mouseX > offsetX + rsi.childX[index] && MouseHandler.mouseY > offsetY + rsi.childY[index]
                        && mouseX < offsetX + rsi.childX[index] + RSInterface.interfaceCache[rsi.children[index]].width + 16
                        && MouseHandler.mouseY < offsetY + rsi.childY[index]
                        + RSInterface.interfaceCache[rsi.children[index]].height) {

                    RSInterface rsInterface = RSInterface.interfaceCache[rsi.children[index]];
                    rsInterface.scrollPosition += rotation * 30;
                    if (rsInterface.scrollPosition < 0)
                        rsInterface.scrollPosition = 0;
                    if (rsInterface.scrollPosition > rsInterface.scrollMax - rsInterface.height)
                        rsInterface.scrollPosition = rsInterface.scrollMax - rsInterface.height;
                    return true;
                }
            }
        }

        return false;
    }

}
