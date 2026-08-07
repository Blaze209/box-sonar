package com.box.android.domain.metrics.preview;

import androidx.media3.extractor.ts.PsExtractor;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.domain.metrics.ObservabilityProcessor;
import com.box.android.domain.metrics.preview.units.FileWithRepresentationsFetchObservability;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.RepresentationModel;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.observability.BoxAiEvent;
import com.box.android.domain.models.observability.Gen204ItemStateKt;
import com.box.android.domain.models.observability.PreviewNavApdex;
import com.box.android.domain.models.observability.PreviewPM23Event;
import com.box.android.domain.models.preview.BoxAiActionEvent;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.domain.models.preview.PreviewerType;
import com.box.android.domain.services.ApdexService;
import com.box.android.domain.services.RumService;
import com.box.android.domain.usecases.observability.MetricsUseCase;
import com.box.android.domain.utils.MetricUtils;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: PreviewObservability.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 ?2\u00020\u0001:\u0002>?B+\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ*\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018J,\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0018\u0010\u001a\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0086@¢\u0006\u0002\u0010\u001bJ$\u0010\u001c\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0018H\u0086@¢\u0006\u0002\u0010\u001eJ,\u0010\u001f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010 \u001a\u00020!2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0018H\u0086@¢\u0006\u0002\u0010\"J\u0018\u0010#\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096@¢\u0006\u0002\u0010\u001bJ\u0018\u0010$\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096@¢\u0006\u0002\u0010\u001bJ\u0018\u0010%\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096@¢\u0006\u0002\u0010\u001bJ \u0010&\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010 \u001a\u00020!H\u0096@¢\u0006\u0002\u0010'J\u0018\u0010(\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0086@¢\u0006\u0002\u0010\u001bJ(\u0010)\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020,H\u0086@¢\u0006\u0002\u0010-J(\u0010.\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010*\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!H\u0086@¢\u0006\u0002\u0010/J,\u00100\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020302H\u0086@¢\u0006\u0002\u00104J \u00105\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u00106\u001a\u00020\u0012H\u0082@¢\u0006\u0002\u00107J(\u00108\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u00106\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!H\u0082@¢\u0006\u0002\u0010/J\u000e\u00109\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010:\u001a\u00020\u00102\u0006\u0010;\u001a\u00020\u000eH\u0002J \u0010<\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010+\u001a\u00020,H\u0082@¢\u0006\u0002\u0010=R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/box/android/domain/metrics/preview/PreviewObservability;", "Lcom/box/android/domain/metrics/preview/units/FileWithRepresentationsFetchObservability;", "metricsUseCase", "Lcom/box/android/domain/usecases/observability/MetricsUseCase;", "rumService", "Lcom/box/android/domain/services/RumService;", "apdexService", "Lcom/box/android/domain/services/ApdexService;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/box/android/domain/usecases/observability/MetricsUseCase;Lcom/box/android/domain/services/RumService;Lcom/box/android/domain/services/ApdexService;Lkotlinx/coroutines/CoroutineDispatcher;)V", "observabilityHandler", "Lcom/box/android/domain/metrics/ObservabilityProcessor;", "Lcom/box/android/domain/metrics/preview/PreviewObservabilityLaunchData;", "startPreviewMetricIfNotStarted", "", "observabilityId", "", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "previewSource", "Lcom/box/android/domain/models/preview/PreviewSource;", "startTime", "", "startPreviewMetric", "previewLoadingStarted", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendPreviewSuccess", "endTime", "(Ljava/lang/String;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendPreviewError", "error", "Lcom/box/android/domain/models/DomainError;", "(Ljava/lang/String;Lcom/box/android/domain/models/DomainError;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fileWithRepresentationsFetchStarted", "fileWithRepresentationsFetchSuccessRemote", "fileWithRepresentationsFetchSuccessCache", "fileWithRepresentationsFetchError", "(Ljava/lang/String;Lcom/box/android/domain/models/DomainError;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "previewFileDownloadStarted", "previewFileDownloadSuccess", "previewContentType", "loadingSource", "Lcom/box/android/domain/metrics/preview/PreviewObservability$LoadingSource;", "(Ljava/lang/String;Ljava/lang/String;Lcom/box/android/domain/metrics/preview/PreviewObservability$LoadingSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "previewFileDownloadError", "(Ljava/lang/String;Ljava/lang/String;Lcom/box/android/domain/models/DomainError;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePreviewMetric", "update", "Lkotlin/Function1;", "Lcom/box/android/domain/models/observability/PreviewPM23Event;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "endChildSpanAsSuccess", "operationName", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "endChildSpanWithError", "logBoxAiEnabledFilePreviewed", "sendEvent", "data", "fileWithRepresentationsFetchSuccess", "(Ljava/lang/String;Lcom/box/android/domain/metrics/preview/PreviewObservability$LoadingSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "LoadingSource", "Companion", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreviewObservability implements FileWithRepresentationsFetchObservability {
    public static final String CONTENT_FROM_LEGACY_CACHE = "LegacyCache";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String ORIGINAL_CONTENT_TYPE = "Original";
    public static final String PREVIEW_FAIL_EVENT_NAME = "preview_fail";
    private static final String PREVIEW_LOAD_EVENT_NAME = "PreviewLoad";
    public static final String PREVIEW_SUCCESS_PREFIX = "preview_tti";
    private static final String UNKNOWN_PREVIEWER_TYPE = "unknown";
    private final ApdexService apdexService;
    private final CoroutineDispatcher ioDispatcher;
    private final MetricsUseCase metricsUseCase;
    private final ObservabilityProcessor<PreviewObservabilityLaunchData> observabilityHandler;
    private final RumService rumService;

    /* JADX INFO: renamed from: com.box.android.domain.metrics.preview.PreviewObservability$endChildSpanAsSuccess$1, reason: invalid class name */
    /* JADX INFO: compiled from: PreviewObservability.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.metrics.preview.PreviewObservability", f = "PreviewObservability.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2}, l = {200, 201, 202}, m = "endChildSpanAsSuccess", n = {"observabilityId", "operationName", "childSpan", "observabilityId", "operationName", "childSpan", "observabilityId", "operationName", "childSpan"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 1)
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
            return PreviewObservability.this.endChildSpanAsSuccess(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.domain.metrics.preview.PreviewObservability$endChildSpanWithError$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PreviewObservability.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.metrics.preview.PreviewObservability", f = "PreviewObservability.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {BoxCommonConstants.REQUEST_DELETE, BoxCommonConstants.REQUEST_RENAME, 213}, m = "endChildSpanWithError", n = {"observabilityId", "operationName", "error", "childSpan", "observabilityId", "operationName", "error", "childSpan", "observabilityId", "operationName", "error", "childSpan"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class C15971 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C15971(Continuation<? super C15971> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreviewObservability.this.endChildSpanWithError(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.domain.metrics.preview.PreviewObservability$fileWithRepresentationsFetchStarted$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PreviewObservability.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.metrics.preview.PreviewObservability", f = "PreviewObservability.kt", i = {0, 1, 1, 1, 1, 2, 2}, l = {Token.LOCAL_BLOCK, Token.DOTQUERY, Token.XMLATTR}, m = "fileWithRepresentationsFetchStarted", n = {"observabilityId", "observabilityId", "spanId", "it", "$i$a$-let-PreviewObservability$fileWithRepresentationsFetchStarted$2", "observabilityId", "spanId"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1"}, v = 1)
    static final class C15981 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C15981(Continuation<? super C15981> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreviewObservability.this.fileWithRepresentationsFetchStarted(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.domain.metrics.preview.PreviewObservability$fileWithRepresentationsFetchSuccess$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PreviewObservability.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.metrics.preview.PreviewObservability", f = "PreviewObservability.kt", i = {0, 0, 1, 1, 1, 1}, l = {238, PsExtractor.VIDEO_STREAM_MASK}, m = "fileWithRepresentationsFetchSuccess", n = {"observabilityId", "loadingSource", "observabilityId", "loadingSource", "it", "$i$a$-let-PreviewObservability$fileWithRepresentationsFetchSuccess$2"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "I$0"}, v = 1)
    static final class C15991 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C15991(Continuation<? super C15991> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreviewObservability.this.fileWithRepresentationsFetchSuccess(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.domain.metrics.preview.PreviewObservability$previewFileDownloadStarted$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PreviewObservability.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.metrics.preview.PreviewObservability", f = "PreviewObservability.kt", i = {0, 1, 1, 1, 1, 2, 2}, l = {168, 173, 174}, m = "previewFileDownloadStarted", n = {"observabilityId", "observabilityId", "spanId", "it", "$i$a$-let-PreviewObservability$previewFileDownloadStarted$2", "observabilityId", "spanId"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1"}, v = 1)
    static final class C16011 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C16011(Continuation<? super C16011> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreviewObservability.this.previewFileDownloadStarted(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.domain.metrics.preview.PreviewObservability$previewFileDownloadSuccess$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PreviewObservability.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.metrics.preview.PreviewObservability", f = "PreviewObservability.kt", i = {0, 0, 0, 1, 1, 1, 1, 1}, l = {181, 182}, m = "previewFileDownloadSuccess", n = {"observabilityId", "previewContentType", "loadingSource", "observabilityId", "previewContentType", "loadingSource", "it", "$i$a$-let-PreviewObservability$previewFileDownloadSuccess$2"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
    static final class C16021 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C16021(Continuation<? super C16021> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreviewObservability.this.previewFileDownloadSuccess(null, null, null, this);
        }
    }

    @Inject
    public PreviewObservability(MetricsUseCase metricsUseCase, RumService rumService, ApdexService apdexService, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(metricsUseCase, "metricsUseCase");
        Intrinsics.checkNotNullParameter(rumService, "rumService");
        Intrinsics.checkNotNullParameter(apdexService, "apdexService");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.metricsUseCase = metricsUseCase;
        this.rumService = rumService;
        this.apdexService = apdexService;
        this.ioDispatcher = ioDispatcher;
        this.observabilityHandler = new ObservabilityProcessor<>(rumService, apdexService, new PreviewObservability$observabilityHandler$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object observabilityHandler$sendEvent(PreviewObservability previewObservability, PreviewObservabilityLaunchData previewObservabilityLaunchData, Continuation continuation) {
        previewObservability.sendEvent(previewObservabilityLaunchData);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void startPreviewMetricIfNotStarted$default(PreviewObservability previewObservability, String str, FileModel fileModel, PreviewSource previewSource, long j, int i, Object obj) {
        if ((i & 8) != 0) {
            j = System.currentTimeMillis();
        }
        previewObservability.startPreviewMetricIfNotStarted(str, fileModel, previewSource, j);
    }

    public final void startPreviewMetricIfNotStarted(String observabilityId, FileModel fileModel, PreviewSource previewSource, long startTime) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        Intrinsics.checkNotNullParameter(previewSource, "previewSource");
        if (observabilityId == null || this.observabilityHandler.hasData(observabilityId)) {
            return;
        }
        startPreviewMetric(fileModel, previewSource, startTime, observabilityId);
    }

    public static /* synthetic */ String startPreviewMetric$default(PreviewObservability previewObservability, FileModel fileModel, PreviewSource previewSource, long j, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            j = System.currentTimeMillis();
        }
        long j2 = j;
        if ((i & 8) != 0) {
            str = UUID.randomUUID().toString();
        }
        return previewObservability.startPreviewMetric(fileModel, previewSource, j2, str);
    }

    public final String startPreviewMetric(FileModel fileModel, PreviewSource previewSource, long startTime, String observabilityId) {
        List listEmptyList;
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        Intrinsics.checkNotNullParameter(previewSource, "previewSource");
        if (observabilityId == null) {
            return "";
        }
        String string = fileModel.getItemId().toString();
        String extension = fileModel.getExtension();
        Double dConvertBytesToKBytes = MetricUtils.INSTANCE.convertBytesToKBytes(fileModel.getSize());
        String strConvertBytesToBucket = MetricUtils.INSTANCE.convertBytesToBucket(fileModel.getSize());
        String gen204ItemState = Gen204ItemStateKt.getGen204ItemState(fileModel);
        if (gen204ItemState == null || (listEmptyList = CollectionsKt.listOf(gen204ItemState)) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        return this.observabilityHandler.launchMetric(new PreviewObservabilityLaunchData(new PreviewPM23Event(string, null, extension, false, previewSource, null, null, null, dConvertBytesToKBytes, strConvertBytesToBucket, null, null, listEmptyList, null, null, 24576, null), startTime, null, 4, null), observabilityId);
    }

    public final Object previewLoadingStarted(String str, Continuation<? super Unit> continuation) {
        Object objSendOnLoadingStarted = this.observabilityHandler.sendOnLoadingStarted(str, PREVIEW_LOAD_EVENT_NAME, PreviewNavApdex.INSTANCE, continuation);
        return objSendOnLoadingStarted == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSendOnLoadingStarted : Unit.INSTANCE;
    }

    public static /* synthetic */ Object sendPreviewSuccess$default(PreviewObservability previewObservability, String str, Long l, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        return previewObservability.sendPreviewSuccess(str, l, continuation);
    }

    public final Object sendPreviewSuccess(String str, final Long l, Continuation<? super Unit> continuation) {
        Object objSendSuccessEvent = this.observabilityHandler.sendSuccessEvent(str, new Function1() { // from class: com.box.android.domain.metrics.preview.PreviewObservability$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PreviewObservability.sendPreviewSuccess$lambda$0(l, (PreviewObservabilityLaunchData) obj);
            }
        }, new Function1() { // from class: com.box.android.domain.metrics.preview.PreviewObservability$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PreviewObservability.sendPreviewSuccess$lambda$1((PreviewObservabilityLaunchData) obj);
            }
        }, new Function1() { // from class: com.box.android.domain.metrics.preview.PreviewObservability$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PreviewObservability.sendPreviewSuccess$lambda$2((PreviewObservabilityLaunchData) obj);
            }
        }, continuation);
        return objSendSuccessEvent == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSendSuccessEvent : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PreviewObservabilityLaunchData sendPreviewSuccess$lambda$0(Long l, PreviewObservabilityLaunchData current) {
        Intrinsics.checkNotNullParameter(current, "current");
        PreviewPM23Event event = current.getEvent();
        return PreviewObservabilityLaunchData.copy$default(current, event.copy((30551 & 1) != 0 ? event.fileId : null, (30551 & 2) != 0 ? event.previewerType : null, (30551 & 4) != 0 ? event.extension : null, (30551 & 8) != 0 ? event.failed : false, (30551 & 16) != 0 ? event.previewSource : null, (30551 & 32) != 0 ? event.failReason : null, (30551 & 64) != 0 ? event.errorCode : null, (30551 & 128) != 0 ? event.errorMessage : null, (30551 & 256) != 0 ? event.sizeKB : null, (30551 & 512) != 0 ? event.sizeBucket : null, (30551 & 1024) != 0 ? event.loadedFromCache : null, (30551 & 2048) != 0 ? event.ttiMs : Long.valueOf((l != null ? l.longValue() : System.currentTimeMillis()) - current.getStartTime()), (30551 & 4096) != 0 ? event.itemState : null, (30551 & 8192) != 0 ? event.device : null, (30551 & 16384) != 0 ? event.user : null), 0L, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String sendPreviewSuccess$lambda$1(PreviewObservabilityLaunchData current) {
        Intrinsics.checkNotNullParameter(current, "current");
        return "preview_tti_" + INSTANCE.toObservabilityString(current.getEvent().getPreviewerType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String sendPreviewSuccess$lambda$2(PreviewObservabilityLaunchData current) {
        Intrinsics.checkNotNullParameter(current, "current");
        return LoadingSource.INSTANCE.fromLoadedFromCache(current.getEvent().getLoadedFromCache()).toString();
    }

    public static /* synthetic */ Object sendPreviewError$default(PreviewObservability previewObservability, String str, DomainError domainError, Long l, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            l = null;
        }
        return previewObservability.sendPreviewError(str, domainError, l, continuation);
    }

    public final Object sendPreviewError(String str, DomainError domainError, final Long l, Continuation<? super Unit> continuation) {
        Object objSendErrorEvent = this.observabilityHandler.sendErrorEvent(str, domainError, PREVIEW_FAIL_EVENT_NAME, new Function2() { // from class: com.box.android.domain.metrics.preview.PreviewObservability$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return PreviewObservability.sendPreviewError$lambda$0(l, (PreviewObservabilityLaunchData) obj, (DomainError) obj2);
            }
        }, continuation);
        return objSendErrorEvent == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSendErrorEvent : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PreviewObservabilityLaunchData sendPreviewError$lambda$0(Long l, PreviewObservabilityLaunchData current, DomainError err) {
        Intrinsics.checkNotNullParameter(current, "current");
        Intrinsics.checkNotNullParameter(err, "err");
        PreviewPM23Event event = current.getEvent();
        return PreviewObservabilityLaunchData.copy$default(current, event.copy((30551 & 1) != 0 ? event.fileId : null, (30551 & 2) != 0 ? event.previewerType : null, (30551 & 4) != 0 ? event.extension : null, (30551 & 8) != 0 ? event.failed : true, (30551 & 16) != 0 ? event.previewSource : null, (30551 & 32) != 0 ? event.failReason : err.getSimpleClassName(), (30551 & 64) != 0 ? event.errorCode : null, (30551 & 128) != 0 ? event.errorMessage : err.getMessage(), (30551 & 256) != 0 ? event.sizeKB : null, (30551 & 512) != 0 ? event.sizeBucket : null, (30551 & 1024) != 0 ? event.loadedFromCache : null, (30551 & 2048) != 0 ? event.ttiMs : Long.valueOf((l != null ? l.longValue() : System.currentTimeMillis()) - current.getStartTime()), (30551 & 4096) != 0 ? event.itemState : null, (30551 & 8192) != 0 ? event.device : null, (30551 & 16384) != 0 ? event.user : null), 0L, null, 6, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c7, code lost:
    
        if (r13.updateLaunchData(r3, r15, r8) == r0) goto L33;
     */
    @Override // com.box.android.domain.metrics.preview.units.FileWithRepresentationsFetchObservability
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object fileWithRepresentationsFetchStarted(java.lang.String r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.domain.metrics.preview.PreviewObservability.fileWithRepresentationsFetchStarted(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PreviewObservabilityLaunchData fileWithRepresentationsFetchStarted$lambda$1(String str, PreviewObservabilityLaunchData current) {
        Intrinsics.checkNotNullParameter(current, "current");
        return PreviewObservabilityLaunchData.copy$default(current, null, 0L, str, 3, null);
    }

    @Override // com.box.android.domain.metrics.preview.units.FileWithRepresentationsFetchObservability
    public Object fileWithRepresentationsFetchSuccessRemote(String str, Continuation<? super Unit> continuation) {
        Object objFileWithRepresentationsFetchSuccess = fileWithRepresentationsFetchSuccess(str, LoadingSource.REMOTE, continuation);
        return objFileWithRepresentationsFetchSuccess == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objFileWithRepresentationsFetchSuccess : Unit.INSTANCE;
    }

    @Override // com.box.android.domain.metrics.preview.units.FileWithRepresentationsFetchObservability
    public Object fileWithRepresentationsFetchSuccessCache(String str, Continuation<? super Unit> continuation) {
        Object objFileWithRepresentationsFetchSuccess = fileWithRepresentationsFetchSuccess(str, LoadingSource.CACHE, continuation);
        return objFileWithRepresentationsFetchSuccess == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objFileWithRepresentationsFetchSuccess : Unit.INSTANCE;
    }

    @Override // com.box.android.domain.metrics.preview.units.FileWithRepresentationsFetchObservability
    public Object fileWithRepresentationsFetchError(String str, DomainError domainError, Continuation<? super Unit> continuation) {
        Object objEndChildSpanWithError = endChildSpanWithError(str, "File info with representations fetch error", domainError, continuation);
        return objEndChildSpanWithError == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEndChildSpanWithError : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c7, code lost:
    
        if (r13.updateLaunchData(r3, r15, r8) == r0) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object previewFileDownloadStarted(java.lang.String r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.domain.metrics.preview.PreviewObservability.previewFileDownloadStarted(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PreviewObservabilityLaunchData previewFileDownloadStarted$lambda$1(String str, PreviewObservabilityLaunchData current) {
        Intrinsics.checkNotNullParameter(current, "current");
        return PreviewObservabilityLaunchData.copy$default(current, null, 0L, str, 3, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00ba, code lost:
    
        if (com.box.android.domain.services.ApdexService.addMilestone$default(r1, r8, r3, null, r5, 4, null) == r0) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object previewFileDownloadSuccess(java.lang.String r9, java.lang.String r10, com.box.android.domain.metrics.preview.PreviewObservability.LoadingSource r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r8 = this;
            boolean r0 = r12 instanceof com.box.android.domain.metrics.preview.PreviewObservability.C16021
            if (r0 == 0) goto L14
            r0 = r12
            com.box.android.domain.metrics.preview.PreviewObservability$previewFileDownloadSuccess$1 r0 = (com.box.android.domain.metrics.preview.PreviewObservability.C16021) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            com.box.android.domain.metrics.preview.PreviewObservability$previewFileDownloadSuccess$1 r0 = new com.box.android.domain.metrics.preview.PreviewObservability$previewFileDownloadSuccess$1
            r0.<init>(r12)
        L19:
            r5 = r0
            java.lang.Object r12 = r5.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L5b
            if (r1 == r3) goto L49
            if (r1 != r2) goto L41
            int r8 = r5.I$0
            java.lang.Object r8 = r5.L$3
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r8 = r5.L$2
            com.box.android.domain.metrics.preview.PreviewObservability$LoadingSource r8 = (com.box.android.domain.metrics.preview.PreviewObservability.LoadingSource) r8
            java.lang.Object r8 = r5.L$1
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r8 = r5.L$0
            java.lang.String r8 = (java.lang.String) r8
            kotlin.ResultKt.throwOnFailure(r12)
            goto Lbd
        L41:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L49:
            java.lang.Object r9 = r5.L$2
            r11 = r9
            com.box.android.domain.metrics.preview.PreviewObservability$LoadingSource r11 = (com.box.android.domain.metrics.preview.PreviewObservability.LoadingSource) r11
            java.lang.Object r9 = r5.L$1
            r10 = r9
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r9 = r5.L$0
            java.lang.String r9 = (java.lang.String) r9
            kotlin.ResultKt.throwOnFailure(r12)
            goto L8c
        L5b:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.StringBuilder r12 = r12.append(r10)
            java.lang.String r1 = " fetched from "
            java.lang.StringBuilder r12 = r12.append(r1)
            java.lang.StringBuilder r12 = r12.append(r11)
            java.lang.String r12 = r12.toString()
            r5.L$0 = r9
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r5.L$1 = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r5.L$2 = r1
            r5.label = r3
            java.lang.Object r12 = r8.endChildSpanAsSuccess(r9, r12, r5)
            if (r12 != r0) goto L8c
            goto Lbc
        L8c:
            r3 = r9
            if (r3 == 0) goto Lbd
            com.box.android.domain.services.ApdexService r1 = r8.apdexService
            com.box.android.domain.models.observability.PreviewNavApdex$FileDownloadEnded r8 = com.box.android.domain.models.observability.PreviewNavApdex.FileDownloadEnded.INSTANCE
            com.box.android.domain.models.observability.ApdexType$Milestone r8 = (com.box.android.domain.models.observability.ApdexType.Milestone) r8
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r5.L$0 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r5.L$1 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r5.L$2 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r5.L$3 = r9
            r9 = 0
            r5.I$0 = r9
            r5.label = r2
            r4 = 0
            r6 = 4
            r7 = 0
            r2 = r8
            java.lang.Object r8 = com.box.android.domain.services.ApdexService.addMilestone$default(r1, r2, r3, r4, r5, r6, r7)
            if (r8 != r0) goto Lbd
        Lbc:
            return r0
        Lbd:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.domain.metrics.preview.PreviewObservability.previewFileDownloadSuccess(java.lang.String, java.lang.String, com.box.android.domain.metrics.preview.PreviewObservability$LoadingSource, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object previewFileDownloadError(String str, String str2, DomainError domainError, Continuation<? super Unit> continuation) {
        Object objEndChildSpanWithError = endChildSpanWithError(str, str2 + " fetch error", domainError, continuation);
        return objEndChildSpanWithError == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEndChildSpanWithError : Unit.INSTANCE;
    }

    public final Object updatePreviewMetric(String str, final Function1<? super PreviewPM23Event, PreviewPM23Event> function1, Continuation<? super Unit> continuation) {
        Object objUpdateLaunchData = this.observabilityHandler.updateLaunchData(str, new Function1() { // from class: com.box.android.domain.metrics.preview.PreviewObservability$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PreviewObservability.updatePreviewMetric$lambda$0(function1, (PreviewObservabilityLaunchData) obj);
            }
        }, continuation);
        return objUpdateLaunchData == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdateLaunchData : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PreviewObservabilityLaunchData updatePreviewMetric$lambda$0(Function1 function1, PreviewObservabilityLaunchData current) {
        Intrinsics.checkNotNullParameter(current, "current");
        return PreviewObservabilityLaunchData.copy$default(current, (PreviewPM23Event) function1.invoke(current.getEvent()), 0L, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c9, code lost:
    
        if (r7.updateLaunchData(r2, r10, r0) == r1) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object endChildSpanAsSuccess(java.lang.String r8, java.lang.String r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.domain.metrics.preview.PreviewObservability.endChildSpanAsSuccess(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PreviewObservabilityLaunchData endChildSpanAsSuccess$lambda$0(PreviewObservabilityLaunchData current) {
        Intrinsics.checkNotNullParameter(current, "current");
        return PreviewObservabilityLaunchData.copy$default(current, null, 0L, null, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00e7, code lost:
    
        if (r8.updateLaunchData(r2, r12, r0) == r1) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object endChildSpanWithError(java.lang.String r9, java.lang.String r10, com.box.android.domain.models.DomainError r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            Method dump skipped, instruction units count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.domain.metrics.preview.PreviewObservability.endChildSpanWithError(java.lang.String, java.lang.String, com.box.android.domain.models.DomainError, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PreviewObservabilityLaunchData endChildSpanWithError$lambda$0(PreviewObservabilityLaunchData current) {
        Intrinsics.checkNotNullParameter(current, "current");
        return PreviewObservabilityLaunchData.copy$default(current, null, 0L, null, 3, null);
    }

    /* JADX INFO: renamed from: com.box.android.domain.metrics.preview.PreviewObservability$logBoxAiEnabledFilePreviewed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PreviewObservability.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.metrics.preview.PreviewObservability$logBoxAiEnabledFilePreviewed$1", f = "PreviewObservability.kt", i = {}, l = {221}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C16001 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FileModel $fileModel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C16001(FileModel fileModel, Continuation<? super C16001> continuation) {
            super(2, continuation);
            this.$fileModel = fileModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PreviewObservability.this.new C16001(this.$fileModel, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C16001) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PreviewObservability.this.metricsUseCase.log(new BoxAiEvent(BoxAiActionEvent.AiEnabledFilePreview.INSTANCE, SetsKt.setOf(this.$fileModel.getExtension()), Boxing.boxInt(1), null, null, 24, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void logBoxAiEnabledFilePreviewed(FileModel fileModel) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.ioDispatcher), null, null, new C16001(fileModel, null), 3, null);
    }

    /* JADX INFO: renamed from: com.box.android.domain.metrics.preview.PreviewObservability$sendEvent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PreviewObservability.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.metrics.preview.PreviewObservability$sendEvent$1", f = "PreviewObservability.kt", i = {}, l = {233}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C16031 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PreviewObservabilityLaunchData $data;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C16031(PreviewObservabilityLaunchData previewObservabilityLaunchData, Continuation<? super C16031> continuation) {
            super(2, continuation);
            this.$data = previewObservabilityLaunchData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PreviewObservability.this.new C16031(this.$data, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C16031) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PreviewObservability.this.metricsUseCase.log(this.$data.getEvent(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    private final void sendEvent(PreviewObservabilityLaunchData data) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.ioDispatcher), null, null, new C16031(data, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x009c, code lost:
    
        if (com.box.android.domain.services.ApdexService.addMilestone$default(r1, r8, r3, null, r5, 4, null) == r0) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object fileWithRepresentationsFetchSuccess(java.lang.String r9, com.box.android.domain.metrics.preview.PreviewObservability.LoadingSource r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.box.android.domain.metrics.preview.PreviewObservability.C15991
            if (r0 == 0) goto L14
            r0 = r11
            com.box.android.domain.metrics.preview.PreviewObservability$fileWithRepresentationsFetchSuccess$1 r0 = (com.box.android.domain.metrics.preview.PreviewObservability.C15991) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.box.android.domain.metrics.preview.PreviewObservability$fileWithRepresentationsFetchSuccess$1 r0 = new com.box.android.domain.metrics.preview.PreviewObservability$fileWithRepresentationsFetchSuccess$1
            r0.<init>(r11)
        L19:
            r5 = r0
            java.lang.Object r11 = r5.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L51
            if (r1 == r3) goto L44
            if (r1 != r2) goto L3c
            int r8 = r5.I$0
            java.lang.Object r8 = r5.L$2
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r8 = r5.L$1
            com.box.android.domain.metrics.preview.PreviewObservability$LoadingSource r8 = (com.box.android.domain.metrics.preview.PreviewObservability.LoadingSource) r8
            java.lang.Object r8 = r5.L$0
            java.lang.String r8 = (java.lang.String) r8
            kotlin.ResultKt.throwOnFailure(r11)
            goto L9f
        L3c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L44:
            java.lang.Object r9 = r5.L$1
            r10 = r9
            com.box.android.domain.metrics.preview.PreviewObservability$LoadingSource r10 = (com.box.android.domain.metrics.preview.PreviewObservability.LoadingSource) r10
            java.lang.Object r9 = r5.L$0
            java.lang.String r9 = (java.lang.String) r9
            kotlin.ResultKt.throwOnFailure(r11)
            goto L74
        L51:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r1 = "File info with representations fetch from "
            r11.<init>(r1)
            java.lang.StringBuilder r11 = r11.append(r10)
            java.lang.String r11 = r11.toString()
            r5.L$0 = r9
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r5.L$1 = r1
            r5.label = r3
            java.lang.Object r11 = r8.endChildSpanAsSuccess(r9, r11, r5)
            if (r11 != r0) goto L74
            goto L9e
        L74:
            r3 = r9
            if (r3 == 0) goto L9f
            com.box.android.domain.services.ApdexService r1 = r8.apdexService
            com.box.android.domain.models.observability.PreviewNavApdex$FileInfoRepresentationFetchEnded r8 = com.box.android.domain.models.observability.PreviewNavApdex.FileInfoRepresentationFetchEnded.INSTANCE
            com.box.android.domain.models.observability.ApdexType$Milestone r8 = (com.box.android.domain.models.observability.ApdexType.Milestone) r8
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r5.L$0 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r5.L$1 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r5.L$2 = r9
            r9 = 0
            r5.I$0 = r9
            r5.label = r2
            r4 = 0
            r6 = 4
            r7 = 0
            r2 = r8
            java.lang.Object r8 = com.box.android.domain.services.ApdexService.addMilestone$default(r1, r2, r3, r4, r5, r6, r7)
            if (r8 != r0) goto L9f
        L9e:
            return r0
        L9f:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.domain.metrics.preview.PreviewObservability.fileWithRepresentationsFetchSuccess(java.lang.String, com.box.android.domain.metrics.preview.PreviewObservability$LoadingSource, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: compiled from: PreviewObservability.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\n"}, d2 = {"Lcom/box/android/domain/metrics/preview/PreviewObservability$LoadingSource;", "", "<init>", "(Ljava/lang/String;I)V", "CACHE", "REMOTE", "UNKNOWN", "toString", "", "Companion", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum LoadingSource {
        CACHE,
        REMOTE,
        UNKNOWN;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        public static EnumEntries<LoadingSource> getEntries() {
            return $ENTRIES;
        }

        @Override // java.lang.Enum
        public String toString() {
            String lowerCase = name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            return lowerCase;
        }

        /* JADX INFO: compiled from: PreviewObservability.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/box/android/domain/metrics/preview/PreviewObservability$LoadingSource$Companion;", "", "<init>", "()V", "fromLoadedFromCache", "Lcom/box/android/domain/metrics/preview/PreviewObservability$LoadingSource;", "loadedFromCache", "", "(Ljava/lang/Boolean;)Lcom/box/android/domain/metrics/preview/PreviewObservability$LoadingSource;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final LoadingSource fromLoadedFromCache(Boolean loadedFromCache) {
                if (Intrinsics.areEqual((Object) loadedFromCache, (Object) true)) {
                    return LoadingSource.CACHE;
                }
                return Intrinsics.areEqual((Object) loadedFromCache, (Object) false) ? LoadingSource.REMOTE : LoadingSource.UNKNOWN;
            }
        }
    }

    /* JADX INFO: compiled from: PreviewObservability.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u000b\u001a\u00020\u0005*\u00020\fJ\f\u0010\r\u001a\u00020\u0005*\u0004\u0018\u00010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/box/android/domain/metrics/preview/PreviewObservability$Companion;", "", "<init>", "()V", "ORIGINAL_CONTENT_TYPE", "", "CONTENT_FROM_LEGACY_CACHE", "PREVIEW_SUCCESS_PREFIX", "PREVIEW_FAIL_EVENT_NAME", "PREVIEW_LOAD_EVENT_NAME", "UNKNOWN_PREVIEWER_TYPE", "toPreviewContentType", "Lcom/box/android/domain/models/RepresentationModel;", "toObservabilityString", "Lcom/box/android/domain/models/preview/PreviewerType;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String toPreviewContentType(RepresentationModel representationModel) {
            Intrinsics.checkNotNullParameter(representationModel, "<this>");
            return "Representation " + representationModel.getRepresentationType();
        }

        public final String toObservabilityString(PreviewerType previewerType) {
            String strName;
            if (previewerType == null || (strName = previewerType.name()) == null) {
                return "unknown";
            }
            String lowerCase = strName.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            return lowerCase == null ? "unknown" : lowerCase;
        }
    }
}
