import java.util.EmptyStackException;

public class Pilha {

    private class Node {
        public Integer element;
        public Node next;

        public Node(Integer element) {
            this.element = element;
            next = null;
        }
    }

    private Node topo;
    private int count;
    private Pilha p;

    public Pilha() {
        p = new Pilha();
        topo = null;
        count = 0;
    }

       public void push (Integer e){
        Node aux = new Node(e);
        aux.next = topo;
        topo = aux;
        count++;
    }

    public Integer pop(){
        if(count == 0){
            throw new EmptyStackException();
        }
        count--;
        Integer aux = topo.element;
        topo = topo.next;
        return aux;
    }

    public Integer top() {
        if(p.isEmpty()){
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

