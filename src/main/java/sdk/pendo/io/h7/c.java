package sdk.pendo.io.h7;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0017B\u0011\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\t\u0010\u0006\u001a\u00020\u0002HÖ\u0001J\t\u0010\b\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0013\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\f\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\r\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u001a"}, d2 = {"Lsdk/pendo/io/h7/c;", "", "", "f", "", "e", "toString", "", "hashCode", "other", "equals", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "F", "d", "()F", ViewProps.TOP, "b", "c", "right", ViewProps.BOTTOM, "left", "<init>", "(FFFF)V", "all", "(F)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final /* data */ class c {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final float top;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final float right;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final float bottom;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final float left;

    public c(float f) {
        this(f, f, f, f);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final float getBottom() {
        return this.bottom;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final float getLeft() {
        return this.left;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final float getRight() {
        return this.right;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final float getTop() {
        return this.top;
    }

    public final boolean e() {
        float f = this.top;
        float f2 = this.right;
        if (f != f2) {
            return false;
        }
        float f3 = this.bottom;
        return f2 == f3 && f3 == this.left;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof c)) {
            return false;
        }
        c cVar = (c) other;
        return Float.compare(this.top, cVar.top) == 0 && Float.compare(this.right, cVar.right) == 0 && Float.compare(this.bottom, cVar.bottom) == 0 && Float.compare(this.left, cVar.left) == 0;
    }

    public final String f() {
        return this.top + "px " + this.right + "px " + this.bottom + "px " + this.left + "px";
    }

    public int hashCode() {
        return (((((Float.hashCode(this.top) * 31) + Float.hashCode(this.right)) * 31) + Float.hashCode(this.bottom)) * 31) + Float.hashCode(this.left);
    }

    public String toString() {
        return "BorderWidth(top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ", left=" + this.left + ")";
    }

    public c(float f, float f2, float f3, float f4) {
        this.top = f;
        this.right = f2;
        this.bottom = f3;
        this.left = f4;
    }
}
