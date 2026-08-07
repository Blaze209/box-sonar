package sdk.pendo.io.h7;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0080\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018JE\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0002HÆ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\t\u0010\f\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0013\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\t\u0010\u0012¨\u0006\u0019"}, d2 = {"Lsdk/pendo/io/h7/p;", "", "", "width", "height", "leftInset", "topInset", "rightInset", "bottomInset", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "toString", "hashCode", "other", "", "equals", "I", "f", "()I", "b", "c", "d", "e", "<init>", "(IIIIII)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final /* data */ class p {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final int width;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final int height;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final int leftInset;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final int topInset;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final int rightInset;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final int bottomInset;

    public p(int i, int i2, int i3, int i4, int i5, int i6) {
        this.width = i;
        this.height = i2;
        this.leftInset = i3;
        this.topInset = i4;
        this.rightInset = i5;
        this.bottomInset = i6;
    }

    public final p a(int width, int height, int leftInset, int topInset, int rightInset, int bottomInset) {
        return new p(width, height, leftInset, topInset, rightInset, bottomInset);
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final int getLeftInset() {
        return this.leftInset;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final int getRightInset() {
        return this.rightInset;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final int getTopInset() {
        return this.topInset;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof p)) {
            return false;
        }
        p pVar = (p) other;
        return this.width == pVar.width && this.height == pVar.height && this.leftInset == pVar.leftInset && this.topInset == pVar.topInset && this.rightInset == pVar.rightInset && this.bottomInset == pVar.bottomInset;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.width) * 31) + Integer.hashCode(this.height)) * 31) + Integer.hashCode(this.leftInset)) * 31) + Integer.hashCode(this.topInset)) * 31) + Integer.hashCode(this.rightInset)) * 31) + Integer.hashCode(this.bottomInset);
    }

    public String toString() {
        return "SRDisplay(width=" + this.width + ", height=" + this.height + ", leftInset=" + this.leftInset + ", topInset=" + this.topInset + ", rightInset=" + this.rightInset + ", bottomInset=" + this.bottomInset + ")";
    }

    public static /* synthetic */ p a(p pVar, int i, int i2, int i3, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i = pVar.width;
        }
        if ((i7 & 2) != 0) {
            i2 = pVar.height;
        }
        if ((i7 & 4) != 0) {
            i3 = pVar.leftInset;
        }
        if ((i7 & 8) != 0) {
            i4 = pVar.topInset;
        }
        if ((i7 & 16) != 0) {
            i5 = pVar.rightInset;
        }
        if ((i7 & 32) != 0) {
            i6 = pVar.bottomInset;
        }
        int i8 = i5;
        int i9 = i6;
        return pVar.a(i, i2, i3, i4, i8, i9);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getBottomInset() {
        return this.bottomInset;
    }
}
