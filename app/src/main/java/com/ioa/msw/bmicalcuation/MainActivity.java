package com.ioa.msw.bmicalcuation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView mCurrentHeight;
    TextView mCurrentWeight, mCurrentAge;
    ImageView mIncrementAge, mDecrementAge, mIncrementWeight, mDecrementWeight;
    Button mCalculateBmi;
    SeekBar mSeekbarForHeight;
    RelativeLayout mMale, mFemale;

    int intWeight = 55;
    int intAge = 22;
    int CurrentProgress;
    String mIntProgress = "170";
    String typeRofUser = "0";
    String Weight2 = "55";
    String Age2 = "22";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        mCurrentAge = findViewById(R.id.CurrentAge);
        mCurrentWeight = findViewById(R.id.CurrentWeight);
        mCurrentHeight = findViewById(R.id.CurrentHeight);
        mIncrementAge = findViewById(R.id.IncrementAge);
        mDecrementAge = findViewById(R.id.DecrementAge);
        mIncrementWeight = findViewById(R.id.IncrementWeight);
        mDecrementWeight = findViewById(R.id.DecrementWeight);
        mCalculateBmi = findViewById(R.id.CalculateBmi);
        mSeekbarForHeight = findViewById(R.id.SeekbarForHeight);
        mMale = findViewById(R.id.Male);
        mFemale = findViewById(R.id.Female);

        mMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalefocus));
                mFemale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalefocus));
                typeRofUser = "Male";
            }
        });

        mFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFemale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalefocus));
                mMale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalefocus));
                typeRofUser = "Female";
            }
        });

        mSeekbarForHeight.setMax(300);
        mSeekbarForHeight.setProgress(170);
        mSeekbarForHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                CurrentProgress = progress;
                mIntProgress = String.valueOf(CurrentProgress);
                mCurrentHeight.setText(mIntProgress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mIncrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intWeight = intWeight + 1;
                Weight2 = String.valueOf(intWeight);
                mCurrentWeight.setText(Weight2);
            }
        });

        mIncrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               intAge = intAge + 1;
               Age2 = String.valueOf(intAge);
               mCurrentAge.setText(Age2);
            }
        });

        mDecrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intWeight = intWeight - 1;
                Weight2 = String.valueOf(intWeight);
                mCurrentWeight.setText(Weight2);
            }
        });

        mDecrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intAge = intAge - 1;
                Age2 = String.valueOf(intAge);
                mCurrentAge.setText(Age2);
            }
        });

        mCalculateBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(typeRofUser.equals("0")){
                    Toast.makeText(getApplicationContext(), "Select Your Gender First", Toast.LENGTH_SHORT).show();
                }
                else if(mIntProgress.equals("0")){
                    Toast.makeText(getApplicationContext(), "Select Your Height First", Toast.LENGTH_SHORT).show();
                }
                else if(intAge==0 || intAge < 0){
                    Toast.makeText(getApplicationContext(), "Age is Incorrect", Toast.LENGTH_SHORT).show();
                }
                else if(intWeight==0 || intWeight < 0){
                    Toast.makeText(getApplicationContext(),"Weight Is Incorrect",Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(MainActivity.this, BMIActivity.class);
                    intent.putExtra("gender", typeRofUser);
                    intent.putExtra("height",mIntProgress);
                    intent.putExtra("weight",Weight2);
                    intent.putExtra("age", Age2);
                    startActivity(intent);
                }
            }
        });
    }
}