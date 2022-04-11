package com.murilonerdx.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        List<String> palavras = new ArrayList<String>();
        palavras.add("Alura online");
        palavras.add("editora casa do codigo");
        palavras.add("caelum");

        Comparator<String> comparador = new ComparadorPorTamanho();
        // Collections.sort(palavras, comparador);
        // palavras.sort(comparador);

//        palavras.sort((s1, s2) ->{
//            if(s1.length() < s2.length())
//                return -1;
//            if(s1.length() > s2.length())
//                return 1;
//            return 0;
//        });

        palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
        palavras.sort(Comparator.comparingInt(String::length));

        System.out.println(palavras);

        // Consumer<String> consumidor = new ImprimeNaLinha();
        // palavras.forEach(consumidor);

        Consumer<String> impressor = System.out::println;

        palavras.forEach(impressor);

    }
}

class ImprimeNaLinha implements Consumer<String>{

    @Override
    public void accept(String s) {
        System.out.println(s);
    }

    @Override
    public Consumer<String> andThen(Consumer<? super String> after) {
        return Consumer.super.andThen(after);
    }
}

class ComparadorPorTamanho implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        if(o1.length() < o2.length())
            return -1;
        if(o1.length() > o2.length())
            return 1;
        return 0;
    }
}
