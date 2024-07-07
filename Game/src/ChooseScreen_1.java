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
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class ChooseScreen_1 extends ScreenAdapter {
    private TankWars game;
    private Label label;
    private Label label2;
    private TextButton backButton;
    private Table table;
    private Stage stage;
    private Skin buttonSkin;
    private Texture menuTexture;
    private ImageButton tank1;
    private ImageButton tank2;
    private ImageButton tank3;
    private TextField textField;
    private String inputText;
    private BitmapFont font;
    private SpriteBatch batch;

    public TankWars getGame() {
        return game;
    }

    public void setGame(TankWars game) {
        this.game = game;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public Label getLabel2() {
        return label2;
    }

    public void setLabel2(Label label2) {
        this.label2 = label2;
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

    public ImageButton getTank1() {
        return tank1;
    }

    public void setTank1(ImageButton tank1) {
        this.tank1 = tank1;
    }

    public ImageButton getTank2() {
        return tank2;
    }

    public void setTank2(ImageButton tank2) {
        this.tank2 = tank2;
    }

    public ImageButton getTank3() {
        return tank3;
    }

    public void setTank3(ImageButton tank3) {
        this.tank3 = tank3;
    }

    public TextField getTextField() {
        return textField;
    }

    public void setTextField(TextField textField) {
        this.textField = textField;
    }

    public String getInputText() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }

    public ChooseScreen_1(TankWars game) {
        this.game = game;
    }

    @Override
    public void show() {

//        stage = new Stage(new ScreenViewport());
        stage = new Stage(new StretchViewport(1280,720));
        font = new BitmapFont(Gdx.files.internal("font-title-export.fnt"));
        batch = new SpriteBatch();

        Gdx.input.setInputProcessor(stage);

        table = new Table();
        table.setFillParent(true);
        menuTexture = new Texture(Gdx.files.internal("menuImage.png"));
        menuTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear); //For prevention of pixel scattering
        table.setBackground(new TextureRegionDrawable(new TextureRegion(menuTexture)));

        buttonSkin = new Skin(Gdx.files.internal("orange/skin/uiskin.json"));
        font.getData().setScale(1);

        label = new Label("Enter Player1 Name: ", new Label.LabelStyle(font, Color.ORANGE));
        label.setPosition(100,425);
        label2 = new Label("Choose Your Tank", new Label.LabelStyle(font, Color.ORANGE));
        label2.setPosition(510,570);

        textField = new TextField("", buttonSkin);
        textField.setSize(300,35);
        textField.setPosition(425,425);

        backButton = new TextButton("Back", buttonSkin);
        backButton.setSize(100,50);
        backButton.setPosition(100,570);
        tank1 = new ImageButton(new TextureRegionDrawable(new Texture("Tank1.png")),new TextureRegionDrawable(new Texture("Tank1_Dark.png")));
        tank1.setPosition(0,-50);
        tank2 = new ImageButton(new TextureRegionDrawable(new Texture("Tank2.png")),new TextureRegionDrawable(new Texture("Tank2_Dark.png")));
        tank2.setPosition(400,-50);
        tank3 = new ImageButton(new TextureRegionDrawable(new Texture("Tank3.png")),new TextureRegionDrawable(new Texture("Tank3_Dark.png")));
        tank3.setPosition(800,-50);

        stage.addActor(table);
        stage.addActor(tank1);
        stage.addActor(tank2);
        stage.addActor(tank3);
        stage.addActor(label);
        stage.addActor(textField);
        stage.addActor(label2);
        stage.addActor(backButton);

        textField.setOnscreenKeyboard(new TextField.OnscreenKeyboard() {
            @Override
            public void show(boolean visible) {
                Gdx.input.setOnscreenKeyboardVisible(visible);
            }
        });

        backButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new MenuScreen(game));
            }
        });
        tank1.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                game.tankChosen1 = 1;
                inputText = textField.getText();
                if(inputText.equals("")){
                    game.player1Name = "Player 1";
                }
                else{
                    game.player1Name = inputText;
                }
                game.setScreen(new ChooseScreen_2(game));
            }
        });
        tank2.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                game.tankChosen1 = 2;
                inputText = textField.getText();
                if(inputText.equals("")){
                    game.player1Name = "Player 1";
                }
                else{
                    game.player1Name = inputText;
                }
                game.setScreen(new ChooseScreen_2(game));
            }
        });
        tank3.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                game.tankChosen1 = 3;
                inputText = textField.getText();
                if(inputText.equals("")){
                    game.player1Name = "Player 1";
                }
                else{
                    game.player1Name = inputText;
                }
                game.setScreen(new ChooseScreen_2(game));
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
