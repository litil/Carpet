package com.matelli.carpet.activities;

import java.io.IOException;

import org.andengine.engine.Engine;
import org.andengine.engine.LimitedFPSEngine;
import org.andengine.engine.camera.Camera;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.WakeLockOptions;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.ui.activity.BaseGameActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

import com.matelli.carpet.config.CarpetConstantes;
import com.matelli.carpet.game.ResourcesManager;
import com.matelli.carpet.game.Scene.SceneManager;

public class EnfantActivity extends BaseGameActivity {
	private static final String TAG = "EnfantActivity";

    private Camera camera;
    private ResourcesManager resourcesManager;

    private final static float SCREEN_RESOLUTION_WIDTH = 1920;
    private final static float SCREEN_RESOLUTION_HEIGHT = 1080;

    
    // BROADCAST
    IntentFilter filterSpeedLimitReachedReceiver = new IntentFilter(CarpetConstantes.BROADCAST_VITESSE_LIMITE_ATTEINTE);
    BroadcastReceiver speedLimitReachedReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			// update Chien  view 
			
			
			// send it to web services
			
			Log.d(TAG, "sdljkfdsjhf jksdhfjksdhfjksdhjk fdhskfhdjkshfkjsdhfjk sdf s");
			
		}
    };
    
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        registerReceiver(speedLimitReachedReceiver, filterSpeedLimitReachedReceiver);
    }
    
    
    
    
   
    
    
    
   @Override
    public Engine onCreateEngine(EngineOptions pEngineOptions)
    {
        Log.d("I'm here", "florianburel");
        return new LimitedFPSEngine(pEngineOptions, 60);
    }

    public EngineOptions onCreateEngineOptions()
    {


        camera = new Camera(0, 0, SCREEN_RESOLUTION_WIDTH, SCREEN_RESOLUTION_HEIGHT);
        EngineOptions engineOptions = new EngineOptions(true, ScreenOrientation.LANDSCAPE_FIXED, new RatioResolutionPolicy(SCREEN_RESOLUTION_WIDTH, SCREEN_RESOLUTION_HEIGHT), this.camera);
        engineOptions.getAudioOptions().setNeedsMusic(true).setNeedsSound(true);
        engineOptions.setWakeLockOptions(WakeLockOptions.SCREEN_ON);
        return engineOptions;
    }


    @Override
    public void onCreateResources(OnCreateResourcesCallback pOnCreateResourcesCallback) throws IOException
    {
        ResourcesManager.prepareManager(mEngine, this, camera, getVertexBufferObjectManager());
        resourcesManager = ResourcesManager.getInstance();
        pOnCreateResourcesCallback.onCreateResourcesFinished();
    }

    @Override
    public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback) //throws IOException
    {


        SceneManager.getInstance().createSplashScene(pOnCreateSceneCallback);
    }


    @Override
    public void onPopulateScene(Scene pScene, OnPopulateSceneCallback pOnPopulateSceneCallback) throws IOException
    {

        mEngine.registerUpdateHandler(new TimerHandler(2f, new ITimerCallback()
        {
            public void onTimePassed(final TimerHandler pTimerHandler)
            {
                mEngine.unregisterUpdateHandler(pTimerHandler);

                SceneManager.getInstance().createGameScene();
            }
        }));
        pOnPopulateSceneCallback.onPopulateSceneFinished();

    }

}
