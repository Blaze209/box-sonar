package com.box.android.data.service.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.box.android.data.GetHubsQuery;
import com.box.android.data.datasource.hubs.HubAssetLocalDataSource;
import com.box.android.data.datasource.hubs.HubAssetRemoteDataSource;
import com.box.android.data.datasource.hubs.HubsDataSource;
import com.box.android.data.mappers.hubs.HubsDTOMapperKt;
import com.box.android.domain.configuration.DataPolicy;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.hubs.HubAssetModel;
import com.box.android.domain.models.hubs.HubModel;
import com.box.android.domain.models.hubs.HubsDirection;
import com.box.android.domain.models.hubs.HubsSort;
import com.box.android.domain.services.IHubsService;
import com.box.android.domain.utils.result.Result;
import java.io.File;
import java.util.ArrayList;
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
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: HubsService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B+\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJB\u0010\f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0004\u0012\u00020\u00110\u000e0\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\"\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00110\u000e2\u0006\u0010\u001c\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/box/android/data/service/impl/HubsService;", "Lcom/box/android/domain/services/IHubsService;", "hubsDataSource", "Lcom/box/android/data/datasource/hubs/HubsDataSource;", "hubAssetLocalDataSource", "Lcom/box/android/data/datasource/hubs/HubAssetLocalDataSource;", "hubAssetRemoteDataSource", "Lcom/box/android/data/datasource/hubs/HubAssetRemoteDataSource;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/box/android/data/datasource/hubs/HubsDataSource;Lcom/box/android/data/datasource/hubs/HubAssetLocalDataSource;Lcom/box/android/data/datasource/hubs/HubAssetRemoteDataSource;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getHubs", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/hubs/HubModel;", "Lcom/box/android/domain/models/DomainError;", "sort", "Lcom/box/android/domain/models/hubs/HubsSort;", "direction", "Lcom/box/android/domain/models/hubs/HubsDirection;", "dataPolicy", "Lcom/box/android/domain/configuration/DataPolicy;", "query", "", "loadHubAsset", "Landroid/graphics/Bitmap;", "hubAssetModel", "Lcom/box/android/domain/models/hubs/HubAssetModel;", "(Lcom/box/android/domain/models/hubs/HubAssetModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isFileCached", "", "file", "Ljava/io/File;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HubsService implements IHubsService {
    private final HubAssetLocalDataSource hubAssetLocalDataSource;
    private final HubAssetRemoteDataSource hubAssetRemoteDataSource;
    private final HubsDataSource hubsDataSource;
    private final CoroutineDispatcher ioDispatcher;

    @Inject
    public HubsService(HubsDataSource hubsDataSource, HubAssetLocalDataSource hubAssetLocalDataSource, HubAssetRemoteDataSource hubAssetRemoteDataSource, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(hubsDataSource, "hubsDataSource");
        Intrinsics.checkNotNullParameter(hubAssetLocalDataSource, "hubAssetLocalDataSource");
        Intrinsics.checkNotNullParameter(hubAssetRemoteDataSource, "hubAssetRemoteDataSource");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.hubsDataSource = hubsDataSource;
        this.hubAssetLocalDataSource = hubAssetLocalDataSource;
        this.hubAssetRemoteDataSource = hubAssetRemoteDataSource;
        this.ioDispatcher = ioDispatcher;
    }

    @Override // com.box.android.domain.services.IHubsService
    public Flow<Result<List<HubModel>, DomainError>> getHubs(HubsSort sort, HubsDirection direction, DataPolicy dataPolicy, String query) {
        Intrinsics.checkNotNullParameter(sort, "sort");
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(dataPolicy, "dataPolicy");
        final Flow<Result<List<GetHubsQuery.Edge>, DomainError>> hubs = this.hubsDataSource.getHubs(HubsDTOMapperKt.toGQL(sort), HubsDTOMapperKt.toGQL(direction), dataPolicy, query);
        return FlowKt.flowOn(new Flow<Result<? extends List<? extends HubModel>, ? extends DomainError>>() { // from class: com.box.android.data.service.impl.HubsService$getHubs$$inlined$map$1

            /* JADX INFO: renamed from: com.box.android.data.service.impl.HubsService$getHubs$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.box.android.data.service.impl.HubsService$getHubs$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.data.service.impl.HubsService$getHubs$$inlined$map$1$2", f = "HubsService.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        Result.Success success = (Result) obj;
                        if (success instanceof Result.Success) {
                            List list = (List) ((Result.Success) success).getValue();
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                            Iterator<T> it = list.iterator();
                            while (it.hasNext()) {
                                arrayList.add(HubsDTOMapperKt.toHubModel((GetHubsQuery.Edge) it.next()));
                            }
                            success = new Result.Success(arrayList);
                        } else if (!(success instanceof Result.Error)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(success, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Result<? extends List<? extends HubModel>, ? extends DomainError>> flowCollector, Continuation continuation) {
                Object objCollect = hubs.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, this.ioDispatcher);
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.HubsService$loadHubAsset$2, reason: invalid class name */
    /* JADX INFO: compiled from: HubsService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "Landroid/graphics/Bitmap;", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.HubsService$loadHubAsset$2", f = "HubsService.kt", i = {0, 0}, l = {53}, m = "invokeSuspend", n = {"hubAssetFile", "$i$a$-let-HubsService$loadHubAsset$2$1"}, s = {"L$0", "I$0"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Bitmap, ? extends DomainError>>, Object> {
        final /* synthetic */ HubAssetModel $hubAssetModel;
        int I$0;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(HubAssetModel hubAssetModel, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$hubAssetModel = hubAssetModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HubsService.this.new AnonymousClass2(this.$hubAssetModel, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Bitmap, ? extends DomainError>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<Bitmap, ? extends DomainError>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Bitmap, ? extends DomainError>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:27:0x0074  */
        /* JADX WARN: Code duplicated, block: B:29:0x007c  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            File cachedHubAssetFile;
            File file;
            Bitmap bitmapDecodeFile;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                cachedHubAssetFile = HubsService.this.hubAssetLocalDataSource.getCachedHubAssetFile(this.$hubAssetModel);
                if (cachedHubAssetFile != null) {
                    HubsService hubsService = HubsService.this;
                    HubAssetModel hubAssetModel = this.$hubAssetModel;
                    if (!hubsService.isFileCached(cachedHubAssetFile)) {
                        HubAssetRemoteDataSource hubAssetRemoteDataSource = hubsService.hubAssetRemoteDataSource;
                        this.L$0 = cachedHubAssetFile;
                        this.I$0 = 0;
                        this.label = 1;
                        Object objDownloadHubAsset = hubAssetRemoteDataSource.downloadHubAsset(hubAssetModel, cachedHubAssetFile, this);
                        if (objDownloadHubAsset == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = objDownloadHubAsset;
                        file = cachedHubAssetFile;
                    }
                    bitmapDecodeFile = BitmapFactory.decodeFile(cachedHubAssetFile.getAbsolutePath());
                    if (bitmapDecodeFile != null) {
                        return new Result.Success(bitmapDecodeFile);
                    }
                    return new Result.Error(new DomainError.CustomError("Failed to decode cached hub asset file"));
                }
                return new Result.Error(new DomainError.CustomError("Failed to get cached hub asset file location"));
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            file = (File) this.L$0;
            ResultKt.throwOnFailure(obj);
            Result result = (Result) obj;
            if (result instanceof Result.Success) {
                cachedHubAssetFile = file;
                bitmapDecodeFile = BitmapFactory.decodeFile(cachedHubAssetFile.getAbsolutePath());
                if (bitmapDecodeFile != null) {
                    return new Result.Success(bitmapDecodeFile);
                }
                return new Result.Error(new DomainError.CustomError("Failed to decode cached hub asset file"));
            }
            if (result instanceof Result.Error) {
                return new Result.Error((DomainError) ((Result.Error) result).getValue());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.box.android.domain.services.IHubsService
    public Object loadHubAsset(HubAssetModel hubAssetModel, Continuation<? super Result<Bitmap, ? extends DomainError>> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new AnonymousClass2(hubAssetModel, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isFileCached(File file) {
        return file.exists() && file.length() > 0;
    }
}
