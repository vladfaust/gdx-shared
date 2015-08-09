package shared.game;


/**
 * Created by Faust on 02.06.2015.
 *
 */
public abstract class MyGameWorld
{
	/*
		Singleton
	 */

	private static MyGameWorld instance;

	public static MyGameWorld getInstance ()
	{
		return instance;
	}

	public MyGameWorld ()
	{
		instance = this;
	}

	/*
		Methods
	 */

	public abstract void update (float delta);
	public abstract void reset ();
}