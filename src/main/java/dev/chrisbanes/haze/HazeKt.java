package dev.chrisbanes.haze;

import androidx.compose.ui.Modifier;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Haze.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0000\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a*\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¨\u0006\t"}, d2 = {"haze", "Landroidx/compose/ui/Modifier;", "state", "Ldev/chrisbanes/haze/HazeState;", "hazeSource", ViewProps.Z_INDEX, "", "key", "", "haze_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class HazeKt {
    @Deprecated(message = "Renamed to Modifier.hazeSource()", replaceWith = @ReplaceWith(expression = "hazeSource(state)", imports = {"dev.chrisbanes.haze.hazeSource"}))
    public static final Modifier haze(Modifier modifier, HazeState state) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        return hazeSource$default(modifier, state, 0.0f, null, 6, null);
    }

    public static /* synthetic */ Modifier hazeSource$default(Modifier modifier, HazeState hazeState, float f, Object obj, int i, Object obj2) {
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            obj = null;
        }
        return hazeSource(modifier, hazeState, f, obj);
    }

    public static final Modifier hazeSource(Modifier modifier, HazeState state, float f, Object obj) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        return modifier.then(new HazeSourceElement(state, f, obj));
    }
}
