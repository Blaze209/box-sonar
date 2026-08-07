package sdk.pendo.io.m2;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxOrder;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.microsoft.identity.common.java.marker.PerfConstants;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.s2.a0;
import sdk.pendo.io.s2.o;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0007\nB\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR#\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0007\u0010\u0010¨\u0006\u0014"}, d2 = {"Lsdk/pendo/io/m2/d;", "", "", "Lsdk/pendo/io/s2/g;", "", "c", "name", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "Lsdk/pendo/io/m2/c;", "b", "[Lsdk/pendo/io/m2/c;", "getSTATIC_HEADER_TABLE", "()[Lokhttp3/internal/http2/Header;", "STATIC_HEADER_TABLE", "Ljava/util/Map;", "()Ljava/util/Map;", "NAME_TO_FIRST_INDEX", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class d {
    public static final d a;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private static final c[] STATIC_HEADER_TABLE;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private static final Map<sdk.pendo.io.s2.g, Integer> NAME_TO_FIRST_INDEX;

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020%\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005¢\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013J\u0006\u0010\f\u001a\u00020\u0002J\u0016\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\rR\u0014\u0010\u0017\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0016R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001dR\u001e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010 R\u0016\u0010\"\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0016R\u0016\u0010#\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0016R\u0016\u0010$\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0016¨\u0006("}, d2 = {"Lsdk/pendo/io/m2/d$a;", "", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "", "bytesToRecover", FirebaseAnalytics.Param.INDEX, "e", "g", CmcdData.STREAMING_FORMAT_HLS, "nameIndex", "f", "Lsdk/pendo/io/s2/g;", "c", "", "d", "Lsdk/pendo/io/m2/c;", "entry", "", "firstByte", "prefixMask", "I", "headerTableSizeSetting", "maxDynamicTableByteCount", "", "Ljava/util/List;", "headerList", "Lsdk/pendo/io/s2/f;", "Lsdk/pendo/io/s2/f;", "source", "", "[Lsdk/pendo/io/m2/c;", "dynamicTable", "nextHeaderIndex", "headerCount", "dynamicTableByteCount", "Lsdk/pendo/io/s2/a0;", "<init>", "(Lokio/Source;II)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final int headerTableSizeSetting;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private int maxDynamicTableByteCount;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private final List<c> headerList;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private final sdk.pendo.io.s2.f source;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        public c[] dynamicTable;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata */
        private int nextHeaderIndex;

        /* JADX INFO: renamed from: g, reason: from kotlin metadata */
        public int headerCount;

        /* JADX INFO: renamed from: h, reason: from kotlin metadata */
        public int dynamicTableByteCount;

        public a(a0 source, int i, int i2) {
            Intrinsics.checkNotNullParameter(source, "source");
            this.headerTableSizeSetting = i;
            this.maxDynamicTableByteCount = i2;
            this.headerList = new ArrayList();
            this.source = o.a(source);
            this.dynamicTable = new c[8];
            this.nextHeaderIndex = 7;
        }

        private final void a() {
            int i = this.maxDynamicTableByteCount;
            int i2 = this.dynamicTableByteCount;
            if (i < i2) {
                if (i == 0) {
                    b();
                } else {
                    b(i2 - i);
                }
            }
        }

        private final void b() {
            ArraysKt.fill$default(this.dynamicTable, (Object) null, 0, 0, 6, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final boolean d(int index) {
            return index >= 0 && index <= d.a.b().length - 1;
        }

        private final void g() {
            a(-1, new c(d.a.a(e()), e()));
        }

        private final void h() throws IOException {
            this.headerList.add(new c(d.a.a(e()), e()));
        }

        public final List<c> c() {
            List<c> list = CollectionsKt.toList(this.headerList);
            this.headerList.clear();
            return list;
        }

        public final sdk.pendo.io.s2.g e() {
            int iD = d();
            boolean z = (iD & 128) == 128;
            long jA = a(iD, 127);
            if (!z) {
                return this.source.readByteString(jA);
            }
            sdk.pendo.io.s2.d dVar = new sdk.pendo.io.s2.d();
            k.a.a(this.source, jA, dVar);
            return dVar.g();
        }

        public final void f() throws IOException {
            while (!this.source.exhausted()) {
                int iA = sdk.pendo.io.f2.b.a(this.source.readByte(), 255);
                if (iA == 128) {
                    throw new IOException("index == 0");
                }
                if ((iA & 128) == 128) {
                    e(a(iA, 127) - 1);
                } else if (iA == 64) {
                    g();
                } else if ((iA & 64) == 64) {
                    f(a(iA, 63) - 1);
                } else if ((iA & 32) == 32) {
                    int iA2 = a(iA, 31);
                    this.maxDynamicTableByteCount = iA2;
                    if (iA2 < 0 || iA2 > this.headerTableSizeSetting) {
                        throw new IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
                    }
                    a();
                } else if (iA == 16 || iA == 0) {
                    h();
                } else {
                    g(a(iA, 15) - 1);
                }
            }
        }

        public /* synthetic */ a(a0 a0Var, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(a0Var, i, (i3 & 4) != 0 ? i : i2);
        }

        private final int a(int index) {
            return this.nextHeaderIndex + 1 + index;
        }

        private final int b(int bytesToRecover) {
            int i;
            int i2 = 0;
            if (bytesToRecover > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i = this.nextHeaderIndex;
                    if (length < i || bytesToRecover <= 0) {
                        break;
                    }
                    c cVar = this.dynamicTable[length];
                    Intrinsics.checkNotNull(cVar);
                    int i3 = cVar.hpackSize;
                    bytesToRecover -= i3;
                    this.dynamicTableByteCount -= i3;
                    this.headerCount--;
                    i2++;
                }
                c[] cVarArr = this.dynamicTable;
                int i4 = i + 1;
                System.arraycopy(cVarArr, i4, cVarArr, i4 + i2, this.headerCount);
                this.nextHeaderIndex += i2;
            }
            return i2;
        }

        private final sdk.pendo.io.s2.g c(int index) throws IOException {
            c cVar;
            if (!d(index)) {
                int iA = a(index - d.a.b().length);
                if (iA >= 0) {
                    c[] cVarArr = this.dynamicTable;
                    if (iA < cVarArr.length) {
                        cVar = cVarArr[iA];
                        Intrinsics.checkNotNull(cVar);
                    }
                }
                throw new IOException("Header index too large " + (index + 1));
            }
            cVar = d.a.b()[index];
            return cVar.name;
        }

        private final int d() {
            return sdk.pendo.io.f2.b.a(this.source.readByte(), 255);
        }

        private final void e(int index) throws IOException {
            if (d(index)) {
                this.headerList.add(d.a.b()[index]);
                return;
            }
            int iA = a(index - d.a.b().length);
            if (iA >= 0) {
                c[] cVarArr = this.dynamicTable;
                if (iA < cVarArr.length) {
                    List<c> list = this.headerList;
                    c cVar = cVarArr[iA];
                    Intrinsics.checkNotNull(cVar);
                    list.add(cVar);
                    return;
                }
            }
            throw new IOException("Header index too large " + (index + 1));
        }

        private final void f(int nameIndex) {
            a(-1, new c(c(nameIndex), e()));
        }

        private final void g(int index) throws IOException {
            this.headerList.add(new c(c(index), e()));
        }

        private final void a(int index, c entry) {
            this.headerList.add(entry);
            int i = entry.hpackSize;
            if (index != -1) {
                c cVar = this.dynamicTable[a(index)];
                Intrinsics.checkNotNull(cVar);
                i -= cVar.hpackSize;
            }
            int i2 = this.maxDynamicTableByteCount;
            if (i > i2) {
                b();
                return;
            }
            int iB = b((this.dynamicTableByteCount + i) - i2);
            if (index == -1) {
                int i3 = this.headerCount + 1;
                c[] cVarArr = this.dynamicTable;
                if (i3 > cVarArr.length) {
                    c[] cVarArr2 = new c[cVarArr.length * 2];
                    System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = cVarArr2;
                }
                int i4 = this.nextHeaderIndex;
                this.nextHeaderIndex = i4 - 1;
                this.dynamicTable[i4] = entry;
                this.headerCount++;
            } else {
                this.dynamicTable[index + a(index) + iB] = entry;
            }
            this.dynamicTableByteCount += i;
        }

        public final int a(int firstByte, int prefixMask) {
            int i = firstByte & prefixMask;
            if (i < prefixMask) {
                return i;
            }
            int i2 = 0;
            while (true) {
                int iD = d();
                if ((iD & 128) == 0) {
                    return prefixMask + (iD << i2);
                }
                prefixMask += (iD & 127) << i2;
                i2 += 7;
            }
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\f\u0018\u00002\u00020\u0001B%\b\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0014\u0010\u0006\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\tJ\u001e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0004R\u0016\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0011R\u0016\u0010\u001c\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0013R\u0016\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0011R\u001e\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\u0011R\u0016\u0010&\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b%\u0010\u0011R\u0016\u0010(\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b'\u0010\u0011¨\u0006+"}, d2 = {"Lsdk/pendo/io/m2/d$b;", "", "", "b", "", "bytesToRecover", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/m2/c;", "entry", "", "headerBlock", "value", "prefixMask", "bits", "Lsdk/pendo/io/s2/g;", "data", "headerTableSizeSetting", "I", "", "Z", "useCompression", "Lsdk/pendo/io/s2/d;", "c", "Lsdk/pendo/io/s2/d;", "out", "d", "smallestHeaderTableSizeSetting", "e", "emitDynamicTableSizeUpdate", "f", "maxDynamicTableByteCount", "", "g", "[Lsdk/pendo/io/m2/c;", "dynamicTable", CmcdData.STREAMING_FORMAT_HLS, "nextHeaderIndex", "i", "headerCount", "j", "dynamicTableByteCount", "<init>", "(IZLokio/Buffer;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class b {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        public int headerTableSizeSetting;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private final boolean useCompression;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private final sdk.pendo.io.s2.d out;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private int smallestHeaderTableSizeSetting;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        private boolean emitDynamicTableSizeUpdate;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata */
        public int maxDynamicTableByteCount;

        /* JADX INFO: renamed from: g, reason: from kotlin metadata */
        public c[] dynamicTable;

        /* JADX INFO: renamed from: h, reason: from kotlin metadata */
        private int nextHeaderIndex;

        /* JADX INFO: renamed from: i, reason: from kotlin metadata */
        public int headerCount;

        /* JADX INFO: renamed from: j, reason: from kotlin metadata */
        public int dynamicTableByteCount;

        public b(int i, boolean z, sdk.pendo.io.s2.d out) {
            Intrinsics.checkNotNullParameter(out, "out");
            this.headerTableSizeSetting = i;
            this.useCompression = z;
            this.out = out;
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            this.maxDynamicTableByteCount = i;
            this.dynamicTable = new c[8];
            this.nextHeaderIndex = 7;
        }

        private final void a() {
            int i = this.maxDynamicTableByteCount;
            int i2 = this.dynamicTableByteCount;
            if (i < i2) {
                if (i == 0) {
                    b();
                } else {
                    a(i2 - i);
                }
            }
        }

        private final void b() {
            ArraysKt.fill$default(this.dynamicTable, (Object) null, 0, 0, 6, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        public /* synthetic */ b(int i, boolean z, sdk.pendo.io.s2.d dVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 4096 : i, (i2 & 2) != 0 ? true : z, dVar);
        }

        private final int a(int bytesToRecover) {
            int i;
            int i2 = 0;
            if (bytesToRecover > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i = this.nextHeaderIndex;
                    if (length < i || bytesToRecover <= 0) {
                        break;
                    }
                    c cVar = this.dynamicTable[length];
                    Intrinsics.checkNotNull(cVar);
                    bytesToRecover -= cVar.hpackSize;
                    int i3 = this.dynamicTableByteCount;
                    c cVar2 = this.dynamicTable[length];
                    Intrinsics.checkNotNull(cVar2);
                    this.dynamicTableByteCount = i3 - cVar2.hpackSize;
                    this.headerCount--;
                    i2++;
                }
                c[] cVarArr = this.dynamicTable;
                int i4 = i + 1;
                System.arraycopy(cVarArr, i4, cVarArr, i4 + i2, this.headerCount);
                c[] cVarArr2 = this.dynamicTable;
                int i5 = this.nextHeaderIndex + 1;
                Arrays.fill(cVarArr2, i5, i5 + i2, (Object) null);
                this.nextHeaderIndex += i2;
            }
            return i2;
        }

        public final void b(int headerTableSizeSetting) {
            this.headerTableSizeSetting = headerTableSizeSetting;
            int iMin = Math.min(headerTableSizeSetting, 16384);
            int i = this.maxDynamicTableByteCount;
            if (i == iMin) {
                return;
            }
            if (iMin < i) {
                this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, iMin);
            }
            this.emitDynamicTableSizeUpdate = true;
            this.maxDynamicTableByteCount = iMin;
            a();
        }

        private final void a(c entry) {
            int i = entry.hpackSize;
            int i2 = this.maxDynamicTableByteCount;
            if (i > i2) {
                b();
                return;
            }
            a((this.dynamicTableByteCount + i) - i2);
            int i3 = this.headerCount + 1;
            c[] cVarArr = this.dynamicTable;
            if (i3 > cVarArr.length) {
                c[] cVarArr2 = new c[cVarArr.length * 2];
                System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = cVarArr2;
            }
            int i4 = this.nextHeaderIndex;
            this.nextHeaderIndex = i4 - 1;
            this.dynamicTable[i4] = entry;
            this.headerCount++;
            this.dynamicTableByteCount += i;
        }

        /* JADX WARN: Code duplicated, block: B:9:0x0032  */
        public final void a(sdk.pendo.io.s2.g data) {
            int iJ;
            int i;
            Intrinsics.checkNotNullParameter(data, "data");
            if (this.useCompression) {
                k kVar = k.a;
                if (kVar.a(data) < data.j()) {
                    sdk.pendo.io.s2.d dVar = new sdk.pendo.io.s2.d();
                    kVar.a(data, dVar);
                    data = dVar.g();
                    iJ = data.j();
                    i = 128;
                } else {
                    iJ = data.j();
                    i = 0;
                }
            } else {
                iJ = data.j();
                i = 0;
            }
            a(iJ, 127, i);
            this.out.a(data);
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0077  */
        public final void a(List<c> headerBlock) {
            int length;
            int length2;
            Intrinsics.checkNotNullParameter(headerBlock, "headerBlock");
            if (this.emitDynamicTableSizeUpdate) {
                int i = this.smallestHeaderTableSizeSetting;
                if (i < this.maxDynamicTableByteCount) {
                    a(i, 31, 32);
                }
                this.emitDynamicTableSizeUpdate = false;
                this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
                a(this.maxDynamicTableByteCount, 31, 32);
            }
            int size = headerBlock.size();
            for (int i2 = 0; i2 < size; i2++) {
                c cVar = headerBlock.get(i2);
                sdk.pendo.io.s2.g gVarK = cVar.name.k();
                sdk.pendo.io.s2.g gVar = cVar.value;
                d dVar = d.a;
                Integer num = dVar.a().get(gVarK);
                if (num != null) {
                    int iIntValue = num.intValue();
                    length2 = iIntValue + 1;
                    if (2 > length2 || length2 >= 8) {
                        length = length2;
                        length2 = -1;
                    } else if (Intrinsics.areEqual(dVar.b()[iIntValue].value, gVar)) {
                        length = length2;
                    } else if (Intrinsics.areEqual(dVar.b()[length2].value, gVar)) {
                        length = length2;
                        length2 = iIntValue + 2;
                    } else {
                        length = length2;
                        length2 = -1;
                    }
                } else {
                    length = -1;
                    length2 = -1;
                }
                if (length2 == -1) {
                    int length3 = this.dynamicTable.length;
                    for (int i3 = this.nextHeaderIndex + 1; i3 < length3; i3++) {
                        c cVar2 = this.dynamicTable[i3];
                        Intrinsics.checkNotNull(cVar2);
                        if (Intrinsics.areEqual(cVar2.name, gVarK)) {
                            c cVar3 = this.dynamicTable[i3];
                            Intrinsics.checkNotNull(cVar3);
                            if (Intrinsics.areEqual(cVar3.value, gVar)) {
                                length2 = d.a.b().length + (i3 - this.nextHeaderIndex);
                                break;
                            } else if (length == -1) {
                                length = (i3 - this.nextHeaderIndex) + d.a.b().length;
                            }
                        }
                    }
                }
                if (length2 != -1) {
                    a(length2, 127, 128);
                } else {
                    if (length == -1) {
                        this.out.writeByte(64);
                        a(gVarK);
                    } else if (!gVarK.b(c.e) || Intrinsics.areEqual(c.j, gVarK)) {
                        a(length, 63, 64);
                    } else {
                        a(length, 15, 0);
                        a(gVar);
                    }
                    a(gVar);
                    a(cVar);
                }
            }
        }

        public final void a(int value, int prefixMask, int bits) {
            int i;
            sdk.pendo.io.s2.d dVar;
            if (value < prefixMask) {
                dVar = this.out;
                i = value | bits;
            } else {
                this.out.writeByte(bits | prefixMask);
                i = value - prefixMask;
                while (i >= 128) {
                    this.out.writeByte(128 | (i & 127));
                    i >>>= 7;
                }
                dVar = this.out;
            }
            dVar.writeByte(i);
        }
    }

    static {
        d dVar = new d();
        a = dVar;
        sdk.pendo.io.s2.g gVar = c.g;
        sdk.pendo.io.s2.g gVar2 = c.h;
        sdk.pendo.io.s2.g gVar3 = c.i;
        sdk.pendo.io.s2.g gVar4 = c.f;
        STATIC_HEADER_TABLE = new c[]{new c(c.j, ""), new c(gVar, "GET"), new c(gVar, "POST"), new c(gVar2, "/"), new c(gVar2, "/index.html"), new c(gVar3, "http"), new c(gVar3, "https"), new c(gVar4, PerfConstants.ScenarioConstants.SCENARIO_BROKERED_ACQUIRE_TOKEN_SILENTLY), new c(gVar4, TelemetryEventStrings.Api.GET_BROKER_DEVICE_MODE), new c(gVar4, TelemetryEventStrings.Api.BROKER_GET_ACCOUNTS), new c(gVar4, "304"), new c(gVar4, "400"), new c(gVar4, "404"), new c(gVar4, "500"), new c("accept-charset", ""), new c("accept-encoding", "gzip, deflate"), new c("accept-language", ""), new c("accept-ranges", ""), new c("accept", ""), new c("access-control-allow-origin", ""), new c("age", ""), new c("allow", ""), new c("authorization", ""), new c("cache-control", ""), new c("content-disposition", ""), new c("content-encoding", ""), new c("content-language", ""), new c("content-length", ""), new c("content-location", ""), new c("content-range", ""), new c("content-type", ""), new c("cookie", ""), new c(BoxOrder.SORT_DATE, ""), new c(BoxItem.FIELD_ETAG, ""), new c("expect", ""), new c("expires", ""), new c(TypedValues.TransitionType.S_FROM, ""), new c("host", ""), new c("if-match", ""), new c("if-modified-since", ""), new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c("last-modified", ""), new c(BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_LINK, ""), new c(FirebaseAnalytics.Param.LOCATION, ""), new c("max-forwards", ""), new c("proxy-authenticate", ""), new c("proxy-authorization", ""), new c("range", ""), new c("referer", ""), new c("refresh", ""), new c("retry-after", ""), new c("server", ""), new c("set-cookie", ""), new c("strict-transport-security", ""), new c("transfer-encoding", ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), new c("www-authenticate", "")};
        NAME_TO_FIRST_INDEX = dVar.c();
    }

    private d() {
    }

    private final Map<sdk.pendo.io.s2.g, Integer> c() {
        c[] cVarArr = STATIC_HEADER_TABLE;
        LinkedHashMap linkedHashMap = new LinkedHashMap(cVarArr.length);
        int length = cVarArr.length;
        for (int i = 0; i < length; i++) {
            c[] cVarArr2 = STATIC_HEADER_TABLE;
            if (!linkedHashMap.containsKey(cVarArr2[i].name)) {
                linkedHashMap.put(cVarArr2[i].name, Integer.valueOf(i));
            }
        }
        Map<sdk.pendo.io.s2.g, Integer> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        Intrinsics.checkNotNullExpressionValue(mapUnmodifiableMap, "unmodifiableMap(result)");
        return mapUnmodifiableMap;
    }

    public final sdk.pendo.io.s2.g a(sdk.pendo.io.s2.g name) throws IOException {
        Intrinsics.checkNotNullParameter(name, "name");
        int iJ = name.j();
        for (int i = 0; i < iJ; i++) {
            byte bA = name.a(i);
            if (65 <= bA && bA < 91) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + name.m());
            }
        }
        return name;
    }

    public final c[] b() {
        return STATIC_HEADER_TABLE;
    }

    public final Map<sdk.pendo.io.s2.g, Integer> a() {
        return NAME_TO_FIRST_INDEX;
    }
}
