/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cachesimulator;

import communication.AccessDatabase;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sijin
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void runsample(int time) throws IOException {
        // TODO code application logic here


        int temp = 3000;//Integer.parseInt(args[0]);

        Object[] a = new Object[temp];
        for (int i = 0; i < temp; i++) {

            a[i] = new int[temp];

        }


        long timeStart = System.currentTimeMillis();
//        for (int i = 0; i < 1000000000; i++) {

//            for (int j = 0; j < 100000000; j++) {

        while (true) {

            long timeNow = System.currentTimeMillis();

            if((timeNow - timeStart)/1000 > time){
               break;
            }

            Random randomGenerator = new Random();

            int random = randomGenerator.nextInt(10);

            int run = 0;//randomGenerator.nextInt(random + 1);

            if (run == 0) {

                long startTime = System.currentTimeMillis();

                Program(a, temp);

                long endTime = System.currentTimeMillis();
                long totalTime = endTime - startTime;
               // System.out.println("Time now " + endTime + " execution time " + totalTime);

                FileWriter fw = new FileWriter("CaseTwoSample.csv", true);
                PrintWriter pw = new PrintWriter(fw);

                //Write to file for the second row
                pw.print(endTime);
                pw.print(",");
                pw.print(totalTime);
                pw.print("\n");


                AccessDatabase ad = new AccessDatabase();

                Timestamp t = new Timestamp(endTime);
                try {
                    ad.writeCacheTable(t, (int) totalTime);
                } catch (Exception ex) {
                    Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
                }

                //Flush the output to the file
                pw.flush();

                //Close the Print Writer
                pw.close();

                //Close the File Writer
                fw.close();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {

                long startTime = System.currentTimeMillis();

//                    try {
//                        run = randomGenerator.nextInt(20);
//                        Thread.sleep(run * 1000);
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//                    }

                long endTime = System.currentTimeMillis();
                long totalTime = endTime - startTime;
             //   System.out.println("Time now " + endTime + " execution time " + totalTime);

                FileWriter fw = new FileWriter("CaseTwoSample.csv", true);
                PrintWriter pw = new PrintWriter(fw);

                //Write to file for the second row
                pw.print(endTime);
                pw.print(",");
                pw.print(totalTime);
                pw.print("\n");

                //Flush the output to the file
                pw.flush();

                //Close the Print Writer
                pw.close();

                //Close the File Writer
                fw.close();

            }
        }

    }
    
    /**
     * @param args the command line arguments
     */
    public static void run(int time) throws IOException {
        // TODO code application logic here


        int temp = 7000;//Integer.parseInt(args[0]);

        Object[] a = new Object[temp];
        for (int i = 0; i < temp; i++) {

            a[i] = new int[temp];

        }


        long timeStart = System.currentTimeMillis();
//        for (int i = 0; i < 1000000000; i++) {

//            for (int j = 0; j < 100000000; j++) {

        while (true) {

            long timeNow = System.currentTimeMillis();

            if((timeNow - timeStart)/1000 > time){
               break;
            }

            Random randomGenerator = new Random();

            int random = randomGenerator.nextInt(10);

            int run = 0;//randomGenerator.nextInt(random + 1);

            if (run == 0) {

                long startTime = System.currentTimeMillis();

                Program(a, temp);

                long endTime = System.currentTimeMillis();
                long totalTime = endTime - startTime;
               // System.out.println("Time now " + endTime + " execution time " + totalTime);

                FileWriter fw = new FileWriter("CaseTwo.csv", true);
                PrintWriter pw = new PrintWriter(fw);

                //Write to file for the second row
                pw.print(endTime);
                pw.print(",");
                pw.print(totalTime);
                pw.print("\n");

                //Flush the output to the file
                pw.flush();

                //Close the Print Writer
                pw.close();

                //Close the File Writer
                fw.close();

            } else {

                long startTime = System.currentTimeMillis();

//                    try {
//                        run = randomGenerator.nextInt(20);
//                        Thread.sleep(run * 1000);
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//                    }

                long endTime = System.currentTimeMillis();
                long totalTime = endTime - startTime;
             //   System.out.println("Time now " + endTime + " execution time " + totalTime);

                FileWriter fw = new FileWriter("CaseTwo.csv", true);
                PrintWriter pw = new PrintWriter(fw);

                //Write to file for the second row
                pw.print(endTime);
                pw.print(",");
                pw.print(totalTime);
                pw.print("\n");

                //Flush the output to the file
                pw.flush();

                //Close the Print Writer
                pw.close();

                //Close the File Writer
                fw.close();

            }
        }




//            }

//        }



    }

    private static void Program(Object[] a, int temp) {

        for (int i = 0; i < temp; i++) {

            for (int j = 0; j < temp; j++) {

                int[] b = (int[]) a[i];

                b[j] = 1;
            }
        }


    }
}
