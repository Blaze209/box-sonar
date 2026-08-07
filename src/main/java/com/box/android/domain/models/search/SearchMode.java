package com.box.android.domain.models.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.item.FolderModel;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchMode.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u000b2\u00020\u0001:\u0004\b\t\n\u000bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0003\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/box/android/domain/models/search/SearchMode;", "Landroid/os/Parcelable;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "Files", "Hubs", "Notes", "Companion", "Lcom/box/android/domain/models/search/SearchMode$Files;", "Lcom/box/android/domain/models/search/SearchMode$Hubs;", "Lcom/box/android/domain/models/search/SearchMode$Notes;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class SearchMode implements Parcelable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ SearchMode(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private SearchMode() {
    }

    /* JADX INFO: compiled from: SearchMode.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/box/android/domain/models/search/SearchMode$Files;", "Lcom/box/android/domain/models/search/SearchMode;", "parentFolder", "Lcom/box/android/domain/models/item/FolderModel;", "<init>", "(Lcom/box/android/domain/models/item/FolderModel;)V", "getParentFolder", "()Lcom/box/android/domain/models/item/FolderModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Files extends SearchMode {
        public static final Parcelable.Creator<Files> CREATOR = new Creator();
        private final FolderModel parentFolder;

        /* JADX INFO: compiled from: SearchMode.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Files> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Files createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Files(FolderModel.CREATOR.createFromParcel(parcel));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Files[] newArray(int i) {
                return new Files[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Files() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Files copy$default(Files files, FolderModel folderModel, int i, Object obj) {
            if ((i & 1) != 0) {
                folderModel = files.parentFolder;
            }
            return files.copy(folderModel);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FolderModel getParentFolder() {
            return this.parentFolder;
        }

        public final Files copy(FolderModel parentFolder) {
            Intrinsics.checkNotNullParameter(parentFolder, "parentFolder");
            return new Files(parentFolder);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Files) && Intrinsics.areEqual(this.parentFolder, ((Files) other).parentFolder);
        }

        public int hashCode() {
            return this.parentFolder.hashCode();
        }

        public String toString() {
            return "Files(parentFolder=" + this.parentFolder + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            this.parentFolder.writeToParcel(dest, flags);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Files(FolderModel parentFolder) {
            super(null);
            Intrinsics.checkNotNullParameter(parentFolder, "parentFolder");
            this.parentFolder = parentFolder;
        }

        public /* synthetic */ Files(FolderModel folderModel, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? FolderModel.Companion.createFromId$default(FolderModel.INSTANCE, "0", null, 2, null) : folderModel);
        }

        public final FolderModel getParentFolder() {
            return this.parentFolder;
        }
    }

    /* JADX INFO: compiled from: SearchMode.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tHÖ\u0003J\t\u0010\n\u001a\u00020\u0005HÖ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005¨\u0006\u0012"}, d2 = {"Lcom/box/android/domain/models/search/SearchMode$Hubs;", "Lcom/box/android/domain/models/search/SearchMode;", "<init>", "()V", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Hubs extends SearchMode {
        public static final Hubs INSTANCE = new Hubs();
        public static final Parcelable.Creator<Hubs> CREATOR = new Creator();

        /* JADX INFO: compiled from: SearchMode.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Hubs> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Hubs createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return Hubs.INSTANCE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Hubs[] newArray(int i) {
                return new Hubs[i];
            }
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Hubs)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1204333316;
        }

        public String toString() {
            return "Hubs";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeInt(1);
        }

        private Hubs() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: SearchMode.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tHÖ\u0003J\t\u0010\n\u001a\u00020\u0005HÖ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005¨\u0006\u0012"}, d2 = {"Lcom/box/android/domain/models/search/SearchMode$Notes;", "Lcom/box/android/domain/models/search/SearchMode;", "<init>", "()V", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Notes extends SearchMode {
        public static final Notes INSTANCE = new Notes();
        public static final Parcelable.Creator<Notes> CREATOR = new Creator();

        /* JADX INFO: compiled from: SearchMode.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Notes> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Notes createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return Notes.INSTANCE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Notes[] newArray(int i) {
                return new Notes[i];
            }
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Notes)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1314993509;
        }

        public String toString() {
            return "Notes";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeInt(1);
        }

        private Notes() {
            super(null);
        }
    }

    public final String getName() {
        if (this instanceof Files) {
            return "FILES";
        }
        if (Intrinsics.areEqual(this, Hubs.INSTANCE)) {
            return "HUBS";
        }
        if (Intrinsics.areEqual(this, Notes.INSTANCE)) {
            return "NOTES";
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: compiled from: SearchMode.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/domain/models/search/SearchMode$Companion;", "", "<init>", "()V", "fromName", "Lcom/box/android/domain/models/search/SearchMode;", "name", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final SearchMode fromName(String name) {
            String upperCase;
            FolderModel folderModel = null;
            Object[] objArr = 0;
            if (name != null) {
                upperCase = name.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            } else {
                upperCase = null;
            }
            if (Intrinsics.areEqual(upperCase, "HUBS")) {
                return Hubs.INSTANCE;
            }
            if (Intrinsics.areEqual(upperCase, "NOTES")) {
                return Notes.INSTANCE;
            }
            return new Files(folderModel, 1, objArr == true ? 1 : 0);
        }
    }
}
