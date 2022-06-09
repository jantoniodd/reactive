package com.jodiaz;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // codigo1();
        // codigo2();
        // codigo3();
        // codigo4();
        // codigo5();
        // codigo6();
        // codigo7();
        // codigo8();

        codigo9();

        


        
    }

    private static void codigo9() {

        

    }

    private static void codigo8() {
        Archivo archivo = new Archivo();

       List<String> lineas = archivo.leerArchivo("parrafo.txt");

       Observable.fromIterable( lineas )
       .flatMap( linea -> Observable.fromArray( linea.split(" ") ) )
       .count()
       .subscribe( System.out::println );
    }

    private static void codigo7() {

        List<String> lista = Arrays.asList("UNO", "DOS", "TRES", "CUATRO", "CINCO");

        Observable.fromIterable(lista)
        .map(String::length)
        .filter( p-> p%3 == 0)
        .subscribe( System.out::println );

    }

    private static void codigo6() {

        Observable<String> numeros = Observable.create( emmiter -> {

            try {
                
             emmiter.onNext("Uno");
             emmiter.onNext("dos");
             emmiter.onNext("tres");
             emmiter.onNext("cuatro");
             emmiter.onNext("cinco");
             emmiter.onComplete();
            } catch (Exception e) {
                emmiter.onError(e);
            }
 
         } );

         numeros.map( String::length ).filter(f -> f > 4).subscribe( System.out::println );
    }

    private static void codigo5() {

        Observable<String> numeros = Observable.create( emmiter -> {

            try {
                
             emmiter.onNext("Uno");
             emmiter.onNext("dos");
             emmiter.onNext("tres");
             emmiter.onNext("cuatro");
             emmiter.onNext("cinco");
             emmiter.onComplete();
            } catch (Exception e) {
                emmiter.onError(e);
            }
 
         } );

         Observable<Integer> size =  numeros.map( String::length );

         Observable<Integer> data = size.filter(f -> f > 4);

         data.subscribe( System.out::println );


    }

    private static void codigo4() {

        Observable<String> numeros = Observable.create( emmiter -> {

           try {
               
            emmiter.onNext("Uno");
            emmiter.onNext("dos");
            emmiter.onNext("tres");
            emmiter.onNext("cuatro");
            emmiter.onNext("cinco");
            emmiter.onComplete();
           } catch (Exception e) {
               emmiter.onError(e);
           }

        } );

        numeros.subscribe( System.out::println, Throwable::printStackTrace );


    }

    private static void codigo3() {

        Observable<String> numeros = Observable.create( emmiter -> {

            emmiter.onNext("Uno");
            emmiter.onNext("dos");
            emmiter.onNext("tres");
            emmiter.onNext("cuatro");
            emmiter.onNext("cinco");
            emmiter.onComplete();
            emmiter.onNext("seis");

        } );

        numeros.subscribe( System.out::println );

    }

    private static void codigo2() {


      Observable<Long> tiempo  =  Observable.interval(1, TimeUnit.SECONDS);

      tiempo.subscribe( System.out::println );

      sleep(8000);

    }

    public static void sleep(int valor ) {

        try {
            Thread.sleep(valor);
        } catch (Exception e) { 
        }

    }
}
