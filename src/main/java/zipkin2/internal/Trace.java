package zipkin2.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import zipkin2.Endpoint;
import zipkin2.Span;

/* JADX INFO: loaded from: classes6.dex */
public class Trace {
    static final Comparator<Span> CLEANUP_COMPARATOR = new Comparator<Span>() { // from class: zipkin2.internal.Trace.1
        @Override // java.util.Comparator
        public int compare(Span span, Span span2) {
            if (span.equals(span2)) {
                return 0;
            }
            int iCompareTo = span.id().compareTo(span2.id());
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            int iCompareShared = Trace.compareShared(span, span2);
            return iCompareShared != 0 ? iCompareShared : Trace.compareEndpoint(span.localEndpoint(), span2.localEndpoint());
        }
    };

    public static List<Span> merge(List<Span> list) {
        int i;
        int size = list.size();
        if (size <= 1) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList, CLEANUP_COMPARATOR);
        int i2 = 0;
        String strTraceId = ((Span) arrayList.get(0)).traceId();
        for (int i3 = 1; i3 < size; i3++) {
            String strTraceId2 = ((Span) arrayList.get(i3)).traceId();
            if (strTraceId.length() != 32) {
                strTraceId = strTraceId2;
            }
        }
        Span spanBuild = null;
        while (i2 < size) {
            Span span = (Span) arrayList.get(i2);
            boolean zEquals = Boolean.TRUE.equals(span.shared());
            Span.Builder builderTraceId = span.traceId().length() != strTraceId.length() ? span.toBuilder().traceId(strTraceId) : null;
            EndpointTracker endpointTracker = null;
            while (true) {
                i = i2 + 1;
                if (i >= size) {
                    break;
                }
                Span span2 = (Span) arrayList.get(i);
                if (!span2.id().equals(span.id())) {
                    break;
                }
                if (endpointTracker == null) {
                    endpointTracker = new EndpointTracker();
                    endpointTracker.tryMerge(span.localEndpoint());
                }
                if (zEquals != Boolean.TRUE.equals(span2.shared()) || !endpointTracker.tryMerge(span2.localEndpoint())) {
                    break;
                }
                if (builderTraceId == null) {
                    builderTraceId = span.toBuilder();
                }
                builderTraceId.merge(span2);
                size--;
                arrayList.remove(i);
            }
            if (spanBuild != null && spanBuild.id().equals(span.id())) {
                if (spanBuild.kind() == Span.Kind.CLIENT && span.kind() == Span.Kind.SERVER && !zEquals) {
                    if (builderTraceId == null) {
                        builderTraceId = span.toBuilder();
                    }
                    builderTraceId.shared(true);
                    zEquals = true;
                }
                if (zEquals && span.parentId() == null && spanBuild.parentId() != null) {
                    if (builderTraceId == null) {
                        builderTraceId = span.toBuilder();
                    }
                    builderTraceId.parentId(spanBuild.parentId());
                }
            }
            if (builderTraceId != null) {
                spanBuild = builderTraceId.build();
                arrayList.set(i2, spanBuild);
            } else {
                spanBuild = span;
            }
            i2 = i;
        }
        return arrayList;
    }

    static int compareShared(Span span, Span span2) {
        boolean zEquals = Boolean.TRUE.equals(span.shared());
        boolean zEquals2 = Boolean.TRUE.equals(span2.shared());
        if (zEquals && zEquals2) {
            return 0;
        }
        if (zEquals) {
            return 1;
        }
        if (zEquals2) {
            return -1;
        }
        boolean zEquals3 = Span.Kind.CLIENT.equals(span.kind());
        boolean zEquals4 = Span.Kind.CLIENT.equals(span2.kind());
        if (zEquals3 && zEquals4) {
            return 0;
        }
        if (zEquals3) {
            return -1;
        }
        return zEquals4 ? 1 : 0;
    }

    static int compareEndpoint(Endpoint endpoint, Endpoint endpoint2) {
        if (endpoint == null) {
            return endpoint2 == null ? 0 : -1;
        }
        if (endpoint2 == null) {
            return 1;
        }
        int iNullSafeCompareTo = nullSafeCompareTo(endpoint.serviceName(), endpoint2.serviceName(), false);
        if (iNullSafeCompareTo != 0) {
            return iNullSafeCompareTo;
        }
        int iNullSafeCompareTo2 = nullSafeCompareTo(endpoint.ipv4(), endpoint2.ipv4(), false);
        return iNullSafeCompareTo2 != 0 ? iNullSafeCompareTo2 : nullSafeCompareTo(endpoint.ipv6(), endpoint2.ipv6(), false);
    }

    static <T extends Comparable<T>> int nullSafeCompareTo(T t, T t2, boolean z) {
        if (t == null) {
            if (t2 == null) {
                return 0;
            }
            return z ? -1 : 1;
        }
        if (t2 == null) {
            return z ? 1 : -1;
        }
        return t.compareTo(t2);
    }

    static final class EndpointTracker {
        String ipv4;
        String ipv6;
        int port;
        String serviceName;

        EndpointTracker() {
        }

        boolean tryMerge(Endpoint endpoint) {
            if (endpoint == null) {
                return true;
            }
            if (this.serviceName != null && endpoint.serviceName() != null && !this.serviceName.equals(endpoint.serviceName())) {
                return false;
            }
            if (this.ipv4 != null && endpoint.ipv4() != null && !this.ipv4.equals(endpoint.ipv4())) {
                return false;
            }
            if (this.ipv6 != null && endpoint.ipv6() != null && !this.ipv6.equals(endpoint.ipv6())) {
                return false;
            }
            if (this.port != 0 && endpoint.portAsInt() != 0 && this.port != endpoint.portAsInt()) {
                return false;
            }
            if (this.serviceName == null) {
                this.serviceName = endpoint.serviceName();
            }
            if (this.ipv4 == null) {
                this.ipv4 = endpoint.ipv4();
            }
            if (this.ipv6 == null) {
                this.ipv6 = endpoint.ipv6();
            }
            if (this.port == 0) {
                this.port = endpoint.portAsInt();
            }
            return true;
        }
    }

    Trace() {
    }
}
