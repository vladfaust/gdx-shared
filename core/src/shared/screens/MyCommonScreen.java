package shared.screens;

import com.badlogic.gdx.Screen;

import shared.gui.MyGUI;

/**
 * Created by Faust on 02.06.2015.
 *
 */
public abstract class MyCommonScreen implements Screen
{
	@Override
	public void render(float delta)
	{
		MyGUI.instance().render(true, delta);
	}

	abstract public void onBackButtonPressed ();

	@Override
	public void resize(int width, int height)
	{

	}

	@Override
	public void pause()
	{

	}

	@Override
	public void resume()
	{

	}

	@Override
	public void dispose()
	{

	}
}
