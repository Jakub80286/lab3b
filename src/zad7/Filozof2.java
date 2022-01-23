package zad7;

import java.util.concurrent.Semaphore;

public class Filozof2 extends Filozof1 {

    public Filozof2(int nr, int MAX, Semaphore [] spozywanie) {
        super(nr, MAX, spozywanie);
    }

    public void run() {

        while (true) {
            System.out.println("Mysli nr: " + (obecny + 1));
            try {
                Thread.sleep((long) (3000 * Math.random()));
            } catch (InterruptedException e) {
            }
            if (obecny == 0) {
                spozywanie[(obecny + 1) % MAX].acquireUninterruptibly();
                spozywanie[obecny].acquireUninterruptibly();
            } else {
                spozywanie[obecny].acquireUninterruptibly();
                spozywanie[(obecny + 1) % MAX].acquireUninterruptibly();
            }

            System.out.println("Zaczyna jesc nr: " + (obecny + 1));
            try {
                Thread.sleep((long) (3000 * Math.random()));
            } catch (InterruptedException e) {
            }
            System.out.println("Konczy jesc nr:  " + (obecny + 1));
            spozywanie[obecny].release();
            spozywanie[(obecny + 1) % MAX].release();
        }
    }
}