package com.box.android.base.compose.divider;

import androidx.compose.material3.DividerDefaults;
import androidx.compose.material3.DividerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: BoxVerticalDivider.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a-\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\r\u0010\n\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"BoxVerticalDivider", "", "modifier", "Landroidx/compose/ui/Modifier;", "thickness", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/Color;", "BoxVerticalDivider-9IZ8Weo", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/runtime/Composer;II)V", "BoxVerticalDividerPreview", "(Landroidx/compose/runtime/Composer;I)V", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxVerticalDividerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxVerticalDividerPreview$lambda$0(int i, Composer composer, int i2) {
        BoxVerticalDividerPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxVerticalDivider_9IZ8Weo$lambda$0(Modifier modifier, float f, long j, int i, int i2, Composer composer, int i3) {
        m11728BoxVerticalDivider9IZ8Weo(modifier, f, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: BoxVerticalDivider-9IZ8Weo, reason: not valid java name */
    public static final void m11728BoxVerticalDivider9IZ8Weo(Modifier modifier, float f, long j, Composer composer, final int i, final int i2) {
        int i3;
        final long jM11517getDivider0d7_KjU;
        final Modifier modifier2;
        final float f2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1837058603);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxVerticalDivider)N(modifier,thickness:c#ui.unit.Dp,color:c#ui.graphics.Color)28@1127L104:BoxVerticalDivider.kt#dddvzl");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= ((i2 & 2) == 0 && composerStartRestartGroup.changed(f)) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                jM11517getDivider0d7_KjU = j;
                int i5 = composerStartRestartGroup.changed(jM11517getDivider0d7_KjU) ? 256 : 128;
                i3 |= i5;
            } else {
                jM11517getDivider0d7_KjU = j;
            }
            i3 |= i5;
        } else {
            jM11517getDivider0d7_KjU = j;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            f2 = f;
        } else {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "27@1105L6");
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if (i4 != 0) {
                    modifier = Modifier.INSTANCE;
                }
                if ((i2 & 2) != 0) {
                    f = DividerDefaults.INSTANCE.m3278getThicknessD9Ej5fM();
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    jM11517getDivider0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11517getDivider0d7_KjU();
                    i3 &= -897;
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
            }
            Modifier modifier3 = modifier;
            float f3 = f;
            long j2 = jM11517getDivider0d7_KjU;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1837058603, i3, -1, "com.box.android.base.compose.divider.BoxVerticalDivider (BoxVerticalDivider.kt:28)");
            }
            DividerKt.m3285VerticalDivider9IZ8Weo(modifier3, f3, j2, composerStartRestartGroup, i3 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            f2 = f3;
            jM11517getDivider0d7_KjU = j2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.divider.BoxVerticalDividerKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxVerticalDividerKt.BoxVerticalDivider_9IZ8Weo$lambda$0(modifier2, f2, jM11517getDivider0d7_KjU, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void BoxVerticalDividerPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-202471163);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxVerticalDividerPreview)39@1353L329:BoxVerticalDivider.kt#dddvzl");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-202471163, i, -1, "com.box.android.base.compose.divider.BoxVerticalDividerPreview (BoxVerticalDivider.kt:38)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxVerticalDividerKt.INSTANCE.m11729getLambda$1249364912$base_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.divider.BoxVerticalDividerKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxVerticalDividerKt.BoxVerticalDividerPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
