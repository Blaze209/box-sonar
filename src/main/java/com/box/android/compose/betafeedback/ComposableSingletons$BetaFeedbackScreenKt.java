package com.box.android.compose.betafeedback;

import android.net.Uri;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.filled.SendKt;
import androidx.compose.material.icons.filled.CloseKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import com.box.android.R;
import com.box.android.base.compose.BoxTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BetaFeedbackScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$BetaFeedbackScreenKt {
    public static final ComposableSingletons$BetaFeedbackScreenKt INSTANCE = new ComposableSingletons$BetaFeedbackScreenKt();
    private static Function2<Composer, Integer, Unit> lambda$571135214 = ComposableLambdaKt.composableLambdaInstance(571135214, false, new Function2() { // from class: com.box.android.compose.betafeedback.ComposableSingletons$BetaFeedbackScreenKt$$ExternalSyntheticLambda8
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BetaFeedbackScreenKt.lambda_571135214$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1200407154, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f225lambda$1200407154 = ComposableLambdaKt.composableLambdaInstance(-1200407154, false, new Function2() { // from class: com.box.android.compose.betafeedback.ComposableSingletons$BetaFeedbackScreenKt$$ExternalSyntheticLambda9
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BetaFeedbackScreenKt.lambda__1200407154$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$404953723 = ComposableLambdaKt.composableLambdaInstance(404953723, false, new Function2() { // from class: com.box.android.compose.betafeedback.ComposableSingletons$BetaFeedbackScreenKt$$ExternalSyntheticLambda10
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BetaFeedbackScreenKt.lambda_404953723$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1895053074, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f226lambda$1895053074 = ComposableLambdaKt.composableLambdaInstance(-1895053074, false, new Function2() { // from class: com.box.android.compose.betafeedback.ComposableSingletons$BetaFeedbackScreenKt$$ExternalSyntheticLambda11
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BetaFeedbackScreenKt.lambda__1895053074$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1490594733 = ComposableLambdaKt.composableLambdaInstance(1490594733, false, new Function2() { // from class: com.box.android.compose.betafeedback.ComposableSingletons$BetaFeedbackScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BetaFeedbackScreenKt.lambda_1490594733$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1796219201 = ComposableLambdaKt.composableLambdaInstance(1796219201, false, new Function2() { // from class: com.box.android.compose.betafeedback.ComposableSingletons$BetaFeedbackScreenKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BetaFeedbackScreenKt.lambda_1796219201$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1200407154$box_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m12415getLambda$1200407154$box_generalProdRelease() {
        return f225lambda$1200407154;
    }

    /* JADX INFO: renamed from: getLambda$-1895053074$box_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m12416getLambda$1895053074$box_generalProdRelease() {
        return f226lambda$1895053074;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1490594733$box_generalProdRelease() {
        return lambda$1490594733;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1796219201$box_generalProdRelease() {
        return lambda$1796219201;
    }

    public final Function2<Composer, Integer, Unit> getLambda$404953723$box_generalProdRelease() {
        return lambda$404953723;
    }

    public final Function2<Composer, Integer, Unit> getLambda$571135214$box_generalProdRelease() {
        return lambda$571135214;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_571135214$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C66@2823L44,68@2975L6,65@2786L228:BetaFeedbackScreen.kt#z2bog0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(571135214, i, -1, "com.box.android.compose.betafeedback.ComposableSingletons$BetaFeedbackScreenKt.lambda$571135214.<anonymous> (BetaFeedbackScreen.kt:65)");
            }
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.beta_feedback_title, composer, 6), null, BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11579getTopBarText0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxMedium20(), composer, 0, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1200407154$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C81@3503L45,82@3594L6,79@3385L252:BetaFeedbackScreen.kt#z2bog0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1200407154, i, -1, "com.box.android.compose.betafeedback.ComposableSingletons$BetaFeedbackScreenKt.lambda$-1200407154.<anonymous> (BetaFeedbackScreen.kt:79)");
            }
            IconKt.m3576Iconww6aTOc(CloseKt.getClose(Icons.INSTANCE.getDefault()), StringResources_androidKt.stringResource(R.string.beta_feedback_cancel, composer, 6), (Modifier) null, BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11579getTopBarText0d7_KjU(), composer, 0, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_404953723$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C92@4000L43,93@4089L6,90@3871L264:BetaFeedbackScreen.kt#z2bog0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(404953723, i, -1, "com.box.android.compose.betafeedback.ComposableSingletons$BetaFeedbackScreenKt.lambda$404953723.<anonymous> (BetaFeedbackScreen.kt:90)");
            }
            IconKt.m3576Iconww6aTOc(SendKt.getSend(Icons.AutoMirrored.Filled.INSTANCE), StringResources_androidKt.stringResource(R.string.beta_feedback_send, composer, 6), (Modifier) null, BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11577getTopBarControl0d7_KjU(), composer, 0, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1895053074$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C119@4974L43,121@5125L6,118@4937L233:BetaFeedbackScreen.kt#z2bog0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1895053074, i, -1, "com.box.android.compose.betafeedback.ComposableSingletons$BetaFeedbackScreenKt.lambda$-1895053074.<anonymous> (BetaFeedbackScreen.kt:118)");
            }
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.beta_feedback_hint, composer, 6), null, BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11513getContentSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composer, 0, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1490594733$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C197@7503L11,198@7539L2,199@7583L2,196@7454L141:BetaFeedbackScreen.kt#z2bog0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1490594733, i, -1, "com.box.android.compose.betafeedback.ComposableSingletons$BetaFeedbackScreenKt.lambda$1490594733.<anonymous> (BetaFeedbackScreen.kt:196)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -2057536552, "CC(remember):BetaFeedbackScreen.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function2() { // from class: com.box.android.compose.betafeedback.ComposableSingletons$BetaFeedbackScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ComposableSingletons$BetaFeedbackScreenKt.lambda_1490594733$lambda$0$0$0((String) obj, ((Boolean) obj2).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function2 function2 = (Function2) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -2057535409, "CC(remember):BetaFeedbackScreen.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.compose.betafeedback.ComposableSingletons$BetaFeedbackScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function0 function0 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -2057534001, "CC(remember):BetaFeedbackScreen.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.box.android.compose.betafeedback.ComposableSingletons$BetaFeedbackScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$BetaFeedbackScreenKt.lambda_1490594733$lambda$0$2$0((Function0) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BetaFeedbackScreenKt.BetaFeedbackScreen(null, function2, function0, (Function1) objRememberedValue3, null, composer, 3504, 17);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1490594733$lambda$0$0$0(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1490594733$lambda$0$2$0(Function0 it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1796219201$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C210@7835L11,211@7871L2,212@7915L2,208@7714L213:BetaFeedbackScreen.kt#z2bog0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1796219201, i, -1, "com.box.android.compose.betafeedback.ComposableSingletons$BetaFeedbackScreenKt.lambda$1796219201.<anonymous> (BetaFeedbackScreen.kt:208)");
            }
            Uri uri = Uri.parse("content://example/screenshot.png");
            ComposerKt.sourceInformationMarkerStart(composer, -410196628, "CC(remember):BetaFeedbackScreen.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function2() { // from class: com.box.android.compose.betafeedback.ComposableSingletons$BetaFeedbackScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ComposableSingletons$BetaFeedbackScreenKt.lambda_1796219201$lambda$0$0$0((String) obj, ((Boolean) obj2).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function2 function2 = (Function2) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -410195485, "CC(remember):BetaFeedbackScreen.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.compose.betafeedback.ComposableSingletons$BetaFeedbackScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function0 function0 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -410194077, "CC(remember):BetaFeedbackScreen.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.box.android.compose.betafeedback.ComposableSingletons$BetaFeedbackScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$BetaFeedbackScreenKt.lambda_1796219201$lambda$0$2$0((Function0) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BetaFeedbackScreenKt.BetaFeedbackScreen(uri, function2, function0, (Function1) objRememberedValue3, null, composer, 3504, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1796219201$lambda$0$0$0(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1796219201$lambda$0$2$0(Function0 it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }
}
