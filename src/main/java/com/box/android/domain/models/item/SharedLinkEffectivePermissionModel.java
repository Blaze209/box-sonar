package com.box.android.domain.models.item;

import com.box.android.domain.models.DomainModel;
import com.box.androidsdk.content.models.BoxSharedLink;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SharedLinkEffectivePermissionModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/box/android/domain/models/item/SharedLinkEffectivePermissionModel;", "Lcom/box/android/domain/models/DomainModel;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CAN_DOWNLOAD", "CAN_EDIT", "CAN_PREVIEW", "NO_ACCESS", "UNKNOWN", "Companion", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum SharedLinkEffectivePermissionModel implements DomainModel {
    CAN_DOWNLOAD(BoxSharedLink.Permissions.FIELD_CAN_DOWNLOAD),
    CAN_EDIT(BoxSharedLink.Permissions.FIELD_CAN_EDIT),
    CAN_PREVIEW("can_preview"),
    NO_ACCESS("no_access"),
    UNKNOWN("unknown");

    private final String value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public static EnumEntries<SharedLinkEffectivePermissionModel> getEntries() {
        return $ENTRIES;
    }

    SharedLinkEffectivePermissionModel(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    /* JADX INFO: compiled from: SharedLinkEffectivePermissionModel.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/domain/models/item/SharedLinkEffectivePermissionModel$Companion;", "", "<init>", "()V", "fromString", "Lcom/box/android/domain/models/item/SharedLinkEffectivePermissionModel;", "value", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SharedLinkEffectivePermissionModel fromString(String value) {
            SharedLinkEffectivePermissionModel sharedLinkEffectivePermissionModel;
            SharedLinkEffectivePermissionModel sharedLinkEffectivePermissionModel2 = SharedLinkEffectivePermissionModel.UNKNOWN;
            SharedLinkEffectivePermissionModel[] sharedLinkEffectivePermissionModelArrValues = SharedLinkEffectivePermissionModel.values();
            int length = sharedLinkEffectivePermissionModelArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    sharedLinkEffectivePermissionModel = null;
                    break;
                }
                sharedLinkEffectivePermissionModel = sharedLinkEffectivePermissionModelArrValues[i];
                if (StringsKt.equals(sharedLinkEffectivePermissionModel.name(), value, true)) {
                    break;
                }
                i++;
            }
            SharedLinkEffectivePermissionModel sharedLinkEffectivePermissionModel3 = sharedLinkEffectivePermissionModel;
            if (sharedLinkEffectivePermissionModel3 != null) {
                sharedLinkEffectivePermissionModel2 = sharedLinkEffectivePermissionModel3;
            }
            return sharedLinkEffectivePermissionModel2;
        }
    }
}
