package com.box.android.data.service.impl.boxai;

import com.box.android.common.utilities.CollectionUtilsKt;
import com.box.android.data.GetAiAgentsQuery;
import com.box.android.data.GetAiSessionsQuery;
import com.box.android.data.api.models.boxai.AiGetAnswerDTO;
import com.box.android.data.api.models.boxai.AiMode;
import com.box.android.data.datasource.boxai.BoxAiRemoteDataSource;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.mappers.boxai.BoxAiDTOMapperKt;
import com.box.android.data.service.impl.DomainErrorMapper;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.boxai.AiAgentModel;
import com.box.android.domain.models.boxai.AiAnswerStreamingModel;
import com.box.android.domain.models.boxai.AiRecentSession;
import com.box.android.domain.services.IBoxAiService;
import com.box.android.domain.services.IdMappingService;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxIterator;
import com.facebook.react.modules.dialog.AlertFragment;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: BoxAiService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ*\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012J(\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\r0\u000b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0016H\u0096@¢\u0006\u0002\u0010\u0017J \u0010\u0018\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0016\u0012\u0004\u0012\u00020\r0\u000bH\u0096@¢\u0006\u0002\u0010\u001aJ(\u0010\u001b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u0016\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0096@¢\u0006\u0002\u0010\u001fJT\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\r0\u000b0!2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00162\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\b\u0010&\u001a\u0004\u0018\u00010$2\b\u0010'\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J.\u0010,\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\u0016\u0012\u0004\u0012\u00020\r0\u000b2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0016H\u0082@¢\u0006\u0002\u0010\u0017J\f\u0010/\u001a\u00020\u0011*\u00020+H\u0002J0\u00100\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\r0\u000b0!*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020+0\u000b0!H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/box/android/data/service/impl/boxai/BoxAiService;", "Lcom/box/android/domain/services/IBoxAiService;", "boxAiRemoteDataSource", "Lcom/box/android/data/datasource/boxai/BoxAiRemoteDataSource;", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", "defaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/box/android/data/datasource/boxai/BoxAiRemoteDataSource;Lcom/box/android/domain/services/IdMappingService;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getPermission", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/boxai/AiPermissionModel;", "Lcom/box/android/domain/models/DomainError;", "itemId", "Lcom/box/android/domain/models/ItemId;", "isMultidoc", "", "(Lcom/box/android/domain/models/ItemId;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSession", "Lcom/box/android/domain/models/boxai/AiSessionModel;", "itemIds", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAgents", "Lcom/box/android/domain/models/boxai/AiAgentModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecentAiSessions", "Lcom/box/android/domain/models/boxai/AiRecentSession;", BoxIterator.FIELD_LIMIT, "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAnswerQAStreaming", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/models/boxai/AiAnswerStreamingModel;", AuthenticationConstants.AAD.QUERY_PROMPT, "", "itemSession", "contextSession", "agentId", "getFallbackMode", "Lcom/box/android/data/api/models/boxai/AiMode;", "error", "Lcom/box/android/data/datasource/errors/RemoteError;", "getRemoteIdsOrError", "Lcom/box/android/domain/models/ItemId$Remote;", AlertFragment.ARG_ITEMS, "isRetryable", "mapToDomain", "Lcom/box/android/data/api/models/boxai/AiGetAnswerDTO;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxAiService implements IBoxAiService {
    private final BoxAiRemoteDataSource boxAiRemoteDataSource;
    private final CoroutineDispatcher defaultDispatcher;
    private final IdMappingService idMappingService;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.boxai.BoxAiService$createSession$1, reason: invalid class name */
    /* JADX INFO: compiled from: BoxAiService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.boxai.BoxAiService", f = "BoxAiService.kt", i = {0, 1, 1, 1, 1, 1}, l = {52, 54}, m = "createSession", n = {"itemIds", "itemIds", "$this$flatMap$iv", "remoteIds", "$i$f$flatMap", "$i$a$-flatMap-BoxAiService$createSession$2"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
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
            return BoxAiService.this.createSession(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.boxai.BoxAiService$getAgents$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxAiService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.boxai.BoxAiService", f = "BoxAiService.kt", i = {}, l = {61}, m = "getAgents", n = {}, s = {}, v = 1)
    static final class C15381 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C15381(Continuation<? super C15381> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BoxAiService.this.getAgents(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.boxai.BoxAiService$getPermission$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxAiService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.boxai.BoxAiService", f = "BoxAiService.kt", i = {0, 0, 1, 1, 1, 1, 1, 1}, l = {43, 45}, m = "getPermission", n = {"itemId", "isMultidoc", "itemId", "$this$flatMap$iv", "remoteId", "isMultidoc", "$i$f$flatMap", "$i$a$-flatMap-BoxAiService$getPermission$2"}, s = {"L$0", "Z$0", "L$0", "L$1", "L$2", "Z$0", "I$0", "I$1"}, v = 1)
    static final class C15401 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C15401(Continuation<? super C15401> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BoxAiService.this.getPermission(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.boxai.BoxAiService$getRecentAiSessions$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxAiService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.boxai.BoxAiService", f = "BoxAiService.kt", i = {0}, l = {68}, m = "getRecentAiSessions", n = {BoxIterator.FIELD_LIMIT}, s = {"I$0"}, v = 1)
    static final class C15411 extends ContinuationImpl {
        int I$0;
        int label;
        /* synthetic */ Object result;

        C15411(Continuation<? super C15411> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BoxAiService.this.getRecentAiSessions(0, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.boxai.BoxAiService$getRemoteIdsOrError$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxAiService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.boxai.BoxAiService", f = "BoxAiService.kt", i = {0}, l = {113}, m = "getRemoteIdsOrError", n = {AlertFragment.ARG_ITEMS}, s = {"L$0"}, v = 1)
    static final class C15421 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C15421(Continuation<? super C15421> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BoxAiService.this.getRemoteIdsOrError(null, this);
        }
    }

    @Inject
    public BoxAiService(BoxAiRemoteDataSource boxAiRemoteDataSource, IdMappingService idMappingService, CoroutineDispatcher defaultDispatcher) {
        Intrinsics.checkNotNullParameter(boxAiRemoteDataSource, "boxAiRemoteDataSource");
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        Intrinsics.checkNotNullParameter(defaultDispatcher, "defaultDispatcher");
        this.boxAiRemoteDataSource = boxAiRemoteDataSource;
        this.idMappingService = idMappingService;
        this.defaultDispatcher = defaultDispatcher;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0097, code lost:
    
        if (r8 == r1) goto L23;
     */
    @Override // com.box.android.domain.services.IBoxAiService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getPermission(com.box.android.domain.models.ItemId r6, boolean r7, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<com.box.android.domain.models.boxai.AiPermissionModel, ? extends com.box.android.domain.models.DomainError>> r8) {
        /*
            Method dump skipped, instruction units count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.boxai.BoxAiService.getPermission(com.box.android.domain.models.ItemId, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008d, code lost:
    
        if (r7 == r1) goto L23;
     */
    @Override // com.box.android.domain.services.IBoxAiService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object createSession(java.util.List<? extends com.box.android.domain.models.ItemId> r6, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<com.box.android.domain.models.boxai.AiSessionModel, ? extends com.box.android.domain.models.DomainError>> r7) {
        /*
            Method dump skipped, instruction units count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.boxai.BoxAiService.createSession(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.IBoxAiService
    public Object getAgents(Continuation<? super Result<? extends List<AiAgentModel>, ? extends DomainError>> continuation) {
        C15381 c15381;
        if (continuation instanceof C15381) {
            c15381 = (C15381) continuation;
            if ((c15381.label & Integer.MIN_VALUE) != 0) {
                c15381.label -= Integer.MIN_VALUE;
            } else {
                c15381 = new C15381(continuation);
            }
        } else {
            c15381 = new C15381(continuation);
        }
        Object aiAgents = c15381.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c15381.label;
        if (i == 0) {
            ResultKt.throwOnFailure(aiAgents);
            BoxAiRemoteDataSource boxAiRemoteDataSource = this.boxAiRemoteDataSource;
            c15381.label = 1;
            aiAgents = boxAiRemoteDataSource.getAiAgents(c15381);
            if (aiAgents == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(aiAgents);
        }
        Result.Success success = (Result) aiAgents;
        if (success instanceof Result.Success) {
            success = new Result.Success(BoxAiDTOMapperKt.toDomain((GetAiAgentsQuery.FilteredForUserAiAgents) ((Result.Success) success).getValue()));
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (success instanceof Result.Success) {
            return success;
        }
        if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (RemoteError) ((Result.Error) success).getValue(), null, 2, null));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.IBoxAiService
    public Object getRecentAiSessions(int i, Continuation<? super Result<? extends List<AiRecentSession>, ? extends DomainError>> continuation) {
        C15411 c15411;
        if (continuation instanceof C15411) {
            c15411 = (C15411) continuation;
            if ((c15411.label & Integer.MIN_VALUE) != 0) {
                c15411.label -= Integer.MIN_VALUE;
            } else {
                c15411 = new C15411(continuation);
            }
        } else {
            c15411 = new C15411(continuation);
        }
        Object recentAiSessions = c15411.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c15411.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(recentAiSessions);
            BoxAiRemoteDataSource boxAiRemoteDataSource = this.boxAiRemoteDataSource;
            c15411.I$0 = i;
            c15411.label = 1;
            recentAiSessions = boxAiRemoteDataSource.getRecentAiSessions(i, c15411);
            if (recentAiSessions == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i3 = c15411.I$0;
            ResultKt.throwOnFailure(recentAiSessions);
        }
        Result.Success success = (Result) recentAiSessions;
        if (success instanceof Result.Success) {
            success = new Result.Success(BoxAiDTOMapperKt.toDomain((GetAiSessionsQuery.ItemV2s) ((Result.Success) success).getValue()));
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (success instanceof Result.Success) {
            return success;
        }
        if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (RemoteError) ((Result.Error) success).getValue(), null, 2, null));
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.boxai.BoxAiService$getAnswerQAStreaming$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxAiService.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/boxai/AiAnswerStreamingModel;", "Lcom/box/android/domain/models/DomainError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.boxai.BoxAiService$getAnswerQAStreaming$1", f = "BoxAiService.kt", i = {0, 1, 1, 2, 2}, l = {82, 84, 100}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "remoteIdResult", "$this$flow", "remoteIdResult"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1"}, v = 1)
    static final class C15391 extends SuspendLambda implements Function2<FlowCollector<? super Result<? extends AiAnswerStreamingModel, ? extends DomainError>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $agentId;
        final /* synthetic */ String $contextSession;
        final /* synthetic */ boolean $isMultidoc;
        final /* synthetic */ List<ItemId> $itemIds;
        final /* synthetic */ String $itemSession;
        final /* synthetic */ String $prompt;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C15391(List<? extends ItemId> list, boolean z, String str, String str2, String str3, String str4, Continuation<? super C15391> continuation) {
            super(2, continuation);
            this.$itemIds = list;
            this.$isMultidoc = z;
            this.$prompt = str;
            this.$itemSession = str2;
            this.$contextSession = str3;
            this.$agentId = str4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C15391 c15391 = BoxAiService.this.new C15391(this.$itemIds, this.$isMultidoc, this.$prompt, this.$itemSession, this.$contextSession, this.$agentId, continuation);
            c15391.L$0 = obj;
            return c15391;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Result<? extends AiAnswerStreamingModel, ? extends DomainError>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C15391) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x009a, code lost:
        
            if (kotlinx.coroutines.flow.FlowKt.emitAll(r0, com.box.android.data.service.impl.boxai.BoxAiStreamingRateLimiterKt.withByWordRateLimiting(r2.mapToDomain(r5.getAnswerStreaming(r6, r7, r8, r9, r10, r11, new com.box.android.data.service.impl.boxai.BoxAiService$getAnswerQAStreaming$1$$ExternalSyntheticLambda0(r3, r12))), r14.this$0.defaultDispatcher), r14) == r1) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x00b6, code lost:
        
            if (r0.emit(r15, r14) == r1) goto L28;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                r14 = this;
                java.lang.Object r0 = r14.L$0
                kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r14.label
                r3 = 3
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L2b
                if (r2 == r5) goto L27
                if (r2 == r4) goto L1e
                if (r2 != r3) goto L16
                goto L1e
            L16:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r15)
                throw r14
            L1e:
                java.lang.Object r14 = r14.L$1
                com.box.android.domain.utils.result.Result r14 = (com.box.android.domain.utils.result.Result) r14
                kotlin.ResultKt.throwOnFailure(r15)
                goto Lb9
            L27:
                kotlin.ResultKt.throwOnFailure(r15)
                goto L41
            L2b:
                kotlin.ResultKt.throwOnFailure(r15)
                com.box.android.data.service.impl.boxai.BoxAiService r15 = com.box.android.data.service.impl.boxai.BoxAiService.this
                java.util.List<com.box.android.domain.models.ItemId> r2 = r14.$itemIds
                r6 = r14
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r14.L$0 = r0
                r14.label = r5
                java.lang.Object r15 = com.box.android.data.service.impl.boxai.BoxAiService.access$getRemoteIdsOrError(r15, r2, r6)
                if (r15 != r1) goto L41
                goto Lb8
            L41:
                com.box.android.domain.utils.result.Result r15 = (com.box.android.domain.utils.result.Result) r15
                boolean r2 = r15 instanceof com.box.android.domain.utils.result.Result.Success
                if (r2 == 0) goto L9d
                com.box.android.data.service.impl.boxai.BoxAiService r2 = com.box.android.data.service.impl.boxai.BoxAiService.this
                com.box.android.data.datasource.boxai.BoxAiRemoteDataSource r5 = com.box.android.data.service.impl.boxai.BoxAiService.access$getBoxAiRemoteDataSource$p(r2)
                r3 = r15
                com.box.android.domain.utils.result.Result$Success r3 = (com.box.android.domain.utils.result.Result.Success) r3
                java.lang.Object r3 = r3.getValue()
                r6 = r3
                java.util.List r6 = (java.util.List) r6
                boolean r3 = r14.$isMultidoc
                if (r3 == 0) goto L5e
                com.box.android.data.api.models.boxai.AiMode r3 = com.box.android.data.api.models.boxai.AiMode.HUB_QA
                goto L60
            L5e:
                com.box.android.data.api.models.boxai.AiMode r3 = com.box.android.data.api.models.boxai.AiMode.QA
            L60:
                r7 = r3
                java.lang.String r8 = r14.$prompt
                java.lang.String r9 = r14.$itemSession
                java.lang.String r10 = r14.$contextSession
                java.lang.String r11 = r14.$agentId
                com.box.android.data.service.impl.boxai.BoxAiService r3 = com.box.android.data.service.impl.boxai.BoxAiService.this
                boolean r12 = r14.$isMultidoc
                r13 = r12
                com.box.android.data.service.impl.boxai.BoxAiService$getAnswerQAStreaming$1$$ExternalSyntheticLambda0 r12 = new com.box.android.data.service.impl.boxai.BoxAiService$getAnswerQAStreaming$1$$ExternalSyntheticLambda0
                r12.<init>()
                kotlinx.coroutines.flow.Flow r3 = r5.getAnswerStreaming(r6, r7, r8, r9, r10, r11, r12)
                kotlinx.coroutines.flow.Flow r2 = com.box.android.data.service.impl.boxai.BoxAiService.access$mapToDomain(r2, r3)
                com.box.android.data.service.impl.boxai.BoxAiService r3 = com.box.android.data.service.impl.boxai.BoxAiService.this
                kotlinx.coroutines.CoroutineDispatcher r3 = com.box.android.data.service.impl.boxai.BoxAiService.access$getDefaultDispatcher$p(r3)
                kotlinx.coroutines.flow.Flow r2 = com.box.android.data.service.impl.boxai.BoxAiStreamingRateLimiterKt.withByWordRateLimiting(r2, r3)
                r3 = r14
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r14.L$0 = r5
                java.lang.Object r15 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
                r14.L$1 = r15
                r14.label = r4
                java.lang.Object r14 = kotlinx.coroutines.flow.FlowKt.emitAll(r0, r2, r3)
                if (r14 != r1) goto Lb9
                goto Lb8
            L9d:
                boolean r2 = r15 instanceof com.box.android.domain.utils.result.Result.Error
                if (r2 == 0) goto Lbc
                r2 = r14
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r14.L$0 = r4
                java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
                r14.L$1 = r4
                r14.label = r3
                java.lang.Object r14 = r0.emit(r15, r2)
                if (r14 != r1) goto Lb9
            Lb8:
                return r1
            Lb9:
                kotlin.Unit r14 = kotlin.Unit.INSTANCE
                return r14
            Lbc:
                kotlin.NoWhenBranchMatchedException r14 = new kotlin.NoWhenBranchMatchedException
                r14.<init>()
                throw r14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.boxai.BoxAiService.C15391.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final AiMode invokeSuspend$lambda$0(BoxAiService boxAiService, boolean z, RemoteError remoteError) {
            return boxAiService.getFallbackMode(remoteError, z);
        }
    }

    @Override // com.box.android.domain.services.IBoxAiService
    public Flow<Result<AiAnswerStreamingModel, DomainError>> getAnswerQAStreaming(List<? extends ItemId> itemIds, boolean isMultidoc, String prompt, String itemSession, String contextSession, String agentId) {
        Intrinsics.checkNotNullParameter(itemIds, "itemIds");
        Intrinsics.checkNotNullParameter(prompt, "prompt");
        Intrinsics.checkNotNullParameter(itemSession, "itemSession");
        return FlowKt.flow(new C15391(itemIds, isMultidoc, prompt, itemSession, contextSession, agentId, null));
    }

    public final AiMode getFallbackMode(RemoteError error, boolean isMultidoc) {
        Intrinsics.checkNotNullParameter(error, "error");
        if (isMultidoc || !isRetryable(error)) {
            return null;
        }
        return AiMode.TEXT_GEN;
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.boxai.BoxAiService$getRemoteIdsOrError$2, reason: invalid class name */
    /* JADX INFO: compiled from: BoxAiService.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/ItemId$Remote;", "Lcom/box/android/domain/models/DomainError;", "it", "Lcom/box/android/domain/models/ItemId;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.boxai.BoxAiService$getRemoteIdsOrError$2", f = "BoxAiService.kt", i = {0}, l = {113}, m = "invokeSuspend", n = {"it"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<ItemId, Continuation<? super Result<? extends ItemId.Remote, ? extends DomainError>>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = BoxAiService.this.new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(ItemId itemId, Continuation<? super Result<ItemId.Remote, ? extends DomainError>> continuation) {
            return ((AnonymousClass2) create(itemId, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(ItemId itemId, Continuation<? super Result<? extends ItemId.Remote, ? extends DomainError>> continuation) {
            return invoke2(itemId, (Continuation<? super Result<ItemId.Remote, ? extends DomainError>>) continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ItemId itemId = (ItemId) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.L$0 = SpillingKt.nullOutSpilledVariable(itemId);
            this.label = 1;
            Object remoteIdOrError = BoxAiService.this.idMappingService.getRemoteIdOrError(itemId, this);
            return remoteIdOrError == coroutine_suspended ? coroutine_suspended : remoteIdOrError;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getRemoteIdsOrError(List<? extends ItemId> list, Continuation<? super Result<? extends List<ItemId.Remote>, ? extends DomainError>> continuation) {
        C15421 c15421;
        if (continuation instanceof C15421) {
            c15421 = (C15421) continuation;
            if ((c15421.label & Integer.MIN_VALUE) != 0) {
                c15421.label -= Integer.MIN_VALUE;
            } else {
                c15421 = new C15421(continuation);
            }
        } else {
            c15421 = new C15421(continuation);
        }
        Object objMapParallel = c15421.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c15421.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objMapParallel);
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(null);
            c15421.L$0 = SpillingKt.nullOutSpilledVariable(list);
            c15421.label = 1;
            objMapParallel = CollectionUtilsKt.mapParallel(list, anonymousClass2, c15421);
            if (objMapParallel == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objMapParallel);
        }
        return com.box.android.domain.utils.result.ResultKt.transpose((List) objMapParallel);
    }

    private final boolean isRetryable(RemoteError remoteError) {
        return (remoteError instanceof RemoteError.PreconditionFailed) || (remoteError instanceof RemoteError.UnprocessableEntity);
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.boxai.BoxAiService$mapToDomain$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxAiService.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0002H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/boxai/AiAnswerStreamingModel;", "Lcom/box/android/domain/models/DomainError;", "partialResult", "Lcom/box/android/data/api/models/boxai/AiGetAnswerDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.boxai.BoxAiService$mapToDomain$1", f = "BoxAiService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C15431 extends SuspendLambda implements Function2<Result<? extends AiGetAnswerDTO, ? extends RemoteError>, Continuation<? super Flow<? extends Result<? extends AiAnswerStreamingModel, ? extends DomainError>>>, Object> {
        /* synthetic */ Object L$0;
        int label;

        C15431(Continuation<? super C15431> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C15431 c15431 = new C15431(continuation);
            c15431.L$0 = obj;
            return c15431;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Result<AiGetAnswerDTO, ? extends RemoteError> result, Continuation<? super Flow<? extends Result<? extends AiAnswerStreamingModel, ? extends DomainError>>> continuation) {
            return ((C15431) create(result, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Result<? extends AiGetAnswerDTO, ? extends RemoteError> result, Continuation<? super Flow<? extends Result<? extends AiAnswerStreamingModel, ? extends DomainError>>> continuation) {
            return invoke2((Result<AiGetAnswerDTO, ? extends RemoteError>) result, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Result.Error error = (Result) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (error instanceof Result.Success) {
                error = new Result.Success(BoxAiDTOMapperKt.toDomainList((AiGetAnswerDTO) ((Result.Success) error).getValue()));
            } else if (!(error instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            if (!(error instanceof Result.Success)) {
                if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                error = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (RemoteError) ((Result.Error) error).getValue(), null, 2, null));
            }
            return FlowKt.asFlow(com.box.android.domain.utils.result.ResultKt.transpose(error));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Flow<Result<AiAnswerStreamingModel, DomainError>> mapToDomain(Flow<? extends Result<AiGetAnswerDTO, ? extends RemoteError>> flow) {
        return FlowKt.flatMapConcat(flow, new C15431(null));
    }
}
