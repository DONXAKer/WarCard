package com.mafia.warcard;

import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;
import java.util.Map;

import static com.mafia.warcard.StaticMethods.GetPoint2Texture;

public class Const {
    public static enum TypeUnit {
        AIR, EARTH;
    }

    public static enum ImageName {
        MenuScreenBG, FindGameScreenBG

    }

    public static Map<ImageName, Texture> CollectionTexture = new HashMap<ImageName, Texture>();

    public static void FillCollectionTexture() {
        CollectionTexture.put(ImageName.MenuScreenBG, new Texture(GetPoint2Texture("exit.png")));
        CollectionTexture.put(ImageName.FindGameScreenBG, new Texture(GetPoint2Texture("libgdx.png")));
    }
}
