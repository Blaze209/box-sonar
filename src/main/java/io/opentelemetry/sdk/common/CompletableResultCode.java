package io.opentelemetry.sdk.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class CompletableResultCode {
    private static final CompletableResultCode SUCCESS = new CompletableResultCode().succeed();
    private static final CompletableResultCode FAILURE = new CompletableResultCode().fail();

    @Nullable
    private Boolean succeeded = null;
    private final List<Runnable> completionActions = new ArrayList();
    private final Object lock = new Object();

    public static CompletableResultCode ofSuccess() {
        return SUCCESS;
    }

    public static CompletableResultCode ofFailure() {
        return FAILURE;
    }

    public static CompletableResultCode ofAll(Collection<CompletableResultCode> collection) {
        if (collection.isEmpty()) {
            return ofSuccess();
        }
        final CompletableResultCode completableResultCode = new CompletableResultCode();
        final AtomicInteger atomicInteger = new AtomicInteger(collection.size());
        final AtomicBoolean atomicBoolean = new AtomicBoolean();
        for (final CompletableResultCode completableResultCode2 : collection) {
            completableResultCode2.whenComplete(new Runnable() { // from class: io.opentelemetry.sdk.common.CompletableResultCode$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    CompletableResultCode.lambda$ofAll$0(this.f$0, atomicBoolean, atomicInteger, completableResultCode);
                }
            });
        }
        return completableResultCode;
    }

    static /* synthetic */ void lambda$ofAll$0(CompletableResultCode completableResultCode, AtomicBoolean atomicBoolean, AtomicInteger atomicInteger, CompletableResultCode completableResultCode2) {
        if (!completableResultCode.isSuccess()) {
            atomicBoolean.set(true);
        }
        if (atomicInteger.decrementAndGet() == 0) {
            if (atomicBoolean.get()) {
                completableResultCode2.fail();
            } else {
                completableResultCode2.succeed();
            }
        }
    }

    public CompletableResultCode succeed() {
        synchronized (this.lock) {
            if (this.succeeded == null) {
                this.succeeded = true;
                Iterator<Runnable> it = this.completionActions.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
            }
        }
        return this;
    }

    public CompletableResultCode fail() {
        synchronized (this.lock) {
            if (this.succeeded == null) {
                this.succeeded = false;
                Iterator<Runnable> it = this.completionActions.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
            }
        }
        return this;
    }

    public boolean isSuccess() {
        boolean z;
        synchronized (this.lock) {
            Boolean bool = this.succeeded;
            z = bool != null && bool.booleanValue();
        }
        return z;
    }

    public CompletableResultCode whenComplete(Runnable runnable) {
        boolean z;
        synchronized (this.lock) {
            if (this.succeeded != null) {
                z = true;
            } else {
                this.completionActions.add(runnable);
                z = false;
            }
        }
        if (z) {
            runnable.run();
        }
        return this;
    }

    public boolean isDone() {
        boolean z;
        synchronized (this.lock) {
            z = this.succeeded != null;
        }
        return z;
    }

    public CompletableResultCode join(long j, TimeUnit timeUnit) {
        if (isDone()) {
            return this;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Objects.requireNonNull(countDownLatch);
        whenComplete(new Runnable() { // from class: io.opentelemetry.sdk.common.CompletableResultCode$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await(j, timeUnit);
            return this;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return this;
        }
    }
}
