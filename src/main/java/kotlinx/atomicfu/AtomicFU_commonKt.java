package kotlinx.atomicfu;

import android.R;
import androidx.exifinterface.media.ExifInterface;
import com.pspdfkit.analytics.Analytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AtomicFU.common.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a$\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\tH\u0086\bø\u0001\u0000\u001a$\u0010\u0005\u001a\u00020\u0004*\u00020\n2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\tH\u0086\bø\u0001\u0000\u001a$\u0010\u0005\u001a\u00020\u000b*\u00020\f2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\tH\u0086\bø\u0001\u0000\u001a5\u0010\u0005\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\r2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00020\tH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a$\u0010\u000f\u001a\u00020\u0010*\u00020\u00072\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00120\tH\u0086\bø\u0001\u0000\u001a$\u0010\u000f\u001a\u00020\u0010*\u00020\n2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\tH\u0086\bø\u0001\u0000\u001a$\u0010\u000f\u001a\u00020\u0010*\u00020\f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00120\tH\u0086\bø\u0001\u0000\u001a0\u0010\u000f\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\r2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00120\tH\u0086\bø\u0001\u0000\u001a$\u0010\u0013\u001a\u00020\u0012*\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\tH\u0086\bø\u0001\u0000\u001a$\u0010\u0013\u001a\u00020\u0012*\u00020\n2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\tH\u0086\bø\u0001\u0000\u001a$\u0010\u0013\u001a\u00020\u0012*\u00020\f2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\tH\u0086\bø\u0001\u0000\u001a0\u0010\u0013\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\r2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00020\tH\u0086\bø\u0001\u0000\u001a$\u0010\u0014\u001a\u00020\u0006*\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\tH\u0086\bø\u0001\u0000\u001a$\u0010\u0014\u001a\u00020\u0004*\u00020\n2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\tH\u0086\bø\u0001\u0000\u001a$\u0010\u0014\u001a\u00020\u000b*\u00020\f2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\tH\u0086\bø\u0001\u0000\u001a5\u0010\u0014\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\r2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00020\tH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0015"}, d2 = {"atomicArrayOfNulls", "Lkotlinx/atomicfu/AtomicArray;", ExifInterface.GPS_DIRECTION_TRUE, "size", "", "getAndUpdate", "", "Lkotlinx/atomicfu/AtomicBoolean;", "function", "Lkotlin/Function1;", "Lkotlinx/atomicfu/AtomicInt;", "", "Lkotlinx/atomicfu/AtomicLong;", "Lkotlinx/atomicfu/AtomicRef;", "(Lkotlinx/atomicfu/AtomicRef;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "loop", "", Analytics.Data.ACTION, "", "update", "updateAndGet", "atomicfu"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class AtomicFU_commonKt {
    public static final <T> AtomicArray<T> atomicArrayOfNulls(int i) {
        return new AtomicArray<>(i);
    }

    public static final <T> Void loop(AtomicRef<T> atomicRef, Function1<? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(atomicRef, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        while (true) {
            action.invoke(atomicRef.getValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void update(AtomicRef<T> atomicRef, Function1<? super T, ? extends T> function) {
        R.anim animVar;
        Intrinsics.checkNotNullParameter(atomicRef, "<this>");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            animVar = (Object) atomicRef.getValue();
        } while (!atomicRef.compareAndSet(animVar, function.invoke(animVar)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
    public static final <T> T getAndUpdate(AtomicRef<T> atomicRef, Function1<? super T, ? extends T> function) {
        ?? r0;
        Intrinsics.checkNotNullParameter(atomicRef, "<this>");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            r0 = (Object) atomicRef.getValue();
        } while (!atomicRef.compareAndSet(r0, function.invoke(r0)));
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T updateAndGet(AtomicRef<T> atomicRef, Function1<? super T, ? extends T> function) {
        R.anim animVar;
        T tInvoke;
        Intrinsics.checkNotNullParameter(atomicRef, "<this>");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            animVar = (Object) atomicRef.getValue();
            tInvoke = function.invoke(animVar);
        } while (!atomicRef.compareAndSet(animVar, tInvoke));
        return tInvoke;
    }

    public static final Void loop(AtomicBoolean atomicBoolean, Function1<? super Boolean, Unit> action) {
        Intrinsics.checkNotNullParameter(atomicBoolean, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        while (true) {
            action.invoke(Boolean.valueOf(atomicBoolean.getValue()));
        }
    }

    public static final void update(AtomicBoolean atomicBoolean, Function1<? super Boolean, Boolean> function) {
        boolean value;
        Intrinsics.checkNotNullParameter(atomicBoolean, "<this>");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            value = atomicBoolean.getValue();
        } while (!atomicBoolean.compareAndSet(value, function.invoke(Boolean.valueOf(value)).booleanValue()));
    }

    public static final boolean getAndUpdate(AtomicBoolean atomicBoolean, Function1<? super Boolean, Boolean> function) {
        boolean value;
        Intrinsics.checkNotNullParameter(atomicBoolean, "<this>");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            value = atomicBoolean.getValue();
        } while (!atomicBoolean.compareAndSet(value, function.invoke(Boolean.valueOf(value)).booleanValue()));
        return value;
    }

    public static final boolean updateAndGet(AtomicBoolean atomicBoolean, Function1<? super Boolean, Boolean> function) {
        boolean value;
        boolean zBooleanValue;
        Intrinsics.checkNotNullParameter(atomicBoolean, "<this>");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            value = atomicBoolean.getValue();
            zBooleanValue = function.invoke(Boolean.valueOf(value)).booleanValue();
        } while (!atomicBoolean.compareAndSet(value, zBooleanValue));
        return zBooleanValue;
    }

    public static final Void loop(AtomicInt atomicInt, Function1<? super Integer, Unit> action) {
        Intrinsics.checkNotNullParameter(atomicInt, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        while (true) {
            action.invoke(Integer.valueOf(atomicInt.getValue()));
        }
    }

    public static final void update(AtomicInt atomicInt, Function1<? super Integer, Integer> function) {
        int value;
        Intrinsics.checkNotNullParameter(atomicInt, "<this>");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            value = atomicInt.getValue();
        } while (!atomicInt.compareAndSet(value, function.invoke(Integer.valueOf(value)).intValue()));
    }

    public static final int getAndUpdate(AtomicInt atomicInt, Function1<? super Integer, Integer> function) {
        int value;
        Intrinsics.checkNotNullParameter(atomicInt, "<this>");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            value = atomicInt.getValue();
        } while (!atomicInt.compareAndSet(value, function.invoke(Integer.valueOf(value)).intValue()));
        return value;
    }

    public static final int updateAndGet(AtomicInt atomicInt, Function1<? super Integer, Integer> function) {
        int value;
        int iIntValue;
        Intrinsics.checkNotNullParameter(atomicInt, "<this>");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            value = atomicInt.getValue();
            iIntValue = function.invoke(Integer.valueOf(value)).intValue();
        } while (!atomicInt.compareAndSet(value, iIntValue));
        return iIntValue;
    }

    public static final Void loop(AtomicLong atomicLong, Function1<? super Long, Unit> action) {
        Intrinsics.checkNotNullParameter(atomicLong, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        while (true) {
            action.invoke(Long.valueOf(atomicLong.getValue()));
        }
    }

    public static final void update(AtomicLong atomicLong, Function1<? super Long, Long> function) {
        long value;
        Intrinsics.checkNotNullParameter(atomicLong, "<this>");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            value = atomicLong.getValue();
        } while (!atomicLong.compareAndSet(value, function.invoke(Long.valueOf(value)).longValue()));
    }

    public static final long getAndUpdate(AtomicLong atomicLong, Function1<? super Long, Long> function) {
        long value;
        Intrinsics.checkNotNullParameter(atomicLong, "<this>");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            value = atomicLong.getValue();
        } while (!atomicLong.compareAndSet(value, function.invoke(Long.valueOf(value)).longValue()));
        return value;
    }

    public static final long updateAndGet(AtomicLong atomicLong, Function1<? super Long, Long> function) {
        long value;
        long jLongValue;
        Intrinsics.checkNotNullParameter(atomicLong, "<this>");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            value = atomicLong.getValue();
            jLongValue = function.invoke(Long.valueOf(value)).longValue();
        } while (!atomicLong.compareAndSet(value, jLongValue));
        return jLongValue;
    }
}
