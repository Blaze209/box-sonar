package androidx.compose.ui.node;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MyersDiff.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0083@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0086\u0002¢\u0006\u0004\b\f\u0010\rJ \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0086\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/node/CenteredArray;", "", "data", "", "constructor-impl", "([I)[I", "mid", "", "getMid-impl", "([I)I", PasskeyWebListener.GET_UNIQUE_KEY, FirebaseAnalytics.Param.INDEX, "get-impl", "([II)I", "set", "", "value", "set-impl", "([III)V", "equals", "", "other", "hashCode", "toString", "", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
final class CenteredArray {
    private final int[] data;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ CenteredArray m8420boximpl(int[] iArr) {
        return new CenteredArray(iArr);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int[] m8421constructorimpl(int[] iArr) {
        return iArr;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m8422equalsimpl(int[] iArr, Object obj) {
        return (obj instanceof CenteredArray) && Intrinsics.areEqual(iArr, ((CenteredArray) obj).getData());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m8423equalsimpl0(int[] iArr, int[] iArr2) {
        return Intrinsics.areEqual(iArr, iArr2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m8426hashCodeimpl(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m8428toStringimpl(int[] iArr) {
        return "CenteredArray(data=" + Arrays.toString(iArr) + ')';
    }

    public boolean equals(Object other) {
        return m8422equalsimpl(this.data, other);
    }

    public int hashCode() {
        return m8426hashCodeimpl(this.data);
    }

    public String toString() {
        return m8428toStringimpl(this.data);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int[] getData() {
        return this.data;
    }

    private /* synthetic */ CenteredArray(int[] iArr) {
        this.data = iArr;
    }

    /* JADX INFO: renamed from: getMid-impl, reason: not valid java name */
    private static final int m8425getMidimpl(int[] iArr) {
        return iArr.length / 2;
    }

    /* JADX INFO: renamed from: get-impl, reason: not valid java name */
    public static final int m8424getimpl(int[] iArr, int i) {
        return iArr[i + m8425getMidimpl(iArr)];
    }

    /* JADX INFO: renamed from: set-impl, reason: not valid java name */
    public static final void m8427setimpl(int[] iArr, int i, int i2) {
        iArr[i + m8425getMidimpl(iArr)] = i2;
    }
}
