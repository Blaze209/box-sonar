package com.box.android.browse.utilities;

import com.box.android.domain.models.ItemId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TestTagUtils.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toItemTestTag", "", "Lcom/box/android/domain/models/ItemId$Remote;", "browse_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TestTagUtilsKt {
    public static final String toItemTestTag(ItemId.Remote remote) {
        Intrinsics.checkNotNullParameter(remote, "<this>");
        return "Item:" + remote.getType().getValue() + ":" + remote.getBoxId();
    }
}
