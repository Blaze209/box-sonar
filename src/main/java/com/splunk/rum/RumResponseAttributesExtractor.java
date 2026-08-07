package com.splunk.rum;

import com.google.common.net.HttpHeaders;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.context.Context;
import io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes3.dex */
class RumResponseAttributesExtractor implements AttributesExtractor<Request, Response> {
    private final ServerTimingHeaderParser serverTimingHeaderParser;

    public RumResponseAttributesExtractor(ServerTimingHeaderParser serverTimingHeaderParser) {
        this.serverTimingHeaderParser = serverTimingHeaderParser;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public void onStart(AttributesBuilder attributesBuilder, Context context, Request request) {
        attributesBuilder.put(SplunkRum.COMPONENT_KEY, "http");
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public void onEnd(AttributesBuilder attributesBuilder, Context context, Request request, Response response, Throwable th) {
        if (response != null) {
            onResponse(attributesBuilder, response);
        }
    }

    private void onResponse(AttributesBuilder attributesBuilder, Response response) {
        String[] strArr = this.serverTimingHeaderParser.parse(response.header(HttpHeaders.SERVER_TIMING));
        if (strArr.length == 2) {
            attributesBuilder.put(SplunkRum.LINK_TRACE_ID_KEY, strArr[0]);
            attributesBuilder.put(SplunkRum.LINK_SPAN_ID_KEY, strArr[1]);
        }
    }
}
