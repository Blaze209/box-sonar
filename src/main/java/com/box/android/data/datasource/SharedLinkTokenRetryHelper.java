package com.box.android.data.datasource;

import androidx.exifinterface.media.ExifInterface;
import com.box.android.coreservices.models.CustomBoxSession;
import com.box.android.data.api.models.auth.AccessTokenDTO;
import com.box.android.data.api.models.auth.ScopeDTO;
import com.box.android.data.api.requests.AuthRequest;
import com.box.android.data.service.impl.SessionManager;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.utils.result.Result;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.box.androidsdk.content.models.BoxSession;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: SharedLinkTokenRetryHelper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0088\u0001\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u00150\u0013\"\u0004\b\u0000\u0010\u0014\"\u0004\b\u0001\u0010\u00152\u0006\u0010\u0016\u001a\u00020\u001720\u0010\u0018\u001a,\b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u00150\u00130\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00192\u001e\u0010\u001b\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u00150\u0013\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u001fJ|\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u00150\u00130!\"\u0004\b\u0000\u0010\u0014\"\u0004\b\u0001\u0010\u00152\u0006\u0010\u0016\u001a\u00020\u00172&\u0010\u0018\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u00150\u00130!0\u001c2\u001e\u0010\u001b\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u00150\u0013\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\nJ(\u0010\"\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\nH\u0082@¢\u0006\u0002\u0010$J\u0012\u0010%\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010&\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006("}, d2 = {"Lcom/box/android/data/datasource/SharedLinkTokenRetryHelper;", "", "sessionManager", "Lcom/box/android/data/service/impl/SessionManager;", "authRequest", "Lcom/box/android/data/api/requests/AuthRequest;", "<init>", "(Lcom/box/android/data/service/impl/SessionManager;Lcom/box/android/data/api/requests/AuthRequest;)V", "downscopedTokenMapping", "", "", "Lcom/box/android/data/api/models/auth/AccessTokenDTO;", "boxSession", "Lcom/box/android/coreservices/models/CustomBoxSession;", "getBoxSession", "()Lcom/box/android/coreservices/models/CustomBoxSession;", "boxSession$delegate", "Lkotlin/Lazy;", "retryOnFailure", "Lcom/box/android/domain/utils/result/Result;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LONGITUDE_EAST, "itemId", "Lcom/box/android/domain/models/ItemId$Remote;", "requestBlock", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "evaluateForRetryableFailures", "Lkotlin/Function1;", "", "scope", "(Lcom/box/android/domain/models/ItemId$Remote;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retryOnFlowFailure", "Lkotlinx/coroutines/flow/Flow;", "getTokenWithSharedLinkContext", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "(Lcom/box/android/domain/models/ItemId$Remote;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getValidSavedDownscopedToken", "validateToken", "token", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SharedLinkTokenRetryHelper {
    private final AuthRequest authRequest;

    /* JADX INFO: renamed from: boxSession$delegate, reason: from kotlin metadata */
    private final Lazy boxSession;
    private final Map<String, AccessTokenDTO> downscopedTokenMapping;
    private final SessionManager sessionManager;

    /* JADX INFO: renamed from: com.box.android.data.datasource.SharedLinkTokenRetryHelper$getTokenWithSharedLinkContext$1, reason: invalid class name */
    /* JADX INFO: compiled from: SharedLinkTokenRetryHelper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.SharedLinkTokenRetryHelper", f = "SharedLinkTokenRetryHelper.kt", i = {0, 0, 0, 0, 0}, l = {93}, m = "getTokenWithSharedLinkContext", n = {"itemId", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "scope", "$i$f$resultOf", "$i$a$-resultOf-SharedLinkTokenRetryHelper$getTokenWithSharedLinkContext$token$1"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SharedLinkTokenRetryHelper.this.getTokenWithSharedLinkContext(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.SharedLinkTokenRetryHelper$retryOnFailure$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SharedLinkTokenRetryHelper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.SharedLinkTokenRetryHelper", f = "SharedLinkTokenRetryHelper.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {39, 49, 51}, m = "retryOnFailure", n = {"itemId", "requestBlock", "evaluateForRetryableFailures", "scope", "validatedToken", "itemId", "requestBlock", "evaluateForRetryableFailures", "scope", "validatedToken", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "cachedTokenForSharedLink", "isSharedLinkTokenUseful", "itemId", "requestBlock", "evaluateForRetryableFailures", "scope", "validatedToken", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "cachedTokenForSharedLink", "token", "isSharedLinkTokenUseful"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0"}, v = 1)
    static final class C10991<T, E> extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        C10991(Continuation<? super C10991> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SharedLinkTokenRetryHelper.this.retryOnFailure(null, null, null, null, this);
        }
    }

    @Inject
    public SharedLinkTokenRetryHelper(SessionManager sessionManager, AuthRequest authRequest) {
        Intrinsics.checkNotNullParameter(sessionManager, "sessionManager");
        Intrinsics.checkNotNullParameter(authRequest, "authRequest");
        this.sessionManager = sessionManager;
        this.authRequest = authRequest;
        this.downscopedTokenMapping = new LinkedHashMap();
        this.boxSession = LazyKt.lazy(new Function0() { // from class: com.box.android.data.datasource.SharedLinkTokenRetryHelper$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SharedLinkTokenRetryHelper.boxSession_delegate$lambda$0(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CustomBoxSession boxSession_delegate$lambda$0(SharedLinkTokenRetryHelper sharedLinkTokenRetryHelper) {
        BoxSession boxSession = sharedLinkTokenRetryHelper.sessionManager.getBoxSession();
        Intrinsics.checkNotNull(boxSession, "null cannot be cast to non-null type com.box.android.coreservices.models.CustomBoxSession");
        return (CustomBoxSession) boxSession;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CustomBoxSession getBoxSession() {
        return (CustomBoxSession) this.boxSession.getValue();
    }

    /* JADX WARN: Code duplicated, block: B:38:0x012f  */
    /* JADX WARN: Code duplicated, block: B:41:0x0170 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:42:0x0171 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final <T, E> Object retryOnFailure(ItemId.Remote remote, Function2<? super AccessTokenDTO, ? super Continuation<? super Result<? extends T, ? extends E>>, ? extends Object> function2, Function1<? super Result<? extends T, ? extends E>, Boolean> function1, String str, Continuation<? super Result<? extends T, ? extends E>> continuation) {
        C10991 c10991;
        AccessTokenDTO validSavedDownscopedToken;
        Object objInvoke;
        Function1<? super Result<? extends T, ? extends E>, Boolean> function3;
        Result result;
        String str2;
        AccessTokenDTO accessTokenDTO;
        int i;
        Function2<? super AccessTokenDTO, ? super Continuation<? super Result<? extends T, ? extends E>>, ? extends Object> function4;
        String str3;
        ItemId.Remote remote2;
        AccessTokenDTO accessTokenDTO2;
        AccessTokenDTO accessTokenDTO3;
        Object objInvoke2;
        if (continuation instanceof C10991) {
            c10991 = (C10991) continuation;
            if ((c10991.label & Integer.MIN_VALUE) != 0) {
                c10991.label -= Integer.MIN_VALUE;
            } else {
                c10991 = new C10991(continuation);
            }
        } else {
            c10991 = new C10991(continuation);
        }
        Object obj = c10991.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c10991.label;
        int i3 = 1;
        if (i2 != 0) {
            if (i2 == 1) {
                AccessTokenDTO accessTokenDTO4 = (AccessTokenDTO) c10991.L$4;
                str = (String) c10991.L$3;
                function1 = (Function1) c10991.L$2;
                function2 = (Function2) c10991.L$1;
                ItemId.Remote remote3 = (ItemId.Remote) c10991.L$0;
                ResultKt.throwOnFailure(obj);
                validSavedDownscopedToken = accessTokenDTO4;
                remote = remote3;
                objInvoke = obj;
            } else {
                if (i2 != 2) {
                    if (i2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i4 = c10991.I$0;
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                i = c10991.I$0;
                accessTokenDTO2 = (AccessTokenDTO) c10991.L$7;
                str3 = (String) c10991.L$6;
                result = (Result) c10991.L$5;
                accessTokenDTO = (AccessTokenDTO) c10991.L$4;
                str2 = (String) c10991.L$3;
                function3 = (Function1) c10991.L$2;
                function4 = (Function2) c10991.L$1;
                remote2 = (ItemId.Remote) c10991.L$0;
                ResultKt.throwOnFailure(obj);
            }
            accessTokenDTO3 = (AccessTokenDTO) obj;
            if (accessTokenDTO3 != null) {
                return result;
            }
            c10991.L$0 = SpillingKt.nullOutSpilledVariable(remote2);
            c10991.L$1 = SpillingKt.nullOutSpilledVariable(function4);
            c10991.L$2 = SpillingKt.nullOutSpilledVariable(function3);
            c10991.L$3 = SpillingKt.nullOutSpilledVariable(str2);
            c10991.L$4 = SpillingKt.nullOutSpilledVariable(accessTokenDTO);
            c10991.L$5 = SpillingKt.nullOutSpilledVariable(result);
            c10991.L$6 = SpillingKt.nullOutSpilledVariable(str3);
            c10991.L$7 = SpillingKt.nullOutSpilledVariable(accessTokenDTO2);
            c10991.L$8 = SpillingKt.nullOutSpilledVariable(accessTokenDTO3);
            c10991.I$0 = i;
            c10991.label = 3;
            objInvoke2 = function4.invoke(accessTokenDTO3, c10991);
            if (objInvoke2 != coroutine_suspended) {
                return coroutine_suspended;
            }
            return objInvoke2;
        }
        ResultKt.throwOnFailure(obj);
        validSavedDownscopedToken = getValidSavedDownscopedToken(remote);
        c10991.L$0 = remote;
        c10991.L$1 = function2;
        c10991.L$2 = function1;
        c10991.L$3 = str;
        c10991.L$4 = SpillingKt.nullOutSpilledVariable(validSavedDownscopedToken);
        c10991.label = 1;
        objInvoke = function2.invoke(validSavedDownscopedToken, c10991);
        if (objInvoke != coroutine_suspended) {
        }
        return coroutine_suspended;
        Result result2 = (Result) objInvoke;
        String sharedLink = getBoxSession().getSharedLink();
        AccessTokenDTO accessTokenDTO5 = this.downscopedTokenMapping.get(sharedLink);
        if (accessTokenDTO5 != null && !validateToken(remote, accessTokenDTO5)) {
            i3 = 0;
        }
        if (i3 == 0 || !function1.invoke(result2).booleanValue() || sharedLink == null) {
            return result2;
        }
        c10991.L$0 = SpillingKt.nullOutSpilledVariable(remote);
        c10991.L$1 = function2;
        c10991.L$2 = SpillingKt.nullOutSpilledVariable(function1);
        c10991.L$3 = SpillingKt.nullOutSpilledVariable(str);
        c10991.L$4 = SpillingKt.nullOutSpilledVariable(validSavedDownscopedToken);
        c10991.L$5 = result2;
        c10991.L$6 = SpillingKt.nullOutSpilledVariable(sharedLink);
        c10991.L$7 = SpillingKt.nullOutSpilledVariable(accessTokenDTO5);
        c10991.I$0 = i3;
        c10991.label = 2;
        Object tokenWithSharedLinkContext = getTokenWithSharedLinkContext(remote, sharedLink, str, c10991);
        if (tokenWithSharedLinkContext != coroutine_suspended) {
            function3 = function1;
            result = result2;
            str2 = str;
            accessTokenDTO = validSavedDownscopedToken;
            obj = tokenWithSharedLinkContext;
            i = i3;
            function4 = function2;
            str3 = sharedLink;
            remote2 = remote;
            accessTokenDTO2 = accessTokenDTO5;
            accessTokenDTO3 = (AccessTokenDTO) obj;
            if (accessTokenDTO3 != null) {
                return result;
            }
            c10991.L$0 = SpillingKt.nullOutSpilledVariable(remote2);
            c10991.L$1 = SpillingKt.nullOutSpilledVariable(function4);
            c10991.L$2 = SpillingKt.nullOutSpilledVariable(function3);
            c10991.L$3 = SpillingKt.nullOutSpilledVariable(str2);
            c10991.L$4 = SpillingKt.nullOutSpilledVariable(accessTokenDTO);
            c10991.L$5 = SpillingKt.nullOutSpilledVariable(result);
            c10991.L$6 = SpillingKt.nullOutSpilledVariable(str3);
            c10991.L$7 = SpillingKt.nullOutSpilledVariable(accessTokenDTO2);
            c10991.L$8 = SpillingKt.nullOutSpilledVariable(accessTokenDTO3);
            c10991.I$0 = i;
            c10991.label = 3;
            objInvoke2 = function4.invoke(accessTokenDTO3, c10991);
            if (objInvoke2 != coroutine_suspended) {
                return objInvoke2;
            }
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Add missing generic type declarations: [T, E] */
    /* JADX INFO: renamed from: com.box.android.data.datasource.SharedLinkTokenRetryHelper$retryOnFlowFailure$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SharedLinkTokenRetryHelper.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00050\u0004H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.SharedLinkTokenRetryHelper$retryOnFlowFailure$1", f = "SharedLinkTokenRetryHelper.kt", i = {0, 0}, l = {67}, m = "invokeSuspend", n = {"$this$flow", "validatedToken"}, s = {"L$0", "L$1"}, v = 1)
    static final class C11001<E, T> extends SuspendLambda implements Function2<FlowCollector<? super Result<? extends T, ? extends E>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Result<? extends T, ? extends E>, Boolean> $evaluateForRetryableFailures;
        final /* synthetic */ ItemId.Remote $itemId;
        final /* synthetic */ Function1<AccessTokenDTO, Flow<Result<T, E>>> $requestBlock;
        final /* synthetic */ String $scope;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C11001(ItemId.Remote remote, Function1<? super AccessTokenDTO, ? extends Flow<? extends Result<? extends T, ? extends E>>> function1, Function1<? super Result<? extends T, ? extends E>, Boolean> function2, String str, Continuation<? super C11001> continuation) {
            super(2, continuation);
            this.$itemId = remote;
            this.$requestBlock = function1;
            this.$evaluateForRetryableFailures = function2;
            this.$scope = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C11001 c11001 = SharedLinkTokenRetryHelper.this.new C11001(this.$itemId, this.$requestBlock, this.$evaluateForRetryableFailures, this.$scope, continuation);
            c11001.L$0 = obj;
            return c11001;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Result<? extends T, ? extends E>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C11001) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AccessTokenDTO validSavedDownscopedToken = SharedLinkTokenRetryHelper.this.getValidSavedDownscopedToken(this.$itemId);
                this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                this.L$1 = SpillingKt.nullOutSpilledVariable(validSavedDownscopedToken);
                this.label = 1;
                if (this.$requestBlock.invoke(validSavedDownscopedToken).collect(new C01571(flowCollector, SharedLinkTokenRetryHelper.this, this.$itemId, this.$evaluateForRetryableFailures, this.$scope, this.$requestBlock), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.box.android.data.datasource.SharedLinkTokenRetryHelper$retryOnFlowFailure$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: SharedLinkTokenRetryHelper.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        static final class C01571<T> implements FlowCollector {
            final /* synthetic */ FlowCollector<Result<? extends T, ? extends E>> $$this$flow;
            final /* synthetic */ Function1<Result<? extends T, ? extends E>, Boolean> $evaluateForRetryableFailures;
            final /* synthetic */ ItemId.Remote $itemId;
            final /* synthetic */ Function1<AccessTokenDTO, Flow<Result<T, E>>> $requestBlock;
            final /* synthetic */ String $scope;
            final /* synthetic */ SharedLinkTokenRetryHelper this$0;

            /* JADX WARN: Multi-variable type inference failed */
            C01571(FlowCollector<? super Result<? extends T, ? extends E>> flowCollector, SharedLinkTokenRetryHelper sharedLinkTokenRetryHelper, ItemId.Remote remote, Function1<? super Result<? extends T, ? extends E>, Boolean> function1, String str, Function1<? super AccessTokenDTO, ? extends Flow<? extends Result<? extends T, ? extends E>>> function2) {
                this.$$this$flow = flowCollector;
                this.this$0 = sharedLinkTokenRetryHelper;
                this.$itemId = remote;
                this.$evaluateForRetryableFailures = function1;
                this.$scope = str;
                this.$requestBlock = function2;
            }

            /* JADX WARN: Code duplicated, block: B:47:0x011c  */
            /* JADX WARN: Code duplicated, block: B:52:0x0150  */
            /* JADX WARN: Code duplicated, block: B:7:0x0014  */
            /* JADX WARN: Code restructure failed: missing block: B:25:0x00b4, code lost:
            
                if (r13.emit(r14, r0) == r1) goto L59;
             */
            /* JADX WARN: Code restructure failed: missing block: B:48:0x014a, code lost:
            
                if (kotlinx.coroutines.flow.FlowKt.emitAll(r5, r13, r0) == r1) goto L59;
             */
            /* JADX WARN: Code restructure failed: missing block: B:53:0x0175, code lost:
            
                if (r13.emit(r14, r0) == r1) goto L59;
             */
            /* JADX WARN: Code restructure failed: missing block: B:58:0x0197, code lost:
            
                if (r13.emit(r14, r0) == r1) goto L59;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object emit(com.box.android.domain.utils.result.Result<? extends T, ? extends E> r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
                /*
                    Method dump skipped, instruction units count: 419
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.SharedLinkTokenRetryHelper.C11001.C01571.emit(com.box.android.domain.utils.result.Result, kotlin.coroutines.Continuation):java.lang.Object");
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((Result) obj, (Continuation<? super Unit>) continuation);
            }
        }
    }

    public final <T, E> Flow<Result<T, E>> retryOnFlowFailure(ItemId.Remote itemId, Function1<? super AccessTokenDTO, ? extends Flow<? extends Result<? extends T, ? extends E>>> requestBlock, Function1<? super Result<? extends T, ? extends E>, Boolean> evaluateForRetryableFailures, String scope) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(requestBlock, "requestBlock");
        Intrinsics.checkNotNullParameter(evaluateForRetryableFailures, "evaluateForRetryableFailures");
        Intrinsics.checkNotNullParameter(scope, "scope");
        return FlowKt.flow(new C11001(itemId, requestBlock, evaluateForRetryableFailures, scope, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getTokenWithSharedLinkContext(ItemId.Remote remote, String str, String str2, Continuation<? super AccessTokenDTO> continuation) {
        AnonymousClass1 anonymousClass1;
        Result.Error error;
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
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object downscopedTokenForSharedLink$default = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(downscopedTokenForSharedLink$default);
                AuthRequest authRequest = this.authRequest;
                String strAccessToken = getBoxSession().getAuthInfo().accessToken();
                Intrinsics.checkNotNullExpressionValue(strAccessToken, "accessToken(...)");
                anonymousClass2.L$0 = remote;
                anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(str);
                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                anonymousClass2.I$0 = 0;
                anonymousClass2.I$1 = 0;
                anonymousClass2.label = 1;
                downscopedTokenForSharedLink$default = AuthRequest.getDownscopedTokenForSharedLink$default(authRequest, str, strAccessToken, str2, null, null, anonymousClass2, 24, null);
                if (downscopedTokenForSharedLink$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = anonymousClass2.I$1;
                int i3 = anonymousClass2.I$0;
                remote = (ItemId.Remote) anonymousClass2.L$0;
                ResultKt.throwOnFailure(downscopedTokenForSharedLink$default);
            }
            error = new Result.Success((AccessTokenDTO) downscopedTokenForSharedLink$default);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        AccessTokenDTO accessTokenDTO = (AccessTokenDTO) com.box.android.domain.utils.result.ResultKt.getOrNull(error);
        if (accessTokenDTO == null) {
            return null;
        }
        this.downscopedTokenMapping.put(getBoxSession().getSharedLink(), accessTokenDTO);
        if (validateToken(remote, accessTokenDTO)) {
            return accessTokenDTO;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AccessTokenDTO getValidSavedDownscopedToken(ItemId.Remote itemId) {
        AccessTokenDTO accessTokenDTO = this.downscopedTokenMapping.get(getBoxSession().getSharedLink());
        if (accessTokenDTO == null || !validateToken(itemId, accessTokenDTO)) {
            return null;
        }
        return accessTokenDTO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean validateToken(ItemId.Remote itemId, AccessTokenDTO token) {
        List<ScopeDTO> restrictedTo = token.getRestrictedTo();
        if (restrictedTo != null) {
            List<ScopeDTO> list = restrictedTo;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (ScopeDTO scopeDTO : list) {
                    if (Intrinsics.areEqual(scopeDTO.getAppliedTo().getId(), itemId.getBoxId()) || Intrinsics.areEqual(scopeDTO.getAppliedTo().getType(), ItemType.FOLDER.getValue())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
