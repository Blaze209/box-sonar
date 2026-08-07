package zipkin2.storage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import zipkin2.Call;
import zipkin2.Callback;
import zipkin2.DependencyLink;
import zipkin2.Span;
import zipkin2.internal.DependencyLinker;

/* JADX INFO: loaded from: classes6.dex */
public final class InMemoryStorage extends StorageComponent implements SpanStore, SpanConsumer, AutocompleteTags, ServiceAndSpanNames, Traces {
    static final Comparator<String> STRING_COMPARATOR = new Comparator<String>() { // from class: zipkin2.storage.InMemoryStorage.6
        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            if (str == null) {
                return -1;
            }
            return str.compareTo(str2);
        }

        public String toString() {
            return "String::compareTo";
        }
    };
    static final Comparator<TraceIdTimestamp> TIMESTAMP_DESCENDING = new Comparator<TraceIdTimestamp>() { // from class: zipkin2.storage.InMemoryStorage.7
        @Override // java.util.Comparator
        public int compare(TraceIdTimestamp traceIdTimestamp, TraceIdTimestamp traceIdTimestamp2) {
            int i;
            long j = traceIdTimestamp.timestamp;
            long j2 = traceIdTimestamp2.timestamp;
            if (j < j2) {
                i = -1;
            } else {
                i = j == j2 ? 0 : 1;
            }
            return i != 0 ? -i : traceIdTimestamp2.lowTraceId.compareTo(traceIdTimestamp.lowTraceId);
        }

        public String toString() {
            return "TimestampDescending{}";
        }
    };
    final AtomicInteger acceptedSpanCount;
    final Set<String> autocompleteKeys;
    final Call<List<String>> autocompleteKeysCall;
    private final SortedMultimap<String, String> autocompleteTags;
    final int maxSpanCount;
    final boolean searchEnabled;
    private final SortedMultimap<String, String> serviceToRemoteServiceNames;
    private final SortedMultimap<String, String> serviceToSpanNames;
    private final ServiceNameToTraceIds serviceToTraceIds;
    private final SortedMultimap<TraceIdTimestamp, Span> spansByTraceIdTimestamp = new SortedMultimap<TraceIdTimestamp, Span>(TIMESTAMP_DESCENDING) { // from class: zipkin2.storage.InMemoryStorage.1
        @Override // zipkin2.storage.InMemoryStorage.SortedMultimap
        Collection<Span> valueContainer() {
            return new LinkedHashSet();
        }
    };
    final boolean strictTraceId;
    private final SortedMultimap<String, TraceIdTimestamp> traceIdToTraceIdTimestamps;

    @Override // zipkin2.storage.StorageComponent
    public InMemoryStorage autocompleteTags() {
        return this;
    }

    @Override // zipkin2.Component, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // zipkin2.storage.StorageComponent
    public InMemoryStorage serviceAndSpanNames() {
        return this;
    }

    @Override // zipkin2.storage.StorageComponent
    public SpanConsumer spanConsumer() {
        return this;
    }

    @Override // zipkin2.storage.StorageComponent
    public InMemoryStorage spanStore() {
        return this;
    }

    @Override // zipkin2.storage.StorageComponent
    public InMemoryStorage traces() {
        return this;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder extends StorageComponent.Builder {
        boolean strictTraceId = true;
        boolean searchEnabled = true;
        int maxSpanCount = 500000;
        List<String> autocompleteKeys = Collections.emptyList();

        @Override // zipkin2.storage.StorageComponent.Builder
        public /* bridge */ /* synthetic */ StorageComponent.Builder autocompleteKeys(List list) {
            return autocompleteKeys((List<String>) list);
        }

        @Override // zipkin2.storage.StorageComponent.Builder
        public Builder strictTraceId(boolean z) {
            this.strictTraceId = z;
            return this;
        }

        @Override // zipkin2.storage.StorageComponent.Builder
        public Builder searchEnabled(boolean z) {
            this.searchEnabled = z;
            return this;
        }

        @Override // zipkin2.storage.StorageComponent.Builder
        public Builder autocompleteKeys(List<String> list) {
            if (list == null) {
                throw new NullPointerException("autocompleteKeys == null");
            }
            this.autocompleteKeys = list;
            return this;
        }

        public Builder maxSpanCount(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("maxSpanCount <= 0");
            }
            this.maxSpanCount = i;
            return this;
        }

        @Override // zipkin2.storage.StorageComponent.Builder
        public InMemoryStorage build() {
            return new InMemoryStorage(this);
        }
    }

    InMemoryStorage(Builder builder) {
        Comparator<String> comparator = STRING_COMPARATOR;
        this.traceIdToTraceIdTimestamps = new SortedMultimap<String, TraceIdTimestamp>(comparator) { // from class: zipkin2.storage.InMemoryStorage.2
            @Override // zipkin2.storage.InMemoryStorage.SortedMultimap
            Collection<TraceIdTimestamp> valueContainer() {
                return new LinkedHashSet();
            }
        };
        this.serviceToTraceIds = new ServiceNameToTraceIds();
        this.serviceToSpanNames = new SortedMultimap<String, String>(comparator) { // from class: zipkin2.storage.InMemoryStorage.3
            @Override // zipkin2.storage.InMemoryStorage.SortedMultimap
            Collection<String> valueContainer() {
                return new LinkedHashSet();
            }
        };
        this.serviceToRemoteServiceNames = new SortedMultimap<String, String>(comparator) { // from class: zipkin2.storage.InMemoryStorage.4
            @Override // zipkin2.storage.InMemoryStorage.SortedMultimap
            Collection<String> valueContainer() {
                return new LinkedHashSet();
            }
        };
        this.autocompleteTags = new SortedMultimap<String, String>(comparator) { // from class: zipkin2.storage.InMemoryStorage.5
            @Override // zipkin2.storage.InMemoryStorage.SortedMultimap
            Collection<String> valueContainer() {
                return new LinkedHashSet();
            }
        };
        this.acceptedSpanCount = new AtomicInteger();
        this.strictTraceId = builder.strictTraceId;
        this.searchEnabled = builder.searchEnabled;
        this.maxSpanCount = builder.maxSpanCount;
        this.autocompleteKeysCall = Call.create(builder.autocompleteKeys);
        this.autocompleteKeys = new LinkedHashSet(builder.autocompleteKeys);
    }

    public int acceptedSpanCount() {
        return this.acceptedSpanCount.get();
    }

    public synchronized void clear() {
        this.acceptedSpanCount.set(0);
        this.traceIdToTraceIdTimestamps.clear();
        this.spansByTraceIdTimestamp.clear();
        this.serviceToTraceIds.clear();
        this.serviceToRemoteServiceNames.clear();
        this.serviceToSpanNames.clear();
        this.autocompleteTags.clear();
    }

    @Override // zipkin2.storage.SpanConsumer
    public Call<Void> accept(List<Span> list) {
        return new StoreSpansCall(list);
    }

    synchronized void doAccept(List<Span> list) {
        int size = list.size();
        this.acceptedSpanCount.addAndGet(size);
        evictToRecoverSpans((this.spansByTraceIdTimestamp.size() + size) - this.maxSpanCount);
        for (Span span : list) {
            long jTimestampAsLong = span.timestampAsLong() / 1000;
            String strLowTraceId = lowTraceId(span.traceId());
            TraceIdTimestamp traceIdTimestamp = new TraceIdTimestamp(strLowTraceId, jTimestampAsLong);
            this.spansByTraceIdTimestamp.put(traceIdTimestamp, span);
            this.traceIdToTraceIdTimestamps.put(strLowTraceId, traceIdTimestamp);
            if (this.searchEnabled) {
                String strLocalServiceName = span.localServiceName();
                if (strLocalServiceName != null) {
                    this.serviceToTraceIds.put(strLocalServiceName, strLowTraceId);
                    String strRemoteServiceName = span.remoteServiceName();
                    if (strRemoteServiceName != null) {
                        this.serviceToRemoteServiceNames.put(strLocalServiceName, strRemoteServiceName);
                    }
                    String strName = span.name();
                    if (strName != null) {
                        this.serviceToSpanNames.put(strLocalServiceName, strName);
                    }
                }
                for (Map.Entry<String, String> entry : span.tags().entrySet()) {
                    if (this.autocompleteKeys.contains(entry.getKey())) {
                        this.autocompleteTags.put(entry.getKey(), entry.getValue());
                    }
                }
            }
        }
    }

    final class StoreSpansCall extends Call.Base<Void> {
        final List<Span> spans;

        StoreSpansCall(List<Span> list) {
            this.spans = list;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // zipkin2.Call.Base
        public Void doExecute() {
            InMemoryStorage.this.doAccept(this.spans);
            return null;
        }

        @Override // zipkin2.Call.Base
        protected void doEnqueue(Callback<Void> callback) {
            try {
                callback.onSuccess(doExecute());
            } catch (Throwable th) {
                propagateIfFatal(th);
                callback.onError(th);
            }
        }

        @Override // zipkin2.Call.Base, zipkin2.Call
        public Call<Void> clone() {
            return InMemoryStorage.this.new StoreSpansCall(this.spans);
        }

        public String toString() {
            return "StoreSpansCall{" + this.spans + "}";
        }
    }

    int evictToRecoverSpans(int i) {
        int i2 = 0;
        while (i > 0) {
            int iDeleteOldestTrace = deleteOldestTrace();
            i -= iDeleteOldestTrace;
            i2 += iDeleteOldestTrace;
        }
        return i2;
    }

    private int deleteOldestTrace() {
        String str = this.spansByTraceIdTimestamp.delegate.lastKey().lowTraceId;
        Iterator<TraceIdTimestamp> it = this.traceIdToTraceIdTimestamps.remove(str).iterator();
        int size = 0;
        while (it.hasNext()) {
            size += this.spansByTraceIdTimestamp.remove(it.next()).size();
        }
        if (this.searchEnabled) {
            for (String str2 : this.serviceToTraceIds.removeServiceIfTraceId(str)) {
                this.serviceToRemoteServiceNames.remove(str2);
                this.serviceToSpanNames.remove(str2);
            }
        }
        return size;
    }

    @Override // zipkin2.storage.SpanStore
    public Call<List<List<Span>>> getTraces(QueryRequest queryRequest) {
        return getTraces(queryRequest, this.strictTraceId);
    }

    synchronized Call<List<List<Span>>> getTraces(QueryRequest queryRequest, boolean z) {
        Set<String> setTraceIdsDescendingByTimestamp = traceIdsDescendingByTimestamp(queryRequest);
        if (setTraceIdsDescendingByTimestamp.isEmpty()) {
            return Call.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = setTraceIdsDescendingByTimestamp.iterator();
        while (it.hasNext() && arrayList.size() < queryRequest.limit()) {
            List<Span> listSpansByTraceId = spansByTraceId(it.next());
            if (queryRequest.test(listSpansByTraceId)) {
                if (!z) {
                    arrayList.add(listSpansByTraceId);
                } else {
                    for (List<Span> list : strictByTraceId(listSpansByTraceId)) {
                        if (queryRequest.test(list)) {
                            arrayList.add(list);
                        }
                    }
                }
            }
        }
        return Call.create(arrayList);
    }

    static Collection<List<Span>> strictByTraceId(List<Span> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Span span : list) {
            String strTraceId = span.traceId();
            if (!linkedHashMap.containsKey(strTraceId)) {
                linkedHashMap.put(strTraceId, new ArrayList());
            }
            ((List) linkedHashMap.get(strTraceId)).add(span);
        }
        return linkedHashMap.values();
    }

    public synchronized List<List<Span>> getTraces() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it = this.traceIdToTraceIdTimestamps.keySet().iterator();
        while (it.hasNext()) {
            List<Span> listSpansByTraceId = spansByTraceId(it.next());
            if (this.strictTraceId) {
                arrayList.addAll(strictByTraceId(listSpansByTraceId));
            } else {
                arrayList.add(listSpansByTraceId);
            }
        }
        return arrayList;
    }

    public synchronized List<DependencyLink> getDependencies() {
        return getDependencyLinks(this.traceIdToTraceIdTimestamps.keySet());
    }

    Set<String> traceIdsDescendingByTimestamp(QueryRequest queryRequest) {
        Collection<TraceIdTimestamp> collectionKeySet;
        if (!this.searchEnabled) {
            return Collections.emptySet();
        }
        if (queryRequest.serviceName() != null) {
            collectionKeySet = traceIdTimestampsByServiceName(queryRequest.serviceName());
        } else {
            collectionKeySet = this.spansByTraceIdTimestamp.keySet();
        }
        if (collectionKeySet == null || collectionKeySet.isEmpty()) {
            return Collections.emptySet();
        }
        return lowTraceIdsInRange(collectionKeySet, queryRequest.endTs, queryRequest.lookback);
    }

    static Set<String> lowTraceIdsInRange(Collection<TraceIdTimestamp> collection, long j, long j2) {
        long j3 = j - j2;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (TraceIdTimestamp traceIdTimestamp : collection) {
            if (traceIdTimestamp.timestamp >= j3 && traceIdTimestamp.timestamp <= j) {
                linkedHashSet.add(traceIdTimestamp.lowTraceId);
            }
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    @Override // zipkin2.storage.SpanStore, zipkin2.storage.Traces
    public synchronized Call<List<Span>> getTrace(String str) {
        String strNormalizeTraceId = Span.normalizeTraceId(str);
        List<Span> listSpansByTraceId = spansByTraceId(lowTraceId(strNormalizeTraceId));
        if (listSpansByTraceId.isEmpty()) {
            return Call.emptyList();
        }
        if (!this.strictTraceId) {
            return Call.create(listSpansByTraceId);
        }
        ArrayList arrayList = new ArrayList(listSpansByTraceId);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!((Span) it.next()).traceId().equals(strNormalizeTraceId)) {
                it.remove();
            }
        }
        return Call.create(arrayList);
    }

    @Override // zipkin2.storage.Traces
    public synchronized Call<List<List<Span>>> getTraces(Iterable<String> iterable) {
        ArrayList arrayList;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<String> it = iterable.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(Span.normalizeTraceId(it.next()));
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        Iterator it2 = linkedHashSet.iterator();
        while (it2.hasNext()) {
            linkedHashSet2.add(lowTraceId((String) it2.next()));
        }
        arrayList = new ArrayList();
        Iterator it3 = linkedHashSet2.iterator();
        while (it3.hasNext()) {
            List<Span> listSpansByTraceId = spansByTraceId((String) it3.next());
            if (this.strictTraceId) {
                for (List<Span> list : strictByTraceId(listSpansByTraceId)) {
                    if (linkedHashSet.contains(list.get(0).traceId())) {
                        arrayList.add(list);
                    }
                }
            } else {
                arrayList.add(listSpansByTraceId);
            }
        }
        return Call.create(arrayList);
    }

    @Override // zipkin2.storage.SpanStore, zipkin2.storage.ServiceAndSpanNames
    public synchronized Call<List<String>> getServiceNames() {
        if (this.searchEnabled) {
            return Call.create(new ArrayList(this.serviceToTraceIds.keySet()));
        }
        return Call.emptyList();
    }

    @Override // zipkin2.storage.ServiceAndSpanNames
    public synchronized Call<List<String>> getRemoteServiceNames(String str) {
        if (!str.isEmpty() && this.searchEnabled) {
            return Call.create(new ArrayList(this.serviceToRemoteServiceNames.get(str.toLowerCase(Locale.ROOT))));
        }
        return Call.emptyList();
    }

    @Override // zipkin2.storage.SpanStore, zipkin2.storage.ServiceAndSpanNames
    public synchronized Call<List<String>> getSpanNames(String str) {
        if (!str.isEmpty() && this.searchEnabled) {
            return Call.create(new ArrayList(this.serviceToSpanNames.get(str.toLowerCase(Locale.ROOT))));
        }
        return Call.emptyList();
    }

    @Override // zipkin2.storage.SpanStore
    public synchronized Call<List<DependencyLink>> getDependencies(long j, long j2) {
        try {
            if (j <= 0) {
                throw new IllegalArgumentException("endTs <= 0");
            }
            if (j2 <= 0) {
                throw new IllegalArgumentException("lookback <= 0");
            }
        } catch (Throwable th) {
            throw th;
        }
        return Call.create(getDependencyLinks(lowTraceIdsInRange(this.spansByTraceIdTimestamp.keySet(), j, j2)));
    }

    List<DependencyLink> getDependencyLinks(Set<String> set) {
        if (set.isEmpty()) {
            return Collections.emptyList();
        }
        DependencyLinker dependencyLinker = new DependencyLinker();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            dependencyLinker.putTrace(spansByTraceId(it.next()));
        }
        return dependencyLinker.link();
    }

    @Override // zipkin2.storage.AutocompleteTags
    public synchronized Call<List<String>> getKeys() {
        if (this.searchEnabled) {
            return this.autocompleteKeysCall.clone();
        }
        return Call.emptyList();
    }

    @Override // zipkin2.storage.AutocompleteTags
    public synchronized Call<List<String>> getValues(String str) {
        try {
            if (str == null) {
                throw new NullPointerException("key == null");
            }
            if (str.isEmpty()) {
                throw new IllegalArgumentException("key was empty");
            }
            if (this.searchEnabled) {
                return Call.create(new ArrayList(this.autocompleteTags.get(str)));
            }
            return Call.emptyList();
        } catch (Throwable th) {
            throw th;
        }
    }

    static final class ServiceNameToTraceIds extends SortedMultimap<String, String> {
        ServiceNameToTraceIds() {
            super(InMemoryStorage.STRING_COMPARATOR);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // zipkin2.storage.InMemoryStorage.SortedMultimap
        public Collection<String> valueContainer() {
            return new LinkedHashSet();
        }

        Set<String> removeServiceIfTraceId(String str) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (Map.Entry entry : this.delegate.entrySet()) {
                Collection collection = (Collection) entry.getValue();
                if (collection.remove(str) && collection.isEmpty()) {
                    linkedHashSet.add(entry.getKey());
                }
            }
            this.delegate.keySet().removeAll(linkedHashSet);
            return linkedHashSet;
        }
    }

    static abstract class SortedMultimap<K, V> {
        final SortedMap<K, Collection<V>> delegate;
        int size = 0;

        abstract Collection<V> valueContainer();

        SortedMultimap(Comparator<K> comparator) {
            this.delegate = new TreeMap(comparator);
        }

        Set<K> keySet() {
            return this.delegate.keySet();
        }

        int size() {
            return this.size;
        }

        void put(K k, V v) {
            Collection<V> collection = this.delegate.get(k);
            if (collection == null) {
                SortedMap<K, Collection<V>> sortedMap = this.delegate;
                Collection<V> collectionValueContainer = valueContainer();
                sortedMap.put(k, collectionValueContainer);
                collection = collectionValueContainer;
            }
            if (collection.add(v)) {
                this.size++;
            }
        }

        Collection<V> remove(K k) {
            Collection<V> collectionRemove = this.delegate.remove(k);
            if (collectionRemove != null) {
                this.size -= collectionRemove.size();
            }
            return collectionRemove;
        }

        void clear() {
            this.delegate.clear();
            this.size = 0;
        }

        Collection<V> get(K k) {
            Collection<V> collection = this.delegate.get(k);
            return collection != null ? collection : Collections.emptySet();
        }
    }

    List<Span> spansByTraceId(String str) {
        ArrayList arrayList = new ArrayList();
        Iterator<TraceIdTimestamp> it = this.traceIdToTraceIdTimestamps.get(str).iterator();
        while (it.hasNext()) {
            arrayList.addAll(this.spansByTraceIdTimestamp.get(it.next()));
        }
        return arrayList;
    }

    Collection<TraceIdTimestamp> traceIdTimestampsByServiceName(String str) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.serviceToTraceIds.get(str).iterator();
        while (it.hasNext()) {
            arrayList.addAll(this.traceIdToTraceIdTimestamps.get(it.next()));
        }
        Collections.sort(arrayList, TIMESTAMP_DESCENDING);
        return arrayList;
    }

    static String lowTraceId(String str) {
        return str.length() == 32 ? str.substring(16) : str;
    }

    static final class TraceIdTimestamp {
        final String lowTraceId;
        final long timestamp;

        TraceIdTimestamp(String str, long j) {
            this.lowTraceId = str;
            this.timestamp = j;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof TraceIdTimestamp)) {
                return false;
            }
            TraceIdTimestamp traceIdTimestamp = (TraceIdTimestamp) obj;
            return this.lowTraceId.equals(traceIdTimestamp.lowTraceId) && this.timestamp == traceIdTimestamp.timestamp;
        }

        public int hashCode() {
            int iHashCode = (this.lowTraceId.hashCode() ^ 1000003) * 1000003;
            long j = this.timestamp;
            return ((int) (j ^ (j >>> 32))) ^ iHashCode;
        }
    }

    public String toString() {
        return "InMemoryStorage{}";
    }
}
