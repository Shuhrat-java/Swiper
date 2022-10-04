package uz.swiper;

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
        String[] colors = {"#9400D3", "#4B0082", "#0000FF", "#00FF00", "#FFFF00", "#FF7F00", "#FF0000"};
        for (int i = 0; i < colors.length; i++) {
            VPModel model = new VPModel();
            model.setColor(colors[i]);
            model.setColorName("RED");
            modelArrayList.add(model);
        }

        viewPager.setAdapter(new VPCustomAdapter(modelArrayList, ColorsActivity.this));
    }
}
