package com.box.android.data.service.impl;

import com.amplitude.api.Constants;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.data.api.models.RepresentationsDTO;
import com.box.android.data.datasource.CacheError;
import com.box.android.data.datasource.VersionsPreviewCache;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.datasource.representations.RepresentationsCacheDataSource;
import com.box.android.data.datasource.representations.RepresentationsRemoteDataSource;
import com.box.android.data.mappers.RepresentationToDomainUtilsKt;
import com.box.android.domain.controller.IPreviewController;
import com.box.android.domain.mappers.FileModelMapper;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.FilePreviewDomainError;
import com.box.android.domain.models.IGenericError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.RepresentationModel;
import com.box.android.domain.models.RepresentationStatus;
import com.box.android.domain.models.RepresentationType;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.WatermarkModel;
import com.box.android.domain.preview.PreviewContentType;
import com.box.android.domain.services.IRepresentationsService;
import com.box.android.domain.services.IdMappingService;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxDocumentFile;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxRepresentation;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ShareKt;
import kotlinx.coroutines.flow.SharingStarted;

/* JADX INFO: compiled from: RepresentationsService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 82\u00020\u0001:\u00018B;\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0001\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ*\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010\u0018J\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J0\u0010\u001b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0082@¢\u0006\u0002\u0010\u0018J*\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010#J2\u0010$\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010'J*\u0010(\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010*\u001a\u00020+H\u0096@¢\u0006\u0002\u0010,J\u0014\u0010-\u001a\u00020\u0017*\u00020\u00172\u0006\u0010&\u001a\u00020\u0013H\u0002J2\u0010.\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u00132\u0006\u0010/\u001a\u00020%H\u0096@¢\u0006\u0002\u00100J\"\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010&\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u00102J\u001e\u00103\u001a\u0002042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u00105J\u001c\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010&\u001a\u00020\u0013H\u0002J\"\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010&\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u00102R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/box/android/data/service/impl/RepresentationsService;", "Lcom/box/android/domain/services/IRepresentationsService;", "representationsRemoteDataSource", "Lcom/box/android/data/datasource/representations/RepresentationsRemoteDataSource;", "representationsCacheDataSource", "Lcom/box/android/data/datasource/representations/RepresentationsCacheDataSource;", "versionsPreviewCache", "Lcom/box/android/data/datasource/VersionsPreviewCache;", "mappingService", "Lcom/box/android/domain/services/IdMappingService;", "legacyPreviewController", "Lcom/box/android/domain/controller/IPreviewController;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/box/android/data/datasource/representations/RepresentationsRemoteDataSource;Lcom/box/android/data/datasource/representations/RepresentationsCacheDataSource;Lcom/box/android/data/datasource/VersionsPreviewCache;Lcom/box/android/domain/services/IdMappingService;Lcom/box/android/domain/controller/IPreviewController;Lkotlinx/coroutines/CoroutineDispatcher;)V", "fetchFileRepresentations", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/box/android/domain/models/RepresentationModel;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "hintsHeader", "", "(Lcom/box/android/domain/models/item/FileModel;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeNotReadyReps", "reps", "fetchFileRepresentationsFromRemoteAndUpdateCache", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/DomainError;", "fetchFileRepresentationsForVersion", "Lcom/box/android/domain/models/preview/FileVersionRepresentationsModel;", "fileId", "Lcom/box/android/domain/models/ItemId;", Constants.AMP_PLAN_VERSION_ID, "(Lcom/box/android/domain/models/ItemId;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadPreviewRepresentation", "Ljava/net/URL;", BoxRepresentation.FIELD_REPRESENTATION, "(Lcom/box/android/domain/models/ItemId;Ljava/lang/String;Lcom/box/android/domain/models/RepresentationModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadRepresentationToLegacyCache", "", "representationType", "Lcom/box/android/domain/preview/PreviewContentType$Representation;", "(Lcom/box/android/domain/models/item/FileModel;Lcom/box/android/domain/preview/PreviewContentType$Representation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildAssetTypePath", "downloadThumbnailRepresentation", "destinationURL", "(Lcom/box/android/domain/models/item/FileModel;Lcom/box/android/domain/models/RepresentationModel;Ljava/net/URL;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "makeSureRepresentationIsReady", "(Lcom/box/android/domain/models/RepresentationModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasCachedRepresentationPreview", "", "(Lcom/box/android/domain/models/item/FileModel;Lcom/box/android/domain/models/RepresentationModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "verifyRepresentationFinalStatus", "fetchRepresentationInfoUtilReady", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RepresentationsService implements IRepresentationsService {
    public static final String LOGTAG = "RepresentationsService";
    private static final long PENDING_CONVERSION_DELAY = 4000;
    private static final long PENDING_CONVERSION_RETRIES = 4;
    private static final int REQUEST_PAGE_NUMBER = 1;
    private final CoroutineDispatcher ioDispatcher;
    private final IPreviewController legacyPreviewController;
    private final IdMappingService mappingService;
    private final RepresentationsCacheDataSource representationsCacheDataSource;
    private final RepresentationsRemoteDataSource representationsRemoteDataSource;
    private final VersionsPreviewCache versionsPreviewCache;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RepresentationsService$downloadRepresentationToLegacyCache$1, reason: invalid class name */
    /* JADX INFO: compiled from: RepresentationsService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RepresentationsService", f = "RepresentationsService.kt", i = {0, 0}, l = {Token.METHOD}, m = "downloadRepresentationToLegacyCache", n = {"fileModel", "representationType"}, s = {"L$0", "L$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RepresentationsService.this.downloadRepresentationToLegacyCache(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RepresentationsService$fetchFileRepresentationsForVersion$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RepresentationsService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RepresentationsService", f = "RepresentationsService.kt", i = {0, 0, 1, 1, 1, 1, 1, 1}, l = {121, 122}, m = "fetchFileRepresentationsForVersion", n = {"fileId", Constants.AMP_PLAN_VERSION_ID, "fileId", Constants.AMP_PLAN_VERSION_ID, "$this$flatMap$iv", "remoteId", "$i$f$flatMap", "$i$a$-flatMap-RepresentationsService$fetchFileRepresentationsForVersion$2"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1"}, v = 1)
    static final class C15141 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C15141(Continuation<? super C15141> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RepresentationsService.this.fetchFileRepresentationsForVersion(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RepresentationsService$fetchFileRepresentationsFromRemoteAndUpdateCache$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RepresentationsService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RepresentationsService", f = "RepresentationsService.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2}, l = {102, 103, 108}, m = "fetchFileRepresentationsFromRemoteAndUpdateCache", n = {"fileModel", "hintsHeader", "fileModel", "hintsHeader", "remoteId", "fileModel", "hintsHeader", "remoteId", "$this$map$iv", "it", "representationsDTO", "$i$f$map", "$i$a$-map-RepresentationsService$fetchFileRepresentationsFromRemoteAndUpdateCache$2"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1"}, v = 1)
    static final class C15151 extends ContinuationImpl {
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

        C15151(Continuation<? super C15151> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RepresentationsService.this.fetchFileRepresentationsFromRemoteAndUpdateCache(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RepresentationsService$makeSureRepresentationIsReady$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RepresentationsService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RepresentationsService", f = "RepresentationsService.kt", i = {0}, l = {BoxCommonConstants.REQUEST_OPTIONS}, m = "makeSureRepresentationIsReady", n = {BoxRepresentation.FIELD_REPRESENTATION}, s = {"L$0"}, v = 1)
    static final class C15181 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C15181(Continuation<? super C15181> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RepresentationsService.this.makeSureRepresentationIsReady(null, this);
        }
    }

    @Inject
    public RepresentationsService(RepresentationsRemoteDataSource representationsRemoteDataSource, RepresentationsCacheDataSource representationsCacheDataSource, VersionsPreviewCache versionsPreviewCache, IdMappingService mappingService, IPreviewController legacyPreviewController, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(representationsRemoteDataSource, "representationsRemoteDataSource");
        Intrinsics.checkNotNullParameter(representationsCacheDataSource, "representationsCacheDataSource");
        Intrinsics.checkNotNullParameter(versionsPreviewCache, "versionsPreviewCache");
        Intrinsics.checkNotNullParameter(mappingService, "mappingService");
        Intrinsics.checkNotNullParameter(legacyPreviewController, "legacyPreviewController");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.representationsRemoteDataSource = representationsRemoteDataSource;
        this.representationsCacheDataSource = representationsCacheDataSource;
        this.versionsPreviewCache = versionsPreviewCache;
        this.mappingService = mappingService;
        this.legacyPreviewController = legacyPreviewController;
        this.ioDispatcher = ioDispatcher;
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RepresentationsService$fetchFileRepresentations$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RepresentationsService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lcom/box/android/domain/models/RepresentationModel;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RepresentationsService$fetchFileRepresentations$2", f = "RepresentationsService.kt", i = {0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6}, l = {68, 70, 71, 73, 76, 78, 80}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "$this$map$iv", "it", "$i$f$map", "$i$a$-map-RepresentationsService$fetchFileRepresentations$2$1", "$this$flow", "$this$map$iv", "it", "$i$f$map", "$i$a$-map-RepresentationsService$fetchFileRepresentations$2$1", "$this$flow", "$this$map$iv", "it", "$this$map$iv", BoxFile.FIELD_REPRESENTATIONS, "$i$f$map", "$i$a$-map-RepresentationsService$fetchFileRepresentations$2$1", "$i$f$map", "$i$a$-map-RepresentationsService$fetchFileRepresentations$2$1$1", "$this$flow", "$this$mapError$iv", "it", "$i$f$mapError", "$i$a$-mapError-RepresentationsService$fetchFileRepresentations$2$2", "$this$flow", "$this$mapError$iv", "it", "$this$map$iv", BoxFile.FIELD_REPRESENTATIONS, "$i$f$mapError", "$i$a$-mapError-RepresentationsService$fetchFileRepresentations$2$2", "$i$f$map", "$i$a$-map-RepresentationsService$fetchFileRepresentations$2$2$1", "$this$flow", "$this$mapError$iv", "it", "$this$mapError$iv", "it", "$i$f$mapError", "$i$a$-mapError-RepresentationsService$fetchFileRepresentations$2$2", "$i$f$mapError", "$i$a$-mapError-RepresentationsService$fetchFileRepresentations$2$2$2"}, s = {"L$0", "L$0", "L$1", "L$5", "I$0", "I$1", "L$0", "L$1", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C15132 extends SuspendLambda implements Function2<FlowCollector<? super List<? extends RepresentationModel>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ FileModel $fileModel;
        final /* synthetic */ String $hintsHeader;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15132(FileModel fileModel, String str, Continuation<? super C15132> continuation) {
            super(2, continuation);
            this.$fileModel = fileModel;
            this.$hintsHeader = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C15132 c15132 = RepresentationsService.this.new C15132(this.$fileModel, this.$hintsHeader, continuation);
            c15132.L$0 = obj;
            return c15132;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super List<? extends RepresentationModel>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super List<RepresentationModel>>) flowCollector, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super List<RepresentationModel>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C15132) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:18:0x00cd  */
        /* JADX WARN: Code duplicated, block: B:21:0x0101  */
        /* JADX WARN: Code duplicated, block: B:25:0x012a  */
        /* JADX WARN: Code duplicated, block: B:28:0x0131  */
        /* JADX WARN: Code duplicated, block: B:32:0x0176  */
        /* JADX WARN: Code duplicated, block: B:35:0x0183  */
        /* JADX WARN: Code duplicated, block: B:37:0x0189  */
        /* JADX WARN: Code duplicated, block: B:41:0x0197  */
        /* JADX WARN: Code duplicated, block: B:43:0x019b  */
        /* JADX WARN: Code duplicated, block: B:46:0x01c5  */
        /* JADX WARN: Code duplicated, block: B:49:0x01d0  */
        /* JADX WARN: Code duplicated, block: B:52:0x0209  */
        /* JADX WARN: Code duplicated, block: B:54:0x0216  */
        /* JADX WARN: Code duplicated, block: B:59:0x021f  */
        /* JADX WARN: Code duplicated, block: B:61:0x0223  */
        /* JADX WARN: Code duplicated, block: B:66:0x0271  */
        /* JADX WARN: Code duplicated, block: B:68:0x0277  */
        /* JADX WARN: Code duplicated, block: B:70:0x027d  */
        /* JADX WARN: Code duplicated, block: B:74:0x0286  */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0167, code lost:
        
            if (r0.emit(r7, r11) == r1) goto L63;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x025d, code lost:
        
            if (r0.emit(r8, r11) == r1) goto L63;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                Method dump skipped, instruction units count: 672
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.RepresentationsService.C15132.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.box.android.domain.services.IRepresentationsService
    public Object fetchFileRepresentations(FileModel fileModel, String str, Continuation<? super Flow<? extends List<RepresentationModel>>> continuation) {
        return FlowKt__ShareKt.shareIn$default(FlowKt.flow(new C15132(fileModel, str, null)), CoroutineScopeKt.CoroutineScope(continuation.get$context()), SharingStarted.INSTANCE.getLazily(), 0, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<RepresentationModel> removeNotReadyReps(List<RepresentationModel> reps) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : reps) {
            if (((RepresentationModel) obj).getStatus().getState().isReady()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:31:0x00be  */
    /* JADX WARN: Code duplicated, block: B:33:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:34:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:38:0x0104  */
    /* JADX WARN: Code duplicated, block: B:40:0x0112  */
    /* JADX WARN: Code duplicated, block: B:44:0x011a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:45:0x011b  */
    /* JADX WARN: Code duplicated, block: B:47:0x011f  */
    /* JADX WARN: Code duplicated, block: B:49:0x0138  */
    /* JADX WARN: Code duplicated, block: B:51:0x013e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object fetchFileRepresentationsFromRemoteAndUpdateCache(FileModel fileModel, String str, Continuation<? super Result<? extends List<RepresentationModel>, ? extends DomainError>> continuation) {
        C15151 c15151;
        FileModel fileModel2;
        ItemId.Remote remote;
        Result.Success success;
        RepresentationsDTO representationsDTO;
        RepresentationsDTO representationsDTO2;
        RepresentationsCacheDataSource representationsCacheDataSource;
        RepresentationsDTO representationsDTO3;
        if (continuation instanceof C15151) {
            c15151 = (C15151) continuation;
            if ((c15151.label & Integer.MIN_VALUE) != 0) {
                c15151.label -= Integer.MIN_VALUE;
            } else {
                c15151 = new C15151(continuation);
            }
        } else {
            c15151 = new C15151(continuation);
        }
        Object remoteId = c15151.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c15151.label;
        if (i == 0) {
            ResultKt.throwOnFailure(remoteId);
            IdMappingService idMappingService = this.mappingService;
            ItemId itemId = fileModel.getItemId();
            c15151.L$0 = fileModel;
            c15151.L$1 = str;
            c15151.label = 1;
            remoteId = idMappingService.getRemoteId(itemId, c15151);
            if (remoteId != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            str = (String) c15151.L$1;
            fileModel = (FileModel) c15151.L$0;
            ResultKt.throwOnFailure(remoteId);
        } else {
            if (i == 2) {
                remote = (ItemId.Remote) c15151.L$2;
                str = (String) c15151.L$1;
                fileModel2 = (FileModel) c15151.L$0;
                ResultKt.throwOnFailure(remoteId);
                success = (Result) remoteId;
                if (success instanceof Result.Success) {
                    representationsDTO = (RepresentationsDTO) ((Result.Success) success).getValue();
                    if (representationsDTO == null) {
                        representationsDTO2 = new RepresentationsDTO(CollectionsKt.emptyList());
                    } else {
                        representationsDTO2 = representationsDTO;
                    }
                    representationsCacheDataSource = this.representationsCacheDataSource;
                    c15151.L$0 = SpillingKt.nullOutSpilledVariable(fileModel2);
                    c15151.L$1 = SpillingKt.nullOutSpilledVariable(str);
                    c15151.L$2 = SpillingKt.nullOutSpilledVariable(remote);
                    c15151.L$3 = SpillingKt.nullOutSpilledVariable(success);
                    c15151.L$4 = SpillingKt.nullOutSpilledVariable(representationsDTO);
                    c15151.L$5 = representationsDTO2;
                    c15151.I$0 = 0;
                    c15151.I$1 = 0;
                    c15151.label = 3;
                    if (representationsCacheDataSource.updateFileRepresentations(fileModel2, representationsDTO2, c15151) != coroutine_suspended) {
                        representationsDTO3 = representationsDTO2;
                    }
                    return coroutine_suspended;
                }
                if (!(success instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (success instanceof Result.Success) {
                    return success;
                }
                if (!(success instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (RemoteError) ((Result.Error) success).getValue(), null, 2, null));
            }
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c15151.I$1;
            int i3 = c15151.I$0;
            representationsDTO3 = (RepresentationsDTO) c15151.L$5;
            ResultKt.throwOnFailure(remoteId);
        }
        success = new Result.Success(RepresentationToDomainUtilsKt.toDomain(representationsDTO3));
        if (success instanceof Result.Success) {
            return success;
        }
        if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (RemoteError) ((Result.Error) success).getValue(), null, 2, null));
        ItemId.Remote remote2 = (ItemId.Remote) remoteId;
        if (remote2 == null) {
            return new Result.Success(CollectionsKt.emptyList());
        }
        RepresentationsRemoteDataSource representationsRemoteDataSource = this.representationsRemoteDataSource;
        String boxId = remote2.getBoxId();
        c15151.L$0 = fileModel;
        c15151.L$1 = SpillingKt.nullOutSpilledVariable(str);
        c15151.L$2 = SpillingKt.nullOutSpilledVariable(remote2);
        c15151.label = 2;
        Object fileRepresentations = representationsRemoteDataSource.getFileRepresentations(boxId, str, c15151);
        if (fileRepresentations != coroutine_suspended) {
            fileModel2 = fileModel;
            remote = remote2;
            remoteId = fileRepresentations;
            success = (Result) remoteId;
            if (success instanceof Result.Success) {
                representationsDTO = (RepresentationsDTO) ((Result.Success) success).getValue();
                if (representationsDTO == null) {
                    representationsDTO2 = new RepresentationsDTO(CollectionsKt.emptyList());
                } else {
                    representationsDTO2 = representationsDTO;
                }
                representationsCacheDataSource = this.representationsCacheDataSource;
                c15151.L$0 = SpillingKt.nullOutSpilledVariable(fileModel2);
                c15151.L$1 = SpillingKt.nullOutSpilledVariable(str);
                c15151.L$2 = SpillingKt.nullOutSpilledVariable(remote);
                c15151.L$3 = SpillingKt.nullOutSpilledVariable(success);
                c15151.L$4 = SpillingKt.nullOutSpilledVariable(representationsDTO);
                c15151.L$5 = representationsDTO2;
                c15151.I$0 = 0;
                c15151.I$1 = 0;
                c15151.label = 3;
                if (representationsCacheDataSource.updateFileRepresentations(fileModel2, representationsDTO2, c15151) != coroutine_suspended) {
                    representationsDTO3 = representationsDTO2;
                    success = new Result.Success(RepresentationToDomainUtilsKt.toDomain(representationsDTO3));
                }
            } else if (!(success instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            if (success instanceof Result.Success) {
                return success;
            }
            if (!(success instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (RemoteError) ((Result.Error) success).getValue(), null, 2, null));
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a4, code lost:
    
        if (r8 == r1) goto L23;
     */
    @Override // com.box.android.domain.services.IRepresentationsService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object fetchFileRepresentationsForVersion(com.box.android.domain.models.ItemId r6, java.lang.String r7, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<com.box.android.domain.models.preview.FileVersionRepresentationsModel, ? extends com.box.android.domain.models.DomainError>> r8) {
        /*
            Method dump skipped, instruction units count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.RepresentationsService.fetchFileRepresentationsForVersion(com.box.android.domain.models.ItemId, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RepresentationsService$downloadPreviewRepresentation$2, reason: invalid class name */
    /* JADX INFO: compiled from: RepresentationsService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "Ljava/net/URL;", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RepresentationsService$downloadPreviewRepresentation$2", f = "RepresentationsService.kt", i = {1, 1, 1, 1, 1, 1, 1}, l = {Token.TARGET, Token.SET_REF_OP}, m = "invokeSuspend", n = {"$this$flatMap$iv", "remoteId", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "destinationUrl", "$i$f$flatMap", "$i$a$-flatMap-RepresentationsService$downloadPreviewRepresentation$2$1", "fileCreated"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "Z$0"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends URL, ? extends DomainError>>, Object> {
        final /* synthetic */ ItemId $fileId;
        final /* synthetic */ RepresentationModel $representation;
        final /* synthetic */ String $versionId;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ItemId itemId, String str, RepresentationModel representationModel, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$fileId = itemId;
            this.$versionId = str;
            this.$representation = representationModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RepresentationsService.this.new AnonymousClass2(this.$fileId, this.$versionId, this.$representation, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends URL, ? extends DomainError>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<URL, ? extends DomainError>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<URL, ? extends DomainError>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x00cc  */
        /* JADX WARN: Code duplicated, block: B:26:0x00dd  */
        /* JADX WARN: Code duplicated, block: B:30:0x00e5 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:31:0x00e6  */
        /* JADX WARN: Code duplicated, block: B:33:0x00ea  */
        /* JADX WARN: Code duplicated, block: B:35:0x0102  */
        /* JADX WARN: Code duplicated, block: B:37:0x0108  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            URL url;
            Result.Success success;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = RepresentationsService.this.mappingService.getRemoteIdOrError(this.$fileId, this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                url = (URL) this.L$3;
                ResultKt.throwOnFailure(obj);
            }
            success = (Result) obj;
            if (success instanceof Result.Success) {
                success = new Result.Success(url);
            } else if (!(success instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            if (success instanceof Result.Success) {
                return success;
            }
            if (success instanceof Result.Error) {
                throw new NoWhenBranchMatchedException();
            }
            return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (RemoteError) ((Result.Error) success).getValue(), null, 2, null));
            Result result = (Result) obj;
            RepresentationsService representationsService = RepresentationsService.this;
            String str = this.$versionId;
            RepresentationModel representationModel = this.$representation;
            if (result instanceof Result.Success) {
                ItemId.Remote remote = (ItemId.Remote) ((Result.Success) result).getValue();
                Result<Pair<Boolean, URL>, CacheError> destinationUrl = representationsService.versionsPreviewCache.getDestinationUrl(remote.getBoxId(), str, representationModel.getRepresentationType().toString());
                if (destinationUrl instanceof Result.Success) {
                    Pair pair = (Pair) ((Result.Success) destinationUrl).getValue();
                    boolean zBooleanValue = ((Boolean) pair.component1()).booleanValue();
                    URL url2 = (URL) pair.component2();
                    if (zBooleanValue) {
                        RepresentationsRemoteDataSource representationsRemoteDataSource = representationsService.representationsRemoteDataSource;
                        URL url3 = new URL(representationsService.buildAssetTypePath(representationModel.getContentUrlTemplate(), representationModel));
                        this.L$0 = SpillingKt.nullOutSpilledVariable(result);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(remote);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(destinationUrl);
                        this.L$3 = url2;
                        this.I$0 = 0;
                        this.I$1 = 0;
                        this.Z$0 = zBooleanValue;
                        this.label = 2;
                        obj = representationsRemoteDataSource.downloadRepresentation(url3, url2, this);
                        if (obj != coroutine_suspended) {
                            url = url2;
                            success = (Result) obj;
                            if (success instanceof Result.Success) {
                                success = new Result.Success(url);
                            } else if (!(success instanceof Result.Error)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            if (success instanceof Result.Success) {
                                return success;
                            }
                            if (success instanceof Result.Error) {
                                throw new NoWhenBranchMatchedException();
                            }
                            return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (RemoteError) ((Result.Error) success).getValue(), null, 2, null));
                        }
                        return coroutine_suspended;
                    }
                    return new Result.Success(url2);
                }
                if (!(destinationUrl instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (IGenericError) ((Result.Error) destinationUrl).getValue(), null, 2, null));
            }
            if (result instanceof Result.Error) {
                return result;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.box.android.domain.services.IRepresentationsService
    public Object downloadPreviewRepresentation(ItemId itemId, String str, RepresentationModel representationModel, Continuation<? super Result<URL, ? extends DomainError>> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new AnonymousClass2(itemId, str, representationModel, null), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.IRepresentationsService
    public Object downloadRepresentationToLegacyCache(FileModel fileModel, PreviewContentType.Representation representation, Continuation<? super Result<Unit, ? extends DomainError>> continuation) throws IOException {
        AnonymousClass1 anonymousClass1;
        PreviewContentType.Representation representation2;
        File cachedPreviewOnlyFile;
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
        Object objDownloadRepresentationToOutputStream = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objDownloadRepresentationToOutputStream);
            RepresentationsRemoteDataSource representationsRemoteDataSource = this.representationsRemoteDataSource;
            URL url = new URL(buildAssetTypePath(representation.getModel().getContentUrlTemplate(), representation.getModel()));
            OutputStream outputStreamCreatePreviewOutputStream = this.legacyPreviewController.getStorage().createPreviewOutputStream(fileModel, (String) null, representation);
            Intrinsics.checkNotNullExpressionValue(outputStreamCreatePreviewOutputStream, "createPreviewOutputStream(...)");
            anonymousClass1.L$0 = fileModel;
            anonymousClass1.L$1 = representation;
            anonymousClass1.label = 1;
            objDownloadRepresentationToOutputStream = representationsRemoteDataSource.downloadRepresentationToOutputStream(url, outputStreamCreatePreviewOutputStream, anonymousClass1);
            if (objDownloadRepresentationToOutputStream == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            representation = (PreviewContentType.Representation) anonymousClass1.L$1;
            fileModel = (FileModel) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objDownloadRepresentationToOutputStream);
        }
        Result.Error error = (Result) objDownloadRepresentationToOutputStream;
        if (!(error instanceof Result.Success)) {
            if (!(error instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            error = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (RemoteError) ((Result.Error) error).getValue(), null, 2, null));
        }
        if ((error instanceof Result.Success) && (cachedPreviewOnlyFile = this.legacyPreviewController.getStorage().getCachedPreviewOnlyFile(fileModel, (String) null, (representation2 = representation))) != null) {
            BoxDocumentFile boxDocumentFile = new BoxDocumentFile(FileModelMapper.toBoxFile$default(FileModelMapper.INSTANCE, fileModel, false, 1, null));
            boxDocumentFile.setContentLength(cachedPreviewOnlyFile.length());
            this.legacyPreviewController.getStorage().cacheMetadata(boxDocumentFile, "doc", representation2);
        }
        return error;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String buildAssetTypePath(String str, RepresentationModel representationModel) {
        String str2;
        if (representationModel.getProperties().getPaged()) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            str2 = String.format(Locale.ENGLISH, "%d.%s", Arrays.copyOf(new Object[]{1, RepresentationType.INSTANCE.toBoxRepType(representationModel.getRepresentationType())}, 2));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        } else {
            str2 = "";
        }
        return StringsKt.replace$default(str, "{+asset_path}", str2, false, 4, (Object) null);
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RepresentationsService$downloadThumbnailRepresentation$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RepresentationsService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "Ljava/net/URL;", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RepresentationsService$downloadThumbnailRepresentation$2", f = "RepresentationsService.kt", i = {}, l = {198}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C15122 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends URL, ? extends DomainError>>, Object> {
        final /* synthetic */ URL $destinationURL;
        final /* synthetic */ RepresentationModel $representation;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15122(RepresentationModel representationModel, URL url, Continuation<? super C15122> continuation) {
            super(2, continuation);
            this.$representation = representationModel;
            this.$destinationURL = url;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RepresentationsService.this.new C15122(this.$representation, this.$destinationURL, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends URL, ? extends DomainError>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<URL, ? extends DomainError>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<URL, ? extends DomainError>> continuation) {
            return ((C15122) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = RepresentationsService.this.representationsRemoteDataSource.downloadRepresentation(new URL(RepresentationsService.this.buildAssetTypePath(this.$representation.getContentUrlTemplate(), this.$representation)), this.$destinationURL, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Result.Success success = (Result) obj;
            URL url = this.$destinationURL;
            if (success instanceof Result.Success) {
                success = new Result.Success(url);
            } else if (!(success instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            if (success instanceof Result.Success) {
                return success;
            }
            if (!(success instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (RemoteError) ((Result.Error) success).getValue(), null, 2, null));
        }
    }

    @Override // com.box.android.domain.services.IRepresentationsService
    public Object downloadThumbnailRepresentation(FileModel fileModel, RepresentationModel representationModel, URL url, Continuation<? super Result<URL, ? extends DomainError>> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new C15122(representationModel, url, null), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.IRepresentationsService
    public Object makeSureRepresentationIsReady(RepresentationModel representationModel, Continuation<? super Result<RepresentationModel, ? extends DomainError>> continuation) {
        C15181 c15181;
        if (continuation instanceof C15181) {
            c15181 = (C15181) continuation;
            if ((c15181.label & Integer.MIN_VALUE) != 0) {
                c15181.label -= Integer.MIN_VALUE;
            } else {
                c15181 = new C15181(continuation);
            }
        } else {
            c15181 = new C15181(continuation);
        }
        Object objFetchRepresentationInfoUtilReady = c15181.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c15181.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objFetchRepresentationInfoUtilReady);
            if (representationModel.getStatus().getState() == RepresentationStatus.State.PENDING || representationModel.getStatus().getState() == RepresentationStatus.State.NONE) {
                c15181.L$0 = SpillingKt.nullOutSpilledVariable(representationModel);
                c15181.label = 1;
                objFetchRepresentationInfoUtilReady = fetchRepresentationInfoUtilReady(representationModel, c15181);
                if (objFetchRepresentationInfoUtilReady == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                return verifyRepresentationFinalStatus(representationModel);
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objFetchRepresentationInfoUtilReady);
        }
        Result result = (Result) objFetchRepresentationInfoUtilReady;
        if (result instanceof Result.Success) {
            return verifyRepresentationFinalStatus((RepresentationModel) ((Result.Success) result).getValue());
        }
        if (!(result instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(new FilePreviewDomainError.RepresentationNotReadyError(null, 1, null));
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RepresentationsService$hasCachedRepresentationPreview$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RepresentationsService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RepresentationsService$hasCachedRepresentationPreview$2", f = "RepresentationsService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C15172 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ FileModel $fileModel;
        final /* synthetic */ RepresentationModel $representation;
        int label;
        final /* synthetic */ RepresentationsService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15172(RepresentationModel representationModel, RepresentationsService representationsService, FileModel fileModel, Continuation<? super C15172> continuation) {
            super(2, continuation);
            this.$representation = representationModel;
            this.this$0 = representationsService;
            this.$fileModel = fileModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C15172(this.$representation, this.this$0, this.$fileModel, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C15172) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:19:0x0062  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            WatermarkModel watermark;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            PreviewContentType.Representation representation = new PreviewContentType.Representation(this.$representation);
            File cachedPreviewFile = this.this$0.legacyPreviewController.getStorage().getCachedPreviewFile(this.$fileModel, (String) null, representation);
            boolean z = false;
            if (cachedPreviewFile == null || !cachedPreviewFile.exists()) {
                return Boxing.boxBoolean(false);
            }
            boolean zIsWatermarked = FileModel.INSTANCE.isWatermarked(this.$fileModel);
            FileModel fileModel = (FileModel) this.this$0.legacyPreviewController.getStorage().getMetadata(this.$fileModel, "doc", representation);
            boolean z2 = (fileModel == null || (watermark = fileModel.getWatermark()) == null || !watermark.isWatermarked()) ? false : true;
            if (!zIsWatermarked && !z2) {
                z = true;
            } else if (zIsWatermarked && !z2) {
                this.this$0.legacyPreviewController.getStorage().clearPreviewCacheForFile(this.$fileModel);
            } else if (zIsWatermarked && z2) {
                z = true;
            }
            return Boxing.boxBoolean(z);
        }
    }

    @Override // com.box.android.domain.services.IRepresentationsService
    public Object hasCachedRepresentationPreview(FileModel fileModel, RepresentationModel representationModel, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new C15172(representationModel, this, fileModel, null), continuation);
    }

    private final Result<RepresentationModel, DomainError> verifyRepresentationFinalStatus(RepresentationModel representation) {
        if (representation.getStatus().getState() == RepresentationStatus.State.ERROR) {
            if (Intrinsics.areEqual(representation.getStatus(), IRepresentationsService.INSTANCE.getPASSWORD_PROTECTED_ERROR())) {
                return new Result.Error(new FilePreviewDomainError.PasswordProtectedError(null, 1, null));
            }
            String code = representation.getStatus().getCode();
            if (code == null) {
                code = "";
            }
            return new Result.Error(new FilePreviewDomainError.RepresentationStatusError(code));
        }
        if (representation.getStatus().getState() != RepresentationStatus.State.SUCCESS && representation.getStatus().getState() != RepresentationStatus.State.VIEWABLE) {
            return new Result.Error(new FilePreviewDomainError.RepresentationNotReadyError(null, 1, null));
        }
        return new Result.Success(representation);
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RepresentationsService$fetchRepresentationInfoUtilReady$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RepresentationsService.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/RepresentationModel;", "Lcom/box/android/domain/models/DomainError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RepresentationsService$fetchRepresentationInfoUtilReady$2", f = "RepresentationsService.kt", i = {0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {273, 280, 288}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "$this$onSuccess$iv", "it", "representationModel", "$i$f$onSuccess", "$i$a$-onSuccess-RepresentationsService$fetchRepresentationInfoUtilReady$2$1", "$this$flow", "$this$onError$iv", "it", "$i$f$onError", "$i$a$-onError-RepresentationsService$fetchRepresentationInfoUtilReady$2$2"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class C15162 extends SuspendLambda implements Function2<FlowCollector<? super Result<? extends RepresentationModel, ? extends DomainError>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ RepresentationModel $representation;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX INFO: renamed from: com.box.android.data.service.impl.RepresentationsService$fetchRepresentationInfoUtilReady$2$WhenMappings */
        /* JADX INFO: compiled from: RepresentationsService.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[RepresentationStatus.State.values().length];
                try {
                    iArr[RepresentationStatus.State.SUCCESS.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[RepresentationStatus.State.VIEWABLE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[RepresentationStatus.State.ERROR.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15162(RepresentationModel representationModel, Continuation<? super C15162> continuation) {
            super(2, continuation);
            this.$representation = representationModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C15162 c15162 = RepresentationsService.this.new C15162(this.$representation, continuation);
            c15162.L$0 = obj;
            return c15162;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends RepresentationModel, ? extends DomainError>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Result<RepresentationModel, ? extends DomainError>>) flowCollector, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<RepresentationModel, ? extends DomainError>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C15162) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:31:0x00bb  */
        /* JADX WARN: Code duplicated, block: B:33:0x00bf  */
        /* JADX WARN: Code duplicated, block: B:36:0x00f4  */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00f1, code lost:
        
            if (r0.emit(r4, r10) == r1) goto L35;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) throws com.box.android.data.service.impl.PendingConversionException {
            /*
                Method dump skipped, instruction units count: 259
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.RepresentationsService.C15162.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fetchRepresentationInfoUtilReady(RepresentationModel representationModel, Continuation<? super Result<RepresentationModel, ? extends DomainError>> continuation) {
        return FlowKt.first(FlowKt.flowOn(FlowKt.m16356catch(FlowKt.retry(FlowKt.flow(new C15162(representationModel, null)), 4L, new AnonymousClass3(null)), new AnonymousClass4(null)), this.ioDispatcher), continuation);
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RepresentationsService$fetchRepresentationInfoUtilReady$3, reason: invalid class name */
    /* JADX INFO: compiled from: RepresentationsService.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "cause", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RepresentationsService$fetchRepresentationInfoUtilReady$3", f = "RepresentationsService.kt", i = {0}, l = {292}, m = "invokeSuspend", n = {"cause"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<Throwable, Continuation<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Throwable th, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass3) create(th, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Throwable th = (Throwable) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            boolean z = true;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (th instanceof PendingConversionException) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(th);
                    this.label = 1;
                    if (DelayKt.delay(RepresentationsService.PENDING_CONVERSION_DELAY, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    z = false;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Boxing.boxBoolean(z);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RepresentationsService$fetchRepresentationInfoUtilReady$4, reason: invalid class name */
    /* JADX INFO: compiled from: RepresentationsService.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/RepresentationModel;", "Lcom/box/android/domain/models/DomainError;", "it", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RepresentationsService$fetchRepresentationInfoUtilReady$4", f = "RepresentationsService.kt", i = {0, 0, 1, 1}, l = {301, 303}, m = "invokeSuspend", n = {"$this$catch", "it", "$this$catch", "it"}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 1)
    static final class AnonymousClass4 extends SuspendLambda implements Function3<FlowCollector<? super Result<? extends RepresentationModel, ? extends DomainError>>, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        AnonymousClass4(Continuation<? super AnonymousClass4> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends RepresentationModel, ? extends DomainError>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Result<RepresentationModel, ? extends DomainError>>) flowCollector, th, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<RepresentationModel, ? extends DomainError>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(continuation);
            anonymousClass4.L$0 = flowCollector;
            anonymousClass4.L$1 = th;
            return anonymousClass4.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x004a, code lost:
        
            if (r0.emit(new com.box.android.domain.utils.result.Result.Error(new com.box.android.domain.models.FilePreviewDomainError.RepresentationNotReadyError(null, 1, null)), r8) == r2) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x007f, code lost:
        
            if (r0.emit(new com.box.android.domain.utils.result.Result.Error(new com.box.android.domain.models.DomainError.UnknownError("Fetch representation info failed with error: " + r5)), r8) == r2) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0081, code lost:
        
            return r2;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = r8.L$0
                kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
                java.lang.Object r1 = r8.L$1
                java.lang.Throwable r1 = (java.lang.Throwable) r1
                java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r3 = r8.label
                r4 = 2
                r5 = 1
                if (r3 == 0) goto L23
                if (r3 == r5) goto L1f
                if (r3 != r4) goto L17
                goto L1f
            L17:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L1f:
                kotlin.ResultKt.throwOnFailure(r9)
                goto L82
            L23:
                kotlin.ResultKt.throwOnFailure(r9)
                boolean r9 = r1 instanceof com.box.android.data.service.impl.PendingConversionException
                if (r9 == 0) goto L4d
                com.box.android.domain.utils.result.Result$Error r9 = new com.box.android.domain.utils.result.Result$Error
                com.box.android.domain.models.FilePreviewDomainError$RepresentationNotReadyError r3 = new com.box.android.domain.models.FilePreviewDomainError$RepresentationNotReadyError
                r4 = 0
                r3.<init>(r4, r5, r4)
                r9.<init>(r3)
                r3 = r8
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r8.L$0 = r4
                java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
                r8.L$1 = r1
                r8.label = r5
                java.lang.Object r8 = r0.emit(r9, r3)
                if (r8 != r2) goto L82
                goto L81
            L4d:
                com.box.android.domain.utils.result.Result$Error r9 = new com.box.android.domain.utils.result.Result$Error
                com.box.android.domain.models.DomainError$UnknownError r3 = new com.box.android.domain.models.DomainError$UnknownError
                java.lang.String r5 = r1.getMessage()
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                java.lang.String r7 = "Fetch representation info failed with error: "
                r6.<init>(r7)
                java.lang.StringBuilder r5 = r6.append(r5)
                java.lang.String r5 = r5.toString()
                r3.<init>(r5)
                r9.<init>(r3)
                r3 = r8
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r8.L$0 = r5
                java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
                r8.L$1 = r1
                r8.label = r4
                java.lang.Object r8 = r0.emit(r9, r3)
                if (r8 != r2) goto L82
            L81:
                return r2
            L82:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.RepresentationsService.AnonymousClass4.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
