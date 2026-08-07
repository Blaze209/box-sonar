package io.opentelemetry.sdk.metrics.internal.aggregator;

import androidx.collection.SieveCacheKt;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class AdaptingIntegerArray {

    @Nullable
    private byte[] byteBacking;
    private ArrayCellSize cellSize;

    @Nullable
    private int[] intBacking;

    @Nullable
    private long[] longBacking;

    @Nullable
    private short[] shortBacking;

    private enum ArrayCellSize {
        BYTE,
        SHORT,
        INT,
        LONG
    }

    AdaptingIntegerArray(int i) {
        this.cellSize = ArrayCellSize.BYTE;
        this.byteBacking = new byte[i];
    }

    private AdaptingIntegerArray(AdaptingIntegerArray adaptingIntegerArray) {
        this.cellSize = adaptingIntegerArray.cellSize;
        int i = AnonymousClass1.$SwitchMap$io$opentelemetry$sdk$metrics$internal$aggregator$AdaptingIntegerArray$ArrayCellSize[this.cellSize.ordinal()];
        if (i == 1) {
            byte[] bArr = adaptingIntegerArray.byteBacking;
            this.byteBacking = Arrays.copyOf(bArr, bArr.length);
            return;
        }
        if (i == 2) {
            short[] sArr = adaptingIntegerArray.shortBacking;
            this.shortBacking = Arrays.copyOf(sArr, sArr.length);
        } else if (i == 3) {
            int[] iArr = adaptingIntegerArray.intBacking;
            this.intBacking = Arrays.copyOf(iArr, iArr.length);
        } else {
            if (i != 4) {
                return;
            }
            long[] jArr = adaptingIntegerArray.longBacking;
            this.longBacking = Arrays.copyOf(jArr, jArr.length);
        }
    }

    /* JADX INFO: renamed from: io.opentelemetry.sdk.metrics.internal.aggregator.AdaptingIntegerArray$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$opentelemetry$sdk$metrics$internal$aggregator$AdaptingIntegerArray$ArrayCellSize;

        static {
            int[] iArr = new int[ArrayCellSize.values().length];
            $SwitchMap$io$opentelemetry$sdk$metrics$internal$aggregator$AdaptingIntegerArray$ArrayCellSize = iArr;
            try {
                iArr[ArrayCellSize.BYTE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$opentelemetry$sdk$metrics$internal$aggregator$AdaptingIntegerArray$ArrayCellSize[ArrayCellSize.SHORT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$opentelemetry$sdk$metrics$internal$aggregator$AdaptingIntegerArray$ArrayCellSize[ArrayCellSize.INT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$opentelemetry$sdk$metrics$internal$aggregator$AdaptingIntegerArray$ArrayCellSize[ArrayCellSize.LONG.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    AdaptingIntegerArray copy() {
        return new AdaptingIntegerArray(this);
    }

    void increment(int i, long j) {
        int i2 = AnonymousClass1.$SwitchMap$io$opentelemetry$sdk$metrics$internal$aggregator$AdaptingIntegerArray$ArrayCellSize[this.cellSize.ordinal()];
        if (i2 == 1) {
            byte[] bArr = this.byteBacking;
            long j2 = ((long) bArr[i]) + j;
            if (j2 > 127) {
                resizeToShort();
                increment(i, j);
                return;
            } else {
                bArr[i] = (byte) j2;
                return;
            }
        }
        if (i2 == 2) {
            short[] sArr = this.shortBacking;
            long j3 = ((long) sArr[i]) + j;
            if (j3 > 32767) {
                resizeToInt();
                increment(i, j);
                return;
            } else {
                sArr[i] = (short) j3;
                return;
            }
        }
        if (i2 != 3) {
            if (i2 != 4) {
                return;
            }
            long[] jArr = this.longBacking;
            jArr[i] = jArr[i] + j;
            return;
        }
        int[] iArr = this.intBacking;
        long j4 = ((long) iArr[i]) + j;
        if (j4 > SieveCacheKt.NodeLinkMask) {
            resizeToLong();
            increment(i, j);
        } else {
            iArr[i] = (int) j4;
        }
    }

    long get(int i) {
        int i2 = AnonymousClass1.$SwitchMap$io$opentelemetry$sdk$metrics$internal$aggregator$AdaptingIntegerArray$ArrayCellSize[this.cellSize.ordinal()];
        if (i2 == 1) {
            return this.byteBacking[i];
        }
        if (i2 == 2) {
            return this.shortBacking[i];
        }
        if (i2 == 3) {
            return this.intBacking[i];
        }
        if (i2 != 4) {
            return 0L;
        }
        return this.longBacking[i];
    }

    int length() {
        int i = AnonymousClass1.$SwitchMap$io$opentelemetry$sdk$metrics$internal$aggregator$AdaptingIntegerArray$ArrayCellSize[this.cellSize.ordinal()];
        if (i == 1) {
            return this.byteBacking.length;
        }
        if (i == 2) {
            return this.shortBacking.length;
        }
        if (i == 3) {
            return this.intBacking.length;
        }
        if (i != 4) {
            return 0;
        }
        return this.longBacking.length;
    }

    void clear() {
        int i = AnonymousClass1.$SwitchMap$io$opentelemetry$sdk$metrics$internal$aggregator$AdaptingIntegerArray$ArrayCellSize[this.cellSize.ordinal()];
        if (i == 1) {
            Arrays.fill(this.byteBacking, (byte) 0);
            return;
        }
        if (i == 2) {
            Arrays.fill(this.shortBacking, (short) 0);
        } else if (i == 3) {
            Arrays.fill(this.intBacking, 0);
        } else {
            if (i != 4) {
                return;
            }
            Arrays.fill(this.longBacking, 0L);
        }
    }

    private void resizeToShort() {
        short[] sArr = new short[this.byteBacking.length];
        int i = 0;
        while (true) {
            byte[] bArr = this.byteBacking;
            if (i < bArr.length) {
                sArr[i] = bArr[i];
                i++;
            } else {
                this.cellSize = ArrayCellSize.SHORT;
                this.shortBacking = sArr;
                this.byteBacking = null;
                return;
            }
        }
    }

    private void resizeToInt() {
        int[] iArr = new int[this.shortBacking.length];
        int i = 0;
        while (true) {
            short[] sArr = this.shortBacking;
            if (i < sArr.length) {
                iArr[i] = sArr[i];
                i++;
            } else {
                this.cellSize = ArrayCellSize.INT;
                this.intBacking = iArr;
                this.shortBacking = null;
                return;
            }
        }
    }

    private void resizeToLong() {
        long[] jArr = new long[this.intBacking.length];
        int i = 0;
        while (true) {
            int[] iArr = this.intBacking;
            if (i < iArr.length) {
                jArr[i] = iArr[i];
                i++;
            } else {
                this.cellSize = ArrayCellSize.LONG;
                this.longBacking = jArr;
                this.intBacking = null;
                return;
            }
        }
    }
}
