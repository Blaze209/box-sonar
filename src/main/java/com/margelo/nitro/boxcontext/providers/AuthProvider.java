package com.margelo.nitro.boxcontext.providers;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: AuthProvider.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/margelo/nitro/boxcontext/providers/AuthProvider;", "", "getAuthToken", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface AuthProvider {
    Object getAuthToken(Continuation<? super String> continuation);
}
