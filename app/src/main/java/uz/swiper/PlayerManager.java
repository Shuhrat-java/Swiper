package uz.swiper;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

import java.io.IOException;
import java.util.Locale;

public class PlayerManager {
    MediaPlayer player;
    public PlayerManager(){
        player = new MediaPlayer();
    }
    public void play(Context context, VPModel model){
         try {
            player.reset();
            AssetFileDescriptor fileDescriptor = context.getAssets().openFd(model.getColorName().toLowerCase(Locale.ROOT) + ".mp3");
            player.setDataSource(fileDescriptor.getFileDescriptor(),
                    fileDescriptor.getStartOffset(),
                    fileDescriptor.getLength());
            player.prepare();
            player.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
