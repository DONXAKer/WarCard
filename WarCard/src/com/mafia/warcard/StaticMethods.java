package com.mafia.warcard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class StaticMethods {

    /* return FileHandle to file on assets
      path - path to file on assets
     */
    public static FileHandle GetPoint2Texture(String path) {
        return Gdx.files.internal("img\\" + path);
    }
}
