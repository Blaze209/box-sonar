package com.splunk.rum;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.rum.internal.instrumentation.ApplicationStateListener;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
class NetworkMonitor implements ApplicationStateListener {
    static final AttributeKey<String> NETWORK_STATUS_KEY = AttributeKey.stringKey("network.status");
    private final ConnectionUtil connectionUtil;
    private final AtomicBoolean shouldEmitChangeEvents = new AtomicBoolean(true);

    NetworkMonitor(ConnectionUtil connectionUtil) {
        this.connectionUtil = connectionUtil;
    }

    void addConnectivityListener(Tracer tracer) {
        this.connectionUtil.addNetworkChangeListener(new TracingNetworkChangeListener(tracer, this.shouldEmitChangeEvents));
    }

    @Override // io.opentelemetry.rum.internal.instrumentation.ApplicationStateListener
    public void onApplicationForegrounded() {
        this.shouldEmitChangeEvents.set(true);
    }

    @Override // io.opentelemetry.rum.internal.instrumentation.ApplicationStateListener
    public void onApplicationBackgrounded() {
        this.shouldEmitChangeEvents.set(false);
    }

    static class TracingNetworkChangeListener implements NetworkChangeListener {
        private final CurrentNetworkAttributesExtractor networkAttributesExtractor = new CurrentNetworkAttributesExtractor();
        private final AtomicBoolean shouldEmitChangeEvents;
        private final Tracer tracer;

        TracingNetworkChangeListener(Tracer tracer, AtomicBoolean atomicBoolean) {
            this.tracer = tracer;
            this.shouldEmitChangeEvents = atomicBoolean;
        }

        @Override // com.splunk.rum.NetworkChangeListener
        public void onNetworkChange(CurrentNetwork currentNetwork) {
            if (this.shouldEmitChangeEvents.get()) {
                if (currentNetwork.getState() == NetworkState.NO_NETWORK_AVAILABLE) {
                    this.tracer.spanBuilder("network.change").setAttribute(NetworkMonitor.NETWORK_STATUS_KEY, "lost").startSpan().setAttribute(SemanticAttributes.NET_HOST_CONNECTION_TYPE, currentNetwork.getState().getHumanName()).end();
                    return;
                }
                Span spanStartSpan = this.tracer.spanBuilder("network.change").setAttribute(NetworkMonitor.NETWORK_STATUS_KEY, "available").startSpan();
                spanStartSpan.setAllAttributes(this.networkAttributesExtractor.extract(currentNetwork));
                spanStartSpan.end();
            }
        }
    }
}
