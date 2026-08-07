package com.box.android.fileactivity.presentation;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FileActivitiesScreen.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/fileactivity/presentation/VersionInfo;", "", "<init>", "()V", "Version", "Page", "VersionAndPage", "Lcom/box/android/fileactivity/presentation/VersionInfo$Page;", "Lcom/box/android/fileactivity/presentation/VersionInfo$Version;", "Lcom/box/android/fileactivity/presentation/VersionInfo$VersionAndPage;", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class VersionInfo {
    public static final int $stable = 0;

    public /* synthetic */ VersionInfo(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: FileActivitiesScreen.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/fileactivity/presentation/VersionInfo$Version;", "Lcom/box/android/fileactivity/presentation/VersionInfo;", "versionNumber", "", "<init>", "(I)V", "getVersionNumber", "()I", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Version extends VersionInfo {
        public static final int $stable = 0;
        private final int versionNumber;

        public static /* synthetic */ Version copy$default(Version version, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = version.versionNumber;
            }
            return version.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getVersionNumber() {
            return this.versionNumber;
        }

        public final Version copy(int versionNumber) {
            return new Version(versionNumber);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Version) && this.versionNumber == ((Version) other).versionNumber;
        }

        public int hashCode() {
            return Integer.hashCode(this.versionNumber);
        }

        public String toString() {
            return "Version(versionNumber=" + this.versionNumber + ")";
        }

        public Version(int i) {
            super(null);
            this.versionNumber = i;
        }

        public final int getVersionNumber() {
            return this.versionNumber;
        }
    }

    private VersionInfo() {
    }

    /* JADX INFO: compiled from: FileActivitiesScreen.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/fileactivity/presentation/VersionInfo$Page;", "Lcom/box/android/fileactivity/presentation/VersionInfo;", "pageNumber", "", "<init>", "(I)V", "getPageNumber", "()I", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Page extends VersionInfo {
        public static final int $stable = 0;
        private final int pageNumber;

        public static /* synthetic */ Page copy$default(Page page, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = page.pageNumber;
            }
            return page.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getPageNumber() {
            return this.pageNumber;
        }

        public final Page copy(int pageNumber) {
            return new Page(pageNumber);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Page) && this.pageNumber == ((Page) other).pageNumber;
        }

        public int hashCode() {
            return Integer.hashCode(this.pageNumber);
        }

        public String toString() {
            return "Page(pageNumber=" + this.pageNumber + ")";
        }

        public Page(int i) {
            super(null);
            this.pageNumber = i;
        }

        public final int getPageNumber() {
            return this.pageNumber;
        }
    }

    /* JADX INFO: compiled from: FileActivitiesScreen.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/box/android/fileactivity/presentation/VersionInfo$VersionAndPage;", "Lcom/box/android/fileactivity/presentation/VersionInfo;", "versionNumber", "", "pageNumber", "<init>", "(II)V", "getVersionNumber", "()I", "getPageNumber", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class VersionAndPage extends VersionInfo {
        public static final int $stable = 0;
        private final int pageNumber;
        private final int versionNumber;

        public static /* synthetic */ VersionAndPage copy$default(VersionAndPage versionAndPage, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = versionAndPage.versionNumber;
            }
            if ((i3 & 2) != 0) {
                i2 = versionAndPage.pageNumber;
            }
            return versionAndPage.copy(i, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getVersionNumber() {
            return this.versionNumber;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getPageNumber() {
            return this.pageNumber;
        }

        public final VersionAndPage copy(int versionNumber, int pageNumber) {
            return new VersionAndPage(versionNumber, pageNumber);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VersionAndPage)) {
                return false;
            }
            VersionAndPage versionAndPage = (VersionAndPage) other;
            return this.versionNumber == versionAndPage.versionNumber && this.pageNumber == versionAndPage.pageNumber;
        }

        public int hashCode() {
            return (Integer.hashCode(this.versionNumber) * 31) + Integer.hashCode(this.pageNumber);
        }

        public String toString() {
            return "VersionAndPage(versionNumber=" + this.versionNumber + ", pageNumber=" + this.pageNumber + ")";
        }

        public VersionAndPage(int i, int i2) {
            super(null);
            this.versionNumber = i;
            this.pageNumber = i2;
        }

        public final int getPageNumber() {
            return this.pageNumber;
        }

        public final int getVersionNumber() {
            return this.versionNumber;
        }
    }
}
