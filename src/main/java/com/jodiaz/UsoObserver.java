package com.jodiaz;

import java.util.Arrays;
import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class UsoObserver {
    static List<String> data = Arrays.asList("Uno", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "ocho", "Nueve", "Dies");

    public static void main(String[] args) {

        // codigo1();
        // codigo2();
        // codigo3();
        // codigo4();
        // codigo5();
        // codigo6();

    }

    private static void codigo6() {

        Observable.fromIterable(data)
        .flatMap( m -> Observable.fromArray(m.split("")) )
        .distinct()
        .sorted()
        .zipWith(Observable.range(1, Integer.MAX_VALUE), (s,c)->String.format("%d. %s", c, s) )
        .subscribe( System.out::println );  

    }

    private static void codigo5() {

        Observable.fromIterable(data)
        .flatMap( m -> Observable.fromArray(m.split("")) )
        .distinct()
        .zipWith(Observable.range(1, Integer.MAX_VALUE), (s,c)->String.format("%d. %s", c, s) )
        .subscribe( System.out::println );

    }

    private static void codigo4() {

        Observable.fromIterable(data)
        .flatMap( num -> Observable.fromArray(num.split("")) )
        .zipWith(Observable.range(1, Integer.MAX_VALUE), (cadena,count) -> String.format("%2d. %s", count, cadena) )
        .subscribe( System.out::println );

    }

    private static void codigo3() {

        Observable.fromIterable(data)
                .zipWith(Observable.range(1, Integer.MAX_VALUE), (s, c) -> String.format("%2d. %s", c, s))
                .subscribe(System.out::println);

    }

    private static void codigo2() {

        Observable<String> data = Observable.just("Uno", "Dos", "Tres", "Cuatro", "Cinco");

        data.map(String::length).filter(i -> i >= 5).subscribe(System.out::println, Throwable::printStackTrace,
                () -> System.out.println("ACABO!!!!"));

    }

    private static void codigo1() {

        Observable<String> data = Observable.just("Uno", "Dos", "Tres", "Cuatro", "Cinco");

        Observer<Integer> myObserve = new Observer<Integer>() {

            @Override
            public void onSubscribe(@NonNull Disposable d) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onNext(@NonNull Integer t) {
                System.out.println("RECIBIDO: " + t);

            }

            @Override
            public void onError(@NonNull Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("TERMINADO!!!");
            }

        };

        data.map(String::length).filter(i -> i >= 5).subscribe(myObserve);

    }

}
