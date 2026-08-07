package sdk.pendo.io.b7;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0013\u0012\b\b\u0002\u0010!\u001a\u00020\u0007\u0012\b\b\u0002\u0010#\u001a\u00020\u0007\u0012\b\b\u0002\u0010$\u001a\u00020\u0007\u0012\b\b\u0002\u0010%\u001a\u00020\u0007\u0012\b\b\u0002\u0010'\u001a\u00020\u0007\u0012\b\b\u0002\u0010(\u001a\u00020\u000e¢\u0006\u0004\b)\u0010*J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001a\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u001d\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017R\u0017\u0010!\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010#\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u001e\u001a\u0004\b\"\u0010 R\u0017\u0010$\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001e\u001a\u0004\b\u0019\u0010 R\u0017\u0010%\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\"\u0010\u001e\u001a\u0004\b\u001b\u0010 R\u0017\u0010'\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b&\u0010\u001e\u001a\u0004\b&\u0010 R\u0017\u0010(\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\u0014\u0010\u0011¨\u0006+"}, d2 = {"Lsdk/pendo/io/b7/e;", "", "", "toString", "", "hashCode", "other", "", "equals", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "I", "k", "()I", "targetSize", "", "b", "F", "()F", "borderFraction", "", "c", "D", "g", "()D", "minCoverage", "d", "alphaIgnoreBelow", "e", "f", "gamma", "Z", CmcdData.STREAMING_FORMAT_HLS, "()Z", "preserveAlphaInResult", "i", "returnTransparentWhenNoSignal", "enableFastBackgroundPath", "excludeImageViewContent", "j", "suppressEdges", "edgeThreshold", "<init>", "(IFDIDZZZZZF)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final /* data */ class e {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final int targetSize;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final float borderFraction;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final double minCoverage;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final int alphaIgnoreBelow;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final double gamma;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final boolean preserveAlphaInResult;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final boolean returnTransparentWhenNoSignal;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final boolean enableFastBackgroundPath;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final boolean excludeImageViewContent;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final boolean suppressEdges;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private final float edgeThreshold;

    public e() {
        this(0, 0.0f, 0.0d, 0, 0.0d, false, false, false, false, false, 0.0f, 2047, null);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getAlphaIgnoreBelow() {
        return this.alphaIgnoreBelow;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final float getBorderFraction() {
        return this.borderFraction;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final float getEdgeThreshold() {
        return this.edgeThreshold;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final boolean getEnableFastBackgroundPath() {
        return this.enableFastBackgroundPath;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final boolean getExcludeImageViewContent() {
        return this.excludeImageViewContent;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof e)) {
            return false;
        }
        e eVar = (e) other;
        return this.targetSize == eVar.targetSize && Float.compare(this.borderFraction, eVar.borderFraction) == 0 && Double.compare(this.minCoverage, eVar.minCoverage) == 0 && this.alphaIgnoreBelow == eVar.alphaIgnoreBelow && Double.compare(this.gamma, eVar.gamma) == 0 && this.preserveAlphaInResult == eVar.preserveAlphaInResult && this.returnTransparentWhenNoSignal == eVar.returnTransparentWhenNoSignal && this.enableFastBackgroundPath == eVar.enableFastBackgroundPath && this.excludeImageViewContent == eVar.excludeImageViewContent && this.suppressEdges == eVar.suppressEdges && Float.compare(this.edgeThreshold, eVar.edgeThreshold) == 0;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final double getGamma() {
        return this.gamma;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final double getMinCoverage() {
        return this.minCoverage;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final boolean getPreserveAlphaInResult() {
        return this.preserveAlphaInResult;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r0v19, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((((((Integer.hashCode(this.targetSize) * 31) + Float.hashCode(this.borderFraction)) * 31) + Double.hashCode(this.minCoverage)) * 31) + Integer.hashCode(this.alphaIgnoreBelow)) * 31) + Double.hashCode(this.gamma)) * 31;
        boolean z = this.preserveAlphaInResult;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z2 = this.returnTransparentWhenNoSignal;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z3 = this.enableFastBackgroundPath;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i3 = (i2 + r3) * 31;
        boolean z4 = this.excludeImageViewContent;
        ?? r4 = z4;
        if (z4) {
            r4 = 1;
        }
        int i4 = (i3 + r4) * 31;
        boolean z5 = this.suppressEdges;
        return ((i4 + (z5 ? 1 : z5)) * 31) + Float.hashCode(this.edgeThreshold);
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final boolean getReturnTransparentWhenNoSignal() {
        return this.returnTransparentWhenNoSignal;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final boolean getSuppressEdges() {
        return this.suppressEdges;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final int getTargetSize() {
        return this.targetSize;
    }

    public String toString() {
        return "FillSampleOptions(targetSize=" + this.targetSize + ", borderFraction=" + this.borderFraction + ", minCoverage=" + this.minCoverage + ", alphaIgnoreBelow=" + this.alphaIgnoreBelow + ", gamma=" + this.gamma + ", preserveAlphaInResult=" + this.preserveAlphaInResult + ", returnTransparentWhenNoSignal=" + this.returnTransparentWhenNoSignal + ", enableFastBackgroundPath=" + this.enableFastBackgroundPath + ", excludeImageViewContent=" + this.excludeImageViewContent + ", suppressEdges=" + this.suppressEdges + ", edgeThreshold=" + this.edgeThreshold + ")";
    }

    public e(int i, float f, double d, int i2, double d2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, float f2) {
        this.targetSize = i;
        this.borderFraction = f;
        this.minCoverage = d;
        this.alphaIgnoreBelow = i2;
        this.gamma = d2;
        this.preserveAlphaInResult = z;
        this.returnTransparentWhenNoSignal = z2;
        this.enableFastBackgroundPath = z3;
        this.excludeImageViewContent = z4;
        this.suppressEdges = z5;
        this.edgeThreshold = f2;
    }

    public /* synthetic */ e(int i, float f, double d, int i2, double d2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, float f2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 32 : i, (i3 & 2) != 0 ? 0.18f : f, (i3 & 4) != 0 ? 0.06d : d, (i3 & 8) != 0 ? 8 : i2, (i3 & 16) != 0 ? 1.0d : d2, (i3 & 32) != 0 ? true : z, (i3 & 64) != 0 ? false : z2, (i3 & 128) != 0 ? true : z3, (i3 & 256) != 0 ? true : z4, (i3 & 512) == 0 ? z5 : true, (i3 & 1024) != 0 ? 160.0f : f2);
    }
}
