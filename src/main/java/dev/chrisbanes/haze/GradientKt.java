package dev.chrisbanes.haze;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Gradient.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"asBrush", "Landroidx/compose/ui/graphics/Brush;", "Ldev/chrisbanes/haze/HazeProgressive$LinearGradient;", "numStops", "", "haze_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class GradientKt {
    public static /* synthetic */ Brush asBrush$default(HazeProgressive.LinearGradient linearGradient, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 20;
        }
        return asBrush(linearGradient, i);
    }

    public static final Brush asBrush(HazeProgressive.LinearGradient linearGradient, int i) {
        Intrinsics.checkNotNullParameter(linearGradient, "<this>");
        Brush.Companion companion = Brush.INSTANCE;
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(Color.m6804boximpl(Color.m6813copywmQWz5c$default(Color.INSTANCE.m6847getMagenta0d7_KjU(), UtilsKt.lerp(linearGradient.getStartIntensity(), linearGradient.getEndIntensity(), linearGradient.getEasing().transform((i2 * 1.0f) / (i - 1))), 0.0f, 0.0f, 0.0f, 14, null)));
        }
        return Brush.Companion.m6763linearGradientmHitzGk$default(companion, arrayList, linearGradient.m14488getStartF1C5BW0(), linearGradient.m14487getEndF1C5BW0(), 0, 8, (Object) null);
    }
}
