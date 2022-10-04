package uz.swiper;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class VPCustomAdapter extends PagerAdapter {
    ArrayList<VPModel> list = new ArrayList<>();
    private Context mContext;

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

        ViewGroup vpItem = (ViewGroup) LayoutInflater.from(mContext).inflate(R.layout.vp_item, container, false);

        View colorView = vpItem.findViewById(R.id.vp_item_color);
        colorView.setBackgroundColor(Color.parseColor(model.getColor()));// #FF

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
