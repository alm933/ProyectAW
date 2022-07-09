package com.upn.proyectaw;

public class Productos {

    private String pid;
    private String pnombreproducto;
    private String pidimagenproducto;
    private String pidimagen128;
    private String descripcioncorta;
    private String descripcionlarga;
    private String precionormal;
    private String precioOferta;
    private String Stock;

    public String getStock() {
        return Stock;
    }

    public void setStock(String stock) {
        Stock = stock;
    }

    public Productos(String name, String description, String priceNor, String priceDis, String stock){

    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPnombreproducto() {
        return pnombreproducto;
    }

    public void setPnombreproducto(String pnombreproducto) {
        this.pnombreproducto = pnombreproducto;
    }

    public String getPidimagenproducto() {
        return pidimagenproducto;
    }

    public void setPidimagenproducto(String pidimagenproducto) {
        this.pidimagenproducto = pidimagenproducto;
    }

    public String getPidimagen128() {
        return pidimagen128;
    }

    public void setPidimagen128(String pidimagen128) {
        this.pidimagen128 = pidimagen128;
    }

    public String getDescripcioncorta() {
        return descripcioncorta;
    }

    public void setDescripcioncorta(String descripcioncorta) {
        this.descripcioncorta = descripcioncorta;
    }

    public String getDescripcionlarga() {
        return descripcionlarga;
    }

    public void setDescripcionlarga(String descripcionlarga) {
        this.descripcionlarga = descripcionlarga;
    }

    public String getPrecionormal() {
        return precionormal;
    }

    public void setPrecionormal(String precionormal) {
        this.precionormal = precionormal;
    }

    public String getPrecioOferta() {
        return precioOferta;
    }

    public void setPrecioOferta(String precioOferta) {
        this.precioOferta = precioOferta;
    }
}
