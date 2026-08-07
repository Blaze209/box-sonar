package com.box.android.domain.models.search;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.item.FileModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchResult.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/domain/models/search/NoteSearchItem;", "", "file", "Lcom/box/android/domain/models/item/FileModel;", "accessibleSharedLink", "", "<init>", "(Lcom/box/android/domain/models/item/FileModel;Ljava/lang/String;)V", "getFile", "()Lcom/box/android/domain/models/item/FileModel;", "getAccessibleSharedLink", "()Ljava/lang/String;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class NoteSearchItem {
    private final String accessibleSharedLink;
    private final FileModel file;

    public static /* synthetic */ NoteSearchItem copy$default(NoteSearchItem noteSearchItem, FileModel fileModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            fileModel = noteSearchItem.file;
        }
        if ((i & 2) != 0) {
            str = noteSearchItem.accessibleSharedLink;
        }
        return noteSearchItem.copy(fileModel, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final FileModel getFile() {
        return this.file;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAccessibleSharedLink() {
        return this.accessibleSharedLink;
    }

    public final NoteSearchItem copy(FileModel file, String accessibleSharedLink) {
        Intrinsics.checkNotNullParameter(file, "file");
        return new NoteSearchItem(file, accessibleSharedLink);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NoteSearchItem)) {
            return false;
        }
        NoteSearchItem noteSearchItem = (NoteSearchItem) other;
        return Intrinsics.areEqual(this.file, noteSearchItem.file) && Intrinsics.areEqual(this.accessibleSharedLink, noteSearchItem.accessibleSharedLink);
    }

    public int hashCode() {
        int iHashCode = this.file.hashCode() * 31;
        String str = this.accessibleSharedLink;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "NoteSearchItem(file=" + this.file + ", accessibleSharedLink=" + this.accessibleSharedLink + ")";
    }

    public NoteSearchItem(FileModel file, String str) {
        Intrinsics.checkNotNullParameter(file, "file");
        this.file = file;
        this.accessibleSharedLink = str;
    }

    public /* synthetic */ NoteSearchItem(FileModel fileModel, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fileModel, (i & 2) != 0 ? null : str);
    }

    public final String getAccessibleSharedLink() {
        return this.accessibleSharedLink;
    }

    public final FileModel getFile() {
        return this.file;
    }
}
