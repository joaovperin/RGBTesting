package br.com.jpe.rgbtesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

import br.com.jpe.rgbtesting.core.ColorSeekBarEventListener;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar_Red;
    SeekBar seekBar_Green;
    SeekBar seekBar_Blue;

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

        seekBar_Red.setProgress(colorValue_Red);
        seekBar_Green.setProgress(colorValue_Green);
        seekBar_Blue.setProgress(colorValue_Blue);

        seekBar_Red.setOnSeekBarChangeListener(new ColorSeekBarEventListener(){
            @Override
            public void run(Integer value) {
                colorValue_Red = value;
            }
        });

        seekBar_Green.setOnSeekBarChangeListener(new ColorSeekBarEventListener() {
            @Override
            public void run(Integer value) {
                colorValue_Green = value;
            }
        });

        seekBar_Blue.setOnSeekBarChangeListener(new ColorSeekBarEventListener() {
            @Override
            public void run(Integer value) {
                colorValue_Blue = value;
            }
        });
    }

    public void onClickChangeActivity(View v){
        String txt = String.format("Trocando de activity!\n[RGB = %d,%d,%d]",
                colorValue_Red, colorValue_Green, colorValue_Blue);
        Toast.makeText(this, txt, Toast.LENGTH_LONG).show();
    }

}
