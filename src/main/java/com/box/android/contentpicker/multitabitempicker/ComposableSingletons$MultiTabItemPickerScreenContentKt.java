package com.box.android.contentpicker.multitabitempicker;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.contentpicker.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MultiTabItemPickerScreenContent.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$MultiTabItemPickerScreenContentKt {
    public static final ComposableSingletons$MultiTabItemPickerScreenContentKt INSTANCE = new ComposableSingletons$MultiTabItemPickerScreenContentKt();
    private static Function2<Composer, Integer, Unit> lambda$829198317 = ComposableLambdaKt.composableLambdaInstance(829198317, false, new Function2() { // from class: com.box.android.contentpicker.multitabitempicker.ComposableSingletons$MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$MultiTabItemPickerScreenContentKt.lambda_829198317$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$1666604345 = ComposableLambdaKt.composableLambdaInstance(1666604345, false, new Function3() { // from class: com.box.android.contentpicker.multitabitempicker.ComposableSingletons$MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$MultiTabItemPickerScreenContentKt.lambda_1666604345$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-566965917, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f229lambda$566965917 = ComposableLambdaKt.composableLambdaInstance(-566965917, false, new Function2() { // from class: com.box.android.contentpicker.multitabitempicker.ComposableSingletons$MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$MultiTabItemPickerScreenContentKt.lambda__566965917$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-566965917$content_picker_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m12436getLambda$566965917$content_picker_generalProdRelease() {
        return f229lambda$566965917;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$1666604345$content_picker_generalProdRelease() {
        return lambda$1666604345;
    }

    public final Function2<Composer, Integer, Unit> getLambda$829198317$content_picker_generalProdRelease() {
        return lambda$829198317;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_829198317$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C275@13025L36,276@13104L37,277@13179L6,274@12989L225:MultiTabItemPickerScreenContent.kt#aug1cj");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(829198317, i, -1, "com.box.android.contentpicker.multitabitempicker.ComposableSingletons$MultiTabItemPickerScreenContentKt.lambda$829198317.<anonymous> (MultiTabItemPickerScreenContent.kt:274)");
            }
            IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_close, composer, 0), StringResources_androidKt.stringResource(R.string.Deselect_all, composer, 0), (Modifier) null, BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), composer, Painter.$stable, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1666604345$lambda$0(RowScope FilledTonalButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(FilledTonalButton, "$this$FilledTonalButton");
        ComposerKt.sourceInformation(composer, "C297@14114L28,298@14186L10,296@14081L144:MultiTabItemPickerScreenContent.kt#aug1cj");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1666604345, i, -1, "com.box.android.contentpicker.multitabitempicker.ComposableSingletons$MultiTabItemPickerScreenContentKt.lambda$1666604345.<anonymous> (MultiTabItemPickerScreenContent.kt:296)");
            }
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.add, composer, 0), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelLarge(), composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__566965917$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C394@16890L2,394@16909L2,394@16843L69:MultiTabItemPickerScreenContent.kt#aug1cj");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-566965917, i, -1, "com.box.android.contentpicker.multitabitempicker.ComposableSingletons$MultiTabItemPickerScreenContentKt.lambda$-566965917.<anonymous> (MultiTabItemPickerScreenContent.kt:394)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 606602181, "CC(remember):MultiTabItemPickerScreenContent.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.ComposableSingletons$MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 606602789, "CC(remember):MultiTabItemPickerScreenContent.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.ComposableSingletons$MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            MultiTabItemPickerScreenContentKt.SelectionFloatingBar(2, function0, (Function0) objRememberedValue2, null, composer, 438, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
