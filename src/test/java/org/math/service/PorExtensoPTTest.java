package org.math.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class PorExtensoPTTest {

    @Test
    public void assertionsUnidades() {
        assertEquals("sete", new PorExtensoPT().resultado(7));
        assertEquals("zero", new PorExtensoPT().resultado(0));
        assertEquals("três", new PorExtensoPT().resultado(3));
        assertEquals("oito", new PorExtensoPT().resultado(8));
    }

    @Test
    public void assertionsDezenas() {
        assertEquals("onze", new PorExtensoPT().resultado(11));
        assertEquals("dez", new PorExtensoPT().resultado(10));
        assertEquals("dezenove", new PorExtensoPT().resultado(19));
        assertEquals("trinta", new PorExtensoPT().resultado(30));
        assertEquals("noventa", new PorExtensoPT().resultado(90));
    }

    @Test
    public void assertionsCentenas() {
        assertEquals("trezentos e trinta e três", new PorExtensoPT().resultado(333));
        assertEquals("cem", new PorExtensoPT().resultado(100));
        assertEquals("cento e oitenta e seis", new PorExtensoPT().resultado(186));
    }

    @Test
    public void assertionsMilhares() {
        assertEquals("onze mil", new PorExtensoPT().resultado(11000));
        assertEquals("trezentos e trinta e três mil e quatrocentos e cinquenta", new PorExtensoPT().resultado(333450));
        assertEquals("duzentos mil", new PorExtensoPT().resultado(200000));
        assertEquals("noventa", new PorExtensoPT().resultado(90));
    }

}
