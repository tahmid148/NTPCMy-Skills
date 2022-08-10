package com.ntpc.myskills.ui.dashboard;

public class MenuModel {

    public String Listname;
    public boolean hasChildren, isGroup;

    public MenuModel(String listname, boolean hasChildren, boolean isGroup) {
        Listname = listname;
        this.hasChildren = hasChildren;
        this.isGroup = isGroup;
    }
}
