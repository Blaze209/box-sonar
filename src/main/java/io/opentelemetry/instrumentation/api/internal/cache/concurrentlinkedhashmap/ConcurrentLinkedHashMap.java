package io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes4.dex */
public final class ConcurrentLinkedHashMap<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
    static final Queue<?> DISCARDING_QUEUE;
    static final long MAXIMUM_CAPACITY = 9223372034707292160L;
    static final int NCPU;
    static final int NUMBER_OF_READ_BUFFERS;
    static final int READ_BUFFERS_MASK;
    static final int READ_BUFFER_DRAIN_THRESHOLD = 64;
    static final int READ_BUFFER_INDEX_MASK = 127;
    static final int READ_BUFFER_SIZE = 128;
    static final int READ_BUFFER_THRESHOLD = 32;
    static final int WRITE_BUFFER_DRAIN_THRESHOLD = 16;
    static final long serialVersionUID = 1;
    final AtomicLong capacity;
    final int concurrencyLevel;
    final ConcurrentMap<K, Node<K, V>> data;
    final AtomicReference<DrainStatus> drainStatus;
    transient Set<Map.Entry<K, V>> entrySet;
    final LinkedDeque<Node<K, V>> evictionDeque;
    final Lock evictionLock;
    transient Set<K> keySet;
    final EvictionListener<K, V> listener;
    final Queue<Node<K, V>> pendingNotifications;
    final AtomicLong[] readBufferDrainAtWriteCount;
    final long[] readBufferReadCount;
    final AtomicLong[] readBufferWriteCount;
    final AtomicReference<Node<K, V>>[][] readBuffers;
    transient Collection<V> values;
    final EntryWeigher<? super K, ? super V> weigher;
    final AtomicLong weightedSize;
    final Queue<Runnable> writeBuffer;

    enum DiscardingListener implements EvictionListener<Object, Object> {
        INSTANCE;

        @Override // io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.EvictionListener
        public void onEviction(Object obj, Object obj2) {
        }
    }

    enum DrainStatus {
        IDLE { // from class: io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.ConcurrentLinkedHashMap.DrainStatus.1
            @Override // io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.ConcurrentLinkedHashMap.DrainStatus
            boolean shouldDrainBuffers(boolean z) {
                return !z;
            }
        },
        REQUIRED { // from class: io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.ConcurrentLinkedHashMap.DrainStatus.2
            @Override // io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.ConcurrentLinkedHashMap.DrainStatus
            boolean shouldDrainBuffers(boolean z) {
                return true;
            }
        },
        PROCESSING { // from class: io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.ConcurrentLinkedHashMap.DrainStatus.3
            @Override // io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.ConcurrentLinkedHashMap.DrainStatus
            boolean shouldDrainBuffers(boolean z) {
                return false;
            }
        };

        abstract boolean shouldDrainBuffers(boolean z);
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        NCPU = iAvailableProcessors;
        int iCeilingNextPowerOfTwo = ceilingNextPowerOfTwo(iAvailableProcessors);
        NUMBER_OF_READ_BUFFERS = iCeilingNextPowerOfTwo;
        READ_BUFFERS_MASK = iCeilingNextPowerOfTwo - 1;
        DISCARDING_QUEUE = new DiscardingQueue();
    }

    static int ceilingNextPowerOfTwo(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }

    private ConcurrentLinkedHashMap(Builder<K, V> builder) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        int i = builder.concurrencyLevel;
        this.concurrencyLevel = i;
        this.capacity = new AtomicLong(Math.min(builder.capacity, MAXIMUM_CAPACITY));
        this.data = new ConcurrentHashMap(builder.initialCapacity, 0.75f, i);
        this.weigher = builder.weigher;
        this.evictionLock = new ReentrantLock();
        this.weightedSize = new AtomicLong();
        this.evictionDeque = new LinkedDeque<>();
        this.writeBuffer = new ConcurrentLinkedQueue();
        this.drainStatus = new AtomicReference<>(DrainStatus.IDLE);
        int i2 = NUMBER_OF_READ_BUFFERS;
        this.readBufferReadCount = new long[i2];
        this.readBufferWriteCount = new AtomicLong[i2];
        this.readBufferDrainAtWriteCount = new AtomicLong[i2];
        this.readBuffers = (AtomicReference[][]) Array.newInstance((Class<?>) AtomicReference.class, i2, 128);
        for (int i3 = 0; i3 < NUMBER_OF_READ_BUFFERS; i3++) {
            this.readBufferWriteCount[i3] = new AtomicLong();
            this.readBufferDrainAtWriteCount[i3] = new AtomicLong();
            this.readBuffers[i3] = new AtomicReference[128];
            for (int i4 = 0; i4 < 128; i4++) {
                this.readBuffers[i3][i4] = new AtomicReference<>();
            }
        }
        EvictionListener<K, V> evictionListener = builder.listener;
        this.listener = evictionListener;
        if (evictionListener == DiscardingListener.INSTANCE) {
            concurrentLinkedQueue = (Queue<Node<K, V>>) DISCARDING_QUEUE;
        } else {
            concurrentLinkedQueue = new ConcurrentLinkedQueue();
        }
        this.pendingNotifications = concurrentLinkedQueue;
    }

    static void checkNotNull(Object obj) {
        obj.getClass();
    }

    static void checkArgument(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    static void checkState(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public long capacity() {
        return this.capacity.get();
    }

    public void setCapacity(long j) {
        checkArgument(j >= 0);
        this.evictionLock.lock();
        try {
            this.capacity.lazySet(Math.min(j, MAXIMUM_CAPACITY));
            drainBuffers();
            evict();
            this.evictionLock.unlock();
            notifyListener();
        } catch (Throwable th) {
            this.evictionLock.unlock();
            throw th;
        }
    }

    boolean hasOverflowed() {
        return this.weightedSize.get() > this.capacity.get();
    }

    void evict() {
        Node<K, V> node;
        while (hasOverflowed() && (node = (Node) this.evictionDeque.poll()) != null) {
            if (this.data.remove(node.key, node)) {
                this.pendingNotifications.add(node);
            }
            makeDead(node);
        }
    }

    void afterRead(Node<K, V> node) {
        int bufferIndex = readBufferIndex();
        drainOnReadIfNeeded(bufferIndex, recordRead(bufferIndex, node));
        notifyListener();
    }

    static int readBufferIndex() {
        return ((int) Thread.currentThread().getId()) & READ_BUFFERS_MASK;
    }

    long recordRead(int i, Node<K, V> node) {
        AtomicLong atomicLong = this.readBufferWriteCount[i];
        long j = atomicLong.get();
        atomicLong.lazySet(1 + j);
        this.readBuffers[i][(int) (127 & j)].lazySet(node);
        return j;
    }

    void drainOnReadIfNeeded(int i, long j) {
        if (this.drainStatus.get().shouldDrainBuffers(j - this.readBufferDrainAtWriteCount[i].get() < 32)) {
            tryToDrainBuffers();
        }
    }

    void afterWrite(Runnable runnable) {
        this.writeBuffer.add(runnable);
        this.drainStatus.lazySet(DrainStatus.REQUIRED);
        tryToDrainBuffers();
        notifyListener();
    }

    void tryToDrainBuffers() {
        if (this.evictionLock.tryLock()) {
            try {
                this.drainStatus.lazySet(DrainStatus.PROCESSING);
                drainBuffers();
            } finally {
                PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.drainStatus, DrainStatus.PROCESSING, DrainStatus.IDLE);
                this.evictionLock.unlock();
            }
        }
    }

    void drainBuffers() {
        drainReadBuffers();
        drainWriteBuffer();
    }

    void drainReadBuffers() {
        int id = (int) Thread.currentThread().getId();
        int i = NUMBER_OF_READ_BUFFERS + id;
        while (id < i) {
            drainReadBuffer(READ_BUFFERS_MASK & id);
            id++;
        }
    }

    void drainReadBuffer(int i) {
        long j = this.readBufferWriteCount[i].get();
        for (int i2 = 0; i2 < 64; i2++) {
            AtomicReference<Node<K, V>> atomicReference = this.readBuffers[i][(int) (this.readBufferReadCount[i] & 127)];
            Node<K, V> node = atomicReference.get();
            if (node == null) {
                break;
            }
            atomicReference.lazySet(null);
            applyRead(node);
            long[] jArr = this.readBufferReadCount;
            jArr[i] = jArr[i] + 1;
        }
        this.readBufferDrainAtWriteCount[i].lazySet(j);
    }

    void applyRead(Node<K, V> node) {
        if (this.evictionDeque.contains((LinkedDeque.Linked<?>) node)) {
            this.evictionDeque.moveToBack(node);
        }
    }

    void drainWriteBuffer() {
        Runnable runnablePoll;
        for (int i = 0; i < 16 && (runnablePoll = this.writeBuffer.poll()) != null; i++) {
            runnablePoll.run();
        }
    }

    boolean tryToRetire(Node<K, V> node, WeightedValue<V> weightedValue) {
        if (weightedValue.isAlive()) {
            return node.compareAndSet(weightedValue, new WeightedValue(weightedValue.value, -weightedValue.weight));
        }
        return false;
    }

    void makeRetired(Node<K, V> node) {
        WeightedValue weightedValue;
        do {
            weightedValue = (WeightedValue) node.get();
            if (!weightedValue.isAlive()) {
                return;
            }
        } while (!node.compareAndSet(weightedValue, new WeightedValue(weightedValue.value, -weightedValue.weight)));
    }

    void makeDead(Node<K, V> node) {
        WeightedValue weightedValue;
        do {
            weightedValue = (WeightedValue) node.get();
        } while (!node.compareAndSet(weightedValue, new WeightedValue(weightedValue.value, 0)));
        AtomicLong atomicLong = this.weightedSize;
        atomicLong.lazySet(atomicLong.get() - ((long) Math.abs(weightedValue.weight)));
    }

    void notifyListener() {
        while (true) {
            Node<K, V> nodePoll = this.pendingNotifications.poll();
            if (nodePoll == null) {
                return;
            } else {
                this.listener.onEviction(nodePoll.key, nodePoll.getValue());
            }
        }
    }

    final class AddTask implements Runnable {
        final Node<K, V> node;
        final int weight;

        AddTask(Node<K, V> node, int i) {
            this.weight = i;
            this.node = node;
        }

        @Override // java.lang.Runnable
        public void run() {
            ConcurrentLinkedHashMap.this.weightedSize.lazySet(ConcurrentLinkedHashMap.this.weightedSize.get() + ((long) this.weight));
            if (((WeightedValue) this.node.get()).isAlive()) {
                ConcurrentLinkedHashMap.this.evictionDeque.add(this.node);
                ConcurrentLinkedHashMap.this.evict();
            }
        }
    }

    final class RemovalTask implements Runnable {
        final Node<K, V> node;

        RemovalTask(Node<K, V> node) {
            this.node = node;
        }

        @Override // java.lang.Runnable
        public void run() {
            ConcurrentLinkedHashMap.this.evictionDeque.remove(this.node);
            ConcurrentLinkedHashMap.this.makeDead(this.node);
        }
    }

    final class UpdateTask implements Runnable {
        final Node<K, V> node;
        final int weightDifference;

        public UpdateTask(Node<K, V> node, int i) {
            this.weightDifference = i;
            this.node = node;
        }

        @Override // java.lang.Runnable
        public void run() {
            ConcurrentLinkedHashMap.this.weightedSize.lazySet(ConcurrentLinkedHashMap.this.weightedSize.get() + ((long) this.weightDifference));
            ConcurrentLinkedHashMap.this.applyRead(this.node);
            ConcurrentLinkedHashMap.this.evict();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.data.size();
    }

    public long weightedSize() {
        return Math.max(0L, this.weightedSize.get());
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.evictionLock.lock();
        while (true) {
            try {
                Node<K, V> node = (Node) this.evictionDeque.poll();
                if (node == null) {
                    break;
                }
                this.data.remove(node.key, node);
                makeDead(node);
            } catch (Throwable th) {
                this.evictionLock.unlock();
                throw th;
            }
        }
        for (AtomicReference<Node<K, V>>[] atomicReferenceArr : this.readBuffers) {
            for (AtomicReference<Node<K, V>> atomicReference : atomicReferenceArr) {
                atomicReference.lazySet(null);
            }
        }
        while (true) {
            Runnable runnablePoll = this.writeBuffer.poll();
            if (runnablePoll != null) {
                runnablePoll.run();
            } else {
                this.evictionLock.unlock();
                return;
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return this.data.containsKey(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        checkNotNull(obj);
        Iterator<Node<K, V>> it = this.data.values().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().equals(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Node<K, V> node = this.data.get(obj);
        if (node == null) {
            return null;
        }
        afterRead(node);
        return node.getValue();
    }

    public V getQuietly(Object obj) {
        Node<K, V> node = this.data.get(obj);
        if (node == null) {
            return null;
        }
        return node.getValue();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        return put(k, v, false);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k, V v) {
        return put(k, v, true);
    }

    V put(K k, V v, boolean z) {
        checkNotNull(k);
        checkNotNull(v);
        int iWeightOf = this.weigher.weightOf(k, v);
        WeightedValue weightedValue = new WeightedValue(v, iWeightOf);
        Node<K, V> node = new Node<>(k, weightedValue);
        while (true) {
            Node<K, V> nodePutIfAbsent = this.data.putIfAbsent(node.key, node);
            if (nodePutIfAbsent == null) {
                afterWrite(new AddTask(node, iWeightOf));
                return null;
            }
            if (z) {
                afterRead(nodePutIfAbsent);
                return nodePutIfAbsent.getValue();
            }
            while (true) {
                WeightedValue weightedValue2 = (WeightedValue) nodePutIfAbsent.get();
                if (!weightedValue2.isAlive()) {
                    break;
                }
                if (nodePutIfAbsent.compareAndSet(weightedValue2, weightedValue)) {
                    int i = iWeightOf - weightedValue2.weight;
                    if (i == 0) {
                        afterRead(nodePutIfAbsent);
                    } else {
                        afterWrite(new UpdateTask(nodePutIfAbsent, i));
                    }
                    return weightedValue2.value;
                }
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        Node<K, V> nodeRemove = this.data.remove(obj);
        if (nodeRemove == null) {
            return null;
        }
        makeRetired(nodeRemove);
        afterWrite(new RemovalTask(nodeRemove));
        return nodeRemove.getValue();
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object obj, Object obj2) {
        Node<K, V> node = this.data.get(obj);
        if (node != null && obj2 != null) {
            WeightedValue<V> weightedValue = (WeightedValue) node.get();
            while (weightedValue.contains(obj2)) {
                if (tryToRetire(node, weightedValue)) {
                    if (!this.data.remove(obj, node)) {
                        break;
                    }
                    afterWrite(new RemovalTask(node));
                    return true;
                }
                weightedValue = (WeightedValue) node.get();
                if (!weightedValue.isAlive()) {
                    break;
                }
            }
        }
        return false;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k, V v) {
        WeightedValue weightedValue;
        checkNotNull(k);
        checkNotNull(v);
        int iWeightOf = this.weigher.weightOf(k, v);
        WeightedValue weightedValue2 = new WeightedValue(v, iWeightOf);
        Node<K, V> node = this.data.get(k);
        if (node == null) {
            return null;
        }
        do {
            weightedValue = (WeightedValue) node.get();
            if (!weightedValue.isAlive()) {
                return null;
            }
        } while (!node.compareAndSet(weightedValue, weightedValue2));
        int i = iWeightOf - weightedValue.weight;
        if (i == 0) {
            afterRead(node);
        } else {
            afterWrite(new UpdateTask(node, i));
        }
        return weightedValue.value;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k, V v, V v2) {
        WeightedValue weightedValue;
        checkNotNull(k);
        checkNotNull(v);
        checkNotNull(v2);
        int iWeightOf = this.weigher.weightOf(k, v2);
        WeightedValue weightedValue2 = new WeightedValue(v2, iWeightOf);
        Node<K, V> node = this.data.get(k);
        if (node == null) {
            return false;
        }
        do {
            weightedValue = (WeightedValue) node.get();
            if (!weightedValue.isAlive() || !weightedValue.contains(v)) {
                return false;
            }
        } while (!node.compareAndSet(weightedValue, weightedValue2));
        int i = iWeightOf - weightedValue.weight;
        if (i == 0) {
            afterRead(node);
            return true;
        }
        afterWrite(new UpdateTask(node, i));
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        KeySet keySet = new KeySet();
        this.keySet = keySet;
        return keySet;
    }

    public Set<K> ascendingKeySet() {
        return ascendingKeySetWithLimit(Integer.MAX_VALUE);
    }

    public Set<K> ascendingKeySetWithLimit(int i) {
        return orderedKeySet(true, i);
    }

    public Set<K> descendingKeySet() {
        return descendingKeySetWithLimit(Integer.MAX_VALUE);
    }

    public Set<K> descendingKeySetWithLimit(int i) {
        return orderedKeySet(false, i);
    }

    Set<K> orderedKeySet(boolean z, int i) {
        checkArgument(i >= 0);
        this.evictionLock.lock();
        try {
            drainBuffers();
            LinkedHashSet linkedHashSet = new LinkedHashSet(this.weigher == Weighers.entrySingleton() ? Math.min(i, (int) weightedSize()) : 16);
            Iterator it = z ? this.evictionDeque.iterator() : this.evictionDeque.descendingIterator();
            while (it.hasNext() && i > linkedHashSet.size()) {
                linkedHashSet.add(((Node) it.next()).key);
            }
            return Collections.unmodifiableSet(linkedHashSet);
        } finally {
            this.evictionLock.unlock();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        Values values = new Values();
        this.values = values;
        return values;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        EntrySet entrySet = new EntrySet();
        this.entrySet = entrySet;
        return entrySet;
    }

    public Map<K, V> ascendingMap() {
        return ascendingMapWithLimit(Integer.MAX_VALUE);
    }

    public Map<K, V> ascendingMapWithLimit(int i) {
        return orderedMap(true, i);
    }

    public Map<K, V> descendingMap() {
        return descendingMapWithLimit(Integer.MAX_VALUE);
    }

    public Map<K, V> descendingMapWithLimit(int i) {
        return orderedMap(false, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    Map<K, V> orderedMap(boolean z, int i) {
        checkArgument(i >= 0);
        this.evictionLock.lock();
        try {
            drainBuffers();
            LinkedHashMap linkedHashMap = new LinkedHashMap(this.weigher == Weighers.entrySingleton() ? Math.min(i, (int) weightedSize()) : 16);
            Iterator it = z ? this.evictionDeque.iterator() : this.evictionDeque.descendingIterator();
            while (it.hasNext() && i > linkedHashMap.size()) {
                Node node = (Node) it.next();
                linkedHashMap.put(node.key, node.getValue());
            }
            return Collections.unmodifiableMap(linkedHashMap);
        } finally {
            this.evictionLock.unlock();
        }
    }

    static final class WeightedValue<V> {
        final V value;
        final int weight;

        WeightedValue(V v, int i) {
            this.weight = i;
            this.value = v;
        }

        boolean contains(Object obj) {
            V v = this.value;
            return obj == v || v.equals(obj);
        }

        boolean isAlive() {
            return this.weight > 0;
        }

        boolean isRetired() {
            return this.weight < 0;
        }

        boolean isDead() {
            return this.weight == 0;
        }
    }

    static final class Node<K, V> extends AtomicReference<WeightedValue<V>> implements LinkedDeque.Linked<Node<K, V>> {
        final K key;
        Node<K, V> next;
        Node<K, V> prev;

        Node(K k, WeightedValue<V> weightedValue) {
            super(weightedValue);
            this.key = k;
        }

        @Override // io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.LinkedDeque.Linked
        public Node<K, V> getPrevious() {
            return this.prev;
        }

        @Override // io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.LinkedDeque.Linked
        public void setPrevious(Node<K, V> node) {
            this.prev = node;
        }

        @Override // io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.LinkedDeque.Linked
        public Node<K, V> getNext() {
            return this.next;
        }

        @Override // io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.LinkedDeque.Linked
        public void setNext(Node<K, V> node) {
            this.next = node;
        }

        V getValue() {
            return ((WeightedValue) get()).value;
        }
    }

    final class KeySet extends AbstractSet<K> {
        final ConcurrentLinkedHashMap<K, V> map;

        KeySet() {
            this.map = ConcurrentLinkedHashMap.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.map.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.map.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new KeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return ConcurrentLinkedHashMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return this.map.remove(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return this.map.data.keySet().toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) this.map.data.keySet().toArray(tArr);
        }
    }

    final class KeyIterator implements Iterator<K> {
        K current;
        final Iterator<K> iterator;

        KeyIterator() {
            this.iterator = ConcurrentLinkedHashMap.this.data.keySet().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public K next() {
            K next = this.iterator.next();
            this.current = next;
            return next;
        }

        @Override // java.util.Iterator
        public void remove() {
            ConcurrentLinkedHashMap.checkState(this.current != null);
            ConcurrentLinkedHashMap.this.remove(this.current);
            this.current = null;
        }
    }

    final class Values extends AbstractCollection<V> {
        Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return ConcurrentLinkedHashMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            ConcurrentLinkedHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new ValueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ConcurrentLinkedHashMap.this.containsValue(obj);
        }
    }

    final class ValueIterator implements Iterator<V> {
        Node<K, V> current;
        final Iterator<Node<K, V>> iterator;

        ValueIterator() {
            this.iterator = ConcurrentLinkedHashMap.this.data.values().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            Node<K, V> next = this.iterator.next();
            this.current = next;
            return next.getValue();
        }

        @Override // java.util.Iterator
        public void remove() {
            ConcurrentLinkedHashMap.checkState(this.current != null);
            ConcurrentLinkedHashMap.this.remove(this.current.key);
            this.current = null;
        }
    }

    final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        final ConcurrentLinkedHashMap<K, V> map;

        EntrySet() {
            this.map = ConcurrentLinkedHashMap.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.map.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.map.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Node<K, V> node = this.map.data.get(entry.getKey());
            return node != null && node.getValue().equals(entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(Map.Entry<K, V> entry) {
            return this.map.putIfAbsent(entry.getKey(), entry.getValue()) == null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.map.remove(entry.getKey(), entry.getValue());
        }
    }

    final class EntryIterator implements Iterator<Map.Entry<K, V>> {
        Node<K, V> current;
        final Iterator<Node<K, V>> iterator;

        EntryIterator() {
            this.iterator = ConcurrentLinkedHashMap.this.data.values().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            this.current = this.iterator.next();
            return new WriteThroughEntry(this.current);
        }

        @Override // java.util.Iterator
        public void remove() {
            ConcurrentLinkedHashMap.checkState(this.current != null);
            ConcurrentLinkedHashMap.this.remove(this.current.key);
            this.current = null;
        }
    }

    final class WriteThroughEntry extends AbstractMap.SimpleEntry<K, V> {
        static final long serialVersionUID = 1;

        WriteThroughEntry(Node<K, V> node) {
            super(node.key, node.getValue());
        }

        @Override // java.util.AbstractMap.SimpleEntry, java.util.Map.Entry
        public V setValue(V v) {
            ConcurrentLinkedHashMap.this.put(getKey(), v);
            return (V) super.setValue(v);
        }

        Object writeReplace() {
            return new AbstractMap.SimpleEntry(this);
        }
    }

    static final class BoundedEntryWeigher<K, V> implements EntryWeigher<K, V>, Serializable {
        static final long serialVersionUID = 1;
        final EntryWeigher<? super K, ? super V> weigher;

        BoundedEntryWeigher(EntryWeigher<? super K, ? super V> entryWeigher) {
            ConcurrentLinkedHashMap.checkNotNull(entryWeigher);
            this.weigher = entryWeigher;
        }

        @Override // io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.EntryWeigher
        public int weightOf(K k, V v) {
            int iWeightOf = this.weigher.weightOf(k, v);
            ConcurrentLinkedHashMap.checkArgument(iWeightOf >= 1);
            return iWeightOf;
        }

        Object writeReplace() {
            return this.weigher;
        }
    }

    static final class DiscardingQueue extends AbstractQueue<Object> {
        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
        public boolean add(Object obj) {
            return true;
        }

        @Override // java.util.Queue
        public boolean offer(Object obj) {
            return true;
        }

        @Override // java.util.Queue
        public Object peek() {
            return null;
        }

        @Override // java.util.Queue
        public Object poll() {
            return null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return 0;
        }

        DiscardingQueue() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Object> iterator() {
            return Collections.emptyList().iterator();
        }
    }

    Object writeReplace() {
        return new SerializationProxy(this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Proxy required");
    }

    static final class SerializationProxy<K, V> implements Serializable {
        static final long serialVersionUID = 1;
        final long capacity;
        final int concurrencyLevel;
        final Map<K, V> data;
        final EvictionListener<K, V> listener;
        final EntryWeigher<? super K, ? super V> weigher;

        SerializationProxy(ConcurrentLinkedHashMap<K, V> concurrentLinkedHashMap) {
            this.concurrencyLevel = concurrentLinkedHashMap.concurrencyLevel;
            this.data = new HashMap(concurrentLinkedHashMap);
            this.capacity = concurrentLinkedHashMap.capacity.get();
            this.listener = concurrentLinkedHashMap.listener;
            this.weigher = concurrentLinkedHashMap.weigher;
        }

        Object readResolve() {
            ConcurrentLinkedHashMap<K, V> concurrentLinkedHashMapBuild = new Builder().concurrencyLevel(this.concurrencyLevel).maximumWeightedCapacity(this.capacity).listener(this.listener).weigher(this.weigher).build();
            concurrentLinkedHashMapBuild.putAll(this.data);
            return concurrentLinkedHashMapBuild;
        }
    }

    public static final class Builder<K, V> {
        static final int DEFAULT_CONCURRENCY_LEVEL = 16;
        static final int DEFAULT_INITIAL_CAPACITY = 16;
        long capacity = -1;
        EntryWeigher<? super K, ? super V> weigher = Weighers.entrySingleton();
        int initialCapacity = 16;
        int concurrencyLevel = 16;
        EvictionListener<K, V> listener = DiscardingListener.INSTANCE;

        public Builder<K, V> initialCapacity(int i) {
            ConcurrentLinkedHashMap.checkArgument(i >= 0);
            this.initialCapacity = i;
            return this;
        }

        public Builder<K, V> maximumWeightedCapacity(long j) {
            ConcurrentLinkedHashMap.checkArgument(j >= 0);
            this.capacity = j;
            return this;
        }

        public Builder<K, V> concurrencyLevel(int i) {
            ConcurrentLinkedHashMap.checkArgument(i > 0);
            this.concurrencyLevel = i;
            return this;
        }

        public Builder<K, V> listener(EvictionListener<K, V> evictionListener) {
            ConcurrentLinkedHashMap.checkNotNull(evictionListener);
            this.listener = evictionListener;
            return this;
        }

        public Builder<K, V> weigher(Weigher<? super V> weigher) {
            EntryWeigher<? super K, ? super V> boundedEntryWeigher;
            if (weigher == Weighers.singleton()) {
                boundedEntryWeigher = Weighers.entrySingleton();
            } else {
                boundedEntryWeigher = new BoundedEntryWeigher(Weighers.asEntryWeigher(weigher));
            }
            this.weigher = boundedEntryWeigher;
            return this;
        }

        public Builder<K, V> weigher(EntryWeigher<? super K, ? super V> entryWeigher) {
            EntryWeigher<? super K, ? super V> boundedEntryWeigher;
            if (entryWeigher == Weighers.entrySingleton()) {
                boundedEntryWeigher = Weighers.entrySingleton();
            } else {
                boundedEntryWeigher = new BoundedEntryWeigher(entryWeigher);
            }
            this.weigher = boundedEntryWeigher;
            return this;
        }

        public ConcurrentLinkedHashMap<K, V> build() {
            ConcurrentLinkedHashMap.checkState(this.capacity >= 0);
            return new ConcurrentLinkedHashMap<>(this);
        }
    }
}
