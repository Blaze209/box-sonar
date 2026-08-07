package org.apache.hc.core5.http.message;

import java.util.List;
import java.util.function.Consumer;
import org.apache.hc.core5.http.HeaderElement;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class MessageSupport$$ExternalSyntheticLambda0 implements Consumer {
    public final /* synthetic */ List f$0;

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f$0.add((HeaderElement) obj);
    }
}
