package com.microsoft.identity.common.java.opentelemetry;

import com.microsoft.identity.common.internal.broker.ipc.WebAppsAdditionalRequiredParameters;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import kotlin.Metadata;

/* JADX INFO: compiled from: IOTelSpanFactory.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u001a\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\n"}, d2 = {"Lcom/microsoft/identity/common/java/opentelemetry/IOTelSpanFactory;", "", "createSpan", "Lio/opentelemetry/api/trace/Span;", "name", "", WebAppsAdditionalRequiredParameters.FIELD_CALLING_PACKAGE_NAME, "createSpanFromParent", "parentSpanContext", "Lio/opentelemetry/api/trace/SpanContext;", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IOTelSpanFactory {
    Span createSpan(String name);

    Span createSpan(String name, String callingPackageName);

    Span createSpanFromParent(String name, SpanContext parentSpanContext);

    Span createSpanFromParent(String name, SpanContext parentSpanContext, String callingPackageName);
}
