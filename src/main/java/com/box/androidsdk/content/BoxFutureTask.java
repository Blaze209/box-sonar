package com.box.androidsdk.content;

import com.box.androidsdk.content.models.BoxObject;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes13.dex */
public class BoxFutureTask<E extends BoxObject> extends FutureTask<BoxResponse<E>> {
    protected ArrayList<OnCompletedListener<E>> mCompletedListeners;
    protected final BoxRequest mRequest;

    public interface OnCompletedListener<E extends BoxObject> {
        void onCompleted(BoxResponse<E> boxResponse);
    }

    public BoxFutureTask(Class<E> cls, final BoxRequest boxRequest) {
        super(new Callable<BoxResponse<E>>() { // from class: com.box.androidsdk.content.BoxFutureTask.1
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
    }

    protected BoxFutureTask(Callable<BoxResponse<E>> callable, BoxRequest boxRequest) {
        super(callable);
        this.mCompletedListeners = new ArrayList<>();
        this.mRequest = boxRequest;
    }

    @Override // java.util.concurrent.FutureTask
    protected synchronized void done() {
        BoxResponse<E> boxResponse;
        try {
            boxResponse = get();
            e = null;
        } catch (InterruptedException e) {
            e = e;
            Thread.currentThread().interrupt();
            boxResponse = null;
        } catch (CancellationException | ExecutionException e2) {
            e = e2;
            boxResponse = null;
        }
        if (e != null) {
            boxResponse = new BoxResponse<>(null, new BoxException("Unable to retrieve response from FutureTask.", e), this.mRequest);
        }
        Iterator<OnCompletedListener<E>> it = this.mCompletedListeners.iterator();
        while (it.hasNext()) {
            it.next().onCompleted(boxResponse);
        }
    }

    public synchronized BoxFutureTask<E> addOnCompletedListener(OnCompletedListener<E> onCompletedListener) {
        this.mCompletedListeners.add(onCompletedListener);
        return this;
    }
}
