package com.box.android.base.presentation.components.topbar.simple;

import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.box.android.base.R;
import com.box.android.base.compose.BoxTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: BoxSimpleTopBar.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$BoxSimpleTopBarKt {
    public static final ComposableSingletons$BoxSimpleTopBarKt INSTANCE = new ComposableSingletons$BoxSimpleTopBarKt();

    /* JADX INFO: renamed from: lambda$-2044380569, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f190lambda$2044380569 = ComposableLambdaKt.composableLambdaInstance(-2044380569, false, new Function2() { // from class: com.box.android.base.presentation.components.topbar.simple.ComposableSingletons$BoxSimpleTopBarKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxSimpleTopBarKt.lambda__2044380569$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-222343199, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f191lambda$222343199 = ComposableLambdaKt.composableLambdaInstance(-222343199, false, new Function2() { // from class: com.box.android.base.presentation.components.topbar.simple.ComposableSingletons$BoxSimpleTopBarKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxSimpleTopBarKt.lambda__222343199$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1566857783, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f189lambda$1566857783 = ComposableLambdaKt.composableLambdaInstance(-1566857783, false, new Function2() { // from class: com.box.android.base.presentation.components.topbar.simple.ComposableSingletons$BoxSimpleTopBarKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxSimpleTopBarKt.lambda__1566857783$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1566857783$base_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m11855getLambda$1566857783$base_generalProdRelease() {
        return f189lambda$1566857783;
    }

    /* JADX INFO: renamed from: getLambda$-2044380569$base_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m11856getLambda$2044380569$base_generalProdRelease() {
        return f190lambda$2044380569;
    }

    /* JADX INFO: renamed from: getLambda$-222343199$base_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m11857getLambda$222343199$base_generalProdRelease() {
        return f191lambda$222343199;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__2044380569$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C49@1855L46,50@1948L51,48@1815L206:BoxSimpleTopBar.kt#osoi5s");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2044380569, i, -1, "com.box.android.base.presentation.components.topbar.simple.ComposableSingletons$BoxSimpleTopBarKt.lambda$-2044380569.<anonymous> (BoxSimpleTopBar.kt:48)");
            }
            IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_arrow_left, composer, 0), StringResources_androidKt.stringResource(R.string.back_button_talkback_label, composer, 0), (Modifier) null, 0L, composer, Painter.$stable, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__222343199$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C70@2762L52,71@2865L118,74@3029L6,69@2718L357:BoxSimpleTopBar.kt#osoi5s");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-222343199, i, -1, "com.box.android.base.presentation.components.topbar.simple.ComposableSingletons$BoxSimpleTopBarKt.lambda$-222343199.<anonymous> (BoxSimpleTopBar.kt:69)");
            }
            IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_toolbar_back_btn, composer, 0), StringResources_androidKt.stringResource(R.string.back_button_talkback_label, composer, 0), (Modifier) null, BoxTheme.INSTANCE.getColors(composer, 6).m11577getTopBarControl0d7_KjU(), composer, Painter.$stable, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1566857783$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C103@3934L3,101@3866L121:BoxSimpleTopBar.kt#osoi5s");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1566857783, i, -1, "com.box.android.base.presentation.components.topbar.simple.ComposableSingletons$BoxSimpleTopBarKt.lambda$-1566857783.<anonymous> (BoxSimpleTopBar.kt:101)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1783193932, "CC(remember):BoxSimpleTopBar.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.base.presentation.components.topbar.simple.ComposableSingletons$BoxSimpleTopBarKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxSimpleTopBarKt.BoxSimpleTopBar("Inbox", (Function0) objRememberedValue, null, true, null, composer, 3126, 20);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
