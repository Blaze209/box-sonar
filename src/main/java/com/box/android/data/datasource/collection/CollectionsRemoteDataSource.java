package com.box.android.data.datasource.collection;

import com.box.android.data.api.models.collections.CollectionDTO;
import com.box.android.data.api.models.collections.CreateCollectionDTO;
import com.box.android.data.api.requests.CollectionsRequest;
import com.box.android.data.datasource.ErrorUtil;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.domain.models.CollectionType;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.squareup.moshi.Moshi;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: CollectionsRemoteDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\r0\n0\tH\u0016J*\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/datasource/collection/CollectionsRemoteDataSource;", "", "collectionsRequest", "Lcom/box/android/data/api/requests/CollectionsRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/box/android/data/api/requests/CollectionsRequest;Lcom/squareup/moshi/Moshi;)V", "getCollections", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/api/models/collections/CollectionDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;", "createCollection", "name", "", "collectionType", "Lcom/box/android/domain/models/CollectionType;", "(Ljava/lang/String;Lcom/box/android/domain/models/CollectionType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class CollectionsRemoteDataSource {
    private static final String LOGTAG = "CollectionsRemoteDataSource";
    private final CollectionsRequest collectionsRequest;
    private final Moshi moshi;

    /* JADX INFO: renamed from: com.box.android.data.datasource.collection.CollectionsRemoteDataSource$createCollection$1, reason: invalid class name */
    /* JADX INFO: compiled from: CollectionsRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.collection.CollectionsRemoteDataSource", f = "CollectionsRemoteDataSource.kt", i = {0, 0, 0, 0, 0}, l = {57}, m = "createCollection$suspendImpl", n = {"$this", "name", "collectionType", "$i$f$resultOf", "$i$a$-resultOf-CollectionsRemoteDataSource$createCollection$2"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
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
            return CollectionsRemoteDataSource.createCollection$suspendImpl(CollectionsRemoteDataSource.this, null, null, this);
        }
    }

    public Object createCollection(String str, CollectionType collectionType, Continuation<? super Result<CollectionDTO, ? extends RemoteError>> continuation) {
        return createCollection$suspendImpl(this, str, collectionType, continuation);
    }

    @Inject
    public CollectionsRemoteDataSource(CollectionsRequest collectionsRequest, Moshi moshi) {
        Intrinsics.checkNotNullParameter(collectionsRequest, "collectionsRequest");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.collectionsRequest = collectionsRequest;
        this.moshi = moshi;
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.collection.CollectionsRemoteDataSource$getCollections$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CollectionsRemoteDataSource.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/api/models/collections/CollectionDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.collection.CollectionsRemoteDataSource$getCollections$1", f = "CollectionsRemoteDataSource.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {32, 43}, m = "invokeSuspend", n = {"$this$flow", "marker", "$i$f$resultOf", "$i$a$-resultOf-CollectionsRemoteDataSource$getCollections$1$collectionsResult$1", "$this$flow", "marker", "collectionsResult"}, s = {"L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "L$2"}, v = 1)
    static final class C11271 extends SuspendLambda implements Function2<FlowCollector<? super Result<? extends List<? extends CollectionDTO>, ? extends RemoteError>>, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        C11271(Continuation<? super C11271> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C11271 c11271 = CollectionsRemoteDataSource.this.new C11271(continuation);
            c11271.L$0 = obj;
            return c11271;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends List<? extends CollectionDTO>, ? extends RemoteError>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Result<? extends List<CollectionDTO>, ? extends RemoteError>>) flowCollector, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<? extends List<CollectionDTO>, ? extends RemoteError>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C11271) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(9:14|15|69|16|17|73|18|(1:20)(7:21|29|(2:32|(2:67|68))(1:31)|(2:36|(2:65|66))(1:35)|38|(2:41|(1:43)(2:63|64))(1:40)|44)|46) */
        /* JADX WARN: Code duplicated, block: B:20:0x0066  */
        /* JADX WARN: Code duplicated, block: B:21:0x0068 A[Catch: Exception -> 0x0072, PHI: r5 r11 r15
          0x0068: PHI (r5v3 kotlin.jvm.internal.Ref$ObjectRef) = (r5v4 kotlin.jvm.internal.Ref$ObjectRef), (r5v7 kotlin.jvm.internal.Ref$ObjectRef) binds: [B:19:0x0064, B:11:0x0031] A[DONT_GENERATE, DONT_INLINE]
          0x0068: PHI (r11v2 com.box.android.data.datasource.collection.CollectionsRemoteDataSource$getCollections$1) = 
          (r11v5 com.box.android.data.datasource.collection.CollectionsRemoteDataSource$getCollections$1)
          (r11v8 com.box.android.data.datasource.collection.CollectionsRemoteDataSource$getCollections$1)
         binds: [B:19:0x0064, B:11:0x0031] A[DONT_GENERATE, DONT_INLINE]
          0x0068: PHI (r15v10 java.lang.Object) = (r15v17 java.lang.Object), (r15v0 java.lang.Object) binds: [B:19:0x0064, B:11:0x0031] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #2 {Exception -> 0x0072, blocks: (B:18:0x0060, B:21:0x0068), top: B:73:0x0060 }] */
        /* JADX WARN: Code duplicated, block: B:31:0x0082  */
        /* JADX WARN: Code duplicated, block: B:32:0x0096  */
        /* JADX WARN: Code duplicated, block: B:35:0x009c  */
        /* JADX WARN: Code duplicated, block: B:36:0x00b1  */
        /* JADX WARN: Code duplicated, block: B:40:0x00bb  */
        /* JADX WARN: Code duplicated, block: B:41:0x00bd  */
        /* JADX WARN: Code duplicated, block: B:43:0x00c1  */
        /* JADX WARN: Code duplicated, block: B:63:0x0129  */
        /* JADX WARN: Code duplicated, block: B:65:0x012f  */
        /* JADX WARN: Code duplicated, block: B:67:0x0135  */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0072, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0074, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0075, code lost:
        
            r11 = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0076, code lost:
        
            r15 = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00fa, code lost:
        
            if (r1.emit(r0, r11) == r2) goto L46;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v16, types: [T, java.lang.String] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00fa -> B:47:0x00fd). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                Method dump skipped, instruction units count: 315
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.collection.CollectionsRemoteDataSource.C11271.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public Flow<Result<List<CollectionDTO>, RemoteError>> getCollections() {
        return FlowKt.flow(new C11271(null));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    static /* synthetic */ Object createCollection$suspendImpl(CollectionsRemoteDataSource collectionsRemoteDataSource, String str, CollectionType collectionType, Continuation<? super Result<CollectionDTO, ? extends RemoteError>> continuation) {
        AnonymousClass1 anonymousClass1;
        Result.Error error;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = collectionsRemoteDataSource.new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = collectionsRemoteDataSource.new AnonymousClass1(continuation);
        }
        Object objCreateCollection = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objCreateCollection);
                CollectionsRequest collectionsRequest = collectionsRemoteDataSource.collectionsRequest;
                CreateCollectionDTO createCollectionDTO = new CreateCollectionDTO(str, collectionType);
                anonymousClass1.L$0 = collectionsRemoteDataSource;
                anonymousClass1.L$1 = str;
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(collectionType);
                anonymousClass1.I$0 = 0;
                anonymousClass1.I$1 = 0;
                anonymousClass1.label = 1;
                objCreateCollection = collectionsRequest.createCollection(createCollectionDTO, anonymousClass1);
                if (objCreateCollection == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = anonymousClass1.I$1;
                int i3 = anonymousClass1.I$0;
                str = (String) anonymousClass1.L$1;
                collectionsRemoteDataSource = (CollectionsRemoteDataSource) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objCreateCollection);
            }
            error = new Result.Success((CollectionDTO) objCreateCollection);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            Exception exc = (Exception) ((Result.Error) error).getValue();
            BoxLogUtils.e(LOGTAG, "Exception while creating collection " + str, exc);
            return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException(exc, collectionsRemoteDataSource.moshi));
        }
        throw new NoWhenBranchMatchedException();
    }
}
