package com.pspdfkit.jetpack.compose.components;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.res.PainterResources_androidKt;
import com.pspdfkit.R;
import com.pspdfkit.compose.theme.UiTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class ComposableSingletons$MainToolbarKt {
    public static final ComposableSingletons$MainToolbarKt INSTANCE = new ComposableSingletons$MainToolbarKt();
    private static Function3<Color, Composer, Integer, Unit> lambda$1623726612 = ComposableLambdaKt.composableLambdaInstance(1623726612, false, new Function3<Color, Composer, Integer, Unit>() { // from class: com.pspdfkit.jetpack.compose.components.ComposableSingletons$MainToolbarKt$lambda$1623726612$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Color color, Composer composer, Integer num) {
            m14057invokeek8zF_U(color.m6824unboximpl(), composer, num.intValue());
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke-ek8zF_U, reason: not valid java name */
        public final void m14057invokeek8zF_U(long j, Composer composer, int i) {
            if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1623726612, i, -1, "com.pspdfkit.jetpack.compose.components.ComposableSingletons$MainToolbarKt.lambda$1623726612.<anonymous> (MainToolbar.kt:92)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });
    private static Function4<RowScope, Color, Composer, Integer, Unit> lambda$1210789952 = ComposableLambdaKt.composableLambdaInstance(1210789952, false, new Function4<RowScope, Color, Composer, Integer, Unit>() { // from class: com.pspdfkit.jetpack.compose.components.ComposableSingletons$MainToolbarKt$lambda$1210789952$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Color color, Composer composer, Integer num) {
            m14056invokeRPmYEkk(rowScope, color.m6824unboximpl(), composer, num.intValue());
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke-RPmYEkk, reason: not valid java name */
        public final void m14056invokeRPmYEkk(RowScope rowScope, long j, Composer composer, int i) {
            rowScope.getClass();
            if (!composer.shouldExecute((i & 129) != 128, i & 1)) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1210789952, i, -1, "com.pspdfkit.jetpack.compose.components.ComposableSingletons$MainToolbarKt.lambda$1210789952.<anonymous> (MainToolbar.kt:93)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda$-414266515, reason: not valid java name */
    private static Function4<ColumnScope, Color, Composer, Integer, Unit> f253lambda$414266515 = ComposableLambdaKt.composableLambdaInstance(-414266515, false, new Function4<ColumnScope, Color, Composer, Integer, Unit>() { // from class: com.pspdfkit.jetpack.compose.components.ComposableSingletons$MainToolbarKt$lambda$-414266515$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Color color, Composer composer, Integer num) {
            m14055invokeRPmYEkk(columnScope, color.m6824unboximpl(), composer, num.intValue());
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke-RPmYEkk, reason: not valid java name */
        public final void m14055invokeRPmYEkk(ColumnScope columnScope, long j, Composer composer, int i) {
            columnScope.getClass();
            if (!composer.shouldExecute((i & 129) != 128, i & 1)) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-414266515, i, -1, "com.pspdfkit.jetpack.compose.components.ComposableSingletons$MainToolbarKt.lambda$-414266515.<anonymous> (MainToolbar.kt:145)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda$-1062889127, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f252lambda$1062889127 = ComposableLambdaKt.composableLambdaInstance(-1062889127, false, new Function2() { // from class: com.pspdfkit.jetpack.compose.components.ComposableSingletons$MainToolbarKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$MainToolbarKt.lambda__1062889127$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1062889127$lambda$0(Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1062889127, i, -1, "com.pspdfkit.jetpack.compose.components.ComposableSingletons$MainToolbarKt.lambda$-1062889127.<anonymous> (MainToolbar.kt:198)");
            }
            IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.pspdf__ic_more, composer, 0), (String) null, (Modifier) null, UiTheme.INSTANCE.getColors(composer, 6).getMainToolbar().m13943getTextColor0d7_KjU(), composer, Painter.$stable | 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: getLambda$-1062889127$sdk_nutrient, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m14053getLambda$1062889127$sdk_nutrient() {
        return f252lambda$1062889127;
    }

    /* JADX INFO: renamed from: getLambda$-414266515$sdk_nutrient, reason: not valid java name */
    public final Function4<ColumnScope, Color, Composer, Integer, Unit> m14054getLambda$414266515$sdk_nutrient() {
        return f253lambda$414266515;
    }

    public final Function4<RowScope, Color, Composer, Integer, Unit> getLambda$1210789952$sdk_nutrient() {
        return lambda$1210789952;
    }

    public final Function3<Color, Composer, Integer, Unit> getLambda$1623726612$sdk_nutrient() {
        return lambda$1623726612;
    }
}
