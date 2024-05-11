/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.negozio_smnd;

import eccezioni.EccezioneAppendiabitiNonValido;
import eccezioni.EccezionePosizioneNonValida;
import eccezioni.EccezionePosizioneOccupata;
import eccezioni.EccezionePosizioneVuota;
import eccezioni.FileException;
import java.io.IOException;
import java.util.ArrayList;
import utilita.ConsoleInput;
import utilita.Menu;
import utilita.Ordinatore;

/**
 *
 * @author nadia
 */
public class App {

    public static void main(String[] args)
    {
        String[] vociMenu;
        int numeroVoci=12;
        vociMenu=new String[numeroVoci];
        Menu menu;
        int voceScelta;
        Appendiabiti app1=new Appendiabiti(); //creo l'appendiabiti vuoto
        int esito;

        ConsoleInput tastiera=new ConsoleInput();
        String tipo,taglia,colore,marca;
        float prezzo;
        Abito ab;
        int appendiabiti, posizione;
        

        String nomeFile="abiti.csv";
        String nomeFileBinario="appendiabiti.bin";
        
        vociMenu[0]="\t--> Esci";
        vociMenu[1]="\t--> Visualizza tutti gli abiti presenti";
        vociMenu[2]="\t--> Aggiungi abito";
        vociMenu[3]="\t--> Visualizza abito (appendiabiti)";
        vociMenu[4]="\t--> Elimina abito(appendiabiti)";
        vociMenu[5]="\t--> Mostra abiti di una marca";
        vociMenu[6]="\t--> Mostra abiti presenti in ordine alfabetico di marca";
        vociMenu[7]="\t--> Mostra abiti di prezzo inferiore a un determinato prezzo massimo";
        vociMenu[8]="\t--> Esporta i abiti su file CSV";
        vociMenu[9]="\t--> Importa i abiti da file CSV";
        vociMenu[10]="\t--> Salva dati appendiabiti";
        vociMenu[11]="\t--> Carica dati appendiabiti";
        
        menu=new Menu(vociMenu);
       
        
        //Gestione menu
        do
        {
            System.out.println("Menu:");
            voceScelta=menu.sceltaMenu();
            switch (voceScelta) 
            {
                case 0: //esci
                    System.out.println("Arrivederci!");    
                    break;
                case 1://Visualizza tutti
                    System.out.println(app1.toString());
                    break;
                case 2://aggiungi abito
                    try
                    {
                        System.out.println("Tipo --> ");
                        tipo=tastiera.readString();
                        System.out.println("Taglia --> ");
                        taglia=tastiera.readString();
                        System.out.println("Colore --> ");
                        colore=tastiera.readString();
                        System.out.println("Marca --> ");
                        marca=tastiera.readString();
                        do
                        {
                            try
                            {
                                System.out.println("Prezzo --> ");
                                prezzo=tastiera.readFloat();
                                break; //se input ok, esci dal ciclo
                            }
                            catch (NumberFormatException e)
                            {
                                System.out.println("Errore! Devi inserire un numero!");
                            }  
                        }while(true); 
                        
                        do
                        {
                            try
                            {
                                System.out.println("Appendiabiti (0..9) --> ");
                                appendiabiti=tastiera.readInt();
                                break; //se input ok, esci dal ciclo
                            }
                            catch (NumberFormatException e)
                            {
                                System.out.println("Errore! Devi inserire un numero!");
                            }  
                        }while(true); 
                        
                        Abito nuovoAbito = new Abito(0, tipo, prezzo, marca, taglia, colore);
                        
                        try 
                        {
                            app1.setAbito(nuovoAbito, appendiabiti);
                            System.out.println("Abito aggiunto correttamente");
                        }
                        catch (EccezionePosizioneNonValida ex) 
                        {
                              System.out.println("Posizione inesistente");
                        } 
                        catch (EccezionePosizioneOccupata ex)
                        {
                            System.out.println("Posizione già occupata");
                        }
                    }
                    catch(IOException e)
                    {
                        System.out.println("Impossibile leggere da tastiera!");
                    }
                    
                    break;

                case 3: //visualizza abito
                    try 
                    {
                        do
                        {
                            try
                            {
                                    System.out.println("Appendiabiti (0..9) --> ");
                                    posizione=tastiera.readInt();
                                break; //se input ok, esci dal ciclo
                            }
                            catch (NumberFormatException e)
                            {
                                System.out.println("Errore! Devi inserire un numero!");
                            }  
                        }while(true);  
                        ab=app1.getAbito(posizione);
                        System.out.println("Abito cercato: "+ab.toString());
                    } 
                    catch (EccezionePosizioneNonValida ex) 
                    {
                          System.out.println("Posizione inesistente");
                    } 
                    catch (EccezionePosizioneVuota ex) 
                    {
                        System.out.println("Abito non trovato!");
                    }
                    catch (IOException e)
                    {
                        System.out.println("Impossibile leggere da tastiera!");
                    }
                    break;

                case 4: //elimina abito

                    try 
                    {
                        do
                        {
                            try
                            {
                                    System.out.println("Posizione (0..9) --> ");
                                    posizione=tastiera.readInt();
                                break; //se input ok, esci dal ciclo
                            }
                            catch (NumberFormatException e)
                            {
                                System.out.println("Errore! Devi inserire un numero!");
                            }  
                        }while(true);  
                        app1.rimuoviAbito(posizione);
                        System.out.println("Abito rimosso correttamente");
                    } 
                    catch (EccezionePosizioneNonValida ex) 
                    {
                          System.out.println("Posizione inesistente");
                    } 
                    catch (EccezionePosizioneVuota ex) 
                    {
                          System.out.println("Posizione già vuota. Nessun abito è stato rimosso.");
                    }
                    catch (IOException e)
                    {
                        System.out.println("Impossibile acquisire da tastiera");
                    }                 
                    break;
                case 5://mostra abiti marca
                    
                    try
                    {
                        System.out.println("Marca --> ");
                        marca=tastiera.readString();
                        Abito[] elencoAbitiMarca = app1.elencoAbitiMarca(marca);
                        if(elencoAbitiMarca==null)
                            System.out.println("Nessun abito presente");
                        else
                        {
                            for(int i=0;i<elencoAbitiMarca.length;i++)
                            {
                                System.out.println(elencoAbitiMarca[i]);
                            }
                        }   
                    }
                    catch (IOException e)
                    {
                        System.out.println("Impossibile leggere da tastiera1");
                    }
                    
                    break;
                case 6: //mostra elenco libri ordinati
                    Abito[] AbitiPresenti = app1.elencoAbitiPresenti();
                    AbitiPresenti=Ordinatore.selectionSortCrescenteAbiti(AbitiPresenti);
                    for(int i=0;i<AbitiPresenti.length;i++)
                    {
                        System.out.println(AbitiPresenti[i].toString());
                    }
                    break;
                case 7: // Filtra abiti per prezzo massimo
                    try {
                        System.out.println("Inserisci il prezzo massimo: ");
                        float prezzoMassimo = tastiera.readFloat();
                        ArrayList<Abito> abitiFiltrati = app1.filtraAbitiPerPrezzoMassimo(prezzoMassimo);
                        if (abitiFiltrati.isEmpty()) {
                            System.out.println("Nessun abito trovato al di sotto del prezzo massimo inserito.");
                        } else {
                            System.out.println("Abiti sotto il prezzo massimo:");
                            for (Abito abito : abitiFiltrati) {
                                System.out.println(abito);
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Impossibile leggere da tastiera!");
                    }
                    break;
                case 8: //esporta su file CSV
                    try 
                    {
                        app1.esportaCSV(nomeFile);
                        System.out.println("Esportazione avvenuta con successo!");
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Errore di scrittura, impossibile accedere al file");
                    } 
                    catch (FileException ex) 
                    {
                        System.out.println("Errore file aperto in lettura!");
                    }
                    break;
                case 9:              
                    try 
                    {
                        app1.importaCSV(nomeFile);
                        System.out.println("Importazione avvenuta con successo.");
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Impossibile leggere dal file");
                    } 
                    break;
                case 10:
                    try
                    {
                       
                        app1.salvaAppendiabiti(nomeFileBinario);
                        System.out.println("Salvataggio avvenuto correttamente");
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Impossibile salvare su file");
                    }
                    break;
                case 11: 
                    try 
                    {
                        //carica scaffale
                        app1=app1.caricaAppendiabiti(nomeFileBinario);
                        System.out.println("Caricamento avvenuto con successo");
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Impossibile leggere da file");
                    } 
                    catch (ClassNotFoundException ex) 
                    {
                        System.out.println("Impossibile leggere i dati dell'appendiabiti");
                    }

                    break;
                
            }  
        }while(voceScelta!=0);  
    }
}
