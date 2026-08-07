package com.box.android.base.compose;

import androidx.compose.material3.RippleConfiguration;
import androidx.compose.material3.RippleKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomRippleConfiguration.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a,\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"CustomRippleConfiguration", "", "rippleColor", "Landroidx/compose/ui/graphics/Color;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "CustomRippleConfiguration-3J-VO9M", "(JLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CustomRippleConfigurationKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomRippleConfiguration_3J_VO9M$lambda$1(long j, Function2 function2, int i, int i2, Composer composer, int i3) {
        m11643CustomRippleConfiguration3JVO9M(j, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: CustomRippleConfiguration-3J-VO9M, reason: not valid java name */
    public static final void m11643CustomRippleConfiguration3JVO9M(long j, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(349609260);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CustomRippleConfiguration)N(rippleColor:c#ui.graphics.Color,content)16@744L100,20@850L128:CustomRippleConfiguration.kt#vejmn0");
        if ((i & 6) == 0) {
            i3 = (((i2 & 1) == 0 && composerStartRestartGroup.changed(j)) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(content) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "15@646L6");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 1) != 0) {
                    i3 &= -15;
                }
            } else if ((i2 & 1) != 0) {
                j = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11535getMainActiveControlContent0d7_KjU();
                i3 &= -15;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(349609260, i3, -1, "com.box.android.base.compose.CustomRippleConfiguration (CustomRippleConfiguration.kt:15)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 967054928, "CC(remember):CustomRippleConfiguration.kt#9igjgp");
            boolean z = (((i3 & 14) ^ 6) > 4 && composerStartRestartGroup.changed(j)) || (i3 & 6) == 4;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new RippleConfiguration(j, BoxTheme.INSTANCE.getRippleAlpha(), null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CompositionLocalKt.CompositionLocalProvider(RippleKt.getLocalRippleConfiguration().provides((RippleConfiguration) objRememberedValue), content, composerStartRestartGroup, (i3 & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final long j2 = j;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.CustomRippleConfigurationKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CustomRippleConfigurationKt.CustomRippleConfiguration_3J_VO9M$lambda$1(j2, content, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
