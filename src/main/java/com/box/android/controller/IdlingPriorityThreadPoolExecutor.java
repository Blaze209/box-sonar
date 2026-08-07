package com.box.android.controller;

import android.util.Log;
import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.IdlingResource;
import androidx.test.espresso.idling.CountingIdlingResource;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IdlingPriorityThreadPoolExecutor.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0007\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#BE\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u001e\u001a\u00020\u00192\b\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\b\u0010\"\u001a\u00020\u0019H\u0014R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/box/android/controller/IdlingPriorityThreadPoolExecutor;", "Lcom/box/android/controller/PriorityThreadPoolExecutor;", "Landroidx/test/espresso/IdlingResource;", "resourceName", "", "corePoolSize", "", "maximumPoolSize", "keepAliveTime", "", "unit", "Ljava/util/concurrent/TimeUnit;", "workQueue", "Ljava/util/concurrent/PriorityBlockingQueue;", "Ljava/lang/Runnable;", "factory", "Ljava/util/concurrent/ThreadFactory;", "<init>", "(Ljava/lang/String;IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/PriorityBlockingQueue;Ljava/util/concurrent/ThreadFactory;)V", "countingIdlingResource", "Landroidx/test/espresso/idling/CountingIdlingResource;", "getName", "isIdleNow", "", "registerIdleTransitionCallback", "", "callback", "Landroidx/test/espresso/IdlingResource$ResourceCallback;", "execute", "command", "afterExecute", "r", "t", "", "terminated", "Companion", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IdlingPriorityThreadPoolExecutor extends PriorityThreadPoolExecutor implements IdlingResource {
    private static final String LOG_TAG = "IdlingPriorityThreadPoolExec";
    private CountingIdlingResource countingIdlingResource;
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IdlingPriorityThreadPoolExecutor(String resourceName, int i, int i2, long j, TimeUnit unit, PriorityBlockingQueue<Runnable> workQueue, ThreadFactory factory) {
        super(i, i2, j, unit, workQueue, factory);
        Intrinsics.checkNotNullParameter(resourceName, "resourceName");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(workQueue, "workQueue");
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.countingIdlingResource = new CountingIdlingResource(resourceName);
        Log.i(LOG_TAG, "Register idling resource for thread pool " + resourceName);
        IdlingRegistry.getInstance().register(this);
    }

    @Override // androidx.test.espresso.IdlingResource
    public String getName() {
        String name = this.countingIdlingResource.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return name;
    }

    @Override // androidx.test.espresso.IdlingResource
    public boolean isIdleNow() {
        return this.countingIdlingResource.isIdleNow();
    }

    @Override // androidx.test.espresso.IdlingResource
    public void registerIdleTransitionCallback(IdlingResource.ResourceCallback callback) {
        this.countingIdlingResource.registerIdleTransitionCallback(callback);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable command) {
        this.countingIdlingResource.increment();
        super.execute(command);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable r, Throwable t) {
        this.countingIdlingResource.decrement();
        super.afterExecute(r, t);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void terminated() {
        super.terminated();
        Log.i(LOG_TAG, "Thread pool terminated, unregistering " + this.countingIdlingResource.getName());
        IdlingRegistry.getInstance().unregister(this);
    }
}
