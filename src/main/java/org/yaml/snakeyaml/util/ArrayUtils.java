package org.yaml.snakeyaml.util;

import java.util.AbstractList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class ArrayUtils {
    private ArrayUtils() {
    }

    public static <E> List<E> toUnmodifiableList(E[] eArr) {
        return eArr.length == 0 ? Collections.emptyList() : new UnmodifiableArrayList(eArr);
    }

    public static <E> List<E> toUnmodifiableCompositeList(E[] eArr, E[] eArr2) {
        if (eArr.length == 0) {
            return toUnmodifiableList(eArr2);
        }
        if (eArr2.length == 0) {
            return toUnmodifiableList(eArr);
        }
        return new CompositeUnmodifiableArrayList(eArr, eArr2);
    }

    private static class UnmodifiableArrayList<E> extends AbstractList<E> {
        private final E[] array;

        UnmodifiableArrayList(E[] eArr) {
            this.array = eArr;
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i) {
            E[] eArr = this.array;
            if (i >= eArr.length) {
                throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size());
            }
            return eArr[i];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.array.length;
        }
    }

    private static class CompositeUnmodifiableArrayList<E> extends AbstractList<E> {
        private final E[] array1;
        private final E[] array2;

        CompositeUnmodifiableArrayList(E[] eArr, E[] eArr2) {
            this.array1 = eArr;
            this.array2 = eArr2;
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i) {
            E[] eArr = this.array1;
            if (i < eArr.length) {
                return eArr[i];
            }
            int length = i - eArr.length;
            E[] eArr2 = this.array2;
            if (length < eArr2.length) {
                return eArr2[i - eArr.length];
            }
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.array1.length + this.array2.length;
        }
    }
}
