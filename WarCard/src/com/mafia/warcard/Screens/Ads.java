package com.mafia.warcard.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mafia.warcard.BaseClass.Screen;
import com.mafia.warcard.Const;
import com.mafia.warcard.MainClass;

public class Ads extends Screen {

    public Ads(OrthographicCamera camera) {

        stage = new Stage();
        Gdx.input.setInputProcessor(this);

        // загружаем картинку с логотипом
        Image splashImage = new Image(Const.CollectionTexture.get(Const.ImageName.AdsScreenBG));
        // последовательно играемся с картинкой. Быстро ее убираем,плавное появление картинки и ожидание нескольких секунд
        splashImage.addAction(Actions.sequence(Actions.fadeOut(0.01f), Actions.fadeIn(2f),
                Actions.delay(3f, Actions.run(onSplashFinishedRunnable))));

        stage.addActor(splashImage);
        //setBG(Const.ImageName.AdsScreenBG);
    }

    Runnable onSplashFinishedRunnable = new Runnable() {
        @Override
        public void run() {
            // после ожидания активируем экран с меню
            MainClass.i_CurrentScreen = Screen.MAINMENU;
        }
    };

    @Override
    public void show(SpriteBatch batch) {
        super.show(batch);
    }
}
