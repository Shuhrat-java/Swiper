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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.viewpager.widget.PagerAdapter;

public class VPCustomAdapter extends PagerAdapter {
    ArrayList<VPModel> list = new ArrayList<>();
    private Context mContext;
    private MediaPlayer player;
    public VPCustomAdapter(ArrayList<VPModel> vpModels, Context context) {
        this.list = vpModels;
        mContext = context;
        player = new MediaPlayer();
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

        TextView itemView = vpItem;
        itemView.setBackgroundColor(model.getColor());// #FF
        itemView.setText(model.getColorName());
        vpItem.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {

                try {
                    player.reset();
                    AssetFileDescriptor as = mContext.getAssets().openFd(model.getColorName().toLowerCase(Locale.ROOT)+".mp3");
                    player.setDataSource(as.getFileDescriptor(),as.getStartOffset(),as.getLength());
                    player.prepare();
                    player.start();
                } catch (IOException e) {
                    e.printStackTrace();
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
