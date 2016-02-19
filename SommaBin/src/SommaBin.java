/**
 *
 * Created by motta.corrado on 25/01/2016.
 *
 * Praticamente nel mio esercizio che ho fatto, la somma se inserisco due numeri positivi funziona, mentre se metto uno dei due numeri negativi non funziona.
 Se decommentiamo alcune parti di codice, che servono appunto per far funzionare il programma con i numeri negativi, ho fatto fare al programma queste operazioni:
 --> trasformare il numero in positivo, ad esempio se metto -2 il numero sarà 2.
 --> convertirlo in binario, sempre nel caso precedente sarà 00000010
 --> complemento a 1, quindi inverto tutti i bit 11111101
 --> complemento a 2, quindi aggiungo 00000001.

 Per fare fare questa ultima operazione, ho usato le stesse righe di codice che ci aveva fatto vedere oggi con la bitwise, a differenza che
 al posto di avere "somma[i]=(addendo1[i]^addendo2[i]) | riporto"  avevo 0000001 al posto di addendo2.
 Quindi, ho "somma[i]=(addendo1[i]^0000001)| riporto"

 Solamente che i risultati non vengono corretti, e non sono nemmeno riuscito a capire dai risultati errati che mi vengono fuori dove possa essere l'errore.
 Dove sbaglio?

 */

/* Chiedere all'utente di inserire due numeri tra -128 e 127; se i numeri inseriti sono negativi salvarli in un array di 8 numeri interi in binario in complemento a 2
Chiedere all'utente di inserire piu' per la somma e meno per la differenza
Eseguire l'operazione in decimale	*/

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.*;
import java.lang.*;

public class SommaBin {

    /*
    Attualmente il programma funziona solo se vengono messi dei numeri che sono positivi,
    tuttavia al suo interno ci sono delle parti che sono commentate che servono perche sto
    predisponendo che il programma funzioni anche con dei numeri che sono negativi.
    Versione 1.0
    */

        public static void main(String arg[]){
            int addendo1 [] = new int [8];
            int addendo2 [] = new int [8];
            int numero1 = 0;
            int numero2 = 0;
            int somma []= new int [9];
            int sommadec = 0;
            int cont = 0;
            byte entra = 0;
            int riporto = 0;
            boolean negativo1 = false;                      //SAREBBE PIU' CORRETTO USARE UN BOOLEAN PER UNA SCELTA 1-0
            boolean negativo2 = false;
            Scanner sc = new Scanner(System.in);
            System.out.print ("Inserisci un numero decimale: ");
            numero1 = sc.nextInt();
            System.out.print ("Inserisci il secondo numero decimale: ");
            numero2 = sc.nextInt();
            sommadec = numero1 + numero2;
            if (sommadec<-128 || sommadec >= 127){
                System.out.println ("Errore, la somma dei numeri è troppo grande");			//Se la somma e minore di -128 e maggiore di 127, non far nulla
                entra = 1;                                                                     // DOVRESTI PREVEDERE UN CICLO (WHILE) CHE PERMETTE DI REINSERIRE IL/I NUMERO/I SE SBAGLIATI O SE TROPPO GRANDI
            }
		    if (numero1<0){								//Parte per i numeri negativi
                negativo1 = true;
                numero1 = -numero1;
            }
		    if (numero2<0){
                negativo2 = true;
                numero2 = -numero2;
            }

            if (entra==0){
                do {                                                    //Converte il primo numero in binario
                    addendo1[cont] = numero1 % 2;
                    numero1 = numero1 / 2;
                    cont = cont + 1;
                } while (numero1 != 0);
                //for (int i=cont-1; i>=0; i--){
                System.out.print(" ");
                for (int i=7; i>=0; i--){
                    System.out.print(addendo1[i]);					//Stampa il primo numero binario
                }
                System.out.println();
                /*if (negativo1){						//Parte che andra decommentata x farlo funzionare con i numeri negativi, e C2
						for (int i=cont-1; i>=0; i--){
						if (addendo1[i]==0){
                            addendo1[i] = 1;
                        }
						else {
                            addendo1[i] = 0;
                        }
						}
						while(rip
                            addendo1[i] = (addendo1[i] ^ 1) ^ riporto;  //IL CODICE CHE DICEVO IO IN CLASSE (DI METTERE OPERAZIONE DI EX-OR SIA TRA GLI ADDENDI CHE NEL RIPORTO) PER OTTENERE LA SOMMA DI BIT
                            riporto = addendo1[i] & 1;
                        }
*/
                cont = 0;
                do {                                                //Parte per convertire il secondo numero in binario
                    addendo2[cont] = numero2 % 2;
                    numero2 = numero2 / 2;
                    cont = cont + 1;
                } while (numero2 != 0);
                //for (int i=cont-1; i>=0; i--){
                System.out.print(" ");
                for (int i=7; i>=0; i--){
                    System.out.print(addendo2[i]);
                }
                System.out.println();
                System.out.println ("Controlla che la somma dovrà essere " + sommadec + " in binario");
          /*              if (negativo2){				//Parte che andra decommentata x farlo funzionare con i numeri negativi e C2
						for (int i= cont-1; i>=0; i--){
						if (addendo2[i]==0){
							addendo2[i]=1;
						}
						else {
						    addendo1[i] =0;
						}
						}
						for (int i=0; i<8; i++){
                            addendo2[i] = (addendo2[i] ^ 1) | riporto;
                            riporto = addendo2[i] & 1;
	                    }*/


                for (int i=0; i<8; i++){										//Fai la somma in binario
                    somma[i] = (addendo1[i] ^ addendo2[i]) ^ riporto; // IL CODICE CHE DICEVO IO IN CLASSE (DI METTERE OPERAZIONE DI EX-OR SIA TRA GLI ADDENDI CHE NEL RIPORTO)
                    riporto = (addendo1[i] & addendo2[i]) | (addendo1[i] & riporto) | (addendo2[i] & riporto);        // PER OTTENERE LA SOMMA DEI BIT
                }

                if(riporto==1) somma[8] = 1;   //QUESTO PER POTER RAPPRESENTARE IL RISULTATO SE ESSO è <-128 E >127

                for (int i=8; i>=0; i--){
                    System.out.print (somma[i]);									//Stampa il risultato
                }
                System.out.println();
            }
        }
}
