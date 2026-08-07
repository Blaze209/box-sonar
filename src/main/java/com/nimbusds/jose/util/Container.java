package com.nimbusds.jose.util;

import com.nimbusds.jose.shaded.jcip.NotThreadSafe;

/* JADX INFO: loaded from: classes3.dex */
@NotThreadSafe
public class Container<T> {
    private T item;

    public Container() {
    }

    public Container(T t) {
        this.item = t;
    }

    public T get() {
        return this.item;
    }

    public void set(T t) {
        this.item = t;
    }
}
