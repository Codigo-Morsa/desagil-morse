package br.pro.hashi.ensino.desagil.morse;

public class Node {
    private int value;
    private Node left;
    private Node right;
    private Node parent;
    private char character;

    public Node(int value, char character, Node left, Node right, Node parent) {
        this.value = value;
        this.character = character;
        this.left = left;
        this.right = right;
        this.parent = parent;


    }
    public Node getLeft() {
        return left;
    }
    public Node getRight() {
        return right;
    }
    public Node getParent() {
        return parent;
    }
    public char getChar() {
        return character;
    }
    public void setParent(Node parent){
        this.parent = parent;
    }
}
