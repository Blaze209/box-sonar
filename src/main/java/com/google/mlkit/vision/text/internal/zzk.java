package com.google.mlkit.vision.text.internal;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.SparseArray;
import androidx.media3.common.C;
import com.google.android.gms.internal.mlkit_vision_text_common.zzbh;
import com.google.android.gms.internal.mlkit_vision_text_common.zzbk;
import com.google.android.gms.internal.mlkit_vision_text_common.zzbu;
import com.google.android.gms.internal.mlkit_vision_text_common.zzcp;
import com.google.android.gms.internal.mlkit_vision_text_common.zzu;
import com.google.android.gms.internal.mlkit_vision_text_common.zzv;
import com.google.android.gms.internal.mlkit_vision_text_common.zzy;
import com.google.mlkit.vision.text.Text;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* JADX INFO: loaded from: classes14.dex */
final class zzk {
    public static final /* synthetic */ int zzb = 0;
    static final zzv zza = zzv.zza("\n");
    private static final Comparator zzc = new Comparator() { // from class: com.google.mlkit.vision.text.internal.zzf
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int i = zzk.zzb;
            return ((Integer) ((Map.Entry) obj).getValue()).compareTo((Integer) ((Map.Entry) obj2).getValue());
        }
    };

    /* JADX WARN: Multi-variable type inference failed */
    static Text zza(com.google.android.gms.internal.mlkit_vision_text_common.zzl[] zzlVarArr, final Matrix matrix) {
        SparseArray sparseArray = new SparseArray();
        int i = 0;
        for (com.google.android.gms.internal.mlkit_vision_text_common.zzl zzlVar : zzlVarArr) {
            SparseArray sparseArray2 = (SparseArray) sparseArray.get(zzlVar.zzj);
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                sparseArray.append(zzlVar.zzj, sparseArray2);
            }
            sparseArray2.append(zzlVar.zzk, zzlVar);
        }
        zzbh zzbhVar = new zzbh();
        int i2 = 0;
        while (i2 < sparseArray.size()) {
            SparseArray sparseArray3 = (SparseArray) sparseArray.valueAt(i2);
            zzbh zzbhVar2 = new zzbh();
            for (int i3 = i; i3 < sparseArray3.size(); i3++) {
                zzbhVar2.zza((com.google.android.gms.internal.mlkit_vision_text_common.zzl) sparseArray3.valueAt(i3));
            }
            zzbk zzbkVarZzb = zzbhVar2.zzb();
            List listZza = zzbu.zza(zzbkVarZzb, new zzu() { // from class: com.google.mlkit.vision.text.internal.zzh
                @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzu
                public final Object zza(Object obj) {
                    com.google.android.gms.internal.mlkit_vision_text_common.zzl zzlVar2 = (com.google.android.gms.internal.mlkit_vision_text_common.zzl) obj;
                    int i4 = zzk.zzb;
                    List listZzb = zza.zzb(zzlVar2.zzb);
                    String str = zzy.zzb(zzlVar2.zze) ? "" : zzlVar2.zze;
                    Rect rectZza = zza.zza(listZzb);
                    String str2 = zzy.zzb(zzlVar2.zzg) ? C.LANGUAGE_UNDETERMINED : zzlVar2.zzg;
                    final Matrix matrix2 = matrix;
                    return new Text.Line(str, rectZza, listZzb, str2, matrix2, zzbu.zza(Arrays.asList(zzlVar2.zza), new zzu() { // from class: com.google.mlkit.vision.text.internal.zzj
                        @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzu
                        public final Object zza(Object obj2) {
                            com.google.android.gms.internal.mlkit_vision_text_common.zzr zzrVar = (com.google.android.gms.internal.mlkit_vision_text_common.zzr) obj2;
                            int i5 = zzk.zzb;
                            List listZzb2 = zza.zzb(zzrVar.zzb);
                            return new Text.Element(zzy.zzb(zzrVar.zzd) ? "" : zzrVar.zzd, zza.zza(listZzb2), listZzb2, zzy.zzb(zzrVar.zzf) ? C.LANGUAGE_UNDETERMINED : zzrVar.zzf, matrix2, zzrVar.zze, zzrVar.zzb.zze, zzbk.zzh());
                        }
                    }), zzlVar2.zzf, zzlVar2.zzb.zze);
                }
            });
            com.google.android.gms.internal.mlkit_vision_text_common.zzf zzfVar = ((com.google.android.gms.internal.mlkit_vision_text_common.zzl) zzbkVarZzb.get(i)).zzb;
            zzcp zzcpVarListIterator = zzbkVarZzb.listIterator(i);
            int iMax = Integer.MIN_VALUE;
            int iMin = Integer.MAX_VALUE;
            int iMin2 = Integer.MAX_VALUE;
            int iMax2 = Integer.MIN_VALUE;
            while (zzcpVarListIterator.hasNext()) {
                com.google.android.gms.internal.mlkit_vision_text_common.zzf zzfVar2 = ((com.google.android.gms.internal.mlkit_vision_text_common.zzl) zzcpVarListIterator.next()).zzb;
                int i4 = i;
                int i5 = -zzfVar.zza;
                int i6 = -zzfVar.zzb;
                SparseArray sparseArray4 = sparseArray;
                int i7 = i2;
                double dSin = Math.sin(Math.toRadians(zzfVar.zze));
                double dCos = Math.cos(Math.toRadians(zzfVar.zze));
                Point[] pointArr = new Point[4];
                Point point = new Point(zzfVar2.zza, zzfVar2.zzb);
                pointArr[i4] = point;
                point.offset(i5, i6);
                double d = ((double) pointArr[i4].x) * dCos;
                double d2 = ((double) pointArr[i4].y) * dSin;
                double d3 = ((double) (-pointArr[i4].x)) * dSin;
                double d4 = ((double) pointArr[i4].y) * dCos;
                int i8 = (int) (d + d2);
                pointArr[i4].x = i8;
                zzcp zzcpVar = zzcpVarListIterator;
                int i9 = (int) (d3 + d4);
                pointArr[i4].y = i9;
                pointArr[1] = new Point(zzfVar2.zzc + i8, i9);
                pointArr[2] = new Point(zzfVar2.zzc + i8, zzfVar2.zzd + i9);
                pointArr[3] = new Point(i8, i9 + zzfVar2.zzd);
                for (int i10 = i4; i10 < 4; i10++) {
                    Point point2 = pointArr[i10];
                    iMin = Math.min(iMin, point2.x);
                    iMax = Math.max(iMax, point2.x);
                    iMin2 = Math.min(iMin2, point2.y);
                    iMax2 = Math.max(iMax2, point2.y);
                }
                zzcpVarListIterator = zzcpVar;
                i = i4;
                sparseArray = sparseArray4;
                i2 = i7;
            }
            SparseArray sparseArray5 = sparseArray;
            int i11 = i2;
            int i12 = i;
            int i13 = zzfVar.zza;
            int i14 = zzfVar.zzb;
            double dSin2 = Math.sin(Math.toRadians(zzfVar.zze));
            double dCos2 = Math.cos(Math.toRadians(zzfVar.zze));
            Point[] pointArr2 = new Point[4];
            pointArr2[i12] = new Point(iMin, iMin2);
            pointArr2[1] = new Point(iMax, iMin2);
            pointArr2[2] = new Point(iMax, iMax2);
            pointArr2[3] = new Point(iMin, iMax2);
            int i15 = i12;
            while (i15 < 4) {
                double d5 = ((double) pointArr2[i15].x) * dCos2;
                double d6 = ((double) pointArr2[i15].y) * dSin2;
                double d7 = ((double) pointArr2[i15].x) * dSin2;
                double d8 = dSin2;
                double d9 = ((double) pointArr2[i15].y) * dCos2;
                pointArr2[i15].x = (int) (d5 - d6);
                pointArr2[i15].y = (int) (d7 + d9);
                pointArr2[i15].offset(i13, i14);
                i15++;
                dSin2 = d8;
            }
            List listAsList = Arrays.asList(pointArr2);
            zzbhVar.zza(new Text.TextBlock(zza.zzb(zzbu.zza(listZza, new zzu() { // from class: com.google.mlkit.vision.text.internal.zzi
                @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzu
                public final Object zza(Object obj) {
                    return ((Text.Line) obj).getText();
                }
            })), zza.zza(listAsList), listAsList, zzb(listZza), matrix, listZza));
            i2 = i11 + 1;
            i = i12;
            sparseArray = sparseArray5;
        }
        zzbk zzbkVarZzb2 = zzbhVar.zzb();
        return new Text(zza.zzb(zzbu.zza(zzbkVarZzb2, new zzu() { // from class: com.google.mlkit.vision.text.internal.zzg
            @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzu
            public final Object zza(Object obj) {
                return ((Text.TextBlock) obj).getText();
            }
        })), zzbkVarZzb2);
    }

    private static String zzb(List list) {
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String recognizedLanguage = ((Text.Line) it.next()).getRecognizedLanguage();
            map.put(recognizedLanguage, Integer.valueOf((map.containsKey(recognizedLanguage) ? ((Integer) map.get(recognizedLanguage)).intValue() : 0) + 1));
        }
        Set setEntrySet = map.entrySet();
        if (setEntrySet.isEmpty()) {
            return C.LANGUAGE_UNDETERMINED;
        }
        String str = (String) ((Map.Entry) Collections.max(setEntrySet, zzc)).getKey();
        return !zzy.zzb(str) ? str : C.LANGUAGE_UNDETERMINED;
    }
}
