/**
 * Created by motta.corrado on 22/01/2016.
 */
public class CountDown extends Thread {
    public void run(){
        try{
            sleep(20000);
        } catch (InterruptedException e){}
        System.exit(0);
    }
}