package io.opentelemetry.instrumentation.api.instrumenter.rpc;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.DoubleHistogram;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.ContextKey;
import io.opentelemetry.instrumentation.api.instrumenter.OperationListener;
import io.opentelemetry.instrumentation.api.instrumenter.OperationMetrics;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
public final class RpcClientMetrics implements OperationListener {
    private static final double NANOS_PER_MS = TimeUnit.MILLISECONDS.toNanos(1);
    private static final ContextKey<State> RPC_CLIENT_REQUEST_METRICS_STATE = ContextKey.named("rpc-client-request-metrics-state");
    private static final Logger logger = Logger.getLogger(RpcClientMetrics.class.getName());
    private final DoubleHistogram clientDurationHistogram;

    /* JADX INFO: renamed from: $r8$lambda$jbVrJfzcLKM891dQTN-c3o_0fUg, reason: not valid java name */
    public static /* synthetic */ RpcClientMetrics m14750$r8$lambda$jbVrJfzcLKM891dQTNc3o_0fUg(Meter meter) {
        return new RpcClientMetrics(meter);
    }

    private RpcClientMetrics(Meter meter) {
        this.clientDurationHistogram = meter.histogramBuilder("rpc.client.duration").setDescription("The duration of an outbound RPC invocation").setUnit("ms").build();
    }

    public static OperationMetrics get() {
        return new OperationMetrics() { // from class: io.opentelemetry.instrumentation.api.instrumenter.rpc.RpcClientMetrics$$ExternalSyntheticLambda0
            @Override // io.opentelemetry.instrumentation.api.instrumenter.OperationMetrics
            public final OperationListener create(Meter meter) {
                return RpcClientMetrics.m14750$r8$lambda$jbVrJfzcLKM891dQTNc3o_0fUg(meter);
            }
        };
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.OperationListener
    public Context onStart(Context context, Attributes attributes, long j) {
        return context.with(RPC_CLIENT_REQUEST_METRICS_STATE, new AutoValue_RpcClientMetrics_State(attributes, j));
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.OperationListener
    public void onEnd(Context context, Attributes attributes, long j) {
        State state = (State) context.get(RPC_CLIENT_REQUEST_METRICS_STATE);
        if (state == null) {
            logger.log(Level.FINE, "No state present when ending context {0}. Cannot record RPC request metrics.", context);
        } else {
            this.clientDurationHistogram.record((j - state.startTimeNanos()) / NANOS_PER_MS, MetricsView.applyClientView(state.startAttributes(), attributes), context);
        }
    }

    static abstract class State {
        abstract Attributes startAttributes();

        abstract long startTimeNanos();

        State() {
        }
    }
}
