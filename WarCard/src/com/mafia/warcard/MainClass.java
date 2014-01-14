package com.mafia.warcard;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mafia.warcard.BaseClass.Screen;
import com.mafia.warcard.Screens.Ads;
import com.mafia.warcard.Screens.Game;
import com.mafia.warcard.Screens.Menu;
import com.shephertz.app42.paas.sdk.java.ServiceAPI;

import java.util.HashMap;

import static com.mafia.warcard.Const.*;
import static com.mafia.warcard.StaticMethods.GetPoint2Texture;

public class MainClass implements ApplicationListener {
    HashMap<Integer, Screen> screens = new HashMap<Integer, Screen>();
    private OrthographicCamera camera;
    private SpriteBatch batch;
    public static int i_CurrentScreen = Screen.ADSCREEN;
    public static boolean i_FirstTimeLoad = true;

    @Override
    public void create() {
        // get width and height from device
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        SetScreenSize();

        // orthographic camera - main view
        camera = new OrthographicCamera(1, h / w);
        batch = new SpriteBatch();

        // для начала загрузим все по заставки, а затем будем грузить все остальное
        Const.CollectionTexture.put(Const.ImageName.AdsScreenBG, new Texture(GetPoint2Texture("AdsScreenBG.png")));
        screens.put(Screen.ADSCREEN, new Ads(camera));


        //sprite = new Sprite(texture);
        //sprite.setSize(1, 1 * sprite.getHeight() / sprite.getWidth());
        //sprite.setOrigin(sprite.getWidth() / 2, sprite.getHeight() / 2);
        //sprite.setPosition(-sprite.getWidth() / 2, -sprite.getHeight() / 2);

        // analyze multuplayer system
        serviceAPI = new ServiceAPI("f1ceac97fa399c44d6c44ee915dc15b3b593a5f8df94aa5b07283b5ab99041ca", "ac2676c71819b5c3b1532db6f2ae568dd365ebb20c2440944dd23334c4e3f0b0");

    }

    @Override
    public void dispose() {
        batch.dispose();
        DisposeCollectionTexture();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        //batch.setProjectionMatrix(camera.projection);
        batch.begin();
        //sprite.draw(batch);
        screens.get(i_CurrentScreen).show(batch);
        batch.end();

        // проверяем, что это первый запуск игры и загружаем текстуры
        if (i_FirstTimeLoad) {
            // заполняем коллекцию с текстурами
            FillCollectionTexture();
            LoadFirstTime();
            i_FirstTimeLoad = false;
        }
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    // процедура загрузки данных при запуске игры
    private void LoadFirstTime() {
        // добавляем все экраны в HashMap, для быстрого выбора
        screens.put(Screen.MAINMENU, new Menu());
        screens.put(Screen.GAME, new Game());


        // после загрузки текстур говорим рендеру, что надо переключиться на экран с меню.
        //i_CurrentScreen = Screen.MAINMENU;
    }
}
