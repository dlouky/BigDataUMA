package org.uma.mbd.mdEjemplo;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main
{
    public static void main(String[] args) {
        Function<Integer, Boolean> par = n -> n % 2 ==0;
        Predicate<Integer> otroPar = n -> n % 2 ==0;

        System.out.println(par.apply(6));
        System.out.println(par.apply(7));

        System.out.println(otroPar.test(6));
        System.out.println(otroPar.test(7));

        Predicate<String> enMayusculas = s -> Character.isUpperCase(s.charAt(0));
        System.out.println(enMayusculas.test("Hola"));
        System.out.println(enMayusculas.test("hola"));

        BiFunction<Integer, Boolean, Integer> rara = (e,b) -> b ? e : e + 1;
        System.out.println(rara.apply(3, true));
        System.out.println(rara.apply(3, false));
    }
}