package com.splunk.rum;

import android.util.Log;
import io.opentelemetry.sdk.common.Clock;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import zipkin2.Call;
import zipkin2.codec.Encoding;
import zipkin2.reporter.Sender;

/* JADX INFO: loaded from: classes3.dex */
class ZipkinToDiskSender extends Sender {
    private final Clock clock;
    private final FileUtils fileUtils;
    private final File path;
    private final DeviceSpanStorageLimiter storageLimiter;

    @Override // zipkin2.reporter.Sender
    public int messageMaxBytes() {
        return 1048576;
    }

    private ZipkinToDiskSender(Builder builder) {
        this.path = (File) Objects.requireNonNull(builder.path);
        this.fileUtils = builder.fileUtils;
        this.clock = builder.clock;
        this.storageLimiter = (DeviceSpanStorageLimiter) Objects.requireNonNull(builder.storageLimiter);
    }

    @Override // zipkin2.reporter.Sender
    public Encoding encoding() {
        return Encoding.JSON;
    }

    @Override // zipkin2.reporter.Sender
    public int messageSizeInBytes(List<byte[]> list) {
        return ((Integer) list.stream().reduce(0, new BiFunction() { // from class: com.splunk.rum.ZipkinToDiskSender$$ExternalSyntheticLambda0
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Integer.valueOf(((Integer) obj).intValue() + ((byte[]) obj2).length + 1);
            }
        }, new BinaryOperator() { // from class: com.splunk.rum.ZipkinToDiskSender$$ExternalSyntheticLambda1
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Integer.valueOf(Integer.sum(((Integer) obj).intValue(), ((Integer) obj2).intValue()));
            }
        })).intValue();
    }

    @Override // zipkin2.reporter.Sender
    public Call<Void> sendSpans(List<byte[]> list) {
        if (list.isEmpty()) {
            return Call.create(null);
        }
        if (!this.storageLimiter.ensureFreeSpace()) {
            Log.e("SplunkRum", "Dropping " + list.size() + " spans: Too much telemetry has been buffered or not enough space on device.");
            return Call.create(null);
        }
        try {
            this.fileUtils.writeAsLines(createFilename(this.clock.now()), list);
        } catch (IOException e) {
            Log.e("SplunkRum", "Error writing spans to storage", e);
        }
        return Call.create(null);
    }

    private File createFilename(long j) {
        return new File(this.path, j + ".spans");
    }

    static Builder builder() {
        return new Builder();
    }

    static class Builder {
        private File path;
        private DeviceSpanStorageLimiter storageLimiter;
        private FileUtils fileUtils = new FileUtils();
        private Clock clock = Clock.getDefault();

        Builder() {
        }

        Builder path(File file) {
            this.path = file;
            return this;
        }

        Builder fileUtils(FileUtils fileUtils) {
            this.fileUtils = fileUtils;
            return this;
        }

        Builder clock(Clock clock) {
            this.clock = clock;
            return this;
        }

        Builder storageLimiter(DeviceSpanStorageLimiter deviceSpanStorageLimiter) {
            this.storageLimiter = deviceSpanStorageLimiter;
            return this;
        }

        ZipkinToDiskSender build() {
            return new ZipkinToDiskSender(this);
        }
    }
}
