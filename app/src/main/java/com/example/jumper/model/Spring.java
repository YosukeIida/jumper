package com.example.jumper.model;

public class Spring extends GameCharacter {
    private Player player;
    private OnOverlapListener onOverlapListener;
    public Spring(int inity) {
        x = (int)(Math.random()*600);
        y = inity + (int)(Math.random()*400 - 200);
        xSize = 70;
        ySize = 70;
    }
    public void setPlayer(Player player) {this.player = player;}

    public void setOnOverlapListener(OnOverlapListener onOverlapListener) {
        this.onOverlapListener = onOverlapListener;
    }

    public void move() {
        if ( player.getySpeed() <= 0 && overlap(player) == true ) {
            player.highjump();
            onOverlapListener.overlap(this);
        }
    }

}
