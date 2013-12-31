package com.mafia.warcard;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mafia.warcard.BaseClass.Screen;
import com.mafia.warcard.Screens.Menu;

import java.util.HashMap;

import static com.mafia.warcard.Const.FillCollectionTexture;

public class MainClass implements ApplicationListener {
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Texture texture;
    private Sprite sprite;

    private int i_CurrentScreen = 1;

    HashMap<Integer, Menu> screens = new HashMap<Integer, Menu>();

    @Override
    public void create() {
        // get width and height from device
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        // orthographic camera - main view
        camera = new OrthographicCamera(1, h / w);
        batch = new SpriteBatch();

        // fill collection with all img
        FillCollectionTexture();

        // add screens to hashmap
        screens.put(Screen.MAINMENU, new Menu(camera));


        //texture = new Texture(Gdx.files.internal("img\\libgdx.png"));


        //sprite = new Sprite(texture);
        //sprite.setSize(1, 1 * sprite.getHeight() / sprite.getWidth());
        //sprite.setOrigin(sprite.getWidth() / 2, sprite.getHeight() / 2);
        //sprite.setPosition(-sprite.getWidth() / 2, -sprite.getHeight() / 2);

        // analyze multuplayer system
        //ServiceAPI serviceAPI = new ServiceAPI("f1ceac97fa399c44d6c44ee915dc15b3b593a5f8df94aa5b07283b5ab99041ca", "ac2676c71819b5c3b1532db6f2ae568dd365ebb20c2440944dd23334c4e3f0b0");

    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    Texture tex;

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        //batch.setProjectionMatrix(camera.projection);
        batch.begin();
        //sprite.draw(batch);
        screens.get(i_CurrentScreen).show(batch);
        batch.end();
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
}
