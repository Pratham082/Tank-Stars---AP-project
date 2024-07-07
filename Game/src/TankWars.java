package com.mygdx.game;

import com.badlogic.gdx.Game;
import java.io.Serializable;

public class TankWars extends Game implements Serializable{
    private static TankWars gen = null; // Singleton Interface
    public static TankWars getInstance() {
        if (gen == null) {
            gen = new TankWars();
        }
        return gen;
    }
    String player1Name; String player2Name;
    int tankChosen1; int tankChosen2;
    int referencePos1 = 100, referencePos2 = 1080;
    int posTank1 = 100; int posTank2 = 1080;
    int referenceHealth1 = 100, referenceHealth2 = 1080;
    float healthTank1 = 100; float healthTank2 = 100;
    int tankturn = 1;


    private TankWars(){
        super();
    }

    @Override
    public void create () {
        setScreen(new TitleScreen(this));
    }

    @Override
    public void dispose () {
    }
}