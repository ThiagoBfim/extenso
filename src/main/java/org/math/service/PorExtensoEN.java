package org.math.service;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PorExtensoEN extends PorExtenso {

    private static final List<String> unidades = Collections.unmodifiableList(Arrays.asList("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"));
    private static final List<String> primeiraDezena = Collections.unmodifiableList(Arrays.asList("ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"));
    private static final List<String> dezendas = Collections.unmodifiableList(Arrays.asList("twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"));

    @Override
    void appendMilhar(StringBuilder porExtenso, SeparadorUnidades separadorUnidades) {
        if (separadorUnidades.getMilhares() > 0) {
            SeparadorUnidades separadorUnidadesMilhar = new SeparadorUnidades(separadorUnidades.getMilhares());
            appendCentena(porExtenso, separadorUnidadesMilhar);
            appendDezena(porExtenso, separadorUnidadesMilhar);
            appendUnidadade(porExtenso, separadorUnidadesMilhar);
            porExtenso.append(" thousand");
        }
    }

    @Override
    void appendCentena(StringBuilder porExtenso, SeparadorUnidades separadorUnidades) {
        if (separadorUnidades.getCentenas() > 0) {
            appendWhenPorExtensoIsNotEmpty(porExtenso, " ");
            porExtenso.append(unidades.get(separadorUnidades.getCentenas())).append(" hundred");
        }
    }

    @Override
    void appendDezena(StringBuilder porExtenso, SeparadorUnidades separadorUnidades) {
        if (separadorUnidades.getDezenas() > 0) {
            appendWhenPorExtensoIsNotEmpty(porExtenso, " and ");
            if (separadorUnidades.getDezenas() == 1) {
                porExtenso.append(primeiraDezena.get(separadorUnidades.getUnidades()));
            } else {
                porExtenso.append(dezendas.get(separadorUnidades.getDezenas() - 2));
            }
        }
    }

    @Override
    void appendUnidadade(StringBuilder porExtenso, SeparadorUnidades separadorUnidades) {
        if (separadorUnidades.getUnidades() > 0 && separadorUnidades.getDezenas() != 1) {
            appendWhenPorExtensoIsNotEmpty(porExtenso, " ");
            porExtenso.append(unidades.get(separadorUnidades.getUnidades()));
        } else if (StringUtils.isEmpty(porExtenso) && separadorUnidades.getUnidades() == 0) {
            porExtenso.append(unidades.get(separadorUnidades.getUnidades()));
        }
    }

    private void appendWhenPorExtensoIsNotEmpty(StringBuilder porExtenso, String value) {
        if (StringUtils.isNotEmpty(porExtenso)) {
            porExtenso.append(value);
        }
    }
}
