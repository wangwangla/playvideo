package kw.mulitplay.game;
/*******************************************************************************
 * Copyright 2014 See AUTHORS file.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/


import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.video.VideoPlayer;
import com.badlogic.gdx.video.VideoPlayerCreator;

import java.io.FileNotFoundException;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class GdxVideoTest extends Game {
    private VideoActor videoActor;
    private Stage stage;
    @Override
    public void create () {
        stage = new Stage();
        videoActor = new VideoActor();
        Gdx.input.setInputProcessor(stage);
        stage.addActor(videoActor);
    }

    @Override
    public void render () {
        stage.act();
        stage.draw();
    }

    @Override
    public void pause () {
        videoActor.pause();
    }

    @Override
    public void resume () {
        videoActor.resume();
    }

    @Override
    public void dispose () {
        videoActor.dispose();
    }
}
