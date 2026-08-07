package org.jose4j.jwt;

import java.text.DateFormat;
import java.util.Date;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jose4j.lang.Maths;

/* JADX INFO: loaded from: classes5.dex */
public class NumericDate {
    private static final long CONVERSION = 1000;
    private long value;

    private NumericDate(long j) {
        setValue(j);
    }

    public static NumericDate now() {
        return fromMilliseconds(System.currentTimeMillis());
    }

    public static NumericDate fromSeconds(long j) {
        return new NumericDate(j);
    }

    public static NumericDate fromMilliseconds(long j) {
        return fromSeconds(j / 1000);
    }

    public void addSeconds(long j) {
        setValue(Maths.add(this.value, j));
    }

    public long getValue() {
        return this.value;
    }

    public void setValue(long j) {
        this.value = j;
    }

    public long getValueInMillis() {
        long value = getValue();
        long j = 1000 * value;
        if (canConvertToMillis()) {
            return j;
        }
        throw new ArithmeticException("converting " + value + " seconds to milliseconds (x1000) resulted in long integer overflow (" + j + ")");
    }

    private boolean canConvertToMillis() {
        long value = getValue();
        long j = 1000 * value;
        if ((value <= 0 || j >= value) && (value >= 0 || j <= value)) {
            if (!((value == 0) & (j != 0))) {
                return true;
            }
        }
        return false;
    }

    public boolean isBefore(NumericDate numericDate) {
        return this.value < numericDate.getValue();
    }

    public boolean isOnOrAfter(NumericDate numericDate) {
        return !isBefore(numericDate);
    }

    public boolean isAfter(NumericDate numericDate) {
        return this.value > numericDate.getValue();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NumericDate{");
        sb.append(getValue());
        if (canConvertToMillis()) {
            sb.append(" -> ").append(DateFormat.getDateTimeInstance(2, 1).format(new Date(getValueInMillis())));
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof NumericDate) && this.value == ((NumericDate) obj).value;
        }
        return true;
    }

    public int hashCode() {
        long j = this.value;
        return (int) (j ^ (j >>> 32));
    }
}
