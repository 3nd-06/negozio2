package com.mycompany.negozio;

import eccezioni.EccezioneAppendiabitiNonValido;
import eccezioni.EccezionePosizioneNonValida;
import eccezioni.EccezionePosizioneOccupata;
import eccezioni.EccezionePosizioneVuota;
import eccezioni.FileException;
import java.io.IOException;
import utilita.ConsoleInput;
import utilita.Menu;
import utilita.Ordinatore;

public class App
{
    public static void main(String[] args) throws IOException
    {
        
        /*Abito l1 = new Abito(0, "t", 20, "ftds", "f", "we");
        Abito l2 = new Abito(0, "d", 0, "marca", "taglia", "colore");
        
        String[] vociMenu;
        int numeroVoci = 11;
        vociMenu = new String[numeroVoci];
        Menu menu;
        int voceScelta;
        Magazzino m1 = new Magazzino(); 
        int esito;
        ConsoleInput tastiera = new ConsoleInput();
        int prezzo;
        String taglia, marca, colore, tipo;
        int idAbito;
        Abito ab = null;
        int appendiabiti, posizione;
        String[] elencoTagliaMarca;
        Abito[] AbitiPresenti;
        String nomeFile = "appendiabiti.csv";
        String nomeFileBinario = "Magazzino.bin";
        
        vociMenu[0] = "\t--> Esci";
        vociMenu[1] = "\t--> Visualizza tutti i Appendiabiti presenti";
        vociMenu[2] = "\t--> Aggiungi Appendiabito";
        vociMenu[3] = "\t--> Visualizza Appendiabiti(appendiabiti, posizione)";
        vociMenu[4] = "\t--> Elimina appendiabiti (appendiabiti, posizione)";
        vociMenu[5] = "\t--> Mostra Abiti di un colore";
        vociMenu[6] = "\t--> Mostra abiti presenti in ordine alfabetico di marca";
        vociMenu[7] = "\t--> Esporta i appendiabiti su file CSV";
        vociMenu[8] = "\t--> Importa i appendiabit da file CSV";
        vociMenu[9] = "\t--> salva dati Magazzino";
        vociMenu[10] = "\t--> carica dati magazzino";
        menu = new Menu(vociMenu);
        
        do
        {
            System.out.println("Menu:");
            voceScelta = menu.sceltaMenu();
            switch (voceScelta)
            {
                case 0: 
                    System.out.println("Arrivederci!");    
                    break;
                case 1:
                    System.out.println(m1.toString());
                    break;
                case 2:
                    System.out.println("Taglia --> ");
                    taglia = tastiera.readString();
                    System.out.println("Marca --> ");
                    marca = tastiera.readString();
                    System.out.println("colore-->");
                    colore = tastiera.readString();
                    System.out.println("Tipo-->");
                    tipo = tastiera.readString();
                    do
                    {
                        try
                        {
                            System.out.println(" idAbito --> ");
                            idAbito = tastiera.readInt();
                            break;
                        }
                        catch (NumberFormatException e)
                        {
                            System.out.println("Errore! Devi inserire un numero!");
                        }
                    } while(true);
                    do
                    {
                        try
                        {
                            System.out.println("Ripiano (0..4) --> ");
                            prezzo = tastiera.readInt();
                            break;
                        }
                        catch (NumberFormatException e)
                        {
                            System.out.println("Errore! Devi inserire un numero!");
                        }
                    } while(true);
                    ab = new Abito(idAbito, tipo, prezzo, marca, taglia, colore);
                    esito = m1.aggiungiAbito(ab);
                    if (esito == 0)
                    {
                        System.out.println("Abito aggiunto correttamente");
                    }
                    else if (esito == 1)
                    {
                        System.out.println("Posizione occupata");
                    }
                    else if (esito == 2)
                    {
                        System.out.println("Posizione non valida");
                    }
                    break;
                case 3:
                    System.out.println("Ripiano (0..4) --> ");
                    appendiabiti = tastiera.readInt();
                    System.out.println("Posizione (0..9) --> ");
                    posizione = tastiera.readInt();
                    ab = m1.getAbito(ab);
                    System.out.println(ab.toString());
                    break;
                case 4:
                    System.out.println("Ripiano (0..4) --> ");
                    appendiabiti = tastiera.readInt();
                    System.out.println("Posizione (0..9) --> ");
                    posizione = tastiera.readInt();
                    m1.eliminaAbito(posizione,appendiabiti);
                    System.out.println("Abito eliminato correttamente");
                    break;
                case 5:
                    System.out.println("Marca --> ");
                    marca = tastiera.readString();
                    elencoTagliaMarca = m1.getAbitiMarca(marca);
                    for (String s : elencoTagliaMarca)
                    {
                        System.out.println(s);
                    }
                    break;
                case 6:
                    AbitiPresenti = m1.getAbitiOrdinati();
                    for (Abito a : AbitiPresenti)
                    {
                        System.out.println(a.toString());
                    }
                    break;
                case 7:
                    m1.salvaAbitiCSV(nomeFile);
                    System.out.println("Salvataggio su file CSV effettuato correttamente");
                    break;
                case 8:
                    m1.caricaAbitiCSV(nomeFile);
                    System.out.println("Caricamento da file CSV effettuato correttamente");
                    break;
                case 9:
                    m1.salvaAbitiBinario(nomeFileBinario);
                    System.out.println("Salvataggio su file binario effettuato correttamente");
                    break;
                case 10:
                    m1.caricaAbitiBinario(nomeFileBinario);
                    System.out.println("Caricamento da file binario effettuato correttamente");
                    break;
            }
        } while (voceScelta != 0);
    }

    public App() {
*/
    }
}
