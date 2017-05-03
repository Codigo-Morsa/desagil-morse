package br.pro.hashi.ensino.desagil.morse;

import java.util.HashMap;

/**
 * Created by elisa on 26/04/2017.
 */

public class RomanToMorse {
    public String letterList;
    private MorseTree tree = new MorseTree();
    private String[] dicMorse;
    private String morse;

    public RomanToMorse(){
        letterList = "abcdefghijklmnopqrstuvwxyz1234567890+=/";
        dicMorse = new String[letterList.length()];


        for (int i=0; i < letterList.length(); i++) {
            morse = tree.codigo(letterList.charAt(i));
            dicMorse[i] = morse;

        }
    }

    public String[] getResult(){
        return dicMorse;
    }
}
