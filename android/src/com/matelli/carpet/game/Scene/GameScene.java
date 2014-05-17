package com.matelli.carpet.game.Scene;

import com.matelli.carpet.models.User;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.camera.hud.HUD;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.opengl.util.GLState;
import org.andengine.util.HorizontalAlign;

/**
 * Created by fl0 on 17/05/2014.
 */
public class GameScene extends BaseScene
{
    private HUD gameHUD;
    private User user;
    private Text scoreText;
    private Sprite dogSprite;

    GameScene(User user)
    {
        this.user = user;
    }


    private void createHUD()
    {

        gameHUD = new HUD();

        // CREATE SCORE TEXT
        scoreText = new Text(20, 420, resourcesManager.font, "Score: 0123456789", new TextOptions(HorizontalAlign.LEFT), vbom);
     //   scoreText.setAnchorCenter(0, 0);
        scoreText.setText("Score: " + this.user.getScore());
        gameHUD.attachChild(scoreText);


        camera.setHUD(gameHUD);
    }

    @Override
    public void createScene() {
        createBackground();
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
        attachChild(new Sprite(0, 0, resourcesManager.game_background_region, vbom)
        {
            @Override
            protected void preDraw(GLState pGLState, Camera pCamera)
            {
                super.preDraw(pGLState, pCamera);
                pGLState.enableDither();
            }
        });

        this.dogSprite = new Sprite(0,0, resourcesManager.game_pet_region, vbom);
        attachChild(this.dogSprite);


    }
}
