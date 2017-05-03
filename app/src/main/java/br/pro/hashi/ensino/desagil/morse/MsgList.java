package br.pro.hashi.ensino.desagil.morse;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by elisa on 17/04/2017.
 */

public class MsgList {
    private LinkedList<String> messages;

    public MsgList(){
        messages = new LinkedList<String>();
        messages.add(0,"Escolha uma mensagem nas setas");
        messages.add(1, "URGENTE! Preciso de você!");
        messages.add(2, "Preciso de você.");
        messages.add(3, "Preciso de água.");
        messages.add(4, "Estou com dor.");
        messages.add(5, "Preciso ir ao banheiro.");
        messages.add(6, "Estou com fome.");

    }

    public List<String> getMessages(){

        return messages;
    }
}
