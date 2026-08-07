package com.box.android.domain.services;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.item.FileModel;
import java.net.URI;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IAudioPlaylistItemsService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\b\tB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/domain/services/AudioItem;", "", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "<init>", "(Lcom/box/android/domain/models/item/FileModel;)V", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "Playable", "Disabled", "Lcom/box/android/domain/services/AudioItem$Disabled;", "Lcom/box/android/domain/services/AudioItem$Playable;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class AudioItem {
    private final FileModel fileModel;

    public /* synthetic */ AudioItem(FileModel fileModel, DefaultConstructorMarker defaultConstructorMarker) {
        this(fileModel);
    }

    /* JADX INFO: compiled from: IAudioPlaylistItemsService.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/services/AudioItem$Playable;", "Lcom/box/android/domain/services/AudioItem;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "uri", "Ljava/net/URI;", "<init>", "(Lcom/box/android/domain/models/item/FileModel;Ljava/net/URI;)V", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "getUri", "()Ljava/net/URI;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Playable extends AudioItem {
        private final FileModel fileModel;
        private final URI uri;

        public static /* synthetic */ Playable copy$default(Playable playable, FileModel fileModel, URI uri, int i, Object obj) {
            if ((i & 1) != 0) {
                fileModel = playable.fileModel;
            }
            if ((i & 2) != 0) {
                uri = playable.uri;
            }
            return playable.copy(fileModel, uri);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FileModel getFileModel() {
            return this.fileModel;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final URI getUri() {
            return this.uri;
        }

        public final Playable copy(FileModel fileModel, URI uri) {
            Intrinsics.checkNotNullParameter(fileModel, "fileModel");
            Intrinsics.checkNotNullParameter(uri, "uri");
            return new Playable(fileModel, uri);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Playable)) {
                return false;
            }
            Playable playable = (Playable) other;
            return Intrinsics.areEqual(this.fileModel, playable.fileModel) && Intrinsics.areEqual(this.uri, playable.uri);
        }

        public int hashCode() {
            return (this.fileModel.hashCode() * 31) + this.uri.hashCode();
        }

        public String toString() {
            return "Playable(fileModel=" + this.fileModel + ", uri=" + this.uri + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Playable(FileModel fileModel, URI uri) {
            super(fileModel, null);
            Intrinsics.checkNotNullParameter(fileModel, "fileModel");
            Intrinsics.checkNotNullParameter(uri, "uri");
            this.fileModel = fileModel;
            this.uri = uri;
        }

        @Override // com.box.android.domain.services.AudioItem
        public FileModel getFileModel() {
            return this.fileModel;
        }

        public final URI getUri() {
            return this.uri;
        }
    }

    private AudioItem(FileModel fileModel) {
        this.fileModel = fileModel;
    }

    public FileModel getFileModel() {
        return this.fileModel;
    }

    /* JADX INFO: compiled from: IAudioPlaylistItemsService.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/domain/services/AudioItem$Disabled;", "Lcom/box/android/domain/services/AudioItem;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "<init>", "(Lcom/box/android/domain/models/item/FileModel;)V", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Disabled extends AudioItem {
        private final FileModel fileModel;

        public static /* synthetic */ Disabled copy$default(Disabled disabled, FileModel fileModel, int i, Object obj) {
            if ((i & 1) != 0) {
                fileModel = disabled.fileModel;
            }
            return disabled.copy(fileModel);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FileModel getFileModel() {
            return this.fileModel;
        }

        public final Disabled copy(FileModel fileModel) {
            Intrinsics.checkNotNullParameter(fileModel, "fileModel");
            return new Disabled(fileModel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Disabled) && Intrinsics.areEqual(this.fileModel, ((Disabled) other).fileModel);
        }

        public int hashCode() {
            return this.fileModel.hashCode();
        }

        public String toString() {
            return "Disabled(fileModel=" + this.fileModel + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Disabled(FileModel fileModel) {
            super(fileModel, null);
            Intrinsics.checkNotNullParameter(fileModel, "fileModel");
            this.fileModel = fileModel;
        }

        @Override // com.box.android.domain.services.AudioItem
        public FileModel getFileModel() {
            return this.fileModel;
        }
    }
}
