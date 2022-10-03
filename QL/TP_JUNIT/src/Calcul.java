public class Calcul {
    public int factorielle(int nb){
        if ((nb == 0) || (nb == 1)) {
            return 1;
        } else {
            return nb * factorielle(nb-1);
        }

    }

    public float division(int x , int y){
        if (y == 0)
            throw new IllegalArgumentException("IllegalArgumentException");
        else {
            float result = (float) x/y;
           return result;
        }
    }


}

