package com.jodiaz;

import java.util.List;

import com.jodiaz.bd.AccesoBD;
import com.jodiaz.bd.Lugar;

import io.reactivex.rxjava3.core.Observable;

public class UsoDB {

    AccesoBD accesoBD;

    public static void main(String[] args) {
        new UsoDB();
    }

    public UsoDB() {

        accesoBD = new AccesoBD();

        List<String> provincias = accesoBD.cargarProvincias();
        Observable<String> data = Observable.fromIterable(provincias);

        List<Lugar> provincias2 = accesoBD.cargarProvinciasObjeto();
        Observable<Lugar> data2 = Observable.fromIterable(provincias2);


        data2.filter(f -> f.getDpto().equals("02")).subscribe(System.out::println);


    }

}
