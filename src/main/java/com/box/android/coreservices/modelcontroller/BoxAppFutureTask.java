package com.box.android.coreservices.modelcontroller;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxObject;
import com.box.androidsdk.content.requests.BoxCacheableRequest;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes9.dex */
public class BoxAppFutureTask<E extends BoxObject> extends FutureTask<BoxResponse<E>> {
    protected ArrayList<OnCompletedListener<E>> mCompletedListeners;
    private final BoxFutureTask.TaskPriority mPriority;
    protected final BoxRequest mRequest;
    private long requestId;

    public interface OnCompletedListener<E extends BoxObject> {
        void onCompleted(BoxResponse<E> boxResponse);
    }

    public <R extends BoxRequest<T, R>, T extends BoxObject> BoxAppFutureTask(BoxRequest<T, R> boxRequest) {
        this(boxRequest, BoxFutureTask.TaskPriority.PRIORITY_MEDIUM);
    }

    public <R extends BoxRequest<T, R>, T extends BoxObject> BoxAppFutureTask(final BoxRequest<T, R> boxRequest, BoxFutureTask.TaskPriority taskPriority) {
        super(new Callable<BoxResponse<E>>() { // from class: com.box.android.coreservices.modelcontroller.BoxAppFutureTask.1
            @Override // java.util.concurrent.Callable
            public BoxResponse<E> call() throws Exception {
                BoxObject boxObjectSend = null;
                try {
                    e = null;
                    boxObjectSend = boxRequest.send();
                } catch (Exception e) {
                    e = e;
                }
                return new BoxResponse<>(boxObjectSend, e, boxRequest);
            }
        });
        this.mCompletedListeners = new ArrayList<>();
        this.mRequest = boxRequest;
        this.mPriority = BoxFutureTask.TaskPriority.PRIORITY_MEDIUM;
    }

    public <R extends BoxRequest<T, R> & BoxCacheableRequest<T>, T extends BoxObject> BoxAppFutureTask(BoxRequest<T, R> boxRequest, boolean z) {
        this(boxRequest, BoxFutureTask.TaskPriority.PRIORITY_MEDIUM, z);
    }

    public <R extends BoxRequest<T, R> & BoxCacheableRequest<T>, T extends BoxObject> BoxAppFutureTask(final BoxRequest<T, R> boxRequest, BoxFutureTask.TaskPriority taskPriority, final boolean z) {
        super(new Callable<BoxResponse<E>>() { // from class: com.box.android.coreservices.modelcontroller.BoxAppFutureTask.2
            @Override // java.util.concurrent.Callable
            public BoxResponse<E> call() throws Exception {
                BoxObject boxObjectSendForCachedResult = null;
                try {
                    e = null;
                    boxObjectSendForCachedResult = z ? ((BoxCacheableRequest) boxRequest).sendForCachedResult() : boxRequest.send();
                } catch (Exception e) {
                    e = e;
                }
                return new BoxResponse<>(boxObjectSendForCachedResult, e, boxRequest);
            }
        });
        this.mCompletedListeners = new ArrayList<>();
        this.mRequest = boxRequest;
        this.mPriority = BoxFutureTask.TaskPriority.PRIORITY_MEDIUM;
    }

    @Override // java.util.concurrent.FutureTask
    protected void done() {
        BoxResponse<E> boxResponse;
        super.done();
        if (isCancelled()) {
            return;
        }
        try {
            boxResponse = (BoxResponse) get();
            e = null;
        } catch (InterruptedException e) {
            e = e;
            Thread.currentThread().interrupt();
            boxResponse = null;
        } catch (ExecutionException e2) {
            e = e2;
            boxResponse = null;
        }
        if (e != null) {
            boxResponse = new BoxResponse<>(null, new BoxException("Unable to retrieve response from FutureTask.", e), this.mRequest);
        }
        Iterator<OnCompletedListener<E>> it = getCompletionListeners().iterator();
        while (it.hasNext()) {
            it.next().onCompleted(boxResponse);
        }
    }

    public ArrayList<OnCompletedListener<E>> getCompletionListeners() {
        return this.mCompletedListeners;
    }

    public BoxAppFutureTask<E> addOnCompletedListener(OnCompletedListener<E> onCompletedListener) {
        if (onCompletedListener == null) {
            return this;
        }
        this.mCompletedListeners.add(onCompletedListener);
        return this;
    }

    public void setRequestId(long j) {
        this.requestId = j;
    }

    public long getRequestId() {
        return this.requestId;
    }

    public BoxFutureTask.TaskPriority getPriority() {
        return this.mPriority;
    }
}
