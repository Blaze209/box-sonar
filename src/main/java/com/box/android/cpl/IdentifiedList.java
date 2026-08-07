package com.box.android.cpl;

import androidx.exifinterface.media.ExifInterface;
import com.box.android.cpl.Identifiable;
import com.box.android.observability.DiagnosisParams;
import com.box.androidsdk.content.models.BoxFile;
import com.facebook.react.modules.dialog.AlertFragment;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import external.sdk.pendo.io.mozilla.javascript.ES6Iterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableCollection;
import kotlin.jvm.internal.markers.KMutableIterator;

/* JADX INFO: compiled from: IdentifiedList.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u001f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0010)\n\u0002\b\u0004\n\u0002\u0010*\n\u0002\b\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00030\u00052\b\u0012\u0004\u0012\u0002H\u00030\u0006:\u0001@B\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u0017\b\u0016\u0012\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u000b¢\u0006\u0002\u0010\fB\u0005¢\u0006\u0002\u0010\rJ\u0015\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001b\u001a\u00020\u00182\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001dH\u0016J\u0015\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\u001fH\u0016J\u0016\u0010#\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u001aJ\u0016\u0010$\u001a\u00020\u00182\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001dH\u0016J\u0013\u0010%\u001a\u00020\u00182\b\u0010&\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u0016\u0010'\u001a\u00028\u00012\u0006\u0010(\u001a\u00020\bH\u0096\u0002¢\u0006\u0002\u0010)J\u0015\u0010*\u001a\u0004\u0018\u00018\u00012\u0006\u0010+\u001a\u00028\u0000¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020\u00182\u0006\u0010+\u001a\u00028\u0000¢\u0006\u0002\u0010.J\b\u0010/\u001a\u00020\bH\u0016J\u0015\u00100\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00028\u0001H\u0016¢\u0006\u0002\u00101J\b\u00102\u001a\u00020\u0018H\u0016J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00028\u000104H\u0096\u0002J\u0015\u00105\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00028\u0001H\u0016¢\u0006\u0002\u00101J\u001f\u00106\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0019\u001a\u00028\u0001¢\u0006\u0002\u00107J\u000e\u00108\u001a\b\u0012\u0004\u0012\u00028\u000109H\u0016J\u0016\u00108\u001a\b\u0012\u0004\u0012\u00028\u0001092\u0006\u0010(\u001a\u00020\bH\u0016J\u0015\u0010:\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aJ\u0016\u0010;\u001a\u00020\u00182\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001dH\u0016J\u0016\u0010<\u001a\u00020\u00182\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001dH\u0016J\u001e\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010>\u001a\u00020\b2\u0006\u0010?\u001a\u00020\bH\u0016R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006A"}, d2 = {"Lcom/box/android/cpl/IdentifiedList;", "TId", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/box/android/cpl/Identifiable;", "", "", "initialCapacity", "", "(I)V", AlertFragment.ARG_ITEMS, "", "([Lcom/box/android/cpl/Identifiable;)V", "()V", "innerList", "", "innerMap", "", BoxFile.FIELD_LOCK, "Ljava/util/concurrent/locks/ReentrantLock;", "size", "getSize", "()I", "add", "", "element", "(Lcom/box/android/cpl/Identifiable;)Z", "addAll", "elements", "", "checkDuplicateId", "", "item", "(Lcom/box/android/cpl/Identifiable;)V", DiagnosisParams.CLEAR_ON_LOGOUT, "contains", "containsAll", "equals", "other", PasskeyWebListener.GET_UNIQUE_KEY, FirebaseAnalytics.Param.INDEX, "(I)Lcom/box/android/cpl/Identifiable;", "getById", "id", "(Ljava/lang/Object;)Lcom/box/android/cpl/Identifiable;", "hasId", "(Ljava/lang/Object;)Z", "hashCode", "indexOf", "(Lcom/box/android/cpl/Identifiable;)I", "isEmpty", "iterator", "", "lastIndexOf", "listByReplacingElement", "(Lcom/box/android/cpl/Identifiable;)Lcom/box/android/cpl/IdentifiedList;", "listIterator", "", "remove", "removeAll", "retainAll", "subList", "fromIndex", "toIndex", "MutableIteratorImpl", "cpl-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class IdentifiedList<TId, T extends Identifiable<TId>> implements List<T>, Collection<T>, KMappedMarker, KMutableCollection {
    private List<T> innerList;
    private Map<TId, T> innerMap;
    private final ReentrantLock lock;

    public void add(int i, T t) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ void add(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public T remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Object remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public void replaceAll(UnaryOperator<T> unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public T set(int i, T t) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public void sort(Comparator<? super T> comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.toArray(this, array);
    }

    public IdentifiedList() {
        this.lock = new ReentrantLock();
        this.innerList = new ArrayList();
        this.innerMap = new LinkedHashMap();
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Identifiable) {
            return contains((Identifiable) obj);
        }
        return false;
    }

    @Override // java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Identifiable) {
            return indexOf((Identifiable) obj);
        }
        return -1;
    }

    @Override // java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Identifiable) {
            return lastIndexOf((Identifiable) obj);
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof Identifiable) {
            return remove((Identifiable) obj);
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    public IdentifiedList(int i) {
        this();
        this.innerList = new ArrayList(i);
        this.innerMap = new LinkedHashMap(i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IdentifiedList(T[] items) {
        this();
        Intrinsics.checkNotNullParameter(items, "items");
        this.innerList = new ArrayList(items.length);
        this.innerMap = new LinkedHashMap(items.length);
        for (T t : items) {
            checkDuplicateId(t);
            this.innerMap.put((TId) t.getActivityId(), t);
            this.innerList.add(t);
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object other) {
        List<T> list = this.innerList;
        IdentifiedList identifiedList = other instanceof IdentifiedList ? (IdentifiedList) other : null;
        return Intrinsics.areEqual(list, identifiedList != null ? identifiedList.innerList : null);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.innerList.hashCode();
    }

    public int getSize() {
        return this.innerList.size();
    }

    public final T getById(TId id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.innerMap.get(id);
    }

    public final boolean hasId(TId id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.innerMap.containsKey(id);
    }

    public final IdentifiedList<TId, T> listByReplacingElement(T element) {
        Intrinsics.checkNotNullParameter(element, "element");
        IdentifiedList<TId, T> identifiedList = new IdentifiedList<>(this.innerList.size());
        for (T t : this) {
            if (Intrinsics.areEqual(t.getActivityId(), element.getActivityId())) {
                t = element;
            }
            identifiedList.add(t);
        }
        return identifiedList;
    }

    public boolean contains(T element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return Intrinsics.areEqual(this.innerMap.get(element.getActivityId()), element);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator<? extends Object> it = elements.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List
    public T get(int index) {
        return this.innerList.get(index);
    }

    public int indexOf(T element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return this.innerList.indexOf(element);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.innerList.isEmpty();
    }

    public int lastIndexOf(T element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return this.innerList.lastIndexOf(element);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return this.innerList.listIterator();
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int index) {
        return this.innerList.listIterator(index);
    }

    @Override // java.util.List
    public List<T> subList(int fromIndex, int toIndex) {
        return this.innerList.subList(fromIndex, toIndex);
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T element) {
        Intrinsics.checkNotNullParameter(element, "element");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            checkDuplicateId(element);
            this.innerMap.put((TId) element.getActivityId(), element);
            this.innerList.add(element);
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Iterator<? extends T> it = elements.iterator();
            while (it.hasNext()) {
                add((Identifiable) it.next());
            }
            Unit unit = Unit.INSTANCE;
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.innerMap.clear();
            this.innerList.clear();
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return new MutableIteratorImpl();
    }

    public boolean remove(T element) {
        Intrinsics.checkNotNullParameter(element, "element");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.innerMap.remove(element.getActivityId());
            return this.innerList.remove(element);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Iterator<? extends Object> it = elements.iterator();
            while (true) {
                boolean z = false;
                while (true) {
                    if (it.hasNext()) {
                        if (remove(it.next()) || z) {
                            z = true;
                        }
                    } else {
                        reentrantLock.unlock();
                        return z;
                    }
                }
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            boolean zRetainAll = this.innerList.retainAll(elements);
            this.innerMap.clear();
            Map<TId, T> map = this.innerMap;
            List<T> list = this.innerList;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (T t : list) {
                arrayList.add(TuplesKt.to(t.getActivityId(), t));
            }
            MapsKt.putAll(map, arrayList);
            return zRetainAll;
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void checkDuplicateId(T item) {
        if (this.innerMap.containsKey(item.getActivityId())) {
            throw new IllegalArgumentException("Tried to add duplicate id " + item.getActivityId() + '.');
        }
    }

    /* JADX INFO: compiled from: IdentifiedList.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00010\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0002J\u000e\u0010\b\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016R\u0012\u0010\u0003\u001a\u0004\u0018\u00018\u0001X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/box/android/cpl/IdentifiedList$MutableIteratorImpl;", "", "(Lcom/box/android/cpl/IdentifiedList;)V", "lastElement", "Lcom/box/android/cpl/Identifiable;", "realIterator", "hasNext", "", ES6Iterator.NEXT_METHOD, "()Lcom/box/android/cpl/Identifiable;", "remove", "", "cpl-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private final class MutableIteratorImpl implements Iterator<T>, KMutableIterator {
        private T lastElement;
        private final Iterator<T> realIterator;

        public MutableIteratorImpl() {
            this.realIterator = IdentifiedList.this.innerList.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.realIterator.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            T next = this.realIterator.next();
            this.lastElement = next;
            return next;
        }

        @Override // java.util.Iterator
        public void remove() {
            this.realIterator.remove();
            T t = this.lastElement;
            if (t != null) {
            }
        }
    }
}
