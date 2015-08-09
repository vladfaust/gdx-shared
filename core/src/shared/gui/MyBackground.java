package shared.gui;

/**
 * Created by Faust on 02.06.2015.
 * It's static due it's simple
 */
public class MyBackground
{
	private static float
			R = 0.5f,
			G = 0.5f,
			B = 0.5f,
			A = 1f;

	public static void set(float r, float g, float b, float a)
	{
		R = r;
		G = g;
		B = b;
		A = a;
	}

	public static float getR()
	{
		return R;
	}

	public static float getG()
	{
		return G;
	}

	public static float getB()
	{
		return B;
	}

	public static float getA()
	{
		return A;
	}
}
