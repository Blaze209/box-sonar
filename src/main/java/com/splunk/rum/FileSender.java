package com.splunk.rum;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import zipkin2.reporter.Sender;

/* JADX INFO: loaded from: classes3.dex */
class FileSender {
    private static final int DEFAULT_MAX_RETRIES = 20;
    private final BandwidthTracker bandwidthTracker;
    private final FileUtils fileUtils;
    private final RetryTracker retryTracker;
    private final Sender sender;

    private FileSender(Builder builder) {
        this.sender = (Sender) Objects.requireNonNull(builder.sender);
        this.fileUtils = builder.fileUtils;
        this.bandwidthTracker = (BandwidthTracker) Objects.requireNonNull(builder.bandwidthTracker);
        this.retryTracker = builder.buildRetryTracker();
    }

    boolean handleFileOnDisk(File file) {
        Log.d("SplunkRum", "Reading file content for ingest: " + file);
        List<byte[]> fileCompletely = readFileCompletely(file);
        if (fileCompletely.isEmpty()) {
            this.fileUtils.safeDelete(file);
            return false;
        }
        boolean zAttemptSend = attemptSend(file, fileCompletely);
        if (!zAttemptSend) {
            this.retryTracker.trackFailure(file);
        }
        if (!zAttemptSend && !this.retryTracker.exceededRetries(file)) {
            return zAttemptSend;
        }
        this.retryTracker.clear(file);
        this.fileUtils.safeDelete(file);
        return zAttemptSend;
    }

    private boolean attemptSend(File file, List<byte[]> list) {
        try {
            this.bandwidthTracker.tick(list);
            this.sender.sendSpans(list).execute();
            Log.d("SplunkRum", "File content " + file + " successfully uploaded");
            return true;
        } catch (IOException e) {
            Log.w("SplunkRum", "Error sending file content", e);
            return false;
        }
    }

    private List<byte[]> readFileCompletely(File file) {
        try {
            return this.fileUtils.readFileCompletely(file);
        } catch (IOException e) {
            Log.w("SplunkRum", "Error reading span data from file " + file, e);
            return Collections.emptyList();
        }
    }

    static Builder builder() {
        return new Builder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class RetryTracker {
        private final Map<File, Integer> attempts;
        private final Consumer<Integer> backoff;
        private final int maxRetries;

        private RetryTracker(int i, Consumer<Integer> consumer) {
            this.attempts = new HashMap();
            this.maxRetries = i;
            this.backoff = consumer;
        }

        void clear(File file) {
            this.attempts.remove(file);
        }

        void trackFailure(File file) {
            Integer numMerge = this.attempts.merge(file, 1, new BiFunction() { // from class: com.splunk.rum.FileSender$RetryTracker$$ExternalSyntheticLambda0
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return Integer.valueOf(((Integer) obj).intValue() + 1);
                }
            });
            if (numMerge.intValue() >= this.maxRetries) {
                Log.w("SplunkRum", "Dropping data in " + file + " (max retries exceeded " + this.maxRetries + ")");
            } else {
                this.backoff.accept(numMerge);
            }
        }

        boolean exceededRetries(File file) {
            return this.attempts.getOrDefault(file, 0).intValue() >= this.maxRetries;
        }
    }

    static class DefaultBackoff implements Consumer<Integer> {
        DefaultBackoff() {
        }

        @Override // java.util.function.Consumer
        public void accept(Integer num) {
            try {
                TimeUnit.SECONDS.sleep(Math.min(60, num.intValue() * 5));
            } catch (InterruptedException e) {
                Log.w("SplunkRum", "Error during backoff", e);
                Thread.currentThread().interrupt();
            }
        }
    }

    static class Builder {
        private BandwidthTracker bandwidthTracker;
        private Sender sender;
        private FileUtils fileUtils = new FileUtils();
        private int maxRetries = 20;
        private Consumer<Integer> backoff = new DefaultBackoff();

        Builder() {
        }

        Builder sender(Sender sender) {
            this.sender = sender;
            return this;
        }

        Builder fileUtils(FileUtils fileUtils) {
            this.fileUtils = fileUtils;
            return this;
        }

        Builder maxRetries(int i) {
            this.maxRetries = i;
            return this;
        }

        Builder bandwidthTracker(BandwidthTracker bandwidthTracker) {
            this.bandwidthTracker = bandwidthTracker;
            return this;
        }

        Builder backoff(Consumer<Integer> consumer) {
            this.backoff = consumer;
            return this;
        }

        FileSender build() {
            return new FileSender(this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public RetryTracker buildRetryTracker() {
            return new RetryTracker(this.maxRetries, this.backoff);
        }
    }
}
