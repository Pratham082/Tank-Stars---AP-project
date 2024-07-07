package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class GameScreen_1 extends ScreenAdapter {
    private TankWars game; Stage stage; Skin buttonSkin;
    private Label player1Name, player2Name, angleCurrent, velocityCurrent;
    private Texture backgroundImage, groundImage, tankImage1, tankImage2, rangeImage, missileImage;
    private Sprite sprite, sprite2, tank1, tank2, range, missile;
    private ProgressBar healthBar1, healthBar2, fuelBar;
    private TextButton backButton, fireButton;
    private int normalizeCOM, normalizeCOM2, initialVelocity = 50, cannonAngle = 45, posCurrentTank, missileVisible=0;
    private float missileX; float missileY;int fuel;
    private BitmapFont font;
    private SpriteBatch batch;
    private Vector2 iv;
    Vector2 gravity;
    float elapsedTime;

    public TankWars getGame() {
        return game;
    }

    public void setGame(TankWars game) {
        this.game = game;
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

    public Label getPlayer1Name() {
        return player1Name;
    }

    public void setPlayer1Name(Label player1Name) {
        this.player1Name = player1Name;
    }

    public Label getPlayer2Name() {
        return player2Name;
    }

    public void setPlayer2Name(Label player2Name) {
        this.player2Name = player2Name;
    }

    public Label getAngleCurrent() {
        return angleCurrent;
    }

    public void setAngleCurrent(Label angleCurrent) {
        this.angleCurrent = angleCurrent;
    }

    public Label getVelocityCurrent() {
        return velocityCurrent;
    }

    public void setVelocityCurrent(Label velocityCurrent) {
        this.velocityCurrent = velocityCurrent;
    }

    public Texture getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(Texture backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public Texture getGroundImage() {
        return groundImage;
    }

    public void setGroundImage(Texture groundImage) {
        this.groundImage = groundImage;
    }

    public Texture getTankImage1() {
        return tankImage1;
    }

    public void setTankImage1(Texture tankImage1) {
        this.tankImage1 = tankImage1;
    }

    public Texture getTankImage2() {
        return tankImage2;
    }

    public void setTankImage2(Texture tankImage2) {
        this.tankImage2 = tankImage2;
    }

    public Texture getRangeImage() {
        return rangeImage;
    }

    public void setRangeImage(Texture rangeImage) {
        this.rangeImage = rangeImage;
    }

    public Texture getMissileImage() {
        return missileImage;
    }

    public void setMissileImage(Texture missileImage) {
        this.missileImage = missileImage;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public Sprite getSprite2() {
        return sprite2;
    }

    public void setSprite2(Sprite sprite2) {
        this.sprite2 = sprite2;
    }

    public Sprite getTank1() {
        return tank1;
    }

    public void setTank1(Sprite tank1) {
        this.tank1 = tank1;
    }

    public Sprite getTank2() {
        return tank2;
    }

    public void setTank2(Sprite tank2) {
        this.tank2 = tank2;
    }

    public Sprite getRange() {
        return range;
    }

    public void setRange(Sprite range) {
        this.range = range;
    }

    public Sprite getMissile() {
        return missile;
    }

    public void setMissile(Sprite missile) {
        this.missile = missile;
    }

    public ProgressBar getHealthBar1() {
        return healthBar1;
    }

    public void setHealthBar1(ProgressBar healthBar1) {
        this.healthBar1 = healthBar1;
    }

    public ProgressBar getHealthBar2() {
        return healthBar2;
    }

    public void setHealthBar2(ProgressBar healthBar2) {
        this.healthBar2 = healthBar2;
    }

    public TextButton getBackButton() {
        return backButton;
    }

    public void setBackButton(TextButton backButton) {
        this.backButton = backButton;
    }

    public TextButton getFireButton() {
        return fireButton;
    }

    public void setFireButton(TextButton fireButton) {
        this.fireButton = fireButton;
    }

    public int getNormalizeCOM() {
        return normalizeCOM;
    }

    public void setNormalizeCOM(int normalizeCOM) {
        this.normalizeCOM = normalizeCOM;
    }

    public int getNormalizeCOM2() {
        return normalizeCOM2;
    }

    public void setNormalizeCOM2(int normalizeCOM2) {
        this.normalizeCOM2 = normalizeCOM2;
    }

    public int getInitialVelocity() {
        return initialVelocity;
    }

    public void setInitialVelocity(int initialVelocity) {
        this.initialVelocity = initialVelocity;
    }

    public int getCannonAngle() {
        return cannonAngle;
    }

    public void setCannonAngle(int cannonAngle) {
        this.cannonAngle = cannonAngle;
    }

    public int getPosCurrentTank() {
        return posCurrentTank;
    }

    public void setPosCurrentTank(int posCurrentTank) {
        this.posCurrentTank = posCurrentTank;
    }

    public int getMissileVisible() {
        return missileVisible;
    }

    public void setMissileVisible(int missileVisible) {
        this.missileVisible = missileVisible;
    }

    public float getMissileX() {
        return missileX;
    }

    public void setMissileX(int missileX) {
        this.missileX = missileX;
    }

    public float getMissileY() {
        return missileY;
    }

    public void setMissileY(int missileY) {
        this.missileY = missileY;
    }

    public GameScreen_1(TankWars game) {
        this.game = game;
    }

    @Override
    public void show() {

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        font = new BitmapFont(Gdx.files.internal("font-title-export.fnt"));
        batch = new SpriteBatch();

        font.getData().setScale(1);
        player1Name = new Label(game.player1Name, new Label.LabelStyle(font, Color.ORANGE));
        player1Name.setPosition(220,620);
        player2Name = new Label(game.player2Name, new Label.LabelStyle(font, Color.ORANGE));
        player2Name.setPosition(910,620);

        buttonSkin = new Skin(Gdx.files.internal("orange/skin/uiskin.json"));
        backButton = new TextButton("Options Menu",buttonSkin);
        backButton.setSize(150,50);
        backButton.setPosition(565,620);

        fireButton = new TextButton("FIRE",buttonSkin);
        fireButton.setSize(150,50);
        fireButton.setPosition(565,40);

        healthBar1 = new ProgressBar(0f, 100f, 1f, false, buttonSkin);
        healthBar1.setPosition(200,600);
        healthBar2 = new ProgressBar(0f, 100f, 1f, false, buttonSkin);
        healthBar2.setPosition(890,600);
        fuelBar = new ProgressBar(0f, 100f, 1f, false, buttonSkin);
        fuel = 100;

        angleCurrent = new Label(Integer.toString(cannonAngle), new Label.LabelStyle(font, Color.ORANGE));
        velocityCurrent = new Label(Integer.toString(initialVelocity), new Label.LabelStyle(font, Color.ORANGE));
        posCurrentTank = game.posTank1;

        backgroundImage = new Texture(Gdx.files.internal("background.png"));
        backgroundImage.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear); //For prevention of pixel scattering
        sprite = new Sprite(backgroundImage,0,0,1280,720);
        groundImage = new Texture(Gdx.files.internal("ground.jpg"));
        groundImage.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear); //For prevention of pixel scattering
        sprite2 = new Sprite(groundImage,0,0,1280,144);
        rangeImage = new Texture(Gdx.files.internal("rangeImage.png"));
        rangeImage.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear); //For prevention of pixel scattering
        range = new Sprite(rangeImage);
        missileImage = new Texture(Gdx.files.internal("missileImage.png"));
        missileImage.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear); //For prevention of pixel scattering
        missile = new Sprite(missileImage);
        missile.setSize(45,30);

        gravity=new Vector2(0, -10);
        iv =new Vector2((float)(initialVelocity*Math.cos(cannonAngle * Math.PI / 180)),(float)(initialVelocity*Math.sin(cannonAngle * Math.PI / 180)));


        if(game.tankChosen1==1) {
            tankImage1 = new Texture(Gdx.files.internal("Tanks/TankImage1.png"));
            normalizeCOM = 24;
        }
        else if(game.tankChosen1==2) {
            tankImage1 = new Texture(Gdx.files.internal("Tanks/TankImage2.png"));
            normalizeCOM = 26;
        }
        else if(game.tankChosen1==3) {
            tankImage1 = new Texture(Gdx.files.internal("Tanks/TankImage3.png"));
            normalizeCOM = 30;
        }
        if(game.tankChosen2==1) {
            tankImage2 = new Texture(Gdx.files.internal("Tanks/TankImage1.png"));
            normalizeCOM2 = 24;
        }
        else if(game.tankChosen2==2) {
            tankImage2 = new Texture(Gdx.files.internal("Tanks/TankImage2.png"));
            normalizeCOM2 = 26;
        }
        else if(game.tankChosen2==3) {
            tankImage2 = new Texture(Gdx.files.internal("Tanks/TankImage3.png"));
            normalizeCOM2 = 30;
        }
        tankImage1.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear); //For prevention of pixel scattering
        tankImage2.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear); //For prevention of pixel scattering

        tank1 = new Sprite(tankImage1);
        tank1.setSize(100,100);
        tank2 = new Sprite(tankImage2);
        tank2.setSize(100,100);
        tank2.flip(true,false);

        stage.addActor(player1Name);
        stage.addActor(player2Name);
        stage.addActor(angleCurrent);
        stage.addActor(velocityCurrent);
        stage.addActor(backButton);
        stage.addActor(fireButton);
        stage.addActor(healthBar1);
        stage.addActor(healthBar2);
        stage.addActor(fuelBar);

        backButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new OptionScreen(game));
            }
        });
        fireButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                game.tankturn = 2;
                missileVisible = 1;
                missileX = game.posTank1+50;
                missileY = 144 - normalizeCOM+50;
                missile.setPosition(missileX, missileY);
                elapsedTime = (float) (2*(initialVelocity)*Math.sin(cannonAngle*Math.PI/180)/10);
                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        game.setScreen(new GameScreen_2(game));
                    }
                }, 3);

            }
        });
    }

    public void resize(int width, int height) {
        stage.getViewport().update(width,height,true);
    }

    @Override
    public void render(float delta) {
        game.posTank1 = posCurrentTank;

        angleCurrent.setText("Angle: "+(cannonAngle));
        velocityCurrent.setText("Power: "+initialVelocity);
        angleCurrent.setPosition(posCurrentTank,310);
        velocityCurrent.setPosition(posCurrentTank,350);
        fuelBar.setPosition(posCurrentTank, 100);
        fuelBar.setValue(fuel);

        range.setPosition(game.posTank1+50, 144-normalizeCOM+60);
        range.setOrigin(0, 0);
        range.setSize(initialVelocity,initialVelocity);
        range.setRotation(cannonAngle-45); //Just this is with respect to the image, everything else is cool
        if(cannonAngle>90){
            range.setFlip(true,true);
//            range.flip(true,true);
        }
        else{
            range.setFlip(false,false);
        }
        tank1.setPosition(game.posTank1,144 - normalizeCOM);
        tank2.setPosition(game.posTank2,144 - normalizeCOM2);
        healthBar1.setValue(game.healthTank1);
        healthBar2.setValue(game.healthTank2);

        ScreenUtils.clear(138/407f, 43/407f, 226/407f, 1);
        batch.begin();
        sprite.draw(batch);
        sprite2.draw(batch);
        tank1.draw(batch);
        tank2.draw(batch);
        range.draw(batch);
        if(game.healthTank2==0){
            game.setScreen(new WonScreen(game,1));
        }
        if(missileY<144){
            missileVisible = 0;
            float temp = Math.abs(game.posTank2 - missileX);
            if(temp<100){
                game.healthTank2 -= 100;
                game.healthTank2 += temp;
                game.posTank2 += temp;
            }
        }
        if(missileVisible==1) {
            float deltatime=Gdx.graphics.getDeltaTime();
            iv.x+=gravity.x*deltatime*elapsedTime;
            iv.y+=gravity.y*deltatime*elapsedTime;
            missileX = missile.getX()+iv.x * deltatime * elapsedTime;
            missileY = missile.getY()+iv.y * deltatime * elapsedTime;
            missile.setPosition(missileX,missileY);
            missile.draw(batch);
        }
        stage.draw();
        batch.end();

        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            if(initialVelocity<100) {
                initialVelocity++;
            }
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            if(initialVelocity>0) {
                initialVelocity--;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            if(posCurrentTank>10 && fuel > 0) {
                posCurrentTank--;
                fuel--;
            }
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.D)){
            if(posCurrentTank<1200 && fuel > 0) {
                posCurrentTank++;
                fuel--;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            if(cannonAngle<180) {
                cannonAngle++;
            }
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.S)){
            if(cannonAngle>0) {
                cannonAngle--;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.ENTER)){
            game.setScreen(new WonScreen(game,1));
        }
    }

    @Override
    public void hide(){
        Gdx.input.setInputProcessor(null);
    }
}
