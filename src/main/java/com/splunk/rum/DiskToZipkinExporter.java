package com.splunk.rum;

import android.util.Log;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes3.dex */
class DiskToZipkinExporter {
    static final double DEFAULT_MAX_UNCOMPRESSED_BANDWIDTH = 15360.0d;
    private final double bandwidthLimit;
    private final BandwidthTracker bandwidthTracker;
    private final ConnectionUtil connectionUtil;
    private final FileSender fileSender;
    private final FileUtils fileUtils;
    private final File spanFilesPath;
    private final ScheduledExecutorService threadPool;

    DiskToZipkinExporter(Builder builder) {
        this.threadPool = builder.threadPool;
        this.connectionUtil = (ConnectionUtil) Objects.requireNonNull(builder.connectionUtil);
        this.fileSender = (FileSender) Objects.requireNonNull(builder.fileSender);
        this.spanFilesPath = (File) Objects.requireNonNull(builder.spanFilesPath);
        this.fileUtils = builder.fileUtils;
        this.bandwidthTracker = (BandwidthTracker) Objects.requireNonNull(builder.bandwidthTracker);
        this.bandwidthLimit = builder.bandwidthLimit;
    }

    void startPolling() {
        this.threadPool.scheduleAtFixedRate(new Runnable() { // from class: com.splunk.rum.DiskToZipkinExporter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.doExportCycle();
            }
        }, 5L, 5L, TimeUnit.SECONDS);
    }

    void doExportCycle() {
        try {
            exportPendingFiles();
        } catch (Exception e) {
            Log.w("SplunkRum", "Error processing on-disk files", e);
        }
    }

    private void exportPendingFiles() {
        if (!this.connectionUtil.refreshNetworkStatus().isOnline()) {
            Log.i("SplunkRum", "Network offline, leaving spans on disk for for eventual export.");
            return;
        }
        boolean z = false;
        for (File file : getPendingFiles()) {
            double d = this.bandwidthTracker.totalSustainedRate();
            if (d > this.bandwidthLimit) {
                Log.i("SplunkRum", String.format("Export rate %.2f exceeds limit of %.2f, backing off", Double.valueOf(d), Double.valueOf(this.bandwidthLimit)));
                break;
            }
            boolean zHandleFileOnDisk = this.fileSender.handleFileOnDisk(file);
            z |= zHandleFileOnDisk;
            if (!zHandleFileOnDisk) {
                break;
            }
        }
        if (z) {
            return;
        }
        this.bandwidthTracker.tick(Collections.emptyList());
    }

    private List<File> getPendingFiles() {
        return (List) this.fileUtils.listSpanFiles(this.spanFilesPath).sorted(Comparator.comparing(new Function() { // from class: com.splunk.rum.DiskToZipkinExporter$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((File) obj).getName();
            }
        })).collect(Collectors.toList());
    }

    void stop() {
        this.threadPool.shutdown();
    }

    static Builder builder() {
        return new Builder();
    }

    static class Builder {
        private BandwidthTracker bandwidthTracker;
        private ConnectionUtil connectionUtil;
        private FileSender fileSender;
        private File spanFilesPath;
        private ScheduledExecutorService threadPool = Executors.newSingleThreadScheduledExecutor();
        private FileUtils fileUtils = new FileUtils();
        private double bandwidthLimit = DiskToZipkinExporter.DEFAULT_MAX_UNCOMPRESSED_BANDWIDTH;

        Builder() {
        }

        Builder threadPool(ScheduledExecutorService scheduledExecutorService) {
            this.threadPool = scheduledExecutorService;
            return this;
        }

        Builder connectionUtil(ConnectionUtil connectionUtil) {
            this.connectionUtil = connectionUtil;
            return this;
        }

        Builder bandwidthTracker(BandwidthTracker bandwidthTracker) {
            this.bandwidthTracker = bandwidthTracker;
            return this;
        }

        Builder fileSender(FileSender fileSender) {
            this.fileSender = fileSender;
            return this;
        }

        Builder bandwidthLimit(double d) {
            this.bandwidthLimit = d;
            return this;
        }

        Builder spanFilesPath(File file) {
            this.spanFilesPath = file;
            return this;
        }

        Builder fileUtils(FileUtils fileUtils) {
            this.fileUtils = fileUtils;
            return this;
        }

        DiskToZipkinExporter build() {
            return new DiskToZipkinExporter(this);
        }
    }
}
