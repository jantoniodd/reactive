package com.jodiaz;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Archivo {

    private FileReader fileReader;

    private BufferedReader bufferedReader;

    private String ruta = "src/main/resources/";

    public List<String> leerArchivo(String filename) {

        List<String> listado = new ArrayList<>();

        try {

            fileReader = new FileReader(ruta + filename);

            bufferedReader = new BufferedReader(fileReader);

            String linea = bufferedReader.readLine();

            while (linea != null && linea.length() > 0) {

                listado.add(linea);

                linea = bufferedReader.readLine();
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return listado;

    }

    public FileReader getFileReader() {
        return fileReader;
    }

    public void setFileReader(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    public void setBufferedReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

}
