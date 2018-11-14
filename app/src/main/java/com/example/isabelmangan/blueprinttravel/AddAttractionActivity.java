package com.example.isabelmangan.blueprinttravel;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.GoogleMap;


public class AddAttractionActivity extends AppCompatActivity {

    public class Attraction{
        String placeid;
        Boolean isReq;
        String duration;
    }

    private static final String TAG = "MyAttraction";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_attraction);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Create a new attraction object
        final Attraction addAttraction = new Attraction();


        //Autocomplete to get the place
        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);

        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
               Log.i(TAG, "Place: " + place.getName());
                //update attraction object with placeid
                addAttraction.placeid = place.getId();

                //Test placeid is correct
                Log.d(TAG, "Place ID: " + addAttraction.placeid);
            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
               // Log.i(TAG, "An error occurred: " + status);
            }
        });

        //Initiate a Switch for required state
        final Switch simpleSwitch = (Switch) findViewById(R.id.attraction_required_toggle);
        simpleSwitch.setChecked(false);

        //final RadioGroup rb = (RadioGroup) findViewById(R.id.radioGroup);

        //Add Attraction Button
        Button mAddAttractionButton = (Button) findViewById(R.id.add_attraction_button);
        mAddAttractionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //TODO: add attraction to list in database
                //Set Required bool from Switch isChecked
                addAttraction.isReq = simpleSwitch.isChecked();

                //Test switch status
                Log.d(TAG, "Required status: " + addAttraction.isReq);

                //TODO: Set Duration from radio buttons
                 RadioGroup rb = (RadioGroup) findViewById(R.id.radioGroup);
                 rb.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        //test checkedid
                        Log.d(TAG, "CheckedID: " + checkedId);

                        switch (checkedId) {
                            case R.id.attraction_duration_short_radio:
                                // to task
                                addAttraction.duration = "short";
                                break;
                            case R.id.attraction_duration_medium_radio:
                                // to task
                                addAttraction.duration = "medium";
                                break;
                            case R.id.attraction_duration_long_radio:
                                // to task
                                addAttraction.duration = "long";
                                break;
                        }
                    }
                });

                //Test duration result
                Log.d(TAG, "Duration: " + addAttraction.duration);

                //TODO: send database addAttraction object

                //TODO: Call edit trip activity
                //finishActivity(key);???
            }
        });

    }


}