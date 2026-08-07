package io.split.android.client.utils;

/* JADX INFO: loaded from: classes4.dex */
public interface MemoryUtils {
    boolean isMemoryAvailableForJson(String json);

    boolean isMemoryAvailableToAllocate(long bytes, int times);
}
