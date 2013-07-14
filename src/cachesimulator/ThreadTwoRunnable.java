/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cachesimulator;

/**
 *
 * @author Sijin
 */
public class ThreadTwoRunnable implements Runnable{

    Thread thread;


    public ThreadTwoRunnable(Thread t){
        this.thread = t;
    }


    public void run() {
        Main.t2(thread);
        
    }


}
