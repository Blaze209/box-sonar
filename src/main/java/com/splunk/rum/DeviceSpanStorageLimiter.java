package com.splunk.rum;

import android.util.Log;
import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes3.dex */
class DeviceSpanStorageLimiter {
    static final int DEFAULT_MAX_STORAGE_USE_MB = 25;
    private final FileUtils fileUtils;
    private final int maxStorageUseMb;
    private final File path;

    private DeviceSpanStorageLimiter(Builder builder) {
        this.path = (File) Objects.requireNonNull(builder.path);
        this.maxStorageUseMb = builder.maxStorageUseMb;
        this.fileUtils = builder.fileUtils;
    }

    boolean ensureFreeSpace() {
        tryFreeingSpace();
        return this.path.getFreeSpace() > limitInBytes();
    }

    private void tryFreeingSpace() {
        long totalFileSizeInBytes = this.fileUtils.getTotalFileSizeInBytes(this.path);
        if (underLimit(totalFileSizeInBytes)) {
            return;
        }
        Stream<File> streamListSpanFiles = this.fileUtils.listSpanFiles(this.path);
        final FileUtils fileUtils = this.fileUtils;
        Objects.requireNonNull(fileUtils);
        for (File file : (List) streamListSpanFiles.sorted(Comparator.comparingLong(new ToLongFunction() { // from class: com.splunk.rum.DeviceSpanStorageLimiter$$ExternalSyntheticLambda0
            @Override // java.util.function.ToLongFunction
            public final long applyAsLong(Object obj) {
                return fileUtils.getModificationTime((File) obj);
            }
        })).collect(Collectors.toList())) {
            Log.w("SplunkRum", "Too much data buffered, dropping file " + file);
            long fileSize = this.fileUtils.getFileSize(file);
            this.fileUtils.safeDelete(file);
            totalFileSizeInBytes -= fileSize;
            if (underLimit(totalFileSizeInBytes)) {
                return;
            }
        }
    }

    private boolean underLimit(long j) {
        return j < limitInBytes();
    }

    private long limitInBytes() {
        return ((long) this.maxStorageUseMb) * 1048576;
    }

    static Builder builder() {
        return new Builder();
    }

    static class Builder {
        private File path;
        private int maxStorageUseMb = 25;
        private FileUtils fileUtils = new FileUtils();

        Builder() {
        }

        Builder path(File file) {
            this.path = file;
            return this;
        }

        Builder maxStorageUseMb(int i) {
            this.maxStorageUseMb = i;
            return this;
        }

        Builder fileUtils(FileUtils fileUtils) {
            this.fileUtils = fileUtils;
            return this;
        }

        DeviceSpanStorageLimiter build() {
            return new DeviceSpanStorageLimiter(this);
        }
    }
}
