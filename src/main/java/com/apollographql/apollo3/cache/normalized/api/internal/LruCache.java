package com.apollographql.apollo3.cache.normalized.api.internal;

import com.box.android.observability.DiagnosisParams;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import com.pspdfkit.annotations.NoteAnnotation;
import external.sdk.pendo.io.mozilla.javascript.ES6Iterator;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: LruCache.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0001&B;\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012,\b\u0002\u0010\u0006\u001a&\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\u0004\u0012\u00020\u00050\u0007j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\b¢\u0006\u0002\u0010\tJ+\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f2\u0006\u0010\u0012\u001a\u00028\u00002\b\u0010\u0013\u001a\u0004\u0018\u00018\u0001H\u0002¢\u0006\u0002\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\u0016J\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0018J\u0018\u0010\u0019\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0012\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u001aJ\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cJ\u001c\u0010\u001d\u001a\u00020\u00162\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\fH\u0002J\u0015\u0010\u001f\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0012\u001a\u00028\u0000¢\u0006\u0002\u0010\u001aJ\u0014\u0010\u001f\u001a\u00020\u00162\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000 J\u0017\u0010!\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0012\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001aJ\u001e\u0010\"\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u0001H\u0086\u0002¢\u0006\u0002\u0010#J\u0006\u0010\u000f\u001a\u00020\u0005J\b\u0010$\u001a\u00020\u0016H\u0002J\u001c\u0010%\u001a\u00020\u00162\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\fH\u0002RB\u0010\n\u001a6\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f0\u000bj\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\u0006\u001a&\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\u0004\u0012\u00020\u00050\u0007j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/api/internal/LruCache;", NoteAnnotation.KEY, "Value", "", "maxSize", "", "weigher", "Lkotlin/Function2;", "Lcom/apollographql/apollo3/cache/normalized/api/internal/Weigher;", "(ILkotlin/jvm/functions/Function2;)V", SemanticAttributes.DbSystemValues.CACHE, "Ljava/util/LinkedHashMap;", "Lcom/apollographql/apollo3/cache/normalized/api/internal/LruCache$Node;", "Lkotlin/collections/LinkedHashMap;", "headNode", "size", "tailNode", "addNode", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Lcom/apollographql/apollo3/cache/normalized/api/internal/LruCache$Node;", DiagnosisParams.CLEAR_ON_LOGOUT, "", "dump", "", PasskeyWebListener.GET_UNIQUE_KEY, "(Ljava/lang/Object;)Ljava/lang/Object;", "keys", "", "moveNodeToHead", "node", "remove", "", "removeUnsafe", "set", "(Ljava/lang/Object;Ljava/lang/Object;)V", "trim", "unlinkNode", "Node", "apollo-normalized-cache-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LruCache<Key, Value> {
    private final LinkedHashMap<Key, Node<Key, Value>> cache;
    private Node<Key, Value> headNode;
    private final int maxSize;
    private int size;
    private Node<Key, Value> tailNode;
    private final Function2<Key, Value, Integer> weigher;

    /* JADX WARN: Multi-variable type inference failed */
    public LruCache(int i, Function2<? super Key, ? super Value, Integer> weigher) {
        Intrinsics.checkNotNullParameter(weigher, "weigher");
        this.maxSize = i;
        this.weigher = weigher;
        this.cache = new LinkedHashMap<>(0, 0.75f);
    }

    public /* synthetic */ LruCache(int i, AnonymousClass1 anonymousClass1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? new Function2<Key, Value, Integer>() { // from class: com.apollographql.apollo3.cache.normalized.api.internal.LruCache.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function2
            public final Integer invoke(Key key, Value value) {
                return 1;
            }
        } : anonymousClass1);
    }

    public final Value get(Key key) {
        Node<Key, Value> node = this.cache.get(key);
        if (node != null) {
            moveNodeToHead(node);
        }
        if (node != null) {
            return node.getValue();
        }
        return null;
    }

    public final void set(Key key, Value value) {
        Node<Key, Value> node = this.cache.get(key);
        if (node == null) {
            this.cache.put(key, addNode(key, value));
        } else {
            node.setValue(value);
            moveNodeToHead(node);
        }
        trim();
    }

    public final Value remove(Key key) {
        return removeUnsafe(key);
    }

    public final Set<Key> keys() {
        Set<Key> setKeySet = this.cache.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "cache.keys");
        return setKeySet;
    }

    private final Value removeUnsafe(Key key) {
        Node<Key, Value> nodeRemove = this.cache.remove(key);
        Value value = nodeRemove != null ? nodeRemove.getValue() : null;
        if (nodeRemove != null) {
            unlinkNode(nodeRemove);
        }
        return value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void remove(Collection<? extends Key> keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        Iterator<T> it = keys.iterator();
        while (it.hasNext()) {
            removeUnsafe(it.next());
        }
    }

    public final void clear() {
        this.cache.clear();
        this.headNode = null;
        this.tailNode = null;
        this.size = 0;
    }

    /* JADX INFO: renamed from: size, reason: from getter */
    public final int getSize() {
        return this.size;
    }

    public final Map<Key, Value> dump() {
        LinkedHashMap<Key, Node<Key, Value>> linkedHashMap = this.cache;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
        Iterator<T> it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap2.put(entry.getKey(), ((Node) entry.getValue()).getValue());
        }
        return linkedHashMap2;
    }

    private final void trim() {
        Node<Key, Value> node = this.tailNode;
        while (node != null && this.size > this.maxSize) {
            LinkedHashMap<Key, Node<Key, Value>> linkedHashMap = this.cache;
            TypeIntrinsics.asMutableMap(linkedHashMap).remove(node.getKey());
            unlinkNode(node);
            node = this.tailNode;
        }
    }

    private final Node<Key, Value> addNode(Key key, Value value) {
        Node<Key, Value> node = new Node<>(key, value, this.headNode, null);
        this.headNode = node;
        if (node.getNext() == null) {
            this.tailNode = this.headNode;
        } else {
            Node<Key, Value> next = node.getNext();
            if (next != null) {
                next.setPrev(this.headNode);
            }
        }
        this.size += this.weigher.invoke(key, value).intValue();
        return node;
    }

    private final void moveNodeToHead(Node<Key, Value> node) {
        if (node.getPrev() == null) {
            return;
        }
        Node<Key, Value> prev = node.getPrev();
        if (prev != null) {
            prev.setNext(node.getNext());
        }
        if (node.getNext() == null) {
            this.tailNode = node.getPrev();
        } else {
            Node<Key, Value> next = node.getNext();
            if (next != null) {
                next.setPrev(node.getPrev());
            }
        }
        node.setNext(this.headNode);
        node.setPrev(null);
        Node<Key, Value> node2 = this.headNode;
        if (node2 != null) {
            node2.setPrev(node);
        }
        this.headNode = node;
    }

    private final void unlinkNode(Node<Key, Value> node) {
        if (node.getPrev() == null) {
            this.headNode = node.getNext();
        } else {
            Node<Key, Value> prev = node.getPrev();
            if (prev != null) {
                prev.setNext(node.getNext());
            }
        }
        if (node.getNext() == null) {
            this.tailNode = node.getPrev();
        } else {
            Node<Key, Value> next = node.getNext();
            if (next != null) {
                next.setPrev(node.getPrev());
            }
        }
        int i = this.size;
        Function2<Key, Value, Integer> function2 = this.weigher;
        Key key = node.getKey();
        Intrinsics.checkNotNull(key);
        this.size = i - function2.invoke(key, node.getValue()).intValue();
        node.setKey(null);
        node.setValue(null);
        node.setNext(null);
        node.setPrev(null);
    }

    /* JADX INFO: compiled from: LruCache.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\b\u0002\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003BE\u0012\b\u0010\u0004\u001a\u0004\u0018\u00018\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00018\u0003\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u0000\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u0000¢\u0006\u0002\u0010\bR\u001e\u0010\u0004\u001a\u0004\u0018\u00018\u0002X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR(\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001e\u0010\u0005\u001a\u0004\u0018\u00018\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/api/internal/LruCache$Node;", NoteAnnotation.KEY, "Value", "", "key", "value", ES6Iterator.NEXT_METHOD, "prev", "(Ljava/lang/Object;Ljava/lang/Object;Lcom/apollographql/apollo3/cache/normalized/api/internal/LruCache$Node;Lcom/apollographql/apollo3/cache/normalized/api/internal/LruCache$Node;)V", "getKey", "()Ljava/lang/Object;", "setKey", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getNext", "()Lcom/apollographql/apollo3/cache/normalized/api/internal/LruCache$Node;", "setNext", "(Lcom/apollographql/apollo3/cache/normalized/api/internal/LruCache$Node;)V", "getPrev", "setPrev", "getValue", "setValue", "apollo-normalized-cache-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Node<Key, Value> {
        private Key key;
        private Node<Key, Value> next;
        private Node<Key, Value> prev;
        private Value value;

        public Node(Key key, Value value, Node<Key, Value> node, Node<Key, Value> node2) {
            this.key = key;
            this.value = value;
            this.next = node;
            this.prev = node2;
        }

        public final Key getKey() {
            return this.key;
        }

        public final void setKey(Key key) {
            this.key = key;
        }

        public final Value getValue() {
            return this.value;
        }

        public final void setValue(Value value) {
            this.value = value;
        }

        public final Node<Key, Value> getNext() {
            return this.next;
        }

        public final void setNext(Node<Key, Value> node) {
            this.next = node;
        }

        public final Node<Key, Value> getPrev() {
            return this.prev;
        }

        public final void setPrev(Node<Key, Value> node) {
            this.prev = node;
        }
    }
}
