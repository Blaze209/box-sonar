package com.box.android.data.utilities;

import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.utils.SupportedFileExtensions;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileModelFilter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u0082\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/box/android/data/utilities/FileModelFilter;", "", "<init>", "()V", "shouldAccept", "", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "ImageItems", "GifItems", "VideoItems", "Lcom/box/android/data/utilities/FileModelFilter$GifItems;", "Lcom/box/android/data/utilities/FileModelFilter$ImageItems;", "Lcom/box/android/data/utilities/FileModelFilter$VideoItems;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class FileModelFilter {
    public /* synthetic */ FileModelFilter(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract boolean shouldAccept(FileModel fileModel);

    private FileModelFilter() {
    }

    /* JADX INFO: compiled from: FileModelFilter.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0013\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001¨\u0006\u000f"}, d2 = {"Lcom/box/android/data/utilities/FileModelFilter$ImageItems;", "Lcom/box/android/data/utilities/FileModelFilter;", "<init>", "()V", "shouldAccept", "", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "equals", "other", "", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ImageItems extends FileModelFilter {
        public static final ImageItems INSTANCE = new ImageItems();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ImageItems)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 489516647;
        }

        public String toString() {
            return "ImageItems";
        }

        private ImageItems() {
            super(null);
        }

        @Override // com.box.android.data.utilities.FileModelFilter
        public boolean shouldAccept(FileModel fileModel) {
            Intrinsics.checkNotNullParameter(fileModel, "fileModel");
            String extension = fileModel.getExtension();
            return SupportedFileExtensions.INSTANCE.isImageExtension(extension) || SupportedFileExtensions.INSTANCE.isVectorExtension(extension) || SupportedFileExtensions.INSTANCE.isAdobePhotoshopExtension(extension) || SupportedFileExtensions.INSTANCE.isAdobeIllustratorExtension(extension);
        }
    }

    /* JADX INFO: compiled from: FileModelFilter.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0013\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001¨\u0006\u000f"}, d2 = {"Lcom/box/android/data/utilities/FileModelFilter$GifItems;", "Lcom/box/android/data/utilities/FileModelFilter;", "<init>", "()V", "shouldAccept", "", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "equals", "other", "", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class GifItems extends FileModelFilter {
        public static final GifItems INSTANCE = new GifItems();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GifItems)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1234302434;
        }

        public String toString() {
            return "GifItems";
        }

        private GifItems() {
            super(null);
        }

        @Override // com.box.android.data.utilities.FileModelFilter
        public boolean shouldAccept(FileModel fileModel) {
            Intrinsics.checkNotNullParameter(fileModel, "fileModel");
            return SupportedFileExtensions.INSTANCE.isGifExtension(fileModel.getExtension());
        }
    }

    /* JADX INFO: compiled from: FileModelFilter.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0013\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001¨\u0006\u000f"}, d2 = {"Lcom/box/android/data/utilities/FileModelFilter$VideoItems;", "Lcom/box/android/data/utilities/FileModelFilter;", "<init>", "()V", "shouldAccept", "", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "equals", "other", "", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class VideoItems extends FileModelFilter {
        public static final VideoItems INSTANCE = new VideoItems();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VideoItems)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 314439495;
        }

        public String toString() {
            return "VideoItems";
        }

        private VideoItems() {
            super(null);
        }

        @Override // com.box.android.data.utilities.FileModelFilter
        public boolean shouldAccept(FileModel fileModel) {
            Intrinsics.checkNotNullParameter(fileModel, "fileModel");
            return SupportedFileExtensions.INSTANCE.isVideoExtension(fileModel.getExtension());
        }
    }
}
