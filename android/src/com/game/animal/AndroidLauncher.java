package com.game.animal;

import android.os.Bundle;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.github.anrwatchdog.ANRWatchDog;

import kw.mulitplay.game.GdxVideoTest;
import kw.mulitplay.game.GdxVideoTest1;

public class AndroidLauncher extends AndroidApplication {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new ANRWatchDog().setIgnoreDebugger(true).start();
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        initialize(new GdxVideoTest1(), config);
    }
}