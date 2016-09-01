package nus.me.common.game1;

import android.graphics.Bitmap;

/**
 * Created by nus on 31/08/16.
 */
public class ClassData {
    private int x = 0;
    private int y = 0;
    private Bitmap bitmap;
    private int p_x;
    private int p_y;


    public ClassData(int x, int y, Bitmap bitmap) {
        this.x = x;
        this.y = y;
        this.bitmap = bitmap;
        this.p_x = x;
        this.p_y = y;
    }

    public int getX() {
        return x;
    }




    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public int getP_x() {
        return p_x;
    }

    public void setP_x(int p_x) {
        this.p_x = p_x;
    }

    public int getP_y() {
        return p_y;
    }

    public void setP_y(int p_y) {
        this.p_y = p_y;
    }
}
