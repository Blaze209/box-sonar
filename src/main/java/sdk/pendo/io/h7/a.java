package sdk.pendo.io.h7;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018B\u0011\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0007J\t\u0010\t\u001a\u00020\u0004HÖ\u0001J\t\u0010\n\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u0005\u0010\u000eR\u0017\u0010\u0011\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\r\u001a\u0004\b\u0010\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\r\u001a\u0004\b\u0012\u0010\u000eR\u0017\u0010\u0016\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000e¨\u0006\u001b"}, d2 = {"Lsdk/pendo/io/h7/a;", "", "", "color", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "c", "", "b", "toString", "hashCode", "other", "equals", "I", "()I", ViewProps.TOP, "getRight", "right", "getBottom", ViewProps.BOTTOM, "d", "getLeft", "left", "<init>", "(IIII)V", "all", "(I)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final /* data */ class a {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final int top;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final int right;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final int bottom;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final int left;

    public a(int i) {
        this(i, i, i, i);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getTop() {
        return this.top;
    }

    public final boolean b() {
        int i;
        int i2 = this.top;
        int i3 = this.right;
        return i2 == i3 && i3 == (i = this.bottom) && i == this.left;
    }

    public final String c() {
        return a(this.top) + " " + a(this.right) + " " + a(this.bottom) + " " + a(this.left);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        return this.top == aVar.top && this.right == aVar.right && this.bottom == aVar.bottom && this.left == aVar.left;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.top) * 31) + Integer.hashCode(this.right)) * 31) + Integer.hashCode(this.bottom)) * 31) + Integer.hashCode(this.left);
    }

    public String toString() {
        return "BorderColor(top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ", left=" + this.left + ")";
    }

    public a(int i, int i2, int i3, int i4) {
        this.top = i;
        this.right = i2;
        this.bottom = i3;
        this.left = i4;
    }

    private final String a(int color) {
        String hexString = Integer.toHexString(color);
        Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(...)");
        String strSubstring = StringsKt.padStart(hexString, 8, '0').substring(2);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
        return "#" + strSubstring;
    }
}
