package com.example.jumper.model;

public class Ufo extends GameCharacter{

    private Player player;
    private OnOverlapListener onOverlapListener;
    private int xSpeed = 2;

    public Ufo(int inity) {
        x = (int)(Math.random()*600);
        y = inity+(int)(Math.random()*400 - 200);
        xSize = 96;
        ySize = 66;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setOnOverlapListener(OnOverlapListener onOverlapListener) {
        this.onOverlapListener = onOverlapListener;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public void move() {
        x = x + xSpeed;
        if (x > (700 - xSize)) {
            xSpeed = -2;
        }
        if (x < 0) {
            xSpeed = 2;
        }
        if ( overlap(player) == true) {
            player.dead();
            onOverlapListener.overlap(this);
        }
    }


}
