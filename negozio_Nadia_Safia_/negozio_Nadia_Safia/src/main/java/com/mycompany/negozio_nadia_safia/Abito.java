/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.negozio_nadia_safia;

/**
 *
 * @author Studente
 */
public class Abito
{
    private static long nextIdAbito=1;
    private long idAbito;
    private String tipo;
    private float prezzo;
    private String marca;
    private String taglia;
    private String colore;

    public Abito(int idAbito, String tipo, float prezzo, String marca, String taglia, String colore)
    {
        this.idAbito = idAbito;
        this.tipo = tipo;
        this.prezzo = prezzo;
        this.marca = marca;
        this.taglia = taglia;
        this.colore = colore;
    }
    
    public Abito(Abito abito)
    {
        idAbito=nextIdAbito;
        
        idAbito=abito.getIdAbito();
        setTipo(abito.getTipo());
        setPrezzo(abito.getPrezzo());
        setMarca(abito.getMarca());
        setTaglia(abito.getTaglia());
        setColore(abito.getColore());
        
        nextIdAbito++;
    }
    

    public long getIdAbito() {
        return idAbito;
    }

    public void setIdAbito(int idAbito) {
        this.idAbito = idAbito;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTaglia() {
        return taglia;
    }

    public void setTaglia(String taglia) {
        this.taglia = taglia;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    @Override
    public String toString() {
        return "Abito{" + "idAbito=" + idAbito + ", tipo=" + tipo + ", prezzo=" + prezzo + ", marca=" + marca + ", taglia=" + taglia + ", colore=" + colore + '}';
    }
    
    

}
