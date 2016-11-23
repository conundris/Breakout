package com.breakout.ca2016;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.breakout.ca2016.Screens.MainGameScreen;
import com.breakout.ca2016.Screens.MainMenuScreen;

public class Breakout extends Game {

	public static boolean DEBUG = false;

	private static MainGameScreen mainGameScreen;
	private static MainMenuScreen mainMenuScreen;

	public Screen getScreenType(ScreenType screenType){
		switch(screenType){
			case MainMenu:
				return mainMenuScreen;
			case MainGame:
				return mainGameScreen;
			default:
				return mainGameScreen;
		}
	}

	@Override
	public void create () {
		// Creating Creators
		mainGameScreen = new MainGameScreen(this);
		mainMenuScreen = new MainMenuScreen(this);
		setScreen(mainMenuScreen);
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		mainGameScreen.dispose();
		mainMenuScreen.dispose();
	}
}
