package io.opentelemetry.instrumentation.api.instrumenter;

import io.opentelemetry.context.Context;
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.context.propagation.TextMapSetter;

/* JADX INFO: loaded from: classes4.dex */
final class PropagatingToDownstreamInstrumenter<REQUEST, RESPONSE> extends Instrumenter<REQUEST, RESPONSE> {
    private final ContextPropagators propagators;
    private final TextMapSetter<REQUEST> setter;

    PropagatingToDownstreamInstrumenter(InstrumenterBuilder<REQUEST, RESPONSE> instrumenterBuilder, TextMapSetter<REQUEST> textMapSetter) {
        super(instrumenterBuilder);
        this.propagators = instrumenterBuilder.openTelemetry.getPropagators();
        this.setter = textMapSetter;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.Instrumenter
    public Context start(Context context, REQUEST request) {
        Context contextStart = super.start(context, request);
        this.propagators.getTextMapPropagator().inject(contextStart, request, this.setter);
        return contextStart;
    }
}
