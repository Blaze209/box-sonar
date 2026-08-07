package com.box.android.base.compose.button;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.box.android.base.R;
import com.box.android.base.compose.button.model.ButtonItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: BoxOutlinedButton.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$BoxOutlinedButtonKt {
    public static final ComposableSingletons$BoxOutlinedButtonKt INSTANCE = new ComposableSingletons$BoxOutlinedButtonKt();

    /* JADX INFO: renamed from: lambda$-1576039785, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f171lambda$1576039785 = ComposableLambdaKt.composableLambdaInstance(-1576039785, false, new Function2() { // from class: com.box.android.base.compose.button.ComposableSingletons$BoxOutlinedButtonKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxOutlinedButtonKt.lambda__1576039785$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1576039785$base_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m11687getLambda$1576039785$base_generalProdRelease() {
        return f171lambda$1576039785;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1576039785$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C59@2064L3,56@1925L166:BoxOutlinedButton.kt#171s90");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1576039785, i, -1, "com.box.android.base.compose.button.ComposableSingletons$BoxOutlinedButtonKt.lambda$-1576039785.<anonymous> (BoxOutlinedButton.kt:56)");
            }
            int i2 = R.string.retry;
            ComposerKt.sourceInformationMarkerStart(composer, 1549226874, "CC(remember):BoxOutlinedButton.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.base.compose.button.ComposableSingletons$BoxOutlinedButtonKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxOutlinedButtonKt.BoxOutlinedButton(new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue, i2, 1, null), null, null, null, null, null, composer, 0, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
