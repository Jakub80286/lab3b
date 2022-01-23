package zad4;

public class MonteCarlo extends Thread
{
    int n;
    double wynik = 0;
    int xx, yy, xS;

    public MonteCarlo(int xx, int yy, int xS, int n)
    {
        this.xx = xx;
        this.yy = yy;
        this.xS = xS;
        this.xS = xS;
        this.n = n;
    }

    public void run()
    {
        int wKolo = 0;

        for(int i = 0; i < n; i++)
        {
            double x = Math.random();
            double y = Math.random();

            if (x * x + y * y <= 1)
            {
                wKolo++;
            }
        }

        wynik = wKolo;
    }

    public double getWynik()
    {
        return this.wynik;
    }
}