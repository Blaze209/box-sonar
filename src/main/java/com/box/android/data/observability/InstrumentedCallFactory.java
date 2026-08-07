package com.box.android.data.observability;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/* JADX INFO: compiled from: InstrumentedCallFactory.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/box/android/data/observability/InstrumentedCallFactory;", "Lokhttp3/Call$Factory;", "client", "Lokhttp3/OkHttpClient;", "rumInstrumentation", "Lcom/box/android/data/observability/RumInstrumentation;", "<init>", "(Lokhttp3/OkHttpClient;Lcom/box/android/data/observability/RumInstrumentation;)V", "rumOkHttpClientCallFactory", "newCall", "Lokhttp3/Call;", "request", "Lokhttp3/Request;", "injectTracingHeader", "getRumOkHttpClientCallFactory", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InstrumentedCallFactory implements Call.Factory {
    private final OkHttpClient client;
    private final RumInstrumentation rumInstrumentation;
    private Call.Factory rumOkHttpClientCallFactory;

    public InstrumentedCallFactory(OkHttpClient client, RumInstrumentation rumInstrumentation) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(rumInstrumentation, "rumInstrumentation");
        this.client = client;
        this.rumInstrumentation = rumInstrumentation;
    }

    @Override // okhttp3.Call.Factory
    public Call newCall(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        OkHttpClient rumOkHttpClientCallFactory = getRumOkHttpClientCallFactory();
        if (rumOkHttpClientCallFactory == null) {
            rumOkHttpClientCallFactory = this.client;
        }
        return rumOkHttpClientCallFactory.newCall(injectTracingHeader(request));
    }

    private final Request injectTracingHeader(Request request) {
        if (!this.rumInstrumentation.isInitialised()) {
            return request;
        }
        return request.newBuilder().headers(request.headers().newBuilder().add("X-Box-Force-Tracing", "1").build()).build();
    }

    private final Call.Factory getRumOkHttpClientCallFactory() {
        Call.Factory factory = this.rumOkHttpClientCallFactory;
        if (factory != null) {
            return factory;
        }
        if (!this.rumInstrumentation.isInitialised()) {
            return null;
        }
        Call.Factory factoryCreateRumOkHttpCallFactory = this.rumInstrumentation.createRumOkHttpCallFactory(this.client);
        this.rumOkHttpClientCallFactory = factoryCreateRumOkHttpCallFactory;
        return factoryCreateRumOkHttpCallFactory;
    }
}
