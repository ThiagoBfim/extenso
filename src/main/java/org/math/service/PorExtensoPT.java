package org.math.service;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PorExtensoPT implements PorExtenso {

    private static final List<String> unidades = Collections.unmodifiableList(Arrays.asList("zero", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove"));
    private static final List<String> primeiraDezena = Collections.unmodifiableList(Arrays.asList("dez", "onze", "doze", "treze", "quatorze", "quinze", "dezesseis", "dezessete", "dezoito", "dezenove"));
    private static final List<String> dezendas = Collections.unmodifiableList(Arrays.asList("vinte", "trinta", "quarenta", "cinquenta", "sessenta", "setenta", "oitenta", "noventa"));
    private static final List<String> centenas = Collections.unmodifiableList(Arrays.asList("cem", "cento", "duzentos", "trezentos", "quatrocentos", "quinhentos", "seiscentos", "setecentos", "oitocentos", "novecentos"));


    @Override
    public String resultado(Integer numero) {
        SeparadorUnidades separadorUnidades = new SeparadorUnidades(numero);
        StringBuilder porExtenso = new StringBuilder();
        appendMilhar(separadorUnidades, porExtenso);
        realizarPorExtenso(separadorUnidades, porExtenso);
        return porExtenso.toString();
    }

    private void realizarPorExtenso(SeparadorUnidades separadorUnidades, StringBuilder porExtenso) {
        appendCentena(separadorUnidades, porExtenso);
        appendDezena(separadorUnidades, porExtenso);
        appendUnidade(separadorUnidades, porExtenso);
    }

    private void appendUnidade(SeparadorUnidades separadorUnidades, StringBuilder porExtenso) {
        if (separadorUnidades.getUnidade() > 0 && separadorUnidades.getDezena() != 1) {
            appendAnd(porExtenso);
            porExtenso.append(unidades.get(separadorUnidades.getUnidade()));
        }
        if (StringUtils.isEmpty(porExtenso) && separadorUnidades.getUnidade() == 0) {
            porExtenso.append(unidades.get(separadorUnidades.getUnidade()));
        }
    }

    private void appendDezena(SeparadorUnidades separadorUnidades, StringBuilder porExtenso) {
        if (separadorUnidades.getDezena() > 0) {
            appendAnd(porExtenso);
            if (separadorUnidades.getDezena() == 1) {
                porExtenso.append(primeiraDezena.get(separadorUnidades.getUnidade()));
            } else {
                porExtenso.append(dezendas.get(separadorUnidades.getDezena() - 2));
            }
        }
    }

    private void appendMilhar(SeparadorUnidades separadorUnidades, StringBuilder porExtenso) {
        if (separadorUnidades.getMilhares() == 1) {
            porExtenso.append(separadorUnidades.getMilhares()).append("mil");
        }
        if (separadorUnidades.getMilhares() > 1) {
            realizarPorExtenso(new SeparadorUnidades(separadorUnidades.getMilhares()), porExtenso);
            porExtenso.append(" mil");
        }
    }

    private void appendCentena(SeparadorUnidades separadorUnidades, StringBuilder porExtenso) {
        if (separadorUnidades.getCentena() == 1 && separadorUnidades.getUnidade() == 0 && separadorUnidades.getDezena() == 0) {
            porExtenso.append(centenas.get(separadorUnidades.getCentena() - 1));
        } else if (separadorUnidades.getCentena() > 0) {
            appendAnd(porExtenso);
            porExtenso.append(centenas.get(separadorUnidades.getCentena()));
        }
    }

    private void appendAnd(StringBuilder porExtenso) {
        if (StringUtils.isNotEmpty(porExtenso)) {
            porExtenso.append(" e ");
        }
    }

    private class SeparadorUnidades {
        private Integer numero;
        private int milhares;
        private int centena;
        private int dezena;
        private int unidade;

        public SeparadorUnidades(Integer numero) {
            this.numero = numero;
            invoke();
        }

        public int getMilhares() {
            return milhares;
        }

        public int getCentena() {
            return centena;
        }

        public int getDezena() {
            return dezena;
        }

        public int getUnidade() {
            return unidade;
        }

        public SeparadorUnidades invoke() {

            //Exemplo: 1553
            milhares = numero / 1000;
            numero -= milhares * 1000;  //reais = 553
            centena = numero / 100;
            numero -= centena * 100;   //reais = 53
            dezena = numero / 10;
            numero -= dezena * 10;      //reais = 3
            unidade = numero;
            return this;
        }
    }
}
