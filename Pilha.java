import java.util.EmptyStackException;

public class Pilha {

    private class Node {
        public char element;
        public Node next;

        public Node(char element) {
            this.element = element;
            next = null;
        }
    }

    private Node topo;
    private int count;

    public Pilha() {
        topo = null;
        count = 0;
    }

       public void push (char e){
        Node aux = new Node(e);
        aux.next = topo;
        topo = aux;
        count ++;
    }

    public char pop(){
        if(count == 0){
            throw new EmptyStackException();
        }
        count --;
        char aux = topo.element;
        topo = topo.next;
        return aux;
    }

    public char top() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return topo.element;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void clear() {
        topo = null;
        count = 0;
    }
}

