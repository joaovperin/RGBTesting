package br.com.jpe.rgbtesting;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import br.com.jpe.rgbtesting.core.ColorConstants;

public class ChangeColorActivity extends AppCompatActivity implements ColorConstants {

    Integer colorValue_Red;
    Integer colorValue_Green;
    Integer colorValue_Blue;

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

        Toast.makeText(this, getRGBToastText(), Toast.LENGTH_LONG).show();
    }

    private String getRGBToastText() {
        return String.format("%s:\n[R:%3d G:%3d B:%3d]",
                getString(R.string.rgb_values),
                colorValue_Red, colorValue_Blue, colorValue_Green);
    }

    public void onClickBackButton(View v){
        finish();
    }

}
