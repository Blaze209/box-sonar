package com.box.android.data.observability;

import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.common.utilities.BuildConfigProvider;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.services.IBVEManager;
import com.box.android.domain.services.ISessionManager;
import com.box.android.domain.services.RumService;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.androidsdk.content.utils.BoxLogUtils;
import external.sdk.pendo.io.mozilla.javascript.Token;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.extension.kotlin.ContextExtensionsKt;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.RandomKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: RumObservability.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 A2\u00020\u0001:\u0001AB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u0010H\u0016JF\u0010\u001c\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001a\u001a\u00020\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001f\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010!H\u0096@¢\u0006\u0002\u0010\"J\u0016\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010%J(\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00102\b\u0010(\u001a\u0004\u0018\u00010!H\u0096@¢\u0006\u0002\u0010)J\u001e\u0010*\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010,J\u001e\u0010-\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010,J\u001e\u0010.\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u00102\u0006\u0010/\u001a\u000200H\u0096@¢\u0006\u0002\u00101J(\u00102\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00102\b\u0010+\u001a\u0004\u0018\u00010\u0010H\u0096@¢\u0006\u0002\u00103J&\u00104\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u00102\u0006\u0010/\u001a\u0002002\u0006\u0010\u001d\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u00105J\u000e\u00106\u001a\u00020\u0010*\u0004\u0018\u00010\u0010H\u0002J\u0018\u00107\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u00108\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J\u0014\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100:H\u0002J*\u0010;\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u00102\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00150=H\u0082@¢\u0006\u0002\u0010>J\b\u0010?\u001a\u00020\u0010H\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010@\u001a\u00020\u0018H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006B"}, d2 = {"Lcom/box/android/data/observability/RumObservability;", "Lcom/box/android/domain/services/RumService;", "sessionManager", "Lcom/box/android/domain/services/ISessionManager;", "rumInstrumentation", "Lcom/box/android/data/observability/RumInstrumentation;", "bveManager", "Lcom/box/android/domain/services/IBVEManager;", "debugConfig", "", "<init>", "(Lcom/box/android/domain/services/ISessionManager;Lcom/box/android/data/observability/RumInstrumentation;Lcom/box/android/domain/services/IBVEManager;Z)V", "shouldSample", "Ljava/lang/Boolean;", "spanMap", "", "", "Lio/opentelemetry/api/trace/Span;", "getSpanMap$data_generalProdRelease", "()Ljava/util/Map;", "init", "", "proxyUrl", "samplingRatio", "", "startSpan", "spanName", "identifier", "startCustomizedSpan", "customEventName", "parentSpanIdentifier", "makeCurrent", "startTimestamp", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "endSpanAsSuccess", "spanId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addMilestone", "milestone", "timestamp", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateOperation", "operationName", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateEventName", "endSpanWithError", "error", "Lcom/box/android/domain/models/DomainError;", "(Ljava/lang/String;Lcom/box/android/domain/models/DomainError;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAndEndSpanAsSuccess", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAndEndSpanAsError", "(Ljava/lang/String;Lcom/box/android/domain/models/DomainError;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSpanId", "initNotSynchronised", "buildEndpoint", "buildHeaders", "", "withSpan", "update", "Lkotlin/Function1;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveDeploymentEnvironment", "probability", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RumObservability implements RumService {
    private static final String APPLICATION_NAME = "Box Android";
    private static final String AUTHORIZATION_KEY = "Authorization";
    private static final String CUSTOM_EVENT_NAME_ATTRIBUTE = "workflow.name";
    private static final String ERROR_ATTRIBUTE = "exception.message";
    private final IBVEManager bveManager;
    private final boolean debugConfig;
    private final RumInstrumentation rumInstrumentation;
    private final ISessionManager sessionManager;
    private Boolean shouldSample;
    private final Map<String, Span> spanMap;

    /* JADX INFO: renamed from: com.box.android.data.observability.RumObservability$endSpanAsSuccess$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RumObservability.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.observability.RumObservability", f = "RumObservability.kt", i = {0}, l = {73}, m = "endSpanAsSuccess", n = {"spanId"}, s = {"L$0"}, v = 1)
    static final class C13661 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C13661(Continuation<? super C13661> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RumObservability.this.endSpanAsSuccess(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.observability.RumObservability$endSpanWithError$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RumObservability.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.observability.RumObservability", f = "RumObservability.kt", i = {0, 0}, l = {102}, m = "endSpanWithError", n = {"spanId", "error"}, s = {"L$0", "L$1"}, v = 1)
    static final class C13671 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C13671(Continuation<? super C13671> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RumObservability.this.endSpanWithError(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.observability.RumObservability$updateAndEndSpanAsError$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RumObservability.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.observability.RumObservability", f = "RumObservability.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2}, l = {117, 118, 119}, m = "updateAndEndSpanAsError", n = {"spanId", "error", "customEventName", "spanId", "error", "customEventName", "spanId", "error", "customEventName"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 1)
    static final class C13691 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C13691(Continuation<? super C13691> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RumObservability.this.updateAndEndSpanAsError(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.observability.RumObservability$updateAndEndSpanAsSuccess$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RumObservability.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.observability.RumObservability", f = "RumObservability.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 2}, l = {111, 112, 113}, m = "updateAndEndSpanAsSuccess", n = {"spanId", "customEventName", "operationName", "it", "$i$a$-let-RumObservability$updateAndEndSpanAsSuccess$2", "spanId", "customEventName", "operationName", "spanId", "customEventName", "operationName"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 1)
    static final class C13701 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C13701(Continuation<? super C13701> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RumObservability.this.updateAndEndSpanAsSuccess(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.observability.RumObservability$withSpan$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RumObservability.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.observability.RumObservability", f = "RumObservability.kt", i = {0, 0, 0, 0}, l = {Token.LET}, m = "withSpan", n = {"spanId", "update", "span", "$i$a$-also-RumObservability$withSpan$2"}, s = {"L$0", "L$1", "L$3", "I$0"}, v = 1)
    static final class C13711 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C13711(Continuation<? super C13711> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RumObservability.this.withSpan(null, null, this);
        }
    }

    public RumObservability(ISessionManager sessionManager, RumInstrumentation rumInstrumentation, IBVEManager bveManager, boolean z) {
        Intrinsics.checkNotNullParameter(sessionManager, "sessionManager");
        Intrinsics.checkNotNullParameter(rumInstrumentation, "rumInstrumentation");
        Intrinsics.checkNotNullParameter(bveManager, "bveManager");
        this.sessionManager = sessionManager;
        this.rumInstrumentation = rumInstrumentation;
        this.bveManager = bveManager;
        this.debugConfig = z;
        this.spanMap = new LinkedHashMap();
    }

    public /* synthetic */ RumObservability(ISessionManager iSessionManager, RumInstrumentation rumInstrumentation, IBVEManager iBVEManager, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(iSessionManager, rumInstrumentation, iBVEManager, (i & 8) != 0 ? BuildConfigProvider.INSTANCE.isDebugBuild() : z);
    }

    public final Map<String, Span> getSpanMap$data_generalProdRelease() {
        return this.spanMap;
    }

    @Override // com.box.android.domain.services.RumService
    public void init(String proxyUrl, double samplingRatio) {
        Intrinsics.checkNotNullParameter(proxyUrl, "proxyUrl");
        try {
            synchronized (this) {
                initNotSynchronised(proxyUrl, samplingRatio);
                Unit unit = Unit.INSTANCE;
            }
        } catch (Exception e) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Exception while initialising splunk rum " + e.getMessage() + " " + e.getStackTrace());
        }
    }

    @Override // com.box.android.domain.services.RumService
    public String startSpan(String spanName, String identifier) {
        Intrinsics.checkNotNullParameter(spanName, "spanName");
        String spanId = toSpanId(identifier);
        this.spanMap.put(spanId, this.rumInstrumentation.startSpan(spanName));
        return spanId;
    }

    @Override // com.box.android.domain.services.RumService
    public Object startCustomizedSpan(String str, String str2, String str3, String str4, boolean z, Long l, Continuation<? super String> continuation) {
        String spanId = toSpanId(str3);
        Span span = str4 != null ? this.spanMap.get(str4) : null;
        Map<String, Span> map = this.spanMap;
        Span spanStartSpan = this.rumInstrumentation.startSpan(str, str2, span, l);
        if (z) {
            spanStartSpan.makeCurrent();
        }
        map.put(spanId, spanStartSpan);
        return spanId;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.RumService
    public Object endSpanAsSuccess(String str, Continuation<? super Unit> continuation) {
        C13661 c13661;
        if (continuation instanceof C13661) {
            c13661 = (C13661) continuation;
            if ((c13661.label & Integer.MIN_VALUE) != 0) {
                c13661.label -= Integer.MIN_VALUE;
            } else {
                c13661 = new C13661(continuation);
            }
        } else {
            c13661 = new C13661(continuation);
        }
        Object obj = c13661.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13661.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function1<? super Span, Unit> function1 = new Function1() { // from class: com.box.android.data.observability.RumObservability$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return RumObservability.endSpanAsSuccess$lambda$0((Span) obj2);
                }
            };
            c13661.L$0 = str;
            c13661.label = 1;
            if (withSpan(str, function1, c13661) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) c13661.L$0;
            ResultKt.throwOnFailure(obj);
        }
        this.spanMap.remove(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit endSpanAsSuccess$lambda$0(Span span) {
        Intrinsics.checkNotNullParameter(span, "span");
        span.end();
        return Unit.INSTANCE;
    }

    @Override // com.box.android.domain.services.RumService
    public Object addMilestone(final String str, String str2, final Long l, Continuation<? super Unit> continuation) {
        Object objWithSpan = withSpan(str2, new Function1() { // from class: com.box.android.data.observability.RumObservability$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RumObservability.addMilestone$lambda$0(l, str, (Span) obj);
            }
        }, continuation);
        return objWithSpan == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithSpan : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addMilestone$lambda$0(Long l, String str, Span span) {
        Intrinsics.checkNotNullParameter(span, "span");
        if (l != null) {
            span.addEvent(str, l.longValue(), TimeUnit.MILLISECONDS);
        } else {
            span.addEvent(str);
        }
        return Unit.INSTANCE;
    }

    @Override // com.box.android.domain.services.RumService
    public Object updateOperation(String str, final String str2, Continuation<? super Unit> continuation) {
        Object objWithSpan = withSpan(str, new Function1() { // from class: com.box.android.data.observability.RumObservability$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RumObservability.updateOperation$lambda$0(str2, (Span) obj);
            }
        }, continuation);
        return objWithSpan == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithSpan : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateOperation$lambda$0(String str, Span span) {
        Intrinsics.checkNotNullParameter(span, "span");
        span.updateName(str);
        return Unit.INSTANCE;
    }

    @Override // com.box.android.domain.services.RumService
    public Object updateEventName(String str, final String str2, Continuation<? super Unit> continuation) {
        Object objWithSpan = withSpan(str, new Function1() { // from class: com.box.android.data.observability.RumObservability$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RumObservability.updateEventName$lambda$0(str2, (Span) obj);
            }
        }, continuation);
        return objWithSpan == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithSpan : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateEventName$lambda$0(String str, Span span) {
        Intrinsics.checkNotNullParameter(span, "span");
        span.setAttribute(CUSTOM_EVENT_NAME_ATTRIBUTE, str);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.RumService
    public Object endSpanWithError(String str, final DomainError domainError, Continuation<? super Unit> continuation) {
        C13671 c13671;
        if (continuation instanceof C13671) {
            c13671 = (C13671) continuation;
            if ((c13671.label & Integer.MIN_VALUE) != 0) {
                c13671.label -= Integer.MIN_VALUE;
            } else {
                c13671 = new C13671(continuation);
            }
        } else {
            c13671 = new C13671(continuation);
        }
        Object obj = c13671.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13671.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function1<? super Span, Unit> function1 = new Function1() { // from class: com.box.android.data.observability.RumObservability$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return RumObservability.endSpanWithError$lambda$0(domainError, (Span) obj2);
                }
            };
            c13671.L$0 = str;
            c13671.L$1 = SpillingKt.nullOutSpilledVariable(domainError);
            c13671.label = 1;
            if (withSpan(str, function1, c13671) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) c13671.L$0;
            ResultKt.throwOnFailure(obj);
        }
        this.spanMap.remove(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit endSpanWithError$lambda$0(DomainError domainError, Span span) {
        Intrinsics.checkNotNullParameter(span, "span");
        span.setStatus(StatusCode.ERROR).setAttribute(ERROR_ATTRIBUTE, domainError.getMessage()).end();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c4, code lost:
    
        if (endSpanAsSuccess(r10, r0) == r1) goto L29;
     */
    @Override // com.box.android.domain.services.RumService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object updateAndEndSpanAsSuccess(java.lang.String r8, java.lang.String r9, java.lang.String r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            Method dump skipped, instruction units count: 202
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.observability.RumObservability.updateAndEndSpanAsSuccess(java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ab, code lost:
    
        if (endSpanWithError(r10, r9, r0) == r1) goto L27;
     */
    @Override // com.box.android.domain.services.RumService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object updateAndEndSpanAsError(java.lang.String r8, com.box.android.domain.models.DomainError r9, java.lang.String r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.box.android.data.observability.RumObservability.C13691
            if (r0 == 0) goto L14
            r0 = r11
            com.box.android.data.observability.RumObservability$updateAndEndSpanAsError$1 r0 = (com.box.android.data.observability.RumObservability.C13691) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.box.android.data.observability.RumObservability$updateAndEndSpanAsError$1 r0 = new com.box.android.data.observability.RumObservability$updateAndEndSpanAsError$1
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L67
            if (r2 == r5) goto L55
            if (r2 == r4) goto L45
            if (r2 != r3) goto L3d
            java.lang.Object r7 = r0.L$2
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r7 = r0.L$1
            com.box.android.domain.models.DomainError r7 = (com.box.android.domain.models.DomainError) r7
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            kotlin.ResultKt.throwOnFailure(r11)
            goto Lae
        L3d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L45:
            java.lang.Object r8 = r0.L$2
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r0.L$1
            com.box.android.domain.models.DomainError r9 = (com.box.android.domain.models.DomainError) r9
            java.lang.Object r10 = r0.L$0
            java.lang.String r10 = (java.lang.String) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L93
        L55:
            java.lang.Object r8 = r0.L$2
            r10 = r8
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r8 = r0.L$1
            r9 = r8
            com.box.android.domain.models.DomainError r9 = (com.box.android.domain.models.DomainError) r9
            java.lang.Object r8 = r0.L$0
            java.lang.String r8 = (java.lang.String) r8
            kotlin.ResultKt.throwOnFailure(r11)
            goto L7d
        L67:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.String r11 = r9.getSimpleClassName()
            r0.L$0 = r8
            r0.L$1 = r9
            r0.L$2 = r10
            r0.label = r5
            java.lang.Object r11 = r7.updateOperation(r8, r11, r0)
            if (r11 != r1) goto L7d
            goto Lad
        L7d:
            r0.L$0 = r8
            r0.L$1 = r9
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r0.L$2 = r11
            r0.label = r4
            java.lang.Object r11 = r7.updateEventName(r8, r10, r0)
            if (r11 != r1) goto L90
            goto Lad
        L90:
            r6 = r10
            r10 = r8
            r8 = r6
        L93:
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r0.L$0 = r11
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$1 = r11
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.L$2 = r8
            r0.label = r3
            java.lang.Object r7 = r7.endSpanWithError(r10, r9, r0)
            if (r7 != r1) goto Lae
        Lad:
            return r1
        Lae:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.observability.RumObservability.updateAndEndSpanAsError(java.lang.String, com.box.android.domain.models.DomainError, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String toSpanId(String str) {
        if (str != null) {
            return str;
        }
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private final void initNotSynchronised(String proxyUrl, double samplingRatio) {
        if (this.shouldSample == null) {
            this.shouldSample = Boolean.valueOf(shouldSample(samplingRatio));
        }
        if (Intrinsics.areEqual((Object) this.shouldSample, (Object) false) || this.rumInstrumentation.isInitialised()) {
            return;
        }
        this.rumInstrumentation.initialise(APPLICATION_NAME, resolveDeploymentEnvironment(), buildEndpoint(proxyUrl), this.debugConfig, new C13681(this), ApplicationProvider.getApplication());
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        BoxLogUtils.i(simpleName, "Splunk RUM initialised successfully");
    }

    /* JADX INFO: renamed from: com.box.android.data.observability.RumObservability$initNotSynchronised$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RumObservability.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class C13681 extends FunctionReferenceImpl implements Function0<Map<String, ? extends String>> {
        C13681(Object obj) {
            super(0, obj, RumObservability.class, "buildHeaders", "buildHeaders()Ljava/util/Map;", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<String, ? extends String> invoke() {
            return ((RumObservability) this.receiver).buildHeaders();
        }
    }

    private final String buildEndpoint(String proxyUrl) {
        return this.bveManager.getBaseUri() + StringsKt.removePrefix(proxyUrl, (CharSequence) "/");
    }

    /* JADX INFO: renamed from: com.box.android.data.observability.RumObservability$buildHeaders$1, reason: invalid class name */
    /* JADX INFO: compiled from: RumObservability.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.observability.RumObservability$buildHeaders$1", f = "RumObservability.kt", i = {}, l = {Token.XMLATTR}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<String, ? extends String>>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RumObservability.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Map<String, ? extends String>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Map<String, String>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Map<String, String>> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = RumObservability.this.sessionManager.getAccessToken(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return MapsKt.mapOf(TuplesKt.to("Authorization", "Bearer " + ((String) obj)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, String> buildHeaders() {
        return (Map) BuildersKt.runBlocking(Dispatchers.getIO(), new AnonymousClass1(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object withSpan(String str, Function1<? super Span, Unit> function1, Continuation<? super Unit> continuation) {
        C13711 c13711;
        if (continuation instanceof C13711) {
            c13711 = (C13711) continuation;
            if ((c13711.label & Integer.MIN_VALUE) != 0) {
                c13711.label -= Integer.MIN_VALUE;
            } else {
                c13711 = new C13711(continuation);
            }
        } else {
            c13711 = new C13711(continuation);
        }
        Object obj = c13711.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13711.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Span span = this.spanMap.get(str);
            if (span != null) {
                CoroutineContext coroutineContextAsContextElement = ContextExtensionsKt.asContextElement(span);
                RumObservability$withSpan$2$1 rumObservability$withSpan$2$1 = new RumObservability$withSpan$2$1(function1, span, null);
                c13711.L$0 = SpillingKt.nullOutSpilledVariable(str);
                c13711.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                c13711.L$2 = span;
                c13711.L$3 = SpillingKt.nullOutSpilledVariable(span);
                c13711.I$0 = 0;
                c13711.label = 1;
                if (BuildersKt.withContext(coroutineContextAsContextElement, rumObservability$withSpan$2$1, c13711) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c13711.I$0;
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    private final String resolveDeploymentEnvironment() {
        if (this.debugConfig) {
            return "dev";
        }
        return "prod";
    }

    private final boolean shouldSample(double probability) {
        return BuildConfigProvider.INSTANCE.isDebugBuild() || RandomKt.Random(Calendar.getInstance().get(14)).nextDouble() <= probability;
    }
}
