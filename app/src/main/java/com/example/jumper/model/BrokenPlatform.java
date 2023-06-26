package com.example.jumper.model;

public class BrokenPlatform extends GameCharacter {

    private Player player;
    private OnOverlapListener onOverlapListener;
    public BrokenPlatform(int inity) {
        x = (int)(Math.random()*500);
        y = inity+(int)(Math.random()*100 - 50);
        xSize = 192;
        ySize = 42;
    }

    private boolean countFlag = false;
    private int count=0;
    private int state=0;

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getState() {
        return state;
    }

    public void setOnOverlapListener(OnOverlapListener onOverlapListener) {
        this.onOverlapListener = onOverlapListener;
    }

    public void move() {
        if (countFlag == true) {
            count ++;
        }
        if ( player.getySpeed() <= 0 && overlap(player) == true && state<4) {
            player.jump();
            onOverlapListener.overlap(this);
            countFlag = true;
        }
        if (count <= 10) {
            state = 0;
        }
        else if  (count <= 20) {
            state = 1;
        }
        else if (count <= 30) {
            state = 2;
        }
        else if (count <= 40) {
            state = 3;
        } else {
            state = 4;
        }
    }
}
