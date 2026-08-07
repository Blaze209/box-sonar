package com.box.android.cpl;

import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: StoreFactory.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JI\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u00062\u0006\u0010\u0007\u001a\u0002H\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\fJQ\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u0002H\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/box/android/cpl/StoreFactory;", "Lcom/box/android/cpl/IStoreFactory;", "()V", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/box/android/cpl/Store;", "State", "Action", "initialState", "reducable", "Lcom/box/android/cpl/Reducable;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Ljava/lang/Object;Lcom/box/android/cpl/Reducable;Lkotlinx/coroutines/CoroutineScope;)Lcom/box/android/cpl/Store;", "key", "", "(Ljava/lang/String;Ljava/lang/Object;Lcom/box/android/cpl/Reducable;Lkotlinx/coroutines/CoroutineScope;)Lcom/box/android/cpl/Store;", "cpl-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class StoreFactory implements IStoreFactory {
    @Override // com.box.android.cpl.IStoreFactory
    public <State, Action> Store<State, Action> create(State initialState, Reducable<State, Action> reducable, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(reducable, "reducable");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        return new Store<>(initialState, null, reducable, coroutineScope, null, 18, null);
    }

    @Override // com.box.android.cpl.IStoreFactory
    public <State, Action> Store<State, Action> create(String key, State initialState, Reducable<State, Action> reducable, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(reducable, "reducable");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        return new Store<>(initialState, key, reducable, coroutineScope, null, 16, null);
    }
}
