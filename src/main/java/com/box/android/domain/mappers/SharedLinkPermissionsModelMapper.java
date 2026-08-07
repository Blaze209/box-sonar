package com.box.android.domain.mappers;

import com.box.android.domain.models.SharedLinkPermissionOptionType;
import com.box.androidsdk.content.models.BoxSharedLink;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SharedLinkPermissionsModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\b\u0012\u0004\u0012\u00020\b0\u0007¨\u0006\t"}, d2 = {"Lcom/box/android/domain/mappers/SharedLinkPermissionsModelMapper;", "", "<init>", "()V", "toSharedLinkPermissionModel", "", "Lcom/box/android/domain/models/SharedLinkPermissionOptionType;", "Ljava/util/ArrayList;", "Lcom/box/androidsdk/content/models/BoxSharedLink$Permission;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SharedLinkPermissionsModelMapper {
    public static final SharedLinkPermissionsModelMapper INSTANCE = new SharedLinkPermissionsModelMapper();

    /* JADX INFO: compiled from: SharedLinkPermissionsModelMapper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BoxSharedLink.Permission.values().length];
            try {
                iArr[BoxSharedLink.Permission.CAN_EDIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BoxSharedLink.Permission.CAN_PREVIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BoxSharedLink.Permission.CAN_DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private SharedLinkPermissionsModelMapper() {
    }

    public final List<SharedLinkPermissionOptionType> toSharedLinkPermissionModel(ArrayList<BoxSharedLink.Permission> arrayList) {
        SharedLinkPermissionOptionType sharedLinkPermissionOptionType;
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        ArrayList<BoxSharedLink.Permission> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator<T> it = arrayList2.iterator();
        while (it.hasNext()) {
            int i = WhenMappings.$EnumSwitchMapping$0[((BoxSharedLink.Permission) it.next()).ordinal()];
            if (i == 1) {
                sharedLinkPermissionOptionType = SharedLinkPermissionOptionType.EDIT;
            } else if (i == 2) {
                sharedLinkPermissionOptionType = SharedLinkPermissionOptionType.PREVIEW;
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                sharedLinkPermissionOptionType = SharedLinkPermissionOptionType.DOWNLOAD;
            }
            arrayList3.add(sharedLinkPermissionOptionType);
        }
        return arrayList3;
    }
}
