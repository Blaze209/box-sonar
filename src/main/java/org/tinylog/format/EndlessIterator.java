package org.tinylog.format;

import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
class EndlessIterator<E> implements Iterator<E> {
    private final E value;

    @Override // java.util.Iterator
    public boolean hasNext() {
        return true;
    }

    EndlessIterator(E e) {
        this.value = e;
    }

    @Override // java.util.Iterator
    public E next() {
        return this.value;
    }
}
