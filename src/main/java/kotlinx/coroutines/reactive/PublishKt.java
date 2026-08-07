package kotlinx.coroutines.reactive;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ProducerScope;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: Publish.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u001aR\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042/\b\u0001\u0010\u0005\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0006¢\u0006\u0002\b\u000b¢\u0006\u0002\u0010\f\u001ar\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00042\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\u00062-\u0010\u0005\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0006¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\u0012\u001aX\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u000f2\b\b\u0002\u0010\u0003\u001a\u00020\u00042/\b\u0001\u0010\u0005\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0006¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\u0017\"\u000e\u0010\u0013\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000\" \u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"publish", "Lorg/reactivestreams/Publisher;", ExifInterface.GPS_DIRECTION_TRUE, "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lorg/reactivestreams/Publisher;", "publishInternal", "scope", "Lkotlinx/coroutines/CoroutineScope;", "exceptionOnCancelHandler", "", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)Lorg/reactivestreams/Publisher;", "CLOSED", "", "SIGNALLED", "DEFAULT_HANDLER", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lorg/reactivestreams/Publisher;", "kotlinx-coroutines-reactive"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class PublishKt {
    private static final long CLOSED = -1;
    private static final Function2<Throwable, CoroutineContext, Unit> DEFAULT_HANDLER = new Function2() { // from class: kotlinx.coroutines.reactive.PublishKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return PublishKt.DEFAULT_HANDLER$lambda$2((Throwable) obj, (CoroutineContext) obj2);
        }
    };
    private static final long SIGNALLED = -2;

    public static /* synthetic */ Publisher publish$default(CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return publish(coroutineContext, function2);
    }

    public static final <T> Publisher<T> publish(CoroutineContext coroutineContext, Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        if (coroutineContext.get(Job.INSTANCE) != null) {
            throw new IllegalArgumentException(("Publisher context cannot contain job in it.Its lifecycle should be managed via subscription. Had " + coroutineContext).toString());
        }
        return publishInternal(GlobalScope.INSTANCE, coroutineContext, DEFAULT_HANDLER, function2);
    }

    public static final <T> Publisher<T> publishInternal(final CoroutineScope coroutineScope, final CoroutineContext coroutineContext, final Function2<? super Throwable, ? super CoroutineContext, Unit> function2, final Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return new Publisher() { // from class: kotlinx.coroutines.reactive.PublishKt$$ExternalSyntheticLambda0
            @Override // org.reactivestreams.Publisher
            public final void subscribe(Subscriber subscriber) {
                PublishKt.publishInternal$lambda$1(coroutineScope, coroutineContext, function2, function3, subscriber);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void publishInternal$lambda$1(CoroutineScope coroutineScope, CoroutineContext coroutineContext, Function2 function2, Function2 function3, Subscriber subscriber) {
        if (subscriber == null) {
            throw new NullPointerException("Subscriber cannot be null");
        }
        PublisherCoroutine publisherCoroutine = new PublisherCoroutine(CoroutineContextKt.newCoroutineContext(coroutineScope, coroutineContext), subscriber, function2);
        subscriber.onSubscribe(publisherCoroutine);
        publisherCoroutine.start(CoroutineStart.DEFAULT, publisherCoroutine, function3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DEFAULT_HANDLER$lambda$2(Throwable th, CoroutineContext coroutineContext) {
        if (!(th instanceof CancellationException)) {
            CoroutineExceptionHandlerKt.handleCoroutineException(coroutineContext, th);
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Publisher publish$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return publish(coroutineScope, coroutineContext, function2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "CoroutineScope.publish is deprecated in favour of top-level publish", replaceWith = @ReplaceWith(expression = "publish(context, block)", imports = {}))
    public static final /* synthetic */ Publisher publish(CoroutineScope coroutineScope, CoroutineContext coroutineContext, Function2 function2) {
        return publishInternal(coroutineScope, coroutineContext, DEFAULT_HANDLER, function2);
    }
}
