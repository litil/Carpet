package com.matelli.carpet.game.Scene;

import android.util.Log;

import com.matelli.carpet.game.ResourcesManager;
import com.matelli.carpet.models.User;

import org.andengine.engine.Engine;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder;
import org.andengine.ui.IGameInterface;

/**
 * Created by fl0 on 17/05/2014.
 */
public class SceneManager
{
    //---------------------------------------------
    // SCENES
    //---------------------------------------------

    private BaseScene splashScene;
    private BaseScene gameScene;
    private BaseScene loadingScene;

    //---------------------------------------------
    // VARIABLES
    //---------------------------------------------

    private static final SceneManager INSTANCE = new SceneManager();

    private SceneType currentSceneType = SceneType.SCENE_SPLASH;

    private BaseScene currentScene;

    private Engine engine = ResourcesManager.getInstance().engine;

    public enum SceneType
    {
        SCENE_SPLASH,
        SCENE_MENU,
        SCENE_GAME,
        SCENE_LOADING,
    }

    //---------------------------------------------
    // CLASS LOGIC
    //---------------------------------------------

    public void setScene(BaseScene scene)
    {
        engine.setScene(scene);
        currentScene = scene;
        currentSceneType = scene.getSceneType();
    }

    public void setScene(SceneType sceneType)
    {
        switch (sceneType)
        {
            case SCENE_MENU:
            case SCENE_GAME:
                setScene(gameScene);
                break;
            case SCENE_SPLASH:
                setScene(splashScene);
                break;
            case SCENE_LOADING:
                setScene(loadingScene);
                break;
            default:
                break;
        }
    }

    //---------------------------------------------
    // GETTERS AND SETTERS
    //---------------------------------------------

    public static SceneManager getInstance()
    {
        return INSTANCE;
    }

    public SceneType getCurrentSceneType()
    {
        return currentSceneType;
    }

    public BaseScene getCurrentScene()
    {
        return currentScene;
    }

    public void createSplashScene(IGameInterface.OnCreateSceneCallback pOnCreateSceneCallback)
    {
        ResourcesManager.getInstance().loadSplashScreen();
        splashScene = new SplashScene();
        currentScene = splashScene;
        pOnCreateSceneCallback.onCreateSceneFinished(splashScene);
    }

    public void createGameScene(User user)
    {


        try {
            ResourcesManager.getInstance().loadRessources();

            GameScene scene = new GameScene();

            gameScene = scene;

            setScene(gameScene);
            disposeSplashScene();
        } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            e.printStackTrace();
            Log.d("exception", "florianburel");

        }

    }

    private void disposeSplashScene()
    {
         ResourcesManager.getInstance().unloadSplashScreen();
        splashScene.disposeScene();
        splashScene = null;
    }
}
