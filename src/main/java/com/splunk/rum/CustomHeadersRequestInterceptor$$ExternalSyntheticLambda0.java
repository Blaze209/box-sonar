package com.splunk.rum;

import java.util.function.BiConsumer;
import okhttp3.Request;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class CustomHeadersRequestInterceptor$$ExternalSyntheticLambda0 implements BiConsumer {
    public final /* synthetic */ Request.Builder f$0;

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        this.f$0.header((String) obj, (String) obj2);
    }
}
