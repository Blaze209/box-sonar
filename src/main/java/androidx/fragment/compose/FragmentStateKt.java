package androidx.fragment.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: FragmentState.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0000\u001a\f\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u00030\u0001H\u0002\u001a\r\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"fragmentStateSaver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/fragment/compose/FragmentState;", "rememberFragmentState", "(Landroidx/compose/runtime/Composer;I)Landroidx/fragment/compose/FragmentState;", "fragment-compose_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FragmentStateKt {
    public static final FragmentState rememberFragmentState(Composer composer, int i) {
        composer.startReplaceableGroup(-496803845);
        ComposerKt.sourceInformation(composer, "C(rememberFragmentState)32@1157L78:FragmentState.kt#dnbm1l");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-496803845, i, -1, "androidx.fragment.compose.rememberFragmentState (FragmentState.kt:31)");
        }
        FragmentState fragmentState = (FragmentState) RememberSaveableKt.m6246rememberSaveable(new Object[0], (Saver) fragmentStateSaver(), (String) null, (Function0) new Function0<FragmentState>() { // from class: androidx.fragment.compose.FragmentStateKt.rememberFragmentState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FragmentState invoke() {
                return new FragmentState(null, 1, null);
            }
        }, composer, 3072, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return fragmentState;
    }

    private static final Saver<FragmentState, ?> fragmentStateSaver() {
        return SaverKt.Saver(new Function2<SaverScope, FragmentState, MutableState<Fragment.SavedState>>() { // from class: androidx.fragment.compose.FragmentStateKt.fragmentStateSaver.1
            @Override // kotlin.jvm.functions.Function2
            public final MutableState<Fragment.SavedState> invoke(SaverScope saverScope, FragmentState fragmentState) {
                return fragmentState.getState$fragment_compose_release();
            }
        }, new Function1<MutableState<Fragment.SavedState>, FragmentState>() { // from class: androidx.fragment.compose.FragmentStateKt.fragmentStateSaver.2
            @Override // kotlin.jvm.functions.Function1
            public final FragmentState invoke(MutableState<Fragment.SavedState> mutableState) {
                return new FragmentState(mutableState);
            }
        });
    }
}
