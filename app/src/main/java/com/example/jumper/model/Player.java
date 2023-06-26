package com.example.jumper.model;

public class Player extends GameCharacter{


    private int xSpeed=0;
    private float ySpeed=0;
    private int yMax=0;
    private boolean jumpFlag = false;

    private boolean deadFlag = false;

    private boolean clearFlag = false;

    private int point = 0;

    public Player() {
        x = 400;
        y = 0;
        xSize = 96;
        ySize = 96;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public int getxSpeed() { return xSpeed; }

    public float getySpeed() { return ySpeed; }

    public int getyMax() {
        return yMax;
    }

    public boolean isDead() {
        return deadFlag;
    }

    public boolean isClear() {
        return clearFlag;
    }

    public void dead() {
        deadFlag = true;
    }

    public void clear() {
        clearFlag = true;
    }

    public int getPoint() {
        return point;
    }
    public void addPoint(int p) {
        point += p;
    }

    public void move() {

        // ジャンプ中でなければジャンプする
        if (jumpFlag == false) {
            jump();
        }

        x = x + xSpeed;
        y = (int) (y + ySpeed);

        // 地上に着地したらジャンプ終了
        if (y <= 0 ) {
            y = 0;
            ySpeed = 0;
            jumpFlag = false;
        }

        // 重力で減速
        ySpeed = ySpeed - 0.1f;

        // 画面の端を超えたら反対側に移動
        if (x > 700) {
            x = -xSize;
        }

        if (x < -xSize) {
            x = 700;
        }

        // 最高到達点を更新
        if (y > yMax) {
            yMax = y;
        }
    }


    public void jump() {
        ySpeed = 10.4f;
        jumpFlag = true;
    }
    public void highjump() {
        ySpeed = 14.0f;
        jumpFlag = true;
    }



}
