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
	 */

	private static MyGUI instance;
	public static MyGUI instance()
	{
		return instance;
	}

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
		camera.setToOrtho(false, MyGame.getWidth(), MyGame.getHeight());

		stage.getViewport().setCamera(camera);
		stage.getViewport().setWorldSize(MyGame.getWidth(), MyGame.getHeight());

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

	public void render(boolean clearScreen, float delta)
	{
		if (clearScreen) {
			Gdx.gl.glClearColor(MyBackground.getR(), MyBackground.getG(), MyBackground.getB(), MyBackground.getA());
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		}

		stage.act(delta);
		stage.draw();
	}

	public static void setScreen(MyGUIScreen screen)
	{
		screen.setScreen();
	}

	/*
		Getters
	 */

	public Stage getStage()
	{
		return stage;
	}

	public Skin getSkin()
	{
		return skin;
	}

	public Stack getStack()
	{
		return stack;
	}
}
