package com.box.android.base.compose.divider;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.DividerDefaults;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import com.box.android.base.compose.BoxTheme;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: BoxItemListingDivider.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a-\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"BoxItemListingDivider", "", "startPadding", "Landroidx/compose/ui/unit/Dp;", "endPadding", "thickness", "BoxItemListingDivider-yajeYGU", "(FFFLandroidx/compose/runtime/Composer;II)V", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxItemListingDividerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxItemListingDivider_yajeYGU$lambda$0(float f, float f2, float f3, int i, int i2, Composer composer, int i3) {
        m11726BoxItemListingDivideryajeYGU(f, f2, f3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x004e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0052  */
    /* JADX WARN: Code duplicated, block: B:30:0x005a  */
    /* JADX WARN: Code duplicated, block: B:31:0x005d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0063  */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:38:0x006e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0077  */
    /* JADX WARN: Code duplicated, block: B:51:0x0092 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x0094  */
    /* JADX WARN: Code duplicated, block: B:53:0x009c  */
    /* JADX WARN: Code duplicated, block: B:55:0x009f  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:59:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:63:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:66:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:68:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:71:0x0103  */
    /* JADX WARN: Code duplicated, block: B:73:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: BoxItemListingDivider-yajeYGU, reason: not valid java name */
    public static final void m11726BoxItemListingDivideryajeYGU(float f, float f2, float f3, Composer composer, final int i, final int i2) {
        float f4;
        int i3;
        float f5;
        float f6;
        boolean z;
        final float f7;
        final float f8;
        final float f9;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        float fM9687constructorimpl;
        float fM9687constructorimpl2;
        float f10;
        float f11;
        float fM3278getThicknessD9Ej5fM;
        Composer composerStartRestartGroup = composer.startRestartGroup(-852957017);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxItemListingDivider)N(startPadding:c#ui.unit.Dp,endPadding:c#ui.unit.Dp,thickness:c#ui.unit.Dp)18@715L6,16@591L186:BoxItemListingDivider.kt#dddvzl");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            f4 = f;
        } else if ((i & 6) == 0) {
            f4 = f;
            i3 = (composerStartRestartGroup.changed(f4) ? 4 : 2) | i;
        } else {
            f4 = f;
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 == 0) {
            if ((i & 48) == 0) {
                f5 = f2;
                i3 |= composerStartRestartGroup.changed(f5) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    f6 = f3;
                    int i6 = composerStartRestartGroup.changed(f6) ? 256 : 128;
                    i3 |= i6;
                } else {
                    f6 = f3;
                }
                i3 |= i6;
            } else {
                f6 = f3;
            }
            if ((i3 & Token.DOTQUERY) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                f7 = f4;
                f8 = f5;
                f9 = f6;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i4 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(66);
                    } else {
                        fM9687constructorimpl = f4;
                    }
                    if (i5 != 0) {
                        fM9687constructorimpl2 = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl2 = f5;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        f10 = fM9687constructorimpl;
                        f11 = fM9687constructorimpl2;
                        fM3278getThicknessD9Ej5fM = DividerDefaults.INSTANCE.m3278getThicknessD9Ej5fM();
                    } else {
                        f10 = fM9687constructorimpl;
                        f11 = fM9687constructorimpl2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-852957017, i3, -1, "com.box.android.base.compose.divider.BoxItemListingDivider (BoxItemListingDivider.kt:15)");
                    }
                    f7 = f10;
                    BoxHorizontalDividerKt.m11724BoxHorizontalDivider9IZ8Weo(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, f10, 0.0f, f11, 0.0f, 10, null), fM3278getThicknessD9Ej5fM, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11532getItemListingDivider0d7_KjU(), composerStartRestartGroup, (i3 >> 3) & 112, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f9 = fM3278getThicknessD9Ej5fM;
                    f8 = f11;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    f10 = f4;
                    f11 = f5;
                }
                fM3278getThicknessD9Ej5fM = f6;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-852957017, i3, -1, "com.box.android.base.compose.divider.BoxItemListingDivider (BoxItemListingDivider.kt:15)");
                }
                f7 = f10;
                BoxHorizontalDividerKt.m11724BoxHorizontalDivider9IZ8Weo(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, f10, 0.0f, f11, 0.0f, 10, null), fM3278getThicknessD9Ej5fM, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11532getItemListingDivider0d7_KjU(), composerStartRestartGroup, (i3 >> 3) & 112, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f9 = fM3278getThicknessD9Ej5fM;
                f8 = f11;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.divider.BoxItemListingDividerKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxItemListingDividerKt.BoxItemListingDivider_yajeYGU$lambda$0(f7, f8, f9, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        f5 = f2;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                f6 = f3;
                if (composerStartRestartGroup.changed(f6)) {
                }
                i3 |= i6;
            } else {
                f6 = f3;
            }
            i3 |= i6;
        } else {
            f6 = f3;
        }
        if ((i3 & Token.DOTQUERY) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            f7 = f4;
            f8 = f5;
            f9 = f6;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i4 != 0) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(66);
                } else {
                    fM9687constructorimpl = f4;
                }
                if (i5 != 0) {
                    fM9687constructorimpl2 = Dp.m9687constructorimpl(0);
                } else {
                    fM9687constructorimpl2 = f5;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    f10 = fM9687constructorimpl;
                    f11 = fM9687constructorimpl2;
                    fM3278getThicknessD9Ej5fM = DividerDefaults.INSTANCE.m3278getThicknessD9Ej5fM();
                } else {
                    f10 = fM9687constructorimpl;
                    f11 = fM9687constructorimpl2;
                    fM3278getThicknessD9Ej5fM = f6;
                }
            } else {
                if (i4 != 0) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(66);
                } else {
                    fM9687constructorimpl = f4;
                }
                if (i5 != 0) {
                    fM9687constructorimpl2 = Dp.m9687constructorimpl(0);
                } else {
                    fM9687constructorimpl2 = f5;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    f10 = fM9687constructorimpl;
                    f11 = fM9687constructorimpl2;
                    fM3278getThicknessD9Ej5fM = DividerDefaults.INSTANCE.m3278getThicknessD9Ej5fM();
                } else {
                    f10 = fM9687constructorimpl;
                    f11 = fM9687constructorimpl2;
                    fM3278getThicknessD9Ej5fM = f6;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-852957017, i3, -1, "com.box.android.base.compose.divider.BoxItemListingDivider (BoxItemListingDivider.kt:15)");
            }
            f7 = f10;
            BoxHorizontalDividerKt.m11724BoxHorizontalDivider9IZ8Weo(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, f10, 0.0f, f11, 0.0f, 10, null), fM3278getThicknessD9Ej5fM, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11532getItemListingDivider0d7_KjU(), composerStartRestartGroup, (i3 >> 3) & 112, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f9 = fM3278getThicknessD9Ej5fM;
            f8 = f11;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.divider.BoxItemListingDividerKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxItemListingDividerKt.BoxItemListingDivider_yajeYGU$lambda$0(f7, f8, f9, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
