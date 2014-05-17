package com.matelli.carpet.game;

import android.graphics.Color;
import android.util.Log;

import com.matelli.carpet.activities.EnfantActivity;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

/**
 * Created by fl0 on 17/05/2014.
 */
public class ResourcesManager
{
    //---------------------------------------------
    // VARIABLES
    //---------------------------------------------

    private static final ResourcesManager INSTANCE = new ResourcesManager();

    private static final int IMAGE_RES_WIDTH = 1920;
    private static final int IMAGE_RES_HEIGHT = 1080;

    public Engine engine;
    public EnfantActivity activity;
    public Camera camera;
    public VertexBufferObjectManager vbom;

    //---------------------------------------------
    // TEXTURES & TEXTURE REGIONS
    //---------------------------------------------

    public ITextureRegion splash_region;
    private BitmapTextureAtlas splashTextureAtlas;



    // Main game
    private BuildableBitmapTextureAtlas gameTextureAtlas;
    public ITextureRegion game_background_region;

    private  BuildableBitmapTextureAtlas game_pet_atlas;
    public ITextureRegion game_pet_region;

    //public ITextureRegion game_car_region;

    public Font font;




    //---------------------------------------------
    // CLASS LOGIC
    //---------------------------------------------


    public void loadRessources() throws ITextureAtlasBuilder.TextureAtlasBuilderException
    {
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/game/");

        gameTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), IMAGE_RES_WIDTH, IMAGE_RES_HEIGHT, TextureOptions.BILINEAR);
        game_background_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "Fond.png");
        this.gameTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
        this.gameTextureAtlas.load();

        game_pet_atlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), IMAGE_RES_WIDTH, IMAGE_RES_HEIGHT, TextureOptions.BILINEAR);
        game_pet_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(game_pet_atlas, activity, "Dog.png");
        this.game_pet_atlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
        this.game_pet_atlas.load();

        FontFactory.setAssetBasePath("font/");
        final ITexture mainFontTexture = new BitmapTextureAtlas(activity.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);

        font = FontFactory.createStrokeFromAsset(activity.getFontManager(), mainFontTexture, activity.getAssets(), "Gotham-Bold.ttf", 50, true, Color.WHITE, 2, Color.BLACK);
        font.load();



    }


    public void loadSplashScreen()
    {
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");

        splashTextureAtlas = new BitmapTextureAtlas(activity.getTextureManager(), IMAGE_RES_WIDTH, IMAGE_RES_HEIGHT, TextureOptions.BILINEAR);



        splash_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(splashTextureAtlas, activity, "splash.png", 0, 0);

        Log.d(splash_region.getWidth() + "" + splash_region.getHeight(), "florianburel");
        splashTextureAtlas.load();
    }

    public void unloadSplashScreen()
    {
        splashTextureAtlas.unload();
        splash_region = null;
    }

    /**
     * @param engine
     * @param activity
     * @param camera
     * @param vbom
     * <br><br>
     * We use this method at beginning of game loading, to prepare Resources Manager properly,
     * setting all needed parameters, so we can latter access them from different classes (eg. scenes)
     */
    public static void prepareManager(Engine engine, EnfantActivity activity, Camera camera, VertexBufferObjectManager vbom)
    {
        getInstance().engine = engine;
        getInstance().activity = activity;
        getInstance().camera = camera;
        getInstance().vbom = vbom;
    }

    //---------------------------------------------
    // GETTERS AND SETTERS
    //---------------------------------------------

    public static ResourcesManager getInstance()
    {
        return INSTANCE;
    }
}
