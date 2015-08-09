package shared.utils;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Faust on 04.06.2015.
 *
 */
public class MyVector2Utils
{
	private static Vector2 temp = Vector2.Zero;

	/*
		Modifies bodies velocities when they collide
	 */

	public static void hitBodiesNoMass (Vector2 aPos, Vector2 bPos, Vector2 aVel, Vector2 bVel)
	{
		/*
		 * Via @ Jay Conrod
		 * http://stackoverflow.com/a/345863
		 */

		Vector2 collision = temp.set(aPos).sub(bPos).nor();

		// Get the components of the velocity vectors which are parallel to the collision.
		// The perpendicular component remains the same for both fish

		float aci = temp.set(aVel).dot(collision);
		float bci = temp.set(bVel).dot(collision);

		// Replace the collision velocity components with the new ones

		aVel.add(collision.scl(bci - aci));
		bVel.add(collision.scl(aci - bci));
	}

	/*
		Reflects a body velocity when hit anything
	 */

	public static void hitBodyWithSurface (Vector2 vel, Vector2 surfaceNormal)
	{
		/*
		 * Via @ Phrogz
		 * http://math.stackexchange.com/a/13263
		 */

		vel.sub(temp.set(surfaceNormal).scl(2f*vel.dot(surfaceNormal)));
	}

	/*
		Reflects a body velocity when hit to a circle arc point
	 */

	public static void hitBodyWithArcPoint (Vector2 vel, float degrees)
	{
		Vector2 normal = temp.set(Vector2.X).rotate(degrees).scl(-1f);
		hitBodyWithSurface(vel, normal);
	}
}
