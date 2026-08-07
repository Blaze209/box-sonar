package zipkin2.internal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;
import zipkin2.Endpoint;
import zipkin2.Span;

/* JADX INFO: loaded from: classes6.dex */
public final class SpanNode {
    static final Comparator<SpanNode> NODE_COMPARATOR = new Comparator<SpanNode>() { // from class: zipkin2.internal.SpanNode.1
        @Override // java.util.Comparator
        public int compare(SpanNode spanNode, SpanNode spanNode2) {
            long jTimestampAsLong = spanNode.span().timestampAsLong();
            long jTimestampAsLong2 = spanNode2.span().timestampAsLong();
            if (jTimestampAsLong < jTimestampAsLong2) {
                return -1;
            }
            return jTimestampAsLong == jTimestampAsLong2 ? 0 : 1;
        }
    };
    List<SpanNode> children = Collections.emptyList();

    @Nullable
    SpanNode parent;

    @Nullable
    Span span;

    public static Builder newBuilder(Logger logger) {
        return new Builder(logger);
    }

    SpanNode(@Nullable Span span) {
        this.span = span;
    }

    @Nullable
    public SpanNode parent() {
        return this.parent;
    }

    @Nullable
    public Span span() {
        return this.span;
    }

    public List<SpanNode> children() {
        return this.children;
    }

    public Iterator<SpanNode> traverse() {
        return new BreadthFirstIterator(this);
    }

    static final class BreadthFirstIterator implements Iterator<SpanNode> {
        final ArrayDeque<SpanNode> queue;

        BreadthFirstIterator(SpanNode spanNode) {
            ArrayDeque<SpanNode> arrayDeque = new ArrayDeque<>();
            this.queue = arrayDeque;
            if (spanNode.span == null) {
                int size = spanNode.children.size();
                for (int i = 0; i < size; i++) {
                    this.queue.add(spanNode.children.get(i));
                }
                return;
            }
            arrayDeque.add(spanNode);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.queue.isEmpty();
        }

        @Override // java.util.Iterator
        public SpanNode next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            SpanNode spanNodeRemove = this.queue.remove();
            int size = spanNodeRemove.children.size();
            for (int i = 0; i < size; i++) {
                this.queue.add(spanNodeRemove.children.get(i));
            }
            return spanNodeRemove;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }

    SpanNode addChild(SpanNode spanNode) {
        if (spanNode == null) {
            throw new NullPointerException("child == null");
        }
        if (spanNode == this) {
            throw new IllegalArgumentException("circular dependency on " + this);
        }
        if (this.children.equals(Collections.emptyList())) {
            this.children = new ArrayList();
        }
        this.children.add(spanNode);
        spanNode.parent = this;
        return this;
    }

    public static final class Builder {
        final Logger logger;
        SpanNode rootSpan = null;
        Map<Object, SpanNode> keyToNode = new LinkedHashMap();
        Map<Object, Object> spanToParent = new LinkedHashMap();

        Builder(Logger logger) {
            this.logger = logger;
        }

        void clear() {
            this.rootSpan = null;
            this.keyToNode.clear();
            this.spanToParent.clear();
        }

        public SpanNode build(List<Span> list) {
            if (list.isEmpty()) {
                throw new IllegalArgumentException("spans were empty");
            }
            clear();
            List<Span> listMerge = Trace.merge(list);
            int size = listMerge.size();
            String strTraceId = listMerge.get(0).traceId();
            if (this.logger.isLoggable(Level.FINE)) {
                this.logger.fine("building trace tree: traceId=" + strTraceId);
            }
            for (int i = 0; i < size; i++) {
                index(listMerge.get(i));
            }
            for (int i2 = 0; i2 < size; i2++) {
                process(listMerge.get(i2));
            }
            if (this.rootSpan == null) {
                if (this.logger.isLoggable(Level.FINE)) {
                    this.logger.fine("substituting dummy node for missing root span: traceId=" + strTraceId);
                }
                this.rootSpan = new SpanNode(null);
            }
            for (Map.Entry<Object, Object> entry : this.spanToParent.entrySet()) {
                SpanNode spanNode = this.keyToNode.get(entry.getKey());
                SpanNode spanNode2 = this.keyToNode.get(entry.getValue());
                if (spanNode2 == null) {
                    this.rootSpan.addChild(spanNode);
                } else {
                    spanNode2.addChild(spanNode);
                }
            }
            sortTreeByTimestamp(this.rootSpan);
            return this.rootSpan;
        }

        void sortTreeByTimestamp(SpanNode spanNode) {
            ArrayDeque arrayDeque = new ArrayDeque();
            arrayDeque.add(spanNode);
            while (!arrayDeque.isEmpty()) {
                SpanNode spanNode2 = (SpanNode) arrayDeque.pop();
                if (!spanNode2.children().isEmpty()) {
                    Collections.sort(spanNode2.children(), SpanNode.NODE_COMPARATOR);
                    arrayDeque.addAll(spanNode2.children());
                }
            }
        }

        void index(Span span) {
            Object objId;
            String strParentId;
            if (Boolean.TRUE.equals(span.shared())) {
                objId = SpanNode.createKey(span.id(), true, span.localEndpoint());
                strParentId = span.id();
            } else {
                objId = span.id();
                strParentId = span.parentId();
            }
            this.spanToParent.put(objId, strParentId);
        }

        void process(Span span) {
            Endpoint endpointLocalEndpoint = span.localEndpoint();
            boolean zEquals = Boolean.TRUE.equals(span.shared());
            Object objCreateKey = SpanNode.createKey(span.id(), zEquals, span.localEndpoint());
            Object objCreateKey2 = null;
            Object objCreateKey3 = endpointLocalEndpoint != null ? SpanNode.createKey(span.id(), zEquals, null) : objCreateKey;
            if (zEquals) {
                objCreateKey2 = span.id();
            } else if (span.parentId() != null) {
                objCreateKey2 = SpanNode.createKey(span.parentId(), true, endpointLocalEndpoint);
                if (this.spanToParent.containsKey(objCreateKey2)) {
                    this.spanToParent.put(objCreateKey3, objCreateKey2);
                } else {
                    objCreateKey2 = span.parentId();
                }
            } else if (this.rootSpan != null && this.logger.isLoggable(Level.FINE)) {
                this.logger.fine(String.format("attributing span missing parent to root: traceId=%s, rootSpanId=%s, spanId=%s", span.traceId(), this.rootSpan.span().id(), span.id()));
            }
            SpanNode spanNode = new SpanNode(span);
            if (objCreateKey2 == null && this.rootSpan == null) {
                this.rootSpan = spanNode;
                this.spanToParent.remove(objCreateKey3);
            } else if (zEquals) {
                this.keyToNode.put(objCreateKey, spanNode);
                this.keyToNode.put(objCreateKey3, spanNode);
            } else {
                this.keyToNode.put(objCreateKey3, spanNode);
            }
        }
    }

    static Object createKey(String str, boolean z, @Nullable Endpoint endpoint) {
        return !z ? str : new SharedKey(str, endpoint);
    }

    static final class SharedKey {

        @Nullable
        final Endpoint endpoint;
        final String id;

        SharedKey(String str, @Nullable Endpoint endpoint) {
            if (str == null) {
                throw new NullPointerException("id == null");
            }
            this.id = str;
            this.endpoint = endpoint;
        }

        public String toString() {
            return "SharedKey{id=" + this.id + ", endpoint=" + this.endpoint + "}";
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SharedKey)) {
                return false;
            }
            SharedKey sharedKey = (SharedKey) obj;
            return this.id.equals(sharedKey.id) && equal(this.endpoint, sharedKey.endpoint);
        }

        static boolean equal(Object obj, Object obj2) {
            if (obj != obj2) {
                return obj != null && obj.equals(obj2);
            }
            return true;
        }

        public int hashCode() {
            int iHashCode = (this.id.hashCode() ^ 1000003) * 1000003;
            Endpoint endpoint = this.endpoint;
            return (endpoint == null ? 0 : endpoint.hashCode()) ^ iHashCode;
        }
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int size = this.children.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(this.children.get(i).span);
        }
        StringBuilder sb = new StringBuilder("SpanNode{parent=");
        SpanNode spanNode = this.parent;
        return sb.append(spanNode != null ? spanNode.span : null).append(", span=").append(this.span).append(", children=").append(arrayList).append("}").toString();
    }
}
