package com.matelli.carpet.activities;

import com.matelli.carpet.R;
import com.matelli.carpet.R.id;
import com.matelli.carpet.R.layout;
import com.matelli.carpet.R.menu;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends RoboActivity {
	private static final String TAG = "WelcomeActivity";
	
	@InjectView(R.id.button_goto_enfant)		Button gotoEnfant; 
	@InjectView(R.id.button_goto_conducteur)	Button gotoConducteur; 
	
	private Activity currentActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        currentActivity = this;
        
        // got to EnfantActivity
        gotoEnfant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	Intent intent = new Intent(currentActivity, EnfantActivity.class);
            	currentActivity.startActivity(intent);
            }
        });
        
     // got to ConducteurActivity
        gotoConducteur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	Intent intent = new Intent(currentActivity, ConducteurActivity.class);
            	currentActivity.startActivity(intent);
            }
        });
        
        
    }

    
    
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.welcome, menu);
        return true;
    }
    
}
