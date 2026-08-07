package com.box.androidsdk.content.requests;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxObject;

/* JADX INFO: loaded from: classes13.dex */
public interface BoxCacheableRequest<T extends BoxObject> {
    T sendForCachedResult() throws BoxException;

    BoxFutureTask<T> toTaskForCachedResult() throws BoxException;
}
