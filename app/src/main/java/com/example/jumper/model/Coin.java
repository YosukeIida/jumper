package com.example.jumper.model;

public class Coin extends GameCharacter {

    private Player player;
    private OnOverlapListener onOverlapListener;
    public Coin(int inity) {
        x = (int)(Math.random()*600);
        y = inity+(int)(Math.random()*600 - 300);
        xSize=75;
        ySize=75;
    }
    private boolean disappearFlag = false;

    private int state = 0;
    private int count = 0;


    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setOnOverlapListener(OnOverlapListener onOverlapListener) {
        this.onOverlapListener = onOverlapListener;
    }

    public boolean isDisappearFlag() {
        return disappearFlag;
    }

    public int getState() {
        return state;
    }

    public void move() {
        if (disappearFlag == true) {
            count ++;
        }
        if ( overlap(player) == true && disappearFlag == false) {
            player.addPoint(10);
            disappearFlag = true;
            onOverlapListener.overlap(this);
        }
        if (count <= 10) {
            state = 0;
        }
        else if  (count <= 20) {
            state = 1;
        }
        else if (count <= 30) {
            state = 2;
        } else {
            state = 3;
        }
    }
}
