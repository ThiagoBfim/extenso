package org.math.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PorExtensoPT extends PorExtenso {

    private static final List<String> unidades = Collections.unmodifiableList(Arrays.asList("zero", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove"));
    private static final List<String> primeiraDezena = Collections.unmodifiableList(Arrays.asList("dez", "onze", "doze", "treze", "quatorze", "quinze", "dezesseis", "dezessete", "dezoito", "dezenove"));
    private static final List<String> dezenas = Collections.unmodifiableList(Arrays.asList("vinte", "trinta", "quarenta", "cinquenta", "sessenta", "setenta", "oitenta", "noventa"));
    private static final List<String> centenas = Collections.unmodifiableList(Arrays.asList("cento", "duzentos", "trezentos", "quatrocentos", "quinhentos", "seiscentos", "setecentos", "oitocentos", "novecentos"));

    @Override
    protected void appendMilhar(StringBuilder porExtenso, PorExtenso.SeparadorUnidades separadorUnidades) {
        if (separadorUnidades.getMilhares() == 1) {
            porExtenso.append("mil");
        } else if (separadorUnidades.getMilhares() >= 1) {
            super.appendMilhar(porExtenso, separadorUnidades);
        }
    }

    @Override
    protected void appendCentena(StringBuilder porExtenso, PorExtenso.SeparadorUnidades separadorUnidades) {
        if (separadorUnidades.getCentenas() == 1 && separadorUnidades.getUnidades() == 0 && separadorUnidades.getDezenas() == 0) {
            appendWhenPorExtensoIsNotEmpty(porExtenso, getConcatValue());
            porExtenso.append("cem");
        } else if (separadorUnidades.getCentenas() > 0) {
            super.appendCentena(porExtenso, separadorUnidades);
        }
    }

    @Override
    protected String getNomenclaturaNegative() {
        return "menos";
    }

    @Override
    String getNomenclaturaMilhar() {
        return "mil";
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
        return " e ";
    }

}
