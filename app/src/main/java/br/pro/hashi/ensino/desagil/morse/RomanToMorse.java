package br.pro.hashi.ensino.desagil.morse;

import java.util.HashMap;

/**
 * Created by elisa on 26/04/2017.
 */

public class RomanToMorse {
    public String letterList;
    private MorseTree tree = new MorseTree();
    private HashMap<Character, String> dic;

    public RomanToMorse(){
        letterList = "abcdefghijklmnopqrstuvwxyz1234567890+=/";
        dic = new HashMap<>();
        for (int i=0; i < letterList.length(); i++) {
            String morse = tree.codigo(letterList.charAt(i));
            dic.put(letterList.charAt(i), morse);
        }
    }

    public HashMap<Character, String> getResult(){
        return dic;
    }
}
