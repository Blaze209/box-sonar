package com.google.api.client.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes10.dex */
public final class Lists {
    public static <E> ArrayList<E> newArrayList() {
        return new ArrayList<>();
    }

    public static <E> ArrayList<E> newArrayListWithCapacity(int i) {
        return new ArrayList<>(i);
    }

    public static <E> ArrayList<E> newArrayList(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new ArrayList<>(Collections2.cast(iterable));
        }
        return newArrayList(iterable.iterator());
    }

    public static <E> ArrayList<E> newArrayList(Iterator<? extends E> it) {
        ArrayList<E> arrayListNewArrayList = newArrayList();
        while (it.hasNext()) {
            arrayListNewArrayList.add(it.next());
        }
        return arrayListNewArrayList;
    }

    private Lists() {
    }
}
