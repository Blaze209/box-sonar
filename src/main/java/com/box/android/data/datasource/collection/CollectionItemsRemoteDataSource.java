package com.box.android.data.datasource.collection;

import com.box.android.coreservices.jobmanager.jobs.BoxItemJob;
import com.box.android.data.api.models.collections.CollectionItemDTO;
import com.box.android.data.api.models.collections.CollectionItemsDTO;
import com.box.android.data.api.models.collections.MembershipOperationDTO;
import com.box.android.data.api.models.collections.MembershipOperations;
import com.box.android.data.api.models.collections.MembershipOperationsResultDTO;
import com.box.android.data.api.models.collections.MembershipOperationsResultItemDTO;
import com.box.android.data.api.models.items.IItemDTO;
import com.box.android.data.api.models.items.ItemDTOFields;
import com.box.android.data.api.models.items.mini.ItemIdDTO;
import com.box.android.data.api.requests.CollectionItemsRequest;
import com.box.android.data.datasource.ErrorUtil;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxIterator;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.squareup.moshi.Moshi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: CollectionItemsRemoteDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 %2\u00020\u0001:\u0001%B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\r0\n0\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016JD\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u000b\u0012\u0004\u0012\u00020\r0\n2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u000bH\u0096@¢\u0006\u0002\u0010\u0015J\u007f\u0010\u0016\u001a0\b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00172:\u0010\u001b\u001a6\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001c2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¢\u0006\u0002\u0010\u001dJq\u0010\u001e\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001f24\u0010\u001b\u001a0\b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00172\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u0018H\u0002¢\u0006\u0002\u0010\"JK\u0010#\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\r0\n0\t2$\u0010\u001b\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001fH\u0002¢\u0006\u0002\u0010$R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/box/android/data/datasource/collection/CollectionItemsRemoteDataSource;", "", "collectionItemsRequest", "Lcom/box/android/data/api/requests/CollectionItemsRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/box/android/data/api/requests/CollectionItemsRequest;Lcom/squareup/moshi/Moshi;)V", "getCollectionItems", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/api/models/items/IItemDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;", BoxItemJob.COLLECTION_ID, "", "updateCollection", "Lcom/box/android/data/api/models/collections/MembershipOperationsResultItemDTO;", "itemsToAdd", "Lcom/box/android/domain/models/ItemId$Remote;", "itemsToRemove", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setCollectionId", "Lkotlin/Function4;", "", "Lkotlin/coroutines/Continuation;", "Lcom/box/android/data/api/models/collections/CollectionItemsDTO;", "request", "Lkotlin/Function5;", "(Lkotlin/jvm/functions/Function5;Ljava/lang/String;)Lkotlin/jvm/functions/Function4;", "setItemFieldsAndLimit", "Lkotlin/Function2;", "itemFieldsStr", BoxIterator.FIELD_LIMIT, "(Lkotlin/jvm/functions/Function4;Ljava/lang/String;I)Lkotlin/jvm/functions/Function2;", "getCollectionItemsFromRemote", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class CollectionItemsRemoteDataSource {
    private static final String LOGTAG = "CollectionItemsRemoteDataSource";
    private final CollectionItemsRequest collectionItemsRequest;
    private final Moshi moshi;

    /* JADX INFO: renamed from: com.box.android.data.datasource.collection.CollectionItemsRemoteDataSource$updateCollection$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CollectionItemsRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.collection.CollectionItemsRemoteDataSource", f = "CollectionItemsRemoteDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {74}, m = "updateCollection$suspendImpl", n = {"$this", BoxItemJob.COLLECTION_ID, "itemsToAdd", "itemsToRemove", "membershipOperations", "$i$f$resultOf", "$i$a$-resultOf-CollectionItemsRemoteDataSource$updateCollection$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1"}, v = 1)
    static final class C11261 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C11261(Continuation<? super C11261> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CollectionItemsRemoteDataSource.updateCollection$suspendImpl(CollectionItemsRemoteDataSource.this, null, null, null, this);
        }
    }

    public Object updateCollection(String str, List<ItemId.Remote> list, List<ItemId.Remote> list2, Continuation<? super Result<? extends List<MembershipOperationsResultItemDTO>, ? extends RemoteError>> continuation) {
        return updateCollection$suspendImpl(this, str, list, list2, continuation);
    }

    @Inject
    public CollectionItemsRemoteDataSource(CollectionItemsRequest collectionItemsRequest, Moshi moshi) {
        Intrinsics.checkNotNullParameter(collectionItemsRequest, "collectionItemsRequest");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.collectionItemsRequest = collectionItemsRequest;
        this.moshi = moshi;
    }

    public Flow<Result<List<IItemDTO>, RemoteError>> getCollectionItems(String collectionId) {
        Intrinsics.checkNotNullParameter(collectionId, "collectionId");
        return getCollectionItemsFromRemote(setItemFieldsAndLimit(setCollectionId(new CollectionItemsRemoteDataSource$getCollectionItems$partialWithCollectionId$1(this.collectionItemsRequest), collectionId), ItemDTOFields.INSTANCE.getDEFAULT_ITEM_FIELDS(), 100));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    static /* synthetic */ Object updateCollection$suspendImpl(CollectionItemsRemoteDataSource collectionItemsRemoteDataSource, String str, List<ItemId.Remote> list, List<ItemId.Remote> list2, Continuation<? super Result<? extends List<MembershipOperationsResultItemDTO>, ? extends RemoteError>> continuation) {
        C11261 c11261;
        Result.Error error;
        if (continuation instanceof C11261) {
            c11261 = (C11261) continuation;
            if ((c11261.label & Integer.MIN_VALUE) != 0) {
                c11261.label -= Integer.MIN_VALUE;
            } else {
                c11261 = collectionItemsRemoteDataSource.new C11261(continuation);
            }
        } else {
            c11261 = collectionItemsRemoteDataSource.new C11261(continuation);
        }
        Object objUpdateCollection = c11261.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11261.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objUpdateCollection);
                List<ItemId.Remote> list3 = list;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                for (ItemId.Remote remote : list3) {
                    arrayList.add(new MembershipOperationDTO(MembershipOperations.ADD, new ItemIdDTO(remote.getBoxId(), remote.getType())));
                }
                ArrayList arrayList2 = arrayList;
                List<ItemId.Remote> list4 = list2;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
                for (ItemId.Remote remote2 : list4) {
                    arrayList3.add(new MembershipOperationDTO(MembershipOperations.REMOVE, new ItemIdDTO(remote2.getBoxId(), remote2.getType())));
                }
                List listPlus = CollectionsKt.plus((Collection) arrayList2, (Iterable) arrayList3);
                Intrinsics.checkNotNull(listPlus, "null cannot be cast to non-null type java.util.ArrayList<com.box.android.data.api.models.collections.MembershipOperationDTO>");
                ArrayList arrayList4 = (ArrayList) listPlus;
                c11261.L$0 = collectionItemsRemoteDataSource;
                c11261.L$1 = SpillingKt.nullOutSpilledVariable(str);
                c11261.L$2 = SpillingKt.nullOutSpilledVariable(list);
                c11261.L$3 = SpillingKt.nullOutSpilledVariable(list2);
                c11261.L$4 = SpillingKt.nullOutSpilledVariable(arrayList4);
                c11261.I$0 = 0;
                c11261.I$1 = 0;
                c11261.label = 1;
                objUpdateCollection = collectionItemsRemoteDataSource.collectionItemsRequest.updateCollection(str, arrayList4, c11261);
                if (objUpdateCollection == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c11261.I$1;
                int i3 = c11261.I$0;
                collectionItemsRemoteDataSource = (CollectionItemsRemoteDataSource) c11261.L$0;
                ResultKt.throwOnFailure(objUpdateCollection);
            }
            error = new Result.Success((MembershipOperationsResultDTO) objUpdateCollection);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            error = new Result.Success(((MembershipOperationsResultDTO) ((Result.Success) error).getValue()).getResults());
        } else if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException((Exception) ((Result.Error) error).getValue(), collectionItemsRemoteDataSource.moshi));
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.collection.CollectionItemsRemoteDataSource$setCollectionId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CollectionItemsRemoteDataSource.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "Lcom/box/android/data/api/models/collections/CollectionItemsDTO;", "itemFields", "", BoxIterator.FIELD_LIMIT, "", "marker"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.collection.CollectionItemsRemoteDataSource$setCollectionId$1", f = "CollectionItemsRemoteDataSource.kt", i = {0, 0, 0}, l = {93}, m = "invokeSuspend", n = {"itemFields", BoxIterator.FIELD_LIMIT, "marker"}, s = {"L$0", "L$1", "L$2"}, v = 1)
    static final class C11241 extends SuspendLambda implements Function4<String, Integer, String, Continuation<? super CollectionItemsDTO>, Object> {
        final /* synthetic */ String $collectionId;
        final /* synthetic */ Function5<String, String, Integer, String, Continuation<? super CollectionItemsDTO>, Object> $request;
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C11241(Function5<? super String, ? super String, ? super Integer, ? super String, ? super Continuation<? super CollectionItemsDTO>, ? extends Object> function5, String str, Continuation<? super C11241> continuation) {
            super(4, continuation);
            this.$request = function5;
            this.$collectionId = str;
        }

        @Override // kotlin.jvm.functions.Function4
        public final Object invoke(String str, Integer num, String str2, Continuation<? super CollectionItemsDTO> continuation) {
            C11241 c11241 = new C11241(this.$request, this.$collectionId, continuation);
            c11241.L$0 = str;
            c11241.L$1 = num;
            c11241.L$2 = str2;
            return c11241.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str = (String) this.L$0;
            Integer num = (Integer) this.L$1;
            String str2 = (String) this.L$2;
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
            Function5<String, String, Integer, String, Continuation<? super CollectionItemsDTO>, Object> function5 = this.$request;
            String str3 = this.$collectionId;
            this.L$0 = SpillingKt.nullOutSpilledVariable(str);
            this.L$1 = SpillingKt.nullOutSpilledVariable(num);
            this.L$2 = SpillingKt.nullOutSpilledVariable(str2);
            this.label = 1;
            Object objInvoke = function5.invoke(str3, str, num, str2, this);
            return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
        }
    }

    private final Function4<String, Integer, String, Continuation<? super CollectionItemsDTO>, Object> setCollectionId(Function5<? super String, ? super String, ? super Integer, ? super String, ? super Continuation<? super CollectionItemsDTO>, ? extends Object> request, String collectionId) {
        return new C11241(request, collectionId, null);
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.collection.CollectionItemsRemoteDataSource$setItemFieldsAndLimit$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CollectionItemsRemoteDataSource.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "Lcom/box/android/data/api/models/collections/CollectionItemsDTO;", "marker", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.collection.CollectionItemsRemoteDataSource$setItemFieldsAndLimit$1", f = "CollectionItemsRemoteDataSource.kt", i = {0}, l = {103}, m = "invokeSuspend", n = {"marker"}, s = {"L$0"}, v = 1)
    static final class C11251 extends SuspendLambda implements Function2<String, Continuation<? super CollectionItemsDTO>, Object> {
        final /* synthetic */ String $itemFieldsStr;
        final /* synthetic */ int $limit;
        final /* synthetic */ Function4<String, Integer, String, Continuation<? super CollectionItemsDTO>, Object> $request;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C11251(Function4<? super String, ? super Integer, ? super String, ? super Continuation<? super CollectionItemsDTO>, ? extends Object> function4, String str, int i, Continuation<? super C11251> continuation) {
            super(2, continuation);
            this.$request = function4;
            this.$itemFieldsStr = str;
            this.$limit = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C11251 c11251 = new C11251(this.$request, this.$itemFieldsStr, this.$limit, continuation);
            c11251.L$0 = obj;
            return c11251;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(String str, Continuation<? super CollectionItemsDTO> continuation) {
            return ((C11251) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str = (String) this.L$0;
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
            Function4<String, Integer, String, Continuation<? super CollectionItemsDTO>, Object> function4 = this.$request;
            String str2 = this.$itemFieldsStr;
            Integer numBoxInt = Boxing.boxInt(this.$limit);
            this.L$0 = SpillingKt.nullOutSpilledVariable(str);
            this.label = 1;
            Object objInvoke = function4.invoke(str2, numBoxInt, str, this);
            return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
        }
    }

    private final Function2<String, Continuation<? super CollectionItemsDTO>, Object> setItemFieldsAndLimit(Function4<? super String, ? super Integer, ? super String, ? super Continuation<? super CollectionItemsDTO>, ? extends Object> request, String itemFieldsStr, int limit) {
        return new C11251(request, itemFieldsStr, limit, null);
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.collection.CollectionItemsRemoteDataSource$getCollectionItemsFromRemote$1, reason: invalid class name */
    /* JADX INFO: compiled from: CollectionItemsRemoteDataSource.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/api/models/items/IItemDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.collection.CollectionItemsRemoteDataSource$getCollectionItemsFromRemote$1", f = "CollectionItemsRemoteDataSource.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {118, 126}, m = "invokeSuspend", n = {"$this$flow", "marker", "$i$f$resultOf", "$i$a$-resultOf-CollectionItemsRemoteDataSource$getCollectionItemsFromRemote$1$collectionItemsResult$1", "$this$flow", "marker", "collectionItemsResult"}, s = {"L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "L$2"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Result<? extends List<? extends IItemDTO>, ? extends RemoteError>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<String, Continuation<? super CollectionItemsDTO>, Object> $request;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ CollectionItemsRemoteDataSource this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function2<? super String, ? super Continuation<? super CollectionItemsDTO>, ? extends Object> function2, CollectionItemsRemoteDataSource collectionItemsRemoteDataSource, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$request = function2;
            this.this$0 = collectionItemsRemoteDataSource;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$request, this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Result<? extends List<? extends IItemDTO>, ? extends RemoteError>> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:18:0x0052  */
        /* JADX WARN: Code duplicated, block: B:19:0x0054 A[Catch: Exception -> 0x002f, PHI: r2 r11
          0x0054: PHI (r2v5 kotlin.jvm.internal.Ref$ObjectRef) = (r2v6 kotlin.jvm.internal.Ref$ObjectRef), (r2v11 kotlin.jvm.internal.Ref$ObjectRef) binds: [B:17:0x0050, B:10:0x002b] A[DONT_GENERATE, DONT_INLINE]
          0x0054: PHI (r11v17 java.lang.Object) = (r11v20 java.lang.Object), (r11v0 java.lang.Object) binds: [B:17:0x0050, B:10:0x002b] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {Exception -> 0x002f, blocks: (B:16:0x003c, B:19:0x0054, B:10:0x002b), top: B:67:0x002b }] */
        /* JADX WARN: Code duplicated, block: B:24:0x0069  */
        /* JADX WARN: Code duplicated, block: B:25:0x007d  */
        /* JADX WARN: Code duplicated, block: B:28:0x0083  */
        /* JADX WARN: Code duplicated, block: B:31:0x00a8 A[LOOP:0: B:29:0x00a2->B:31:0x00a8, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:33:0x00c1  */
        /* JADX WARN: Code duplicated, block: B:38:0x00cc  */
        /* JADX WARN: Code duplicated, block: B:40:0x00d0  */
        /* JADX WARN: Code duplicated, block: B:44:0x0109  */
        /* JADX WARN: Code duplicated, block: B:47:0x0110  */
        /* JADX WARN: Code duplicated, block: B:49:0x0114  */
        /* JADX WARN: Code duplicated, block: B:51:0x011f  */
        /* JADX WARN: Code duplicated, block: B:53:0x0125  */
        /* JADX WARN: Code duplicated, block: B:55:0x012b  */
        /* JADX WARN: Code duplicated, block: B:61:0x0138  */
        /* JADX WARN: Code duplicated, block: B:63:0x013e  */
        /* JADX WARN: Code duplicated, block: B:65:0x0144  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v17, types: [T, java.lang.String] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0109 -> B:45:0x010c). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Ref.ObjectRef objectRef;
            Result.Error error;
            boolean z;
            CollectionItemsRemoteDataSource collectionItemsRemoteDataSource;
            Ref.ObjectRef objectRef2;
            Result result;
            ArrayList arrayList;
            Iterator<T> it;
            CharSequence charSequence;
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                objectRef = new Ref.ObjectRef();
                Function2<String, Continuation<? super CollectionItemsDTO>, Object> function2 = this.$request;
                T t = objectRef.element;
                this.L$0 = flowCollector;
                this.L$1 = objectRef;
                this.L$2 = null;
                this.I$0 = 0;
                this.I$1 = 0;
                this.label = 1;
                obj = function2.invoke(t, this);
                if (obj == coroutine_suspended) {
                    error = new Result.Success((CollectionItemsDTO) obj);
                    z = error instanceof Result.Success;
                    if (!z) {
                        objectRef.element = ((CollectionItemsDTO) ((Result.Success) error).getValue()).getPagination().getNextMarker();
                    } else if (!(error instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (!z) {
                        List<CollectionItemDTO> entries = ((CollectionItemsDTO) ((Result.Success) error).getValue()).getEntries();
                        arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(entries, 10));
                        it = entries.iterator();
                        while (it.hasNext()) {
                            arrayList.add(((CollectionItemDTO) it.next()).getItem());
                        }
                        error = new Result.Success(arrayList);
                    } else if (!(error instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    collectionItemsRemoteDataSource = this.this$0;
                    if (!(error instanceof Result.Success)) {
                        if (error instanceof Result.Error) {
                            Exception exc = (Exception) ((Result.Error) error).getValue();
                            BoxLogUtils.e(CollectionItemsRemoteDataSource.LOGTAG, "Exception while getting items from remote", exc);
                            error = new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException(exc, collectionItemsRemoteDataSource.moshi));
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                    this.L$0 = flowCollector;
                    this.L$1 = objectRef;
                    this.L$2 = error;
                    this.label = 2;
                    if (flowCollector.emit(error, this) != coroutine_suspended) {
                        Result result2 = error;
                        objectRef2 = objectRef;
                        result = result2;
                    }
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                objectRef = (Ref.ObjectRef) this.L$1;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception e) {
                    error = new Result.Error(e);
                    z = error instanceof Result.Success;
                    if (!z) {
                        objectRef.element = ((CollectionItemsDTO) ((Result.Success) error).getValue()).getPagination().getNextMarker();
                    } else if (!(error instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (!z) {
                        List<CollectionItemDTO> entries2 = ((CollectionItemsDTO) ((Result.Success) error).getValue()).getEntries();
                        arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(entries2, 10));
                        it = entries2.iterator();
                        while (it.hasNext()) {
                            arrayList.add(((CollectionItemDTO) it.next()).getItem());
                        }
                        error = new Result.Success(arrayList);
                    } else if (!(error instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    collectionItemsRemoteDataSource = this.this$0;
                    if (!(error instanceof Result.Success)) {
                        if (error instanceof Result.Error) {
                            Exception exc2 = (Exception) ((Result.Error) error).getValue();
                            BoxLogUtils.e(CollectionItemsRemoteDataSource.LOGTAG, "Exception while getting items from remote", exc2);
                            error = new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException(exc2, collectionItemsRemoteDataSource.moshi));
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                    this.L$0 = flowCollector;
                    this.L$1 = objectRef;
                    this.L$2 = error;
                    this.label = 2;
                    if (flowCollector.emit(error, this) != coroutine_suspended) {
                        Result result3 = error;
                        objectRef2 = objectRef;
                        result = result3;
                        if (result instanceof Result.Success) {
                            charSequence = (CharSequence) objectRef2.element;
                            if (charSequence == null) {
                            }
                            return Unit.INSTANCE;
                        }
                        if (!(result instanceof Result.Error)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        return Unit.INSTANCE;
                    }
                    return coroutine_suspended;
                }
                error = new Result.Success((CollectionItemsDTO) obj);
                z = error instanceof Result.Success;
                if (!z) {
                    objectRef.element = ((CollectionItemsDTO) ((Result.Success) error).getValue()).getPagination().getNextMarker();
                } else if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (!z) {
                    List<CollectionItemDTO> entries3 = ((CollectionItemsDTO) ((Result.Success) error).getValue()).getEntries();
                    arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(entries3, 10));
                    it = entries3.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((CollectionItemDTO) it.next()).getItem());
                    }
                    error = new Result.Success(arrayList);
                } else if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                collectionItemsRemoteDataSource = this.this$0;
                if (!(error instanceof Result.Success)) {
                    if (error instanceof Result.Error) {
                        Exception exc3 = (Exception) ((Result.Error) error).getValue();
                        BoxLogUtils.e(CollectionItemsRemoteDataSource.LOGTAG, "Exception while getting items from remote", exc3);
                        error = new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException(exc3, collectionItemsRemoteDataSource.moshi));
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                this.L$0 = flowCollector;
                this.L$1 = objectRef;
                this.L$2 = error;
                this.label = 2;
                if (flowCollector.emit(error, this) != coroutine_suspended) {
                    Result result4 = error;
                    objectRef2 = objectRef;
                    result = result4;
                }
                return coroutine_suspended;
            }
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            result = (Result) this.L$2;
            objectRef2 = (Ref.ObjectRef) this.L$1;
            ResultKt.throwOnFailure(obj);
            if (result instanceof Result.Success) {
                charSequence = (CharSequence) objectRef2.element;
                if (charSequence == null && charSequence.length() != 0) {
                    objectRef = objectRef2;
                    Function2<String, Continuation<? super CollectionItemsDTO>, Object> function3 = this.$request;
                    T t2 = objectRef.element;
                    this.L$0 = flowCollector;
                    this.L$1 = objectRef;
                    this.L$2 = null;
                    this.I$0 = 0;
                    this.I$1 = 0;
                    this.label = 1;
                    obj = function3.invoke(t2, this);
                    if (obj == coroutine_suspended) {
                        error = new Result.Success((CollectionItemsDTO) obj);
                        z = error instanceof Result.Success;
                        if (!z) {
                            objectRef.element = ((CollectionItemsDTO) ((Result.Success) error).getValue()).getPagination().getNextMarker();
                        } else if (!(error instanceof Result.Error)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        if (!z) {
                            List<CollectionItemDTO> entries4 = ((CollectionItemsDTO) ((Result.Success) error).getValue()).getEntries();
                            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(entries4, 10));
                            it = entries4.iterator();
                            while (it.hasNext()) {
                                arrayList.add(((CollectionItemDTO) it.next()).getItem());
                            }
                            error = new Result.Success(arrayList);
                        } else if (!(error instanceof Result.Error)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        collectionItemsRemoteDataSource = this.this$0;
                        if (!(error instanceof Result.Success)) {
                            if (error instanceof Result.Error) {
                                Exception exc4 = (Exception) ((Result.Error) error).getValue();
                                BoxLogUtils.e(CollectionItemsRemoteDataSource.LOGTAG, "Exception while getting items from remote", exc4);
                                error = new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException(exc4, collectionItemsRemoteDataSource.moshi));
                            } else {
                                throw new NoWhenBranchMatchedException();
                            }
                        }
                        this.L$0 = flowCollector;
                        this.L$1 = objectRef;
                        this.L$2 = error;
                        this.label = 2;
                        if (flowCollector.emit(error, this) != coroutine_suspended) {
                            Result result5 = error;
                            objectRef2 = objectRef;
                            result = result5;
                            if (result instanceof Result.Success) {
                                charSequence = (CharSequence) objectRef2.element;
                                if (charSequence == null) {
                                }
                                return Unit.INSTANCE;
                            }
                            if (!(result instanceof Result.Error)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            if (!(result instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            return Unit.INSTANCE;
        }
    }

    private final Flow<Result<List<IItemDTO>, RemoteError>> getCollectionItemsFromRemote(Function2<? super String, ? super Continuation<? super CollectionItemsDTO>, ? extends Object> request) {
        return FlowKt.flow(new AnonymousClass1(request, this, null));
    }
}
