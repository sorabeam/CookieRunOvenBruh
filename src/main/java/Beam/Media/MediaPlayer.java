package Beam.Media;

import GameLogic.GameLogic;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;

import java.util.HashMap;

public class MediaPlayer {

    private final HashMap<String, String> playList;
    private final HashMap<String, AudioClip> sfxCache;
    private javafx.scene.media.MediaPlayer bgmPlayer;
    private static MediaPlayer instance;

    public static MediaPlayer getInstance() {
        if (instance == null)
            instance = new MediaPlayer();
        return instance;
    }

    public MediaPlayer(){
        playList = new HashMap<>();
        sfxCache = new HashMap<>();

        playList.put("GameOver", "/SOUND/GameOver.mp3");
        playList.put("HeatWave", "/SOUND/HeatWaves.mp3");
        playList.put("Hit", "/SOUND/Hit.mp3");
        playList.put("JUMP", "/SOUND/JUMP.mp3");
        playList.put("Cookies", "/SOUND/Cookies.mp3");
        playList.put("SLIDE", "/SOUND/SLIDE.mp3");
        playList.put("Click", "/SOUND/CLICK.mp3");
        playList.put("Lobby", "/SOUND/Lobby.mp3");
        playList.put("Pets", "/SOUND/PETS.mp3");
        playList.put("Jelly", "/SOUND/JellyCollectedSound.mp3");
        playList.put("Item", "/SOUND/ItemCollectedSound.mp3");

        playList.put("SoundMAP1", "/SOUND/SOUNDMAP1.mp3");
        playList.put("SoundMAP2", "/SOUND/SOUNDMAP2.mp3");
        playList.put("SoundMAP3", "/SOUND/SOUNDMAP3.mp3");

        // preload SFX
        preloadSFX("Hit");
        preloadSFX("JUMP");
        preloadSFX("SLIDE");
        preloadSFX("Click");
        preloadSFX("Jelly");
        preloadSFX("Item");
    }

    private void preloadSFX(String key) {

        String path = playList.get(key);
        if (path == null) return;

        var url = getClass().getResource(path);
        if (url == null) return;

        sfxCache.put(key, new AudioClip(url.toExternalForm()));
    }

    public void playBGM(String key, boolean loop) {

        if (bgmPlayer != null) {
            bgmPlayer.stop();
            bgmPlayer.dispose();
        }

        String path = playList.get(key);
        if (path == null) {
            System.out.println("BGM key not found: " + key);
            return;
        }

        Media media = new Media(getClass().getResource(path).toExternalForm());
        bgmPlayer = new javafx.scene.media.MediaPlayer(media);

        if (loop)
            bgmPlayer.setCycleCount(javafx.scene.media.MediaPlayer.INDEFINITE);

        bgmPlayer.setVolume(GameLogic.getMusicVolume() / 100.0);
        bgmPlayer.play();
    }

    public void playSFX(String key) {

        AudioClip clip = sfxCache.get(key);
        if (clip == null) {
            System.out.println("SFX not preloaded: " + key);
            return;
        }

        clip.setVolume(GameLogic.getSFXVolume() / 100.0);
        clip.play();
    }

    public void updateBGMVolume() {
        if (bgmPlayer != null) {
            bgmPlayer.setVolume(GameLogic.getMusicVolume() / 100.0);
        }
    }

    public void updateSFXVolume() {
        for (AudioClip clip : sfxCache.values()) {
            clip.setVolume(GameLogic.getSFXVolume() / 100.0);
        }
    }
}
