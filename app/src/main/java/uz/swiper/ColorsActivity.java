package uz.swiper;

import android.graphics.Color;
import android.os.Bundle;

import java.lang.reflect.Modifier;
import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class ColorsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        ViewPager viewPager = findViewById(R.id.view_pager);

        ArrayList<VPModel> modelArrayList = new ArrayList<>();
        int[] colors = {Color.RED, Color.MAGENTA, Color.YELLOW, Color.GREEN,
                Color.BLUE, Color.CYAN, Color.BLACK};
        String[] colorNames = {"Red","Magenta","Yellow","Green","Blue","Cyan","Black"};
        for (int i = 0; i < colors.length; i++) {
            VPModel model = new VPModel();
            model.setColor(colors[i]);
            model.setColorName(colorNames[i]);
            modelArrayList.add(model);
        }

        viewPager.setAdapter(new VPCustomAdapter(modelArrayList, ColorsActivity.this));

    }
}
