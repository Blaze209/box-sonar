package com.box.android.domain.models.item;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WatermarkableItem.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/models/item/WatermarkableItem;", "Landroid/os/Parcelable;", "File", "Folder", "Lcom/box/android/domain/models/item/WatermarkableItem$File;", "Lcom/box/android/domain/models/item/WatermarkableItem$Folder;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface WatermarkableItem extends Parcelable {

    /* JADX INFO: compiled from: WatermarkableItem.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/box/android/domain/models/item/WatermarkableItem$File;", "Lcom/box/android/domain/models/item/WatermarkableItem;", "model", "Lcom/box/android/domain/models/item/FileModel;", "<init>", "(Lcom/box/android/domain/models/item/FileModel;)V", "getModel", "()Lcom/box/android/domain/models/item/FileModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class File implements WatermarkableItem {
        public static final Parcelable.Creator<File> CREATOR = new Creator();
        private final FileModel model;

        /* JADX INFO: compiled from: WatermarkableItem.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<File> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final File createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new File(FileModel.CREATOR.createFromParcel(parcel));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final File[] newArray(int i) {
                return new File[i];
            }
        }

        public static /* synthetic */ File copy$default(File file, FileModel fileModel, int i, Object obj) {
            if ((i & 1) != 0) {
                fileModel = file.model;
            }
            return file.copy(fileModel);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FileModel getModel() {
            return this.model;
        }

        public final File copy(FileModel model) {
            Intrinsics.checkNotNullParameter(model, "model");
            return new File(model);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof File) && Intrinsics.areEqual(this.model, ((File) other).model);
        }

        public int hashCode() {
            return this.model.hashCode();
        }

        public String toString() {
            return "File(model=" + this.model + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            this.model.writeToParcel(dest, flags);
        }

        public File(FileModel model) {
            Intrinsics.checkNotNullParameter(model, "model");
            this.model = model;
        }

        public final FileModel getModel() {
            return this.model;
        }
    }

    /* JADX INFO: compiled from: WatermarkableItem.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/box/android/domain/models/item/WatermarkableItem$Folder;", "Lcom/box/android/domain/models/item/WatermarkableItem;", "model", "Lcom/box/android/domain/models/item/FolderModel;", "<init>", "(Lcom/box/android/domain/models/item/FolderModel;)V", "getModel", "()Lcom/box/android/domain/models/item/FolderModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Folder implements WatermarkableItem {
        public static final Parcelable.Creator<Folder> CREATOR = new Creator();
        private final FolderModel model;

        /* JADX INFO: compiled from: WatermarkableItem.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Folder> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Folder createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Folder(FolderModel.CREATOR.createFromParcel(parcel));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Folder[] newArray(int i) {
                return new Folder[i];
            }
        }

        public static /* synthetic */ Folder copy$default(Folder folder, FolderModel folderModel, int i, Object obj) {
            if ((i & 1) != 0) {
                folderModel = folder.model;
            }
            return folder.copy(folderModel);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FolderModel getModel() {
            return this.model;
        }

        public final Folder copy(FolderModel model) {
            Intrinsics.checkNotNullParameter(model, "model");
            return new Folder(model);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Folder) && Intrinsics.areEqual(this.model, ((Folder) other).model);
        }

        public int hashCode() {
            return this.model.hashCode();
        }

        public String toString() {
            return "Folder(model=" + this.model + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            this.model.writeToParcel(dest, flags);
        }

        public Folder(FolderModel model) {
            Intrinsics.checkNotNullParameter(model, "model");
            this.model = model;
        }

        public final FolderModel getModel() {
            return this.model;
        }
    }
}
