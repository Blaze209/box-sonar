package com.box.androidsdk.content.requests;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxIterator;
import com.box.androidsdk.content.models.BoxIteratorBoxEntity;
import com.box.androidsdk.content.models.BoxObject;

/* JADX INFO: loaded from: classes13.dex */
public class MultiputResponseHandler extends BoxRequest.BoxRequestHandler<BoxRequestsFile.CommitUploadSession> {
    protected static final int DEFAULT_MAX_WAIT_MILLIS = 90000;
    protected static final int DEFAULT_NUM_RETRIES = 2;
    protected int mNumAcceptedRetries;
    protected int mRetryAfterMillis;

    public MultiputResponseHandler(BoxRequestsFile.CommitUploadSession commitUploadSession) {
        super(commitUploadSession);
        this.mNumAcceptedRetries = 0;
        this.mRetryAfterMillis = 1000;
    }

    @Override // com.box.androidsdk.content.requests.BoxRequest.BoxRequestHandler
    public <T extends BoxObject> T onResponse(Class<T> cls, BoxHttpResponse boxHttpResponse) throws IllegalAccessException, BoxException, InstantiationException {
        if (boxHttpResponse.getResponseCode() == 202) {
            try {
                int i = this.mNumAcceptedRetries;
                if (i < 2) {
                    this.mNumAcceptedRetries = i + 1;
                    this.mRetryAfterMillis = getRetryAfterFromResponse(boxHttpResponse, 1);
                } else {
                    int i2 = this.mRetryAfterMillis;
                    if (i2 < DEFAULT_MAX_WAIT_MILLIS) {
                        this.mRetryAfterMillis = (int) (((double) i2) * (Math.random() + 1.5d));
                    } else {
                        throw new BoxException.MaxAttemptsExceeded("Max wait time exceeded.", this.mNumAcceptedRetries);
                    }
                }
                Thread.sleep(this.mRetryAfterMillis);
                return (T) ((BoxRequestsFile.CommitUploadSession) this.mRequest).send();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new BoxException(e.getMessage(), boxHttpResponse);
            }
        }
        return ((BoxIterator) super.onResponse(BoxIteratorBoxEntity.class, boxHttpResponse)).get(0);
    }
}
