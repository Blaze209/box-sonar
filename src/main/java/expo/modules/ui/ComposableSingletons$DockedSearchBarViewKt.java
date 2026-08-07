package expo.modules.ui;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DockedSearchBarView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public final class ComposableSingletons$DockedSearchBarViewKt {
    public static final ComposableSingletons$DockedSearchBarViewKt INSTANCE = new ComposableSingletons$DockedSearchBarViewKt();
    private static Function3<ColumnScope, Composer, Integer, Unit> lambda$304213221 = ComposableLambdaKt.composableLambdaInstance(304213221, false, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: expo.modules.ui.ComposableSingletons$DockedSearchBarViewKt$lambda$304213221$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
            invoke(columnScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(ColumnScope DockedSearchBar, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(DockedSearchBar, "$this$DockedSearchBar");
            ComposerKt.sourceInformation(composer, "C:DockedSearchBarView.kt#v15e7d");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(304213221, i, -1, "expo.modules.ui.ComposableSingletons$DockedSearchBarViewKt.lambda$304213221.<anonymous> (DockedSearchBarView.kt:51)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    public final Function3<ColumnScope, Composer, Integer, Unit> getLambda$304213221$expo_ui_release() {
        return lambda$304213221;
    }
}
