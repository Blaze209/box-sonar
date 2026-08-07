package io.opentelemetry.instrumentation.api.instrumenter.http;

import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.context.Context;
import io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor;
import io.opentelemetry.instrumentation.api.instrumenter.http.HttpCommonAttributesGetter;
import io.opentelemetry.instrumentation.api.instrumenter.net.internal.FallbackNamePortGetter;
import io.opentelemetry.instrumentation.api.internal.AttributesExtractorUtil;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
abstract class HttpCommonAttributesExtractor<REQUEST, RESPONSE, GETTER extends HttpCommonAttributesGetter<REQUEST, RESPONSE>> implements AttributesExtractor<REQUEST, RESPONSE> {
    private static final Logger logger = Logger.getLogger(HttpCommonAttributesGetter.class.getName());
    private final List<String> capturedRequestHeaders;
    private final List<String> capturedResponseHeaders;
    final GETTER getter;

    HttpCommonAttributesExtractor(GETTER getter, List<String> list, List<String> list2) {
        this.getter = getter;
        this.capturedRequestHeaders = CapturedHttpHeadersUtil.lowercase(list);
        this.capturedResponseHeaders = CapturedHttpHeadersUtil.lowercase(list2);
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public void onStart(AttributesBuilder attributesBuilder, Context context, REQUEST request) {
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.HTTP_METHOD, this.getter.method(request));
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.HTTP_USER_AGENT, userAgent(request));
        for (String str : this.capturedRequestHeaders) {
            List<String> listRequestHeader = this.getter.requestHeader(request, str);
            if (!listRequestHeader.isEmpty()) {
                AttributesExtractorUtil.internalSet(attributesBuilder, CapturedHttpHeadersUtil.requestAttributeKey(str), listRequestHeader);
            }
        }
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public void onEnd(AttributesBuilder attributesBuilder, Context context, REQUEST request, @Nullable RESPONSE response, @Nullable Throwable th) {
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.HTTP_REQUEST_CONTENT_LENGTH, requestContentLength(request));
        if (response != null) {
            Integer numStatusCode = this.getter.statusCode(request, response, th);
            if (numStatusCode != null && numStatusCode.intValue() > 0) {
                AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.HTTP_STATUS_CODE, Long.valueOf(numStatusCode.intValue()));
            }
            AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.HTTP_RESPONSE_CONTENT_LENGTH, responseContentLength(request, response));
            for (String str : this.capturedResponseHeaders) {
                List<String> listResponseHeader = this.getter.responseHeader(request, response, str);
                if (!listResponseHeader.isEmpty()) {
                    AttributesExtractorUtil.internalSet(attributesBuilder, CapturedHttpHeadersUtil.responseAttributeKey(str), listResponseHeader);
                }
            }
        }
    }

    @Nullable
    private String userAgent(REQUEST request) {
        return firstHeaderValue(this.getter.requestHeader(request, "user-agent"));
    }

    @Nullable
    private Long requestContentLength(REQUEST request) {
        return parseNumber(firstHeaderValue(this.getter.requestHeader(request, "content-length")));
    }

    @Nullable
    private Long responseContentLength(REQUEST request, RESPONSE response) {
        return parseNumber(firstHeaderValue(this.getter.responseHeader(request, response, "content-length")));
    }

    @Nullable
    static String firstHeaderValue(List<String> list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Nullable
    private static Long parseNumber(@Nullable String str) {
        if (str == null) {
            return null;
        }
        try {
            return Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static final class HttpNetNamePortGetter<REQUEST> implements FallbackNamePortGetter<REQUEST> {
        private final HttpCommonAttributesGetter<REQUEST, ?> getter;

        HttpNetNamePortGetter(HttpCommonAttributesGetter<REQUEST, ?> httpCommonAttributesGetter) {
            this.getter = httpCommonAttributesGetter;
        }

        @Override // io.opentelemetry.instrumentation.api.instrumenter.net.internal.FallbackNamePortGetter
        @Nullable
        public String name(REQUEST request) {
            String strFirstHeaderValue = HttpCommonAttributesExtractor.firstHeaderValue(this.getter.requestHeader(request, "host"));
            if (strFirstHeaderValue == null) {
                return null;
            }
            int iIndexOf = strFirstHeaderValue.indexOf(58);
            return iIndexOf == -1 ? strFirstHeaderValue : strFirstHeaderValue.substring(0, iIndexOf);
        }

        @Override // io.opentelemetry.instrumentation.api.instrumenter.net.internal.FallbackNamePortGetter
        @Nullable
        public Integer port(REQUEST request) {
            int iIndexOf;
            String strFirstHeaderValue = HttpCommonAttributesExtractor.firstHeaderValue(this.getter.requestHeader(request, "host"));
            if (strFirstHeaderValue == null || (iIndexOf = strFirstHeaderValue.indexOf(58)) == -1) {
                return null;
            }
            try {
                return Integer.valueOf(Integer.parseInt(strFirstHeaderValue.substring(iIndexOf + 1)));
            } catch (NumberFormatException e) {
                HttpCommonAttributesExtractor.logger.log(Level.FINE, e.getMessage(), (Throwable) e);
                return null;
            }
        }
    }
}
