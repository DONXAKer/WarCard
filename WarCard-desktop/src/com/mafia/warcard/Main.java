package com.mafia.warcard;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
    public static void main(String[] args) {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "WarCard";
        cfg.useGL20 = true;
        cfg.width = Const.ScreenWidth;
        cfg.height = Const.ScreenHeight;

        new LwjglApplication(new MainClass(), cfg);
    }
}
