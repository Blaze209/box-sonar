package com.box.android.preview.preview;

import android.content.res.Configuration;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.box.android.base.compose.ComposeUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImmersiveModeUtils.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"landscapeSystemPadding", "Landroidx/compose/ui/Modifier;", "isImmersiveMode", "", "(Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "preview_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ImmersiveModeUtilsKt {
    public static final Modifier landscapeSystemPadding(Modifier modifier, boolean z, Composer composer, int i) {
        float dp;
        Modifier.Companion companionThen;
        Modifier.Companion companionNavigationBarsPadding;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        ComposerKt.sourceInformationMarkerStart(composer, -663845777, "C(landscapeSystemPadding)N(isImmersiveMode)34@1651L7,35@1707L13,36@1760L10,37@1802L7,38@1855L7,39@1881L279:ImmersiveModeUtils.kt#viiktp");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-663845777, i, -1, "com.box.android.preview.preview.landscapeSystemPadding (ImmersiveModeUtils.kt:33)");
        }
        ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localConfiguration);
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i2 = ((Configuration) objConsume).orientation;
        WindowInsets displayCutout = WindowInsets_androidKt.getDisplayCutout(WindowInsets.INSTANCE, composer, 6);
        WindowInsets systemBars = WindowInsets_androidKt.getSystemBars(WindowInsets.INSTANCE, composer, 6);
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume2 = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Density density = (Density) objConsume2;
        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume3 = composer.consume(localLayoutDirection);
        ComposerKt.sourceInformationMarkerEnd(composer);
        LayoutDirection layoutDirection = (LayoutDirection) objConsume3;
        if (z) {
            composer.startReplaceGroup(1994348465);
            composer.endReplaceGroup();
            dp = Dp.m9687constructorimpl(0);
        } else {
            composer.startReplaceGroup(1994350165);
            ComposerKt.sourceInformation(composer, "40@1997L6");
            dp = ComposeUtilsKt.toDp(displayCutout.getLeft(density, layoutDirection), composer, 0);
            composer.endReplaceGroup();
        }
        State<Dp> stateM464animateDpAsStateAjpBEmI = AnimateAsStateKt.m464animateDpAsStateAjpBEmI(dp, AnimationSpecKt.spring$default(0.0f, 400.0f, Dp.m9685boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Dp.INSTANCE)), 1, null), null, null, composer, 0, 12);
        boolean z2 = systemBars.getBottom(density) == 0 && systemBars.getRight(density, layoutDirection) > 0;
        if (i2 == 2) {
            Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, stateM464animateDpAsStateAjpBEmI.getValue().m9701unboximpl(), 0.0f, 0.0f, 0.0f, 14, null);
            if (z2) {
                companionNavigationBarsPadding = WindowInsetsPadding_androidKt.navigationBarsPadding(Modifier.INSTANCE);
            } else {
                companionNavigationBarsPadding = Modifier.INSTANCE;
            }
            companionThen = modifierM1222paddingqDBjuR0$default.then(companionNavigationBarsPadding);
        } else {
            companionThen = Modifier.INSTANCE;
        }
        Modifier modifierThen = modifier.then(companionThen);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return modifierThen;
    }
}
