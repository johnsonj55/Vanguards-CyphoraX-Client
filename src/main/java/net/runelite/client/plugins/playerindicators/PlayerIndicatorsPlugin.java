/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.playerindicators;

import com.google.inject.Provides;
import lombok.Value;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.Player;
import net.runelite.api.events.ClientTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ColorUtil;

import javax.inject.Inject;
import java.awt.*;

import static net.runelite.api.MenuAction.*;

@PluginDescriptor(
	name = "Player Indicators",
	description = "Highlight players on-screen and/or on the minimap",
	tags = {"highlight", "minimap", "overlay", "players"}
)
public class PlayerIndicatorsPlugin extends Plugin
{
	@Inject
	private OverlayManager overlayManager;

	@Inject
	private PlayerIndicatorsConfig config;

	@Inject
	private PlayerIndicatorsOverlay playerIndicatorsOverlay;

	@Inject
	private PlayerIndicatorsTileOverlay playerIndicatorsTileOverlay;

	@Inject
	private PlayerIndicatorsMinimapOverlay playerIndicatorsMinimapOverlay;

	@Inject
	private PlayerIndicatorsService playerIndicatorsService;

	@Inject
	private Client client;


	@Provides
	PlayerIndicatorsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PlayerIndicatorsConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(playerIndicatorsOverlay);
		overlayManager.add(playerIndicatorsTileOverlay);
		overlayManager.add(playerIndicatorsMinimapOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(playerIndicatorsOverlay);
		overlayManager.remove(playerIndicatorsTileOverlay);
		overlayManager.remove(playerIndicatorsMinimapOverlay);
	}

	@Subscribe
	public void onClientTick(ClientTick clientTick)
	{
		if (client.isMenuOpen())
		{
			return;
		}

		
	}

	private Decorations getDecorations(Player player) {
		int image = -1;
		Color color = null;

		/*if (config.showPlayerRanks() && com.runescape.Client.instance.getCrown(player) != null) {
			image = com.runescape.Client.instance.getCrown(player).getSpriteId();
		}*/

		if (player.isFriend() && config.highlightFriends())
		{
			color = config.getFriendColor();
		}
		else if (player.getTeam() > 0 && client.getLocalPlayer().getTeam() == player.getTeam() && config.highlightTeamMembers())
		{
			color = config.getTeamMemberColor();
		}

		else if (!player.isFriendsChatMember() && !player.isClanMember() && config.highlightOthers())
		{
			color = config.getOthersColor();
		}

		if (image == -1 && color == null)
		{
			return null;
		}

		return new Decorations(image, color);
	}

	private String decorateTarget(String oldTarget, Decorations decorations)
	{
		String newTarget = oldTarget;

		if (decorations.getColor() != null && config.colorPlayerMenu())
		{
			// strip out existing <col...
			int idx = oldTarget.indexOf('>');
			if (idx != -1)
			{
				newTarget = oldTarget.substring(idx + 1);
			}

			newTarget = ColorUtil.prependColorTag(newTarget, decorations.getColor());
		}

		if (decorations.getImage() != -1)
		{
			newTarget = "<img=" + decorations.getImage() + ">" + newTarget;
		}

		return newTarget;
	}

	@Value
	private static class Decorations
	{
		private final int image;
		private final Color color;
	}
}
