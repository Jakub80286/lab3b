import zad5.Obraz;
import zad6.Julii;
import zad7.Filozof1;
import zad7.Filozof2;
import zad7.Filozof3;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main
    {
        public static void main(String args[]) throws IOException, InterruptedException {
//            int n = 1000;
//            MonteCarlo a = new MonteCarlo(0, 0, 2,  n);
//            MonteCarlo b = new MonteCarlo(2, 0, 4,  n);
//            MonteCarlo c = new MonteCarlo(0, 2, 2,  n);
//            MonteCarlo d = new MonteCarlo(2, 2, 4,  n);
//            a.run();
//            b.run();
//            c.run();
//            d.run();
//            try {
//                a.join();
//                b.join();
//                c.join();
//                d.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            double Pk = a.getWynik() + b.getWynik() + c.getWynik() + d.getWynik();
//            Pk = (Pk / ((double)n * 4)) * (2 * 2);
//            System.out.println("Przyblizone pole kola " + Pk);




//                    BufferedImage obraz;
//                    File input = new File("muchomor.jpg");
//                    obraz = ImageIO.read(input);
//                    int poziom = obraz.getWidth();
//                    int pion = obraz.getHeight();
//                    int polSzer = poziom / 2;
//                    int polWys = pion / 2;
//                    Obraz n1, n2, n3, n4;
//                    n1 = new Obraz(obraz, 0, 0, polSzer, polWys);
//                    n2 = new Obraz(obraz, polSzer, 0, poziom, polWys);
//                    n3 = new Obraz(obraz, 0, polWys, polSzer, pion);
//                    n4 = new Obraz(obraz, polSzer, polWys, poziom, pion);
//                    n1.start();
//                    n2.start();
//                    n3.start();
//                    n4.start();
//                    try {
//                        n1.join();
//                        n2.join();
//                        n3.join();
//                        n4.join();
//                    } catch (Exception e) {
//                    }
//                    File ouptut = new File("muchomorNegatyw.jpg");
//                    ImageIO.write(obraz, "jpg", ouptut);




//            long startTime = System.currentTimeMillis();
//
//            Julii thread0 = new Julii(0);
//            Julii thread1 = new Julii(1);
//            Julii thread2 = new Julii(2);
//            Julii thread3 = new Julii(3);
//
//            thread0.start();
//            thread1.start();
//            thread2.start();
//            thread3.start();
//
//            thread0.join();
//            thread1.join();
//            thread2.join();
//            thread3.join();








            int MAX = 100;
            int wybor;
            Semaphore[] widelec = new Semaphore[MAX];
            Scanner odpowiedz = new Scanner(System.in);

                System.out.println("Podaj ilość filozofów od 2 do 100:");
                MAX = odpowiedz.nextInt();

                System.out.println("Wybierz metode 1, 2 lub 3:");
                wybor = odpowiedz.nextInt();
                if (wybor == 1 || wybor == 2 || wybor == 3){
                    for (int i = 0; i < MAX; i++){
                        widelec[i] = new Semaphore(1);
                    }

                    for (int i = 0; i < MAX; i++){
                        switch(wybor){
                            case 1:  new Filozof1(i, MAX, widelec).start();
                                break;
                            case 2:  new Filozof2(i, MAX, widelec).start();
                                break;
                            case 3:  new Filozof3(i, MAX, widelec).start();
                                break;
                        }
                    }
                }

                }
            }

