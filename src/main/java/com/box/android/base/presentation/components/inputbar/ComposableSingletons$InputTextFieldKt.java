package com.box.android.base.presentation.components.inputbar;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.MicKt;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.box.android.base.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: InputTextField.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$InputTextFieldKt {
    public static final ComposableSingletons$InputTextFieldKt INSTANCE = new ComposableSingletons$InputTextFieldKt();
    private static Function2<Composer, Integer, Unit> lambda$350733301 = ComposableLambdaKt.composableLambdaInstance(350733301, false, new Function2() { // from class: com.box.android.base.presentation.components.inputbar.ComposableSingletons$InputTextFieldKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$InputTextFieldKt.lambda_350733301$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-768150602, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f184lambda$768150602 = ComposableLambdaKt.composableLambdaInstance(-768150602, false, new Function2() { // from class: com.box.android.base.presentation.components.inputbar.ComposableSingletons$InputTextFieldKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$InputTextFieldKt.lambda__768150602$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1344091457 = ComposableLambdaKt.composableLambdaInstance(1344091457, false, new Function2() { // from class: com.box.android.base.presentation.components.inputbar.ComposableSingletons$InputTextFieldKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$InputTextFieldKt.lambda_1344091457$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$711892580 = ComposableLambdaKt.composableLambdaInstance(711892580, false, new Function2() { // from class: com.box.android.base.presentation.components.inputbar.ComposableSingletons$InputTextFieldKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$InputTextFieldKt.lambda_711892580$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1041196200 = ComposableLambdaKt.composableLambdaInstance(1041196200, false, new Function2() { // from class: com.box.android.base.presentation.components.inputbar.ComposableSingletons$InputTextFieldKt$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$InputTextFieldKt.lambda_1041196200$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1762576027, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f183lambda$1762576027 = ComposableLambdaKt.composableLambdaInstance(-1762576027, false, new Function2() { // from class: com.box.android.base.presentation.components.inputbar.ComposableSingletons$InputTextFieldKt$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$InputTextFieldKt.lambda__1762576027$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1762576027$base_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m11812getLambda$1762576027$base_generalProdRelease() {
        return f183lambda$1762576027;
    }

    /* JADX INFO: renamed from: getLambda$-768150602$base_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m11813getLambda$768150602$base_generalProdRelease() {
        return f184lambda$768150602;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1041196200$base_generalProdRelease() {
        return lambda$1041196200;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1344091457$base_generalProdRelease() {
        return lambda$1344091457;
    }

    public final Function2<Composer, Integer, Unit> getLambda$350733301$base_generalProdRelease() {
        return lambda$350733301;
    }

    public final Function2<Composer, Integer, Unit> getLambda$711892580$base_generalProdRelease() {
        return lambda$711892580;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_350733301$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C309@12002L37,310@12082L48,312@12200L2,308@11944L276:InputTextField.kt#epp6th");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(350733301, i, -1, "com.box.android.base.presentation.components.inputbar.ComposableSingletons$InputTextFieldKt.lambda$350733301.<anonymous> (InputTextField.kt:308)");
            }
            Painter painterPainterResource = PainterResources_androidKt.painterResource(R.drawable.ic_send24, composer, 0);
            String strStringResource = StringResources_androidKt.stringResource(R.string.comment_bar_placeholder, composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, 2047261943, "CC(remember):InputTextField.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.base.presentation.components.inputbar.ComposableSingletons$InputTextFieldKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            InputTextFieldKt.m11823InputTextFieldActionButtonnBX6wN0(null, painterPainterResource, strStringResource, true, 0L, 0L, (Function0) objRememberedValue, composer, (Painter.$stable << 3) | 1575936, 49);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__768150602$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C334@12820L37,335@12900L48,337@13018L2,333@12762L276:InputTextField.kt#epp6th");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-768150602, i, -1, "com.box.android.base.presentation.components.inputbar.ComposableSingletons$InputTextFieldKt.lambda$-768150602.<anonymous> (InputTextField.kt:333)");
            }
            Painter painterPainterResource = PainterResources_androidKt.painterResource(R.drawable.ic_send24, composer, 0);
            String strStringResource = StringResources_androidKt.stringResource(R.string.comment_bar_placeholder, composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, 541655160, "CC(remember):InputTextField.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.base.presentation.components.inputbar.ComposableSingletons$InputTextFieldKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            InputTextFieldKt.m11823InputTextFieldActionButtonnBX6wN0(null, painterPainterResource, strStringResource, true, 0L, 0L, (Function0) objRememberedValue, composer, (Painter.$stable << 3) | 1575936, 49);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_711892580$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C361@13733L7,360@13678L2,358@13582L485:InputTextField.kt#epp6th");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(711892580, i, -1, "com.box.android.base.presentation.components.inputbar.ComposableSingletons$InputTextFieldKt.lambda$711892580.<anonymous> (InputTextField.kt:358)");
            }
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd(composer);
            long jM6824unboximpl = ((Color) objConsume).m6824unboximpl();
            ComposerKt.sourceInformationMarkerStart(composer, 1228972966, "CC(remember):InputTextField.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.base.presentation.components.inputbar.ComposableSingletons$InputTextFieldKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            InputTextFieldKt.m11822InputTextFieldActionButtonY0xEhic(null, true, jM6824unboximpl, 0L, (Function0) objRememberedValue, lambda$1344091457, composer, 221232, 9);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1344091457$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C365@13903L39,363@13798L229:InputTextField.kt#epp6th");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1344091457, i, -1, "com.box.android.base.presentation.components.inputbar.ComposableSingletons$InputTextFieldKt.lambda$1344091457.<anonymous> (InputTextField.kt:363)");
            }
            IconKt.m3575Iconww6aTOc(VectorPainterKt.rememberVectorPainter(MicKt.getMic(Icons.Filled.INSTANCE), composer, 0), "Record", SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(24)), 0L, composer, VectorPainter.$stable | 432, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1762576027$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C392@14766L7,391@14711L2,389@14615L485:InputTextField.kt#epp6th");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1762576027, i, -1, "com.box.android.base.presentation.components.inputbar.ComposableSingletons$InputTextFieldKt.lambda$-1762576027.<anonymous> (InputTextField.kt:389)");
            }
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd(composer);
            long jM6824unboximpl = ((Color) objConsume).m6824unboximpl();
            ComposerKt.sourceInformationMarkerStart(composer, -1618443673, "CC(remember):InputTextField.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.base.presentation.components.inputbar.ComposableSingletons$InputTextFieldKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            InputTextFieldKt.m11822InputTextFieldActionButtonY0xEhic(null, true, jM6824unboximpl, 0L, (Function0) objRememberedValue, lambda$1041196200, composer, 221232, 9);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1041196200$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C396@14936L39,394@14831L229:InputTextField.kt#epp6th");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1041196200, i, -1, "com.box.android.base.presentation.components.inputbar.ComposableSingletons$InputTextFieldKt.lambda$1041196200.<anonymous> (InputTextField.kt:394)");
            }
            IconKt.m3575Iconww6aTOc(VectorPainterKt.rememberVectorPainter(MicKt.getMic(Icons.Filled.INSTANCE), composer, 0), "Record", SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(24)), 0L, composer, VectorPainter.$stable | 432, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
