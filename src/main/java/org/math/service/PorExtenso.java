package org.math.service;

public abstract class PorExtenso {


    public String resultado(Integer numero) {
        StringBuilder porExtenso = new StringBuilder();
        SeparadorUnidades separadorUnidades = new SeparadorUnidades(numero);
        appendMilhar(porExtenso, separadorUnidades);
        appendCentena(porExtenso, separadorUnidades);
        appendDezena(porExtenso, separadorUnidades);
        appendUnidadade(porExtenso, separadorUnidades);
        return porExtenso.toString();
    }

    abstract void appendMilhar(StringBuilder porExtenso, SeparadorUnidades separadorUnidades);

    abstract void appendCentena(StringBuilder porExtenso, SeparadorUnidades separadorUnidades);

    abstract void appendDezena(StringBuilder porExtenso, SeparadorUnidades separadorUnidades);

    abstract void appendUnidadade(StringBuilder porExtenso, SeparadorUnidades separadorUnidades);


    protected static class SeparadorUnidades {
        private Integer numero;
        private int milhares;
        private int centenas;
        private int dezenas;
        private int unidades;

        public SeparadorUnidades(Integer numero) {
            this.numero = numero;
            invoke();
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

        private void invoke() {
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
