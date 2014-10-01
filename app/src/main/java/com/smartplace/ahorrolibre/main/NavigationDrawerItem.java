package com.smartplace.ahorrolibre.main;

import android.graphics.drawable.Drawable;

/**
 * Created by Roberto on 23/07/2014.
 */
public class NavigationDrawerItem {
    private Drawable icon;
    private String name;

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
