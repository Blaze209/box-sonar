package com.box.android.base;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.navigation.NavBackStackEntry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NavBackStackEntryExt.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"rememberNavArgs", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/navigation/NavBackStackEntry;", "key", "", "(Landroidx/navigation/NavBackStackEntry;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class NavBackStackEntryExtKt {
    public static final /* synthetic */ <T> T rememberNavArgs(NavBackStackEntry navBackStackEntry, String key, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        ComposerKt.sourceInformationMarkerStart(composer, 1696826545, "CC(rememberNavArgs)N(key)16@695L45:NavBackStackEntryExt.kt#i3t43k");
        ComposerKt.sourceInformationMarkerStart(composer, -1437260482, "CC(remember):NavBackStackEntryExt.kt#9igjgp");
        boolean zChanged = ((((i & 112) ^ 48) > 32 && composer.changed(key)) || (i & 48) == 32) | composer.changed(navBackStackEntry);
        T t = (T) composer.rememberedValue();
        if (zChanged || t == Composer.INSTANCE.getEmpty()) {
            t = (T) navBackStackEntry.getSavedStateHandle().get(key);
            composer.updateRememberedValue(t);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        return t;
    }
}
