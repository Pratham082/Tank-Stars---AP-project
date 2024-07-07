package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MenuScreen extends ScreenAdapter {
    private TankWars game;
    private TextButton startGame;
    private TextButton resumeGame;
    private TextButton endGame;
    private Table table;
    private Stage stage;
    private Skin buttonSkin;
    private Texture menuTexture;
    private Texture logoTexture;
    private SpriteBatch batch;

    public TankWars getGame() {
        return game;
    }

    public void setGame(TankWars game) {
        this.game = game;
    }

    public TextButton getStartGame() {
        return startGame;
    }

    public void setStartGame(TextButton startGame) {
        this.startGame = startGame;
    }

    public TextButton getResumeGame() {
        return resumeGame;
    }

    public void setResumeGame(TextButton resumeGame) {
        this.resumeGame = resumeGame;
    }

    public TextButton getEndGame() {
        return endGame;
    }

    public void setEndGame(TextButton endGame) {
        this.endGame = endGame;
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

    public Texture getLogoTexture() {
        return logoTexture;
    }

    public void setLogoTexture(Texture logoTexture) {
        this.logoTexture = logoTexture;
    }

    public MenuScreen(TankWars game) {
        this.game = game;
    }

    @Override
    public void show() {

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        batch = new SpriteBatch();

        table = new Table();
        table.setFillParent(true);
        menuTexture = new Texture(Gdx.files.internal("menuImage.png"));
        menuTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear); //For prevention of pixel scattering
        table.setBackground(new TextureRegionDrawable(new TextureRegion(menuTexture)));

//Check For un-necessary setting of size
        buttonSkin = new Skin(Gdx.files.internal("orange/skin/uiskin.json"));
        startGame = new TextButton("Start Game",buttonSkin);
        startGame.setSize(100,100);
        resumeGame = new TextButton("Resume Game",buttonSkin);
        resumeGame.setSize(100,100);
        endGame = new TextButton("End Game",buttonSkin);
        endGame.setSize(100,100);

        table.add();
        logoTexture = new Texture(Gdx.files.internal("logo.png"));
        logoTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        table.add(new Image(logoTexture));
        table.row();
        table.add(startGame).height(50).width(200);
        table.add(resumeGame).pad(100).height(50).width(200);
        table.add(endGame).height(50).width(200);
        stage.addActor(table);
        startGame.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new ChooseScreen_1(game));
            }
        });
        resumeGame.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen((Screen) new ResumeScreen(game));
            }
        });
        endGame.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new EndScreen(game));
            }
        });
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
