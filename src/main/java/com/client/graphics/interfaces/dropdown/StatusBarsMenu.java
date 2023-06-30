package com.client.graphics.interfaces.dropdown;

import com.client.Configuration;
import com.client.graphics.interfaces.MenuItem;
import com.client.graphics.interfaces.RSInterface;

public class StatusBarsMenu implements MenuItem {
    @Override
    public void select(int optionSelected, RSInterface rsInterface) {
        switch (optionSelected) {
            case 0:
                Configuration.statusBars = true;
                break;
            case 1:
                Configuration.statusBars = false;
                break;
        }

    }
}
