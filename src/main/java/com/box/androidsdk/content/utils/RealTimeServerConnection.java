package com.box.androidsdk.content.utils;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxIteratorRealTimeServers;
import com.box.androidsdk.content.models.BoxRealTimeServer;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.models.BoxSimpleMessage;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxRequestsEvent;
import com.box.androidsdk.content.requests.BoxResponse;
import java.net.SocketTimeoutException;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes13.dex */
public class RealTimeServerConnection implements BoxFutureTask.OnCompletedListener<BoxSimpleMessage> {
    private BoxRealTimeServer mBoxRealTimeServer;
    private final OnChangeListener mChangeListener;
    private BoxRequest mRequest;
    private BoxSession mSession;
    private final ThreadPoolExecutor mExecutor = SdkUtils.createDefaultThreadPoolExecutor(1, 1, 3600, TimeUnit.SECONDS);
    private int mRetries = 0;

    public interface OnChangeListener {
        void onChange(BoxSimpleMessage boxSimpleMessage, RealTimeServerConnection realTimeServerConnection);

        void onException(Exception exc, RealTimeServerConnection realTimeServerConnection);
    }

    public RealTimeServerConnection(BoxRequest boxRequest, OnChangeListener onChangeListener, BoxSession boxSession) {
        this.mRequest = boxRequest;
        this.mSession = boxSession;
        this.mChangeListener = onChangeListener;
    }

    public BoxRequest getRequest() {
        return this.mRequest;
    }

    public int getTimesRetried() {
        return this.mRetries;
    }

    public BoxRealTimeServer getRealTimeServer() {
        return this.mBoxRealTimeServer;
    }

    public FutureTask<BoxSimpleMessage> toTask() {
        return new FutureTask<>(new Callable<BoxSimpleMessage>() { // from class: com.box.androidsdk.content.utils.RealTimeServerConnection.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public BoxSimpleMessage call() throws Exception {
                return RealTimeServerConnection.this.connect();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BoxSimpleMessage connect() {
        BoxFutureTask boxFutureTaskAddOnCompletedListener;
        this.mRetries = 0;
        try {
            this.mBoxRealTimeServer = (BoxRealTimeServer) ((BoxIteratorRealTimeServers) this.mRequest.send()).get(0);
            BoxRequestsEvent.LongPollMessageRequest longPollMessageRequest = new BoxRequestsEvent.LongPollMessageRequest(this.mBoxRealTimeServer.getUrl(), this.mSession);
            longPollMessageRequest.setTimeOut(this.mBoxRealTimeServer.getFieldRetryTimeout().intValue() * 1000);
            boolean z = true;
            do {
                try {
                    try {
                        boxFutureTaskAddOnCompletedListener = longPollMessageRequest.toTask().addOnCompletedListener(this);
                        try {
                            this.mExecutor.submit(boxFutureTaskAddOnCompletedListener);
                            BoxResponse boxResponse = boxFutureTaskAddOnCompletedListener.get(this.mBoxRealTimeServer.getFieldRetryTimeout().intValue(), TimeUnit.SECONDS);
                            if (boxResponse.isSuccess() && !((BoxSimpleMessage) boxResponse.getResult()).getMessage().equals(BoxSimpleMessage.MESSAGE_RECONNECT)) {
                                return (BoxSimpleMessage) boxResponse.getResult();
                            }
                        } catch (TimeoutException unused) {
                            if (boxFutureTaskAddOnCompletedListener != null) {
                                try {
                                    boxFutureTaskAddOnCompletedListener.cancel(true);
                                } catch (CancellationException unused2) {
                                }
                            }
                        }
                    } catch (TimeoutException unused3) {
                        boxFutureTaskAddOnCompletedListener = null;
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    this.mChangeListener.onException(e, this);
                } catch (ExecutionException e2) {
                    this.mChangeListener.onException(e2, this);
                }
                this.mRetries++;
                if (this.mBoxRealTimeServer.getMaxRetries().longValue() < this.mRetries) {
                    z = false;
                }
            } while (z);
            this.mChangeListener.onException(new BoxException.MaxAttemptsExceeded("Max retries exceeded, ", this.mRetries), this);
            return null;
        } catch (BoxException e3) {
            this.mChangeListener.onException(e3, this);
            return null;
        }
    }

    protected void handleResponse(BoxResponse<BoxSimpleMessage> boxResponse) {
        if (boxResponse.isSuccess()) {
            if (((BoxSimpleMessage) boxResponse.getResult()).getMessage().equals(BoxSimpleMessage.MESSAGE_RECONNECT)) {
                return;
            }
            this.mChangeListener.onChange((BoxSimpleMessage) boxResponse.getResult(), this);
        } else {
            if ((boxResponse.getException() instanceof BoxException) && (boxResponse.getException().getCause() instanceof SocketTimeoutException)) {
                return;
            }
            this.mChangeListener.onException(boxResponse.getException(), this);
        }
    }

    @Override // com.box.androidsdk.content.BoxFutureTask.OnCompletedListener
    public void onCompleted(BoxResponse<BoxSimpleMessage> boxResponse) {
        handleResponse(boxResponse);
    }
}
