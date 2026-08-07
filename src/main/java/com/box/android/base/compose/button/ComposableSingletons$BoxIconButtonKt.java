package com.box.android.base.compose.button;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.box.android.base.R;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.button.model.ButtonItemIconResource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: BoxIconButton.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$BoxIconButtonKt {
    public static final ComposableSingletons$BoxIconButtonKt INSTANCE = new ComposableSingletons$BoxIconButtonKt();

    /* JADX INFO: renamed from: lambda$-684532951, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f170lambda$684532951 = ComposableLambdaKt.composableLambdaInstance(-684532951, false, new Function2() { // from class: com.box.android.base.compose.button.ComposableSingletons$BoxIconButtonKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxIconButtonKt.lambda__684532951$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-684532951$base_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m11686getLambda$684532951$base_generalProdRelease() {
        return f170lambda$684532951;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__684532951$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C71@2638L3,69@2545L258:BoxIconButton.kt#171s90");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-684532951, i, -1, "com.box.android.base.compose.button.ComposableSingletons$BoxIconButtonKt.lambda$-684532951.<anonymous> (BoxIconButton.kt:69)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -706166324, "CC(remember):BoxIconButton.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.base.compose.button.ComposableSingletons$BoxIconButtonKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, (Function0) objRememberedValue, "", new ButtonItemIconResource.DrawableResource(R.drawable.ic_edit_fill), false, 17, null), null, null, 0L, 0.0f, composer, 0, 30);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
