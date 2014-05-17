package com.matelli.carpet.activities;

import com.matelli.carpet.R;
import com.matelli.carpet.R.layout;
import com.matelli.carpet.R.menu;
import com.matelli.carpet.game.GameManager;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.ui.activity.BaseGameActivity;

public class EnfantActivity extends BaseGameActivity {


    private Camera camera;
    private static final int CAMERA_LARGEUR = 480;
    private static final int CAMERA_HAUTEUR = 320;

    @Override
    public Engine onLoadEngine() {

        camera = new Camera(0, 0, CAMERA_LARGEUR, CAMERA_HAUTEUR);
        return new Engine(new EngineOptions(true,
                EngineOptions.ScreenOrientation.LANDSCAPE,
                new RatioResolutionPolicy(CAMERA_LARGEUR, CAMERA_HAUTEUR),
                camera));

    }

    @Override
    public void onLoadResources() {
        GameManager.prepareManager(mEngine, this, camera);
        GameManager manager = GameManager.getInstance();

    }

    @Override
    public Scene onLoadScene() {
        final Scene scene = new Scene();
        return scene;
    }

    @Override
    public void onLoadComplete() {

    }
}
