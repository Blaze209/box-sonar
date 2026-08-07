package io.opentelemetry.instrumentation.api.internal;

import io.opentelemetry.api.trace.SpanKind;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
public final class SupportabilityMetrics {
    private static final SupportabilityMetrics INSTANCE;
    private static final Logger logger;
    private final boolean agentDebugEnabled;
    private final Consumer<String> reporter;
    private final ConcurrentMap<String, KindCounters> suppressionCounters = new ConcurrentHashMap();
    private final ConcurrentMap<String, AtomicLong> counters = new ConcurrentHashMap();

    static {
        final Logger logger2 = Logger.getLogger(SupportabilityMetrics.class.getName());
        logger = logger2;
        boolean z = ConfigPropertiesUtil.getBoolean("otel.javaagent.debug", false);
        Objects.requireNonNull(logger2);
        INSTANCE = new SupportabilityMetrics(z, new Consumer() { // from class: io.opentelemetry.instrumentation.api.internal.SupportabilityMetrics$$ExternalSyntheticLambda4
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                logger2.fine((String) obj);
            }
        }).start();
    }

    public static SupportabilityMetrics instance() {
        return INSTANCE;
    }

    SupportabilityMetrics(boolean z, Consumer<String> consumer) {
        this.agentDebugEnabled = z;
        this.reporter = consumer;
    }

    public void recordSuppressedSpan(SpanKind spanKind, String str) {
        if (this.agentDebugEnabled) {
            this.suppressionCounters.computeIfAbsent(str, new Function() { // from class: io.opentelemetry.instrumentation.api.internal.SupportabilityMetrics$$ExternalSyntheticLambda6
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return SupportabilityMetrics.lambda$recordSuppressedSpan$0((String) obj);
                }
            }).increment(spanKind);
        }
    }

    static /* synthetic */ KindCounters lambda$recordSuppressedSpan$0(String str) {
        return new KindCounters(null);
    }

    public void incrementCounter(String str) {
        if (this.agentDebugEnabled) {
            this.counters.computeIfAbsent(str, new Function() { // from class: io.opentelemetry.instrumentation.api.internal.SupportabilityMetrics$$ExternalSyntheticLambda5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return SupportabilityMetrics.lambda$incrementCounter$1((String) obj);
                }
            }).incrementAndGet();
        }
    }

    static /* synthetic */ AtomicLong lambda$incrementCounter$1(String str) {
        return new AtomicLong();
    }

    void report() {
        this.suppressionCounters.forEach(new BiConsumer() { // from class: io.opentelemetry.instrumentation.api.internal.SupportabilityMetrics$$ExternalSyntheticLambda2
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                this.f$0.m14752x65a17bea((String) obj, (SupportabilityMetrics.KindCounters) obj2);
            }
        });
        this.counters.forEach(new BiConsumer() { // from class: io.opentelemetry.instrumentation.api.internal.SupportabilityMetrics$$ExternalSyntheticLambda3
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                this.f$0.m14753x56f30b6b((String) obj, (AtomicLong) obj2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$report$2$io-opentelemetry-instrumentation-api-internal-SupportabilityMetrics, reason: not valid java name */
    /* synthetic */ void m14752x65a17bea(String str, KindCounters kindCounters) {
        for (SpanKind spanKind : SpanKind.values()) {
            long andReset = kindCounters.getAndReset(spanKind);
            if (andReset > 0) {
                this.reporter.accept("Suppressed Spans by '" + str + "' (" + spanKind + ") : " + andReset);
            }
        }
    }

    /* JADX INFO: renamed from: lambda$report$3$io-opentelemetry-instrumentation-api-internal-SupportabilityMetrics, reason: not valid java name */
    /* synthetic */ void m14753x56f30b6b(String str, AtomicLong atomicLong) {
        long andSet = atomicLong.getAndSet(0L);
        if (andSet > 0) {
            this.reporter.accept("Counter '" + str + "' : " + andSet);
        }
    }

    private SupportabilityMetrics start() {
        if (this.agentDebugEnabled) {
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, new ThreadFactory() { // from class: io.opentelemetry.instrumentation.api.internal.SupportabilityMetrics$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    return SupportabilityMetrics.lambda$start$4(runnable);
                }
            });
            scheduledExecutorServiceNewScheduledThreadPool.scheduleAtFixedRate(new Runnable() { // from class: io.opentelemetry.instrumentation.api.internal.SupportabilityMetrics$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.report();
                }
            }, 5L, 5L, TimeUnit.SECONDS);
            if (scheduledExecutorServiceNewScheduledThreadPool.isTerminated()) {
                throw new AssertionError();
            }
        }
        return this;
    }

    static /* synthetic */ Thread lambda$start$4(Runnable runnable) {
        Thread thread = new Thread(runnable, "supportability_metrics_reporter");
        thread.setDaemon(true);
        thread.setContextClassLoader(null);
        return thread;
    }

    public static final class CounterNames {
        public static final String SQL_STATEMENT_SANITIZER_CACHE_MISS = "SqlStatementSanitizer cache miss";

        private CounterNames() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class KindCounters {
        private final AtomicLong client;
        private final AtomicLong consumer;
        private final AtomicLong internal;
        private final AtomicLong producer;
        private final AtomicLong server;

        private KindCounters() {
            this.server = new AtomicLong();
            this.client = new AtomicLong();
            this.internal = new AtomicLong();
            this.consumer = new AtomicLong();
            this.producer = new AtomicLong();
        }

        /* synthetic */ KindCounters(AnonymousClass1 anonymousClass1) {
            this();
        }

        void increment(SpanKind spanKind) {
            int i = AnonymousClass1.$SwitchMap$io$opentelemetry$api$trace$SpanKind[spanKind.ordinal()];
            if (i == 1) {
                this.internal.incrementAndGet();
                return;
            }
            if (i == 2) {
                this.server.incrementAndGet();
                return;
            }
            if (i == 3) {
                this.client.incrementAndGet();
            } else if (i == 4) {
                this.producer.incrementAndGet();
            } else {
                if (i != 5) {
                    return;
                }
                this.consumer.incrementAndGet();
            }
        }

        long getAndReset(SpanKind spanKind) {
            int i = AnonymousClass1.$SwitchMap$io$opentelemetry$api$trace$SpanKind[spanKind.ordinal()];
            if (i == 1) {
                return this.internal.getAndSet(0L);
            }
            if (i == 2) {
                return this.server.getAndSet(0L);
            }
            if (i == 3) {
                return this.client.getAndSet(0L);
            }
            if (i == 4) {
                return this.producer.getAndSet(0L);
            }
            if (i != 5) {
                return 0L;
            }
            return this.consumer.getAndSet(0L);
        }
    }

    /* JADX INFO: renamed from: io.opentelemetry.instrumentation.api.internal.SupportabilityMetrics$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$opentelemetry$api$trace$SpanKind;

        static {
            int[] iArr = new int[SpanKind.values().length];
            $SwitchMap$io$opentelemetry$api$trace$SpanKind = iArr;
            try {
                iArr[SpanKind.INTERNAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$opentelemetry$api$trace$SpanKind[SpanKind.SERVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$opentelemetry$api$trace$SpanKind[SpanKind.CLIENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$opentelemetry$api$trace$SpanKind[SpanKind.PRODUCER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$opentelemetry$api$trace$SpanKind[SpanKind.CONSUMER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }
}
