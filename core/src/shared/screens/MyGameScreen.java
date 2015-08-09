package shared.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import shared.game.MyGameRenderer;
import shared.game.MyGameWorld;
import shared.gui.MyBackground;
import shared.gui.MyGUI;

/**
 * Created by Faust on 02.06.2015.
 *
 */
public abstract class MyGameScreen implements MyScreen
{
	/*
		Variables
	 */

	private static MyGameScreen instance;
	private MyGameWorld gameWorld;
	private MyGameRenderer gameRenderer;

	/*
		Constructor, MUST be overridden
	 */

	public MyGameScreen (MyGameWorld gameWorld, MyGameRenderer gameRenderer)
	{
		instance = this;
		this.gameWorld = gameWorld;
		this.gameRenderer = gameRenderer;
	}

	@Override
	public void show ()
	{
		gameWorld.reset();
		gameRenderer.reset();
	}

	@Override
	public void render (float delta)
	{
		// Firstly clear screen & fill with a color

		Gdx.gl.glClearColor(MyBackground.getR(), MyBackground.getG(), MyBackground.getB(), MyBackground.getA());
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// Update the world

		gameWorld.update(delta);

		// Then draw it

		gameRenderer.render(delta);

		// And HUD

		MyGUI.render(false, delta);
	}

	/*
		Overridden and unused methods
	 */

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

	public static MyGameScreen getInstance ()
	{
		return instance;
	}
}