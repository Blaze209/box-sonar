package zipkin2.v1;

import java.util.Map;
import zipkin2.Annotation;
import zipkin2.Endpoint;
import zipkin2.Span;

/* JADX INFO: loaded from: classes6.dex */
public final class V2SpanConverter {
    final V1Span.Builder result = V1Span.newBuilder();
    final V1SpanMetadata md = new V1SpanMetadata();

    public static V2SpanConverter create() {
        return new V2SpanConverter();
    }

    public V1Span convert(Span span) {
        this.md.parse(span);
        this.result.clear().traceId(span.traceId()).parentId(span.parentId()).id(span.id()).name(span.name()).debug(span.debug());
        if (!Boolean.TRUE.equals(span.shared())) {
            this.result.timestamp(span.timestampAsLong());
            this.result.duration(span.durationAsLong());
        }
        boolean z = false;
        boolean z2 = (this.md.startTs == 0 || this.md.begin == null) ? false : true;
        boolean z3 = (this.md.endTs == 0 || this.md.end == null) ? false : true;
        Endpoint endpointLocalEndpoint = span.localEndpoint();
        int size = span.annotations().size();
        if (z2) {
            size++;
            this.result.addAnnotation(this.md.startTs, this.md.begin, endpointLocalEndpoint);
        }
        int size2 = span.annotations().size();
        for (int i = 0; i < size2; i++) {
            Annotation annotation = span.annotations().get(i);
            if ((!z2 || !annotation.value().equals(this.md.begin)) && (!z3 || !annotation.value().equals(this.md.end))) {
                this.result.addAnnotation(annotation.timestamp(), annotation.value(), endpointLocalEndpoint);
            }
        }
        if (z3) {
            size++;
            this.result.addAnnotation(this.md.endTs, this.md.end, endpointLocalEndpoint);
        }
        for (Map.Entry<String, String> entry : span.tags().entrySet()) {
            this.result.addBinaryAnnotation(entry.getKey(), entry.getValue(), endpointLocalEndpoint);
        }
        boolean z4 = size == 0 && endpointLocalEndpoint != null && span.tags().isEmpty();
        if (this.md.addr != null && span.remoteEndpoint() != null) {
            z = true;
        }
        if (z4) {
            this.result.addBinaryAnnotation("lc", "", endpointLocalEndpoint);
        }
        if (z) {
            this.result.addBinaryAnnotation(this.md.addr, span.remoteEndpoint());
        }
        return this.result.build();
    }

    static final class V1SpanMetadata {
        String addr;
        String begin;
        String end;
        long endTs;
        long mrTs;
        long msTs;
        long startTs;
        long wrTs;
        long wsTs;

        V1SpanMetadata() {
        }

        /* JADX WARN: Code duplicated, block: B:66:0x014f  */
        /* JADX WARN: Code duplicated, block: B:73:0x0163  */
        /* JADX WARN: Code duplicated, block: B:89:0x019b  */
        /* JADX WARN: Code duplicated, block: B:96:0x01af  */
        void parse(Span span) {
            Span.Kind kind;
            long j = 0;
            this.mrTs = 0L;
            this.wrTs = 0L;
            this.wsTs = 0L;
            this.msTs = 0L;
            this.endTs = 0L;
            this.startTs = 0L;
            this.addr = null;
            this.end = null;
            this.begin = null;
            long jTimestampAsLong = span.timestampAsLong();
            this.startTs = jTimestampAsLong;
            this.endTs = (jTimestampAsLong == 0 || span.durationAsLong() == 0) ? 0L : this.startTs + span.durationAsLong();
            Span.Kind kind2 = span.kind();
            int size = span.annotations().size();
            int i = 0;
            while (i < size) {
                long j2 = j;
                Annotation annotation = span.annotations().get(i);
                String strValue = annotation.value();
                if (strValue.length() == 2) {
                    if (strValue.equals("cs")) {
                        kind = Span.Kind.CLIENT;
                        if (annotation.timestamp() < this.startTs) {
                            this.startTs = annotation.timestamp();
                        }
                    } else if (strValue.equals("sr")) {
                        kind = Span.Kind.SERVER;
                        if (annotation.timestamp() < this.startTs) {
                            this.startTs = annotation.timestamp();
                        }
                    } else if (strValue.equals("ss")) {
                        kind = Span.Kind.SERVER;
                        if (annotation.timestamp() > this.endTs) {
                            this.endTs = annotation.timestamp();
                        }
                    } else if (strValue.equals("cr")) {
                        kind = Span.Kind.CLIENT;
                        if (annotation.timestamp() > this.endTs) {
                            this.endTs = annotation.timestamp();
                        }
                    } else if (strValue.equals("ms")) {
                        kind = Span.Kind.PRODUCER;
                        this.msTs = annotation.timestamp();
                    } else if (strValue.equals("mr")) {
                        kind = Span.Kind.CONSUMER;
                        this.mrTs = annotation.timestamp();
                    } else if (strValue.equals("ws")) {
                        this.wsTs = annotation.timestamp();
                    } else if (strValue.equals("wr")) {
                        this.wrTs = annotation.timestamp();
                    }
                    kind2 = kind;
                }
                i++;
                j = j2;
            }
            long j3 = j;
            if (span.remoteEndpoint() != null) {
                this.addr = "sa";
            }
            if (kind2 == null) {
                return;
            }
            int i2 = AnonymousClass1.$SwitchMap$zipkin2$Span$Kind[kind2.ordinal()];
            if (i2 == 1) {
                this.addr = "sa";
                this.begin = "cs";
                this.end = "cr";
            } else if (i2 == 2) {
                this.addr = "ca";
                this.begin = "sr";
                this.end = "ss";
            } else if (i2 == 3) {
                this.addr = "ma";
                this.begin = "ms";
                this.end = "ws";
                long j4 = this.startTs;
                if (j4 != j3) {
                    long j5 = this.msTs;
                    if (j5 != j3 && j5 < j4) {
                        this.startTs = this.msTs;
                    }
                } else {
                    this.startTs = this.msTs;
                }
                long j6 = this.endTs;
                if (j6 != j3) {
                    long j7 = this.wsTs;
                    if (j7 != j3 && j7 > j6) {
                        this.endTs = this.wsTs;
                    }
                } else {
                    this.endTs = this.wsTs;
                }
            } else if (i2 == 4) {
                this.addr = "ma";
                long j8 = this.startTs;
                if (j8 != j3) {
                    long j9 = this.wrTs;
                    if (j9 != j3 && j9 < j8) {
                        this.startTs = this.wrTs;
                    }
                } else {
                    this.startTs = this.wrTs;
                }
                long j10 = this.endTs;
                if (j10 != j3) {
                    long j11 = this.mrTs;
                    if (j11 != j3 && j11 > j10) {
                        this.endTs = this.mrTs;
                    }
                } else {
                    this.endTs = this.mrTs;
                }
                if (this.endTs != j3 || this.wrTs != j3) {
                    this.begin = "wr";
                    this.end = "mr";
                } else {
                    this.begin = "mr";
                }
            } else {
                throw new AssertionError("update kind mapping");
            }
            if (span.remoteEndpoint() == null) {
                this.addr = null;
            }
        }
    }

    /* JADX INFO: renamed from: zipkin2.v1.V2SpanConverter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$zipkin2$Span$Kind;

        static {
            int[] iArr = new int[Span.Kind.values().length];
            $SwitchMap$zipkin2$Span$Kind = iArr;
            try {
                iArr[Span.Kind.CLIENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$zipkin2$Span$Kind[Span.Kind.SERVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$zipkin2$Span$Kind[Span.Kind.PRODUCER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$zipkin2$Span$Kind[Span.Kind.CONSUMER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    V2SpanConverter() {
    }
}
