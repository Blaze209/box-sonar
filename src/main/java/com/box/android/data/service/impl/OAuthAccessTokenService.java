package com.box.android.data.service.impl;

import com.box.android.domain.services.AuthTokenService;
import com.box.android.domain.services.ISessionManager;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: OAuthAccessTokenService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096@¢\u0006\u0002\u0010\bJ\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0096@¢\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/box/android/data/service/impl/OAuthAccessTokenService;", "Lcom/box/android/domain/services/AuthTokenService;", "sessionManager", "Lcom/box/android/domain/services/ISessionManager;", "<init>", "(Lcom/box/android/domain/services/ISessionManager;)V", "getAccessToken", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAccessTokenWithExpiration", "Lkotlin/Pair;", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OAuthAccessTokenService implements AuthTokenService {
    private final ISessionManager sessionManager;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.OAuthAccessTokenService$getAccessToken$1, reason: invalid class name */
    /* JADX INFO: compiled from: OAuthAccessTokenService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.OAuthAccessTokenService", f = "OAuthAccessTokenService.kt", i = {}, l = {9}, m = "getAccessToken", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OAuthAccessTokenService.this.getAccessToken(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.OAuthAccessTokenService$getAccessTokenWithExpiration$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OAuthAccessTokenService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.OAuthAccessTokenService", f = "OAuthAccessTokenService.kt", i = {1, 1, 2, 2}, l = {12, 15, 16}, m = "getAccessTokenWithExpiration", n = {"accessToken", "expiresIn", "accessToken", "expiresIn"}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 1)
    static final class C14701 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C14701(Continuation<? super C14701> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OAuthAccessTokenService.this.getAccessTokenWithExpiration(this);
        }
    }

    @Inject
    public OAuthAccessTokenService(ISessionManager sessionManager) {
        Intrinsics.checkNotNullParameter(sessionManager, "sessionManager");
        this.sessionManager = sessionManager;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.AuthTokenService
    public Object getAccessToken(Continuation<? super String> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object accessTokenWithExpiration = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(accessTokenWithExpiration);
            anonymousClass1.label = 1;
            accessTokenWithExpiration = getAccessTokenWithExpiration(anonymousClass1);
            if (accessTokenWithExpiration == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(accessTokenWithExpiration);
        }
        Pair pair = (Pair) accessTokenWithExpiration;
        if (pair != null) {
            return (String) pair.getFirst();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:36:0x00af  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v1, types: [T, java.lang.Object] */
    @Override // com.box.android.domain.services.AuthTokenService
    public Object getAccessTokenWithExpiration(Continuation<? super Pair<String, Long>> continuation) {
        C14701 c14701;
        Ref.ObjectRef objectRef;
        Ref.LongRef longRef;
        Ref.ObjectRef objectRef2;
        Ref.LongRef longRef2;
        Ref.LongRef longRef3;
        Ref.ObjectRef objectRef3;
        Pair pair;
        if (continuation instanceof C14701) {
            c14701 = (C14701) continuation;
            if ((c14701.label & Integer.MIN_VALUE) != 0) {
                c14701.label -= Integer.MIN_VALUE;
            } else {
                c14701 = new C14701(continuation);
            }
        } else {
            c14701 = new C14701(continuation);
        }
        Object accessTokenWithExpiration = c14701.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14701.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(accessTokenWithExpiration);
            } else {
                if (i == 2) {
                    longRef2 = (Ref.LongRef) c14701.L$1;
                    objectRef2 = (Ref.ObjectRef) c14701.L$0;
                    ResultKt.throwOnFailure(accessTokenWithExpiration);
                    ISessionManager iSessionManager = this.sessionManager;
                    c14701.L$0 = objectRef2;
                    c14701.L$1 = longRef2;
                    c14701.label = 3;
                    accessTokenWithExpiration = iSessionManager.getAccessTokenWithExpiration(c14701);
                    if (accessTokenWithExpiration != coroutine_suspended) {
                        longRef3 = longRef2;
                        objectRef3 = objectRef2;
                    }
                    return coroutine_suspended;
                }
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                longRef3 = (Ref.LongRef) c14701.L$1;
                objectRef3 = (Ref.ObjectRef) c14701.L$0;
                ResultKt.throwOnFailure(accessTokenWithExpiration);
            }
            pair = (Pair) accessTokenWithExpiration;
            if (pair != null) {
                return null;
            }
            objectRef3.element = pair.getFirst();
            longRef3.element = ((Number) pair.getSecond()).longValue();
            longRef = longRef3;
            objectRef = objectRef3;
            return TuplesKt.to(objectRef.element, Boxing.boxLong(longRef.element));
        }
        ResultKt.throwOnFailure(accessTokenWithExpiration);
        ISessionManager iSessionManager2 = this.sessionManager;
        c14701.label = 1;
        accessTokenWithExpiration = iSessionManager2.getAccessTokenWithExpiration(c14701);
        if (accessTokenWithExpiration != coroutine_suspended) {
        }
        return coroutine_suspended;
        Pair pair2 = (Pair) accessTokenWithExpiration;
        if (pair2 == null) {
            return null;
        }
        objectRef = new Ref.ObjectRef();
        objectRef.element = pair2.component1();
        longRef = new Ref.LongRef();
        longRef.element = ((Number) pair2.component2()).longValue();
        if (longRef.element < 60) {
            ISessionManager iSessionManager3 = this.sessionManager;
            c14701.L$0 = objectRef;
            c14701.L$1 = longRef;
            c14701.label = 2;
            if (iSessionManager3.refreshSession(c14701) != coroutine_suspended) {
                objectRef2 = objectRef;
                longRef2 = longRef;
                ISessionManager iSessionManager4 = this.sessionManager;
                c14701.L$0 = objectRef2;
                c14701.L$1 = longRef2;
                c14701.label = 3;
                accessTokenWithExpiration = iSessionManager4.getAccessTokenWithExpiration(c14701);
                if (accessTokenWithExpiration != coroutine_suspended) {
                    longRef3 = longRef2;
                    objectRef3 = objectRef2;
                    pair = (Pair) accessTokenWithExpiration;
                    if (pair != null) {
                        return null;
                    }
                    objectRef3.element = pair.getFirst();
                    longRef3.element = ((Number) pair.getSecond()).longValue();
                    longRef = longRef3;
                    objectRef = objectRef3;
                }
            }
            return coroutine_suspended;
        }
        return TuplesKt.to(objectRef.element, Boxing.boxLong(longRef.element));
    }
}
