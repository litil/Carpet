package com.matelli.carpet.game.Scene;


import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;

import com.matelli.carpet.models.Chien;

/**
 * Created by fl0 on 17/05/2014.
 */
public class DogScene extends BaseScene {
    private final static int posX = 250;
    private final static int posY = 400;

    private Chien dog;
    private Sprite dogSprite;
    


    @Override
    public void createScene() {
    	dogSprite = new Sprite(0, 0, resourcesManager.splash_region, vbom)
        {
            @Override
            protected void preDraw(GLState pGLState, Camera pCamera)
            {
                super.preDraw(pGLState, pCamera);
                pGLState.enableDither();
            }
        };

        dogSprite.setScale(1f);
        dogSprite.setPosition(0, 0);
        attachChild(dogSprite);
    }

    @Override
    public void onBackKeyPressed() {

    }

    @Override
    public SceneManager.SceneType getSceneType() {
        return null;
    }

    @Override
    public void disposeScene() {

    }
}
