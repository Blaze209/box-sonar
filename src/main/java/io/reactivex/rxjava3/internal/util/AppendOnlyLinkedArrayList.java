package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.functions.Predicate;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
public class AppendOnlyLinkedArrayList<T> {
    final int capacity;
    final Object[] head;
    int offset;
    Object[] tail;

    public interface NonThrowingPredicate<T> extends Predicate<T> {
        @Override // io.reactivex.rxjava3.functions.Predicate
        boolean test(T t);
    }

    public AppendOnlyLinkedArrayList(int capacity) {
        this.capacity = capacity;
        Object[] objArr = new Object[capacity + 1];
        this.head = objArr;
        this.tail = objArr;
    }

    public void add(T value) {
        int i = this.capacity;
        int i2 = this.offset;
        if (i2 == i) {
            Object[] objArr = new Object[i + 1];
            this.tail[i] = objArr;
            this.tail = objArr;
            i2 = 0;
        }
        this.tail[i2] = value;
        this.offset = i2 + 1;
    }

    public void setFirst(T value) {
        this.head[0] = value;
    }

    public void forEachWhile(NonThrowingPredicate<? super T> consumer) {
        int i = this.capacity;
        for (Object[] objArr = this.head; objArr != null; objArr = (Object[]) objArr[i]) {
            for (int i2 = 0; i2 < i; i2++) {
                Object obj = objArr[i2];
                if (obj == null) {
                    break;
                } else {
                    if (consumer.test(obj)) {
                        return;
                    }
                }
            }
        }
    }

    public <U> boolean accept(Subscriber<? super U> subscriber) {
        Object[] objArr = this.head;
        int i = this.capacity;
        while (true) {
            if (objArr == null) {
                return false;
            }
            for (int i2 = 0; i2 < i; i2++) {
                Object[] objArr2 = objArr[i2];
                if (objArr2 == null) {
                    break;
                }
                if (NotificationLite.acceptFull(objArr2, subscriber)) {
                    return true;
                }
            }
            objArr = objArr[i];
        }
    }

    public <U> boolean accept(Observer<? super U> observer) {
        Object[] objArr = this.head;
        int i = this.capacity;
        while (true) {
            if (objArr == null) {
                return false;
            }
            for (int i2 = 0; i2 < i; i2++) {
                Object[] objArr2 = objArr[i2];
                if (objArr2 == null) {
                    break;
                }
                if (NotificationLite.acceptFull(objArr2, observer)) {
                    return true;
                }
            }
            objArr = objArr[i];
        }
    }

    public <S> void forEachWhile(S state, BiPredicate<? super S, ? super T> consumer) throws Throwable {
        Object[] objArr = this.head;
        int i = this.capacity;
        while (true) {
            for (int i2 = 0; i2 < i; i2++) {
                Object obj = objArr[i2];
                if (obj == null || consumer.test(state, obj)) {
                    return;
                }
            }
            objArr = (Object[]) objArr[i];
        }
    }
}
