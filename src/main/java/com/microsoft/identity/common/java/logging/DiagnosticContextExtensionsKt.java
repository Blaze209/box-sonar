package com.microsoft.identity.common.java.logging;

import com.microsoft.identity.common.internal.broker.ipc.WebAppsAdditionalRequiredParameters;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DiagnosticContextExtensions.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¨\u0006\u0007"}, d2 = {"withInitializedContext", "Ljava/lang/AutoCloseable;", "Lcom/microsoft/identity/common/java/logging/DiagnosticContext;", "correlationId", "", WebAppsAdditionalRequiredParameters.FIELD_SDK_TYPE, "sdkVersion", "common4j"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DiagnosticContextExtensionsKt {
    public static final AutoCloseable withInitializedContext(final DiagnosticContext diagnosticContext, String correlationId, String sdkType, String sdkVersion) {
        Intrinsics.checkNotNullParameter(diagnosticContext, "<this>");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        Intrinsics.checkNotNullParameter(sdkType, "sdkType");
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        RequestContext requestContext = new RequestContext();
        requestContext.put("correlation_id", correlationId);
        requestContext.put("x-client-SKU", sdkType);
        requestContext.put("x-client-Ver", sdkVersion);
        diagnosticContext.setRequestContext(requestContext);
        return new AutoCloseable() { // from class: com.microsoft.identity.common.java.logging.DiagnosticContextExtensionsKt$$ExternalSyntheticLambda0
            @Override // java.lang.AutoCloseable
            public final void close() {
                DiagnosticContextExtensionsKt.withInitializedContext$lambda$1(diagnosticContext);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void withInitializedContext$lambda$1(DiagnosticContext this_withInitializedContext) {
        Intrinsics.checkNotNullParameter(this_withInitializedContext, "$this_withInitializedContext");
        this_withInitializedContext.clear();
    }
}
