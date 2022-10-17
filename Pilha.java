import java.util.EmptyStackException;

public class Pilha {

    private class Node {
        public String element;
        public Node next;

        public Node(String element) {
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

    public void push (String e){
        Node aux = new Node(e);
        aux.next = topo;
        topo = aux;
        count ++;
    }

    public String pop(){
        if(count == 0){
            throw new EmptyStackException();
        }
        count --;
        String aux = topo.element;
        topo = topo.next;
        return aux;
    }

    public String top() {
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

