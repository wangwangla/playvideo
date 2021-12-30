package kw.mulitplay.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.video.VideoPlayer;
import com.badlogic.gdx.video.VideoPlayerCreator;

import java.io.FileNotFoundException;

public class VideoActor extends Group {
    VideoPlayer videoPlayer;
    private float hight = 0;
    private float wight = 0;
    private float xx;
    private float yy;
    public VideoActor(){
        setSize(GdxVideoTest1.wid,GdxVideoTest1.hig);
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
                float v1 = 720.0F / 1280.0F;
                float wid = GdxVideoTest1.wid;
                float hig = GdxVideoTest1.hig;
                float v2 = wid / hig;
                if(v2 > v1){
                    //宽
                    float v = wid / 720.0F;
                    hight = height * v;
                    wight = wid;
                    yy = (hig - hight)/2;
                    xx = 0;
                }else {
                    //fei
                    float v = hig / 1280.0F;
                    wight = width * v;
                    hight = hig;
                    xx = (wid - wight)/2;
                    yy = 0;
                }
            }
        });
        try {
            videoPlayer.play(Gdx.files.internal("x.webm"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch,1);
        videoPlayer.update();
        batch.flush();
        batch.getShader().begin();
        Texture frame = videoPlayer.getTexture();
        if (frame != null) batch.draw(frame, xx, yy, wight,hight);
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
