package zad5;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Obraz extends Thread{
    BufferedImage obraz;
    int xx, yy, xs, ys;

    public Obraz(BufferedImage obraz, int xx, int yy, int xs, int ys){
        this.xx = xx;
        this.yy = yy;
        this.xs = xs;
        this.ys = ys;
        this.obraz = obraz;
    }

    @Override
    public void run() {
        for(int i = xx; i < xs; i++){
            for(int j = yy; j < ys; j++) {
                Color c = new Color(obraz.getRGB(i, j));
                int r = c.getRed();
                int g= c.getGreen();
                int b = c.getBlue();
                int R, G, B;
                R = 255 - r;
                G = 255 - g;
                B = 255 - b;
                Color newColor = new Color(R, G, B);
                obraz.setRGB(i, j, newColor.getRGB());
            }
        }
    }

}