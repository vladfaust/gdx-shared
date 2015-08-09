package shared.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;

import shared.MyGame;

/**
 * Created by Faust on 02.06.2015.
 * Shared GUI class
 */
public abstract class MyGUI
{
	/*
		Singleton
		Some GUI elements should be accessed everywhere
	 */

	private static MyGUI instance;

	/*
		Root elements
	 */

	private Stage stage;
	private Skin skin;
	private Stack stack;

	/*
		Initializer
	 */

	public MyGUI ()
	{
		instance = this;

		// Init things

		stage = new Stage();
		skin = new Skin();
		stack = new Stack();

		// Setting up the stage

		OrthographicCamera camera = new OrthographicCamera();
		camera.setToOrtho(false, MyGame.getGameWidth(), MyGame.getGameHeight());

		stage.getViewport().setCamera(camera);
		stage.getViewport().setWorldSize(MyGame.getGameWidth(), MyGame.getGameHeight());

		stack.setFillParent(true);
		stage.addActor(stack);

		// Adding input

		MyGame.addInputProcessor(stage);

		// Initialize fonts

		initFonts();
	}

	protected abstract void initFonts();

	/*
		Utilities
	 */

	public static void render(boolean clearScreen, float delta)
	{
		if (clearScreen) {
			Gdx.gl.glClearColor(MyBackground.getR(), MyBackground.getG(), MyBackground.getB(), MyBackground.getA());
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		}

		instance.stage.act(delta);
		instance.stage.draw();
	}

	public static void setScreen(MyGUIScreen screen)
	{
		if (screen == null)
			getStack().clear();
		else
			screen.setScreen();
	}

	/*
		Getters
	 */

	// These are static getters

	public static Stage getStage()
	{
		return instance.stage;
	}

	public static Skin getSkin()
	{
		return instance.skin;
	}

	public static Stack getStack()
	{
		return instance.stack;
	}
}
