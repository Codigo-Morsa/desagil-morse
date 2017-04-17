package br.pro.hashi.ensino.desagil.morse;

import java.util.LinkedList;

/**
 * Created by elisa on 17/04/2017.
 */

public class MsgList {
    private LinkedList<String> messages;

    public MsgList(){
        messages = new LinkedList<String>();
        messages.add(0, "URGENTE! Preciso de você!");
        messages.add(1, "Preciso de você.");
        messages.add(2, "Preciso de água.");
        messages.add(3, "Estou com dor.");
        messages.add(4, "Preciso ir ao banheiro.");
        messages.add(5, "Estou com fome.");

    }

    public getMessages(){
        return messages;
    }
}
