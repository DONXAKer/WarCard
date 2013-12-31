package com.mafia.warcard.Screens;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.mafia.warcard.BaseClass.Screen;
import com.mafia.warcard.Const;

import static com.mafia.warcard.StaticMethods.GetPoint2Texture;

/**
 * Created by DON on 18.12.13.
 */
public class Menu extends Screen {

    Texture t_Settings;
    Texture t_Exit;
    Texture t_ListGame;
    Texture t_BackGround;

    public Menu(Camera camera) {
        t_Settings = new Texture(GetPoint2Texture("exit.png"));
        t_Exit = new Texture(GetPoint2Texture("exit.png"));
        t_ListGame = new Texture(GetPoint2Texture("exit.png"));
        t_BackGround = new Texture(GetPoint2Texture("exit.png"));

        setBG(Const.ImageName.MenuScreenBG, camera);
    }


}
