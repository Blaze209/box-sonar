package com.box.androidsdk.content;

import com.box.androidsdk.content.models.BoxObject;
import com.box.androidsdk.content.requests.BoxCacheableRequest;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxResponse;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes13.dex */
public class BoxCacheFutureTask<T extends BoxObject, R extends BoxRequest & BoxCacheableRequest> extends BoxFutureTask<T> {
    public BoxCacheFutureTask(Class<T> cls, final R r, final BoxCache boxCache) {
        super(new Callable<BoxResponse<T>>() { // from class: com.box.androidsdk.content.BoxCacheFutureTask.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public BoxResponse<T> call() throws Exception {
                BoxObject boxObject = null;
                try {
                    e = null;
                    boxObject = boxCache.get(r);
                } catch (Exception e) {
                    e = e;
                }
                return new BoxResponse<>(boxObject, e, r);
            }
        }, r);
    }
}
