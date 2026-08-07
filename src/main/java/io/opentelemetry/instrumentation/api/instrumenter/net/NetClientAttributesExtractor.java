package io.opentelemetry.instrumentation.api.instrumenter.net;

import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.context.Context;
import io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor;
import io.opentelemetry.instrumentation.api.instrumenter.net.internal.FallbackNamePortGetter;
import io.opentelemetry.instrumentation.api.instrumenter.net.internal.InternalNetClientAttributesExtractor;
import java.util.function.BiPredicate;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class NetClientAttributesExtractor<REQUEST, RESPONSE> implements AttributesExtractor<REQUEST, RESPONSE> {
    private final InternalNetClientAttributesExtractor<REQUEST, RESPONSE> internalExtractor;

    static /* synthetic */ boolean lambda$new$0(Integer num, Object obj) {
        return true;
    }

    public static <REQUEST, RESPONSE> NetClientAttributesExtractor<REQUEST, RESPONSE> create(NetClientAttributesGetter<REQUEST, RESPONSE> netClientAttributesGetter) {
        return new NetClientAttributesExtractor<>(netClientAttributesGetter);
    }

    private NetClientAttributesExtractor(NetClientAttributesGetter<REQUEST, RESPONSE> netClientAttributesGetter) {
        this.internalExtractor = new InternalNetClientAttributesExtractor<>(netClientAttributesGetter, new BiPredicate() { // from class: io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesExtractor$$ExternalSyntheticLambda0
            @Override // java.util.function.BiPredicate
            public final boolean test(Object obj, Object obj2) {
                return NetClientAttributesExtractor.lambda$new$0((Integer) obj, obj2);
            }
        }, FallbackNamePortGetter.noop());
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public void onStart(AttributesBuilder attributesBuilder, Context context, REQUEST request) {
        this.internalExtractor.onStart(attributesBuilder, request);
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public void onEnd(AttributesBuilder attributesBuilder, Context context, REQUEST request, @Nullable RESPONSE response, @Nullable Throwable th) {
        this.internalExtractor.onEnd(attributesBuilder, request, response);
    }
}
