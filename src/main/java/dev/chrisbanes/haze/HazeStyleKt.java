package dev.chrisbanes.haze;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HazeStyle.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0005\u001a\u00020\u0006*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0080\bø\u0001\u0000\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"LocalHazeStyle", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Ldev/chrisbanes/haze/HazeStyle;", "getLocalHazeStyle", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "takeOrElse", "", "block", "Lkotlin/Function0;", "haze_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class HazeStyleKt {
    private static final ProvidableCompositionLocal<HazeStyle> LocalHazeStyle = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: dev.chrisbanes.haze.HazeStyleKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return HazeStyleKt.LocalHazeStyle$lambda$0();
        }
    }, 1, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final HazeStyle LocalHazeStyle$lambda$0() {
        return HazeStyle.INSTANCE.getUnspecified();
    }

    public static final ProvidableCompositionLocal<HazeStyle> getLocalHazeStyle() {
        return LocalHazeStyle;
    }

    public static final float takeOrElse(float f, Function0<Float> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return (0.0f > f || f > 1.0f) ? block.invoke().floatValue() : f;
    }
}
