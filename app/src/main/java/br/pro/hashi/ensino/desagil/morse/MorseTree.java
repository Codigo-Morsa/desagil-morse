package br.pro.hashi.ensino.desagil.morse;

public class MorseTree {
    private Node current;
    private Node left;
    private Node right;
    private Node[] nodes;
    private String alphabet;

    public MorseTree() {
        int i;
        alphabet = "_etianmsurwdkgohvf_l_pjbxcyzq__54_3___2__+____16=/_____7___8_90_";

        nodes = new Node[63];
        for(i = nodes.length - 1; i >= nodes.length / 2; i--) {
            nodes[i] = new Node(i,alphabet.charAt(i), null, null);

        }

        for(i = nodes.length / 2 - 1; i >= 0; i--) {
            nodes[i] = new Node(i,alphabet.charAt(i),nodes[(2 * i) + 1], nodes[(2 * i) + 2]);
        }
    }


    public char translate(String code) {
        String[] parts = code.split("");

        current = nodes[0];
        left = current.getLeft();
        right = current.getRight();
        char translation = ' ';

        for (int i = 0; i < parts.length; i ++){
            System.out.println(parts[i]);
            if (parts[i].matches("-")){
                System.out.println("é traço");
                if (right.getChar() == '_'){
                    try{
                        if (right.getLeft().getChar() != '_' || right.getRight().getChar() != '_'){

                            current = right;
                            left = current.getLeft();
                            right = current.getRight();
                            translation = current.getChar();
                        }else{
                            translation = current.getChar();
                        }
                    }catch(NullPointerException e){

                        current = right;
                        translation = current.getChar();
                    }
                }else {
                    current = right;
                    left = current.getLeft();
                    right = current.getRight();
                    translation = current.getChar();

                }
            }
            else if (parts[i].matches(".")){
                System.out.println("é ponto");
                if (left.getChar() == '_'){
                    try{
                        if (left.getLeft().getChar() != '_' || left.getRight().getChar() != '_'){
                            current = left;
                            left = current.getLeft();
                            right = current.getRight();
                            translation = current.getChar();
                        }else{
                            translation = current.getChar();
                        }
                    }catch(NullPointerException e){

                        current = left;
                        translation = current.getChar();
                    }
                }else{
                    current = left;
                    left = current.getLeft();
                    right = current.getRight();
                    translation = current.getChar();

                }
            }
        }
        System.out.println(translation);
        return translation;
    }

}

