package com.box.androidsdk.content.models;

import com.box.androidsdk.content.models.BoxJsonObject;
import com.eclipsesource.json.JsonArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public class BoxArray<E extends BoxJsonObject> implements Collection<E> {
    protected final Collection<E> collection = new ArrayList();

    public String toJson() {
        JsonArray jsonArray = new JsonArray();
        for (int i = 0; i < size(); i++) {
            jsonArray.add(get(i).toJsonObject());
        }
        return jsonArray.toString();
    }

    @Override // java.util.Collection
    public boolean add(E e) {
        return this.collection.add(e);
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        return this.collection.addAll(collection);
    }

    @Override // java.util.Collection
    public void clear() {
        this.collection.clear();
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return this.collection.contains(obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return this.collection.containsAll(collection);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return this.collection.equals(obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return this.collection.hashCode();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.collection.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return this.collection.iterator();
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        return this.collection.remove(obj);
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        return this.collection.removeAll(collection);
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        return this.collection.retainAll(collection);
    }

    @Override // java.util.Collection
    public int size() {
        return this.collection.size();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return this.collection.toArray();
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.collection.toArray(tArr);
    }

    public E get(int i) {
        Collection<E> collection = this.collection;
        if (collection instanceof List) {
            return (E) ((List) collection).get(i);
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException();
        }
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (i == 0) {
                return it.next();
            }
            it.next();
        }
        throw new IndexOutOfBoundsException();
    }
}
