package com.example.jumper.model;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class World {
    //-------------------
    // 変数宣言
    //-------------------
    public final int PLATFORM_COUNTS = 5;
    public final int MOVING_PLATFORM_COUNTS = 5;
    public final int BROKEN_PLATFORM_COUNTS = 5;
    public final int UFO_COUNTS = 6;
    public final int COIN_COUNTS = 8;
    public final int SPRING_COUNTS = 3;

    //------------------
    // モデル
    //------------------
    private Player yusyaYoshida;
    private List<Platform> platforms;
    private List<Coin> coins;
    private Castle castle;
    private List<MovingPlatform> movingPlatforms;
    private List<Ufo> ufos;
    private List<BrokenPlatform> brokenPlatforms;
    private List<Spring> springs;


    public World() {
        //------------------
        // モデルの生成
        //------------------
        yusyaYoshida = new Player();
//        coin = new Coin(400);
        castle = new Castle();
//        platform = new Platform();
//        movingPlatform = new MovingPlatform();
//        ufo = new Ufo();
//        brokenPlatform = new BrokenPlatform();

        platforms = IntStream.rangeClosed(0, PLATFORM_COUNTS -1).map(n -> 400 + n * 1200).mapToObj(y-> new Platform(y)).collect(Collectors.toList());
        movingPlatforms = IntStream.rangeClosed(0, MOVING_PLATFORM_COUNTS -1).map(n -> 800 + n * 1200).mapToObj(y-> new MovingPlatform(y)).collect(Collectors.toList());
        brokenPlatforms = IntStream.rangeClosed(0, BROKEN_PLATFORM_COUNTS -1).map(n -> 1200 + n * 1200).mapToObj(y-> new BrokenPlatform(y)).collect(Collectors.toList());
        ufos = IntStream.rangeClosed(0, UFO_COUNTS -1).map(n -> 400 + n * 1200).mapToObj(y-> new Ufo(y)).collect(Collectors.toList());
        coins = IntStream.rangeClosed(0, COIN_COUNTS -1).map(n -> 450 + n * 800).mapToObj(y-> new Coin(y)).collect(Collectors.toList());
        springs = IntStream.rangeClosed(0, SPRING_COUNTS -1).map(n -> 1800 + n * 1800).mapToObj(y-> new Spring(y)).collect(Collectors.toList());

        //        platforms = new LinkedList<Platform>();
//        for (int i=0; i<PLATFORM_COUNTS; i++) {
//            Platform platform = new Platform(400 + i * 1200);
//            platforms.add(platform);
//        }
//        movingPlatforms = new LinkedList<MovingPlatform>();
//        for (int i=0; i<MOVING_PLATFORM_COUNTS; i++) {
//            MovingPlatform movingPlatform = new MovingPlatform(800 + i * 1200);
//            movingPlatforms.add(movingPlatform);
//        }

//        brokenPlatforms = new LinkedList<BrokenPlatform>();
//        for (int i=0; i<BROKEN_PLATFORM_COUNTS; i++) {
//            BrokenPlatform brokenPlatform = new BrokenPlatform(1200 + i * 1200);
//            brokenPlatforms.add(brokenPlatform);
//        }
//        ufos = new LinkedList<Ufo>();
//        for (int i=0; i<UFO_COUNTS; i++) {
//            Ufo ufo = new Ufo(1100 + i*1000);
//            ufos.add(ufo);
//        }
//        coins = new LinkedList<Coin>();
//        for (int i=0; i<COIN_COUNTS; i++) {
//            Coin coin = new Coin(450 + i*800);
//            coins.add(coin);
//        }
//        springs = new LinkedList<Spring>();
//        for (int i=0; i<SPRING_COUNTS; i++) {
//            Spring spring = new Spring(1800+ i*1800);
//            springs.add(spring);
//        }

        //------------------------
        // モデルの接続
        //------------------------
//        platform.setPlayer(yusyaYoshida);
//        movingPlatform.setPlayer(yusyaYoshida);
//        brokenPlatform.setPlayer(yusyaYoshida);
//        ufo.setPlayer(yusyaYoshida);
        castle.setPlayer(yusyaYoshida);
//        coin.setPlayer(yusyaYoshida);

        platforms.forEach(x->x.setPlayer(yusyaYoshida));
        movingPlatforms.forEach(x->x.setPlayer(yusyaYoshida));
        brokenPlatforms.forEach(x->x.setPlayer(yusyaYoshida));
        ufos.forEach(x->x.setPlayer(yusyaYoshida));
        coins.forEach(x->x.setPlayer(yusyaYoshida));
        springs.forEach(x->x.setPlayer(yusyaYoshida));

//
//        for (int i=0; i<PLATFORM_COUNTS; i++) {
//            Platform platform = platforms.get(i);
//            platform.setPlayer(yusyaYoshida);
//        }
//
//        for (int i=0; i<MOVING_PLATFORM_COUNTS; i++) {
//            MovingPlatform movingPlatform = movingPlatforms.get(i);
//            movingPlatform.setPlayer(yusyaYoshida);
//        }
//
//        for (int i=0; i<BROKEN_PLATFORM_COUNTS; i++) {
//            BrokenPlatform brokenPlatform = brokenPlatforms.get(i);
//            brokenPlatform.setPlayer(yusyaYoshida);
//        }
//        for (int i=0; i<UFO_COUNTS; i++) {
//            Ufo ufo = ufos.get(i);
//            ufo.setPlayer(yusyaYoshida);
//        }
//        for (int i=0; i<COIN_COUNTS; i++) {
//            Coin coin = coins.get(i);
//            coin.setPlayer(yusyaYoshida);
//        }
//        for (int i=0; i<SPRING_COUNTS; i++) {
//            Spring spring = springs.get(i);
//            spring.setPlayer(yusyaYoshida);
//        }
    }

    public void move() {
        yusyaYoshida.move();
        castle.move();

        platforms.forEach(x->x.move());
        movingPlatforms.forEach(x->x.move());
        brokenPlatforms.forEach(x->x.move());
        ufos.forEach(x->x.move());
        coins.forEach(x->x.move());
        springs.forEach(x->x.move());

//
//        for (int i=0; i<PLATFORM_COUNTS; i++) {
//            platforms.get(i).move();
//        }
//        for (int i=0; i<PLATFORM_COUNTS; i++) {
//            movingPlatforms.get(i).move();
//        }
//        for (int i=0; i<BROKEN_PLATFORM_COUNTS; i++) {
//            brokenPlatforms.get(i).move();
//        }
//        for (int i=0; i<UFO_COUNTS; i++) {
//            ufos.get(i).move();
//        }
//        for (int i=0; i<COIN_COUNTS; i++) {
//            coins.get(i).move();
//        }
//        for (int i=0; i<SPRING_COUNTS; i++) {
//            springs.get(i).move();
//        }
    }

    public Player getYusyaYoshida() {
        return yusyaYoshida;
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public Castle getCastle() {
        return castle;
    }

    public List<MovingPlatform> getMovingPlatforms() {
        return movingPlatforms;
    }

    public List<Ufo> getUfos() {
        return ufos;
    }

    public List<BrokenPlatform> getBrokenPlatforms() {
        return brokenPlatforms;
    }

    public List<Spring> getSprings() {
        return springs;
    }
}
