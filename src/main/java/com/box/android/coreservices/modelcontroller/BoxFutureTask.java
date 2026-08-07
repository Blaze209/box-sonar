package com.box.android.coreservices.modelcontroller;

import android.util.Log;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes9.dex */
public class BoxFutureTask<E extends BoxMessage> extends FutureTask<E> {
    private final FinalMessageListener<E> mFinalMessageListener;
    private final TaskPriority mPriority;
    private final long mRequestId;

    public interface FinalMessageListener<E extends BoxMessage> {
        void onGet(E e) throws ExecutionException, InterruptedException;
    }

    public enum TaskPriority {
        PRIORITY_HIGH,
        PRIORITY_MEDIUM,
        PRIORITY_LOW
    }

    public BoxFutureTask(Callable<E> callable, long j) {
        this(callable, j, TaskPriority.PRIORITY_MEDIUM);
    }

    public BoxFutureTask(Callable<E> callable, long j, TaskPriority taskPriority) {
        this(callable, j, null, taskPriority);
    }

    public BoxFutureTask(Callable<E> callable, long j, FinalMessageListener<E> finalMessageListener) {
        this(callable, j, finalMessageListener, TaskPriority.PRIORITY_MEDIUM);
    }

    public BoxFutureTask(Callable<E> callable, long j, FinalMessageListener<E> finalMessageListener, TaskPriority taskPriority) {
        super(callable);
        this.mRequestId = j;
        this.mFinalMessageListener = finalMessageListener;
        this.mPriority = taskPriority;
    }

    public long getId() {
        return this.mRequestId;
    }

    public E runAndGet() throws ExecutionException, InterruptedException {
        try {
            run();
        } catch (Exception e) {
            Log.d("runAndGet ", getClass().getName(), e);
        }
        return (E) get();
    }

    @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
    public E get() throws ExecutionException, InterruptedException {
        E e;
        try {
            e = (E) super.get();
        } catch (CancellationException e2) {
            throw new ExecutionException(e2);
        } catch (Exception e3) {
            Log.d("auth ", e3.getMessage() + getClass().getName() + Log.getStackTraceString(new Throwable()));
            e = null;
        }
        FinalMessageListener<E> finalMessageListener = this.mFinalMessageListener;
        if (finalMessageListener != null) {
            finalMessageListener.onGet(e);
        }
        return e;
    }

    public TaskPriority getPriority() {
        return this.mPriority;
    }
}
