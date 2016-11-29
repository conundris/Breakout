package com.breakout.ca2016.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.breakout.ca2016.Breakout;
import com.breakout.ca2016.Controller.MainGameController;
import com.breakout.ca2016.Entities.Board;

/**
 * Created by t00191944 on 15/11/2016.
 */
public class MainGameScreen implements Screen {

    private Breakout game;
    private OrthographicCamera cam;
    private SpriteBatch batch;

    public Board board;

    public MainGameScreen(Breakout game) {
        this.game = game;
    }

    private void init() {
        this.board = new Board(game);
        this.batch = new SpriteBatch();
        // Create Camera
        this.cam = new OrthographicCamera(Board.BOARD_WIDTH, Board.BOARD_HEIGHT);
        this.cam.setToOrtho(false, Board.BOARD_WIDTH, Board.BOARD_HEIGHT);
        Gdx.input.setInputProcessor(new MainGameController(board));
    }

    @Override
    public void show() {
        init();
    }

    @Override
    public void render(float delta)
    {
        // clear the screen
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // start the updating of all Objects
        this.board.update(delta);
        this.board.render(this.batch, this.cam);
        cam.update();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {
        Gdx.app.log("Test", "Pause");
    }

    @Override
    public void resume() {
        Gdx.app.log("Test", "Resume");
    }

    @Override
    public void hide() {
        Gdx.app.log("Test", "Hide Called");
    }

    @Override
    public void dispose() {
        Gdx.app.log("Test", "Dispose Called");
        this.board = null;
        this.batch = null;
        this.cam = null;
    }
}