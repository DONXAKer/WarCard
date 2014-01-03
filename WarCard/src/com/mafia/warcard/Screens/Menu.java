package com.mafia.warcard.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mafia.warcard.BaseClass.Screen;
import com.mafia.warcard.Const;
import com.mafia.warcard.MainClass;

import static com.mafia.warcard.Const.CollectionTexture;

public class Menu extends Screen {

    TextButton btnPlay;
    TextButton btnSettings;
    TextButton btnExit;

    TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();

    public Menu() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        style.up = new TextureRegionDrawable(new TextureRegion(CollectionTexture.get(Const.ImageName.Skin)));
        style.font = new BitmapFont();

        Table table = new Table();

        btnPlay = new TextButton("Новая Game", style);
        btnSettings = new TextButton("Настройки", style);
        btnExit = new TextButton("Выход", style);


        btnPlay.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y,
                                     int pointer, int button) {
                MainClass.i_CurrentScreen = Screen.ADSCREEN;
                return true;
            }

        });

        btnExit.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.exit();
                return true;
            }
        });

        table.setFillParent(true);
//                table.debug();
        table.add(btnPlay).width(150).height(50);
        table.row();
        table.add(btnSettings).width(150).height(50).padTop(10);
        table.row();
        table.add(btnExit).width(150).height(50).padTop(10);

        Image splashImage = new Image(Const.CollectionTexture.get(Const.ImageName.MenuScreenBG));
        stage.addActor(splashImage);
        stage.addActor(table);

        //setBG(Const.ImageName.MenuScreenBG);
    }

    @Override
    public void show(SpriteBatch batch) {
        super.show(batch);

        //batch.draw(Const.CollectionTexture.get(Const.ImageName.Button_Play),150, 300);
        //batch.draw(Const.CollectionTexture.get(Const.ImageName.Button_Settings),150, 200);
        //batch.draw(Const.CollectionTexture.get(Const.ImageName.Button_Exit),150, 100);
    }
}
