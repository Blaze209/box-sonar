package com.box.android.data.service.impl;

import com.box.android.common.utilities.CollectionUtilsKt;
import com.box.android.domain.configuration.DataPolicy;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.utils.result.Result;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: OfflineService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/box/android/domain/models/item/FolderModel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.service.impl.OfflineService$fetchOfflineItems$2$folders$1", f = "OfflineService.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class OfflineService$fetchOfflineItems$2$folders$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends FolderModel>>, Object> {
    final /* synthetic */ DataPolicy $dataPolicy;
    final /* synthetic */ List<String> $folderIds;
    int label;
    final /* synthetic */ OfflineService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OfflineService$fetchOfflineItems$2$folders$1(List<String> list, OfflineService offlineService, DataPolicy dataPolicy, Continuation<? super OfflineService$fetchOfflineItems$2$folders$1> continuation) {
        super(2, continuation);
        this.$folderIds = list;
        this.this$0 = offlineService;
        this.$dataPolicy = dataPolicy;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OfflineService$fetchOfflineItems$2$folders$1(this.$folderIds, this.this$0, this.$dataPolicy, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends FolderModel>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<FolderModel>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<FolderModel>> continuation) {
        return ((OfflineService$fetchOfflineItems$2$folders$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.OfflineService$fetchOfflineItems$2$folders$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: OfflineService.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/models/item/FolderModel;", "id", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.OfflineService$fetchOfflineItems$2$folders$1$1", f = "OfflineService.kt", i = {0}, l = {108}, m = "invokeSuspend", n = {"id"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<String, Continuation<? super FolderModel>, Object> {
        final /* synthetic */ DataPolicy $dataPolicy;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ OfflineService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(OfflineService offlineService, DataPolicy dataPolicy, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = offlineService;
            this.$dataPolicy = dataPolicy;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$dataPolicy, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(String str, Continuation<? super FolderModel> continuation) {
            return ((AnonymousClass1) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str = (String) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.L$0 = SpillingKt.nullOutSpilledVariable(str);
                this.label = 1;
                obj = this.this$0.remoteItemService.item(new ItemId.Remote(str, ItemType.FOLDER), this.$dataPolicy, (Continuation<? super Result<? extends ItemModel, ? extends DomainError>>) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Object orNull = com.box.android.domain.utils.result.ResultKt.getOrNull((Result) obj);
            if (orNull instanceof FolderModel) {
                return (FolderModel) orNull;
            }
            return null;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = CollectionUtilsKt.mapParallel(this.$folderIds, new AnonymousClass1(this.this$0, this.$dataPolicy, null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return CollectionsKt.filterNotNull((Iterable) obj);
    }
}
