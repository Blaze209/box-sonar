package com.box.android.services;

import android.os.Handler;
import android.os.Message;
import android.os.Process;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes13.dex */
public abstract class BoxAsyncTask<Params, Progress, Result> {
    private static final int CORE_POOL_SIZE = 8;
    private static final int KEEP_ALIVE = 10;
    private static final int MAXIMUM_POOL_SIZE = 128;
    private static final int MESSAGE_POST_CANCEL = 3;
    private static final int MESSAGE_POST_PROGRESS = 2;
    private static final int MESSAGE_POST_RESULT = 1;
    private static final ThreadPoolExecutor sExecutor;
    private static final InternalHandler sHandler;
    private static final ThreadFactory sThreadFactory;
    private static final BlockingQueue<Runnable> sWorkQueue;
    private final FutureTask<Result> mFuture;
    private volatile Status mStatus = Status.PENDING;
    private final WorkerRunnable<Params, Result> mWorker;

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    protected abstract Result doInBackground(Params... paramsArr);

    protected void onCancelled() {
    }

    protected void onPostExecute(Result result) {
    }

    protected void onPreExecute() {
    }

    protected void onProgressUpdate(Progress... progressArr) {
    }

    static {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        sWorkQueue = linkedBlockingQueue;
        ThreadFactory threadFactory = new ThreadFactory() { // from class: com.box.android.services.BoxAsyncTask.1
            private final AtomicInteger mCount = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "BoxBoxAsyncTask #" + this.mCount.getAndIncrement());
            }
        };
        sThreadFactory = threadFactory;
        sExecutor = new ThreadPoolExecutor(8, 128, 10L, TimeUnit.SECONDS, linkedBlockingQueue, threadFactory);
        sHandler = new InternalHandler();
    }

    protected BoxAsyncTask() {
        WorkerRunnable<Params, Result> workerRunnable = new WorkerRunnable<Params, Result>() { // from class: com.box.android.services.BoxAsyncTask.2
            @Override // java.util.concurrent.Callable
            public Result call() throws Exception {
                Process.setThreadPriority(10);
                return (Result) BoxAsyncTask.this.doInBackground(this.mParams);
            }
        };
        this.mWorker = workerRunnable;
        this.mFuture = new FutureTask<Result>(workerRunnable) { // from class: com.box.android.services.BoxAsyncTask.3
            @Override // java.util.concurrent.FutureTask
            protected void done() {
                Result result = null;
                try {
                    result = get();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                } catch (CancellationException unused2) {
                    BoxAsyncTask.sHandler.obtainMessage(3, new BoxAsyncTaskResult(BoxAsyncTask.this, null)).sendToTarget();
                    return;
                } catch (ExecutionException e) {
                    throw new RuntimeException("An error occured while executing doInBackground()", e.getCause());
                } catch (Throwable th) {
                    throw new RuntimeException("An error occured while executing doInBackground()", th);
                }
                BoxAsyncTask.sHandler.obtainMessage(1, new BoxAsyncTaskResult(BoxAsyncTask.this, result)).sendToTarget();
            }
        };
    }

    public final Status getStatus() {
        return this.mStatus;
    }

    public final boolean isCancelled() {
        return this.mFuture.isCancelled();
    }

    public final boolean cancel(boolean z) {
        return this.mFuture.cancel(z);
    }

    public final Result get() throws ExecutionException, InterruptedException {
        return this.mFuture.get();
    }

    public final Result get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.mFuture.get(j, timeUnit);
    }

    /* JADX INFO: renamed from: com.box.android.services.BoxAsyncTask$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$box$android$services$BoxAsyncTask$Status;

        static {
            int[] iArr = new int[Status.values().length];
            $SwitchMap$com$box$android$services$BoxAsyncTask$Status = iArr;
            try {
                iArr[Status.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$box$android$services$BoxAsyncTask$Status[Status.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$box$android$services$BoxAsyncTask$Status[Status.PENDING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public final BoxAsyncTask<Params, Progress, Result> execute(Params... paramsArr) {
        int i = AnonymousClass4.$SwitchMap$com$box$android$services$BoxAsyncTask$Status[this.mStatus.ordinal()];
        if (i == 1) {
            throw new IllegalStateException("Cannot execute task: the task is already running.");
        }
        if (i == 2) {
            throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
        }
        this.mStatus = Status.RUNNING;
        onPreExecute();
        this.mWorker.mParams = paramsArr;
        sExecutor.submit(this.mFuture);
        return this;
    }

    protected final void publishProgress(Progress... progressArr) {
        sHandler.obtainMessage(2, new BoxAsyncTaskResult(this, progressArr)).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish(Result result) {
        if (isCancelled()) {
            result = null;
        }
        onPostExecute(result);
        this.mStatus = Status.FINISHED;
    }

    private static class InternalHandler extends Handler {
        private InternalHandler() {
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            BoxAsyncTaskResult boxAsyncTaskResult = (BoxAsyncTaskResult) message.obj;
            int i = message.what;
            if (i == 1) {
                boxAsyncTaskResult.mTask.finish(boxAsyncTaskResult.mData[0]);
            } else if (i == 2) {
                boxAsyncTaskResult.mTask.onProgressUpdate(boxAsyncTaskResult.mData);
            } else {
                if (i != 3) {
                    return;
                }
                boxAsyncTaskResult.mTask.onCancelled();
            }
        }
    }

    private static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {
        Params[] mParams;

        private WorkerRunnable() {
        }
    }

    private static class BoxAsyncTaskResult<Data> {
        final Data[] mData;
        final BoxAsyncTask mTask;

        BoxAsyncTaskResult(BoxAsyncTask boxAsyncTask, Data... dataArr) {
            this.mTask = boxAsyncTask;
            this.mData = dataArr;
        }
    }
}
