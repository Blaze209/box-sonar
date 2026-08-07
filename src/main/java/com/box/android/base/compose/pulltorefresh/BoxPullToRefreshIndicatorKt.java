package com.box.android.base.compose.pulltorefresh;

import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults;
import androidx.compose.material3.pulltorefresh.PullToRefreshState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.TestTagKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxPullToRefreshIndicator.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\r\u0010\t\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"BoxPullToRefreshIndicator", "", "state", "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "isRefreshing", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/material3/pulltorefresh/PullToRefreshState;ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "BoxPullToRefreshIndicatorPreview", "(Landroidx/compose/runtime/Composer;I)V", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxPullToRefreshIndicatorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxPullToRefreshIndicator$lambda$1(PullToRefreshState pullToRefreshState, boolean z, Modifier modifier, int i, int i2, Composer composer, int i3) {
        BoxPullToRefreshIndicator(pullToRefreshState, z, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxPullToRefreshIndicatorPreview$lambda$0(int i, Composer composer, int i2) {
        BoxPullToRefreshIndicatorPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x005c  */
    /* JADX WARN: Code duplicated, block: B:31:0x005e  */
    /* JADX WARN: Code duplicated, block: B:34:0x0067 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0069  */
    /* JADX WARN: Code duplicated, block: B:36:0x006f  */
    /* JADX WARN: Code duplicated, block: B:39:0x0076  */
    /* JADX WARN: Code duplicated, block: B:42:0x0080  */
    /* JADX WARN: Code duplicated, block: B:43:0x008b  */
    /* JADX WARN: Code duplicated, block: B:46:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:48:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:53:? A[RETURN, SYNTHETIC] */
    public static final void BoxPullToRefreshIndicator(final PullToRefreshState state, final boolean z, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        Modifier.Companion companionTestTag;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer composerStartRestartGroup = composer.startRestartGroup(82023688);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxPullToRefreshIndicator)N(state,isRefreshing,modifier)44@2021L6,45@2070L6,38@1791L309:BoxPullToRefreshIndicator.kt#1dt47l");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(state) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i3 & Token.DOTQUERY) != 146) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i4 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(82023688, i3, -1, "com.box.android.base.compose.pulltorefresh.BoxPullToRefreshIndicator (BoxPullToRefreshIndicator.kt:37)");
                }
                PullToRefreshDefaults pullToRefreshDefaults = PullToRefreshDefaults.INSTANCE;
                if (z) {
                    companionTestTag = TestTagKt.testTag(Modifier.INSTANCE, "PullToRefreshIndicator");
                } else {
                    companionTestTag = Modifier.INSTANCE;
                }
                pullToRefreshDefaults.m5106Indicator2poqoh4(state, z, modifier4.then(companionTestTag), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11542getPopupBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU(), 0.0f, composerStartRestartGroup, (PullToRefreshDefaults.$stable << 18) | (i3 & 126), 32);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.pulltorefresh.BoxPullToRefreshIndicatorKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxPullToRefreshIndicatorKt.BoxPullToRefreshIndicator$lambda$1(state, z, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i3 & Token.DOTQUERY) != 146) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i4 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(82023688, i3, -1, "com.box.android.base.compose.pulltorefresh.BoxPullToRefreshIndicator (BoxPullToRefreshIndicator.kt:37)");
            }
            PullToRefreshDefaults pullToRefreshDefaults2 = PullToRefreshDefaults.INSTANCE;
            if (z) {
                companionTestTag = TestTagKt.testTag(Modifier.INSTANCE, "PullToRefreshIndicator");
            } else {
                companionTestTag = Modifier.INSTANCE;
            }
            pullToRefreshDefaults2.m5106Indicator2poqoh4(state, z, modifier4.then(companionTestTag), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11542getPopupBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU(), 0.0f, composerStartRestartGroup, (PullToRefreshDefaults.$stable << 18) | (i3 & 126), 32);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.pulltorefresh.BoxPullToRefreshIndicatorKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxPullToRefreshIndicatorKt.BoxPullToRefreshIndicator$lambda$1(state, z, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void BoxPullToRefreshIndicatorPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1076414657);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxPullToRefreshIndicatorPreview)54@2240L1208:BoxPullToRefreshIndicator.kt#1dt47l");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1076414657, i, -1, "com.box.android.base.compose.pulltorefresh.BoxPullToRefreshIndicatorPreview (BoxPullToRefreshIndicator.kt:53)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxPullToRefreshIndicatorKt.INSTANCE.m11738getLambda$1749201142$base_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.pulltorefresh.BoxPullToRefreshIndicatorKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxPullToRefreshIndicatorKt.BoxPullToRefreshIndicatorPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
