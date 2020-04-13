package org.math.enuns;

import org.apache.commons.lang3.StringUtils;

import java.util.stream.Stream;

public enum Language {

    PT, EN;

    public static String description() {
        return StringUtils.join(values(), ", ");
    }

    public static boolean notContains(String linguagem) {
        return Stream.of(values()).noneMatch(l -> l.name().equals(linguagem));

    }
}
