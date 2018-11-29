package br.com.jpe.rgbtesting;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import br.com.jpe.rgbtesting.core.ColorConstants;
import br.com.jpe.rgbtesting.core.ColorSeekBarEventListener;

public class MainActivity extends AppCompatActivity implements ColorConstants {

    SeekBar seekBar_Red;
    SeekBar seekBar_Green;
    SeekBar seekBar_Blue;

    Button bt_ChangeActivity;

    Integer colorValue_Red = 0;
    Integer colorValue_Green = 0;
    Integer colorValue_Blue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar_Red = findViewById(R.id.sb_Red);
        seekBar_Green = findViewById(R.id.sb_Green);
        seekBar_Blue = findViewById(R.id.sb_Blue);

        bt_ChangeActivity = findViewById(R.id.bt_ChangeActivity);

        seekBar_Red.setProgress(colorValue_Red);
        seekBar_Green.setProgress(colorValue_Green);
        seekBar_Blue.setProgress(colorValue_Blue);

        seekBar_Red.setOnSeekBarChangeListener(new ColorSeekBarEventListener(){
            @Override
            public void run(Integer value) {
                colorValue_Red = value;
                updateButtonColor();
            }
        });

        seekBar_Green.setOnSeekBarChangeListener(new ColorSeekBarEventListener() {
            @Override
            public void run(Integer value) {
                colorValue_Green = value;
                updateButtonColor();
            }
        });

        seekBar_Blue.setOnSeekBarChangeListener(new ColorSeekBarEventListener() {
            @Override
            public void run(Integer value) {
                colorValue_Blue = value;
                updateButtonColor();
            }
        });
    }

    public void onClickChangeActivity(View v){
        Intent it = new Intent(this, ChangeColorActivity.class);
        it.putExtra(COLOR_R, colorValue_Red);
        it.putExtra(COLOR_G, colorValue_Green);
        it.putExtra(COLOR_B, colorValue_Blue);
        startActivity(it);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        updateButtonColor();
    }

    private void updateButtonColor(){
        Integer color = Color.rgb(colorValue_Red, colorValue_Green, colorValue_Blue);
        bt_ChangeActivity.setBackgroundColor(color);
    }

}
