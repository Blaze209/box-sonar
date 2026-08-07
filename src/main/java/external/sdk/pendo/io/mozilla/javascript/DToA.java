package external.sdk.pendo.io.mozilla.javascript;

import java.math.BigInteger;
import org.apache.commons.codec.language.Soundex;

/* JADX INFO: loaded from: classes4.dex */
class DToA {
    private static final int Bias = 1023;
    private static final int Bletch = 16;
    private static final int Bndry_mask = 1048575;
    static final int DTOSTR_EXPONENTIAL = 3;
    static final int DTOSTR_FIXED = 2;
    static final int DTOSTR_PRECISION = 4;
    static final int DTOSTR_STANDARD = 0;
    static final int DTOSTR_STANDARD_EXPONENTIAL = 1;
    private static final int Exp_11 = 1072693248;
    private static final int Exp_mask = 2146435072;
    private static final int Exp_mask_shifted = 2047;
    private static final int Exp_msk1 = 1048576;
    private static final long Exp_msk1L = 4503599627370496L;
    private static final int Exp_shift = 20;
    private static final int Exp_shift1 = 20;
    private static final int Exp_shiftL = 52;
    private static final int Frac_mask = 1048575;
    private static final int Frac_mask1 = 1048575;
    private static final long Frac_maskL = 4503599627370495L;
    private static final int Int_max = 14;
    private static final int Log2P = 1;
    private static final int P = 53;
    private static final int Quick_max = 14;
    private static final int Sign_bit = Integer.MIN_VALUE;
    private static final int Ten_pmax = 22;
    private static final int n_bigtens = 5;
    private static final double[] tens = {1.0d, 10.0d, 100.0d, 1000.0d, 10000.0d, 100000.0d, 1000000.0d, 1.0E7d, 1.0E8d, 1.0E9d, 1.0E10d, 1.0E11d, 1.0E12d, 1.0E13d, 1.0E14d, 1.0E15d, 1.0E16d, 1.0E17d, 1.0E18d, 1.0E19d, 1.0E20d, 1.0E21d, 1.0E22d};
    private static final double[] bigtens = {1.0E16d, 1.0E32d, 1.0E64d, 1.0E128d, 1.0E256d};
    private static final int[] dtoaModes = {0, 0, 3, 2, 2};

    DToA() {
    }

    private static char BASEDIGIT(int i) {
        return (char) (i >= 10 ? i + 87 : i + 48);
    }

    /* JADX WARN: Code duplicated, block: B:112:0x022b  */
    /* JADX WARN: Code duplicated, block: B:114:0x0233  */
    /* JADX WARN: Code duplicated, block: B:116:0x023b  */
    /* JADX WARN: Code duplicated, block: B:118:0x0243  */
    /* JADX WARN: Code duplicated, block: B:121:0x024d  */
    /* JADX WARN: Code duplicated, block: B:122:0x0250  */
    /* JADX WARN: Code duplicated, block: B:125:0x0257  */
    /* JADX WARN: Code duplicated, block: B:127:0x025b  */
    /* JADX WARN: Code duplicated, block: B:132:0x027e  */
    /* JADX WARN: Code duplicated, block: B:137:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:142:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:145:0x02bb A[LOOP:1: B:128:0x026a->B:145:0x02bb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:146:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:151:0x02ed A[LOOP:9: B:151:0x02ed->B:416:?, LOOP_START] */
    /* JADX WARN: Code duplicated, block: B:154:0x0308  */
    /* JADX WARN: Code duplicated, block: B:159:0x031b  */
    /* JADX WARN: Code duplicated, block: B:161:0x0321  */
    /* JADX WARN: Code duplicated, block: B:164:0x032a A[LOOP:8: B:147:0x02d8->B:164:0x032a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:165:0x032f  */
    /* JADX WARN: Code duplicated, block: B:168:0x0334  */
    /* JADX WARN: Code duplicated, block: B:169:0x0338  */
    /* JADX WARN: Code duplicated, block: B:174:0x034f  */
    /* JADX WARN: Code duplicated, block: B:210:0x03da A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:211:0x03dc  */
    /* JADX WARN: Code duplicated, block: B:213:0x03e0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:214:0x03e2  */
    /* JADX WARN: Code duplicated, block: B:215:0x03e5  */
    /* JADX WARN: Code duplicated, block: B:217:0x03ef  */
    /* JADX WARN: Code duplicated, block: B:219:0x03f5  */
    /* JADX WARN: Code duplicated, block: B:220:0x03f8  */
    /* JADX WARN: Code duplicated, block: B:222:0x03fe  */
    /* JADX WARN: Code duplicated, block: B:223:0x0404  */
    /* JADX WARN: Code duplicated, block: B:225:0x0414  */
    /* JADX WARN: Code duplicated, block: B:227:0x041e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:229:0x0422  */
    /* JADX WARN: Code duplicated, block: B:230:0x0425  */
    /* JADX WARN: Code duplicated, block: B:233:0x042f  */
    /* JADX WARN: Code duplicated, block: B:234:0x0431 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:235:0x0433  */
    /* JADX WARN: Code duplicated, block: B:238:0x043e A[PHI: r2 r5 r11
      0x043e: PHI (r2v29 java.math.BigInteger) = (r2v4 java.math.BigInteger), (r2v30 java.math.BigInteger) binds: [B:233:0x042f, B:237:0x043c] A[DONT_GENERATE, DONT_INLINE]
      0x043e: PHI (r5v21 java.math.BigInteger) = (r5v5 java.math.BigInteger), (r5v23 java.math.BigInteger) binds: [B:233:0x042f, B:237:0x043c] A[DONT_GENERATE, DONT_INLINE]
      0x043e: PHI (r11v23 int) = (r11v19 int), (r11v24 int) binds: [B:233:0x042f, B:237:0x043c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:241:0x0448  */
    /* JADX WARN: Code duplicated, block: B:244:0x044f  */
    /* JADX WARN: Code duplicated, block: B:251:0x046d  */
    /* JADX WARN: Code duplicated, block: B:254:0x0479  */
    /* JADX WARN: Code duplicated, block: B:256:0x0480  */
    /* JADX WARN: Code duplicated, block: B:257:0x0488  */
    /* JADX WARN: Code duplicated, block: B:261:0x0494  */
    /* JADX WARN: Code duplicated, block: B:262:0x049b  */
    /* JADX WARN: Code duplicated, block: B:265:0x04a2  */
    /* JADX WARN: Code duplicated, block: B:268:0x04a7  */
    /* JADX WARN: Code duplicated, block: B:270:0x04af A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:271:0x04b1  */
    /* JADX WARN: Code duplicated, block: B:272:0x04b4  */
    /* JADX WARN: Code duplicated, block: B:274:0x04b8  */
    /* JADX WARN: Code duplicated, block: B:276:0x04be  */
    /* JADX WARN: Code duplicated, block: B:279:0x04c6  */
    /* JADX WARN: Code duplicated, block: B:283:0x04d8  */
    /* JADX WARN: Code duplicated, block: B:286:0x04e4  */
    /* JADX WARN: Code duplicated, block: B:297:0x050b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:298:0x050d  */
    /* JADX WARN: Code duplicated, block: B:301:0x0515  */
    /* JADX WARN: Code duplicated, block: B:302:0x051a  */
    /* JADX WARN: Code duplicated, block: B:306:0x053b  */
    /* JADX WARN: Code duplicated, block: B:307:0x053d  */
    /* JADX WARN: Code duplicated, block: B:309:0x0543 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:323:0x0571  */
    /* JADX WARN: Code duplicated, block: B:325:0x0575 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:349:0x05dc  */
    /* JADX WARN: Code duplicated, block: B:351:0x05e7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:352:0x05e9  */
    /* JADX WARN: Code duplicated, block: B:354:0x05ed A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:356:0x05f0  */
    /* JADX WARN: Code duplicated, block: B:357:0x05f2  */
    /* JADX WARN: Code duplicated, block: B:359:0x05f9  */
    /* JADX WARN: Code duplicated, block: B:361:0x0602  */
    /* JADX WARN: Code duplicated, block: B:364:0x060c  */
    /* JADX WARN: Code duplicated, block: B:365:0x060f  */
    /* JADX WARN: Code duplicated, block: B:368:0x0615  */
    /* JADX WARN: Code duplicated, block: B:374:0x0639 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:380:0x0646  */
    /* JADX WARN: Code duplicated, block: B:382:0x064c  */
    /* JADX WARN: Code duplicated, block: B:386:0x065b A[LOOP:6: B:369:0x0618->B:386:0x065b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:390:0x027b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:391:0x0285 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:392:0x02b7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:402:0x05da A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:409:0x062e A[EDGE_INSN: B:409:0x062e->B:371:0x062e BREAK  A[LOOP:6: B:369:0x0618->B:386:0x065b], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:410:0x029c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:413:0x02e7 A[EDGE_INSN: B:413:0x02e7->B:149:0x02e7 BREAK  A[LOOP:8: B:147:0x02d8->B:164:0x032a], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:414:0x0304 A[SYNTHETIC] */
    static int JS_dtoa(double d, int i, boolean z, int i2, boolean[] zArr, StringBuilder sb) {
        double word0;
        double word1;
        int i3;
        boolean z2;
        int i4;
        double d2;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z3;
        int i11;
        int i12;
        int i13;
        int i14;
        char c;
        int i15;
        int i16;
        int i17;
        BigInteger bigIntegerMultiply;
        int i18;
        int i19;
        int i20;
        int i21;
        BigInteger bigIntegerValueOf;
        int i22;
        byte[] byteArray;
        int i23;
        int i24;
        int i25;
        int i26;
        int iHi0bits;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        BigInteger bigInteger;
        char cIntValue;
        char cIntValue2;
        int iCompareTo;
        int i32;
        BigInteger bigIntegerMultiply2;
        int i33;
        int iCompareTo2;
        BigInteger bigIntegerSubtract;
        int iCompareTo3;
        int i34;
        int iCompareTo4;
        char c2;
        int iCompareTo5;
        int i35;
        int i36;
        int i37;
        int i38;
        int i39;
        char c3;
        int i40;
        double d3;
        int i41;
        int i42;
        int i43;
        int i44;
        double word2;
        double d4;
        int i45;
        double d5;
        char cCharAt;
        char c4;
        int i46;
        double d6;
        double d7;
        int i47;
        double d8;
        double d9;
        char cCharAt2;
        char c5;
        int i48;
        int i49;
        double d10;
        boolean z4;
        boolean z5;
        int i50 = i;
        int[] iArr = new int[1];
        int[] iArr2 = new int[1];
        if ((word0(d) & Integer.MIN_VALUE) != 0) {
            zArr[0] = true;
            word0 = setWord0(d, word0(d) & Integer.MAX_VALUE);
        } else {
            word0 = d;
            zArr[0] = false;
        }
        if ((word0(word0) & Exp_mask) == Exp_mask) {
            sb.append((word1(word0) == 0 && (word0(word0) & 1048575) == 0) ? "Infinity" : "NaN");
            return 9999;
        }
        if (word0 == 0.0d) {
            sb.setLength(0);
            sb.append('0');
            return 1;
        }
        BigInteger bigIntegerD2b = d2b(word0, iArr, iArr2);
        int iWord0 = (word0(word0) >>> 20) & Exp_mask_shifted;
        if (iWord0 != 0) {
            i3 = iWord0 - 1023;
            word1 = setWord0(word0, (word0(word0) & 1048575) | Exp_11);
            z2 = false;
        } else {
            int i51 = iArr2[0] + iArr[0];
            int i52 = i51 + 1074;
            double dWord0 = i52 > 32 ? (((long) word0(word0)) << (64 - i52)) | ((long) (word1(word0) >>> (i51 + 1042))) : ((long) word1(word0)) << (32 - i52);
            word1 = setWord0(dWord0, word0(dWord0) - 32505856);
            i3 = i51 - 1;
            z2 = true;
        }
        boolean z6 = z2;
        double d11 = ((word1 - 1.5d) * 0.289529654602168d) + 0.1760912590558d + (((double) i3) * 0.301029995663981d);
        int i53 = (int) d11;
        if (d11 < r11) {
            i4 = 0;
            d2 = word0;
            if (d11 != i53) {
                i53--;
            }
        } else {
            i4 = 0;
            d2 = word0;
        }
        if (i53 < 0 || i53 > 22) {
            i5 = 1;
        } else {
            if (d2 < tens[i53]) {
                i53--;
            }
            i5 = i4;
        }
        int i54 = (iArr2[i4] - i3) - 1;
        if (i54 >= 0) {
            i7 = i54;
            i6 = i4;
        } else {
            i6 = -i54;
            i7 = i4;
        }
        if (i53 >= 0) {
            i7 += i53;
            i9 = i53;
            i8 = i4;
        } else {
            i6 -= i53;
            i8 = -i53;
            i9 = i4;
        }
        if (i50 < 0 || i50 > 9) {
            i50 = i4;
        }
        if (i50 > 5) {
            i50 -= 4;
            i10 = i4;
        } else {
            i10 = 1;
        }
        if (i50 == 0 || i50 == 1) {
            z3 = true;
            i11 = 1;
            i12 = -1;
            i13 = 0;
            i14 = -1;
        } else {
            if (i50 != 2) {
                if (i50 == 3) {
                    z5 = false;
                } else if (i50 == 4) {
                    z4 = true;
                } else if (i50 != 5) {
                    i13 = i2;
                    z3 = true;
                    i11 = 1;
                    i12 = 0;
                    i14 = 0;
                } else {
                    z5 = true;
                }
                int i55 = i2 + i53;
                z3 = z5;
                i12 = i55 + 1;
                i11 = 1;
                i14 = i55;
                i13 = i2;
            } else {
                z4 = false;
            }
            i13 = i2 <= 0 ? 1 : i2;
            i11 = 1;
            z3 = z4;
            i12 = i13;
            i14 = i12;
        }
        if (i12 >= 0 && i12 <= 14 && i10 != 0) {
            if (i53 > 0) {
                double d12 = tens[i53 & 15];
                int i56 = i53 >> 4;
                if ((i56 & 16) != 0) {
                    i56 &= 15;
                    d10 = d2 / bigtens[4];
                    i41 = 3;
                } else {
                    d10 = d2;
                    i41 = 2;
                }
                double d13 = d12;
                int i57 = i56;
                int i58 = 0;
                while (i57 != 0) {
                    if ((i57 & 1) != 0) {
                        i41++;
                        d13 *= bigtens[i58];
                    }
                    i57 >>= 1;
                    i58++;
                }
                d3 = d10 / d13;
            } else {
                int i59 = -i53;
                if (i59 != 0) {
                    double d14 = tens[i59 & 15] * d2;
                    int i60 = i59 >> 4;
                    i41 = 2;
                    d3 = d14;
                    int i61 = 0;
                    while (i60 != 0) {
                        if ((i60 & 1) != 0) {
                            i41++;
                            d3 *= bigtens[i61];
                        }
                        i60 >>= 1;
                        i61++;
                    }
                } else {
                    d3 = d2;
                    i41 = 2;
                }
            }
            if (i5 != 0 && d3 < 1.0d && i12 > 0) {
                if (i14 <= 0) {
                    iArr = iArr;
                    i42 = i53;
                    i15 = i12;
                    i43 = i41;
                    i44 = i11;
                } else {
                    d3 *= 10.0d;
                    i42 = i53 - 1;
                    i43 = i41 + 1;
                    i15 = i14;
                }
                double d15 = (((double) i43) * d3) + 7.0d;
                word2 = setWord0(d15, word0(d15) - 54525952);
                if (i15 == 0) {
                    d3 -= 5.0d;
                    if (d3 > word2) {
                        sb.append('1');
                        return i42 + 2;
                    }
                    if (d3 < (-word2)) {
                        sb.setLength(0);
                    } else {
                        i44 = i11;
                    }
                    sb.append('0');
                    return i11;
                }
                if (i44 == 0) {
                    if (z3) {
                        d6 = (0.5d / tens[i15 - 1]) - word2;
                        d7 = d3;
                        i47 = 0;
                        while (true) {
                            long j = (long) d7;
                            d8 = d6;
                            d9 = d7 - j;
                            sb.append((char) (j + 48));
                            if (d9 < d8) {
                                return i42 + 1;
                            }
                            if (1.0d - d9 < d8) {
                                do {
                                    cCharAt2 = sb.charAt(sb.length() - 1);
                                    sb.setLength(sb.length() - 1);
                                    if (cCharAt2 != '9') {
                                        c5 = cCharAt2;
                                        i48 = i42;
                                    }
                                    sb.append((char) (c5 + 1));
                                    return i48 + 1;
                                } while (sb.length() != 0);
                                i48 = i42 + 1;
                                c5 = '0';
                                sb.append((char) (c5 + 1));
                                return i48 + 1;
                            }
                            i49 = i47 + 1;
                            if (i49 >= i15) {
                                d3 = d9;
                                break;
                            }
                            d7 = d9 * 10.0d;
                            d6 = d8 * 10.0d;
                            i47 = i49;
                        }
                    } else {
                        d4 = word2 * tens[i15 - 1];
                        i45 = i11;
                        d5 = d3;
                        while (true) {
                            long j2 = (long) d5;
                            d3 = d5 - j2;
                            sb.append((char) (j2 + 48));
                            if (i45 == i15) {
                                break;
                            }
                            i45++;
                            d5 = d3 * 10.0d;
                        }
                        if (d3 > d4 + 0.5d) {
                            do {
                                cCharAt = sb.charAt(sb.length() - 1);
                                sb.setLength(sb.length() - 1);
                                if (cCharAt != '9') {
                                    c4 = cCharAt;
                                    i46 = i42;
                                }
                                sb.append((char) (c4 + 1));
                                return i46 + 1;
                            } while (sb.length() != 0);
                            i46 = i42 + 1;
                            c4 = '0';
                            sb.append((char) (c4 + 1));
                            return i46 + 1;
                        }
                        if (d3 < 0.5d - d4) {
                            stripTrailingZeroes(sb);
                            return i42 + 1;
                        }
                    }
                    i44 = i11;
                } else {
                    i8 = i8;
                }
                c = 0;
                if (i44 != 0) {
                    sb.setLength(0);
                } else {
                    i53 = i42;
                    d2 = d3;
                }
                i16 = iArr[c];
                if (i16 >= 0 || i53 > 14) {
                    if (z3) {
                        if (i50 < 2) {
                            if (z6) {
                                i39 = i16 + 1075;
                            } else {
                                i39 = 54 - iArr2[0];
                            }
                            i19 = i6;
                            i17 = i8;
                        } else {
                            i37 = i15 - 1;
                            i17 = i8;
                            if (i17 >= i37) {
                                i38 = i17 - i37;
                            } else {
                                int i62 = i37 - i17;
                                i9 += i62;
                                i17 += i62;
                                i38 = 0;
                            }
                            if (i15 < 0) {
                                i19 = i6 - i15;
                                i8 = i38;
                                i39 = 0;
                            } else {
                                i8 = i38;
                                i39 = i15;
                                i19 = i6;
                            }
                        }
                        i20 = i6 + i39;
                        i7 += i39;
                        bigIntegerMultiply = BigInteger.valueOf(1L);
                        i18 = i9;
                        i21 = i8;
                    } else {
                        i17 = i8;
                        bigIntegerMultiply = null;
                        i18 = i9;
                        i19 = i6;
                        i20 = i19;
                        i21 = i17;
                    }
                    if (i19 > 0 && i7 > 0) {
                        if (i19 < i7) {
                            i36 = i19;
                        } else {
                            i36 = i7;
                        }
                        i20 -= i36;
                        i19 -= i36;
                        i7 -= i36;
                    }
                    if (i17 > 0) {
                        if (z3) {
                            if (i21 > 0) {
                                bigIntegerMultiply = pow5mult(bigIntegerMultiply, i21);
                                bigIntegerD2b = bigIntegerMultiply.multiply(bigIntegerD2b);
                            }
                            i17 -= i21;
                            if (i17 != 0) {
                                bigIntegerD2b = pow5mult(bigIntegerD2b, i17);
                            }
                        } else {
                            bigIntegerD2b = pow5mult(bigIntegerD2b, i17);
                        }
                    }
                    bigIntegerValueOf = BigInteger.valueOf(1L);
                    if (i18 > 0) {
                        bigIntegerValueOf = pow5mult(bigIntegerValueOf, i18);
                    }
                    if (i50 < 2 || word1(d2) != 0 || (word0(d2) & 1048575) != 0 || (word0(d2) & 2145386496) == 0) {
                        i22 = 0;
                    } else {
                        i20++;
                        i7++;
                        i22 = i11;
                    }
                    byteArray = bigIntegerValueOf.toByteArray();
                    i23 = 4;
                    i24 = 0;
                    i25 = 0;
                    while (i24 < i23) {
                        i35 = i25 << 8;
                        int i63 = i19;
                        if (i24 < byteArray.length) {
                            i25 = (byteArray[i24] & 255) | i35;
                        } else {
                            i25 = i35;
                        }
                        i24++;
                        i23 = 4;
                        i19 = i63;
                    }
                    i26 = i19;
                    if (i18 != 0) {
                        iHi0bits = 32 - hi0bits(i25);
                    } else {
                        iHi0bits = i11;
                    }
                    i27 = (iHi0bits + i7) & 31;
                    if (i27 != 0) {
                        i27 = 32 - i27;
                    }
                    if (i27 > 4) {
                        i29 = i27 - 4;
                    } else {
                        if (i27 < 4) {
                            i29 = i27 + 28;
                        } else {
                            i28 = i26;
                        }
                        if (i20 > 0) {
                            bigIntegerD2b = bigIntegerD2b.shiftLeft(i20);
                        }
                        if (i7 > 0) {
                            bigIntegerValueOf = bigIntegerValueOf.shiftLeft(i7);
                        }
                        if (i5 != 0 && bigIntegerD2b.compareTo(bigIntegerValueOf) < 0) {
                            i53--;
                            bigIntegerD2b = bigIntegerD2b.multiply(BigInteger.valueOf(10L));
                            if (z3) {
                                bigIntegerMultiply = bigIntegerMultiply.multiply(BigInteger.valueOf(10L));
                            }
                            i15 = i14;
                        }
                        if (i15 <= 0 || i50 <= 2) {
                            if (z3) {
                                if (i28 > 0) {
                                    bigIntegerMultiply = bigIntegerMultiply.shiftLeft(i28);
                                }
                                i32 = i11;
                                if (i22 != 0) {
                                    bigIntegerMultiply2 = bigIntegerMultiply.shiftLeft(i32);
                                } else {
                                    bigIntegerMultiply2 = bigIntegerMultiply;
                                }
                                i33 = i32;
                                while (true) {
                                    BigInteger[] bigIntegerArrDivideAndRemainder = bigIntegerD2b.divideAndRemainder(bigIntegerValueOf);
                                    bigInteger = bigIntegerArrDivideAndRemainder[i32];
                                    cIntValue2 = (char) (bigIntegerArrDivideAndRemainder[0].intValue() + 48);
                                    iCompareTo2 = bigInteger.compareTo(bigIntegerMultiply);
                                    bigIntegerSubtract = bigIntegerValueOf.subtract(bigIntegerMultiply2);
                                    if (bigIntegerSubtract.signum() <= 0) {
                                        iCompareTo3 = 1;
                                    } else {
                                        iCompareTo3 = bigInteger.compareTo(bigIntegerSubtract);
                                    }
                                    if (iCompareTo3 != 0 && i50 == 0) {
                                        if ((word1(d2) & 1) == 0) {
                                            if (cIntValue2 != '9') {
                                                if (iCompareTo2 > 0) {
                                                    cIntValue2 = (char) (cIntValue2 + 1);
                                                }
                                                sb.append(cIntValue2);
                                                return i53 + 1;
                                            }
                                            sb.append('9');
                                            if (roundOff(sb)) {
                                                i53++;
                                                sb.append('1');
                                            }
                                            return i53 + 1;
                                        }
                                    }
                                    if (iCompareTo2 >= 0 || (iCompareTo2 == 0 && i50 == 0 && (word1(d2) & 1) == 0)) {
                                        if (iCompareTo3 <= 0) {
                                            i34 = 1;
                                        } else {
                                            iCompareTo4 = bigInteger.shiftLeft(1).compareTo(bigIntegerValueOf);
                                            if (iCompareTo4 > 0) {
                                                c2 = (char) (cIntValue2 + 1);
                                                if (cIntValue2 == '9') {
                                                    sb.append('9');
                                                    if (roundOff(sb)) {
                                                        i53++;
                                                        sb.append('1');
                                                    }
                                                    return i53 + 1;
                                                }
                                                i34 = 1;
                                                cIntValue2 = c2;
                                            } else if (iCompareTo4 != 0) {
                                                i34 = 1;
                                            } else if ((cIntValue2 & 1) != 1 || z) {
                                                c2 = (char) (cIntValue2 + 1);
                                                if (cIntValue2 == '9') {
                                                    sb.append('9');
                                                    if (roundOff(sb)) {
                                                        i53++;
                                                        sb.append('1');
                                                    }
                                                    return i53 + 1;
                                                }
                                                i34 = 1;
                                                cIntValue2 = c2;
                                            } else {
                                                i34 = 1;
                                            }
                                        }
                                        sb.append(cIntValue2);
                                        return i53 + i34;
                                    }
                                    if (iCompareTo3 > 0) {
                                        if (cIntValue2 != '9') {
                                            sb.append((char) (cIntValue2 + 1));
                                            return i53 + 1;
                                        }
                                        sb.append('9');
                                        if (roundOff(sb)) {
                                            i53++;
                                            sb.append('1');
                                        }
                                        return i53 + 1;
                                    }
                                    sb.append(cIntValue2);
                                    if (i33 == i15) {
                                        i30 = 1;
                                        break;
                                    }
                                    bigIntegerD2b = bigInteger.multiply(BigInteger.valueOf(10L));
                                    if (bigIntegerMultiply == bigIntegerMultiply2) {
                                        bigIntegerMultiply = bigIntegerMultiply2.multiply(BigInteger.valueOf(10L));
                                        bigIntegerMultiply2 = bigIntegerMultiply;
                                    } else {
                                        bigIntegerMultiply = bigIntegerMultiply.multiply(BigInteger.valueOf(10L));
                                        bigIntegerMultiply2 = bigIntegerMultiply2.multiply(BigInteger.valueOf(10L));
                                    }
                                    i33++;
                                    i32 = 1;
                                }
                            } else {
                                i30 = i11;
                                i31 = i30;
                                while (true) {
                                    BigInteger[] bigIntegerArrDivideAndRemainder2 = bigIntegerD2b.divideAndRemainder(bigIntegerValueOf);
                                    bigInteger = bigIntegerArrDivideAndRemainder2[i30];
                                    cIntValue = (char) (bigIntegerArrDivideAndRemainder2[0].intValue() + 48);
                                    sb.append(cIntValue);
                                    if (i31 >= i15) {
                                        break;
                                    }
                                    i31++;
                                    bigIntegerD2b = bigInteger.multiply(BigInteger.valueOf(10L));
                                }
                                cIntValue2 = cIntValue;
                            }
                            iCompareTo = bigInteger.shiftLeft(i30).compareTo(bigIntegerValueOf);
                            if (iCompareTo > 0 && (iCompareTo != 0 || ((cIntValue2 & 1) != i30 && !z))) {
                                stripTrailingZeroes(sb);
                            } else if (roundOff(sb)) {
                                sb.append('1');
                                return i53 + 2;
                            }
                            return i53 + 1;
                        }
                        if (i15 >= 0 && (iCompareTo5 = bigIntegerD2b.compareTo(bigIntegerValueOf.multiply(BigInteger.valueOf(5L)))) >= 0 && (iCompareTo5 != 0 || z)) {
                            sb.append('1');
                            return i53 + 2;
                        }
                    }
                    i20 += i29;
                    i7 += i29;
                    i28 = i26 + i29;
                    if (i20 > 0) {
                        bigIntegerD2b = bigIntegerD2b.shiftLeft(i20);
                    }
                    if (i7 > 0) {
                        bigIntegerValueOf = bigIntegerValueOf.shiftLeft(i7);
                    }
                    if (i5 != 0) {
                        i53--;
                        bigIntegerD2b = bigIntegerD2b.multiply(BigInteger.valueOf(10L));
                        if (z3) {
                            bigIntegerMultiply = bigIntegerMultiply.multiply(BigInteger.valueOf(10L));
                        }
                        i15 = i14;
                    }
                    if (i15 <= 0) {
                    }
                    if (z3) {
                        if (i28 > 0) {
                            bigIntegerMultiply = bigIntegerMultiply.shiftLeft(i28);
                        }
                        i32 = i11;
                        if (i22 != 0) {
                            bigIntegerMultiply2 = bigIntegerMultiply.shiftLeft(i32);
                        } else {
                            bigIntegerMultiply2 = bigIntegerMultiply;
                        }
                        i33 = i32;
                        while (true) {
                            BigInteger[] bigIntegerArrDivideAndRemainder3 = bigIntegerD2b.divideAndRemainder(bigIntegerValueOf);
                            bigInteger = bigIntegerArrDivideAndRemainder3[i32];
                            cIntValue2 = (char) (bigIntegerArrDivideAndRemainder3[0].intValue() + 48);
                            iCompareTo2 = bigInteger.compareTo(bigIntegerMultiply);
                            bigIntegerSubtract = bigIntegerValueOf.subtract(bigIntegerMultiply2);
                            if (bigIntegerSubtract.signum() <= 0) {
                                iCompareTo3 = 1;
                            } else {
                                iCompareTo3 = bigInteger.compareTo(bigIntegerSubtract);
                            }
                            if (iCompareTo3 != 0) {
                            }
                            if (iCompareTo2 >= 0) {
                            }
                            if (iCompareTo3 <= 0) {
                                i34 = 1;
                            } else {
                                iCompareTo4 = bigInteger.shiftLeft(1).compareTo(bigIntegerValueOf);
                                if (iCompareTo4 > 0) {
                                    c2 = (char) (cIntValue2 + 1);
                                    if (cIntValue2 == '9') {
                                        sb.append('9');
                                        if (roundOff(sb)) {
                                            i53++;
                                            sb.append('1');
                                        }
                                        return i53 + 1;
                                    }
                                    i34 = 1;
                                    cIntValue2 = c2;
                                } else if (iCompareTo4 != 0) {
                                    if ((cIntValue2 & 1) != 1) {
                                    }
                                    c2 = (char) (cIntValue2 + 1);
                                    if (cIntValue2 == '9') {
                                        sb.append('9');
                                        if (roundOff(sb)) {
                                            i53++;
                                            sb.append('1');
                                        }
                                        return i53 + 1;
                                    }
                                    i34 = 1;
                                    cIntValue2 = c2;
                                } else {
                                    i34 = 1;
                                }
                            }
                            sb.append(cIntValue2);
                            return i53 + i34;
                            i33++;
                            i32 = 1;
                        }
                    } else {
                        i30 = i11;
                        i31 = i30;
                        while (true) {
                            BigInteger[] bigIntegerArrDivideAndRemainder4 = bigIntegerD2b.divideAndRemainder(bigIntegerValueOf);
                            bigInteger = bigIntegerArrDivideAndRemainder4[i30];
                            cIntValue = (char) (bigIntegerArrDivideAndRemainder4[0].intValue() + 48);
                            sb.append(cIntValue);
                            if (i31 >= i15) {
                                break;
                                break;
                            }
                            i31++;
                            bigIntegerD2b = bigInteger.multiply(BigInteger.valueOf(10L));
                        }
                        cIntValue2 = cIntValue;
                    }
                    iCompareTo = bigInteger.shiftLeft(i30).compareTo(bigIntegerValueOf);
                    if (iCompareTo > 0) {
                        if (roundOff(sb)) {
                            sb.append('1');
                            return i53 + 2;
                        }
                    } else if (roundOff(sb)) {
                        sb.append('1');
                        return i53 + 2;
                    }
                    return i53 + 1;
                }
                double d16 = tens[i53];
                if (i13 >= 0 || i15 > 0) {
                    int i64 = i11;
                    while (true) {
                        long j3 = (long) (d2 / d16);
                        double d17 = d2 - (j3 * d16);
                        sb.append((char) (j3 + 48));
                        if (i64 == i15) {
                            double d18 = d17 + d17;
                            if (d18 <= d16 && (d18 != d16 || ((j3 & 1) == 0 && !z))) {
                                break;
                                break;
                            }
                            while (true) {
                                char cCharAt3 = sb.charAt(sb.length() - 1);
                                sb.setLength(sb.length() - 1);
                                if (cCharAt3 != '9') {
                                    int i65 = i53;
                                    c3 = cCharAt3;
                                    i40 = i65;
                                    break;
                                }
                                if (sb.length() == 0) {
                                    i40 = i53 + 1;
                                    c3 = '0';
                                    break;
                                }
                            }
                            sb.append((char) (c3 + 1));
                            i53 = i40;
                            break;
                        }
                        d2 = d17 * 10.0d;
                        if (d2 == 0) {
                            break;
                        }
                        i64++;
                    }
                    return i53 + 1;
                }
                if (i15 >= 0) {
                    double d19 = d16 * 5.0d;
                    if (d2 >= d19 && (z || d2 != d19)) {
                        sb.append('1');
                        return i53 + 2;
                    }
                }
                sb.setLength(0);
                sb.append('0');
                return i11;
            }
            i42 = i53;
            i15 = i12;
            i43 = i41;
            i44 = 0;
            double d110 = (((double) i43) * d3) + 7.0d;
            word2 = setWord0(d110, word0(d110) - 54525952);
            if (i15 == 0) {
                d3 -= 5.0d;
                if (d3 > word2) {
                    sb.append('1');
                    return i42 + 2;
                }
                if (d3 < (-word2)) {
                    sb.setLength(0);
                } else {
                    i44 = i11;
                }
                sb.append('0');
                return i11;
            }
            if (i44 == 0) {
                if (z3) {
                    d6 = (0.5d / tens[i15 - 1]) - word2;
                    d7 = d3;
                    i47 = 0;
                    while (true) {
                        long j4 = (long) d7;
                        d8 = d6;
                        d9 = d7 - j4;
                        sb.append((char) (j4 + 48));
                        if (d9 < d8) {
                            return i42 + 1;
                        }
                        if (1.0d - d9 < d8) {
                            do {
                                cCharAt2 = sb.charAt(sb.length() - 1);
                                sb.setLength(sb.length() - 1);
                                if (cCharAt2 != '9') {
                                    c5 = cCharAt2;
                                    i48 = i42;
                                }
                                sb.append((char) (c5 + 1));
                                return i48 + 1;
                            } while (sb.length() != 0);
                            i48 = i42 + 1;
                            c5 = '0';
                            sb.append((char) (c5 + 1));
                            return i48 + 1;
                        }
                        i49 = i47 + 1;
                        if (i49 >= i15) {
                            d3 = d9;
                            break;
                        }
                        d7 = d9 * 10.0d;
                        d6 = d8 * 10.0d;
                        i47 = i49;
                    }
                } else {
                    d4 = word2 * tens[i15 - 1];
                    i45 = i11;
                    d5 = d3;
                    while (true) {
                        long j5 = (long) d5;
                        d3 = d5 - j5;
                        sb.append((char) (j5 + 48));
                        if (i45 == i15) {
                            break;
                            break;
                        }
                        i45++;
                        d5 = d3 * 10.0d;
                    }
                    if (d3 > d4 + 0.5d) {
                        do {
                            cCharAt = sb.charAt(sb.length() - 1);
                            sb.setLength(sb.length() - 1);
                            if (cCharAt != '9') {
                                c4 = cCharAt;
                                i46 = i42;
                            }
                            sb.append((char) (c4 + 1));
                            return i46 + 1;
                        } while (sb.length() != 0);
                        i46 = i42 + 1;
                        c4 = '0';
                        sb.append((char) (c4 + 1));
                        return i46 + 1;
                    }
                    if (d3 < 0.5d - d4) {
                        stripTrailingZeroes(sb);
                        return i42 + 1;
                    }
                }
                i44 = i11;
            } else {
                i8 = i8;
            }
            c = 0;
            if (i44 != 0) {
                sb.setLength(0);
            } else {
                i53 = i42;
                d2 = d3;
            }
            i16 = iArr[c];
            if (i16 >= 0) {
                if (z3) {
                    if (i50 < 2) {
                        if (z6) {
                            i39 = i16 + 1075;
                        } else {
                            i39 = 54 - iArr2[0];
                        }
                        i19 = i6;
                        i17 = i8;
                    } else {
                        i37 = i15 - 1;
                        i17 = i8;
                        if (i17 >= i37) {
                            i38 = i17 - i37;
                        } else {
                            int i66 = i37 - i17;
                            i9 += i66;
                            i17 += i66;
                            i38 = 0;
                        }
                        if (i15 < 0) {
                            i19 = i6 - i15;
                            i8 = i38;
                            i39 = 0;
                        } else {
                            i8 = i38;
                            i39 = i15;
                            i19 = i6;
                        }
                    }
                    i20 = i6 + i39;
                    i7 += i39;
                    bigIntegerMultiply = BigInteger.valueOf(1L);
                    i18 = i9;
                    i21 = i8;
                } else {
                    i17 = i8;
                    bigIntegerMultiply = null;
                    i18 = i9;
                    i19 = i6;
                    i20 = i19;
                    i21 = i17;
                }
                if (i19 > 0) {
                    if (i19 < i7) {
                        i36 = i19;
                    } else {
                        i36 = i7;
                    }
                    i20 -= i36;
                    i19 -= i36;
                    i7 -= i36;
                }
                if (i17 > 0) {
                    if (z3) {
                        bigIntegerD2b = pow5mult(bigIntegerD2b, i17);
                    } else {
                        if (i21 > 0) {
                            bigIntegerMultiply = pow5mult(bigIntegerMultiply, i21);
                            bigIntegerD2b = bigIntegerMultiply.multiply(bigIntegerD2b);
                        }
                        i17 -= i21;
                        if (i17 != 0) {
                            bigIntegerD2b = pow5mult(bigIntegerD2b, i17);
                        }
                    }
                }
                bigIntegerValueOf = BigInteger.valueOf(1L);
                if (i18 > 0) {
                    bigIntegerValueOf = pow5mult(bigIntegerValueOf, i18);
                }
                if (i50 < 2) {
                    i22 = 0;
                } else {
                    i22 = 0;
                }
                byteArray = bigIntegerValueOf.toByteArray();
                i23 = 4;
                i24 = 0;
                i25 = 0;
                while (i24 < i23) {
                    i35 = i25 << 8;
                    int i67 = i19;
                    if (i24 < byteArray.length) {
                        i25 = (byteArray[i24] & 255) | i35;
                    } else {
                        i25 = i35;
                    }
                    i24++;
                    i23 = 4;
                    i19 = i67;
                }
                i26 = i19;
                if (i18 != 0) {
                    iHi0bits = 32 - hi0bits(i25);
                } else {
                    iHi0bits = i11;
                }
                i27 = (iHi0bits + i7) & 31;
                if (i27 != 0) {
                    i27 = 32 - i27;
                }
                if (i27 > 4) {
                    if (i27 < 4) {
                        i29 = i27 + 28;
                    } else {
                        i28 = i26;
                    }
                    if (i20 > 0) {
                        bigIntegerD2b = bigIntegerD2b.shiftLeft(i20);
                    }
                    if (i7 > 0) {
                        bigIntegerValueOf = bigIntegerValueOf.shiftLeft(i7);
                    }
                    if (i5 != 0) {
                        i53--;
                        bigIntegerD2b = bigIntegerD2b.multiply(BigInteger.valueOf(10L));
                        if (z3) {
                            bigIntegerMultiply = bigIntegerMultiply.multiply(BigInteger.valueOf(10L));
                        }
                        i15 = i14;
                    }
                    if (i15 <= 0) {
                    }
                    if (z3) {
                        if (i28 > 0) {
                            bigIntegerMultiply = bigIntegerMultiply.shiftLeft(i28);
                        }
                        i32 = i11;
                        if (i22 != 0) {
                            bigIntegerMultiply2 = bigIntegerMultiply.shiftLeft(i32);
                        } else {
                            bigIntegerMultiply2 = bigIntegerMultiply;
                        }
                        i33 = i32;
                        while (true) {
                            BigInteger[] bigIntegerArrDivideAndRemainder5 = bigIntegerD2b.divideAndRemainder(bigIntegerValueOf);
                            bigInteger = bigIntegerArrDivideAndRemainder5[i32];
                            cIntValue2 = (char) (bigIntegerArrDivideAndRemainder5[0].intValue() + 48);
                            iCompareTo2 = bigInteger.compareTo(bigIntegerMultiply);
                            bigIntegerSubtract = bigIntegerValueOf.subtract(bigIntegerMultiply2);
                            if (bigIntegerSubtract.signum() <= 0) {
                                iCompareTo3 = 1;
                            } else {
                                iCompareTo3 = bigInteger.compareTo(bigIntegerSubtract);
                            }
                            if (iCompareTo3 != 0) {
                            }
                            if (iCompareTo2 >= 0) {
                            }
                            if (iCompareTo3 <= 0) {
                                i34 = 1;
                            } else {
                                iCompareTo4 = bigInteger.shiftLeft(1).compareTo(bigIntegerValueOf);
                                if (iCompareTo4 > 0) {
                                    c2 = (char) (cIntValue2 + 1);
                                    if (cIntValue2 == '9') {
                                        sb.append('9');
                                        if (roundOff(sb)) {
                                            i53++;
                                            sb.append('1');
                                        }
                                        return i53 + 1;
                                    }
                                    i34 = 1;
                                    cIntValue2 = c2;
                                } else if (iCompareTo4 != 0) {
                                    if ((cIntValue2 & 1) != 1) {
                                    }
                                    c2 = (char) (cIntValue2 + 1);
                                    if (cIntValue2 == '9') {
                                        sb.append('9');
                                        if (roundOff(sb)) {
                                            i53++;
                                            sb.append('1');
                                        }
                                        return i53 + 1;
                                    }
                                    i34 = 1;
                                    cIntValue2 = c2;
                                } else {
                                    i34 = 1;
                                }
                            }
                            sb.append(cIntValue2);
                            return i53 + i34;
                            i33++;
                            i32 = 1;
                        }
                    } else {
                        i30 = i11;
                        i31 = i30;
                        while (true) {
                            BigInteger[] bigIntegerArrDivideAndRemainder6 = bigIntegerD2b.divideAndRemainder(bigIntegerValueOf);
                            bigInteger = bigIntegerArrDivideAndRemainder6[i30];
                            cIntValue = (char) (bigIntegerArrDivideAndRemainder6[0].intValue() + 48);
                            sb.append(cIntValue);
                            if (i31 >= i15) {
                                break;
                                break;
                            }
                            i31++;
                            bigIntegerD2b = bigInteger.multiply(BigInteger.valueOf(10L));
                        }
                        cIntValue2 = cIntValue;
                    }
                    iCompareTo = bigInteger.shiftLeft(i30).compareTo(bigIntegerValueOf);
                    if (iCompareTo > 0) {
                        if (roundOff(sb)) {
                            sb.append('1');
                            return i53 + 2;
                        }
                    } else if (roundOff(sb)) {
                        sb.append('1');
                        return i53 + 2;
                    }
                    return i53 + 1;
                }
                i29 = i27 - 4;
                i20 += i29;
                i7 += i29;
                i28 = i26 + i29;
                if (i20 > 0) {
                    bigIntegerD2b = bigIntegerD2b.shiftLeft(i20);
                }
                if (i7 > 0) {
                    bigIntegerValueOf = bigIntegerValueOf.shiftLeft(i7);
                }
                if (i5 != 0) {
                    i53--;
                    bigIntegerD2b = bigIntegerD2b.multiply(BigInteger.valueOf(10L));
                    if (z3) {
                        bigIntegerMultiply = bigIntegerMultiply.multiply(BigInteger.valueOf(10L));
                    }
                    i15 = i14;
                }
                if (i15 <= 0) {
                }
                if (z3) {
                    if (i28 > 0) {
                        bigIntegerMultiply = bigIntegerMultiply.shiftLeft(i28);
                    }
                    i32 = i11;
                    if (i22 != 0) {
                        bigIntegerMultiply2 = bigIntegerMultiply.shiftLeft(i32);
                    } else {
                        bigIntegerMultiply2 = bigIntegerMultiply;
                    }
                    i33 = i32;
                    while (true) {
                        BigInteger[] bigIntegerArrDivideAndRemainder7 = bigIntegerD2b.divideAndRemainder(bigIntegerValueOf);
                        bigInteger = bigIntegerArrDivideAndRemainder7[i32];
                        cIntValue2 = (char) (bigIntegerArrDivideAndRemainder7[0].intValue() + 48);
                        iCompareTo2 = bigInteger.compareTo(bigIntegerMultiply);
                        bigIntegerSubtract = bigIntegerValueOf.subtract(bigIntegerMultiply2);
                        if (bigIntegerSubtract.signum() <= 0) {
                            iCompareTo3 = 1;
                        } else {
                            iCompareTo3 = bigInteger.compareTo(bigIntegerSubtract);
                        }
                        if (iCompareTo3 != 0) {
                        }
                        if (iCompareTo2 >= 0) {
                        }
                        if (iCompareTo3 <= 0) {
                            i34 = 1;
                        } else {
                            iCompareTo4 = bigInteger.shiftLeft(1).compareTo(bigIntegerValueOf);
                            if (iCompareTo4 > 0) {
                                c2 = (char) (cIntValue2 + 1);
                                if (cIntValue2 == '9') {
                                    sb.append('9');
                                    if (roundOff(sb)) {
                                        i53++;
                                        sb.append('1');
                                    }
                                    return i53 + 1;
                                }
                                i34 = 1;
                                cIntValue2 = c2;
                            } else if (iCompareTo4 != 0) {
                                if ((cIntValue2 & 1) != 1) {
                                }
                                c2 = (char) (cIntValue2 + 1);
                                if (cIntValue2 == '9') {
                                    sb.append('9');
                                    if (roundOff(sb)) {
                                        i53++;
                                        sb.append('1');
                                    }
                                    return i53 + 1;
                                }
                                i34 = 1;
                                cIntValue2 = c2;
                            } else {
                                i34 = 1;
                            }
                        }
                        sb.append(cIntValue2);
                        return i53 + i34;
                        i33++;
                        i32 = 1;
                    }
                } else {
                    i30 = i11;
                    i31 = i30;
                    while (true) {
                        BigInteger[] bigIntegerArrDivideAndRemainder8 = bigIntegerD2b.divideAndRemainder(bigIntegerValueOf);
                        bigInteger = bigIntegerArrDivideAndRemainder8[i30];
                        cIntValue = (char) (bigIntegerArrDivideAndRemainder8[0].intValue() + 48);
                        sb.append(cIntValue);
                        if (i31 >= i15) {
                            break;
                            break;
                        }
                        i31++;
                        bigIntegerD2b = bigInteger.multiply(BigInteger.valueOf(10L));
                    }
                    cIntValue2 = cIntValue;
                }
                iCompareTo = bigInteger.shiftLeft(i30).compareTo(bigIntegerValueOf);
                if (iCompareTo > 0) {
                    if (roundOff(sb)) {
                        sb.append('1');
                        return i53 + 2;
                    }
                } else if (roundOff(sb)) {
                    sb.append('1');
                    return i53 + 2;
                }
                return i53 + 1;
            }
            if (z3) {
                if (i50 < 2) {
                    if (z6) {
                        i39 = i16 + 1075;
                    } else {
                        i39 = 54 - iArr2[0];
                    }
                    i19 = i6;
                    i17 = i8;
                } else {
                    i37 = i15 - 1;
                    i17 = i8;
                    if (i17 >= i37) {
                        i38 = i17 - i37;
                    } else {
                        int i68 = i37 - i17;
                        i9 += i68;
                        i17 += i68;
                        i38 = 0;
                    }
                    if (i15 < 0) {
                        i19 = i6 - i15;
                        i8 = i38;
                        i39 = 0;
                    } else {
                        i8 = i38;
                        i39 = i15;
                        i19 = i6;
                    }
                }
                i20 = i6 + i39;
                i7 += i39;
                bigIntegerMultiply = BigInteger.valueOf(1L);
                i18 = i9;
                i21 = i8;
            } else {
                i17 = i8;
                bigIntegerMultiply = null;
                i18 = i9;
                i19 = i6;
                i20 = i19;
                i21 = i17;
            }
            if (i19 > 0) {
                if (i19 < i7) {
                    i36 = i19;
                } else {
                    i36 = i7;
                }
                i20 -= i36;
                i19 -= i36;
                i7 -= i36;
            }
            if (i17 > 0) {
                if (z3) {
                    bigIntegerD2b = pow5mult(bigIntegerD2b, i17);
                } else {
                    if (i21 > 0) {
                        bigIntegerMultiply = pow5mult(bigIntegerMultiply, i21);
                        bigIntegerD2b = bigIntegerMultiply.multiply(bigIntegerD2b);
                    }
                    i17 -= i21;
                    if (i17 != 0) {
                        bigIntegerD2b = pow5mult(bigIntegerD2b, i17);
                    }
                }
            }
            bigIntegerValueOf = BigInteger.valueOf(1L);
            if (i18 > 0) {
                bigIntegerValueOf = pow5mult(bigIntegerValueOf, i18);
            }
            if (i50 < 2) {
                i22 = 0;
            } else {
                i22 = 0;
            }
            byteArray = bigIntegerValueOf.toByteArray();
            i23 = 4;
            i24 = 0;
            i25 = 0;
            while (i24 < i23) {
                i35 = i25 << 8;
                int i69 = i19;
                if (i24 < byteArray.length) {
                    i25 = (byteArray[i24] & 255) | i35;
                } else {
                    i25 = i35;
                }
                i24++;
                i23 = 4;
                i19 = i69;
            }
            i26 = i19;
            if (i18 != 0) {
                iHi0bits = 32 - hi0bits(i25);
            } else {
                iHi0bits = i11;
            }
            i27 = (iHi0bits + i7) & 31;
            if (i27 != 0) {
                i27 = 32 - i27;
            }
            if (i27 > 4) {
                if (i27 < 4) {
                    i29 = i27 + 28;
                } else {
                    i28 = i26;
                }
                if (i20 > 0) {
                    bigIntegerD2b = bigIntegerD2b.shiftLeft(i20);
                }
                if (i7 > 0) {
                    bigIntegerValueOf = bigIntegerValueOf.shiftLeft(i7);
                }
                if (i5 != 0) {
                    i53--;
                    bigIntegerD2b = bigIntegerD2b.multiply(BigInteger.valueOf(10L));
                    if (z3) {
                        bigIntegerMultiply = bigIntegerMultiply.multiply(BigInteger.valueOf(10L));
                    }
                    i15 = i14;
                }
                if (i15 <= 0) {
                }
                if (z3) {
                    if (i28 > 0) {
                        bigIntegerMultiply = bigIntegerMultiply.shiftLeft(i28);
                    }
                    i32 = i11;
                    if (i22 != 0) {
                        bigIntegerMultiply2 = bigIntegerMultiply.shiftLeft(i32);
                    } else {
                        bigIntegerMultiply2 = bigIntegerMultiply;
                    }
                    i33 = i32;
                    while (true) {
                        BigInteger[] bigIntegerArrDivideAndRemainder9 = bigIntegerD2b.divideAndRemainder(bigIntegerValueOf);
                        bigInteger = bigIntegerArrDivideAndRemainder9[i32];
                        cIntValue2 = (char) (bigIntegerArrDivideAndRemainder9[0].intValue() + 48);
                        iCompareTo2 = bigInteger.compareTo(bigIntegerMultiply);
                        bigIntegerSubtract = bigIntegerValueOf.subtract(bigIntegerMultiply2);
                        if (bigIntegerSubtract.signum() <= 0) {
                            iCompareTo3 = 1;
                        } else {
                            iCompareTo3 = bigInteger.compareTo(bigIntegerSubtract);
                        }
                        if (iCompareTo3 != 0) {
                        }
                        if (iCompareTo2 >= 0) {
                        }
                        if (iCompareTo3 <= 0) {
                            i34 = 1;
                        } else {
                            iCompareTo4 = bigInteger.shiftLeft(1).compareTo(bigIntegerValueOf);
                            if (iCompareTo4 > 0) {
                                c2 = (char) (cIntValue2 + 1);
                                if (cIntValue2 == '9') {
                                    sb.append('9');
                                    if (roundOff(sb)) {
                                        i53++;
                                        sb.append('1');
                                    }
                                    return i53 + 1;
                                }
                                i34 = 1;
                                cIntValue2 = c2;
                            } else if (iCompareTo4 != 0) {
                                if ((cIntValue2 & 1) != 1) {
                                }
                                c2 = (char) (cIntValue2 + 1);
                                if (cIntValue2 == '9') {
                                    sb.append('9');
                                    if (roundOff(sb)) {
                                        i53++;
                                        sb.append('1');
                                    }
                                    return i53 + 1;
                                }
                                i34 = 1;
                                cIntValue2 = c2;
                            } else {
                                i34 = 1;
                            }
                        }
                        sb.append(cIntValue2);
                        return i53 + i34;
                        i33++;
                        i32 = 1;
                    }
                } else {
                    i30 = i11;
                    i31 = i30;
                    while (true) {
                        BigInteger[] bigIntegerArrDivideAndRemainder10 = bigIntegerD2b.divideAndRemainder(bigIntegerValueOf);
                        bigInteger = bigIntegerArrDivideAndRemainder10[i30];
                        cIntValue = (char) (bigIntegerArrDivideAndRemainder10[0].intValue() + 48);
                        sb.append(cIntValue);
                        if (i31 >= i15) {
                            break;
                            break;
                        }
                        i31++;
                        bigIntegerD2b = bigInteger.multiply(BigInteger.valueOf(10L));
                    }
                    cIntValue2 = cIntValue;
                }
                iCompareTo = bigInteger.shiftLeft(i30).compareTo(bigIntegerValueOf);
                if (iCompareTo > 0) {
                    if (roundOff(sb)) {
                        sb.append('1');
                        return i53 + 2;
                    }
                } else if (roundOff(sb)) {
                    sb.append('1');
                    return i53 + 2;
                }
                return i53 + 1;
            }
            i29 = i27 - 4;
            i20 += i29;
            i7 += i29;
            i28 = i26 + i29;
            if (i20 > 0) {
                bigIntegerD2b = bigIntegerD2b.shiftLeft(i20);
            }
            if (i7 > 0) {
                bigIntegerValueOf = bigIntegerValueOf.shiftLeft(i7);
            }
            if (i5 != 0) {
                i53--;
                bigIntegerD2b = bigIntegerD2b.multiply(BigInteger.valueOf(10L));
                if (z3) {
                    bigIntegerMultiply = bigIntegerMultiply.multiply(BigInteger.valueOf(10L));
                }
                i15 = i14;
            }
            if (i15 <= 0) {
            }
            if (z3) {
                if (i28 > 0) {
                    bigIntegerMultiply = bigIntegerMultiply.shiftLeft(i28);
                }
                i32 = i11;
                if (i22 != 0) {
                    bigIntegerMultiply2 = bigIntegerMultiply.shiftLeft(i32);
                } else {
                    bigIntegerMultiply2 = bigIntegerMultiply;
                }
                i33 = i32;
                while (true) {
                    BigInteger[] bigIntegerArrDivideAndRemainder11 = bigIntegerD2b.divideAndRemainder(bigIntegerValueOf);
                    bigInteger = bigIntegerArrDivideAndRemainder11[i32];
                    cIntValue2 = (char) (bigIntegerArrDivideAndRemainder11[0].intValue() + 48);
                    iCompareTo2 = bigInteger.compareTo(bigIntegerMultiply);
                    bigIntegerSubtract = bigIntegerValueOf.subtract(bigIntegerMultiply2);
                    if (bigIntegerSubtract.signum() <= 0) {
                        iCompareTo3 = 1;
                    } else {
                        iCompareTo3 = bigInteger.compareTo(bigIntegerSubtract);
                    }
                    if (iCompareTo3 != 0) {
                    }
                    if (iCompareTo2 >= 0) {
                    }
                    if (iCompareTo3 <= 0) {
                        i34 = 1;
                    } else {
                        iCompareTo4 = bigInteger.shiftLeft(1).compareTo(bigIntegerValueOf);
                        if (iCompareTo4 > 0) {
                            c2 = (char) (cIntValue2 + 1);
                            if (cIntValue2 == '9') {
                                sb.append('9');
                                if (roundOff(sb)) {
                                    i53++;
                                    sb.append('1');
                                }
                                return i53 + 1;
                            }
                            i34 = 1;
                            cIntValue2 = c2;
                        } else if (iCompareTo4 != 0) {
                            if ((cIntValue2 & 1) != 1) {
                            }
                            c2 = (char) (cIntValue2 + 1);
                            if (cIntValue2 == '9') {
                                sb.append('9');
                                if (roundOff(sb)) {
                                    i53++;
                                    sb.append('1');
                                }
                                return i53 + 1;
                            }
                            i34 = 1;
                            cIntValue2 = c2;
                        } else {
                            i34 = 1;
                        }
                    }
                    sb.append(cIntValue2);
                    return i53 + i34;
                    i33++;
                    i32 = 1;
                }
            } else {
                i30 = i11;
                i31 = i30;
                while (true) {
                    BigInteger[] bigIntegerArrDivideAndRemainder12 = bigIntegerD2b.divideAndRemainder(bigIntegerValueOf);
                    bigInteger = bigIntegerArrDivideAndRemainder12[i30];
                    cIntValue = (char) (bigIntegerArrDivideAndRemainder12[0].intValue() + 48);
                    sb.append(cIntValue);
                    if (i31 >= i15) {
                        break;
                        break;
                    }
                    i31++;
                    bigIntegerD2b = bigInteger.multiply(BigInteger.valueOf(10L));
                }
                cIntValue2 = cIntValue;
            }
            iCompareTo = bigInteger.shiftLeft(i30).compareTo(bigIntegerValueOf);
            if (iCompareTo > 0) {
                if (roundOff(sb)) {
                    sb.append('1');
                    return i53 + 2;
                }
            } else if (roundOff(sb)) {
                sb.append('1');
                return i53 + 2;
            }
            return i53 + 1;
            sb.setLength(0);
            sb.append('0');
            return i11;
        }
        iArr = iArr;
        i5 = i5;
        i6 = i6;
        i8 = i8;
        c = 0;
        i15 = i12;
        i16 = iArr[c];
        if (i16 >= 0) {
            if (z3) {
                if (i50 < 2) {
                    if (z6) {
                        i39 = i16 + 1075;
                    } else {
                        i39 = 54 - iArr2[0];
                    }
                    i19 = i6;
                    i17 = i8;
                } else {
                    i37 = i15 - 1;
                    i17 = i8;
                    if (i17 >= i37) {
                        i38 = i17 - i37;
                    } else {
                        int i610 = i37 - i17;
                        i9 += i610;
                        i17 += i610;
                        i38 = 0;
                    }
                    if (i15 < 0) {
                        i19 = i6 - i15;
                        i8 = i38;
                        i39 = 0;
                    } else {
                        i8 = i38;
                        i39 = i15;
                        i19 = i6;
                    }
                }
                i20 = i6 + i39;
                i7 += i39;
                bigIntegerMultiply = BigInteger.valueOf(1L);
                i18 = i9;
                i21 = i8;
            } else {
                i17 = i8;
                bigIntegerMultiply = null;
                i18 = i9;
                i19 = i6;
                i20 = i19;
                i21 = i17;
            }
            if (i19 > 0) {
                if (i19 < i7) {
                    i36 = i19;
                } else {
                    i36 = i7;
                }
                i20 -= i36;
                i19 -= i36;
                i7 -= i36;
            }
            if (i17 > 0) {
                if (z3) {
                    bigIntegerD2b = pow5mult(bigIntegerD2b, i17);
                } else {
                    if (i21 > 0) {
                        bigIntegerMultiply = pow5mult(bigIntegerMultiply, i21);
                        bigIntegerD2b = bigIntegerMultiply.multiply(bigIntegerD2b);
                    }
                    i17 -= i21;
                    if (i17 != 0) {
                        bigIntegerD2b = pow5mult(bigIntegerD2b, i17);
                    }
                }
            }
            bigIntegerValueOf = BigInteger.valueOf(1L);
            if (i18 > 0) {
                bigIntegerValueOf = pow5mult(bigIntegerValueOf, i18);
            }
            if (i50 < 2) {
                i22 = 0;
            } else {
                i22 = 0;
            }
            byteArray = bigIntegerValueOf.toByteArray();
            i23 = 4;
            i24 = 0;
            i25 = 0;
            while (i24 < i23) {
                i35 = i25 << 8;
                int i611 = i19;
                if (i24 < byteArray.length) {
                    i25 = (byteArray[i24] & 255) | i35;
                } else {
                    i25 = i35;
                }
                i24++;
                i23 = 4;
                i19 = i611;
            }
            i26 = i19;
            if (i18 != 0) {
                iHi0bits = 32 - hi0bits(i25);
            } else {
                iHi0bits = i11;
            }
            i27 = (iHi0bits + i7) & 31;
            if (i27 != 0) {
                i27 = 32 - i27;
            }
            if (i27 > 4) {
                if (i27 < 4) {
                    i29 = i27 + 28;
                } else {
                    i28 = i26;
                }
                if (i20 > 0) {
                    bigIntegerD2b = bigIntegerD2b.shiftLeft(i20);
                }
                if (i7 > 0) {
                    bigIntegerValueOf = bigIntegerValueOf.shiftLeft(i7);
                }
                if (i5 != 0) {
                    i53--;
                    bigIntegerD2b = bigIntegerD2b.multiply(BigInteger.valueOf(10L));
                    if (z3) {
                        bigIntegerMultiply = bigIntegerMultiply.multiply(BigInteger.valueOf(10L));
                    }
                    i15 = i14;
                }
                if (i15 <= 0) {
                }
                if (z3) {
                    if (i28 > 0) {
                        bigIntegerMultiply = bigIntegerMultiply.shiftLeft(i28);
                    }
                    i32 = i11;
                    if (i22 != 0) {
                        bigIntegerMultiply2 = bigIntegerMultiply.shiftLeft(i32);
                    } else {
                        bigIntegerMultiply2 = bigIntegerMultiply;
                    }
                    i33 = i32;
                    while (true) {
                        BigInteger[] bigIntegerArrDivideAndRemainder13 = bigIntegerD2b.divideAndRemainder(bigIntegerValueOf);
                        bigInteger = bigIntegerArrDivideAndRemainder13[i32];
                        cIntValue2 = (char) (bigIntegerArrDivideAndRemainder13[0].intValue() + 48);
                        iCompareTo2 = bigInteger.compareTo(bigIntegerMultiply);
                        bigIntegerSubtract = bigIntegerValueOf.subtract(bigIntegerMultiply2);
                        if (bigIntegerSubtract.signum() <= 0) {
                            iCompareTo3 = 1;
                        } else {
                            iCompareTo3 = bigInteger.compareTo(bigIntegerSubtract);
                        }
                        if (iCompareTo3 != 0) {
                        }
                        if (iCompareTo2 >= 0) {
                        }
                        if (iCompareTo3 <= 0) {
                            i34 = 1;
                        } else {
                            iCompareTo4 = bigInteger.shiftLeft(1).compareTo(bigIntegerValueOf);
                            if (iCompareTo4 > 0) {
                                c2 = (char) (cIntValue2 + 1);
                                if (cIntValue2 == '9') {
                                    sb.append('9');
                                    if (roundOff(sb)) {
                                        i53++;
                                        sb.append('1');
                                    }
                                    return i53 + 1;
                                }
                                i34 = 1;
                                cIntValue2 = c2;
                            } else if (iCompareTo4 != 0) {
                                if ((cIntValue2 & 1) != 1) {
                                }
                                c2 = (char) (cIntValue2 + 1);
                                if (cIntValue2 == '9') {
                                    sb.append('9');
                                    if (roundOff(sb)) {
                                        i53++;
                                        sb.append('1');
                                    }
                                    return i53 + 1;
                                }
                                i34 = 1;
                                cIntValue2 = c2;
                            } else {
                                i34 = 1;
                            }
                        }
                        sb.append(cIntValue2);
                        return i53 + i34;
                        i33++;
                        i32 = 1;
                    }
                } else {
                    i30 = i11;
                    i31 = i30;
                    while (true) {
                        BigInteger[] bigIntegerArrDivideAndRemainder14 = bigIntegerD2b.divideAndRemainder(bigIntegerValueOf);
                        bigInteger = bigIntegerArrDivideAndRemainder14[i30];
                        cIntValue = (char) (bigIntegerArrDivideAndRemainder14[0].intValue() + 48);
                        sb.append(cIntValue);
                        if (i31 >= i15) {
                            break;
                            break;
                        }
                        i31++;
                        bigIntegerD2b = bigInteger.multiply(BigInteger.valueOf(10L));
                    }
                    cIntValue2 = cIntValue;
                }
                iCompareTo = bigInteger.shiftLeft(i30).compareTo(bigIntegerValueOf);
                if (iCompareTo > 0) {
                    if (roundOff(sb)) {
                        sb.append('1');
                        return i53 + 2;
                    }
                } else if (roundOff(sb)) {
                    sb.append('1');
                    return i53 + 2;
                }
                return i53 + 1;
            }
            i29 = i27 - 4;
            i20 += i29;
            i7 += i29;
            i28 = i26 + i29;
            if (i20 > 0) {
                bigIntegerD2b = bigIntegerD2b.shiftLeft(i20);
            }
            if (i7 > 0) {
                bigIntegerValueOf = bigIntegerValueOf.shiftLeft(i7);
            }
            if (i5 != 0) {
                i53--;
                bigIntegerD2b = bigIntegerD2b.multiply(BigInteger.valueOf(10L));
                if (z3) {
                    bigIntegerMultiply = bigIntegerMultiply.multiply(BigInteger.valueOf(10L));
                }
                i15 = i14;
            }
            if (i15 <= 0) {
            }
            if (z3) {
                if (i28 > 0) {
                    bigIntegerMultiply = bigIntegerMultiply.shiftLeft(i28);
                }
                i32 = i11;
                if (i22 != 0) {
                    bigIntegerMultiply2 = bigIntegerMultiply.shiftLeft(i32);
                } else {
                    bigIntegerMultiply2 = bigIntegerMultiply;
                }
                i33 = i32;
                while (true) {
                    BigInteger[] bigIntegerArrDivideAndRemainder15 = bigIntegerD2b.divideAndRemainder(bigIntegerValueOf);
                    bigInteger = bigIntegerArrDivideAndRemainder15[i32];
                    cIntValue2 = (char) (bigIntegerArrDivideAndRemainder15[0].intValue() + 48);
                    iCompareTo2 = bigInteger.compareTo(bigIntegerMultiply);
                    bigIntegerSubtract = bigIntegerValueOf.subtract(bigIntegerMultiply2);
                    if (bigIntegerSubtract.signum() <= 0) {
                        iCompareTo3 = 1;
                    } else {
                        iCompareTo3 = bigInteger.compareTo(bigIntegerSubtract);
                    }
                    if (iCompareTo3 != 0) {
                    }
                    if (iCompareTo2 >= 0) {
                    }
                    if (iCompareTo3 <= 0) {
                        i34 = 1;
                    } else {
                        iCompareTo4 = bigInteger.shiftLeft(1).compareTo(bigIntegerValueOf);
                        if (iCompareTo4 > 0) {
                            c2 = (char) (cIntValue2 + 1);
                            if (cIntValue2 == '9') {
                                sb.append('9');
                                if (roundOff(sb)) {
                                    i53++;
                                    sb.append('1');
                                }
                                return i53 + 1;
                            }
                            i34 = 1;
                            cIntValue2 = c2;
                        } else if (iCompareTo4 != 0) {
                            if ((cIntValue2 & 1) != 1) {
                            }
                            c2 = (char) (cIntValue2 + 1);
                            if (cIntValue2 == '9') {
                                sb.append('9');
                                if (roundOff(sb)) {
                                    i53++;
                                    sb.append('1');
                                }
                                return i53 + 1;
                            }
                            i34 = 1;
                            cIntValue2 = c2;
                        } else {
                            i34 = 1;
                        }
                    }
                    sb.append(cIntValue2);
                    return i53 + i34;
                    i33++;
                    i32 = 1;
                }
            } else {
                i30 = i11;
                i31 = i30;
                while (true) {
                    BigInteger[] bigIntegerArrDivideAndRemainder16 = bigIntegerD2b.divideAndRemainder(bigIntegerValueOf);
                    bigInteger = bigIntegerArrDivideAndRemainder16[i30];
                    cIntValue = (char) (bigIntegerArrDivideAndRemainder16[0].intValue() + 48);
                    sb.append(cIntValue);
                    if (i31 >= i15) {
                        break;
                        break;
                    }
                    i31++;
                    bigIntegerD2b = bigInteger.multiply(BigInteger.valueOf(10L));
                }
                cIntValue2 = cIntValue;
            }
            iCompareTo = bigInteger.shiftLeft(i30).compareTo(bigIntegerValueOf);
            if (iCompareTo > 0) {
                if (roundOff(sb)) {
                    sb.append('1');
                    return i53 + 2;
                }
            } else if (roundOff(sb)) {
                sb.append('1');
                return i53 + 2;
            }
            return i53 + 1;
        }
        if (z3) {
            if (i50 < 2) {
                if (z6) {
                    i39 = i16 + 1075;
                } else {
                    i39 = 54 - iArr2[0];
                }
                i19 = i6;
                i17 = i8;
            } else {
                i37 = i15 - 1;
                i17 = i8;
                if (i17 >= i37) {
                    i38 = i17 - i37;
                } else {
                    int i612 = i37 - i17;
                    i9 += i612;
                    i17 += i612;
                    i38 = 0;
                }
                if (i15 < 0) {
                    i19 = i6 - i15;
                    i8 = i38;
                    i39 = 0;
                } else {
                    i8 = i38;
                    i39 = i15;
                    i19 = i6;
                }
            }
            i20 = i6 + i39;
            i7 += i39;
            bigIntegerMultiply = BigInteger.valueOf(1L);
            i18 = i9;
            i21 = i8;
        } else {
            i17 = i8;
            bigIntegerMultiply = null;
            i18 = i9;
            i19 = i6;
            i20 = i19;
            i21 = i17;
        }
        if (i19 > 0) {
            if (i19 < i7) {
                i36 = i19;
            } else {
                i36 = i7;
            }
            i20 -= i36;
            i19 -= i36;
            i7 -= i36;
        }
        if (i17 > 0) {
            if (z3) {
                bigIntegerD2b = pow5mult(bigIntegerD2b, i17);
            } else {
                if (i21 > 0) {
                    bigIntegerMultiply = pow5mult(bigIntegerMultiply, i21);
                    bigIntegerD2b = bigIntegerMultiply.multiply(bigIntegerD2b);
                }
                i17 -= i21;
                if (i17 != 0) {
                    bigIntegerD2b = pow5mult(bigIntegerD2b, i17);
                }
            }
        }
        bigIntegerValueOf = BigInteger.valueOf(1L);
        if (i18 > 0) {
            bigIntegerValueOf = pow5mult(bigIntegerValueOf, i18);
        }
        if (i50 < 2) {
            i22 = 0;
        } else {
            i22 = 0;
        }
        byteArray = bigIntegerValueOf.toByteArray();
        i23 = 4;
        i24 = 0;
        i25 = 0;
        while (i24 < i23) {
            i35 = i25 << 8;
            int i613 = i19;
            if (i24 < byteArray.length) {
                i25 = (byteArray[i24] & 255) | i35;
            } else {
                i25 = i35;
            }
            i24++;
            i23 = 4;
            i19 = i613;
        }
        i26 = i19;
        if (i18 != 0) {
            iHi0bits = 32 - hi0bits(i25);
        } else {
            iHi0bits = i11;
        }
        i27 = (iHi0bits + i7) & 31;
        if (i27 != 0) {
            i27 = 32 - i27;
        }
        if (i27 > 4) {
            if (i27 < 4) {
                i29 = i27 + 28;
            } else {
                i28 = i26;
            }
            if (i20 > 0) {
                bigIntegerD2b = bigIntegerD2b.shiftLeft(i20);
            }
            if (i7 > 0) {
                bigIntegerValueOf = bigIntegerValueOf.shiftLeft(i7);
            }
            if (i5 != 0) {
                i53--;
                bigIntegerD2b = bigIntegerD2b.multiply(BigInteger.valueOf(10L));
                if (z3) {
                    bigIntegerMultiply = bigIntegerMultiply.multiply(BigInteger.valueOf(10L));
                }
                i15 = i14;
            }
            if (i15 <= 0) {
            }
            if (z3) {
                if (i28 > 0) {
                    bigIntegerMultiply = bigIntegerMultiply.shiftLeft(i28);
                }
                i32 = i11;
                if (i22 != 0) {
                    bigIntegerMultiply2 = bigIntegerMultiply.shiftLeft(i32);
                } else {
                    bigIntegerMultiply2 = bigIntegerMultiply;
                }
                i33 = i32;
                while (true) {
                    BigInteger[] bigIntegerArrDivideAndRemainder17 = bigIntegerD2b.divideAndRemainder(bigIntegerValueOf);
                    bigInteger = bigIntegerArrDivideAndRemainder17[i32];
                    cIntValue2 = (char) (bigIntegerArrDivideAndRemainder17[0].intValue() + 48);
                    iCompareTo2 = bigInteger.compareTo(bigIntegerMultiply);
                    bigIntegerSubtract = bigIntegerValueOf.subtract(bigIntegerMultiply2);
                    if (bigIntegerSubtract.signum() <= 0) {
                        iCompareTo3 = 1;
                    } else {
                        iCompareTo3 = bigInteger.compareTo(bigIntegerSubtract);
                    }
                    if (iCompareTo3 != 0) {
                    }
                    if (iCompareTo2 >= 0) {
                    }
                    if (iCompareTo3 <= 0) {
                        i34 = 1;
                    } else {
                        iCompareTo4 = bigInteger.shiftLeft(1).compareTo(bigIntegerValueOf);
                        if (iCompareTo4 > 0) {
                            c2 = (char) (cIntValue2 + 1);
                            if (cIntValue2 == '9') {
                                sb.append('9');
                                if (roundOff(sb)) {
                                    i53++;
                                    sb.append('1');
                                }
                                return i53 + 1;
                            }
                            i34 = 1;
                            cIntValue2 = c2;
                        } else if (iCompareTo4 != 0) {
                            if ((cIntValue2 & 1) != 1) {
                            }
                            c2 = (char) (cIntValue2 + 1);
                            if (cIntValue2 == '9') {
                                sb.append('9');
                                if (roundOff(sb)) {
                                    i53++;
                                    sb.append('1');
                                }
                                return i53 + 1;
                            }
                            i34 = 1;
                            cIntValue2 = c2;
                        } else {
                            i34 = 1;
                        }
                    }
                    sb.append(cIntValue2);
                    return i53 + i34;
                    i33++;
                    i32 = 1;
                }
            } else {
                i30 = i11;
                i31 = i30;
                while (true) {
                    BigInteger[] bigIntegerArrDivideAndRemainder18 = bigIntegerD2b.divideAndRemainder(bigIntegerValueOf);
                    bigInteger = bigIntegerArrDivideAndRemainder18[i30];
                    cIntValue = (char) (bigIntegerArrDivideAndRemainder18[0].intValue() + 48);
                    sb.append(cIntValue);
                    if (i31 >= i15) {
                        break;
                        break;
                    }
                    i31++;
                    bigIntegerD2b = bigInteger.multiply(BigInteger.valueOf(10L));
                }
                cIntValue2 = cIntValue;
            }
            iCompareTo = bigInteger.shiftLeft(i30).compareTo(bigIntegerValueOf);
            if (iCompareTo > 0) {
                if (roundOff(sb)) {
                    sb.append('1');
                    return i53 + 2;
                }
            } else if (roundOff(sb)) {
                sb.append('1');
                return i53 + 2;
            }
            return i53 + 1;
        }
        i29 = i27 - 4;
        i20 += i29;
        i7 += i29;
        i28 = i26 + i29;
        if (i20 > 0) {
            bigIntegerD2b = bigIntegerD2b.shiftLeft(i20);
        }
        if (i7 > 0) {
            bigIntegerValueOf = bigIntegerValueOf.shiftLeft(i7);
        }
        if (i5 != 0) {
            i53--;
            bigIntegerD2b = bigIntegerD2b.multiply(BigInteger.valueOf(10L));
            if (z3) {
                bigIntegerMultiply = bigIntegerMultiply.multiply(BigInteger.valueOf(10L));
            }
            i15 = i14;
        }
        if (i15 <= 0) {
        }
        if (z3) {
            if (i28 > 0) {
                bigIntegerMultiply = bigIntegerMultiply.shiftLeft(i28);
            }
            i32 = i11;
            if (i22 != 0) {
                bigIntegerMultiply2 = bigIntegerMultiply.shiftLeft(i32);
            } else {
                bigIntegerMultiply2 = bigIntegerMultiply;
            }
            i33 = i32;
            while (true) {
                BigInteger[] bigIntegerArrDivideAndRemainder19 = bigIntegerD2b.divideAndRemainder(bigIntegerValueOf);
                bigInteger = bigIntegerArrDivideAndRemainder19[i32];
                cIntValue2 = (char) (bigIntegerArrDivideAndRemainder19[0].intValue() + 48);
                iCompareTo2 = bigInteger.compareTo(bigIntegerMultiply);
                bigIntegerSubtract = bigIntegerValueOf.subtract(bigIntegerMultiply2);
                if (bigIntegerSubtract.signum() <= 0) {
                    iCompareTo3 = 1;
                } else {
                    iCompareTo3 = bigInteger.compareTo(bigIntegerSubtract);
                }
                if (iCompareTo3 != 0) {
                }
                if (iCompareTo2 >= 0) {
                }
                if (iCompareTo3 <= 0) {
                    i34 = 1;
                } else {
                    iCompareTo4 = bigInteger.shiftLeft(1).compareTo(bigIntegerValueOf);
                    if (iCompareTo4 > 0) {
                        c2 = (char) (cIntValue2 + 1);
                        if (cIntValue2 == '9') {
                            sb.append('9');
                            if (roundOff(sb)) {
                                i53++;
                                sb.append('1');
                            }
                            return i53 + 1;
                        }
                        i34 = 1;
                        cIntValue2 = c2;
                    } else if (iCompareTo4 != 0) {
                        if ((cIntValue2 & 1) != 1) {
                        }
                        c2 = (char) (cIntValue2 + 1);
                        if (cIntValue2 == '9') {
                            sb.append('9');
                            if (roundOff(sb)) {
                                i53++;
                                sb.append('1');
                            }
                            return i53 + 1;
                        }
                        i34 = 1;
                        cIntValue2 = c2;
                    } else {
                        i34 = 1;
                    }
                }
                sb.append(cIntValue2);
                return i53 + i34;
                i33++;
                i32 = 1;
            }
        } else {
            i30 = i11;
            i31 = i30;
            while (true) {
                BigInteger[] bigIntegerArrDivideAndRemainder110 = bigIntegerD2b.divideAndRemainder(bigIntegerValueOf);
                bigInteger = bigIntegerArrDivideAndRemainder110[i30];
                cIntValue = (char) (bigIntegerArrDivideAndRemainder110[0].intValue() + 48);
                sb.append(cIntValue);
                if (i31 >= i15) {
                    break;
                    break;
                }
                i31++;
                bigIntegerD2b = bigInteger.multiply(BigInteger.valueOf(10L));
            }
            cIntValue2 = cIntValue;
        }
        iCompareTo = bigInteger.shiftLeft(i30).compareTo(bigIntegerValueOf);
        if (iCompareTo > 0) {
            if (roundOff(sb)) {
                sb.append('1');
                return i53 + 2;
            }
        } else if (roundOff(sb)) {
            sb.append('1');
            return i53 + 2;
        }
        return i53 + 1;
        sb.setLength(0);
        sb.append('0');
        return i11;
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x0121, code lost:
    
        if (r8 > 0) goto L77;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static java.lang.String JS_dtobasestr(int r12, double r13) {
        /*
            Method dump skipped, instruction units count: 345
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.DToA.JS_dtobasestr(int, double):java.lang.String");
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0057  */
    static void JS_dtostr(StringBuilder sb, int i, int i2, double d) {
        boolean z;
        boolean[] zArr = new boolean[1];
        if (i == 2 && (d >= 1.0E21d || d <= -1.0E21d)) {
            i = 0;
        }
        int i3 = i2;
        int iJS_dtoa = JS_dtoa(d, dtoaModes[i], i >= 2, i3, zArr, sb);
        int length = sb.length();
        if (iJS_dtoa != 9999) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                z = false;
                                i3 = 0;
                            } else if (iJS_dtoa < -5 || iJS_dtoa > i3) {
                            }
                        }
                    } else if (i3 >= 0) {
                        i3 = iJS_dtoa + i3;
                    } else {
                        i3 = iJS_dtoa;
                    }
                    z = false;
                } else {
                    i3 = 0;
                }
                z = true;
            } else if (iJS_dtoa < -5 || iJS_dtoa > 21) {
                z = true;
                i3 = 0;
            } else {
                i3 = iJS_dtoa;
                z = false;
            }
            if (length < i3) {
                do {
                    sb.append('0');
                } while (sb.length() != i3);
                length = i3;
            }
            if (z) {
                if (length != 1) {
                    sb.insert(1, '.');
                }
                sb.append('e');
                int i4 = iJS_dtoa - 1;
                if (i4 >= 0) {
                    sb.append('+');
                }
                sb.append(i4);
            } else if (iJS_dtoa != length) {
                if (iJS_dtoa > 0) {
                    sb.insert(iJS_dtoa, '.');
                } else {
                    for (int i5 = 0; i5 < 1 - iJS_dtoa; i5++) {
                        sb.insert(0, '0');
                    }
                    sb.insert(1, '.');
                }
            }
        }
        if (zArr[0]) {
            if (word0(d) == Integer.MIN_VALUE && word1(d) == 0) {
                return;
            }
            if ((word0(d) & Exp_mask) != Exp_mask || (word1(d) == 0 && (word0(d) & 1048575) == 0)) {
                sb.insert(0, Soundex.SILENT_MARKER);
            }
        }
    }

    private static BigInteger d2b(double d, int[] iArr, int[] iArr2) {
        byte[] bArr;
        int iLo0bits;
        long jDoubleToLongBits = Double.doubleToLongBits(d);
        int i = (int) (jDoubleToLongBits >>> 32);
        int i2 = (int) jDoubleToLongBits;
        int i3 = 1048575 & i;
        int i4 = (i & Integer.MAX_VALUE) >>> 20;
        if (i4 != 0) {
            i3 |= 1048576;
        }
        int i5 = 1;
        if (i2 != 0) {
            bArr = new byte[8];
            iLo0bits = lo0bits(i2);
            int i6 = i2 >>> iLo0bits;
            if (iLo0bits != 0) {
                stuffBits(bArr, 4, i6 | (i3 << (32 - iLo0bits)));
                i3 >>= iLo0bits;
            } else {
                stuffBits(bArr, 4, i6);
            }
            stuffBits(bArr, 0, i3);
            if (i3 != 0) {
                i5 = 2;
            }
        } else {
            bArr = new byte[4];
            int iLo0bits2 = lo0bits(i3);
            i3 >>>= iLo0bits2;
            stuffBits(bArr, 0, i3);
            iLo0bits = iLo0bits2 + 32;
        }
        if (i4 != 0) {
            iArr[0] = (i4 - 1075) + iLo0bits;
            iArr2[0] = 53 - iLo0bits;
        } else {
            iArr[0] = (i4 - 1074) + iLo0bits;
            iArr2[0] = (i5 * 32) - hi0bits(i3);
        }
        return new BigInteger(bArr);
    }

    private static int hi0bits(int i) {
        int i2;
        if (((-65536) & i) == 0) {
            i <<= 16;
            i2 = 16;
        } else {
            i2 = 0;
        }
        if (((-16777216) & i) == 0) {
            i2 += 8;
            i <<= 8;
        }
        if (((-268435456) & i) == 0) {
            i2 += 4;
            i <<= 4;
        }
        if (((-1073741824) & i) == 0) {
            i2 += 2;
            i <<= 2;
        }
        if ((Integer.MIN_VALUE & i) == 0) {
            i2++;
            if ((i & 1073741824) == 0) {
                return 32;
            }
        }
        return i2;
    }

    private static int lo0bits(int i) {
        int i2 = 0;
        if ((i & 7) != 0) {
            if ((i & 1) != 0) {
                return 0;
            }
            return (i & 2) != 0 ? 1 : 2;
        }
        if ((65535 & i) == 0) {
            i >>>= 16;
            i2 = 16;
        }
        if ((i & 255) == 0) {
            i2 += 8;
            i >>>= 8;
        }
        if ((i & 15) == 0) {
            i2 += 4;
            i >>>= 4;
        }
        if ((i & 3) == 0) {
            i2 += 2;
            i >>>= 2;
        }
        if ((i & 1) == 0) {
            i2++;
            if (((i >>> 1) & 1) == 0) {
                return 32;
            }
        }
        return i2;
    }

    static BigInteger pow5mult(BigInteger bigInteger, int i) {
        return bigInteger.multiply(BigInteger.valueOf(5L).pow(i));
    }

    static boolean roundOff(StringBuilder sb) {
        int length = sb.length();
        while (length != 0) {
            int i = length - 1;
            char cCharAt = sb.charAt(i);
            if (cCharAt != '9') {
                sb.setCharAt(i, (char) (cCharAt + 1));
                sb.setLength(length);
                return false;
            }
            length = i;
        }
        sb.setLength(0);
        return true;
    }

    static double setWord0(double d, int i) {
        return Double.longBitsToDouble((Double.doubleToLongBits(d) & 4294967295L) | (((long) i) << 32));
    }

    private static void stripTrailingZeroes(StringBuilder sb) {
        int length = sb.length();
        while (true) {
            int i = length - 1;
            if (length <= 0 || sb.charAt(i) != '0') {
                break;
            } else {
                length = i;
            }
        }
        sb.setLength(length);
    }

    private static void stuffBits(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    static int word0(double d) {
        return (int) (Double.doubleToLongBits(d) >> 32);
    }

    static int word1(double d) {
        return (int) Double.doubleToLongBits(d);
    }
}
