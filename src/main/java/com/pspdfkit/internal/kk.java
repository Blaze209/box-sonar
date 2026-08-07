package com.pspdfkit.internal;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.InkAnnotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class kk extends d7<mk> implements gg {
    public final tw b;
    public int c;
    public final long d;
    public long e;
    public boolean f;

    public kk(boolean z) {
        super(new mk(z, 15));
        this.b = new tw();
        this.d = System.currentTimeMillis();
    }

    @Override // com.pspdfkit.internal.d7, com.pspdfkit.internal.r4
    public final Annotation a(int i, Matrix matrix, float f) {
        matrix.getClass();
        return null;
    }

    @Override // com.pspdfkit.internal.d7, com.pspdfkit.internal.r4
    public final boolean b(Annotation annotation, Matrix matrix, float f) {
        matrix.getClass();
        return false;
    }

    public final void e() {
        if (this.f) {
            mk mkVar = (mk) this.a;
            List<List<PointF>> list = this.b.a;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(CollectionsKt.toList((List) it.next()));
            }
            mkVar.o.clear();
            mkVar.o.addAll(arrayList);
            mkVar.t = true;
            mkVar.i();
            this.f = false;
        }
    }

    @Override // com.pspdfkit.internal.d7, com.pspdfkit.internal.r4
    public final boolean a(Annotation annotation, Matrix matrix, float f, boolean z) {
        boolean z2;
        annotation.getClass();
        matrix.getClass();
        if (((mk) this.a).t) {
            return false;
        }
        if (!(annotation instanceof InkAnnotation)) {
            throw new IllegalArgumentException("setAnnotation is implemented only for InkAnnotations.");
        }
        List<List<PointF>> lines = ((InkAnnotation) annotation).getLines();
        if (lines == null) {
            lines = Collections.EMPTY_LIST;
        }
        lines.getClass();
        int iHashCode = lines.hashCode();
        if (this.c == iHashCode) {
            z2 = false;
        } else {
            this.c = iHashCode;
            Matrix matrix2 = new Matrix(matrix);
            z2 = true;
            float f2 = 1 / f;
            matrix2.postScale(f2, f2);
            ArrayList arrayList = new ArrayList(lines.size());
            for (List<PointF> list : lines) {
                ArrayList arrayList2 = new ArrayList(list.size());
                for (PointF pointF : list) {
                    PointF pointF2 = new PointF();
                    pointF2.set(pointF);
                    s60.a(pointF2, matrix2);
                    arrayList2.add(pointF2);
                }
                arrayList.add(arrayList2);
            }
            if (Intrinsics.areEqual(((mk) this.a).o, arrayList)) {
                z2 = false;
            } else {
                mk mkVar = (mk) this.a;
                mkVar.o.clear();
                mkVar.q.reset();
                mkVar.t = true;
                if (mkVar.n) {
                    mkVar.o.addAll(arrayList);
                    mkVar.i();
                } else {
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        ArrayList arrayList3 = new ArrayList(500);
                        mkVar.p = arrayList3;
                        mkVar.o.add(arrayList3);
                        Iterator it = ((List) obj).iterator();
                        while (it.hasNext()) {
                            mkVar.a((PointF) it.next(), matrix, f);
                        }
                        ArrayList arrayList4 = mkVar.p;
                        if (arrayList4.size() > 1) {
                            PointF pointF3 = (PointF) CollectionsKt.last((List) arrayList4);
                            mkVar.q.lineTo(pointF3.x, pointF3.y);
                        }
                    }
                }
                a(2);
            }
            tw twVar = this.b;
            twVar.getClass();
            ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            int size2 = arrayList.size();
            int i2 = 0;
            while (i2 < size2) {
                Object obj2 = arrayList.get(i2);
                i2++;
                arrayList5.add(CollectionsKt.toMutableList((Collection) obj2));
            }
            List<List<PointF>> mutableList = CollectionsKt.toMutableList((Collection) arrayList5);
            twVar.a = mutableList;
            ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(mutableList, 10));
            Iterator<T> it2 = mutableList.iterator();
            while (it2.hasNext()) {
                arrayList6.add(tw.a((List) it2.next()));
            }
            twVar.b = CollectionsKt.toMutableList((Collection) arrayList6);
        }
        boolean zA = super.a(annotation, matrix, f, z) | z2;
        ((mk) this.a).t = false;
        return zA;
    }

    public kk(int i, int i2, float f, float f2, boolean z) {
        super(new mk(i, i2, f, f2, z));
        this.b = new tw();
        this.d = System.currentTimeMillis();
    }

    @Override // com.pspdfkit.internal.d7, com.pspdfkit.internal.f10
    public final void a(int i) {
        if (i != 0 && i != 0) {
            this.a.a(i);
            if (i == 2) {
                this.e = System.currentTimeMillis();
                return;
            }
            return;
        }
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:52:0x016f A[PHI: r18
      0x016f: PHI (r18v5 float) = (r18v4 float), (r18v7 float) binds: [B:51:0x016d, B:48:0x014d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:54:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:55:0x01af  */
    /* JADX WARN: Code duplicated, block: B:60:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:71:0x0219  */
    /* JADX WARN: Code duplicated, block: B:72:0x0244  */
    /* JADX WARN: Code duplicated, block: B:73:0x0257 A[PHI: r18
      0x0257: PHI (r18v6 float) = (r18v4 float), (r18v7 float) binds: [B:51:0x016d, B:48:0x014d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARN: Type inference failed for: r2v23, types: [android.graphics.PointF[], java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r6v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v40 */
    /* JADX WARN: Type inference failed for: r7v12, types: [android.graphics.PointF[], java.lang.Object[]] */
    @Override // com.pspdfkit.internal.gg
    public final boolean a(float f, float f2, float f3) {
        ?? r6;
        PointF pointF;
        float f4;
        boolean z;
        float f5;
        List listEmptyList;
        ?? r16;
        float f6;
        float f7;
        float f8;
        float f9;
        PointF pointF2;
        float f10;
        float f11;
        float f12;
        float f13;
        ArrayList arrayList;
        double d;
        double d2;
        List listEmptyList2;
        List listListOf;
        float f14 = f3;
        PointF pointF3 = new PointF(f, f2);
        tw twVar = this.b;
        twVar.getClass();
        float f15 = f14 * f14;
        int lastIndex = CollectionsKt.getLastIndex(twVar.a);
        boolean z2 = false;
        boolean z3 = false;
        while (true) {
            boolean z4 = true;
            if (-1 >= lastIndex) {
                break;
            }
            List<PointF> list = twVar.a.get(lastIndex);
            RectF rectF = twVar.b.get(lastIndex);
            if (list.isEmpty()) {
                twVar.a.remove(lastIndex);
                twVar.b.remove(lastIndex);
            } else {
                float f16 = pointF3.x;
                if (f16 >= rectF.left - f14 && f16 <= rectF.right + f14) {
                    float f17 = pointF3.y;
                    if (f17 >= rectF.top - f14 && f17 <= rectF.bottom + f14) {
                        if (list.size() == 1) {
                            PointF pointF4 = list.get(z2 ? 1 : 0);
                            float f18 = pointF4.x - pointF3.x;
                            float f19 = pointF4.y - pointF3.y;
                            if ((f19 * f19) + (f18 * f18) <= f15) {
                                twVar.a.remove(lastIndex);
                                twVar.b.remove(lastIndex);
                                pointF = pointF3;
                                f4 = f15;
                                z3 = true;
                            }
                        } else {
                            int i = 2;
                            if (list.size() < 2) {
                                listEmptyList = CollectionsKt.emptyList();
                                pointF = pointF3;
                                f4 = f15;
                                z = z3;
                                f5 = 0.1f;
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                int size = list.size() - 1;
                                int i2 = z2 ? 1 : 0;
                                while (i2 < size) {
                                    PointF pointF5 = list.get(i2);
                                    i2++;
                                    PointF pointF6 = list.get(i2);
                                    float fA = tw.a(pointF5, pointF3);
                                    float fA2 = tw.a(pointF6, pointF3);
                                    if (fA <= f15) {
                                        r6 = z2;
                                        r16 = z4;
                                    } else {
                                        r6 = z2;
                                        r16 = r6;
                                    }
                                    ?? r17 = fA2 <= f15 ? z4 : r6;
                                    if (r16 != 0 && r17 != 0) {
                                        listListOf = CollectionsKt.emptyList();
                                    } else if (r16 != 0 && r17 == 0) {
                                        PointF pointFA = tw.a(pointF5, pointF6, pointF3, f14, z4);
                                        boolean z5 = z4;
                                        PointF[] pointFArr = new PointF[i];
                                        pointFArr[r6] = pointFA;
                                        pointFArr[z5 ? 1 : 0] = pointF6;
                                        listListOf = CollectionsKt.listOf(CollectionsKt.listOf((Object[]) pointFArr));
                                    } else {
                                        boolean z6 = z4;
                                        if (r16 == 0 && r17 != 0) {
                                            PointF pointFA2 = tw.a(pointF5, pointF6, pointF3, f14, r6);
                                            PointF[] pointFArr2 = new PointF[i];
                                            pointFArr2[r6] = pointF5;
                                            pointFArr2[z6 ? 1 : 0] = pointFA2;
                                            listListOf = CollectionsKt.listOf(CollectionsKt.listOf((Object[]) pointFArr2));
                                        } else {
                                            float f20 = pointF6.x;
                                            ?? r18 = r6;
                                            float f21 = pointF5.x;
                                            float f22 = f20 - f21;
                                            float f23 = pointF6.y;
                                            float f24 = pointF5.y;
                                            float f25 = f23 - f24;
                                            float f26 = ((pointF3.y - f24) * f25) + ((pointF3.x - f21) * f22);
                                            float f27 = (f25 * f25) + (f22 * f22);
                                            if (f27 == 0.0f) {
                                                f6 = f15;
                                                if (tw.a(pointF5, pointF3) <= f15) {
                                                    float f28 = pointF6.x;
                                                    float f29 = pointF5.x;
                                                    f7 = f28 - f29;
                                                    float f30 = pointF6.y;
                                                    float f31 = pointF5.y;
                                                    f8 = f30 - f31;
                                                    float f32 = f29 - pointF3.x;
                                                    float f33 = f31 - pointF3.y;
                                                    f9 = (f8 * f8) + (f7 * f7);
                                                    pointF2 = pointF3;
                                                    f10 = 2;
                                                    f11 = ((f33 * f8) + (f32 * f7)) * f10;
                                                    f12 = (f11 * f11) - ((4 * f9) * (((f33 * f33) + (f32 * f32)) - f6));
                                                    if (f12 < 0.0f) {
                                                        listEmptyList2 = CollectionsKt.emptyList();
                                                    } else {
                                                        float fSqrt = (float) Math.sqrt(f12);
                                                        float f34 = -f11;
                                                        float f35 = f10 * f9;
                                                        float f36 = (f34 - fSqrt) / f35;
                                                        f13 = (f34 + fSqrt) / f35;
                                                        arrayList = new ArrayList();
                                                        d = f36;
                                                        if (0.0d > d && d <= 1.0d) {
                                                            arrayList.add(new PointF((f36 * f7) + pointF5.x, (f36 * f8) + pointF5.y));
                                                        }
                                                        d2 = f13;
                                                        if (0.0d <= d2 && d2 <= 1.0d && Math.abs(f13 - f36) > 0.001f) {
                                                            arrayList.add(new PointF((f7 * f13) + pointF5.x, (f13 * f8) + pointF5.y));
                                                        }
                                                        listEmptyList2 = arrayList;
                                                    }
                                                    if (listEmptyList2.size() == 2) {
                                                        ?? r2 = new PointF[2];
                                                        r2[r18 == true ? 1 : 0] = pointF5;
                                                        r2[z6 ? 1 : 0] = listEmptyList2.get(r18 == true ? 1 : 0);
                                                        List listListOf2 = CollectionsKt.listOf((Object[]) r2);
                                                        ?? r7 = new PointF[2];
                                                        r7[r18 == true ? 1 : 0] = listEmptyList2.get(z6 ? 1 : 0);
                                                        r7[z6 ? 1 : 0] = pointF6;
                                                        List listListOf3 = CollectionsKt.listOf((Object[]) r7);
                                                        List[] listArr = new List[2];
                                                        listArr[r18 == true ? 1 : 0] = listListOf2;
                                                        listArr[z6 ? 1 : 0] = listListOf3;
                                                        listListOf = CollectionsKt.listOf((Object[]) listArr);
                                                    } else {
                                                        PointF[] pointFArr3 = new PointF[2];
                                                        pointFArr3[r18 == true ? 1 : 0] = pointF5;
                                                        pointFArr3[z6 ? 1 : 0] = pointF6;
                                                        listListOf = CollectionsKt.listOf(CollectionsKt.listOf((Object[]) pointFArr3));
                                                    }
                                                } else {
                                                    pointF2 = pointF3;
                                                    z3 = z3;
                                                    PointF[] pointFArr4 = new PointF[2];
                                                    pointFArr4[r18 == true ? 1 : 0] = pointF5;
                                                    pointFArr4[z6 ? 1 : 0] = pointF6;
                                                    listListOf = CollectionsKt.listOf(CollectionsKt.listOf((Object[]) pointFArr4));
                                                }
                                            } else {
                                                float f37 = f26 / f27;
                                                f6 = f15;
                                                float fCoerceIn = RangesKt.coerceIn(f37, 0.0f, 1.0f);
                                                if (tw.a(new PointF((f22 * fCoerceIn) + pointF5.x, (fCoerceIn * f25) + pointF5.y), pointF3) <= f6) {
                                                    float f210 = pointF6.x;
                                                    float f211 = pointF5.x;
                                                    f7 = f210 - f211;
                                                    float f38 = pointF6.y;
                                                    float f39 = pointF5.y;
                                                    f8 = f38 - f39;
                                                    float f310 = f211 - pointF3.x;
                                                    float f311 = f39 - pointF3.y;
                                                    f9 = (f8 * f8) + (f7 * f7);
                                                    pointF2 = pointF3;
                                                    f10 = 2;
                                                    f11 = ((f311 * f8) + (f310 * f7)) * f10;
                                                    f12 = (f11 * f11) - ((4 * f9) * (((f311 * f311) + (f310 * f310)) - f6));
                                                    if (f12 < 0.0f) {
                                                        listEmptyList2 = CollectionsKt.emptyList();
                                                    } else {
                                                        float fSqrt2 = (float) Math.sqrt(f12);
                                                        float f312 = -f11;
                                                        float f313 = f10 * f9;
                                                        float f314 = (f312 - fSqrt2) / f313;
                                                        f13 = (f312 + fSqrt2) / f313;
                                                        arrayList = new ArrayList();
                                                        d = f314;
                                                        if (0.0d > d) {
                                                        }
                                                        d2 = f13;
                                                        if (0.0d <= d2) {
                                                            arrayList.add(new PointF((f7 * f13) + pointF5.x, (f13 * f8) + pointF5.y));
                                                        }
                                                        listEmptyList2 = arrayList;
                                                    }
                                                    if (listEmptyList2.size() == 2) {
                                                        ?? r3 = new PointF[2];
                                                        r3[r18 == true ? 1 : 0] = pointF5;
                                                        r3[z6 ? 1 : 0] = listEmptyList2.get(r18 == true ? 1 : 0);
                                                        List listListOf4 = CollectionsKt.listOf((Object[]) r3);
                                                        ?? r8 = new PointF[2];
                                                        r8[r18 == true ? 1 : 0] = listEmptyList2.get(z6 ? 1 : 0);
                                                        r8[z6 ? 1 : 0] = pointF6;
                                                        List listListOf5 = CollectionsKt.listOf((Object[]) r8);
                                                        List[] listArr2 = new List[2];
                                                        listArr2[r18 == true ? 1 : 0] = listListOf4;
                                                        listArr2[z6 ? 1 : 0] = listListOf5;
                                                        listListOf = CollectionsKt.listOf((Object[]) listArr2);
                                                    } else {
                                                        PointF[] pointFArr5 = new PointF[2];
                                                        pointFArr5[r18 == true ? 1 : 0] = pointF5;
                                                        pointFArr5[z6 ? 1 : 0] = pointF6;
                                                        listListOf = CollectionsKt.listOf(CollectionsKt.listOf((Object[]) pointFArr5));
                                                    }
                                                } else {
                                                    pointF2 = pointF3;
                                                    z3 = z3;
                                                    PointF[] pointFArr6 = new PointF[2];
                                                    pointFArr6[r18 == true ? 1 : 0] = pointF5;
                                                    pointFArr6[z6 ? 1 : 0] = pointF6;
                                                    listListOf = CollectionsKt.listOf(CollectionsKt.listOf((Object[]) pointFArr6));
                                                }
                                            }
                                        }
                                        arrayList2.addAll(listListOf);
                                        f14 = f3;
                                        f15 = f6;
                                        z3 = z3;
                                        pointF3 = pointF2;
                                        r6 = 0;
                                        z4 = true;
                                        i = 2;
                                    }
                                    pointF2 = pointF3;
                                    f6 = f15;
                                    z3 = z3;
                                    arrayList2.addAll(listListOf);
                                    f14 = f3;
                                    f15 = f6;
                                    z3 = z3;
                                    pointF3 = pointF2;
                                    r6 = 0;
                                    z4 = true;
                                    i = 2;
                                }
                                r6 = z2;
                                pointF = pointF3;
                                f4 = f15;
                                z = z3;
                                f5 = 0.1f;
                                if (arrayList2.isEmpty()) {
                                    listEmptyList = CollectionsKt.emptyList();
                                } else {
                                    ArrayList arrayList3 = new ArrayList();
                                    List arrayList4 = new ArrayList();
                                    int size2 = arrayList2.size();
                                    int i3 = 0;
                                    while (i3 < size2) {
                                        Object obj = arrayList2.get(i3);
                                        i3++;
                                        List list2 = (List) obj;
                                        if (list2.size() >= 2) {
                                            if (arrayList4.isEmpty()) {
                                                arrayList4.addAll(list2);
                                            } else {
                                                PointF pointF7 = (PointF) CollectionsKt.last(arrayList4);
                                                PointF pointF8 = (PointF) CollectionsKt.first(list2);
                                                pointF7.getClass();
                                                pointF8.getClass();
                                                if (((float) Math.sqrt(tw.a(pointF7, pointF8))) < 0.1f) {
                                                    arrayList4.addAll(CollectionsKt.drop(list2, 1));
                                                } else {
                                                    if (arrayList4.size() >= 2) {
                                                        arrayList3.add(arrayList4);
                                                    }
                                                    arrayList4 = CollectionsKt.toMutableList((Collection) list2);
                                                }
                                            }
                                        }
                                    }
                                    if (arrayList4.size() >= 2) {
                                        arrayList3.add(arrayList4);
                                    }
                                    listEmptyList = arrayList3;
                                }
                            }
                            if (listEmptyList.isEmpty()) {
                                twVar.a.remove(lastIndex);
                                twVar.b.remove(lastIndex);
                            } else {
                                if (listEmptyList.size() <= 1) {
                                    List list3 = (List) CollectionsKt.first(listEmptyList);
                                    if (list3.size() == list.size()) {
                                        List listZip = CollectionsKt.zip(list3, list);
                                        if (!(listZip instanceof Collection) || !listZip.isEmpty()) {
                                            Iterator it = listZip.iterator();
                                            while (true) {
                                                if (it.hasNext()) {
                                                    Pair pair = (Pair) it.next();
                                                    PointF pointF9 = (PointF) pair.component1();
                                                    PointF pointF10 = (PointF) pair.component2();
                                                    pointF9.getClass();
                                                    pointF10.getClass();
                                                    if (((float) Math.sqrt(tw.a(pointF9, pointF10))) < f5) {
                                                    }
                                                }
                                            }
                                        }
                                        z3 = z;
                                    }
                                }
                                twVar.a.set(lastIndex, (List<PointF>) CollectionsKt.first(listEmptyList));
                                twVar.b.set(lastIndex, tw.a((List) CollectionsKt.first(listEmptyList)));
                                if (listEmptyList.size() > 1) {
                                    List listDrop = CollectionsKt.drop(listEmptyList, 1);
                                    ArrayList arrayList5 = new ArrayList();
                                    Iterator it2 = listDrop.iterator();
                                    while (it2.hasNext()) {
                                        arrayList5.add(tw.a((List) it2.next()));
                                    }
                                    int i4 = lastIndex + 1;
                                    twVar.a.addAll(i4, listDrop);
                                    twVar.b.addAll(i4, arrayList5);
                                }
                            }
                            z3 = true;
                        }
                    }
                }
                lastIndex--;
                f14 = f3;
                f15 = f4;
                pointF3 = pointF;
                z2 = false;
            }
            pointF = pointF3;
            f4 = f15;
            z = z3;
            z3 = z;
            lastIndex--;
            f14 = f3;
            f15 = f4;
            pointF3 = pointF;
            z2 = false;
        }
        if (!z3) {
            return false;
        }
        this.f = true;
        return true;
    }

    public final ArrayList a(Matrix matrix, float f) {
        matrix.getClass();
        ArrayList arrayList = ((mk) this.a).o;
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ArrayList arrayList3 = new ArrayList();
            for (PointF pointF : (List) obj) {
                arrayList3.add(new PointF(pointF.x * f, pointF.y * f));
            }
            Matrix matrix2 = new Matrix();
            matrix.invert(matrix2);
            int size2 = arrayList3.size();
            int i2 = 0;
            while (i2 < size2) {
                Object obj2 = arrayList3.get(i2);
                i2++;
                s60.a((PointF) obj2, matrix2);
            }
            arrayList2.add(arrayList3);
        }
        return arrayList2;
    }
}
