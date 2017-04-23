package br.pro.hashi.ensino.desagil.morse;

public class Node {
    private int value;
    private Node left;
    private Node right;
    private char character;

    public Node(int value, char character, Node left, Node right) {
        this.value = value;
        this.character = character;
        this.left = left;
        this.right = right;


    }
    public Node getLeft() {
        return left;
    }
    public Node getRight() {
        return right;
    }
    public char getChar() {
        return character;
    }
}
