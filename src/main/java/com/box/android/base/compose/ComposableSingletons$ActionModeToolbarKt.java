package com.box.android.base.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.box.android.base.R;
import com.box.android.base.compose.button.model.ButtonItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ActionModeToolbar.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$ActionModeToolbarKt {
    public static final ComposableSingletons$ActionModeToolbarKt INSTANCE = new ComposableSingletons$ActionModeToolbarKt();
    private static Function2<Composer, Integer, Unit> lambda$1699485117 = ComposableLambdaKt.composableLambdaInstance(1699485117, false, new Function2() { // from class: com.box.android.base.compose.ComposableSingletons$ActionModeToolbarKt$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ActionModeToolbarKt.lambda_1699485117$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1409000781 = ComposableLambdaKt.composableLambdaInstance(1409000781, false, new Function2() { // from class: com.box.android.base.compose.ComposableSingletons$ActionModeToolbarKt$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ActionModeToolbarKt.lambda_1409000781$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$1409000781$base_generalProdRelease() {
        return lambda$1409000781;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1699485117$base_generalProdRelease() {
        return lambda$1699485117;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1699485117$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C117@4663L2,120@4774L3,115@4579L290:ActionModeToolbar.kt#vejmn0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1699485117, i, -1, "com.box.android.base.compose.ComposableSingletons$ActionModeToolbarKt.lambda$1699485117.<anonymous> (ActionModeToolbar.kt:115)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1117627967, "CC(remember):ActionModeToolbar.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.base.compose.ComposableSingletons$ActionModeToolbarKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1117631520, "CC(remember):ActionModeToolbar.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.base.compose.ComposableSingletons$ActionModeToolbarKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ActionModeToolbarKt.ActionModeToolbar("Action Mode Toolbar", function0, CollectionsKt.listOf(new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue2, R.string.LS_Delete, 1, null)), false, composer, 54, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1409000781$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C134@5067L2,137@5178L3,132@4983L330:ActionModeToolbar.kt#vejmn0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1409000781, i, -1, "com.box.android.base.compose.ComposableSingletons$ActionModeToolbarKt.lambda$1409000781.<anonymous> (ActionModeToolbar.kt:132)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1135055311, "CC(remember):ActionModeToolbar.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.base.compose.ComposableSingletons$ActionModeToolbarKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1135058864, "CC(remember):ActionModeToolbar.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.base.compose.ComposableSingletons$ActionModeToolbarKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ActionModeToolbarKt.ActionModeToolbar("Action Mode Toolbar", function0, CollectionsKt.listOf(new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue2, R.string.LS_Delete, 1, null)), true, composer, 3126, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
