package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SavingScreen extends ScreenAdapter {
    private TankWars game;
    private TextButton Button1;
    private TextButton Button2;
    private TextButton Button3;
    private TextButton backButton;
    private Table table;
    private Stage stage;
    private Skin buttonSkin;
    private Texture menuTexture;
    private BitmapFont font;
    private SpriteBatch batch;

    public TankWars getGame() {
        return game;
    }

    public void setGame(TankWars game) {
        this.game = game;
    }

    public TextButton getButton1() {
        return Button1;
    }

    public void setButton1(TextButton button1) {
        Button1 = button1;
    }

    public TextButton getButton2() {
        return Button2;
    }

    public void setButton2(TextButton button2) {
        Button2 = button2;
    }

    public TextButton getButton3() {
        return Button3;
    }

    public void setButton3(TextButton button3) {
        Button3 = button3;
    }

    public TextButton getBackButton() {
        return backButton;
    }

    public void setBackButton(TextButton backButton) {
        this.backButton = backButton;
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

    public SavingScreen(TankWars game) {
        this.game = game;
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
        Label label = new Label("Slot Options", new Label.LabelStyle(font, Color.ORANGE));
        buttonSkin = new Skin(Gdx.files.internal("orange/skin/uiskin.json"));
        backButton = new TextButton("Back",buttonSkin);
        backButton.setSize(100,50);
        backButton.setPosition(100,620);

        Button1 = new TextButton("Slot 1",buttonSkin);
        Button1.setSize(100,100);
        Button2 = new TextButton("Slot 2",buttonSkin);
        Button2.setSize(100,100);
        Button3 = new TextButton("Slot 3",buttonSkin);
        Button3.setSize(100,100);
        table.add(label);
        table.row();
        table.add(Button1).height(50).width(200).padTop(100);
        table.row();
        table.add(Button2).height(50).width(200).pad(50);
        table.row();
        table.add(Button3).height(50).width(200);

        stage.addActor(table);
        stage.addActor(backButton);

        backButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new OptionScreen(game));
            }
        });
        Button1.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                ObjectOutputStream out = null;
                try {
                    out = new ObjectOutputStream(new FileOutputStream("out1.txt"));
                    out.writeObject(game);
                    out.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                game.setScreen(new MenuScreen(game));
            }
        });
        Button2.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                ObjectOutputStream out = null;
                try {
                    out = new ObjectOutputStream(new FileOutputStream("out2.txt"));
                    out.writeObject(game);
                    out.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                game.setScreen(new MenuScreen(game));
            }
        });
        Button3.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                ObjectOutputStream out = null;
                try {
                    out = new ObjectOutputStream(new FileOutputStream("out3.txt"));
                    out.writeObject(game);
                    out.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                game.setScreen(new MenuScreen(game));
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
