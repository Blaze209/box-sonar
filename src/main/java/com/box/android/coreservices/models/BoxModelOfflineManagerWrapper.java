package com.box.android.coreservices.models;

import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.services.IRemoteItemService;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: BoxModelOfflineManagerWrapper.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/box/android/coreservices/models/BoxModelOfflineManagerWrapper;", "", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "remoteItemService", "Lcom/box/android/domain/services/IRemoteItemService;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/domain/services/IRemoteItemService;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getState", "Lcom/box/android/coreservices/models/BoxModelOfflineManager$State;", "item", "Lcom/box/android/domain/models/item/ItemModel;", "(Lcom/box/android/domain/models/item/ItemModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStateFlow", "Lkotlinx/coroutines/flow/Flow;", "itemId", "Lcom/box/android/domain/models/ItemId;", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxModelOfflineManagerWrapper {
    private final CoroutineDispatcher dispatcher;
    private final IRemoteItemService remoteItemService;
    private final IUserContextManager userContextManager;

    @Inject
    public BoxModelOfflineManagerWrapper(IUserContextManager userContextManager, IRemoteItemService remoteItemService, CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(remoteItemService, "remoteItemService");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.userContextManager = userContextManager;
        this.remoteItemService = remoteItemService;
        this.dispatcher = dispatcher;
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.models.BoxModelOfflineManagerWrapper$getState$2, reason: invalid class name */
    /* JADX INFO: compiled from: BoxModelOfflineManagerWrapper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/box/android/coreservices/models/BoxModelOfflineManager$State;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.models.BoxModelOfflineManagerWrapper$getState$2", f = "BoxModelOfflineManagerWrapper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BoxModelOfflineManager.State>, Object> {
        final /* synthetic */ ItemModel $item;
        int label;
        final /* synthetic */ BoxModelOfflineManagerWrapper this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ItemModel itemModel, BoxModelOfflineManagerWrapper boxModelOfflineManagerWrapper, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$item = itemModel;
            this.this$0 = boxModelOfflineManagerWrapper;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$item, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BoxModelOfflineManager.State> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return BoxModelOfflineManager.getState(this.$item, this.this$0.userContextManager);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object getState(ItemModel itemModel, Continuation<? super BoxModelOfflineManager.State> continuation) {
        return BuildersKt.withContext(this.dispatcher, new AnonymousClass2(itemModel, this, null), continuation);
    }

    public final Flow<BoxModelOfflineManager.State> getStateFlow(ItemId itemId) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        return FlowKt.flowOn(BoxModelOfflineManager.INSTANCE.getStateFlow(itemId, this.userContextManager, this.remoteItemService), this.dispatcher);
    }
}
