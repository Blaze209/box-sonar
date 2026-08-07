package com.box.android.data.datasource.collection.interceptors;

import com.apollographql.apollo3.api.Error;
import com.box.android.data.DeleteCollectionItemMutation;
import com.box.android.data.datasource.errors.CollectionsRemoteError;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.service.impl.CollectionItemRelationEntity;
import com.box.android.domain.models.IGenericError;
import com.box.android.domain.utils.result.Result;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: GQLRemoveCollectionItemResponseInterceptor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00010\u0005H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/IGenericError;", "it", "", "Lcom/box/android/data/service/impl/CollectionItemRelationEntity;", "Lcom/box/android/data/datasource/errors/RemoteError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.datasource.collection.interceptors.GQLRemoveCollectionItemResponseInterceptor$intercept$1$cacheOperation$1", f = "GQLRemoveCollectionItemResponseInterceptor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class GQLRemoveCollectionItemResponseInterceptor$intercept$1$cacheOperation$1 extends SuspendLambda implements Function2<List<? extends Result<? extends CollectionItemRelationEntity, ? extends RemoteError>>, Continuation<? super Result<? extends Unit, ? extends IGenericError>>, Object> {
    final /* synthetic */ String $collectionId;
    final /* synthetic */ Ref.ObjectRef<DeleteCollectionItemMutation.DeleteCollectionItem> $mutation;
    final /* synthetic */ Ref.ObjectRef<Error> $responseError;
    final /* synthetic */ Ref.IntRef $statusCode;
    final /* synthetic */ Ref.ObjectRef<IOException> $thrownException;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GQLRemoveCollectionItemResponseInterceptor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GQLRemoveCollectionItemResponseInterceptor$intercept$1$cacheOperation$1(Ref.ObjectRef<DeleteCollectionItemMutation.DeleteCollectionItem> objectRef, String str, Ref.IntRef intRef, Ref.ObjectRef<Error> objectRef2, GQLRemoveCollectionItemResponseInterceptor gQLRemoveCollectionItemResponseInterceptor, Ref.ObjectRef<IOException> objectRef3, Continuation<? super GQLRemoveCollectionItemResponseInterceptor$intercept$1$cacheOperation$1> continuation) {
        super(2, continuation);
        this.$mutation = objectRef;
        this.$collectionId = str;
        this.$statusCode = intRef;
        this.$responseError = objectRef2;
        this.this$0 = gQLRemoveCollectionItemResponseInterceptor;
        this.$thrownException = objectRef3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GQLRemoveCollectionItemResponseInterceptor$intercept$1$cacheOperation$1 gQLRemoveCollectionItemResponseInterceptor$intercept$1$cacheOperation$1 = new GQLRemoveCollectionItemResponseInterceptor$intercept$1$cacheOperation$1(this.$mutation, this.$collectionId, this.$statusCode, this.$responseError, this.this$0, this.$thrownException, continuation);
        gQLRemoveCollectionItemResponseInterceptor$intercept$1$cacheOperation$1.L$0 = obj;
        return gQLRemoveCollectionItemResponseInterceptor$intercept$1$cacheOperation$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(List<? extends Result<? extends CollectionItemRelationEntity, ? extends RemoteError>> list, Continuation<? super Result<? extends Unit, ? extends IGenericError>> continuation) {
        return invoke2((List<? extends Result<CollectionItemRelationEntity, ? extends RemoteError>>) list, (Continuation<? super Result<Unit, ? extends IGenericError>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(List<? extends Result<CollectionItemRelationEntity, ? extends RemoteError>> list, Continuation<? super Result<Unit, ? extends IGenericError>> continuation) {
        return ((GQLRemoveCollectionItemResponseInterceptor$intercept$1$cacheOperation$1) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [T, com.box.android.data.DeleteCollectionItemMutation$DeleteCollectionItem] */
    /* JADX WARN: Type inference failed for: r0v9, types: [T, java.io.IOException] */
    /* JADX WARN: Type inference failed for: r4v7, types: [T, com.apollographql.apollo3.api.Error] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List list = (List) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Result result = (Result) list.get(0);
        if (result instanceof Result.Success) {
            this.$mutation.element = new DeleteCollectionItemMutation.DeleteCollectionItem(this.$collectionId);
            this.$statusCode.element = 200;
            return new Result.Success(Unit.INSTANCE);
        }
        if (!(result instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        this.$mutation.element = null;
        Result.Error error = (Result.Error) result;
        this.$statusCode.element = ((RemoteError) error.getValue()).getCode();
        if (((RemoteError) error.getValue()) instanceof CollectionsRemoteError) {
            Ref.ObjectRef<Error> objectRef = this.$responseError;
            GQLRemoveCollectionItemResponseInterceptor gQLRemoveCollectionItemResponseInterceptor = this.this$0;
            Object value = error.getValue();
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type com.box.android.data.datasource.errors.CollectionsRemoteError");
            objectRef.element = gQLRemoveCollectionItemResponseInterceptor.getError((CollectionsRemoteError) value);
        } else {
            this.$thrownException.element = new IOException(error.getValue() + " Code: " + ((RemoteError) error.getValue()).getCode());
        }
        return new Result.Error(error.getValue());
    }
}
