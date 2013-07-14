/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cachesimulator;

import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sijin
 */
public class Main {

    public static void t1() {

        // TODO code application logic here
        int[] execArray = {5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 55, 45, 30, 10};
        int[] restArray = {20, 15, 10, 5, 10};

        int execIndex = 0;
        int restIndex = 0;


        while (true) {

            try {


                int time = execArray[execIndex];
                System.out.println("Not sampling");
              //  System.out.println("exec " + time);
                Program.run(time);

                execIndex = (execIndex + 1) % execArray.length;

                try {
                    System.out.println("Not sampling");
                    //System.out.println("rest " + restArray[restIndex]);
                    Thread.sleep(restArray[restIndex] * 1000);

                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }

                restIndex = (restIndex + 1) % restArray.length;

            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }



        }
    }

    public static void t2(Thread thread) {
        try {
            int sleeptime = 5;
            try {
                thread.sleep(sleeptime * 1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            Program.runsample(sleeptime);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Thread thread1 = new Thread(new ThreadOneRunnable());
        thread1.start();

        while (true) {
            try {
                Thread.sleep(1 * 1000);
                Random randomGenerator = new Random();
                int random = randomGenerator.nextInt(20);
                if (random == 1) {
                    System.out.println("sampling starts");
                    Thread thread2 = new Thread(new ThreadTwoRunnable(thread1));
                    thread2.start();
                    Thread.sleep(5*1000);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }


        }
    }
}
