package com.box.android.data.observability;

import android.app.Application;
import androidx.media3.common.MimeTypes;
import com.box.android.common.utilities.ApplicationProvider;
import com.splunk.rum.SplunkRum;
import com.splunk.rum.SplunkRumBuilder;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanBuilder;
import io.opentelemetry.context.Context;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: SplunkRumInstrumentation.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016JJ\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00052\u0018\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\tH\u0016J3\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0002\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/box/android/data/observability/SplunkRumInstrumentation;", "Lcom/box/android/data/observability/RumInstrumentation;", "<init>", "()V", "isInitialised", "", "initialise", "", "applicationName", "", "environment", "proxyUrl", "debug", "headersSupplier", "Lkotlin/Function0;", "", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "createRumOkHttpCallFactory", "Lokhttp3/Call$Factory;", "client", "Lokhttp3/OkHttpClient;", "startSpan", "Lio/opentelemetry/api/trace/Span;", "workflowName", "operationName", "parent", "startTimestamp", "", "(Ljava/lang/String;Ljava/lang/String;Lio/opentelemetry/api/trace/Span;Ljava/lang/Long;)Lio/opentelemetry/api/trace/Span;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SplunkRumInstrumentation implements RumInstrumentation {
    @Inject
    public SplunkRumInstrumentation() {
    }

    @Override // com.box.android.data.observability.RumInstrumentation
    public boolean isInitialised() {
        return SplunkRum.isInitialized();
    }

    @Override // com.box.android.data.observability.RumInstrumentation
    public void initialise(String applicationName, String environment, String proxyUrl, boolean debug, final Function0<? extends Map<String, String>> headersSupplier, Application application) {
        Intrinsics.checkNotNullParameter(applicationName, "applicationName");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(proxyUrl, "proxyUrl");
        Intrinsics.checkNotNullParameter(headersSupplier, "headersSupplier");
        Intrinsics.checkNotNullParameter(application, "application");
        SplunkRumBuilder splunkRumBuilderDisableGzipCompression = SplunkRum.builder().setApplicationName(applicationName).setRumAccessToken("").setDeploymentEnvironment(environment).setBeaconEndpoint(proxyUrl).setHeadersSupplier(new Supplier() { // from class: com.box.android.data.observability.SplunkRumInstrumentation$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return SplunkRumInstrumentation.initialise$lambda$0(headersSupplier);
            }
        }).disableGzipCompression();
        if (debug) {
            splunkRumBuilderDisableGzipCompression.enableDebug();
        }
        splunkRumBuilderDisableGzipCompression.build(ApplicationProvider.getApplication());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map initialise$lambda$0(Function0 function0) {
        return (Map) function0.invoke();
    }

    @Override // com.box.android.data.observability.RumInstrumentation
    public Call.Factory createRumOkHttpCallFactory(OkHttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        Call.Factory factoryCreateRumOkHttpCallFactory = SplunkRum.getInstance().createRumOkHttpCallFactory(client);
        Intrinsics.checkNotNullExpressionValue(factoryCreateRumOkHttpCallFactory, "createRumOkHttpCallFactory(...)");
        return factoryCreateRumOkHttpCallFactory;
    }

    @Override // com.box.android.data.observability.RumInstrumentation
    public Span startSpan(String workflowName) {
        Intrinsics.checkNotNullParameter(workflowName, "workflowName");
        Span spanStartWorkflow = SplunkRum.getInstance().startWorkflow(workflowName);
        Intrinsics.checkNotNullExpressionValue(spanStartWorkflow, "startWorkflow(...)");
        return spanStartWorkflow;
    }

    @Override // com.box.android.data.observability.RumInstrumentation
    public Span startSpan(String workflowName, String operationName, Span parent, Long startTimestamp) {
        Intrinsics.checkNotNullParameter(operationName, "operationName");
        SpanBuilder spanBuilder = SplunkRum.getInstance().getOpenTelemetry().getTracer("BoxTracer").spanBuilder(operationName);
        if (workflowName != null) {
            spanBuilder.setAttribute("workflow.name", workflowName);
        }
        if (parent != null) {
            spanBuilder.setParent(Context.current().with(parent));
        }
        if (startTimestamp != null) {
            spanBuilder.setStartTimestamp(startTimestamp.longValue(), TimeUnit.MILLISECONDS);
        }
        Span spanStartSpan = spanBuilder.startSpan();
        Intrinsics.checkNotNullExpressionValue(spanStartSpan, "startSpan(...)");
        return spanStartSpan;
    }
}
