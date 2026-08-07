package com.box.android.data.service.impl;

import com.box.android.coreservices.jobmanager.jobs.BoxItemJob;
import com.box.android.data.api.models.collections.ErrorCodes;
import com.box.android.data.api.models.collections.MembershipOperationsResultItemDTO;
import com.box.android.data.datasource.ErrorUtil;
import com.box.android.data.datasource.errors.CollectionsRemoteError;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.IGenericError;
import com.box.android.domain.utils.result.Result;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import java.util.ArrayList;
import java.util.List;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: CollectionsServiceUtils.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J~\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0018\u0010\u000e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000f\u0012\u0004\u0012\u00020\u00100\u000b2@\u0010\u0011\u001a<\b\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u000b0\u000f\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012H\u0086@¢\u0006\u0002\u0010\u0014J~\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00160\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0018\u0010\u000e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000f\u0012\u0004\u0012\u00020\u00100\u000b2@\u0010\u0011\u001a<\b\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u000b0\u000f\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012H\u0086@¢\u0006\u0002\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/box/android/data/service/impl/CollectionsServiceUtils;", "", "<init>", "()V", "mapToCollectionItemRelationEntity", "Lcom/box/android/data/service/impl/CollectionItemRelationEntity;", BoxItemJob.COLLECTION_ID, "", "membershipOperationsResultItemDTO", "Lcom/box/android/data/api/models/collections/MembershipOperationsResultItemDTO;", "processUpdateCollectionResultToGenericError", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/IGenericError;", "updateCollectionRequestResult", "", "Lcom/box/android/data/datasource/errors/RemoteError;", "cacheOperation", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/String;Lcom/box/android/domain/utils/result/Result;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processUpdateCollectionResult", "Lcom/box/android/domain/models/DomainError;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CollectionsServiceUtils {
    public static final CollectionsServiceUtils INSTANCE = new CollectionsServiceUtils();

    /* JADX INFO: renamed from: com.box.android.data.service.impl.CollectionsServiceUtils$processUpdateCollectionResult$1, reason: invalid class name */
    /* JADX INFO: compiled from: CollectionsServiceUtils.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.CollectionsServiceUtils", f = "CollectionsServiceUtils.kt", i = {0, 0, 0}, l = {99}, m = "processUpdateCollectionResult", n = {BoxItemJob.COLLECTION_ID, "updateCollectionRequestResult", "cacheOperation"}, s = {"L$0", "L$1", "L$2"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
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
            return CollectionsServiceUtils.this.processUpdateCollectionResult(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.CollectionsServiceUtils$processUpdateCollectionResultToGenericError$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CollectionsServiceUtils.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.CollectionsServiceUtils", f = "CollectionsServiceUtils.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {84}, m = "processUpdateCollectionResultToGenericError", n = {BoxItemJob.COLLECTION_ID, "updateCollectionRequestResult", "cacheOperation", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$flatMap$iv", "entities", "$i$f$flatMap", "$i$a$-flatMap-CollectionsServiceUtils$processUpdateCollectionResultToGenericError$3"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1"}, v = 1)
    static final class C14101 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C14101(Continuation<? super C14101> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CollectionsServiceUtils.this.processUpdateCollectionResultToGenericError(null, null, null, this);
        }
    }

    private CollectionsServiceUtils() {
    }

    private final CollectionItemRelationEntity mapToCollectionItemRelationEntity(String collectionId, MembershipOperationsResultItemDTO membershipOperationsResultItemDTO) {
        return new CollectionItemRelationEntity(collectionId, membershipOperationsResultItemDTO.getId(), membershipOperationsResultItemDTO.getType().toString(), null, 8, null);
    }

    /* JADX WARN: Code duplicated, block: B:44:0x014c  */
    /* JADX WARN: Code duplicated, block: B:45:0x015f  */
    /* JADX WARN: Code duplicated, block: B:48:0x0165  */
    /* JADX WARN: Code duplicated, block: B:50:0x0169  */
    /* JADX WARN: Code duplicated, block: B:51:0x0179  */
    /* JADX WARN: Code duplicated, block: B:55:0x0185  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r13v2, types: [T, com.box.android.domain.utils.result.Result$Error] */
    /* JADX WARN: Type inference failed for: r13v7, types: [T, com.box.android.domain.utils.result.Result$Success] */
    public final Object processUpdateCollectionResultToGenericError(String str, Result<? extends List<MembershipOperationsResultItemDTO>, ? extends RemoteError> result, Function2<? super List<? extends Result<CollectionItemRelationEntity, ? extends RemoteError>>, ? super Continuation<? super Result<Unit, ? extends IGenericError>>, ? extends Object> function2, Continuation<? super Result<Unit, ? extends IGenericError>> continuation) {
        C14101 c14101;
        Ref.ObjectRef objectRef;
        Result.Success success;
        Ref.ObjectRef objectRef2;
        Result success2;
        boolean z;
        if (continuation instanceof C14101) {
            c14101 = (C14101) continuation;
            if ((c14101.label & Integer.MIN_VALUE) != 0) {
                c14101.label -= Integer.MIN_VALUE;
            } else {
                c14101 = new C14101(continuation);
            }
        } else {
            c14101 = new C14101(continuation);
        }
        Object obj = c14101.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14101.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            objectRef = new Ref.ObjectRef();
            if (result instanceof Result.Success) {
                List<MembershipOperationsResultItemDTO> list = (List) ((Result.Success) result).getValue();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (MembershipOperationsResultItemDTO membershipOperationsResultItemDTO : list) {
                    if (Intrinsics.areEqual(membershipOperationsResultItemDTO.getErrorCode(), "none") || (Integer.parseInt(membershipOperationsResultItemDTO.getStatusCode()) == 409 && Intrinsics.areEqual(membershipOperationsResultItemDTO.getErrorCode(), ErrorCodes.DUPLICATE_ERROR))) {
                        success2 = new Result.Success(INSTANCE.mapToCollectionItemRelationEntity(str, membershipOperationsResultItemDTO));
                    } else {
                        success2 = new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteError(Integer.parseInt(membershipOperationsResultItemDTO.getStatusCode()), membershipOperationsResultItemDTO.getErrorCode(), "Operation with item id " + membershipOperationsResultItemDTO.getId() + " was not successful", null));
                    }
                    arrayList.add(success2);
                }
                success = new Result.Success(arrayList);
            } else {
                if (!(result instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                success = result;
            }
            if (success instanceof Result.Success) {
                List list2 = (List) ((Result.Success) success).getValue();
                c14101.L$0 = SpillingKt.nullOutSpilledVariable(str);
                c14101.L$1 = SpillingKt.nullOutSpilledVariable(result);
                c14101.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                c14101.L$3 = objectRef;
                c14101.L$4 = SpillingKt.nullOutSpilledVariable(success);
                c14101.L$5 = SpillingKt.nullOutSpilledVariable(list2);
                c14101.I$0 = 0;
                c14101.I$1 = 0;
                c14101.label = 1;
                Object objInvoke = function2.invoke(list2, c14101);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef2 = objectRef;
                obj = objInvoke;
            } else if (!(success instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            z = success instanceof Result.Success;
            if (z) {
                objectRef.element = new Result.Success(Unit.INSTANCE);
            } else if (!(success instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            if (!z) {
                if (success instanceof Result.Error) {
                    objectRef.element = new Result.Error((IGenericError) ((Result.Error) success).getValue());
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            T t = objectRef.element;
            Intrinsics.checkNotNull(t);
            return t;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i2 = c14101.I$1;
        int i3 = c14101.I$0;
        objectRef2 = (Ref.ObjectRef) c14101.L$3;
        ResultKt.throwOnFailure(obj);
        success = (Result) obj;
        objectRef = objectRef2;
        z = success instanceof Result.Success;
        if (z) {
            objectRef.element = new Result.Success(Unit.INSTANCE);
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (!z) {
            if (success instanceof Result.Error) {
                objectRef.element = new Result.Error((IGenericError) ((Result.Error) success).getValue());
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        T t2 = objectRef.element;
        Intrinsics.checkNotNull(t2);
        return t2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object processUpdateCollectionResult(String str, Result<? extends List<MembershipOperationsResultItemDTO>, ? extends RemoteError> result, Function2<? super List<? extends Result<CollectionItemRelationEntity, ? extends RemoteError>>, ? super Continuation<? super Result<Unit, ? extends IGenericError>>, ? extends Object> function2, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        AnonymousClass1 anonymousClass1;
        DomainError domainError;
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
        Object objProcessUpdateCollectionResultToGenericError = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objProcessUpdateCollectionResultToGenericError);
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(result);
            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(function2);
            anonymousClass1.label = 1;
            objProcessUpdateCollectionResultToGenericError = processUpdateCollectionResultToGenericError(str, result, function2, anonymousClass1);
            if (objProcessUpdateCollectionResultToGenericError == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objProcessUpdateCollectionResultToGenericError);
        }
        Result result2 = (Result) objProcessUpdateCollectionResultToGenericError;
        if (result2 instanceof Result.Success) {
            return result2;
        }
        if (result2 instanceof Result.Error) {
            IGenericError iGenericError = (IGenericError) ((Result.Error) result2).getValue();
            if (iGenericError instanceof CollectionsRemoteError) {
                domainError = DomainErrorMapper.INSTANCE.toDomainError((CollectionsRemoteError) iGenericError);
            } else {
                domainError = DomainErrorMapper.INSTANCE.toDomainError(iGenericError, "Unknown error while updating collection membership");
            }
            return new Result.Error(domainError);
        }
        throw new NoWhenBranchMatchedException();
    }
}
