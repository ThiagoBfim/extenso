package org.math.service;

import org.math.enuns.Language;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class PorExtensoFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(PorExtensoFactory.class);

    private static Map<Language, PorExtenso> mapPorExtenso = new HashMap<>();

    private PorExtensoFactory() {
        throw new AssertionError("Cannot instantiate the class");
    }

    public static synchronized PorExtenso getPorExtensoInstance(Language language) {
        PorExtenso porExtenso = mapPorExtenso.get(language);
        if (porExtenso == null) {
            try {
                mapPorExtenso.put(language, language.getPorExtensoClass().newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                LOGGER.error("Error getting an instance of PorExtenso with language: {}", language, e);
            }
        }
        return mapPorExtenso.get(language);
    }
}
