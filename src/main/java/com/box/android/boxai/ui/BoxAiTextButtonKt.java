package com.box.android.boxai.ui;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.facebook.react.uimanager.ViewProps;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAiTextButton.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\r\u0010\t\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\n\u001a\r\u0010\u000b\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\n¨\u0006\f"}, d2 = {"BoxAiTextButton", "", "text", "", ViewProps.ON_CLICK, "Lkotlin/Function0;", "colors", "Landroidx/compose/material3/ButtonColors;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/ButtonColors;Landroidx/compose/runtime/Composer;II)V", "BoxAiTextButtonPreview", "(Landroidx/compose/runtime/Composer;I)V", "BoxAiTextButtonPreviewMultiline", "boxai_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxAiTextButtonKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiTextButton$lambda$1(String str, Function0 function0, ButtonColors buttonColors, int i, int i2, Composer composer, int i3) {
        BoxAiTextButton(str, function0, buttonColors, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiTextButtonPreview$lambda$0(int i, Composer composer, int i2) {
        BoxAiTextButtonPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiTextButtonPreviewMultiline$lambda$0(int i, Composer composer, int i2) {
        BoxAiTextButtonPreviewMultiline(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:52:0x012c  */
    public static final void BoxAiTextButton(final String text, final Function0<Unit> onClick, ButtonColors buttonColors, Composer composer, final int i, final int i2) {
        int i3;
        ButtonColors buttonColors2;
        Composer composer2;
        final ButtonColors buttonColors3;
        ButtonColors buttonColorsM2850buttonColorsro_MJ88;
        int i4;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(365219701);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiTextButton)N(text,onClick,colors)34@1263L191,29@1092L362:BoxAiTextButton.kt#bwxcym");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(text) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = 16;
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                buttonColors2 = buttonColors;
                int i6 = composerStartRestartGroup.changed(buttonColors2) ? 256 : 128;
                i3 |= i6;
            } else {
                buttonColors2 = buttonColors;
            }
            i3 |= i6;
        } else {
            buttonColors2 = buttonColors;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "26@1050L6,25@1000L83");
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 4) != 0) {
                    composerStartRestartGroup = composerStartRestartGroup;
                    i5 = 16;
                    buttonColorsM2850buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(BoxAITheme.INSTANCE.getColors(composerStartRestartGroup, 6).m12059getTextButtonBackground0d7_KjU(), 0L, 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 14);
                    i4 = i3 & (-897);
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(365219701, i4, -1, "com.box.android.boxai.ui.BoxAiTextButton (BoxAiTextButton.kt:28)");
                }
                Composer composer3 = composerStartRestartGroup;
                ButtonKt.Button(onClick, (Modifier) null, false, (Shape) RoundedCornerShapeKt.getCircleShape(), buttonColorsM2850buttonColorsro_MJ88, (ButtonElevation) null, (BorderStroke) null, PaddingKt.m1212PaddingValuesYgX7TsA(Dp.m9687constructorimpl(i5), Dp.m9687constructorimpl(8)), (MutableInteractionSource) null, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1789314203, true, new Function3() { // from class: com.box.android.boxai.ui.BoxAiTextButtonKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return BoxAiTextButtonKt.BoxAiTextButton$lambda$0(text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composer3, ((i4 >> 3) & 14) | 817889280 | (57344 & (i4 << 6)), 358);
                composer2 = composer3;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                buttonColors3 = buttonColorsM2850buttonColorsro_MJ88;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 4) != 0) {
                    i4 = i3 & (-897);
                }
                buttonColorsM2850buttonColorsro_MJ88 = buttonColors2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(365219701, i4, -1, "com.box.android.boxai.ui.BoxAiTextButton (BoxAiTextButton.kt:28)");
                }
                Composer composer4 = composerStartRestartGroup;
                ButtonKt.Button(onClick, (Modifier) null, false, (Shape) RoundedCornerShapeKt.getCircleShape(), buttonColorsM2850buttonColorsro_MJ88, (ButtonElevation) null, (BorderStroke) null, PaddingKt.m1212PaddingValuesYgX7TsA(Dp.m9687constructorimpl(i5), Dp.m9687constructorimpl(8)), (MutableInteractionSource) null, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1789314203, true, new Function3() { // from class: com.box.android.boxai.ui.BoxAiTextButtonKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return BoxAiTextButtonKt.BoxAiTextButton$lambda$0(text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composer4, ((i4 >> 3) & 14) | 817889280 | (57344 & (i4 << 6)), 358);
                composer2 = composer4;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                buttonColors3 = buttonColorsM2850buttonColorsro_MJ88;
            }
            i4 = i3;
            buttonColorsM2850buttonColorsro_MJ88 = buttonColors2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(365219701, i4, -1, "com.box.android.boxai.ui.BoxAiTextButton (BoxAiTextButton.kt:28)");
            }
            Composer composer5 = composerStartRestartGroup;
            ButtonKt.Button(onClick, (Modifier) null, false, (Shape) RoundedCornerShapeKt.getCircleShape(), buttonColorsM2850buttonColorsro_MJ88, (ButtonElevation) null, (BorderStroke) null, PaddingKt.m1212PaddingValuesYgX7TsA(Dp.m9687constructorimpl(i5), Dp.m9687constructorimpl(8)), (MutableInteractionSource) null, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1789314203, true, new Function3() { // from class: com.box.android.boxai.ui.BoxAiTextButtonKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BoxAiTextButtonKt.BoxAiTextButton$lambda$0(text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer5, ((i4 >> 3) & 14) | 817889280 | (57344 & (i4 << 6)), 358);
            composer2 = composer5;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            buttonColors3 = buttonColorsM2850buttonColorsro_MJ88;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            buttonColors3 = buttonColors2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiTextButtonKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiTextButtonKt.BoxAiTextButton$lambda$1(text, onClick, buttonColors3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiTextButton$lambda$0(String str, RowScope Button, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation(composer, "C38@1379L6,35@1273L175:BoxAiTextButton.kt#bwxcym");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1789314203, i, -1, "com.box.android.boxai.ui.BoxAiTextButton.<anonymous> (BoxAiTextButton.kt:35)");
            }
            TextKt.m4494TextNvy7gAk(str, null, BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, TextAlign.m9519boximpl(TextAlign.INSTANCE.m9526getCentere0LSkKk()), 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal14(), composer, 0, 0, 130042);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void BoxAiTextButtonPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1462832340);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiTextButtonPreview)50@1611L210:BoxAiTextButton.kt#bwxcym");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1462832340, i, -1, "com.box.android.boxai.ui.BoxAiTextButtonPreview (BoxAiTextButton.kt:49)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxAiTextButtonKt.INSTANCE.m12112getLambda$1719375049$boxai_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiTextButtonKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiTextButtonKt.BoxAiTextButtonPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void BoxAiTextButtonPreviewMultiline(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1026935481);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiTextButtonPreviewMultiline)63@1967L240:BoxAiTextButton.kt#bwxcym");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1026935481, i, -1, "com.box.android.boxai.ui.BoxAiTextButtonPreviewMultiline (BoxAiTextButton.kt:62)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxAiTextButtonKt.INSTANCE.m12111getLambda$1176266340$boxai_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiTextButtonKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiTextButtonKt.BoxAiTextButtonPreviewMultiline$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
