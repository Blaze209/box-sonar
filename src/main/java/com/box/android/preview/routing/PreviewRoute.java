package com.box.android.preview.routing;

import com.box.android.base.presentation.components.commentbar.TimestampedCommentConfig;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewRoute.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0010\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0010\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#¨\u0006$"}, d2 = {"Lcom/box/android/preview/routing/PreviewRoute;", "", "<init>", "()V", "MoveOrCopy", "None", "OpenInExternalApp", "OpenUrl", "Share", "Collections", "ParentFolder", "FileInformation", "SelectDownloadFolder", "Settings", "Gallery", "Playlist", "UpdateApp", "Watermarking", "AddTask", "FileActivities", "Lcom/box/android/preview/routing/PreviewRoute$AddTask;", "Lcom/box/android/preview/routing/PreviewRoute$Collections;", "Lcom/box/android/preview/routing/PreviewRoute$FileActivities;", "Lcom/box/android/preview/routing/PreviewRoute$FileInformation;", "Lcom/box/android/preview/routing/PreviewRoute$Gallery;", "Lcom/box/android/preview/routing/PreviewRoute$MoveOrCopy;", "Lcom/box/android/preview/routing/PreviewRoute$None;", "Lcom/box/android/preview/routing/PreviewRoute$OpenInExternalApp;", "Lcom/box/android/preview/routing/PreviewRoute$OpenUrl;", "Lcom/box/android/preview/routing/PreviewRoute$ParentFolder;", "Lcom/box/android/preview/routing/PreviewRoute$Playlist;", "Lcom/box/android/preview/routing/PreviewRoute$SelectDownloadFolder;", "Lcom/box/android/preview/routing/PreviewRoute$Settings;", "Lcom/box/android/preview/routing/PreviewRoute$Share;", "Lcom/box/android/preview/routing/PreviewRoute$UpdateApp;", "Lcom/box/android/preview/routing/PreviewRoute$Watermarking;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class PreviewRoute {
    public static final int $stable = 0;

    public /* synthetic */ PreviewRoute(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: PreviewRoute.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/routing/PreviewRoute$MoveOrCopy;", "Lcom/box/android/preview/routing/PreviewRoute;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class MoveOrCopy extends PreviewRoute {
        public static final int $stable = 0;
        public static final MoveOrCopy INSTANCE = new MoveOrCopy();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MoveOrCopy)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -947106311;
        }

        public String toString() {
            return "MoveOrCopy";
        }

        private MoveOrCopy() {
            super(null);
        }
    }

    private PreviewRoute() {
    }

    /* JADX INFO: compiled from: PreviewRoute.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/routing/PreviewRoute$None;", "Lcom/box/android/preview/routing/PreviewRoute;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class None extends PreviewRoute {
        public static final int $stable = 0;
        public static final None INSTANCE = new None();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof None)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1821079032;
        }

        public String toString() {
            return "None";
        }

        private None() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: PreviewRoute.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/routing/PreviewRoute$OpenInExternalApp;", "Lcom/box/android/preview/routing/PreviewRoute;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OpenInExternalApp extends PreviewRoute {
        public static final int $stable = 0;
        public static final OpenInExternalApp INSTANCE = new OpenInExternalApp();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OpenInExternalApp)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1319390985;
        }

        public String toString() {
            return "OpenInExternalApp";
        }

        private OpenInExternalApp() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: PreviewRoute.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/preview/routing/PreviewRoute$OpenUrl;", "Lcom/box/android/preview/routing/PreviewRoute;", "url", "", "<init>", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OpenUrl extends PreviewRoute {
        public static final int $stable = 0;
        private final String url;

        public static /* synthetic */ OpenUrl copy$default(OpenUrl openUrl, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = openUrl.url;
            }
            return openUrl.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public final OpenUrl copy(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new OpenUrl(url);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OpenUrl) && Intrinsics.areEqual(this.url, ((OpenUrl) other).url);
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        public String toString() {
            return "OpenUrl(url=" + this.url + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenUrl(String url) {
            super(null);
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
        }

        public final String getUrl() {
            return this.url;
        }
    }

    /* JADX INFO: compiled from: PreviewRoute.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/routing/PreviewRoute$Share;", "Lcom/box/android/preview/routing/PreviewRoute;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Share extends PreviewRoute {
        public static final int $stable = 0;
        public static final Share INSTANCE = new Share();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Share)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -614478065;
        }

        public String toString() {
            return "Share";
        }

        private Share() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: PreviewRoute.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/routing/PreviewRoute$Collections;", "Lcom/box/android/preview/routing/PreviewRoute;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Collections extends PreviewRoute {
        public static final int $stable = 0;
        public static final Collections INSTANCE = new Collections();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Collections)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -630554427;
        }

        public String toString() {
            return "Collections";
        }

        private Collections() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: PreviewRoute.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/routing/PreviewRoute$ParentFolder;", "Lcom/box/android/preview/routing/PreviewRoute;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ParentFolder extends PreviewRoute {
        public static final int $stable = 0;
        public static final ParentFolder INSTANCE = new ParentFolder();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ParentFolder)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 978023560;
        }

        public String toString() {
            return "ParentFolder";
        }

        private ParentFolder() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: PreviewRoute.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/routing/PreviewRoute$FileInformation;", "Lcom/box/android/preview/routing/PreviewRoute;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class FileInformation extends PreviewRoute {
        public static final int $stable = 0;
        public static final FileInformation INSTANCE = new FileInformation();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FileInformation)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1584031040;
        }

        public String toString() {
            return "FileInformation";
        }

        private FileInformation() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: PreviewRoute.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/routing/PreviewRoute$SelectDownloadFolder;", "Lcom/box/android/preview/routing/PreviewRoute;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SelectDownloadFolder extends PreviewRoute {
        public static final int $stable = 0;
        public static final SelectDownloadFolder INSTANCE = new SelectDownloadFolder();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SelectDownloadFolder)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -35709438;
        }

        public String toString() {
            return "SelectDownloadFolder";
        }

        private SelectDownloadFolder() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: PreviewRoute.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/routing/PreviewRoute$Settings;", "Lcom/box/android/preview/routing/PreviewRoute;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Settings extends PreviewRoute {
        public static final int $stable = 0;
        public static final Settings INSTANCE = new Settings();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Settings)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1413066483;
        }

        public String toString() {
            return "Settings";
        }

        private Settings() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: PreviewRoute.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/routing/PreviewRoute$Gallery;", "Lcom/box/android/preview/routing/PreviewRoute;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Gallery extends PreviewRoute {
        public static final int $stable = 0;
        public static final Gallery INSTANCE = new Gallery();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Gallery)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -58463614;
        }

        public String toString() {
            return "Gallery";
        }

        private Gallery() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: PreviewRoute.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/routing/PreviewRoute$Playlist;", "Lcom/box/android/preview/routing/PreviewRoute;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Playlist extends PreviewRoute {
        public static final int $stable = 0;
        public static final Playlist INSTANCE = new Playlist();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Playlist)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1857909922;
        }

        public String toString() {
            return "Playlist";
        }

        private Playlist() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: PreviewRoute.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/routing/PreviewRoute$UpdateApp;", "Lcom/box/android/preview/routing/PreviewRoute;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class UpdateApp extends PreviewRoute {
        public static final int $stable = 0;
        public static final UpdateApp INSTANCE = new UpdateApp();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateApp)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1677234120;
        }

        public String toString() {
            return "UpdateApp";
        }

        private UpdateApp() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: PreviewRoute.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/routing/PreviewRoute$Watermarking;", "Lcom/box/android/preview/routing/PreviewRoute;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Watermarking extends PreviewRoute {
        public static final int $stable = 0;
        public static final Watermarking INSTANCE = new Watermarking();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Watermarking)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1271943218;
        }

        public String toString() {
            return "Watermarking";
        }

        private Watermarking() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: PreviewRoute.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/routing/PreviewRoute$AddTask;", "Lcom/box/android/preview/routing/PreviewRoute;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AddTask extends PreviewRoute {
        public static final int $stable = 0;
        public static final AddTask INSTANCE = new AddTask();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AddTask)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1010737930;
        }

        public String toString() {
            return "AddTask";
        }

        private AddTask() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: PreviewRoute.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/preview/routing/PreviewRoute$FileActivities;", "Lcom/box/android/preview/routing/PreviewRoute;", "activityId", "", "timestampConfig", "Lcom/box/android/base/presentation/components/commentbar/TimestampedCommentConfig;", "<init>", "(Ljava/lang/String;Lcom/box/android/base/presentation/components/commentbar/TimestampedCommentConfig;)V", "getActivityId", "()Ljava/lang/String;", "getTimestampConfig", "()Lcom/box/android/base/presentation/components/commentbar/TimestampedCommentConfig;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class FileActivities extends PreviewRoute {
        public static final int $stable = TimestampedCommentConfig.$stable;
        private final String activityId;
        private final TimestampedCommentConfig timestampConfig;

        /* JADX WARN: Multi-variable type inference failed */
        public FileActivities() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ FileActivities copy$default(FileActivities fileActivities, String str, TimestampedCommentConfig timestampedCommentConfig, int i, Object obj) {
            if ((i & 1) != 0) {
                str = fileActivities.activityId;
            }
            if ((i & 2) != 0) {
                timestampedCommentConfig = fileActivities.timestampConfig;
            }
            return fileActivities.copy(str, timestampedCommentConfig);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getActivityId() {
            return this.activityId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final TimestampedCommentConfig getTimestampConfig() {
            return this.timestampConfig;
        }

        public final FileActivities copy(String activityId, TimestampedCommentConfig timestampConfig) {
            return new FileActivities(activityId, timestampConfig);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FileActivities)) {
                return false;
            }
            FileActivities fileActivities = (FileActivities) other;
            return Intrinsics.areEqual(this.activityId, fileActivities.activityId) && Intrinsics.areEqual(this.timestampConfig, fileActivities.timestampConfig);
        }

        public int hashCode() {
            String str = this.activityId;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            TimestampedCommentConfig timestampedCommentConfig = this.timestampConfig;
            return iHashCode + (timestampedCommentConfig != null ? timestampedCommentConfig.hashCode() : 0);
        }

        public String toString() {
            return "FileActivities(activityId=" + this.activityId + ", timestampConfig=" + this.timestampConfig + ")";
        }

        public FileActivities(String str, TimestampedCommentConfig timestampedCommentConfig) {
            super(null);
            this.activityId = str;
            this.timestampConfig = timestampedCommentConfig;
        }

        public /* synthetic */ FileActivities(String str, TimestampedCommentConfig timestampedCommentConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : timestampedCommentConfig);
        }

        public final String getActivityId() {
            return this.activityId;
        }

        public final TimestampedCommentConfig getTimestampConfig() {
            return this.timestampConfig;
        }
    }
}
