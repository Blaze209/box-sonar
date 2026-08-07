package sdk.pendo.io.s2;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u000b\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004:\u0001\u0007B!\b\u0002\u0012\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0002R\"\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0011\u001a\u00020\r8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lsdk/pendo/io/s2/r;", "Lkotlin/collections/AbstractList;", "Lsdk/pendo/io/s2/g;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", FirebaseAnalytics.Param.INDEX, CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "[Lsdk/pendo/io/s2/g;", "getByteStrings$okio", "()[Lokio/ByteString;", "byteStrings", "", "b", "[I", "()[I", "trie", "getSize", "()I", "size", "<init>", "([Lokio/ByteString;[I)V", "c", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
public final class r extends AbstractList<g> implements RandomAccess {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final g[] byteStrings;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final int[] trie;

    /* JADX INFO: renamed from: sdk.pendo.io.s2.r$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018JT\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0002J#\u0010\u0012\u001a\u00020\u00112\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u0010\"\u00020\tH\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0016\u001a\u00020\u0002*\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lsdk/pendo/io/s2/r$a;", "", "", "nodeOffset", "Lsdk/pendo/io/s2/d;", "node", "", "byteStringOffset", "", "Lsdk/pendo/io/s2/g;", "byteStrings", "fromIndex", "toIndex", "indexes", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "Lsdk/pendo/io/s2/r;", "of", "([Lokio/ByteString;)Lokio/Options;", "getIntCount", "(Lokio/Buffer;)J", "intCount", "<init>", "()V", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void a(long nodeOffset, d node, int byteStringOffset, List<? extends g> byteStrings, int fromIndex, int toIndex, List<Integer> indexes) {
            int i;
            int i2;
            int i3;
            long j;
            int i4 = byteStringOffset;
            if (fromIndex >= toIndex) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            for (int i5 = fromIndex; i5 < toIndex; i5++) {
                if (byteStrings.get(i5).j() < i4) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
            g gVar = byteStrings.get(fromIndex);
            g gVar2 = byteStrings.get(toIndex - 1);
            if (i4 == gVar.j()) {
                int iIntValue = indexes.get(fromIndex).intValue();
                int i6 = fromIndex + 1;
                g gVar3 = byteStrings.get(i6);
                i = i6;
                i2 = iIntValue;
                gVar = gVar3;
            } else {
                i = fromIndex;
                i2 = -1;
            }
            if (gVar.a(i4) == gVar2.a(i4)) {
                int iMin = Math.min(gVar.j(), gVar2.j());
                int i7 = 0;
                for (int i8 = i4; i8 < iMin && gVar.a(i8) == gVar2.a(i8); i8++) {
                    i7++;
                }
                long jA = nodeOffset + a(node) + ((long) 2) + ((long) i7) + 1;
                node.writeInt(-i7);
                node.writeInt(i2);
                int i9 = i4 + i7;
                while (i4 < i9) {
                    node.writeInt(gVar.a(i4) & 255);
                    i4++;
                }
                if (i + 1 == toIndex) {
                    if (i9 != byteStrings.get(i).j()) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    node.writeInt(indexes.get(i).intValue());
                    return;
                } else {
                    d dVar = new d();
                    node.writeInt(((int) (a(dVar) + jA)) * (-1));
                    a(jA, dVar, i9, byteStrings, i, toIndex, indexes);
                    node.a((a0) dVar);
                    return;
                }
            }
            int i10 = 1;
            for (int i11 = i + 1; i11 < toIndex; i11++) {
                if (byteStrings.get(i11 - 1).a(i4) != byteStrings.get(i11).a(i4)) {
                    i10++;
                }
            }
            long jA2 = nodeOffset + a(node) + ((long) 2) + ((long) (i10 * 2));
            node.writeInt(i10);
            node.writeInt(i2);
            for (int i12 = i; i12 < toIndex; i12++) {
                byte bA = byteStrings.get(i12).a(i4);
                if (i12 == i || bA != byteStrings.get(i12 - 1).a(i4)) {
                    node.writeInt(bA & 255);
                }
            }
            d dVar2 = new d();
            while (i < toIndex) {
                byte bA2 = byteStrings.get(i).a(i4);
                int i13 = i + 1;
                int i14 = i13;
                while (true) {
                    if (i14 >= toIndex) {
                        i3 = toIndex;
                        break;
                    } else {
                        if (bA2 != byteStrings.get(i14).a(i4)) {
                            i3 = i14;
                            break;
                        }
                        i14++;
                    }
                }
                if (i13 == i3 && i4 + 1 == byteStrings.get(i).j()) {
                    node.writeInt(indexes.get(i).intValue());
                    j = jA2;
                } else {
                    node.writeInt(((int) (a(dVar2) + jA2)) * (-1));
                    j = jA2;
                    a(j, dVar2, i4 + 1, byteStrings, i, i3, indexes);
                }
                jA2 = j;
                i = i3;
            }
            node.a((a0) dVar2);
        }

        static /* synthetic */ void a(Companion companion, long j, d dVar, int i, List list, int i2, int i3, List list2, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                j = 0;
            }
            companion.a(j, dVar, (i4 & 4) != 0 ? 0 : i, list, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) != 0 ? list.size() : i3, list2);
        }

        private final long a(d dVar) {
            return dVar.getSize() / ((long) 4);
        }

        @JvmStatic
        public final r a(g... byteStrings) {
            Intrinsics.checkNotNullParameter(byteStrings, "byteStrings");
            DefaultConstructorMarker defaultConstructorMarker = null;
            int i = 0;
            if (byteStrings.length == 0) {
                return new r(new g[0], new int[]{0, -1}, defaultConstructorMarker);
            }
            List mutableList = ArraysKt.toMutableList(byteStrings);
            CollectionsKt.sort(mutableList);
            ArrayList arrayList = new ArrayList(byteStrings.length);
            for (g gVar : byteStrings) {
                arrayList.add(-1);
            }
            Integer[] numArr = (Integer[]) arrayList.toArray(new Integer[0]);
            List listMutableListOf = CollectionsKt.mutableListOf(Arrays.copyOf(numArr, numArr.length));
            int length = byteStrings.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                listMutableListOf.set(CollectionsKt.binarySearch$default(mutableList, byteStrings[i2], 0, 0, 6, (Object) null), Integer.valueOf(i3));
                i2++;
                i3++;
            }
            if (((g) mutableList.get(0)).j() <= 0) {
                throw new IllegalArgumentException("the empty byte string is not a supported option".toString());
            }
            int i4 = 0;
            while (i4 < mutableList.size()) {
                g gVar2 = (g) mutableList.get(i4);
                int i5 = i4 + 1;
                int i6 = i5;
                while (i6 < mutableList.size()) {
                    g gVar3 = (g) mutableList.get(i6);
                    if (!gVar3.b(gVar2)) {
                        break;
                    }
                    if (gVar3.j() == gVar2.j()) {
                        throw new IllegalArgumentException(("duplicate option: " + gVar3).toString());
                    }
                    if (((Number) listMutableListOf.get(i6)).intValue() > ((Number) listMutableListOf.get(i4)).intValue()) {
                        mutableList.remove(i6);
                        listMutableListOf.remove(i6);
                    } else {
                        i6++;
                    }
                }
                i4 = i5;
            }
            d dVar = new d();
            a(this, 0L, dVar, 0, mutableList, 0, 0, listMutableListOf, 53, null);
            int[] iArr = new int[(int) a(dVar)];
            while (!dVar.exhausted()) {
                iArr[i] = dVar.readInt();
                i++;
            }
            Object[] objArrCopyOf = Arrays.copyOf(byteStrings, byteStrings.length);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, size)");
            return new r((g[]) objArrCopyOf, iArr, defaultConstructorMarker);
        }
    }

    private r(g[] gVarArr, int[] iArr) {
        this.byteStrings = gVarArr;
        this.trie = iArr;
    }

    public /* bridge */ boolean a(g gVar) {
        return super.contains(gVar);
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final int[] getTrie() {
        return this.trie;
    }

    public /* bridge */ int c(g gVar) {
        return super.lastIndexOf(gVar);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof g) {
            return a((g) obj);
        }
        return false;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    /* JADX INFO: renamed from: getSize */
    public int get_size() {
        return this.byteStrings.length;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof g) {
            return b((g) obj);
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof g) {
            return c((g) obj);
        }
        return -1;
    }

    public /* synthetic */ r(g[] gVarArr, int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(gVarArr, iArr);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public g get(int index) {
        return this.byteStrings[index];
    }

    public /* bridge */ int b(g gVar) {
        return super.indexOf(gVar);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final g[] getByteStrings() {
        return this.byteStrings;
    }
}
