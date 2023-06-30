package com.client.engine.impl;

import com.client.Client;
import com.client.features.KeyboardAction;
import com.client.graphics.interfaces.impl.Keybinding;
import net.runelite.api.KeyCode;
import net.runelite.api.events.FocusChanged;
import net.runelite.rs.api.RSKeyHandler;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class KeyHandler implements KeyListener, FocusListener, RSKeyHandler {

    public static KeyHandler instance;

    static  {
        instance = new KeyHandler();
    }

    public static final int[] keyArray = new int[128];
    private final int[] charQueue = new int[128];
    private int readIndex;
    private int writeIndex;
    int keyPressed = 0;
    public static volatile int idleCycles = 0;

    @Override
    public void focusGained(FocusEvent e) {}

    @Override
    public void focusLost(FocusEvent e) {
        final FocusChanged focusChanged = new FocusChanged();
        focusChanged.setFocused(false);
        Client.instance.getCallbacks().post(focusChanged);

        for (int i = 0; i < 128; i++) {
            keyArray[i] = 0;
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        Client.instance.getCallbacks().keyTyped(keyEvent);
        if (!keyEvent.isConsumed())
        {

        }
    }

    @Override
    public void keyPressed(KeyEvent event) {
        idleCycles = 0;

        Client.instance.getCallbacks().keyPressed(event);
        if (!event.isConsumed())
        {
            System.out.println(event.getKeyCode());
            int i = event.getKeyCode();
            if(i == KeyEvent.VK_SHIFT) {
                keyPressed = KeyCode.KC_SHIFT;
            } else {
                keyPressed = i;
            }
            int keyChar = event.getKeyChar();

            if (event.isShiftDown()) {
                Client.shiftDown = true;
            }
            if (i == KeyEvent.VK_SPACE) {
                if (Client.backDialogID == 979 || Client.backDialogID == 968 || Client.backDialogID == 973
                        || Client.backDialogID == 986 || Client.backDialogID == 306 || Client.backDialogID == 4887
                        || Client.backDialogID == 4893 || Client.backDialogID == 356 || Client.backDialogID == 359
                        || Client.backDialogID == 310 || Client.backDialogID == 4882 || Client.backDialogID == 4900) {
                    Client.stream.createFrame(40);
                    Client.stream.writeWord(4892);
                    // Client.setDialogueOptionsShowing(true);
                }
            }


            if (i == 192 && Client.localPlayer != null && Client.localPlayer.isAdminRights()) {
                Client.instance.devConsole.console_open = !Client.instance.devConsole.console_open;
            }

            if (event.isControlDown()) {
                if (i == KeyEvent.VK_SPACE) {
                    Client.continueDialogue();
                }
                if (i == KeyEvent.VK_1 || i == KeyEvent.VK_NUMPAD1) {
                    Client.dialogueOptions("one");
                }
                if (i == KeyEvent.VK_2 || i == KeyEvent.VK_NUMPAD2) {
                    Client.dialogueOptions("two");
                }
                if (i == KeyEvent.VK_3 || i == KeyEvent.VK_NUMPAD3) {
                    Client.dialogueOptions("three");
                }
                if (i == KeyEvent.VK_4 || i == KeyEvent.VK_NUMPAD4) {
                    Client.dialogueOptions("four");
                }
                if (i == KeyEvent.VK_5 || i == KeyEvent.VK_NUMPAD5) {
                    Client.dialogueOptions("five");
                }
                switch (i) {
                    case KeyEvent.VK_V:
                        Client.inputString += Client.getClipboardContents();
                        Client.inputTaken = true;
                        break;

                    case KeyEvent.VK_T:
                        Client.teleportInterface();
                        break;

                }
            }

            if (i == KeyEvent.VK_F1) {
                Keybinding.isBound(KeyEvent.VK_F1);
            } else if (i == KeyEvent.VK_F2) {
                Keybinding.isBound(KeyEvent.VK_F2);
            } else if (i == KeyEvent.VK_F3) {
                Keybinding.isBound(KeyEvent.VK_F3);
            } else if (i == KeyEvent.VK_F4) {
                Keybinding.isBound(KeyEvent.VK_F4);
            } else if (i == KeyEvent.VK_F5) {
                Keybinding.isBound(KeyEvent.VK_F5);
            } else if (i == KeyEvent.VK_F6) {
                Keybinding.isBound(KeyEvent.VK_F6);
            } else if (i == KeyEvent.VK_F7) {
                Keybinding.isBound(KeyEvent.VK_F7);
            } else if (i == KeyEvent.VK_F8) {
                Keybinding.isBound(KeyEvent.VK_F8);
            } else if (i == KeyEvent.VK_F9) {
                Keybinding.isBound(KeyEvent.VK_F9);
            } else if (i == KeyEvent.VK_F10) {
                Keybinding.isBound(KeyEvent.VK_F10);
            } else if (i == KeyEvent.VK_F11) {
                Keybinding.isBound(KeyEvent.VK_F11);
            } else if (i == KeyEvent.VK_F12) {
                Keybinding.isBound(KeyEvent.VK_F12);
            }

            if (i == KeyEvent.VK_ESCAPE) {
                Keybinding.isBound(KeyEvent.VK_ESCAPE);
                Client.closeInterface();
            }

            if (event.isControlDown()) {
                Client.controlIsDown = true;
            }

            for(KeyboardAction action : KeyboardAction.values()) {
                if (Client.loggedIn) {
                    if (action.canActivate(event.getKeyCode(), event.isControlDown(),
                            event.isShiftDown(), event.isAltDown())) {
                        Client.instance.sendKeyboardAction(action.getAction());
                        break;
                    }
                }
            }


            if (keyChar < 30)
                keyChar = 0;
            if (i == 37)
                keyChar = 1;
            if (i == 39)
                keyChar = 2;
            if (i == 38)
                keyChar = 3;
            if (i == 40)
                keyChar = 4;
            if (i == 17)
                keyChar = 5;
            if (i == 8)
                keyChar = 8;
            if (i == 127)
                keyChar = 8;
            if (i == 9)
                keyChar = 9;
            if (i == 10)
                keyChar = 10;
            if (i >= 112 && i <= 123)
                keyChar = (1008 + i) - 112;
            if (i == 36)
                keyChar = 1000;
            if (i == 35)
                keyChar = 1001;
            if (i == 33)
                keyChar = 1002;
            if (i == 34)
                keyChar = 1003;
            if (keyChar > 0 && keyChar < 128)
                keyArray[keyChar] = 1;
            if (Client.instance.getOculusOrbState() == 0 && keyChar > 4) {
                charQueue[writeIndex] = keyChar;
                writeIndex = writeIndex + 1 & 0x7f;
            }
        }
    }

    public int readChar() {
        int k = -1;
        if (writeIndex != readIndex) {
            k = charQueue[readIndex];
            readIndex = readIndex + 1 & 0x7f;
        }
        return k;
    }


    @Override
    public void keyReleased(KeyEvent event) {
        Client.instance.getCallbacks().keyReleased(event);
        if (!event.isConsumed())
        {
            idleCycles = 0;
            int i = event.getKeyCode();
            char c = event.getKeyChar();

            if (i == KeyEvent.VK_SHIFT) {
                Client.shiftDown = false;
            }
            if (i == KeyEvent.VK_CONTROL) {
                Client.controlIsDown = false;
            }

            if (c < '\036')
                c = '\0';
            if (i == 37)
                c = '\001';
            if (i == 39)
                c = '\002';
            if (i == 38)
                c = '\003';
            if (i == 40)
                c = '\004';
            if (i == 17)
                c = '\005';
            if (i == 8)
                c = '\b';
            if (i == 127)
                c = '\b';
            if (i == 9)
                c = '\t';
            if (i == 10)
                c = '\n';
            if (c > 0 && c < '\200')
                keyArray[c] = 0;
        }

    }

}
