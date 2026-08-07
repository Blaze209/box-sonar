package com.box.android.domain.usecases.collections;

import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.CollectionType;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.services.ICollectionsService;
import com.box.android.domain.utils.result.Result;
import javax.inject.Inject;
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
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CreateCollectionInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/box/android/domain/usecases/collections/CreateCollectionInteractor;", "Lcom/box/android/domain/usecases/collections/CreateCollectionUseCase;", "collectionService", "Lcom/box/android/domain/services/ICollectionsService;", "<init>", "(Lcom/box/android/domain/services/ICollectionsService;)V", "createCollection", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/CollectionModel;", "Lcom/box/android/domain/models/DomainError;", "collectionName", "", "collectionType", "Lcom/box/android/domain/models/CollectionType;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CreateCollectionInteractor implements CreateCollectionUseCase {
    private final ICollectionsService collectionService;

    @Inject
    public CreateCollectionInteractor(ICollectionsService collectionService) {
        Intrinsics.checkNotNullParameter(collectionService, "collectionService");
        this.collectionService = collectionService;
    }

    /* JADX INFO: renamed from: com.box.android.domain.usecases.collections.CreateCollectionInteractor$createCollection$1, reason: invalid class name */
    /* JADX INFO: compiled from: CreateCollectionInteractor.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/CollectionModel;", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.collections.CreateCollectionInteractor$createCollection$1", f = "CreateCollectionInteractor.kt", i = {}, l = {14}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends CollectionModel, ? extends DomainError>>, Object> {
        final /* synthetic */ String $collectionName;
        final /* synthetic */ CollectionType $collectionType;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, CollectionType collectionType, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$collectionName = str;
            this.$collectionType = collectionType;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CreateCollectionInteractor.this.new AnonymousClass1(this.$collectionName, this.$collectionType, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends CollectionModel, ? extends DomainError>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<CollectionModel, ? extends DomainError>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<CollectionModel, ? extends DomainError>> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = CreateCollectionInteractor.this.collectionService.createCollection(this.$collectionName, this.$collectionType, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Result result = (Result) obj;
            if (result instanceof Result.Success) {
                return new Result.Success(((Result.Success) result).getValue());
            }
            if (result instanceof Result.Error) {
                return new Result.Error(((Result.Error) result).getValue());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.box.android.domain.usecases.collections.CreateCollectionUseCase
    public Result<CollectionModel, DomainError> createCollection(String collectionName, CollectionType collectionType) {
        Intrinsics.checkNotNullParameter(collectionName, "collectionName");
        Intrinsics.checkNotNullParameter(collectionType, "collectionType");
        return (Result) BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(collectionName, collectionType, null), 1, null);
    }
}
