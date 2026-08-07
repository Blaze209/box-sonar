package com.box.android.preview.item;

import android.graphics.Bitmap;
import com.box.android.base.presentation.utilities.FileTypeIcon;
import com.box.android.cpl.Embedded;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.item.FileModel;
import com.box.android.preview.previewtype.audio.AudioPreviewReducer;
import com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer;
import com.box.android.preview.previewtype.code.CodePreviewReducer;
import com.box.android.preview.previewtype.document.DocumentPreviewReducer;
import com.box.android.preview.previewtype.gif.GifPreviewReducer;
import com.box.android.preview.previewtype.image.ImagePreviewReducer;
import com.box.android.preview.previewtype.video.VideoPreviewReducer;
import com.facebook.react.views.textinput.ReactTextInputShadowNode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemState.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\n\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017B\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\n\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !¨\u0006\""}, d2 = {"Lcom/box/android/preview/item/ItemState;", "", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "<init>", "(Lcom/box/android/domain/models/item/FileModel;)V", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "previewContentLoaded", "", "getLoadingPlaceholder", "Lcom/box/android/preview/item/LoadingPlaceholder;", "withLoadingPlaceholder", "loadingPlaceholder", "Uninitialized", "Loading", "Error", "Document", "Image", "Gif", "Video", "Code", "Audio", "BoxNote", "Lcom/box/android/preview/item/ItemState$Audio;", "Lcom/box/android/preview/item/ItemState$BoxNote;", "Lcom/box/android/preview/item/ItemState$Code;", "Lcom/box/android/preview/item/ItemState$Document;", "Lcom/box/android/preview/item/ItemState$Error;", "Lcom/box/android/preview/item/ItemState$Gif;", "Lcom/box/android/preview/item/ItemState$Image;", "Lcom/box/android/preview/item/ItemState$Loading;", "Lcom/box/android/preview/item/ItemState$Uninitialized;", "Lcom/box/android/preview/item/ItemState$Video;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class ItemState {
    public static final int $stable = 8;
    private final FileModel fileModel;

    public /* synthetic */ ItemState(FileModel fileModel, DefaultConstructorMarker defaultConstructorMarker) {
        this(fileModel);
    }

    /* JADX INFO: compiled from: ItemState.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/item/ItemState$Uninitialized;", "Lcom/box/android/preview/item/ItemState;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "<init>", "(Lcom/box/android/domain/models/item/FileModel;)V", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Uninitialized extends ItemState {
        public static final int $stable = 8;
        private final FileModel fileModel;

        public static /* synthetic */ Uninitialized copy$default(Uninitialized uninitialized, FileModel fileModel, int i, Object obj) {
            if ((i & 1) != 0) {
                fileModel = uninitialized.fileModel;
            }
            return uninitialized.copy(fileModel);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FileModel getFileModel() {
            return this.fileModel;
        }

        public final Uninitialized copy(FileModel fileModel) {
            Intrinsics.checkNotNullParameter(fileModel, "fileModel");
            return new Uninitialized(fileModel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Uninitialized) && Intrinsics.areEqual(this.fileModel, ((Uninitialized) other).fileModel);
        }

        public int hashCode() {
            return this.fileModel.hashCode();
        }

        public String toString() {
            return "Uninitialized(fileModel=" + this.fileModel + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Uninitialized(FileModel fileModel) {
            super(fileModel, null);
            Intrinsics.checkNotNullParameter(fileModel, "fileModel");
            this.fileModel = fileModel;
        }

        @Override // com.box.android.preview.item.ItemState
        public FileModel getFileModel() {
            return this.fileModel;
        }
    }

    private ItemState(FileModel fileModel) {
        this.fileModel = fileModel;
    }

    public FileModel getFileModel() {
        return this.fileModel;
    }

    /* JADX INFO: compiled from: ItemState.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/box/android/preview/item/ItemState$Loading;", "Lcom/box/android/preview/item/ItemState;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", ReactTextInputShadowNode.PROP_PLACEHOLDER, "Lcom/box/android/preview/item/LoadingPlaceholder;", "<init>", "(Lcom/box/android/domain/models/item/FileModel;Lcom/box/android/preview/item/LoadingPlaceholder;)V", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "getPlaceholder", "()Lcom/box/android/preview/item/LoadingPlaceholder;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Loading extends ItemState {
        public static final int $stable = 8;
        private final FileModel fileModel;
        private final LoadingPlaceholder placeholder;

        public static /* synthetic */ Loading copy$default(Loading loading, FileModel fileModel, LoadingPlaceholder loadingPlaceholder, int i, Object obj) {
            if ((i & 1) != 0) {
                fileModel = loading.fileModel;
            }
            if ((i & 2) != 0) {
                loadingPlaceholder = loading.placeholder;
            }
            return loading.copy(fileModel, loadingPlaceholder);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FileModel getFileModel() {
            return this.fileModel;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final LoadingPlaceholder getPlaceholder() {
            return this.placeholder;
        }

        public final Loading copy(FileModel fileModel, LoadingPlaceholder placeholder) {
            Intrinsics.checkNotNullParameter(fileModel, "fileModel");
            Intrinsics.checkNotNullParameter(placeholder, "placeholder");
            return new Loading(fileModel, placeholder);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Loading)) {
                return false;
            }
            Loading loading = (Loading) other;
            return Intrinsics.areEqual(this.fileModel, loading.fileModel) && Intrinsics.areEqual(this.placeholder, loading.placeholder);
        }

        public int hashCode() {
            return (this.fileModel.hashCode() * 31) + this.placeholder.hashCode();
        }

        public String toString() {
            return "Loading(fileModel=" + this.fileModel + ", placeholder=" + this.placeholder + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Loading(FileModel fileModel, LoadingPlaceholder placeholder) {
            super(fileModel, null);
            Intrinsics.checkNotNullParameter(fileModel, "fileModel");
            Intrinsics.checkNotNullParameter(placeholder, "placeholder");
            this.fileModel = fileModel;
            this.placeholder = placeholder;
        }

        @Override // com.box.android.preview.item.ItemState
        public FileModel getFileModel() {
            return this.fileModel;
        }

        public final LoadingPlaceholder getPlaceholder() {
            return this.placeholder;
        }
    }

    /* JADX INFO: compiled from: ItemState.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/box/android/preview/item/ItemState$Error;", "Lcom/box/android/preview/item/ItemState;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/item/FileModel;Lcom/box/android/domain/models/DomainError;)V", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Error extends ItemState {
        public static final int $stable = 8;
        private final DomainError error;
        private final FileModel fileModel;

        public static /* synthetic */ Error copy$default(Error error, FileModel fileModel, DomainError domainError, int i, Object obj) {
            if ((i & 1) != 0) {
                fileModel = error.fileModel;
            }
            if ((i & 2) != 0) {
                domainError = error.error;
            }
            return error.copy(fileModel, domainError);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FileModel getFileModel() {
            return this.fileModel;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final DomainError getError() {
            return this.error;
        }

        public final Error copy(FileModel fileModel, DomainError error) {
            Intrinsics.checkNotNullParameter(fileModel, "fileModel");
            Intrinsics.checkNotNullParameter(error, "error");
            return new Error(fileModel, error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Error)) {
                return false;
            }
            Error error = (Error) other;
            return Intrinsics.areEqual(this.fileModel, error.fileModel) && Intrinsics.areEqual(this.error, error.error);
        }

        public int hashCode() {
            return (this.fileModel.hashCode() * 31) + this.error.hashCode();
        }

        public String toString() {
            return "Error(fileModel=" + this.fileModel + ", error=" + this.error + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(FileModel fileModel, DomainError error) {
            super(fileModel, null);
            Intrinsics.checkNotNullParameter(fileModel, "fileModel");
            Intrinsics.checkNotNullParameter(error, "error");
            this.fileModel = fileModel;
            this.error = error;
        }

        public final DomainError getError() {
            return this.error;
        }

        @Override // com.box.android.preview.item.ItemState
        public FileModel getFileModel() {
            return this.fileModel;
        }
    }

    /* JADX INFO: compiled from: ItemState.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/item/ItemState$Document;", "Lcom/box/android/preview/item/ItemState;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$State;", "state", "<init>", "(Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$State;)V", "getState", "()Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$State;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Document extends ItemState implements Embedded<DocumentPreviewReducer.State> {
        public static final int $stable = 8;
        private final DocumentPreviewReducer.State state;

        public static /* synthetic */ Document copy$default(Document document, DocumentPreviewReducer.State state, int i, Object obj) {
            if ((i & 1) != 0) {
                state = document.state;
            }
            return document.copy(state);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.box.android.cpl.Embedded
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final DocumentPreviewReducer.State getAction() {
            return this.state;
        }

        public final Document copy(DocumentPreviewReducer.State state) {
            Intrinsics.checkNotNullParameter(state, "state");
            return new Document(state);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Document) && Intrinsics.areEqual(this.state, ((Document) other).state);
        }

        public int hashCode() {
            return this.state.hashCode();
        }

        public String toString() {
            return "Document(state=" + this.state + ")";
        }

        public final DocumentPreviewReducer.State getState() {
            return this.state;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Document(DocumentPreviewReducer.State state) {
            super(state.getFile(), null);
            Intrinsics.checkNotNullParameter(state, "state");
            this.state = state;
        }
    }

    /* JADX INFO: compiled from: ItemState.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/item/ItemState$Image;", "Lcom/box/android/preview/item/ItemState;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$State;", "state", "<init>", "(Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$State;)V", "getState", "()Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$State;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Image extends ItemState implements Embedded<ImagePreviewReducer.State> {
        public static final int $stable = 8;
        private final ImagePreviewReducer.State state;

        public static /* synthetic */ Image copy$default(Image image, ImagePreviewReducer.State state, int i, Object obj) {
            if ((i & 1) != 0) {
                state = image.state;
            }
            return image.copy(state);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.box.android.cpl.Embedded
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ImagePreviewReducer.State getAction() {
            return this.state;
        }

        public final Image copy(ImagePreviewReducer.State state) {
            Intrinsics.checkNotNullParameter(state, "state");
            return new Image(state);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Image) && Intrinsics.areEqual(this.state, ((Image) other).state);
        }

        public int hashCode() {
            return this.state.hashCode();
        }

        public String toString() {
            return "Image(state=" + this.state + ")";
        }

        public final ImagePreviewReducer.State getState() {
            return this.state;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Image(ImagePreviewReducer.State state) {
            super(state.getFile(), null);
            Intrinsics.checkNotNullParameter(state, "state");
            this.state = state;
        }
    }

    /* JADX INFO: compiled from: ItemState.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/item/ItemState$Gif;", "Lcom/box/android/preview/item/ItemState;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/previewtype/gif/GifPreviewReducer$State;", "state", "<init>", "(Lcom/box/android/preview/previewtype/gif/GifPreviewReducer$State;)V", "getState", "()Lcom/box/android/preview/previewtype/gif/GifPreviewReducer$State;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Gif extends ItemState implements Embedded<GifPreviewReducer.State> {
        public static final int $stable = 8;
        private final GifPreviewReducer.State state;

        public static /* synthetic */ Gif copy$default(Gif gif, GifPreviewReducer.State state, int i, Object obj) {
            if ((i & 1) != 0) {
                state = gif.state;
            }
            return gif.copy(state);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.box.android.cpl.Embedded
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final GifPreviewReducer.State getAction() {
            return this.state;
        }

        public final Gif copy(GifPreviewReducer.State state) {
            Intrinsics.checkNotNullParameter(state, "state");
            return new Gif(state);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Gif) && Intrinsics.areEqual(this.state, ((Gif) other).state);
        }

        public int hashCode() {
            return this.state.hashCode();
        }

        public String toString() {
            return "Gif(state=" + this.state + ")";
        }

        public final GifPreviewReducer.State getState() {
            return this.state;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Gif(GifPreviewReducer.State state) {
            super(state.getFileModel(), null);
            Intrinsics.checkNotNullParameter(state, "state");
            this.state = state;
        }
    }

    /* JADX INFO: compiled from: ItemState.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/item/ItemState$Video;", "Lcom/box/android/preview/item/ItemState;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$State;", "state", "<init>", "(Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$State;)V", "getState", "()Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$State;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Video extends ItemState implements Embedded<VideoPreviewReducer.State> {
        public static final int $stable = 8;
        private final VideoPreviewReducer.State state;

        public static /* synthetic */ Video copy$default(Video video, VideoPreviewReducer.State state, int i, Object obj) {
            if ((i & 1) != 0) {
                state = video.state;
            }
            return video.copy(state);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.box.android.cpl.Embedded
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final VideoPreviewReducer.State getAction() {
            return this.state;
        }

        public final Video copy(VideoPreviewReducer.State state) {
            Intrinsics.checkNotNullParameter(state, "state");
            return new Video(state);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Video) && Intrinsics.areEqual(this.state, ((Video) other).state);
        }

        public int hashCode() {
            return this.state.hashCode();
        }

        public String toString() {
            return "Video(state=" + this.state + ")";
        }

        public final VideoPreviewReducer.State getState() {
            return this.state;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Video(VideoPreviewReducer.State state) {
            super(state.getFile(), null);
            Intrinsics.checkNotNullParameter(state, "state");
            this.state = state;
        }
    }

    /* JADX INFO: compiled from: ItemState.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/item/ItemState$Code;", "Lcom/box/android/preview/item/ItemState;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/previewtype/code/CodePreviewReducer$State;", "state", "<init>", "(Lcom/box/android/preview/previewtype/code/CodePreviewReducer$State;)V", "getState", "()Lcom/box/android/preview/previewtype/code/CodePreviewReducer$State;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Code extends ItemState implements Embedded<CodePreviewReducer.State> {
        public static final int $stable = 8;
        private final CodePreviewReducer.State state;

        public static /* synthetic */ Code copy$default(Code code, CodePreviewReducer.State state, int i, Object obj) {
            if ((i & 1) != 0) {
                state = code.state;
            }
            return code.copy(state);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.box.android.cpl.Embedded
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CodePreviewReducer.State getAction() {
            return this.state;
        }

        public final Code copy(CodePreviewReducer.State state) {
            Intrinsics.checkNotNullParameter(state, "state");
            return new Code(state);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Code) && Intrinsics.areEqual(this.state, ((Code) other).state);
        }

        public int hashCode() {
            return this.state.hashCode();
        }

        public String toString() {
            return "Code(state=" + this.state + ")";
        }

        public final CodePreviewReducer.State getState() {
            return this.state;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Code(CodePreviewReducer.State state) {
            super(state.getFile(), null);
            Intrinsics.checkNotNullParameter(state, "state");
            this.state = state;
        }
    }

    /* JADX INFO: compiled from: ItemState.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/item/ItemState$Audio;", "Lcom/box/android/preview/item/ItemState;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$State;", "state", "<init>", "(Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$State;)V", "getState", "()Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$State;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Audio extends ItemState implements Embedded<AudioPreviewReducer.State> {
        public static final int $stable = 8;
        private final AudioPreviewReducer.State state;

        public static /* synthetic */ Audio copy$default(Audio audio, AudioPreviewReducer.State state, int i, Object obj) {
            if ((i & 1) != 0) {
                state = audio.state;
            }
            return audio.copy(state);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.box.android.cpl.Embedded
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final AudioPreviewReducer.State getAction() {
            return this.state;
        }

        public final Audio copy(AudioPreviewReducer.State state) {
            Intrinsics.checkNotNullParameter(state, "state");
            return new Audio(state);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Audio) && Intrinsics.areEqual(this.state, ((Audio) other).state);
        }

        public int hashCode() {
            return this.state.hashCode();
        }

        public String toString() {
            return "Audio(state=" + this.state + ")";
        }

        public final AudioPreviewReducer.State getState() {
            return this.state;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Audio(AudioPreviewReducer.State state) {
            super(state.getFileModel(), null);
            Intrinsics.checkNotNullParameter(state, "state");
            this.state = state;
        }
    }

    /* JADX INFO: compiled from: ItemState.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/item/ItemState$BoxNote;", "Lcom/box/android/preview/item/ItemState;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$State;", "state", "<init>", "(Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$State;)V", "getState", "()Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$State;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class BoxNote extends ItemState implements Embedded<BoxNotePreviewReducer.State> {
        public static final int $stable = 8;
        private final BoxNotePreviewReducer.State state;

        public static /* synthetic */ BoxNote copy$default(BoxNote boxNote, BoxNotePreviewReducer.State state, int i, Object obj) {
            if ((i & 1) != 0) {
                state = boxNote.state;
            }
            return boxNote.copy(state);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.box.android.cpl.Embedded
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final BoxNotePreviewReducer.State getAction() {
            return this.state;
        }

        public final BoxNote copy(BoxNotePreviewReducer.State state) {
            Intrinsics.checkNotNullParameter(state, "state");
            return new BoxNote(state);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof BoxNote) && Intrinsics.areEqual(this.state, ((BoxNote) other).state);
        }

        public int hashCode() {
            return this.state.hashCode();
        }

        public String toString() {
            return "BoxNote(state=" + this.state + ")";
        }

        public final BoxNotePreviewReducer.State getState() {
            return this.state;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BoxNote(BoxNotePreviewReducer.State state) {
            super(state.getFileModel(), null);
            Intrinsics.checkNotNullParameter(state, "state");
            this.state = state;
        }
    }

    public final boolean previewContentLoaded() {
        return ((this instanceof Uninitialized) || (this instanceof Loading) || (this instanceof Error)) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final LoadingPlaceholder getLoadingPlaceholder() {
        if (this instanceof Loading) {
            return ((Loading) this).getPlaceholder();
        }
        if (this instanceof Document) {
            return ((Document) this).getState().getLoadingPlaceholder();
        }
        if (this instanceof Image) {
            return ((Image) this).getState().getLoadingPlaceholder();
        }
        if (this instanceof Gif) {
            return ((Gif) this).getState().getLoadingPlaceholder();
        }
        if (this instanceof Video) {
            return ((Video) this).getState().getLoadingPlaceholder();
        }
        Bitmap bitmap = null;
        Object[] objArr = 0;
        if (this instanceof BoxNote) {
            if (((BoxNote) this).getState().getIsLoading()) {
                return new LoadingPlaceholder(FileTypeIcon.BOXNOTE, bitmap, 2, objArr == true ? 1 : 0);
            }
            return null;
        }
        if ((this instanceof Uninitialized) || (this instanceof Error) || (this instanceof Audio) || (this instanceof Code)) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final ItemState withLoadingPlaceholder(LoadingPlaceholder loadingPlaceholder) {
        Intrinsics.checkNotNullParameter(loadingPlaceholder, "loadingPlaceholder");
        if (this instanceof Loading) {
            return Loading.copy$default((Loading) this, null, loadingPlaceholder, 1, null);
        }
        if (this instanceof Document) {
            return new Document(DocumentPreviewReducer.State.copy$default(((Document) this).getState(), null, null, loadingPlaceholder, null, null, null, 0, 0, null, null, null, null, null, null, 16379, null));
        }
        if (this instanceof Image) {
            return new Image(ImagePreviewReducer.State.copy$default(((Image) this).getState(), null, null, loadingPlaceholder, null, null, 27, null));
        }
        if (this instanceof Gif) {
            return new Gif(GifPreviewReducer.State.copy$default(((Gif) this).getState(), null, null, loadingPlaceholder, 3, null));
        }
        return this instanceof Video ? new Video(VideoPreviewReducer.State.copy$default(((Video) this).getState(), null, null, 0L, loadingPlaceholder, null, 23, null)) : this;
    }
}
