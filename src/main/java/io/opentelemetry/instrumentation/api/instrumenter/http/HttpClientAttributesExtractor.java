package io.opentelemetry.instrumentation.api.instrumenter.http;

import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.context.Context;
import io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter;
import io.opentelemetry.instrumentation.api.instrumenter.net.internal.InternalNetClientAttributesExtractor;
import io.opentelemetry.instrumentation.api.internal.AttributesExtractorUtil;
import io.opentelemetry.instrumentation.api.internal.SpanKey;
import io.opentelemetry.instrumentation.api.internal.SpanKeyProvider;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.List;
import java.util.function.BiPredicate;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class HttpClientAttributesExtractor<REQUEST, RESPONSE> extends HttpCommonAttributesExtractor<REQUEST, RESPONSE, HttpClientAttributesGetter<REQUEST, RESPONSE>> implements SpanKeyProvider {
    private final InternalNetClientAttributesExtractor<REQUEST, RESPONSE> internalNetExtractor;

    @Deprecated
    public static <REQUEST, RESPONSE> HttpClientAttributesExtractor<REQUEST, RESPONSE> create(HttpClientAttributesGetter<REQUEST, RESPONSE> httpClientAttributesGetter) {
        return builder(httpClientAttributesGetter).build();
    }

    public static <REQUEST, RESPONSE> HttpClientAttributesExtractor<REQUEST, RESPONSE> create(HttpClientAttributesGetter<REQUEST, RESPONSE> httpClientAttributesGetter, NetClientAttributesGetter<REQUEST, RESPONSE> netClientAttributesGetter) {
        return builder(httpClientAttributesGetter, netClientAttributesGetter).build();
    }

    @Deprecated
    public static <REQUEST, RESPONSE> HttpClientAttributesExtractorBuilder<REQUEST, RESPONSE> builder(HttpClientAttributesGetter<REQUEST, RESPONSE> httpClientAttributesGetter) {
        return builder(httpClientAttributesGetter, new NoopNetClientAttributesGetter());
    }

    public static <REQUEST, RESPONSE> HttpClientAttributesExtractorBuilder<REQUEST, RESPONSE> builder(HttpClientAttributesGetter<REQUEST, RESPONSE> httpClientAttributesGetter, NetClientAttributesGetter<REQUEST, RESPONSE> netClientAttributesGetter) {
        return new HttpClientAttributesExtractorBuilder<>(httpClientAttributesGetter, netClientAttributesGetter);
    }

    HttpClientAttributesExtractor(HttpClientAttributesGetter<REQUEST, RESPONSE> httpClientAttributesGetter, NetClientAttributesGetter<REQUEST, RESPONSE> netClientAttributesGetter, List<String> list, List<String> list2) {
        super(httpClientAttributesGetter, list, list2);
        this.internalNetExtractor = new InternalNetClientAttributesExtractor<>(netClientAttributesGetter, new BiPredicate() { // from class: io.opentelemetry.instrumentation.api.instrumenter.http.HttpClientAttributesExtractor$$ExternalSyntheticLambda0
            @Override // java.util.function.BiPredicate
            public final boolean test(Object obj, Object obj2) {
                return this.f$0.shouldCapturePeerPort(((Integer) obj).intValue(), obj2);
            }
        }, new HttpCommonAttributesExtractor.HttpNetNamePortGetter(httpClientAttributesGetter));
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.http.HttpCommonAttributesExtractor, io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public void onStart(AttributesBuilder attributesBuilder, Context context, REQUEST request) {
        super.onStart(attributesBuilder, context, request);
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.HTTP_URL, stripSensitiveData(((HttpClientAttributesGetter) this.getter).url(request)));
        this.internalNetExtractor.onStart(attributesBuilder, request);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldCapturePeerPort(int i, REQUEST request) {
        String strUrl = ((HttpClientAttributesGetter) this.getter).url(request);
        if (strUrl == null) {
            return true;
        }
        if (strUrl.startsWith("http://") && i == 80) {
            return false;
        }
        return (strUrl.startsWith(AuthenticationConstants.Broker.REDIRECT_SSL_PREFIX) && i == 443) ? false : true;
    }

    @Nullable
    private static String stripSensitiveData(@Nullable String str) {
        int iIndexOf;
        int length;
        int i;
        if (str == null || str.isEmpty() || (iIndexOf = str.indexOf(58)) == -1 || (length = str.length()) <= (i = iIndexOf + 2) || str.charAt(iIndexOf + 1) != '/' || str.charAt(i) != '/') {
            return str;
        }
        int i2 = iIndexOf + 3;
        int i3 = -1;
        for (int i4 = i2; i4 < length; i4++) {
            char cCharAt = str.charAt(i4);
            if (cCharAt == '@') {
                i3 = i4;
            }
            if (cCharAt == '/' || cCharAt == '?' || cCharAt == '#') {
                break;
            }
        }
        return (i3 == -1 || i3 == length + (-1)) ? str : str.substring(0, i2) + str.substring(i3 + 1);
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.http.HttpCommonAttributesExtractor, io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public void onEnd(AttributesBuilder attributesBuilder, Context context, REQUEST request, @Nullable RESPONSE response, @Nullable Throwable th) {
        super.onEnd(attributesBuilder, context, request, response, th);
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.HTTP_FLAVOR, ((HttpClientAttributesGetter) this.getter).flavor(request, response));
        this.internalNetExtractor.onEnd(attributesBuilder, request, response);
    }

    @Override // io.opentelemetry.instrumentation.api.internal.SpanKeyProvider
    public SpanKey internalGetSpanKey() {
        return SpanKey.HTTP_CLIENT;
    }

    private static final class NoopNetClientAttributesGetter<REQUEST, RESPONSE> implements NetClientAttributesGetter<REQUEST, RESPONSE> {
        @Override // io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter
        @Nullable
        public String peerName(REQUEST request) {
            return null;
        }

        @Override // io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter
        @Nullable
        public Integer peerPort(REQUEST request) {
            return null;
        }

        @Override // io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter
        @Nullable
        public String transport(REQUEST request, @Nullable RESPONSE response) {
            return null;
        }

        private NoopNetClientAttributesGetter() {
        }
    }
}
