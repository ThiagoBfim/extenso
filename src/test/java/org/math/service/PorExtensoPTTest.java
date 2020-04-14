package org.math.service;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class PorExtensoPTTest {

    private static PorExtensoPT porExtensoPT;
    @BeforeClass
    public static void setUp() throws Exception {
        porExtensoPT = new PorExtensoPT();
    }

    @Test
    public void assertionsUnidades() {
        assertEquals("zero", porExtensoPT.resultado(0));
        assertEquals("sete", porExtensoPT.resultado(7));
        assertEquals("três", porExtensoPT.resultado(3));
        assertEquals("oito", porExtensoPT.resultado(8));
        assertEquals("nove", porExtensoPT.resultado(9));
    }

    @Test
    public void assertionsDezenas() {
        assertEquals("dez", porExtensoPT.resultado(10));
        assertEquals("onze", porExtensoPT.resultado(11));
        assertEquals("dezenove", porExtensoPT.resultado(19));
        assertEquals("trinta", porExtensoPT.resultado(30));
        assertEquals("quarenta e quatro", porExtensoPT.resultado(44));
        assertEquals("noventa", porExtensoPT.resultado(90));
        assertEquals("noventa e nove", porExtensoPT.resultado(99));
    }

    @Test
    public void assertionsCentenas() {
        assertEquals("cem", porExtensoPT.resultado(100));
        assertEquals("trezentos e trinta e três", porExtensoPT.resultado(333));
        assertEquals("cento e oitenta e seis", porExtensoPT.resultado(186));
        assertEquals("novecentos e noventa e nove", porExtensoPT.resultado(999));
    }

    @Test
    public void assertionsMilhares() {
        assertEquals("mil", porExtensoPT.resultado(1_000));
        assertEquals("onze mil", porExtensoPT.resultado(11_000));
        assertEquals("trezentos e trinta e três mil e quatrocentos e cinquenta", porExtensoPT.resultado(333_450));
        assertEquals("duzentos mil", porExtensoPT.resultado(200_000));
        assertEquals("novecentos e noventa e nove mil e novecentos e noventa e nove", porExtensoPT.resultado(999_999));
    }

}
