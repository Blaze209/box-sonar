package com.box.android.domain.models.observability;

import kotlin.Metadata;

/* JADX INFO: compiled from: ApdexType.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\n\u0018\u00002\u00020\u0001:\u0004\u000f\u0010\u0011\u0012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/box/android/domain/models/observability/PreviewNavApdex;", "Lcom/box/android/domain/models/observability/ApdexType;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "FileInfoRepresentationFetchStarted", "FileInfoRepresentationFetchEnded", "FileDownloadStarted", "FileDownloadEnded", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PreviewNavApdex implements ApdexType {
    public static final PreviewNavApdex INSTANCE = new PreviewNavApdex();
    private static final String name = "preview_nav";

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreviewNavApdex)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 701707767;
    }

    public String toString() {
        return "PreviewNavApdex";
    }

    private PreviewNavApdex() {
    }

    @Override // com.box.android.domain.models.observability.ApdexType
    public String getName() {
        return name;
    }

    /* JADX INFO: compiled from: ApdexType.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/box/android/domain/models/observability/PreviewNavApdex$FileInfoRepresentationFetchStarted;", "Lcom/box/android/domain/models/observability/ApdexType$Milestone;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class FileInfoRepresentationFetchStarted implements ApdexType.Milestone {
        public static final FileInfoRepresentationFetchStarted INSTANCE = new FileInfoRepresentationFetchStarted();
        private static final String name = "file_info_representation_fetch_started";

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FileInfoRepresentationFetchStarted)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -613371595;
        }

        public String toString() {
            return "FileInfoRepresentationFetchStarted";
        }

        private FileInfoRepresentationFetchStarted() {
        }

        @Override // com.box.android.domain.models.observability.ApdexType.Milestone
        public String getName() {
            return name;
        }
    }

    /* JADX INFO: compiled from: ApdexType.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/box/android/domain/models/observability/PreviewNavApdex$FileInfoRepresentationFetchEnded;", "Lcom/box/android/domain/models/observability/ApdexType$Milestone;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class FileInfoRepresentationFetchEnded implements ApdexType.Milestone {
        public static final FileInfoRepresentationFetchEnded INSTANCE = new FileInfoRepresentationFetchEnded();
        private static final String name = "file_info_representation_fetch_ended";

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FileInfoRepresentationFetchEnded)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1049942126;
        }

        public String toString() {
            return "FileInfoRepresentationFetchEnded";
        }

        private FileInfoRepresentationFetchEnded() {
        }

        @Override // com.box.android.domain.models.observability.ApdexType.Milestone
        public String getName() {
            return name;
        }
    }

    /* JADX INFO: compiled from: ApdexType.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/box/android/domain/models/observability/PreviewNavApdex$FileDownloadStarted;", "Lcom/box/android/domain/models/observability/ApdexType$Milestone;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class FileDownloadStarted implements ApdexType.Milestone {
        public static final FileDownloadStarted INSTANCE = new FileDownloadStarted();
        private static final String name = "file_download_started";

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FileDownloadStarted)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1048747226;
        }

        public String toString() {
            return "FileDownloadStarted";
        }

        private FileDownloadStarted() {
        }

        @Override // com.box.android.domain.models.observability.ApdexType.Milestone
        public String getName() {
            return name;
        }
    }

    /* JADX INFO: compiled from: ApdexType.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/box/android/domain/models/observability/PreviewNavApdex$FileDownloadEnded;", "Lcom/box/android/domain/models/observability/ApdexType$Milestone;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class FileDownloadEnded implements ApdexType.Milestone {
        public static final FileDownloadEnded INSTANCE = new FileDownloadEnded();
        private static final String name = "file_download_ended";

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FileDownloadEnded)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1264013983;
        }

        public String toString() {
            return "FileDownloadEnded";
        }

        private FileDownloadEnded() {
        }

        @Override // com.box.android.domain.models.observability.ApdexType.Milestone
        public String getName() {
            return name;
        }
    }
}
