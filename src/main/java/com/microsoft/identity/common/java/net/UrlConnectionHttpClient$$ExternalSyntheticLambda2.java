package com.microsoft.identity.common.java.net;

import com.microsoft.identity.common.java.util.ported.Consumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class UrlConnectionHttpClient$$ExternalSyntheticLambda2 implements Consumer {
    @Override // com.microsoft.identity.common.java.util.ported.Consumer
    public final void accept(Object obj) {
        UrlConnectionHttpClient.recordHttpTelemetryEventEnd((HttpResponse) obj);
    }
}
