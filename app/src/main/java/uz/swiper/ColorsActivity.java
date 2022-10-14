package uz.swiper;

import android.content.res.AssetFileDescriptor;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Locale;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class ColorsActivity extends AppCompatActivity {
    PlayerManager player = new PlayerManager();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        ViewPager viewPager = findViewById(R.id.view_pager);

        ArrayList<VPModel> modelArrayList = new ArrayList<>();

        int[] colors = {Color.RED, Color.MAGENTA, Color.YELLOW, Color.GREEN,
                Color.BLUE, Color.CYAN, Color.BLACK};

        String[] colorNames = {"Red", "Magenta", "Yellow", "Green", "Blue", "Cyan", "Black"};

        for (int i = 0; i < colors.length; i++) {

            VPModel model = new VPModel();
            model.setColor(colors[i]);
            model.setColorName(colorNames[i]);

            modelArrayList.add(model);
        }

        VPCustomAdapter vpCustomAdapter = new VPCustomAdapter(modelArrayList, ColorsActivity.this);

        vpCustomAdapter.setPagerClickListener(new ClickListener() {
            @Override
            public void onPagerItemClick(VPModel model) {
                player.play(ColorsActivity.this, model);
            }
        });
        viewPager.setAdapter(vpCustomAdapter);

    }
}
