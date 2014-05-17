package com.matelli.carpet.fragments;

import java.util.Locale;

import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.matelli.carpet.R;
import com.matelli.carpet.activities.ConducteurActivity;
import com.matelli.carpet.activities.EnfantActivity;
import com.matelli.carpet.utils.FakeDataHelper;

/**
 * Fragment that appears in the "content_frame", shows a planet
 */
public class ConducteurFragment extends Fragment {
	ImageView buttonPlayGame; 
	public static final String SCREEN_INDEX = "screen_index";
	Activity currentActivity;

	public ConducteurFragment() {
		// Empty constructor required for fragment subclasses
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		currentActivity = this.getActivity();

		View rootView = inflater.inflate(R.layout.fragment_conducteur, container, false);
		int i = getArguments().getInt(SCREEN_INDEX);
		String entryTitle = getResources().getStringArray(R.array.menu_entry)[i];

		int imageId = getResources().getIdentifier(entryTitle.toLowerCase(Locale.getDefault()), "drawable", getActivity().getPackageName());
		((ImageView) rootView.findViewById(R.id.image)).setImageResource(imageId);
		getActivity().setTitle(entryTitle);


		// got to EnfantActivity
		buttonPlayGame = (ImageView) rootView.findViewById(R.id.play_game);
		buttonPlayGame.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent intent = new Intent(currentActivity, EnfantActivity.class);
				currentActivity.startActivity(intent);
			}
		});


		return rootView;
	}
}
