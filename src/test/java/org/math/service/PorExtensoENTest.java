package org.math.service;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class PorExtensoENTest {
    private static PorExtensoEN porExtensoEN;

    @BeforeClass
    public static void setUp() {
        porExtensoEN = new PorExtensoEN();
    }

    @Test
    public void assertionsUnidades() {
        assertEquals("minus five", porExtensoEN.resultado(-5));
        assertEquals("minus one", porExtensoEN.resultado(-1));
        assertEquals("zero", porExtensoEN.resultado(0));
        assertEquals("seven", porExtensoEN.resultado(7));
        assertEquals("three", porExtensoEN.resultado(3));
        assertEquals("eight", porExtensoEN.resultado(8));
        assertEquals("nine", porExtensoEN.resultado(9));
    }

    @Test
    public void assertionsDezenas() {
        assertEquals("minus ten", porExtensoEN.resultado(-10));
        assertEquals("minus nineteen", porExtensoEN.resultado(-19));
        assertEquals("ten", porExtensoEN.resultado(10));
        assertEquals("eleven", porExtensoEN.resultado(11));
        assertEquals("nineteen", porExtensoEN.resultado(19));
        assertEquals("thirty", porExtensoEN.resultado(30));
        assertEquals("forty four", porExtensoEN.resultado(44));
        assertEquals("ninety", porExtensoEN.resultado(90));
        assertEquals("ninety nine", porExtensoEN.resultado(99));
    }

    @Test
    public void assertionsCentenas() {
        assertEquals("minus one hundred", porExtensoEN.resultado(-100));
        assertEquals("minus one hundred eighty six", porExtensoEN.resultado(-186));
        assertEquals("one hundred", porExtensoEN.resultado(100));
        assertEquals("one hundred one", porExtensoEN.resultado(101));
        assertEquals("one hundred eighty six", porExtensoEN.resultado(186));
        assertEquals("three hundred thirty three", porExtensoEN.resultado(333));
        assertEquals("nine hundred ninety nine", porExtensoEN.resultado(999));
    }

    @Test
    public void assertionsMilhares() {
        assertEquals("minus one thousand", porExtensoEN.resultado(-1_000));
        assertEquals("minus one thousand one hundred", porExtensoEN.resultado(-1_100));
        assertEquals("one thousand", porExtensoEN.resultado(1_000));
        assertEquals("one thousand one hundred", porExtensoEN.resultado(1_100));
        assertEquals("eleven thousand", porExtensoEN.resultado(11_000));
        assertEquals("ninety four thousand five hundred eighty seven", porExtensoEN.resultado(94_587));
        assertEquals("three hundred thirty three thousand four hundred fifty", porExtensoEN.resultado(333_450));
        assertEquals("two hundred thousand", porExtensoEN.resultado(200_000));
        assertEquals("nine hundred ninety nine thousand nine hundred ninety nine", porExtensoEN.resultado(999_999));
    }

}
