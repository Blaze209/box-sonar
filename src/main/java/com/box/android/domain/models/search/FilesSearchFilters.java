package com.box.android.domain.models.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.utils.SupportedFileExtensions;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FilesSearchFilters.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001:\u0004$%&'B+\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0011\u001a\u00020\u0012J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J-\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0006\u0010\u0017\u001a\u00020\u0018J\u0013\u0010\u0019\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0018R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006("}, d2 = {"Lcom/box/android/domain/models/search/FilesSearchFilters;", "Landroid/os/Parcelable;", "itemTypes", "", "Lcom/box/android/domain/models/search/FilesSearchFilters$FilterItemType;", "modifiedDate", "Lcom/box/android/domain/models/search/FilesSearchFilters$ModifiedAfterDate;", "size", "Lcom/box/android/domain/models/search/FilesSearchFilters$Size;", "<init>", "(Ljava/util/Set;Lcom/box/android/domain/models/search/FilesSearchFilters$ModifiedAfterDate;Lcom/box/android/domain/models/search/FilesSearchFilters$Size;)V", "getItemTypes", "()Ljava/util/Set;", "getModifiedDate", "()Lcom/box/android/domain/models/search/FilesSearchFilters$ModifiedAfterDate;", "getSize", "()Lcom/box/android/domain/models/search/FilesSearchFilters$Size;", "isAnyFilterApplied", "", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "FilterItemType", "ModifiedAfterDate", "Size", "FilterType", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FilesSearchFilters implements Parcelable {
    public static final Parcelable.Creator<FilesSearchFilters> CREATOR = new Creator();
    private final Set<FilterItemType> itemTypes;
    private final ModifiedAfterDate modifiedDate;
    private final Size size;

    /* JADX INFO: compiled from: FilesSearchFilters.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<FilesSearchFilters> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FilesSearchFilters createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i = parcel.readInt();
            LinkedHashSet linkedHashSet = new LinkedHashSet(i);
            for (int i2 = 0; i2 != i; i2++) {
                linkedHashSet.add(parcel.readParcelable(FilesSearchFilters.class.getClassLoader()));
            }
            return new FilesSearchFilters(linkedHashSet, (ModifiedAfterDate) parcel.readParcelable(FilesSearchFilters.class.getClassLoader()), (Size) parcel.readParcelable(FilesSearchFilters.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FilesSearchFilters[] newArray(int i) {
            return new FilesSearchFilters[i];
        }
    }

    /* JADX INFO: compiled from: FilesSearchFilters.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/domain/models/search/FilesSearchFilters$FilterType;", "", "<init>", "()V", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static class FilterType {
    }

    public FilesSearchFilters() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FilesSearchFilters copy$default(FilesSearchFilters filesSearchFilters, Set set, ModifiedAfterDate modifiedAfterDate, Size size, int i, Object obj) {
        if ((i & 1) != 0) {
            set = filesSearchFilters.itemTypes;
        }
        if ((i & 2) != 0) {
            modifiedAfterDate = filesSearchFilters.modifiedDate;
        }
        if ((i & 4) != 0) {
            size = filesSearchFilters.size;
        }
        return filesSearchFilters.copy(set, modifiedAfterDate, size);
    }

    public final Set<FilterItemType> component1() {
        return this.itemTypes;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ModifiedAfterDate getModifiedDate() {
        return this.modifiedDate;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Size getSize() {
        return this.size;
    }

    public final FilesSearchFilters copy(Set<? extends FilterItemType> itemTypes, ModifiedAfterDate modifiedDate, Size size) {
        Intrinsics.checkNotNullParameter(itemTypes, "itemTypes");
        Intrinsics.checkNotNullParameter(modifiedDate, "modifiedDate");
        Intrinsics.checkNotNullParameter(size, "size");
        return new FilesSearchFilters(itemTypes, modifiedDate, size);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FilesSearchFilters)) {
            return false;
        }
        FilesSearchFilters filesSearchFilters = (FilesSearchFilters) other;
        return Intrinsics.areEqual(this.itemTypes, filesSearchFilters.itemTypes) && Intrinsics.areEqual(this.modifiedDate, filesSearchFilters.modifiedDate) && Intrinsics.areEqual(this.size, filesSearchFilters.size);
    }

    public int hashCode() {
        return (((this.itemTypes.hashCode() * 31) + this.modifiedDate.hashCode()) * 31) + this.size.hashCode();
    }

    public String toString() {
        return "FilesSearchFilters(itemTypes=" + this.itemTypes + ", modifiedDate=" + this.modifiedDate + ", size=" + this.size + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        Set<FilterItemType> set = this.itemTypes;
        dest.writeInt(set.size());
        Iterator<FilterItemType> it = set.iterator();
        while (it.hasNext()) {
            dest.writeParcelable(it.next(), flags);
        }
        dest.writeParcelable(this.modifiedDate, flags);
        dest.writeParcelable(this.size, flags);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FilesSearchFilters(Set<? extends FilterItemType> itemTypes, ModifiedAfterDate modifiedDate, Size size) {
        Intrinsics.checkNotNullParameter(itemTypes, "itemTypes");
        Intrinsics.checkNotNullParameter(modifiedDate, "modifiedDate");
        Intrinsics.checkNotNullParameter(size, "size");
        this.itemTypes = itemTypes;
        this.modifiedDate = modifiedDate;
        this.size = size;
    }

    public /* synthetic */ FilesSearchFilters(Set set, ModifiedAfterDate.Any any, Size.Any any2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SetsKt.emptySet() : set, (i & 2) != 0 ? ModifiedAfterDate.Any.INSTANCE : any, (i & 4) != 0 ? Size.Any.INSTANCE : any2);
    }

    public final Set<FilterItemType> getItemTypes() {
        return this.itemTypes;
    }

    public final ModifiedAfterDate getModifiedDate() {
        return this.modifiedDate;
    }

    public final Size getSize() {
        return this.size;
    }

    public final boolean isAnyFilterApplied() {
        return (this.itemTypes.isEmpty() && Intrinsics.areEqual(this.modifiedDate, ModifiedAfterDate.Any.INSTANCE) && Intrinsics.areEqual(this.size, Size.Any.INSTANCE)) ? false : true;
    }

    /* JADX INFO: compiled from: FilesSearchFilters.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lcom/box/android/domain/models/search/FilesSearchFilters$FilterItemType;", "Lcom/box/android/domain/models/search/FilesSearchFilters$FilterType;", "Landroid/os/Parcelable;", "<init>", "()V", "Folder", "FileType", "Lcom/box/android/domain/models/search/FilesSearchFilters$FilterItemType$FileType;", "Lcom/box/android/domain/models/search/FilesSearchFilters$FilterItemType$Folder;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class FilterItemType extends FilterType implements Parcelable {
        public /* synthetic */ FilterItemType(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private FilterItemType() {
        }

        /* JADX INFO: compiled from: FilesSearchFilters.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005¨\u0006\u000b"}, d2 = {"Lcom/box/android/domain/models/search/FilesSearchFilters$FilterItemType$Folder;", "Lcom/box/android/domain/models/search/FilesSearchFilters$FilterItemType;", "<init>", "()V", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Folder extends FilterItemType {
            public static final Folder INSTANCE = new Folder();
            public static final Parcelable.Creator<Folder> CREATOR = new Creator();

            /* JADX INFO: compiled from: FilesSearchFilters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<Folder> {
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final Folder createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.readInt();
                    return Folder.INSTANCE;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final Folder[] newArray(int i) {
                    return new Folder[i];
                }
            }

            @Override // android.os.Parcelable
            public final int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel dest, int flags) {
                Intrinsics.checkNotNullParameter(dest, "dest");
                dest.writeInt(1);
            }

            private Folder() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FilesSearchFilters.kt */
        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\t\t\n\u000b\f\r\u000e\u000f\u0010\u0011B\u0017\b\u0004\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0082\u0001\t\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a¨\u0006\u001b"}, d2 = {"Lcom/box/android/domain/models/search/FilesSearchFilters$FilterItemType$FileType;", "Lcom/box/android/domain/models/search/FilesSearchFilters$FilterItemType;", "extensions", "", "", "<init>", "(Ljava/util/Set;)V", "getExtensions", "()Ljava/util/Set;", "Audio", "BoxNote", "Document", "Autocad", "Image", "Pdf", "Presentation", "Spreadsheet", "Video", "Lcom/box/android/domain/models/search/FilesSearchFilters$FilterItemType$FileType$Audio;", "Lcom/box/android/domain/models/search/FilesSearchFilters$FilterItemType$FileType$Autocad;", "Lcom/box/android/domain/models/search/FilesSearchFilters$FilterItemType$FileType$BoxNote;", "Lcom/box/android/domain/models/search/FilesSearchFilters$FilterItemType$FileType$Document;", "Lcom/box/android/domain/models/search/FilesSearchFilters$FilterItemType$FileType$Image;", "Lcom/box/android/domain/models/search/FilesSearchFilters$FilterItemType$FileType$Pdf;", "Lcom/box/android/domain/models/search/FilesSearchFilters$FilterItemType$FileType$Presentation;", "Lcom/box/android/domain/models/search/FilesSearchFilters$FilterItemType$FileType$Spreadsheet;", "Lcom/box/android/domain/models/search/FilesSearchFilters$FilterItemType$FileType$Video;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static abstract class FileType extends FilterItemType {
            private final Set<String> extensions;

            public /* synthetic */ FileType(Set set, DefaultConstructorMarker defaultConstructorMarker) {
                this(set);
            }

            private FileType(Set<String> set) {
                super(null);
                this.extensions = set;
            }

            /* JADX INFO: compiled from: FilesSearchFilters.kt */
            @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005¨\u0006\u000b"}, d2 = {"Lcom/box/android/domain/models/search/FilesSearchFilters$FilterItemType$FileType$Audio;", "Lcom/box/android/domain/models/search/FilesSearchFilters$FilterItemType$FileType;", "<init>", "()V", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
            public static final class Audio extends FileType {
                public static final Audio INSTANCE = new Audio();
                public static final Parcelable.Creator<Audio> CREATOR = new Creator();

                /* JADX INFO: compiled from: FilesSearchFilters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class Creator implements Parcelable.Creator<Audio> {
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // android.os.Parcelable.Creator
                    public final Audio createFromParcel(Parcel parcel) {
                        Intrinsics.checkNotNullParameter(parcel, "parcel");
                        parcel.readInt();
                        return Audio.INSTANCE;
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // android.os.Parcelable.Creator
                    public final Audio[] newArray(int i) {
                        return new Audio[i];
                    }
                }

                @Override // android.os.Parcelable
                public final int describeContents() {
                    return 0;
                }

                @Override // android.os.Parcelable
                public final void writeToParcel(Parcel dest, int flags) {
                    Intrinsics.checkNotNullParameter(dest, "dest");
                    dest.writeInt(1);
                }

                private Audio() {
                    super(SupportedFileExtensions.INSTANCE.getAUDIO_EXTENSIONS(), null);
                }
            }

            public final Set<String> getExtensions() {
                return this.extensions;
            }

            /* JADX INFO: compiled from: FilesSearchFilters.kt */
            @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005¨\u0006\u000b"}, d2 = {"Lcom/box/android/domain/models/search/FilesSearchFilters$FilterItemType$FileType$BoxNote;", "Lcom/box/android/domain/models/search/FilesSearchFilters$FilterItemType$FileType;", "<init>", "()V", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
            public static final class BoxNote extends FileType {
                public static final BoxNote INSTANCE = new BoxNote();
                public static final Parcelable.Creator<BoxNote> CREATOR = new Creator();

                /* JADX INFO: compiled from: FilesSearchFilters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class Creator implements Parcelable.Creator<BoxNote> {
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // android.os.Parcelable.Creator
                    public final BoxNote createFromParcel(Parcel parcel) {
                        Intrinsics.checkNotNullParameter(parcel, "parcel");
                        parcel.readInt();
                        return BoxNote.INSTANCE;
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // android.os.Parcelable.Creator
                    public final BoxNote[] newArray(int i) {
                        return new BoxNote[i];
                    }
                }

                @Override // android.os.Parcelable
                public final int describeContents() {
                    return 0;
                }

                @Override // android.os.Parcelable
                public final void writeToParcel(Parcel dest, int flags) {
                    Intrinsics.checkNotNullParameter(dest, "dest");
                    dest.writeInt(1);
                }

                private BoxNote() {
                    super(SetsKt.setOf("boxnote"), null);
                }
            }

            /* JADX INFO: compiled from: FilesSearchFilters.kt */
            @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005¨\u0006\u000b"}, d2 = {"Lcom/box/android/domain/models/search/FilesSearchFilters$FilterItemType$FileType$Document;", "Lcom/box/android/domain/models/search/FilesSearchFilters$FilterItemType$FileType;", "<init>", "()V", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
            public static final class Document extends FileType {
                public static final Document INSTANCE = new Document();
                public static final Parcelable.Creator<Document> CREATOR = new Creator();

                /* JADX INFO: compiled from: FilesSearchFilters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class Creator implements Parcelable.Creator<Document> {
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // android.os.Parcelable.Creator
                    public final Document createFromParcel(Parcel parcel) {
                        Intrinsics.checkNotNullParameter(parcel, "parcel");
                        parcel.readInt();
                        return Document.INSTANCE;
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // android.os.Parcelable.Creator
                    public final Document[] newArray(int i) {
                        return new Document[i];
                    }
                }

                @Override // android.os.Parcelable
                public final int describeContents() {
                    return 0;
                }

                @Override // android.os.Parcelable
                public final void writeToParcel(Parcel dest, int flags) {
                    Intrinsics.checkNotNullParameter(dest, "dest");
                    dest.writeInt(1);
                }

                private Document() {
                    super(SetsKt.minus((Set<? extends String>) SetsKt.plus((Set) SupportedFileExtensions.INSTANCE.getDOCUMENT_EXTENSIONS(), (Iterable) SupportedFileExtensions.INSTANCE.getMICROSOFT_WORD_EXTENSIONS()), "pdf"), null);
                }
            }

            /* JADX INFO: compiled from: FilesSearchFilters.kt */
            @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005¨\u0006\u000b"}, d2 = {"Lcom/box/android/domain/models/search/FilesSearchFilters$FilterItemType$FileType$Autocad;", "Lcom/box/android/domain/models/search/FilesSearchFilters$FilterItemType$FileType;", "<init>", "()V", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
            public static final class Autocad extends FileType {
                public static final Autocad INSTANCE = new Autocad();
                public static final Parcelable.Creator<Autocad> CREATOR = new Creator();

                /* JADX INFO: compiled from: FilesSearchFilters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class Creator implements Parcelable.Creator<Autocad> {
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // android.os.Parcelable.Creator
                    public final Autocad createFromParcel(Parcel parcel) {
                        Intrinsics.checkNotNullParameter(parcel, "parcel");
                        parcel.readInt();
                        return Autocad.INSTANCE;
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // android.os.Parcelable.Creator
                    public final Autocad[] newArray(int i) {
                        return new Autocad[i];
                    }
                }

                @Override // android.os.Parcelable
                public final int describeContents() {
                    return 0;
                }

                @Override // android.os.Parcelable
                public final void writeToParcel(Parcel dest, int flags) {
                    Intrinsics.checkNotNullParameter(dest, "dest");
                    dest.writeInt(1);
                }

                private Autocad() {
                    super(SetsKt.setOf(SupportedFileExtensions.DWG_EXTENSION), null);
                }
            }

            /* JADX INFO: compiled from: FilesSearchFilters.kt */
            @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005¨\u0006\u000b"}, d2 = {"Lcom/box/android/domain/models/search/FilesSearchFilters$FilterItemType$FileType$Image;", "Lcom/box/android/domain/models/search/FilesSearchFilters$FilterItemType$FileType;", "<init>", "()V", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
            public static final class Image extends FileType {
                public static final Image INSTANCE = new Image();
                public static final Parcelable.Creator<Image> CREATOR = new Creator();

                /* JADX INFO: compiled from: FilesSearchFilters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class Creator implements Parcelable.Creator<Image> {
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // android.os.Parcelable.Creator
                    public final Image createFromParcel(Parcel parcel) {
                        Intrinsics.checkNotNullParameter(parcel, "parcel");
                        parcel.readInt();
                        return Image.INSTANCE;
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // android.os.Parcelable.Creator
                    public final Image[] newArray(int i) {
                        return new Image[i];
                    }
                }

                @Override // android.os.Parcelable
                public final int describeContents() {
                    return 0;
                }

                @Override // android.os.Parcelable
                public final void writeToParcel(Parcel dest, int flags) {
                    Intrinsics.checkNotNullParameter(dest, "dest");
                    dest.writeInt(1);
                }

                private Image() {
                    super(SetsKt.plus((Set<? extends String>) SetsKt.plus((Set<? extends String>) SetsKt.plus((Set<? extends String>) SetsKt.plus((Set) SupportedFileExtensions.INSTANCE.getIMAGE_EXTENSIONS(), (Iterable) SupportedFileExtensions.INSTANCE.getVECTOR_EXTENSIONS()), SupportedFileExtensions.AI_EXTENSION), SupportedFileExtensions.GIF_EXTENSION), SupportedFileExtensions.PSD_EXTENSION), null);
                }
            }

            /* JADX INFO: compiled from: FilesSearchFilters.kt */
            @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005¨\u0006\u000b"}, d2 = {"Lcom/box/android/domain/models/search/FilesSearchFilters$FilterItemType$FileType$Pdf;", "Lcom/box/android/domain/models/search/FilesSearchFilters$FilterItemType$FileType;", "<init>", "()V", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
            public static final class Pdf extends FileType {
                public static final Pdf INSTANCE = new Pdf();
                public static final Parcelable.Creator<Pdf> CREATOR = new Creator();

                /* JADX INFO: compiled from: FilesSearchFilters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class Creator implements Parcelable.Creator<Pdf> {
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // android.os.Parcelable.Creator
                    public final Pdf createFromParcel(Parcel parcel) {
                        Intrinsics.checkNotNullParameter(parcel, "parcel");
                        parcel.readInt();
                        return Pdf.INSTANCE;
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // android.os.Parcelable.Creator
                    public final Pdf[] newArray(int i) {
                        return new Pdf[i];
                    }
                }

                @Override // android.os.Parcelable
                public final int describeContents() {
                    return 0;
                }

                @Override // android.os.Parcelable
                public final void writeToParcel(Parcel dest, int flags) {
                    Intrinsics.checkNotNullParameter(dest, "dest");
                    dest.writeInt(1);
                }

                private Pdf() {
                    super(SetsKt.setOf("pdf"), null);
                }
            }

            /* JADX INFO: compiled from: FilesSearchFilters.kt */
            @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005¨\u0006\u000b"}, d2 = {"Lcom/box/android/domain/models/search/FilesSearchFilters$FilterItemType$FileType$Presentation;", "Lcom/box/android/domain/models/search/FilesSearchFilters$FilterItemType$FileType;", "<init>", "()V", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
            public static final class Presentation extends FileType {
                public static final Presentation INSTANCE = new Presentation();
                public static final Parcelable.Creator<Presentation> CREATOR = new Creator();

                /* JADX INFO: compiled from: FilesSearchFilters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class Creator implements Parcelable.Creator<Presentation> {
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // android.os.Parcelable.Creator
                    public final Presentation createFromParcel(Parcel parcel) {
                        Intrinsics.checkNotNullParameter(parcel, "parcel");
                        parcel.readInt();
                        return Presentation.INSTANCE;
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // android.os.Parcelable.Creator
                    public final Presentation[] newArray(int i) {
                        return new Presentation[i];
                    }
                }

                @Override // android.os.Parcelable
                public final int describeContents() {
                    return 0;
                }

                @Override // android.os.Parcelable
                public final void writeToParcel(Parcel dest, int flags) {
                    Intrinsics.checkNotNullParameter(dest, "dest");
                    dest.writeInt(1);
                }

                private Presentation() {
                    super(SetsKt.plus((Set) SupportedFileExtensions.INSTANCE.getPRESENTATION_EXTENSIONS(), (Iterable) SupportedFileExtensions.INSTANCE.getMICROSOFT_POWERPOINT_EXTENSIONS()), null);
                }
            }

            /* JADX INFO: compiled from: FilesSearchFilters.kt */
            @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005¨\u0006\u000b"}, d2 = {"Lcom/box/android/domain/models/search/FilesSearchFilters$FilterItemType$FileType$Spreadsheet;", "Lcom/box/android/domain/models/search/FilesSearchFilters$FilterItemType$FileType;", "<init>", "()V", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
            public static final class Spreadsheet extends FileType {
                public static final Spreadsheet INSTANCE = new Spreadsheet();
                public static final Parcelable.Creator<Spreadsheet> CREATOR = new Creator();

                /* JADX INFO: compiled from: FilesSearchFilters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class Creator implements Parcelable.Creator<Spreadsheet> {
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // android.os.Parcelable.Creator
                    public final Spreadsheet createFromParcel(Parcel parcel) {
                        Intrinsics.checkNotNullParameter(parcel, "parcel");
                        parcel.readInt();
                        return Spreadsheet.INSTANCE;
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // android.os.Parcelable.Creator
                    public final Spreadsheet[] newArray(int i) {
                        return new Spreadsheet[i];
                    }
                }

                @Override // android.os.Parcelable
                public final int describeContents() {
                    return 0;
                }

                @Override // android.os.Parcelable
                public final void writeToParcel(Parcel dest, int flags) {
                    Intrinsics.checkNotNullParameter(dest, "dest");
                    dest.writeInt(1);
                }

                private Spreadsheet() {
                    super(SetsKt.plus((Set) SupportedFileExtensions.INSTANCE.getSPREADSHEET_EXTENSIONS(), (Iterable) SupportedFileExtensions.INSTANCE.getMICROSOFT_EXCEL_EXTENSIONS()), null);
                }
            }

            /* JADX INFO: compiled from: FilesSearchFilters.kt */
            @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005¨\u0006\u000b"}, d2 = {"Lcom/box/android/domain/models/search/FilesSearchFilters$FilterItemType$FileType$Video;", "Lcom/box/android/domain/models/search/FilesSearchFilters$FilterItemType$FileType;", "<init>", "()V", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
            public static final class Video extends FileType {
                public static final Video INSTANCE = new Video();
                public static final Parcelable.Creator<Video> CREATOR = new Creator();

                /* JADX INFO: compiled from: FilesSearchFilters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class Creator implements Parcelable.Creator<Video> {
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // android.os.Parcelable.Creator
                    public final Video createFromParcel(Parcel parcel) {
                        Intrinsics.checkNotNullParameter(parcel, "parcel");
                        parcel.readInt();
                        return Video.INSTANCE;
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // android.os.Parcelable.Creator
                    public final Video[] newArray(int i) {
                        return new Video[i];
                    }
                }

                @Override // android.os.Parcelable
                public final int describeContents() {
                    return 0;
                }

                @Override // android.os.Parcelable
                public final void writeToParcel(Parcel dest, int flags) {
                    Intrinsics.checkNotNullParameter(dest, "dest");
                    dest.writeInt(1);
                }

                private Video() {
                    super(SupportedFileExtensions.INSTANCE.getVIDEO_EXTENSIONS(), null);
                }
            }
        }
    }

    /* JADX INFO: compiled from: FilesSearchFilters.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u00012\u00020\u0002:\u0005\u0005\u0006\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001\u0005\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/box/android/domain/models/search/FilesSearchFilters$ModifiedAfterDate;", "Lcom/box/android/domain/models/search/FilesSearchFilters$FilterType;", "Landroid/os/Parcelable;", "<init>", "()V", "Any", "PastDay", "PastWeek", "PastMonth", "PastYear", "Lcom/box/android/domain/models/search/FilesSearchFilters$ModifiedAfterDate$Any;", "Lcom/box/android/domain/models/search/FilesSearchFilters$ModifiedAfterDate$PastDay;", "Lcom/box/android/domain/models/search/FilesSearchFilters$ModifiedAfterDate$PastMonth;", "Lcom/box/android/domain/models/search/FilesSearchFilters$ModifiedAfterDate$PastWeek;", "Lcom/box/android/domain/models/search/FilesSearchFilters$ModifiedAfterDate$PastYear;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class ModifiedAfterDate extends FilterType implements Parcelable {
        public /* synthetic */ ModifiedAfterDate(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private ModifiedAfterDate() {
        }

        /* JADX INFO: compiled from: FilesSearchFilters.kt */
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tHÖ\u0003J\t\u0010\n\u001a\u00020\u0005HÖ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005¨\u0006\u0012"}, d2 = {"Lcom/box/android/domain/models/search/FilesSearchFilters$ModifiedAfterDate$Any;", "Lcom/box/android/domain/models/search/FilesSearchFilters$ModifiedAfterDate;", "<init>", "()V", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Any extends ModifiedAfterDate {
            public static final Any INSTANCE = new Any();
            public static final Parcelable.Creator<Any> CREATOR = new Creator();

            /* JADX INFO: compiled from: FilesSearchFilters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<Any> {
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final Any createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.readInt();
                    return Any.INSTANCE;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final Any[] newArray(int i) {
                    return new Any[i];
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
                if (!(other instanceof Any)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1247363606;
            }

            public String toString() {
                return "Any";
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel dest, int flags) {
                Intrinsics.checkNotNullParameter(dest, "dest");
                dest.writeInt(1);
            }

            private Any() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FilesSearchFilters.kt */
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tHÖ\u0003J\t\u0010\n\u001a\u00020\u0005HÖ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005¨\u0006\u0012"}, d2 = {"Lcom/box/android/domain/models/search/FilesSearchFilters$ModifiedAfterDate$PastDay;", "Lcom/box/android/domain/models/search/FilesSearchFilters$ModifiedAfterDate;", "<init>", "()V", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PastDay extends ModifiedAfterDate {
            public static final PastDay INSTANCE = new PastDay();
            public static final Parcelable.Creator<PastDay> CREATOR = new Creator();

            /* JADX INFO: compiled from: FilesSearchFilters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<PastDay> {
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final PastDay createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.readInt();
                    return PastDay.INSTANCE;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final PastDay[] newArray(int i) {
                    return new PastDay[i];
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
                if (!(other instanceof PastDay)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -367957208;
            }

            public String toString() {
                return "PastDay";
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel dest, int flags) {
                Intrinsics.checkNotNullParameter(dest, "dest");
                dest.writeInt(1);
            }

            private PastDay() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FilesSearchFilters.kt */
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tHÖ\u0003J\t\u0010\n\u001a\u00020\u0005HÖ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005¨\u0006\u0012"}, d2 = {"Lcom/box/android/domain/models/search/FilesSearchFilters$ModifiedAfterDate$PastWeek;", "Lcom/box/android/domain/models/search/FilesSearchFilters$ModifiedAfterDate;", "<init>", "()V", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PastWeek extends ModifiedAfterDate {
            public static final PastWeek INSTANCE = new PastWeek();
            public static final Parcelable.Creator<PastWeek> CREATOR = new Creator();

            /* JADX INFO: compiled from: FilesSearchFilters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<PastWeek> {
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final PastWeek createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.readInt();
                    return PastWeek.INSTANCE;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final PastWeek[] newArray(int i) {
                    return new PastWeek[i];
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
                if (!(other instanceof PastWeek)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1478797800;
            }

            public String toString() {
                return "PastWeek";
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel dest, int flags) {
                Intrinsics.checkNotNullParameter(dest, "dest");
                dest.writeInt(1);
            }

            private PastWeek() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FilesSearchFilters.kt */
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tHÖ\u0003J\t\u0010\n\u001a\u00020\u0005HÖ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005¨\u0006\u0012"}, d2 = {"Lcom/box/android/domain/models/search/FilesSearchFilters$ModifiedAfterDate$PastMonth;", "Lcom/box/android/domain/models/search/FilesSearchFilters$ModifiedAfterDate;", "<init>", "()V", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PastMonth extends ModifiedAfterDate {
            public static final PastMonth INSTANCE = new PastMonth();
            public static final Parcelable.Creator<PastMonth> CREATOR = new Creator();

            /* JADX INFO: compiled from: FilesSearchFilters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<PastMonth> {
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final PastMonth createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.readInt();
                    return PastMonth.INSTANCE;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final PastMonth[] newArray(int i) {
                    return new PastMonth[i];
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
                if (!(other instanceof PastMonth)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1410836724;
            }

            public String toString() {
                return "PastMonth";
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel dest, int flags) {
                Intrinsics.checkNotNullParameter(dest, "dest");
                dest.writeInt(1);
            }

            private PastMonth() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FilesSearchFilters.kt */
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tHÖ\u0003J\t\u0010\n\u001a\u00020\u0005HÖ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005¨\u0006\u0012"}, d2 = {"Lcom/box/android/domain/models/search/FilesSearchFilters$ModifiedAfterDate$PastYear;", "Lcom/box/android/domain/models/search/FilesSearchFilters$ModifiedAfterDate;", "<init>", "()V", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PastYear extends ModifiedAfterDate {
            public static final PastYear INSTANCE = new PastYear();
            public static final Parcelable.Creator<PastYear> CREATOR = new Creator();

            /* JADX INFO: compiled from: FilesSearchFilters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<PastYear> {
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final PastYear createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.readInt();
                    return PastYear.INSTANCE;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final PastYear[] newArray(int i) {
                    return new PastYear[i];
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
                if (!(other instanceof PastYear)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1478857265;
            }

            public String toString() {
                return "PastYear";
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel dest, int flags) {
                Intrinsics.checkNotNullParameter(dest, "dest");
                dest.writeInt(1);
            }

            private PastYear() {
                super(null);
            }
        }
    }

    /* JADX INFO: compiled from: FilesSearchFilters.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u00012\u00020\u0002:\u0006\u0005\u0006\u0007\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001\u0006\u000b\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/box/android/domain/models/search/FilesSearchFilters$Size;", "Lcom/box/android/domain/models/search/FilesSearchFilters$FilterType;", "Landroid/os/Parcelable;", "<init>", "()V", "Any", "LessThan1Mb", "From1To5Mb", "From5To25Mb", "From25To100Mb", "From100MbTo1Gb", "Lcom/box/android/domain/models/search/FilesSearchFilters$Size$Any;", "Lcom/box/android/domain/models/search/FilesSearchFilters$Size$From100MbTo1Gb;", "Lcom/box/android/domain/models/search/FilesSearchFilters$Size$From1To5Mb;", "Lcom/box/android/domain/models/search/FilesSearchFilters$Size$From25To100Mb;", "Lcom/box/android/domain/models/search/FilesSearchFilters$Size$From5To25Mb;", "Lcom/box/android/domain/models/search/FilesSearchFilters$Size$LessThan1Mb;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Size extends FilterType implements Parcelable {
        public /* synthetic */ Size(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Size() {
        }

        /* JADX INFO: compiled from: FilesSearchFilters.kt */
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tHÖ\u0003J\t\u0010\n\u001a\u00020\u0005HÖ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005¨\u0006\u0012"}, d2 = {"Lcom/box/android/domain/models/search/FilesSearchFilters$Size$Any;", "Lcom/box/android/domain/models/search/FilesSearchFilters$Size;", "<init>", "()V", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Any extends Size {
            public static final Any INSTANCE = new Any();
            public static final Parcelable.Creator<Any> CREATOR = new Creator();

            /* JADX INFO: compiled from: FilesSearchFilters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<Any> {
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final Any createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.readInt();
                    return Any.INSTANCE;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final Any[] newArray(int i) {
                    return new Any[i];
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
                if (!(other instanceof Any)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -336115756;
            }

            public String toString() {
                return "Any";
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel dest, int flags) {
                Intrinsics.checkNotNullParameter(dest, "dest");
                dest.writeInt(1);
            }

            private Any() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FilesSearchFilters.kt */
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tHÖ\u0003J\t\u0010\n\u001a\u00020\u0005HÖ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005¨\u0006\u0012"}, d2 = {"Lcom/box/android/domain/models/search/FilesSearchFilters$Size$LessThan1Mb;", "Lcom/box/android/domain/models/search/FilesSearchFilters$Size;", "<init>", "()V", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class LessThan1Mb extends Size {
            public static final LessThan1Mb INSTANCE = new LessThan1Mb();
            public static final Parcelable.Creator<LessThan1Mb> CREATOR = new Creator();

            /* JADX INFO: compiled from: FilesSearchFilters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<LessThan1Mb> {
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final LessThan1Mb createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.readInt();
                    return LessThan1Mb.INSTANCE;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final LessThan1Mb[] newArray(int i) {
                    return new LessThan1Mb[i];
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
                if (!(other instanceof LessThan1Mb)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -624651660;
            }

            public String toString() {
                return "LessThan1Mb";
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel dest, int flags) {
                Intrinsics.checkNotNullParameter(dest, "dest");
                dest.writeInt(1);
            }

            private LessThan1Mb() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FilesSearchFilters.kt */
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tHÖ\u0003J\t\u0010\n\u001a\u00020\u0005HÖ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005¨\u0006\u0012"}, d2 = {"Lcom/box/android/domain/models/search/FilesSearchFilters$Size$From1To5Mb;", "Lcom/box/android/domain/models/search/FilesSearchFilters$Size;", "<init>", "()V", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class From1To5Mb extends Size {
            public static final From1To5Mb INSTANCE = new From1To5Mb();
            public static final Parcelable.Creator<From1To5Mb> CREATOR = new Creator();

            /* JADX INFO: compiled from: FilesSearchFilters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<From1To5Mb> {
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final From1To5Mb createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.readInt();
                    return From1To5Mb.INSTANCE;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final From1To5Mb[] newArray(int i) {
                    return new From1To5Mb[i];
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
                if (!(other instanceof From1To5Mb)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1614864352;
            }

            public String toString() {
                return "From1To5Mb";
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel dest, int flags) {
                Intrinsics.checkNotNullParameter(dest, "dest");
                dest.writeInt(1);
            }

            private From1To5Mb() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FilesSearchFilters.kt */
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tHÖ\u0003J\t\u0010\n\u001a\u00020\u0005HÖ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005¨\u0006\u0012"}, d2 = {"Lcom/box/android/domain/models/search/FilesSearchFilters$Size$From5To25Mb;", "Lcom/box/android/domain/models/search/FilesSearchFilters$Size;", "<init>", "()V", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class From5To25Mb extends Size {
            public static final From5To25Mb INSTANCE = new From5To25Mb();
            public static final Parcelable.Creator<From5To25Mb> CREATOR = new Creator();

            /* JADX INFO: compiled from: FilesSearchFilters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<From5To25Mb> {
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final From5To25Mb createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.readInt();
                    return From5To25Mb.INSTANCE;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final From5To25Mb[] newArray(int i) {
                    return new From5To25Mb[i];
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
                if (!(other instanceof From5To25Mb)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 2071089094;
            }

            public String toString() {
                return "From5To25Mb";
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel dest, int flags) {
                Intrinsics.checkNotNullParameter(dest, "dest");
                dest.writeInt(1);
            }

            private From5To25Mb() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FilesSearchFilters.kt */
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tHÖ\u0003J\t\u0010\n\u001a\u00020\u0005HÖ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005¨\u0006\u0012"}, d2 = {"Lcom/box/android/domain/models/search/FilesSearchFilters$Size$From25To100Mb;", "Lcom/box/android/domain/models/search/FilesSearchFilters$Size;", "<init>", "()V", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class From25To100Mb extends Size {
            public static final From25To100Mb INSTANCE = new From25To100Mb();
            public static final Parcelable.Creator<From25To100Mb> CREATOR = new Creator();

            /* JADX INFO: compiled from: FilesSearchFilters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<From25To100Mb> {
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final From25To100Mb createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.readInt();
                    return From25To100Mb.INSTANCE;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final From25To100Mb[] newArray(int i) {
                    return new From25To100Mb[i];
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
                if (!(other instanceof From25To100Mb)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -359343738;
            }

            public String toString() {
                return "From25To100Mb";
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel dest, int flags) {
                Intrinsics.checkNotNullParameter(dest, "dest");
                dest.writeInt(1);
            }

            private From25To100Mb() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FilesSearchFilters.kt */
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tHÖ\u0003J\t\u0010\n\u001a\u00020\u0005HÖ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005¨\u0006\u0012"}, d2 = {"Lcom/box/android/domain/models/search/FilesSearchFilters$Size$From100MbTo1Gb;", "Lcom/box/android/domain/models/search/FilesSearchFilters$Size;", "<init>", "()V", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class From100MbTo1Gb extends Size {
            public static final From100MbTo1Gb INSTANCE = new From100MbTo1Gb();
            public static final Parcelable.Creator<From100MbTo1Gb> CREATOR = new Creator();

            /* JADX INFO: compiled from: FilesSearchFilters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<From100MbTo1Gb> {
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final From100MbTo1Gb createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.readInt();
                    return From100MbTo1Gb.INSTANCE;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final From100MbTo1Gb[] newArray(int i) {
                    return new From100MbTo1Gb[i];
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
                if (!(other instanceof From100MbTo1Gb)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1105037581;
            }

            public String toString() {
                return "From100MbTo1Gb";
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel dest, int flags) {
                Intrinsics.checkNotNullParameter(dest, "dest");
                dest.writeInt(1);
            }

            private From100MbTo1Gb() {
                super(null);
            }
        }
    }
}
