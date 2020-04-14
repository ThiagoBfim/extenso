package org.math.service;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PorExtensoPT extends PorExtenso {

    private static final List<String> unidades = Collections.unmodifiableList(Arrays.asList("zero", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove"));
    private static final List<String> primeiraDezena = Collections.unmodifiableList(Arrays.asList("dez", "onze", "doze", "treze", "quatorze", "quinze", "dezesseis", "dezessete", "dezoito", "dezenove"));
    private static final List<String> dezendas = Collections.unmodifiableList(Arrays.asList("vinte", "trinta", "quarenta", "cinquenta", "sessenta", "setenta", "oitenta", "noventa"));
    private static final List<String> centenas = Collections.unmodifiableList(Arrays.asList("cem", "cento", "duzentos", "trezentos", "quatrocentos", "quinhentos", "seiscentos", "setecentos", "oitocentos", "novecentos"));

    @Override
    void appendMilhar(StringBuilder porExtenso, PorExtenso.SeparadorUnidades separadorUnidades) {
        if (separadorUnidades.getMilhares() == 1) {
            porExtenso.append("mil");
        } else if (separadorUnidades.getMilhares() >= 1) {
            SeparadorUnidades separadorUnidadesMilhar = new SeparadorUnidades(separadorUnidades.getMilhares());
            appendCentena(porExtenso, separadorUnidadesMilhar);
            appendDezena(porExtenso, separadorUnidadesMilhar);
            appendUnidadade(porExtenso, separadorUnidadesMilhar);
            porExtenso.append(" mil");
        }
    }

    @Override
    void appendCentena(StringBuilder porExtenso, PorExtenso.SeparadorUnidades separadorUnidades) {
        if (separadorUnidades.getCentenas() == 1 && separadorUnidades.getUnidades() == 0 && separadorUnidades.getDezenas() == 0) {
            porExtenso.append(centenas.get(separadorUnidades.getCentenas() - 1));
        } else if (separadorUnidades.getCentenas() > 0) {
            appendAnd(porExtenso);
            porExtenso.append(centenas.get(separadorUnidades.getCentenas()));
        }
    }

    @Override
    void appendDezena(StringBuilder porExtenso, PorExtenso.SeparadorUnidades separadorUnidades) {
        if (separadorUnidades.getDezenas() > 0) {
            appendAnd(porExtenso);
            if (separadorUnidades.getDezenas() == 1) {
                porExtenso.append(primeiraDezena.get(separadorUnidades.getUnidades()));
            } else {
                porExtenso.append(dezendas.get(separadorUnidades.getDezenas() - 2));
            }
        }
    }

    @Override
    void appendUnidadade(StringBuilder porExtenso, PorExtenso.SeparadorUnidades separadorUnidades) {
        if (separadorUnidades.getUnidades() > 0 && separadorUnidades.getDezenas() != 1) {
            appendAnd(porExtenso);
            porExtenso.append(unidades.get(separadorUnidades.getUnidades()));
        } else if (StringUtils.isEmpty(porExtenso) && separadorUnidades.getUnidades() == 0) {
            porExtenso.append(unidades.get(separadorUnidades.getUnidades()));
        }
    }

    private void appendAnd(StringBuilder porExtenso) {
        if (StringUtils.isNotEmpty(porExtenso)) {
            porExtenso.append(" e ");
        }
    }

}
