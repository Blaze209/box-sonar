package com.box.android.inbox.notifications.inboxitem;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.unit.Dp;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxItemRequirementsButton.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a%\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a\r\u0010\u0007\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"InboxItemRequirementsButton", "", "onViewRequirements", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "InboxNotificationRequirementsButtonPreview", "(Landroidx/compose/runtime/Composer;I)V", "box_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class InboxItemRequirementsButtonKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItemRequirementsButton$lambda$0(Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        InboxItemRequirementsButton(function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxNotificationRequirementsButtonPreview$lambda$0(int i, Composer composer, int i2) {
        InboxNotificationRequirementsButtonPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004e  */
    /* JADX WARN: Code duplicated, block: B:24:0x0050  */
    /* JADX WARN: Code duplicated, block: B:27:0x0059 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x005b  */
    /* JADX WARN: Code duplicated, block: B:29:0x0061  */
    /* JADX WARN: Code duplicated, block: B:32:0x0068  */
    /* JADX WARN: Code duplicated, block: B:35:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:37:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:40:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:42:? A[RETURN, SYNTHETIC] */
    public static final void InboxItemRequirementsButton(final Function0<Unit> onViewRequirements, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        boolean z;
        Composer composer2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(onViewRequirements, "onViewRequirements");
        Composer composerStartRestartGroup = composer.startRestartGroup(992559729);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InboxItemRequirementsButton)N(onViewRequirements,modifier)29@1239L6,28@1187L86,21@861L597:InboxItemRequirementsButton.kt#2fg1pg");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(onViewRequirements) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i3 & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
            } else {
                if (i4 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(992559729, i3, -1, "com.box.android.inbox.notifications.inboxitem.InboxItemRequirementsButton (InboxItemRequirementsButton.kt:20)");
                }
                Modifier modifier4 = modifier3;
                composer2 = composerStartRestartGroup;
                ButtonKt.Button(onViewRequirements, TestTagKt.testTag(SizeKt.m1252height3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(modifier3, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 0.0f, 13, null), Dp.m9687constructorimpl(32)), "InboxItemRequirementsButton"), false, (Shape) RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(16)), ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0L, 0L, 0L, composer2, ButtonDefaults.$stable << 12, 14), (ButtonElevation) null, (BorderStroke) null, PaddingKt.m1212PaddingValuesYgX7TsA(Dp.m9687constructorimpl(12), Dp.m9687constructorimpl(0)), (MutableInteractionSource) null, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) ComposableSingletons$InboxItemRequirementsButtonKt.INSTANCE.m12675getLambda$652823967$box_generalProdRelease(), composerStartRestartGroup, (i3 & 14) | 817889280, 356);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemRequirementsButtonKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return InboxItemRequirementsButtonKt.InboxItemRequirementsButton$lambda$0(onViewRequirements, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i3 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(992559729, i3, -1, "com.box.android.inbox.notifications.inboxitem.InboxItemRequirementsButton (InboxItemRequirementsButton.kt:20)");
            }
            Modifier modifier5 = modifier3;
            composer2 = composerStartRestartGroup;
            ButtonKt.Button(onViewRequirements, TestTagKt.testTag(SizeKt.m1252height3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(modifier3, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 0.0f, 13, null), Dp.m9687constructorimpl(32)), "InboxItemRequirementsButton"), false, (Shape) RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(16)), ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0L, 0L, 0L, composer2, ButtonDefaults.$stable << 12, 14), (ButtonElevation) null, (BorderStroke) null, PaddingKt.m1212PaddingValuesYgX7TsA(Dp.m9687constructorimpl(12), Dp.m9687constructorimpl(0)), (MutableInteractionSource) null, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) ComposableSingletons$InboxItemRequirementsButtonKt.INSTANCE.m12675getLambda$652823967$box_generalProdRelease(), composerStartRestartGroup, (i3 & 14) | 817889280, 356);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier5;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemRequirementsButtonKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InboxItemRequirementsButtonKt.InboxItemRequirementsButton$lambda$0(onViewRequirements, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void InboxNotificationRequirementsButtonPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(574041234);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InboxNotificationRequirementsButtonPreview)46@1635L148:InboxItemRequirementsButton.kt#2fg1pg");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(574041234, i, -1, "com.box.android.inbox.notifications.inboxitem.InboxNotificationRequirementsButtonPreview (InboxItemRequirementsButton.kt:45)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$InboxItemRequirementsButtonKt.INSTANCE.m12674getLambda$1154800281$box_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemRequirementsButtonKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InboxItemRequirementsButtonKt.InboxNotificationRequirementsButtonPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
