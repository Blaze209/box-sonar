package org.apache.hc.core5.http.config;

import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class NamedElementChain<E> {
    private final NamedElementChain<E>.Node master;
    private int size;

    public NamedElementChain() {
        NamedElementChain<E>.Node node = new Node("master", null);
        this.master = node;
        ((Node) node).previous = node;
        ((Node) node).next = node;
        this.size = 0;
    }

    public NamedElementChain<E>.Node getFirst() {
        NamedElementChain<E>.Node node = ((Node) this.master).next;
        NamedElementChain<E>.Node node2 = this.master;
        if (node != node2) {
            return ((Node) node2).next;
        }
        return null;
    }

    public NamedElementChain<E>.Node getLast() {
        NamedElementChain<E>.Node node = ((Node) this.master).previous;
        NamedElementChain<E>.Node node2 = this.master;
        if (node != node2) {
            return ((Node) node2).previous;
        }
        return null;
    }

    public NamedElementChain<E>.Node addFirst(E e, String str) {
        Args.notBlank(str, "Name");
        Args.notNull(e, "Value");
        NamedElementChain<E>.Node node = new Node(str, e);
        Node node2 = ((Node) this.master).next;
        ((Node) this.master).next = node;
        ((Node) node).previous = this.master;
        ((Node) node).next = node2;
        node2.previous = node;
        this.size++;
        return node;
    }

    public NamedElementChain<E>.Node addLast(E e, String str) {
        Args.notBlank(str, "Name");
        Args.notNull(e, "Value");
        NamedElementChain<E>.Node node = new Node(str, e);
        Node node2 = ((Node) this.master).previous;
        ((Node) this.master).previous = node;
        ((Node) node).previous = node2;
        ((Node) node).next = this.master;
        node2.next = node;
        this.size++;
        return node;
    }

    public NamedElementChain<E>.Node find(String str) {
        Args.notBlank(str, "Name");
        return doFind(str);
    }

    private NamedElementChain<E>.Node doFind(String str) {
        for (NamedElementChain<E>.Node node = ((Node) this.master).next; node != this.master; node = ((Node) node).next) {
            if (str.equals(((Node) node).name)) {
                return node;
            }
        }
        return null;
    }

    public NamedElementChain<E>.Node addBefore(String str, E e, String str2) {
        Args.notBlank(str2, "Name");
        Args.notNull(e, "Value");
        NamedElementChain<E>.Node nodeDoFind = doFind(str);
        if (nodeDoFind == null) {
            return null;
        }
        NamedElementChain<E>.Node node = new Node(str2, e);
        Node node2 = ((Node) nodeDoFind).previous;
        node2.next = node;
        ((Node) node).previous = node2;
        ((Node) node).next = nodeDoFind;
        ((Node) nodeDoFind).previous = node;
        this.size++;
        return node;
    }

    public NamedElementChain<E>.Node addAfter(String str, E e, String str2) {
        Args.notBlank(str2, "Name");
        Args.notNull(e, "Value");
        NamedElementChain<E>.Node nodeDoFind = doFind(str);
        if (nodeDoFind == null) {
            return null;
        }
        NamedElementChain<E>.Node node = new Node(str2, e);
        Node node2 = ((Node) nodeDoFind).next;
        ((Node) nodeDoFind).next = node;
        ((Node) node).previous = nodeDoFind;
        ((Node) node).next = node2;
        node2.previous = node;
        this.size++;
        return node;
    }

    public boolean remove(String str) {
        NamedElementChain<E>.Node nodeDoFind = doFind(str);
        if (nodeDoFind == null) {
            return false;
        }
        ((Node) nodeDoFind).previous.next = ((Node) nodeDoFind).next;
        ((Node) nodeDoFind).next.previous = ((Node) nodeDoFind).previous;
        ((Node) nodeDoFind).previous = null;
        ((Node) nodeDoFind).next = null;
        this.size--;
        return true;
    }

    public boolean replace(String str, E e) {
        NamedElementChain<E>.Node nodeDoFind = doFind(str);
        if (nodeDoFind == null) {
            return false;
        }
        ((Node) nodeDoFind).value = e;
        return true;
    }

    public int getSize() {
        return this.size;
    }

    public class Node {
        private final String name;
        private NamedElementChain<E>.Node next;
        private NamedElementChain<E>.Node previous;
        private E value;

        Node(String str, E e) {
            this.name = str;
            this.value = e;
        }

        public String getName() {
            return this.name;
        }

        public E getValue() {
            return this.value;
        }

        public NamedElementChain<E>.Node getPrevious() {
            if (this.previous != NamedElementChain.this.master) {
                return this.previous;
            }
            return null;
        }

        public NamedElementChain<E>.Node getNext() {
            if (this.next != NamedElementChain.this.master) {
                return this.next;
            }
            return null;
        }

        public String toString() {
            return this.name + ": " + this.value;
        }
    }
}
