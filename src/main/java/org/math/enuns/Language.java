package org.math.enuns;

import org.apache.commons.lang3.StringUtils;
import org.math.service.PorExtenso;
import org.math.service.PorExtensoEN;
import org.math.service.PorExtensoPT;

import java.util.stream.Stream;

public enum Language {

    PT(PorExtensoPT.class),
    EN(PorExtensoEN.class);

    private Class<? extends PorExtenso> porExtensoClass;

    Language(Class<? extends PorExtenso> porExtensoClass) {
        this.porExtensoClass = porExtensoClass;
    }

    public Class<? extends PorExtenso> getPorExtensoClass() {
        return porExtensoClass;
    }

    public static String description() {
        return StringUtils.join(values(), ", ");
    }

    public static boolean notContains(String linguagem) {
        return Stream.of(values()).noneMatch(l -> l.name().equals(linguagem));

    }
}
