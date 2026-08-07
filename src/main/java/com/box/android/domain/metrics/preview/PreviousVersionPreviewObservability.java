package com.box.android.domain.metrics.preview;

import com.box.android.domain.metrics.ObservabilityProcessor;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.observability.PreviewNavApdex;
import com.box.android.domain.models.observability.PreviousVersionPreviewPM23Event;
import com.box.android.domain.models.preview.PreviewerType;
import com.box.android.domain.services.ApdexService;
import com.box.android.domain.services.RumService;
import com.box.android.domain.usecases.observability.MetricsUseCase;
import java.util.UUID;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: PreviousVersionPreviewObservability.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(B+\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ*\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0010J \u0010\u0018\u001a\u00020\u00192\b\u0010\u0017\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001a\u001a\u00020\u001bH\u0086@¢\u0006\u0002\u0010\u001cJ$\u0010\u001d\u001a\u00020\u00192\b\u0010\u0017\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0016H\u0086@¢\u0006\u0002\u0010\u001fJ,\u0010 \u001a\u00020\u00192\b\u0010\u0017\u001a\u0004\u0018\u00010\u00102\u0006\u0010!\u001a\u00020\"2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0016H\u0086@¢\u0006\u0002\u0010#J\u0018\u0010$\u001a\u00020\u00192\b\u0010\u0017\u001a\u0004\u0018\u00010\u0010H\u0086@¢\u0006\u0002\u0010%J\u0010\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/box/android/domain/metrics/preview/PreviousVersionPreviewObservability;", "", "metricsUseCase", "Lcom/box/android/domain/usecases/observability/MetricsUseCase;", "apdexService", "Lcom/box/android/domain/services/ApdexService;", "rumService", "Lcom/box/android/domain/services/RumService;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/box/android/domain/usecases/observability/MetricsUseCase;Lcom/box/android/domain/services/ApdexService;Lcom/box/android/domain/services/RumService;Lkotlinx/coroutines/CoroutineDispatcher;)V", "observabilityHandler", "Lcom/box/android/domain/metrics/ObservabilityProcessor;", "Lcom/box/android/domain/metrics/preview/PreviousVersionObservabilityLaunchData;", "startPreviewMetric", "", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "versionNumber", "", "startTime", "", "observabilityId", "updatePreviewerType", "", "previewerType", "Lcom/box/android/domain/models/preview/PreviewerType;", "(Ljava/lang/String;Lcom/box/android/domain/models/preview/PreviewerType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendPreviewSuccess", "endTime", "(Ljava/lang/String;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendPreviewError", "error", "Lcom/box/android/domain/models/DomainError;", "(Ljava/lang/String;Lcom/box/android/domain/models/DomainError;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "previewLoadingStarted", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendEvent", "data", "Companion", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreviousVersionPreviewObservability {
    private static final String LOAD_EVENT_NAME = "PreviousVersionPreviewLoaded";
    private static final String PREVIEW_FAIL_EVENT_NAME = "previous_version_fail";
    private static final String PREVIEW_SUCCESS_PREFIX = "previous_version_tti";
    private final CoroutineDispatcher ioDispatcher;
    private final MetricsUseCase metricsUseCase;
    private final ObservabilityProcessor<PreviousVersionObservabilityLaunchData> observabilityHandler;

    @Inject
    public PreviousVersionPreviewObservability(MetricsUseCase metricsUseCase, ApdexService apdexService, RumService rumService, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(metricsUseCase, "metricsUseCase");
        Intrinsics.checkNotNullParameter(apdexService, "apdexService");
        Intrinsics.checkNotNullParameter(rumService, "rumService");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.metricsUseCase = metricsUseCase;
        this.ioDispatcher = ioDispatcher;
        this.observabilityHandler = new ObservabilityProcessor<>(rumService, apdexService, new PreviousVersionPreviewObservability$observabilityHandler$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object observabilityHandler$sendEvent(PreviousVersionPreviewObservability previousVersionPreviewObservability, PreviousVersionObservabilityLaunchData previousVersionObservabilityLaunchData, Continuation continuation) {
        previousVersionPreviewObservability.sendEvent(previousVersionObservabilityLaunchData);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ String startPreviewMetric$default(PreviousVersionPreviewObservability previousVersionPreviewObservability, FileModel fileModel, int i, long j, String str, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            j = System.currentTimeMillis();
        }
        long j2 = j;
        if ((i2 & 8) != 0) {
            str = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
        }
        return previousVersionPreviewObservability.startPreviewMetric(fileModel, i, j2, str);
    }

    public final String startPreviewMetric(FileModel fileModel, int versionNumber, long startTime, String observabilityId) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        Intrinsics.checkNotNullParameter(observabilityId, "observabilityId");
        return this.observabilityHandler.launchMetric(new PreviousVersionObservabilityLaunchData(new PreviousVersionPreviewPM23Event(fileModel.getItemId().toString(), null, false, versionNumber, null, null, null, null, null, null, 896, null), startTime), observabilityId);
    }

    public final Object updatePreviewerType(String str, final PreviewerType previewerType, Continuation<? super Unit> continuation) {
        Object objUpdateLaunchData = this.observabilityHandler.updateLaunchData(str, new Function1() { // from class: com.box.android.domain.metrics.preview.PreviousVersionPreviewObservability$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PreviousVersionPreviewObservability.updatePreviewerType$lambda$0(previewerType, (PreviousVersionObservabilityLaunchData) obj);
            }
        }, continuation);
        return objUpdateLaunchData == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdateLaunchData : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PreviousVersionObservabilityLaunchData updatePreviewerType$lambda$0(PreviewerType previewerType, PreviousVersionObservabilityLaunchData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return PreviousVersionObservabilityLaunchData.copy$default(data, PreviousVersionPreviewPM23Event.copy$default(data.getEvent(), null, previewerType, false, 0, null, null, null, null, null, null, 1021, null), 0L, 2, null);
    }

    public static /* synthetic */ Object sendPreviewSuccess$default(PreviousVersionPreviewObservability previousVersionPreviewObservability, String str, Long l, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        return previousVersionPreviewObservability.sendPreviewSuccess(str, l, continuation);
    }

    public final Object sendPreviewSuccess(String str, final Long l, Continuation<? super Unit> continuation) {
        Object objSendSuccessEvent$default = ObservabilityProcessor.sendSuccessEvent$default(this.observabilityHandler, str, new Function1() { // from class: com.box.android.domain.metrics.preview.PreviousVersionPreviewObservability$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PreviousVersionPreviewObservability.sendPreviewSuccess$lambda$0(l, (PreviousVersionObservabilityLaunchData) obj);
            }
        }, new Function1() { // from class: com.box.android.domain.metrics.preview.PreviousVersionPreviewObservability$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PreviousVersionPreviewObservability.sendPreviewSuccess$lambda$1((PreviousVersionObservabilityLaunchData) obj);
            }
        }, null, continuation, 8, null);
        return objSendSuccessEvent$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSendSuccessEvent$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PreviousVersionObservabilityLaunchData sendPreviewSuccess$lambda$0(Long l, PreviousVersionObservabilityLaunchData current) {
        Intrinsics.checkNotNullParameter(current, "current");
        return PreviousVersionObservabilityLaunchData.copy$default(current, PreviousVersionPreviewPM23Event.copy$default(current.getEvent(), null, null, false, 0, null, null, null, null, null, Long.valueOf((l != null ? l.longValue() : System.currentTimeMillis()) - current.getStartTime()), 507, null), 0L, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String sendPreviewSuccess$lambda$1(PreviousVersionObservabilityLaunchData current) {
        Intrinsics.checkNotNullParameter(current, "current");
        return "previous_version_tti_" + PreviewObservability.INSTANCE.toObservabilityString(current.getEvent().getPreviewerType());
    }

    public static /* synthetic */ Object sendPreviewError$default(PreviousVersionPreviewObservability previousVersionPreviewObservability, String str, DomainError domainError, Long l, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            l = null;
        }
        return previousVersionPreviewObservability.sendPreviewError(str, domainError, l, continuation);
    }

    public final Object sendPreviewError(String str, DomainError domainError, final Long l, Continuation<? super Unit> continuation) {
        Object objSendErrorEvent = this.observabilityHandler.sendErrorEvent(str, domainError, PREVIEW_FAIL_EVENT_NAME, new Function2() { // from class: com.box.android.domain.metrics.preview.PreviousVersionPreviewObservability$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return PreviousVersionPreviewObservability.sendPreviewError$lambda$0(l, (PreviousVersionObservabilityLaunchData) obj, (DomainError) obj2);
            }
        }, continuation);
        return objSendErrorEvent == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSendErrorEvent : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PreviousVersionObservabilityLaunchData sendPreviewError$lambda$0(Long l, PreviousVersionObservabilityLaunchData current, DomainError err) {
        Intrinsics.checkNotNullParameter(current, "current");
        Intrinsics.checkNotNullParameter(err, "err");
        return PreviousVersionObservabilityLaunchData.copy$default(current, PreviousVersionPreviewPM23Event.copy$default(current.getEvent(), null, null, true, 0, err.getSimpleClassName(), null, err.getMessage(), null, null, Long.valueOf((l != null ? l.longValue() : System.currentTimeMillis()) - current.getStartTime()), 427, null), 0L, 2, null);
    }

    public final Object previewLoadingStarted(String str, Continuation<? super Unit> continuation) {
        Object objSendOnLoadingStarted = this.observabilityHandler.sendOnLoadingStarted(str, LOAD_EVENT_NAME, PreviewNavApdex.INSTANCE, continuation);
        return objSendOnLoadingStarted == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSendOnLoadingStarted : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.box.android.domain.metrics.preview.PreviousVersionPreviewObservability$sendEvent$1, reason: invalid class name */
    /* JADX INFO: compiled from: PreviousVersionPreviewObservability.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.metrics.preview.PreviousVersionPreviewObservability$sendEvent$1", f = "PreviousVersionPreviewObservability.kt", i = {}, l = {108}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PreviousVersionObservabilityLaunchData $data;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PreviousVersionObservabilityLaunchData previousVersionObservabilityLaunchData, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$data = previousVersionObservabilityLaunchData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PreviousVersionPreviewObservability.this.new AnonymousClass1(this.$data, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PreviousVersionPreviewObservability.this.metricsUseCase.log(this.$data.getEvent(), this) == coroutine_suspended) {
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

    private final void sendEvent(PreviousVersionObservabilityLaunchData data) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.ioDispatcher), null, null, new AnonymousClass1(data, null), 3, null);
    }
}
