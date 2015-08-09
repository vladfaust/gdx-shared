package shared;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;

import shared.screens.MyScreen;

/**
 * Created by Faust on 02.06.2015.
 *
 */
public abstract class MyGame extends Game implements InputProcessor
{
	private static MyGame instance;

	/*
		Variables
	 */

	protected int gameWidth = 0, gameHeight = 0;  // Unknown on start
	private InputMultiplexer inputMultiplexer = null;
	private static MyScreen currentScreen;

	/*
		Initialization
	 */

	public void create (int width)
	{
		instance = this;

		// Dimensions

		gameWidth = width;
		gameHeight = Gdx.graphics.getHeight() * width / Gdx.graphics.getWidth();

		// Setting input

		inputMultiplexer = new InputMultiplexer();
		Gdx.input.setInputProcessor(inputMultiplexer);
		Gdx.input.setCatchBackKey(true);
		inputMultiplexer.addProcessor(this);
	}

	@Override
	public void setScreen (Screen screen)
	{
		super.setScreen(screen);
		currentScreen = (MyScreen) screen;
	}

	/*
		Inputs
	 */

	public static void addInputProcessor (InputProcessor inputProcessor)
	{
		instance.inputMultiplexer.addProcessor(inputProcessor);
	}

	public static void removeInputProcessor (InputProcessor inputProcessor)
	{
		instance.inputMultiplexer.removeProcessor(inputProcessor);
	}

	@Override
	public boolean keyDown (int keycode)
	{
		if (keycode == Input.Keys.BACK || keycode == Input.Keys.BACKSPACE) {
			currentScreen.onBackButtonPressed();
			return true;
		}
		return false;
	}

	@Override
	public boolean keyUp (int keycode)
	{
		return false;
	}

	@Override
	public boolean keyTyped (char character)
	{
		return false;
	}

	@Override
	public boolean touchDown (int screenX, int screenY, int pointer, int button)
	{
		return false;
	}

	@Override
	public boolean touchUp (int screenX, int screenY, int pointer, int button)
	{
		return false;
	}

	@Override
	public boolean touchDragged (int screenX, int screenY, int pointer)
	{
		return false;
	}

	@Override
	public boolean mouseMoved (int screenX, int screenY)
	{
		return false;
	}

	@Override
	public boolean scrolled (int amount)
	{
		return false;
	}

	/*
		Getters
	 */

	public static int getGameWidth ()
	{
		return instance.gameWidth;
	}

	public static int getGameHeight ()
	{
		return instance.gameHeight;
	}

	public static MyGame getInstance ()
	{
		return instance;
	}
}
