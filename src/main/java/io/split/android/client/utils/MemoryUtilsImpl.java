package io.split.android.client.utils;

/* JADX INFO: loaded from: classes4.dex */
public class MemoryUtilsImpl implements MemoryUtils {
    private static final int MEMORY_ALLOCATION_TIMES_FOR_JSON = 2;

    @Override // io.split.android.client.utils.MemoryUtils
    public boolean isMemoryAvailableToAllocate(long bytes, int times) {
        return Runtime.getRuntime().freeMemory() > bytes * ((long) times);
    }

    @Override // io.split.android.client.utils.MemoryUtils
    public boolean isMemoryAvailableForJson(String json) {
        if (Utils.isNullOrEmpty(json)) {
            return true;
        }
        return isMemoryAvailableToAllocate(json.getBytes().length, 2);
    }
}
