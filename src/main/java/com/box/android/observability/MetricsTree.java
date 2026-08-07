package com.box.android.observability;

import com.box.android.domain.models.observability.LogEvent;
import com.box.android.domain.models.observability.ThrowableMetric;
import com.box.android.domain.usecases.observability.MetricsUseCase;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.apache.commons.logging.LogFactory;
import timber.log.Timber;

/* JADX INFO: compiled from: MetricsTree.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J,\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J,\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/box/android/observability/MetricsTree;", "Ltimber/log/Timber$Tree;", "metricsUseCase", "Lcom/box/android/domain/usecases/observability/MetricsUseCase;", "<init>", "(Lcom/box/android/domain/usecases/observability/MetricsUseCase;)V", "log", "", LogFactory.PRIORITY_KEY, "", "tag", "", "message", "t", "", "saveToCache", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MetricsTree extends Timber.Tree {
    public static final int $stable = 8;
    private final MetricsUseCase metricsUseCase;

    public MetricsTree(MetricsUseCase metricsUseCase) {
        Intrinsics.checkNotNullParameter(metricsUseCase, "metricsUseCase");
        this.metricsUseCase = metricsUseCase;
    }

    @Override // timber.log.Timber.Tree
    protected void log(int priority, String tag, String message, Throwable t) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (priority == 5 || priority == 6) {
            saveToCache(priority, tag, message, t);
        }
    }

    private final void saveToCache(int priority, String tag, String message, Throwable t) {
        LogEvent.Priority priority2;
        if (priority == 5) {
            priority2 = LogEvent.Priority.WARNING;
        } else if (priority == 6) {
            priority2 = LogEvent.Priority.ERROR;
        } else {
            priority2 = LogEvent.Priority.UNKNOWN;
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(new LogEvent(message, priority2, tag, ThrowableMetric.INSTANCE.from(t), null, null, 48, null), null), 3, null);
    }

    /* JADX INFO: renamed from: com.box.android.observability.MetricsTree$saveToCache$1, reason: invalid class name */
    /* JADX INFO: compiled from: MetricsTree.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.observability.MetricsTree$saveToCache$1", f = "MetricsTree.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ LogEvent $event;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LogEvent logEvent, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$event = logEvent;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MetricsTree.this.new AnonymousClass1(this.$event, continuation);
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
                if (MetricsTree.this.metricsUseCase.log(this.$event, this) == coroutine_suspended) {
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
}
