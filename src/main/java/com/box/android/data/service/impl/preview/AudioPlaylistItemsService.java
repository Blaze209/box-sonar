package com.box.android.data.service.impl.preview;

import androidx.exifinterface.media.ExifInterface;
import com.box.android.data.datasource.representations.Mp3RepresentationUriProvider;
import com.box.android.data.service.impl.LocalItemService;
import com.box.android.data.service.impl.preview.helpers.legacycache.PreviewFromLegacyCacheFetcher;
import com.box.android.domain.models.CaptureHistoryModel;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.domain.services.AudioItem;
import com.box.android.domain.services.IAudioPlaylistItemsService;
import com.box.android.domain.services.IOfflineService;
import com.box.android.domain.services.IRecentsService;
import com.box.android.domain.services.IdMappingService;
import com.box.android.domain.usecases.capture.CaptureHistoryUseCase;
import com.box.android.domain.utils.ItemSorter;
import com.box.android.domain.utils.SupportedFileExtensions;
import com.box.android.domain.utils.result.Result;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.facebook.react.modules.dialog.AlertFragment;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: AudioPlaylistItemsService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001BQ\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J0\u0010\u0016\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0004\u0012\u00020\u001b0\u00180\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010 \u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J \u0010\"\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0004\u0012\u00020\u001b0\u00180\u0017H\u0002JF\u0010#\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0004\u0012\u00020\u001b0\u00180\u0017\"\b\b\u0000\u0010$*\u00020%*\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H$0\u0019\u0012\u0004\u0012\u00020\u001b0\u00180\u0017H\u0002J\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00192\f\u0010'\u001a\b\u0012\u0004\u0012\u00020%0\u0019H\u0002J\u001e\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019*\b\u0012\u0004\u0012\u00020\u001d0\u0019H\u0082@¢\u0006\u0002\u0010)J\u0018\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u001dH\u0082@¢\u0006\u0002\u0010-R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/box/android/data/service/impl/preview/AudioPlaylistItemsService;", "Lcom/box/android/domain/services/IAudioPlaylistItemsService;", "itemService", "Lcom/box/android/data/service/impl/LocalItemService;", "previewLocalDataSource", "Lcom/box/android/data/service/impl/preview/PreviewLocalDataSource;", "previewFromLegacyCacheFetcher", "Lcom/box/android/data/service/impl/preview/helpers/legacycache/PreviewFromLegacyCacheFetcher;", "itemSorter", "Lcom/box/android/domain/utils/ItemSorter;", "mp3RepresentationUriProvider", "Lcom/box/android/data/datasource/representations/Mp3RepresentationUriProvider;", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", "recentsService", "Lcom/box/android/domain/services/IRecentsService;", "offlineService", "Lcom/box/android/domain/services/IOfflineService;", "captureHistoryUseCase", "Lcom/box/android/domain/usecases/capture/CaptureHistoryUseCase;", "<init>", "(Lcom/box/android/data/service/impl/LocalItemService;Lcom/box/android/data/service/impl/preview/PreviewLocalDataSource;Lcom/box/android/data/service/impl/preview/helpers/legacycache/PreviewFromLegacyCacheFetcher;Lcom/box/android/domain/utils/ItemSorter;Lcom/box/android/data/datasource/representations/Mp3RepresentationUriProvider;Lcom/box/android/domain/services/IdMappingService;Lcom/box/android/domain/services/IRecentsService;Lcom/box/android/domain/services/IOfflineService;Lcom/box/android/domain/usecases/capture/CaptureHistoryUseCase;)V", "fetchAudioPlaylistItems", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/services/AudioItem;", "Lcom/box/android/domain/models/DomainError;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "previewSource", "Lcom/box/android/domain/models/preview/PreviewSource;", "isAudioPlaylistAvailable", "", "filterCaptureHistory", "filterAndMapToAudioTrack", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/box/android/domain/models/item/ItemModel;", "filterAudioFiles", AlertFragment.ARG_ITEMS, "mapToAudioTracks", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAudioPreviewUri", "Ljava/net/URI;", "audioFile", "(Lcom/box/android/domain/models/item/FileModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AudioPlaylistItemsService implements IAudioPlaylistItemsService {
    private final CaptureHistoryUseCase captureHistoryUseCase;
    private final IdMappingService idMappingService;
    private final LocalItemService itemService;
    private final ItemSorter itemSorter;
    private final Mp3RepresentationUriProvider mp3RepresentationUriProvider;
    private final IOfflineService offlineService;
    private final PreviewFromLegacyCacheFetcher previewFromLegacyCacheFetcher;
    private final PreviewLocalDataSource previewLocalDataSource;
    private final IRecentsService recentsService;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.preview.AudioPlaylistItemsService$getAudioPreviewUri$1, reason: invalid class name */
    /* JADX INFO: compiled from: AudioPlaylistItemsService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.preview.AudioPlaylistItemsService", f = "AudioPlaylistItemsService.kt", i = {0, 1, 1, 1, 2, 2, 2, 2, 3}, l = {119, 120, 126, Token.LOOP}, m = "getAudioPreviewUri", n = {"audioFile", "audioFile", "remoteId", "$i$a$-let-AudioPlaylistItemsService$getAudioPreviewUri$2", "audioFile", "remoteId", "cachedUri", "$i$a$-let-AudioPlaylistItemsService$getAudioPreviewUri$2", "audioFile"}, s = {"L$0", "L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
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
            return AudioPlaylistItemsService.this.getAudioPreviewUri(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.preview.AudioPlaylistItemsService$mapToAudioTracks$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AudioPlaylistItemsService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.preview.AudioPlaylistItemsService", f = "AudioPlaylistItemsService.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {105}, m = "mapToAudioTracks", n = {"$this$mapToAudioTracks", "$this$mapNotNull$iv", "$this$mapNotNullTo$iv$iv", "destination$iv$iv", "$this$forEach$iv$iv$iv", "element$iv$iv$iv", "element$iv$iv", "fileModel", "$i$f$mapNotNull", "$i$f$mapNotNullTo", "$i$f$forEach", "$i$a$-forEach-CollectionsKt___CollectionsKt$mapNotNullTo$1$iv$iv", "$i$a$-mapNotNull-AudioPlaylistItemsService$mapToAudioTracks$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "L$8", "I$0", "I$1", "I$2", "I$3", "I$4"}, v = 1)
    static final class C15441 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        C15441(Continuation<? super C15441> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AudioPlaylistItemsService.this.mapToAudioTracks(null, this);
        }
    }

    @Inject
    public AudioPlaylistItemsService(LocalItemService itemService, PreviewLocalDataSource previewLocalDataSource, PreviewFromLegacyCacheFetcher previewFromLegacyCacheFetcher, ItemSorter itemSorter, Mp3RepresentationUriProvider mp3RepresentationUriProvider, IdMappingService idMappingService, IRecentsService recentsService, IOfflineService offlineService, CaptureHistoryUseCase captureHistoryUseCase) {
        Intrinsics.checkNotNullParameter(itemService, "itemService");
        Intrinsics.checkNotNullParameter(previewLocalDataSource, "previewLocalDataSource");
        Intrinsics.checkNotNullParameter(previewFromLegacyCacheFetcher, "previewFromLegacyCacheFetcher");
        Intrinsics.checkNotNullParameter(itemSorter, "itemSorter");
        Intrinsics.checkNotNullParameter(mp3RepresentationUriProvider, "mp3RepresentationUriProvider");
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        Intrinsics.checkNotNullParameter(recentsService, "recentsService");
        Intrinsics.checkNotNullParameter(offlineService, "offlineService");
        Intrinsics.checkNotNullParameter(captureHistoryUseCase, "captureHistoryUseCase");
        this.itemService = itemService;
        this.previewLocalDataSource = previewLocalDataSource;
        this.previewFromLegacyCacheFetcher = previewFromLegacyCacheFetcher;
        this.itemSorter = itemSorter;
        this.mp3RepresentationUriProvider = mp3RepresentationUriProvider;
        this.idMappingService = idMappingService;
        this.recentsService = recentsService;
        this.offlineService = offlineService;
        this.captureHistoryUseCase = captureHistoryUseCase;
    }

    @Override // com.box.android.domain.services.IAudioPlaylistItemsService
    public Flow<Result<List<AudioItem>, DomainError>> fetchAudioPlaylistItems(FileModel fileModel, PreviewSource previewSource) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        Intrinsics.checkNotNullParameter(previewSource, "previewSource");
        if (!isAudioPlaylistAvailable(fileModel, previewSource)) {
            return FlowKt.flowOf(new Result.Error(new DomainError.NoResultFoundError("Playlist is not available for " + fileModel.getItemId())));
        }
        if (previewSource instanceof PreviewSource.AudioNotification) {
            previewSource = ((PreviewSource.AudioNotification) previewSource).getInitialAudioPreviewSource();
        }
        if (previewSource instanceof PreviewSource.Recents) {
            return filterAndMapToAudioTrack(this.recentsService.recentItems());
        }
        if (previewSource instanceof PreviewSource.Offline) {
            return filterAndMapToAudioTrack(this.offlineService.offlineItems());
        }
        if (previewSource instanceof PreviewSource.CaptureHistory) {
            return filterCaptureHistory();
        }
        ItemId itemIdParentWithRoot = ItemModelKt.parentWithRoot(fileModel);
        if (itemIdParentWithRoot == null) {
            return FlowKt.flow(new AudioPlaylistItemsService$fetchAudioPlaylistItems$parentFolder$1(this, fileModel, null));
        }
        final Flow<Result<List<ItemModel>, DomainError>> flowItems = this.itemService.items(itemIdParentWithRoot);
        return (Flow) new Flow<Result<? extends List<? extends AudioItem>, ? extends DomainError>>() { // from class: com.box.android.data.service.impl.preview.AudioPlaylistItemsService$fetchAudioPlaylistItems$$inlined$map$1

            /* JADX INFO: renamed from: com.box.android.data.service.impl.preview.AudioPlaylistItemsService$fetchAudioPlaylistItems$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ AudioPlaylistItemsService this$0;

                /* JADX INFO: renamed from: com.box.android.data.service.impl.preview.AudioPlaylistItemsService$fetchAudioPlaylistItems$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.data.service.impl.preview.AudioPlaylistItemsService$fetchAudioPlaylistItems$$inlined$map$1$2", f = "AudioPlaylistItemsService.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {55, 50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$completion", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$map$iv", "itemModels", "audioFiles", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1", "$i$a$-map-AudioPlaylistItemsService$fetchAudioPlaylistItems$1", "$i$f$map", "$i$a$-map-AudioPlaylistItemsService$fetchAudioPlaylistItems$1$1", "value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    int I$1;
                    int I$2;
                    int I$3;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    Object L$6;
                    Object L$7;
                    Object L$8;
                    Object L$9;
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

                public AnonymousClass2(FlowCollector flowCollector, AudioPlaylistItemsService audioPlaylistItemsService) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = audioPlaylistItemsService;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                /* JADX WARN: Code restructure failed: missing block: B:27:0x0132, code lost:
                
                    if (r13.emit(r5, r0) == r1) goto L28;
                 */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r12, kotlin.coroutines.Continuation r13) throws java.io.UnsupportedEncodingException {
                    /*
                        Method dump skipped, instruction units count: 318
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.preview.AudioPlaylistItemsService$fetchAudioPlaylistItems$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Result<? extends List<? extends AudioItem>, ? extends DomainError>> flowCollector, Continuation continuation) {
                Object objCollect = flowItems.collect(new AnonymousClass2(flowCollector, this), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
    }

    @Override // com.box.android.domain.services.IAudioPlaylistItemsService
    public boolean isAudioPlaylistAvailable(FileModel fileModel, PreviewSource previewSource) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        Intrinsics.checkNotNullParameter(previewSource, "previewSource");
        return SupportedFileExtensions.INSTANCE.isAudioExtension(fileModel.getExtension()) && !IAudioPlaylistItemsService.INSTANCE.getPREVIEW_SOURCES_PLAYLIST_NOT_ALLOWED().contains(previewSource);
    }

    private final Flow<Result<List<AudioItem>, DomainError>> filterCaptureHistory() {
        final Flow<Result<Pair<List<CaptureHistoryModel>, List<CaptureHistoryModel>>, DomainError>> historicalCaptures = this.captureHistoryUseCase.getHistoricalCaptures(false);
        return filterAndMapToAudioTrack(new Flow<Result<? extends List<? extends FileModel>, ? extends DomainError>>() { // from class: com.box.android.data.service.impl.preview.AudioPlaylistItemsService$filterCaptureHistory$$inlined$mapNotNull$1

            /* JADX INFO: renamed from: com.box.android.data.service.impl.preview.AudioPlaylistItemsService$filterCaptureHistory$$inlined$mapNotNull$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.box.android.data.service.impl.preview.AudioPlaylistItemsService$filterCaptureHistory$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.data.service.impl.preview.AudioPlaylistItemsService$filterCaptureHistory$$inlined$mapNotNull$1$2", f = "AudioPlaylistItemsService.kt", i = {0, 0, 0, 0, 0, 0}, l = {62}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
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
                            Iterable iterable = (Iterable) ((Pair) ((Result.Success) success).getValue()).getSecond();
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                            Iterator<T> it = iterable.iterator();
                            while (it.hasNext()) {
                                arrayList.add(((CaptureHistoryModel) it.next()).getFileModel());
                            }
                            success = new Result.Success(arrayList);
                        } else if (!(success instanceof Result.Error)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        if (success != null) {
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(success);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(success, anonymousClass1) == coroutine_suspended) {
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
            public Object collect(FlowCollector<? super Result<? extends List<? extends FileModel>, ? extends DomainError>> flowCollector, Continuation continuation) {
                Object objCollect = historicalCaptures.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<FileModel> filterAudioFiles(List<? extends ItemModel> items) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = items.iterator();
        while (it.hasNext()) {
            FileModel fileModel = ItemModelKt.fileModel((ItemModel) it.next());
            if (fileModel != null) {
                arrayList.add(fileModel);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (SupportedFileExtensions.INSTANCE.isAudioExtension(((FileModel) obj).getExtension())) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:17:0x0084  */
    /* JADX WARN: Code duplicated, block: B:19:0x00c8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:23:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:24:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:26:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:28:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:29:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:32:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00c9 -> B:21:0x00cc). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object mapToAudioTracks(java.util.List<com.box.android.domain.models.item.FileModel> r17, kotlin.coroutines.Continuation<? super java.util.List<? extends com.box.android.domain.services.AudioItem>> r18) throws java.io.UnsupportedEncodingException {
        /*
            Method dump skipped, instruction units count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.preview.AudioPlaylistItemsService.mapToAudioTracks(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:31:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:32:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:34:0x00ab A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c8, code lost:
    
        if (r10 == r1) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00f5, code lost:
    
        if (r10 == r1) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getAudioPreviewUri(com.box.android.domain.models.item.FileModel r9, kotlin.coroutines.Continuation<? super java.net.URI> r10) throws java.io.UnsupportedEncodingException {
        /*
            Method dump skipped, instruction units count: 279
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.preview.AudioPlaylistItemsService.getAudioPreviewUri(com.box.android.domain.models.item.FileModel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final <T extends ItemModel> Flow<Result<List<AudioItem>, DomainError>> filterAndMapToAudioTrack(final Flow<? extends Result<? extends List<? extends T>, ? extends DomainError>> flow) {
        return (Flow) new Flow<Result<? extends List<? extends AudioItem>, ? extends DomainError>>() { // from class: com.box.android.data.service.impl.preview.AudioPlaylistItemsService$filterAndMapToAudioTrack$$inlined$map$1

            /* JADX INFO: renamed from: com.box.android.data.service.impl.preview.AudioPlaylistItemsService$filterAndMapToAudioTrack$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ AudioPlaylistItemsService this$0;

                /* JADX INFO: renamed from: com.box.android.data.service.impl.preview.AudioPlaylistItemsService$filterAndMapToAudioTrack$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.data.service.impl.preview.AudioPlaylistItemsService$filterAndMapToAudioTrack$$inlined$map$1$2", f = "AudioPlaylistItemsService.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {54, 50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$completion", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$map$iv", "itemModels", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1", "$i$a$-map-AudioPlaylistItemsService$filterAndMapToAudioTrack$1", "$i$f$map", "$i$a$-map-AudioPlaylistItemsService$filterAndMapToAudioTrack$1$1", "value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "L$8", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    int I$1;
                    int I$2;
                    int I$3;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    Object L$6;
                    Object L$7;
                    Object L$8;
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

                public AnonymousClass2(FlowCollector flowCollector, AudioPlaylistItemsService audioPlaylistItemsService) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = audioPlaylistItemsService;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                /* JADX WARN: Code restructure failed: missing block: B:27:0x011b, code lost:
                
                    if (r12.emit(r5, r0) == r1) goto L28;
                 */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r11, kotlin.coroutines.Continuation r12) throws java.io.UnsupportedEncodingException {
                    /*
                        Method dump skipped, instruction units count: 295
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.preview.AudioPlaylistItemsService$filterAndMapToAudioTrack$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Result<? extends List<? extends AudioItem>, ? extends DomainError>> flowCollector, Continuation continuation) {
                Object objCollect = flow.collect(new AnonymousClass2(flowCollector, this), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
    }
}
