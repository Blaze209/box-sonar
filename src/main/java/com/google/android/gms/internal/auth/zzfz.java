package com.google.android.gms.internal.auth;

import androidx.media3.common.C;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
/* JADX INFO: loaded from: classes13.dex */
final class zzfz<T> implements zzgh<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzhi.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzfw zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzfk zzl;
    private final zzgy zzm;
    private final zzel zzn;
    private final zzgb zzo;
    private final zzfr zzp;

    private zzfz(int[] iArr, Object[] objArr, int i, int i2, zzfw zzfwVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzgb zzgbVar, zzfk zzfkVar, zzgy zzgyVar, zzel zzelVar, zzfr zzfrVar, byte[] bArr) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzh = z;
        this.zzi = iArr2;
        this.zzj = i3;
        this.zzk = i4;
        this.zzo = zzgbVar;
        this.zzl = zzfkVar;
        this.zzm = zzgyVar;
        this.zzn = zzelVar;
        this.zzg = zzfwVar;
        this.zzp = zzfrVar;
    }

    private static Field zzA(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private final void zzB(Object obj, Object obj2, int i) {
        long jZzv = zzv(i) & 1048575;
        if (zzG(obj2, i)) {
            Object objZzf = zzhi.zzf(obj, jZzv);
            Object objZzf2 = zzhi.zzf(obj2, jZzv);
            if (objZzf != null && objZzf2 != null) {
                zzhi.zzp(obj, jZzv, zzez.zzg(objZzf, objZzf2));
                zzD(obj, i);
            } else if (objZzf2 != null) {
                zzhi.zzp(obj, jZzv, objZzf2);
                zzD(obj, i);
            }
        }
    }

    private final void zzC(Object obj, Object obj2, int i) {
        int iZzv = zzv(i);
        int i2 = this.zzc[i];
        long j = iZzv & 1048575;
        if (zzJ(obj2, i2, i)) {
            Object objZzf = zzJ(obj, i2, i) ? zzhi.zzf(obj, j) : null;
            Object objZzf2 = zzhi.zzf(obj2, j);
            if (objZzf != null && objZzf2 != null) {
                zzhi.zzp(obj, j, zzez.zzg(objZzf, objZzf2));
                zzE(obj, i2, i);
            } else if (objZzf2 != null) {
                zzhi.zzp(obj, j, objZzf2);
                zzE(obj, i2, i);
            }
        }
    }

    private final void zzD(Object obj, int i) {
        int iZzs = zzs(i);
        long j = 1048575 & iZzs;
        if (j == 1048575) {
            return;
        }
        zzhi.zzn(obj, j, (1 << (iZzs >>> 20)) | zzhi.zzc(obj, j));
    }

    private final void zzE(Object obj, int i, int i2) {
        zzhi.zzn(obj, zzs(i2) & 1048575, i);
    }

    private final boolean zzF(Object obj, Object obj2, int i) {
        return zzG(obj, i) == zzG(obj2, i);
    }

    private final boolean zzG(Object obj, int i) {
        int iZzs = zzs(i);
        long j = iZzs & 1048575;
        if (j != 1048575) {
            return (zzhi.zzc(obj, j) & (1 << (iZzs >>> 20))) != 0;
        }
        int iZzv = zzv(i);
        long j2 = iZzv & 1048575;
        switch (zzu(iZzv)) {
            case 0:
                return Double.doubleToRawLongBits(zzhi.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzhi.zzb(obj, j2)) != 0;
            case 2:
                return zzhi.zzd(obj, j2) != 0;
            case 3:
                return zzhi.zzd(obj, j2) != 0;
            case 4:
                return zzhi.zzc(obj, j2) != 0;
            case 5:
                return zzhi.zzd(obj, j2) != 0;
            case 6:
                return zzhi.zzc(obj, j2) != 0;
            case 7:
                return zzhi.zzt(obj, j2);
            case 8:
                Object objZzf = zzhi.zzf(obj, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzee) {
                    return !zzee.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzhi.zzf(obj, j2) != null;
            case 10:
                return !zzee.zzb.equals(zzhi.zzf(obj, j2));
            case 11:
                return zzhi.zzc(obj, j2) != 0;
            case 12:
                return zzhi.zzc(obj, j2) != 0;
            case 13:
                return zzhi.zzc(obj, j2) != 0;
            case 14:
                return zzhi.zzd(obj, j2) != 0;
            case 15:
                return zzhi.zzc(obj, j2) != 0;
            case 16:
                return zzhi.zzd(obj, j2) != 0;
            case 17:
                return zzhi.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzH(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzG(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzI(Object obj, int i, zzgh zzghVar) {
        return zzghVar.zzi(zzhi.zzf(obj, i & 1048575));
    }

    private final boolean zzJ(Object obj, int i, int i2) {
        return zzhi.zzc(obj, (long) (zzs(i2) & 1048575)) == i;
    }

    static zzgz zzc(Object obj) {
        zzeu zzeuVar = (zzeu) obj;
        zzgz zzgzVar = zzeuVar.zzc;
        if (zzgzVar != zzgz.zza()) {
            return zzgzVar;
        }
        zzgz zzgzVarZzc = zzgz.zzc();
        zzeuVar.zzc = zzgzVarZzc;
        return zzgzVarZzc;
    }

    static zzfz zzj(Class cls, zzft zzftVar, zzgb zzgbVar, zzfk zzfkVar, zzgy zzgyVar, zzel zzelVar, zzfr zzfrVar) {
        if (zzftVar instanceof zzgg) {
            return zzk((zzgg) zzftVar, zzgbVar, zzfkVar, zzgyVar, zzelVar, zzfrVar);
        }
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:123:0x025d  */
    /* JADX WARN: Code duplicated, block: B:124:0x0260  */
    /* JADX WARN: Code duplicated, block: B:127:0x0279  */
    /* JADX WARN: Code duplicated, block: B:128:0x027c  */
    /* JADX WARN: Code duplicated, block: B:176:0x0373  */
    /* JADX WARN: Code duplicated, block: B:182:0x0388  */
    static zzfz zzk(zzgg zzggVar, zzgb zzgbVar, zzfk zzfkVar, zzgy zzgyVar, zzel zzelVar, zzfr zzfrVar) {
        int i;
        int iCharAt;
        int iCharAt2;
        int iCharAt3;
        int iCharAt4;
        int i2;
        int i3;
        int[] iArr;
        int i4;
        int i5;
        char cCharAt;
        int i6;
        char cCharAt2;
        int i7;
        char cCharAt3;
        int i8;
        char cCharAt4;
        int i9;
        char cCharAt5;
        int i10;
        char cCharAt6;
        int i11;
        char cCharAt7;
        int i12;
        char cCharAt8;
        int i13;
        int i14;
        int i15;
        int iObjectFieldOffset;
        int i16;
        int i17;
        int i18;
        Field fieldZzA;
        char cCharAt9;
        int i19;
        int i20;
        int i21;
        Object obj;
        Field fieldZzA2;
        int i22;
        Object obj2;
        Field fieldZzA3;
        int i23;
        char cCharAt10;
        int i24;
        int i25;
        char cCharAt11;
        int i26;
        char cCharAt12;
        int i27;
        char cCharAt13;
        boolean z = zzggVar.zzc() == 2;
        String strZzd = zzggVar.zzd();
        int length = strZzd.length();
        char c = 55296;
        if (strZzd.charAt(0) >= 55296) {
            int i28 = 1;
            while (true) {
                i = i28 + 1;
                if (strZzd.charAt(i28) < 55296) {
                    break;
                }
                i28 = i;
            }
        } else {
            i = 1;
        }
        int i29 = i + 1;
        int iCharAt5 = strZzd.charAt(i);
        if (iCharAt5 >= 55296) {
            int i30 = iCharAt5 & 8191;
            int i31 = 13;
            while (true) {
                i27 = i29 + 1;
                cCharAt13 = strZzd.charAt(i29);
                if (cCharAt13 < 55296) {
                    break;
                }
                i30 |= (cCharAt13 & 8191) << i31;
                i31 += 13;
                i29 = i27;
            }
            iCharAt5 = i30 | (cCharAt13 << i31);
            i29 = i27;
        }
        if (iCharAt5 == 0) {
            iCharAt = 0;
            iCharAt2 = 0;
            iCharAt3 = 0;
            i3 = 0;
            iCharAt4 = 0;
            i2 = 0;
            iArr = zza;
            i4 = 0;
        } else {
            int i32 = i29 + 1;
            int iCharAt6 = strZzd.charAt(i29);
            if (iCharAt6 >= 55296) {
                int i33 = iCharAt6 & 8191;
                int i34 = 13;
                while (true) {
                    i12 = i32 + 1;
                    cCharAt8 = strZzd.charAt(i32);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i33 |= (cCharAt8 & 8191) << i34;
                    i34 += 13;
                    i32 = i12;
                }
                iCharAt6 = i33 | (cCharAt8 << i34);
                i32 = i12;
            }
            int i35 = i32 + 1;
            int iCharAt7 = strZzd.charAt(i32);
            if (iCharAt7 >= 55296) {
                int i36 = iCharAt7 & 8191;
                int i37 = 13;
                while (true) {
                    i11 = i35 + 1;
                    cCharAt7 = strZzd.charAt(i35);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i36 |= (cCharAt7 & 8191) << i37;
                    i37 += 13;
                    i35 = i11;
                }
                iCharAt7 = i36 | (cCharAt7 << i37);
                i35 = i11;
            }
            int i38 = i35 + 1;
            iCharAt = strZzd.charAt(i35);
            if (iCharAt >= 55296) {
                int i39 = iCharAt & 8191;
                int i40 = 13;
                while (true) {
                    i10 = i38 + 1;
                    cCharAt6 = strZzd.charAt(i38);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i39 |= (cCharAt6 & 8191) << i40;
                    i40 += 13;
                    i38 = i10;
                }
                iCharAt = i39 | (cCharAt6 << i40);
                i38 = i10;
            }
            int i41 = i38 + 1;
            iCharAt2 = strZzd.charAt(i38);
            if (iCharAt2 >= 55296) {
                int i42 = iCharAt2 & 8191;
                int i43 = 13;
                while (true) {
                    i9 = i41 + 1;
                    cCharAt5 = strZzd.charAt(i41);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i42 |= (cCharAt5 & 8191) << i43;
                    i43 += 13;
                    i41 = i9;
                }
                iCharAt2 = i42 | (cCharAt5 << i43);
                i41 = i9;
            }
            int i44 = i41 + 1;
            iCharAt3 = strZzd.charAt(i41);
            if (iCharAt3 >= 55296) {
                int i45 = iCharAt3 & 8191;
                int i46 = 13;
                while (true) {
                    i8 = i44 + 1;
                    cCharAt4 = strZzd.charAt(i44);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i45 |= (cCharAt4 & 8191) << i46;
                    i46 += 13;
                    i44 = i8;
                }
                iCharAt3 = i45 | (cCharAt4 << i46);
                i44 = i8;
            }
            int i47 = i44 + 1;
            int iCharAt8 = strZzd.charAt(i44);
            if (iCharAt8 >= 55296) {
                int i48 = iCharAt8 & 8191;
                int i49 = 13;
                while (true) {
                    i7 = i47 + 1;
                    cCharAt3 = strZzd.charAt(i47);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i48 |= (cCharAt3 & 8191) << i49;
                    i49 += 13;
                    i47 = i7;
                }
                iCharAt8 = i48 | (cCharAt3 << i49);
                i47 = i7;
            }
            int i50 = i47 + 1;
            int iCharAt9 = strZzd.charAt(i47);
            if (iCharAt9 >= 55296) {
                int i51 = iCharAt9 & 8191;
                int i52 = 13;
                while (true) {
                    i6 = i50 + 1;
                    cCharAt2 = strZzd.charAt(i50);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i51 |= (cCharAt2 & 8191) << i52;
                    i52 += 13;
                    i50 = i6;
                }
                iCharAt9 = i51 | (cCharAt2 << i52);
                i50 = i6;
            }
            int i53 = i50 + 1;
            iCharAt4 = strZzd.charAt(i50);
            if (iCharAt4 >= 55296) {
                int i54 = iCharAt4 & 8191;
                int i55 = 13;
                while (true) {
                    i5 = i53 + 1;
                    cCharAt = strZzd.charAt(i53);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i54 |= (cCharAt & 8191) << i55;
                    i55 += 13;
                    i53 = i5;
                }
                iCharAt4 = i54 | (cCharAt << i55);
                i53 = i5;
            }
            int[] iArr2 = new int[iCharAt4 + iCharAt8 + iCharAt9];
            i2 = iCharAt6 + iCharAt6 + iCharAt7;
            i3 = iCharAt8;
            iArr = iArr2;
            i4 = iCharAt6;
            i29 = i53;
        }
        Unsafe unsafe = zzb;
        Object[] objArrZze = zzggVar.zze();
        Class<?> cls = zzggVar.zza().getClass();
        int[] iArr3 = new int[iCharAt3 * 3];
        Object[] objArr = new Object[iCharAt3 + iCharAt3];
        int i56 = i3 + iCharAt4;
        int i57 = i56;
        int i58 = iCharAt4;
        int i59 = 0;
        int i60 = 0;
        while (i29 < length) {
            int i61 = i29 + 1;
            int iCharAt10 = strZzd.charAt(i29);
            if (iCharAt10 >= c) {
                int i62 = iCharAt10 & 8191;
                int i63 = i61;
                int i64 = 13;
                while (true) {
                    i26 = i63 + 1;
                    cCharAt12 = strZzd.charAt(i63);
                    if (cCharAt12 < c) {
                        break;
                    }
                    i62 |= (cCharAt12 & 8191) << i64;
                    i64 += 13;
                    i63 = i26;
                }
                iCharAt10 = i62 | (cCharAt12 << i64);
                i13 = i26;
            } else {
                i13 = i61;
            }
            int i65 = i13 + 1;
            int iCharAt11 = strZzd.charAt(i13);
            if (iCharAt11 >= c) {
                int i66 = iCharAt11 & 8191;
                int i67 = i65;
                int i68 = 13;
                while (true) {
                    i25 = i67 + 1;
                    cCharAt11 = strZzd.charAt(i67);
                    i14 = length;
                    if (cCharAt11 < 55296) {
                        break;
                    }
                    i66 |= (cCharAt11 & 8191) << i68;
                    i68 += 13;
                    i67 = i25;
                    length = i14;
                }
                iCharAt11 = i66 | (cCharAt11 << i68);
                i15 = i25;
            } else {
                i14 = length;
                i15 = i65;
            }
            int i69 = iCharAt11 & 255;
            int[] iArr4 = iArr3;
            if ((iCharAt11 & 1024) != 0) {
                iArr[i60] = i59;
                i60++;
            }
            if (i69 >= 51) {
                int i70 = i15 + 1;
                int iCharAt12 = strZzd.charAt(i15);
                if (iCharAt12 >= 55296) {
                    int i71 = iCharAt12 & 8191;
                    int i72 = i70;
                    int i73 = 13;
                    while (true) {
                        i23 = i72 + 1;
                        cCharAt10 = strZzd.charAt(i72);
                        i24 = i71;
                        if (cCharAt10 < 55296) {
                            break;
                        }
                        i71 = i24 | ((cCharAt10 & 8191) << i73);
                        i73 += 13;
                        i72 = i23;
                    }
                    iCharAt12 = i24 | (cCharAt10 << i73);
                    i19 = i23;
                } else {
                    i19 = i70;
                }
                int i74 = iCharAt12;
                int i75 = i69 - 51;
                int i76 = i19;
                if (i75 == 9 || i75 == 17) {
                    int i77 = i59 / 3;
                    i20 = i2 + 1;
                    objArr[i77 + i77 + 1] = objArrZze[i2];
                } else {
                    if (i75 == 12 && !z) {
                        int i78 = i59 / 3;
                        i20 = i2 + 1;
                        objArr[i78 + i78 + 1] = objArrZze[i2];
                    }
                    i21 = i74 + i74;
                    obj = objArrZze[i21];
                    if (obj instanceof Field) {
                        fieldZzA2 = (Field) obj;
                    } else {
                        fieldZzA2 = zzA(cls, (String) obj);
                        objArrZze[i21] = fieldZzA2;
                    }
                    int iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzA2);
                    i22 = i21 + 1;
                    obj2 = objArrZze[i22];
                    if (obj2 instanceof Field) {
                        fieldZzA3 = (Field) obj2;
                    } else {
                        fieldZzA3 = zzA(cls, (String) obj2);
                        objArrZze[i22] = fieldZzA3;
                    }
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzA3);
                    i17 = iObjectFieldOffset2;
                    strZzd = strZzd;
                    i29 = i76;
                    i16 = 0;
                }
                i2 = i20;
                i21 = i74 + i74;
                obj = objArrZze[i21];
                if (obj instanceof Field) {
                    fieldZzA2 = (Field) obj;
                } else {
                    fieldZzA2 = zzA(cls, (String) obj);
                    objArrZze[i21] = fieldZzA2;
                }
                int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzA2);
                i22 = i21 + 1;
                obj2 = objArrZze[i22];
                if (obj2 instanceof Field) {
                    fieldZzA3 = (Field) obj2;
                } else {
                    fieldZzA3 = zzA(cls, (String) obj2);
                    objArrZze[i22] = fieldZzA3;
                }
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzA3);
                i17 = iObjectFieldOffset3;
                strZzd = strZzd;
                i29 = i76;
                i16 = 0;
            } else {
                int i79 = i2 + 1;
                Field fieldZzA4 = zzA(cls, (String) objArrZze[i2]);
                if (i69 == 9 || i69 == 17) {
                    int i80 = i59 / 3;
                    objArr[i80 + i80 + 1] = fieldZzA4.getType();
                } else {
                    if (i69 == 27 || i69 == 49) {
                        int i81 = i59 / 3;
                        i2 += 2;
                        objArr[i81 + i81 + 1] = objArrZze[i79];
                    } else if (i69 == 12 || i69 == 30 || i69 == 44) {
                        if (!z) {
                            int i82 = i59 / 3;
                            i2 += 2;
                            objArr[i82 + i82 + 1] = objArrZze[i79];
                        }
                    } else if (i69 == 50) {
                        int i83 = i58 + 1;
                        iArr[i58] = i59;
                        int i84 = i59 / 3;
                        int i85 = i84 + i84;
                        int i86 = i2 + 2;
                        objArr[i85] = objArrZze[i79];
                        if ((iCharAt11 & 2048) != 0) {
                            objArr[i85 + 1] = objArrZze[i86];
                            i2 += 3;
                        } else {
                            i2 = i86;
                        }
                        i58 = i83;
                    }
                    int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldZzA4);
                    iObjectFieldOffset = 1048575;
                    if ((iCharAt11 & 4096) == 4096 || i69 > 17) {
                        i29 = i15;
                        i16 = 0;
                    } else {
                        int i87 = i15 + 1;
                        int iCharAt13 = strZzd.charAt(i15);
                        if (iCharAt13 >= 55296) {
                            int i88 = iCharAt13 & 8191;
                            int i89 = 13;
                            while (true) {
                                i18 = i87 + 1;
                                cCharAt9 = strZzd.charAt(i87);
                                if (cCharAt9 < 55296) {
                                    break;
                                }
                                i88 |= (cCharAt9 & 8191) << i89;
                                i89 += 13;
                                i87 = i18;
                            }
                            iCharAt13 = i88 | (cCharAt9 << i89);
                        } else {
                            i18 = i87;
                        }
                        int i90 = i4 + i4 + (iCharAt13 / 32);
                        Object obj3 = objArrZze[i90];
                        if (obj3 instanceof Field) {
                            fieldZzA = (Field) obj3;
                        } else {
                            fieldZzA = zzA(cls, (String) obj3);
                            objArrZze[i90] = fieldZzA;
                        }
                        i16 = iCharAt13 % 32;
                        int i91 = i18;
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzA);
                        i29 = i91;
                    }
                    if (i69 < 18 && i69 <= 49) {
                        iArr[i57] = iObjectFieldOffset4;
                        i57++;
                    }
                    i17 = iObjectFieldOffset4;
                }
                i2 = i79;
                int iObjectFieldOffset5 = (int) unsafe.objectFieldOffset(fieldZzA4);
                iObjectFieldOffset = 1048575;
                if ((iCharAt11 & 4096) == 4096) {
                    i29 = i15;
                    i16 = 0;
                } else {
                    i29 = i15;
                    i16 = 0;
                }
                if (i69 < 18) {
                }
                i17 = iObjectFieldOffset5;
            }
            int i92 = i59 + 1;
            iArr4[i59] = iCharAt10;
            int i93 = i59 + 2;
            int i94 = i16;
            iArr4[i92] = ((iCharAt11 & 512) != 0 ? C.BUFFER_FLAG_LAST_SAMPLE : 0) | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | (i69 << 20) | i17;
            i59 += 3;
            iArr4[i93] = (i94 << 20) | iObjectFieldOffset;
            iArr3 = iArr4;
            length = i14;
            strZzd = strZzd;
            c = 55296;
        }
        return new zzfz(iArr3, objArr, iCharAt, iCharAt2, zzggVar.zza(), z, false, iArr, iCharAt4, i56, zzgbVar, zzfkVar, zzgyVar, zzelVar, zzfrVar, null);
    }

    private static int zzl(Object obj, long j) {
        return ((Integer) zzhi.zzf(obj, j)).intValue();
    }

    private final int zzm(Object obj, byte[] bArr, int i, int i2, int i3, long j, zzds zzdsVar) throws IOException {
        Unsafe unsafe = zzb;
        Object objZzz = zzz(i3);
        Object object = unsafe.getObject(obj, j);
        if (!((zzfq) object).zze()) {
            zzfq zzfqVarZzb = zzfq.zza().zzb();
            zzfr.zza(zzfqVarZzb, object);
            unsafe.putObject(obj, j, zzfqVarZzb);
        }
        throw null;
    }

    private final int zzn(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzds zzdsVar) throws IOException {
        Object object;
        Unsafe unsafe = zzb;
        long j2 = this.zzc[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j, Double.valueOf(Double.longBitsToDouble(zzdt.zzn(bArr, i))));
                unsafe.putInt(obj, j2, i4);
                return i + 8;
            case 52:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j, Float.valueOf(Float.intBitsToFloat(zzdt.zzb(bArr, i))));
                unsafe.putInt(obj, j2, i4);
                return i + 4;
            case 53:
            case 54:
                if (i5 != 0) {
                    return i;
                }
                int iZzm = zzdt.zzm(bArr, i, zzdsVar);
                unsafe.putObject(obj, j, Long.valueOf(zzdsVar.zzb));
                unsafe.putInt(obj, j2, i4);
                return iZzm;
            case 55:
            case 62:
                if (i5 != 0) {
                    return i;
                }
                int iZzj = zzdt.zzj(bArr, i, zzdsVar);
                unsafe.putObject(obj, j, Integer.valueOf(zzdsVar.zza));
                unsafe.putInt(obj, j2, i4);
                return iZzj;
            case 56:
            case 65:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j, Long.valueOf(zzdt.zzn(bArr, i)));
                unsafe.putInt(obj, j2, i4);
                return i + 8;
            case 57:
            case 64:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j, Integer.valueOf(zzdt.zzb(bArr, i)));
                unsafe.putInt(obj, j2, i4);
                return i + 4;
            case 58:
                if (i5 != 0) {
                    return i;
                }
                int iZzm2 = zzdt.zzm(bArr, i, zzdsVar);
                unsafe.putObject(obj, j, Boolean.valueOf(zzdsVar.zzb != 0));
                unsafe.putInt(obj, j2, i4);
                return iZzm2;
            case 59:
                if (i5 != 2) {
                    return i;
                }
                int iZzj2 = zzdt.zzj(bArr, i, zzdsVar);
                int i9 = zzdsVar.zza;
                if (i9 == 0) {
                    unsafe.putObject(obj, j, "");
                } else {
                    if ((i6 & C.BUFFER_FLAG_LAST_SAMPLE) != 0 && !zzhm.zzd(bArr, iZzj2, iZzj2 + i9)) {
                        throw zzfa.zzb();
                    }
                    unsafe.putObject(obj, j, new String(bArr, iZzj2, i9, zzez.zzb));
                    iZzj2 += i9;
                }
                unsafe.putInt(obj, j2, i4);
                return iZzj2;
            case 60:
                if (i5 != 2) {
                    return i;
                }
                int iZzd = zzdt.zzd(zzy(i8), bArr, i, i2, zzdsVar);
                object = unsafe.getInt(obj, j2) == i4 ? unsafe.getObject(obj, j) : null;
                if (object == null) {
                    unsafe.putObject(obj, j, zzdsVar.zzc);
                } else {
                    unsafe.putObject(obj, j, zzez.zzg(object, zzdsVar.zzc));
                }
                unsafe.putInt(obj, j2, i4);
                return iZzd;
            case 61:
                if (i5 != 2) {
                    return i;
                }
                int iZza = zzdt.zza(bArr, i, zzdsVar);
                unsafe.putObject(obj, j, zzdsVar.zzc);
                unsafe.putInt(obj, j2, i4);
                return iZza;
            case 63:
                if (i5 != 0) {
                    return i;
                }
                int iZzj3 = zzdt.zzj(bArr, i, zzdsVar);
                int i10 = zzdsVar.zza;
                zzex zzexVarZzx = zzx(i8);
                if (zzexVarZzx != null && !zzexVarZzx.zza()) {
                    zzc(obj).zzf(i3, Long.valueOf(i10));
                    return iZzj3;
                }
                unsafe.putObject(obj, j, Integer.valueOf(i10));
                unsafe.putInt(obj, j2, i4);
                return iZzj3;
            case 66:
                if (i5 != 0) {
                    return i;
                }
                int iZzj4 = zzdt.zzj(bArr, i, zzdsVar);
                unsafe.putObject(obj, j, Integer.valueOf(zzei.zzb(zzdsVar.zza)));
                unsafe.putInt(obj, j2, i4);
                return iZzj4;
            case 67:
                if (i5 != 0) {
                    return i;
                }
                int iZzm3 = zzdt.zzm(bArr, i, zzdsVar);
                unsafe.putObject(obj, j, Long.valueOf(zzei.zzc(zzdsVar.zzb)));
                unsafe.putInt(obj, j2, i4);
                return iZzm3;
            case 68:
                if (i5 == 3) {
                    int iZzc = zzdt.zzc(zzy(i8), bArr, i, i2, (i3 & (-8)) | 4, zzdsVar);
                    object = unsafe.getInt(obj, j2) == i4 ? unsafe.getObject(obj, j) : null;
                    if (object == null) {
                        unsafe.putObject(obj, j, zzdsVar.zzc);
                    } else {
                        unsafe.putObject(obj, j, zzez.zzg(object, zzdsVar.zzc));
                    }
                    unsafe.putInt(obj, j2, i4);
                    return iZzc;
                }
                break;
        }
        return i;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:24:0x0080. Please report as an issue. */
    private final int zzo(Object obj, byte[] bArr, int i, int i2, zzds zzdsVar) throws IOException {
        Unsafe unsafe;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        this = this;
        Object obj2 = obj;
        byte[] bArr2 = bArr;
        int i13 = i2;
        zzdsVar = zzdsVar;
        Unsafe unsafe2 = zzb;
        int i14 = -1;
        int iZzm = i;
        int i15 = -1;
        int i16 = 0;
        int i17 = 0;
        int i18 = 1048575;
        while (iZzm < i13) {
            int iZzk = iZzm + 1;
            int i19 = bArr2[iZzm];
            if (i19 < 0) {
                iZzk = zzdt.zzk(i19, bArr2, iZzk, zzdsVar);
                i19 = zzdsVar.zza;
            }
            int i20 = iZzk;
            int i21 = i19 >>> 3;
            int i22 = i19 & 7;
            int iZzr = i21 > i15 ? this.zzr(i21, i16 / 3) : this.zzq(i21);
            if (iZzr == i14) {
                unsafe = unsafe2;
                i3 = i19;
                i4 = i14;
                i5 = i21;
                i6 = 0;
                obj = obj2;
            } else {
                int[] iArr = this.zzc;
                int i23 = iArr[iZzr + 1];
                int iZzu = zzu(i23);
                int i24 = i19;
                int i25 = iZzr;
                long j = i23 & 1048575;
                if (iZzu <= 17) {
                    int i26 = iArr[i25 + 2];
                    int i27 = 1 << (i26 >>> 20);
                    int i28 = i26 & 1048575;
                    if (i28 != i18) {
                        int i29 = 1048575;
                        if (i18 != 1048575) {
                            unsafe2.putInt(obj2, i18, i17);
                            i29 = 1048575;
                        }
                        if (i28 != i29) {
                            i17 = unsafe2.getInt(obj2, i28);
                        }
                        i18 = i28;
                    }
                    switch (iZzu) {
                        case 0:
                            i12 = i25;
                            if (i22 != 1) {
                                obj = obj2;
                                unsafe = unsafe2;
                                i5 = i21;
                                i6 = i12;
                                i4 = -1;
                                i3 = i24 == true ? 1 : 0;
                            } else {
                                zzhi.zzl(obj2, j, Double.longBitsToDouble(zzdt.zzn(bArr2, i20)));
                                iZzm = i20 + 8;
                                i17 |= i27;
                                i13 = i2;
                                i15 = i21;
                                i16 = i12;
                                i14 = -1;
                            }
                            break;
                        case 1:
                            i12 = i25;
                            if (i22 != 5) {
                                obj = obj2;
                                unsafe = unsafe2;
                                i5 = i21;
                                i6 = i12;
                                i4 = -1;
                                i3 = i24 == true ? 1 : 0;
                            } else {
                                zzhi.zzm(obj2, j, Float.intBitsToFloat(zzdt.zzb(bArr2, i20)));
                                iZzm = i20 + 4;
                                i17 |= i27;
                                i13 = i2;
                                i15 = i21;
                                i16 = i12;
                                i14 = -1;
                            }
                            break;
                        case 2:
                        case 3:
                            i12 = i25;
                            if (i22 != 0) {
                                obj = obj2;
                                unsafe = unsafe2;
                                i5 = i21;
                                i6 = i12;
                                i4 = -1;
                                i3 = i24 == true ? 1 : 0;
                            } else {
                                int iZzm2 = zzdt.zzm(bArr2, i20, zzdsVar);
                                Unsafe unsafe3 = unsafe2;
                                Object obj3 = obj2;
                                unsafe3.putLong(obj3, j, zzdsVar.zzb);
                                unsafe2 = unsafe3;
                                obj2 = obj3;
                                i17 |= i27;
                                iZzm = iZzm2;
                                i15 = i21;
                                i16 = i12;
                                i14 = -1;
                                i13 = i2;
                            }
                            break;
                        case 4:
                        case 11:
                            i12 = i25;
                            if (i22 != 0) {
                                obj = obj2;
                                unsafe = unsafe2;
                                i5 = i21;
                                i6 = i12;
                                i4 = -1;
                                i3 = i24 == true ? 1 : 0;
                            } else {
                                int iZzj = zzdt.zzj(bArr2, i20, zzdsVar);
                                unsafe2.putInt(obj2, j, zzdsVar.zza);
                                i17 |= i27;
                                i13 = i2;
                                iZzm = iZzj;
                                i15 = i21;
                                i16 = i12;
                                i14 = -1;
                            }
                            break;
                        case 5:
                        case 14:
                            i12 = i25;
                            if (i22 != 1) {
                                obj = obj2;
                                unsafe = unsafe2;
                                i5 = i21;
                                i6 = i12;
                                i4 = -1;
                                i3 = i24 == true ? 1 : 0;
                            } else {
                                Unsafe unsafe4 = unsafe2;
                                Object obj4 = obj2;
                                unsafe4.putLong(obj4, j, zzdt.zzn(bArr2, i20));
                                unsafe2 = unsafe4;
                                obj2 = obj4;
                                iZzm = i20 + 8;
                                i17 |= i27;
                                i13 = i2;
                                i15 = i21;
                                i16 = i12;
                                i14 = -1;
                            }
                            break;
                        case 6:
                        case 13:
                            i12 = i25;
                            if (i22 != 5) {
                                obj = obj2;
                                unsafe = unsafe2;
                                i5 = i21;
                                i6 = i12;
                                i4 = -1;
                                i3 = i24 == true ? 1 : 0;
                            } else {
                                unsafe2.putInt(obj2, j, zzdt.zzb(bArr2, i20));
                                iZzm = i20 + 4;
                                i17 |= i27;
                                i13 = i2;
                                i15 = i21;
                                i16 = i12;
                                i14 = -1;
                            }
                            break;
                        case 7:
                            i12 = i25;
                            if (i22 != 0) {
                                obj = obj2;
                                unsafe = unsafe2;
                                i5 = i21;
                                i6 = i12;
                                i4 = -1;
                                i3 = i24 == true ? 1 : 0;
                            } else {
                                iZzm = zzdt.zzm(bArr2, i20, zzdsVar);
                                zzhi.zzk(obj2, j, zzdsVar.zzb != 0);
                                i17 |= i27;
                                i13 = i2;
                                i15 = i21;
                                i16 = i12;
                                i14 = -1;
                            }
                            break;
                        case 8:
                            i12 = i25;
                            if (i22 != 2) {
                                obj = obj2;
                                unsafe = unsafe2;
                                i5 = i21;
                                i6 = i12;
                                i4 = -1;
                                i3 = i24 == true ? 1 : 0;
                            } else {
                                iZzm = (536870912 & i23) == 0 ? zzdt.zzg(bArr2, i20, zzdsVar) : zzdt.zzh(bArr2, i20, zzdsVar);
                                unsafe2.putObject(obj2, j, zzdsVar.zzc);
                                i17 |= i27;
                                i15 = i21;
                                i16 = i12;
                                i14 = -1;
                            }
                            break;
                        case 9:
                            i12 = i25;
                            if (i22 != 2) {
                                obj = obj2;
                                unsafe = unsafe2;
                                i5 = i21;
                                i6 = i12;
                                i4 = -1;
                                i3 = i24 == true ? 1 : 0;
                            } else {
                                iZzm = zzdt.zzd(this.zzy(i12), bArr2, i20, i13, zzdsVar);
                                Object object = unsafe2.getObject(obj2, j);
                                if (object == null) {
                                    unsafe2.putObject(obj2, j, zzdsVar.zzc);
                                } else {
                                    unsafe2.putObject(obj2, j, zzez.zzg(object, zzdsVar.zzc));
                                }
                                i17 |= i27;
                                i15 = i21;
                                i16 = i12;
                                i14 = -1;
                            }
                            break;
                        case 10:
                            i12 = i25;
                            if (i22 != 2) {
                                obj = obj2;
                                unsafe = unsafe2;
                                i5 = i21;
                                i6 = i12;
                                i4 = -1;
                                i3 = i24 == true ? 1 : 0;
                            } else {
                                iZzm = zzdt.zza(bArr2, i20, zzdsVar);
                                unsafe2.putObject(obj2, j, zzdsVar.zzc);
                                i17 |= i27;
                                i15 = i21;
                                i16 = i12;
                                i14 = -1;
                            }
                            break;
                        case 12:
                            i12 = i25;
                            if (i22 != 0) {
                                obj = obj2;
                                unsafe = unsafe2;
                                i5 = i21;
                                i6 = i12;
                                i4 = -1;
                                i3 = i24 == true ? 1 : 0;
                            } else {
                                iZzm = zzdt.zzj(bArr2, i20, zzdsVar);
                                unsafe2.putInt(obj2, j, zzdsVar.zza);
                                i17 |= i27;
                                i15 = i21;
                                i16 = i12;
                                i14 = -1;
                            }
                            break;
                        case 15:
                            i12 = i25;
                            if (i22 != 0) {
                                obj = obj2;
                                unsafe = unsafe2;
                                i5 = i21;
                                i6 = i12;
                                i4 = -1;
                                i3 = i24 == true ? 1 : 0;
                            } else {
                                iZzm = zzdt.zzj(bArr2, i20, zzdsVar);
                                unsafe2.putInt(obj2, j, zzei.zzb(zzdsVar.zza));
                                i17 |= i27;
                                i15 = i21;
                                i16 = i12;
                                i14 = -1;
                            }
                            break;
                        case 16:
                            if (i22 != 0) {
                                i12 = i25;
                                obj = obj2;
                                unsafe = unsafe2;
                                i5 = i21;
                                i6 = i12;
                                i4 = -1;
                                i3 = i24 == true ? 1 : 0;
                            } else {
                                int iZzm3 = zzdt.zzm(bArr2, i20, zzdsVar);
                                Unsafe unsafe5 = unsafe2;
                                Object obj5 = obj2;
                                i12 = i25;
                                unsafe5.putLong(obj5, j, zzei.zzc(zzdsVar.zzb));
                                unsafe2 = unsafe5;
                                obj2 = obj5;
                                i17 |= i27;
                                iZzm = iZzm3;
                                i15 = i21;
                                i16 = i12;
                                i14 = -1;
                            }
                            break;
                        default:
                            i12 = i25;
                            obj = obj2;
                            unsafe = unsafe2;
                            i5 = i21;
                            i6 = i12;
                            i4 = -1;
                            i3 = i24 == true ? 1 : 0;
                            break;
                    }
                } else {
                    i6 = i25;
                    if (iZzu != 27) {
                        i7 = i20;
                        Unsafe unsafe6 = unsafe2;
                        if (iZzu <= 49) {
                            i8 = i17;
                            unsafe = unsafe6;
                            i4 = -1;
                            i10 = i18;
                            int iZzp = this.zzp(obj, bArr, i7, i2, i24 == true ? 1 : 0, i21, i22, i6, i23, iZzu, j, zzdsVar);
                            i9 = i24 == true ? 1 : 0;
                            i11 = i21;
                            if (iZzp != i7) {
                                obj2 = obj;
                                iZzm = iZzp;
                                i16 = i6;
                                i15 = i11;
                                i18 = i10;
                                i14 = i4;
                                i17 = i8;
                                unsafe2 = unsafe;
                                bArr2 = bArr;
                                i13 = i2;
                            } else {
                                i20 = iZzp;
                                i5 = i11;
                                i3 = i9;
                            }
                        } else {
                            i8 = i17;
                            unsafe = unsafe6;
                            i4 = -1;
                            i9 = i24 == true ? 1 : 0;
                            i10 = i18;
                            i11 = i21;
                            if (iZzu == 50) {
                                if (i22 == 2) {
                                    int iZzm4 = zzm(obj, bArr, i7, i2, i6, j, zzdsVar);
                                    if (iZzm4 != i7) {
                                        i6 = i6;
                                        this = this;
                                        obj2 = obj;
                                        bArr2 = bArr;
                                        zzdsVar = zzdsVar;
                                        iZzm = iZzm4;
                                        i16 = i6;
                                        i15 = i11;
                                        i18 = i10;
                                        i14 = -1;
                                        i17 = i8;
                                        unsafe2 = unsafe;
                                        i13 = i2;
                                    } else {
                                        i6 = i6;
                                        i20 = iZzm4;
                                    }
                                } else {
                                    i6 = i6;
                                    i20 = i7;
                                }
                                i5 = i11;
                                i3 = i9;
                            } else {
                                i5 = i11;
                                int iZzn = zzn(obj, bArr, i7, i2, i9 == true ? 1 : 0, i5, i22, i23, iZzu, j, i6, zzdsVar);
                                obj = obj;
                                i3 = i9 == true ? 1 : 0;
                                if (iZzn != i7) {
                                    i6 = i6;
                                    i15 = i5;
                                    iZzm = iZzn;
                                    i16 = i6;
                                    obj2 = obj;
                                    i18 = i10;
                                    i14 = i4;
                                    i17 = i8;
                                    unsafe2 = unsafe;
                                    bArr2 = bArr;
                                    i13 = i2;
                                } else {
                                    i6 = i6;
                                    i20 = iZzn;
                                }
                            }
                        }
                    } else if (i22 == 2) {
                        zzey zzeyVarZzd = (zzey) unsafe2.getObject(obj2, j);
                        if (!zzeyVarZzd.zzc()) {
                            int size = zzeyVarZzd.size();
                            zzeyVarZzd = zzeyVarZzd.zzd(size == 0 ? 10 : size + size);
                            unsafe2.putObject(obj2, j, zzeyVarZzd);
                        }
                        int iZze = zzdt.zze(this.zzy(i6), i24 == true ? 1 : 0, bArr2, i20, i2, zzeyVarZzd, zzdsVar);
                        bArr2 = bArr;
                        zzdsVar = zzdsVar;
                        iZzm = iZze;
                        i16 = i6;
                        unsafe2 = unsafe2;
                        i15 = i21;
                        i14 = -1;
                        obj2 = obj;
                        i13 = i2;
                    } else {
                        i7 = i20;
                        i10 = i18;
                        i8 = i17;
                        unsafe = unsafe2;
                        i11 = i21;
                        i4 = -1;
                        i9 = i24 == true ? 1 : 0;
                        i20 = i7;
                        i5 = i11;
                        i3 = i9;
                    }
                    i18 = i10;
                    i17 = i8;
                }
            }
            int iZzi = zzdt.zzi(i3 == true ? 1 : 0, bArr, i20, i2, zzc(obj), zzdsVar);
            bArr2 = bArr;
            zzdsVar = zzdsVar;
            i15 = i5;
            i16 = i6;
            obj2 = obj;
            i14 = i4;
            unsafe2 = unsafe;
            i13 = i2;
            iZzm = iZzi;
            this = this;
        }
        Object obj6 = obj2;
        Unsafe unsafe7 = unsafe2;
        int i30 = i13;
        int i31 = i18;
        int i32 = i17;
        if (i31 != 1048575) {
            unsafe7.putInt(obj6, i31, i32);
        }
        if (iZzm == i30) {
            return iZzm;
        }
        throw zzfa.zzd();
    }

    private final int zzp(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, zzds zzdsVar) throws IOException {
        int iZzl;
        byte[] bArr2 = bArr;
        int i8 = i2;
        Unsafe unsafe = zzb;
        zzey zzeyVarZzd = (zzey) unsafe.getObject(obj, j2);
        if (!zzeyVarZzd.zzc()) {
            int size = zzeyVarZzd.size();
            zzeyVarZzd = zzeyVarZzd.zzd(size == 0 ? 10 : size + size);
            unsafe.putObject(obj, j2, zzeyVarZzd);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    zzej zzejVar = (zzej) zzeyVarZzd;
                    int iZzj = zzdt.zzj(bArr2, i, zzdsVar);
                    int i9 = zzdsVar.zza + iZzj;
                    while (iZzj < i9) {
                        zzejVar.zze(Double.longBitsToDouble(zzdt.zzn(bArr2, iZzj)));
                        iZzj += 8;
                    }
                    if (iZzj == i9) {
                        return iZzj;
                    }
                    throw zzfa.zzf();
                }
                if (i5 == 1) {
                    zzej zzejVar2 = (zzej) zzeyVarZzd;
                    zzejVar2.zze(Double.longBitsToDouble(zzdt.zzn(bArr, i)));
                    int i10 = i + 8;
                    while (i10 < i8) {
                        int iZzj2 = zzdt.zzj(bArr2, i10, zzdsVar);
                        if (i3 != zzdsVar.zza) {
                            return i10;
                        }
                        zzejVar2.zze(Double.longBitsToDouble(zzdt.zzn(bArr2, iZzj2)));
                        i10 = iZzj2 + 8;
                    }
                    return i10;
                }
                return i;
            case 19:
            case 36:
                if (i5 == 2) {
                    zzeq zzeqVar = (zzeq) zzeyVarZzd;
                    int iZzj3 = zzdt.zzj(bArr2, i, zzdsVar);
                    int i11 = zzdsVar.zza + iZzj3;
                    while (iZzj3 < i11) {
                        zzeqVar.zze(Float.intBitsToFloat(zzdt.zzb(bArr2, iZzj3)));
                        iZzj3 += 4;
                    }
                    if (iZzj3 == i11) {
                        return iZzj3;
                    }
                    throw zzfa.zzf();
                }
                if (i5 == 5) {
                    zzeq zzeqVar2 = (zzeq) zzeyVarZzd;
                    zzeqVar2.zze(Float.intBitsToFloat(zzdt.zzb(bArr, i)));
                    int i12 = i + 4;
                    while (i12 < i8) {
                        int iZzj4 = zzdt.zzj(bArr2, i12, zzdsVar);
                        if (i3 != zzdsVar.zza) {
                            return i12;
                        }
                        zzeqVar2.zze(Float.intBitsToFloat(zzdt.zzb(bArr2, iZzj4)));
                        i12 = iZzj4 + 4;
                    }
                    return i12;
                }
                return i;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    zzfl zzflVar = (zzfl) zzeyVarZzd;
                    int iZzj5 = zzdt.zzj(bArr2, i, zzdsVar);
                    int i13 = zzdsVar.zza + iZzj5;
                    while (iZzj5 < i13) {
                        iZzj5 = zzdt.zzm(bArr2, iZzj5, zzdsVar);
                        zzflVar.zze(zzdsVar.zzb);
                    }
                    if (iZzj5 == i13) {
                        return iZzj5;
                    }
                    throw zzfa.zzf();
                }
                if (i5 == 0) {
                    zzfl zzflVar2 = (zzfl) zzeyVarZzd;
                    int iZzm = zzdt.zzm(bArr2, i, zzdsVar);
                    zzflVar2.zze(zzdsVar.zzb);
                    while (iZzm < i8) {
                        int iZzj6 = zzdt.zzj(bArr2, iZzm, zzdsVar);
                        if (i3 != zzdsVar.zza) {
                            return iZzm;
                        }
                        iZzm = zzdt.zzm(bArr2, iZzj6, zzdsVar);
                        zzflVar2.zze(zzdsVar.zzb);
                    }
                    return iZzm;
                }
                return i;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return zzdt.zzf(bArr2, i, zzeyVarZzd, zzdsVar);
                }
                if (i5 == 0) {
                    return zzdt.zzl(i3, bArr2, i, i8, zzeyVarZzd, zzdsVar);
                }
                return i;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    zzfl zzflVar3 = (zzfl) zzeyVarZzd;
                    int iZzj7 = zzdt.zzj(bArr2, i, zzdsVar);
                    int i14 = zzdsVar.zza + iZzj7;
                    while (iZzj7 < i14) {
                        zzflVar3.zze(zzdt.zzn(bArr2, iZzj7));
                        iZzj7 += 8;
                    }
                    if (iZzj7 == i14) {
                        return iZzj7;
                    }
                    throw zzfa.zzf();
                }
                if (i5 == 1) {
                    zzfl zzflVar4 = (zzfl) zzeyVarZzd;
                    zzflVar4.zze(zzdt.zzn(bArr, i));
                    int i15 = i + 8;
                    while (i15 < i8) {
                        int iZzj8 = zzdt.zzj(bArr2, i15, zzdsVar);
                        if (i3 != zzdsVar.zza) {
                            return i15;
                        }
                        zzflVar4.zze(zzdt.zzn(bArr2, iZzj8));
                        i15 = iZzj8 + 8;
                    }
                    return i15;
                }
                return i;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    zzev zzevVar = (zzev) zzeyVarZzd;
                    int iZzj9 = zzdt.zzj(bArr2, i, zzdsVar);
                    int i16 = zzdsVar.zza + iZzj9;
                    while (iZzj9 < i16) {
                        zzevVar.zze(zzdt.zzb(bArr2, iZzj9));
                        iZzj9 += 4;
                    }
                    if (iZzj9 == i16) {
                        return iZzj9;
                    }
                    throw zzfa.zzf();
                }
                if (i5 == 5) {
                    zzev zzevVar2 = (zzev) zzeyVarZzd;
                    zzevVar2.zze(zzdt.zzb(bArr, i));
                    int i17 = i + 4;
                    while (i17 < i8) {
                        int iZzj10 = zzdt.zzj(bArr2, i17, zzdsVar);
                        if (i3 != zzdsVar.zza) {
                            return i17;
                        }
                        zzevVar2.zze(zzdt.zzb(bArr2, iZzj10));
                        i17 = iZzj10 + 4;
                    }
                    return i17;
                }
                return i;
            case 25:
            case 42:
                if (i5 == 2) {
                    zzdu zzduVar = (zzdu) zzeyVarZzd;
                    int iZzj11 = zzdt.zzj(bArr2, i, zzdsVar);
                    int i18 = zzdsVar.zza + iZzj11;
                    while (iZzj11 < i18) {
                        iZzj11 = zzdt.zzm(bArr2, iZzj11, zzdsVar);
                        zzduVar.zze(zzdsVar.zzb != 0);
                    }
                    if (iZzj11 == i18) {
                        return iZzj11;
                    }
                    throw zzfa.zzf();
                }
                if (i5 == 0) {
                    zzdu zzduVar2 = (zzdu) zzeyVarZzd;
                    int iZzm2 = zzdt.zzm(bArr2, i, zzdsVar);
                    zzduVar2.zze(zzdsVar.zzb != 0);
                    while (iZzm2 < i8) {
                        int iZzj12 = zzdt.zzj(bArr2, iZzm2, zzdsVar);
                        if (i3 != zzdsVar.zza) {
                            return iZzm2;
                        }
                        iZzm2 = zzdt.zzm(bArr2, iZzj12, zzdsVar);
                        zzduVar2.zze(zzdsVar.zzb != 0);
                    }
                    return iZzm2;
                }
                return i;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) == 0) {
                        int iZzj13 = zzdt.zzj(bArr2, i, zzdsVar);
                        int i19 = zzdsVar.zza;
                        if (i19 < 0) {
                            throw zzfa.zzc();
                        }
                        if (i19 == 0) {
                            zzeyVarZzd.add("");
                        } else {
                            zzeyVarZzd.add(new String(bArr2, iZzj13, i19, zzez.zzb));
                            iZzj13 += i19;
                        }
                        while (iZzj13 < i8) {
                            int iZzj14 = zzdt.zzj(bArr2, iZzj13, zzdsVar);
                            if (i3 != zzdsVar.zza) {
                                return iZzj13;
                            }
                            iZzj13 = zzdt.zzj(bArr2, iZzj14, zzdsVar);
                            int i20 = zzdsVar.zza;
                            if (i20 < 0) {
                                throw zzfa.zzc();
                            }
                            if (i20 == 0) {
                                zzeyVarZzd.add("");
                            } else {
                                zzeyVarZzd.add(new String(bArr2, iZzj13, i20, zzez.zzb));
                                iZzj13 += i20;
                            }
                        }
                        return iZzj13;
                    }
                    int iZzj15 = zzdt.zzj(bArr2, i, zzdsVar);
                    int i21 = zzdsVar.zza;
                    if (i21 < 0) {
                        throw zzfa.zzc();
                    }
                    if (i21 == 0) {
                        zzeyVarZzd.add("");
                    } else {
                        int i22 = iZzj15 + i21;
                        if (!zzhm.zzd(bArr2, iZzj15, i22)) {
                            throw zzfa.zzb();
                        }
                        zzeyVarZzd.add(new String(bArr2, iZzj15, i21, zzez.zzb));
                        iZzj15 = i22;
                    }
                    while (iZzj15 < i8) {
                        int iZzj16 = zzdt.zzj(bArr2, iZzj15, zzdsVar);
                        if (i3 != zzdsVar.zza) {
                            return iZzj15;
                        }
                        iZzj15 = zzdt.zzj(bArr2, iZzj16, zzdsVar);
                        int i23 = zzdsVar.zza;
                        if (i23 < 0) {
                            throw zzfa.zzc();
                        }
                        if (i23 == 0) {
                            zzeyVarZzd.add("");
                        } else {
                            int i24 = iZzj15 + i23;
                            if (!zzhm.zzd(bArr2, iZzj15, i24)) {
                                throw zzfa.zzb();
                            }
                            zzeyVarZzd.add(new String(bArr2, iZzj15, i23, zzez.zzb));
                            iZzj15 = i24;
                        }
                    }
                    return iZzj15;
                }
                return i;
            case 27:
                if (i5 == 2) {
                    return zzdt.zze(zzy(i6), i3, bArr2, i, i8, zzeyVarZzd, zzdsVar);
                }
                return i;
            case 28:
                if (i5 == 2) {
                    int iZzj17 = zzdt.zzj(bArr2, i, zzdsVar);
                    int i25 = zzdsVar.zza;
                    if (i25 < 0) {
                        throw zzfa.zzc();
                    }
                    if (i25 > bArr2.length - iZzj17) {
                        throw zzfa.zzf();
                    }
                    if (i25 == 0) {
                        zzeyVarZzd.add(zzee.zzb);
                    } else {
                        zzeyVarZzd.add(zzee.zzk(bArr2, iZzj17, i25));
                        iZzj17 += i25;
                    }
                    while (iZzj17 < i8) {
                        int iZzj18 = zzdt.zzj(bArr2, iZzj17, zzdsVar);
                        if (i3 != zzdsVar.zza) {
                            return iZzj17;
                        }
                        iZzj17 = zzdt.zzj(bArr2, iZzj18, zzdsVar);
                        int i26 = zzdsVar.zza;
                        if (i26 < 0) {
                            throw zzfa.zzc();
                        }
                        if (i26 > bArr2.length - iZzj17) {
                            throw zzfa.zzf();
                        }
                        if (i26 == 0) {
                            zzeyVarZzd.add(zzee.zzb);
                        } else {
                            zzeyVarZzd.add(zzee.zzk(bArr2, iZzj17, i26));
                            iZzj17 += i26;
                        }
                    }
                    return iZzj17;
                }
                return i;
            case 30:
            case 44:
                if (i5 != 2) {
                    if (i5 == 0) {
                        iZzl = zzdt.zzl(i3, bArr2, i, i8, zzeyVarZzd, zzdsVar);
                    }
                    return i;
                }
                iZzl = zzdt.zzf(bArr2, i, zzeyVarZzd, zzdsVar);
                zzeu zzeuVar = (zzeu) obj;
                zzgz zzgzVar = zzeuVar.zzc;
                if (zzgzVar == zzgz.zza()) {
                    zzgzVar = null;
                }
                Object objZzd = zzgj.zzd(i4, zzeyVarZzd, zzx(i6), zzgzVar, this.zzm);
                if (objZzd == null) {
                    return iZzl;
                }
                zzeuVar.zzc = (zzgz) objZzd;
                return iZzl;
            case 33:
            case 47:
                if (i5 == 2) {
                    zzev zzevVar3 = (zzev) zzeyVarZzd;
                    int iZzj19 = zzdt.zzj(bArr2, i, zzdsVar);
                    int i27 = zzdsVar.zza + iZzj19;
                    while (iZzj19 < i27) {
                        iZzj19 = zzdt.zzj(bArr2, iZzj19, zzdsVar);
                        zzevVar3.zze(zzei.zzb(zzdsVar.zza));
                    }
                    if (iZzj19 == i27) {
                        return iZzj19;
                    }
                    throw zzfa.zzf();
                }
                if (i5 == 0) {
                    zzev zzevVar4 = (zzev) zzeyVarZzd;
                    int iZzj20 = zzdt.zzj(bArr2, i, zzdsVar);
                    zzevVar4.zze(zzei.zzb(zzdsVar.zza));
                    while (iZzj20 < i8) {
                        int iZzj21 = zzdt.zzj(bArr2, iZzj20, zzdsVar);
                        if (i3 != zzdsVar.zza) {
                            return iZzj20;
                        }
                        iZzj20 = zzdt.zzj(bArr2, iZzj21, zzdsVar);
                        zzevVar4.zze(zzei.zzb(zzdsVar.zza));
                    }
                    return iZzj20;
                }
                return i;
            case 34:
            case 48:
                if (i5 == 2) {
                    zzfl zzflVar5 = (zzfl) zzeyVarZzd;
                    int iZzj22 = zzdt.zzj(bArr2, i, zzdsVar);
                    int i28 = zzdsVar.zza + iZzj22;
                    while (iZzj22 < i28) {
                        iZzj22 = zzdt.zzm(bArr2, iZzj22, zzdsVar);
                        zzflVar5.zze(zzei.zzc(zzdsVar.zzb));
                    }
                    if (iZzj22 == i28) {
                        return iZzj22;
                    }
                    throw zzfa.zzf();
                }
                if (i5 == 0) {
                    zzfl zzflVar6 = (zzfl) zzeyVarZzd;
                    int iZzm3 = zzdt.zzm(bArr2, i, zzdsVar);
                    zzflVar6.zze(zzei.zzc(zzdsVar.zzb));
                    while (iZzm3 < i8) {
                        int iZzj23 = zzdt.zzj(bArr2, iZzm3, zzdsVar);
                        if (i3 != zzdsVar.zza) {
                            return iZzm3;
                        }
                        iZzm3 = zzdt.zzm(bArr2, iZzj23, zzdsVar);
                        zzflVar6.zze(zzei.zzc(zzdsVar.zzb));
                    }
                    return iZzm3;
                }
                return i;
            default:
                if (i5 == 3) {
                    zzgh zzghVarZzy = zzy(i6);
                    int i29 = (i3 & (-8)) | 4;
                    int iZzc = zzdt.zzc(zzghVarZzy, bArr2, i, i8, i29, zzdsVar);
                    zzeyVarZzd.add(zzdsVar.zzc);
                    while (iZzc < i8) {
                        int iZzj24 = zzdt.zzj(bArr2, iZzc, zzdsVar);
                        if (i3 != zzdsVar.zza) {
                            return iZzc;
                        }
                        iZzc = zzdt.zzc(zzghVarZzy, bArr2, iZzj24, i8, i29, zzdsVar);
                        zzeyVarZzd.add(zzdsVar.zzc);
                        bArr2 = bArr;
                        i8 = i2;
                    }
                    return iZzc;
                }
                return i;
        }
    }

    private final int zzq(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzt(i, 0);
    }

    private final int zzr(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzt(i, i2);
    }

    private final int zzs(int i) {
        return this.zzc[i + 2];
    }

    private final int zzt(int i, int i2) {
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

    private static int zzu(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzv(int i) {
        return this.zzc[i + 1];
    }

    private static long zzw(Object obj, long j) {
        return ((Long) zzhi.zzf(obj, j)).longValue();
    }

    private final zzex zzx(int i) {
        int i2 = i / 3;
        return (zzex) this.zzd[i2 + i2 + 1];
    }

    private final zzgh zzy(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzgh zzghVar = (zzgh) this.zzd[i3];
        if (zzghVar != null) {
            return zzghVar;
        }
        zzgh zzghVarZzb = zzge.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzghVarZzb;
        return zzghVarZzb;
    }

    private final Object zzz(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final int zza(Object obj) {
        int i;
        int iZzc;
        int length = this.zzc.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iZzv = zzv(i3);
            int i4 = this.zzc[i3];
            long j = 1048575 & iZzv;
            int iHashCode = 37;
            switch (zzu(iZzv)) {
                case 0:
                    i = i2 * 53;
                    iZzc = zzez.zzc(Double.doubleToLongBits(zzhi.zza(obj, j)));
                    i2 = i + iZzc;
                    break;
                case 1:
                    i = i2 * 53;
                    iZzc = Float.floatToIntBits(zzhi.zzb(obj, j));
                    i2 = i + iZzc;
                    break;
                case 2:
                    i = i2 * 53;
                    iZzc = zzez.zzc(zzhi.zzd(obj, j));
                    i2 = i + iZzc;
                    break;
                case 3:
                    i = i2 * 53;
                    iZzc = zzez.zzc(zzhi.zzd(obj, j));
                    i2 = i + iZzc;
                    break;
                case 4:
                    i = i2 * 53;
                    iZzc = zzhi.zzc(obj, j);
                    i2 = i + iZzc;
                    break;
                case 5:
                    i = i2 * 53;
                    iZzc = zzez.zzc(zzhi.zzd(obj, j));
                    i2 = i + iZzc;
                    break;
                case 6:
                    i = i2 * 53;
                    iZzc = zzhi.zzc(obj, j);
                    i2 = i + iZzc;
                    break;
                case 7:
                    i = i2 * 53;
                    iZzc = zzez.zza(zzhi.zzt(obj, j));
                    i2 = i + iZzc;
                    break;
                case 8:
                    i = i2 * 53;
                    iZzc = ((String) zzhi.zzf(obj, j)).hashCode();
                    i2 = i + iZzc;
                    break;
                case 9:
                    Object objZzf = zzhi.zzf(obj, j);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iZzc = zzhi.zzf(obj, j).hashCode();
                    i2 = i + iZzc;
                    break;
                case 11:
                    i = i2 * 53;
                    iZzc = zzhi.zzc(obj, j);
                    i2 = i + iZzc;
                    break;
                case 12:
                    i = i2 * 53;
                    iZzc = zzhi.zzc(obj, j);
                    i2 = i + iZzc;
                    break;
                case 13:
                    i = i2 * 53;
                    iZzc = zzhi.zzc(obj, j);
                    i2 = i + iZzc;
                    break;
                case 14:
                    i = i2 * 53;
                    iZzc = zzez.zzc(zzhi.zzd(obj, j));
                    i2 = i + iZzc;
                    break;
                case 15:
                    i = i2 * 53;
                    iZzc = zzhi.zzc(obj, j);
                    i2 = i + iZzc;
                    break;
                case 16:
                    i = i2 * 53;
                    iZzc = zzez.zzc(zzhi.zzd(obj, j));
                    i2 = i + iZzc;
                    break;
                case 17:
                    Object objZzf2 = zzhi.zzf(obj, j);
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
                    iZzc = zzhi.zzf(obj, j).hashCode();
                    i2 = i + iZzc;
                    break;
                case 50:
                    i = i2 * 53;
                    iZzc = zzhi.zzf(obj, j).hashCode();
                    i2 = i + iZzc;
                    break;
                case 51:
                    if (zzJ(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzez.zzc(Double.doubleToLongBits(((Double) zzhi.zzf(obj, j)).doubleValue()));
                        i2 = i + iZzc;
                    }
                    break;
                case 52:
                    if (zzJ(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = Float.floatToIntBits(((Float) zzhi.zzf(obj, j)).floatValue());
                        i2 = i + iZzc;
                    }
                    break;
                case 53:
                    if (zzJ(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzez.zzc(zzw(obj, j));
                        i2 = i + iZzc;
                    }
                    break;
                case 54:
                    if (zzJ(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzez.zzc(zzw(obj, j));
                        i2 = i + iZzc;
                    }
                    break;
                case 55:
                    if (zzJ(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzl(obj, j);
                        i2 = i + iZzc;
                    }
                    break;
                case 56:
                    if (zzJ(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzez.zzc(zzw(obj, j));
                        i2 = i + iZzc;
                    }
                    break;
                case 57:
                    if (zzJ(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzl(obj, j);
                        i2 = i + iZzc;
                    }
                    break;
                case 58:
                    if (zzJ(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzez.zza(((Boolean) zzhi.zzf(obj, j)).booleanValue());
                        i2 = i + iZzc;
                    }
                    break;
                case 59:
                    if (zzJ(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = ((String) zzhi.zzf(obj, j)).hashCode();
                        i2 = i + iZzc;
                    }
                    break;
                case 60:
                    if (zzJ(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzhi.zzf(obj, j).hashCode();
                        i2 = i + iZzc;
                    }
                    break;
                case 61:
                    if (zzJ(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzhi.zzf(obj, j).hashCode();
                        i2 = i + iZzc;
                    }
                    break;
                case 62:
                    if (zzJ(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzl(obj, j);
                        i2 = i + iZzc;
                    }
                    break;
                case 63:
                    if (zzJ(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzl(obj, j);
                        i2 = i + iZzc;
                    }
                    break;
                case 64:
                    if (zzJ(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzl(obj, j);
                        i2 = i + iZzc;
                    }
                    break;
                case 65:
                    if (zzJ(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzez.zzc(zzw(obj, j));
                        i2 = i + iZzc;
                    }
                    break;
                case 66:
                    if (zzJ(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzl(obj, j);
                        i2 = i + iZzc;
                    }
                    break;
                case 67:
                    if (zzJ(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzez.zzc(zzw(obj, j));
                        i2 = i + iZzc;
                    }
                    break;
                case 68:
                    if (zzJ(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzhi.zzf(obj, j).hashCode();
                        i2 = i + iZzc;
                    }
                    break;
            }
        }
        return (i2 * 53) + this.zzm.zza(obj).hashCode();
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 11681. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    final int zzb(java.lang.Object r28, byte[] r29, int r30, int r31, int r32, com.google.android.gms.internal.auth.zzds r33) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1168
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzfz.zzb(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.auth.zzds):int");
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final Object zzd() {
        return ((zzeu) this.zzg).zzi(4, null, null);
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final void zze(Object obj) {
        int i;
        int i2 = this.zzj;
        while (true) {
            i = this.zzk;
            if (i2 >= i) {
                break;
            }
            long jZzv = zzv(this.zzi[i2]) & 1048575;
            Object objZzf = zzhi.zzf(obj, jZzv);
            if (objZzf != null) {
                ((zzfq) objZzf).zzc();
                zzhi.zzp(obj, jZzv, objZzf);
            }
            i2++;
        }
        int length = this.zzi.length;
        while (i < length) {
            this.zzl.zza(obj, this.zzi[i]);
            i++;
        }
        this.zzm.zze(obj);
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final void zzg(Object obj, byte[] bArr, int i, int i2, zzds zzdsVar) throws IOException {
        if (this.zzh) {
            zzo(obj, bArr, i, i2, zzdsVar);
        } else {
            zzb(obj, bArr, i, i2, 0, zzdsVar);
        }
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final boolean zzh(Object obj, Object obj2) {
        boolean zZzh;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int iZzv = zzv(i);
            long j = iZzv & 1048575;
            switch (zzu(iZzv)) {
                case 0:
                    if (!zzF(obj, obj2, i) || Double.doubleToLongBits(zzhi.zza(obj, j)) != Double.doubleToLongBits(zzhi.zza(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzF(obj, obj2, i) || Float.floatToIntBits(zzhi.zzb(obj, j)) != Float.floatToIntBits(zzhi.zzb(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzF(obj, obj2, i) || zzhi.zzd(obj, j) != zzhi.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzF(obj, obj2, i) || zzhi.zzd(obj, j) != zzhi.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzF(obj, obj2, i) || zzhi.zzc(obj, j) != zzhi.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzF(obj, obj2, i) || zzhi.zzd(obj, j) != zzhi.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzF(obj, obj2, i) || zzhi.zzc(obj, j) != zzhi.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzF(obj, obj2, i) || zzhi.zzt(obj, j) != zzhi.zzt(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzF(obj, obj2, i) || !zzgj.zzh(zzhi.zzf(obj, j), zzhi.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzF(obj, obj2, i) || !zzgj.zzh(zzhi.zzf(obj, j), zzhi.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzF(obj, obj2, i) || !zzgj.zzh(zzhi.zzf(obj, j), zzhi.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzF(obj, obj2, i) || zzhi.zzc(obj, j) != zzhi.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzF(obj, obj2, i) || zzhi.zzc(obj, j) != zzhi.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzF(obj, obj2, i) || zzhi.zzc(obj, j) != zzhi.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzF(obj, obj2, i) || zzhi.zzd(obj, j) != zzhi.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzF(obj, obj2, i) || zzhi.zzc(obj, j) != zzhi.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzF(obj, obj2, i) || zzhi.zzd(obj, j) != zzhi.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzF(obj, obj2, i) || !zzgj.zzh(zzhi.zzf(obj, j), zzhi.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
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
                    zZzh = zzgj.zzh(zzhi.zzf(obj, j), zzhi.zzf(obj2, j));
                    break;
                case 50:
                    zZzh = zzgj.zzh(zzhi.zzf(obj, j), zzhi.zzf(obj2, j));
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
                    long jZzs = zzs(i) & 1048575;
                    if (zzhi.zzc(obj, jZzs) != zzhi.zzc(obj2, jZzs) || !zzgj.zzh(zzhi.zzf(obj, j), zzhi.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zZzh) {
                return false;
            }
        }
        return this.zzm.zza(obj).equals(this.zzm.zza(obj2));
    }

    /* JADX WARN: Code duplicated, block: B:42:0x008d  */
    /* JADX WARN: Code duplicated, block: B:44:0x009c  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:50:0x00b2 A[LOOP:1: B:45:0x00a1->B:50:0x00b2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:62:0x00b1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x00c6 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.auth.zzgh
    public final boolean zzi(Object obj) {
        int i;
        int i2;
        List list;
        zzgh zzghVarZzy;
        int i3;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (i5 < this.zzj) {
            int i7 = this.zzi[i5];
            int i8 = this.zzc[i7];
            int iZzv = this.zzv(i7);
            int i9 = this.zzc[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i4) {
                if (i10 != 1048575) {
                    i6 = zzb.getInt(obj, i10);
                }
                i2 = i6;
                i = i10;
            } else {
                i = i4;
                i2 = i6;
            }
            zzfz<T> zzfzVar = this;
            Object obj2 = obj;
            if ((268435456 & iZzv) != 0 && !zzfzVar.zzH(obj2, i7, i, i2, i11)) {
                return false;
            }
            int iZzu = zzu(iZzv);
            if (iZzu == 9 || iZzu == 17) {
                if (zzfzVar.zzH(obj2, i7, i, i2, i11) && !zzI(obj2, iZzv, zzfzVar.zzy(i7))) {
                    return false;
                }
            } else if (iZzu == 27) {
                list = (List) zzhi.zzf(obj2, iZzv & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzghVarZzy = zzfzVar.zzy(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!zzghVarZzy.zzi(list.get(i3))) {
                            return false;
                        }
                    }
                }
            } else if (iZzu == 60 || iZzu == 68) {
                if (zzfzVar.zzJ(obj2, i8, i7) && !zzI(obj2, iZzv, zzfzVar.zzy(i7))) {
                    return false;
                }
            } else if (iZzu == 49) {
                list = (List) zzhi.zzf(obj2, iZzv & 1048575);
                if (list.isEmpty()) {
                    zzghVarZzy = zzfzVar.zzy(i7);
                    while (i3 < list.size()) {
                        if (!zzghVarZzy.zzi(list.get(i3))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iZzu == 50 && !((zzfq) zzhi.zzf(obj2, iZzv & 1048575)).isEmpty()) {
                throw null;
            }
            i5++;
            this = zzfzVar;
            obj = obj2;
            i4 = i;
            i6 = i2;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final void zzf(Object obj, Object obj2) {
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzv = zzv(i);
            long j = 1048575 & iZzv;
            int i2 = this.zzc[i];
            switch (zzu(iZzv)) {
                case 0:
                    if (zzG(obj2, i)) {
                        zzhi.zzl(obj, j, zzhi.zza(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 1:
                    if (zzG(obj2, i)) {
                        zzhi.zzm(obj, j, zzhi.zzb(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 2:
                    if (zzG(obj2, i)) {
                        zzhi.zzo(obj, j, zzhi.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 3:
                    if (zzG(obj2, i)) {
                        zzhi.zzo(obj, j, zzhi.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 4:
                    if (zzG(obj2, i)) {
                        zzhi.zzn(obj, j, zzhi.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 5:
                    if (zzG(obj2, i)) {
                        zzhi.zzo(obj, j, zzhi.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 6:
                    if (zzG(obj2, i)) {
                        zzhi.zzn(obj, j, zzhi.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 7:
                    if (zzG(obj2, i)) {
                        zzhi.zzk(obj, j, zzhi.zzt(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 8:
                    if (zzG(obj2, i)) {
                        zzhi.zzp(obj, j, zzhi.zzf(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 9:
                    zzB(obj, obj2, i);
                    break;
                case 10:
                    if (zzG(obj2, i)) {
                        zzhi.zzp(obj, j, zzhi.zzf(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 11:
                    if (zzG(obj2, i)) {
                        zzhi.zzn(obj, j, zzhi.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 12:
                    if (zzG(obj2, i)) {
                        zzhi.zzn(obj, j, zzhi.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 13:
                    if (zzG(obj2, i)) {
                        zzhi.zzn(obj, j, zzhi.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 14:
                    if (zzG(obj2, i)) {
                        zzhi.zzo(obj, j, zzhi.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 15:
                    if (zzG(obj2, i)) {
                        zzhi.zzn(obj, j, zzhi.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 16:
                    if (zzG(obj2, i)) {
                        zzhi.zzo(obj, j, zzhi.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 17:
                    zzB(obj, obj2, i);
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
                    this.zzl.zzb(obj, obj2, j);
                    break;
                case 50:
                    zzgj.zzi(this.zzp, obj, obj2, j);
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
                    if (zzJ(obj2, i2, i)) {
                        zzhi.zzp(obj, j, zzhi.zzf(obj2, j));
                        zzE(obj, i2, i);
                    }
                    break;
                case 60:
                    zzC(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzJ(obj2, i2, i)) {
                        zzhi.zzp(obj, j, zzhi.zzf(obj2, j));
                        zzE(obj, i2, i);
                    }
                    break;
                case 68:
                    zzC(obj, obj2, i);
                    break;
            }
        }
        zzgj.zzf(this.zzm, obj, obj2);
    }
}
