package zipkin2.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import zipkin2.DependencyLink;
import zipkin2.Span;

/* JADX INFO: loaded from: classes6.dex */
public final class DependencyLinker {
    final SpanNode.Builder builder;
    final Map<Pair, Long> callCounts;
    final Map<Pair, Long> errorCounts;
    final Logger logger;

    public DependencyLinker() {
        this(Logger.getLogger(DependencyLinker.class.getName()));
    }

    DependencyLinker(Logger logger) {
        this.callCounts = new LinkedHashMap();
        this.errorCounts = new LinkedHashMap();
        this.logger = logger;
        this.builder = SpanNode.newBuilder(logger);
    }

    public DependencyLinker putTrace(List<Span> list) {
        String str;
        String strLocalServiceName;
        if (!list.isEmpty()) {
            SpanNode spanNodeBuild = this.builder.build(list);
            if (this.logger.isLoggable(Level.FINE)) {
                this.logger.fine("traversing trace tree, breadth-first");
            }
            Iterator<SpanNode> itTraverse = spanNodeBuild.traverse();
            while (itTraverse.hasNext()) {
                SpanNode next = itTraverse.next();
                Span span = next.span();
                if (this.logger.isLoggable(Level.FINE)) {
                    this.logger.fine("processing " + span);
                }
                Span.Kind kind = span.kind();
                if (!Span.Kind.CLIENT.equals(kind) || next.children().isEmpty()) {
                    String strLocalServiceName2 = span.localServiceName();
                    String strRemoteServiceName = span.remoteServiceName();
                    if (kind == null) {
                        if (strLocalServiceName2 != null && strRemoteServiceName != null) {
                            kind = Span.Kind.CLIENT;
                        } else {
                            this.logger.fine("non remote span; skipping");
                        }
                    }
                    int i = AnonymousClass1.$SwitchMap$zipkin2$Span$Kind[kind.ordinal()];
                    if (i == 1 || i == 2) {
                        if (next == spanNodeBuild && strRemoteServiceName == null) {
                            this.logger.fine("root's client is unknown; skipping");
                        } else {
                            str = strRemoteServiceName;
                            strRemoteServiceName = strLocalServiceName2;
                            boolean zContainsKey = span.tags().containsKey("error");
                            if (kind == Span.Kind.PRODUCER && kind != Span.Kind.CONSUMER) {
                                Span spanFirstRemoteAncestor = firstRemoteAncestor(next);
                                if (spanFirstRemoteAncestor != null && (strLocalServiceName = spanFirstRemoteAncestor.localServiceName()) != null) {
                                    if (kind == Span.Kind.CLIENT && strLocalServiceName2 != null && !strLocalServiceName.equals(strLocalServiceName2)) {
                                        this.logger.fine("detected missing link to client span");
                                        addLink(strLocalServiceName, strLocalServiceName2, false);
                                    }
                                    if (kind == Span.Kind.SERVER || str == null) {
                                        str = strLocalServiceName;
                                    }
                                    if (!zContainsKey && Span.Kind.CLIENT.equals(spanFirstRemoteAncestor.kind()) && span.parentId() != null && span.parentId().equals(spanFirstRemoteAncestor.id())) {
                                        zContainsKey = spanFirstRemoteAncestor.tags().containsKey("error");
                                    }
                                }
                                if (str == null || strRemoteServiceName == null) {
                                    this.logger.fine("cannot find remote ancestor; skipping");
                                } else {
                                    addLink(str, strRemoteServiceName, zContainsKey);
                                }
                            } else if (str != null || strRemoteServiceName == null) {
                                this.logger.fine("cannot link messaging span to its broker; skipping");
                            } else {
                                addLink(str, strRemoteServiceName, zContainsKey);
                            }
                        }
                    } else if (i != 3 && i != 4) {
                        this.logger.fine("unknown kind; skipping");
                    } else {
                        str = strLocalServiceName2;
                        boolean zContainsKey2 = span.tags().containsKey("error");
                        if (kind == Span.Kind.PRODUCER) {
                        }
                        if (str != null) {
                        }
                        this.logger.fine("cannot link messaging span to its broker; skipping");
                    }
                }
            }
        }
        return this;
    }

    /* JADX INFO: renamed from: zipkin2.internal.DependencyLinker$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$zipkin2$Span$Kind;

        static {
            int[] iArr = new int[Span.Kind.values().length];
            $SwitchMap$zipkin2$Span$Kind = iArr;
            try {
                iArr[Span.Kind.SERVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$zipkin2$Span$Kind[Span.Kind.CONSUMER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$zipkin2$Span$Kind[Span.Kind.CLIENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$zipkin2$Span$Kind[Span.Kind.PRODUCER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    Span firstRemoteAncestor(SpanNode spanNode) {
        for (SpanNode spanNodeParent = spanNode.parent(); spanNodeParent != null; spanNodeParent = spanNodeParent.parent()) {
            Span span = spanNodeParent.span();
            if (span != null && span.kind() != null) {
                if (this.logger.isLoggable(Level.FINE)) {
                    this.logger.fine("found remote ancestor " + span);
                }
                return span;
            }
        }
        return null;
    }

    void addLink(String str, String str2, boolean z) {
        if (this.logger.isLoggable(Level.FINE)) {
            this.logger.fine("incrementing " + (z ? "error " : "") + "link " + str + " -> " + str2);
        }
        Pair pair = new Pair(str, str2);
        if (this.callCounts.containsKey(pair)) {
            Map<Pair, Long> map = this.callCounts;
            map.put(pair, Long.valueOf(map.get(pair).longValue() + 1));
        } else {
            this.callCounts.put(pair, 1L);
        }
        if (z) {
            if (this.errorCounts.containsKey(pair)) {
                Map<Pair, Long> map2 = this.errorCounts;
                map2.put(pair, Long.valueOf(map2.get(pair).longValue() + 1));
            } else {
                this.errorCounts.put(pair, 1L);
            }
        }
    }

    public List<DependencyLink> link() {
        return link(this.callCounts, this.errorCounts);
    }

    public static List<DependencyLink> merge(Iterable<DependencyLink> iterable) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (DependencyLink dependencyLink : iterable) {
            Pair pair = new Pair(dependencyLink.parent(), dependencyLink.child());
            long jLongValue = 0;
            linkedHashMap.put(pair, Long.valueOf((linkedHashMap.containsKey(pair) ? ((Long) linkedHashMap.get(pair)).longValue() : 0L) + dependencyLink.callCount()));
            if (linkedHashMap2.containsKey(pair)) {
                jLongValue = ((Long) linkedHashMap2.get(pair)).longValue();
            }
            linkedHashMap2.put(pair, Long.valueOf(jLongValue + dependencyLink.errorCount()));
        }
        return link(linkedHashMap, linkedHashMap2);
    }

    static List<DependencyLink> link(Map<Pair, Long> map, Map<Pair, Long> map2) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<Pair, Long> entry : map.entrySet()) {
            Pair key = entry.getKey();
            arrayList.add(DependencyLink.newBuilder().parent(key.left).child(key.right).callCount(entry.getValue().longValue()).errorCount(map2.containsKey(key) ? map2.get(key).longValue() : 0L).build());
        }
        return arrayList;
    }

    static final class Pair {
        final String left;
        final String right;

        Pair(String str, String str2) {
            this.left = str;
            this.right = str2;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Pair)) {
                return false;
            }
            Pair pair = (Pair) obj;
            return this.left.equals(pair.left) && this.right.equals(pair.right);
        }

        public int hashCode() {
            return this.right.hashCode() ^ ((this.left.hashCode() ^ 1000003) * 1000003);
        }
    }
}
