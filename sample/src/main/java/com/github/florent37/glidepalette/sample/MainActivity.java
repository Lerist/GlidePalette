package com.github.florent37.glidepalette.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.florent37.glidepalette.GlidePalette;

public class MainActivity extends AppCompatActivity {

    public static final String URL = "https://www.lepetiterudit.com/wp-content/uploads/2015/04/starry-night.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView) findViewById(R.id.image);
        TextView textVibrant = (TextView) findViewById(R.id.textVibrant);
        TextView textVibrantLight = (TextView) findViewById(R.id.textVibrantLight);
        TextView textVibrantDark = (TextView) findViewById(R.id.textVibrantDark);
        TextView textMuted = (TextView) findViewById(R.id.textMuted);
        TextView textMutedLight = (TextView) findViewById(R.id.textMutedLight);
        TextView textMutedDark = (TextView) findViewById(R.id.textMutedDark);

        Glide.with(this).load(URL)
                .centerCrop()
                .listener(GlidePalette.with(URL)
                        .use(GlidePalette.Profile.VIBRANT)
                        .intoBackground(textVibrant, GlidePalette.Swatch.RGB)
                        .intoTextColor(textVibrant, GlidePalette.Swatch.BODY_TEXT_COLOR)
                        .use(GlidePalette.Profile.VIBRANT_DARK)
                        .intoBackground(textVibrantDark, GlidePalette.Swatch.RGB)
                        .intoTextColor(textVibrantDark, GlidePalette.Swatch.BODY_TEXT_COLOR)
                        .use(GlidePalette.Profile.VIBRANT_LIGHT)
                        .intoBackground(textVibrantLight, GlidePalette.Swatch.RGB)
                        .intoTextColor(textVibrantLight, GlidePalette.Swatch.BODY_TEXT_COLOR)

                        .use(GlidePalette.Profile.MUTED)
                        .intoBackground(textMuted, GlidePalette.Swatch.RGB)
                        .intoTextColor(textMuted, GlidePalette.Swatch.BODY_TEXT_COLOR)
                        .use(GlidePalette.Profile.MUTED_DARK)
                        .intoBackground(textMutedDark, GlidePalette.Swatch.RGB)
                        .intoTextColor(textMutedDark, GlidePalette.Swatch.BODY_TEXT_COLOR)
                        .use(GlidePalette.Profile.MUTED_LIGHT)
                        .intoBackground(textMutedLight, GlidePalette.Swatch.RGB)
                        .intoTextColor(textMutedLight, GlidePalette.Swatch.BODY_TEXT_COLOR)

                        .intoCallBack(new GlidePalette.CallBack() {

                            @Override
                            public void onPaletteLoaded(Palette palette) {
                                //specific task
                            }
                        }))
                .into(imageView);
    }
}