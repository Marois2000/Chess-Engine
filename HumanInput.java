import java.util.*;

public class HumanInput {
    public int startX;
    public int startY;
    public int endX;
    public int endY;
    public boolean gettingEnd = false;

    public HumanInput() {

    }

    public void input(int x, int y) {

        if (gettingEnd && x == startX && y == startY) {
            gettingEnd = false;
            startX = -1;
            startY = -1;
        }
        if (gettingEnd) {
            endX = x;
            endY = y;
        }

        if (!gettingEnd) {
            startX = x;
            startY = y;
            gettingEnd = true;
        }


    }

    public void reset() {
        startX = -1;
        startY = -1;
        endX = -1;
        endY = -1;
        gettingEnd = false;
    }

    public boolean allIn() {
        if (startX > 0 && startY > 0 && endX > 0 && endY > 0) {
            return true;
        }

        return false;
    }
}
