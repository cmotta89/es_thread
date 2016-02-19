/**
 * Created by motta.corrado on 22/01/2016.
 */
public class Cons extends Thread{
    private Buffer buffer;
    private int numero;
    private String ThreadID;

    Cons(Buffer b, String nome){
        buffer = b;
        ThreadID = nome;
    }

    public void run(){
        while (true) {
            numero = buffer.get(ThreadID);
            if (numero == 0) {
                System.out.println("Consumatore " + this.ThreadID + " ha provato a prelevare il numero sbagliato");
            } else System.out.println("Consumatore " + this.ThreadID + " ha prelevato il numero: " + numero);
            //yield();
        }
    }
}
