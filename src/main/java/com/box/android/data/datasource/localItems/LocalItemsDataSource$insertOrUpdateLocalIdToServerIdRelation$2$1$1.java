package com.box.android.data.datasource.localItems;

import com.box.android.data.persistence.BoxDatabase;
import com.box.android.data.persistence.localItems.LocalIdToServerIdRelationEntity;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: LocalItemsDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.datasource.localItems.LocalItemsDataSource$insertOrUpdateLocalIdToServerIdRelation$2$1$1", f = "LocalItemsDataSource.kt", i = {}, l = {Token.LOOP}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class LocalItemsDataSource$insertOrUpdateLocalIdToServerIdRelation$2$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ BoxDatabase $boxDatabase;
    final /* synthetic */ LocalIdToServerIdRelationEntity $localIdToServerIdRelationEntity;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LocalItemsDataSource$insertOrUpdateLocalIdToServerIdRelation$2$1$1(BoxDatabase boxDatabase, LocalIdToServerIdRelationEntity localIdToServerIdRelationEntity, Continuation<? super LocalItemsDataSource$insertOrUpdateLocalIdToServerIdRelation$2$1$1> continuation) {
        super(1, continuation);
        this.$boxDatabase = boxDatabase;
        this.$localIdToServerIdRelationEntity = localIdToServerIdRelationEntity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new LocalItemsDataSource$insertOrUpdateLocalIdToServerIdRelation$2$1$1(this.$boxDatabase, this.$localIdToServerIdRelationEntity, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((LocalItemsDataSource$insertOrUpdateLocalIdToServerIdRelation$2$1$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.$boxDatabase.localItemsDao().insertOrUpdateLocalIdToServerId(this.$localIdToServerIdRelationEntity, this) == coroutine_suspended) {
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
}
