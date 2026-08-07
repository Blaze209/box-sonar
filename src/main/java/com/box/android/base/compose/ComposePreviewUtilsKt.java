package com.box.android.base.compose;

import com.box.android.cpl.Reducable;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.Store;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: ComposePreviewUtils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a+\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"createMockStore", "Lcom/box/android/cpl/Store;", "State", "Action", "state", "(Ljava/lang/Object;)Lcom/box/android/cpl/Store;", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ComposePreviewUtilsKt {
    public static final <State, Action> Store<State, Action> createMockStore(State state) {
        return new Store<>(state, null, new Reducable<State, Action>() { // from class: com.box.android.base.compose.ComposePreviewUtilsKt.createMockStore.1
            @Override // com.box.android.cpl.Reducable
            public /* bridge */ Reducable<State, Action> getBuild() {
                return Reducable.DefaultImpls.getBuild(this);
            }

            @Override // com.box.android.cpl.Reducable
            public /* bridge */ ReducerResult<State, Action> reduce(State state2, Action action) {
                return Reducable.DefaultImpls.reduce(this, state2, action);
            }
        }, CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, 18, null);
    }
}
