package zipkin2.internal;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public final class DelayLimiter<C> {
    final int cardinality;
    final SuppressionFactory suppressionFactory;
    final ConcurrentHashMap<C, Suppression<C>> cache = new ConcurrentHashMap<>();
    final DelayQueue<Suppression<C>> suppressions = new DelayQueue<>();

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        long ttl = 0;
        TimeUnit ttlUnit = TimeUnit.MILLISECONDS;
        int cardinality = 0;

        public Builder ttl(long j, TimeUnit timeUnit) {
            if (timeUnit == null) {
                throw new NullPointerException("ttlUnit == null");
            }
            this.ttl = j;
            this.ttlUnit = timeUnit;
            return this;
        }

        public Builder cardinality(int i) {
            this.cardinality = i;
            return this;
        }

        public <C> DelayLimiter<C> build() {
            if (this.ttl <= 0) {
                throw new IllegalArgumentException("ttl <= 0");
            }
            if (this.cardinality <= 0) {
                throw new IllegalArgumentException("cardinality <= 0");
            }
            return new DelayLimiter<>(new SuppressionFactory(this.ttlUnit.toNanos(this.ttl)), this.cardinality);
        }

        Builder() {
        }
    }

    DelayLimiter(SuppressionFactory suppressionFactory, int i) {
        this.suppressionFactory = suppressionFactory;
        this.cardinality = i;
    }

    public boolean shouldInvoke(C c) {
        cleanupExpiredSuppressions();
        if (this.cache.containsKey(c)) {
            return false;
        }
        Suppression<C> suppressionCreate = this.suppressionFactory.create(c);
        if (this.cache.putIfAbsent(c, suppressionCreate) != null) {
            return false;
        }
        this.suppressions.offer(suppressionCreate);
        if (this.suppressions.size() <= this.cardinality) {
            return true;
        }
        removeOneSuppression();
        return true;
    }

    void removeOneSuppression() {
        Suppression suppression;
        do {
            suppression = (Suppression) this.suppressions.peek();
            if (suppression == null) {
                return;
            }
        } while (!this.suppressions.remove(suppression));
        this.cache.remove(suppression.context, suppression);
    }

    public void invalidate(C c) {
        Suppression<C> suppressionRemove = this.cache.remove(c);
        if (suppressionRemove != null) {
            this.suppressions.remove(suppressionRemove);
        }
    }

    public void clear() {
        this.cache.clear();
        this.suppressions.clear();
    }

    void cleanupExpiredSuppressions() {
        while (true) {
            Suppression suppression = (Suppression) this.suppressions.poll();
            if (suppression == null) {
                return;
            } else {
                this.cache.remove(suppression.context, suppression);
            }
        }
    }

    static class SuppressionFactory {
        final long ttlNanos;

        SuppressionFactory(long j) {
            this.ttlNanos = j;
        }

        long nanoTime() {
            return System.nanoTime();
        }

        <C> Suppression<C> create(C c) {
            return new Suppression<>(this, c, nanoTime() + this.ttlNanos);
        }
    }

    static final class Suppression<C> implements Delayed {
        final C context;
        final long expiration;
        final SuppressionFactory factory;

        Suppression(SuppressionFactory suppressionFactory, C c, long j) {
            this.factory = suppressionFactory;
            this.context = c;
            this.expiration = j;
        }

        @Override // java.util.concurrent.Delayed
        public long getDelay(TimeUnit timeUnit) {
            return timeUnit.convert(this.expiration - this.factory.nanoTime(), TimeUnit.NANOSECONDS);
        }

        @Override // java.lang.Comparable
        public int compareTo(Delayed delayed) {
            return Long.signum(this.expiration - ((Suppression) delayed).expiration);
        }
    }
}
