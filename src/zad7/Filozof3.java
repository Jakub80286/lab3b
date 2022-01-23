package zad7;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Filozof3 extends Filozof1{

    Random losuj;

    public Filozof3(int nr, int MAX, Semaphore[] widelec){
        super(nr, MAX, widelec);
        losuj = new Random(obecny);
    }

    public void run ( ) {
        while ( true ) {
            System.out.println ( "Mysli nr:  " + (obecny + 1)) ;
            try {
                Thread.sleep ( ( long ) (3000 * Math.random( ) ) ) ;
            } catch ( InterruptedException e ) {
            }

            int strona = losuj.nextInt ( 2 ) ;
            boolean podnioslDwaWidelce = false ;
            do {
                if ( strona == 0) {
                    spozywanie[obecny].acquireUninterruptibly ( ) ;
                    if( ! ( spozywanie[ (obecny +1)%MAX].tryAcquire ( ) ) ) {
                        spozywanie[obecny].release ( ) ;
                    } else {
                        podnioslDwaWidelce = true ;
                    }
                } else {
                    spozywanie[(obecny +1)%MAX].acquireUninterruptibly ( ) ;
                    if ( ! (spozywanie[obecny].tryAcquire ( ) ) ) {
                        spozywanie[(obecny +1)%MAX].release ( ) ;
                    } else {
                        podnioslDwaWidelce = true ;
                    }
                }
            } while (!podnioslDwaWidelce) ;
            System.out.println ( "Zaczyna jesc nr:  " + (obecny + 1)) ;
            try {
                Thread.sleep ( ( long ) (3000 * Math.random( ) ) ) ;
            } catch ( InterruptedException e ) {
            }
            System.out.println ( "Konczy jesc nr:  " + (obecny + 1)) ;
            spozywanie[obecny].release ( ) ;
            spozywanie[ (obecny +1)%MAX].release ( ) ;
        }
    }
}