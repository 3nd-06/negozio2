/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.negozio_nadia_safia;

import com.mycompany.negozio_nadia_safia.Abito;
import eccezioni.EccezioneAppendiabitiNonValido;
import eccezioni.EccezionePosizioneNonValida;
import eccezioni.EccezionePosizioneOccupata;
import eccezioni.EccezionePosizioneVuota;
import java.io.Serializable;

/**
 *
 * @author Studente
 */
public class Magazzino implements Serializable
{
    private int appendiabito=0;
    private Appendiabiti[] appendiabiti; //array di appendiabiti
    private final static int NUM_APPENDIABITI=5;
    
    public Magazzino()
    {
        appendiabiti=new Appendiabiti[NUM_APPENDIABITI];
        //Istanzio una mensola (vuota) per ciascun ripiano
        for(int i=0;i<NUM_APPENDIABITI;i++)
        {
            appendiabiti[i]=new Appendiabiti();
        }
    }
    
    public void setAbito(Abito abito, int appendiabito, int posizione ) throws EccezioneAppendiabitiNonValido, EccezionePosizioneNonValida, EccezionePosizioneOccupata 
    {
        
        if (appendiabito<0 || appendiabito >=NUM_APPENDIABITI)
            throw new EccezioneAppendiabitiNonValido();
        appendiabiti[appendiabito].setAbito(abito, posizione);
    }
    
    public Abito getLibro(int appendiabito, int posizione) throws EccezioneAppendiabitiNonValido, EccezionePosizioneNonValida, EccezionePosizioneVuota
    {
        if (appendiabito<0 || appendiabito>=NUM_APPENDIABITI)
            throw new EccezioneAppendiabitiNonValido();
        Abito ab;
        ab=appendiabiti[appendiabito].getAbito(posizione);
        return ab;
    }
    
    //aggiungi rimuoviabito
    //get numero appendiabiti
  
    public int getNumMaxAbiti()
    {
        int contatore=0;
        for (int i=0;i<NUM_APPENDIABITI;i++)
        {
            contatore+=appendiabiti[i].getNumMaxAbiti();
        }
        
        return contatore;
    }
    
    
    public int getNumAbiti()
    {
        int contaAbiti=0;
        for(int i=0;i<NUM_APPENDIABITI;i++)
        {
            contaAbiti+=appendiabiti[i].getNumAbiti();
        }
        return contaAbiti;
    }

    public int getNumAbiti(int ripiano)
    {
        if (appendiabito<0 || appendiabito>NUM_APPENDIABITI)
            return -1;
        
        return appendiabiti[appendiabito].getNumAbiti();
    }
    
       public int getNumMaxAbiti(int appendiabito)
    {
            if (appendiabito<0 || appendiabito>NUM_APPENDIABITI)
               return -1;
           return appendiabiti[appendiabito].getNumMaxAbiti();
    }
    
    
    public Appendiabiti[] getAppendiabiti() {
        return appendiabiti;
    }

    public void setAppendiabiti(Appendiabiti[] appendiabiti) {
        this.appendiabiti = appendiabiti;
    }

    @Override
    public String toString() 
    {
        String s="";
        for (int i=0;i<NUM_APPENDIABITI;i++)
        {
            s+="Ripiano "+i+":\n"+appendiabiti[i].toString();
        }
        return s;
    }
    
    
}
