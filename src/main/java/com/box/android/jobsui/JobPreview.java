package com.box.android.jobsui;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JobItemReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00072\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/box/android/jobsui/JobPreview;", "", "<init>", "()V", "PendingItemPreview", "BoxPreview", "FolderPreview", "Companion", "Lcom/box/android/jobsui/JobPreview$BoxPreview;", "Lcom/box/android/jobsui/JobPreview$FolderPreview;", "Lcom/box/android/jobsui/JobPreview$PendingItemPreview;", "jobsui_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class JobPreview {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ JobPreview(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private JobPreview() {
    }

    /* JADX INFO: compiled from: JobItemReducer.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/box/android/jobsui/JobPreview$PendingItemPreview;", "Lcom/box/android/jobsui/JobPreview;", "name", "", "contentUrl", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/box/android/domain/models/item/FileModel;)V", "getName", "()Ljava/lang/String;", "getContentUrl", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "jobsui_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PendingItemPreview extends JobPreview {
        public static final int $stable = 8;
        private final String contentUrl;
        private final FileModel fileModel;
        private final String name;

        public static /* synthetic */ PendingItemPreview copy$default(PendingItemPreview pendingItemPreview, String str, String str2, FileModel fileModel, int i, Object obj) {
            if ((i & 1) != 0) {
                str = pendingItemPreview.name;
            }
            if ((i & 2) != 0) {
                str2 = pendingItemPreview.contentUrl;
            }
            if ((i & 4) != 0) {
                fileModel = pendingItemPreview.fileModel;
            }
            return pendingItemPreview.copy(str, str2, fileModel);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getContentUrl() {
            return this.contentUrl;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final FileModel getFileModel() {
            return this.fileModel;
        }

        public final PendingItemPreview copy(String name, String contentUrl, FileModel fileModel) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(contentUrl, "contentUrl");
            return new PendingItemPreview(name, contentUrl, fileModel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PendingItemPreview)) {
                return false;
            }
            PendingItemPreview pendingItemPreview = (PendingItemPreview) other;
            return Intrinsics.areEqual(this.name, pendingItemPreview.name) && Intrinsics.areEqual(this.contentUrl, pendingItemPreview.contentUrl) && Intrinsics.areEqual(this.fileModel, pendingItemPreview.fileModel);
        }

        public int hashCode() {
            int iHashCode = ((this.name.hashCode() * 31) + this.contentUrl.hashCode()) * 31;
            FileModel fileModel = this.fileModel;
            return iHashCode + (fileModel == null ? 0 : fileModel.hashCode());
        }

        public String toString() {
            return "PendingItemPreview(name=" + this.name + ", contentUrl=" + this.contentUrl + ", fileModel=" + this.fileModel + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PendingItemPreview(String name, String contentUrl, FileModel fileModel) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(contentUrl, "contentUrl");
            this.name = name;
            this.contentUrl = contentUrl;
            this.fileModel = fileModel;
        }

        public final String getContentUrl() {
            return this.contentUrl;
        }

        public final FileModel getFileModel() {
            return this.fileModel;
        }

        public final String getName() {
            return this.name;
        }
    }

    /* JADX INFO: compiled from: JobItemReducer.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/jobsui/JobPreview$BoxPreview;", "Lcom/box/android/jobsui/JobPreview;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "<init>", "(Lcom/box/android/domain/models/item/FileModel;)V", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "jobsui_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class BoxPreview extends JobPreview {
        public static final int $stable = 8;
        private final FileModel fileModel;

        public static /* synthetic */ BoxPreview copy$default(BoxPreview boxPreview, FileModel fileModel, int i, Object obj) {
            if ((i & 1) != 0) {
                fileModel = boxPreview.fileModel;
            }
            return boxPreview.copy(fileModel);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FileModel getFileModel() {
            return this.fileModel;
        }

        public final BoxPreview copy(FileModel fileModel) {
            Intrinsics.checkNotNullParameter(fileModel, "fileModel");
            return new BoxPreview(fileModel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof BoxPreview) && Intrinsics.areEqual(this.fileModel, ((BoxPreview) other).fileModel);
        }

        public int hashCode() {
            return this.fileModel.hashCode();
        }

        public String toString() {
            return "BoxPreview(fileModel=" + this.fileModel + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BoxPreview(FileModel fileModel) {
            super(null);
            Intrinsics.checkNotNullParameter(fileModel, "fileModel");
            this.fileModel = fileModel;
        }

        public final FileModel getFileModel() {
            return this.fileModel;
        }
    }

    /* JADX INFO: compiled from: JobItemReducer.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/jobsui/JobPreview$FolderPreview;", "Lcom/box/android/jobsui/JobPreview;", "folder", "Lcom/box/android/domain/models/item/FolderModel;", "<init>", "(Lcom/box/android/domain/models/item/FolderModel;)V", "getFolder", "()Lcom/box/android/domain/models/item/FolderModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "jobsui_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class FolderPreview extends JobPreview {
        public static final int $stable = 8;
        private final FolderModel folder;

        public static /* synthetic */ FolderPreview copy$default(FolderPreview folderPreview, FolderModel folderModel, int i, Object obj) {
            if ((i & 1) != 0) {
                folderModel = folderPreview.folder;
            }
            return folderPreview.copy(folderModel);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FolderModel getFolder() {
            return this.folder;
        }

        public final FolderPreview copy(FolderModel folder) {
            Intrinsics.checkNotNullParameter(folder, "folder");
            return new FolderPreview(folder);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof FolderPreview) && Intrinsics.areEqual(this.folder, ((FolderPreview) other).folder);
        }

        public int hashCode() {
            return this.folder.hashCode();
        }

        public String toString() {
            return "FolderPreview(folder=" + this.folder + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FolderPreview(FolderModel folder) {
            super(null);
            Intrinsics.checkNotNullParameter(folder, "folder");
            this.folder = folder;
        }

        public final FolderModel getFolder() {
            return this.folder;
        }
    }

    /* JADX INFO: compiled from: JobItemReducer.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/jobsui/JobPreview$Companion;", "", "<init>", "()V", "fromJobState", "Lcom/box/android/jobsui/JobPreview;", "jobState", "Lcom/box/android/jobsui/JobItemReducer$State;", "jobsui_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final JobPreview fromJobState(JobItemReducer.State jobState) {
            Intrinsics.checkNotNullParameter(jobState, "jobState");
            if (jobState.getContentUrl() != null) {
                String title = jobState.getTitle();
                String contentUrl = jobState.getContentUrl();
                ItemModel item = jobState.getItem();
                return new PendingItemPreview(title, contentUrl, item instanceof FileModel ? (FileModel) item : null);
            }
            if (jobState.getItem() instanceof FileModel) {
                return new BoxPreview((FileModel) jobState.getItem());
            }
            if (jobState.getItem() instanceof FolderModel) {
                return new FolderPreview((FolderModel) jobState.getItem());
            }
            return null;
        }
    }
}
