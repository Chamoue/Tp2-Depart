package ca.csf.pobj.tp2;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class ConvertIntToRomanTest {

    @Test
    public void onConvertIntToRomanMethod() {
        ConvertIntToRoman converter = new ConvertIntToRoman();

        //Basic roman letters
        Assert.assertTrue(converter.convertIntToRoman(1).contentEquals("I"));
        Assert.assertTrue(converter.convertIntToRoman(5).contentEquals("V"));
        Assert.assertTrue(converter.convertIntToRoman(10).contentEquals("X"));
        Assert.assertTrue(converter.convertIntToRoman(50).contentEquals("L"));
        Assert.assertTrue(converter.convertIntToRoman(100).contentEquals("C"));
        Assert.assertTrue(converter.convertIntToRoman(500).contentEquals("D"));
        Assert.assertTrue(converter.convertIntToRoman(1000).contentEquals("M"));

        //Testing Max
        Assert.assertTrue(converter.convertIntToRoman(4999).contentEquals("MMMMCMXCIX"));

        //Testing 9s
        Assert.assertTrue(converter.convertIntToRoman(9).contentEquals("IX"));
        Assert.assertTrue(converter.convertIntToRoman(99).contentEquals("XCIX"));
        Assert.assertTrue(converter.convertIntToRoman(999).contentEquals("CMXCIX"));
        Assert.assertTrue(converter.convertIntToRoman(1999).contentEquals("MCMXCIX"));

        //Testing 4s
        Assert.assertTrue(converter.convertIntToRoman(4).contentEquals("IV"));
        Assert.assertTrue(converter.convertIntToRoman(44).contentEquals("XLIV"));
        Assert.assertTrue(converter.convertIntToRoman(444).contentEquals("CDXLIV"));
        Assert.assertTrue(converter.convertIntToRoman(4444).contentEquals("MMMMCDXLIV"));


    }

    //BEN_CORRECTION : Les cas après le premier ne seront jamais exécutés, car une exception est lancée.
    //                 Pour que cela marche, il faut créer un test par cas.
    @Test(expected = IllegalArgumentException.class)
    public void onConvertIntToRomanMethodExcpetions() {
        ConvertIntToRoman converter = new ConvertIntToRoman();

        //0
        converter.convertIntToRoman(0);

        //Negative
        converter.convertIntToRoman(-1);
        converter.convertIntToRoman(-100);

        //Over 5000!!
        converter.convertIntToRoman(5000);
        converter.convertIntToRoman(100000);
    }

}