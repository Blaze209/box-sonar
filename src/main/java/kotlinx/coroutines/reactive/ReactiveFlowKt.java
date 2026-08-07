package kotlinx.coroutines.reactive;

import androidx.exifinterface.media.ExifInterface;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import org.reactivestreams.Publisher;

/* JADX INFO: compiled from: ReactiveFlow.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a,\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u001a&\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\r\u001a\u00020\u0007H\u0000\"\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u000e"}, d2 = {"asFlow", "Lkotlinx/coroutines/flow/Flow;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lorg/reactivestreams/Publisher;", "asPublisher", "context", "Lkotlin/coroutines/CoroutineContext;", "contextInjectors", "", "Lkotlinx/coroutines/reactive/ContextInjector;", "[Lkotlinx/coroutines/reactive/ContextInjector;", "injectCoroutineContext", "coroutineContext", "kotlinx-coroutines-reactive"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ReactiveFlowKt {
    private static final ContextInjector[] contextInjectors = (ContextInjector[]) SequencesKt.toList(SequencesKt.asSequence(ServiceLoader.load(ContextInjector.class, ContextInjector.class.getClassLoader()).iterator())).toArray(new ContextInjector[0]);

    public static final <T> Publisher<T> asPublisher(Flow<? extends T> flow) {
        return asPublisher$default(flow, null, 1, null);
    }

    public static final <T> Flow<T> asFlow(Publisher<T> publisher) {
        return new PublisherAsFlow(publisher, null, 0, null, 14, null);
    }

    public static /* synthetic */ Publisher asPublisher$default(Flow flow, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return asPublisher(flow, coroutineContext);
    }

    public static final <T> Publisher<T> asPublisher(Flow<? extends T> flow, CoroutineContext coroutineContext) {
        return new FlowAsPublisher(flow, Dispatchers.getUnconfined().plus(coroutineContext));
    }

    public static final <T> Publisher<T> injectCoroutineContext(Publisher<T> publisher, CoroutineContext coroutineContext) {
        for (ContextInjector contextInjector : contextInjectors) {
            publisher = contextInjector.injectCoroutineContext(publisher, coroutineContext);
        }
        return publisher;
    }
}
