package com.ioa.msw.bmicalcuation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BMIActivity extends AppCompatActivity {

    TextView mBmiDisplay, mAgeDisplay, mWeightDisplay, mHeightDisplay, mBmiCategory, mGender;
    Button mGotoMain;
    Intent intent;

    ImageView mImageview;
    String mBmi;
    String Category;
    Float IntBmi;

    String Height;
    String Weight;
    Float IntHeight,IntWeight;

    RelativeLayout mBackground;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);
        getSupportActionBar().setElevation(0);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        getSupportActionBar().setTitle("Result");

        intent = getIntent();
        mBmiDisplay = findViewById(R.id.BmiDisplay);
        mBmiCategory = findViewById(R.id.BmiCategoryDisplay);
        mGotoMain = findViewById(R.id.GotoBtn);
        mImageview = findViewById(R.id.imageview);
        mGender = findViewById(R.id.GenderDisplay);
        mBackground = findViewById(R.id.contentLayout);

        Height = intent.getStringExtra("height");
        Weight = intent.getStringExtra("weight");

        IntHeight = Float.parseFloat(Height);
        IntWeight = Float.parseFloat(Weight);

        IntHeight = IntHeight/100;
        IntBmi = IntWeight/(IntHeight*IntHeight);

        mBmi = Float.toString(IntBmi);
        System.out.println(mBmi);

        if(IntBmi < 16){
            mBmiCategory.setText("Severe Thinness");
            mBackground.setBackgroundColor(Color.RED);
            mImageview.setImageResource(R.drawable.crosss);
        }
        else if(IntBmi < 16.9 && IntBmi > 16){
            mBmiCategory.setText("Moderate Thinness");
            mBackground.setBackgroundColor(R.color.halfwarn);
            mImageview.setImageResource(R.drawable.warning);
        }
        else if(IntBmi < 18.4 && IntBmi > 17){
            mBmiCategory.setText("Mild Thinness");
            mBackground.setBackgroundColor(R.color.halfwarn);
            mImageview.setImageResource(R.drawable.warning);
        }
        else if(IntBmi < 24.9 && IntBmi > 18.5){
            mBmiCategory.setText("Normal");
            mImageview.setImageResource(R.drawable.ok);
        }
        else if(IntBmi < 29.9 && IntBmi > 25){
            mBmiCategory.setText("Overweight");
            mBackground.setBackgroundColor(R.color.halfwarn);
            mImageview.setImageResource(R.drawable.warning);
        }
        else if(IntBmi < 34.9 && IntBmi > 30){
            mBmiCategory.setText("Obese Class I");
            mBackground.setBackgroundColor(R.color.halfwarn);
            mImageview.setImageResource(R.drawable.warning);
        }
        else{
            mBmiCategory.setText("Obese Class II");
            mBackground.setBackgroundColor(R.color.warn);
            mImageview.setImageResource(R.drawable.crosss);
        }

        mGender.setText(intent.getStringExtra("gender"));
        mBmiDisplay.setText(mBmi);

        mGotoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}