package io.split.android.client.telemetry.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes4.dex */
public class AtomicLongArray {
    private static final int MAX_LENGTH = 23;
    private final AtomicLong[] array;

    public AtomicLongArray(int size) {
        AtomicLong[] atomicLongArr = new AtomicLong[size <= 0 ? 23 : size];
        this.array = atomicLongArr;
        int length = atomicLongArr.length;
        for (int i = 0; i < length; i++) {
            this.array[i] = new AtomicLong();
        }
    }

    public synchronized void increment(int index) {
        if (index >= 0) {
            AtomicLong[] atomicLongArr = this.array;
            if (index < atomicLongArr.length) {
                atomicLongArr[index].getAndIncrement();
            }
        }
    }

    public synchronized List<Long> fetchAndClearAll() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (AtomicLong atomicLong : this.array) {
            arrayList.add(Long.valueOf(atomicLong.longValue()));
        }
        int length = this.array.length;
        for (int i = 0; i < length; i++) {
            this.array[i] = new AtomicLong();
        }
        return arrayList;
    }
}
