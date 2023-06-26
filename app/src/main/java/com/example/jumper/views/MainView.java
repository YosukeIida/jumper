package com.example.jumper.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.jumper.MainActivity;
import com.example.jumper.R;
import com.example.jumper.helpers.BaseView;
import com.example.jumper.model.BrokenPlatform;
import com.example.jumper.model.Coin;
import com.example.jumper.model.GameCharacter;
import com.example.jumper.model.MovingPlatform;
import com.example.jumper.model.Platform;
import com.example.jumper.model.Player;
import com.example.jumper.model.Spring;
import com.example.jumper.model.Ufo;
import com.example.jumper.model.World;

import java.util.LinkedList;

public class MainView extends BaseView {

    ConstraintLayout constraintLayout;
    Context context;
    MainActivity mainActivity;

    //-------------------
    // 変数宣言
    //-------------------
    final int PLATFORM_COUNTS = 5;
    final int MOVING_PLATFORM_COUNTS = 5;
    final int BROKEN_PLATFORM_COUNTS = 5;
    final int UFO_COUNTS = 6;
    final int COIN_COUNTS = 8;
    final int SPRING_COUNTS = 3;

    //------------------
    // 画像
    //------------------
    Bitmap playerRightImage;
    Bitmap playerLeftImage;
    Bitmap platformImage;
    Bitmap coinImage;
    Bitmap coinImage2;
    Bitmap coinImage3;
    Bitmap castleImage;
    Bitmap ufoRightImage;
    Bitmap ufoLeftImage;
    Bitmap platformImage1;
    Bitmap platformImage2;
    Bitmap platformImage3;
    Bitmap springImage;


    ImageViewBuilder imageViewBuilder;
    TextView gameOverTextView;
    TextView gameClearTextView;
    TextView scoreTextView;

    Button retryButton;




    public MainView(Context context) {
        super(context);
        this.context = context;
        this.mainActivity=(MainActivity)context;
        this.constraintLayout = baseActivity.findViewById(R.id.constraintLayout);

        //------------------
        // 画像の読み込み
        //------------------
        playerRightImage=loadImage(R.drawable.player_right);
        playerLeftImage=loadImage(R.drawable.player_left);
        platformImage=loadImage(R.drawable.platform);
        coinImage=loadImage(R.drawable.coin);
        coinImage2=loadImage(R.drawable.coin2);
        coinImage3=loadImage(R.drawable.coin3);
        castleImage=loadImage(R.drawable.castle);
        ufoLeftImage=loadImage(R.drawable.ufo_left);
        ufoRightImage=loadImage(R.drawable.ufo_right);
        platformImage1=loadImage(R.drawable.platform1);
        platformImage2=loadImage(R.drawable.platform2);
        platformImage3=loadImage(R.drawable.platform3);
        springImage=loadImage(R.drawable.spring);


        //------------------
        // ビューの取得・生成
        //------------------
        imageViewBuilder = new ImageViewBuilder(constraintLayout, context);

        //------------------
        // プレーヤ用ImageView
        //------------------
//        playerImageView = new ImageView(context);
//        constraintLayout.addView(playerImageView);
//
//        // 足場用 platform Image View
//        platformImageViews = new LinkedList<ImageView>();
//        for (int i=0; i<PLATFORM_COUNTS; i++) {
//            ImageView platformImageView = new ImageView(context);
//            constraintLayout.addView(platformImageView);
//            platformImageViews.add(platformImageView);
//        }
//
//        coinImageViews = new LinkedList<ImageView>();
//        for (int i=0; i<COIN_COUNTS; i++) {
//            ImageView coinImageView = new ImageView(context);
//            constraintLayout.addView(coinImageView);
//            coinImageViews.add(coinImageView);
//        }
//
//        // castle Image View
//        castleImageView = new ImageView(context);
//        constraintLayout.addView(castleImageView);
//
//        movingPlatformImageViews = new LinkedList<ImageView>();
//        for (int i=0; i<MOVING_PLATFORM_COUNTS; i++) {
//            ImageView movingPlatformImageView = new ImageView(context);
//            constraintLayout.addView(movingPlatformImageView);
//            movingPlatformImageViews.add(movingPlatformImageView);
//        }
//
//
//        ufoImageViews = new LinkedList<ImageView>();
//        for (int i=0; i<UFO_COUNTS; i++) {
//            ImageView ufoImageView = new ImageView(context);
//            constraintLayout.addView(ufoImageView);
//            ufoImageViews.add(ufoImageView);
//        }
//
//        brokenPlatformImageViews = new LinkedList<ImageView>();
//        for (int i=0; i<BROKEN_PLATFORM_COUNTS; i++) {
//            ImageView brokenPlatformImageView = new ImageView(context);
//            constraintLayout.addView(brokenPlatformImageView);
//            brokenPlatformImageViews.add(brokenPlatformImageView);
//        }
//
//        springImageViews = new LinkedList<ImageView>();
//        for (int i=0; i<SPRING_COUNTS; i++) {
//            ImageView springImageView = new ImageView(context);
//            constraintLayout.addView(springImageView);
//            springImageViews.add(springImageView);
//        }

        // GameOver
        gameOverTextView = new TextView(context);
        constraintLayout.addView(gameOverTextView);
        gameOverTextView.setText("Game Over !!");
        gameOverTextView.setTextSize(32);
        gameOverTextView.setTextColor(Color.RED);
        gameOverTextView.setVisibility(View.GONE);

        // GameClear
        gameClearTextView = new TextView(context);
        constraintLayout.addView(gameClearTextView);
        gameClearTextView.setText("Game Clear !!");
        gameClearTextView.setTextSize(32);
        gameClearTextView.setTextColor(Color.BLUE);
        gameClearTextView.setVisibility(View.GONE);

        // Score
        scoreTextView = new TextView(context);
        constraintLayout.addView(scoreTextView);
        scoreTextView.setTextSize(32);
        scoreTextView.setTextColor(Color.BLUE);

        // リトライボタン
        retryButton = new Button(context);
        constraintLayout.addView(retryButton);
        retryButton.setVisibility(GONE);
        retryButton.setOnClickListener(new RetryButtonOnClickListener(){
            @Override
            public void onClick(View view) {
                mainActivity.retry();
            }
        });

    }

    public void draw(World world) {

        int yMax = world.getYusyaYoshida().getyMax();
        if (yMax < 750) {
            canvasBaseY = 0;
        } else {
            canvasBaseY = yMax - 750;
        }

        // ImageViewBuilderをリセット
        imageViewBuilder.reset();

//        if (world.getYusyaYoshida().isDead()) {
//            gameOverTextView.setVisibility(View.VISIBLE);
//            drawTextViewCenter(350, canvasBaseY + 750, gameOverTextView);
//        }
//
//        if (world.getYusyaYoshida().isClear() && world.getYusyaYoshida().isDead() == false) {
//            gameClearTextView.setVisibility(View.VISIBLE);
//            drawTextViewCenter(350, canvasBaseY + 750, gameClearTextView);
//        }
//
//        scoreTextView.setText(String.valueOf(world.getYusyaYoshida().getPoint()));
//        drawTextViewRight(700, canvasBaseY + 1300,scoreTextView);



        Player yusyaYoshida = world.getYusyaYoshida();
        // プレーヤー
        drawPlayer(yusyaYoshida);
        drawCharacter(world.getCastle(), castleImage);
        world.getPlatforms().forEach(x->drawCharacter(x, platformImage));
        world.getMovingPlatforms().forEach(x -> drawCharacter(x, platformImage));
        world.getBrokenPlatforms().forEach(x -> drawBrokenPlatform(x));
        world.getUfos().forEach(x -> drawUfo(x));
        world.getCoins().forEach(x-> drawCoin(x));
//        world.getCoins().forEach(x->drawCharacter(x, coinImage));
        world.getSprings().forEach(x-> drawCharacter(x, springImage));

        drawScore(yusyaYoshida.getPoint());

        if (yusyaYoshida.isDead()) {
            drawGameOver();
            drawRetryButton();
        } else if (yusyaYoshida.isClear()) {
            drawGameClear();
        }


        // 足場
//        drawCharacter(platform, platformImage, platformImageView);
//        for (int i=0; i<PLATFORM_COUNTS; i++) {
//            Platform platform = world.getPlatforms().get(i);
//            ImageView platformImageView = platformImageViews.get(i);
//            drawCharacter(platform, platformImage, platformImageView);
//        }
//
//        // 動く足場
////        drawCharacter(movingPlatform, platformImage, movingPlatformImageView);
//        for (int i=0; i<MOVING_PLATFORM_COUNTS; i++) {
//            MovingPlatform movingPlatform = world.getMovingPlatforms().get(i);
//            ImageView movingPlatfromImageView = movingPlatformImageViews.get(i);
//            drawCharacter(movingPlatform, platformImage, movingPlatfromImageView);
//        }
//        // コイン
////        drawCharacter(coin, coinImage, coinImageView);
//        for (int i=0; i<COIN_COUNTS; i++) {
//            Coin coin = world.getCoins().get(i);
//            ImageView coinImageView = coinImageViews.get(i);
//            drawCharacter(coin, coinImage, coinImageView);
//            if (coin.isDisappearFlag() == true) {
//                coinImageView.setVisibility(View.GONE);
//            }
//            else {
//                coinImageView.setVisibility(View.VISIBLE);
//            }
//        }
//
//        // お城
//        drawCharacter(world.getCastle(), castleImage);
//        // Ufo
////        drawUfo(ufo, ufoImageView);
//        for (int i=0; i<UFO_COUNTS; i++) {
//            Ufo ufo = world.getUfos().get(i);
//            ImageView ufoImageView = ufoImageViews.get(i);
//            drawUfo(ufo, ufoImageView);
//        }
//
//
//        // 壊れる足場
////        drawBrokenPlatform(brokenPlatform, brokenPlatformImageView);
//        for (int i=0; i<BROKEN_PLATFORM_COUNTS; i++) {
//            BrokenPlatform brokenPlatform = world.getBrokenPlatforms().get(i);
//            ImageView brokenPlatfromImageView = brokenPlatformImageViews.get(i);
//            drawBrokenPlatform(brokenPlatform, brokenPlatfromImageView);
//        }
//
//        for (int i=0; i<SPRING_COUNTS; i++) {
//            Spring spring = world.getSprings().get(i);
//            ImageView springImageView = springImageViews.get(i);
//            drawCharacter(spring, springImage, springImageView);
//        }


    }

    //======================
    // キャラクター表示用の関数
    //======================

    // 画像が変化しないキャラクターの表示
    public void drawCharacter(GameCharacter gameCharacter, Bitmap image) {
        ImageView imageView = imageViewBuilder.getImageView();
        int x = gameCharacter.getX();
        int y = gameCharacter.getY();
        int xSize = gameCharacter.getxSize();
        int ySize = gameCharacter.getySize();
        drawImage(x, y, xSize, ySize, image, imageView);
    }
    // プレーヤーの表示
    public void drawPlayer(Player player) {
        ImageView imageView = imageViewBuilder.getImageView();
        int x = player.getX();
        int y = player.getY();
        int xSize = player.getxSize();
        int ySize = player.getySize();
        int xSpeed = player.getxSpeed();
        if ( xSpeed >= 0 ) {
            drawImage(x, y, xSize, ySize, playerRightImage, imageView);
        } else {
            drawImage(x, y, xSize, ySize, playerLeftImage, imageView);
        }
    }

    // Ufoの表示
    public void drawUfo(Ufo ufo) {
        ImageView imageView = imageViewBuilder.getImageView();
        int ux = ufo.getX();
        int uy = ufo.getY();
        int uxSize = ufo.getxSize();
        int uySize = ufo.getySize();
        int uxSpeed = ufo.getxSpeed();
        if (uxSpeed >= 0) {
            drawImage(ux, uy, uxSize, uySize, ufoRightImage, imageView);
        } else {
            drawImage(ux, uy, uxSize, uySize, ufoLeftImage, imageView);
        }
    }

    // 壊れる足場の表示
    public void drawBrokenPlatform(BrokenPlatform brokenPlatform) {
        ImageView imageView = imageViewBuilder.getImageView();
        int bpx = brokenPlatform.getX();
        int bpy = brokenPlatform.getY();
        int bpxSize = brokenPlatform.getxSize();
        int bpySize = brokenPlatform.getySize();
        int state = brokenPlatform.getState();
        switch (state) {
            case 0:
                drawImage(bpx, bpy, bpxSize, bpySize, platformImage, imageView);
                break;
            case 1:
                drawImage(bpx, bpy, bpxSize, bpySize, platformImage1, imageView);
                break;
            case 2:
                drawImage(bpx, bpy, bpxSize, bpySize, platformImage2, imageView);
                break;
            case 3:
                drawImage(bpx, bpy, bpxSize, bpySize, platformImage3, imageView);
                break;
            case 4:
                imageView.setVisibility(View.GONE);

        }
    }

    public void drawCoin(Coin coin) {
        ImageView imageView = imageViewBuilder.getImageView();
        int cx = coin.getX();
        int cy = coin.getY();
        int cxSize = coin.getxSize();
        int cySize = coin.getySize();
        int cState = coin.getState();
        switch (cState) {
            case 0:
                drawImage(cx, cy, cxSize, cySize, coinImage, imageView);
                break;
            case 1:
                drawImage(cx, cy, cxSize, cySize, coinImage2, imageView);
                break;
            case 2:
                drawImage(cx, cy, cxSize, cySize, coinImage3, imageView);
                break;
            case 3:
                imageView.setVisibility(GONE);
                break;
        }
    }

    // テキスト表示用の関数
    public void drawScore(int score) {
        scoreTextView.setTextSize(32);
        scoreTextView.setTextColor(Color.BLUE);
        scoreTextView.setText("" + score);
        drawTextViewRight(700, canvasBaseY + 1400, scoreTextView);
    }

    public void drawGameOver() {
        gameOverTextView.setVisibility(View.VISIBLE);
        gameOverTextView.setText("Game Over !!");
        gameOverTextView.setTextSize(32);
        gameOverTextView.setTextColor(Color.RED);
        drawTextViewCenter(350, canvasBaseY + 750, gameOverTextView);
    }

    public void drawGameClear() {
        gameClearTextView.setVisibility(View.VISIBLE);
        gameClearTextView.setText("Game Clear !!");
        gameClearTextView.setTextSize(32);
        gameClearTextView.setTextColor(Color.BLUE);
        drawTextViewCenter(350, canvasBaseY + 750, gameClearTextView);
    }

    public void drawRetryButton() {
        retryButton.setVisibility(VISIBLE);
        scoreTextView.setTextSize(40);
        retryButton.setText("もう一回");
        drawViewCenter(350, canvasBaseY + 700, retryButton);
    }


}

