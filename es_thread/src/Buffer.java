/**
 * Created by motta.corrado on 22/01/2016.
 */
public class Buffer {
    private int val;
    protected boolean risorsa_disponibile = false;

    public synchronized int get(String ThID){
        while (risorsa_disponibile == false) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        if (!(val > 5 && ThID.equals("Cons>5") || val < 6 && ThID.equals("Cons<5"))) {
            notifyAll();
            return 0;
        }
        risorsa_disponibile = false;
        notifyAll();
        return val;
    }

    public synchronized void put(int num){
        while (risorsa_disponibile == true) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        val = num;
        risorsa_disponibile = true;
        notifyAll();
    }
}