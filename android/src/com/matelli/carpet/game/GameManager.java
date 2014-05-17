package com.matelli.carpet.game;


import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.ui.activity.BaseGameActivity;

/**
 * Created by fl0 on 17/05/2014.
 */
public class GameManager {

    private static final GameManager INSTANCE = new GameManager();
    public Engine engine;

    public BaseGameActivity activity;
    public Camera camera;
 //   public VertexBufferObjectManager vbom;

    //---------------------------------------------
    // TEXTURES & TEXTURE REGIONS
    //---------------------------------------------

    //---------------------------------------------
    // CLASS LOGIC
    //---------------------------------------------

    public void loadMenuResources()
    {
        loadMenuGraphics();
        loadMenuAudio();
    }

    public void loadGameResources()
    {
        loadGameGraphics();
        loadGameFonts();
        loadGameAudio();
    }

    private void loadMenuGraphics()
    {

    }

    private void loadMenuAudio()
    {

    }

    private void loadGameGraphics()
    {

    }

    private void loadGameFonts()
    {

    }

    private void loadGameAudio()
    {

    }

    public void loadSplashScreen()
    {

    }

    public void unloadSplashScreen()
    {

    }

    /**
     * @param engine
     * @param activity
     * @param camera
     * <br><br>
     * We use this method at beginning of game loading, to prepare Resources Manager properly,
     * setting all needed parameters, so we can latter access them from different classes (eg. scenes)
     */
    public static void prepareManager(Engine engine, BaseGameActivity activity, Camera camera /*, VertexBufferObjectManager vbom*/)
    {
        getInstance().engine = engine;
        getInstance().activity = activity;
        getInstance().camera = camera;
       // getInstance().vbom = vbom;
    }

    //---------------------------------------------
    // GETTERS AND SETTERS
    //---------------------------------------------

    public static GameManager getInstance()
    {
        return INSTANCE;
    }
}
