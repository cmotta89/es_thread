/**
 * Created by motta.corrado on 22/01/2016.
 */
public class Prod extends Thread {
    private Buffer buffer;
    private int numero;
    private String ThreadID;

    Prod(Buffer b, String nome){
        ThreadID = nome;
        buffer = b;
    }

    public void run(){
        while (true) {
            try{
                sleep((int)(Math.random()*2500));
            } catch (InterruptedException e){}
            numero=(int)(Math.random()*10)+1;
            buffer.put(numero);
            System.out.println("Il produttore " + this.ThreadID + " ha inserito il seguente numero: " + numero);
            //yield();
        }
    }
}
