package sdk.pendo.io.m2;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.common.base.Ascii;
import external.sdk.pendo.io.mozilla.javascript.NativeSymbol;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bJ\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lsdk/pendo/io/m2/k;", "", "", NativeSymbol.TYPE_NAME, "code", "codeBitCount", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/s2/g;", "source", "Lsdk/pendo/io/s2/e;", "sink", "bytes", "Lsdk/pendo/io/s2/f;", "", "byteCount", "", "b", "[I", "CODES", "", "c", "[B", "CODE_BIT_COUNTS", "Lsdk/pendo/io/m2/k$a;", "d", "Lsdk/pendo/io/m2/k$a;", "root", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class k {
    public static final k a = new k();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private static final int[] CODES = {8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, 1016, 1017, 4090, 8185, 21, 248, 2042, 1018, 1019, 249, 2043, 250, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, 1020, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private static final byte[] CODE_BIT_COUNTS = {Ascii.CR, 23, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.CAN, Ascii.RS, Ascii.FS, Ascii.FS, Ascii.RS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.RS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, 6, 10, 10, Ascii.FF, Ascii.CR, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, Ascii.SI, 6, Ascii.FF, 10, Ascii.CR, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, Ascii.CR, 19, Ascii.CR, Ascii.SO, 6, Ascii.SI, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, Ascii.SI, 11, Ascii.SO, Ascii.CR, Ascii.FS, 20, 22, 20, 20, 22, 22, 22, 23, 22, 23, 23, 23, 23, 23, Ascii.CAN, 23, Ascii.CAN, Ascii.CAN, 22, 23, Ascii.CAN, 23, 23, 23, 23, 21, 22, 23, 22, 23, 23, Ascii.CAN, 22, 21, 20, 22, 22, 23, 23, 21, 23, 22, 22, Ascii.CAN, 21, 22, 23, 23, 21, 21, 22, 21, 23, 22, 23, 23, 20, 22, 22, 22, 23, 22, 22, 23, Ascii.SUB, Ascii.SUB, 20, 19, 22, 23, 22, 25, Ascii.SUB, Ascii.SUB, Ascii.SUB, Ascii.ESC, Ascii.ESC, Ascii.SUB, Ascii.CAN, 25, 19, 21, Ascii.SUB, Ascii.ESC, Ascii.ESC, Ascii.SUB, Ascii.ESC, Ascii.CAN, 21, 21, Ascii.SUB, Ascii.SUB, Ascii.FS, Ascii.ESC, Ascii.ESC, Ascii.ESC, 20, Ascii.CAN, 20, 21, 22, 21, 21, 23, 22, 22, 25, 25, Ascii.CAN, Ascii.CAN, Ascii.SUB, 23, Ascii.SUB, Ascii.ESC, Ascii.SUB, Ascii.SUB, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.FS, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.SUB};

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private static final a root = new a();

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u000f\u0010\u0010B\u0019\b\u0016\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0012R!\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000b¨\u0006\u0013"}, d2 = {"Lsdk/pendo/io/m2/k$a;", "", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "[Lsdk/pendo/io/m2/k$a;", "getChildren", "()[Lokhttp3/internal/http2/Huffman$Node;", "children", "", "b", "I", "()I", NativeSymbol.TYPE_NAME, "c", "terminalBitCount", "<init>", "()V", "bits", "(II)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    private static final class a {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final a[] children;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private final int symbol;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private final int terminalBitCount;

        public a() {
            this.children = new a[256];
            this.symbol = 0;
            this.terminalBitCount = 0;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final a[] getChildren() {
            return this.children;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final int getSymbol() {
            return this.symbol;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final int getTerminalBitCount() {
            return this.terminalBitCount;
        }

        public a(int i, int i2) {
            this.children = null;
            this.symbol = i;
            int i3 = i2 & 7;
            this.terminalBitCount = i3 == 0 ? 8 : i3;
        }
    }

    static {
        for (int i = 0; i < 256; i++) {
            a.a(i, CODES[i], CODE_BIT_COUNTS[i]);
        }
    }

    private k() {
    }

    private final void a(int symbol, int code, int codeBitCount) {
        a aVar = new a(symbol, codeBitCount);
        a aVar2 = root;
        while (codeBitCount > 8) {
            codeBitCount -= 8;
            int i = (code >>> codeBitCount) & 255;
            a[] children = aVar2.getChildren();
            Intrinsics.checkNotNull(children);
            a aVar3 = children[i];
            if (aVar3 == null) {
                aVar3 = new a();
                children[i] = aVar3;
            }
            aVar2 = aVar3;
        }
        int i2 = 8 - codeBitCount;
        int i3 = (code << i2) & 255;
        a[] children2 = aVar2.getChildren();
        Intrinsics.checkNotNull(children2);
        ArraysKt.fill(children2, aVar, i3, (1 << i2) + i3);
    }

    public final void a(sdk.pendo.io.s2.f source, long byteCount, sdk.pendo.io.s2.e sink) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(sink, "sink");
        a aVar = root;
        int iA = 0;
        int terminalBitCount = 0;
        for (long j = 0; j < byteCount; j++) {
            iA = (iA << 8) | sdk.pendo.io.f2.b.a(source.readByte(), 255);
            terminalBitCount += 8;
            while (terminalBitCount >= 8) {
                a[] children = aVar.getChildren();
                Intrinsics.checkNotNull(children);
                aVar = children[(iA >>> (terminalBitCount - 8)) & 255];
                Intrinsics.checkNotNull(aVar);
                if (aVar.getChildren() == null) {
                    sink.writeByte(aVar.getSymbol());
                    terminalBitCount -= aVar.getTerminalBitCount();
                    aVar = root;
                } else {
                    terminalBitCount -= 8;
                }
            }
        }
        while (terminalBitCount > 0) {
            a[] children2 = aVar.getChildren();
            Intrinsics.checkNotNull(children2);
            a aVar2 = children2[(iA << (8 - terminalBitCount)) & 255];
            Intrinsics.checkNotNull(aVar2);
            if (aVar2.getChildren() != null || aVar2.getTerminalBitCount() > terminalBitCount) {
                return;
            }
            sink.writeByte(aVar2.getSymbol());
            terminalBitCount -= aVar2.getTerminalBitCount();
            aVar = root;
        }
    }

    public final void a(sdk.pendo.io.s2.g source, sdk.pendo.io.s2.e sink) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(sink, "sink");
        int iJ = source.j();
        long j = 0;
        int i = 0;
        for (int i2 = 0; i2 < iJ; i2++) {
            int iA = sdk.pendo.io.f2.b.a(source.a(i2), 255);
            int i3 = CODES[iA];
            byte b = CODE_BIT_COUNTS[iA];
            j = (j << b) | ((long) i3);
            i += b;
            while (i >= 8) {
                i -= 8;
                sink.writeByte((int) (j >> i));
            }
        }
        if (i > 0) {
            sink.writeByte((int) ((j << (8 - i)) | (255 >>> i)));
        }
    }

    public final int a(sdk.pendo.io.s2.g bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        int iJ = bytes.j();
        long j = 0;
        for (int i = 0; i < iJ; i++) {
            j += (long) CODE_BIT_COUNTS[sdk.pendo.io.f2.b.a(bytes.a(i), 255)];
        }
        return (int) ((j + ((long) 7)) >> 3);
    }
}
