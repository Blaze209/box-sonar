package com.box.cirrus.providers;

import com.box.android.domain.analytics.PendoAnalytics;
import com.box.android.domain.models.observability.XPlatformEvent;
import com.box.android.domain.usecases.observability.MetricsUseCase;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.margelo.nitro.boxcontext.LogEventProperties;
import com.margelo.nitro.boxcontext.providers.AnalyticsProvider;
import com.margelo.nitro.core.AnyMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: BoxAnalyticsProvider.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/box/cirrus/providers/BoxAnalyticsProvider;", "Lcom/margelo/nitro/boxcontext/providers/AnalyticsProvider;", "metricsUseCase", "Lcom/box/android/domain/usecases/observability/MetricsUseCase;", "coroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/box/android/domain/usecases/observability/MetricsUseCase;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getMetricsUseCase", "()Lcom/box/android/domain/usecases/observability/MetricsUseCase;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "trackEvent", "", "name", "", "properties", "Lcom/margelo/nitro/core/AnyMap;", "logEvent", "Lcom/margelo/nitro/boxcontext/LogEventProperties;", "cirrus_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxAnalyticsProvider implements AnalyticsProvider {
    private final CoroutineDispatcher coroutineDispatcher;
    private final CoroutineScope coroutineScope;
    private final MetricsUseCase metricsUseCase;

    @Inject
    public BoxAnalyticsProvider(MetricsUseCase metricsUseCase, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(metricsUseCase, "metricsUseCase");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "coroutineDispatcher");
        this.metricsUseCase = metricsUseCase;
        this.coroutineDispatcher = coroutineDispatcher;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(coroutineDispatcher));
    }

    public final MetricsUseCase getMetricsUseCase() {
        return this.metricsUseCase;
    }

    @Override // com.margelo.nitro.boxcontext.providers.AnalyticsProvider
    public void trackEvent(String name, AnyMap properties) {
        Intrinsics.checkNotNullParameter(name, "name");
        PendoAnalytics.INSTANCE.trackEvent(name, BoxAnalyticsProviderKt.toPropertiesMap(properties));
    }

    /* JADX INFO: renamed from: com.box.cirrus.providers.BoxAnalyticsProvider$logEvent$1, reason: invalid class name */
    /* JADX INFO: compiled from: BoxAnalyticsProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.cirrus.providers.BoxAnalyticsProvider$logEvent$1", f = "BoxAnalyticsProvider.kt", i = {0, 0, 0}, l = {32}, m = "invokeSuspend", n = {"$this$launch", "$this$invokeSuspend_u24lambda_u240", "$i$a$-runCatching-BoxAnalyticsProvider$logEvent$1$1"}, s = {"L$0", "L$1", "I$0"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $name;
        final /* synthetic */ LogEventProperties $properties;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, LogEventProperties logEventProperties, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$name = str;
            this.$properties = logEventProperties;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = BoxAnalyticsProvider.this.new AnonymousClass1(this.$name, this.$properties, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM14780constructorimpl;
            Object objLog;
            Double doubleOrNull;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    BoxAnalyticsProvider boxAnalyticsProvider = BoxAnalyticsProvider.this;
                    String str = this.$name;
                    LogEventProperties logEventProperties = this.$properties;
                    Result.Companion companion = Result.INSTANCE;
                    MetricsUseCase metricsUseCase = boxAnalyticsProvider.getMetricsUseCase();
                    String module_id = logEventProperties.getModule_id();
                    String status = logEventProperties.getStatus();
                    String error_code = logEventProperties.getError_code();
                    String error_message = logEventProperties.getError_message();
                    String source = logEventProperties.getSource();
                    String app_mode = logEventProperties.getApp_mode();
                    String data = logEventProperties.getData();
                    String session_id = logEventProperties.getSession_id();
                    String agent_id = logEventProperties.getAgent_id();
                    String turn_id = logEventProperties.getTurn_id();
                    String trace_id = logEventProperties.getTrace_id();
                    String agent_release_state = logEventProperties.getAgent_release_state();
                    String duration = logEventProperties.getDuration();
                    XPlatformEvent xPlatformEvent = new XPlatformEvent(str, module_id, status, error_code, error_message, source, app_mode, data, session_id, agent_id, turn_id, trace_id, agent_release_state, (duration == null || (doubleOrNull = StringsKt.toDoubleOrNull(duration)) == null) ? null : Boxing.boxLong((long) doubleOrNull.doubleValue()), null, null, 49152, null);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.I$0 = 0;
                    this.label = 1;
                    objLog = metricsUseCase.log(xPlatformEvent, this);
                    if (objLog == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    objLog = obj;
                }
                objM14780constructorimpl = Result.m14780constructorimpl((com.box.android.domain.utils.result.Result) objLog);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM14780constructorimpl = Result.m14780constructorimpl(ResultKt.createFailure(th));
            }
            BoxAnalyticsProvider boxAnalyticsProvider2 = BoxAnalyticsProvider.this;
            Throwable thM14783exceptionOrNullimpl = Result.m14783exceptionOrNullimpl(objM14780constructorimpl);
            if (thM14783exceptionOrNullimpl != null) {
                BoxLogUtils.e(ExtensionsKt.getTAG(boxAnalyticsProvider2), thM14783exceptionOrNullimpl);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.margelo.nitro.boxcontext.providers.AnalyticsProvider
    public void logEvent(String name, LogEventProperties properties) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(properties, "properties");
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new AnonymousClass1(name, properties, null), 3, null);
    }
}
