package org.scoula.lib.cli.ui;

import org.scoula.lib.cli.command.Command;

public class MenuItem {
    String title; // 메뉴 문자열
    Command command; // 메뉴 명령

    public MenuItem(String title, Command command) {
        this.title = title;
        this.command = command;
    }

    public String getTitle() {
        return title;
    }

    public Command getCommand() {
        return command;
    }
}
