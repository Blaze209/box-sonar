package com.box.android.data.observability;

import android.app.Application;
import androidx.media3.common.MimeTypes;
import io.opentelemetry.api.trace.Span;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import okhttp3.Call;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: SplunkRumInstrumentation.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&JL\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00032\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0007H&J3\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH&¢\u0006\u0002\u0010\u001b¨\u0006\u001cÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/observability/RumInstrumentation;", "", "isInitialised", "", "initialise", "", "applicationName", "", "environment", "proxyUrl", "debug", "headersSupplier", "Lkotlin/Function0;", "", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "createRumOkHttpCallFactory", "Lokhttp3/Call$Factory;", "client", "Lokhttp3/OkHttpClient;", "startSpan", "Lio/opentelemetry/api/trace/Span;", "workflowName", "operationName", "parent", "startTimestamp", "", "(Ljava/lang/String;Ljava/lang/String;Lio/opentelemetry/api/trace/Span;Ljava/lang/Long;)Lio/opentelemetry/api/trace/Span;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface RumInstrumentation {
    Call.Factory createRumOkHttpCallFactory(OkHttpClient client);

    void initialise(String applicationName, String environment, String proxyUrl, boolean debug, Function0<? extends Map<String, String>> headersSupplier, Application application);

    boolean isInitialised();

    Span startSpan(String workflowName);

    Span startSpan(String workflowName, String operationName, Span parent, Long startTimestamp);

    /* JADX INFO: compiled from: SplunkRumInstrumentation.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ void initialise$default(RumInstrumentation rumInstrumentation, String str, String str2, String str3, boolean z, Function0 function0, Application application, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initialise");
        }
        if ((i & 8) != 0) {
            z = false;
        }
        rumInstrumentation.initialise(str, str2, str3, z, function0, application);
    }
}
