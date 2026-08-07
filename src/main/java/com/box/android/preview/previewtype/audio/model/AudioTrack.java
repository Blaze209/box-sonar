package com.box.android.preview.previewtype.audio.model;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.item.FileModel;
import java.net.URI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AudioTrack.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/preview/previewtype/audio/model/AudioTrack;", "", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "uri", "Ljava/net/URI;", "<init>", "(Lcom/box/android/domain/models/item/FileModel;Ljava/net/URI;)V", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "getUri", "()Ljava/net/URI;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AudioTrack {
    public static final int $stable = 8;
    private final FileModel fileModel;
    private final URI uri;

    public static /* synthetic */ AudioTrack copy$default(AudioTrack audioTrack, FileModel fileModel, URI uri, int i, Object obj) {
        if ((i & 1) != 0) {
            fileModel = audioTrack.fileModel;
        }
        if ((i & 2) != 0) {
            uri = audioTrack.uri;
        }
        return audioTrack.copy(fileModel, uri);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final FileModel getFileModel() {
        return this.fileModel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final URI getUri() {
        return this.uri;
    }

    public final AudioTrack copy(FileModel fileModel, URI uri) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        Intrinsics.checkNotNullParameter(uri, "uri");
        return new AudioTrack(fileModel, uri);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AudioTrack)) {
            return false;
        }
        AudioTrack audioTrack = (AudioTrack) other;
        return Intrinsics.areEqual(this.fileModel, audioTrack.fileModel) && Intrinsics.areEqual(this.uri, audioTrack.uri);
    }

    public int hashCode() {
        return (this.fileModel.hashCode() * 31) + this.uri.hashCode();
    }

    public String toString() {
        return "AudioTrack(fileModel=" + this.fileModel + ", uri=" + this.uri + ")";
    }

    public AudioTrack(FileModel fileModel, URI uri) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.fileModel = fileModel;
        this.uri = uri;
    }

    public final FileModel getFileModel() {
        return this.fileModel;
    }

    public final URI getUri() {
        return this.uri;
    }
}
