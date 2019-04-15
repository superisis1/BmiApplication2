package kr.insungjung.bmiapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BmiHelper extends AppCompatActivity {

    EditText mUserName;
    EditText mUserAge;
    EditText mUserWeight;
    EditText mUserTall;
    Button mBmiInputButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_helper);

        mUserName = findViewById(R.id.inputNameText);
        mUserAge = findViewById(R.id.inputAgeText);
        mUserWeight = findViewById(R.id.inputWeightText);
        mUserTall = findViewById(R.id.inputTallText);
        mBmiInputButton = findViewById(R.id.bmiInputButton);

        mBmiInputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sBmiLevel;

                String userName = mUserName.getText().toString();
                String title = String.format("%s 님의 BMI 지수입니다.", userName);

                String sUserWeight = mUserWeight.getText().toString();
                float dUserWeight = Float.parseFloat(sUserWeight);

                String sUserTall = mUserTall.getText().toString();
                float dUserTall = Float.parseFloat(sUserTall);

                float fCalBmi = dUserWeight / ((dUserTall / 100) * (dUserTall / 100));
                String sCalBmi = String.format("%.2f", fCalBmi);


                if (fCalBmi > 0 && fCalBmi <= 18.5) {
                    sBmiLevel = "저체중";
                } else if (fCalBmi < 25) {
                    sBmiLevel = "정상";
                } else if (fCalBmi < 30) {
                    sBmiLevel = "과체중";
                } else {
                    sBmiLevel = "비만";
                }

                Intent intent = new Intent(BmiHelper.this, MainActivity.class);
                intent.putExtra("제목", title);
                intent.putExtra("사용자Bmi지수", sCalBmi);
                intent.putExtra("사용자Bmi레벨", sBmiLevel);
                startActivity(intent);
                finish();
            }
        });
    }
}
