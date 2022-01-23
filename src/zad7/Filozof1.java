package zad7;

import java.util.concurrent.Semaphore ;

public class Filozof1 extends Thread {

    int MAX;
    Semaphore[] spozywanie;
    int obecny;

    public Filozof1(int nr, int MAX, Semaphore[] spozywanie) {
        obecny = nr;
        this.MAX = MAX;
        this.spozywanie = spozywanie;
    }

    public void run() {
        while (true) {

            System.out.println("Mysli nr: " + (obecny + 1));
            try {
                Thread.sleep((long) (3000 * Math.random()));
            } catch (InterruptedException e) {
            }
            spozywanie[obecny].acquireUninterruptibly();
            spozywanie[(int) ((obecny + 1) % MAX)].acquireUninterruptibly();

            System.out.println("Zaczyna jesc nr: " + (obecny + 1));
            try {
                Thread.sleep((long) (5000 * Math.random()));
            } catch (InterruptedException e) {
            }
            System.out.println("Konczy jesc nr: " + (obecny + 1));
            spozywanie[obecny].release();
            spozywanie[(int) ((obecny + 1) % MAX)].release();
        }
    }
}
