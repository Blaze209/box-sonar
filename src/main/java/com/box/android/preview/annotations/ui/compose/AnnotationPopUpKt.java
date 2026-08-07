package com.box.android.preview.annotations.ui.compose;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxTypography;
import com.box.android.preview.R;
import com.box.android.preview.preview.PreviewPopupKt;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnnotationPopUp.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"AnnotationPopupContent", "", "canDeletePermission", "", "viewCommentOnClick", "Lkotlin/Function0;", "deleteOnClick", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "preview_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AnnotationPopUpKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnnotationPopupContent$lambda$2(boolean z, Function0 function0, Function0 function1, int i, Composer composer, int i2) {
        AnnotationPopupContent(z, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void AnnotationPopupContent(final boolean z, Function0<Unit> viewCommentOnClick, Function0<Unit> deleteOnClick, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function0;
        final Function0<Unit> function1;
        Intrinsics.checkNotNullParameter(viewCommentOnClick, "viewCommentOnClick");
        Intrinsics.checkNotNullParameter(deleteOnClick, "deleteOnClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1915637768);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AnnotationPopupContent)N(canDeletePermission,viewCommentOnClick,deleteOnClick)20@864L6,24@962L136,22@899L199:AnnotationPopUp.kt#sozp7t");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(viewCommentOnClick) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(deleteOnClick) ? 256 : 128;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
            function0 = viewCommentOnClick;
            function1 = deleteOnClick;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1915637768, i3, -1, "com.box.android.preview.annotations.ui.compose.AnnotationPopupContent (AnnotationPopUp.kt:18)");
            }
            final TextStyle textStyleM9104copyp1EtxEg$default = TextStyle.m9104copyp1EtxEg$default(BoxTypography.INSTANCE.getBoxMedium12(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
            PreviewPopupKt.PreviewPopupButton(viewCommentOnClick, null, ComposableLambdaKt.rememberComposableLambda(-248410357, true, new Function3() { // from class: com.box.android.preview.annotations.ui.compose.AnnotationPopUpKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AnnotationPopUpKt.AnnotationPopupContent$lambda$0(textStyleM9104copyp1EtxEg$default, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 2);
            function0 = viewCommentOnClick;
            if (z) {
                composerStartRestartGroup.startReplaceGroup(-1533814760);
                ComposerKt.sourceInformation(composerStartRestartGroup, "34@1205L352,32@1139L418");
                function1 = deleteOnClick;
                PreviewPopupKt.PreviewPopupButton(function1, null, ComposableLambdaKt.rememberComposableLambda(349361232, true, new Function3() { // from class: com.box.android.preview.annotations.ui.compose.AnnotationPopUpKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return AnnotationPopUpKt.AnnotationPopupContent$lambda$1(textStyleM9104copyp1EtxEg$default, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 6) & 14) | 384, 2);
            } else {
                function1 = deleteOnClick;
                composerStartRestartGroup.startReplaceGroup(-1534949174);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.annotations.ui.compose.AnnotationPopUpKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AnnotationPopUpKt.AnnotationPopupContent$lambda$2(z, function0, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnnotationPopupContent$lambda$0(TextStyle textStyle, RowScope PreviewPopupButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(PreviewPopupButton, "$this$PreviewPopupButton");
        ComposerKt.sourceInformation(composer, "C26@997L42,25@972L120:AnnotationPopUp.kt#sozp7t");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-248410357, i, -1, "com.box.android.preview.annotations.ui.compose.AnnotationPopupContent.<anonymous> (AnnotationPopUp.kt:25)");
            }
            String upperCase = StringResources_androidKt.stringResource(R.string.view_comment, composer, 0).toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            TextKt.m4494TextNvy7gAk(upperCase, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyle, composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnnotationPopupContent$lambda$1(TextStyle textStyle, RowScope PreviewPopupButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(PreviewPopupButton, "$this$PreviewPopupButton");
        ComposerKt.sourceInformation(composer, "C36@1251L48,35@1219L137,39@1369L39,41@1443L43,40@1421L126:AnnotationPopUp.kt#sozp7t");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(349361232, i, -1, "com.box.android.preview.annotations.ui.compose.AnnotationPopupContent.<anonymous> (AnnotationPopUp.kt:35)");
            }
            IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_trash16_blue, composer, 0), (String) null, (Modifier) null, 0L, composer, Painter.$stable | 48, 12);
            SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(8)), composer, 6);
            String upperCase = StringResources_androidKt.stringResource(R.string.pspdf__delete, composer, 0).toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            TextKt.m4494TextNvy7gAk(upperCase, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyle, composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
