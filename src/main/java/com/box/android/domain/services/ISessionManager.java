package com.box.android.domain.services;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: ISessionManager.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003H¦@¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H¦@¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u0003H&J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\f\u001a\u0004\u0018\u00010\u0003H&¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/ISessionManager;", "", "getAccessToken", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAccessTokenWithExpiration", "Lkotlin/Pair;", "", "refreshSession", "", "getUserAgent", "getSharedLink", "getSharedLinkPassword", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ISessionManager {
    Object getAccessToken(Continuation<? super String> continuation);

    Object getAccessTokenWithExpiration(Continuation<? super Pair<String, Long>> continuation);

    String getSharedLink();

    String getSharedLinkPassword();

    String getUserAgent();

    Object refreshSession(Continuation<? super Boolean> continuation);
}
