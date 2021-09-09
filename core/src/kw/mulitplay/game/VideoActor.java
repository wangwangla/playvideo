package kw.mulitplay.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.video.VideoPlayer;
import com.badlogic.gdx.video.VideoPlayerCreator;

import java.io.FileNotFoundException;

public class VideoActor extends Actor {
    VideoPlayer videoPlayer;
    public VideoActor(){
        setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        videoPlayer = VideoPlayerCreator.createVideoPlayer();
        videoPlayer.setOnCompletionListener(new VideoPlayer.CompletionListener() {
            @Override
            public void onCompletionListener (FileHandle file) {
                Gdx.app.log("VideoTest", file.name() + " fully played.");


            }
        });
        videoPlayer.setOnVideoSizeListener(new VideoPlayer.VideoSizeListener() {
            @Override
            public void onVideoSize (float width, float height) {
                Gdx.app.log("VideoTest", "The video has a size of " + width + "x" + height + ".");
            }
        });
        try {
//            videoPlayer.play(Gdx.files.internal("libGDX - It's Good For You!.webm"));
            videoPlayer.play(Gdx.files.internal("1.mp4"));
        } catch (FileNotFoundException e) {
            System.out.println("Oh no!");
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
//        if (Gdx.input.justTouched()) {
//            try {
//                videoPlayer.play(Gdx.files.internal("libGDX - It's Good For You!.webm"));
//            } catch (FileNotFoundException e) {
//                System.out.println("Oh no!");
//            }
//        }


        super.draw(batch, parentAlpha);
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        videoPlayer.update();
        Texture frame = videoPlayer.getTexture();
        if (frame != null) batch.draw(frame, getX(), getY(), Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

    }

    public void pause () {
        videoPlayer.pause();
    }

    public void resume () {
        videoPlayer.resume();
    }

    public void dispose () {
        videoPlayer.dispose();
    }
}
