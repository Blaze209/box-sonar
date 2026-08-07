package com.google.android.gms.internal.measurement;

import androidx.media3.common.C;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
final class zzgs<T> implements zzhd<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzib.zzc();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzgo zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final boolean zzk;
    private final int[] zzl;
    private final int zzm;
    private final int zzn;
    private final zzgw zzo;
    private final zzfy zzp;
    private final zzhv<?, ?> zzq;
    private final zzes<?> zzr;
    private final zzgh zzs;

    private zzgs(int[] iArr, Object[] objArr, int i, int i2, zzgo zzgoVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzgw zzgwVar, zzfy zzfyVar, zzhv<?, ?> zzhvVar, zzes<?> zzesVar, zzgh zzghVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzgoVar instanceof zzfd;
        this.zzj = z;
        this.zzh = zzesVar != null && zzesVar.zza(zzgoVar);
        this.zzk = false;
        this.zzl = iArr2;
        this.zzm = i3;
        this.zzn = i4;
        this.zzo = zzgwVar;
        this.zzp = zzfyVar;
        this.zzq = zzhvVar;
        this.zzr = zzesVar;
        this.zzg = zzgoVar;
        this.zzs = zzghVar;
    }

    private static boolean zzf(int i) {
        return (i & C.BUFFER_FLAG_LAST_SAMPLE) != 0;
    }

    /* JADX WARN: Code duplicated, block: B:168:0x0370  */
    /* JADX WARN: Code duplicated, block: B:170:0x0374  */
    /* JADX WARN: Code duplicated, block: B:172:0x037f  */
    /* JADX WARN: Code duplicated, block: B:175:0x038b A[LOOP:6: B:173:0x0383->B:175:0x038b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:177:0x0399  */
    /* JADX WARN: Code duplicated, block: B:180:0x03ab  */
    /* JADX WARN: Code duplicated, block: B:181:0x03ae  */
    /* JADX WARN: Code duplicated, block: B:183:0x03be  */
    /* JADX WARN: Code duplicated, block: B:184:0x03c1  */
    /* JADX WARN: Code duplicated, block: B:188:0x03cd  */
    /* JADX WARN: Code duplicated, block: B:191:0x03dd  */
    /* JADX WARN: Code duplicated, block: B:214:0x0395 A[EDGE_INSN: B:214:0x0395->B:176:0x0395 BREAK  A[LOOP:6: B:173:0x0383->B:175:0x038b], SYNTHETIC] */
    static <T> zzgs<T> zza(Class<T> cls, zzgm zzgmVar, zzgw zzgwVar, zzfy zzfyVar, zzhv<?, ?> zzhvVar, zzes<?> zzesVar, zzgh zzghVar) {
        int i;
        int iCharAt;
        int i2;
        int i3;
        int[] iArr;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        char cCharAt;
        int i9;
        char cCharAt2;
        int i10;
        char cCharAt3;
        int i11;
        char cCharAt4;
        int i12;
        char cCharAt5;
        int i13;
        char cCharAt6;
        int i14;
        char cCharAt7;
        int i15;
        char cCharAt8;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int iObjectFieldOffset;
        int i21;
        int iObjectFieldOffset2;
        int i22;
        int i23;
        int i24;
        int iCharAt2;
        int i25;
        Object obj;
        Field fieldZza;
        int i26;
        int i27;
        char cCharAt9;
        int i28;
        Field fieldZza2;
        Field fieldZza3;
        int i29;
        int i30;
        char cCharAt10;
        int i31;
        char cCharAt11;
        int i32;
        int i33;
        char cCharAt12;
        int i34;
        char cCharAt13;
        char cCharAt14;
        if (zzgmVar instanceof zzhb) {
            zzhb zzhbVar = (zzhb) zzgmVar;
            int i35 = 0;
            boolean z = zzhbVar.zza() == zzfd.zze.zzi;
            String strZzd = zzhbVar.zzd();
            int length = strZzd.length();
            int iCharAt3 = strZzd.charAt(0);
            if (iCharAt3 >= 55296) {
                int i36 = iCharAt3 & 8191;
                int i37 = 1;
                int i38 = 13;
                while (true) {
                    i = i37 + 1;
                    cCharAt14 = strZzd.charAt(i37);
                    if (cCharAt14 < 55296) {
                        break;
                    }
                    i36 |= (cCharAt14 & 8191) << i38;
                    i38 += 13;
                    i37 = i;
                }
                iCharAt3 = i36 | (cCharAt14 << i38);
            } else {
                i = 1;
            }
            int i39 = i + 1;
            int iCharAt4 = strZzd.charAt(i);
            if (iCharAt4 >= 55296) {
                int i40 = iCharAt4 & 8191;
                int i41 = 13;
                while (true) {
                    i34 = i39 + 1;
                    cCharAt13 = strZzd.charAt(i39);
                    if (cCharAt13 < 55296) {
                        break;
                    }
                    i40 |= (cCharAt13 & 8191) << i41;
                    i41 += 13;
                    i39 = i34;
                }
                iCharAt4 = i40 | (cCharAt13 << i41);
                i39 = i34;
            }
            if (iCharAt4 == 0) {
                i4 = 0;
                iCharAt = 0;
                i6 = 0;
                i7 = 0;
                i3 = 0;
                iArr = zza;
                i5 = 0;
            } else {
                int i42 = i39 + 1;
                int iCharAt5 = strZzd.charAt(i39);
                if (iCharAt5 >= 55296) {
                    int i43 = iCharAt5 & 8191;
                    int i44 = 13;
                    while (true) {
                        i15 = i42 + 1;
                        cCharAt8 = strZzd.charAt(i42);
                        if (cCharAt8 < 55296) {
                            break;
                        }
                        i43 |= (cCharAt8 & 8191) << i44;
                        i44 += 13;
                        i42 = i15;
                    }
                    iCharAt5 = i43 | (cCharAt8 << i44);
                    i42 = i15;
                }
                int i45 = i42 + 1;
                int iCharAt6 = strZzd.charAt(i42);
                if (iCharAt6 >= 55296) {
                    int i46 = iCharAt6 & 8191;
                    int i47 = 13;
                    while (true) {
                        i14 = i45 + 1;
                        cCharAt7 = strZzd.charAt(i45);
                        if (cCharAt7 < 55296) {
                            break;
                        }
                        i46 |= (cCharAt7 & 8191) << i47;
                        i47 += 13;
                        i45 = i14;
                    }
                    iCharAt6 = i46 | (cCharAt7 << i47);
                    i45 = i14;
                }
                int i48 = i45 + 1;
                iCharAt = strZzd.charAt(i45);
                if (iCharAt >= 55296) {
                    int i49 = iCharAt & 8191;
                    int i50 = 13;
                    while (true) {
                        i13 = i48 + 1;
                        cCharAt6 = strZzd.charAt(i48);
                        if (cCharAt6 < 55296) {
                            break;
                        }
                        i49 |= (cCharAt6 & 8191) << i50;
                        i50 += 13;
                        i48 = i13;
                    }
                    iCharAt = i49 | (cCharAt6 << i50);
                    i48 = i13;
                }
                int i51 = i48 + 1;
                int iCharAt7 = strZzd.charAt(i48);
                if (iCharAt7 >= 55296) {
                    int i52 = iCharAt7 & 8191;
                    int i53 = 13;
                    while (true) {
                        i12 = i51 + 1;
                        cCharAt5 = strZzd.charAt(i51);
                        if (cCharAt5 < 55296) {
                            break;
                        }
                        i52 |= (cCharAt5 & 8191) << i53;
                        i53 += 13;
                        i51 = i12;
                    }
                    iCharAt7 = i52 | (cCharAt5 << i53);
                    i51 = i12;
                }
                int i54 = i51 + 1;
                int iCharAt8 = strZzd.charAt(i51);
                if (iCharAt8 >= 55296) {
                    int i55 = iCharAt8 & 8191;
                    int i56 = 13;
                    while (true) {
                        i11 = i54 + 1;
                        cCharAt4 = strZzd.charAt(i54);
                        if (cCharAt4 < 55296) {
                            break;
                        }
                        i55 |= (cCharAt4 & 8191) << i56;
                        i56 += 13;
                        i54 = i11;
                    }
                    iCharAt8 = i55 | (cCharAt4 << i56);
                    i54 = i11;
                }
                int i57 = i54 + 1;
                int iCharAt9 = strZzd.charAt(i54);
                if (iCharAt9 >= 55296) {
                    int i58 = iCharAt9 & 8191;
                    int i59 = 13;
                    while (true) {
                        i10 = i57 + 1;
                        cCharAt3 = strZzd.charAt(i57);
                        if (cCharAt3 < 55296) {
                            break;
                        }
                        i58 |= (cCharAt3 & 8191) << i59;
                        i59 += 13;
                        i57 = i10;
                    }
                    iCharAt9 = i58 | (cCharAt3 << i59);
                    i57 = i10;
                }
                int i60 = i57 + 1;
                int iCharAt10 = strZzd.charAt(i57);
                if (iCharAt10 >= 55296) {
                    int i61 = iCharAt10 & 8191;
                    int i62 = i60;
                    int i63 = 13;
                    while (true) {
                        i9 = i62 + 1;
                        cCharAt2 = strZzd.charAt(i62);
                        if (cCharAt2 < 55296) {
                            break;
                        }
                        i61 |= (cCharAt2 & 8191) << i63;
                        i63 += 13;
                        i62 = i9;
                    }
                    iCharAt10 = i61 | (cCharAt2 << i63);
                    i2 = i9;
                } else {
                    i2 = i60;
                }
                int i64 = i2 + 1;
                int iCharAt11 = strZzd.charAt(i2);
                if (iCharAt11 >= 55296) {
                    int i65 = iCharAt11 & 8191;
                    int i66 = i64;
                    int i67 = 13;
                    while (true) {
                        i8 = i66 + 1;
                        cCharAt = strZzd.charAt(i66);
                        if (cCharAt < 55296) {
                            break;
                        }
                        i65 |= (cCharAt & 8191) << i67;
                        i67 += 13;
                        i66 = i8;
                    }
                    iCharAt11 = i65 | (cCharAt << i67);
                    i64 = i8;
                }
                int[] iArr2 = new int[iCharAt11 + iCharAt9 + iCharAt10];
                i3 = (iCharAt5 << 1) + iCharAt6;
                int i68 = iCharAt8;
                iArr = iArr2;
                i4 = i68;
                i5 = iCharAt7;
                i6 = iCharAt9;
                i7 = iCharAt11;
                i35 = iCharAt5;
                i39 = i64;
            }
            int i69 = 1;
            Unsafe unsafe = zzb;
            Object[] objArrZze = zzhbVar.zze();
            Class<?> cls2 = zzhbVar.zzc().getClass();
            int[] iArr3 = new int[i4 * 3];
            Object[] objArr = new Object[i4 << 1];
            int i70 = i6 + i7;
            int i71 = i70;
            int i72 = i7;
            int i73 = 0;
            int i74 = 0;
            while (i39 < length) {
                int i75 = i39 + 1;
                int iCharAt12 = strZzd.charAt(i39);
                int[] iArr4 = iArr3;
                if (iCharAt12 >= 55296) {
                    int i76 = iCharAt12 & 8191;
                    int i77 = i75;
                    int i78 = 13;
                    while (true) {
                        i33 = i77 + 1;
                        cCharAt12 = strZzd.charAt(i77);
                        i16 = length;
                        if (cCharAt12 < 55296) {
                            break;
                        }
                        i76 |= (cCharAt12 & 8191) << i78;
                        i78 += 13;
                        i77 = i33;
                        length = i16;
                    }
                    iCharAt12 = i76 | (cCharAt12 << i78);
                    i17 = i33;
                } else {
                    i16 = length;
                    i17 = i75;
                }
                int i79 = i17 + 1;
                int iCharAt13 = strZzd.charAt(i17);
                if (iCharAt13 >= 55296) {
                    int i80 = iCharAt13 & 8191;
                    int i81 = i79;
                    int i82 = 13;
                    while (true) {
                        i31 = i81 + 1;
                        cCharAt11 = strZzd.charAt(i81);
                        i32 = i80;
                        if (cCharAt11 < 55296) {
                            break;
                        }
                        i80 = i32 | ((cCharAt11 & 8191) << i82);
                        i82 += 13;
                        i81 = i31;
                    }
                    iCharAt13 = i32 | (cCharAt11 << i82);
                    i18 = i31;
                } else {
                    i18 = i79;
                }
                int i83 = i35;
                int i84 = iCharAt13 & 255;
                int i85 = iCharAt3;
                if ((iCharAt13 & 1024) != 0) {
                    iArr[i73] = i74;
                    i73++;
                }
                Object[] objArr2 = objArr;
                if (i84 >= 51) {
                    int i86 = i18 + 1;
                    int iCharAt14 = strZzd.charAt(i18);
                    char c = 55296;
                    if (iCharAt14 >= 55296) {
                        int i87 = iCharAt14 & 8191;
                        int i88 = 13;
                        while (true) {
                            i30 = i86 + 1;
                            cCharAt10 = strZzd.charAt(i86);
                            if (cCharAt10 < c) {
                                break;
                            }
                            i87 |= (cCharAt10 & 8191) << i88;
                            i88 += 13;
                            i86 = i30;
                            c = 55296;
                        }
                        iCharAt14 = i87 | (cCharAt10 << i88);
                        i86 = i30;
                    }
                    int i89 = i84 - 51;
                    int i90 = iCharAt14;
                    if (i89 == 9 || i89 == 17) {
                        objArr2[((i74 / 3) << 1) + 1] = objArrZze[i3];
                        i3++;
                    } else if (i89 == 12 && (i85 & 1) == (i29 = i69)) {
                        objArr2[((i74 / 3) << i29) + i29] = objArrZze[i3];
                        i3++;
                    }
                    int i91 = i90 << 1;
                    Object obj2 = objArrZze[i91];
                    if (obj2 instanceof Field) {
                        fieldZza2 = (Field) obj2;
                    } else {
                        fieldZza2 = zza(cls2, (String) obj2);
                        objArrZze[i91] = fieldZza2;
                    }
                    int i92 = i86;
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZza2);
                    int i93 = i91 + 1;
                    Object obj3 = objArrZze[i93];
                    if (obj3 instanceof Field) {
                        fieldZza3 = (Field) obj3;
                    } else {
                        fieldZza3 = zza(cls2, (String) obj3);
                        objArrZze[i93] = fieldZza3;
                    }
                    i19 = iCharAt12;
                    i39 = i92;
                    strZzd = strZzd;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZza3);
                    i20 = i3;
                    i23 = iObjectFieldOffset3;
                    i22 = 0;
                    i69 = 1;
                    i5 = i5;
                } else {
                    int i94 = i3 + 1;
                    Field fieldZza4 = zza(cls2, (String) objArrZze[i3]);
                    if (i84 == 9 || i84 == 17) {
                        i19 = iCharAt12;
                        objArr2[((i74 / 3) << 1) + 1] = fieldZza4.getType();
                    } else {
                        if (i84 == 27 || i84 == 49) {
                            i19 = iCharAt12;
                            i28 = i3 + 2;
                            objArr2[((i74 / 3) << 1) + 1] = objArrZze[i94];
                        } else if (i84 == 12 || i84 == 30 || i84 == 44) {
                            i19 = iCharAt12;
                            if ((i85 & 1) == 1) {
                                i28 = i3 + 2;
                                objArr2[((i74 / 3) << 1) + 1] = objArrZze[i94];
                            }
                            iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZza4);
                            if ((i85 & 1) == 1) {
                                if (i84 <= 17) {
                                    i24 = i18 + 1;
                                    iCharAt2 = strZzd.charAt(i18);
                                    if (iCharAt2 >= 55296) {
                                        i26 = iCharAt2 & 8191;
                                        i27 = 13;
                                        while (true) {
                                            i21 = i24 + 1;
                                            cCharAt9 = strZzd.charAt(i24);
                                            if (cCharAt9 >= 55296) {
                                                break;
                                            }
                                            i26 |= (cCharAt9 & 8191) << i27;
                                            i27 += 13;
                                            i24 = i21;
                                        }
                                        iCharAt2 = i26 | (cCharAt9 << i27);
                                    } else {
                                        i21 = i24;
                                    }
                                    i69 = 1;
                                    i25 = (i83 << 1) + (iCharAt2 / 32);
                                    obj = objArrZze[i25];
                                    if (obj instanceof Field) {
                                        fieldZza = (Field) obj;
                                    } else {
                                        fieldZza = zza(cls2, (String) obj);
                                        objArrZze[i25] = fieldZza;
                                    }
                                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZza);
                                    i22 = iCharAt2 % 32;
                                } else {
                                    i69 = 1;
                                }
                                if (i84 >= 18 || i84 > 49) {
                                    i23 = iObjectFieldOffset;
                                } else {
                                    iArr[i71] = iObjectFieldOffset;
                                    i23 = iObjectFieldOffset;
                                    i71++;
                                }
                                i39 = i21;
                            } else {
                                i69 = 1;
                            }
                            i21 = i18;
                            iObjectFieldOffset2 = 0;
                            i22 = 0;
                            if (i84 >= 18) {
                                i23 = iObjectFieldOffset;
                            } else {
                                i23 = iObjectFieldOffset;
                            }
                            i39 = i21;
                        } else {
                            if (i84 == 50) {
                                int i95 = i72 + 1;
                                iArr[i72] = i74;
                                int i96 = (i74 / 3) << 1;
                                int i97 = i3 + 2;
                                objArr2[i96] = objArrZze[i94];
                                if ((iCharAt13 & 2048) != 0) {
                                    i20 = i3 + 3;
                                    objArr2[i96 + 1] = objArrZze[i97];
                                    i19 = iCharAt12;
                                    i72 = i95;
                                } else {
                                    i20 = i97;
                                    i72 = i95;
                                    i19 = iCharAt12;
                                }
                            } else {
                                i19 = iCharAt12;
                            }
                            iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZza4);
                            if ((i85 & 1) == 1) {
                                if (i84 <= 17) {
                                    i24 = i18 + 1;
                                    iCharAt2 = strZzd.charAt(i18);
                                    if (iCharAt2 >= 55296) {
                                        i26 = iCharAt2 & 8191;
                                        i27 = 13;
                                        while (true) {
                                            i21 = i24 + 1;
                                            cCharAt9 = strZzd.charAt(i24);
                                            if (cCharAt9 >= 55296) {
                                                break;
                                                break;
                                            }
                                            i26 |= (cCharAt9 & 8191) << i27;
                                            i27 += 13;
                                            i24 = i21;
                                        }
                                        iCharAt2 = i26 | (cCharAt9 << i27);
                                    } else {
                                        i21 = i24;
                                    }
                                    i69 = 1;
                                    i25 = (i83 << 1) + (iCharAt2 / 32);
                                    obj = objArrZze[i25];
                                    if (obj instanceof Field) {
                                        fieldZza = (Field) obj;
                                    } else {
                                        fieldZza = zza(cls2, (String) obj);
                                        objArrZze[i25] = fieldZza;
                                    }
                                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZza);
                                    i22 = iCharAt2 % 32;
                                } else {
                                    i69 = 1;
                                }
                                if (i84 >= 18) {
                                    i23 = iObjectFieldOffset;
                                } else {
                                    i23 = iObjectFieldOffset;
                                }
                                i39 = i21;
                            } else {
                                i69 = 1;
                            }
                            i21 = i18;
                            iObjectFieldOffset2 = 0;
                            i22 = 0;
                            if (i84 >= 18) {
                                i23 = iObjectFieldOffset;
                            } else {
                                i23 = iObjectFieldOffset;
                            }
                            i39 = i21;
                        }
                        i20 = i28;
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZza4);
                        if ((i85 & 1) == 1) {
                            if (i84 <= 17) {
                                i24 = i18 + 1;
                                iCharAt2 = strZzd.charAt(i18);
                                if (iCharAt2 >= 55296) {
                                    i26 = iCharAt2 & 8191;
                                    i27 = 13;
                                    while (true) {
                                        i21 = i24 + 1;
                                        cCharAt9 = strZzd.charAt(i24);
                                        if (cCharAt9 >= 55296) {
                                            break;
                                            break;
                                        }
                                        i26 |= (cCharAt9 & 8191) << i27;
                                        i27 += 13;
                                        i24 = i21;
                                    }
                                    iCharAt2 = i26 | (cCharAt9 << i27);
                                } else {
                                    i21 = i24;
                                }
                                i69 = 1;
                                i25 = (i83 << 1) + (iCharAt2 / 32);
                                obj = objArrZze[i25];
                                if (obj instanceof Field) {
                                    fieldZza = (Field) obj;
                                } else {
                                    fieldZza = zza(cls2, (String) obj);
                                    objArrZze[i25] = fieldZza;
                                }
                                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZza);
                                i22 = iCharAt2 % 32;
                            } else {
                                i69 = 1;
                            }
                            if (i84 >= 18) {
                                i23 = iObjectFieldOffset;
                            } else {
                                i23 = iObjectFieldOffset;
                            }
                            i39 = i21;
                        } else {
                            i69 = 1;
                        }
                        i21 = i18;
                        iObjectFieldOffset2 = 0;
                        i22 = 0;
                        if (i84 >= 18) {
                            i23 = iObjectFieldOffset;
                        } else {
                            i23 = iObjectFieldOffset;
                        }
                        i39 = i21;
                    }
                    i20 = i94;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZza4);
                    if ((i85 & 1) == 1) {
                        if (i84 <= 17) {
                            i24 = i18 + 1;
                            iCharAt2 = strZzd.charAt(i18);
                            if (iCharAt2 >= 55296) {
                                i26 = iCharAt2 & 8191;
                                i27 = 13;
                                while (true) {
                                    i21 = i24 + 1;
                                    cCharAt9 = strZzd.charAt(i24);
                                    if (cCharAt9 >= 55296) {
                                        break;
                                        break;
                                    }
                                    i26 |= (cCharAt9 & 8191) << i27;
                                    i27 += 13;
                                    i24 = i21;
                                }
                                iCharAt2 = i26 | (cCharAt9 << i27);
                            } else {
                                i21 = i24;
                            }
                            i69 = 1;
                            i25 = (i83 << 1) + (iCharAt2 / 32);
                            obj = objArrZze[i25];
                            if (obj instanceof Field) {
                                fieldZza = (Field) obj;
                            } else {
                                fieldZza = zza(cls2, (String) obj);
                                objArrZze[i25] = fieldZza;
                            }
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZza);
                            i22 = iCharAt2 % 32;
                        } else {
                            i69 = 1;
                        }
                        if (i84 >= 18) {
                            i23 = iObjectFieldOffset;
                        } else {
                            i23 = iObjectFieldOffset;
                        }
                        i39 = i21;
                    } else {
                        i69 = 1;
                    }
                    i21 = i18;
                    iObjectFieldOffset2 = 0;
                    i22 = 0;
                    if (i84 >= 18) {
                        i23 = iObjectFieldOffset;
                    } else {
                        i23 = iObjectFieldOffset;
                    }
                    i39 = i21;
                }
                int i98 = i74 + 1;
                iArr4[i74] = i19;
                int i99 = i74 + 2;
                int i100 = iObjectFieldOffset2;
                iArr4[i98] = ((iCharAt13 & 256) != 0 ? 268435456 : 0) | ((iCharAt13 & 512) != 0 ? C.BUFFER_FLAG_LAST_SAMPLE : 0) | (i84 << 20) | i23;
                i74 += 3;
                iArr4[i99] = (i22 << 20) | i100;
                i5 = i5;
                i35 = i83;
                iArr3 = iArr4;
                iCharAt3 = i85;
                length = i16;
                strZzd = strZzd;
                i3 = i20;
                objArr = objArr2;
            }
            return new zzgs<>(iArr3, objArr, iCharAt, i5, zzhbVar.zzc(), z, false, iArr, i7, i70, zzgwVar, zzfyVar, zzhvVar, zzesVar, zzghVar);
        }
        ((zzhs) zzgmVar).zza();
        int i101 = zzfd.zze.zzi;
        throw new NoSuchMethodError();
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String string = Arrays.toString(declaredFields);
            throw new RuntimeException(new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(string).length()).append("Field ").append(str).append(" for ").append(name).append(" not found. Known fields are ").append(string).toString());
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzhd
    public final T zza() {
        return (T) this.zzo.zza(this.zzg);
    }

    /* JADX WARN: Code duplicated, block: B:104:0x01c1  */
    @Override // com.google.android.gms.internal.measurement.zzhd
    public final boolean zza(T t, T t2) {
        int length = this.zzc.length;
        int i = 0;
        while (true) {
            boolean zZza = true;
            if (i < length) {
                int iZzd = zzd(i);
                long j = iZzd & 1048575;
                switch ((iZzd & 267386880) >>> 20) {
                    case 0:
                        if (!zzc(t, t2, i) || Double.doubleToLongBits(zzib.zze(t, j)) != Double.doubleToLongBits(zzib.zze(t2, j))) {
                            zZza = false;
                        }
                        break;
                    case 1:
                        if (!zzc(t, t2, i) || Float.floatToIntBits(zzib.zzd(t, j)) != Float.floatToIntBits(zzib.zzd(t2, j))) {
                            zZza = false;
                        }
                        break;
                    case 2:
                        if (!zzc(t, t2, i) || zzib.zzb(t, j) != zzib.zzb(t2, j)) {
                            zZza = false;
                        }
                        break;
                    case 3:
                        if (!zzc(t, t2, i) || zzib.zzb(t, j) != zzib.zzb(t2, j)) {
                            zZza = false;
                        }
                        break;
                    case 4:
                        if (!zzc(t, t2, i) || zzib.zza(t, j) != zzib.zza(t2, j)) {
                            zZza = false;
                        }
                        break;
                    case 5:
                        if (!zzc(t, t2, i) || zzib.zzb(t, j) != zzib.zzb(t2, j)) {
                            zZza = false;
                        }
                        break;
                    case 6:
                        if (!zzc(t, t2, i) || zzib.zza(t, j) != zzib.zza(t2, j)) {
                            zZza = false;
                        }
                        break;
                    case 7:
                        if (!zzc(t, t2, i) || zzib.zzc(t, j) != zzib.zzc(t2, j)) {
                            zZza = false;
                        }
                        break;
                    case 8:
                        if (!zzc(t, t2, i) || !zzhf.zza(zzib.zzf(t, j), zzib.zzf(t2, j))) {
                            zZza = false;
                        }
                        break;
                    case 9:
                        if (!zzc(t, t2, i) || !zzhf.zza(zzib.zzf(t, j), zzib.zzf(t2, j))) {
                            zZza = false;
                        }
                        break;
                    case 10:
                        if (!zzc(t, t2, i) || !zzhf.zza(zzib.zzf(t, j), zzib.zzf(t2, j))) {
                            zZza = false;
                        }
                        break;
                    case 11:
                        if (!zzc(t, t2, i) || zzib.zza(t, j) != zzib.zza(t2, j)) {
                            zZza = false;
                        }
                        break;
                    case 12:
                        if (!zzc(t, t2, i) || zzib.zza(t, j) != zzib.zza(t2, j)) {
                            zZza = false;
                        }
                        break;
                    case 13:
                        if (!zzc(t, t2, i) || zzib.zza(t, j) != zzib.zza(t2, j)) {
                            zZza = false;
                        }
                        break;
                    case 14:
                        if (!zzc(t, t2, i) || zzib.zzb(t, j) != zzib.zzb(t2, j)) {
                            zZza = false;
                        }
                        break;
                    case 15:
                        if (!zzc(t, t2, i) || zzib.zza(t, j) != zzib.zza(t2, j)) {
                            zZza = false;
                        }
                        break;
                    case 16:
                        if (!zzc(t, t2, i) || zzib.zzb(t, j) != zzib.zzb(t2, j)) {
                            zZza = false;
                        }
                        break;
                    case 17:
                        if (!zzc(t, t2, i) || !zzhf.zza(zzib.zzf(t, j), zzib.zzf(t2, j))) {
                            zZza = false;
                        }
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        zZza = zzhf.zza(zzib.zzf(t, j), zzib.zzf(t2, j));
                        break;
                    case 50:
                        zZza = zzhf.zza(zzib.zzf(t, j), zzib.zzf(t2, j));
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                        long jZze = zze(i) & 1048575;
                        if (zzib.zza(t, jZze) != zzib.zza(t2, jZze) || !zzhf.zza(zzib.zzf(t, j), zzib.zzf(t2, j))) {
                            zZza = false;
                        }
                        break;
                }
                if (!zZza) {
                    return false;
                }
                i += 3;
            } else {
                if (!this.zzq.zzb(t).equals(this.zzq.zzb(t2))) {
                    return false;
                }
                if (this.zzh) {
                    return this.zzr.zza(t).equals(this.zzr.zza(t2));
                }
                return true;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzhd
    public final int zza(T t) {
        int i;
        int iZza;
        int length = this.zzc.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iZzd = zzd(i3);
            int i4 = this.zzc[i3];
            long j = 1048575 & iZzd;
            int iHashCode = 37;
            switch ((iZzd & 267386880) >>> 20) {
                case 0:
                    i = i2 * 53;
                    iZza = zzff.zza(Double.doubleToLongBits(zzib.zze(t, j)));
                    i2 = i + iZza;
                    break;
                case 1:
                    i = i2 * 53;
                    iZza = Float.floatToIntBits(zzib.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 2:
                    i = i2 * 53;
                    iZza = zzff.zza(zzib.zzb(t, j));
                    i2 = i + iZza;
                    break;
                case 3:
                    i = i2 * 53;
                    iZza = zzff.zza(zzib.zzb(t, j));
                    i2 = i + iZza;
                    break;
                case 4:
                    i = i2 * 53;
                    iZza = zzib.zza(t, j);
                    i2 = i + iZza;
                    break;
                case 5:
                    i = i2 * 53;
                    iZza = zzff.zza(zzib.zzb(t, j));
                    i2 = i + iZza;
                    break;
                case 6:
                    i = i2 * 53;
                    iZza = zzib.zza(t, j);
                    i2 = i + iZza;
                    break;
                case 7:
                    i = i2 * 53;
                    iZza = zzff.zza(zzib.zzc(t, j));
                    i2 = i + iZza;
                    break;
                case 8:
                    i = i2 * 53;
                    iZza = ((String) zzib.zzf(t, j)).hashCode();
                    i2 = i + iZza;
                    break;
                case 9:
                    Object objZzf = zzib.zzf(t, j);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iZza = zzib.zzf(t, j).hashCode();
                    i2 = i + iZza;
                    break;
                case 11:
                    i = i2 * 53;
                    iZza = zzib.zza(t, j);
                    i2 = i + iZza;
                    break;
                case 12:
                    i = i2 * 53;
                    iZza = zzib.zza(t, j);
                    i2 = i + iZza;
                    break;
                case 13:
                    i = i2 * 53;
                    iZza = zzib.zza(t, j);
                    i2 = i + iZza;
                    break;
                case 14:
                    i = i2 * 53;
                    iZza = zzff.zza(zzib.zzb(t, j));
                    i2 = i + iZza;
                    break;
                case 15:
                    i = i2 * 53;
                    iZza = zzib.zza(t, j);
                    i2 = i + iZza;
                    break;
                case 16:
                    i = i2 * 53;
                    iZza = zzff.zza(zzib.zzb(t, j));
                    i2 = i + iZza;
                    break;
                case 17:
                    Object objZzf2 = zzib.zzf(t, j);
                    if (objZzf2 != null) {
                        iHashCode = objZzf2.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i2 * 53;
                    iZza = zzib.zzf(t, j).hashCode();
                    i2 = i + iZza;
                    break;
                case 50:
                    i = i2 * 53;
                    iZza = zzib.zzf(t, j).hashCode();
                    i2 = i + iZza;
                    break;
                case 51:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzff.zza(Double.doubleToLongBits(zzb(t, j)));
                        i2 = i + iZza;
                    }
                    break;
                case 52:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = Float.floatToIntBits(zzc(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case 53:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzff.zza(zze(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case 54:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzff.zza(zze(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case 55:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzd(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case 56:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzff.zza(zze(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case 57:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzd(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case 58:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzff.zza(zzf(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case 59:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = ((String) zzib.zzf(t, j)).hashCode();
                        i2 = i + iZza;
                    }
                    break;
                case 60:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzib.zzf(t, j).hashCode();
                        i2 = i + iZza;
                    }
                    break;
                case 61:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzib.zzf(t, j).hashCode();
                        i2 = i + iZza;
                    }
                    break;
                case 62:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzd(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case 63:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzd(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case 64:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzd(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case 65:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzff.zza(zze(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case 66:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzd(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case 67:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzff.zza(zze(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case 68:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzib.zzf(t, j).hashCode();
                        i2 = i + iZza;
                    }
                    break;
            }
        }
        int iHashCode2 = (i2 * 53) + this.zzq.zzb(t).hashCode();
        return this.zzh ? (iHashCode2 * 53) + this.zzr.zza(t).hashCode() : iHashCode2;
    }

    @Override // com.google.android.gms.internal.measurement.zzhd
    public final void zzb(T t, T t2) {
        t2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzd = zzd(i);
            long j = 1048575 & iZzd;
            int i2 = this.zzc[i];
            switch ((iZzd & 267386880) >>> 20) {
                case 0:
                    if (zza((Object) t2, i)) {
                        zzib.zza(t, j, zzib.zze(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 1:
                    if (zza((Object) t2, i)) {
                        zzib.zza((Object) t, j, zzib.zzd(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 2:
                    if (zza((Object) t2, i)) {
                        zzib.zza((Object) t, j, zzib.zzb(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 3:
                    if (zza((Object) t2, i)) {
                        zzib.zza((Object) t, j, zzib.zzb(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 4:
                    if (zza((Object) t2, i)) {
                        zzib.zza((Object) t, j, zzib.zza(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 5:
                    if (zza((Object) t2, i)) {
                        zzib.zza((Object) t, j, zzib.zzb(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 6:
                    if (zza((Object) t2, i)) {
                        zzib.zza((Object) t, j, zzib.zza(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 7:
                    if (zza((Object) t2, i)) {
                        zzib.zza(t, j, zzib.zzc(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 8:
                    if (zza((Object) t2, i)) {
                        zzib.zza(t, j, zzib.zzf(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 9:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (zza((Object) t2, i)) {
                        zzib.zza(t, j, zzib.zzf(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 11:
                    if (zza((Object) t2, i)) {
                        zzib.zza((Object) t, j, zzib.zza(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 12:
                    if (zza((Object) t2, i)) {
                        zzib.zza((Object) t, j, zzib.zza(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 13:
                    if (zza((Object) t2, i)) {
                        zzib.zza((Object) t, j, zzib.zza(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 14:
                    if (zza((Object) t2, i)) {
                        zzib.zza((Object) t, j, zzib.zzb(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 15:
                    if (zza((Object) t2, i)) {
                        zzib.zza((Object) t, j, zzib.zza(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 16:
                    if (zza((Object) t2, i)) {
                        zzib.zza((Object) t, j, zzib.zzb(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 17:
                    zza(t, t2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzp.zza(t, t2, j);
                    break;
                case 50:
                    zzhf.zza(this.zzs, t, t2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zza(t2, i2, i)) {
                        zzib.zza(t, j, zzib.zzf(t2, j));
                        zzb(t, i2, i);
                    }
                    break;
                case 60:
                    zzb(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zza(t2, i2, i)) {
                        zzib.zza(t, j, zzib.zzf(t2, j));
                        zzb(t, i2, i);
                    }
                    break;
                case 68:
                    zzb(t, t2, i);
                    break;
            }
        }
        zzhf.zza(this.zzq, t, t2);
        if (this.zzh) {
            zzhf.zza(this.zzr, t, t2);
        }
    }

    private final void zza(T t, T t2, int i) {
        long jZzd = zzd(i) & 1048575;
        if (zza((Object) t2, i)) {
            Object objZzf = zzib.zzf(t, jZzd);
            Object objZzf2 = zzib.zzf(t2, jZzd);
            if (objZzf != null && objZzf2 != null) {
                zzib.zza(t, jZzd, zzff.zza(objZzf, objZzf2));
                zzb((Object) t, i);
            } else if (objZzf2 != null) {
                zzib.zza(t, jZzd, objZzf2);
                zzb((Object) t, i);
            }
        }
    }

    private final void zzb(T t, T t2, int i) {
        int iZzd = zzd(i);
        int i2 = this.zzc[i];
        long j = iZzd & 1048575;
        if (zza(t2, i2, i)) {
            Object objZzf = zzib.zzf(t, j);
            Object objZzf2 = zzib.zzf(t2, j);
            if (objZzf != null && objZzf2 != null) {
                zzib.zza(t, j, zzff.zza(objZzf, objZzf2));
                zzb(t, i2, i);
            } else if (objZzf2 != null) {
                zzib.zza(t, j, objZzf2);
                zzb(t, i2, i);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:420:0x090b A[PHI: r6
      0x090b: PHI (r6v4 int) = 
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v12 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v13 int)
      (r6v1 int)
     binds: [B:255:0x0549, B:461:0x09b5, B:458:0x09ab, B:452:0x098f, B:449:0x097d, B:446:0x096e, B:443:0x0961, B:440:0x0954, B:436:0x0949, B:433:0x0940, B:430:0x0933, B:427:0x0926, B:424:0x0913, B:395:0x081e, B:389:0x0801, B:383:0x07e4, B:377:0x07c7, B:371:0x07a9, B:365:0x078b, B:359:0x076d, B:353:0x074f, B:347:0x0731, B:341:0x0713, B:335:0x06f5, B:329:0x06d7, B:323:0x06b9, B:317:0x069b, B:312:0x0667, B:309:0x065a, B:306:0x064a, B:303:0x063a, B:300:0x062a, B:297:0x061e, B:294:0x0611, B:291:0x0605, B:285:0x05e7, B:282:0x05d3, B:279:0x05c1, B:276:0x05b1, B:273:0x05a1, B:438:0x0950, B:270:0x0594, B:267:0x0588, B:264:0x0578, B:261:0x0568, B:419:0x090a, B:258:0x0552] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.measurement.zzhd
    public final int zzb(T t) {
        int i;
        int i2;
        int i3;
        boolean z;
        int iZzd;
        int iZzb;
        int iZzj;
        int i4;
        int iZzh;
        int iZzi;
        int iZze;
        int iZzg;
        int iZzb2;
        int iZzi2;
        int iZze2;
        int iZzg2;
        int i5 = 267386880;
        int i6 = 1048575;
        int i7 = 0;
        if (this.zzj) {
            Unsafe unsafe = zzb;
            int i8 = 0;
            int i9 = 0;
            while (i8 < this.zzc.length) {
                int iZzd2 = zzd(i8);
                int i10 = (iZzd2 & i5) >>> 20;
                int i11 = i5;
                int i12 = this.zzc[i8];
                long j = iZzd2 & 1048575;
                int i13 = (i10 < zzex.DOUBLE_LIST_PACKED.zza() || i10 > zzex.SINT64_LIST_PACKED.zza()) ? 0 : this.zzc[i8 + 2] & 1048575;
                switch (i10) {
                    case 0:
                        if (zza((Object) t, i8)) {
                            iZzb2 = zzen.zzb(i12, 0.0d);
                            i9 += iZzb2;
                        }
                        break;
                    case 1:
                        if (zza((Object) t, i8)) {
                            iZzb2 = zzen.zzb(i12, 0.0f);
                            i9 += iZzb2;
                        }
                        break;
                    case 2:
                        if (zza((Object) t, i8)) {
                            iZzb2 = zzen.zzd(i12, zzib.zzb(t, j));
                            i9 += iZzb2;
                        }
                        break;
                    case 3:
                        if (zza((Object) t, i8)) {
                            iZzb2 = zzen.zze(i12, zzib.zzb(t, j));
                            i9 += iZzb2;
                        }
                        break;
                    case 4:
                        if (zza((Object) t, i8)) {
                            iZzb2 = zzen.zzf(i12, zzib.zza(t, j));
                            i9 += iZzb2;
                        }
                        break;
                    case 5:
                        if (zza((Object) t, i8)) {
                            iZzb2 = zzen.zzg(i12, 0L);
                            i9 += iZzb2;
                        }
                        break;
                    case 6:
                        if (zza((Object) t, i8)) {
                            iZzb2 = zzen.zzi(i12, 0);
                            i9 += iZzb2;
                        }
                        break;
                    case 7:
                        if (zza((Object) t, i8)) {
                            iZzb2 = zzen.zzb(i12, true);
                            i9 += iZzb2;
                        }
                        break;
                    case 8:
                        if (zza((Object) t, i8)) {
                            Object objZzf = zzib.zzf(t, j);
                            if (objZzf instanceof zzdu) {
                                iZzb2 = zzen.zzc(i12, (zzdu) objZzf);
                            } else {
                                iZzb2 = zzen.zzb(i12, (String) objZzf);
                            }
                            i9 += iZzb2;
                        }
                        break;
                    case 9:
                        if (zza((Object) t, i8)) {
                            iZzb2 = zzhf.zza(i12, zzib.zzf(t, j), zza(i8));
                            i9 += iZzb2;
                        }
                        break;
                    case 10:
                        if (zza((Object) t, i8)) {
                            iZzb2 = zzen.zzc(i12, (zzdu) zzib.zzf(t, j));
                            i9 += iZzb2;
                        }
                        break;
                    case 11:
                        if (zza((Object) t, i8)) {
                            iZzb2 = zzen.zzg(i12, zzib.zza(t, j));
                            i9 += iZzb2;
                        }
                        break;
                    case 12:
                        if (zza((Object) t, i8)) {
                            iZzb2 = zzen.zzk(i12, zzib.zza(t, j));
                            i9 += iZzb2;
                        }
                        break;
                    case 13:
                        if (zza((Object) t, i8)) {
                            iZzb2 = zzen.zzj(i12, 0);
                            i9 += iZzb2;
                        }
                        break;
                    case 14:
                        if (zza((Object) t, i8)) {
                            iZzb2 = zzen.zzh(i12, 0L);
                            i9 += iZzb2;
                        }
                        break;
                    case 15:
                        if (zza((Object) t, i8)) {
                            iZzb2 = zzen.zzh(i12, zzib.zza(t, j));
                            i9 += iZzb2;
                        }
                        break;
                    case 16:
                        if (zza((Object) t, i8)) {
                            iZzb2 = zzen.zzf(i12, zzib.zzb(t, j));
                            i9 += iZzb2;
                        }
                        break;
                    case 17:
                        if (zza((Object) t, i8)) {
                            iZzb2 = zzen.zzc(i12, (zzgo) zzib.zzf(t, j), zza(i8));
                            i9 += iZzb2;
                        }
                        break;
                    case 18:
                        iZzb2 = zzhf.zzi(i12, zza(t, j), false);
                        i9 += iZzb2;
                        break;
                    case 19:
                        iZzb2 = zzhf.zzh(i12, zza(t, j), false);
                        i9 += iZzb2;
                        break;
                    case 20:
                        iZzb2 = zzhf.zza(i12, (List<Long>) zza(t, j), false);
                        i9 += iZzb2;
                        break;
                    case 21:
                        iZzb2 = zzhf.zzb(i12, (List<Long>) zza(t, j), false);
                        i9 += iZzb2;
                        break;
                    case 22:
                        iZzb2 = zzhf.zze(i12, zza(t, j), false);
                        i9 += iZzb2;
                        break;
                    case 23:
                        iZzb2 = zzhf.zzi(i12, zza(t, j), false);
                        i9 += iZzb2;
                        break;
                    case 24:
                        iZzb2 = zzhf.zzh(i12, zza(t, j), false);
                        i9 += iZzb2;
                        break;
                    case 25:
                        iZzb2 = zzhf.zzj(i12, zza(t, j), false);
                        i9 += iZzb2;
                        break;
                    case 26:
                        iZzb2 = zzhf.zza(i12, zza(t, j));
                        i9 += iZzb2;
                        break;
                    case 27:
                        iZzb2 = zzhf.zza(i12, zza(t, j), zza(i8));
                        i9 += iZzb2;
                        break;
                    case 28:
                        iZzb2 = zzhf.zzb(i12, zza(t, j));
                        i9 += iZzb2;
                        break;
                    case 29:
                        iZzb2 = zzhf.zzf(i12, zza(t, j), false);
                        i9 += iZzb2;
                        break;
                    case 30:
                        iZzb2 = zzhf.zzd(i12, zza(t, j), false);
                        i9 += iZzb2;
                        break;
                    case 31:
                        iZzb2 = zzhf.zzh(i12, zza(t, j), false);
                        i9 += iZzb2;
                        break;
                    case 32:
                        iZzb2 = zzhf.zzi(i12, zza(t, j), false);
                        i9 += iZzb2;
                        break;
                    case 33:
                        iZzb2 = zzhf.zzg(i12, zza(t, j), false);
                        i9 += iZzb2;
                        break;
                    case 34:
                        iZzb2 = zzhf.zzc(i12, zza(t, j), false);
                        i9 += iZzb2;
                        break;
                    case 35:
                        iZzi2 = zzhf.zzi((List) unsafe.getObject(t, j));
                        if (iZzi2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i13, iZzi2);
                            }
                            iZze2 = zzen.zze(i12);
                            iZzg2 = zzen.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i9 += iZzb2;
                        }
                        break;
                    case 36:
                        iZzi2 = zzhf.zzh((List) unsafe.getObject(t, j));
                        if (iZzi2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i13, iZzi2);
                            }
                            iZze2 = zzen.zze(i12);
                            iZzg2 = zzen.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i9 += iZzb2;
                        }
                        break;
                    case 37:
                        iZzi2 = zzhf.zza((List<Long>) unsafe.getObject(t, j));
                        if (iZzi2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i13, iZzi2);
                            }
                            iZze2 = zzen.zze(i12);
                            iZzg2 = zzen.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i9 += iZzb2;
                        }
                        break;
                    case 38:
                        iZzi2 = zzhf.zzb((List) unsafe.getObject(t, j));
                        if (iZzi2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i13, iZzi2);
                            }
                            iZze2 = zzen.zze(i12);
                            iZzg2 = zzen.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i9 += iZzb2;
                        }
                        break;
                    case 39:
                        iZzi2 = zzhf.zze((List) unsafe.getObject(t, j));
                        if (iZzi2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i13, iZzi2);
                            }
                            iZze2 = zzen.zze(i12);
                            iZzg2 = zzen.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i9 += iZzb2;
                        }
                        break;
                    case 40:
                        iZzi2 = zzhf.zzi((List) unsafe.getObject(t, j));
                        if (iZzi2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i13, iZzi2);
                            }
                            iZze2 = zzen.zze(i12);
                            iZzg2 = zzen.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i9 += iZzb2;
                        }
                        break;
                    case 41:
                        iZzi2 = zzhf.zzh((List) unsafe.getObject(t, j));
                        if (iZzi2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i13, iZzi2);
                            }
                            iZze2 = zzen.zze(i12);
                            iZzg2 = zzen.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i9 += iZzb2;
                        }
                        break;
                    case 42:
                        iZzi2 = zzhf.zzj((List) unsafe.getObject(t, j));
                        if (iZzi2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i13, iZzi2);
                            }
                            iZze2 = zzen.zze(i12);
                            iZzg2 = zzen.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i9 += iZzb2;
                        }
                        break;
                    case 43:
                        iZzi2 = zzhf.zzf((List) unsafe.getObject(t, j));
                        if (iZzi2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i13, iZzi2);
                            }
                            iZze2 = zzen.zze(i12);
                            iZzg2 = zzen.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i9 += iZzb2;
                        }
                        break;
                    case 44:
                        iZzi2 = zzhf.zzd((List) unsafe.getObject(t, j));
                        if (iZzi2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i13, iZzi2);
                            }
                            iZze2 = zzen.zze(i12);
                            iZzg2 = zzen.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i9 += iZzb2;
                        }
                        break;
                    case 45:
                        iZzi2 = zzhf.zzh((List) unsafe.getObject(t, j));
                        if (iZzi2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i13, iZzi2);
                            }
                            iZze2 = zzen.zze(i12);
                            iZzg2 = zzen.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i9 += iZzb2;
                        }
                        break;
                    case 46:
                        iZzi2 = zzhf.zzi((List) unsafe.getObject(t, j));
                        if (iZzi2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i13, iZzi2);
                            }
                            iZze2 = zzen.zze(i12);
                            iZzg2 = zzen.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i9 += iZzb2;
                        }
                        break;
                    case 47:
                        iZzi2 = zzhf.zzg((List) unsafe.getObject(t, j));
                        if (iZzi2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i13, iZzi2);
                            }
                            iZze2 = zzen.zze(i12);
                            iZzg2 = zzen.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i9 += iZzb2;
                        }
                        break;
                    case 48:
                        iZzi2 = zzhf.zzc((List) unsafe.getObject(t, j));
                        if (iZzi2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i13, iZzi2);
                            }
                            iZze2 = zzen.zze(i12);
                            iZzg2 = zzen.zzg(iZzi2);
                            iZzb2 = iZze2 + iZzg2 + iZzi2;
                            i9 += iZzb2;
                        }
                        break;
                    case 49:
                        iZzb2 = zzhf.zzb(i12, (List<zzgo>) zza(t, j), zza(i8));
                        i9 += iZzb2;
                        break;
                    case 50:
                        iZzb2 = this.zzs.zza(i12, zzib.zzf(t, j), zzb(i8));
                        i9 += iZzb2;
                        break;
                    case 51:
                        if (zza(t, i12, i8)) {
                            iZzb2 = zzen.zzb(i12, 0.0d);
                            i9 += iZzb2;
                        }
                        break;
                    case 52:
                        if (zza(t, i12, i8)) {
                            iZzb2 = zzen.zzb(i12, 0.0f);
                            i9 += iZzb2;
                        }
                        break;
                    case 53:
                        if (zza(t, i12, i8)) {
                            iZzb2 = zzen.zzd(i12, zze(t, j));
                            i9 += iZzb2;
                        }
                        break;
                    case 54:
                        if (zza(t, i12, i8)) {
                            iZzb2 = zzen.zze(i12, zze(t, j));
                            i9 += iZzb2;
                        }
                        break;
                    case 55:
                        if (zza(t, i12, i8)) {
                            iZzb2 = zzen.zzf(i12, zzd(t, j));
                            i9 += iZzb2;
                        }
                        break;
                    case 56:
                        if (zza(t, i12, i8)) {
                            iZzb2 = zzen.zzg(i12, 0L);
                            i9 += iZzb2;
                        }
                        break;
                    case 57:
                        if (zza(t, i12, i8)) {
                            iZzb2 = zzen.zzi(i12, 0);
                            i9 += iZzb2;
                        }
                        break;
                    case 58:
                        if (zza(t, i12, i8)) {
                            iZzb2 = zzen.zzb(i12, true);
                            i9 += iZzb2;
                        }
                        break;
                    case 59:
                        if (zza(t, i12, i8)) {
                            Object objZzf2 = zzib.zzf(t, j);
                            if (objZzf2 instanceof zzdu) {
                                iZzb2 = zzen.zzc(i12, (zzdu) objZzf2);
                            } else {
                                iZzb2 = zzen.zzb(i12, (String) objZzf2);
                            }
                            i9 += iZzb2;
                        }
                        break;
                    case 60:
                        if (zza(t, i12, i8)) {
                            iZzb2 = zzhf.zza(i12, zzib.zzf(t, j), zza(i8));
                            i9 += iZzb2;
                        }
                        break;
                    case 61:
                        if (zza(t, i12, i8)) {
                            iZzb2 = zzen.zzc(i12, (zzdu) zzib.zzf(t, j));
                            i9 += iZzb2;
                        }
                        break;
                    case 62:
                        if (zza(t, i12, i8)) {
                            iZzb2 = zzen.zzg(i12, zzd(t, j));
                            i9 += iZzb2;
                        }
                        break;
                    case 63:
                        if (zza(t, i12, i8)) {
                            iZzb2 = zzen.zzk(i12, zzd(t, j));
                            i9 += iZzb2;
                        }
                        break;
                    case 64:
                        if (zza(t, i12, i8)) {
                            iZzb2 = zzen.zzj(i12, 0);
                            i9 += iZzb2;
                        }
                        break;
                    case 65:
                        if (zza(t, i12, i8)) {
                            iZzb2 = zzen.zzh(i12, 0L);
                            i9 += iZzb2;
                        }
                        break;
                    case 66:
                        if (zza(t, i12, i8)) {
                            iZzb2 = zzen.zzh(i12, zzd(t, j));
                            i9 += iZzb2;
                        }
                        break;
                    case 67:
                        if (zza(t, i12, i8)) {
                            iZzb2 = zzen.zzf(i12, zze(t, j));
                            i9 += iZzb2;
                        }
                        break;
                    case 68:
                        if (zza(t, i12, i8)) {
                            iZzb2 = zzen.zzc(i12, (zzgo) zzib.zzf(t, j), zza(i8));
                            i9 += iZzb2;
                        }
                        break;
                }
                i8 += 3;
                i5 = i11;
            }
            return i9 + zza((zzhv) this.zzq, (Object) t);
        }
        Unsafe unsafe2 = zzb;
        int i14 = -1;
        int i15 = 0;
        int iZzb3 = 0;
        int i16 = 0;
        while (i15 < this.zzc.length) {
            int iZzd3 = zzd(i15);
            int[] iArr = this.zzc;
            int i17 = iArr[i15];
            int i18 = i6;
            int i19 = (iZzd3 & 267386880) >>> 20;
            if (i19 <= 17) {
                i = iArr[i15 + 2];
                int i20 = i & i18;
                i2 = 1 << (i >>> 20);
                if (i20 != i14) {
                    i16 = unsafe2.getInt(t, i20);
                    i14 = i20;
                }
            } else {
                i = (!this.zzk || i19 < zzex.DOUBLE_LIST_PACKED.zza() || i19 > zzex.SINT64_LIST_PACKED.zza()) ? 0 : this.zzc[i15 + 2] & i18;
                i2 = 0;
            }
            long j2 = iZzd3 & i18;
            switch (i19) {
                case 0:
                    i3 = 0;
                    z = false;
                    if ((i16 & i2) != 0) {
                        iZzb3 += zzen.zzb(i17, 0.0d);
                    }
                    break;
                case 1:
                    i3 = 0;
                    if ((i16 & i2) != 0) {
                        z = false;
                        iZzb3 += zzen.zzb(i17, 0.0f);
                    } else {
                        z = false;
                    }
                    break;
                case 2:
                    i3 = 0;
                    if ((i16 & i2) != 0) {
                        iZzd = zzen.zzd(i17, unsafe2.getLong(t, j2));
                        iZzb3 += iZzd;
                    }
                    z = false;
                    break;
                case 3:
                    i3 = 0;
                    if ((i16 & i2) != 0) {
                        iZzd = zzen.zze(i17, unsafe2.getLong(t, j2));
                        iZzb3 += iZzd;
                    }
                    z = false;
                    break;
                case 4:
                    i3 = 0;
                    if ((i16 & i2) != 0) {
                        iZzd = zzen.zzf(i17, unsafe2.getInt(t, j2));
                        iZzb3 += iZzd;
                    }
                    z = false;
                    break;
                case 5:
                    i3 = 0;
                    if ((i16 & i2) != 0) {
                        iZzd = zzen.zzg(i17, 0L);
                        iZzb3 += iZzd;
                    }
                    z = false;
                    break;
                case 6:
                    if ((i16 & i2) != 0) {
                        i3 = 0;
                        iZzd = zzen.zzi(i17, 0);
                        iZzb3 += iZzd;
                    } else {
                        i3 = 0;
                    }
                    z = false;
                    break;
                case 7:
                    if ((i16 & i2) != 0) {
                        iZzb = zzen.zzb(i17, true);
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 8:
                    if ((i16 & i2) != 0) {
                        Object object = unsafe2.getObject(t, j2);
                        if (object instanceof zzdu) {
                            iZzb = zzen.zzc(i17, (zzdu) object);
                        } else {
                            iZzb = zzen.zzb(i17, (String) object);
                        }
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 9:
                    if ((i16 & i2) != 0) {
                        iZzb = zzhf.zza(i17, unsafe2.getObject(t, j2), zza(i15));
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 10:
                    if ((i16 & i2) != 0) {
                        iZzb = zzen.zzc(i17, (zzdu) unsafe2.getObject(t, j2));
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 11:
                    if ((i16 & i2) != 0) {
                        iZzb = zzen.zzg(i17, unsafe2.getInt(t, j2));
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 12:
                    if ((i16 & i2) != 0) {
                        iZzb = zzen.zzk(i17, unsafe2.getInt(t, j2));
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 13:
                    if ((i16 & i2) != 0) {
                        iZzj = zzen.zzj(i17, 0);
                        iZzb3 += iZzj;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 14:
                    if ((i16 & i2) != 0) {
                        iZzb = zzen.zzh(i17, 0L);
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 15:
                    if ((i16 & i2) != 0) {
                        iZzb = zzen.zzh(i17, unsafe2.getInt(t, j2));
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 16:
                    if ((i16 & i2) != 0) {
                        iZzb = zzen.zzf(i17, unsafe2.getLong(t, j2));
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 17:
                    if ((i16 & i2) != 0) {
                        iZzb = zzen.zzc(i17, (zzgo) unsafe2.getObject(t, j2), zza(i15));
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 18:
                    iZzb = zzhf.zzi(i17, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    i3 = 0;
                    z = false;
                    break;
                case 19:
                    i4 = 0;
                    iZzh = zzhf.zzh(i17, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzh;
                    i3 = i4;
                    z = false;
                    break;
                case 20:
                    i4 = 0;
                    iZzh = zzhf.zza(i17, (List<Long>) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzh;
                    i3 = i4;
                    z = false;
                    break;
                case 21:
                    i4 = 0;
                    iZzh = zzhf.zzb(i17, (List<Long>) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzh;
                    i3 = i4;
                    z = false;
                    break;
                case 22:
                    i4 = 0;
                    iZzh = zzhf.zze(i17, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzh;
                    i3 = i4;
                    z = false;
                    break;
                case 23:
                    i4 = 0;
                    iZzh = zzhf.zzi(i17, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzh;
                    i3 = i4;
                    z = false;
                    break;
                case 24:
                    i4 = 0;
                    iZzh = zzhf.zzh(i17, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzh;
                    i3 = i4;
                    z = false;
                    break;
                case 25:
                    i4 = 0;
                    iZzh = zzhf.zzj(i17, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzh;
                    i3 = i4;
                    z = false;
                    break;
                case 26:
                    iZzb = zzhf.zza(i17, (List<?>) unsafe2.getObject(t, j2));
                    iZzb3 += iZzb;
                    i3 = 0;
                    z = false;
                    break;
                case 27:
                    iZzb = zzhf.zza(i17, (List<?>) unsafe2.getObject(t, j2), zza(i15));
                    iZzb3 += iZzb;
                    i3 = 0;
                    z = false;
                    break;
                case 28:
                    iZzb = zzhf.zzb(i17, (List) unsafe2.getObject(t, j2));
                    iZzb3 += iZzb;
                    i3 = 0;
                    z = false;
                    break;
                case 29:
                    iZzb = zzhf.zzf(i17, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzb;
                    i3 = 0;
                    z = false;
                    break;
                case 30:
                    i4 = 0;
                    iZzh = zzhf.zzd(i17, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzh;
                    i3 = i4;
                    z = false;
                    break;
                case 31:
                    i4 = 0;
                    iZzh = zzhf.zzh(i17, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzh;
                    i3 = i4;
                    z = false;
                    break;
                case 32:
                    i4 = 0;
                    iZzh = zzhf.zzi(i17, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzh;
                    i3 = i4;
                    z = false;
                    break;
                case 33:
                    i4 = 0;
                    iZzh = zzhf.zzg(i17, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzh;
                    i3 = i4;
                    z = false;
                    break;
                case 34:
                    i4 = 0;
                    iZzh = zzhf.zzc(i17, (List) unsafe2.getObject(t, j2), false);
                    iZzb3 += iZzh;
                    i3 = i4;
                    z = false;
                    break;
                case 35:
                    iZzi = zzhf.zzi((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzen.zze(i17);
                        iZzg = zzen.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 36:
                    iZzi = zzhf.zzh((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzen.zze(i17);
                        iZzg = zzen.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 37:
                    iZzi = zzhf.zza((List<Long>) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzen.zze(i17);
                        iZzg = zzen.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 38:
                    iZzi = zzhf.zzb((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzen.zze(i17);
                        iZzg = zzen.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 39:
                    iZzi = zzhf.zze((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzen.zze(i17);
                        iZzg = zzen.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 40:
                    iZzi = zzhf.zzi((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzen.zze(i17);
                        iZzg = zzen.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 41:
                    iZzi = zzhf.zzh((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzen.zze(i17);
                        iZzg = zzen.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 42:
                    iZzi = zzhf.zzj((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzen.zze(i17);
                        iZzg = zzen.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 43:
                    iZzi = zzhf.zzf((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzen.zze(i17);
                        iZzg = zzen.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 44:
                    iZzi = zzhf.zzd((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzen.zze(i17);
                        iZzg = zzen.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 45:
                    iZzi = zzhf.zzh((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzen.zze(i17);
                        iZzg = zzen.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 46:
                    iZzi = zzhf.zzi((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzen.zze(i17);
                        iZzg = zzen.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 47:
                    iZzi = zzhf.zzg((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzen.zze(i17);
                        iZzg = zzen.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 48:
                    iZzi = zzhf.zzc((List) unsafe2.getObject(t, j2));
                    if (iZzi > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i, iZzi);
                        }
                        iZze = zzen.zze(i17);
                        iZzg = zzen.zzg(iZzi);
                        iZzb = iZze + iZzg + iZzi;
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 49:
                    iZzb = zzhf.zzb(i17, (List<zzgo>) unsafe2.getObject(t, j2), zza(i15));
                    iZzb3 += iZzb;
                    i3 = 0;
                    z = false;
                    break;
                case 50:
                    iZzb = this.zzs.zza(i17, unsafe2.getObject(t, j2), zzb(i15));
                    iZzb3 += iZzb;
                    i3 = 0;
                    z = false;
                    break;
                case 51:
                    if (zza(t, i17, i15)) {
                        iZzb = zzen.zzb(i17, 0.0d);
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 52:
                    if (zza(t, i17, i15)) {
                        iZzj = zzen.zzb(i17, 0.0f);
                        iZzb3 += iZzj;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 53:
                    if (zza(t, i17, i15)) {
                        iZzb = zzen.zzd(i17, zze(t, j2));
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 54:
                    if (zza(t, i17, i15)) {
                        iZzb = zzen.zze(i17, zze(t, j2));
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 55:
                    if (zza(t, i17, i15)) {
                        iZzb = zzen.zzf(i17, zzd(t, j2));
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 56:
                    if (zza(t, i17, i15)) {
                        iZzb = zzen.zzg(i17, 0L);
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 57:
                    if (zza(t, i17, i15)) {
                        iZzj = zzen.zzi(i17, 0);
                        iZzb3 += iZzj;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 58:
                    if (zza(t, i17, i15)) {
                        iZzb = zzen.zzb(i17, true);
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 59:
                    if (zza(t, i17, i15)) {
                        Object object2 = unsafe2.getObject(t, j2);
                        if (object2 instanceof zzdu) {
                            iZzb = zzen.zzc(i17, (zzdu) object2);
                        } else {
                            iZzb = zzen.zzb(i17, (String) object2);
                        }
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 60:
                    if (zza(t, i17, i15)) {
                        iZzb = zzhf.zza(i17, unsafe2.getObject(t, j2), zza(i15));
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 61:
                    if (zza(t, i17, i15)) {
                        iZzb = zzen.zzc(i17, (zzdu) unsafe2.getObject(t, j2));
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 62:
                    if (zza(t, i17, i15)) {
                        iZzb = zzen.zzg(i17, zzd(t, j2));
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 63:
                    if (zza(t, i17, i15)) {
                        iZzb = zzen.zzk(i17, zzd(t, j2));
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 64:
                    if (zza(t, i17, i15)) {
                        iZzj = zzen.zzj(i17, 0);
                        iZzb3 += iZzj;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 65:
                    if (zza(t, i17, i15)) {
                        iZzb = zzen.zzh(i17, 0L);
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 66:
                    if (zza(t, i17, i15)) {
                        iZzb = zzen.zzh(i17, zzd(t, j2));
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 67:
                    if (zza(t, i17, i15)) {
                        iZzb = zzen.zzf(i17, zze(t, j2));
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                case 68:
                    if (zza(t, i17, i15)) {
                        iZzb = zzen.zzc(i17, (zzgo) unsafe2.getObject(t, j2), zza(i15));
                        iZzb3 += iZzb;
                    }
                    i3 = 0;
                    z = false;
                    break;
                default:
                    i3 = 0;
                    z = false;
                    break;
            }
            i15 += 3;
            i7 = i3;
            i6 = i18;
        }
        int iZza = i7;
        int iZza2 = iZzb3 + zza((zzhv) this.zzq, (Object) t);
        if (!this.zzh) {
            return iZza2;
        }
        zzew<T> zzewVarZza = this.zzr.zza(t);
        for (int i21 = iZza; i21 < zzewVarZza.zza.zzc(); i21++) {
            Map.Entry entryZzb = zzewVarZza.zza.zzb(i21);
            iZza += zzew.zza((zzey<?>) entryZzb.getKey(), entryZzb.getValue());
        }
        for (Map.Entry entry : zzewVarZza.zza.zzd()) {
            iZza += zzew.zza((zzey<?>) entry.getKey(), entry.getValue());
        }
        return iZza2 + iZza;
    }

    private static <UT, UB> int zza(zzhv<UT, UB> zzhvVar, T t) {
        return zzhvVar.zzf(zzhvVar.zzb(t));
    }

    private static List<?> zza(Object obj, long j) {
        return (List) zzib.zzf(obj, j);
    }

    /* JADX WARN: Code duplicated, block: B:178:0x054a  */
    /* JADX WARN: Code duplicated, block: B:9:0x0032  */
    @Override // com.google.android.gms.internal.measurement.zzhd
    public final void zza(T t, zzis zzisVar) throws IOException {
        Iterator itZzd;
        Map.Entry<?, ?> entry;
        Iterator itZze;
        Map.Entry<?, ?> entry2;
        if (zzisVar.zza() == zzfd.zze.zzk) {
            zza(this.zzq, t, zzisVar);
            if (this.zzh) {
                zzew<T> zzewVarZza = this.zzr.zza(t);
                if (zzewVarZza.zza.isEmpty()) {
                    itZze = null;
                    entry2 = null;
                } else {
                    itZze = zzewVarZza.zze();
                    entry2 = (Map.Entry) itZze.next();
                }
            } else {
                itZze = null;
                entry2 = null;
            }
            for (int length = this.zzc.length - 3; length >= 0; length -= 3) {
                int iZzd = zzd(length);
                int i = this.zzc[length];
                while (entry2 != null && this.zzr.zza(entry2) > i) {
                    this.zzr.zza(zzisVar, entry2);
                    entry2 = itZze.hasNext() ? (Map.Entry) itZze.next() : null;
                }
                switch ((iZzd & 267386880) >>> 20) {
                    case 0:
                        if (zza((Object) t, length)) {
                            zzisVar.zza(i, zzib.zze(t, iZzd & 1048575));
                        }
                        break;
                    case 1:
                        if (zza((Object) t, length)) {
                            zzisVar.zza(i, zzib.zzd(t, iZzd & 1048575));
                        }
                        break;
                    case 2:
                        if (zza((Object) t, length)) {
                            zzisVar.zza(i, zzib.zzb(t, iZzd & 1048575));
                        }
                        break;
                    case 3:
                        if (zza((Object) t, length)) {
                            zzisVar.zzc(i, zzib.zzb(t, iZzd & 1048575));
                        }
                        break;
                    case 4:
                        if (zza((Object) t, length)) {
                            zzisVar.zzc(i, zzib.zza(t, iZzd & 1048575));
                        }
                        break;
                    case 5:
                        if (zza((Object) t, length)) {
                            zzisVar.zzd(i, zzib.zzb(t, iZzd & 1048575));
                        }
                        break;
                    case 6:
                        if (zza((Object) t, length)) {
                            zzisVar.zzd(i, zzib.zza(t, iZzd & 1048575));
                        }
                        break;
                    case 7:
                        if (zza((Object) t, length)) {
                            zzisVar.zza(i, zzib.zzc(t, iZzd & 1048575));
                        }
                        break;
                    case 8:
                        if (zza((Object) t, length)) {
                            zza(i, zzib.zzf(t, iZzd & 1048575), zzisVar);
                        }
                        break;
                    case 9:
                        if (zza((Object) t, length)) {
                            zzisVar.zza(i, zzib.zzf(t, iZzd & 1048575), zza(length));
                        }
                        break;
                    case 10:
                        if (zza((Object) t, length)) {
                            zzisVar.zza(i, (zzdu) zzib.zzf(t, iZzd & 1048575));
                        }
                        break;
                    case 11:
                        if (zza((Object) t, length)) {
                            zzisVar.zze(i, zzib.zza(t, iZzd & 1048575));
                        }
                        break;
                    case 12:
                        if (zza((Object) t, length)) {
                            zzisVar.zzb(i, zzib.zza(t, iZzd & 1048575));
                        }
                        break;
                    case 13:
                        if (zza((Object) t, length)) {
                            zzisVar.zza(i, zzib.zza(t, iZzd & 1048575));
                        }
                        break;
                    case 14:
                        if (zza((Object) t, length)) {
                            zzisVar.zzb(i, zzib.zzb(t, iZzd & 1048575));
                        }
                        break;
                    case 15:
                        if (zza((Object) t, length)) {
                            zzisVar.zzf(i, zzib.zza(t, iZzd & 1048575));
                        }
                        break;
                    case 16:
                        if (zza((Object) t, length)) {
                            zzisVar.zze(i, zzib.zzb(t, iZzd & 1048575));
                        }
                        break;
                    case 17:
                        if (zza((Object) t, length)) {
                            zzisVar.zzb(i, zzib.zzf(t, iZzd & 1048575), zza(length));
                        }
                        break;
                    case 18:
                        zzhf.zza(this.zzc[length], (List<Double>) zzib.zzf(t, iZzd & 1048575), zzisVar, false);
                        break;
                    case 19:
                        zzhf.zzb(this.zzc[length], (List<Float>) zzib.zzf(t, iZzd & 1048575), zzisVar, false);
                        break;
                    case 20:
                        zzhf.zzc(this.zzc[length], (List) zzib.zzf(t, iZzd & 1048575), zzisVar, false);
                        break;
                    case 21:
                        zzhf.zzd(this.zzc[length], (List) zzib.zzf(t, iZzd & 1048575), zzisVar, false);
                        break;
                    case 22:
                        zzhf.zzh(this.zzc[length], (List) zzib.zzf(t, iZzd & 1048575), zzisVar, false);
                        break;
                    case 23:
                        zzhf.zzf(this.zzc[length], (List) zzib.zzf(t, iZzd & 1048575), zzisVar, false);
                        break;
                    case 24:
                        zzhf.zzk(this.zzc[length], (List) zzib.zzf(t, iZzd & 1048575), zzisVar, false);
                        break;
                    case 25:
                        zzhf.zzn(this.zzc[length], (List) zzib.zzf(t, iZzd & 1048575), zzisVar, false);
                        break;
                    case 26:
                        zzhf.zza(this.zzc[length], (List<String>) zzib.zzf(t, iZzd & 1048575), zzisVar);
                        break;
                    case 27:
                        zzhf.zza(this.zzc[length], (List<?>) zzib.zzf(t, iZzd & 1048575), zzisVar, zza(length));
                        break;
                    case 28:
                        zzhf.zzb(this.zzc[length], (List<zzdu>) zzib.zzf(t, iZzd & 1048575), zzisVar);
                        break;
                    case 29:
                        zzhf.zzi(this.zzc[length], (List) zzib.zzf(t, iZzd & 1048575), zzisVar, false);
                        break;
                    case 30:
                        zzhf.zzm(this.zzc[length], (List) zzib.zzf(t, iZzd & 1048575), zzisVar, false);
                        break;
                    case 31:
                        zzhf.zzl(this.zzc[length], (List) zzib.zzf(t, iZzd & 1048575), zzisVar, false);
                        break;
                    case 32:
                        zzhf.zzg(this.zzc[length], (List) zzib.zzf(t, iZzd & 1048575), zzisVar, false);
                        break;
                    case 33:
                        zzhf.zzj(this.zzc[length], (List) zzib.zzf(t, iZzd & 1048575), zzisVar, false);
                        break;
                    case 34:
                        zzhf.zze(this.zzc[length], (List) zzib.zzf(t, iZzd & 1048575), zzisVar, false);
                        break;
                    case 35:
                        zzhf.zza(this.zzc[length], (List<Double>) zzib.zzf(t, iZzd & 1048575), zzisVar, true);
                        break;
                    case 36:
                        zzhf.zzb(this.zzc[length], (List<Float>) zzib.zzf(t, iZzd & 1048575), zzisVar, true);
                        break;
                    case 37:
                        zzhf.zzc(this.zzc[length], (List) zzib.zzf(t, iZzd & 1048575), zzisVar, true);
                        break;
                    case 38:
                        zzhf.zzd(this.zzc[length], (List) zzib.zzf(t, iZzd & 1048575), zzisVar, true);
                        break;
                    case 39:
                        zzhf.zzh(this.zzc[length], (List) zzib.zzf(t, iZzd & 1048575), zzisVar, true);
                        break;
                    case 40:
                        zzhf.zzf(this.zzc[length], (List) zzib.zzf(t, iZzd & 1048575), zzisVar, true);
                        break;
                    case 41:
                        zzhf.zzk(this.zzc[length], (List) zzib.zzf(t, iZzd & 1048575), zzisVar, true);
                        break;
                    case 42:
                        zzhf.zzn(this.zzc[length], (List) zzib.zzf(t, iZzd & 1048575), zzisVar, true);
                        break;
                    case 43:
                        zzhf.zzi(this.zzc[length], (List) zzib.zzf(t, iZzd & 1048575), zzisVar, true);
                        break;
                    case 44:
                        zzhf.zzm(this.zzc[length], (List) zzib.zzf(t, iZzd & 1048575), zzisVar, true);
                        break;
                    case 45:
                        zzhf.zzl(this.zzc[length], (List) zzib.zzf(t, iZzd & 1048575), zzisVar, true);
                        break;
                    case 46:
                        zzhf.zzg(this.zzc[length], (List) zzib.zzf(t, iZzd & 1048575), zzisVar, true);
                        break;
                    case 47:
                        zzhf.zzj(this.zzc[length], (List) zzib.zzf(t, iZzd & 1048575), zzisVar, true);
                        break;
                    case 48:
                        zzhf.zze(this.zzc[length], (List) zzib.zzf(t, iZzd & 1048575), zzisVar, true);
                        break;
                    case 49:
                        zzhf.zzb(this.zzc[length], (List<?>) zzib.zzf(t, iZzd & 1048575), zzisVar, zza(length));
                        break;
                    case 50:
                        zza(zzisVar, i, zzib.zzf(t, iZzd & 1048575), length);
                        break;
                    case 51:
                        if (zza(t, i, length)) {
                            zzisVar.zza(i, zzb(t, iZzd & 1048575));
                        }
                        break;
                    case 52:
                        if (zza(t, i, length)) {
                            zzisVar.zza(i, zzc(t, iZzd & 1048575));
                        }
                        break;
                    case 53:
                        if (zza(t, i, length)) {
                            zzisVar.zza(i, zze(t, iZzd & 1048575));
                        }
                        break;
                    case 54:
                        if (zza(t, i, length)) {
                            zzisVar.zzc(i, zze(t, iZzd & 1048575));
                        }
                        break;
                    case 55:
                        if (zza(t, i, length)) {
                            zzisVar.zzc(i, zzd(t, iZzd & 1048575));
                        }
                        break;
                    case 56:
                        if (zza(t, i, length)) {
                            zzisVar.zzd(i, zze(t, iZzd & 1048575));
                        }
                        break;
                    case 57:
                        if (zza(t, i, length)) {
                            zzisVar.zzd(i, zzd(t, iZzd & 1048575));
                        }
                        break;
                    case 58:
                        if (zza(t, i, length)) {
                            zzisVar.zza(i, zzf(t, iZzd & 1048575));
                        }
                        break;
                    case 59:
                        if (zza(t, i, length)) {
                            zza(i, zzib.zzf(t, iZzd & 1048575), zzisVar);
                        }
                        break;
                    case 60:
                        if (zza(t, i, length)) {
                            zzisVar.zza(i, zzib.zzf(t, iZzd & 1048575), zza(length));
                        }
                        break;
                    case 61:
                        if (zza(t, i, length)) {
                            zzisVar.zza(i, (zzdu) zzib.zzf(t, iZzd & 1048575));
                        }
                        break;
                    case 62:
                        if (zza(t, i, length)) {
                            zzisVar.zze(i, zzd(t, iZzd & 1048575));
                        }
                        break;
                    case 63:
                        if (zza(t, i, length)) {
                            zzisVar.zzb(i, zzd(t, iZzd & 1048575));
                        }
                        break;
                    case 64:
                        if (zza(t, i, length)) {
                            zzisVar.zza(i, zzd(t, iZzd & 1048575));
                        }
                        break;
                    case 65:
                        if (zza(t, i, length)) {
                            zzisVar.zzb(i, zze(t, iZzd & 1048575));
                        }
                        break;
                    case 66:
                        if (zza(t, i, length)) {
                            zzisVar.zzf(i, zzd(t, iZzd & 1048575));
                        }
                        break;
                    case 67:
                        if (zza(t, i, length)) {
                            zzisVar.zze(i, zze(t, iZzd & 1048575));
                        }
                        break;
                    case 68:
                        if (zza(t, i, length)) {
                            zzisVar.zzb(i, zzib.zzf(t, iZzd & 1048575), zza(length));
                        }
                        break;
                }
            }
            while (entry2 != null) {
                this.zzr.zza(zzisVar, entry2);
                entry2 = itZze.hasNext() ? (Map.Entry) itZze.next() : null;
            }
            return;
        }
        if (this.zzj) {
            if (this.zzh) {
                zzew<T> zzewVarZza2 = this.zzr.zza(t);
                if (zzewVarZza2.zza.isEmpty()) {
                    itZzd = null;
                    entry = null;
                } else {
                    itZzd = zzewVarZza2.zzd();
                    entry = (Map.Entry) itZzd.next();
                }
            } else {
                itZzd = null;
                entry = null;
            }
            int length2 = this.zzc.length;
            for (int i2 = 0; i2 < length2; i2 += 3) {
                int iZzd2 = zzd(i2);
                int i3 = this.zzc[i2];
                while (entry != null && this.zzr.zza(entry) <= i3) {
                    this.zzr.zza(zzisVar, entry);
                    entry = itZzd.hasNext() ? (Map.Entry) itZzd.next() : null;
                }
                switch ((iZzd2 & 267386880) >>> 20) {
                    case 0:
                        if (zza((Object) t, i2)) {
                            zzisVar.zza(i3, zzib.zze(t, iZzd2 & 1048575));
                        }
                        break;
                    case 1:
                        if (zza((Object) t, i2)) {
                            zzisVar.zza(i3, zzib.zzd(t, iZzd2 & 1048575));
                        }
                        break;
                    case 2:
                        if (zza((Object) t, i2)) {
                            zzisVar.zza(i3, zzib.zzb(t, iZzd2 & 1048575));
                        }
                        break;
                    case 3:
                        if (zza((Object) t, i2)) {
                            zzisVar.zzc(i3, zzib.zzb(t, iZzd2 & 1048575));
                        }
                        break;
                    case 4:
                        if (zza((Object) t, i2)) {
                            zzisVar.zzc(i3, zzib.zza(t, iZzd2 & 1048575));
                        }
                        break;
                    case 5:
                        if (zza((Object) t, i2)) {
                            zzisVar.zzd(i3, zzib.zzb(t, iZzd2 & 1048575));
                        }
                        break;
                    case 6:
                        if (zza((Object) t, i2)) {
                            zzisVar.zzd(i3, zzib.zza(t, iZzd2 & 1048575));
                        }
                        break;
                    case 7:
                        if (zza((Object) t, i2)) {
                            zzisVar.zza(i3, zzib.zzc(t, iZzd2 & 1048575));
                        }
                        break;
                    case 8:
                        if (zza((Object) t, i2)) {
                            zza(i3, zzib.zzf(t, iZzd2 & 1048575), zzisVar);
                        }
                        break;
                    case 9:
                        if (zza((Object) t, i2)) {
                            zzisVar.zza(i3, zzib.zzf(t, iZzd2 & 1048575), zza(i2));
                        }
                        break;
                    case 10:
                        if (zza((Object) t, i2)) {
                            zzisVar.zza(i3, (zzdu) zzib.zzf(t, iZzd2 & 1048575));
                        }
                        break;
                    case 11:
                        if (zza((Object) t, i2)) {
                            zzisVar.zze(i3, zzib.zza(t, iZzd2 & 1048575));
                        }
                        break;
                    case 12:
                        if (zza((Object) t, i2)) {
                            zzisVar.zzb(i3, zzib.zza(t, iZzd2 & 1048575));
                        }
                        break;
                    case 13:
                        if (zza((Object) t, i2)) {
                            zzisVar.zza(i3, zzib.zza(t, iZzd2 & 1048575));
                        }
                        break;
                    case 14:
                        if (zza((Object) t, i2)) {
                            zzisVar.zzb(i3, zzib.zzb(t, iZzd2 & 1048575));
                        }
                        break;
                    case 15:
                        if (zza((Object) t, i2)) {
                            zzisVar.zzf(i3, zzib.zza(t, iZzd2 & 1048575));
                        }
                        break;
                    case 16:
                        if (zza((Object) t, i2)) {
                            zzisVar.zze(i3, zzib.zzb(t, iZzd2 & 1048575));
                        }
                        break;
                    case 17:
                        if (zza((Object) t, i2)) {
                            zzisVar.zzb(i3, zzib.zzf(t, iZzd2 & 1048575), zza(i2));
                        }
                        break;
                    case 18:
                        zzhf.zza(this.zzc[i2], (List<Double>) zzib.zzf(t, iZzd2 & 1048575), zzisVar, false);
                        break;
                    case 19:
                        zzhf.zzb(this.zzc[i2], (List<Float>) zzib.zzf(t, iZzd2 & 1048575), zzisVar, false);
                        break;
                    case 20:
                        zzhf.zzc(this.zzc[i2], (List) zzib.zzf(t, iZzd2 & 1048575), zzisVar, false);
                        break;
                    case 21:
                        zzhf.zzd(this.zzc[i2], (List) zzib.zzf(t, iZzd2 & 1048575), zzisVar, false);
                        break;
                    case 22:
                        zzhf.zzh(this.zzc[i2], (List) zzib.zzf(t, iZzd2 & 1048575), zzisVar, false);
                        break;
                    case 23:
                        zzhf.zzf(this.zzc[i2], (List) zzib.zzf(t, iZzd2 & 1048575), zzisVar, false);
                        break;
                    case 24:
                        zzhf.zzk(this.zzc[i2], (List) zzib.zzf(t, iZzd2 & 1048575), zzisVar, false);
                        break;
                    case 25:
                        zzhf.zzn(this.zzc[i2], (List) zzib.zzf(t, iZzd2 & 1048575), zzisVar, false);
                        break;
                    case 26:
                        zzhf.zza(this.zzc[i2], (List<String>) zzib.zzf(t, iZzd2 & 1048575), zzisVar);
                        break;
                    case 27:
                        zzhf.zza(this.zzc[i2], (List<?>) zzib.zzf(t, iZzd2 & 1048575), zzisVar, zza(i2));
                        break;
                    case 28:
                        zzhf.zzb(this.zzc[i2], (List<zzdu>) zzib.zzf(t, iZzd2 & 1048575), zzisVar);
                        break;
                    case 29:
                        zzhf.zzi(this.zzc[i2], (List) zzib.zzf(t, iZzd2 & 1048575), zzisVar, false);
                        break;
                    case 30:
                        zzhf.zzm(this.zzc[i2], (List) zzib.zzf(t, iZzd2 & 1048575), zzisVar, false);
                        break;
                    case 31:
                        zzhf.zzl(this.zzc[i2], (List) zzib.zzf(t, iZzd2 & 1048575), zzisVar, false);
                        break;
                    case 32:
                        zzhf.zzg(this.zzc[i2], (List) zzib.zzf(t, iZzd2 & 1048575), zzisVar, false);
                        break;
                    case 33:
                        zzhf.zzj(this.zzc[i2], (List) zzib.zzf(t, iZzd2 & 1048575), zzisVar, false);
                        break;
                    case 34:
                        zzhf.zze(this.zzc[i2], (List) zzib.zzf(t, iZzd2 & 1048575), zzisVar, false);
                        break;
                    case 35:
                        zzhf.zza(this.zzc[i2], (List<Double>) zzib.zzf(t, iZzd2 & 1048575), zzisVar, true);
                        break;
                    case 36:
                        zzhf.zzb(this.zzc[i2], (List<Float>) zzib.zzf(t, iZzd2 & 1048575), zzisVar, true);
                        break;
                    case 37:
                        zzhf.zzc(this.zzc[i2], (List) zzib.zzf(t, iZzd2 & 1048575), zzisVar, true);
                        break;
                    case 38:
                        zzhf.zzd(this.zzc[i2], (List) zzib.zzf(t, iZzd2 & 1048575), zzisVar, true);
                        break;
                    case 39:
                        zzhf.zzh(this.zzc[i2], (List) zzib.zzf(t, iZzd2 & 1048575), zzisVar, true);
                        break;
                    case 40:
                        zzhf.zzf(this.zzc[i2], (List) zzib.zzf(t, iZzd2 & 1048575), zzisVar, true);
                        break;
                    case 41:
                        zzhf.zzk(this.zzc[i2], (List) zzib.zzf(t, iZzd2 & 1048575), zzisVar, true);
                        break;
                    case 42:
                        zzhf.zzn(this.zzc[i2], (List) zzib.zzf(t, iZzd2 & 1048575), zzisVar, true);
                        break;
                    case 43:
                        zzhf.zzi(this.zzc[i2], (List) zzib.zzf(t, iZzd2 & 1048575), zzisVar, true);
                        break;
                    case 44:
                        zzhf.zzm(this.zzc[i2], (List) zzib.zzf(t, iZzd2 & 1048575), zzisVar, true);
                        break;
                    case 45:
                        zzhf.zzl(this.zzc[i2], (List) zzib.zzf(t, iZzd2 & 1048575), zzisVar, true);
                        break;
                    case 46:
                        zzhf.zzg(this.zzc[i2], (List) zzib.zzf(t, iZzd2 & 1048575), zzisVar, true);
                        break;
                    case 47:
                        zzhf.zzj(this.zzc[i2], (List) zzib.zzf(t, iZzd2 & 1048575), zzisVar, true);
                        break;
                    case 48:
                        zzhf.zze(this.zzc[i2], (List) zzib.zzf(t, iZzd2 & 1048575), zzisVar, true);
                        break;
                    case 49:
                        zzhf.zzb(this.zzc[i2], (List<?>) zzib.zzf(t, iZzd2 & 1048575), zzisVar, zza(i2));
                        break;
                    case 50:
                        zza(zzisVar, i3, zzib.zzf(t, iZzd2 & 1048575), i2);
                        break;
                    case 51:
                        if (zza(t, i3, i2)) {
                            zzisVar.zza(i3, zzb(t, iZzd2 & 1048575));
                        }
                        break;
                    case 52:
                        if (zza(t, i3, i2)) {
                            zzisVar.zza(i3, zzc(t, iZzd2 & 1048575));
                        }
                        break;
                    case 53:
                        if (zza(t, i3, i2)) {
                            zzisVar.zza(i3, zze(t, iZzd2 & 1048575));
                        }
                        break;
                    case 54:
                        if (zza(t, i3, i2)) {
                            zzisVar.zzc(i3, zze(t, iZzd2 & 1048575));
                        }
                        break;
                    case 55:
                        if (zza(t, i3, i2)) {
                            zzisVar.zzc(i3, zzd(t, iZzd2 & 1048575));
                        }
                        break;
                    case 56:
                        if (zza(t, i3, i2)) {
                            zzisVar.zzd(i3, zze(t, iZzd2 & 1048575));
                        }
                        break;
                    case 57:
                        if (zza(t, i3, i2)) {
                            zzisVar.zzd(i3, zzd(t, iZzd2 & 1048575));
                        }
                        break;
                    case 58:
                        if (zza(t, i3, i2)) {
                            zzisVar.zza(i3, zzf(t, iZzd2 & 1048575));
                        }
                        break;
                    case 59:
                        if (zza(t, i3, i2)) {
                            zza(i3, zzib.zzf(t, iZzd2 & 1048575), zzisVar);
                        }
                        break;
                    case 60:
                        if (zza(t, i3, i2)) {
                            zzisVar.zza(i3, zzib.zzf(t, iZzd2 & 1048575), zza(i2));
                        }
                        break;
                    case 61:
                        if (zza(t, i3, i2)) {
                            zzisVar.zza(i3, (zzdu) zzib.zzf(t, iZzd2 & 1048575));
                        }
                        break;
                    case 62:
                        if (zza(t, i3, i2)) {
                            zzisVar.zze(i3, zzd(t, iZzd2 & 1048575));
                        }
                        break;
                    case 63:
                        if (zza(t, i3, i2)) {
                            zzisVar.zzb(i3, zzd(t, iZzd2 & 1048575));
                        }
                        break;
                    case 64:
                        if (zza(t, i3, i2)) {
                            zzisVar.zza(i3, zzd(t, iZzd2 & 1048575));
                        }
                        break;
                    case 65:
                        if (zza(t, i3, i2)) {
                            zzisVar.zzb(i3, zze(t, iZzd2 & 1048575));
                        }
                        break;
                    case 66:
                        if (zza(t, i3, i2)) {
                            zzisVar.zzf(i3, zzd(t, iZzd2 & 1048575));
                        }
                        break;
                    case 67:
                        if (zza(t, i3, i2)) {
                            zzisVar.zze(i3, zze(t, iZzd2 & 1048575));
                        }
                        break;
                    case 68:
                        if (zza(t, i3, i2)) {
                            zzisVar.zzb(i3, zzib.zzf(t, iZzd2 & 1048575), zza(i2));
                        }
                        break;
                }
            }
            while (entry != null) {
                this.zzr.zza(zzisVar, entry);
                entry = itZzd.hasNext() ? (Map.Entry) itZzd.next() : null;
            }
            zza(this.zzq, t, zzisVar);
            return;
        }
        zzb((Object) t, zzisVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x0023  */
    private final void zzb(T t, zzis zzisVar) throws IOException {
        Iterator itZzd;
        Map.Entry<?, ?> entry;
        boolean z;
        int i;
        boolean z2;
        if (this.zzh) {
            zzew<T> zzewVarZza = this.zzr.zza(t);
            if (zzewVarZza.zza.isEmpty()) {
                itZzd = null;
                entry = null;
            } else {
                itZzd = zzewVarZza.zzd();
                entry = (Map.Entry) itZzd.next();
            }
        } else {
            itZzd = null;
            entry = null;
        }
        int length = this.zzc.length;
        Unsafe unsafe = zzb;
        int i2 = -1;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int iZzd = zzd(i4);
            int[] iArr = this.zzc;
            int i5 = iArr[i4];
            int i6 = (267386880 & iZzd) >>> 20;
            if (this.zzj || i6 > 17) {
                z = true;
                i = 0;
            } else {
                int i7 = iArr[i4 + 2];
                int i8 = i7 & 1048575;
                z = true;
                if (i8 != i2) {
                    i3 = unsafe.getInt(t, i8);
                    i2 = i8;
                }
                i = 1 << (i7 >>> 20);
            }
            while (entry != null && this.zzr.zza(entry) <= i5) {
                this.zzr.zza(zzisVar, entry);
                entry = itZzd.hasNext() ? (Map.Entry) itZzd.next() : null;
            }
            long j = iZzd & 1048575;
            switch (i6) {
                case 0:
                    if ((i & i3) != 0) {
                        zzisVar.zza(i5, zzib.zze(t, j));
                    }
                    break;
                case 1:
                    if ((i & i3) != 0) {
                        zzisVar.zza(i5, zzib.zzd(t, j));
                    }
                    break;
                case 2:
                    if ((i & i3) != 0) {
                        zzisVar.zza(i5, unsafe.getLong(t, j));
                    }
                    break;
                case 3:
                    if ((i & i3) != 0) {
                        zzisVar.zzc(i5, unsafe.getLong(t, j));
                    }
                    break;
                case 4:
                    if ((i & i3) != 0) {
                        zzisVar.zzc(i5, unsafe.getInt(t, j));
                    }
                    break;
                case 5:
                    if ((i & i3) != 0) {
                        zzisVar.zzd(i5, unsafe.getLong(t, j));
                    }
                    break;
                case 6:
                    if ((i & i3) != 0) {
                        zzisVar.zzd(i5, unsafe.getInt(t, j));
                    }
                    break;
                case 7:
                    if ((i & i3) != 0) {
                        zzisVar.zza(i5, zzib.zzc(t, j));
                    }
                    break;
                case 8:
                    if ((i & i3) != 0) {
                        zza(i5, unsafe.getObject(t, j), zzisVar);
                    }
                    break;
                case 9:
                    if ((i & i3) != 0) {
                        zzisVar.zza(i5, unsafe.getObject(t, j), zza(i4));
                    }
                    break;
                case 10:
                    if ((i & i3) != 0) {
                        zzisVar.zza(i5, (zzdu) unsafe.getObject(t, j));
                    }
                    break;
                case 11:
                    if ((i & i3) != 0) {
                        zzisVar.zze(i5, unsafe.getInt(t, j));
                    }
                    break;
                case 12:
                    if ((i & i3) != 0) {
                        zzisVar.zzb(i5, unsafe.getInt(t, j));
                    }
                    break;
                case 13:
                    if ((i & i3) != 0) {
                        zzisVar.zza(i5, unsafe.getInt(t, j));
                    }
                    break;
                case 14:
                    if ((i & i3) != 0) {
                        zzisVar.zzb(i5, unsafe.getLong(t, j));
                    }
                    break;
                case 15:
                    if ((i & i3) != 0) {
                        zzisVar.zzf(i5, unsafe.getInt(t, j));
                    }
                    break;
                case 16:
                    if ((i & i3) != 0) {
                        zzisVar.zze(i5, unsafe.getLong(t, j));
                    }
                    break;
                case 17:
                    if ((i & i3) != 0) {
                        zzisVar.zzb(i5, unsafe.getObject(t, j), zza(i4));
                    }
                    break;
                case 18:
                    zzhf.zza(this.zzc[i4], (List<Double>) unsafe.getObject(t, j), zzisVar, false);
                    break;
                case 19:
                    zzhf.zzb(this.zzc[i4], (List<Float>) unsafe.getObject(t, j), zzisVar, false);
                    break;
                case 20:
                    zzhf.zzc(this.zzc[i4], (List) unsafe.getObject(t, j), zzisVar, false);
                    break;
                case 21:
                    zzhf.zzd(this.zzc[i4], (List) unsafe.getObject(t, j), zzisVar, false);
                    break;
                case 22:
                    zzhf.zzh(this.zzc[i4], (List) unsafe.getObject(t, j), zzisVar, false);
                    break;
                case 23:
                    zzhf.zzf(this.zzc[i4], (List) unsafe.getObject(t, j), zzisVar, false);
                    break;
                case 24:
                    zzhf.zzk(this.zzc[i4], (List) unsafe.getObject(t, j), zzisVar, false);
                    break;
                case 25:
                    zzhf.zzn(this.zzc[i4], (List) unsafe.getObject(t, j), zzisVar, false);
                    break;
                case 26:
                    zzhf.zza(this.zzc[i4], (List<String>) unsafe.getObject(t, j), zzisVar);
                    break;
                case 27:
                    zzhf.zza(this.zzc[i4], (List<?>) unsafe.getObject(t, j), zzisVar, zza(i4));
                    break;
                case 28:
                    zzhf.zzb(this.zzc[i4], (List<zzdu>) unsafe.getObject(t, j), zzisVar);
                    break;
                case 29:
                    z2 = false;
                    zzhf.zzi(this.zzc[i4], (List) unsafe.getObject(t, j), zzisVar, false);
                    break;
                case 30:
                    z2 = false;
                    zzhf.zzm(this.zzc[i4], (List) unsafe.getObject(t, j), zzisVar, false);
                    break;
                case 31:
                    z2 = false;
                    zzhf.zzl(this.zzc[i4], (List) unsafe.getObject(t, j), zzisVar, false);
                    break;
                case 32:
                    z2 = false;
                    zzhf.zzg(this.zzc[i4], (List) unsafe.getObject(t, j), zzisVar, false);
                    break;
                case 33:
                    z2 = false;
                    zzhf.zzj(this.zzc[i4], (List) unsafe.getObject(t, j), zzisVar, false);
                    break;
                case 34:
                    z2 = false;
                    zzhf.zze(this.zzc[i4], (List) unsafe.getObject(t, j), zzisVar, false);
                    break;
                case 35:
                    zzhf.zza(this.zzc[i4], (List<Double>) unsafe.getObject(t, j), zzisVar, z);
                    break;
                case 36:
                    zzhf.zzb(this.zzc[i4], (List<Float>) unsafe.getObject(t, j), zzisVar, z);
                    break;
                case 37:
                    zzhf.zzc(this.zzc[i4], (List) unsafe.getObject(t, j), zzisVar, z);
                    break;
                case 38:
                    zzhf.zzd(this.zzc[i4], (List) unsafe.getObject(t, j), zzisVar, z);
                    break;
                case 39:
                    zzhf.zzh(this.zzc[i4], (List) unsafe.getObject(t, j), zzisVar, z);
                    break;
                case 40:
                    zzhf.zzf(this.zzc[i4], (List) unsafe.getObject(t, j), zzisVar, z);
                    break;
                case 41:
                    zzhf.zzk(this.zzc[i4], (List) unsafe.getObject(t, j), zzisVar, z);
                    break;
                case 42:
                    zzhf.zzn(this.zzc[i4], (List) unsafe.getObject(t, j), zzisVar, z);
                    break;
                case 43:
                    zzhf.zzi(this.zzc[i4], (List) unsafe.getObject(t, j), zzisVar, z);
                    break;
                case 44:
                    zzhf.zzm(this.zzc[i4], (List) unsafe.getObject(t, j), zzisVar, z);
                    break;
                case 45:
                    zzhf.zzl(this.zzc[i4], (List) unsafe.getObject(t, j), zzisVar, z);
                    break;
                case 46:
                    zzhf.zzg(this.zzc[i4], (List) unsafe.getObject(t, j), zzisVar, z);
                    break;
                case 47:
                    zzhf.zzj(this.zzc[i4], (List) unsafe.getObject(t, j), zzisVar, z);
                    break;
                case 48:
                    zzhf.zze(this.zzc[i4], (List) unsafe.getObject(t, j), zzisVar, z);
                    break;
                case 49:
                    zzhf.zzb(this.zzc[i4], (List<?>) unsafe.getObject(t, j), zzisVar, zza(i4));
                    break;
                case 50:
                    zza(zzisVar, i5, unsafe.getObject(t, j), i4);
                    break;
                case 51:
                    if (zza(t, i5, i4)) {
                        zzisVar.zza(i5, zzb(t, j));
                    }
                    break;
                case 52:
                    if (zza(t, i5, i4)) {
                        zzisVar.zza(i5, zzc(t, j));
                    }
                    break;
                case 53:
                    if (zza(t, i5, i4)) {
                        zzisVar.zza(i5, zze(t, j));
                    }
                    break;
                case 54:
                    if (zza(t, i5, i4)) {
                        zzisVar.zzc(i5, zze(t, j));
                    }
                    break;
                case 55:
                    if (zza(t, i5, i4)) {
                        zzisVar.zzc(i5, zzd(t, j));
                    }
                    break;
                case 56:
                    if (zza(t, i5, i4)) {
                        zzisVar.zzd(i5, zze(t, j));
                    }
                    break;
                case 57:
                    if (zza(t, i5, i4)) {
                        zzisVar.zzd(i5, zzd(t, j));
                    }
                    break;
                case 58:
                    if (zza(t, i5, i4)) {
                        zzisVar.zza(i5, zzf(t, j));
                    }
                    break;
                case 59:
                    if (zza(t, i5, i4)) {
                        zza(i5, unsafe.getObject(t, j), zzisVar);
                    }
                    break;
                case 60:
                    if (zza(t, i5, i4)) {
                        zzisVar.zza(i5, unsafe.getObject(t, j), zza(i4));
                    }
                    break;
                case 61:
                    if (zza(t, i5, i4)) {
                        zzisVar.zza(i5, (zzdu) unsafe.getObject(t, j));
                    }
                    break;
                case 62:
                    if (zza(t, i5, i4)) {
                        zzisVar.zze(i5, zzd(t, j));
                    }
                    break;
                case 63:
                    if (zza(t, i5, i4)) {
                        zzisVar.zzb(i5, zzd(t, j));
                    }
                    break;
                case 64:
                    if (zza(t, i5, i4)) {
                        zzisVar.zza(i5, zzd(t, j));
                    }
                    break;
                case 65:
                    if (zza(t, i5, i4)) {
                        zzisVar.zzb(i5, zze(t, j));
                    }
                    break;
                case 66:
                    if (zza(t, i5, i4)) {
                        zzisVar.zzf(i5, zzd(t, j));
                    }
                    break;
                case 67:
                    if (zza(t, i5, i4)) {
                        zzisVar.zze(i5, zze(t, j));
                    }
                    break;
                case 68:
                    if (zza(t, i5, i4)) {
                        zzisVar.zzb(i5, unsafe.getObject(t, j), zza(i4));
                    }
                    break;
                default:
                    break;
            }
        }
        while (entry != null) {
            this.zzr.zza(zzisVar, entry);
            entry = itZzd.hasNext() ? (Map.Entry) itZzd.next() : null;
        }
        zza(this.zzq, t, zzisVar);
    }

    private final <K, V> void zza(zzis zzisVar, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzisVar.zza(i, this.zzs.zzf(zzb(i2)), this.zzs.zzb(obj));
        }
    }

    private static <UT, UB> void zza(zzhv<UT, UB> zzhvVar, T t, zzis zzisVar) throws IOException {
        zzhvVar.zza(zzhvVar.zzb(t), zzisVar);
    }

    /* JADX WARN: Code duplicated, block: B:161:0x05cc A[LOOP:5: B:159:0x05c8->B:161:0x05cc, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:163:0x05d9  */
    /* JADX WARN: Code duplicated, block: B:352:? A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.google.android.gms.internal.measurement.zzhd
    public final void zza(T t, zzhe zzheVar, zzeq zzeqVar) throws IOException {
        int i;
        zzeqVar.getClass();
        zzhv<?, ?> zzhvVar = this.zzq;
        zzes<?> zzesVar = this.zzr;
        zzew zzewVarZzb = null;
        Object objZza = null;
        while (true) {
            try {
                int iZza = zzheVar.zza();
                int iZzg = zzg(iZza);
                if (iZzg >= 0) {
                    int iZzd = zzd(iZzg);
                    switch ((267386880 & iZzd) >>> 20) {
                        case 0:
                            zzib.zza(t, iZzd & 1048575, zzheVar.zzd());
                            zzb((Object) t, iZzg);
                            continue;
                        case 1:
                            zzib.zza((Object) t, iZzd & 1048575, zzheVar.zze());
                            zzb((Object) t, iZzg);
                            continue;
                        case 2:
                            zzib.zza((Object) t, iZzd & 1048575, zzheVar.zzg());
                            zzb((Object) t, iZzg);
                            continue;
                        case 3:
                            zzib.zza((Object) t, iZzd & 1048575, zzheVar.zzf());
                            zzb((Object) t, iZzg);
                            continue;
                        case 4:
                            zzib.zza((Object) t, iZzd & 1048575, zzheVar.zzh());
                            zzb((Object) t, iZzg);
                            continue;
                        case 5:
                            zzib.zza((Object) t, iZzd & 1048575, zzheVar.zzi());
                            zzb((Object) t, iZzg);
                            continue;
                        case 6:
                            zzib.zza((Object) t, iZzd & 1048575, zzheVar.zzj());
                            zzb((Object) t, iZzg);
                            continue;
                        case 7:
                            zzib.zza(t, iZzd & 1048575, zzheVar.zzk());
                            zzb((Object) t, iZzg);
                            continue;
                        case 8:
                            zza(t, iZzd, zzheVar);
                            zzb((Object) t, iZzg);
                            continue;
                        case 9:
                            if (zza((Object) t, iZzg)) {
                                long j = iZzd & 1048575;
                                zzib.zza(t, j, zzff.zza(zzib.zzf(t, j), zzheVar.zza(zza(iZzg), zzeqVar)));
                            } else {
                                zzib.zza(t, iZzd & 1048575, zzheVar.zza(zza(iZzg), zzeqVar));
                                zzb((Object) t, iZzg);
                                continue;
                            }
                            break;
                        case 10:
                            zzib.zza(t, iZzd & 1048575, zzheVar.zzn());
                            zzb((Object) t, iZzg);
                            continue;
                        case 11:
                            zzib.zza((Object) t, iZzd & 1048575, zzheVar.zzo());
                            zzb((Object) t, iZzg);
                            continue;
                        case 12:
                            int iZzp = zzheVar.zzp();
                            zzfk zzfkVarZzc = zzc(iZzg);
                            if (zzfkVarZzc == null || zzfkVarZzc.zza(iZzp)) {
                                zzib.zza((Object) t, iZzd & 1048575, iZzp);
                                zzb((Object) t, iZzg);
                                continue;
                            } else {
                                objZza = zzhf.zza(iZza, iZzp, objZza, (zzhv<UT, Object>) zzhvVar);
                            }
                            break;
                        case 13:
                            zzib.zza((Object) t, iZzd & 1048575, zzheVar.zzq());
                            zzb((Object) t, iZzg);
                            continue;
                        case 14:
                            zzib.zza((Object) t, iZzd & 1048575, zzheVar.zzr());
                            zzb((Object) t, iZzg);
                            continue;
                        case 15:
                            zzib.zza((Object) t, iZzd & 1048575, zzheVar.zzs());
                            zzb((Object) t, iZzg);
                            continue;
                        case 16:
                            zzib.zza((Object) t, iZzd & 1048575, zzheVar.zzt());
                            zzb((Object) t, iZzg);
                            continue;
                        case 17:
                            if (zza((Object) t, iZzg)) {
                                long j2 = iZzd & 1048575;
                                zzib.zza(t, j2, zzff.zza(zzib.zzf(t, j2), zzheVar.zzb(zza(iZzg), zzeqVar)));
                            } else {
                                zzib.zza(t, iZzd & 1048575, zzheVar.zzb(zza(iZzg), zzeqVar));
                                zzb((Object) t, iZzg);
                                continue;
                            }
                            break;
                        case 18:
                            zzheVar.zza(this.zzp.zza(t, iZzd & 1048575));
                            continue;
                        case 19:
                            zzheVar.zzb(this.zzp.zza(t, iZzd & 1048575));
                            continue;
                        case 20:
                            zzheVar.zzd(this.zzp.zza(t, iZzd & 1048575));
                            continue;
                        case 21:
                            zzheVar.zzc(this.zzp.zza(t, iZzd & 1048575));
                            continue;
                        case 22:
                            zzheVar.zze(this.zzp.zza(t, iZzd & 1048575));
                            continue;
                        case 23:
                            zzheVar.zzf(this.zzp.zza(t, iZzd & 1048575));
                            continue;
                        case 24:
                            zzheVar.zzg(this.zzp.zza(t, iZzd & 1048575));
                            continue;
                        case 25:
                            zzheVar.zzh(this.zzp.zza(t, iZzd & 1048575));
                            continue;
                        case 26:
                            if (zzf(iZzd)) {
                                zzheVar.zzj(this.zzp.zza(t, iZzd & 1048575));
                            } else {
                                zzheVar.zzi(this.zzp.zza(t, iZzd & 1048575));
                                continue;
                            }
                            break;
                        case 27:
                            zzheVar.zza(this.zzp.zza(t, iZzd & 1048575), zza(iZzg), zzeqVar);
                            continue;
                        case 28:
                            zzheVar.zzk(this.zzp.zza(t, iZzd & 1048575));
                            continue;
                        case 29:
                            zzheVar.zzl(this.zzp.zza(t, iZzd & 1048575));
                            continue;
                        case 30:
                            List<Integer> listZza = this.zzp.zza(t, iZzd & 1048575);
                            zzheVar.zzm(listZza);
                            objZza = zzhf.zza(iZza, listZza, zzc(iZzg), objZza, zzhvVar);
                            continue;
                        case 31:
                            zzheVar.zzn(this.zzp.zza(t, iZzd & 1048575));
                            continue;
                        case 32:
                            zzheVar.zzo(this.zzp.zza(t, iZzd & 1048575));
                            continue;
                        case 33:
                            zzheVar.zzp(this.zzp.zza(t, iZzd & 1048575));
                            continue;
                        case 34:
                            zzheVar.zzq(this.zzp.zza(t, iZzd & 1048575));
                            continue;
                        case 35:
                            zzheVar.zza(this.zzp.zza(t, iZzd & 1048575));
                            continue;
                        case 36:
                            zzheVar.zzb(this.zzp.zza(t, iZzd & 1048575));
                            continue;
                        case 37:
                            zzheVar.zzd(this.zzp.zza(t, iZzd & 1048575));
                            continue;
                        case 38:
                            zzheVar.zzc(this.zzp.zza(t, iZzd & 1048575));
                            continue;
                        case 39:
                            zzheVar.zze(this.zzp.zza(t, iZzd & 1048575));
                            continue;
                        case 40:
                            zzheVar.zzf(this.zzp.zza(t, iZzd & 1048575));
                            continue;
                        case 41:
                            zzheVar.zzg(this.zzp.zza(t, iZzd & 1048575));
                            continue;
                        case 42:
                            zzheVar.zzh(this.zzp.zza(t, iZzd & 1048575));
                            continue;
                        case 43:
                            zzheVar.zzl(this.zzp.zza(t, iZzd & 1048575));
                            continue;
                        case 44:
                            List<Integer> listZza2 = this.zzp.zza(t, iZzd & 1048575);
                            zzheVar.zzm(listZza2);
                            objZza = zzhf.zza(iZza, listZza2, zzc(iZzg), objZza, zzhvVar);
                            continue;
                        case 45:
                            zzheVar.zzn(this.zzp.zza(t, iZzd & 1048575));
                            continue;
                        case 46:
                            zzheVar.zzo(this.zzp.zza(t, iZzd & 1048575));
                            continue;
                        case 47:
                            zzheVar.zzp(this.zzp.zza(t, iZzd & 1048575));
                            continue;
                        case 48:
                            zzheVar.zzq(this.zzp.zza(t, iZzd & 1048575));
                            continue;
                        case 49:
                            zzheVar.zzb(this.zzp.zza(t, iZzd & 1048575), zza(iZzg), zzeqVar);
                            continue;
                        case 50:
                            Object objZzb = zzb(iZzg);
                            long jZzd = zzd(iZzg) & 1048575;
                            Object objZzf = zzib.zzf(t, jZzd);
                            if (objZzf == null) {
                                objZzf = this.zzs.zze(objZzb);
                                zzib.zza(t, jZzd, objZzf);
                            } else if (this.zzs.zzc(objZzf)) {
                                Object objZze = this.zzs.zze(objZzb);
                                this.zzs.zza(objZze, objZzf);
                                zzib.zza(t, jZzd, objZze);
                                objZzf = objZze;
                            }
                            zzheVar.zza(this.zzs.zza(objZzf), this.zzs.zzf(objZzb), zzeqVar);
                            continue;
                        case 51:
                            zzib.zza(t, iZzd & 1048575, Double.valueOf(zzheVar.zzd()));
                            zzb(t, iZza, iZzg);
                            continue;
                        case 52:
                            zzib.zza(t, iZzd & 1048575, Float.valueOf(zzheVar.zze()));
                            zzb(t, iZza, iZzg);
                            continue;
                        case 53:
                            zzib.zza(t, iZzd & 1048575, Long.valueOf(zzheVar.zzg()));
                            zzb(t, iZza, iZzg);
                            continue;
                        case 54:
                            zzib.zza(t, iZzd & 1048575, Long.valueOf(zzheVar.zzf()));
                            zzb(t, iZza, iZzg);
                            continue;
                        case 55:
                            zzib.zza(t, iZzd & 1048575, Integer.valueOf(zzheVar.zzh()));
                            zzb(t, iZza, iZzg);
                            continue;
                        case 56:
                            zzib.zza(t, iZzd & 1048575, Long.valueOf(zzheVar.zzi()));
                            zzb(t, iZza, iZzg);
                            continue;
                        case 57:
                            zzib.zza(t, iZzd & 1048575, Integer.valueOf(zzheVar.zzj()));
                            zzb(t, iZza, iZzg);
                            continue;
                        case 58:
                            zzib.zza(t, iZzd & 1048575, Boolean.valueOf(zzheVar.zzk()));
                            zzb(t, iZza, iZzg);
                            continue;
                        case 59:
                            zza(t, iZzd, zzheVar);
                            zzb(t, iZza, iZzg);
                            continue;
                        case 60:
                            if (zza(t, iZza, iZzg)) {
                                long j3 = iZzd & 1048575;
                                zzib.zza(t, j3, zzff.zza(zzib.zzf(t, j3), zzheVar.zza(zza(iZzg), zzeqVar)));
                            } else {
                                zzib.zza(t, iZzd & 1048575, zzheVar.zza(zza(iZzg), zzeqVar));
                                zzb((Object) t, iZzg);
                            }
                            zzb(t, iZza, iZzg);
                            continue;
                        case 61:
                            zzib.zza(t, iZzd & 1048575, zzheVar.zzn());
                            zzb(t, iZza, iZzg);
                            continue;
                        case 62:
                            zzib.zza(t, iZzd & 1048575, Integer.valueOf(zzheVar.zzo()));
                            zzb(t, iZza, iZzg);
                            continue;
                        case 63:
                            int iZzp2 = zzheVar.zzp();
                            zzfk zzfkVarZzc2 = zzc(iZzg);
                            if (zzfkVarZzc2 == null || zzfkVarZzc2.zza(iZzp2)) {
                                zzib.zza(t, iZzd & 1048575, Integer.valueOf(iZzp2));
                                zzb(t, iZza, iZzg);
                                continue;
                            } else {
                                objZza = zzhf.zza(iZza, iZzp2, objZza, (zzhv<UT, Object>) zzhvVar);
                            }
                            break;
                        case 64:
                            zzib.zza(t, iZzd & 1048575, Integer.valueOf(zzheVar.zzq()));
                            zzb(t, iZza, iZzg);
                            continue;
                        case 65:
                            zzib.zza(t, iZzd & 1048575, Long.valueOf(zzheVar.zzr()));
                            zzb(t, iZza, iZzg);
                            continue;
                        case 66:
                            zzib.zza(t, iZzd & 1048575, Integer.valueOf(zzheVar.zzs()));
                            zzb(t, iZza, iZzg);
                            continue;
                        case 67:
                            zzib.zza(t, iZzd & 1048575, Long.valueOf(zzheVar.zzt()));
                            zzb(t, iZza, iZzg);
                            continue;
                        case 68:
                            zzib.zza(t, iZzd & 1048575, zzheVar.zzb(zza(iZzg), zzeqVar));
                            zzb(t, iZza, iZzg);
                            continue;
                        default:
                            if (objZza == null) {
                                try {
                                    objZza = zzhvVar.zza();
                                } catch (zzfn unused) {
                                    zzhvVar.zza(zzheVar);
                                    if (objZza == null) {
                                        objZza = zzhvVar.zzc(t);
                                    }
                                    if (!zzhvVar.zza((Object) objZza, zzheVar)) {
                                        for (int i2 = this.zzm; i2 < this.zzn; i2++) {
                                            objZza = zza((Object) t, this.zzl[i2], objZza, (zzhv<UT, Object>) zzhvVar);
                                        }
                                        if (objZza != null) {
                                            zzhvVar.zzb(t, (Object) objZza);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                break;
                            }
                            if (!zzhvVar.zza((Object) objZza, zzheVar)) {
                                for (int i3 = this.zzm; i3 < this.zzn; i3++) {
                                    objZza = zza((Object) t, this.zzl[i3], objZza, (zzhv<UT, Object>) zzhvVar);
                                }
                                if (objZza != null) {
                                    zzhvVar.zzb(t, (Object) objZza);
                                    return;
                                }
                                return;
                            }
                            break;
                            break;
                    }
                    for (i = this.zzm; i < this.zzn; i++) {
                        objZza = zza((Object) t, this.zzl[i], objZza, (zzhv<UT, Object>) zzhvVar);
                    }
                    if (objZza != null) {
                        zzhvVar.zzb(t, (Object) objZza);
                        throw th;
                    }
                    throw th;
                }
                if (iZza == Integer.MAX_VALUE) {
                    for (int i4 = this.zzm; i4 < this.zzn; i4++) {
                        objZza = zza((Object) t, this.zzl[i4], objZza, (zzhv<UT, Object>) zzhvVar);
                    }
                    if (objZza != null) {
                        zzhvVar.zzb(t, (Object) objZza);
                        return;
                    }
                    return;
                }
                Object objZza2 = !this.zzh ? null : zzesVar.zza(zzeqVar, this.zzg, iZza);
                if (objZza2 != null) {
                    if (zzewVarZzb == null) {
                        zzewVarZzb = zzesVar.zzb(t);
                    }
                    zzeq zzeqVar2 = zzeqVar;
                    zzew zzewVar = zzewVarZzb;
                    zzhe zzheVar2 = zzheVar;
                    objZza = zzesVar.zza(zzheVar2, objZza2, zzeqVar2, zzewVar, objZza, zzhvVar);
                    zzheVar = zzheVar2;
                    zzeqVar = zzeqVar2;
                    zzewVarZzb = zzewVar;
                } else {
                    zzhvVar.zza(zzheVar);
                    if (objZza == null) {
                        objZza = zzhvVar.zzc(t);
                    }
                    if (!zzhvVar.zza((Object) objZza, zzheVar)) {
                        for (int i5 = this.zzm; i5 < this.zzn; i5++) {
                            objZza = zza((Object) t, this.zzl[i5], objZza, (zzhv<UT, Object>) zzhvVar);
                        }
                        if (objZza != null) {
                            zzhvVar.zzb(t, (Object) objZza);
                            return;
                        }
                        return;
                    }
                }
            } catch (Throwable th) {
                while (i < this.zzn) {
                    objZza = zza((Object) t, this.zzl[i], objZza, (zzhv<UT, Object>) zzhvVar);
                }
                if (objZza != null) {
                    zzhvVar.zzb(t, (Object) objZza);
                    throw th;
                }
                throw th;
            }
        }
    }

    private static zzhy zze(Object obj) {
        zzfd zzfdVar = (zzfd) obj;
        zzhy zzhyVar = zzfdVar.zzb;
        if (zzhyVar != zzhy.zza()) {
            return zzhyVar;
        }
        zzhy zzhyVarZzb = zzhy.zzb();
        zzfdVar.zzb = zzhyVarZzb;
        return zzhyVarZzb;
    }

    private static int zza(byte[] bArr, int i, int i2, zzim zzimVar, Class<?> cls, zzdt zzdtVar) throws IOException {
        switch (zzgr.zza[zzimVar.ordinal()]) {
            case 1:
                int iZzb = zzdq.zzb(bArr, i, zzdtVar);
                zzdtVar.zzc = Boolean.valueOf(zzdtVar.zzb != 0);
                return iZzb;
            case 2:
                return zzdq.zze(bArr, i, zzdtVar);
            case 3:
                zzdtVar.zzc = Double.valueOf(zzdq.zzc(bArr, i));
                return i + 8;
            case 4:
            case 5:
                zzdtVar.zzc = Integer.valueOf(zzdq.zza(bArr, i));
                return i + 4;
            case 6:
            case 7:
                zzdtVar.zzc = Long.valueOf(zzdq.zzb(bArr, i));
                return i + 8;
            case 8:
                zzdtVar.zzc = Float.valueOf(zzdq.zzd(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int iZza = zzdq.zza(bArr, i, zzdtVar);
                zzdtVar.zzc = Integer.valueOf(zzdtVar.zza);
                return iZza;
            case 12:
            case 13:
                int iZzb2 = zzdq.zzb(bArr, i, zzdtVar);
                zzdtVar.zzc = Long.valueOf(zzdtVar.zzb);
                return iZzb2;
            case 14:
                return zzdq.zza(zzgz.zza().zza((Class) cls), bArr, i, i2, zzdtVar);
            case 15:
                int iZza2 = zzdq.zza(bArr, i, zzdtVar);
                zzdtVar.zzc = Integer.valueOf(zzeg.zze(zzdtVar.zza));
                return iZza2;
            case 16:
                int iZzb3 = zzdq.zzb(bArr, i, zzdtVar);
                zzdtVar.zzc = Long.valueOf(zzeg.zza(zzdtVar.zzb));
                return iZzb3;
            case 17:
                return zzdq.zzd(bArr, i, zzdtVar);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, zzdt zzdtVar) throws IOException {
        int i8;
        int i9;
        int iZza;
        Unsafe unsafe = zzb;
        zzfl zzflVarZza = (zzfl) unsafe.getObject(t, j2);
        if (!zzflVarZza.zza()) {
            int size = zzflVarZza.size();
            zzflVarZza = zzflVarZza.zza(size == 0 ? 10 : size << 1);
            unsafe.putObject(t, j2, zzflVarZza);
        }
        zzfl zzflVar = zzflVarZza;
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    zzeo zzeoVar = (zzeo) zzflVar;
                    int iZza2 = zzdq.zza(bArr, i, zzdtVar);
                    int i10 = zzdtVar.zza + iZza2;
                    while (iZza2 < i10) {
                        zzeoVar.zza(zzdq.zzc(bArr, iZza2));
                        iZza2 += 8;
                    }
                    if (iZza2 == i10) {
                        return iZza2;
                    }
                    throw zzfo.zza();
                }
                if (i5 != 1) {
                    return i;
                }
                zzeo zzeoVar2 = (zzeo) zzflVar;
                zzeoVar2.zza(zzdq.zzc(bArr, i));
                int i11 = i + 8;
                while (i11 < i2) {
                    int iZza3 = zzdq.zza(bArr, i11, zzdtVar);
                    if (i3 != zzdtVar.zza) {
                        return i11;
                    }
                    zzeoVar2.zza(zzdq.zzc(bArr, iZza3));
                    i11 = iZza3 + 8;
                }
                return i11;
            case 19:
            case 36:
                if (i5 == 2) {
                    zzfc zzfcVar = (zzfc) zzflVar;
                    int iZza4 = zzdq.zza(bArr, i, zzdtVar);
                    int i12 = zzdtVar.zza + iZza4;
                    while (iZza4 < i12) {
                        zzfcVar.zza(zzdq.zzd(bArr, iZza4));
                        iZza4 += 4;
                    }
                    if (iZza4 == i12) {
                        return iZza4;
                    }
                    throw zzfo.zza();
                }
                if (i5 != 5) {
                    return i;
                }
                zzfc zzfcVar2 = (zzfc) zzflVar;
                zzfcVar2.zza(zzdq.zzd(bArr, i));
                int i13 = i + 4;
                while (i13 < i2) {
                    int iZza5 = zzdq.zza(bArr, i13, zzdtVar);
                    if (i3 != zzdtVar.zza) {
                        return i13;
                    }
                    zzfcVar2.zza(zzdq.zzd(bArr, iZza5));
                    i13 = iZza5 + 4;
                }
                return i13;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    zzgc zzgcVar = (zzgc) zzflVar;
                    int iZza6 = zzdq.zza(bArr, i, zzdtVar);
                    int i14 = zzdtVar.zza + iZza6;
                    while (iZza6 < i14) {
                        iZza6 = zzdq.zzb(bArr, iZza6, zzdtVar);
                        zzgcVar.zza(zzdtVar.zzb);
                    }
                    if (iZza6 == i14) {
                        return iZza6;
                    }
                    throw zzfo.zza();
                }
                if (i5 != 0) {
                    return i;
                }
                zzgc zzgcVar2 = (zzgc) zzflVar;
                int iZzb = zzdq.zzb(bArr, i, zzdtVar);
                zzgcVar2.zza(zzdtVar.zzb);
                while (iZzb < i2) {
                    int iZza7 = zzdq.zza(bArr, iZzb, zzdtVar);
                    if (i3 != zzdtVar.zza) {
                        return iZzb;
                    }
                    iZzb = zzdq.zzb(bArr, iZza7, zzdtVar);
                    zzgcVar2.zza(zzdtVar.zzb);
                }
                return iZzb;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return zzdq.zza(bArr, i, (zzfl<?>) zzflVar, zzdtVar);
                }
                return i5 == 0 ? zzdq.zza(i3, bArr, i, i2, (zzfl<?>) zzflVar, zzdtVar) : i;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    zzgc zzgcVar3 = (zzgc) zzflVar;
                    int iZza8 = zzdq.zza(bArr, i, zzdtVar);
                    int i15 = zzdtVar.zza + iZza8;
                    while (iZza8 < i15) {
                        zzgcVar3.zza(zzdq.zzb(bArr, iZza8));
                        iZza8 += 8;
                    }
                    if (iZza8 == i15) {
                        return iZza8;
                    }
                    throw zzfo.zza();
                }
                if (i5 != 1) {
                    return i;
                }
                zzgc zzgcVar4 = (zzgc) zzflVar;
                zzgcVar4.zza(zzdq.zzb(bArr, i));
                int i16 = i + 8;
                while (i16 < i2) {
                    int iZza9 = zzdq.zza(bArr, i16, zzdtVar);
                    if (i3 != zzdtVar.zza) {
                        return i16;
                    }
                    zzgcVar4.zza(zzdq.zzb(bArr, iZza9));
                    i16 = iZza9 + 8;
                }
                return i16;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    zzfg zzfgVar = (zzfg) zzflVar;
                    int iZza10 = zzdq.zza(bArr, i, zzdtVar);
                    int i17 = zzdtVar.zza + iZza10;
                    while (iZza10 < i17) {
                        zzfgVar.zzd(zzdq.zza(bArr, iZza10));
                        iZza10 += 4;
                    }
                    if (iZza10 == i17) {
                        return iZza10;
                    }
                    throw zzfo.zza();
                }
                if (i5 != 5) {
                    return i;
                }
                zzfg zzfgVar2 = (zzfg) zzflVar;
                zzfgVar2.zzd(zzdq.zza(bArr, i));
                int i18 = i + 4;
                while (i18 < i2) {
                    int iZza11 = zzdq.zza(bArr, i18, zzdtVar);
                    if (i3 != zzdtVar.zza) {
                        return i18;
                    }
                    zzfgVar2.zzd(zzdq.zza(bArr, iZza11));
                    i18 = iZza11 + 4;
                }
                return i18;
            case 25:
            case 42:
                if (i5 == 2) {
                    zzds zzdsVar = (zzds) zzflVar;
                    int iZza12 = zzdq.zza(bArr, i, zzdtVar);
                    int i19 = zzdtVar.zza + iZza12;
                    while (iZza12 < i19) {
                        iZza12 = zzdq.zzb(bArr, iZza12, zzdtVar);
                        zzdsVar.zza(zzdtVar.zzb != 0);
                    }
                    if (iZza12 == i19) {
                        return iZza12;
                    }
                    throw zzfo.zza();
                }
                if (i5 != 0) {
                    return i;
                }
                zzds zzdsVar2 = (zzds) zzflVar;
                int iZzb2 = zzdq.zzb(bArr, i, zzdtVar);
                zzdsVar2.zza(zzdtVar.zzb != 0);
                while (iZzb2 < i2) {
                    int iZza13 = zzdq.zza(bArr, iZzb2, zzdtVar);
                    if (i3 != zzdtVar.zza) {
                        return iZzb2;
                    }
                    iZzb2 = zzdq.zzb(bArr, iZza13, zzdtVar);
                    zzdsVar2.zza(zzdtVar.zzb != 0);
                }
                return iZzb2;
            case 26:
                if (i5 != 2) {
                    return i;
                }
                if ((j & 536870912) == 0) {
                    int iZza14 = zzdq.zza(bArr, i, zzdtVar);
                    int i20 = zzdtVar.zza;
                    if (i20 < 0) {
                        throw zzfo.zzb();
                    }
                    if (i20 == 0) {
                        zzflVar.add("");
                    } else {
                        zzflVar.add(new String(bArr, iZza14, i20, zzff.zza));
                        iZza14 += i20;
                    }
                    while (iZza14 < i2) {
                        int iZza15 = zzdq.zza(bArr, iZza14, zzdtVar);
                        if (i3 != zzdtVar.zza) {
                            return iZza14;
                        }
                        iZza14 = zzdq.zza(bArr, iZza15, zzdtVar);
                        int i21 = zzdtVar.zza;
                        if (i21 < 0) {
                            throw zzfo.zzb();
                        }
                        if (i21 == 0) {
                            zzflVar.add("");
                        } else {
                            zzflVar.add(new String(bArr, iZza14, i21, zzff.zza));
                            iZza14 += i21;
                        }
                    }
                    return iZza14;
                }
                int iZza16 = zzdq.zza(bArr, i, zzdtVar);
                int i22 = zzdtVar.zza;
                if (i22 < 0) {
                    throw zzfo.zzb();
                }
                if (i22 == 0) {
                    zzflVar.add("");
                } else {
                    int i23 = iZza16 + i22;
                    if (!zzie.zza(bArr, iZza16, i23)) {
                        throw zzfo.zzh();
                    }
                    zzflVar.add(new String(bArr, iZza16, i22, zzff.zza));
                    iZza16 = i23;
                }
                while (iZza16 < i2) {
                    int iZza17 = zzdq.zza(bArr, iZza16, zzdtVar);
                    if (i3 != zzdtVar.zza) {
                        return iZza16;
                    }
                    iZza16 = zzdq.zza(bArr, iZza17, zzdtVar);
                    int i24 = zzdtVar.zza;
                    if (i24 < 0) {
                        throw zzfo.zzb();
                    }
                    if (i24 == 0) {
                        zzflVar.add("");
                    } else {
                        int i25 = iZza16 + i24;
                        if (!zzie.zza(bArr, iZza16, i25)) {
                            throw zzfo.zzh();
                        }
                        zzflVar.add(new String(bArr, iZza16, i24, zzff.zza));
                        iZza16 = i25;
                    }
                }
                return iZza16;
            case 27:
                i8 = i;
                if (i5 == 2) {
                    return zzdq.zza(zza(i6), i3, bArr, i8, i2, zzflVar, zzdtVar);
                }
                return i8;
            case 28:
                i8 = i;
                if (i5 == 2) {
                    int iZza18 = zzdq.zza(bArr, i8, zzdtVar);
                    int i26 = zzdtVar.zza;
                    if (i26 < 0) {
                        throw zzfo.zzb();
                    }
                    if (i26 > bArr.length - iZza18) {
                        throw zzfo.zza();
                    }
                    if (i26 == 0) {
                        zzflVar.add(zzdu.zza);
                    } else {
                        zzflVar.add(zzdu.zza(bArr, iZza18, i26));
                        iZza18 += i26;
                    }
                    while (iZza18 < i2) {
                        int iZza19 = zzdq.zza(bArr, iZza18, zzdtVar);
                        if (i3 != zzdtVar.zza) {
                            return iZza18;
                        }
                        iZza18 = zzdq.zza(bArr, iZza19, zzdtVar);
                        int i27 = zzdtVar.zza;
                        if (i27 < 0) {
                            throw zzfo.zzb();
                        }
                        if (i27 > bArr.length - iZza18) {
                            throw zzfo.zza();
                        }
                        if (i27 == 0) {
                            zzflVar.add(zzdu.zza);
                        } else {
                            zzflVar.add(zzdu.zza(bArr, iZza18, i27));
                            iZza18 += i27;
                        }
                    }
                    return iZza18;
                }
                return i8;
            case 30:
            case 44:
                i9 = i;
                if (i5 != 2) {
                    if (i5 == 0) {
                        iZza = zzdq.zza(i3, bArr, i9, i2, (zzfl<?>) zzflVar, zzdtVar);
                    }
                    return i9;
                }
                iZza = zzdq.zza(bArr, i9, (zzfl<?>) zzflVar, zzdtVar);
                zzfd zzfdVar = (zzfd) t;
                zzhy zzhyVar = zzfdVar.zzb;
                if (zzhyVar == zzhy.zza()) {
                    zzhyVar = null;
                }
                zzhy zzhyVar2 = (zzhy) zzhf.zza(i4, zzflVar, zzc(i6), zzhyVar, this.zzq);
                if (zzhyVar2 != null) {
                    zzfdVar.zzb = zzhyVar2;
                }
                return iZza;
            case 33:
            case 47:
                i9 = i;
                if (i5 == 2) {
                    zzfg zzfgVar3 = (zzfg) zzflVar;
                    int iZza20 = zzdq.zza(bArr, i9, zzdtVar);
                    int i28 = zzdtVar.zza + iZza20;
                    while (iZza20 < i28) {
                        iZza20 = zzdq.zza(bArr, iZza20, zzdtVar);
                        zzfgVar3.zzd(zzeg.zze(zzdtVar.zza));
                    }
                    if (iZza20 == i28) {
                        return iZza20;
                    }
                    throw zzfo.zza();
                }
                if (i5 == 0) {
                    zzfg zzfgVar4 = (zzfg) zzflVar;
                    int iZza21 = zzdq.zza(bArr, i9, zzdtVar);
                    zzfgVar4.zzd(zzeg.zze(zzdtVar.zza));
                    while (iZza21 < i2) {
                        int iZza22 = zzdq.zza(bArr, iZza21, zzdtVar);
                        if (i3 != zzdtVar.zza) {
                            return iZza21;
                        }
                        iZza21 = zzdq.zza(bArr, iZza22, zzdtVar);
                        zzfgVar4.zzd(zzeg.zze(zzdtVar.zza));
                    }
                    return iZza21;
                }
                return i9;
            case 34:
            case 48:
                i9 = i;
                if (i5 == 2) {
                    zzgc zzgcVar5 = (zzgc) zzflVar;
                    int iZza23 = zzdq.zza(bArr, i9, zzdtVar);
                    int i29 = zzdtVar.zza + iZza23;
                    while (iZza23 < i29) {
                        iZza23 = zzdq.zzb(bArr, iZza23, zzdtVar);
                        zzgcVar5.zza(zzeg.zza(zzdtVar.zzb));
                    }
                    if (iZza23 == i29) {
                        return iZza23;
                    }
                    throw zzfo.zza();
                }
                if (i5 == 0) {
                    zzgc zzgcVar6 = (zzgc) zzflVar;
                    int iZzb3 = zzdq.zzb(bArr, i9, zzdtVar);
                    zzgcVar6.zza(zzeg.zza(zzdtVar.zzb));
                    while (iZzb3 < i2) {
                        int iZza24 = zzdq.zza(bArr, iZzb3, zzdtVar);
                        if (i3 != zzdtVar.zza) {
                            return iZzb3;
                        }
                        iZzb3 = zzdq.zzb(bArr, iZza24, zzdtVar);
                        zzgcVar6.zza(zzeg.zza(zzdtVar.zzb));
                    }
                    return iZzb3;
                }
                return i9;
            case 49:
                if (i5 == 3) {
                    zzhd zzhdVarZza = zza(i6);
                    int i30 = (i3 & (-8)) | 4;
                    int iZza25 = zzdq.zza(zzhdVarZza, bArr, i, i2, i30, zzdtVar);
                    byte[] bArr2 = bArr;
                    int i31 = i2;
                    int i32 = i30;
                    zzdt zzdtVar2 = zzdtVar;
                    zzflVar.add(zzdtVar2.zzc);
                    while (iZza25 < i31) {
                        int iZza26 = zzdq.zza(bArr2, iZza25, zzdtVar2);
                        if (i3 != zzdtVar2.zza) {
                            return iZza25;
                        }
                        byte[] bArr3 = bArr2;
                        int i33 = i32;
                        int i34 = i31;
                        zzdt zzdtVar3 = zzdtVar2;
                        iZza25 = zzdq.zza(zzhdVarZza, bArr3, iZza26, i34, i33, zzdtVar3);
                        zzflVar.add(zzdtVar3.zzc);
                        i32 = i33;
                        bArr2 = bArr3;
                        i31 = i34;
                        zzdtVar2 = zzdtVar3;
                    }
                    return iZza25;
                }
            default:
                return i;
        }
    }

    private final <K, V> int zza(T t, byte[] bArr, int i, int i2, int i3, long j, zzdt zzdtVar) throws IOException {
        byte[] bArr2;
        zzdt zzdtVar2;
        int i4;
        Unsafe unsafe = zzb;
        Object objZzb = zzb(i3);
        Object object = unsafe.getObject(t, j);
        if (this.zzs.zzc(object)) {
            Object objZze = this.zzs.zze(objZzb);
            this.zzs.zza(objZze, object);
            unsafe.putObject(t, j, objZze);
            object = objZze;
        }
        zzgf<?, ?> zzgfVarZzf = this.zzs.zzf(objZzb);
        Map<?, ?> mapZza = this.zzs.zza(object);
        int iZza = zzdq.zza(bArr, i, zzdtVar);
        int i5 = zzdtVar.zza;
        if (i5 < 0 || i5 > i2 - iZza) {
            throw zzfo.zza();
        }
        int i6 = i5 + iZza;
        K k = zzgfVarZzf.zzb;
        V v = zzgfVarZzf.zzd;
        while (iZza < i6) {
            int iZza2 = iZza + 1;
            int i7 = bArr[iZza];
            if (i7 < 0) {
                iZza2 = zzdq.zza(i7, bArr, iZza2, zzdtVar);
                i7 = zzdtVar.zza;
            }
            int i8 = iZza2;
            int i9 = i7 >>> 3;
            int i10 = i7 & 7;
            if (i9 == 1) {
                bArr2 = bArr;
                int i11 = i2;
                zzdtVar2 = zzdtVar;
                if (i10 == zzgfVarZzf.zza.zzb()) {
                    i4 = i11;
                    iZza = zza(bArr2, i8, i4, zzgfVarZzf.zza, (Class<?>) null, zzdtVar2);
                    k = zzdtVar2.zzc;
                } else {
                    i4 = i11;
                }
                bArr = bArr2;
                i2 = i4;
                zzdtVar = zzdtVar2;
            } else if (i9 == 2 && i10 == zzgfVarZzf.zzc.zzb()) {
                byte[] bArr3 = bArr;
                int i12 = i2;
                zzdt zzdtVar3 = zzdtVar;
                iZza = zza(bArr3, i8, i12, zzgfVarZzf.zzc, zzgfVarZzf.zzd.getClass(), zzdtVar3);
                v = (V) zzdtVar3.zzc;
                i2 = i12;
                bArr = bArr3;
            } else {
                bArr2 = bArr;
                i4 = i2;
                zzdtVar2 = zzdtVar;
            }
            iZza = zzdq.zza(i7, bArr2, i8, i4, zzdtVar2);
            k = k;
            bArr = bArr2;
            i2 = i4;
            zzdtVar = zzdtVar2;
        }
        if (iZza != i6) {
            throw zzfo.zzg();
        }
        mapZza.put(k, v);
        return i6;
    }

    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzdt zzdtVar) throws IOException {
        int i9;
        int i10;
        int iZzb;
        Object object;
        Unsafe unsafe = zzb;
        long j2 = this.zzc[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                i9 = i;
                if (i5 != 1) {
                    return i9;
                }
                unsafe.putObject(t, j, Double.valueOf(zzdq.zzc(bArr, i)));
                iZzb = i9 + 8;
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 52:
                i10 = i;
                if (i5 != 5) {
                    return i10;
                }
                unsafe.putObject(t, j, Float.valueOf(zzdq.zzd(bArr, i)));
                iZzb = i10 + 4;
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 53:
            case 54:
                if (i5 != 0) {
                    return i;
                }
                iZzb = zzdq.zzb(bArr, i, zzdtVar);
                unsafe.putObject(t, j, Long.valueOf(zzdtVar.zzb));
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 55:
            case 62:
                if (i5 != 0) {
                    return i;
                }
                iZzb = zzdq.zza(bArr, i, zzdtVar);
                unsafe.putObject(t, j, Integer.valueOf(zzdtVar.zza));
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 56:
            case 65:
                i9 = i;
                if (i5 != 1) {
                    return i9;
                }
                unsafe.putObject(t, j, Long.valueOf(zzdq.zzb(bArr, i)));
                iZzb = i9 + 8;
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 57:
            case 64:
                i10 = i;
                if (i5 != 5) {
                    return i10;
                }
                unsafe.putObject(t, j, Integer.valueOf(zzdq.zza(bArr, i)));
                iZzb = i10 + 4;
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 58:
                if (i5 != 0) {
                    return i;
                }
                iZzb = zzdq.zzb(bArr, i, zzdtVar);
                unsafe.putObject(t, j, Boolean.valueOf(zzdtVar.zzb != 0));
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 59:
                if (i5 != 2) {
                    return i;
                }
                int iZza = zzdq.zza(bArr, i, zzdtVar);
                int i11 = zzdtVar.zza;
                if (i11 == 0) {
                    unsafe.putObject(t, j, "");
                } else {
                    if ((i6 & C.BUFFER_FLAG_LAST_SAMPLE) != 0 && !zzie.zza(bArr, iZza, iZza + i11)) {
                        throw zzfo.zzh();
                    }
                    unsafe.putObject(t, j, new String(bArr, iZza, i11, zzff.zza));
                    iZza += i11;
                }
                unsafe.putInt(t, j2, i4);
                return iZza;
            case 60:
                if (i5 != 2) {
                    return i;
                }
                int iZza2 = zzdq.zza(zza(i8), bArr, i, i2, zzdtVar);
                object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                if (object == null) {
                    unsafe.putObject(t, j, zzdtVar.zzc);
                } else {
                    unsafe.putObject(t, j, zzff.zza(object, zzdtVar.zzc));
                }
                unsafe.putInt(t, j2, i4);
                return iZza2;
            case 61:
                if (i5 != 2) {
                    return i;
                }
                iZzb = zzdq.zze(bArr, i, zzdtVar);
                unsafe.putObject(t, j, zzdtVar.zzc);
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 63:
                if (i5 != 0) {
                    return i;
                }
                int iZza3 = zzdq.zza(bArr, i, zzdtVar);
                int i12 = zzdtVar.zza;
                zzfk zzfkVarZzc = zzc(i8);
                if (zzfkVarZzc == null || zzfkVarZzc.zza(i12)) {
                    unsafe.putObject(t, j, Integer.valueOf(i12));
                    iZzb = iZza3;
                    unsafe.putInt(t, j2, i4);
                    return iZzb;
                }
                zze(t).zza(i3, Long.valueOf(i12));
                return iZza3;
            case 66:
                if (i5 != 0) {
                    return i;
                }
                iZzb = zzdq.zza(bArr, i, zzdtVar);
                unsafe.putObject(t, j, Integer.valueOf(zzeg.zze(zzdtVar.zza)));
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 67:
                if (i5 != 0) {
                    return i;
                }
                iZzb = zzdq.zzb(bArr, i, zzdtVar);
                unsafe.putObject(t, j, Long.valueOf(zzeg.zza(zzdtVar.zzb)));
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 68:
                if (i5 == 3) {
                    iZzb = zzdq.zza(zza(i8), bArr, i, i2, (i3 & (-8)) | 4, zzdtVar);
                    object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object == null) {
                        unsafe.putObject(t, j, zzdtVar.zzc);
                    } else {
                        unsafe.putObject(t, j, zzff.zza(object, zzdtVar.zzc));
                    }
                    unsafe.putInt(t, j2, i4);
                    return iZzb;
                }
            default:
                return i;
        }
    }

    private final zzhd zza(int i) {
        int i2 = (i / 3) << 1;
        zzhd zzhdVar = (zzhd) this.zzd[i2];
        if (zzhdVar != null) {
            return zzhdVar;
        }
        zzhd<T> zzhdVarZza = zzgz.zza().zza((Class) this.zzd[i2 + 1]);
        this.zzd[i2] = zzhdVarZza;
        return zzhdVarZza;
    }

    private final Object zzb(int i) {
        return this.zzd[(i / 3) << 1];
    }

    private final zzfk zzc(int i) {
        return (zzfk) this.zzd[((i / 3) << 1) + 1];
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 12221. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    final int zza(T r27, byte[] r28, int r29, int r30, int r31, com.google.android.gms.internal.measurement.zzdt r32) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgs.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzdt):int");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:19:0x005b. Please report as an issue. */
    @Override // com.google.android.gms.internal.measurement.zzhd
    public final void zza(T t, byte[] bArr, int i, int i2, zzdt zzdtVar) throws IOException {
        int iZzg;
        Unsafe unsafe;
        int i3;
        int i4;
        int i5;
        boolean z;
        Unsafe unsafe2;
        boolean z2;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z3;
        boolean z4;
        int iZzb;
        T t2;
        this = this;
        bArr = bArr;
        i2 = i2;
        zzdtVar = zzdtVar;
        if (this.zzj) {
            Unsafe unsafe3 = zzb;
            int i10 = -1;
            int iZza = i;
            int i11 = -1;
            int i12 = 0;
            while (iZza < i2) {
                int iZza2 = iZza + 1;
                int i13 = bArr[iZza];
                if (i13 < 0) {
                    iZza2 = zzdq.zza(i13, bArr, iZza2, zzdtVar);
                    i13 = zzdtVar.zza;
                }
                int i14 = iZza2;
                int i15 = i13;
                int i16 = (i15 == true ? 1 : 0) >>> 3;
                int i17 = (i15 == true ? 1 : 0) & 7;
                if (i16 > i11) {
                    iZzg = this.zza(i16, i12 / 3);
                } else {
                    iZzg = this.zzg(i16);
                }
                int i18 = iZzg;
                if (i18 == i10) {
                    unsafe = unsafe3;
                    i3 = i14;
                    i4 = i16;
                    i5 = 0;
                    z = i15 == true ? 1 : 0;
                } else {
                    int i19 = this.zzc[i18 + 1];
                    int i20 = (267386880 & i19) >>> 20;
                    long j = 1048575 & i19;
                    if (i20 <= 17) {
                        switch (i20) {
                            case 0:
                                unsafe2 = unsafe3;
                                if (i17 != 1) {
                                    unsafe = unsafe2;
                                    i9 = i14;
                                    i8 = i16;
                                    i7 = i18;
                                    z4 = i15 == true ? 1 : 0;
                                    i3 = i9;
                                    i5 = i7;
                                    z3 = z4;
                                } else {
                                    zzib.zza(t, j, zzdq.zzc(bArr, i14));
                                    iZza = i14 + 8;
                                    unsafe3 = unsafe2;
                                    i11 = i16;
                                    i12 = i18;
                                    i10 = -1;
                                }
                                break;
                            case 1:
                                unsafe2 = unsafe3;
                                if (i17 != 5) {
                                    unsafe = unsafe2;
                                    i9 = i14;
                                    i8 = i16;
                                    i7 = i18;
                                    z4 = i15 == true ? 1 : 0;
                                    i3 = i9;
                                    i5 = i7;
                                    z3 = z4;
                                } else {
                                    zzib.zza((Object) t, j, zzdq.zzd(bArr, i14));
                                    iZza = i14 + 4;
                                    unsafe3 = unsafe2;
                                    i11 = i16;
                                    i12 = i18;
                                    i10 = -1;
                                }
                                break;
                            case 2:
                            case 3:
                                unsafe2 = unsafe3;
                                if (i17 != 0) {
                                    unsafe = unsafe2;
                                    i9 = i14;
                                    i8 = i16;
                                    i7 = i18;
                                    z4 = i15 == true ? 1 : 0;
                                    i3 = i9;
                                    i5 = i7;
                                    z3 = z4;
                                } else {
                                    iZzb = zzdq.zzb(bArr, i14, zzdtVar);
                                    t2 = t;
                                    unsafe3 = unsafe2;
                                    unsafe3.putLong(t2, j, zzdtVar.zzb);
                                    unsafe3 = unsafe3;
                                    iZza = iZzb;
                                    i11 = i16;
                                    i12 = i18;
                                    i10 = -1;
                                }
                                break;
                            case 4:
                            case 11:
                                unsafe2 = unsafe3;
                                if (i17 != 0) {
                                    unsafe = unsafe2;
                                    i9 = i14;
                                    i8 = i16;
                                    i7 = i18;
                                    z4 = i15 == true ? 1 : 0;
                                    i3 = i9;
                                    i5 = i7;
                                    z3 = z4;
                                } else {
                                    iZza = zzdq.zza(bArr, i14, zzdtVar);
                                    unsafe2.putInt(t, j, zzdtVar.zza);
                                    unsafe3 = unsafe2;
                                    i11 = i16;
                                    i12 = i18;
                                    i10 = -1;
                                }
                                break;
                            case 5:
                            case 14:
                                unsafe2 = unsafe3;
                                if (i17 != 1) {
                                    unsafe = unsafe2;
                                    i9 = i14;
                                    i8 = i16;
                                    i7 = i18;
                                    z4 = i15 == true ? 1 : 0;
                                    i3 = i9;
                                    i5 = i7;
                                    z3 = z4;
                                } else {
                                    unsafe2.putLong(t, j, zzdq.zzb(bArr, i14));
                                    unsafe2 = unsafe2;
                                    iZza = i14 + 8;
                                    unsafe3 = unsafe2;
                                    i11 = i16;
                                    i12 = i18;
                                    i10 = -1;
                                }
                                break;
                            case 6:
                            case 13:
                                unsafe2 = unsafe3;
                                if (i17 != 5) {
                                    unsafe = unsafe2;
                                    i9 = i14;
                                    i8 = i16;
                                    i7 = i18;
                                    z4 = i15 == true ? 1 : 0;
                                    i3 = i9;
                                    i5 = i7;
                                    z3 = z4;
                                } else {
                                    unsafe2.putInt(t, j, zzdq.zza(bArr, i14));
                                    iZza = i14 + 4;
                                    unsafe3 = unsafe2;
                                    i11 = i16;
                                    i12 = i18;
                                    i10 = -1;
                                }
                                break;
                            case 7:
                                unsafe2 = unsafe3;
                                if (i17 != 0) {
                                    unsafe = unsafe2;
                                    i9 = i14;
                                    i8 = i16;
                                    i7 = i18;
                                    z4 = i15 == true ? 1 : 0;
                                    i3 = i9;
                                    i5 = i7;
                                    z3 = z4;
                                } else {
                                    int iZzb2 = zzdq.zzb(bArr, i14, zzdtVar);
                                    zzib.zza(t, j, zzdtVar.zzb != 0);
                                    iZza = iZzb2;
                                    unsafe3 = unsafe2;
                                    i11 = i16;
                                    i12 = i18;
                                    i10 = -1;
                                }
                                break;
                            case 8:
                                unsafe2 = unsafe3;
                                if (i17 != 2) {
                                    unsafe = unsafe2;
                                    i9 = i14;
                                    i8 = i16;
                                    i7 = i18;
                                    z4 = i15 == true ? 1 : 0;
                                    i3 = i9;
                                    i5 = i7;
                                    z3 = z4;
                                } else {
                                    if ((536870912 & i19) == 0) {
                                        iZza = zzdq.zzc(bArr, i14, zzdtVar);
                                    } else {
                                        iZza = zzdq.zzd(bArr, i14, zzdtVar);
                                    }
                                    unsafe2.putObject(t, j, zzdtVar.zzc);
                                    unsafe3 = unsafe2;
                                    i11 = i16;
                                    i12 = i18;
                                    i10 = -1;
                                }
                                break;
                            case 9:
                                unsafe2 = unsafe3;
                                if (i17 != 2) {
                                    unsafe = unsafe2;
                                    i9 = i14;
                                    i8 = i16;
                                    i7 = i18;
                                    z4 = i15 == true ? 1 : 0;
                                    i3 = i9;
                                    i5 = i7;
                                    z3 = z4;
                                } else {
                                    iZza = zzdq.zza(this.zza(i18), bArr, i14, i2, zzdtVar);
                                    Object object = unsafe2.getObject(t, j);
                                    if (object == null) {
                                        unsafe2.putObject(t, j, zzdtVar.zzc);
                                    } else {
                                        unsafe2.putObject(t, j, zzff.zza(object, zzdtVar.zzc));
                                    }
                                    unsafe3 = unsafe2;
                                    i11 = i16;
                                    i12 = i18;
                                    i10 = -1;
                                }
                                break;
                            case 10:
                                unsafe2 = unsafe3;
                                if (i17 != 2) {
                                    unsafe = unsafe2;
                                    i9 = i14;
                                    i8 = i16;
                                    i7 = i18;
                                    z4 = i15 == true ? 1 : 0;
                                    i3 = i9;
                                    i5 = i7;
                                    z3 = z4;
                                } else {
                                    iZza = zzdq.zze(bArr, i14, zzdtVar);
                                    unsafe2.putObject(t, j, zzdtVar.zzc);
                                    unsafe3 = unsafe2;
                                    i11 = i16;
                                    i12 = i18;
                                    i10 = -1;
                                }
                                break;
                            case 12:
                                unsafe2 = unsafe3;
                                if (i17 != 0) {
                                    unsafe = unsafe2;
                                    i9 = i14;
                                    i8 = i16;
                                    i7 = i18;
                                    z4 = i15 == true ? 1 : 0;
                                    i3 = i9;
                                    i5 = i7;
                                    z3 = z4;
                                } else {
                                    iZza = zzdq.zza(bArr, i14, zzdtVar);
                                    unsafe2.putInt(t, j, zzdtVar.zza);
                                    unsafe3 = unsafe2;
                                    i11 = i16;
                                    i12 = i18;
                                    i10 = -1;
                                }
                                break;
                            case 15:
                                unsafe2 = unsafe3;
                                if (i17 != 0) {
                                    unsafe = unsafe2;
                                    i9 = i14;
                                    i8 = i16;
                                    i7 = i18;
                                    z4 = i15 == true ? 1 : 0;
                                    i3 = i9;
                                    i5 = i7;
                                    z3 = z4;
                                } else {
                                    iZza = zzdq.zza(bArr, i14, zzdtVar);
                                    unsafe2.putInt(t, j, zzeg.zze(zzdtVar.zza));
                                    unsafe3 = unsafe2;
                                    i11 = i16;
                                    i12 = i18;
                                    i10 = -1;
                                }
                                break;
                            case 16:
                                if (i17 != 0) {
                                    unsafe2 = unsafe3;
                                    unsafe = unsafe2;
                                    i9 = i14;
                                    i8 = i16;
                                    i7 = i18;
                                    z4 = i15 == true ? 1 : 0;
                                    i3 = i9;
                                    i5 = i7;
                                    z3 = z4;
                                } else {
                                    iZzb = zzdq.zzb(bArr, i14, zzdtVar);
                                    t2 = t;
                                    unsafe3.putLong(t2, j, zzeg.zza(zzdtVar.zzb));
                                    unsafe3 = unsafe3;
                                    iZza = iZzb;
                                    i11 = i16;
                                    i12 = i18;
                                    i10 = -1;
                                }
                                break;
                            default:
                                unsafe2 = unsafe3;
                                unsafe = unsafe2;
                                i9 = i14;
                                i8 = i16;
                                i7 = i18;
                                z4 = i15 == true ? 1 : 0;
                                i3 = i9;
                                i5 = i7;
                                z3 = z4;
                                break;
                        }
                    } else {
                        unsafe2 = unsafe3;
                        if (i20 != 27) {
                            unsafe = unsafe2;
                            if (i20 <= 49) {
                                int iZza3 = this.zza(t, bArr, i14, i2, i15 == true ? 1 : 0, i16, i17, i18, i19, i20, j, zzdtVar);
                                z2 = i15 == true ? 1 : 0;
                                i6 = i18;
                                if (iZza3 == i14) {
                                    i3 = iZza3;
                                    i4 = i16;
                                    i5 = i6;
                                    z = z2;
                                } else {
                                    i2 = i2;
                                    i12 = i6;
                                    iZza = iZza3;
                                    i11 = i16;
                                }
                            } else {
                                i7 = i18;
                                i8 = i16;
                                boolean z5 = i15 == true ? 1 : 0;
                                if (i20 != 50) {
                                    i4 = i8;
                                    int iZza4 = zza(t, bArr, i14, i2, z5 ? 1 : 0, i4, i17, i19, i20, j, i7, zzdtVar);
                                    z2 = z5 ? 1 : 0;
                                    i6 = i7;
                                    if (iZza4 == i14) {
                                        i3 = iZza4;
                                        i5 = i6;
                                        z = z2;
                                    } else {
                                        i2 = i2;
                                        i12 = i6;
                                        i11 = i4;
                                        iZza = iZza4;
                                    }
                                } else if (i17 == 2) {
                                    int iZza5 = zza(t, bArr, i14, i2, i7, j, zzdtVar);
                                    if (iZza5 == i14) {
                                        i5 = i7;
                                        i3 = iZza5;
                                        z3 = z5;
                                    } else {
                                        this = this;
                                        i12 = i7;
                                        iZza = iZza5;
                                        i11 = i8;
                                    }
                                } else {
                                    i9 = i14;
                                    z4 = z5;
                                    i3 = i9;
                                    i5 = i7;
                                    z3 = z4;
                                }
                            }
                            unsafe3 = unsafe;
                            i10 = -1;
                            bArr = bArr;
                        } else if (i17 == 2) {
                            zzfl zzflVarZza = (zzfl) unsafe2.getObject(t, j);
                            if (!zzflVarZza.zza()) {
                                int size = zzflVarZza.size();
                                zzflVarZza = zzflVarZza.zza(size == 0 ? 10 : size << 1);
                                unsafe2.putObject(t, j, zzflVarZza);
                            }
                            unsafe = unsafe2;
                            iZza = zzdq.zza(this.zza(i18), i15 == true ? 1 : 0, bArr, i14, i2, zzflVarZza, zzdtVar);
                            i11 = i16;
                            i12 = i18;
                        } else {
                            unsafe = unsafe2;
                            i9 = i14;
                            i8 = i16;
                            i7 = i18;
                            z4 = i15 == true ? 1 : 0;
                            i3 = i9;
                            i5 = i7;
                            z3 = z4;
                        }
                        unsafe3 = unsafe;
                        i10 = -1;
                    }
                    i4 = i8;
                    z = z3;
                }
                iZza = zzdq.zza(z ? 1 : 0, bArr, i3, i2, zze(t), zzdtVar);
                i2 = i2;
                i11 = i4;
                i12 = i5;
                unsafe3 = unsafe;
                i10 = -1;
                bArr = bArr;
            }
            if (iZza != i2) {
                throw zzfo.zzg();
            }
            return;
        }
        zza(t, bArr, i, i2, 0, zzdtVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzhd
    public final void zzc(T t) {
        int i;
        int i2 = this.zzm;
        while (true) {
            i = this.zzn;
            if (i2 >= i) {
                break;
            }
            long jZzd = zzd(this.zzl[i2]) & 1048575;
            Object objZzf = zzib.zzf(t, jZzd);
            if (objZzf != null) {
                zzib.zza(t, jZzd, this.zzs.zzd(objZzf));
            }
            i2++;
        }
        int length = this.zzl.length;
        while (i < length) {
            this.zzp.zzb(t, this.zzl[i]);
            i++;
        }
        this.zzq.zzd(t);
        if (this.zzh) {
            this.zzr.zzc(t);
        }
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzhv<UT, UB> zzhvVar) {
        zzfk zzfkVarZzc;
        int i2 = this.zzc[i];
        Object objZzf = zzib.zzf(obj, zzd(i) & 1048575);
        return (objZzf == null || (zzfkVarZzc = zzc(i)) == null) ? ub : (UB) zza(i, i2, this.zzs.zza(objZzf), zzfkVarZzc, ub, zzhvVar);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzfk zzfkVar, UB ub, zzhv<UT, UB> zzhvVar) {
        zzgf<?, ?> zzgfVarZzf = this.zzs.zzf(zzb(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzfkVar.zza(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzhvVar.zza();
                }
                zzec zzecVarZzc = zzdu.zzc(zzgg.zza(zzgfVarZzf, next.getKey(), next.getValue()));
                try {
                    zzgg.zza(zzecVarZzc.zzb(), zzgfVarZzf, next.getKey(), next.getValue());
                    zzhvVar.zza(ub, i2, zzecVarZzc.zza());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:51:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:54:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:57:0x00e7 A[LOOP:2: B:52:0x00d6->B:57:0x00e7, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:74:0x00e6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x00fb A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.google.android.gms.internal.measurement.zzhd] */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18, types: [com.google.android.gms.internal.measurement.zzhd] */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    @Override // com.google.android.gms.internal.measurement.zzhd
    public final boolean zzd(T t) {
        int i;
        List list;
        ?? Zza;
        int i2;
        int i3 = -1;
        int i4 = 0;
        for (int i5 = 0; i5 < this.zzm; i5++) {
            int i6 = this.zzl[i5];
            int i7 = this.zzc[i6];
            int iZzd = zzd(i6);
            if (this.zzj) {
                i = 0;
            } else {
                int i8 = this.zzc[i6 + 2];
                int i9 = i8 & 1048575;
                i = 1 << (i8 >>> 20);
                if (i9 != i3) {
                    i4 = zzb.getInt(t, i9);
                    i3 = i9;
                }
            }
            if ((268435456 & iZzd) != 0 && !zza(t, i6, i4, i)) {
                return false;
            }
            int i10 = (267386880 & iZzd) >>> 20;
            if (i10 == 9 || i10 == 17) {
                if (zza(t, i6, i4, i) && !zza(t, iZzd, zza(i6))) {
                    return false;
                }
            } else if (i10 == 27) {
                list = (List) zzib.zzf(t, iZzd & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    Zza = zza(i6);
                    for (i2 = 0; i2 < list.size(); i2++) {
                        if (!Zza.zzd(list.get(i2))) {
                            return false;
                        }
                    }
                }
            } else if (i10 == 60 || i10 == 68) {
                if (zza(t, i7, i6) && !zza(t, iZzd, zza(i6))) {
                    return false;
                }
            } else if (i10 == 49) {
                list = (List) zzib.zzf(t, iZzd & 1048575);
                if (list.isEmpty()) {
                    Zza = zza(i6);
                    while (i2 < list.size()) {
                        if (!Zza.zzd(list.get(i2))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (i10 != 50) {
                continue;
            } else {
                Map<?, ?> mapZzb = this.zzs.zzb(zzib.zzf(t, iZzd & 1048575));
                if (mapZzb.isEmpty()) {
                    continue;
                } else if (this.zzs.zzf(zzb(i6)).zzc.zza() == zzip.MESSAGE) {
                    ?? Zza2 = 0;
                    for (Object obj : mapZzb.values()) {
                        if (Zza2 == 0) {
                            Zza2 = Zza2;
                            Zza2 = zzgz.zza().zza((Class) obj.getClass());
                        }
                        Zza2 = Zza2;
                        if (!Zza2.zzd(obj)) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            }
        }
        return !this.zzh || this.zzr.zza(t).zzf();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zzhd zzhdVar) {
        return zzhdVar.zzd(zzib.zzf(obj, i & 1048575));
    }

    private static void zza(int i, Object obj, zzis zzisVar) throws IOException {
        if (obj instanceof String) {
            zzisVar.zza(i, (String) obj);
        } else {
            zzisVar.zza(i, (zzdu) obj);
        }
    }

    private final void zza(Object obj, int i, zzhe zzheVar) throws IOException {
        if (zzf(i)) {
            zzib.zza(obj, i & 1048575, zzheVar.zzm());
        } else if (this.zzi) {
            zzib.zza(obj, i & 1048575, zzheVar.zzl());
        } else {
            zzib.zza(obj, i & 1048575, zzheVar.zzn());
        }
    }

    private final int zzd(int i) {
        return this.zzc[i + 1];
    }

    private final int zze(int i) {
        return this.zzc[i + 2];
    }

    private static <T> double zzb(T t, long j) {
        return ((Double) zzib.zzf(t, j)).doubleValue();
    }

    private static <T> float zzc(T t, long j) {
        return ((Float) zzib.zzf(t, j)).floatValue();
    }

    private static <T> int zzd(T t, long j) {
        return ((Integer) zzib.zzf(t, j)).intValue();
    }

    private static <T> long zze(T t, long j) {
        return ((Long) zzib.zzf(t, j)).longValue();
    }

    private static <T> boolean zzf(T t, long j) {
        return ((Boolean) zzib.zzf(t, j)).booleanValue();
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza((Object) t, i) == zza((Object) t2, i);
    }

    private final boolean zza(T t, int i, int i2, int i3) {
        if (this.zzj) {
            return zza((Object) t, i);
        }
        return (i2 & i3) != 0;
    }

    private final boolean zza(T t, int i) {
        if (this.zzj) {
            int iZzd = zzd(i);
            long j = iZzd & 1048575;
            switch ((iZzd & 267386880) >>> 20) {
                case 0:
                    return zzib.zze(t, j) != 0.0d;
                case 1:
                    return zzib.zzd(t, j) != 0.0f;
                case 2:
                    return zzib.zzb(t, j) != 0;
                case 3:
                    return zzib.zzb(t, j) != 0;
                case 4:
                    return zzib.zza(t, j) != 0;
                case 5:
                    return zzib.zzb(t, j) != 0;
                case 6:
                    return zzib.zza(t, j) != 0;
                case 7:
                    return zzib.zzc(t, j);
                case 8:
                    Object objZzf = zzib.zzf(t, j);
                    if (objZzf instanceof String) {
                        return !((String) objZzf).isEmpty();
                    }
                    if (objZzf instanceof zzdu) {
                        return !zzdu.zza.equals(objZzf);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzib.zzf(t, j) != null;
                case 10:
                    return !zzdu.zza.equals(zzib.zzf(t, j));
                case 11:
                    return zzib.zza(t, j) != 0;
                case 12:
                    return zzib.zza(t, j) != 0;
                case 13:
                    return zzib.zza(t, j) != 0;
                case 14:
                    return zzib.zzb(t, j) != 0;
                case 15:
                    return zzib.zza(t, j) != 0;
                case 16:
                    return zzib.zzb(t, j) != 0;
                case 17:
                    return zzib.zzf(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        }
        int iZze = zze(i);
        return (zzib.zza(t, (long) (iZze & 1048575)) & (1 << (iZze >>> 20))) != 0;
    }

    private final void zzb(T t, int i) {
        if (this.zzj) {
            return;
        }
        int iZze = zze(i);
        long j = iZze & 1048575;
        zzib.zza((Object) t, j, zzib.zza(t, j) | (1 << (iZze >>> 20)));
    }

    private final boolean zza(T t, int i, int i2) {
        return zzib.zza(t, (long) (zze(i2) & 1048575)) == i;
    }

    private final void zzb(T t, int i, int i2) {
        zzib.zza((Object) t, zze(i2) & 1048575, i);
    }

    private final int zzg(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzb(i, 0);
    }

    private final int zza(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzb(i, i2);
    }

    private final int zzb(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }
}
