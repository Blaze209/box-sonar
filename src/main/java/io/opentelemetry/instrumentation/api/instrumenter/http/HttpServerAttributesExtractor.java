package io.opentelemetry.instrumentation.api.instrumenter.http;

import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.context.Context;
import io.opentelemetry.instrumentation.api.instrumenter.net.NetServerAttributesGetter;
import io.opentelemetry.instrumentation.api.instrumenter.net.internal.InternalNetServerAttributesExtractor;
import io.opentelemetry.instrumentation.api.internal.AttributesExtractorUtil;
import io.opentelemetry.instrumentation.api.internal.SpanKey;
import io.opentelemetry.instrumentation.api.internal.SpanKeyProvider;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class HttpServerAttributesExtractor<REQUEST, RESPONSE> extends HttpCommonAttributesExtractor<REQUEST, RESPONSE, HttpServerAttributesGetter<REQUEST, RESPONSE>> implements SpanKeyProvider {
    private final Function<Context, String> httpRouteHolderGetter;
    private final InternalNetServerAttributesExtractor<REQUEST> internalNetExtractor;

    public static <REQUEST, RESPONSE> HttpServerAttributesExtractor<REQUEST, RESPONSE> create(HttpServerAttributesGetter<REQUEST, RESPONSE> httpServerAttributesGetter, NetServerAttributesGetter<REQUEST> netServerAttributesGetter) {
        return builder(httpServerAttributesGetter, netServerAttributesGetter).build();
    }

    public static <REQUEST, RESPONSE> HttpServerAttributesExtractorBuilder<REQUEST, RESPONSE> builder(HttpServerAttributesGetter<REQUEST, RESPONSE> httpServerAttributesGetter, NetServerAttributesGetter<REQUEST> netServerAttributesGetter) {
        return new HttpServerAttributesExtractorBuilder<>(httpServerAttributesGetter, netServerAttributesGetter);
    }

    HttpServerAttributesExtractor(HttpServerAttributesGetter<REQUEST, RESPONSE> httpServerAttributesGetter, NetServerAttributesGetter<REQUEST> netServerAttributesGetter, List<String> list, List<String> list2) {
        this(httpServerAttributesGetter, netServerAttributesGetter, list, list2, new Function() { // from class: io.opentelemetry.instrumentation.api.instrumenter.http.HttpServerAttributesExtractor$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return HttpRouteHolder.getRoute((Context) obj);
            }
        });
    }

    HttpServerAttributesExtractor(HttpServerAttributesGetter<REQUEST, RESPONSE> httpServerAttributesGetter, NetServerAttributesGetter<REQUEST> netServerAttributesGetter, List<String> list, List<String> list2, Function<Context, String> function) {
        super(httpServerAttributesGetter, list, list2);
        this.internalNetExtractor = new InternalNetServerAttributesExtractor<>(netServerAttributesGetter, new BiPredicate() { // from class: io.opentelemetry.instrumentation.api.instrumenter.http.HttpServerAttributesExtractor$$ExternalSyntheticLambda0
            @Override // java.util.function.BiPredicate
            public final boolean test(Object obj, Object obj2) {
                return this.f$0.shouldCaptureHostPort(((Integer) obj).intValue(), obj2);
            }
        }, new HttpCommonAttributesExtractor.HttpNetNamePortGetter(httpServerAttributesGetter));
        this.httpRouteHolderGetter = function;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.http.HttpCommonAttributesExtractor, io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public void onStart(AttributesBuilder attributesBuilder, Context context, REQUEST request) {
        super.onStart(attributesBuilder, context, request);
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.HTTP_FLAVOR, ((HttpServerAttributesGetter) this.getter).flavor(request));
        String strForwardedProto = forwardedProto(request);
        if (strForwardedProto == null) {
            strForwardedProto = ((HttpServerAttributesGetter) this.getter).scheme(request);
        }
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.HTTP_SCHEME, strForwardedProto);
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.HTTP_TARGET, ((HttpServerAttributesGetter) this.getter).target(request));
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.HTTP_ROUTE, ((HttpServerAttributesGetter) this.getter).route(request));
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.HTTP_CLIENT_IP, clientIp(request));
        this.internalNetExtractor.onStart(attributesBuilder, request);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldCaptureHostPort(int i, REQUEST request) {
        String strScheme = ((HttpServerAttributesGetter) this.getter).scheme(request);
        if (strScheme == null) {
            return true;
        }
        if (strScheme.equals("http") && i == 80) {
            return false;
        }
        return (strScheme.equals("https") && i == 443) ? false : true;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.http.HttpCommonAttributesExtractor, io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public void onEnd(AttributesBuilder attributesBuilder, Context context, REQUEST request, @Nullable RESPONSE response, @Nullable Throwable th) {
        super.onEnd(attributesBuilder, context, request, response, th);
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.HTTP_ROUTE, this.httpRouteHolderGetter.apply(context));
    }

    @Nullable
    private String forwardedProto(REQUEST request) {
        String strExtractProtoFromForwardedHeader;
        String strFirstHeaderValue = firstHeaderValue(((HttpServerAttributesGetter) this.getter).requestHeader(request, "forwarded"));
        if (strFirstHeaderValue != null && (strExtractProtoFromForwardedHeader = ForwardedHeaderParser.extractProtoFromForwardedHeader(strFirstHeaderValue)) != null) {
            return strExtractProtoFromForwardedHeader;
        }
        String strFirstHeaderValue2 = firstHeaderValue(((HttpServerAttributesGetter) this.getter).requestHeader(request, "x-forwarded-proto"));
        if (strFirstHeaderValue2 != null) {
            return ForwardedHeaderParser.extractProtoFromForwardedProtoHeader(strFirstHeaderValue2);
        }
        return null;
    }

    @Nullable
    private String clientIp(REQUEST request) {
        String strExtractClientIpFromForwardedHeader;
        String strFirstHeaderValue = firstHeaderValue(((HttpServerAttributesGetter) this.getter).requestHeader(request, "forwarded"));
        if (strFirstHeaderValue != null && (strExtractClientIpFromForwardedHeader = ForwardedHeaderParser.extractClientIpFromForwardedHeader(strFirstHeaderValue)) != null) {
            return strExtractClientIpFromForwardedHeader;
        }
        String strFirstHeaderValue2 = firstHeaderValue(((HttpServerAttributesGetter) this.getter).requestHeader(request, "x-forwarded-for"));
        if (strFirstHeaderValue2 != null) {
            return ForwardedHeaderParser.extractClientIpFromForwardedForHeader(strFirstHeaderValue2);
        }
        return null;
    }

    @Override // io.opentelemetry.instrumentation.api.internal.SpanKeyProvider
    public SpanKey internalGetSpanKey() {
        return SpanKey.HTTP_SERVER;
    }
}
