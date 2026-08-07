package com.box.android.base.compose.divider;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: BoxSelectionAwareDivider.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"BoxSelectionAwareDivider", "", "isLastItem", "", "isCurrentItemSelected", "isNextItemSelected", "startPadding", "Landroidx/compose/ui/unit/Dp;", "BoxSelectionAwareDivider--jt2gSs", "(ZZZFLandroidx/compose/runtime/Composer;II)V", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxSelectionAwareDividerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxSelectionAwareDivider__jt2gSs$lambda$0(boolean z, boolean z2, boolean z3, float f, int i, int i2, Composer composer, int i3) {
        m11727BoxSelectionAwareDividerjt2gSs(z, z2, z3, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: BoxSelectionAwareDivider--jt2gSs, reason: not valid java name */
    public static final void m11727BoxSelectionAwareDividerjt2gSs(final boolean z, final boolean z2, final boolean z3, float f, Composer composer, final int i, final int i2) {
        int i3;
        final float f2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1632008879);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxSelectionAwareDivider)N(isLastItem,isCurrentItemSelected,isNextItemSelected,startPadding:c#ui.unit.Dp):BoxSelectionAwareDivider.kt#dddvzl");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(z3) ? 256 : 128;
        }
        int i4 = i2 & 8;
        if (i4 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            if (i4 != 0) {
                f = Dp.m9687constructorimpl(66);
            }
            float f3 = f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1632008879, i3, -1, "com.box.android.base.compose.divider.BoxSelectionAwareDivider (BoxSelectionAwareDivider.kt:16)");
            }
            if (z || z2 || z3) {
                composerStartRestartGroup.startReplaceGroup(-147032079);
            } else {
                composerStartRestartGroup.startReplaceGroup(-146496337);
                ComposerKt.sourceInformation(composerStartRestartGroup, "18@547L50");
                BoxItemListingDividerKt.m11726BoxItemListingDivideryajeYGU(f3, 0.0f, 0.0f, composerStartRestartGroup, (i3 >> 9) & 14, 6);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f2 = f3;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            f2 = f;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.divider.BoxSelectionAwareDividerKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxSelectionAwareDividerKt.BoxSelectionAwareDivider__jt2gSs$lambda$0(z, z2, z3, f2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
