package com.box.android.common.utilities;

import com.box.android.cpl.Effect;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.events.TagsIdentifier;

/* JADX INFO: compiled from: CPLExtensions.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a/\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"cancel", "Lcom/box/android/cpl/Effect;", "Action", "Lcom/box/android/cpl/Effect$Companion;", TagsIdentifier.FIELD_IDS_ARRAY, "", "", "(Lcom/box/android/cpl/Effect$Companion;[Ljava/lang/Object;)Lcom/box/android/cpl/Effect;", "common_prodRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CPLExtensionsKt {
    public static final <Action> Effect<Action> cancel(Effect.Companion companion, Object... ids) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(ids, "ids");
        ArrayList arrayList = new ArrayList(ids.length);
        for (Object obj : ids) {
            arrayList.add(companion.cancel(obj));
        }
        Effect[] effectArr = (Effect[]) arrayList.toArray(new Effect[0]);
        return companion.merge((Effect[]) Arrays.copyOf(effectArr, effectArr.length));
    }
}
