package com.box.android.base.compose;

import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxTheme.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"BoxTheme", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxThemeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxTheme$lambda$2(Function2 function2, int i, Composer composer, int i2) {
        BoxTheme(function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void BoxTheme(final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(584157537);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxTheme)N(content)186@5838L6,187@5904L6,188@5966L186,195@6183L6,196@6249L254,196@6212L291:BoxTheme.kt#vejmn0");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(content) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(584157537, i2, -1, "com.box.android.base.compose.BoxTheme (BoxTheme.kt:185)");
            }
            long jM11567getTextFieldSelection0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11567getTextFieldSelection0d7_KjU();
            long jM11569getTextFieldSelectionHandle0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11569getTextFieldSelectionHandle0d7_KjU();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1265315813, "CC(remember):BoxTheme.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(jM11567getTextFieldSelection0d7_KjU) | composerStartRestartGroup.changed(jM11569getTextFieldSelectionHandle0d7_KjU);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                TextSelectionColors textSelectionColors = new TextSelectionColors(jM11569getTextFieldSelectionHandle0d7_KjU, jM11567getTextFieldSelection0d7_KjU, null);
                composerStartRestartGroup.updateRememberedValue(textSelectionColors);
                objRememberedValue = textSelectionColors;
            }
            final TextSelectionColors textSelectionColors2 = (TextSelectionColors) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CustomRippleConfigurationKt.m11643CustomRippleConfiguration3JVO9M(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU(), ComposableLambdaKt.rememberComposableLambda(-740508790, true, new Function2() { // from class: com.box.android.base.compose.BoxThemeKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxThemeKt.BoxTheme$lambda$1(textSelectionColors2, content, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxThemeKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxThemeKt.BoxTheme$lambda$2(content, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxTheme$lambda$1(final TextSelectionColors textSelectionColors, final Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C197@6273L224,197@6259L238:BoxTheme.kt#vejmn0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-740508790, i, -1, "com.box.android.base.compose.BoxTheme.<anonymous> (BoxTheme.kt:197)");
            }
            MaterialThemeKt.MaterialTheme(null, null, null, ComposableLambdaKt.rememberComposableLambda(929627446, true, new Function2() { // from class: com.box.android.base.compose.BoxThemeKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxThemeKt.BoxTheme$lambda$1$0(textSelectionColors, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 3072, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxTheme$lambda$1$0(TextSelectionColors textSelectionColors, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C198@6287L200:BoxTheme.kt#vejmn0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(929627446, i, -1, "com.box.android.base.compose.BoxTheme.<anonymous>.<anonymous> (BoxTheme.kt:198)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{TextSelectionColorsKt.getLocalTextSelectionColors().provides(textSelectionColors)}, (Function2<? super Composer, ? super Integer, Unit>) function2, composer, ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
