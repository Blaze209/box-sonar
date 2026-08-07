package com.box.android.base.presentation.watermarking;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.box.android.base.compose.ComposePreviewMocks;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WatermarkingScreen.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$WatermarkingScreenKt {
    public static final ComposableSingletons$WatermarkingScreenKt INSTANCE = new ComposableSingletons$WatermarkingScreenKt();

    /* JADX INFO: renamed from: lambda$-132901728, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f192lambda$132901728 = ComposableLambdaKt.composableLambdaInstance(-132901728, false, new Function2() { // from class: com.box.android.base.presentation.watermarking.ComposableSingletons$WatermarkingScreenKt$$ExternalSyntheticLambda23
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WatermarkingScreenKt.lambda__132901728$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$466130694 = ComposableLambdaKt.composableLambdaInstance(466130694, false, new Function2() { // from class: com.box.android.base.presentation.watermarking.ComposableSingletons$WatermarkingScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WatermarkingScreenKt.lambda_466130694$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1955640376 = ComposableLambdaKt.composableLambdaInstance(1955640376, false, new Function2() { // from class: com.box.android.base.presentation.watermarking.ComposableSingletons$WatermarkingScreenKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WatermarkingScreenKt.lambda_1955640376$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1348707551 = ComposableLambdaKt.composableLambdaInstance(1348707551, false, new Function2() { // from class: com.box.android.base.presentation.watermarking.ComposableSingletons$WatermarkingScreenKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WatermarkingScreenKt.lambda_1348707551$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-961992983, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f194lambda$961992983 = ComposableLambdaKt.composableLambdaInstance(-961992983, false, new Function2() { // from class: com.box.android.base.presentation.watermarking.ComposableSingletons$WatermarkingScreenKt$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WatermarkingScreenKt.lambda__961992983$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-403287502, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f193lambda$403287502 = ComposableLambdaKt.composableLambdaInstance(-403287502, false, new Function2() { // from class: com.box.android.base.presentation.watermarking.ComposableSingletons$WatermarkingScreenKt$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WatermarkingScreenKt.lambda__403287502$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-132901728$base_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m11903getLambda$132901728$base_generalProdRelease() {
        return f192lambda$132901728;
    }

    /* JADX INFO: renamed from: getLambda$-403287502$base_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m11904getLambda$403287502$base_generalProdRelease() {
        return f193lambda$403287502;
    }

    /* JADX INFO: renamed from: getLambda$-961992983$base_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m11905getLambda$961992983$base_generalProdRelease() {
        return f194lambda$961992983;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1348707551$base_generalProdRelease() {
        return lambda$1348707551;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1955640376$base_generalProdRelease() {
        return lambda$1955640376;
    }

    public final Function2<Composer, Integer, Unit> getLambda$466130694$base_generalProdRelease() {
        return lambda$466130694;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__132901728$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C359@13235L2,360@13269L2,361@13301L2,351@12872L441:WatermarkingScreen.kt#9p5c7w");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-132901728, i, -1, "com.box.android.base.presentation.watermarking.ComposableSingletons$WatermarkingScreenKt.lambda$-132901728.<anonymous> (WatermarkingScreen.kt:351)");
            }
            WatermarkingReducer.State.Loaded loaded = new WatermarkingReducer.State.Loaded(new WatermarkingReducer.WatermarkingTarget.File(ComposePreviewMocks.INSTANCE.getEMPTY_FILE_MODEL()), false, false, null, false, false, 56, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1130470210, "CC(remember):WatermarkingScreen.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.watermarking.ComposableSingletons$WatermarkingScreenKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$WatermarkingScreenKt.lambda__132901728$lambda$0$0$0(((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1130471298, "CC(remember):WatermarkingScreen.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.watermarking.ComposableSingletons$WatermarkingScreenKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function0 function0 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1130472322, "CC(remember):WatermarkingScreen.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.watermarking.ComposableSingletons$WatermarkingScreenKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            WatermarkingScreenKt.WatermarkingScreen(loaded, function1, function0, (Function0) objRememberedValue3, false, composer, 3504, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__132901728$lambda$0$0$0(boolean z) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_466130694$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C378@13792L2,379@13826L2,380@13858L2,370@13430L440:WatermarkingScreen.kt#9p5c7w");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(466130694, i, -1, "com.box.android.base.presentation.watermarking.ComposableSingletons$WatermarkingScreenKt.lambda$466130694.<anonymous> (WatermarkingScreen.kt:370)");
            }
            WatermarkingReducer.State.Loaded loaded = new WatermarkingReducer.State.Loaded(new WatermarkingReducer.WatermarkingTarget.File(ComposePreviewMocks.INSTANCE.getEMPTY_FILE_MODEL()), true, false, null, false, false, 56, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1275010056, "CC(remember):WatermarkingScreen.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.watermarking.ComposableSingletons$WatermarkingScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$WatermarkingScreenKt.lambda_466130694$lambda$0$0$0(((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1275011144, "CC(remember):WatermarkingScreen.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.watermarking.ComposableSingletons$WatermarkingScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function0 function0 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1275012168, "CC(remember):WatermarkingScreen.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.watermarking.ComposableSingletons$WatermarkingScreenKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            WatermarkingScreenKt.WatermarkingScreen(loaded, function1, function0, (Function0) objRememberedValue3, false, composer, 3504, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_466130694$lambda$0$0$0(boolean z) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1955640376$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C397@14354L2,398@14388L2,399@14420L2,389@13989L443:WatermarkingScreen.kt#9p5c7w");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1955640376, i, -1, "com.box.android.base.presentation.watermarking.ComposableSingletons$WatermarkingScreenKt.lambda$1955640376.<anonymous> (WatermarkingScreen.kt:389)");
            }
            WatermarkingReducer.State.Loaded loaded = new WatermarkingReducer.State.Loaded(new WatermarkingReducer.WatermarkingTarget.Folder(ComposePreviewMocks.INSTANCE.getEMPTY_FOLDER_MODEL()), true, true, null, false, false, 56, null);
            ComposerKt.sourceInformationMarkerStart(composer, -1825262310, "CC(remember):WatermarkingScreen.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.watermarking.ComposableSingletons$WatermarkingScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$WatermarkingScreenKt.lambda_1955640376$lambda$0$0$0(((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1825261222, "CC(remember):WatermarkingScreen.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.watermarking.ComposableSingletons$WatermarkingScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function0 function0 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1825260198, "CC(remember):WatermarkingScreen.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.watermarking.ComposableSingletons$WatermarkingScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            WatermarkingScreenKt.WatermarkingScreen(loaded, function1, function0, (Function0) objRememberedValue3, false, composer, 3504, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1955640376$lambda$0$0$0(boolean z) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1348707551$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C417@15019L2,418@15053L2,419@15085L2,408@14556L541:WatermarkingScreen.kt#9p5c7w");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1348707551, i, -1, "com.box.android.base.presentation.watermarking.ComposableSingletons$WatermarkingScreenKt.lambda$1348707551.<anonymous> (WatermarkingScreen.kt:408)");
            }
            WatermarkingReducer.State.Loaded loaded = new WatermarkingReducer.State.Loaded(new WatermarkingReducer.WatermarkingTarget.File(ComposePreviewMocks.INSTANCE.getEMPTY_FILE_MODEL()), true, true, WatermarkingReducer.WatermarkingDisabledReason.EnabledAtParentLevel.INSTANCE, false, false, 48, null);
            ComposerKt.sourceInformationMarkerStart(composer, -972151743, "CC(remember):WatermarkingScreen.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.watermarking.ComposableSingletons$WatermarkingScreenKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$WatermarkingScreenKt.lambda_1348707551$lambda$0$0$0(((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -972150655, "CC(remember):WatermarkingScreen.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.watermarking.ComposableSingletons$WatermarkingScreenKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function0 function0 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -972149631, "CC(remember):WatermarkingScreen.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.watermarking.ComposableSingletons$WatermarkingScreenKt$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            WatermarkingScreenKt.WatermarkingScreen(loaded, function1, function0, (Function0) objRememberedValue3, false, composer, 3504, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1348707551$lambda$0$0$0(boolean z) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__961992983$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C437@15687L2,438@15721L2,439@15753L2,428@15222L543:WatermarkingScreen.kt#9p5c7w");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-961992983, i, -1, "com.box.android.base.presentation.watermarking.ComposableSingletons$WatermarkingScreenKt.lambda$-961992983.<anonymous> (WatermarkingScreen.kt:428)");
            }
            WatermarkingReducer.State.Loaded loaded = new WatermarkingReducer.State.Loaded(new WatermarkingReducer.WatermarkingTarget.File(ComposePreviewMocks.INSTANCE.getEMPTY_FILE_MODEL()), true, true, WatermarkingReducer.WatermarkingDisabledReason.EnforcedByAccessPolicy.INSTANCE, false, false, 48, null);
            ComposerKt.sourceInformationMarkerStart(composer, -1057272821, "CC(remember):WatermarkingScreen.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.watermarking.ComposableSingletons$WatermarkingScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$WatermarkingScreenKt.lambda__961992983$lambda$0$0$0(((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1057271733, "CC(remember):WatermarkingScreen.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.watermarking.ComposableSingletons$WatermarkingScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function0 function0 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1057270709, "CC(remember):WatermarkingScreen.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.watermarking.ComposableSingletons$WatermarkingScreenKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            WatermarkingScreenKt.WatermarkingScreen(loaded, function1, function0, (Function0) objRememberedValue3, false, composer, 3504, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__961992983$lambda$0$0$0(boolean z) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__403287502$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C458@16359L2,459@16393L2,460@16425L2,449@15891L546:WatermarkingScreen.kt#9p5c7w");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-403287502, i, -1, "com.box.android.base.presentation.watermarking.ComposableSingletons$WatermarkingScreenKt.lambda$-403287502.<anonymous> (WatermarkingScreen.kt:449)");
            }
            WatermarkingReducer.State.Loaded loaded = new WatermarkingReducer.State.Loaded(new WatermarkingReducer.WatermarkingTarget.File(ComposePreviewMocks.INSTANCE.getEMPTY_FILE_MODEL()), false, false, WatermarkingReducer.WatermarkingDisabledReason.NotSupportedForFileType.INSTANCE, false, false, 48, null);
            ComposerKt.sourceInformationMarkerStart(composer, -1012217484, "CC(remember):WatermarkingScreen.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.watermarking.ComposableSingletons$WatermarkingScreenKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$WatermarkingScreenKt.lambda__403287502$lambda$0$0$0(((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1012216396, "CC(remember):WatermarkingScreen.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.watermarking.ComposableSingletons$WatermarkingScreenKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function0 function0 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1012215372, "CC(remember):WatermarkingScreen.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.watermarking.ComposableSingletons$WatermarkingScreenKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            WatermarkingScreenKt.WatermarkingScreen(loaded, function1, function0, (Function0) objRememberedValue3, false, composer, 3504, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__403287502$lambda$0$0$0(boolean z) {
        return Unit.INSTANCE;
    }
}
