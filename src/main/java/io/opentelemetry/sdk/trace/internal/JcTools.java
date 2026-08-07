package io.opentelemetry.sdk.trace.internal;

import io.opentelemetry.internal.shaded.jctools.queues.MessagePassingQueue;
import io.opentelemetry.internal.shaded.jctools.queues.MpscArrayQueue;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
public final class JcTools {
    private static final AtomicBoolean queueCreationWarningLogged = new AtomicBoolean();
    private static final Logger logger = Logger.getLogger(JcTools.class.getName());

    public static <T> Queue<T> newFixedSizeQueue(int i) {
        try {
            return new MpscArrayQueue(i);
        } catch (ExceptionInInitializerError | NoClassDefFoundError e) {
            if (!queueCreationWarningLogged.getAndSet(true)) {
                logger.log(Level.WARNING, "Cannot create high-performance queue, reverting to ArrayBlockingQueue ({0})", Objects.toString(e, "unknown cause"));
            }
            return new ArrayBlockingQueue(i);
        }
    }

    public static long capacity(Queue<?> queue) {
        if (queue instanceof MessagePassingQueue) {
            return ((MessagePassingQueue) queue).capacity();
        }
        return ((long) ((ArrayBlockingQueue) queue).remainingCapacity()) + ((long) queue.size());
    }

    public static <T> void drain(Queue<T> queue, int i, final Consumer<T> consumer) {
        if (queue instanceof MessagePassingQueue) {
            Objects.requireNonNull(consumer);
            ((MessagePassingQueue) queue).drain(new MessagePassingQueue.Consumer() { // from class: io.opentelemetry.sdk.trace.internal.JcTools$$ExternalSyntheticLambda0
                @Override // io.opentelemetry.internal.shaded.jctools.queues.MessagePassingQueue.Consumer
                public final void accept(Object obj) {
                    consumer.accept(obj);
                }
            }, i);
        } else {
            drainNonJcQueue(queue, i, consumer);
        }
    }

    private static <T> void drainNonJcQueue(Queue<T> queue, int i, Consumer<T> consumer) {
        T tPoll;
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (i2 >= i || (tPoll = queue.poll()) == null) {
                return;
            }
            consumer.accept(tPoll);
            i2 = i3;
        }
    }

    private JcTools() {
    }
}
