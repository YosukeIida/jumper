package com.example.jumper;

import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.example.jumper.helpers.BaseActivity;
import com.example.jumper.model.GameCharacter;
import com.example.jumper.model.OnOverlapListener;
import com.example.jumper.model.World;
import com.example.jumper.views.MainView;

public class MainActivity extends BaseActivity {


    //------------------
    // ビュー
    //------------------

    MainView mainView;

    ConstraintLayout constraintLayout;


    //--------------------
    // モデル
    //--------------------
    World world;


    // 効果音
    int platform_sound;
    int brokenPlatform_sound;
    int coin_sound;
    int ufo_sound;
    int spring_sound;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 加速度センサ有効化
        gravityEnabled=true;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //--------------
        // ビューの取得・生成
        //--------------
        mainView = new MainView(this);

        //---------------
        // モデルの生成
        //---------------
        world = new World();

        //---------------
        // BGM
        //--------------
        loadMusic(R.raw.bgm);
        setMusicVolume(0.5f);
        startMusic();

        // 効果音
        platform_sound = loadSound(R.raw.platform);
        brokenPlatform_sound = loadSound(R.raw.broken);
        coin_sound = loadSound(R.raw.coin);
        ufo_sound = loadSound(R.raw.ufo);
        spring_sound = loadSound(R.raw.spring);

        // イベントリスナーの接続
        world.getPlatforms().forEach(x->x.setOnOverlapListenner(new PlatformOnOverlapListener()));
        world.getMovingPlatforms().forEach(x->x.setOnOverlapListener(new PlatformOnOverlapListener()));
        world.getBrokenPlatforms().forEach(x->x.setOnOverlapListener(new BrokenPlatformOnOverlapListener()));
        world.getCoins().forEach(x->x.setOnOverlapListener(new CoinOnOverlapListener()));
        world.getUfos().forEach(x->x.setOnOverlapListener((new UfoOnOverlapListener())));

        world.getSprings().forEach(x->x.setOnOverlapListener((new SpringOnOverlapListener())));
    }

    @Override
    public void update() {

        //---------------------
        // モデルの更新
        //---------------------

        int xAccel=(int)accelerationController.x;
        world.getYusyaYoshida().setxSpeed(-xAccel);

        world.move();

        mainView.draw(world);



    }

    public void retry() {
        stopMusic();
        stopSound();

        Intent intent = new Intent (getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();

        loadMusic(R.raw.bgm);
        setMusicVolume(0.5f);
        startMusic();
    }

    public class PlatformOnOverlapListener implements OnOverlapListener {

        @Override
        public void overlap(GameCharacter gameCharacter) {
            playSound(platform_sound, 1.0f);
        }
    }

    public class BrokenPlatformOnOverlapListener implements OnOverlapListener {

        @Override
        public void overlap(GameCharacter gameCharacter) {
            playSound(brokenPlatform_sound, 1.0f);
        }
    }

    public class CoinOnOverlapListener implements OnOverlapListener {

        @Override
        public void overlap(GameCharacter gameCharacter) {
            playSound(coin_sound, 1.0f);
        }
    }

    public class UfoOnOverlapListener implements OnOverlapListener {

        @Override
        public void overlap(GameCharacter gameCharacter) {
            playSound(ufo_sound, 1.0f);
        }
    }

    public class SpringOnOverlapListener implements OnOverlapListener {

        @Override
        public void overlap(GameCharacter gameCharacter) {
            playSound(spring_sound, 1.0f);
        }
    }
}