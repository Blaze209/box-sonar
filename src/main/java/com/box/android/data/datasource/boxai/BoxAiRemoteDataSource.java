package com.box.android.data.datasource.boxai;

import androidx.exifinterface.media.ExifInterface;
import com.apollographql.apollo3.api.ApolloResponse;
import com.apollographql.apollo3.api.Error;
import com.box.android.data.GetAiAgentsQuery;
import com.box.android.data.GetAiSessionsQuery;
import com.box.android.data.api.graphql.GetAIAgentsGraphQLQuery;
import com.box.android.data.api.graphql.GetAiSessionsGraphQLQuery;
import com.box.android.data.api.models.auth.AccessTokenDTO;
import com.box.android.data.api.models.boxai.AiCreateSessionDTO;
import com.box.android.data.api.models.boxai.AiCreateSessionRequestDTO;
import com.box.android.data.api.models.boxai.AiGetAnswerDTO;
import com.box.android.data.api.models.boxai.AiMode;
import com.box.android.data.api.models.boxai.AiPermissionDTO;
import com.box.android.data.api.requests.BoxAiRequest;
import com.box.android.data.datasource.ErrorUtil;
import com.box.android.data.datasource.GQLErrorUtil;
import com.box.android.data.datasource.SharedLinkTokenRetryHelper;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.mappers.ItemIdMapperKt;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.utils.result.Result;
import com.box.android.observability.DiagnosisParams;
import com.box.androidsdk.content.models.BoxIterator;
import com.facebook.common.util.UriUtil;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationErrorResponse;
import com.squareup.moshi.Moshi;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: BoxAiRemoteDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 >2\u00020\u0001:\u0001>B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ*\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010\u0016J(\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00110\u000f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u001aH\u0086@¢\u0006\u0002\u0010\u001bJ\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00110\u000fH\u0086@¢\u0006\u0002\u0010\u001eJ\"\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00110\u000f2\u0006\u0010!\u001a\u00020\"H\u0086@¢\u0006\u0002\u0010#Jj\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00110\u000f0%2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u001a2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010*2\b\u0010-\u001a\u0004\u0018\u00010*2\u0016\b\u0002\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010(0/J\"\u00100\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00110\u000f0%2\u0006\u00101\u001a\u000202H\u0002J\u0080\u0001\u00103\u001a\u000e\u0012\u0004\u0012\u0002H4\u0012\u0004\u0012\u0002H50\u000f\"\u0004\b\u0000\u00104\"\u0004\b\u0001\u001052\u0006\u0010\u0012\u001a\u00020\u001320\u00106\u001a,\b\u0001\u0012\u0006\u0012\u0004\u0018\u000108\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H4\u0012\u0004\u0012\u0002H50\u000f09\u0012\u0006\u0012\u0004\u0018\u00010\u0001072\u001e\u0010:\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H4\u0012\u0004\u0012\u0002H50\u000f\u0012\u0004\u0012\u00020\u00150/H\u0082@¢\u0006\u0002\u0010;Jv\u0010<\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H4\u0012\u0004\u0012\u0002H50\u000f0%\"\u0004\b\u0000\u00104\"\u0004\b\u0001\u001052\u0006\u0010\u0012\u001a\u00020\u00132&\u00106\u001a\"\u0012\u0006\u0012\u0004\u0018\u000108\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H4\u0012\u0004\u0012\u0002H50\u000f0%0/2\u001e\u0010:\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H4\u0012\u0004\u0012\u0002H50\u000f\u0012\u0004\u0012\u00020\u00150/H\u0002J\f\u0010=\u001a\u00020**\u000208H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/box/android/data/datasource/boxai/BoxAiRemoteDataSource;", "", "boxAiRequest", "Lcom/box/android/data/api/requests/BoxAiRequest;", "sharedLinkTokenRetryHelper", "Lcom/box/android/data/datasource/SharedLinkTokenRetryHelper;", "moshi", "Lcom/squareup/moshi/Moshi;", "getAIAgentsGraphQLQuery", "Lcom/box/android/data/api/graphql/GetAIAgentsGraphQLQuery;", "getAiSessionsGraphQLQuery", "Lcom/box/android/data/api/graphql/GetAiSessionsGraphQLQuery;", "<init>", "(Lcom/box/android/data/api/requests/BoxAiRequest;Lcom/box/android/data/datasource/SharedLinkTokenRetryHelper;Lcom/squareup/moshi/Moshi;Lcom/box/android/data/api/graphql/GetAIAgentsGraphQLQuery;Lcom/box/android/data/api/graphql/GetAiSessionsGraphQLQuery;)V", "getPermission", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/data/api/models/boxai/AiPermissionDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;", "itemId", "Lcom/box/android/domain/models/ItemId$Remote;", "isMultidoc", "", "(Lcom/box/android/domain/models/ItemId$Remote;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSession", "Lcom/box/android/data/api/models/boxai/AiCreateSessionDTO;", "itemIds", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAiAgents", "Lcom/box/android/data/GetAiAgentsQuery$FilteredForUserAiAgents;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecentAiSessions", "Lcom/box/android/data/GetAiSessionsQuery$ItemV2s;", BoxIterator.FIELD_LIMIT, "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAnswerStreaming", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/data/api/models/boxai/AiGetAnswerDTO;", DiagnosisParams.DIAGNOSIS_MODE, "Lcom/box/android/data/api/models/boxai/AiMode;", AuthenticationConstants.AAD.QUERY_PROMPT, "", "itemSession", "contextSession", "agentId", "getFallbackMode", "Lkotlin/Function1;", "processStreamingResponse", "responseBuffer", "Ljava/io/BufferedReader;", "retryWithSharedLinkTokenOnFailure", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LONGITUDE_EAST, "requestBlock", "Lkotlin/Function2;", "Lcom/box/android/data/api/models/auth/AccessTokenDTO;", "Lkotlin/coroutines/Continuation;", "evaluateForRetryableFailures", "(Lcom/box/android/domain/models/ItemId$Remote;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retryWithSharedLinkTokenOnFlowFailure", "formatAuthorizationHeader", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxAiRemoteDataSource {
    private static final String SCOPE = "item_preview ai.readwrite";
    private final BoxAiRequest boxAiRequest;
    private final GetAIAgentsGraphQLQuery getAIAgentsGraphQLQuery;
    private final GetAiSessionsGraphQLQuery getAiSessionsGraphQLQuery;
    private final Moshi moshi;
    private final SharedLinkTokenRetryHelper sharedLinkTokenRetryHelper;

    /* JADX INFO: renamed from: com.box.android.data.datasource.boxai.BoxAiRemoteDataSource$getAiAgents$1, reason: invalid class name */
    /* JADX INFO: compiled from: BoxAiRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.boxai.BoxAiRemoteDataSource", f = "BoxAiRemoteDataSource.kt", i = {0, 0}, l = {115}, m = "getAiAgents", n = {"$i$f$resultOf", "$i$a$-resultOf-BoxAiRemoteDataSource$getAiAgents$2"}, s = {"I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BoxAiRemoteDataSource.this.getAiAgents(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.boxai.BoxAiRemoteDataSource$getRecentAiSessions$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxAiRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.boxai.BoxAiRemoteDataSource", f = "BoxAiRemoteDataSource.kt", i = {0, 0, 0}, l = {Token.LOOP}, m = "getRecentAiSessions", n = {BoxIterator.FIELD_LIMIT, "$i$f$resultOf", "$i$a$-resultOf-BoxAiRemoteDataSource$getRecentAiSessions$2"}, s = {"I$0", "I$1", "I$2"}, v = 1)
    static final class C11181 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int label;
        /* synthetic */ Object result;

        C11181(Continuation<? super C11181> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BoxAiRemoteDataSource.this.getRecentAiSessions(0, this);
        }
    }

    @Inject
    public BoxAiRemoteDataSource(BoxAiRequest boxAiRequest, SharedLinkTokenRetryHelper sharedLinkTokenRetryHelper, Moshi moshi, GetAIAgentsGraphQLQuery getAIAgentsGraphQLQuery, GetAiSessionsGraphQLQuery getAiSessionsGraphQLQuery) {
        Intrinsics.checkNotNullParameter(boxAiRequest, "boxAiRequest");
        Intrinsics.checkNotNullParameter(sharedLinkTokenRetryHelper, "sharedLinkTokenRetryHelper");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Intrinsics.checkNotNullParameter(getAIAgentsGraphQLQuery, "getAIAgentsGraphQLQuery");
        Intrinsics.checkNotNullParameter(getAiSessionsGraphQLQuery, "getAiSessionsGraphQLQuery");
        this.boxAiRequest = boxAiRequest;
        this.sharedLinkTokenRetryHelper = sharedLinkTokenRetryHelper;
        this.moshi = moshi;
        this.getAIAgentsGraphQLQuery = getAIAgentsGraphQLQuery;
        this.getAiSessionsGraphQLQuery = getAiSessionsGraphQLQuery;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object getPermission$request(BoxAiRemoteDataSource boxAiRemoteDataSource, ItemId.Remote remote, AccessTokenDTO accessTokenDTO, Continuation<? super Result<AiPermissionDTO, ? extends RemoteError>> continuation) {
        BoxAiRemoteDataSource$getPermission$request$1 boxAiRemoteDataSource$getPermission$request$1;
        Result.Error error;
        if (continuation instanceof BoxAiRemoteDataSource$getPermission$request$1) {
            boxAiRemoteDataSource$getPermission$request$1 = (BoxAiRemoteDataSource$getPermission$request$1) continuation;
            if ((boxAiRemoteDataSource$getPermission$request$1.label & Integer.MIN_VALUE) != 0) {
                boxAiRemoteDataSource$getPermission$request$1.label -= Integer.MIN_VALUE;
            } else {
                boxAiRemoteDataSource$getPermission$request$1 = new BoxAiRemoteDataSource$getPermission$request$1(continuation);
            }
        } else {
            boxAiRemoteDataSource$getPermission$request$1 = new BoxAiRemoteDataSource$getPermission$request$1(continuation);
        }
        Object permission = boxAiRemoteDataSource$getPermission$request$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = boxAiRemoteDataSource$getPermission$request$1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(permission);
                BoxAiRequest boxAiRequest = boxAiRemoteDataSource.boxAiRequest;
                String boxId = remote.getBoxId();
                String string = remote.getType().toString();
                String authorizationHeader = accessTokenDTO != null ? boxAiRemoteDataSource.formatAuthorizationHeader(accessTokenDTO) : null;
                boxAiRemoteDataSource$getPermission$request$1.L$0 = boxAiRemoteDataSource;
                boxAiRemoteDataSource$getPermission$request$1.L$1 = SpillingKt.nullOutSpilledVariable(remote);
                boxAiRemoteDataSource$getPermission$request$1.L$2 = SpillingKt.nullOutSpilledVariable(accessTokenDTO);
                boxAiRemoteDataSource$getPermission$request$1.I$0 = 0;
                boxAiRemoteDataSource$getPermission$request$1.I$1 = 0;
                boxAiRemoteDataSource$getPermission$request$1.label = 1;
                permission = boxAiRequest.getPermission(boxId, string, authorizationHeader, boxAiRemoteDataSource$getPermission$request$1);
                if (permission == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = boxAiRemoteDataSource$getPermission$request$1.I$1;
                int i3 = boxAiRemoteDataSource$getPermission$request$1.I$0;
                boxAiRemoteDataSource = (BoxAiRemoteDataSource) boxAiRemoteDataSource$getPermission$request$1.L$0;
                ResultKt.throwOnFailure(permission);
            }
            error = new Result.Success((AiPermissionDTO) permission);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException((Exception) ((Result.Error) error).getValue(), boxAiRemoteDataSource.moshi));
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.boxai.BoxAiRemoteDataSource$getPermission$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxAiRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class C11172 extends FunctionReferenceImpl implements Function2<AccessTokenDTO, Continuation<? super Result<? extends AiPermissionDTO, ? extends RemoteError>>, Object>, SuspendFunction {
        final /* synthetic */ ItemId.Remote $itemId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11172(ItemId.Remote remote) {
            super(2, Intrinsics.Kotlin.class, "request", "getPermission$request(Lcom/box/android/data/datasource/boxai/BoxAiRemoteDataSource;Lcom/box/android/domain/models/ItemId$Remote;Lcom/box/android/data/api/models/auth/AccessTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
            this.$itemId = remote;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(AccessTokenDTO accessTokenDTO, Continuation<? super Result<AiPermissionDTO, ? extends RemoteError>> continuation) {
            return BoxAiRemoteDataSource.getPermission$request(BoxAiRemoteDataSource.this, this.$itemId, accessTokenDTO, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(AccessTokenDTO accessTokenDTO, Continuation<? super Result<? extends AiPermissionDTO, ? extends RemoteError>> continuation) {
            return invoke2(accessTokenDTO, (Continuation<? super Result<AiPermissionDTO, ? extends RemoteError>>) continuation);
        }
    }

    public final Object getPermission(ItemId.Remote remote, boolean z, Continuation<? super Result<AiPermissionDTO, ? extends RemoteError>> continuation) {
        if (!z) {
            return retryWithSharedLinkTokenOnFailure(remote, new C11172(remote), new Function1() { // from class: com.box.android.data.datasource.boxai.BoxAiRemoteDataSource$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(BoxAiRemoteDataSource.getPermission$lambda$2((Result) obj));
                }
            }, continuation);
        }
        return getPermission$request(this, remote, null, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getPermission$lambda$2(Result it) {
        Intrinsics.checkNotNullParameter(it, "it");
        AiPermissionDTO aiPermissionDTO = (AiPermissionDTO) com.box.android.domain.utils.result.ResultKt.getOrNull(it);
        if (aiPermissionDTO != null && !aiPermissionDTO.isValidUser()) {
            return true;
        }
        Result.Error error = it instanceof Result.Error ? (Result.Error) it : null;
        return (error != null ? (RemoteError) error.getValue() : null) instanceof RemoteError.NotFound;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object createSession$request(BoxAiRemoteDataSource boxAiRemoteDataSource, List<ItemId.Remote> list, AccessTokenDTO accessTokenDTO, Continuation<? super Result<AiCreateSessionDTO, ? extends RemoteError>> continuation) {
        BoxAiRemoteDataSource$createSession$request$1 boxAiRemoteDataSource$createSession$request$1;
        Result.Error error;
        if (continuation instanceof BoxAiRemoteDataSource$createSession$request$1) {
            boxAiRemoteDataSource$createSession$request$1 = (BoxAiRemoteDataSource$createSession$request$1) continuation;
            if ((boxAiRemoteDataSource$createSession$request$1.label & Integer.MIN_VALUE) != 0) {
                boxAiRemoteDataSource$createSession$request$1.label -= Integer.MIN_VALUE;
            } else {
                boxAiRemoteDataSource$createSession$request$1 = new BoxAiRemoteDataSource$createSession$request$1(continuation);
            }
        } else {
            boxAiRemoteDataSource$createSession$request$1 = new BoxAiRemoteDataSource$createSession$request$1(continuation);
        }
        Object objCreateSession = boxAiRemoteDataSource$createSession$request$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = boxAiRemoteDataSource$createSession$request$1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objCreateSession);
                BoxAiRequest boxAiRequest = boxAiRemoteDataSource.boxAiRequest;
                List<ItemId.Remote> list2 = list;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(ItemIdMapperKt.toItemIdDTO((ItemId.Remote) it.next()));
                }
                AiCreateSessionRequestDTO aiCreateSessionRequestDTO = new AiCreateSessionRequestDTO(arrayList, false, 2, null);
                String authorizationHeader = accessTokenDTO != null ? boxAiRemoteDataSource.formatAuthorizationHeader(accessTokenDTO) : null;
                boxAiRemoteDataSource$createSession$request$1.L$0 = boxAiRemoteDataSource;
                boxAiRemoteDataSource$createSession$request$1.L$1 = SpillingKt.nullOutSpilledVariable(list);
                boxAiRemoteDataSource$createSession$request$1.L$2 = SpillingKt.nullOutSpilledVariable(accessTokenDTO);
                boxAiRemoteDataSource$createSession$request$1.I$0 = 0;
                boxAiRemoteDataSource$createSession$request$1.I$1 = 0;
                boxAiRemoteDataSource$createSession$request$1.label = 1;
                objCreateSession = boxAiRequest.createSession(aiCreateSessionRequestDTO, authorizationHeader, boxAiRemoteDataSource$createSession$request$1);
                if (objCreateSession == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = boxAiRemoteDataSource$createSession$request$1.I$1;
                int i3 = boxAiRemoteDataSource$createSession$request$1.I$0;
                boxAiRemoteDataSource = (BoxAiRemoteDataSource) boxAiRemoteDataSource$createSession$request$1.L$0;
                ResultKt.throwOnFailure(objCreateSession);
            }
            error = new Result.Success((AiCreateSessionDTO) objCreateSession);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException((Exception) ((Result.Error) error).getValue(), boxAiRemoteDataSource.moshi));
    }

    public final Object createSession(List<ItemId.Remote> list, Continuation<? super Result<AiCreateSessionDTO, ? extends RemoteError>> continuation) {
        if (list.size() == 1) {
            return retryWithSharedLinkTokenOnFailure((ItemId.Remote) CollectionsKt.single((List) list), new AnonymousClass2(list), new Function1() { // from class: com.box.android.data.datasource.boxai.BoxAiRemoteDataSource$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(BoxAiRemoteDataSource.createSession$lambda$2((Result) obj));
                }
            }, continuation);
        }
        return createSession$request(this, list, null, continuation);
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.boxai.BoxAiRemoteDataSource$createSession$2, reason: invalid class name */
    /* JADX INFO: compiled from: BoxAiRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function2<AccessTokenDTO, Continuation<? super Result<? extends AiCreateSessionDTO, ? extends RemoteError>>, Object>, SuspendFunction {
        final /* synthetic */ List<ItemId.Remote> $itemIds;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(List<ItemId.Remote> list) {
            super(2, Intrinsics.Kotlin.class, "request", "createSession$request(Lcom/box/android/data/datasource/boxai/BoxAiRemoteDataSource;Ljava/util/List;Lcom/box/android/data/api/models/auth/AccessTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
            this.$itemIds = list;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(AccessTokenDTO accessTokenDTO, Continuation<? super Result<AiCreateSessionDTO, ? extends RemoteError>> continuation) {
            return BoxAiRemoteDataSource.createSession$request(BoxAiRemoteDataSource.this, this.$itemIds, accessTokenDTO, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(AccessTokenDTO accessTokenDTO, Continuation<? super Result<? extends AiCreateSessionDTO, ? extends RemoteError>> continuation) {
            return invoke2(accessTokenDTO, (Continuation<? super Result<AiCreateSessionDTO, ? extends RemoteError>>) continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean createSession$lambda$2(Result it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Result.Error error = it instanceof Result.Error ? (Result.Error) it : null;
        return (error != null ? (RemoteError) error.getValue() : null) instanceof RemoteError.NotFound;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getAiAgents(Continuation<? super Result<GetAiAgentsQuery.FilteredForUserAiAgents, ? extends RemoteError>> continuation) {
        AnonymousClass1 anonymousClass1;
        Result.Error error;
        GetAiAgentsQuery.Data data;
        GetAiAgentsQuery.FilteredForUserAiAgents filteredForUserAiAgents;
        Result.Success success;
        RemoteError.Unknown unknown;
        Error error2;
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
        Object agents = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(agents);
                GetAIAgentsGraphQLQuery getAIAgentsGraphQLQuery = this.getAIAgentsGraphQLQuery;
                anonymousClass1.I$0 = 0;
                anonymousClass1.I$1 = 0;
                anonymousClass1.label = 1;
                agents = getAIAgentsGraphQLQuery.getAgents(anonymousClass1);
                if (agents == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = anonymousClass1.I$1;
                int i3 = anonymousClass1.I$0;
                ResultKt.throwOnFailure(agents);
            }
            error = new Result.Success((ApolloResponse) agents);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (!(error instanceof Result.Success)) {
            if (!(error instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            error = new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException((Exception) ((Result.Error) error).getValue(), this.moshi));
        }
        if (!(error instanceof Result.Success)) {
            if (error instanceof Result.Error) {
                return error;
            }
            throw new NoWhenBranchMatchedException();
        }
        ApolloResponse apolloResponse = (ApolloResponse) ((Result.Success) error).getValue();
        if (apolloResponse != null && apolloResponse.hasErrors()) {
            List<Error> list = apolloResponse.errors;
            if (list == null || (error2 = (Error) CollectionsKt.firstOrNull((List) list)) == null || (unknown = GQLErrorUtil.INSTANCE.getRemoteError(error2)) == null) {
                unknown = new RemoteError.Unknown(-1, MicrosoftAuthorizationErrorResponse.UNKNOWN_ERROR);
            }
            success = new Result.Error(unknown);
        } else if (apolloResponse != null && (data = (GetAiAgentsQuery.Data) apolloResponse.data) != null && (filteredForUserAiAgents = data.getFilteredForUserAiAgents()) != null) {
            success = new Result.Success(filteredForUserAiAgents);
        } else {
            return new Result.Error(new RemoteError.Unknown(-1, MicrosoftAuthorizationErrorResponse.UNKNOWN_ERROR));
        }
        return success;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getRecentAiSessions(int i, Continuation<? super Result<GetAiSessionsQuery.ItemV2s, ? extends RemoteError>> continuation) {
        C11181 c11181;
        Result.Error error;
        GetAiSessionsQuery.Data data;
        GetAiSessionsQuery.ItemV2s itemV2s;
        RemoteError.Unknown unknown;
        Error error2;
        if (continuation instanceof C11181) {
            c11181 = (C11181) continuation;
            if ((c11181.label & Integer.MIN_VALUE) != 0) {
                c11181.label -= Integer.MIN_VALUE;
            } else {
                c11181 = new C11181(continuation);
            }
        } else {
            c11181 = new C11181(continuation);
        }
        Object recentSessions = c11181.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c11181.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(recentSessions);
                GetAiSessionsGraphQLQuery getAiSessionsGraphQLQuery = this.getAiSessionsGraphQLQuery;
                c11181.I$0 = i;
                c11181.I$1 = 0;
                c11181.I$2 = 0;
                c11181.label = 1;
                recentSessions = getAiSessionsGraphQLQuery.getRecentSessions(i, c11181);
                if (recentSessions == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i3 = c11181.I$2;
                int i4 = c11181.I$1;
                int i5 = c11181.I$0;
                ResultKt.throwOnFailure(recentSessions);
            }
            error = new Result.Success((ApolloResponse) recentSessions);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (!(error instanceof Result.Success)) {
            if (!(error instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            error = new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException((Exception) ((Result.Error) error).getValue(), this.moshi));
        }
        if (!(error instanceof Result.Success)) {
            if (error instanceof Result.Error) {
                return error;
            }
            throw new NoWhenBranchMatchedException();
        }
        ApolloResponse apolloResponse = (ApolloResponse) ((Result.Success) error).getValue();
        if (apolloResponse == null || !apolloResponse.hasErrors()) {
            if (apolloResponse != null && (data = (GetAiSessionsQuery.Data) apolloResponse.data) != null && (itemV2s = data.getItemV2s()) != null) {
                return new Result.Success(itemV2s);
            }
            return new Result.Error(new RemoteError.Unknown(-1, MicrosoftAuthorizationErrorResponse.UNKNOWN_ERROR));
        }
        List<Error> list = apolloResponse.errors;
        if (list == null || (error2 = (Error) CollectionsKt.firstOrNull((List) list)) == null || (unknown = GQLErrorUtil.INSTANCE.getRemoteError(error2)) == null) {
            unknown = new RemoteError.Unknown(-1, MicrosoftAuthorizationErrorResponse.UNKNOWN_ERROR);
        }
        return new Result.Error(unknown);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flow<Result<AiGetAnswerDTO, RemoteError>> getAnswerStreaming$request(BoxAiRemoteDataSource boxAiRemoteDataSource, List<ItemId.Remote> list, String str, String str2, String str3, String str4, AiMode aiMode, AccessTokenDTO accessTokenDTO) {
        return FlowKt.flowOn(FlowKt.flow(new BoxAiRemoteDataSource$getAnswerStreaming$request$1(boxAiRemoteDataSource, aiMode, list, str, str2, str3, str4, accessTokenDTO, null)), Dispatchers.getIO());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flow<Result<AiGetAnswerDTO, RemoteError>> getAnswerStreaming$requestWithFallback(AiMode aiMode, BoxAiRemoteDataSource boxAiRemoteDataSource, List<ItemId.Remote> list, String str, String str2, String str3, String str4, Function1<? super RemoteError, ? extends AiMode> function1, AccessTokenDTO accessTokenDTO) {
        return FlowKt.flow(new BoxAiRemoteDataSource$getAnswerStreaming$requestWithFallback$1(aiMode, accessTokenDTO, boxAiRemoteDataSource, list, str, str2, str3, str4, function1, null));
    }

    public final Flow<Result<AiGetAnswerDTO, RemoteError>> getAnswerStreaming(List<ItemId.Remote> itemIds, AiMode mode, String prompt, String itemSession, String contextSession, String agentId, Function1<? super RemoteError, ? extends AiMode> getFallbackMode) {
        Intrinsics.checkNotNullParameter(itemIds, "itemIds");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(prompt, "prompt");
        Intrinsics.checkNotNullParameter(itemSession, "itemSession");
        Intrinsics.checkNotNullParameter(getFallbackMode, "getFallbackMode");
        if (itemIds.size() == 1) {
            return retryWithSharedLinkTokenOnFlowFailure((ItemId.Remote) CollectionsKt.single((List) itemIds), new C11162(mode, this, itemIds, prompt, itemSession, contextSession, agentId, getFallbackMode), new Function1() { // from class: com.box.android.data.datasource.boxai.BoxAiRemoteDataSource$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(BoxAiRemoteDataSource.getAnswerStreaming$lambda$0((Result) obj));
                }
            });
        }
        return getAnswerStreaming$requestWithFallback(mode, this, itemIds, prompt, itemSession, contextSession, agentId, getFallbackMode, null);
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.boxai.BoxAiRemoteDataSource$getAnswerStreaming$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxAiRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class C11162 extends FunctionReferenceImpl implements Function1<AccessTokenDTO, Flow<? extends Result<? extends AiGetAnswerDTO, ? extends RemoteError>>> {
        final /* synthetic */ String $agentId;
        final /* synthetic */ String $contextSession;
        final /* synthetic */ Function1<RemoteError, AiMode> $getFallbackMode;
        final /* synthetic */ List<ItemId.Remote> $itemIds;
        final /* synthetic */ String $itemSession;
        final /* synthetic */ AiMode $mode;
        final /* synthetic */ String $prompt;
        final /* synthetic */ BoxAiRemoteDataSource this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C11162(AiMode aiMode, BoxAiRemoteDataSource boxAiRemoteDataSource, List<ItemId.Remote> list, String str, String str2, String str3, String str4, Function1<? super RemoteError, ? extends AiMode> function1) {
            super(1, Intrinsics.Kotlin.class, "requestWithFallback", "getAnswerStreaming$requestWithFallback(Lcom/box/android/data/api/models/boxai/AiMode;Lcom/box/android/data/datasource/boxai/BoxAiRemoteDataSource;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lcom/box/android/data/api/models/auth/AccessTokenDTO;)Lkotlinx/coroutines/flow/Flow;", 0);
            this.$mode = aiMode;
            this.this$0 = boxAiRemoteDataSource;
            this.$itemIds = list;
            this.$prompt = str;
            this.$itemSession = str2;
            this.$contextSession = str3;
            this.$agentId = str4;
            this.$getFallbackMode = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Flow<Result<AiGetAnswerDTO, RemoteError>> invoke(AccessTokenDTO accessTokenDTO) {
            return BoxAiRemoteDataSource.getAnswerStreaming$requestWithFallback(this.$mode, this.this$0, this.$itemIds, this.$prompt, this.$itemSession, this.$contextSession, this.$agentId, this.$getFallbackMode, accessTokenDTO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getAnswerStreaming$lambda$0(Result it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Result.Error error = it instanceof Result.Error ? (Result.Error) it : null;
        return (error != null ? (RemoteError) error.getValue() : null) instanceof RemoteError.NotFound;
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.boxai.BoxAiRemoteDataSource$processStreamingResponse$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxAiRemoteDataSource.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/data/api/models/boxai/AiGetAnswerDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.boxai.BoxAiRemoteDataSource$processStreamingResponse$1", f = "BoxAiRemoteDataSource.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1}, l = {227, 229}, m = "invokeSuspend", n = {"$this$flow", "adapter", UriUtil.LOCAL_RESOURCE_SCHEME, "it", "$i$a$-let-BoxAiRemoteDataSource$processStreamingResponse$1$1", "$this$flow", "adapter", UriUtil.LOCAL_RESOURCE_SCHEME, "e"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class C11191 extends SuspendLambda implements Function2<FlowCollector<? super Result<? extends AiGetAnswerDTO, ? extends RemoteError>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ BufferedReader $responseBuffer;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11191(BufferedReader bufferedReader, Continuation<? super C11191> continuation) {
            super(2, continuation);
            this.$responseBuffer = bufferedReader;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C11191 c11191 = BoxAiRemoteDataSource.this.new C11191(this.$responseBuffer, continuation);
            c11191.L$0 = obj;
            return c11191;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends AiGetAnswerDTO, ? extends RemoteError>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Result<AiGetAnswerDTO, ? extends RemoteError>>) flowCollector, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<AiGetAnswerDTO, ? extends RemoteError>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C11191) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:17:0x005a  */
        /* JADX WARN: Code duplicated, block: B:19:0x005d A[Catch: Exception -> 0x003c, TRY_ENTER, TryCatch #0 {Exception -> 0x003c, blocks: (B:19:0x005d, B:21:0x0065, B:10:0x0037), top: B:33:0x0037 }] */
        /* JADX WARN: Code duplicated, block: B:21:0x0065 A[Catch: Exception -> 0x003c, TRY_LEAVE, TryCatch #0 {Exception -> 0x003c, blocks: (B:19:0x005d, B:21:0x0065, B:10:0x0037), top: B:33:0x0037 }] */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0086, code lost:
        
            if (r0.emit(r10, r9) == r1) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x00b3, code lost:
        
            if (r0.emit(new com.box.android.domain.utils.result.Result.Error(com.box.android.data.datasource.ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException(r10, r9.this$0.moshi)), r9) == r1) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x00b5, code lost:
        
            return r1;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0063 -> B:27:0x00b6). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0086 -> B:27:0x00b6). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00b3 -> B:27:0x00b6). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = r9.L$0
                kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r9.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L3e
                if (r2 == r4) goto L2b
                if (r2 != r3) goto L23
                java.lang.Object r2 = r9.L$3
                java.lang.Exception r2 = (java.lang.Exception) r2
                java.lang.Object r2 = r9.L$2
                java.lang.String r2 = (java.lang.String) r2
                java.lang.Object r5 = r9.L$1
                com.squareup.moshi.JsonAdapter r5 = (com.squareup.moshi.JsonAdapter) r5
                kotlin.ResultKt.throwOnFailure(r10)
                goto Lb6
            L23:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L2b:
                java.lang.Object r2 = r9.L$3
                java.lang.String r2 = (java.lang.String) r2
                java.lang.Object r2 = r9.L$2
                java.lang.String r2 = (java.lang.String) r2
                java.lang.Object r5 = r9.L$1
                com.squareup.moshi.JsonAdapter r5 = (com.squareup.moshi.JsonAdapter) r5
                kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Exception -> L3c
                goto Lb6
            L3c:
                r10 = move-exception
                goto L89
            L3e:
                kotlin.ResultKt.throwOnFailure(r10)
                com.box.android.data.datasource.boxai.BoxAiRemoteDataSource r10 = com.box.android.data.datasource.boxai.BoxAiRemoteDataSource.this
                com.squareup.moshi.Moshi r10 = com.box.android.data.datasource.boxai.BoxAiRemoteDataSource.access$getMoshi$p(r10)
                java.lang.Class<com.box.android.data.api.models.boxai.AiGetAnswerDTO> r2 = com.box.android.data.api.models.boxai.AiGetAnswerDTO.class
                com.squareup.moshi.JsonAdapter r10 = r10.adapter(r2)
                java.lang.String r2 = ""
                r5 = r10
            L50:
                kotlin.coroutines.CoroutineContext r10 = r9.getContext()
                boolean r10 = kotlinx.coroutines.JobKt.isActive(r10)
                if (r10 != 0) goto L5d
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                return r9
            L5d:
                java.io.BufferedReader r10 = r9.$responseBuffer     // Catch: java.lang.Exception -> L3c
                java.lang.String r2 = r10.readLine()     // Catch: java.lang.Exception -> L3c
                if (r2 == 0) goto Lb6
                com.box.android.domain.utils.result.Result$Success r10 = new com.box.android.domain.utils.result.Result$Success     // Catch: java.lang.Exception -> L3c
                java.lang.Object r6 = r5.fromJson(r2)     // Catch: java.lang.Exception -> L3c
                kotlin.jvm.internal.Intrinsics.checkNotNull(r6)     // Catch: java.lang.Exception -> L3c
                r10.<init>(r6)     // Catch: java.lang.Exception -> L3c
                r9.L$0 = r0     // Catch: java.lang.Exception -> L3c
                r9.L$1 = r5     // Catch: java.lang.Exception -> L3c
                r9.L$2 = r2     // Catch: java.lang.Exception -> L3c
                java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)     // Catch: java.lang.Exception -> L3c
                r9.L$3 = r6     // Catch: java.lang.Exception -> L3c
                r6 = 0
                r9.I$0 = r6     // Catch: java.lang.Exception -> L3c
                r9.label = r4     // Catch: java.lang.Exception -> L3c
                java.lang.Object r10 = r0.emit(r10, r9)     // Catch: java.lang.Exception -> L3c
                if (r10 != r1) goto Lb6
                goto Lb5
            L89:
                com.box.android.domain.utils.result.Result$Error r6 = new com.box.android.domain.utils.result.Result$Error
                com.box.android.data.datasource.ErrorUtil$Companion r7 = com.box.android.data.datasource.ErrorUtil.INSTANCE
                com.box.android.data.datasource.ErrorUtil r7 = r7.getInstance()
                com.box.android.data.datasource.boxai.BoxAiRemoteDataSource r8 = com.box.android.data.datasource.boxai.BoxAiRemoteDataSource.this
                com.squareup.moshi.Moshi r8 = com.box.android.data.datasource.boxai.BoxAiRemoteDataSource.access$getMoshi$p(r8)
                com.box.android.data.datasource.errors.RemoteError r7 = r7.getRemoteErrorFromApiException(r10, r8)
                r6.<init>(r7)
                r7 = r9
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                r9.L$0 = r0
                r9.L$1 = r5
                r9.L$2 = r2
                java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
                r9.L$3 = r10
                r9.label = r3
                java.lang.Object r10 = r0.emit(r6, r7)
                if (r10 != r1) goto Lb6
            Lb5:
                return r1
            Lb6:
                r10 = r2
                java.lang.CharSequence r10 = (java.lang.CharSequence) r10
                if (r10 == 0) goto Lc1
                int r10 = r10.length()
                if (r10 != 0) goto L50
            Lc1:
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.boxai.BoxAiRemoteDataSource.C11191.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Flow<Result<AiGetAnswerDTO, RemoteError>> processStreamingResponse(BufferedReader responseBuffer) {
        return FlowKt.flow(new C11191(responseBuffer, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T, E> Object retryWithSharedLinkTokenOnFailure(ItemId.Remote remote, Function2<? super AccessTokenDTO, ? super Continuation<? super Result<? extends T, ? extends E>>, ? extends Object> function2, Function1<? super Result<? extends T, ? extends E>, Boolean> function1, Continuation<? super Result<? extends T, ? extends E>> continuation) {
        return this.sharedLinkTokenRetryHelper.retryOnFailure(remote, function2, function1, SCOPE, continuation);
    }

    private final <T, E> Flow<Result<T, E>> retryWithSharedLinkTokenOnFlowFailure(ItemId.Remote itemId, Function1<? super AccessTokenDTO, ? extends Flow<? extends Result<? extends T, ? extends E>>> requestBlock, Function1<? super Result<? extends T, ? extends E>, Boolean> evaluateForRetryableFailures) {
        return this.sharedLinkTokenRetryHelper.retryOnFlowFailure(itemId, requestBlock, evaluateForRetryableFailures, SCOPE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String formatAuthorizationHeader(AccessTokenDTO accessTokenDTO) {
        return "Bearer " + accessTokenDTO.getAccessToken();
    }
}
