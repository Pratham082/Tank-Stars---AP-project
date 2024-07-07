package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertNotSame;

public class TitleScreen extends ScreenAdapter {
    private TankWars game;
    private Texture texture;
    private Sprite sprite;
    private SpriteBatch batch;
    public TankWars getGame() {
        return game;
    }

    public void setGame(TankWars game) {
        this.game = game;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public TitleScreen(TankWars game) {
        this.game = game;
    }

    @Test(timeOut = 500)
    void test_func(){
        Integer a = 5;
        Double b = Double.valueOf(10);
        assertNotSame(a,b);
        System.out.println("Testing Complete");
    }

    @Override
    public void show(){
        batch = new SpriteBatch();
        texture = new Texture(Gdx.files.internal("firstImage.jpg"));
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear); //For prevention of pixel scattering
        sprite = new Sprite(texture,0,0,1200,600);
        sprite.setPosition(0,0);
        sprite.setSize(1280,720);
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                game.setScreen(new MenuScreen(game));
            }
        }, 0.5f);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        sprite.draw(batch);
        batch.end();

    }

    @Override
    public void hide(){
        Gdx.input.setInputProcessor(null);
    }
}
