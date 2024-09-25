package com.example.plant_care;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       SeekBar seekBar = findViewById(R.id.seekbar);
       TextView wateringFrequency = findViewById(R.id.watering_frequency_value);

        @SuppressLint("UseSwitchCompatOrMaterialCode") Switch switchNotification = findViewById(R.id.switch_notification);
        TextView tvSwitchStatus = findViewById(R.id.switch_status);
        RatingBar ratingBarHealth = findViewById(R.id.rating_bar_health);
        TextView tv_healthCondition = findViewById(R.id.tv_healthCondition);
        Button btn_save = findViewById(R.id.btn_save);
        EditText et_plantName = findViewById(R.id.et_plant_name);
        RadioGroup radioGroup = findViewById(R.id.radio_group);
        CheckBox checkBox_watering = findViewById(R.id.checkbox_watering);
        CheckBox checkbox_fertilizing = findViewById(R.id.checkbox_fertilizing);
        CheckBox checkbox_pruning = findViewById(R.id.checkbox_pruning);


        switchNotification.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    tvSwitchStatus.setText("Notification is Enabled!");
                } else {
                    tvSwitchStatus.setText("Notification is Disabled!");
                }
            }
        });



        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                wateringFrequency.setText("Watering Frequency: " + progress + " days");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        ratingBarHealth.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                if (rating == 1) {
                    tv_healthCondition.setText("Plant health Condition: Poor");
                } else if (rating == 2) {
                    tv_healthCondition.setText("Plant health Condition: Fair");
                } else if (rating == 3) {
                    tv_healthCondition.setText("Plant health Condition: Good");
                } else if (rating == 4) {
                    tv_healthCondition.setText("Plant health Condition: Excellent");
                }
            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(MainActivity.this, "Plant information is saved!", Toast.LENGTH_SHORT).show();

                radioGroup.clearCheck();
                checkBox_watering.setChecked(false);
                checkbox_fertilizing.setChecked(false);
                checkbox_pruning.setChecked(false);
                ratingBarHealth.setRating(0);
                switchNotification.setChecked(false);
                tv_healthCondition.setText(" ");
                seekBar.setProgress(0);
                et_plantName.setHint("Aloe Vera");


            }
        });


    }

}


