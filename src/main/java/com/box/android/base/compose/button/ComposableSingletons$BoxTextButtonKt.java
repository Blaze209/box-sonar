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

/* JADX INFO: compiled from: BoxTextButton.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$BoxTextButtonKt {
    public static final ComposableSingletons$BoxTextButtonKt INSTANCE = new ComposableSingletons$BoxTextButtonKt();

    /* JADX INFO: renamed from: lambda$-1901792575, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f172lambda$1901792575 = ComposableLambdaKt.composableLambdaInstance(-1901792575, false, new Function2() { // from class: com.box.android.base.compose.button.ComposableSingletons$BoxTextButtonKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxTextButtonKt.lambda__1901792575$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1901792575$base_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m11689getLambda$1901792575$base_generalProdRelease() {
        return f172lambda$1901792575;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1901792575$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C48@1618L3,45@1475L170:BoxTextButton.kt#171s90");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1901792575, i, -1, "com.box.android.base.compose.button.ComposableSingletons$BoxTextButtonKt.lambda$-1901792575.<anonymous> (BoxTextButton.kt:45)");
            }
            int i2 = R.string.button_cancel;
            ComposerKt.sourceInformationMarkerStart(composer, 2033408420, "CC(remember):BoxTextButton.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.base.compose.button.ComposableSingletons$BoxTextButtonKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxTextButtonKt.BoxTextButton(new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue, i2, 1, null), null, null, composer, 0, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
