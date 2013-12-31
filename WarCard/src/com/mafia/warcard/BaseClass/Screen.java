package com.mafia.warcard.BaseClass;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mafia.warcard.Const;

/*
Class describe base structure of screen
 */
public class Screen {

    public static Integer ADSCREEN = 0;
    public static Integer MAINMENU = 1;
    public static Integer FINDGAME = 2;
    private Texture BG;
    private Sprite spriteBG;

    // create background for screen
    public void setBG(Const.ImageName BG, Camera camera) {
        this.BG = Const.CollectionTexture.get(BG);
        spriteBG = new Sprite(this.BG);
        //spriteBG.setSize(10,10);//camera.viewportWidth, camera.viewportHeight);
    }

    // show current screen
    public void show(SpriteBatch batch) {
        spriteBG.draw(batch);

    }

}