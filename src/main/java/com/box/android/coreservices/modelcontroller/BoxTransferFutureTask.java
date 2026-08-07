package com.box.android.coreservices.modelcontroller;

import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes9.dex */
public class BoxTransferFutureTask<E extends BoxMessage> extends BoxFutureTask<E> {
    public BoxTransferFutureTask(Callable<E> callable, long j) {
        super(callable, j);
    }

    @Override // com.box.android.coreservices.modelcontroller.BoxFutureTask, java.util.concurrent.FutureTask, java.util.concurrent.Future
    @Deprecated
    public E get() throws ExecutionException, InterruptedException {
        BoxLogUtils.w("You just called get() on a BoxTransferFutureTask! But BoxTransferFutureTasks are not submitted to an executor by default. Are you sure you didn't want to call runAndGet() instead?");
        return (E) super.get();
    }

    @Override // com.box.android.coreservices.modelcontroller.BoxFutureTask
    public E runAndGet() throws ExecutionException, InterruptedException {
        run();
        return (E) super.get();
    }
}
