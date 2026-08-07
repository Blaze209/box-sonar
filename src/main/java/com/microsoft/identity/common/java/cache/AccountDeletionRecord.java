package com.microsoft.identity.common.java.cache;

import com.microsoft.identity.common.java.dto.AccountRecord;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes14.dex */
public class AccountDeletionRecord implements List<AccountRecord> {
    private static final String RESULT_IS_READ_ONLY = "Result is read-only";
    private final List<AccountRecord> mAccountRecordList;

    public AccountDeletionRecord(List<AccountRecord> list) {
        if (list == null) {
            this.mAccountRecordList = new ArrayList();
        } else {
            this.mAccountRecordList = list;
        }
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.mAccountRecordList.size();
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.mAccountRecordList.isEmpty();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return this.mAccountRecordList.contains(obj);
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<AccountRecord> iterator() {
        return this.mAccountRecordList.iterator();
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.mAccountRecordList.toArray();
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.mAccountRecordList.toArray(tArr);
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(AccountRecord accountRecord) {
        throw new UnsupportedOperationException(RESULT_IS_READ_ONLY);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException(RESULT_IS_READ_ONLY);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return this.mAccountRecordList.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends AccountRecord> collection) {
        throw new UnsupportedOperationException(RESULT_IS_READ_ONLY);
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends AccountRecord> collection) {
        if (collection == null) {
            throw new NullPointerException("c is marked non-null but is null");
        }
        throw new UnsupportedOperationException(RESULT_IS_READ_ONLY);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException(RESULT_IS_READ_ONLY);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException(RESULT_IS_READ_ONLY);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException(RESULT_IS_READ_ONLY);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.List
    public AccountRecord get(int i) {
        return this.mAccountRecordList.get(i);
    }

    @Override // java.util.List
    public AccountRecord set(int i, AccountRecord accountRecord) {
        throw new UnsupportedOperationException(RESULT_IS_READ_ONLY);
    }

    @Override // java.util.List
    public void add(int i, AccountRecord accountRecord) {
        throw new UnsupportedOperationException(RESULT_IS_READ_ONLY);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.List
    public AccountRecord remove(int i) {
        throw new UnsupportedOperationException(RESULT_IS_READ_ONLY);
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.mAccountRecordList.indexOf(obj);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.mAccountRecordList.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<AccountRecord> listIterator() {
        return this.mAccountRecordList.listIterator();
    }

    @Override // java.util.List
    public ListIterator<AccountRecord> listIterator(int i) {
        return this.mAccountRecordList.listIterator(i);
    }

    @Override // java.util.List
    public List<AccountRecord> subList(int i, int i2) {
        return this.mAccountRecordList.subList(i, i2);
    }
}
