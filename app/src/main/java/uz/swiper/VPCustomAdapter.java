package uz.swiper;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.viewpager.widget.PagerAdapter;

public class VPCustomAdapter extends PagerAdapter {

    ArrayList<VPModel> list = new ArrayList<>();
    private Context mContext;
    private ClickListener ls;

    public void setPagerClickListener(ClickListener listener) {
        ls = listener;
    }

    public VPCustomAdapter(ArrayList<VPModel> vpModels, Context context) {
        this.list = vpModels;
        mContext = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        VPModel model = list.get(position);

        TextView vpItem = (TextView) LayoutInflater.from(mContext).inflate(R.layout.vp_item, container, false);

        vpItem.setBackgroundColor(model.getColor());// #FF
        vpItem.setText(model.getColorName());

        vpItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ls != null) {
                    ls.onPagerItemClick(model);
                }
            }
        });

        container.addView(vpItem);

        return vpItem;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
