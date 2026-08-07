package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: AlertDialog.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
public final class AlertDialogKt$AlertDialogImpl$2 implements Function2<Composer, Integer, Unit> {

    /* JADX INFO: renamed from: $$v$c$androidx-compose-ui-graphics-Color$-backgroundColor$0, reason: not valid java name */
    final /* synthetic */ long f63$$v$c$androidxcomposeuigraphicsColor$backgroundColor$0;

    /* JADX INFO: renamed from: $$v$c$androidx-compose-ui-graphics-Color$-contentColor$0, reason: not valid java name */
    final /* synthetic */ long f64$$v$c$androidxcomposeuigraphicsColor$contentColor$0;
    final /* synthetic */ Function2<Composer, Integer, Unit> $buttons;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ Function2<Composer, Integer, Unit> $text;
    final /* synthetic */ Function2<Composer, Integer, Unit> $title;

    /* JADX WARN: Multi-variable type inference failed */
    public AlertDialogKt$AlertDialogImpl$2(Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, Shape shape, long j, long j2) {
        this.$buttons = function2;
        this.$modifier = modifier;
        this.$title = function3;
        this.$text = function4;
        this.$shape = shape;
        this.f63$$v$c$androidxcomposeuigraphicsColor$backgroundColor$0 = j;
        this.f64$$v$c$androidxcomposeuigraphicsColor$contentColor$0 = j2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C181@7963L260:AlertDialog.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-488319269, i, -1, "androidx.compose.material.AlertDialogImpl.<anonymous> (AlertDialog.kt:181)");
        }
        AlertDialogKt.m2231AlertDialogContentWMdw5o4(this.$buttons, this.$modifier, this.$title, this.$text, this.$shape, this.f63$$v$c$androidxcomposeuigraphicsColor$backgroundColor$0, this.f64$$v$c$androidxcomposeuigraphicsColor$contentColor$0, composer, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
