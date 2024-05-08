/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.negozio;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author nadia
 */
public class AbitoTest {
    
    public AbitoTest() {
    }

    @Test
    public void testCreazioneAbito() {
        Abito abito = new Abito(1, "Maglietta", 100.0f, "Armani", "M", "Nero");
        assertNotNull(abito);
    }

    @Test
    public void testGetters() {
        Abito abito = new Abito(1, "Maglietta", 100.0f, "Armani", "M", "Nero");
        assertEquals(1, abito.getIdAbito());
        assertEquals("Maglietta", abito.getTipo());
        assertEquals(100.0f, abito.getPrezzo());
        assertEquals("Armani", abito.getMarca());
        assertEquals("M", abito.getTaglia());
        assertEquals("Nero", abito.getColore());
    }

    @Test
    public void testSetters() {
        Abito abito = new Abito(1, "Maglietta", 100.0f, "Armani", "M", "Nero");
        abito.setIdAbito(2);
        abito.setTipo("Gonna");
        abito.setPrezzo(120.0f);
        abito.setMarca("Gucci");
        abito.setTaglia("L");
        abito.setColore("Bianco");

        assertEquals(2, abito.getIdAbito());
        assertEquals("Gonna", abito.getTipo());
        assertEquals(120.0f, abito.getPrezzo());
        assertEquals("Gucci", abito.getMarca());
        assertEquals("L", abito.getTaglia());
        assertEquals("Bianco", abito.getColore());
    }

    @Test
    public void testToString() {
        Abito abito = new Abito(1, "Maglietta", 100.0f, "Armani", "M", "Nero");
        String expectedToString = "Abito{idAbito=1, tipo=Maglietta, prezzo=100.0, marca=Armani, taglia=M, colore=Nero}";
        assertEquals(expectedToString, abito.toString());
    }
    
}
