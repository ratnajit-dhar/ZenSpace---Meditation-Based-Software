/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zenspace.pkgfinal;

// Java program to play an Audio
// file using Clip Object
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
  
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
  
public class AudioPlayer {
    Long currentFrame;
    Clip clip;
    AudioInputStream audioInputStream;
    public AudioPlayer(String filename)
        throws UnsupportedAudioFileException,
        IOException, LineUnavailableException 
    {
        // create AudioInputStream object
        //if(filename==null) filename="D:\\Java\\y2mate.com - Ed Sheeran  Perfect Lyrics.wav";
        audioInputStream = 
                AudioSystem.getAudioInputStream(new File(filename).getAbsoluteFile());
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);  
        //clip.stop();
        //clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void play(Long CurrentFrame)
    {
        clip.setMicrosecondPosition(CurrentFrame);
        clip.start();
    }
    public void pause()
    {
        System.out.println("zenspace.pkgfinal.AudioPlayer.pause()");
        this.currentFrame = 
        this.clip.getMicrosecondPosition();
        clip.stop();
    }
}
