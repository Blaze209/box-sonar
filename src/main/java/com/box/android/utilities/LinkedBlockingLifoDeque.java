package com.box.android.utilities;

/* JADX INFO: loaded from: classes13.dex */
public class LinkedBlockingLifoDeque<T> extends LinkedBlockingDeque<T> {
    private static final long serialVersionUID = 1;

    public LinkedBlockingLifoDeque() {
    }

    public LinkedBlockingLifoDeque(int i) {
        super(i);
    }

    @Override // com.box.android.utilities.LinkedBlockingDeque, java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(T t) {
        return super.offerFirst(t);
    }
}
