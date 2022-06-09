package com.jodiaz.bd;

public class Lugar {

    private int id;

    private String dpto;
    private String prov;
    private String dist;
    private String nombre;

    public Lugar() {
    }

    public Lugar(int id, String dpto, String prov, String dist, String nombre) {
        this.id = id;
        this.dpto = dpto;
        this.prov = prov;
        this.dist = dist;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDpto() {
        return dpto;
    }

    public void setDpto(String dpto) {
        this.dpto = dpto;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Lugar [dist=" + dist + ", dpto=" + dpto + ", id=" + id + ", nombre=" + nombre + ", prov=" + prov + "]";
    }

}
