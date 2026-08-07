package com.box.android.notes.presentation.cpl;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.ItemId;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotesItemViewData.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\fHÆ\u0003JQ\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010!\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0015R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lcom/box/android/notes/presentation/cpl/NotesItemViewData;", "", "id", "Lcom/box/android/domain/models/ItemId$Remote;", "title", "", "lastEditInfo", "parentFolderName", "isFavorite", "", "canFavorite", "readStatus", "Lcom/box/android/notes/presentation/cpl/NoteReadStatus;", "<init>", "(Lcom/box/android/domain/models/ItemId$Remote;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/box/android/notes/presentation/cpl/NoteReadStatus;)V", "getId", "()Lcom/box/android/domain/models/ItemId$Remote;", "getTitle", "()Ljava/lang/String;", "getLastEditInfo", "getParentFolderName", "()Z", "getCanFavorite", "getReadStatus", "()Lcom/box/android/notes/presentation/cpl/NoteReadStatus;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "notes_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class NotesItemViewData {
    public static final int $stable = 8;
    private final boolean canFavorite;
    private final ItemId.Remote id;
    private final boolean isFavorite;
    private final String lastEditInfo;
    private final String parentFolderName;
    private final NoteReadStatus readStatus;
    private final String title;

    public static /* synthetic */ NotesItemViewData copy$default(NotesItemViewData notesItemViewData, ItemId.Remote remote, String str, String str2, String str3, boolean z, boolean z2, NoteReadStatus noteReadStatus, int i, Object obj) {
        if ((i & 1) != 0) {
            remote = notesItemViewData.id;
        }
        if ((i & 2) != 0) {
            str = notesItemViewData.title;
        }
        if ((i & 4) != 0) {
            str2 = notesItemViewData.lastEditInfo;
        }
        if ((i & 8) != 0) {
            str3 = notesItemViewData.parentFolderName;
        }
        if ((i & 16) != 0) {
            z = notesItemViewData.isFavorite;
        }
        if ((i & 32) != 0) {
            z2 = notesItemViewData.canFavorite;
        }
        if ((i & 64) != 0) {
            noteReadStatus = notesItemViewData.readStatus;
        }
        boolean z3 = z2;
        NoteReadStatus noteReadStatus2 = noteReadStatus;
        boolean z4 = z;
        String str4 = str2;
        return notesItemViewData.copy(remote, str, str4, str3, z4, z3, noteReadStatus2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ItemId.Remote getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLastEditInfo() {
        return this.lastEditInfo;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getParentFolderName() {
        return this.parentFolderName;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsFavorite() {
        return this.isFavorite;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getCanFavorite() {
        return this.canFavorite;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final NoteReadStatus getReadStatus() {
        return this.readStatus;
    }

    public final NotesItemViewData copy(ItemId.Remote id, String title, String lastEditInfo, String parentFolderName, boolean isFavorite, boolean canFavorite, NoteReadStatus readStatus) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(parentFolderName, "parentFolderName");
        Intrinsics.checkNotNullParameter(readStatus, "readStatus");
        return new NotesItemViewData(id, title, lastEditInfo, parentFolderName, isFavorite, canFavorite, readStatus);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotesItemViewData)) {
            return false;
        }
        NotesItemViewData notesItemViewData = (NotesItemViewData) other;
        return Intrinsics.areEqual(this.id, notesItemViewData.id) && Intrinsics.areEqual(this.title, notesItemViewData.title) && Intrinsics.areEqual(this.lastEditInfo, notesItemViewData.lastEditInfo) && Intrinsics.areEqual(this.parentFolderName, notesItemViewData.parentFolderName) && this.isFavorite == notesItemViewData.isFavorite && this.canFavorite == notesItemViewData.canFavorite && this.readStatus == notesItemViewData.readStatus;
    }

    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.title.hashCode()) * 31;
        String str = this.lastEditInfo;
        return ((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.parentFolderName.hashCode()) * 31) + Boolean.hashCode(this.isFavorite)) * 31) + Boolean.hashCode(this.canFavorite)) * 31) + this.readStatus.hashCode();
    }

    public String toString() {
        return "NotesItemViewData(id=" + this.id + ", title=" + this.title + ", lastEditInfo=" + this.lastEditInfo + ", parentFolderName=" + this.parentFolderName + ", isFavorite=" + this.isFavorite + ", canFavorite=" + this.canFavorite + ", readStatus=" + this.readStatus + ")";
    }

    public NotesItemViewData(ItemId.Remote id, String title, String str, String parentFolderName, boolean z, boolean z2, NoteReadStatus readStatus) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(parentFolderName, "parentFolderName");
        Intrinsics.checkNotNullParameter(readStatus, "readStatus");
        this.id = id;
        this.title = title;
        this.lastEditInfo = str;
        this.parentFolderName = parentFolderName;
        this.isFavorite = z;
        this.canFavorite = z2;
        this.readStatus = readStatus;
    }

    public final ItemId.Remote getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getLastEditInfo() {
        return this.lastEditInfo;
    }

    public final String getParentFolderName() {
        return this.parentFolderName;
    }

    public final boolean isFavorite() {
        return this.isFavorite;
    }

    public final boolean getCanFavorite() {
        return this.canFavorite;
    }

    public /* synthetic */ NotesItemViewData(ItemId.Remote remote, String str, String str2, String str3, boolean z, boolean z2, NoteReadStatus noteReadStatus, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(remote, str, str2, str3, z, z2, (i & 64) != 0 ? NoteReadStatus.READ : noteReadStatus);
    }

    public final NoteReadStatus getReadStatus() {
        return this.readStatus;
    }
}
