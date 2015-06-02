package shared;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;

/**
 * Created by Faust on 02.06.2015.
 *
 */
public abstract class MyGame extends Game implements InputProcessor
{
	/*
		Variables
	 */

	protected static int gameWidth = 0, gameHeight = 0;  // Unknown on start
	protected static InputMultiplexer inputMultiplexer = null;

	/*
		Initialization
	 */

	protected abstract void setGameWidth();

	@Override
	public void create()
	{
		setGameWidth();

		if (gameWidth == 0)
			throw new RuntimeException("Game width is not set!");

		gameHeight = Gdx.graphics.getHeight() * gameWidth / Gdx.graphics.getWidth();

		// Setting input

		inputMultiplexer = new InputMultiplexer();
		Gdx.input.setInputProcessor(inputMultiplexer);
		Gdx.input.setCatchBackKey(true);
		inputMultiplexer.addProcessor(this);
	}

	/*
		Inputs
	 */

	public static void addInputProcessor(InputProcessor inputProcessor)
	{
		inputMultiplexer.addProcessor(inputProcessor);
	}

	public static void removeInputProcessor(InputProcessor inputProcessor)
	{
		inputMultiplexer.removeProcessor(inputProcessor);
	}

	@Override
	public boolean keyDown(int keycode)
	{
		return false;
	}

	@Override
	public boolean keyUp(int keycode)
	{
		return false;
	}

	@Override
	public boolean keyTyped(char character)
	{
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button)
	{
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button)
	{
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer)
	{
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY)
	{
		return false;
	}

	@Override
	public boolean scrolled(int amount)
	{
		return false;
	}

	/*
		Getters
	 */

	public static int getWidth()
	{
		return gameWidth;
	}

	public static int getHeight()
	{
		return gameHeight;
	}
}
