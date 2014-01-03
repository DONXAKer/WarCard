package com.mafia.warcard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;
import java.util.Map;

import static com.mafia.warcard.StaticMethods.GetPoint2Texture;

public class Const {
    public static Map<ImageName, Texture> CollectionTexture = new HashMap<ImageName, Texture>();
    //Размеры экрана
    public static int ScreenWidth = 800;
    public static int ScreenHeight = 480;

    // метод загрузки текстур в GPU
    public static void FillCollectionTexture() {
        // загрузка текстур и помещение их в коллекцию.
        // фоновое изображение
        CollectionTexture.put(ImageName.MenuScreenBG, new Texture(GetPoint2Texture("MenuScreenBG.png")));

        // кнопки
        CollectionTexture.put(ImageName.Button_Exit, new Texture(GetPoint2Texture("buttons/Exit.png")));
        CollectionTexture.put(ImageName.Button_Exit_Down, new Texture(GetPoint2Texture("buttons/Exit_Down.png")));
        CollectionTexture.put(ImageName.Button_Play, new Texture(GetPoint2Texture("buttons/Play.png")));
        CollectionTexture.put(ImageName.Button_Play_Down, new Texture(GetPoint2Texture("buttons/Play_Down.png")));
        CollectionTexture.put(ImageName.Button_Settings, new Texture(GetPoint2Texture("buttons/Settings.png")));
        CollectionTexture.put(ImageName.Button_Settings_Down, new Texture(GetPoint2Texture("buttons/Settings_Down.png")));
        CollectionTexture.put(ImageName.Skin, new Texture(GetPoint2Texture("buttons/Skin.png")));
    }

    // процедура очистки коллекции
    public static void DisposeCollectionTexture() {
        for (Map.Entry<ImageName, Texture> entry : CollectionTexture.entrySet()) {
            CollectionTexture.get(entry.getKey()).dispose();
        }
        CollectionTexture = null;
    }

    // функция пересчета координаты y от левого верхнего угла
    public static int CoordinateFromLeftTopCorner(int Y) {
        return ScreenHeight - Y;
    }

    // инициализация размера экрана
    public static void SetScreenSize() {
        ScreenWidth = Gdx.graphics.getWidth();
        ScreenHeight = Gdx.graphics.getHeight();
    }

    public static enum TypeUnit {
        AIR, EARTH
    }

    public static enum ImageName {
        MenuScreenBG, Button_Exit, Button_Exit_Down, Button_Play, Button_Play_Down, Button_Settings, Button_Settings_Down, AdsScreenBG, Skin, FindGameScreenBG

    }
}
