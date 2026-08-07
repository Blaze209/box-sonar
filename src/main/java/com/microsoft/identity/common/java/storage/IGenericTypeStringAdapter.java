package com.microsoft.identity.common.java.storage;

/* JADX INFO: loaded from: classes14.dex */
public interface IGenericTypeStringAdapter<T> {
    public static final IGenericTypeStringAdapter<Long> LongStringAdapter = new IGenericTypeStringAdapter<Long>() { // from class: com.microsoft.identity.common.java.storage.IGenericTypeStringAdapter.1
        @Override // com.microsoft.identity.common.java.storage.IGenericTypeStringAdapter
        public String adapt(Long l) {
            if (l == null) {
                throw new NullPointerException("value is marked non-null but is null");
            }
            return String.valueOf(l);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.microsoft.identity.common.java.storage.IGenericTypeStringAdapter
        public Long adapt(String str) throws NumberFormatException {
            if (str == null) {
                throw new NullPointerException("value is marked non-null but is null");
            }
            return Long.valueOf(Long.parseLong(str));
        }
    };

    T adapt(String str);

    String adapt(T t);
}
