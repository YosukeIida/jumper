package com.example.jumper.model;

public class Castle extends GameCharacter{
    private Player player;

     public Castle() {
        x = 500;
        y = 6500;
        xSize = 192;
        ySize = 192;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    public void move() {
         if ( overlap(player) == true) {
            player.clear();
         }
    }
}
