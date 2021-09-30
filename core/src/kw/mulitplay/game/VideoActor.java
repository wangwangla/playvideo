package kw.mulitplay.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.video.VideoPlayer;
import com.badlogic.gdx.video.VideoPlayerCreator;

import java.io.FileNotFoundException;

public class VideoActor extends Group {
    VideoPlayer videoPlayer;
    private float hight = 0;
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
                float xxx = width / Gdx.graphics.getWidth();
                hight = height / xxx;
                VideoActor.this.setSize(width,hight);
                VideoActor.this.setY(640, Align.center);
            }
        });
        try {
            videoPlayer.play(Gdx.files.internal("libGDX - It's Good For You!.webm"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {

        videoPlayer.update();
        batch.flush();
        batch.getShader().begin();
        Texture frame = videoPlayer.getTexture();
        if (frame != null) batch.draw(frame, getX(), getY(), Gdx.graphics.getWidth(), hight);
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
