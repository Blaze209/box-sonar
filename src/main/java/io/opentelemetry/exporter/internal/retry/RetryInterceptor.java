package io.opentelemetry.exporter.internal.retry;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import okhttp3.Interceptor;
import okhttp3.Response;

/* JADX INFO: loaded from: classes4.dex */
public final class RetryInterceptor implements Interceptor {
    private final Function<Response, Boolean> isRetryable;
    private final Function<IOException, Boolean> isRetryableException;
    private final BoundedLongGenerator randomLong;
    private final RetryPolicy retryPolicy;
    private final Sleeper sleeper;

    interface BoundedLongGenerator {
        long get(long j);
    }

    interface Sleeper {
        void sleep(long j) throws InterruptedException;
    }

    public RetryInterceptor(RetryPolicy retryPolicy, Function<Response, Boolean> function) {
        Function function2 = new Function() { // from class: io.opentelemetry.exporter.internal.retry.RetryInterceptor$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Boolean.valueOf(RetryInterceptor.isRetryableException((IOException) obj));
            }
        };
        final TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        Objects.requireNonNull(timeUnit);
        this(retryPolicy, function, function2, new Sleeper() { // from class: io.opentelemetry.exporter.internal.retry.RetryInterceptor$$ExternalSyntheticLambda1
            @Override // io.opentelemetry.exporter.internal.retry.RetryInterceptor.Sleeper
            public final void sleep(long j) throws InterruptedException {
                timeUnit.sleep(j);
            }
        }, new BoundedLongGenerator() { // from class: io.opentelemetry.exporter.internal.retry.RetryInterceptor$$ExternalSyntheticLambda2
            @Override // io.opentelemetry.exporter.internal.retry.RetryInterceptor.BoundedLongGenerator
            public final long get(long j) {
                return ThreadLocalRandom.current().nextLong(j);
            }
        });
    }

    RetryInterceptor(RetryPolicy retryPolicy, Function<Response, Boolean> function, Function<IOException, Boolean> function2, Sleeper sleeper, BoundedLongGenerator boundedLongGenerator) {
        this.retryPolicy = retryPolicy;
        this.isRetryable = function;
        this.isRetryableException = function2;
        this.sleeper = sleeper;
        this.randomLong = boundedLongGenerator;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0079 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x007a  */
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        long nanos = this.retryPolicy.getInitialBackoff().toNanos();
        Response responseProceed = null;
        int i = 0;
        IOException e = null;
        do {
            if (i > 0) {
                long j = this.randomLong.get(Math.min(nanos, this.retryPolicy.getMaxBackoff().toNanos()));
                nanos = (long) (nanos * this.retryPolicy.getBackoffMultiplier());
                try {
                    this.sleeper.sleep(j);
                    if (responseProceed != null) {
                        responseProceed.close();
                    }
                    i++;
                    try {
                        responseProceed = chain.proceed(chain.request());
                    } catch (IOException e2) {
                        e = e2;
                    }
                    if (responseProceed == null && !Boolean.TRUE.equals(this.isRetryable.apply(responseProceed))) {
                        return responseProceed;
                    }
                    if (e == null && !Boolean.TRUE.equals(this.isRetryableException.apply(e))) {
                        throw e;
                    }
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            } else {
                i++;
                responseProceed = chain.proceed(chain.request());
                if (responseProceed == null) {
                }
                if (e == null) {
                }
            }
            if (responseProceed != null) {
                return responseProceed;
            }
            throw e;
        } while (i < this.retryPolicy.getMaxAttempts());
        if (responseProceed != null) {
            return responseProceed;
        }
        throw e;
    }

    static boolean isRetryableException(IOException iOException) {
        if (!(iOException instanceof SocketTimeoutException)) {
            return false;
        }
        String message = iOException.getMessage();
        return message == null || message.toLowerCase().contains("connect timed out");
    }
}
