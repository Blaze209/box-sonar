package com.box.android.base.compose.button;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.res.StringResources_androidKt;
import com.box.android.base.compose.BoxColorPalette;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.BoxTypography;
import com.box.android.base.compose.button.model.ButtonItem;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxFilledButton.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\r\u0010\t\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"BoxFilledButton", "", "buttonItem", "Lcom/box/android/base/compose/button/model/ButtonItem$TextButtonItem;", "modifier", "Landroidx/compose/ui/Modifier;", "buttonColors", "Landroidx/compose/material3/ButtonColors;", "(Lcom/box/android/base/compose/button/model/ButtonItem$TextButtonItem;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/ButtonColors;Landroidx/compose/runtime/Composer;II)V", "BoxFilledButtonPreview", "(Landroidx/compose/runtime/Composer;I)V", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxFilledButtonKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxFilledButton$lambda$1(ButtonItem.TextButtonItem textButtonItem, Modifier modifier, ButtonColors buttonColors, int i, int i2, Composer composer, int i3) {
        BoxFilledButton(textButtonItem, modifier, buttonColors, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxFilledButtonPreview$lambda$0(int i, Composer composer, int i2) {
        BoxFilledButtonPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0047  */
    /* JADX WARN: Code duplicated, block: B:25:0x004b  */
    /* JADX WARN: Code duplicated, block: B:27:0x0053  */
    /* JADX WARN: Code duplicated, block: B:28:0x0056  */
    /* JADX WARN: Code duplicated, block: B:31:0x005c  */
    /* JADX WARN: Code duplicated, block: B:34:0x0066  */
    /* JADX WARN: Code duplicated, block: B:35:0x0068  */
    /* JADX WARN: Code duplicated, block: B:38:0x0071  */
    /* JADX WARN: Code duplicated, block: B:47:0x0094 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:48:0x0096  */
    /* JADX WARN: Code duplicated, block: B:49:0x009b  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:54:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:55:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:57:0x0110  */
    /* JADX WARN: Code duplicated, block: B:60:0x011d  */
    /* JADX WARN: Code duplicated, block: B:63:0x015c  */
    /* JADX WARN: Code duplicated, block: B:65:0x0162  */
    /* JADX WARN: Code duplicated, block: B:68:0x016d  */
    /* JADX WARN: Code duplicated, block: B:70:? A[RETURN, SYNTHETIC] */
    public static final void BoxFilledButton(final ButtonItem.TextButtonItem buttonItem, Modifier modifier, ButtonColors buttonColors, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        ButtonColors buttonColors2;
        boolean z;
        final Modifier modifier3;
        final ButtonColors buttonColors3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        ButtonColors buttonColors4;
        Modifier modifier4;
        long jM6851getWhite0d7_KjU;
        Intrinsics.checkNotNullParameter(buttonItem, "buttonItem");
        Composer composerStartRestartGroup = composer.startRestartGroup(1542478879);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxFilledButton)N(buttonItem,modifier,buttonColors)36@1524L132,31@1373L283:BoxFilledButton.kt#171s90");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(buttonItem) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    buttonColors2 = buttonColors;
                    int i5 = composerStartRestartGroup.changed(buttonColors2) ? 256 : 128;
                    i3 |= i5;
                } else {
                    buttonColors2 = buttonColors;
                }
                i3 |= i5;
            } else {
                buttonColors2 = buttonColors;
            }
            if ((i3 & Token.DOTQUERY) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "25@1038L6,26@1091L21,27@1203L6,28@1298L6,24@990L374");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i4 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        ButtonDefaults buttonDefaults = ButtonDefaults.INSTANCE;
                        long jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        if (DarkThemeKt.isSystemInDarkTheme(composerStartRestartGroup, 0)) {
                            jM6851getWhite0d7_KjU = BoxColorPalette.INSTANCE.m11364getBOX_GRAY_1000d7_KjU();
                        } else {
                            jM6851getWhite0d7_KjU = Color.INSTANCE.m6851getWhite0d7_KjU();
                        }
                        ButtonColors buttonColorsM2850buttonColorsro_MJ88 = buttonDefaults.m2850buttonColorsro_MJ88(jM11533getMainActiveControl0d7_KjU, jM6851getWhite0d7_KjU, Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11535getMainActiveControlContent0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), composerStartRestartGroup, ButtonDefaults.$stable << 12, 0);
                        i3 &= -897;
                        modifier4 = companion;
                        buttonColors4 = buttonColorsM2850buttonColorsro_MJ88;
                    } else {
                        buttonColors4 = buttonColors2;
                        modifier4 = companion;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    buttonColors4 = buttonColors2;
                    modifier4 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1542478879, i3, -1, "com.box.android.base.compose.button.BoxFilledButton (BoxFilledButton.kt:30)");
                }
                ButtonKt.Button(buttonItem.getOnClick(), modifier4, buttonItem.getIsEnabled(), (Shape) null, buttonColors4, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-1524913137, true, new Function3() { // from class: com.box.android.base.compose.button.BoxFilledButtonKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return BoxFilledButtonKt.BoxFilledButton$lambda$0(buttonItem, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 112) | 805306368 | ((i3 << 6) & 57344), 488);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                buttonColors3 = buttonColors4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                buttonColors3 = buttonColors2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.button.BoxFilledButtonKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxFilledButtonKt.BoxFilledButton$lambda$1(buttonItem, modifier3, buttonColors3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                buttonColors2 = buttonColors;
                if (composerStartRestartGroup.changed(buttonColors2)) {
                }
                i3 |= i5;
            } else {
                buttonColors2 = buttonColors;
            }
            i3 |= i5;
        } else {
            buttonColors2 = buttonColors;
        }
        if ((i3 & Token.DOTQUERY) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "25@1038L6,26@1091L21,27@1203L6,28@1298L6,24@990L374");
            if ((i & 1) != 0) {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 4) != 0) {
                    ButtonDefaults buttonDefaults2 = ButtonDefaults.INSTANCE;
                    long jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                    if (DarkThemeKt.isSystemInDarkTheme(composerStartRestartGroup, 0)) {
                        jM6851getWhite0d7_KjU = BoxColorPalette.INSTANCE.m11364getBOX_GRAY_1000d7_KjU();
                    } else {
                        jM6851getWhite0d7_KjU = Color.INSTANCE.m6851getWhite0d7_KjU();
                    }
                    ButtonColors buttonColorsM2850buttonColorsro_MJ89 = buttonDefaults2.m2850buttonColorsro_MJ88(jM11533getMainActiveControl0d7_KjU2, jM6851getWhite0d7_KjU, Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11535getMainActiveControlContent0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), composerStartRestartGroup, ButtonDefaults.$stable << 12, 0);
                    i3 &= -897;
                    modifier4 = companion;
                    buttonColors4 = buttonColorsM2850buttonColorsro_MJ89;
                } else {
                    buttonColors4 = buttonColors2;
                    modifier4 = companion;
                }
            } else {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 4) != 0) {
                    ButtonDefaults buttonDefaults3 = ButtonDefaults.INSTANCE;
                    long jM11533getMainActiveControl0d7_KjU3 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                    if (DarkThemeKt.isSystemInDarkTheme(composerStartRestartGroup, 0)) {
                        jM6851getWhite0d7_KjU = BoxColorPalette.INSTANCE.m11364getBOX_GRAY_1000d7_KjU();
                    } else {
                        jM6851getWhite0d7_KjU = Color.INSTANCE.m6851getWhite0d7_KjU();
                    }
                    ButtonColors buttonColorsM2850buttonColorsro_MJ810 = buttonDefaults3.m2850buttonColorsro_MJ88(jM11533getMainActiveControl0d7_KjU3, jM6851getWhite0d7_KjU, Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11535getMainActiveControlContent0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), composerStartRestartGroup, ButtonDefaults.$stable << 12, 0);
                    i3 &= -897;
                    modifier4 = companion;
                    buttonColors4 = buttonColorsM2850buttonColorsro_MJ810;
                } else {
                    buttonColors4 = buttonColors2;
                    modifier4 = companion;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1542478879, i3, -1, "com.box.android.base.compose.button.BoxFilledButton (BoxFilledButton.kt:30)");
            }
            ButtonKt.Button(buttonItem.getOnClick(), modifier4, buttonItem.getIsEnabled(), (Shape) null, buttonColors4, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-1524913137, true, new Function3() { // from class: com.box.android.base.compose.button.BoxFilledButtonKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BoxFilledButtonKt.BoxFilledButton$lambda$0(buttonItem, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 112) | 805306368 | ((i3 << 6) & 57344), 488);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            buttonColors3 = buttonColors4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            buttonColors3 = buttonColors2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.button.BoxFilledButtonKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxFilledButtonKt.BoxFilledButton$lambda$1(buttonItem, modifier3, buttonColors3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxFilledButton$lambda$0(ButtonItem.TextButtonItem textButtonItem, RowScope Button, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation(composer, "C38@1559L34,37@1534L116:BoxFilledButton.kt#171s90");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1524913137, i, -1, "com.box.android.base.compose.button.BoxFilledButton.<anonymous> (BoxFilledButton.kt:37)");
            }
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(textButtonItem.getTextRes(), composer, 0), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTypography.INSTANCE.getBoxMedium14(), composer, 0, 12582912, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void BoxFilledButtonPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(836286594);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxFilledButtonPreview)49@1800L193:BoxFilledButton.kt#171s90");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(836286594, i, -1, "com.box.android.base.compose.button.BoxFilledButtonPreview (BoxFilledButton.kt:48)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxFilledButtonKt.INSTANCE.m11684getLambda$936748137$base_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.button.BoxFilledButtonKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxFilledButtonKt.BoxFilledButtonPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
