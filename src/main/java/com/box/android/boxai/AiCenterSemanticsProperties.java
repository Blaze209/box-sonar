package com.box.android.boxai;

import androidx.compose.ui.semantics.SemanticsPropertyKey;
import com.box.brownfieldApi.featuresNavigator.AiCenterLaunchMode;
import com.box.brownfieldApi.featuresNavigator.HostSurface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AiCenterActivity.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/AiCenterSemanticsProperties;", "", "<init>", "()V", "LaunchMode", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Lcom/box/brownfieldApi/featuresNavigator/AiCenterLaunchMode;", "getLaunchMode", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "LaunchHostSurface", "Lcom/box/brownfieldApi/featuresNavigator/HostSurface;", "getLaunchHostSurface", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AiCenterSemanticsProperties {
    public static final AiCenterSemanticsProperties INSTANCE = new AiCenterSemanticsProperties();
    private static final SemanticsPropertyKey<AiCenterLaunchMode> LaunchMode = new SemanticsPropertyKey<>("AiCenterLaunchMode", (Function2) null, 2, (DefaultConstructorMarker) null);
    private static final SemanticsPropertyKey<HostSurface> LaunchHostSurface = new SemanticsPropertyKey<>("AiCenterHostSurface", (Function2) null, 2, (DefaultConstructorMarker) null);
    public static final int $stable = SemanticsPropertyKey.$stable | SemanticsPropertyKey.$stable;

    private AiCenterSemanticsProperties() {
    }

    public final SemanticsPropertyKey<AiCenterLaunchMode> getLaunchMode() {
        return LaunchMode;
    }

    public final SemanticsPropertyKey<HostSurface> getLaunchHostSurface() {
        return LaunchHostSurface;
    }
}
