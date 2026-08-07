package com.box.android.domain.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.item.ItemType;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ItemId.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0003\t\n\u000bB\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0082\u0001\u0002\f\r¨\u0006\u000e"}, d2 = {"Lcom/box/android/domain/models/ItemId;", "Lcom/box/android/domain/models/DomainModel;", "Landroid/os/Parcelable;", "type", "Lcom/box/android/domain/models/item/ItemType;", "<init>", "(Lcom/box/android/domain/models/item/ItemType;)V", "getType", "()Lcom/box/android/domain/models/item/ItemType;", "Remote", "Local", "Companion", "Lcom/box/android/domain/models/ItemId$Local;", "Lcom/box/android/domain/models/ItemId$Remote;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class ItemId implements DomainModel, Parcelable {
    private static final String LOCAL_IDENTIFIER = "local";
    private final ItemType type;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Remote ROOT_ITEM_ID = new Remote("0", ItemType.FOLDER);
    private static final Remote RECENTS_ITEM_ID = new Remote(BoxCommonConstants.RECENTS_ROOT_FOLDER_ID, ItemType.FOLDER);
    private static final Set<String> VALID_PREFIXES = SetsKt.setOf((Object[]) new String[]{"f", "d", "w"});

    public /* synthetic */ ItemId(ItemType itemType, DefaultConstructorMarker defaultConstructorMarker) {
        this(itemType);
    }

    private ItemId(ItemType itemType) {
        this.type = itemType;
    }

    public ItemType getType() {
        return this.type;
    }

    /* JADX INFO: compiled from: ItemId.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0003H\u0016J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u0010\u001a\u00020\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/box/android/domain/models/ItemId$Remote;", "Lcom/box/android/domain/models/ItemId;", "boxId", "", "type", "Lcom/box/android/domain/models/item/ItemType;", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/item/ItemType;)V", "getBoxId", "()Ljava/lang/String;", "getType", "()Lcom/box/android/domain/models/item/ItemType;", "toString", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Remote extends ItemId {
        public static final Parcelable.Creator<Remote> CREATOR = new Creator();
        private final String boxId;
        private final ItemType type;

        /* JADX INFO: compiled from: ItemId.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Remote> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Remote createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Remote(parcel.readString(), ItemType.valueOf(parcel.readString()));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Remote[] newArray(int i) {
                return new Remote[i];
            }
        }

        public static /* synthetic */ Remote copy$default(Remote remote, String str, ItemType itemType, int i, Object obj) {
            if ((i & 1) != 0) {
                str = remote.boxId;
            }
            if ((i & 2) != 0) {
                itemType = remote.type;
            }
            return remote.copy(str, itemType);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getBoxId() {
            return this.boxId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ItemType getType() {
            return this.type;
        }

        public final Remote copy(String boxId, ItemType type) {
            Intrinsics.checkNotNullParameter(boxId, "boxId");
            Intrinsics.checkNotNullParameter(type, "type");
            return new Remote(boxId, type);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Remote)) {
                return false;
            }
            Remote remote = (Remote) other;
            return Intrinsics.areEqual(this.boxId, remote.boxId) && this.type == remote.type;
        }

        public int hashCode() {
            return (this.boxId.hashCode() * 31) + this.type.hashCode();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.boxId);
            dest.writeString(this.type.name());
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Remote(String boxId, ItemType type) {
            super(type, null);
            Intrinsics.checkNotNullParameter(boxId, "boxId");
            Intrinsics.checkNotNullParameter(type, "type");
            this.boxId = boxId;
            this.type = type;
        }

        public final String getBoxId() {
            return this.boxId;
        }

        @Override // com.box.android.domain.models.ItemId
        public ItemType getType() {
            return this.type;
        }

        public String toString() {
            return ItemIdKt.getPrefix(getType()) + "_" + this.boxId;
        }
    }

    /* JADX INFO: compiled from: ItemId.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0003H\u0016J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u0010\u001a\u00020\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/box/android/domain/models/ItemId$Local;", "Lcom/box/android/domain/models/ItemId;", "localId", "", "type", "Lcom/box/android/domain/models/item/ItemType;", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/item/ItemType;)V", "getLocalId", "()Ljava/lang/String;", "getType", "()Lcom/box/android/domain/models/item/ItemType;", "toString", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Local extends ItemId {
        private static final String LOCAL_IDENTIFIER = "local";
        private final String localId;
        private final ItemType type;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final Parcelable.Creator<Local> CREATOR = new Creator();

        /* JADX INFO: compiled from: ItemId.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Local> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Local createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Local(parcel.readString(), ItemType.valueOf(parcel.readString()));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Local[] newArray(int i) {
                return new Local[i];
            }
        }

        public static /* synthetic */ Local copy$default(Local local, String str, ItemType itemType, int i, Object obj) {
            if ((i & 1) != 0) {
                str = local.localId;
            }
            if ((i & 2) != 0) {
                itemType = local.type;
            }
            return local.copy(str, itemType);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLocalId() {
            return this.localId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ItemType getType() {
            return this.type;
        }

        public final Local copy(String localId, ItemType type) {
            Intrinsics.checkNotNullParameter(localId, "localId");
            Intrinsics.checkNotNullParameter(type, "type");
            return new Local(localId, type);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Local)) {
                return false;
            }
            Local local = (Local) other;
            return Intrinsics.areEqual(this.localId, local.localId) && this.type == local.type;
        }

        public int hashCode() {
            return (this.localId.hashCode() * 31) + this.type.hashCode();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.localId);
            dest.writeString(this.type.name());
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Local(String localId, ItemType type) {
            super(type, null);
            Intrinsics.checkNotNullParameter(localId, "localId");
            Intrinsics.checkNotNullParameter(type, "type");
            this.localId = localId;
            this.type = type;
        }

        public final String getLocalId() {
            return this.localId;
        }

        @Override // com.box.android.domain.models.ItemId
        public ItemType getType() {
            return this.type;
        }

        public String toString() {
            return this.localId;
        }

        /* JADX INFO: compiled from: ItemId.kt */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/box/android/domain/models/ItemId$Local$Companion;", "", "<init>", "()V", "LOCAL_IDENTIFIER", "", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/box/android/domain/models/ItemId$Local;", "itemType", "Lcom/box/android/domain/models/item/ItemType;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Local create(ItemType itemType) {
                Intrinsics.checkNotNullParameter(itemType, "itemType");
                return new Local(ItemIdKt.getPrefix(itemType) + "_local_" + UUID.randomUUID(), itemType);
            }
        }
    }

    /* JADX INFO: compiled from: ItemId.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bJ\f\u0010\u0011\u001a\u00020\u0012*\u00020\u000bH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/box/android/domain/models/ItemId$Companion;", "", "<init>", "()V", "ROOT_ITEM_ID", "Lcom/box/android/domain/models/ItemId$Remote;", "getROOT_ITEM_ID", "()Lcom/box/android/domain/models/ItemId$Remote;", "RECENTS_ITEM_ID", "getRECENTS_ITEM_ID", "LOCAL_IDENTIFIER", "", "VALID_PREFIXES", "", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/box/android/domain/models/ItemId;", "identifier", "isValidPrefix", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Remote getROOT_ITEM_ID() {
            return ItemId.ROOT_ITEM_ID;
        }

        public final Remote getRECENTS_ITEM_ID() {
            return ItemId.RECENTS_ITEM_ID;
        }

        public final ItemId create(String identifier) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            List listSplit$default = StringsKt.split$default((CharSequence) identifier, new String[]{"_"}, false, 0, 6, (Object) null);
            List list = listSplit$default;
            if (list.size() == 2 && isValidPrefix((String) listSplit$default.get(0))) {
                return new Remote((String) listSplit$default.get(1), ItemIdKt.fromPrefix(ItemType.INSTANCE, (String) listSplit$default.get(0)));
            }
            if (list.size() == 3 && isValidPrefix((String) listSplit$default.get(0)) && Intrinsics.areEqual(listSplit$default.get(1), "local")) {
                return new Local(identifier, ItemIdKt.fromPrefix(ItemType.INSTANCE, (String) listSplit$default.get(0)));
            }
            throw new IllegalStateException("Invalid identifier: " + identifier);
        }

        private final boolean isValidPrefix(String str) {
            return ItemId.VALID_PREFIXES.contains(str);
        }
    }
}
