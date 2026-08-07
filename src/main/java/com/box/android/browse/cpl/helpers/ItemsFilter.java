package com.box.android.browse.cpl.helpers;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.browse.R;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.RecentFileModel;
import com.box.android.domain.models.item.RecentItemModel;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.events.IdentificationData;

/* JADX INFO: compiled from: ItemsFilter.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0010\u0011\u0012B1\b\u0004\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0082\u0001\u0003\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/box/android/browse/cpl/helpers/ItemsFilter;", "Landroid/os/Parcelable;", "stringRes", "", "menuId", IdentificationData.PREDICATE, "Lkotlin/Function1;", "Lcom/box/android/domain/models/item/ItemModel;", "", "<init>", "(IILkotlin/jvm/functions/Function1;)V", "getStringRes", "()I", "getMenuId", "getPredicate", "()Lkotlin/jvm/functions/Function1;", "SharedLinks", BoxNoteConstants.LOG_TAG, "AllRecents", "Lcom/box/android/browse/cpl/helpers/ItemsFilter$AllRecents;", "Lcom/box/android/browse/cpl/helpers/ItemsFilter$BoxNotes;", "Lcom/box/android/browse/cpl/helpers/ItemsFilter$SharedLinks;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class ItemsFilter implements Parcelable {
    public static final int $stable = 0;
    private final int menuId;
    private final Function1<ItemModel, Boolean> predicate;
    private final int stringRes;

    public /* synthetic */ ItemsFilter(int i, int i2, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ItemsFilter(int i, int i2, Function1<? super ItemModel, Boolean> function1) {
        this.stringRes = i;
        this.menuId = i2;
        this.predicate = function1;
    }

    public final int getMenuId() {
        return this.menuId;
    }

    public final Function1<ItemModel, Boolean> getPredicate() {
        return this.predicate;
    }

    public final int getStringRes() {
        return this.stringRes;
    }

    /* JADX INFO: compiled from: ItemsFilter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005¨\u0006\u000b"}, d2 = {"Lcom/box/android/browse/cpl/helpers/ItemsFilter$SharedLinks;", "Lcom/box/android/browse/cpl/helpers/ItemsFilter;", "<init>", "()V", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class SharedLinks extends ItemsFilter {
        public static final int $stable = 0;
        public static final SharedLinks INSTANCE = new SharedLinks();
        public static final Parcelable.Creator<SharedLinks> CREATOR = new Creator();

        /* JADX INFO: compiled from: ItemsFilter.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<SharedLinks> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SharedLinks createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return SharedLinks.INSTANCE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SharedLinks[] newArray(int i) {
                return new SharedLinks[i];
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

        private SharedLinks() {
            super(R.string.Shared_Links_Filter, R.id.shared_links, new Function1() { // from class: com.box.android.browse.cpl.helpers.ItemsFilter$SharedLinks$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(ItemsFilter.SharedLinks._init_$lambda$0((ItemModel) obj));
                }
            }, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean _init_$lambda$0(ItemModel item) {
            RecentItemModel recentItem;
            Intrinsics.checkNotNullParameter(item, "item");
            String interactionSharedLink = null;
            RecentFileModel recentFileModel = item instanceof RecentFileModel ? (RecentFileModel) item : null;
            if (recentFileModel != null && (recentItem = recentFileModel.getRecentItem()) != null) {
                interactionSharedLink = recentItem.getInteractionSharedLink();
            }
            return interactionSharedLink != null;
        }
    }

    /* JADX INFO: compiled from: ItemsFilter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005¨\u0006\u000b"}, d2 = {"Lcom/box/android/browse/cpl/helpers/ItemsFilter$BoxNotes;", "Lcom/box/android/browse/cpl/helpers/ItemsFilter;", "<init>", "()V", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class BoxNotes extends ItemsFilter {
        public static final int $stable = 0;
        public static final BoxNotes INSTANCE = new BoxNotes();
        public static final Parcelable.Creator<BoxNotes> CREATOR = new Creator();

        /* JADX INFO: compiled from: ItemsFilter.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<BoxNotes> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final BoxNotes createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return BoxNotes.INSTANCE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final BoxNotes[] newArray(int i) {
                return new BoxNotes[i];
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

        private BoxNotes() {
            super(R.string.box_notes_filter, R.id.box_notes, new Function1() { // from class: com.box.android.browse.cpl.helpers.ItemsFilter$BoxNotes$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(ItemsFilter.BoxNotes._init_$lambda$0((ItemModel) obj));
                }
            }, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean _init_$lambda$0(ItemModel item) {
            Intrinsics.checkNotNullParameter(item, "item");
            return Intrinsics.areEqual(CommonBoxUtil.getFileExtension(item.getName(), ""), "boxnote");
        }
    }

    /* JADX INFO: compiled from: ItemsFilter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005¨\u0006\u000b"}, d2 = {"Lcom/box/android/browse/cpl/helpers/ItemsFilter$AllRecents;", "Lcom/box/android/browse/cpl/helpers/ItemsFilter;", "<init>", "()V", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class AllRecents extends ItemsFilter {
        public static final int $stable = 0;
        public static final AllRecents INSTANCE = new AllRecents();
        public static final Parcelable.Creator<AllRecents> CREATOR = new Creator();

        /* JADX INFO: compiled from: ItemsFilter.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<AllRecents> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final AllRecents createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return AllRecents.INSTANCE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final AllRecents[] newArray(int i) {
                return new AllRecents[i];
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

        /* JADX WARN: Multi-variable type inference failed */
        private AllRecents() {
            super(R.string.all_recents_filter, R.id.all_recents, null, 0 == true ? 1 : 0);
        }
    }
}
