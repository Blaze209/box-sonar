package sdk.pendo.io.m2;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\b\u0018\u0000 \u00072\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0086\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0011\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0000R\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0012R\u0011\u0010\u0014\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0012¨\u0006\u0017"}, d2 = {"Lsdk/pendo/io/m2/m;", "", "", "id", "value", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "c", "d", "defaultValue", "b", "other", "", "I", "set", "", "[I", "values", "()I", "headerTableSize", "initialWindowSize", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class m {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private int set;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final int[] values = new int[10];

    public final int a(int id) {
        return this.values[id];
    }

    public final int b() {
        if ((this.set & 128) != 0) {
            return this.values[7];
        }
        return 65535;
    }

    public final int c() {
        if ((this.set & 16) != 0) {
            return this.values[4];
        }
        return Integer.MAX_VALUE;
    }

    public final int d() {
        return Integer.bitCount(this.set);
    }

    public final int a() {
        if ((this.set & 2) != 0) {
            return this.values[1];
        }
        return -1;
    }

    public final int b(int defaultValue) {
        return (this.set & 32) != 0 ? this.values[5] : defaultValue;
    }

    public final boolean c(int id) {
        return (this.set & (1 << id)) != 0;
    }

    public final void a(m other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (int i = 0; i < 10; i++) {
            if (other.c(i)) {
                a(i, other.a(i));
            }
        }
    }

    public final m a(int id, int value) {
        if (id >= 0) {
            int[] iArr = this.values;
            if (id < iArr.length) {
                this.set = (1 << id) | this.set;
                iArr[id] = value;
            }
        }
        return this;
    }
}
