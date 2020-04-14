package org.math.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PorExtensoEN extends PorExtenso {

    private static final List<String> unidades = Collections.unmodifiableList(Arrays.asList("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"));
    private static final List<String> primeiraDezena = Collections.unmodifiableList(Arrays.asList("ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"));
    private static final List<String> dezenas = Collections.unmodifiableList(Arrays.asList("twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"));
    private static final List<String> centenas = Collections.unmodifiableList(Arrays.asList("one hundred", "two hundred", "three hundred", "four hundred", "five hundred", "six hundred", "seven hundred", "eight hundred", "nine hundred"));

    @Override
    protected String getNomenclaturaNegative() {
        return "minus";
    }

    @Override
    String getNomenclaturaMilhar() {
        return "thousand";
    }

    @Override
    protected List<String> getCentenas() {
        return centenas;
    }

    @Override
    protected List<String> getPrimeiraDezena() {
        return primeiraDezena;
    }

    @Override
    protected List<String> getDezenas() {
        return dezenas;
    }


    @Override
    protected List<String> getUnidades() {
        return unidades;
    }

    @Override
    protected String getConcatValue() {
        return " ";
    }

}
