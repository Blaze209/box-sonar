package io.opentelemetry.instrumentation.api.internal;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.ContextKey;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class SpanKey {
    public static final SpanKey CONSUMER_PROCESS;
    private static final ContextKey<Span> CONSUMER_PROCESS_KEY;
    public static final SpanKey CONSUMER_RECEIVE;
    private static final ContextKey<Span> CONSUMER_RECEIVE_KEY;
    public static final SpanKey DB_CLIENT;
    private static final ContextKey<Span> DB_CLIENT_KEY;
    public static final SpanKey HTTP_CLIENT;
    private static final ContextKey<Span> HTTP_CLIENT_KEY;
    public static final SpanKey HTTP_SERVER;
    private static final ContextKey<Span> HTTP_SERVER_KEY;
    public static final SpanKey KIND_CLIENT;
    private static final ContextKey<Span> KIND_CLIENT_KEY;
    public static final SpanKey KIND_CONSUMER;
    private static final ContextKey<Span> KIND_CONSUMER_KEY;
    public static final SpanKey KIND_PRODUCER;
    private static final ContextKey<Span> KIND_PRODUCER_KEY;
    public static final SpanKey KIND_SERVER;
    private static final ContextKey<Span> KIND_SERVER_KEY;
    public static final SpanKey PRODUCER;
    private static final ContextKey<Span> PRODUCER_KEY;
    public static final SpanKey RPC_CLIENT;
    private static final ContextKey<Span> RPC_CLIENT_KEY;
    public static final SpanKey RPC_SERVER;
    private static final ContextKey<Span> RPC_SERVER_KEY;
    private final ContextKey<Span> key;

    static {
        ContextKey<Span> contextKeyNamed = ContextKey.named("opentelemetry-traces-span-key-kind-server");
        KIND_SERVER_KEY = contextKeyNamed;
        ContextKey<Span> contextKeyNamed2 = ContextKey.named("opentelemetry-traces-span-key-kind-client");
        KIND_CLIENT_KEY = contextKeyNamed2;
        ContextKey<Span> contextKeyNamed3 = ContextKey.named("opentelemetry-traces-span-key-kind-consumer");
        KIND_CONSUMER_KEY = contextKeyNamed3;
        ContextKey<Span> contextKeyNamed4 = ContextKey.named("opentelemetry-traces-span-key-kind-producer");
        KIND_PRODUCER_KEY = contextKeyNamed4;
        ContextKey<Span> contextKeyNamed5 = ContextKey.named("opentelemetry-traces-span-key-http-server");
        HTTP_SERVER_KEY = contextKeyNamed5;
        ContextKey<Span> contextKeyNamed6 = ContextKey.named("opentelemetry-traces-span-key-rpc-server");
        RPC_SERVER_KEY = contextKeyNamed6;
        ContextKey<Span> contextKeyNamed7 = ContextKey.named("opentelemetry-traces-span-key-http-client");
        HTTP_CLIENT_KEY = contextKeyNamed7;
        ContextKey<Span> contextKeyNamed8 = ContextKey.named("opentelemetry-traces-span-key-rpc-client");
        RPC_CLIENT_KEY = contextKeyNamed8;
        ContextKey<Span> contextKeyNamed9 = ContextKey.named("opentelemetry-traces-span-key-db-client");
        DB_CLIENT_KEY = contextKeyNamed9;
        ContextKey<Span> contextKeyNamed10 = ContextKey.named("opentelemetry-traces-span-key-producer");
        PRODUCER_KEY = contextKeyNamed10;
        ContextKey<Span> contextKeyNamed11 = ContextKey.named("opentelemetry-traces-span-key-consumer-receive");
        CONSUMER_RECEIVE_KEY = contextKeyNamed11;
        ContextKey<Span> contextKeyNamed12 = ContextKey.named("opentelemetry-traces-span-key-consumer-process");
        CONSUMER_PROCESS_KEY = contextKeyNamed12;
        KIND_SERVER = new SpanKey(contextKeyNamed);
        KIND_CLIENT = new SpanKey(contextKeyNamed2);
        KIND_CONSUMER = new SpanKey(contextKeyNamed3);
        KIND_PRODUCER = new SpanKey(contextKeyNamed4);
        HTTP_SERVER = new SpanKey(contextKeyNamed5);
        RPC_SERVER = new SpanKey(contextKeyNamed6);
        HTTP_CLIENT = new SpanKey(contextKeyNamed7);
        RPC_CLIENT = new SpanKey(contextKeyNamed8);
        DB_CLIENT = new SpanKey(contextKeyNamed9);
        PRODUCER = new SpanKey(contextKeyNamed10);
        CONSUMER_RECEIVE = new SpanKey(contextKeyNamed11);
        CONSUMER_PROCESS = new SpanKey(contextKeyNamed12);
    }

    private SpanKey(ContextKey<Span> contextKey) {
        this.key = contextKey;
    }

    public Context storeInContext(Context context, Span span) {
        return context.with(this.key, span);
    }

    @Nullable
    public Span fromContextOrNull(Context context) {
        return (Span) context.get(this.key);
    }

    public String toString() {
        return this.key.toString();
    }
}
