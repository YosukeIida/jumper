package com.example.jumper.model;

public class GameCharacter {
    protected int x=0;
    protected int y=0;
    protected int xSize=0;
    protected int ySize=0;

    public int getX() { return x; }

    public int getY() {
        return y;
    }

    public int getxSize() {
        return xSize;
    }

    public int getySize() {
        return ySize;
    }

    // キャラクターの右端のx座標を取得する
    public int getRight() {
        return x + xSize - 1;
    }

    // キャラクターの左端のx座標を取得する
    public int getLeft() {
        return x;
    }

    // キャラクターの上端のy座標を取得する
    public int getTop() {
        return y + ySize - 1;
    }

    // キャラクターの下端のy座標を取得する
    public int getBottom() {
        return y;
    }

    // 横方向で重なっているか判定
    public boolean overlapX(GameCharacter target) {
        // 自分の右端のx座標よりも，相手の左端のx座標が大きいなら重なっていない
        if ( getRight() < target.getLeft() ) {
            return false;
        }

        // 相手の右端のx座標よりも，自分の左端のx座標が大きいなら重なっていない
        if ( target.getRight() < getLeft() ) {
            return false;
        }
        return true;
    }

    // 縦方向で重なっていないか確認
    public boolean overlapY(GameCharacter target) {
        // 自分の上端のy座標よりも，相手の下端のy座標が大きいなら重なっていない
        if (getTop() < target.getBottom() ) {
            return false;
        }
        if (target.getTop() < getBottom() ) {
            return false;
        }
        return true;
    }

    // 衝突していないか判定する
    public boolean overlap(GameCharacter target) {
        return overlapX(target) && overlapY(target);
    }
}
