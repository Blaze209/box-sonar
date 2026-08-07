package io.reactivex.rxjava3.observers;

import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.VolatileSizeArrayList;
import io.reactivex.rxjava3.observers.BaseTestConsumer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseTestConsumer<T, U extends BaseTestConsumer<T, U>> {
    protected boolean checkSubscriptionOnce;
    protected long completions;
    protected Thread lastThread;
    protected CharSequence tag;
    protected boolean timeout;
    protected final List<T> values = new VolatileSizeArrayList();
    protected final List<Throwable> errors = new VolatileSizeArrayList();
    protected final CountDownLatch done = new CountDownLatch(1);

    protected abstract U assertSubscribed();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void dispose();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean isDisposed();

    public final List<T> values() {
        return this.values;
    }

    protected final AssertionError fail(String message) {
        StringBuilder sb = new StringBuilder(message.length() + 64);
        sb.append(message);
        sb.append(" (latch = ").append(this.done.getCount()).append(", values = ").append(this.values.size()).append(", errors = ").append(this.errors.size()).append(", completions = ").append(this.completions);
        if (this.timeout) {
            sb.append(", timeout!");
        }
        if (isDisposed()) {
            sb.append(", disposed!");
        }
        CharSequence charSequence = this.tag;
        if (charSequence != null) {
            sb.append(", tag = ").append(charSequence);
        }
        sb.append(')');
        AssertionError assertionError = new AssertionError(sb.toString());
        if (!this.errors.isEmpty()) {
            if (this.errors.size() == 1) {
                assertionError.initCause(this.errors.get(0));
                return assertionError;
            }
            assertionError.initCause(new CompositeException(this.errors));
        }
        return assertionError;
    }

    public final U await() throws InterruptedException {
        if (this.done.getCount() == 0) {
            return this;
        }
        this.done.await();
        return this;
    }

    public final boolean await(long time, TimeUnit unit) throws InterruptedException {
        boolean z = this.done.getCount() == 0 || this.done.await(time, unit);
        this.timeout = !z;
        return z;
    }

    public final U assertComplete() {
        long j = this.completions;
        if (j == 0) {
            throw fail("Not completed");
        }
        if (j <= 1) {
            return this;
        }
        throw fail("Multiple completions: " + j);
    }

    public final U assertNotComplete() {
        long j = this.completions;
        if (j == 1) {
            throw fail("Completed!");
        }
        if (j <= 1) {
            return this;
        }
        throw fail("Multiple completions: " + j);
    }

    public final U assertNoErrors() {
        if (this.errors.size() == 0) {
            return this;
        }
        throw fail("Error(s) present: " + this.errors);
    }

    public final U assertError(Throwable th) {
        return (U) assertError(Functions.equalsWith(th), true);
    }

    public final U assertError(Class<? extends Throwable> cls) {
        return (U) assertError(Functions.isInstanceOf(cls), true);
    }

    public final U assertError(Predicate<Throwable> predicate) {
        return (U) assertError(predicate, false);
    }

    private U assertError(Predicate<Throwable> errorPredicate, boolean exact) {
        int size = this.errors.size();
        if (size == 0) {
            throw fail("No errors");
        }
        Iterator<Throwable> it = this.errors.iterator();
        while (it.hasNext()) {
            try {
                if (errorPredicate.test(it.next())) {
                    if (size == 1) {
                        return this;
                    }
                    if (exact) {
                        throw fail("Error present but other errors as well");
                    }
                    throw fail("One error passed the predicate but other errors are present as well");
                }
            } catch (Throwable th) {
                throw ExceptionHelper.wrapOrThrow(th);
            }
        }
        if (exact) {
            throw fail("Error not present");
        }
        throw fail("No error(s) passed the predicate");
    }

    public final U assertValue(T value) {
        if (this.values.size() != 1) {
            throw fail("\nexpected: " + valueAndClass(value) + "\ngot: " + this.values);
        }
        T t = this.values.get(0);
        if (Objects.equals(value, t)) {
            return this;
        }
        throw fail("\nexpected: " + valueAndClass(value) + "\ngot: " + valueAndClass(t));
    }

    public final U assertValue(Predicate<T> valuePredicate) {
        assertValueAt(0, (Predicate) valuePredicate);
        if (this.values.size() <= 1) {
            return this;
        }
        throw fail("The first value passed the predicate but this consumer received more than one value");
    }

    public final U assertValueAt(int index, T value) {
        int size = this.values.size();
        if (size == 0) {
            throw fail("No values");
        }
        if (index < 0 || index >= size) {
            throw fail("Index " + index + " is out of range [0, " + size + ")");
        }
        T t = this.values.get(index);
        if (Objects.equals(value, t)) {
            return this;
        }
        throw fail("\nexpected: " + valueAndClass(value) + "\ngot: " + valueAndClass(t) + "; Value at position " + index + " differ");
    }

    public final U assertValueAt(int index, Predicate<T> valuePredicate) {
        int size = this.values.size();
        if (size == 0) {
            throw fail("No values");
        }
        if (index < 0 || index >= size) {
            throw fail("Index " + index + " is out of range [0, " + size + ")");
        }
        T t = this.values.get(index);
        try {
            if (valuePredicate.test(t)) {
                return this;
            }
            throw fail("Value " + valueAndClass(t) + " at position " + index + " did not pass the predicate");
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    public static String valueAndClass(Object o) {
        if (o != null) {
            return o + " (class: " + o.getClass().getSimpleName() + ")";
        }
        return AbstractJsonLexerKt.NULL;
    }

    public final U assertValueCount(int count) {
        int size = this.values.size();
        if (size == count) {
            return this;
        }
        throw fail("\nexpected: " + count + "\ngot: " + size + "; Value counts differ");
    }

    public final U assertNoValues() {
        return (U) assertValueCount(0);
    }

    @SafeVarargs
    public final U assertValues(T... values) {
        int size = this.values.size();
        if (size != values.length) {
            throw fail("\nexpected: " + values.length + " " + Arrays.toString(values) + "\ngot: " + size + " " + this.values + "; Value count differs");
        }
        for (int i = 0; i < size; i++) {
            T t = this.values.get(i);
            T t2 = values[i];
            if (!Objects.equals(t2, t)) {
                throw fail("\nexpected: " + valueAndClass(t2) + "\ngot: " + valueAndClass(t) + "; Value at position " + i + " differ");
            }
        }
        return this;
    }

    @SafeVarargs
    public final U assertValuesOnly(T... tArr) {
        return (U) assertSubscribed().assertValues(tArr).assertNoErrors().assertNotComplete();
    }

    public final U assertValueSequence(Iterable<? extends T> sequence) {
        boolean zHasNext;
        boolean zHasNext2;
        Iterator<T> it = this.values.iterator();
        Iterator<? extends T> it2 = sequence.iterator();
        int i = 0;
        while (true) {
            zHasNext = it2.hasNext();
            zHasNext2 = it.hasNext();
            if (!zHasNext2 || !zHasNext) {
                break;
            }
            T next = it2.next();
            T next2 = it.next();
            if (!Objects.equals(next, next2)) {
                throw fail("\nexpected: " + valueAndClass(next) + "\ngot: " + valueAndClass(next2) + "; Value at position " + i + " differ");
            }
            i++;
        }
        if (zHasNext2) {
            throw fail("More values received than expected (" + i + ")");
        }
        if (zHasNext) {
            throw fail("Fewer values received than expected (" + i + ")");
        }
        return this;
    }

    @SafeVarargs
    public final U assertResult(T... tArr) {
        return (U) assertSubscribed().assertValues(tArr).assertNoErrors().assertComplete();
    }

    @SafeVarargs
    public final U assertFailure(Class<? extends Throwable> cls, T... tArr) {
        return (U) assertSubscribed().assertValues(tArr).assertError(cls).assertNotComplete();
    }

    public final U awaitDone(long time, TimeUnit unit) {
        try {
            if (!this.done.await(time, unit)) {
                this.timeout = true;
                dispose();
            }
            return this;
        } catch (InterruptedException e) {
            dispose();
            throw ExceptionHelper.wrapOrThrow(e);
        }
    }

    public final U assertEmpty() {
        return (U) assertSubscribed().assertNoValues().assertNoErrors().assertNotComplete();
    }

    public final U withTag(CharSequence tag) {
        this.tag = tag;
        return this;
    }

    public final U awaitCount(int atLeast) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        while (System.currentTimeMillis() - jCurrentTimeMillis < 5000) {
            if (this.done.getCount() == 0 || this.values.size() >= atLeast) {
                return this;
            }
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.timeout = true;
        return this;
    }
}
