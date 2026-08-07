package com.box.android.data.service.impl;

import com.box.android.data.datasource.CacheError;
import com.box.android.data.datasource.localItems.LocalItemsDataSource;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.services.IdMappingService;
import com.box.android.domain.utils.result.Result;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: ItemIdMappingService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nJ\"\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nJ\u0018\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0016J\"\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\b\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/service/impl/ItemIdMappingService;", "Lcom/box/android/domain/services/IdMappingService;", "localItemsDataSource", "Lcom/box/android/data/datasource/localItems/LocalItemsDataSource;", "<init>", "(Lcom/box/android/data/datasource/localItems/LocalItemsDataSource;)V", "getRemoteId", "Lcom/box/android/domain/models/ItemId$Remote;", "itemId", "Lcom/box/android/domain/models/ItemId;", "(Lcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRemoteIdOrError", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/DomainError;", "observeRemoteId", "Lkotlinx/coroutines/flow/Flow;", "id", "getServerId", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ItemIdMappingService implements IdMappingService {
    private final LocalItemsDataSource localItemsDataSource;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.ItemIdMappingService$getRemoteId$1, reason: invalid class name */
    /* JADX INFO: compiled from: ItemIdMappingService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.ItemIdMappingService", f = "ItemIdMappingService.kt", i = {0}, l = {20}, m = "getRemoteId", n = {"itemId"}, s = {"L$0"}, v = 1)
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
            return ItemIdMappingService.this.getRemoteId(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.ItemIdMappingService$getRemoteIdOrError$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ItemIdMappingService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.ItemIdMappingService", f = "ItemIdMappingService.kt", i = {0}, l = {26}, m = "getRemoteIdOrError", n = {"itemId"}, s = {"L$0"}, v = 1)
    static final class C14401 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C14401(Continuation<? super C14401> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ItemIdMappingService.this.getRemoteIdOrError(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.ItemIdMappingService$getServerId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ItemIdMappingService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.ItemIdMappingService", f = "ItemIdMappingService.kt", i = {0}, l = {53}, m = "getServerId", n = {"itemId"}, s = {"L$0"}, v = 1)
    static final class C14411 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C14411(Continuation<? super C14411> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ItemIdMappingService.this.getServerId(null, this);
        }
    }

    @Inject
    public ItemIdMappingService(LocalItemsDataSource localItemsDataSource) {
        Intrinsics.checkNotNullParameter(localItemsDataSource, "localItemsDataSource");
        this.localItemsDataSource = localItemsDataSource;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.IdMappingService
    public Object getRemoteId(ItemId itemId, Continuation<? super ItemId.Remote> continuation) {
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
        Object remoteIdOrError = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(remoteIdOrError);
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(itemId);
            anonymousClass1.label = 1;
            remoteIdOrError = getRemoteIdOrError(itemId, anonymousClass1);
            if (remoteIdOrError == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(remoteIdOrError);
        }
        return com.box.android.domain.utils.result.ResultKt.getOrNull((Result) remoteIdOrError);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.IdMappingService
    public Object getRemoteIdOrError(ItemId itemId, Continuation<? super Result<ItemId.Remote, ? extends DomainError>> continuation) {
        C14401 c14401;
        if (continuation instanceof C14401) {
            c14401 = (C14401) continuation;
            if ((c14401.label & Integer.MIN_VALUE) != 0) {
                c14401.label -= Integer.MIN_VALUE;
            } else {
                c14401 = new C14401(continuation);
            }
        } else {
            c14401 = new C14401(continuation);
        }
        Object serverId = c14401.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14401.label;
        if (i == 0) {
            ResultKt.throwOnFailure(serverId);
            c14401.L$0 = itemId;
            c14401.label = 1;
            serverId = getServerId(itemId, c14401);
            if (serverId == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            itemId = (ItemId) c14401.L$0;
            ResultKt.throwOnFailure(serverId);
        }
        Result.Success success = (Result) serverId;
        if (success instanceof Result.Success) {
            success = new Result.Success(new ItemId.Remote((String) ((Result.Success) success).getValue(), itemId.getType()));
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (success instanceof Result.Success) {
            return success;
        }
        if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        String simpleName = ((DomainError) ((Result.Error) success).getValue()).getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        return new Result.Error(new DomainError.ItemRemoteIdIsNull(simpleName));
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.ItemIdMappingService$observeRemoteId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ItemIdMappingService.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/models/ItemId$Remote;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.ItemIdMappingService$observeRemoteId$1", f = "ItemIdMappingService.kt", i = {0, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3}, l = {31, 33, 40, 42}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "remoteId", "$this$flow", "remoteId", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "localIdToServerIdFlow", "it", "$i$a$-let-ItemIdMappingService$observeRemoteId$1$2", "$this$flow", "remoteId", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "localIdToServerIdFlow", "$this$invokeSuspend_u24lambda_u242", "$i$a$-run-ItemIdMappingService$observeRemoteId$1$3"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
    static final class C14421 extends SuspendLambda implements Function2<FlowCollector<? super ItemId.Remote>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ItemId $id;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14421(ItemId itemId, Continuation<? super C14421> continuation) {
            super(2, continuation);
            this.$id = itemId;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C14421 c14421 = ItemIdMappingService.this.new C14421(this.$id, continuation);
            c14421.L$0 = obj;
            return c14421;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super ItemId.Remote> flowCollector, Continuation<? super Unit> continuation) {
            return ((C14421) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x006d, code lost:
        
            if (r0.emit(r9, r8) == r1) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x00b5, code lost:
        
            if (kotlinx.coroutines.flow.FlowKt.emitAll(r0, r7, r8) == r1) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x00f1, code lost:
        
            if (r0.emit(null, r8) == r1) goto L30;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                Method dump skipped, instruction units count: 247
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.ItemIdMappingService.C14421.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.box.android.domain.services.IdMappingService
    public Flow<ItemId.Remote> observeRemoteId(ItemId id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return FlowKt.flow(new C14421(id, null));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getServerId(ItemId itemId, Continuation<? super Result<String, ? extends DomainError>> continuation) {
        C14411 c14411;
        if (continuation instanceof C14411) {
            c14411 = (C14411) continuation;
            if ((c14411.label & Integer.MIN_VALUE) != 0) {
                c14411.label -= Integer.MIN_VALUE;
            } else {
                c14411 = new C14411(continuation);
            }
        } else {
            c14411 = new C14411(continuation);
        }
        Object serverId = c14411.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14411.label;
        if (i == 0) {
            ResultKt.throwOnFailure(serverId);
            if (itemId instanceof ItemId.Remote) {
                return new Result.Success(((ItemId.Remote) itemId).getBoxId());
            }
            if (!(itemId instanceof ItemId.Local)) {
                throw new NoWhenBranchMatchedException();
            }
            c14411.L$0 = SpillingKt.nullOutSpilledVariable(itemId);
            c14411.label = 1;
            serverId = this.localItemsDataSource.getServerId((ItemId.Local) itemId, c14411);
            if (serverId == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(serverId);
        }
        Result.Success success = (Result) serverId;
        if (success instanceof Result.Success) {
            success = new Result.Success((String) ((Result.Success) success).getValue());
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (success instanceof Result.Success) {
            return success;
        }
        if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) success).getValue(), null, 2, null));
    }
}
