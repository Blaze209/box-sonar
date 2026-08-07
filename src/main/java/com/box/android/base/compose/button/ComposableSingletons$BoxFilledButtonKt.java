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

/* JADX INFO: compiled from: BoxFilledButton.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$BoxFilledButtonKt {
    public static final ComposableSingletons$BoxFilledButtonKt INSTANCE = new ComposableSingletons$BoxFilledButtonKt();

    /* JADX INFO: renamed from: lambda$-936748137, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f169lambda$936748137 = ComposableLambdaKt.composableLambdaInstance(-936748137, false, new Function2() { // from class: com.box.android.base.compose.button.ComposableSingletons$BoxFilledButtonKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxFilledButtonKt.lambda__936748137$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-936748137$base_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m11684getLambda$936748137$base_generalProdRelease() {
        return f169lambda$936748137;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__936748137$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C53@1960L3,50@1819L168:BoxFilledButton.kt#171s90");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-936748137, i, -1, "com.box.android.base.compose.button.ComposableSingletons$BoxFilledButtonKt.lambda$-936748137.<anonymous> (BoxFilledButton.kt:50)");
            }
            int i2 = R.string.button_ok;
            ComposerKt.sourceInformationMarkerStart(composer, 1728177338, "CC(remember):BoxFilledButton.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.base.compose.button.ComposableSingletons$BoxFilledButtonKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxFilledButtonKt.BoxFilledButton(new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue, i2, 1, null), null, null, composer, 0, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
