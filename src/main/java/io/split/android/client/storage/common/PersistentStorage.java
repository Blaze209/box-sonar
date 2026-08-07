package io.split.android.client.storage.common;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface PersistentStorage<T> extends StoragePusher<T> {
    void delete(List<T> elements);

    void deleteInvalid(long maxTimestamp);

    List<T> pop(int count);

    void pushMany(List<T> elements);

    void setActive(List<T> elements);
}
