package br.pro.hashi.ensino.desagil.morse;

import java.util.LinkedList;
import java.util.Queue;

public class MorseToRoman {
    public MorseToRoman() {
        MorseTree tree = new MorseTree();
        Node[] nodes = tree.getNodes();
        Queue<Node> fila = new LinkedList<>();

        fila.add(nodes[0]);

        for(int i = 0; i < nodes.length; i++){
            String seq = "";
            fila.add(fila.peek().getLeft());
            fila.add(fila.peek().getRight());
            Node current = fila.peek();
            while(fila.peek().getParent() != null) {
                try {
                    if (current.getParent().getLeft() == current) {
                        seq = seq + ".";
                        current = current.getParent();
                    } else if(current.getParent().getRight() == current){
                        seq = seq + "-";
                        current = current.getParent();
                    }
                } catch (NullPointerException e){
                    break;
                }
            }

            String revseq = new StringBuilder(seq).reverse().toString();
            System.out.println("letra: " + fila.peek().getChar() + " | morse: "+ revseq);
            fila.remove(fila.peek());
        }

    }
}
