package com.box.android.search.presentation.ui.components;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.rounded.AccessTimeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: SearchRecentsComponents.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$SearchRecentsComponentsKt {
    public static final ComposableSingletons$SearchRecentsComponentsKt INSTANCE = new ComposableSingletons$SearchRecentsComponentsKt();

    /* JADX INFO: renamed from: lambda$-1045418747, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f248lambda$1045418747 = ComposableLambdaKt.composableLambdaInstance(-1045418747, false, new Function2() { // from class: com.box.android.search.presentation.ui.components.ComposableSingletons$SearchRecentsComponentsKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SearchRecentsComponentsKt.lambda__1045418747$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1045418747$search_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m13039getLambda$1045418747$search_generalProdRelease() {
        return f248lambda$1045418747;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1045418747$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C137@4860L47,138@4931L2,139@4963L2,135@4782L193:SearchRecentsComponents.kt#1mmsr7");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1045418747, i, -1, "com.box.android.search.presentation.ui.components.ComposableSingletons$SearchRecentsComponentsKt.lambda$-1045418747.<anonymous> (SearchRecentsComponents.kt:135)");
            }
            VectorPainter vectorPainterRememberVectorPainter = VectorPainterKt.rememberVectorPainter(AccessTimeKt.getAccessTime(Icons.Rounded.INSTANCE), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, 374936487, "CC(remember):SearchRecentsComponents.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.search.presentation.ui.components.ComposableSingletons$SearchRecentsComponentsKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 374937511, "CC(remember):SearchRecentsComponents.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.search.presentation.ui.components.ComposableSingletons$SearchRecentsComponentsKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SearchRecentsComponentsKt.SearchRecentsListItem("brand design", vectorPainterRememberVectorPainter, function0, null, (Function0) objRememberedValue2, composer, (VectorPainter.$stable << 3) | 24966, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
