package dev.chrisbanes.haze;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Bitmask.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\u0081@\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0003H\u0086\u0002¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0003H\u0086\u0002¢\u0006\u0004\b\u000b\u0010\tJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0003H\u0086\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u000fJ\r\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u001a"}, d2 = {"Ldev/chrisbanes/haze/Bitmask;", "", "value", "", "constructor-impl", "(I)I", "plus", "flag", "plus-HWHKK88", "(II)I", "minus", "minus-HWHKK88", "contains", "", "contains-impl", "(II)Z", "any", "any-impl", "isEmpty", "isEmpty-impl", "(I)Z", "equals", "other", "hashCode", "toString", "", "haze_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class Bitmask {
    private final int value;

    /* JADX INFO: renamed from: any-impl, reason: not valid java name */
    public static final boolean m14431anyimpl(int i, int i2) {
        return (i & i2) != 0;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Bitmask m14432boximpl(int i) {
        return new Bitmask(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m14433constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: contains-impl, reason: not valid java name */
    public static final boolean m14435containsimpl(int i, int i2) {
        return (i & i2) == i2;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m14436equalsimpl(int i, Object obj) {
        return (obj instanceof Bitmask) && i == ((Bitmask) obj).getValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m14437equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m14438hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: isEmpty-impl, reason: not valid java name */
    public static final boolean m14439isEmptyimpl(int i) {
        return i == 0;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m14442toStringimpl(int i) {
        return "Bitmask(value=" + i + ")";
    }

    public boolean equals(Object other) {
        return m14436equalsimpl(this.value, other);
    }

    public int hashCode() {
        return m14438hashCodeimpl(this.value);
    }

    public String toString() {
        return m14442toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    private /* synthetic */ Bitmask(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ int m14434constructorimpl$default(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return m14433constructorimpl(i);
    }

    /* JADX INFO: renamed from: plus-HWHKK88, reason: not valid java name */
    public static final int m14441plusHWHKK88(int i, int i2) {
        return m14433constructorimpl(i | i2);
    }

    /* JADX INFO: renamed from: minus-HWHKK88, reason: not valid java name */
    public static final int m14440minusHWHKK88(int i, int i2) {
        return m14433constructorimpl(i & (~i2));
    }
}
