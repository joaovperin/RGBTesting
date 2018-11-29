package br.com.jpe.rgbtesting;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.com.jpe.rgbtesting.core.ColorConstants;

public class ChangeColorActivity extends AppCompatActivity implements ColorConstants {

    Integer colorValue_Red = 150;
    Integer colorValue_Green = 30;
    Integer colorValue_Blue = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_color);

        // Get the Intent that started this activity and extract the string
        Intent it = getIntent();

        colorValue_Red = it.getIntExtra(COLOR_R, 0);
        colorValue_Green = it.getIntExtra(COLOR_G,0);
        colorValue_Blue = it.getIntExtra(COLOR_B,0);

        Integer color = Color.rgb(colorValue_Red, colorValue_Green, colorValue_Blue);
        getWindow().getDecorView().setBackgroundColor(color);
    }

    public void onClickBackButton(View v){
        finish();
    }

}
