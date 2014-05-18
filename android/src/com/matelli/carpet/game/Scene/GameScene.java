package com.matelli.carpet.game.Scene;

import android.util.Log;

import com.matelli.carpet.models.User;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.camera.hud.HUD;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.opengl.util.GLState;
import org.andengine.util.HorizontalAlign;
import org.andengine.util.color.Color;

/**
 * Created by fl0 on 17/05/2014.
 */
public class GameScene extends BaseScene
{
    private HUD gameHUD;
    private Text scoreText;
    private Sprite dogSprite;


    private User user;
    private Sprite carSprite;


    private void createHUD()
    {

        gameHUD = new HUD();

        Log.d("setting the score", "florianburel");
        // CREATE SCORE TEXT
        scoreText = new Text(1425, 74, resourcesManager.fonts[3], "Score: 0123456789", new TextOptions(HorizontalAlign.LEFT), vbom);
     //   scoreText.setAnchorCenter(0, 0);
        scoreText.setText("Score: " + this.user.getScore());

        gameHUD.attachChild(new Sprite(1400,50, resourcesManager.hud_background, vbom));
        gameHUD.attachChild(scoreText);




        camera.setHUD(gameHUD);
    }

    @Override
    public void createScene() {
        createBackground();

        createMovingElements();

        addCustomControls();

        createHUD();

    }

    private void createMovingElements() {

        AnimatedSprite sprite = new AnimatedSprite(215, 633, resourcesManager.game_pet_region, vbom);

        attachChild(sprite);

        sprite.animate(100);

        this.dogSprite = sprite;

        this.carSprite = new Sprite(1526, 467, resourcesManager.car_item, vbom);
        attachChild(this.carSprite);

    }

    private void addCustomControls() {
        Sprite homeBtn = new Sprite(54, 43, resourcesManager.home_button, vbom);
        attachChild(homeBtn);

        Sprite pauseBtn = new Sprite(204, 43, resourcesManager.pause_button, vbom);
        attachChild(pauseBtn);

        Sprite soundBtn = new Sprite(357, 43, resourcesManager.sound_button, vbom);
        attachChild(soundBtn);


    }

    @Override
    public void onBackKeyPressed()
    {
        System.exit(0);
    }

    @Override
    public SceneManager.SceneType getSceneType() {
        return SceneManager.SceneType.SCENE_GAME;
    }

    @Override
    public void disposeScene() {

    }

    private void createBackground()
    {
        // Attache the background


        this.user = User.createFakeUser();

        // Ajoute le bb
        attachChild(new Sprite(0, 0, resourcesManager.game_background_region, vbom)
        {
            @Override
            protected void preDraw(GLState pGLState, Camera pCamera)
            {
                super.preDraw(pGLState, pCamera);
                pGLState.enableDither();
            }
        });


        // this.dogSprite = new Sprite(0,0, resourcesManager.game_pet_region, vbom);









        Log.d("background created", "florianburel");
    }

}
