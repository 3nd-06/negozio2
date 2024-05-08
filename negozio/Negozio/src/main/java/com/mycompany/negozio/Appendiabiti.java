/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.negozio;

import eccezioni.EccezioneAppendiabitiNonValido;
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
