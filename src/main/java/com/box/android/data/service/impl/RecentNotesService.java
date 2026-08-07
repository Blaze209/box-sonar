package com.box.android.data.service.impl;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.box.android.data.api.models.recentnotes.RecentNoteDTO;
import com.box.android.data.datasource.CacheError;
import com.box.android.data.datasource.LegacyCacheDataSource;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.datasource.recentnotes.RecentNotesLocalDataSource;
import com.box.android.data.datasource.recentnotes.RecentNotesRemoteDataSource;
import com.box.android.data.persistence.recentnotes.RecentNoteEntity;
import com.box.android.data.utilities.GQLCacheHelper;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.PermissionsModel;
import com.box.android.domain.models.item.RecentFileModel;
import com.box.android.domain.services.IRecentNotesService;
import com.box.android.domain.services.IRemoteItemService;
import com.box.android.domain.services.IdMappingService;
import com.box.android.domain.utils.result.Result;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: RecentNotesService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 /2\u00020\u0001:\u0001/B9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0010\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0004\u0012\u00020\u00150\u00120\u0011H\u0016J\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0013H\u0082@¢\u0006\u0002\u0010\u0019J\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00150\u0012H\u0096@¢\u0006\u0002\u0010\u001cJ0\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00150\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00132\u0006\u0010 \u001a\u00020!H\u0082@¢\u0006\u0002\u0010\"J\u0010\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020\u0014H\u0002J(\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020&0\u00122\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0082@¢\u0006\u0002\u0010\u0019J\u001c\u0010(\u001a\u00020\u001b2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0082@¢\u0006\u0002\u0010\u0019J,\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00150\u00122\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0096@¢\u0006\u0002\u0010.R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/box/android/data/service/impl/RecentNotesService;", "Lcom/box/android/domain/services/IRecentNotesService;", "recentNotesRemoteDataSource", "Lcom/box/android/data/datasource/recentnotes/RecentNotesRemoteDataSource;", "recentNotesLocalDataSource", "Lcom/box/android/data/datasource/recentnotes/RecentNotesLocalDataSource;", "remoteItemService", "Lcom/box/android/domain/services/IRemoteItemService;", "gqlCacheHelper", "Lcom/box/android/data/utilities/GQLCacheHelper;", "legacyCacheDataSource", "Lcom/box/android/data/datasource/LegacyCacheDataSource;", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", "<init>", "(Lcom/box/android/data/datasource/recentnotes/RecentNotesRemoteDataSource;Lcom/box/android/data/datasource/recentnotes/RecentNotesLocalDataSource;Lcom/box/android/domain/services/IRemoteItemService;Lcom/box/android/data/utilities/GQLCacheHelper;Lcom/box/android/data/datasource/LegacyCacheDataSource;Lcom/box/android/domain/services/IdMappingService;)V", "recentNoteItems", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/item/RecentFileModel;", "Lcom/box/android/domain/models/DomainError;", "resolveRecentNotesFromGQLCache", "entries", "Lcom/box/android/data/persistence/recentnotes/RecentNoteEntity;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchRecentNotesFromRemote", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveFetchedPage", "pageDtos", "Lcom/box/android/data/api/models/recentnotes/RecentNoteDTO;", "isFirstPage", "", "(Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isAccessible", "model", "saveFilesToGQLCache", "Lcom/box/android/data/datasource/CacheError;", "files", "saveFilesToLegacyCache", "saveNoteToRecents", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "", "(Lcom/box/android/domain/models/item/FileModel;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RecentNotesService implements IRecentNotesService {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String TAG = "RecentNotesService";
    private final GQLCacheHelper gqlCacheHelper;
    private final IdMappingService idMappingService;
    private final LegacyCacheDataSource legacyCacheDataSource;
    private final RecentNotesLocalDataSource recentNotesLocalDataSource;
    private final RecentNotesRemoteDataSource recentNotesRemoteDataSource;
    private final IRemoteItemService remoteItemService;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RecentNotesService$resolveRecentNotesFromGQLCache$1, reason: invalid class name */
    /* JADX INFO: compiled from: RecentNotesService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RecentNotesService", f = "RecentNotesService.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {75}, m = "resolveRecentNotesFromGQLCache", n = {"entries", "$this$mapNotNull$iv", "$this$mapNotNullTo$iv$iv", "destination$iv$iv", "$this$forEach$iv$iv$iv", "element$iv$iv$iv", "element$iv$iv", TypedValues.Custom.S_REFERENCE, "$i$f$mapNotNull", "$i$f$mapNotNullTo", "$i$f$forEach", "$i$a$-forEach-CollectionsKt___CollectionsKt$mapNotNullTo$1$iv$iv", "$i$a$-mapNotNull-RecentNotesService$resolveRecentNotesFromGQLCache$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "L$8", "I$0", "I$1", "I$2", "I$3", "I$4"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
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

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RecentNotesService.this.resolveRecentNotesFromGQLCache(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RecentNotesService$saveFetchedPage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RecentNotesService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RecentNotesService", f = "RecentNotesService.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3}, l = {104, 105, 108, 110}, m = "saveFetchedPage", n = {"pageDtos", "pageModels", "pageEntities", "isFirstPage", "pageDtos", "pageModels", "pageEntities", "$this$onSuccess$iv", "it", "isFirstPage", "$i$f$onSuccess", "$i$a$-onSuccess-RecentNotesService$saveFetchedPage$2", "pageDtos", "pageModels", "pageEntities", "$this$flatMap$iv", "it", "isFirstPage", "$i$f$flatMap", "$i$a$-flatMap-RecentNotesService$saveFetchedPage$3", "pageDtos", "pageModels", "pageEntities", "$this$flatMap$iv", "it", "isFirstPage", "$i$f$flatMap", "$i$a$-flatMap-RecentNotesService$saveFetchedPage$3"}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "I$0", "I$1"}, v = 1)
    static final class C14861 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C14861(Continuation<? super C14861> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RecentNotesService.this.saveFetchedPage(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RecentNotesService$saveFilesToGQLCache$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RecentNotesService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RecentNotesService", f = "RecentNotesService.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {181, 136}, m = "saveFilesToGQLCache", n = {"files", "this_$iv", "$this$withLock_u24default$iv$iv", "$i$f$apolloStoreWithLock", "$i$f$withLock", "files", "this_$iv", "$this$withLock_u24default$iv$iv", "store", "note", "fileModel", "$i$f$apolloStoreWithLock", "$i$f$withLock", "$i$a$-withLock$default-GQLCache$apolloStoreWithLock$2$iv", "$i$a$-apolloStoreWithLock-RecentNotesService$saveFilesToGQLCache$2"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C14871 extends ContinuationImpl {
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
        int label;
        /* synthetic */ Object result;

        C14871(Continuation<? super C14871> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RecentNotesService.this.saveFilesToGQLCache(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RecentNotesService$saveFilesToLegacyCache$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RecentNotesService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RecentNotesService", f = "RecentNotesService.kt", i = {0, 0, 0, 0, 0, 0}, l = {Token.LET}, m = "saveFilesToLegacyCache", n = {"files", "$this$forEach$iv", "element$iv", "note", "$i$f$forEach", "$i$a$-forEach-RecentNotesService$saveFilesToLegacyCache$2"}, s = {"L$0", "L$1", "L$3", "L$4", "I$0", "I$1"}, v = 1)
    static final class C14881 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C14881(Continuation<? super C14881> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RecentNotesService.this.saveFilesToLegacyCache(null, this);
        }
    }

    @Inject
    public RecentNotesService(RecentNotesRemoteDataSource recentNotesRemoteDataSource, RecentNotesLocalDataSource recentNotesLocalDataSource, IRemoteItemService remoteItemService, GQLCacheHelper gqlCacheHelper, LegacyCacheDataSource legacyCacheDataSource, IdMappingService idMappingService) {
        Intrinsics.checkNotNullParameter(recentNotesRemoteDataSource, "recentNotesRemoteDataSource");
        Intrinsics.checkNotNullParameter(recentNotesLocalDataSource, "recentNotesLocalDataSource");
        Intrinsics.checkNotNullParameter(remoteItemService, "remoteItemService");
        Intrinsics.checkNotNullParameter(gqlCacheHelper, "gqlCacheHelper");
        Intrinsics.checkNotNullParameter(legacyCacheDataSource, "legacyCacheDataSource");
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        this.recentNotesRemoteDataSource = recentNotesRemoteDataSource;
        this.recentNotesLocalDataSource = recentNotesLocalDataSource;
        this.remoteItemService = remoteItemService;
        this.gqlCacheHelper = gqlCacheHelper;
        this.legacyCacheDataSource = legacyCacheDataSource;
        this.idMappingService = idMappingService;
    }

    /* JADX INFO: compiled from: RecentNotesService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/box/android/data/service/impl/RecentNotesService$Companion;", "", "<init>", "()V", "TAG", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.box.android.domain.services.IRecentNotesService
    public Flow<Result<List<RecentFileModel>, DomainError>> recentNoteItems() {
        final Flow<Result<List<RecentNoteEntity>, CacheError>> flowObserveRecentNoteEntries = this.recentNotesLocalDataSource.observeRecentNoteEntries();
        return FlowKt.flowOn(new Flow<Result<? extends List<? extends RecentFileModel>, ? extends DomainError>>() { // from class: com.box.android.data.service.impl.RecentNotesService$recentNoteItems$$inlined$map$1

            /* JADX INFO: renamed from: com.box.android.data.service.impl.RecentNotesService$recentNoteItems$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ RecentNotesService this$0;

                /* JADX INFO: renamed from: com.box.android.data.service.impl.RecentNotesService$recentNoteItems$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.data.service.impl.RecentNotesService$recentNoteItems$$inlined$map$1$2", f = "RecentNotesService.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {52, 50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$completion", "entriesResult", "$this$map$iv", "entries", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1", "$i$a$-map-RecentNotesService$recentNoteItems$1", "$i$f$map", "$i$a$-map-RecentNotesService$recentNoteItems$1$1", "value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "L$8", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
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

                public AnonymousClass2(FlowCollector flowCollector, RecentNotesService recentNotesService) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = recentNotesService;
                }

                /* JADX WARN: Code duplicated, block: B:29:0x00f3  */
                /* JADX WARN: Code duplicated, block: B:31:0x00f7  */
                /* JADX WARN: Code duplicated, block: B:37:0x013f  */
                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                /* JADX WARN: Code restructure failed: missing block: B:33:0x0139, code lost:
                
                    if (r11.emit(r5, r0) == r1) goto L34;
                 */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r10, kotlin.coroutines.Continuation r11) {
                    /*
                        Method dump skipped, instruction units count: 331
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.RecentNotesService$recentNoteItems$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Result<? extends List<? extends RecentFileModel>, ? extends DomainError>> flowCollector, Continuation continuation) {
                Object objCollect = flowObserveRecentNoteEntries.collect(new AnonymousClass2(flowCollector, this), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, Dispatchers.getIO());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:17:0x0088  */
    /* JADX WARN: Code duplicated, block: B:19:0x00de A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x00df  */
    /* JADX WARN: Code duplicated, block: B:23:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:24:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:26:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:27:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:29:0x0106  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00df -> B:21:0x00e2). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object resolveRecentNotesFromGQLCache(java.util.List<com.box.android.data.persistence.recentnotes.RecentNoteEntity> r18, kotlin.coroutines.Continuation<? super java.util.List<com.box.android.domain.models.item.RecentFileModel>> r19) {
        /*
            Method dump skipped, instruction units count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.RecentNotesService.resolveRecentNotesFromGQLCache(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RecentNotesService$fetchRecentNotesFromRemote$2, reason: invalid class name */
    /* JADX INFO: compiled from: RecentNotesService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RecentNotesService$fetchRecentNotesFromRemote$2", f = "RecentNotesService.kt", i = {0, 0, 0}, l = {175}, m = "invokeSuspend", n = {"domainError", "$this$collectIndexed$iv", "$i$f$collectIndexed"}, s = {"L$0", "L$1", "I$0"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit, ? extends DomainError>>, Object> {
        int I$0;
        Object L$0;
        Object L$1;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RecentNotesService.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit, ? extends DomainError>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<Unit, ? extends DomainError>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Ref.ObjectRef objectRef;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                Flow<Result<List<RecentNoteDTO>, RemoteError>> flowFetchRecentNotesPages = RecentNotesService.this.recentNotesRemoteDataSource.fetchRecentNotesPages();
                this.L$0 = objectRef2;
                this.L$1 = SpillingKt.nullOutSpilledVariable(flowFetchRecentNotesPages);
                this.I$0 = 0;
                this.label = 1;
                if (flowFetchRecentNotesPages.collect(new RecentNotesService$fetchRecentNotesFromRemote$2$invokeSuspend$$inlined$collectIndexed$1(RecentNotesService.this, objectRef2), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = objectRef2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef = (Ref.ObjectRef) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            DomainError domainError = (DomainError) objectRef.element;
            return domainError != null ? new Result.Error(domainError) : new Result.Success(Unit.INSTANCE);
        }
    }

    @Override // com.box.android.domain.services.IRecentNotesService
    public Object fetchRecentNotesFromRemote(Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:51:0x0186  */
    /* JADX WARN: Code duplicated, block: B:53:0x0191  */
    /* JADX WARN: Code duplicated, block: B:57:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:61:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:65:0x01fd A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:66:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:68:0x0202  */
    /* JADX WARN: Code duplicated, block: B:70:0x021b  */
    /* JADX WARN: Code duplicated, block: B:72:0x0221  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x01bd, code lost:
    
        if (r15 == r1) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x01ef, code lost:
    
        if (r15 == r1) goto L59;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object saveFetchedPage(java.util.List<com.box.android.data.api.models.recentnotes.RecentNoteDTO> r13, boolean r14, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<kotlin.Unit, ? extends com.box.android.domain.models.DomainError>> r15) {
        /*
            Method dump skipped, instruction units count: 557
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.RecentNotesService.saveFetchedPage(java.util.List, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean isAccessible(RecentFileModel model) {
        PermissionsModel permissions = model.getPermissions();
        if (permissions == null) {
            return false;
        }
        if (permissions.getCanPreview()) {
            return true;
        }
        String interactionSharedLink = model.getRecentItem().getInteractionSharedLink();
        return (interactionSharedLink == null || interactionSharedLink.length() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:32:0x00c3 A[Catch: all -> 0x0059, TryCatch #0 {all -> 0x0059, blocks: (B:13:0x0053, B:36:0x0103, B:38:0x0109, B:40:0x010d, B:43:0x011e, B:44:0x0123, B:30:0x00bd, B:32:0x00c3, B:46:0x0129, B:24:0x00a0, B:26:0x00a6, B:29:0x00b1), top: B:51:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x0101  */
    /* JADX WARN: Code duplicated, block: B:38:0x0109 A[Catch: all -> 0x0059, TryCatch #0 {all -> 0x0059, blocks: (B:13:0x0053, B:36:0x0103, B:38:0x0109, B:40:0x010d, B:43:0x011e, B:44:0x0123, B:30:0x00bd, B:32:0x00c3, B:46:0x0129, B:24:0x00a0, B:26:0x00a6, B:29:0x00b1), top: B:51:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x010d A[Catch: all -> 0x0059, TRY_LEAVE, TryCatch #0 {all -> 0x0059, blocks: (B:13:0x0053, B:36:0x0103, B:38:0x0109, B:40:0x010d, B:43:0x011e, B:44:0x0123, B:30:0x00bd, B:32:0x00c3, B:46:0x0129, B:24:0x00a0, B:26:0x00a6, B:29:0x00b1), top: B:51:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x011e A[Catch: all -> 0x0059, TRY_ENTER, TryCatch #0 {all -> 0x0059, blocks: (B:13:0x0053, B:36:0x0103, B:38:0x0109, B:40:0x010d, B:43:0x011e, B:44:0x0123, B:30:0x00bd, B:32:0x00c3, B:46:0x0129, B:24:0x00a0, B:26:0x00a6, B:29:0x00b1), top: B:51:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0124  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x0136: INVOKE (r12 I:kotlinx.coroutines.sync.Mutex), (r7 I:java.lang.Object) INTERFACE call: kotlinx.coroutines.sync.Mutex.unlock(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:239), block:B:49:0x0136 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0101 -> B:36:0x0103). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object saveFilesToGQLCache(java.util.List<com.box.android.domain.models.item.RecentFileModel> r17, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<kotlin.Unit, ? extends com.box.android.data.datasource.CacheError>> r18) {
        /*
            Method dump skipped, instruction units count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.RecentNotesService.saveFilesToGQLCache(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:18:0x0061  */
    /* JADX WARN: Code duplicated, block: B:20:0x0094 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x0095  */
    /* JADX WARN: Code duplicated, block: B:24:0x009f  */
    /* JADX WARN: Code duplicated, block: B:26:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:27:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0095 -> B:12:0x0044). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object saveFilesToLegacyCache(java.util.List<com.box.android.domain.models.item.RecentFileModel> r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.RecentNotesService.saveFilesToLegacyCache(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RecentNotesService$saveNoteToRecents$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RecentNotesService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RecentNotesService$saveNoteToRecents$2", f = "RecentNotesService.kt", i = {1, 1, 1, 1, 1}, l = {Token.DEBUGGER, 169}, m = "invokeSuspend", n = {"$this$flatMap$iv", "remoteId", "entity", "$i$f$flatMap", "$i$a$-flatMap-RecentNotesService$saveNoteToRecents$2$1"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class C14892 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit, ? extends DomainError>>, Object> {
        final /* synthetic */ FileModel $fileModel;
        final /* synthetic */ String $sharedLink;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14892(FileModel fileModel, String str, Continuation<? super C14892> continuation) {
            super(2, continuation);
            this.$fileModel = fileModel;
            this.$sharedLink = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RecentNotesService.this.new C14892(this.$fileModel, this.$sharedLink, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit, ? extends DomainError>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<Unit, ? extends DomainError>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
            return ((C14892) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x009a, code lost:
        
            if (r10 == r0) goto L17;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                Method dump skipped, instruction units count: 208
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.RecentNotesService.C14892.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.box.android.domain.services.IRecentNotesService
    public Object saveNoteToRecents(FileModel fileModel, String str, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C14892(fileModel, str, null), continuation);
    }
}
