package com.box.android.cpl;

import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: StoreFactory.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JI\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u0006\u001a\u0002H\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\b2\u0006\u0010\t\u001a\u00020\nH&¢\u0006\u0002\u0010\u000bJQ\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u0002H\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\b2\u0006\u0010\t\u001a\u00020\nH&¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/box/android/cpl/IStoreFactory;", "", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/box/android/cpl/Store;", "State", "Action", "initialState", "reducable", "Lcom/box/android/cpl/Reducable;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Ljava/lang/Object;Lcom/box/android/cpl/Reducable;Lkotlinx/coroutines/CoroutineScope;)Lcom/box/android/cpl/Store;", "key", "", "(Ljava/lang/String;Ljava/lang/Object;Lcom/box/android/cpl/Reducable;Lkotlinx/coroutines/CoroutineScope;)Lcom/box/android/cpl/Store;", "cpl-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface IStoreFactory {
    <State, Action> Store<State, Action> create(State initialState, Reducable<State, Action> reducable, CoroutineScope coroutineScope);

    <State, Action> Store<State, Action> create(String key, State initialState, Reducable<State, Action> reducable, CoroutineScope coroutineScope);
}
