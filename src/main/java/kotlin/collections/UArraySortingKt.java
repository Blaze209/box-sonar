package kotlin.collections;

import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UArraySorting.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a)\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004¢\u0006\u0004\b\n\u0010\u000b\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004¢\u0006\u0004\b\r\u0010\u000e\u001a)\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004¢\u0006\u0004\b\u000f\u0010\u0010\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004¢\u0006\u0004\b\u0012\u0010\u0013\u001a)\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004¢\u0006\u0004\b\u0014\u0010\u0015\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004¢\u0006\u0004\b\u0017\u0010\u0018\u001a)\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004¢\u0006\u0004\b\u0019\u0010\u001a\u001a)\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0081\u0080\u0004¢\u0006\u0004\b\u001e\u0010\u000b\u001a)\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0081\u0080\u0004¢\u0006\u0004\b\u001f\u0010\u0010\u001a)\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0081\u0080\u0004¢\u0006\u0004\b \u0010\u0015\u001a)\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0081\u0080\u0004¢\u0006\u0004\b!\u0010\u001a¨\u0006\""}, d2 = {"partition", "", "array", "Lkotlin/UByteArray;", "left", "right", "partition-4UcCI2c", "([BII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort-Aa5vz7o", "([SII)V", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "quickSort-oBK06Vg", "([III)V", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "quickSort--nroSd4", "([JII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-Aa5vz7o", "sortArray-oBK06Vg", "sortArray--nroSd4", "kotlin-stdlib"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class UArraySortingKt {
    /* JADX INFO: renamed from: partition-4UcCI2c, reason: not valid java name */
    private static final int m15240partition4UcCI2c(byte[] bArr, int i, int i2) {
        int i3;
        byte bM14856getw2LRezQ = UByteArray.m14856getw2LRezQ(bArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                i3 = bM14856getw2LRezQ & 255;
                if (Intrinsics.compare(UByteArray.m14856getw2LRezQ(bArr, i) & 255, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UByteArray.m14856getw2LRezQ(bArr, i2) & 255, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                byte bM14856getw2LRezQ2 = UByteArray.m14856getw2LRezQ(bArr, i);
                UByteArray.m14861setVurrAj0(bArr, i, UByteArray.m14856getw2LRezQ(bArr, i2));
                UByteArray.m14861setVurrAj0(bArr, i2, bM14856getw2LRezQ2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort-4UcCI2c, reason: not valid java name */
    private static final void m15244quickSort4UcCI2c(byte[] bArr, int i, int i2) {
        int iM15240partition4UcCI2c = m15240partition4UcCI2c(bArr, i, i2);
        int i3 = iM15240partition4UcCI2c - 1;
        if (i < i3) {
            m15244quickSort4UcCI2c(bArr, i, i3);
        }
        if (iM15240partition4UcCI2c < i2) {
            m15244quickSort4UcCI2c(bArr, iM15240partition4UcCI2c, i2);
        }
    }

    /* JADX INFO: renamed from: partition-Aa5vz7o, reason: not valid java name */
    private static final int m15241partitionAa5vz7o(short[] sArr, int i, int i2) {
        int i3;
        short sM15119getMh2AYeg = UShortArray.m15119getMh2AYeg(sArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                int iM15119getMh2AYeg = UShortArray.m15119getMh2AYeg(sArr, i) & UShort.MAX_VALUE;
                i3 = sM15119getMh2AYeg & UShort.MAX_VALUE;
                if (Intrinsics.compare(iM15119getMh2AYeg, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UShortArray.m15119getMh2AYeg(sArr, i2) & UShort.MAX_VALUE, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                short sM15119getMh2AYeg2 = UShortArray.m15119getMh2AYeg(sArr, i);
                UShortArray.m15124set01HTLdE(sArr, i, UShortArray.m15119getMh2AYeg(sArr, i2));
                UShortArray.m15124set01HTLdE(sArr, i2, sM15119getMh2AYeg2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort-Aa5vz7o, reason: not valid java name */
    private static final void m15245quickSortAa5vz7o(short[] sArr, int i, int i2) {
        int iM15241partitionAa5vz7o = m15241partitionAa5vz7o(sArr, i, i2);
        int i3 = iM15241partitionAa5vz7o - 1;
        if (i < i3) {
            m15245quickSortAa5vz7o(sArr, i, i3);
        }
        if (iM15241partitionAa5vz7o < i2) {
            m15245quickSortAa5vz7o(sArr, iM15241partitionAa5vz7o, i2);
        }
    }

    /* JADX INFO: renamed from: partition-oBK06Vg, reason: not valid java name */
    private static final int m15242partitionoBK06Vg(int[] iArr, int i, int i2) {
        int iM14935getpVg5ArA = UIntArray.m14935getpVg5ArA(iArr, (i + i2) / 2);
        while (i <= i2) {
            while (Integer.compareUnsigned(UIntArray.m14935getpVg5ArA(iArr, i), iM14935getpVg5ArA) < 0) {
                i++;
            }
            while (Integer.compareUnsigned(UIntArray.m14935getpVg5ArA(iArr, i2), iM14935getpVg5ArA) > 0) {
                i2--;
            }
            if (i <= i2) {
                int iM14935getpVg5ArA2 = UIntArray.m14935getpVg5ArA(iArr, i);
                UIntArray.m14940setVXSXFK8(iArr, i, UIntArray.m14935getpVg5ArA(iArr, i2));
                UIntArray.m14940setVXSXFK8(iArr, i2, iM14935getpVg5ArA2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort-oBK06Vg, reason: not valid java name */
    private static final void m15246quickSortoBK06Vg(int[] iArr, int i, int i2) {
        int iM15242partitionoBK06Vg = m15242partitionoBK06Vg(iArr, i, i2);
        int i3 = iM15242partitionoBK06Vg - 1;
        if (i < i3) {
            m15246quickSortoBK06Vg(iArr, i, i3);
        }
        if (iM15242partitionoBK06Vg < i2) {
            m15246quickSortoBK06Vg(iArr, iM15242partitionoBK06Vg, i2);
        }
    }

    /* JADX INFO: renamed from: partition--nroSd4, reason: not valid java name */
    private static final int m15239partitionnroSd4(long[] jArr, int i, int i2) {
        long jM15014getsVKNKU = ULongArray.m15014getsVKNKU(jArr, (i + i2) / 2);
        while (i <= i2) {
            while (Long.compareUnsigned(ULongArray.m15014getsVKNKU(jArr, i), jM15014getsVKNKU) < 0) {
                i++;
            }
            while (Long.compareUnsigned(ULongArray.m15014getsVKNKU(jArr, i2), jM15014getsVKNKU) > 0) {
                i2--;
            }
            if (i <= i2) {
                long jM15014getsVKNKU2 = ULongArray.m15014getsVKNKU(jArr, i);
                ULongArray.m15019setk8EXiF4(jArr, i, ULongArray.m15014getsVKNKU(jArr, i2));
                ULongArray.m15019setk8EXiF4(jArr, i2, jM15014getsVKNKU2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort--nroSd4, reason: not valid java name */
    private static final void m15243quickSortnroSd4(long[] jArr, int i, int i2) {
        int iM15239partitionnroSd4 = m15239partitionnroSd4(jArr, i, i2);
        int i3 = iM15239partitionnroSd4 - 1;
        if (i < i3) {
            m15243quickSortnroSd4(jArr, i, i3);
        }
        if (iM15239partitionnroSd4 < i2) {
            m15243quickSortnroSd4(jArr, iM15239partitionnroSd4, i2);
        }
    }

    /* JADX INFO: renamed from: sortArray-4UcCI2c, reason: not valid java name */
    public static final void m15248sortArray4UcCI2c(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-array$0");
        m15244quickSort4UcCI2c(bArr, i, i2 - 1);
    }

    /* JADX INFO: renamed from: sortArray-Aa5vz7o, reason: not valid java name */
    public static final void m15249sortArrayAa5vz7o(short[] sArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-array$0");
        m15245quickSortAa5vz7o(sArr, i, i2 - 1);
    }

    /* JADX INFO: renamed from: sortArray-oBK06Vg, reason: not valid java name */
    public static final void m15250sortArrayoBK06Vg(int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-array$0");
        m15246quickSortoBK06Vg(iArr, i, i2 - 1);
    }

    /* JADX INFO: renamed from: sortArray--nroSd4, reason: not valid java name */
    public static final void m15247sortArraynroSd4(long[] jArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-array$0");
        m15243quickSortnroSd4(jArr, i, i2 - 1);
    }
}
