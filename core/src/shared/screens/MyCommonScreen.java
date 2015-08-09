package shared.screens;

import com.badlogic.gdx.Screen;

import shared.gui.MyGUI;

/**
 * Created by Faust on 02.06.2015.
 *
 */
public abstract class MyCommonScreen implements MyScreen
{
	private static MyCommonScreen instance;

	public MyCommonScreen ()
	{
		instance = this;
	}

	@Override
	public void render(float delta)
	{
		MyGUI.render(true, delta);
	}

	/*
		Unused methods
	 */

	@Override
	public void show ()
	{

	}

	@Override
	public void resize (int width, int height)
	{

	}

	@Override
	public void pause ()
	{

	}

	@Override
	public void resume ()
	{

	}

	@Override
	public void hide ()
	{

	}

	@Override
	public void dispose ()
	{

	}

	public static MyScreen getInstance ()
	{
		return instance;
	}
}
