package br.pro.hashi.ensino.desagil.morse;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class MorseTreeTest {
    private MorseTree tree;

    @Before
    public void setUp() {
        tree = new MorseTree();
    }
    @Test
    public void toA() {
        Assert.assertEquals('a', tree.translate(".-"));
    }
    @Test
    public void toB() {
        Assert.assertEquals('b', tree.translate("-..."));
    }
    @Test
    public void toC() {
        Assert.assertEquals('c', tree.translate("-.-."));
    }
    @Test
    public void toD() {
        Assert.assertEquals('d', tree.translate("-.."));
    }
    @Test
    public void toE() {
        Assert.assertEquals('e', tree.translate("."));
    }
    @Test
    public void toF() {
        Assert.assertEquals('f', tree.translate("..-."));
    }
    @Test
    public void toG() {
        Assert.assertEquals('g', tree.translate("--."));
    }
    @Test
    public void toH() {
        Assert.assertEquals('h', tree.translate("...."));
    }
    @Test
    public void toI() {
        Assert.assertEquals('i', tree.translate(".."));
    }
    @Test
    public void toJ() {
        Assert.assertEquals('j', tree.translate(".---"));
    }
    @Test
    public void toK() {
        Assert.assertEquals('k', tree.translate("-.-"));
    }
    @Test
    public void toL() {
        Assert.assertEquals('l', tree.translate(".-.."));
    }
    @Test
    public void toM() {
        Assert.assertEquals('m', tree.translate("--"));
    }
    @Test
    public void toN() {
        Assert.assertEquals('n', tree.translate("-."));
    }
    @Test
    public void toO() {
        Assert.assertEquals('o', tree.translate("---"));
    }
    @Test
    public void toP() {
        Assert.assertEquals('p', tree.translate(".--."));
    }
    @Test
    public void toQ() {
        Assert.assertEquals('q', tree.translate("--.-"));
    }
    @Test
    public void toR() {
        Assert.assertEquals('r', tree.translate(".-."));
    }
    @Test
    public void toS() {
        Assert.assertEquals('s', tree.translate("..."));
    }
    @Test
    public void toT() {
        Assert.assertEquals('t', tree.translate("-"));
    }
    @Test
    public void toU() {
        Assert.assertEquals('u', tree.translate("..-"));
    }
    @Test
    public void toV() {
        Assert.assertEquals('v', tree.translate("...-"));
    }
    @Test
    public void toW() {
        Assert.assertEquals('w', tree.translate(".--"));
    }
    @Test
    public void toX() {
        Assert.assertEquals('x', tree.translate("-..-"));
    }
    @Test
    public void toY() {
        Assert.assertEquals('y', tree.translate("-.--"));
    }
    @Test
    public void toZ() {
        Assert.assertEquals('z', tree.translate("--.."));
    }

    @Test
    public void to0() {
        Assert.assertEquals('0', tree.translate("-----"));
    }
    @Test
    public void to1() {
        Assert.assertEquals('1', tree.translate(".----"));
    }
    @Test
    public void to2() {
        Assert.assertEquals('2', tree.translate("..---"));
    }
    @Test
    public void to3() {
        Assert.assertEquals('3', tree.translate("...--"));
    }
    @Test
    public void to4() {
        Assert.assertEquals('4', tree.translate("....-"));
    }
    @Test
    public void to5() {
        Assert.assertEquals('5', tree.translate("....."));
    }
    @Test
    public void to6() {
        Assert.assertEquals('6', tree.translate("-...."));
    }
    @Test
    public void to7() {
        Assert.assertEquals('7', tree.translate("--..."));
    }
    @Test
    public void to8() {
        Assert.assertEquals('8', tree.translate("---.."));
    }
    @Test
    public void to9() {
        Assert.assertEquals('9', tree.translate("----."));
    }

}
