package com.box.android.domain.metrics.hubs;

import android.os.SystemClock;
import com.box.android.domain.metrics.ObservabilityProcessor;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemsScreenMode;
import com.box.android.domain.models.hubs.HubsDirection;
import com.box.android.domain.models.hubs.HubsSort;
import com.box.android.domain.models.observability.Gen204Event;
import com.box.android.domain.models.observability.HubAssetApdex;
import com.box.android.domain.models.observability.HubAssetLoadingEvent;
import com.box.android.domain.models.observability.HubEvent;
import com.box.android.domain.models.observability.HubListLoadingEvent;
import com.box.android.domain.models.observability.HubsListApdex;
import com.box.android.domain.services.ApdexService;
import com.box.android.domain.services.RumService;
import com.box.android.domain.usecases.observability.MetricsUseCase;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.Locale;
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

/* JADX INFO: compiled from: HubsObservability.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B+\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010\u001bJ \u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010\u001eJ\u001e\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!H\u0086@¢\u0006\u0002\u0010\"J(\u0010#\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u00122\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010%J \u0010&\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010\u001eJ\u001e\u0010'\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!H\u0086@¢\u0006\u0002\u0010\"J\u0010\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/box/android/domain/metrics/hubs/HubsObservability;", "", "metricsUseCase", "Lcom/box/android/domain/usecases/observability/MetricsUseCase;", "rumService", "Lcom/box/android/domain/services/RumService;", "apdexService", "Lcom/box/android/domain/services/ApdexService;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/box/android/domain/usecases/observability/MetricsUseCase;Lcom/box/android/domain/services/RumService;Lcom/box/android/domain/services/ApdexService;Lkotlinx/coroutines/CoroutineDispatcher;)V", "observabilityHandler", "Lcom/box/android/domain/metrics/ObservabilityProcessor;", "Lcom/box/android/domain/metrics/hubs/HubsObservabilityLaunchData;", "hubListLoadingStarted", "", "observabilityId", "", "hubsDirection", "Lcom/box/android/domain/models/hubs/HubsDirection;", "hubsSort", "Lcom/box/android/domain/models/hubs/HubsSort;", "itemsScreenMode", "Lcom/box/android/domain/models/ItemsScreenMode;", "startTime", "", "(Ljava/lang/String;Lcom/box/android/domain/models/hubs/HubsDirection;Lcom/box/android/domain/models/hubs/HubsSort;Lcom/box/android/domain/models/ItemsScreenMode;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendHubListFetchSuccess", "endTime", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendHubListFetchError", "error", "Lcom/box/android/domain/models/DomainError;", "(Ljava/lang/String;Lcom/box/android/domain/models/DomainError;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hubAssetLoadingStarted", "assetType", "(Ljava/lang/String;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendHubAssetFetchSuccess", "sendHubAssetFetchFailure", "sendEvent", "event", "Companion", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HubsObservability {
    public static final String HUB_ASSET_BANNER = "banner";
    public static final String HUB_ASSET_FETCH_EVENT = "hub_asset_fetch_event";
    public static final String HUB_ASSET_FETCH_FAILURE = "hub_asset_fetch_failure";
    public static final String HUB_ASSET_FETCH_SUCCESS = "hub_asset_fetch_tti";
    public static final String HUB_ASSET_ICON = "icon";
    public static final String HUB_LIST_FETCH_EVENT = "hub_list_fetch_event";
    public static final String HUB_LIST_FETCH_FAILURE = "hub_list_fetch_failed";
    public static final String HUB_LIST_FETCH_SUCCESS = "hub_list_fetch_tti";
    private final ApdexService apdexService;
    private final CoroutineDispatcher ioDispatcher;
    private final MetricsUseCase metricsUseCase;
    private final ObservabilityProcessor<HubsObservabilityLaunchData> observabilityHandler;
    private final RumService rumService;

    @Inject
    public HubsObservability(MetricsUseCase metricsUseCase, RumService rumService, ApdexService apdexService, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(metricsUseCase, "metricsUseCase");
        Intrinsics.checkNotNullParameter(rumService, "rumService");
        Intrinsics.checkNotNullParameter(apdexService, "apdexService");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.metricsUseCase = metricsUseCase;
        this.rumService = rumService;
        this.apdexService = apdexService;
        this.ioDispatcher = ioDispatcher;
        this.observabilityHandler = new ObservabilityProcessor<>(rumService, apdexService, new HubsObservability$observabilityHandler$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object observabilityHandler$sendEvent(HubsObservability hubsObservability, HubsObservabilityLaunchData hubsObservabilityLaunchData, Continuation continuation) {
        hubsObservability.sendEvent(hubsObservabilityLaunchData);
        return Unit.INSTANCE;
    }

    public final Object hubListLoadingStarted(String str, HubsDirection hubsDirection, HubsSort hubsSort, ItemsScreenMode itemsScreenMode, long j, Continuation<? super Unit> continuation) {
        String lowerCase = itemsScreenMode.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        this.observabilityHandler.launchMetric(new HubsObservabilityLaunchData(new HubListLoadingEvent(hubsSort + " " + hubsDirection, lowerCase, null, null, null, null, 60, null), j), str);
        Object objSendOnLoadingStarted = this.observabilityHandler.sendOnLoadingStarted(str, HUB_LIST_FETCH_EVENT, HubsListApdex.INSTANCE, continuation);
        return objSendOnLoadingStarted == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSendOnLoadingStarted : Unit.INSTANCE;
    }

    public static /* synthetic */ Object sendHubListFetchSuccess$default(HubsObservability hubsObservability, String str, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = SystemClock.elapsedRealtime();
        }
        return hubsObservability.sendHubListFetchSuccess(str, j, continuation);
    }

    public final Object sendHubListFetchSuccess(String str, final long j, Continuation<? super Unit> continuation) {
        Object objSendSuccessEvent$default = ObservabilityProcessor.sendSuccessEvent$default(this.observabilityHandler, str, new Function1() { // from class: com.box.android.domain.metrics.hubs.HubsObservability$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HubsObservability.sendHubListFetchSuccess$lambda$0(j, (HubsObservabilityLaunchData) obj);
            }
        }, new Function1() { // from class: com.box.android.domain.metrics.hubs.HubsObservability$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HubsObservability.sendHubListFetchSuccess$lambda$1((HubsObservabilityLaunchData) obj);
            }
        }, null, continuation, 8, null);
        return objSendSuccessEvent$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSendSuccessEvent$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HubsObservabilityLaunchData sendHubListFetchSuccess$lambda$0(long j, HubsObservabilityLaunchData current) {
        Intrinsics.checkNotNullParameter(current, "current");
        HubEvent event = current.getEvent();
        Intrinsics.checkNotNull(event, "null cannot be cast to non-null type com.box.android.domain.models.observability.HubListLoadingEvent");
        return HubsObservabilityLaunchData.copy$default(current, HubListLoadingEvent.copy$default((HubListLoadingEvent) event, null, null, Long.valueOf(j - current.getStartTime()), null, null, null, 51, null), 0L, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String sendHubListFetchSuccess$lambda$1(HubsObservabilityLaunchData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return HUB_LIST_FETCH_SUCCESS;
    }

    public final Object sendHubListFetchError(String str, DomainError domainError, Continuation<? super Unit> continuation) {
        Object objSendErrorEvent = this.observabilityHandler.sendErrorEvent(str, domainError, HUB_LIST_FETCH_FAILURE, new Function2() { // from class: com.box.android.domain.metrics.hubs.HubsObservability$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return HubsObservability.sendHubListFetchError$lambda$0((HubsObservabilityLaunchData) obj, (DomainError) obj2);
            }
        }, continuation);
        return objSendErrorEvent == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSendErrorEvent : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HubsObservabilityLaunchData sendHubListFetchError$lambda$0(HubsObservabilityLaunchData current, DomainError err) {
        Intrinsics.checkNotNullParameter(current, "current");
        Intrinsics.checkNotNullParameter(err, "err");
        HubEvent event = current.getEvent();
        Intrinsics.checkNotNull(event, "null cannot be cast to non-null type com.box.android.domain.models.observability.HubListLoadingEvent");
        return HubsObservabilityLaunchData.copy$default(current, HubListLoadingEvent.copy$default((HubListLoadingEvent) event, null, null, null, err, null, null, 51, null), 0L, 2, null);
    }

    public static /* synthetic */ Object hubAssetLoadingStarted$default(HubsObservability hubsObservability, String str, String str2, long j, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            j = SystemClock.elapsedRealtime();
        }
        return hubsObservability.hubAssetLoadingStarted(str, str2, j, continuation);
    }

    public final Object hubAssetLoadingStarted(String str, String str2, long j, Continuation<? super Unit> continuation) {
        this.observabilityHandler.launchMetric(new HubsObservabilityLaunchData(new HubAssetLoadingEvent(str2, null, null, 6, null), j), str);
        Object objSendOnLoadingStarted = this.observabilityHandler.sendOnLoadingStarted(str, HUB_ASSET_FETCH_EVENT, HubAssetApdex.INSTANCE, continuation);
        return objSendOnLoadingStarted == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSendOnLoadingStarted : Unit.INSTANCE;
    }

    public static /* synthetic */ Object sendHubAssetFetchSuccess$default(HubsObservability hubsObservability, String str, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = SystemClock.elapsedRealtime();
        }
        return hubsObservability.sendHubAssetFetchSuccess(str, j, continuation);
    }

    public final Object sendHubAssetFetchSuccess(String str, final long j, Continuation<? super Unit> continuation) {
        Object objSendSuccessEvent$default = ObservabilityProcessor.sendSuccessEvent$default(this.observabilityHandler, str, new Function1() { // from class: com.box.android.domain.metrics.hubs.HubsObservability$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HubsObservability.sendHubAssetFetchSuccess$lambda$0(j, (HubsObservabilityLaunchData) obj);
            }
        }, new Function1() { // from class: com.box.android.domain.metrics.hubs.HubsObservability$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HubsObservability.sendHubAssetFetchSuccess$lambda$1((HubsObservabilityLaunchData) obj);
            }
        }, null, continuation, 8, null);
        return objSendSuccessEvent$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSendSuccessEvent$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HubsObservabilityLaunchData sendHubAssetFetchSuccess$lambda$0(long j, HubsObservabilityLaunchData current) {
        Intrinsics.checkNotNullParameter(current, "current");
        HubEvent event = current.getEvent();
        Intrinsics.checkNotNull(event, "null cannot be cast to non-null type com.box.android.domain.models.observability.HubAssetLoadingEvent");
        return HubsObservabilityLaunchData.copy$default(current, HubAssetLoadingEvent.copy$default((HubAssetLoadingEvent) event, null, Long.valueOf(j - current.getStartTime()), null, 1, null), 0L, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String sendHubAssetFetchSuccess$lambda$1(HubsObservabilityLaunchData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return HUB_ASSET_FETCH_SUCCESS;
    }

    public final Object sendHubAssetFetchFailure(String str, DomainError domainError, Continuation<? super Unit> continuation) {
        Object objSendErrorEvent = this.observabilityHandler.sendErrorEvent(str, domainError, HUB_ASSET_FETCH_FAILURE, new Function2() { // from class: com.box.android.domain.metrics.hubs.HubsObservability$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return HubsObservability.sendHubAssetFetchFailure$lambda$0((HubsObservabilityLaunchData) obj, (DomainError) obj2);
            }
        }, continuation);
        return objSendErrorEvent == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSendErrorEvent : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HubsObservabilityLaunchData sendHubAssetFetchFailure$lambda$0(HubsObservabilityLaunchData current, DomainError err) {
        Intrinsics.checkNotNullParameter(current, "current");
        Intrinsics.checkNotNullParameter(err, "err");
        HubEvent event = current.getEvent();
        Intrinsics.checkNotNull(event, "null cannot be cast to non-null type com.box.android.domain.models.observability.HubAssetLoadingEvent");
        return HubsObservabilityLaunchData.copy$default(current, HubAssetLoadingEvent.copy$default((HubAssetLoadingEvent) event, null, null, err, 1, null), 0L, 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.domain.metrics.hubs.HubsObservability$sendEvent$1, reason: invalid class name */
    /* JADX INFO: compiled from: HubsObservability.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.metrics.hubs.HubsObservability$sendEvent$1", f = "HubsObservability.kt", i = {}, l = {Token.DOTQUERY}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ HubsObservabilityLaunchData $event;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(HubsObservabilityLaunchData hubsObservabilityLaunchData, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$event = hubsObservabilityLaunchData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HubsObservability.this.new AnonymousClass1(this.$event, continuation);
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
                MetricsUseCase metricsUseCase = HubsObservability.this.metricsUseCase;
                Object event = this.$event.getEvent();
                Intrinsics.checkNotNull(event, "null cannot be cast to non-null type com.box.android.domain.models.observability.Gen204Event");
                this.label = 1;
                if (metricsUseCase.log((Gen204Event) event, this) == coroutine_suspended) {
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

    private final void sendEvent(HubsObservabilityLaunchData event) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.ioDispatcher), null, null, new AnonymousClass1(event, null), 3, null);
    }
}
