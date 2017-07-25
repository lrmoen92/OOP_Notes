package common.helpers;

/**
 * Created by Logan.Moen on 5/31/2017.
 */
public class MathHelper extends CommonHelper{

    public static double E = 2.71;
    public static double PI = 3.14;

    public static int square(int val) {
        return val * val;
    }

    public static int simpleroot(int val)
    {
        int solution = 0;
        for(int x = 0; x <= val; x++){
            if((x * x) == val) {
                solution = x;
            }
        }
        return solution;
    }

    public static int cube(int val) {
        return (val * val * val);
    }

    public static int absval(int val) {
        if (val < 0)
            val = -val;
        return val;
    }


}
