package com.pspdfkit.internal;

import com.pspdfkit.annotations.measurements.MeasurementPrecision;
import java.nio.ByteBuffer;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes3.dex */
public final class zg {

    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[MeasurementPrecision.values().length];
            try {
                iArr[MeasurementPrecision.WHOLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MeasurementPrecision.ONE_DP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MeasurementPrecision.TWO_DP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MeasurementPrecision.THREE_DP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MeasurementPrecision.FOUR_DP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[MeasurementPrecision.WHOLE_INCH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[MeasurementPrecision.HALVES_INCH.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[MeasurementPrecision.QUARTERS_INCH.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[MeasurementPrecision.EIGHTHS_INCH.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[MeasurementPrecision.SIXTEENTHS_INCH.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            a = iArr;
        }
    }

    public static MeasurementPrecision a(wp wpVar) {
        int i = wpVar.b.getInt(wpVar.a);
        if (i == 0) {
            return MeasurementPrecision.WHOLE;
        }
        if (i == 1) {
            return MeasurementPrecision.ONE_DP;
        }
        if (i == 2) {
            return MeasurementPrecision.TWO_DP;
        }
        if (i == 3) {
            return MeasurementPrecision.THREE_DP;
        }
        if (i == 4) {
            return MeasurementPrecision.FOUR_DP;
        }
        throw new IllegalArgumentException("Received invalid decimal measurement precision " + wpVar);
    }

    public static MeasurementPrecision b(wp wpVar) {
        int i = wpVar.b.getInt(wpVar.a);
        if (i == 1) {
            return MeasurementPrecision.WHOLE_INCH;
        }
        if (i == 2) {
            return MeasurementPrecision.HALVES_INCH;
        }
        if (i == 4) {
            return MeasurementPrecision.QUARTERS_INCH;
        }
        if (i == 8) {
            return MeasurementPrecision.EIGHTHS_INCH;
        }
        if (i == 16) {
            return MeasurementPrecision.SIXTEENTHS_INCH;
        }
        throw new IllegalArgumentException("Received invalid fraction measurement precision " + wpVar);
    }

    public static MeasurementPrecision c(wp wpVar) {
        if (wpVar == null) {
            return null;
        }
        short s = wpVar.b.getShort(wpVar.a + 4);
        if (s == 0) {
            return a(wpVar);
        }
        if (s == 1) {
            return b(wpVar);
        }
        throw new IllegalArgumentException("Received invalid measurement precision type" + wpVar);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0039 A[LOOP:0: B:23:0x0037->B:24:0x0039, LOOP_END] */
    public static Integer a(MeasurementPrecision measurementPrecision, yg ygVar) {
        short s;
        short s2;
        int i;
        if (measurementPrecision == null) {
            return null;
        }
        switch (a.a[measurementPrecision.ordinal()]) {
            case 1:
                s = 0;
                s2 = s;
                ygVar.d(4, 8);
                for (i = 0; i < 2; i++) {
                    ByteBuffer byteBuffer = ygVar.a;
                    int i2 = ygVar.b - 1;
                    ygVar.b = i2;
                    byteBuffer.put(i2, (byte) 0);
                }
                ygVar.a(s2);
                ygVar.b(s);
                return Integer.valueOf(ygVar.a.capacity() - ygVar.b);
            case 2:
                s2 = 0;
                s = 1;
                ygVar.d(4, 8);
                while (i < 2) {
                    ByteBuffer byteBuffer2 = ygVar.a;
                    int i3 = ygVar.b - 1;
                    ygVar.b = i3;
                    byteBuffer2.put(i3, (byte) 0);
                }
                ygVar.a(s2);
                ygVar.b(s);
                return Integer.valueOf(ygVar.a.capacity() - ygVar.b);
            case 3:
                s = 2;
                s2 = 0;
                ygVar.d(4, 8);
                while (i < 2) {
                    ByteBuffer byteBuffer3 = ygVar.a;
                    int i4 = ygVar.b - 1;
                    ygVar.b = i4;
                    byteBuffer3.put(i4, (byte) 0);
                }
                ygVar.a(s2);
                ygVar.b(s);
                return Integer.valueOf(ygVar.a.capacity() - ygVar.b);
            case 4:
                s = 3;
                s2 = 0;
                ygVar.d(4, 8);
                while (i < 2) {
                    ByteBuffer byteBuffer4 = ygVar.a;
                    int i5 = ygVar.b - 1;
                    ygVar.b = i5;
                    byteBuffer4.put(i5, (byte) 0);
                }
                ygVar.a(s2);
                ygVar.b(s);
                return Integer.valueOf(ygVar.a.capacity() - ygVar.b);
            case 5:
                s = 4;
                s2 = 0;
                ygVar.d(4, 8);
                while (i < 2) {
                    ByteBuffer byteBuffer5 = ygVar.a;
                    int i6 = ygVar.b - 1;
                    ygVar.b = i6;
                    byteBuffer5.put(i6, (byte) 0);
                }
                ygVar.a(s2);
                ygVar.b(s);
                return Integer.valueOf(ygVar.a.capacity() - ygVar.b);
            case 6:
                s = 1;
                s2 = s;
                ygVar.d(4, 8);
                while (i < 2) {
                    ByteBuffer byteBuffer6 = ygVar.a;
                    int i7 = ygVar.b - 1;
                    ygVar.b = i7;
                    byteBuffer6.put(i7, (byte) 0);
                }
                ygVar.a(s2);
                ygVar.b(s);
                return Integer.valueOf(ygVar.a.capacity() - ygVar.b);
            case 7:
                s = 2;
                s2 = 1;
                ygVar.d(4, 8);
                while (i < 2) {
                    ByteBuffer byteBuffer7 = ygVar.a;
                    int i8 = ygVar.b - 1;
                    ygVar.b = i8;
                    byteBuffer7.put(i8, (byte) 0);
                }
                ygVar.a(s2);
                ygVar.b(s);
                return Integer.valueOf(ygVar.a.capacity() - ygVar.b);
            case 8:
                s = 4;
                s2 = 1;
                ygVar.d(4, 8);
                while (i < 2) {
                    ByteBuffer byteBuffer8 = ygVar.a;
                    int i9 = ygVar.b - 1;
                    ygVar.b = i9;
                    byteBuffer8.put(i9, (byte) 0);
                }
                ygVar.a(s2);
                ygVar.b(s);
                return Integer.valueOf(ygVar.a.capacity() - ygVar.b);
            case 9:
                s = 8;
                s2 = 1;
                ygVar.d(4, 8);
                while (i < 2) {
                    ByteBuffer byteBuffer9 = ygVar.a;
                    int i10 = ygVar.b - 1;
                    ygVar.b = i10;
                    byteBuffer9.put(i10, (byte) 0);
                }
                ygVar.a(s2);
                ygVar.b(s);
                return Integer.valueOf(ygVar.a.capacity() - ygVar.b);
            case 10:
                s = 16;
                s2 = 1;
                ygVar.d(4, 8);
                while (i < 2) {
                    ByteBuffer byteBuffer10 = ygVar.a;
                    int i11 = ygVar.b - 1;
                    ygVar.b = i11;
                    byteBuffer10.put(i11, (byte) 0);
                }
                ygVar.a(s2);
                ygVar.b(s);
                return Integer.valueOf(ygVar.a.capacity() - ygVar.b);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
