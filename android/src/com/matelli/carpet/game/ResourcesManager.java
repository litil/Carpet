package com.matelli.carpet.game;

import android.graphics.Color;
import android.util.Log;

import com.matelli.carpet.activities.EnfantActivity;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.input.touch.detector.ClickDetector;
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
import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;
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
    public TiledTextureRegion game_pet_region;

    private BuildableBitmapTextureAtlas buttonTextureAtlas;
    private BuildableBitmapTextureAtlas pause_buttonTextureAtlas;
    private BuildableBitmapTextureAtlas sound_buttonTextureAtlas;

    public ITextureRegion home_button;
    public ITextureRegion pause_button;
    public ITextureRegion sound_button;

    //public ITextureRegion game_car_region;

    public Font[] fonts;
    private BuildableBitmapTextureAtlas hud_background_atlas;
    public ITextureRegion hud_background;
    private BuildableBitmapTextureAtlas car_itemtextureAtlas;
    public ITextureRegion car_item;


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


        game_pet_atlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1753, 754, TextureOptions.BILINEAR);
        game_pet_region = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(game_pet_atlas, activity, "dog_Run.png", 3, 1);
        this.game_pet_atlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
        this.game_pet_atlas.load();


        FontFactory.setAssetBasePath("font/");
        final ITexture mainFontTexture = new BitmapTextureAtlas(activity.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);

        fonts = new Font[10];

        fonts[0] = FontFactory.createStrokeFromAsset(activity.getFontManager(), mainFontTexture, activity.getAssets(), "Gotham-Bold.otf", 75, true, Color.RED, 2, Color.BLACK);
        fonts[0].load();

        fonts[1] = FontFactory.createStrokeFromAsset(activity.getFontManager(), mainFontTexture, activity.getAssets(), "Gotham-BoldItalic.otf", 75, true, Color.RED, 2, Color.BLACK);
        fonts[1].load();

        fonts[2] = FontFactory.createStrokeFromAsset(activity.getFontManager(), mainFontTexture, activity.getAssets(), "Gotham-Book.otf", 75, true, Color.RED, 2, Color.BLACK);
        fonts[2].load();

        fonts[3] = FontFactory.createStrokeFromAsset(activity.getFontManager(), mainFontTexture, activity.getAssets(), "Gotham-BookItalic.otf", 75, true, Color.RED, 2, Color.BLACK);
        fonts[3].load();

        fonts[4] = FontFactory.createStrokeFromAsset(activity.getFontManager(), mainFontTexture, activity.getAssets(), "Gotham-Light.otf", 75, true, Color.RED, 2, Color.BLACK);
        fonts[4].load();

        fonts[5] = FontFactory.createStrokeFromAsset(activity.getFontManager(), mainFontTexture, activity.getAssets(), "Gotham-LightItalic.otf", 75, true, Color.RED, 2, Color.BLACK);
        fonts[5].load();

        fonts[6] = FontFactory.createStrokeFromAsset(activity.getFontManager(), mainFontTexture, activity.getAssets(), "Gotham-Medium.otf", 75, true, Color.RED, 2, Color.BLACK);
        fonts[6].load();

        fonts[7] = FontFactory.createStrokeFromAsset(activity.getFontManager(), mainFontTexture, activity.getAssets(), "Gotham-MediumItalic.otf", 75, true, Color.RED, 2, Color.BLACK);
        fonts[7].load();

        fonts[8] = FontFactory.createStrokeFromAsset(activity.getFontManager(), mainFontTexture, activity.getAssets(), "Gotham-Thin.otf", 75, true, Color.RED, 2, Color.BLACK);
        fonts[8].load();

        fonts[9] = FontFactory.createStrokeFromAsset(activity.getFontManager(), mainFontTexture, activity.getAssets(), "Gotham-ThinItalic.otf", 75, true, Color.RED, 2, Color.BLACK);
        fonts[9].load();

        // Chargmeent des button

        buttonTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 125, 126, TextureOptions.BILINEAR);
        home_button = BitmapTextureAtlasTextureRegionFactory.createFromAsset(buttonTextureAtlas, activity, "home_btn.png");
        buttonTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
        buttonTextureAtlas.load();


        pause_buttonTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 125, 126, TextureOptions.BILINEAR);
        pause_button = BitmapTextureAtlasTextureRegionFactory.createFromAsset(pause_buttonTextureAtlas, activity, "pause_btn.png");
        pause_buttonTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
        pause_buttonTextureAtlas.load();

        sound_buttonTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 125, 126, TextureOptions.BILINEAR);
        sound_button = BitmapTextureAtlasTextureRegionFactory.createFromAsset(sound_buttonTextureAtlas, activity, "sound_btn.png");
        sound_buttonTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
        sound_buttonTextureAtlas.load();

        hud_background_atlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 511, 129, TextureOptions.BILINEAR);
        hud_background = BitmapTextureAtlasTextureRegionFactory.createFromAsset(hud_background_atlas, activity, "hud_bg.png");
        hud_background_atlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
        hud_background_atlas.load();

        car_itemtextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1089, 576, TextureOptions.BILINEAR);
        car_item = BitmapTextureAtlasTextureRegionFactory.createFromAsset(car_itemtextureAtlas, activity, "car.png");
        car_itemtextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
        car_itemtextureAtlas.load();

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
