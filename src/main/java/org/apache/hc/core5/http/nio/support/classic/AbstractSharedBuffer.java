package org.apache.hc.core5.http.nio.support.classic;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.hc.core5.http.impl.nio.ExpandableBuffer;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
abstract class AbstractSharedBuffer extends ExpandableBuffer {
    volatile boolean aborted;
    final Condition condition;
    volatile boolean endStream;
    final ReentrantLock lock;

    public AbstractSharedBuffer(ReentrantLock reentrantLock, int i) {
        super(i);
        this.lock = (ReentrantLock) Args.notNull(reentrantLock, "Lock");
        this.condition = reentrantLock.newCondition();
    }

    @Override // org.apache.hc.core5.http.impl.nio.ExpandableBuffer
    public boolean hasData() {
        this.lock.lock();
        try {
            return super.hasData();
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.hc.core5.http.impl.nio.ExpandableBuffer
    public int capacity() {
        this.lock.lock();
        try {
            return super.capacity();
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.hc.core5.http.impl.nio.ExpandableBuffer
    public int length() {
        this.lock.lock();
        try {
            return super.length();
        } finally {
            this.lock.unlock();
        }
    }

    public void abort() {
        this.lock.lock();
        try {
            this.endStream = true;
            this.aborted = true;
            this.condition.signalAll();
        } finally {
            this.lock.unlock();
        }
    }

    public void reset() {
        if (this.aborted) {
            return;
        }
        this.lock.lock();
        try {
            setInputMode();
            buffer().clear();
            this.endStream = false;
        } finally {
            this.lock.unlock();
        }
    }

    public boolean isEndStream() {
        this.lock.lock();
        try {
            return this.endStream && !super.hasData();
        } finally {
            this.lock.unlock();
        }
    }
}
