package com.box.android.data.service.impl;

import android.content.Context;
import com.box.android.data.api.utils.CoroutineUtilsKt;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.ISessionManager;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.auth.BoxAuthentication;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.models.BoxSharedLinkSession;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.requests.BoxResponse;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* JADX INFO: compiled from: SessionManager.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u0004\u0018\u00010\tH\u0096@¢\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0096@¢\u0006\u0002\u0010\nJ\u000e\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\nJ\b\u0010\u0010\u001a\u00020\tH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/box/android/data/service/impl/SessionManager;", "Lcom/box/android/domain/services/ISessionManager;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "context", "Landroid/content/Context;", "<init>", "(Lcom/box/android/domain/identity/IUserContextManager;Landroid/content/Context;)V", "getAccessToken", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAccessTokenWithExpiration", "Lkotlin/Pair;", "", "refreshSession", "", "getUserAgent", "getSharedLink", "getSharedLinkPassword", "getBoxUser", "Lcom/box/androidsdk/content/models/BoxUser;", "getBoxSession", "Lcom/box/androidsdk/content/models/BoxSession;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SessionManager implements ISessionManager {
    private final Context context;
    private final IUserContextManager userContextManager;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.SessionManager$getAccessToken$1, reason: invalid class name */
    /* JADX INFO: compiled from: SessionManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.SessionManager", f = "SessionManager.kt", i = {0}, l = {20}, m = "getAccessToken", n = {"accessToken"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SessionManager.this.getAccessToken(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.SessionManager$getAccessTokenWithExpiration$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SessionManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.SessionManager", f = "SessionManager.kt", i = {0}, l = {28}, m = "getAccessTokenWithExpiration", n = {"accessTokenWithExpiration"}, s = {"L$0"}, v = 1)
    static final class C15231 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C15231(Continuation<? super C15231> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SessionManager.this.getAccessTokenWithExpiration(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.SessionManager$refreshSession$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SessionManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.SessionManager", f = "SessionManager.kt", i = {0}, l = {41}, m = "refreshSession", n = {"success"}, s = {"L$0"}, v = 1)
    static final class C15251 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C15251(Continuation<? super C15251> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SessionManager.this.refreshSession(this);
        }
    }

    @Inject
    public SessionManager(IUserContextManager userContextManager, Context context) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(context, "context");
        this.userContextManager = userContextManager;
        this.context = context;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.ISessionManager
    public Object getAccessToken(Continuation<? super String> continuation) {
        AnonymousClass1 anonymousClass1;
        Ref.ObjectRef objectRef;
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
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            ExecutorCoroutineDispatcher singleThreadContext = CoroutineUtilsKt.getSingleThreadContext();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(objectRef2, this, null);
            anonymousClass1.L$0 = objectRef2;
            anonymousClass1.label = 1;
            if (BuildersKt.withContext(singleThreadContext, anonymousClass2, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (Ref.ObjectRef) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return objectRef.element;
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.SessionManager$getAccessToken$2, reason: invalid class name */
    /* JADX INFO: compiled from: SessionManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.SessionManager$getAccessToken$2", f = "SessionManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<String> $accessToken;
        int label;
        final /* synthetic */ SessionManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Ref.ObjectRef<String> objectRef, SessionManager sessionManager, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$accessToken = objectRef;
            this.this$0 = sessionManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$accessToken, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef<String> objectRef = this.$accessToken;
            BoxAuthentication.BoxAuthenticationInfo authInfo = this.this$0.userContextManager.getBoxSession(this.this$0.context).getAuthInfo();
            objectRef.element = authInfo != null ? authInfo.accessToken() : 0;
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.ISessionManager
    public Object getAccessTokenWithExpiration(Continuation<? super Pair<String, Long>> continuation) {
        C15231 c15231;
        Ref.ObjectRef objectRef;
        if (continuation instanceof C15231) {
            c15231 = (C15231) continuation;
            if ((c15231.label & Integer.MIN_VALUE) != 0) {
                c15231.label -= Integer.MIN_VALUE;
            } else {
                c15231 = new C15231(continuation);
            }
        } else {
            c15231 = new C15231(continuation);
        }
        Object obj = c15231.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c15231.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            ExecutorCoroutineDispatcher singleThreadContext = CoroutineUtilsKt.getSingleThreadContext();
            C15242 c15242 = new C15242(objectRef2, null);
            c15231.L$0 = objectRef2;
            c15231.label = 1;
            if (BuildersKt.withContext(singleThreadContext, c15242, c15231) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (Ref.ObjectRef) c15231.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return objectRef.element;
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.SessionManager$getAccessTokenWithExpiration$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SessionManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.SessionManager$getAccessTokenWithExpiration$2", f = "SessionManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C15242 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<Pair<String, Long>> $accessTokenWithExpiration;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15242(Ref.ObjectRef<Pair<String, Long>> objectRef, Continuation<? super C15242> continuation) {
            super(2, continuation);
            this.$accessTokenWithExpiration = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SessionManager.this.new C15242(this.$accessTokenWithExpiration, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C15242) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                BoxAuthentication.BoxAuthenticationInfo authInfo = SessionManager.this.userContextManager.getBoxSession(SessionManager.this.context).getAuthInfo();
                this.$accessTokenWithExpiration.element = authInfo != null ? new Pair(authInfo.accessToken(), authInfo.expiresIn()) : 0;
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.ISessionManager
    public Object refreshSession(Continuation<? super Boolean> continuation) {
        C15251 c15251;
        Ref.BooleanRef booleanRef;
        if (continuation instanceof C15251) {
            c15251 = (C15251) continuation;
            if ((c15251.label & Integer.MIN_VALUE) != 0) {
                c15251.label -= Integer.MIN_VALUE;
            } else {
                c15251 = new C15251(continuation);
            }
        } else {
            c15251 = new C15251(continuation);
        }
        Object obj = c15251.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c15251.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            ExecutorCoroutineDispatcher singleThreadContext = CoroutineUtilsKt.getSingleThreadContext();
            C15262 c15262 = new C15262(booleanRef2, null);
            c15251.L$0 = booleanRef2;
            c15251.label = 1;
            if (BuildersKt.withContext(singleThreadContext, c15262, c15251) == coroutine_suspended) {
                return coroutine_suspended;
            }
            booleanRef = booleanRef2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            booleanRef = (Ref.BooleanRef) c15251.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxBoolean(booleanRef.element);
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.SessionManager$refreshSession$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SessionManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.SessionManager$refreshSession$2", f = "SessionManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C15262 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.BooleanRef $success;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15262(Ref.BooleanRef booleanRef, Continuation<? super C15262> continuation) {
            super(2, continuation);
            this.$success = booleanRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SessionManager.this.new C15262(this.$success, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C15262) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                BoxFutureTask<BoxSession> boxFutureTaskRefresh = SessionManager.this.userContextManager.getBoxSession(SessionManager.this.context).refresh();
                BoxResponse boxResponse = boxFutureTaskRefresh != null ? boxFutureTaskRefresh.get() : null;
                if (boxResponse == null) {
                    return null;
                }
                this.$success.element = boxResponse.isSuccess();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.box.android.domain.services.ISessionManager
    public String getUserAgent() {
        String userAgent = this.userContextManager.getBoxSession(this.context).getUserAgent();
        Intrinsics.checkNotNullExpressionValue(userAgent, "getUserAgent(...)");
        return userAgent;
    }

    @Override // com.box.android.domain.services.ISessionManager
    public String getSharedLink() {
        BoxSession boxSession = this.userContextManager.getBoxSession(this.context);
        BoxSharedLinkSession boxSharedLinkSession = boxSession instanceof BoxSharedLinkSession ? (BoxSharedLinkSession) boxSession : null;
        if (boxSharedLinkSession != null) {
            return boxSharedLinkSession.getSharedLink();
        }
        return null;
    }

    @Override // com.box.android.domain.services.ISessionManager
    public String getSharedLinkPassword() {
        BoxSession boxSession = this.userContextManager.getBoxSession(this.context);
        BoxSharedLinkSession boxSharedLinkSession = boxSession instanceof BoxSharedLinkSession ? (BoxSharedLinkSession) boxSession : null;
        if (boxSharedLinkSession != null) {
            return boxSharedLinkSession.getPassword();
        }
        return null;
    }

    public final BoxUser getBoxUser() {
        return this.userContextManager.getBoxSession(this.context).getUser();
    }

    public final BoxSession getBoxSession() {
        return this.userContextManager.getBoxSession(this.context);
    }
}
