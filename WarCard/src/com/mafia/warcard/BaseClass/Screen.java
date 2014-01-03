package com.mafia.warcard.BaseClass;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mafia.warcard.Const;

/*
Class describe base structure of screen
 */
public class Screen implements InputProcessor {

    public static Integer ADSCREEN = 0;
    public static Integer MAINMENU = 1;
    public static Integer FINDGAME = 2;
    private Texture BG;
    private Sprite spriteBG;

    protected Stage stage;

    // устанавливаем фон для экрана
    public void setBG(Const.ImageName BG) {
        this.BG = Const.CollectionTexture.get(BG);
        //spriteBG = new Sprite(this.BG);
        //spriteBG.setSize(10,10);//camera.viewportWidth, camera.viewportHeight);
    }

    // show current screen
    public void show(SpriteBatch batch) {
        if (BG != null) {
            batch.draw(BG, 0, 0);
        }
        if (stage != null) {
            stage.act(Gdx.graphics.getDeltaTime());
            stage.draw();
        }

    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}