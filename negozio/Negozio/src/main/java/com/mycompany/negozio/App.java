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
    public static void main(String[] args)
    {
        
        String[] vociMenu;
        int numeroVoci=10;
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
        
        vociMenu[0]="\t--> Esci";
        vociMenu[1]="\t--> Visualizza tutti gli abiti presenti";
        vociMenu[2]="\t--> Aggiungi abito";
        vociMenu[3]="\t--> Visualizza abito (appendiabiti) ";
        vociMenu[4]="\t--> Elimina abito(appendiabiti)";
        
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
                          System.out.println("Posizione già vuota. Nessun libro è stato rimosso.");
                    }
                    catch (IOException e)
                    {
                        System.out.println("Impossibile acquisire da tastiera");
                    }                 
                    break;
            }  
        }while(voceScelta!=0);  
    }
}
