package dev.chrisbanes.haze;

import androidx.compose.ui.Modifier;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HazeChild.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001b\b\u0002\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\nH\u0007\u001a;\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001b\b\u0002\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\nH\u0007¨\u0006\f"}, d2 = {"hazeChild", "Landroidx/compose/ui/Modifier;", "state", "Ldev/chrisbanes/haze/HazeState;", "style", "Ldev/chrisbanes/haze/HazeStyle;", "block", "Lkotlin/Function1;", "Ldev/chrisbanes/haze/HazeEffectScope;", "", "Lkotlin/ExtensionFunctionType;", "hazeEffect", "haze_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class HazeChildKt {
    public static /* synthetic */ Modifier hazeChild$default(Modifier modifier, HazeState hazeState, HazeStyle hazeStyle, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            hazeStyle = HazeStyle.INSTANCE.getUnspecified();
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        return hazeChild(modifier, hazeState, hazeStyle, function1);
    }

    @Deprecated(message = "Renamed to Modifier.hazeEffect()", replaceWith = @ReplaceWith(expression = "hazeEffect(state, style, block)", imports = {"dev.chrisbanes.haze.hazeEffect"}))
    public static final Modifier hazeChild(Modifier modifier, HazeState state, HazeStyle style, Function1<? super HazeEffectScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(style, "style");
        return hazeEffect(modifier, state, style, function1);
    }

    public static /* synthetic */ Modifier hazeEffect$default(Modifier modifier, HazeState hazeState, HazeStyle hazeStyle, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            hazeStyle = HazeStyle.INSTANCE.getUnspecified();
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        return hazeEffect(modifier, hazeState, hazeStyle, function1);
    }

    public static final Modifier hazeEffect(Modifier modifier, HazeState state, HazeStyle style, Function1<? super HazeEffectScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(style, "style");
        return modifier.then(new HazeEffectNodeElement(state, style, function1));
    }
}
