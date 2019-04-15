package kr.insungjung.bmiapplication2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mTitle;
    TextView mUserBmi;
    TextView mUserBmiLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitle = findViewById(R.id.titleText);
        mUserBmi = findViewById(R.id.bmiText);
        mUserBmiLevel = findViewById(R.id.bmiLevelText);

        String sTitle = getIntent().getStringExtra("제목");
        String sUserBmi = getIntent().getStringExtra("사용자Bmi지수");
        String sUserBmiLevel = getIntent().getStringExtra("사용자Bmi레벨");

        mTitle.setText(sTitle);
        mUserBmi.setText(sUserBmi);
        mUserBmiLevel.setText(sUserBmiLevel);
    }
}
