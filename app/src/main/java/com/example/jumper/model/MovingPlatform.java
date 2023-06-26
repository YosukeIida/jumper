package com.example.jumper.model;

public class MovingPlatform extends GameCharacter{

    private Player player;
    private  OnOverlapListener onOverlapListener;

    private int xSpeed=2;

    public MovingPlatform(int inity) {
        x = (int)(Math.random()*500);
        y = inity+(int)(Math.random()*100-50);
        xSize = 192;
        ySize = 42;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public  void setOnOverlapListener(OnOverlapListener onOverlapListener) {
        this.onOverlapListener = onOverlapListener;
    }

    public void move() {
        x = x + xSpeed;

        if (x > 700-xSize) {
            xSpeed = -xSpeed;
        }
        if (x < 50) {
            xSpeed = -xSpeed;
        }
        if ( player.getySpeed() <= 0 && overlap(player) == true ) {
            player.jump();
            onOverlapListener.overlap(this);
        }
    }
}
