public class Operation {
    private int x;
    private int y;

    public Operation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int addition() {
        return x + y;
    }

    public int substraction() {
        return x - y;
    }

    public int multiplication() {
        return x * y;
    }

    public float division() {
        if (y == 0)
            throw new IllegalArgumentException("IllegalArgumentException");
        else {
            float result = (float) x / y;
            return result;
        }
    }
}
