package shared.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import shared.MyGame;

/**
 * Created by Faust on 02.06.2015.
 *
 */
public abstract class MyGameRenderer
{

	protected SpriteBatch batch;
	protected ShapeRenderer shapeRenderer;
	protected OrthographicCamera camera;

	public MyGameRenderer ()
	{

		/*
			Camera
		 */

		camera = new OrthographicCamera();
		camera.setToOrtho(false, MyGame.getGameWidth(), MyGame.getGameHeight());

		/*
			Batch
		 */

		batch = new SpriteBatch();
		batch.setProjectionMatrix(camera.combined);

		/*
			Shape renderer
		 */

		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(camera.combined);
		shapeRenderer.setAutoShapeType(true);
	}

	public abstract void render (float delta);

	public abstract void reset ();
}