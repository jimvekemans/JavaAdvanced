package ja.opgave1;

public class Star {
    private int y;
    private int x;
    private int deltaX;
    private int deltaY;

    public Star(int x, int y, int deltaX, int deltaY) {
        this.y = y;
        this.x = x;
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    public Star(Star star) {
        this(star.x, star.y, star.deltaX, star.deltaY);
    }

    public void move() {
        x += deltaX;
        y += deltaY;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
