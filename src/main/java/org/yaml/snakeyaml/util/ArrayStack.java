package org.yaml.snakeyaml.util;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class ArrayStack<T> {
    private final ArrayList<T> stack;

    public ArrayStack(int i) {
        this.stack = new ArrayList<>(i);
    }

    public void push(T t) {
        this.stack.add(t);
    }

    public T pop() {
        ArrayList<T> arrayList = this.stack;
        return arrayList.remove(arrayList.size() - 1);
    }

    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    public void clear() {
        this.stack.clear();
    }
}
