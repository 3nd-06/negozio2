/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.negozio;

import eccezioni.EccezionePosizioneNonValida;
import eccezioni.EccezionePosizioneOccupata;
import eccezioni.EccezionePosizioneVuota;

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
                //Non fare nulla, non avverrà mai.
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
           // return posizione;
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
            //Se la posizione non è valida sollevo l'eccezione
            throw new EccezionePosizioneNonValida();
        }
        catch (NullPointerException e)
        {
            //Se la posizione non contiene un libro
            throw new EccezionePosizioneVuota();
        }
        
    }
    
    public void rimuoviAbito(int posizione) throws EccezionePosizioneNonValida, EccezionePosizioneVuota
    {
    
    /*    if (posizione<0 || posizione>=NUM_MAX_VOLUMI)
            return -1; //posizione non valida 
    */
        try
        {
            if (abiti[posizione]==null)
               throw new EccezionePosizioneVuota();
            abiti[posizione]=null;
            //return posizione; 
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
            if (abiti[i]!=null) //Attenzione!! serve questo!
            {
                if (abiti[i].getMarca().equalsIgnoreCase(marca))
                return true;
            }
        }
        return false;
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

    public Abito[] getAbiti() {
        return abiti;
    }

    public static int getNUM_MAX_ABITI() {
        return NUM_MAX_ABITI;
    }

    public void setAbiti(Abito[] abiti) {
        this.abiti = abiti;
    }

  public  int getNumMaxAppendiabiti()
    {
        return getNumMaxAppendiabiti();
    }

public  Abito getAppendiabiti() 
    {
        return getAppendiabiti();
    }

    public int getNumAppendiabiti() 
    {
        return getNumAppendiabiti();
    }
  
}
