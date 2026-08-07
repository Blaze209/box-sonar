package com.box.android.data.service.impl.preview;

import com.box.android.data.service.impl.OfflineService;
import com.box.android.data.service.impl.RecentsService;
import com.box.android.data.utilities.FileModelFilter;
import com.box.android.domain.models.CaptureHistoryModel;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.domain.services.IGalleryItemsService;
import com.box.android.domain.services.IRemoteItemService;
import com.box.android.domain.usecases.capture.CaptureHistoryUseCase;
import com.box.android.domain.utils.ItemSorter;
import com.box.android.domain.utils.result.Result;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: GalleryItemsService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ*\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0011H\u0002J\u0014\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fH\u0002J0\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f*\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u0010\u0012\u0004\u0012\u00020\u001d0\u001b0\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00108FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b$\u0010%\u0012\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/box/android/data/service/impl/preview/GalleryItemsService;", "Lcom/box/android/domain/services/IGalleryItemsService;", "itemsService", "Lcom/box/android/domain/services/IRemoteItemService;", "recentsService", "Lcom/box/android/data/service/impl/RecentsService;", "offlineService", "Lcom/box/android/data/service/impl/OfflineService;", "captureHistoryUseCase", "Lcom/box/android/domain/usecases/capture/CaptureHistoryUseCase;", "itemSorter", "Lcom/box/android/domain/utils/ItemSorter;", "<init>", "(Lcom/box/android/domain/services/IRemoteItemService;Lcom/box/android/data/service/impl/RecentsService;Lcom/box/android/data/service/impl/OfflineService;Lcom/box/android/domain/usecases/capture/CaptureHistoryUseCase;Lcom/box/android/domain/utils/ItemSorter;)V", "fetchPreviewItems", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/box/android/domain/models/item/FileModel;", "previewSource", "Lcom/box/android/domain/models/preview/PreviewSource;", "fileModel", "(Lcom/box/android/domain/models/preview/PreviewSource;Lcom/box/android/domain/models/item/FileModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isGalleryAvailable", "", "isFileTypeSupported", "filterCaptureHistory", "filterOutItems", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/DomainError;", "galleryFilters", "Lcom/box/android/data/utilities/FileModelFilter;", "getGalleryFilters$annotations", "()V", "getGalleryFilters", "()Ljava/util/List;", "galleryFilters$delegate", "Lkotlin/Lazy;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GalleryItemsService implements IGalleryItemsService {
    private final CaptureHistoryUseCase captureHistoryUseCase;

    /* JADX INFO: renamed from: galleryFilters$delegate, reason: from kotlin metadata */
    private final Lazy galleryFilters;
    private final ItemSorter itemSorter;
    private final IRemoteItemService itemsService;
    private final OfflineService offlineService;
    private final RecentsService recentsService;

    public static /* synthetic */ void getGalleryFilters$annotations() {
    }

    @Inject
    public GalleryItemsService(IRemoteItemService itemsService, RecentsService recentsService, OfflineService offlineService, CaptureHistoryUseCase captureHistoryUseCase, ItemSorter itemSorter) {
        Intrinsics.checkNotNullParameter(itemsService, "itemsService");
        Intrinsics.checkNotNullParameter(recentsService, "recentsService");
        Intrinsics.checkNotNullParameter(offlineService, "offlineService");
        Intrinsics.checkNotNullParameter(captureHistoryUseCase, "captureHistoryUseCase");
        Intrinsics.checkNotNullParameter(itemSorter, "itemSorter");
        this.itemsService = itemsService;
        this.recentsService = recentsService;
        this.offlineService = offlineService;
        this.captureHistoryUseCase = captureHistoryUseCase;
        this.itemSorter = itemSorter;
        this.galleryFilters = LazyKt.lazy(new Function0() { // from class: com.box.android.data.service.impl.preview.GalleryItemsService$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GalleryItemsService.galleryFilters_delegate$lambda$0();
            }
        });
    }

    @Override // com.box.android.domain.services.IGalleryItemsService
    public Object fetchPreviewItems(PreviewSource previewSource, FileModel fileModel, Continuation<? super Flow<? extends List<FileModel>>> continuation) {
        Flow<List<FileModel>> flowFlowOf;
        if (!isGalleryAvailable(previewSource, fileModel)) {
            flowFlowOf = FlowKt.flowOf(CollectionsKt.emptyList());
        } else if (previewSource instanceof PreviewSource.Recents) {
            flowFlowOf = filterOutItems(this.recentsService.recentItems());
        } else if (previewSource instanceof PreviewSource.Offline) {
            flowFlowOf = filterOutItems(this.offlineService.offlineItems());
        } else if (previewSource instanceof PreviewSource.CaptureHistory) {
            flowFlowOf = filterCaptureHistory();
        } else {
            ItemId itemIdParentWithRoot = ItemModelKt.parentWithRoot(fileModel);
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            if (itemIdParentWithRoot != null) {
                final Flow<List<FileModel>> flowFilterOutItems = filterOutItems(FlowKt.onEach(this.itemsService.items(itemIdParentWithRoot), new GalleryItemsService$fetchPreviewItems$2$1(booleanRef, this, itemIdParentWithRoot, null)));
                flowFlowOf = (Flow) new Flow<List<? extends FileModel>>() { // from class: com.box.android.data.service.impl.preview.GalleryItemsService$fetchPreviewItems$lambda$0$$inlined$map$1

                    /* JADX INFO: renamed from: com.box.android.data.service.impl.preview.GalleryItemsService$fetchPreviewItems$lambda$0$$inlined$map$1$2, reason: invalid class name */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;
                        final /* synthetic */ GalleryItemsService this$0;

                        /* JADX INFO: renamed from: com.box.android.data.service.impl.preview.GalleryItemsService$fetchPreviewItems$lambda$0$$inlined$map$1$2$1, reason: invalid class name */
                        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "com.box.android.data.service.impl.preview.GalleryItemsService$fetchPreviewItems$lambda$0$$inlined$map$1$2", f = "GalleryItemsService.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
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

                        public AnonymousClass2(FlowCollector flowCollector, GalleryItemsService galleryItemsService) {
                            this.$this_unsafeFlow = flowCollector;
                            this.this$0 = galleryItemsService;
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
                                List listSort = this.this$0.itemSorter.sort((List) obj);
                                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                anonymousClass1.I$0 = 0;
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(listSort, anonymousClass1) == coroutine_suspended) {
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
                    public Object collect(FlowCollector<? super List<? extends FileModel>> flowCollector, Continuation continuation2) {
                        Object objCollect = flowFilterOutItems.collect(new AnonymousClass2(flowCollector, this), continuation2);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                };
            } else {
                flowFlowOf = FlowKt.flowOf(CollectionsKt.listOf(fileModel));
            }
        }
        return FlowKt.distinctUntilChangedBy(flowFlowOf, new Function1() { // from class: com.box.android.data.service.impl.preview.GalleryItemsService$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GalleryItemsService.fetchPreviewItems$lambda$1((List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HashSet fetchPreviewItems$lambda$1(List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        HashSet hashSet = new HashSet();
        Iterator it2 = it.iterator();
        while (it2.hasNext()) {
            hashSet.add(((FileModel) it2.next()).getItemId());
        }
        return hashSet;
    }

    @Override // com.box.android.domain.services.IGalleryItemsService
    public boolean isGalleryAvailable(PreviewSource previewSource, FileModel fileModel) {
        Intrinsics.checkNotNullParameter(previewSource, "previewSource");
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        return (ItemModelKt.parentWithRoot(fileModel) != null || IGalleryItemsService.INSTANCE.getPREVIEW_SOURCES_GALLERY_ALLOWED_FOR_NON_ROOTED_FILES().contains(previewSource)) && isFileTypeSupported(fileModel) && !IGalleryItemsService.INSTANCE.getPREVIEW_SOURCES_GALLERY_NOT_ALLOWED().contains(previewSource);
    }

    private final boolean isFileTypeSupported(FileModel fileModel) {
        List<FileModelFilter> galleryFilters = getGalleryFilters();
        if ((galleryFilters instanceof Collection) && galleryFilters.isEmpty()) {
            return false;
        }
        Iterator<T> it = galleryFilters.iterator();
        while (it.hasNext()) {
            if (((FileModelFilter) it.next()).shouldAccept(fileModel)) {
                return true;
            }
        }
        return false;
    }

    private final Flow<List<FileModel>> filterCaptureHistory() {
        final Flow<Result<Pair<List<CaptureHistoryModel>, List<CaptureHistoryModel>>, DomainError>> historicalCaptures = this.captureHistoryUseCase.getHistoricalCaptures(false);
        return (Flow) new Flow<List<? extends FileModel>>() { // from class: com.box.android.data.service.impl.preview.GalleryItemsService$filterCaptureHistory$$inlined$mapNotNull$1

            /* JADX INFO: renamed from: com.box.android.data.service.impl.preview.GalleryItemsService$filterCaptureHistory$$inlined$mapNotNull$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ GalleryItemsService this$0;

                /* JADX INFO: renamed from: com.box.android.data.service.impl.preview.GalleryItemsService$filterCaptureHistory$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.data.service.impl.preview.GalleryItemsService$filterCaptureHistory$$inlined$mapNotNull$1$2", f = "GalleryItemsService.kt", i = {0, 0, 0, 0, 0, 0}, l = {72}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
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

                public AnonymousClass2(FlowCollector flowCollector, GalleryItemsService galleryItemsService) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = galleryItemsService;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    List list;
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
                        Pair pair = (Pair) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) obj);
                        ArrayList arrayList = null;
                        if (pair != null && (list = (List) pair.getSecond()) != null) {
                            ArrayList arrayList2 = new ArrayList();
                            Iterator<T> it = list.iterator();
                            while (it.hasNext()) {
                                FileModel fileModel = ((CaptureHistoryModel) it.next()).getFileModel();
                                List<FileModelFilter> galleryFilters = this.this$0.getGalleryFilters();
                                if (!(galleryFilters instanceof Collection) || !galleryFilters.isEmpty()) {
                                    Iterator<T> it2 = galleryFilters.iterator();
                                    do {
                                        if (!it2.hasNext()) {
                                            fileModel = null;
                                            break;
                                        }
                                    } while (!((FileModelFilter) it2.next()).shouldAccept(fileModel));
                                } else {
                                    fileModel = null;
                                    break;
                                }
                                if (fileModel != null) {
                                    arrayList2.add(fileModel);
                                }
                            }
                            arrayList = arrayList2;
                        }
                        if (arrayList != null) {
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(arrayList);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(arrayList, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
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
            public Object collect(FlowCollector<? super List<? extends FileModel>> flowCollector, Continuation continuation) {
                Object objCollect = historicalCaptures.collect(new AnonymousClass2(flowCollector, this), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
    }

    public final List<FileModelFilter> getGalleryFilters() {
        return (List) this.galleryFilters.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List galleryFilters_delegate$lambda$0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(FileModelFilter.ImageItems.INSTANCE);
        arrayList.add(FileModelFilter.VideoItems.INSTANCE);
        arrayList.add(FileModelFilter.GifItems.INSTANCE);
        return arrayList;
    }

    private final Flow<List<FileModel>> filterOutItems(Flow<? extends Result<? extends List<? extends ItemModel>, ? extends DomainError>> flow) {
        return FlowKt.flow(new GalleryItemsService$filterOutItems$$inlined$transform$1(flow, null, this));
    }
}
