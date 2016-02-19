/**
 * Created by motta.corrado on 22/01/2016.
 */

import java.lang.*;

public class provaThread {
    public static void main(String[] args) {
        Prod p;
        Cons c1, c2;
        Buffer b;
        CountDown count;
        count = new CountDown();
        b = new Buffer();
        p = new Prod(b, "Prod1");
        c1 = new Cons(b, "Cons<5");
        c2 = new Cons(b, "Cons>5");
        count.start();
        p.start();
        c1.start();
        c2.start();
    }
}
