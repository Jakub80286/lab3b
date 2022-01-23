package zad6;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Julii extends Thread
{
    final static int N = 4096;
    final static int SKROT = 100;
    public static final double CX = -0.2;
    public static final double CY = 0.8225;
    static int[][] ustaw = new int[N][N];
    private int stan;

    public Julii(int stan)
    {
        this.stan = stan;
    }

    public void run()
    {
        int start = 0, koniec = 0;
        if (stan == 0)
        {
            start = 0;
            koniec = (N / 4) * 1;
        }
        else if (stan == 1)
        {
            start = (N / 4) * 1;
            koniec = (N / 4) * 2;
        }
        else if (stan == 2)
        {
            start = (N / 4) * 2;
            koniec = (N / 4) * 3;
        }
        else if (stan == 3)
        {
            start = (N / 4) * 3;
            koniec = N;
        }

        for (int i = start; i < koniec; i++)
        {
            for (int j = 0; j < N; j++)
            {
                double cr = (4.0 * i - 2 * N) / N;
                double ci = (4.0 * j - 2 * N) / N;
                double zr = cr, zi = ci;
                int k = 0;
                while (k < SKROT && zr * zr + zi * zi < 4.0)
                {
                    // z = c + z * z
                    double zamienr = CX + zr * zr - zi * zi;
                    double zamieni = CY + 2 * zr * zi;
                    zr = zamienr;
                    zi = zamieni;
                    k++;
                }
                ustaw[i][j] = k;
            }
        }

        BufferedImage img = new BufferedImage(N, N, BufferedImage.TYPE_INT_ARGB);

        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                int k = ustaw[i][j];
                float gdzie;
                if (k < SKROT)
                {
                    gdzie = (float) k / SKROT;
                }
                else
                {
                    gdzie = 0;
                }
                Color c = new Color(0, gdzie, 0);
                img.setRGB(i, j, c.getRGB());
            }
        }
        try
        {
            ImageIO.write(img, "PNG", new File("Julii.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}