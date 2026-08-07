package io.opentelemetry.instrumentation.api.instrumenter.net;

import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.context.Context;
import io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor;
import io.opentelemetry.instrumentation.api.instrumenter.net.internal.FallbackNamePortGetter;
import io.opentelemetry.instrumentation.api.instrumenter.net.internal.InternalNetServerAttributesExtractor;
import java.util.function.BiPredicate;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class NetServerAttributesExtractor<REQUEST, RESPONSE> implements AttributesExtractor<REQUEST, RESPONSE> {
    private final InternalNetServerAttributesExtractor<REQUEST> internalExtractor;

    static /* synthetic */ boolean lambda$new$0(Integer num, Object obj) {
        return true;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public void onEnd(AttributesBuilder attributesBuilder, Context context, REQUEST request, @Nullable RESPONSE response, @Nullable Throwable th) {
    }

    public static <REQUEST, RESPONSE> NetServerAttributesExtractor<REQUEST, RESPONSE> create(NetServerAttributesGetter<REQUEST> netServerAttributesGetter) {
        return new NetServerAttributesExtractor<>(netServerAttributesGetter);
    }

    private NetServerAttributesExtractor(NetServerAttributesGetter<REQUEST> netServerAttributesGetter) {
        this.internalExtractor = new InternalNetServerAttributesExtractor<>(netServerAttributesGetter, new BiPredicate() { // from class: io.opentelemetry.instrumentation.api.instrumenter.net.NetServerAttributesExtractor$$ExternalSyntheticLambda0
            @Override // java.util.function.BiPredicate
            public final boolean test(Object obj, Object obj2) {
                return NetServerAttributesExtractor.lambda$new$0((Integer) obj, obj2);
            }
        }, FallbackNamePortGetter.noop());
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public void onStart(AttributesBuilder attributesBuilder, Context context, REQUEST request) {
        this.internalExtractor.onStart(attributesBuilder, request);
    }
}
