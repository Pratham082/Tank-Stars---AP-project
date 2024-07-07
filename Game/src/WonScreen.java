package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class WonScreen extends ScreenAdapter {
    private TankWars game;
    private Table table;
    private Stage stage;
    private Skin buttonSkin;
    private Texture menuTexture;
    private BitmapFont font;
    private SpriteBatch batch;
    int num;

    public TankWars getGame() {
        return game;
    }

    public void setGame(TankWars game) {
        this.game = game;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Skin getButtonSkin() {
        return buttonSkin;
    }

    public void setButtonSkin(Skin buttonSkin) {
        this.buttonSkin = buttonSkin;
    }

    public Texture getMenuTexture() {
        return menuTexture;
    }

    public void setMenuTexture(Texture menuTexture) {
        this.menuTexture = menuTexture;
    }

    public WonScreen(TankWars game, int num) {
        this.game = game;
        this.num = num;
    }

    @Override
    public void show() {

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        font = new BitmapFont(Gdx.files.internal("font-title-export.fnt"));
        batch = new SpriteBatch();

        table = new Table();
        table.setFillParent(true);
        menuTexture = new Texture(Gdx.files.internal("menuImage.png"));
        menuTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear); //For prevention of pixel scattering
        table.setBackground(new TextureRegionDrawable(new TextureRegion(menuTexture)));

        font.getData().setScale(1);
        Label label = new Label("Game Won By: "+num, new Label.LabelStyle(font, Color.ORANGE));
        Label label2 = new Label("Redirecting to MenuScreen", new Label.LabelStyle(font, Color.ORANGE));
        table.add(label);
        table.add(label2);
        stage.addActor(table);
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                game.setScreen(new MenuScreen(game));
            }
        }, 3);
    }

    public void resize(int width, int height) {
        stage.getViewport().update(width,height,true);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(138/407f, 43/407f, 226/407f, 1);
        batch.begin();
        stage.draw();
        batch.end();
    }

    @Override
    public void hide(){
        Gdx.input.setInputProcessor(null);
    }

}
