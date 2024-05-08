/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.negozio;

import eccezioni.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author nadia
 */
public class AppendiabitiTest {
    
    public AppendiabitiTest() {
    }

    @Test
    void testAggiuntaAbito() throws EccezionePosizioneNonValida, EccezionePosizioneOccupata, EccezionePosizioneVuota {
        Appendiabiti appendiabiti = new Appendiabiti();
        Abito abito = new Abito(1, "Formale", 100.0f, "Armani", "M", "Nero");
        
        // Aggiungo un abito all'appendiabiti
        appendiabiti.setAbito(abito, 0);
        
        // Verifica se l'abito è stato aggiunto correttamente
        assertEquals(abito, appendiabiti.getAbito(0));
    }

    @Test
    void testRimozioneAbito() throws EccezionePosizioneNonValida, EccezionePosizioneOccupata, EccezionePosizioneVuota {
        Appendiabiti appendiabiti = new Appendiabiti();
        Abito abito = new Abito(1, "Casuale", 50.0f, "Nike", "L", "Blu");
        appendiabiti.setAbito(abito, 0);
        
        // Rimuovo l'abito dall'appendiabiti
        appendiabiti.rimuoviAbito(0);
        
        // Verifica se l'abito è stato rimosso correttamente
        assertThrows(EccezionePosizioneVuota.class, () -> appendiabiti.getAbito(0));
    }

    @Test
    void testPresenzaMarca() throws EccezionePosizioneNonValida, EccezionePosizioneOccupata {
        Appendiabiti appendiabiti = new Appendiabiti();
        Abito abito1 = new Abito(1, "Formale", 100.0f, "Armani", "M", "Nero");
        Abito abito2 = new Abito(2, "Casuale", 50.0f, "Nike", "L", "Blu");
        appendiabiti.setAbito(abito1, 0);
        appendiabiti.setAbito(abito2, 1);
        
        // Verifica la presenza di una marca nell'appendiabiti
        assertTrue(appendiabiti.presenzaMarca("Armani"));
        assertFalse(appendiabiti.presenzaMarca("Adidas"));
    }

    @Test
    void testNumeroAbiti() throws EccezionePosizioneNonValida, EccezionePosizioneOccupata {
        Appendiabiti appendiabiti = new Appendiabiti();
        Abito abito1 = new Abito(1, "Formale", 100.0f, "Armani", "M", "Nero");
        Abito abito2 = new Abito(2, "Casuale", 50.0f, "Nike", "L", "Blu");
        appendiabiti.setAbito(abito1, 0);
        appendiabiti.setAbito(abito2, 1);
        
        // Verifica il numero di abiti nell'appendiabiti
        assertEquals(2, appendiabiti.getNumAbiti());
    }
}
   
