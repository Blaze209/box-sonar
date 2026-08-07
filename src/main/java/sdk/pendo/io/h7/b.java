package sdk.pendo.io.h7;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\n¢\u0006\u0004\b\u0015\u0010\u0016B\u0011\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\n¢\u0006\u0004\b\u0015\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0004\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0006\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\r\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000b\u0010\u000e¨\u0006\u0019"}, d2 = {"Lsdk/pendo/io/h7/b;", "", "", "e", "toString", "", "hashCode", "other", "", "equals", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "F", "c", "()F", "topLeft", "b", "d", "topRight", "bottomRight", "bottomLeft", "<init>", "(FFFF)V", "all", "(F)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final /* data */ class b {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final float topLeft;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final float topRight;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final float bottomRight;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final float bottomLeft;

    public b(float f) {
        this(f, f, f, f);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final float getBottomLeft() {
        return this.bottomLeft;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final float getBottomRight() {
        return this.bottomRight;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final float getTopLeft() {
        return this.topLeft;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final float getTopRight() {
        return this.topRight;
    }

    public final String e() {
        return this.topLeft + "px " + this.topRight + "px " + this.bottomRight + "px " + this.bottomLeft + "px";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof b)) {
            return false;
        }
        b bVar = (b) other;
        return Float.compare(this.topLeft, bVar.topLeft) == 0 && Float.compare(this.topRight, bVar.topRight) == 0 && Float.compare(this.bottomRight, bVar.bottomRight) == 0 && Float.compare(this.bottomLeft, bVar.bottomLeft) == 0;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.topLeft) * 31) + Float.hashCode(this.topRight)) * 31) + Float.hashCode(this.bottomRight)) * 31) + Float.hashCode(this.bottomLeft);
    }

    public String toString() {
        return "BorderRadius(topLeft=" + this.topLeft + ", topRight=" + this.topRight + ", bottomRight=" + this.bottomRight + ", bottomLeft=" + this.bottomLeft + ")";
    }

    public b(float f, float f2, float f3, float f4) {
        this.topLeft = f;
        this.topRight = f2;
        this.bottomRight = f3;
        this.bottomLeft = f4;
    }
}
