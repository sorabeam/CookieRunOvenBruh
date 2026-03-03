package Beam.Media;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.HashMap;
import java.util.Objects;

public class JooxBox {
    public HashMap<String,String> playlist;
    public MediaPlayer mp;

    private static JooxBox instance;

    public static JooxBox getInstance() {
        if (instance == null)
            instance = new JooxBox();
        return instance;
    }

    public JooxBox(){
        playlist = new HashMap<>();
        playlist.put( "HeatWave" , "/HeatWaves.mp3" );
        playlist.put( "MS1" , "/MS1.mp3" );
    }

    public MediaPlayer play(String path, boolean isLoop,float volum) {
        path = playlist.get(path);
        Media media = new Media(Objects.requireNonNull(getClass().getResource(path)).toExternalForm());
        mp = new MediaPlayer(media);

        if(isLoop) mp.setCycleCount(MediaPlayer.INDEFINITE);
        mp.setVolume(Math.max(0,volum / 100.0));
        mp.play();

        return mp;
    }

    public void ChangeMusic(String paths, boolean isLoop,float volum){

        if (mp != null) {
            mp.stop();
            mp.dispose();
        }

        String path = playlist.get(paths);
        Media media = new Media(Objects.requireNonNull(getClass().getResource(path)).toExternalForm());

        mp = new MediaPlayer(media);
        if(isLoop) mp.setCycleCount(MediaPlayer.INDEFINITE);
        mp.setVolume(Math.max(0,volum / 100.0));
        mp.play();
    }
}
