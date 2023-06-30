package com.client.graphics.interfaces.impl;

import com.client.Client;
import com.client.Sprite;
import com.client.TextDrawingArea;
import com.client.graphics.interfaces.Configs;
import com.client.graphics.interfaces.RSInterface;

import java.awt.*;
import java.text.NumberFormat;

public class Nex extends RSInterface {

    public static final Nex instance = new Nex();

    private static final String SPRITE_FOLDER = "/Interfaces/nex/";
    private static final Sprite NEX_HEALTH_BACKGROUND = new Sprite(SPRITE_FOLDER + "0");

    private static final int HEALTH_REMAINING_COLOUR = 0x00C800;
    private static final int HEALTH_BACKGROUND_COLOUR = 0xC80000;

    public static final int NEX_HEALTH_INTERFACE_ID = 57302;//47302

    private static final Point NEX_HEALTH_SIZE = new Point(190, 17);

    private int healthFillBackgroundId;
    private int healthFillId;
    private int nexHealthTextId;

    private int nexHealth = 3400;
    private int nexMaxHealth = 3400;
    private boolean nexOnHealth = false;

    private Nex() {}

    public void load(TextDrawingArea[] tda) {
        nexHealth(tda);
    }

    private void nexHealth(TextDrawingArea[] tda) {
        int id = NEX_HEALTH_INTERFACE_ID;
        int child = 0;
        RSInterface inter = addInterface(id++);
        inter.totalChildren(4);

        int x = 162;
        int y = 28;

        addSprite(id, NEX_HEALTH_BACKGROUND);
        inter.child(child++, id++, x, y);

        healthFillBackgroundId = id;
        inter.child(child++, id++, x + 4, y + 19);

        healthFillId = id;
        inter.child(child++, id++, x + 4, y + 19);

        nexHealthTextId = id;
        inter.child(child++, id++, x + 98, y + 22);

        buildNexHealthInter();
    }

    private void buildNexHealthInter() {
        double percentage = (double) nexHealth / (double) nexMaxHealth;
      //  addProgressBarReal(healthFillBackgroundId, NEX_HEALTH_SIZE.x, NEX_HEALTH_SIZE.y, !nexOnHealth ? SHIELD_BACKGROUND_COLOUR : HEALTH_BACKGROUND_COLOUR);
       // addProgressBarReal(healthFillId, (int) (NEX_HEALTH_SIZE.x * percentage), NEX_HEALTH_SIZE.y, !nexOnHealth ? SHIELD_REMAINING_COLOUR : HEALTH_REMAINING_COLOUR);

        addProgressBarReal(healthFillBackgroundId, NEX_HEALTH_SIZE.x, NEX_HEALTH_SIZE.y, HEALTH_BACKGROUND_COLOUR);
        addProgressBarReal(healthFillId, (int) (NEX_HEALTH_SIZE.x * percentage), NEX_HEALTH_SIZE.y, HEALTH_REMAINING_COLOUR);

        NumberFormat myFormat = NumberFormat.getInstance();
        myFormat.setGroupingUsed(true);
        addText(nexHealthTextId, myFormat.format(nexHealth) + " / " + myFormat.format(nexMaxHealth), Interfaces.defaultTextDrawingAreas, 0, 0xFFFFFFFF, true);
    }



    public boolean drawNexInterfaces(int interfaceId) {
        if (interfaceId == NEX_HEALTH_INTERFACE_ID) {
            int x = 0;
            int y = 0;
            if (!Client.instance.isResized()) {
                x = Client.canvasWidth / 2 - 261;
            }

            // draw nightmare health
            Client.instance.drawInterface(0, x, RSInterface.get(NEX_HEALTH_INTERFACE_ID), y);
            return true;
        } else {
            return false;
        }
    }

    public void handleConfig(int configId, int configValue) {
        switch (configId) {
            case Configs.NEX_HEALTH_AMOUNT:
                nexHealth = configValue;
                break;
            case Configs.NEX_MAX_HEALTH_AMOUNT:
                nexMaxHealth = configValue;
                break;
            case Configs.NEX_HEALTH_STATUS:
                nexOnHealth = configValue == 1;
                buildNexHealthInter();
                break;

        }
    }

}
