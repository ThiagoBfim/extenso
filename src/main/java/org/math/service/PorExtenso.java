package org.math.service;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public abstract class PorExtenso {

    public String resultado(Integer numero) {
        boolean isNumeroNegativo = numero < 0;
        StringBuilder porExtenso = new StringBuilder();
        SeparadorUnidades separadorUnidades = new SeparadorUnidades(numero, isNumeroNegativo);
        appendMilhar(porExtenso, separadorUnidades);
        appendCentena(porExtenso, separadorUnidades);
        appendDezena(porExtenso, separadorUnidades);
        appendUnidadade(porExtenso, separadorUnidades);
        if (isNumeroNegativo) {
            porExtenso.insert(0, getNomenclaturaNegative().concat(" "));
        }
        return porExtenso.toString();
    }


    /**
     * Nome quando o número for negativo.
     * Exemplo: "menos"
     *
     * @return Nome quando for menos.
     */
    protected abstract String getNomenclaturaNegative();

    /**
     * Nome da unidade em milhar.
     * Exemplo: "mil"
     *
     * @return Nome da unidade em Milhar.
     */
    abstract String getNomenclaturaMilhar();

    /**
     * Lista contendo todas as opções de centenas, entre 100 e 900:
     * Exemplo: [cem, duzentos, trezentos, quatrocentos, ... novecentos]
     * <p>
     * Note: Essa lista deve conter exatamente 9 elementos.
     *
     * @return Lista contendo as opções de centenas.
     */
    abstract List<String> getCentenas();

    /**
     * Lista contendo todas as opções de dezenas, entre 10 e 19:
     * Exemplo: [dez, onze, doze, treze .... dezenove]
     * <p>
     * Note: Essa lista deve conter exatamente 10 elementos.
     *
     * @return Lista contendo as opções da primeira dezena.
     */
    abstract List<String> getPrimeiraDezena();

    /**
     * Lista contendo todas as opções de dezenas, entre 10 e 90:
     * Exemplo: [dez, vinte, trinta .... noventa]
     * <p>
     * Note: Essa lista deve conter exatamente 9 elementos.
     *
     * @return Lista contendo as opções de dezenas.
     */
    abstract List<String> getDezenas();

    /**
     * Lista contendo todas as opções de unidades, entre 0 e 9:
     * Exemplo: [zero, um, dois .... nove]
     * <p>
     * Note: Essa lista deve conter exatamente 10 elementos.
     *
     * @return Lista contendo as opções de unidades.
     */
    abstract List<String> getUnidades();

    /**
     * Valor a ser concatenado entre as unidades.
     * Exemplo: trinta "e" três.
     *
     * @return Valor a ser concatenado.
     */
    abstract String getConcatValue();

    protected void appendMilhar(StringBuilder porExtenso, SeparadorUnidades separadorUnidades) {
        if (separadorUnidades.getMilhares() > 0) {
            SeparadorUnidades separadorUnidadesMilhar = new SeparadorUnidades(separadorUnidades.getMilhares());
            appendCentena(porExtenso, separadorUnidadesMilhar);
            appendDezena(porExtenso, separadorUnidadesMilhar);
            appendUnidadade(porExtenso, separadorUnidadesMilhar);
            porExtenso.append(" ").append(getNomenclaturaMilhar());
        }
    }

    protected void appendCentena(StringBuilder porExtenso, SeparadorUnidades separadorUnidades) {
        if (separadorUnidades.getCentenas() > 0) {
            appendWhenPorExtensoIsNotEmpty(porExtenso, getConcatValue());
            porExtenso.append(getCentenas().get(separadorUnidades.getCentenas() - 1));
        }
    }

    protected void appendUnidadade(StringBuilder porExtenso, SeparadorUnidades separadorUnidades) {
        if (separadorUnidades.getUnidades() > 0 && separadorUnidades.getDezenas() != 1) {
            appendWhenPorExtensoIsNotEmpty(porExtenso, getConcatValue());
            porExtenso.append(getUnidades().get(separadorUnidades.getUnidades()));
        } else if (StringUtils.isEmpty(porExtenso) && separadorUnidades.getUnidades() == 0) {
            porExtenso.append(getUnidades().get(separadorUnidades.getUnidades()));
        }
    }

    protected void appendDezena(StringBuilder porExtenso, SeparadorUnidades separadorUnidades) {
        if (separadorUnidades.getDezenas() > 0) {
            appendWhenPorExtensoIsNotEmpty(porExtenso, getConcatValue());
            if (separadorUnidades.getDezenas() == 1) {
                porExtenso.append(getPrimeiraDezena().get(separadorUnidades.getUnidades()));
            } else {
                porExtenso.append(getDezenas().get(separadorUnidades.getDezenas() - 2));
            }
        }
    }

    final void appendWhenPorExtensoIsNotEmpty(StringBuilder porExtenso, String value) {
        if (StringUtils.isNotEmpty(porExtenso)) {
            porExtenso.append(value);
        }
    }

    protected static class SeparadorUnidades {
        private int milhares;
        private int centenas;
        private int dezenas;
        private int unidades;

        public SeparadorUnidades(int numero) {
            this(numero, false);
        }

        public SeparadorUnidades(int numero, boolean isNumeroNegativo) {
            if (isNumeroNegativo) {
                invoke(numero * -1);
            } else {
                invoke(numero);
            }
        }

        public int getMilhares() {
            return milhares;
        }

        public int getCentenas() {
            return centenas;
        }

        public int getDezenas() {
            return dezenas;
        }

        public int getUnidades() {
            return unidades;
        }

        private void invoke(int numero) {
            //Exemplo: 1553
            milhares = numero / 1000;
            numero -= milhares * 1000;  //553
            centenas = numero / 100;
            numero -= centenas * 100;   //53
            dezenas = numero / 10;
            numero -= dezenas * 10;      //3
            unidades = numero;
        }
    }
}
