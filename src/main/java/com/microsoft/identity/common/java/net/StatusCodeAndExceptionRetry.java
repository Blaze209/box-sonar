package com.microsoft.identity.common.java.net;

import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.util.ported.Function;
import java.util.concurrent.Callable;
import net.jcip.annotations.Immutable;
import net.jcip.annotations.ThreadSafe;

/* JADX INFO: loaded from: classes14.dex */
@Immutable
@ThreadSafe
public class StatusCodeAndExceptionRetry implements IRetryPolicy<HttpResponse> {
    private final int extensionFactor;
    private final int initialDelay;
    private final Function<HttpResponse, Boolean> isAcceptable;
    private final Function<HttpResponse, Boolean> isRetryable;
    private final Function<Exception, Boolean> isRetryableException;
    private final int number;

    /* JADX INFO: Access modifiers changed from: private */
    public static int $default$extensionFactor() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int $default$initialDelay() {
        return 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int $default$number() {
        return 1;
    }

    public static class StatusCodeAndExceptionRetryBuilder {
        private boolean extensionFactor$set;
        private int extensionFactor$value;
        private boolean initialDelay$set;
        private int initialDelay$value;
        private boolean isAcceptable$set;
        private Function<HttpResponse, Boolean> isAcceptable$value;
        private boolean isRetryable$set;
        private Function<HttpResponse, Boolean> isRetryable$value;
        private boolean isRetryableException$set;
        private Function<Exception, Boolean> isRetryableException$value;
        private boolean number$set;
        private int number$value;

        StatusCodeAndExceptionRetryBuilder() {
        }

        public StatusCodeAndExceptionRetry build() {
            Function<Exception, Boolean> function$default$isRetryableException = this.isRetryableException$value;
            if (!this.isRetryableException$set) {
                function$default$isRetryableException = StatusCodeAndExceptionRetry.$default$isRetryableException();
            }
            Function<Exception, Boolean> function = function$default$isRetryableException;
            Function<HttpResponse, Boolean> function$default$isRetryable = this.isRetryable$value;
            if (!this.isRetryable$set) {
                function$default$isRetryable = StatusCodeAndExceptionRetry.$default$isRetryable();
            }
            Function<HttpResponse, Boolean> function2 = function$default$isRetryable;
            Function<HttpResponse, Boolean> function$default$isAcceptable = this.isAcceptable$value;
            if (!this.isAcceptable$set) {
                function$default$isAcceptable = StatusCodeAndExceptionRetry.$default$isAcceptable();
            }
            Function<HttpResponse, Boolean> function3 = function$default$isAcceptable;
            int i$default$number = this.number$value;
            if (!this.number$set) {
                i$default$number = StatusCodeAndExceptionRetry.$default$number();
            }
            int i = i$default$number;
            int i$default$initialDelay = this.initialDelay$value;
            if (!this.initialDelay$set) {
                i$default$initialDelay = StatusCodeAndExceptionRetry.$default$initialDelay();
            }
            int i2 = i$default$initialDelay;
            int i$default$extensionFactor = this.extensionFactor$value;
            if (!this.extensionFactor$set) {
                i$default$extensionFactor = StatusCodeAndExceptionRetry.$default$extensionFactor();
            }
            return new StatusCodeAndExceptionRetry(function, function2, function3, i, i2, i$default$extensionFactor);
        }

        public StatusCodeAndExceptionRetryBuilder extensionFactor(int i) {
            this.extensionFactor$value = i;
            this.extensionFactor$set = true;
            return this;
        }

        public StatusCodeAndExceptionRetryBuilder initialDelay(int i) {
            this.initialDelay$value = i;
            this.initialDelay$set = true;
            return this;
        }

        public StatusCodeAndExceptionRetryBuilder isAcceptable(Function<HttpResponse, Boolean> function) {
            this.isAcceptable$value = function;
            this.isAcceptable$set = true;
            return this;
        }

        public StatusCodeAndExceptionRetryBuilder isRetryable(Function<HttpResponse, Boolean> function) {
            this.isRetryable$value = function;
            this.isRetryable$set = true;
            return this;
        }

        public StatusCodeAndExceptionRetryBuilder isRetryableException(Function<Exception, Boolean> function) {
            this.isRetryableException$value = function;
            this.isRetryableException$set = true;
            return this;
        }

        public StatusCodeAndExceptionRetryBuilder number(int i) {
            this.number$value = i;
            this.number$set = true;
            return this;
        }

        public String toString() {
            return "StatusCodeAndExceptionRetry.StatusCodeAndExceptionRetryBuilder(isRetryableException$value=" + this.isRetryableException$value + ", isRetryable$value=" + this.isRetryable$value + ", isAcceptable$value=" + this.isAcceptable$value + ", number$value=" + this.number$value + ", initialDelay$value=" + this.initialDelay$value + ", extensionFactor$value=" + this.extensionFactor$value + ")";
        }
    }

    public StatusCodeAndExceptionRetry(Function<Exception, Boolean> function, Function<HttpResponse, Boolean> function2, Function<HttpResponse, Boolean> function3, int i, int i2, int i3) {
        this.isRetryableException = function;
        this.isRetryable = function2;
        this.isAcceptable = function3;
        this.number = i;
        this.initialDelay = i2;
        this.extensionFactor = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Function<HttpResponse, Boolean> $default$isAcceptable() {
        return new Function<HttpResponse, Boolean>() { // from class: com.microsoft.identity.common.java.net.StatusCodeAndExceptionRetry.3
            @Override // com.microsoft.identity.common.java.util.ported.Function
            public Boolean apply(HttpResponse httpResponse) {
                return Boolean.TRUE;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Function<HttpResponse, Boolean> $default$isRetryable() {
        return new Function<HttpResponse, Boolean>() { // from class: com.microsoft.identity.common.java.net.StatusCodeAndExceptionRetry.2
            @Override // com.microsoft.identity.common.java.util.ported.Function
            public Boolean apply(HttpResponse httpResponse) {
                return Boolean.FALSE;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Function<Exception, Boolean> $default$isRetryableException() {
        return new Function<Exception, Boolean>() { // from class: com.microsoft.identity.common.java.net.StatusCodeAndExceptionRetry.1
            @Override // com.microsoft.identity.common.java.util.ported.Function
            public Boolean apply(Exception exc) {
                return Boolean.FALSE;
            }
        };
    }

    public static StatusCodeAndExceptionRetryBuilder builder() {
        return new StatusCodeAndExceptionRetryBuilder();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.identity.common.java.net.IRetryPolicy
    public HttpResponse attempt(Callable<HttpResponse> callable) throws ClientException {
        HttpResponse httpResponseCall;
        int i = this.number;
        int i2 = this.initialDelay;
        while (true) {
            try {
                httpResponseCall = callable.call();
                if (i <= 0 || this.isAcceptable.apply(httpResponseCall).booleanValue() || !this.isRetryable.apply(httpResponseCall).booleanValue()) {
                    break;
                }
            } catch (Exception e) {
                if (i <= 0 || !this.isRetryableException.apply(e).booleanValue()) {
                    if (e instanceof ClientException) {
                        throw ((ClientException) e);
                    }
                    throw new RetryFailedException(e);
                }
            }
            int i3 = i - 1;
            if (i <= 0 || !waited(i2) || (i2 = i2 * this.extensionFactor) <= 0) {
                throw new IllegalStateException("This code should not be reachable");
            }
            i = i3;
        }
        return httpResponseCall;
    }

    private boolean waited(int i) {
        try {
            Thread.sleep(i);
            return true;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return false;
        }
    }
}
