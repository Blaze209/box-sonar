package com.box.android.data.service.impl.preview;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.box.android.browse.fragments.BoxSearchFragment;
import com.box.android.common.prefetch.PrefetchCoordinator;
import com.box.android.data.service.impl.LocalItemService;
import com.box.android.data.service.impl.preview.helpers.FileCanBePreviewedChecker;
import com.box.android.data.service.impl.preview.helpers.PreviewFileWithRepresentationsResult;
import com.box.android.data.service.impl.preview.helpers.PreviewFileWithRepresentationsWrapper;
import com.box.android.data.service.impl.preview.helpers.download.PreviewDownloadOriginalWrapper;
import com.box.android.data.service.impl.preview.helpers.download.PreviewDownloadRepresentationWrapper;
import com.box.android.data.service.impl.preview.helpers.legacycache.PreviewFromLegacyCacheFetcher;
import com.box.android.data.service.impl.preview.model.HandlePreviewerMappingResult;
import com.box.android.domain.configuration.DataPolicy;
import com.box.android.domain.metrics.preview.PreviewObservability;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.DomainErrorKt;
import com.box.android.domain.models.FilePreviewDomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.ThrowableDomainError;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.preview.PreviewData;
import com.box.android.domain.models.preview.PreviewerType;
import com.box.android.domain.preview.PreviewerMapping;
import com.box.android.domain.services.IPreviewService;
import com.box.android.domain.services.IRepresentationsService;
import com.box.android.domain.services.IdMappingService;
import com.box.android.domain.services.PreviewDataState;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxRepresentation;
import com.facebook.imageutils.JfifUtil;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import javax.inject.Inject;
import javax.inject.Singleton;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: BridgedPreviewService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bk\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0001\u0010\u0018\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J \u0010%\u001a\b\u0012\u0004\u0012\u00020\u001e0&2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J \u0010'\u001a\b\u0012\u0004\u0012\u00020\u001e0&2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0002J\u0010\u0010(\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010)\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J \u0010*\u001a\b\u0012\u0004\u0012\u00020\u001e0&2\u0006\u0010+\u001a\u00020,2\b\u0010#\u001a\u0004\u0018\u00010$H\u0002J\u0016\u0010-\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020,H\u0082@¢\u0006\u0002\u0010.J(\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001e0&2\u0006\u0010+\u001a\u00020,2\u0006\u00100\u001a\u0002012\b\u0010#\u001a\u0004\u0018\u00010$H\u0002J2\u00102\u001a\u000203*\b\u0012\u0004\u0012\u00020\u001e042\u0006\u0010!\u001a\u00020\"2\u0006\u00105\u001a\u0002062\b\u0010#\u001a\u0004\u0018\u00010$H\u0082@¢\u0006\u0002\u00107J>\u00108\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020:09*\b\u0012\u0004\u0012\u00020\u001e042\u0006\u0010!\u001a\u00020\"2\u0006\u0010;\u001a\u00020<2\b\u0010#\u001a\u0004\u0018\u00010$H\u0082@¢\u0006\u0002\u0010=J>\u0010>\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020:09*\b\u0012\u0004\u0012\u00020\u001e042\u0006\u0010?\u001a\u00020@2\u0006\u0010;\u001a\u00020<2\b\u0010#\u001a\u0004\u0018\u00010$H\u0082@¢\u0006\u0002\u0010AJ:\u0010B\u001a\u000203*\b\u0012\u0004\u0012\u00020\u001e042\u0006\u0010!\u001a\u00020\"2\u0006\u0010C\u001a\u00020@2\u0006\u00105\u001a\u0002062\b\u0010#\u001a\u0004\u0018\u00010$H\u0082@¢\u0006\u0002\u0010DJ\u0018\u0010E\u001a\u000203*\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020:09H\u0002J\f\u0010F\u001a\u00020G*\u00020:H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/box/android/data/service/impl/preview/BridgedPreviewService;", "Lcom/box/android/domain/services/IPreviewService;", "itemService", "Lcom/box/android/data/service/impl/LocalItemService;", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", "previewerMappingsService", "Lcom/box/android/data/service/impl/preview/PreviewerMappingsService;", "previewObservability", "Lcom/box/android/domain/metrics/preview/PreviewObservability;", "previewLocalDataSource", "Lcom/box/android/data/service/impl/preview/PreviewLocalDataSource;", "representationsService", "Lcom/box/android/domain/services/IRepresentationsService;", "fileWithRepresentationsService", "Lcom/box/android/data/service/impl/preview/helpers/PreviewFileWithRepresentationsWrapper;", "fileCanBePreviewedChecker", "Lcom/box/android/data/service/impl/preview/helpers/FileCanBePreviewedChecker;", "downloadRepresentationWrapper", "Lcom/box/android/data/service/impl/preview/helpers/download/PreviewDownloadRepresentationWrapper;", "downloadOriginalWrapper", "Lcom/box/android/data/service/impl/preview/helpers/download/PreviewDownloadOriginalWrapper;", "previewFromLegacyCacheFetcher", "Lcom/box/android/data/service/impl/preview/helpers/legacycache/PreviewFromLegacyCacheFetcher;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/box/android/data/service/impl/LocalItemService;Lcom/box/android/domain/services/IdMappingService;Lcom/box/android/data/service/impl/preview/PreviewerMappingsService;Lcom/box/android/domain/metrics/preview/PreviewObservability;Lcom/box/android/data/service/impl/preview/PreviewLocalDataSource;Lcom/box/android/domain/services/IRepresentationsService;Lcom/box/android/data/service/impl/preview/helpers/PreviewFileWithRepresentationsWrapper;Lcom/box/android/data/service/impl/preview/helpers/FileCanBePreviewedChecker;Lcom/box/android/data/service/impl/preview/helpers/download/PreviewDownloadRepresentationWrapper;Lcom/box/android/data/service/impl/preview/helpers/download/PreviewDownloadOriginalWrapper;Lcom/box/android/data/service/impl/preview/helpers/legacycache/PreviewFromLegacyCacheFetcher;Lkotlinx/coroutines/CoroutineDispatcher;)V", "prefetchCoordinator", "Lcom/box/android/common/prefetch/PrefetchCoordinator;", "Lcom/box/android/domain/services/PreviewDataState;", "prefetchPreviewData", "", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "observabilityId", "", "getPreviewData", "Lkotlinx/coroutines/flow/Flow;", "getPreviewDataInternal", "deleteCachedPreview", "cancelPrefetch", "fetchFileAndGetPreviewData", "itemId", "Lcom/box/android/domain/models/ItemId;", "getLocalPreviewDataState", "(Lcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRemotePreviewDataState", "fetchResult", "Lcom/box/android/data/service/impl/preview/helpers/PreviewFileWithRepresentationsResult;", "handlePreviewerMapping", "Lcom/box/android/data/service/impl/preview/model/HandlePreviewerMappingResult;", "Lkotlinx/coroutines/flow/FlowCollector;", "previewerMapping", "Lcom/box/android/domain/preview/PreviewerMapping;", "(Lkotlinx/coroutines/flow/FlowCollector;Lcom/box/android/domain/models/item/FileModel;Lcom/box/android/domain/preview/PreviewerMapping;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOriginalPreviewData", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/DomainError;", "previewerType", "Lcom/box/android/domain/models/preview/PreviewerType;", "(Lkotlinx/coroutines/flow/FlowCollector;Lcom/box/android/domain/models/item/FileModel;Lcom/box/android/domain/models/preview/PreviewerType;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDashRepPreviewData", "representationModel", "Lcom/box/android/domain/models/RepresentationModel;", "(Lkotlinx/coroutines/flow/FlowCollector;Lcom/box/android/domain/models/RepresentationModel;Lcom/box/android/domain/models/preview/PreviewerType;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRepresentationPreviewData", BoxRepresentation.FIELD_REPRESENTATION, "(Lkotlinx/coroutines/flow/FlowCollector;Lcom/box/android/domain/models/item/FileModel;Lcom/box/android/domain/models/RepresentationModel;Lcom/box/android/domain/preview/PreviewerMapping;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toHandlePreviewerMappingResult", "isUnrecoverableError", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BridgedPreviewService implements IPreviewService {
    private final CoroutineDispatcher dispatcher;
    private final PreviewDownloadOriginalWrapper downloadOriginalWrapper;
    private final PreviewDownloadRepresentationWrapper downloadRepresentationWrapper;
    private final FileCanBePreviewedChecker fileCanBePreviewedChecker;
    private final PreviewFileWithRepresentationsWrapper fileWithRepresentationsService;
    private final IdMappingService idMappingService;
    private final LocalItemService itemService;
    private final PrefetchCoordinator<PreviewDataState> prefetchCoordinator;
    private final PreviewFromLegacyCacheFetcher previewFromLegacyCacheFetcher;
    private final PreviewLocalDataSource previewLocalDataSource;
    private final PreviewObservability previewObservability;
    private final PreviewerMappingsService previewerMappingsService;
    private final IRepresentationsService representationsService;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.preview.BridgedPreviewService$getDashRepPreviewData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BridgedPreviewService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.preview.BridgedPreviewService", f = "BridgedPreviewService.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {281, 282}, m = "getDashRepPreviewData", n = {"$this$getDashRepPreviewData", "representationModel", "previewerType", "observabilityId", "dashURI", "$this$getDashRepPreviewData", "representationModel", "previewerType", "observabilityId", "dashURI"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 1)
    static final class C15451 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C15451(Continuation<? super C15451> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BridgedPreviewService.this.getDashRepPreviewData(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.preview.BridgedPreviewService$getLocalPreviewDataState$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BridgedPreviewService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.preview.BridgedPreviewService", f = "BridgedPreviewService.kt", i = {0, 1, 1, 1}, l = {121, 127}, m = "getLocalPreviewDataState", n = {"itemId", "itemId", "itemModel", "fileModel"}, s = {"L$0", "L$0", "L$1", "L$2"}, v = 1)
    static final class C15461 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C15461(Continuation<? super C15461> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BridgedPreviewService.this.getLocalPreviewDataState(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.preview.BridgedPreviewService$getOriginalPreviewData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BridgedPreviewService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.preview.BridgedPreviewService", f = "BridgedPreviewService.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4}, l = {247, 254, 259, 263, 265}, m = "getOriginalPreviewData", n = {"$this$getOriginalPreviewData", "fileModel", "previewerType", "observabilityId", "$this$getOriginalPreviewData", "fileModel", "previewerType", "observabilityId", "previewFile", "$i$a$-let-BridgedPreviewService$getOriginalPreviewData$2", "$this$getOriginalPreviewData", "fileModel", "previewerType", "observabilityId", "previewFile", "$i$a$-let-BridgedPreviewService$getOriginalPreviewData$2", "$this$getOriginalPreviewData", "fileModel", "previewerType", "observabilityId", "$this$getOriginalPreviewData", "fileModel", "previewerType", "observabilityId", "downloadResult", "previewData", "$i$a$-let-BridgedPreviewService$getOriginalPreviewData$3"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0"}, v = 1)
    static final class C15471 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C15471(Continuation<? super C15471> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BridgedPreviewService.this.getOriginalPreviewData(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.preview.BridgedPreviewService$getRepresentationPreviewData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BridgedPreviewService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.preview.BridgedPreviewService", f = "BridgedPreviewService.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {293, 299, 300, TypedValues.AttributesType.TYPE_PIVOT_TARGET, 327}, m = "getRepresentationPreviewData", n = {"$this$getRepresentationPreviewData", "fileModel", BoxRepresentation.FIELD_REPRESENTATION, "previewerMapping", "observabilityId", "cachedWatermarkedFileUri", "$this$getRepresentationPreviewData", "fileModel", BoxRepresentation.FIELD_REPRESENTATION, "previewerMapping", "observabilityId", "cachedWatermarkedFileUri", "previewFile", "$i$a$-let-BridgedPreviewService$getRepresentationPreviewData$2", "isFileWatermarked", "isCachedFileWatermarked", "$this$getRepresentationPreviewData", "fileModel", BoxRepresentation.FIELD_REPRESENTATION, "previewerMapping", "observabilityId", "cachedWatermarkedFileUri", "previewFile", "$i$a$-let-BridgedPreviewService$getRepresentationPreviewData$2", "isFileWatermarked", "isCachedFileWatermarked", "$this$getRepresentationPreviewData", "fileModel", BoxRepresentation.FIELD_REPRESENTATION, "previewerMapping", "observabilityId", "cachedWatermarkedFileUri", "$this$getRepresentationPreviewData", "fileModel", BoxRepresentation.FIELD_REPRESENTATION, "previewerMapping", "observabilityId", "cachedWatermarkedFileUri", "downloadResult", "previewData", "$i$a$-let-BridgedPreviewService$getRepresentationPreviewData$3"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "Z$0", "Z$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "Z$0", "Z$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0"}, v = 1)
    static final class C15511 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        boolean Z$0;
        boolean Z$1;
        int label;
        /* synthetic */ Object result;

        C15511(Continuation<? super C15511> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BridgedPreviewService.this.getRepresentationPreviewData(null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.preview.BridgedPreviewService$handlePreviewerMapping$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BridgedPreviewService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.preview.BridgedPreviewService", f = "BridgedPreviewService.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5}, l = {214, JfifUtil.MARKER_EOI, 223, BoxSearchFragment.REQUEST_FILTER_SEARCH_RESULTS, 234, 236}, m = "handlePreviewerMapping", n = {"$this$handlePreviewerMapping", "fileModel", "previewerMapping", "observabilityId", "$this$handlePreviewerMapping", "fileModel", "previewerMapping", "observabilityId", "$this$handlePreviewerMapping", "fileModel", "previewerMapping", "observabilityId", BoxRepresentation.FIELD_REPRESENTATION, "$this$handlePreviewerMapping", "fileModel", "previewerMapping", "observabilityId", BoxRepresentation.FIELD_REPRESENTATION, "$this$onError$iv", "error", "$i$f$onError", "$i$a$-onError-BridgedPreviewService$handlePreviewerMapping$3", "$this$handlePreviewerMapping", "fileModel", "previewerMapping", "observabilityId", BoxRepresentation.FIELD_REPRESENTATION, "isDashRep", "$this$handlePreviewerMapping", "fileModel", "previewerMapping", "observabilityId", BoxRepresentation.FIELD_REPRESENTATION, "isDashRep"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
    static final class C15521 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C15521(Continuation<? super C15521> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BridgedPreviewService.this.handlePreviewerMapping(null, null, null, null, this);
        }
    }

    @Inject
    public BridgedPreviewService(LocalItemService itemService, IdMappingService idMappingService, PreviewerMappingsService previewerMappingsService, PreviewObservability previewObservability, PreviewLocalDataSource previewLocalDataSource, IRepresentationsService representationsService, PreviewFileWithRepresentationsWrapper fileWithRepresentationsService, FileCanBePreviewedChecker fileCanBePreviewedChecker, PreviewDownloadRepresentationWrapper downloadRepresentationWrapper, PreviewDownloadOriginalWrapper downloadOriginalWrapper, PreviewFromLegacyCacheFetcher previewFromLegacyCacheFetcher, CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(itemService, "itemService");
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        Intrinsics.checkNotNullParameter(previewerMappingsService, "previewerMappingsService");
        Intrinsics.checkNotNullParameter(previewObservability, "previewObservability");
        Intrinsics.checkNotNullParameter(previewLocalDataSource, "previewLocalDataSource");
        Intrinsics.checkNotNullParameter(representationsService, "representationsService");
        Intrinsics.checkNotNullParameter(fileWithRepresentationsService, "fileWithRepresentationsService");
        Intrinsics.checkNotNullParameter(fileCanBePreviewedChecker, "fileCanBePreviewedChecker");
        Intrinsics.checkNotNullParameter(downloadRepresentationWrapper, "downloadRepresentationWrapper");
        Intrinsics.checkNotNullParameter(downloadOriginalWrapper, "downloadOriginalWrapper");
        Intrinsics.checkNotNullParameter(previewFromLegacyCacheFetcher, "previewFromLegacyCacheFetcher");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.itemService = itemService;
        this.idMappingService = idMappingService;
        this.previewerMappingsService = previewerMappingsService;
        this.previewObservability = previewObservability;
        this.previewLocalDataSource = previewLocalDataSource;
        this.representationsService = representationsService;
        this.fileWithRepresentationsService = fileWithRepresentationsService;
        this.fileCanBePreviewedChecker = fileCanBePreviewedChecker;
        this.downloadRepresentationWrapper = downloadRepresentationWrapper;
        this.downloadOriginalWrapper = downloadOriginalWrapper;
        this.previewFromLegacyCacheFetcher = previewFromLegacyCacheFetcher;
        this.dispatcher = dispatcher;
        this.prefetchCoordinator = new PrefetchCoordinator<>(dispatcher);
    }

    @Override // com.box.android.domain.services.IPreviewService
    public void prefetchPreviewData(FileModel fileModel, String observabilityId) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        this.prefetchCoordinator.store(fileModel.getItemId().toString(), getPreviewDataInternal(fileModel, observabilityId));
    }

    @Override // com.box.android.domain.services.IPreviewService
    public Flow<PreviewDataState> getPreviewData(FileModel fileModel, String observabilityId) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        Flow<PreviewDataState> flowConsume = this.prefetchCoordinator.consume(fileModel.getItemId().toString());
        return flowConsume == null ? getPreviewDataInternal(fileModel, observabilityId) : flowConsume;
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.preview.BridgedPreviewService$getPreviewDataInternal$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BridgedPreviewService.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/services/PreviewDataState;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.preview.BridgedPreviewService$getPreviewDataInternal$1", f = "BridgedPreviewService.kt", i = {0, 1}, l = {88, 92}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"}, v = 1)
    static final class C15481 extends SuspendLambda implements Function2<FlowCollector<? super PreviewDataState>, Continuation<? super Unit>, Object> {
        final /* synthetic */ FileModel $fileModel;
        final /* synthetic */ String $observabilityId;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ BridgedPreviewService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15481(FileModel fileModel, BridgedPreviewService bridgedPreviewService, String str, Continuation<? super C15481> continuation) {
            super(2, continuation);
            this.$fileModel = fileModel;
            this.this$0 = bridgedPreviewService;
            this.$observabilityId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C15481 c15481 = new C15481(this.$fileModel, this.this$0, this.$observabilityId, continuation);
            c15481.L$0 = obj;
            return c15481;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super PreviewDataState> flowCollector, Continuation<? super Unit> continuation) {
            return ((C15481) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0056, code lost:
        
            if (r0.emit(new com.box.android.domain.services.PreviewDataState.Ready(new com.box.android.domain.models.preview.PreviewData(new java.net.URI(""), com.box.android.domain.models.preview.PreviewerType.BoxNote, false)), r7) == r1) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0079, code lost:
        
            if (kotlinx.coroutines.flow.FlowKt.emitAll(r0, r7.this$0.fetchFileAndGetPreviewData(r7.$fileModel.getItemId(), r7.$observabilityId), r7) == r1) goto L19;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = r7.L$0
                kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r7.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L22
                if (r2 == r4) goto L1e
                if (r2 != r3) goto L16
                kotlin.ResultKt.throwOnFailure(r8)
                goto L7c
            L16:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L1e:
                kotlin.ResultKt.throwOnFailure(r8)
                goto L59
            L22:
                kotlin.ResultKt.throwOnFailure(r8)
                com.box.android.domain.utils.SupportedFileExtensions r8 = com.box.android.domain.utils.SupportedFileExtensions.INSTANCE
                com.box.android.domain.models.item.FileModel r2 = r7.$fileModel
                java.lang.String r2 = r2.getExtension()
                boolean r8 = r8.isBoxNoteExtension(r2)
                if (r8 == 0) goto L5c
                com.box.android.domain.services.PreviewDataState$Ready r8 = new com.box.android.domain.services.PreviewDataState$Ready
                com.box.android.domain.models.preview.PreviewData r2 = new com.box.android.domain.models.preview.PreviewData
                java.net.URI r3 = new java.net.URI
                java.lang.String r5 = ""
                r3.<init>(r5)
                com.box.android.domain.models.preview.PreviewerType r5 = com.box.android.domain.models.preview.PreviewerType.BoxNote
                r6 = 0
                r2.<init>(r3, r5, r6)
                r8.<init>(r2)
                r2 = r7
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r7.L$0 = r3
                r7.label = r4
                java.lang.Object r7 = r0.emit(r8, r2)
                if (r7 != r1) goto L59
                goto L7b
            L59:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            L5c:
                com.box.android.data.service.impl.preview.BridgedPreviewService r8 = r7.this$0
                com.box.android.domain.models.item.FileModel r2 = r7.$fileModel
                com.box.android.domain.models.ItemId r2 = r2.getItemId()
                java.lang.String r4 = r7.$observabilityId
                kotlinx.coroutines.flow.Flow r8 = com.box.android.data.service.impl.preview.BridgedPreviewService.access$fetchFileAndGetPreviewData(r8, r2, r4)
                r2 = r7
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r7.L$0 = r4
                r7.label = r3
                java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.emitAll(r0, r8, r2)
                if (r7 != r1) goto L7c
            L7b:
                return r1
            L7c:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.preview.BridgedPreviewService.C15481.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final Flow<PreviewDataState> getPreviewDataInternal(FileModel fileModel, String observabilityId) {
        return FlowKt.m16356catch(FlowKt.flow(new C15481(fileModel, this, observabilityId, null)), new AnonymousClass2(fileModel, null));
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.preview.BridgedPreviewService$getPreviewDataInternal$2, reason: invalid class name */
    /* JADX INFO: compiled from: BridgedPreviewService.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/services/PreviewDataState;", "throwable", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.preview.BridgedPreviewService$getPreviewDataInternal$2", f = "BridgedPreviewService.kt", i = {0, 0, 0, 1, 1, 1}, l = {98, 99}, m = "invokeSuspend", n = {"$this$catch", "throwable", "errorName", "$this$catch", "throwable", "errorName"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<? super PreviewDataState>, Throwable, Continuation<? super Unit>, Object> {
        final /* synthetic */ FileModel $fileModel;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(FileModel fileModel, Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
            this.$fileModel = fileModel;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(FlowCollector<? super PreviewDataState> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$fileModel, continuation);
            anonymousClass2.L$0 = flowCollector;
            anonymousClass2.L$1 = th;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0096, code lost:
        
            if (r0.emit(new com.box.android.domain.services.PreviewDataState.Error(((com.box.android.domain.models.ThrowableDomainError) r1).getDomainError()), r10) == r2) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x00d5, code lost:
        
            if (r0.emit(new com.box.android.domain.services.PreviewDataState.Error(new com.box.android.domain.models.DomainError.UnknownError(r6)), r10) == r2) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x00d7, code lost:
        
            return r2;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                Method dump skipped, instruction units count: 219
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.preview.BridgedPreviewService.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.box.android.domain.services.IPreviewService
    public void deleteCachedPreview(FileModel fileModel) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        this.previewLocalDataSource.deleteAllPreviewFiles(fileModel);
    }

    @Override // com.box.android.domain.services.IPreviewService
    public void cancelPrefetch(FileModel fileModel) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        this.prefetchCoordinator.cancelPrefetch(fileModel.getItemId().toString());
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.preview.BridgedPreviewService$fetchFileAndGetPreviewData$1, reason: invalid class name */
    /* JADX INFO: compiled from: BridgedPreviewService.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/services/PreviewDataState;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.preview.BridgedPreviewService$fetchFileAndGetPreviewData$1", f = "BridgedPreviewService.kt", i = {0, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5}, l = {108, 110, 112, 112, 114, 116}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "$this$flow", "remoteId", "$this$flow", "remoteId", "$this$flow", "remoteId", "$this$flow", "remoteId", "fetchResult"}, s = {"L$0", "L$0", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super PreviewDataState>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ItemId $itemId;
        final /* synthetic */ String $observabilityId;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, ItemId itemId, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$observabilityId = str;
            this.$itemId = itemId;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = BridgedPreviewService.this.new AnonymousClass1(this.$observabilityId, this.$itemId, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super PreviewDataState> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:18:0x0073 A[PHI: r8
          0x0073: PHI (r8v7 java.lang.Object) = (r8v6 java.lang.Object), (r8v0 java.lang.Object) binds: [B:16:0x006f, B:10:0x0038] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:20:0x0078  */
        /* JADX WARN: Code duplicated, block: B:23:0x0097  */
        /* JADX WARN: Code duplicated, block: B:27:0x00b5  */
        /* JADX WARN: Code duplicated, block: B:30:0x00d4 A[PHI: r2 r8
          0x00d4: PHI (r2v9 com.box.android.domain.models.ItemId$Remote) = (r2v4 com.box.android.domain.models.ItemId$Remote), (r2v12 com.box.android.domain.models.ItemId$Remote) binds: [B:28:0x00d1, B:7:0x001a] A[DONT_GENERATE, DONT_INLINE]
          0x00d4: PHI (r8v14 java.lang.Object) = (r8v10 java.lang.Object), (r8v0 java.lang.Object) binds: [B:28:0x00d1, B:7:0x001a] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x00b2, code lost:
        
            if (r2.emit(r8, r7) == r1) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0105, code lost:
        
            if (kotlinx.coroutines.flow.FlowKt.emitAll(r0, r7.this$0.getRemotePreviewDataState(r7.$itemId, r8, r7.$observabilityId), r7) == r1) goto L32;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) throws com.box.android.domain.models.ThrowableDomainError, java.io.UnsupportedEncodingException {
            /*
                Method dump skipped, instruction units count: 286
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.preview.BridgedPreviewService.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Flow<PreviewDataState> fetchFileAndGetPreviewData(ItemId itemId, String observabilityId) {
        return FlowKt.flowOn(FlowKt.flow(new AnonymousClass1(observabilityId, itemId, null)), this.dispatcher);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:32:0x0092  */
    /* JADX WARN: Code duplicated, block: B:40:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getLocalPreviewDataState(ItemId itemId, Continuation<? super PreviewDataState> continuation) throws ThrowableDomainError, UnsupportedEncodingException {
        C15461 c15461;
        ItemId itemId2;
        FileModel fileModel;
        String str;
        PreviewerMapping previewerMappingResolveLocalPreview;
        PreviewerType type;
        if (continuation instanceof C15461) {
            c15461 = (C15461) continuation;
            if ((c15461.label & Integer.MIN_VALUE) != 0) {
                c15461.label -= Integer.MIN_VALUE;
            } else {
                c15461 = new C15461(continuation);
            }
        } else {
            c15461 = new C15461(continuation);
        }
        Object objItem = c15461.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c15461.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objItem);
            LocalItemService localItemService = this.itemService;
            DataPolicy dataPolicy = DataPolicy.CACHE;
            c15461.L$0 = itemId;
            c15461.label = 1;
            objItem = localItemService.item(itemId, dataPolicy, c15461);
            if (objItem != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            itemId = (ItemId) c15461.L$0;
            ResultKt.throwOnFailure(objItem);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            fileModel = (FileModel) c15461.L$2;
            itemId2 = (ItemId) c15461.L$0;
            ResultKt.throwOnFailure(objItem);
        }
        str = (String) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) objItem);
        if (str != null) {
            throw new ThrowableDomainError(new DomainError.NoResultFoundError("No uri found for local file with id: " + itemId2));
        }
        previewerMappingResolveLocalPreview = this.previewerMappingsService.resolveLocalPreview(fileModel.getExtension());
        if (previewerMappingResolveLocalPreview != null || (type = previewerMappingResolveLocalPreview.getType()) == null) {
            throw new ThrowableDomainError(new DomainError.NoResultFoundError("No resolvedType found for local file with id: " + itemId2));
        }
        return new PreviewDataState.Ready(new PreviewData(new URI("file", "", str, null), type, true));
        ItemModel itemModel = (ItemModel) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) objItem);
        if (itemModel == null) {
            throw new ThrowableDomainError(new DomainError.CacheReadError("Error when fetching local item for id: " + itemId));
        }
        FileModel fileModel2 = itemModel instanceof FileModel ? (FileModel) itemModel : null;
        if (fileModel2 == null) {
            throw new ThrowableDomainError(new DomainError.NoResultFoundError("No local file found for id: " + itemId));
        }
        LocalItemService localItemService2 = this.itemService;
        c15461.L$0 = itemId;
        c15461.L$1 = SpillingKt.nullOutSpilledVariable(itemModel);
        c15461.L$2 = fileModel2;
        c15461.label = 2;
        objItem = localItemService2.getContentUrl(itemId, c15461);
        if (objItem != coroutine_suspended) {
            itemId2 = itemId;
            fileModel = fileModel2;
            str = (String) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) objItem);
            if (str != null) {
                throw new ThrowableDomainError(new DomainError.NoResultFoundError("No uri found for local file with id: " + itemId2));
            }
            previewerMappingResolveLocalPreview = this.previewerMappingsService.resolveLocalPreview(fileModel.getExtension());
            if (previewerMappingResolveLocalPreview != null) {
            }
            throw new ThrowableDomainError(new DomainError.NoResultFoundError("No resolvedType found for local file with id: " + itemId2));
        }
        return coroutine_suspended;
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.preview.BridgedPreviewService$getRemotePreviewDataState$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BridgedPreviewService.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/services/PreviewDataState;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.preview.BridgedPreviewService$getRemotePreviewDataState$1", f = "BridgedPreviewService.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {Token.COMMENT, 185}, m = "invokeSuspend", n = {"$this$flow", "fileWithRepresentations", "previewerMappings", "lastKnownError", "cachedPreview", "$this$forEach$iv", "element$iv", "previewerMapping", "$i$f$forEach", "$i$a$-forEach-BridgedPreviewService$getRemotePreviewDataState$1$1", "$this$flow", "fileWithRepresentations", "previewerMappings", "lastKnownError", "cachedPreview", "it", "$i$a$-let-BridgedPreviewService$getRemotePreviewDataState$1$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$9", "L$10", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0"}, v = 1)
    static final class C15491 extends SuspendLambda implements Function2<FlowCollector<? super PreviewDataState>, Continuation<? super Unit>, Object> {
        final /* synthetic */ PreviewFileWithRepresentationsResult $fetchResult;
        final /* synthetic */ String $observabilityId;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        final /* synthetic */ BridgedPreviewService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15491(PreviewFileWithRepresentationsResult previewFileWithRepresentationsResult, BridgedPreviewService bridgedPreviewService, String str, Continuation<? super C15491> continuation) {
            super(2, continuation);
            this.$fetchResult = previewFileWithRepresentationsResult;
            this.this$0 = bridgedPreviewService;
            this.$observabilityId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C15491 c15491 = new C15491(this.$fetchResult, this.this$0, this.$observabilityId, continuation);
            c15491.L$0 = obj;
            return c15491;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super PreviewDataState> flowCollector, Continuation<? super Unit> continuation) {
            return ((C15491) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:15:0x00b2  */
        /* JADX WARN: Code duplicated, block: B:18:0x00f7  */
        /* JADX WARN: Code duplicated, block: B:23:0x0102  */
        /* JADX WARN: Code duplicated, block: B:25:0x0106  */
        /* JADX WARN: Code duplicated, block: B:27:0x0112  */
        /* JADX WARN: Code duplicated, block: B:28:0x0141  */
        /* JADX WARN: Code duplicated, block: B:30:0x014b  */
        /* JADX WARN: Code duplicated, block: B:32:0x0153  */
        /* JADX WARN: Code duplicated, block: B:34:0x0157  */
        /* JADX WARN: Code duplicated, block: B:36:0x0169  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v21, types: [T, com.box.android.domain.models.preview.PreviewData] */
        /* JADX WARN: Type inference failed for: r7v10, types: [T, com.box.android.domain.models.DomainError] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x00f7 -> B:19:0x00f9). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r20) {
            /*
                Method dump skipped, instruction units count: 487
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.preview.BridgedPreviewService.C15491.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Flow<PreviewDataState> getRemotePreviewDataState(ItemId itemId, PreviewFileWithRepresentationsResult fetchResult, String observabilityId) {
        return FlowKt.m16356catch(FlowKt.flow(new C15491(fetchResult, this, observabilityId, null)), new C15502(itemId, observabilityId, null));
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.preview.BridgedPreviewService$getRemotePreviewDataState$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BridgedPreviewService.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/services/PreviewDataState;", "throwable", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.preview.BridgedPreviewService$getRemotePreviewDataState$2", f = "BridgedPreviewService.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4}, l = {193, 194, 197, 200, 201}, m = "invokeSuspend", n = {"$this$catch", "throwable", "$this$catch", "throwable", "legacyCacheResult", "$this$catch", "throwable", "legacyCacheResult", "$this$catch", "throwable", "legacyCacheResult", "$this$catch", "throwable", "legacyCacheResult"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 1)
    static final class C15502 extends SuspendLambda implements Function3<FlowCollector<? super PreviewDataState>, Throwable, Continuation<? super Unit>, Object> {
        final /* synthetic */ ItemId $itemId;
        final /* synthetic */ String $observabilityId;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15502(ItemId itemId, String str, Continuation<? super C15502> continuation) {
            super(3, continuation);
            this.$itemId = itemId;
            this.$observabilityId = str;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(FlowCollector<? super PreviewDataState> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            C15502 c15502 = BridgedPreviewService.this.new C15502(this.$itemId, this.$observabilityId, continuation);
            c15502.L$0 = flowCollector;
            c15502.L$1 = th;
            return c15502.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x008e  */
        /* JADX WARN: Code duplicated, block: B:29:0x00ba  */
        /* JADX WARN: Code duplicated, block: B:31:0x00be  */
        /* JADX WARN: Code duplicated, block: B:34:0x00de A[PHI: r3
          0x00de: PHI (r3v7 com.box.android.domain.utils.result.Result) = (r3v6 com.box.android.domain.utils.result.Result), (r3v11 com.box.android.domain.utils.result.Result) binds: [B:32:0x00db, B:12:0x0030] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:39:0x010d  */
        /* JADX WARN: Code duplicated, block: B:41:? A[SYNTHETIC] */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0107, code lost:
        
            if (r0.emit(new com.box.android.domain.services.PreviewDataState.Ready((com.box.android.domain.models.preview.PreviewData) ((com.box.android.domain.utils.result.Result.Success) r3).getValue()), r11) == r2) goto L36;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 275
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.preview.BridgedPreviewService.C15502.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:24:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:29:0x0127  */
    /* JADX WARN: Code duplicated, block: B:31:0x012c  */
    /* JADX WARN: Code duplicated, block: B:34:0x015d  */
    /* JADX WARN: Code duplicated, block: B:37:0x0167  */
    /* JADX WARN: Code duplicated, block: B:38:0x0173  */
    /* JADX WARN: Code duplicated, block: B:42:0x017a  */
    /* JADX WARN: Code duplicated, block: B:44:0x017e  */
    /* JADX WARN: Code duplicated, block: B:47:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:50:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:52:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:55:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:57:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:62:0x0221  */
    /* JADX WARN: Code duplicated, block: B:65:0x0255 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:66:0x0256  */
    /* JADX WARN: Code duplicated, block: B:68:0x025c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x011c, code lost:
    
        if (r0 == r8) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0217, code lost:
    
        if (r0 == r8) goto L64;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [T, com.box.android.domain.models.RepresentationModel] */
    /* JADX WARN: Type inference failed for: r12v14, types: [T, com.box.android.domain.models.RepresentationModel] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handlePreviewerMapping(kotlinx.coroutines.flow.FlowCollector<? super com.box.android.domain.services.PreviewDataState> r10, com.box.android.domain.models.item.FileModel r11, com.box.android.domain.preview.PreviewerMapping r12, java.lang.String r13, kotlin.coroutines.Continuation<? super com.box.android.data.service.impl.preview.model.HandlePreviewerMappingResult> r14) {
        /*
            Method dump skipped, instruction units count: 628
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.preview.BridgedPreviewService.handlePreviewerMapping(kotlinx.coroutines.flow.FlowCollector, com.box.android.domain.models.item.FileModel, com.box.android.domain.preview.PreviewerMapping, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:46:0x0190  */
    /* JADX WARN: Code duplicated, block: B:49:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:53:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:55:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:57:0x01dc A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:58:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0158, code lost:
    
        if (r14.previewFileDownloadSuccess(r4, com.box.android.domain.metrics.preview.PreviewObservability.ORIGINAL_CONTENT_TYPE, r1, r2) == r3) goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getOriginalPreviewData(kotlinx.coroutines.flow.FlowCollector<? super com.box.android.domain.services.PreviewDataState> r15, com.box.android.domain.models.item.FileModel r16, com.box.android.domain.models.preview.PreviewerType r17, java.lang.String r18, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<kotlin.Unit, ? extends com.box.android.domain.models.DomainError>> r19) {
        /*
            Method dump skipped, instruction units count: 483
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.preview.BridgedPreviewService.getOriginalPreviewData(kotlinx.coroutines.flow.FlowCollector, com.box.android.domain.models.item.FileModel, com.box.android.domain.models.preview.PreviewerType, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00e6, code lost:
    
        if (r0.previewFileDownloadSuccess(r8, r1, r10, r2) == r3) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getDashRepPreviewData(kotlinx.coroutines.flow.FlowCollector<? super com.box.android.domain.services.PreviewDataState> r18, com.box.android.domain.models.RepresentationModel r19, com.box.android.domain.models.preview.PreviewerType r20, java.lang.String r21, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<kotlin.Unit, ? extends com.box.android.domain.models.DomainError>> r22) {
        /*
            Method dump skipped, instruction units count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.preview.BridgedPreviewService.getDashRepPreviewData(kotlinx.coroutines.flow.FlowCollector, com.box.android.domain.models.RepresentationModel, com.box.android.domain.models.preview.PreviewerType, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:60:0x0251  */
    /* JADX WARN: Code duplicated, block: B:63:0x028f  */
    /* JADX WARN: Code duplicated, block: B:66:0x0296  */
    /* JADX WARN: Code duplicated, block: B:68:0x029e  */
    /* JADX WARN: Code duplicated, block: B:70:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x01ce, code lost:
    
        if (r0.previewFileDownloadSuccess(r10, r2, r9, r3) == r4) goto L62;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [T, java.net.URI] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getRepresentationPreviewData(kotlinx.coroutines.flow.FlowCollector<? super com.box.android.domain.services.PreviewDataState> r18, com.box.android.domain.models.item.FileModel r19, com.box.android.domain.models.RepresentationModel r20, com.box.android.domain.preview.PreviewerMapping r21, java.lang.String r22, kotlin.coroutines.Continuation<? super com.box.android.data.service.impl.preview.model.HandlePreviewerMappingResult> r23) {
        /*
            Method dump skipped, instruction units count: 692
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.preview.BridgedPreviewService.getRepresentationPreviewData(kotlinx.coroutines.flow.FlowCollector, com.box.android.domain.models.item.FileModel, com.box.android.domain.models.RepresentationModel, com.box.android.domain.preview.PreviewerMapping, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final HandlePreviewerMappingResult toHandlePreviewerMappingResult(Result<Unit, ? extends DomainError> result) {
        if (result instanceof Result.Success) {
            return HandlePreviewerMappingResult.Success.INSTANCE;
        }
        if (result instanceof Result.Error) {
            return new HandlePreviewerMappingResult.Error((DomainError) ((Result.Error) result).getValue());
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isUnrecoverableError(DomainError domainError) {
        return DomainErrorKt.isNetworkConnectionError(domainError) || (domainError instanceof DomainError.APIAuthError) || (domainError instanceof FilePreviewDomainError.PasswordProtectedError);
    }
}
