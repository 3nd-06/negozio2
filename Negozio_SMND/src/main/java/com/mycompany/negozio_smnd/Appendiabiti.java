/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.negozio_smnd;

import eccezioni.EccezioneAppendiabitiNonValido;
import eccezioni.EccezionePosizioneNonValida;
import eccezioni.EccezionePosizioneOccupata;
import eccezioni.EccezionePosizioneVuota;
import eccezioni.FileException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import utilita.TextFile;

/**
 *
 * @author Utente
 */
public class Appendiabiti 
{
    private Abito[] abiti;
    private final static int NUM_MAX_ABITI=10;
    
    public Appendiabiti()
    {
        abiti=new Abito[NUM_MAX_ABITI];
    }
    
    public Appendiabiti(Appendiabiti app)
    {
        abiti=new Abito[NUM_MAX_ABITI];
        Abito ab;
        for(int i=0;i<app.getNumMaxAbiti();i++)
        {
            try 
            {
                ab=app.getAbito(i);
                abiti[i]=ab;
            } 
            catch (EccezionePosizioneNonValida ex) 
            {
                //non succederà mai
            } 
            catch (EccezionePosizioneVuota ex) 
            {
                 //non fare nulla
            }
                
        }
    }
    
    public void setAbito(Abito abito,int posizione) throws EccezionePosizioneNonValida, EccezionePosizioneOccupata
    {
        try
        {
            if (abiti[posizione]!=null)
                throw new EccezionePosizioneOccupata();
            abiti[posizione]=new Abito(abito);
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            throw new eccezioni.EccezionePosizioneNonValida();
        } 
    }
    
    public Abito getAbito(int posizione) throws EccezionePosizioneNonValida, EccezionePosizioneVuota
    {
        try
        {
           return new Abito(abiti[posizione]); 
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            //Se la posizione non è valida:
            throw new EccezionePosizioneNonValida();
        }
        catch (NullPointerException e)
        {
            //Se la posizione non contiene un abito:
            throw new EccezionePosizioneVuota();
        }
        
    }
    
    
    public void rimuoviAbito(int posizione) throws EccezionePosizioneNonValida, EccezionePosizioneVuota
    {
        try
        {
            if (abiti[posizione]==null)
               throw new EccezionePosizioneVuota();
            abiti[posizione]=null;
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            throw new EccezionePosizioneNonValida();
        } 
    }
    
    public int getNumMaxAbiti() 
    {
        return NUM_MAX_ABITI;
    }
    
    public int getNumAbiti()
    {
        int contaAbiti;
        contaAbiti=0;
        for (int i=0; i<NUM_MAX_ABITI; i++)
        {
            if (abiti[i]!=null )
                contaAbiti++;
            
        }
        return contaAbiti;
    }
     
    public boolean presenzaMarca(String marca)
    {
        for (int i=0;i<getNumMaxAbiti();i++)
        {
            if (abiti[i]!=null)
            {
                if (abiti[i].getMarca().equalsIgnoreCase(marca))
                return true;
            }
        }
        return false;
    }
    
    public Abito[] elencoAbitiMarca(String marca)
    {
        Abito[] elencoAbitiMarca;

        int contaAbitiMarca = 0;
        for (int i = 0; i < NUM_MAX_ABITI; i++) {
            if (abiti[i] != null && abiti[i].getMarca().equalsIgnoreCase(marca)) {
                contaAbitiMarca++; // Incrementa il conteggio degli abiti della marca
            }
        }

        // Se non ci sono abiti della marca, restituisci null
        if (contaAbitiMarca == 0)
            return null;

        // Istanzia l'array dinamicamente
        elencoAbitiMarca = new Abito[contaAbitiMarca];

        // Copia gli abiti della marca nell'array
        contaAbitiMarca = 0;
        for (int i = 0; i < NUM_MAX_ABITI; i++) {
            if (abiti[i] != null && abiti[i].getMarca().equalsIgnoreCase(marca)) {
                elencoAbitiMarca[contaAbitiMarca] = abiti[i];
                contaAbitiMarca++;
            }
        }

        return elencoAbitiMarca;
    }

    public Abito[] elencoAbitiPresenti() {
        Abito[] elencoAbitiPresenti = new Abito[getNumAbiti()];
        int c = 0; // contatore
        for (int i = 0; i < NUM_MAX_ABITI; i++) {
            if (abiti[i] != null) {
                elencoAbitiPresenti[c] = abiti[i];
                c++;
            }
        }
        return elencoAbitiPresenti;
    }

    public ArrayList<Abito> filtraAbitiPerPrezzoMassimo(float prezzoMassimo) {
        ArrayList<Abito> abitiFiltrati = new ArrayList<>();
        for (int i = 0; i < NUM_MAX_ABITI; i++) {
            if (abiti[i] != null && abiti[i].getPrezzo() <= prezzoMassimo) {
                abitiFiltrati.add(abiti[i]);
            }
        }
        return abitiFiltrati;
    }

    public void esportaCSV(String fileName) throws IOException, FileException
    {
        TextFile f1 = new TextFile(fileName, 'W');
        Abito abito;
        String datiAbito;

        for (int i = 0; i < NUM_MAX_ABITI; i++) {
            try
            {
                abito = getAbito(i);
                datiAbito = i + ";" + abito.getIdAbito() + ";" + abito.getTipo() + ";" + abito.getMarca() + ";" + abito.getTaglia() + ";" + abito.getColore();
                f1.toFile(datiAbito);
            }
            catch (EccezionePosizioneNonValida ex) 
            {
                //non succederà mai
            } 
            catch (EccezionePosizioneVuota ex) 
            {
                //non fare nulla.
            }
        }
        f1.close();
    }
    
    public void importaCSV(String fileName) throws IOException
    {
        TextFile f1 = new TextFile(fileName, 'R');
        String rigaLetta;
        String[] datiAbito;
        String tipo, marca, taglia, colore;
        int appendiabiti, posizione;
        Abito abito;

        try {
            while (true) {
                rigaLetta = f1.fromFile();
                datiAbito = rigaLetta.split(";");
                appendiabiti = Integer.parseInt(datiAbito[0]);
                posizione = Integer.parseInt(datiAbito[1]);
                tipo = datiAbito[2];
                marca = datiAbito[3];
                taglia = datiAbito[4];
                colore = datiAbito[5];
                abito = new Abito(0, tipo, 0, marca, taglia, colore);
                try {
                    setAbito(abito, posizione);
                }
                catch (EccezionePosizioneNonValida ex)
                {
                    
                }
                catch (EccezionePosizioneOccupata ex)
                {
                    
                }
            }
        } catch (FileException ex) {
            // Fine del file di testo
            f1.close();
        }
    }

    public void salvaAppendiabiti(String fileName) throws FileNotFoundException, IOException
   {
       ObjectOutputStream writer=new ObjectOutputStream(new FileOutputStream(fileName));
       writer.writeObject(this);
       writer.flush();
       writer.close();
   }
   
   public Appendiabiti caricaAppendiabiti(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException
   {
       Appendiabiti a;
       ObjectInputStream reader=new ObjectInputStream(new FileInputStream(fileName));
       a=(Appendiabiti)reader.readObject();
       reader.close();
       return a;
   }

 
    public  String toString()
    {
        String s="";
        for(int i=0;i<NUM_MAX_ABITI;i++)
        {
            s=s+i+"\t--> ";
            if (abiti[i]!=null)
                s=s+abiti[i].toString()+"\n";
            else
                s=s+"\n";
        }
        return s;
    }
  
}
