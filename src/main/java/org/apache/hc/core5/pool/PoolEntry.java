package org.apache.hc.core5.pool;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.hc.core5.function.Supplier;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.io.ModalCloseable;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.Deadline;
import org.apache.hc.core5.util.TimeValue;

/* JADX INFO: loaded from: classes5.dex */
public final class PoolEntry<T, C extends ModalCloseable> {
    private final AtomicReference<C> connRef;
    private volatile long created;
    private final Supplier<Long> currentTimeSupplier;
    private final DisposalCallback<C> disposalCallback;
    private volatile Deadline expiryDeadline;
    private final T route;
    private volatile Object state;
    private final TimeValue timeToLive;
    private volatile long updated;
    private volatile Deadline validityDeadline;

    PoolEntry(T t, TimeValue timeValue, DisposalCallback<C> disposalCallback, Supplier<Long> supplier) {
        this.expiryDeadline = Deadline.MIN_VALUE;
        this.validityDeadline = Deadline.MIN_VALUE;
        this.route = (T) Args.notNull(t, "Route");
        this.timeToLive = TimeValue.defaultsToNegativeOneMillisecond(timeValue);
        this.connRef = new AtomicReference<>();
        this.disposalCallback = disposalCallback;
        this.currentTimeSupplier = supplier;
    }

    PoolEntry(T t, TimeValue timeValue, Supplier<Long> supplier) {
        this(t, timeValue, null, supplier);
    }

    public PoolEntry(T t, TimeValue timeValue, DisposalCallback<C> disposalCallback) {
        this(t, timeValue, disposalCallback, null);
    }

    public PoolEntry(T t, TimeValue timeValue) {
        this(t, timeValue, null, null);
    }

    public PoolEntry(T t) {
        this(t, null);
    }

    long getCurrentTime() {
        Supplier<Long> supplier = this.currentTimeSupplier;
        return supplier != null ? supplier.get().longValue() : System.currentTimeMillis();
    }

    public T getRoute() {
        return this.route;
    }

    public C getConnection() {
        return this.connRef.get();
    }

    public Deadline getValidityDeadline() {
        return this.validityDeadline;
    }

    public Object getState() {
        return this.state;
    }

    public long getCreated() {
        return this.created;
    }

    public long getUpdated() {
        return this.updated;
    }

    public Deadline getExpiryDeadline() {
        return this.expiryDeadline;
    }

    public boolean hasConnection() {
        return this.connRef.get() != null;
    }

    public void assignConnection(C c) {
        Args.notNull(c, "connection");
        if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.connRef, null, c)) {
            this.created = getCurrentTime();
            this.updated = this.created;
            this.validityDeadline = Deadline.calculate(this.created, this.timeToLive);
            this.expiryDeadline = this.validityDeadline;
            this.state = null;
            return;
        }
        throw new IllegalStateException("Connection already assigned");
    }

    public void discardConnection(CloseMode closeMode) {
        C andSet = this.connRef.getAndSet(null);
        if (andSet != null) {
            this.state = null;
            this.created = 0L;
            this.updated = 0L;
            this.expiryDeadline = Deadline.MIN_VALUE;
            this.validityDeadline = Deadline.MIN_VALUE;
            DisposalCallback<C> disposalCallback = this.disposalCallback;
            if (disposalCallback != null) {
                disposalCallback.execute(andSet, closeMode);
            } else {
                andSet.close(closeMode);
            }
        }
    }

    public void updateExpiry(TimeValue timeValue) {
        Args.notNull(timeValue, "Expiry time");
        long currentTime = getCurrentTime();
        this.expiryDeadline = Deadline.calculate(currentTime, timeValue).min(this.validityDeadline);
        this.updated = currentTime;
    }

    public void updateState(Object obj) {
        this.state = obj;
        this.updated = getCurrentTime();
    }

    public String toString() {
        return "[route:" + this.route + "][state:" + this.state + "]";
    }
}
