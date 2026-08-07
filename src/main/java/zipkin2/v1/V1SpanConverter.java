package zipkin2.v1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import zipkin2.Endpoint;
import zipkin2.Span;
import zipkin2.internal.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class V1SpanConverter {
    V1Annotation cr;
    V1Annotation cs;
    V1Annotation mr;
    V1Annotation ms;
    V1Annotation sr;
    V1Annotation ss;
    V1Annotation wr;
    V1Annotation ws;
    final Span.Builder first = Span.newBuilder();
    final List<Span.Builder> spans = new ArrayList();

    public static V1SpanConverter create() {
        return new V1SpanConverter();
    }

    public List<Span> convert(V1Span v1Span) {
        ArrayList arrayList = new ArrayList();
        convert(v1Span, arrayList);
        return arrayList;
    }

    public void convert(V1Span v1Span, Collection<Span> collection) {
        start(v1Span);
        processAnnotations(v1Span);
        processBinaryAnnotations(v1Span);
        finish(collection);
    }

    void start(V1Span v1Span) {
        this.first.clear();
        this.spans.clear();
        this.wr = null;
        this.ws = null;
        this.mr = null;
        this.ms = null;
        this.cr = null;
        this.ss = null;
        this.sr = null;
        this.cs = null;
        newBuilder(this.first, v1Span);
    }

    void processAnnotations(V1Span v1Span) {
        V1Annotation v1Annotation;
        V1Annotation v1Annotation2;
        Span.Builder builderForEndpoint;
        Span.Builder builderForEndpoint2;
        int size = v1Span.annotations.size();
        for (int i = 0; i < size; i++) {
            V1Annotation v1Annotation3 = v1Span.annotations.get(i);
            Span.Builder builderForEndpoint3 = forEndpoint(v1Span, v1Annotation3.endpoint);
            if (v1Annotation3.value.length() == 2 && v1Annotation3.endpoint != null) {
                if (v1Annotation3.value.equals("cs")) {
                    builderForEndpoint3.kind(Span.Kind.CLIENT);
                    this.cs = v1Annotation3;
                } else if (v1Annotation3.value.equals("sr")) {
                    builderForEndpoint3.kind(Span.Kind.SERVER);
                    this.sr = v1Annotation3;
                } else if (v1Annotation3.value.equals("ss")) {
                    builderForEndpoint3.kind(Span.Kind.SERVER);
                    this.ss = v1Annotation3;
                } else if (v1Annotation3.value.equals("cr")) {
                    builderForEndpoint3.kind(Span.Kind.CLIENT);
                    this.cr = v1Annotation3;
                } else if (v1Annotation3.value.equals("ms")) {
                    builderForEndpoint3.kind(Span.Kind.PRODUCER);
                    this.ms = v1Annotation3;
                } else if (v1Annotation3.value.equals("mr")) {
                    builderForEndpoint3.kind(Span.Kind.CONSUMER);
                    this.mr = v1Annotation3;
                } else if (v1Annotation3.value.equals("ws")) {
                    this.ws = v1Annotation3;
                } else if (v1Annotation3.value.equals("wr")) {
                    this.wr = v1Annotation3;
                } else {
                    builderForEndpoint3.addAnnotation(v1Annotation3.timestamp, v1Annotation3.value);
                }
            } else {
                builderForEndpoint3.addAnnotation(v1Annotation3.timestamp, v1Annotation3.value);
            }
        }
        if (this.cs == null && endTimestampReflectsSpanDuration(this.cr, v1Span)) {
            this.cs = V1Annotation.create(v1Span.timestamp, "cs", this.cr.endpoint);
        }
        if (this.sr == null && endTimestampReflectsSpanDuration(this.ss, v1Span)) {
            this.sr = V1Annotation.create(v1Span.timestamp, "sr", this.ss.endpoint);
        }
        V1Annotation v1Annotation4 = this.cs;
        if (v1Annotation4 != null && this.sr != null) {
            maybeTimestampDuration(v1Span, v1Annotation4, this.cr);
            Span.Builder builderForEndpoint4 = forEndpoint(v1Span, this.cs.endpoint);
            if (hasSameServiceName(this.cs.endpoint, this.sr.endpoint)) {
                builderForEndpoint4.kind(Span.Kind.CLIENT);
                builderForEndpoint2 = newSpanBuilder(v1Span, this.sr.endpoint).kind(Span.Kind.SERVER);
            } else {
                builderForEndpoint2 = forEndpoint(v1Span, this.sr.endpoint);
            }
            builderForEndpoint2.shared(true).timestamp(this.sr.timestamp);
            V1Annotation v1Annotation5 = this.ss;
            if (v1Annotation5 != null) {
                builderForEndpoint2.duration(v1Annotation5.timestamp - this.sr.timestamp);
            }
            if (this.cr == null && v1Span.duration == 0) {
                builderForEndpoint4.duration((Long) null);
            }
        } else if (v1Annotation4 != null && (v1Annotation2 = this.cr) != null) {
            maybeTimestampDuration(v1Span, v1Annotation4, v1Annotation2);
        } else {
            V1Annotation v1Annotation6 = this.sr;
            if (v1Annotation6 != null && (v1Annotation = this.ss) != null) {
                maybeTimestampDuration(v1Span, v1Annotation6, v1Annotation);
            } else {
                handleIncompleteRpc(v1Span);
            }
        }
        if (this.cs == null && this.sr != null && (v1Span.timestamp == 0 || (this.ss != null && v1Span.duration == 0))) {
            forEndpoint(v1Span, this.sr.endpoint).shared(true);
        }
        V1Annotation v1Annotation7 = this.ms;
        if (v1Annotation7 != null && this.mr != null) {
            Span.Builder builderForEndpoint5 = forEndpoint(v1Span, v1Annotation7.endpoint);
            if (hasSameServiceName(this.ms.endpoint, this.mr.endpoint)) {
                builderForEndpoint5.kind(Span.Kind.PRODUCER);
                builderForEndpoint = newSpanBuilder(v1Span, this.mr.endpoint).kind(Span.Kind.CONSUMER);
            } else {
                builderForEndpoint = forEndpoint(v1Span, this.mr.endpoint);
            }
            builderForEndpoint.shared(true);
            V1Annotation v1Annotation8 = this.wr;
            if (v1Annotation8 != null) {
                builderForEndpoint.timestamp(v1Annotation8.timestamp).duration(this.mr.timestamp - this.wr.timestamp);
            } else {
                builderForEndpoint.timestamp(this.mr.timestamp);
            }
            Span.Builder builderTimestamp = builderForEndpoint5.timestamp(this.ms.timestamp);
            V1Annotation v1Annotation9 = this.ws;
            builderTimestamp.duration(v1Annotation9 != null ? Long.valueOf(v1Annotation9.timestamp - this.ms.timestamp) : null);
            return;
        }
        if (v1Annotation7 != null) {
            maybeTimestampDuration(v1Span, v1Annotation7, this.ws);
            return;
        }
        V1Annotation v1Annotation10 = this.mr;
        if (v1Annotation10 != null) {
            V1Annotation v1Annotation11 = this.wr;
            if (v1Annotation11 != null) {
                maybeTimestampDuration(v1Span, v1Annotation11, v1Annotation10);
                return;
            } else {
                maybeTimestampDuration(v1Span, v1Annotation10, null);
                return;
            }
        }
        V1Annotation v1Annotation12 = this.ws;
        if (v1Annotation12 != null) {
            forEndpoint(v1Span, v1Annotation12.endpoint).addAnnotation(this.ws.timestamp, this.ws.value);
        }
        V1Annotation v1Annotation13 = this.wr;
        if (v1Annotation13 != null) {
            forEndpoint(v1Span, v1Annotation13.endpoint).addAnnotation(this.wr.timestamp, this.wr.value);
        }
    }

    void handleIncompleteRpc(V1Span v1Span) {
        handleIncompleteRpc(this.first);
        int size = this.spans.size();
        for (int i = 0; i < size; i++) {
            handleIncompleteRpc(this.spans.get(i));
        }
        if (v1Span.timestamp != 0) {
            this.first.timestamp(v1Span.timestamp).duration(v1Span.duration);
        }
    }

    void handleIncompleteRpc(Span.Builder builder) {
        if (Span.Kind.CLIENT.equals(builder.kind())) {
            V1Annotation v1Annotation = this.cs;
            if (v1Annotation != null) {
                builder.timestamp(v1Annotation.timestamp);
            }
            V1Annotation v1Annotation2 = this.cr;
            if (v1Annotation2 != null) {
                builder.addAnnotation(v1Annotation2.timestamp, this.cr.value);
                return;
            }
            return;
        }
        if (Span.Kind.SERVER.equals(builder.kind())) {
            V1Annotation v1Annotation3 = this.sr;
            if (v1Annotation3 != null) {
                builder.timestamp(v1Annotation3.timestamp);
            }
            V1Annotation v1Annotation4 = this.ss;
            if (v1Annotation4 != null) {
                builder.addAnnotation(v1Annotation4.timestamp, this.ss.value);
            }
        }
    }

    static boolean endTimestampReflectsSpanDuration(V1Annotation v1Annotation, V1Span v1Span) {
        return (v1Annotation == null || v1Span.timestamp == 0 || v1Span.duration == 0 || v1Span.timestamp + v1Span.duration != v1Annotation.timestamp) ? false : true;
    }

    void maybeTimestampDuration(V1Span v1Span, V1Annotation v1Annotation, @Nullable V1Annotation v1Annotation2) {
        Span.Builder builderForEndpoint = forEndpoint(v1Span, v1Annotation.endpoint);
        if (v1Span.timestamp != 0 && v1Span.duration != 0) {
            builderForEndpoint.timestamp(v1Span.timestamp).duration(v1Span.duration);
            return;
        }
        builderForEndpoint.timestamp(v1Annotation.timestamp);
        if (v1Annotation2 != null) {
            builderForEndpoint.duration(v1Annotation2.timestamp - v1Annotation.timestamp);
        }
    }

    void processBinaryAnnotations(V1Span v1Span) {
        int size = v1Span.binaryAnnotations.size();
        Endpoint endpointBuild = null;
        Endpoint endpoint = null;
        Endpoint endpoint2 = null;
        for (int i = 0; i < size; i++) {
            V1BinaryAnnotation v1BinaryAnnotation = v1Span.binaryAnnotations.get(i);
            if ("ca".equals(v1BinaryAnnotation.key)) {
                endpointBuild = v1BinaryAnnotation.endpoint;
            } else if ("sa".equals(v1BinaryAnnotation.key)) {
                endpoint = v1BinaryAnnotation.endpoint;
            } else if ("ma".equals(v1BinaryAnnotation.key)) {
                endpoint2 = v1BinaryAnnotation.endpoint;
            } else {
                Span.Builder builderForEndpoint = forEndpoint(v1Span, v1BinaryAnnotation.endpoint);
                if (!"lc".equals(v1BinaryAnnotation.key) || !v1BinaryAnnotation.stringValue.isEmpty()) {
                    builderForEndpoint.putTag(v1BinaryAnnotation.key, v1BinaryAnnotation.stringValue);
                }
            }
        }
        if (this.cs == null && this.cr == null && this.ss == null && this.sr == null && (endpointBuild != null || endpoint != null)) {
            if (endpointBuild != null && endpoint != null) {
                forEndpoint(v1Span, endpointBuild).remoteEndpoint(endpoint);
                return;
            } else if (endpoint != null) {
                forEndpoint(v1Span, null).remoteEndpoint(endpoint);
                return;
            } else {
                forEndpoint(v1Span, null).kind(Span.Kind.SERVER).remoteEndpoint(endpointBuild);
                return;
            }
        }
        V1Annotation v1Annotation = this.sr;
        if (v1Annotation == null) {
            v1Annotation = this.ss;
        }
        if (endpointBuild != null && v1Annotation != null && !endpointBuild.equals(v1Annotation.endpoint)) {
            if (hasSameServiceName(endpointBuild, v1Annotation.endpoint)) {
                endpointBuild = endpointBuild.toBuilder().serviceName(null).build();
            }
            forEndpoint(v1Span, v1Annotation.endpoint).remoteEndpoint(endpointBuild);
        }
        if (endpoint != null) {
            V1Annotation v1Annotation2 = this.cs;
            if (v1Annotation2 != null) {
                forEndpoint(v1Span, v1Annotation2.endpoint).remoteEndpoint(endpoint);
            } else {
                V1Annotation v1Annotation3 = this.cr;
                if (v1Annotation3 != null) {
                    forEndpoint(v1Span, v1Annotation3.endpoint).remoteEndpoint(endpoint);
                }
            }
        }
        if (endpoint2 != null) {
            V1Annotation v1Annotation4 = this.ms;
            if (v1Annotation4 != null) {
                forEndpoint(v1Span, v1Annotation4.endpoint).remoteEndpoint(endpoint2);
            }
            V1Annotation v1Annotation5 = this.mr;
            if (v1Annotation5 != null) {
                forEndpoint(v1Span, v1Annotation5.endpoint).remoteEndpoint(endpoint2);
            }
        }
    }

    Span.Builder forEndpoint(V1Span v1Span, @Nullable Endpoint endpoint) {
        if (endpoint == null) {
            return this.first;
        }
        if (closeEnoughEndpoint(this.first, endpoint)) {
            return this.first;
        }
        int size = this.spans.size();
        for (int i = 0; i < size; i++) {
            Span.Builder builder = this.spans.get(i);
            if (closeEnoughEndpoint(builder, endpoint)) {
                return builder;
            }
        }
        return newSpanBuilder(v1Span, endpoint);
    }

    static boolean closeEnoughEndpoint(Span.Builder builder, Endpoint endpoint) {
        Endpoint endpointLocalEndpoint = builder.localEndpoint();
        if (endpointLocalEndpoint == null) {
            builder.localEndpoint(endpoint);
            return true;
        }
        return hasSameServiceName(endpointLocalEndpoint, endpoint);
    }

    Span.Builder newSpanBuilder(V1Span v1Span, Endpoint endpoint) {
        Span.Builder builderLocalEndpoint = newBuilder(Span.newBuilder(), v1Span).localEndpoint(endpoint);
        this.spans.add(builderLocalEndpoint);
        return builderLocalEndpoint;
    }

    void finish(Collection<Span> collection) {
        collection.add(this.first.build());
        int size = this.spans.size();
        for (int i = 0; i < size; i++) {
            collection.add(this.spans.get(i).build());
        }
    }

    static boolean hasSameServiceName(Endpoint endpoint, @Nullable Endpoint endpoint2) {
        return equal(endpoint.serviceName(), endpoint2.serviceName());
    }

    static boolean equal(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static Span.Builder newBuilder(Span.Builder builder, V1Span v1Span) {
        return builder.traceId(v1Span.traceIdHigh, v1Span.traceId).parentId(v1Span.parentId).id(v1Span.id).name(v1Span.name).debug(v1Span.debug);
    }

    V1SpanConverter() {
    }
}
