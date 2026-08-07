package com.google.common.math;

import com.box.android.observability.DiagnosisParams;
import com.google.common.base.Preconditions;
import java.lang.Comparable;
import java.lang.Number;
import java.math.RoundingMode;

/* JADX INFO: loaded from: classes14.dex */
@ElementTypesAreNonnullByDefault
abstract class ToDoubleRounder<X extends Number & Comparable<X>> {
    abstract X minus(X a, X b);

    abstract double roundToDoubleArbitrarily(X x);

    abstract int sign(X x);

    abstract X toX(double d, RoundingMode mode);

    ToDoubleRounder() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x005b  */
    /* JADX WARN: Code duplicated, block: B:22:0x0075  */
    /* JADX WARN: Code duplicated, block: B:24:0x007b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x007d  */
    /* JADX WARN: Code duplicated, block: B:26:0x007f  */
    /* JADX WARN: Code duplicated, block: B:29:0x0084  */
    /* JADX WARN: Code duplicated, block: B:31:0x008a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:33:0x008e  */
    /* JADX WARN: Code duplicated, block: B:35:0x0093 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:37:0x0097  */
    /* JADX WARN: Code duplicated, block: B:39:0x009c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:43:0x00a5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:45:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ae A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:48:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:52:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:55:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:59:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:63:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:65:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:67:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:70:0x0102  */
    /* JADX WARN: Code duplicated, block: B:72:0x0108  */
    /* JADX WARN: Code duplicated, block: B:75:0x010f  */
    /* JADX WARN: Code duplicated, block: B:79:0x011e  */
    /* JADX WARN: Code duplicated, block: B:81:0x0124 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:83:0x0127  */
    /* JADX WARN: Code duplicated, block: B:85:0x012c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:87:0x012f  */
    final double roundToDouble(X x, RoundingMode mode) {
        Number x2;
        int iCompareTo;
        double dNextDown;
        Number x3;
        double dNextUp;
        int iCompareTo2;
        int i;
        boolean z;
        Preconditions.checkNotNull(x, "x");
        Preconditions.checkNotNull(mode, DiagnosisParams.DIAGNOSIS_MODE);
        double dRoundToDoubleArbitrarily = roundToDoubleArbitrarily(x);
        if (Double.isInfinite(dRoundToDoubleArbitrarily)) {
            switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[mode.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    return ((double) sign(x)) * Double.MAX_VALUE;
                case 5:
                    return dRoundToDoubleArbitrarily == Double.POSITIVE_INFINITY ? Double.MAX_VALUE : Double.NEGATIVE_INFINITY;
                case 6:
                    return dRoundToDoubleArbitrarily == Double.POSITIVE_INFINITY ? Double.POSITIVE_INFINITY : -1.7976931348623157E308d;
                case 7:
                    break;
                case 8:
                    throw new ArithmeticException(x + " cannot be represented precisely as a double");
                default:
                    x2 = toX(dRoundToDoubleArbitrarily, RoundingMode.UNNECESSARY);
                    iCompareTo = ((Comparable) x).compareTo(x2);
                    switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[mode.ordinal()]) {
                        case 1:
                            if (sign(x) >= 0) {
                                if (iCompareTo < 0) {
                                    return DoubleUtils.nextDown(dRoundToDoubleArbitrarily);
                                }
                            } else if (iCompareTo > 0) {
                                return Math.nextUp(dRoundToDoubleArbitrarily);
                            }
                        case 2:
                        case 3:
                        case 4:
                            if (iCompareTo >= 0) {
                                dNextUp = Math.nextUp(dRoundToDoubleArbitrarily);
                                if (dNextUp != Double.POSITIVE_INFINITY) {
                                    x3 = toX(dNextUp, RoundingMode.CEILING);
                                    iCompareTo2 = ((Comparable) minus(x, x2)).compareTo(minus(x3, x));
                                    if (iCompareTo2 >= 0) {
                                        if (iCompareTo2 <= 0) {
                                            i = AnonymousClass1.$SwitchMap$java$math$RoundingMode[mode.ordinal()];
                                            if (i != 2) {
                                                if (i != 3) {
                                                    if (i == 4) {
                                                        if (sign(x) >= 0) {
                                                        }
                                                    } else {
                                                        throw new AssertionError("impossible");
                                                    }
                                                } else if (sign(x) >= 0) {
                                                }
                                            } else if ((Double.doubleToRawLongBits(dRoundToDoubleArbitrarily) & 1) == 0) {
                                            }
                                        }
                                        return dNextUp;
                                    }
                                    return dRoundToDoubleArbitrarily;
                                }
                            } else {
                                dNextDown = DoubleUtils.nextDown(dRoundToDoubleArbitrarily);
                                if (dNextDown != Double.NEGATIVE_INFINITY) {
                                    Number x4 = toX(dNextDown, RoundingMode.FLOOR);
                                    x3 = x2;
                                    x2 = x4;
                                    dNextUp = dRoundToDoubleArbitrarily;
                                    dRoundToDoubleArbitrarily = dNextDown;
                                    iCompareTo2 = ((Comparable) minus(x, x2)).compareTo(minus(x3, x));
                                    if (iCompareTo2 >= 0) {
                                        if (iCompareTo2 <= 0) {
                                            i = AnonymousClass1.$SwitchMap$java$math$RoundingMode[mode.ordinal()];
                                            if (i != 2) {
                                                if (i != 3) {
                                                    if (i == 4) {
                                                        if (sign(x) >= 0) {
                                                        }
                                                    } else {
                                                        throw new AssertionError("impossible");
                                                    }
                                                } else if (sign(x) >= 0) {
                                                }
                                            } else if ((Double.doubleToRawLongBits(dRoundToDoubleArbitrarily) & 1) == 0) {
                                            }
                                        }
                                        return dNextUp;
                                    }
                                    return dRoundToDoubleArbitrarily;
                                }
                            }
                        case 5:
                            if (iCompareTo < 0) {
                                return DoubleUtils.nextDown(dRoundToDoubleArbitrarily);
                            }
                            break;
                        case 6:
                            if (iCompareTo > 0) {
                                return Math.nextUp(dRoundToDoubleArbitrarily);
                            }
                            break;
                        case 7:
                            if (sign(x) >= 0) {
                                if (iCompareTo > 0) {
                                    return Math.nextUp(dRoundToDoubleArbitrarily);
                                }
                            } else if (iCompareTo < 0) {
                                return DoubleUtils.nextDown(dRoundToDoubleArbitrarily);
                            }
                        case 8:
                            if (iCompareTo == 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            MathPreconditions.checkRoundingUnnecessary(z);
                            return dRoundToDoubleArbitrarily;
                        default:
                            throw new AssertionError("impossible");
                    }
                    break;
            }
        } else {
            x2 = toX(dRoundToDoubleArbitrarily, RoundingMode.UNNECESSARY);
            iCompareTo = ((Comparable) x).compareTo(x2);
            switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[mode.ordinal()]) {
                case 1:
                    if (sign(x) >= 0) {
                        if (iCompareTo < 0) {
                            return DoubleUtils.nextDown(dRoundToDoubleArbitrarily);
                        }
                    } else if (iCompareTo > 0) {
                        return Math.nextUp(dRoundToDoubleArbitrarily);
                    }
                case 2:
                case 3:
                case 4:
                    if (iCompareTo >= 0) {
                        dNextUp = Math.nextUp(dRoundToDoubleArbitrarily);
                        if (dNextUp != Double.POSITIVE_INFINITY) {
                            x3 = toX(dNextUp, RoundingMode.CEILING);
                            iCompareTo2 = ((Comparable) minus(x, x2)).compareTo(minus(x3, x));
                            if (iCompareTo2 >= 0) {
                                if (iCompareTo2 <= 0) {
                                    i = AnonymousClass1.$SwitchMap$java$math$RoundingMode[mode.ordinal()];
                                    if (i != 2) {
                                        if (i != 3) {
                                            if (i == 4) {
                                                if (sign(x) >= 0) {
                                                }
                                            } else {
                                                throw new AssertionError("impossible");
                                            }
                                        } else if (sign(x) >= 0) {
                                        }
                                    } else if ((Double.doubleToRawLongBits(dRoundToDoubleArbitrarily) & 1) == 0) {
                                    }
                                }
                                return dNextUp;
                            }
                            return dRoundToDoubleArbitrarily;
                        }
                    } else {
                        dNextDown = DoubleUtils.nextDown(dRoundToDoubleArbitrarily);
                        if (dNextDown != Double.NEGATIVE_INFINITY) {
                            Number x5 = toX(dNextDown, RoundingMode.FLOOR);
                            x3 = x2;
                            x2 = x5;
                            dNextUp = dRoundToDoubleArbitrarily;
                            dRoundToDoubleArbitrarily = dNextDown;
                            iCompareTo2 = ((Comparable) minus(x, x2)).compareTo(minus(x3, x));
                            if (iCompareTo2 >= 0) {
                                if (iCompareTo2 <= 0) {
                                    i = AnonymousClass1.$SwitchMap$java$math$RoundingMode[mode.ordinal()];
                                    if (i != 2) {
                                        if (i != 3) {
                                            if (i == 4) {
                                                if (sign(x) >= 0) {
                                                }
                                            } else {
                                                throw new AssertionError("impossible");
                                            }
                                        } else if (sign(x) >= 0) {
                                        }
                                    } else if ((Double.doubleToRawLongBits(dRoundToDoubleArbitrarily) & 1) == 0) {
                                    }
                                }
                                return dNextUp;
                            }
                            return dRoundToDoubleArbitrarily;
                        }
                    }
                case 5:
                    if (iCompareTo < 0) {
                        return DoubleUtils.nextDown(dRoundToDoubleArbitrarily);
                    }
                    break;
                case 6:
                    if (iCompareTo > 0) {
                        return Math.nextUp(dRoundToDoubleArbitrarily);
                    }
                    break;
                case 7:
                    if (sign(x) >= 0) {
                        if (iCompareTo > 0) {
                            return Math.nextUp(dRoundToDoubleArbitrarily);
                        }
                    } else if (iCompareTo < 0) {
                        return DoubleUtils.nextDown(dRoundToDoubleArbitrarily);
                    }
                case 8:
                    if (iCompareTo == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    MathPreconditions.checkRoundingUnnecessary(z);
                    return dRoundToDoubleArbitrarily;
                default:
                    throw new AssertionError("impossible");
            }
        }
        return dRoundToDoubleArbitrarily;
    }

    /* JADX INFO: renamed from: com.google.common.math.ToDoubleRounder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            $SwitchMap$java$math$RoundingMode = iArr;
            try {
                iArr[RoundingMode.DOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_EVEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_DOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.FLOOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.CEILING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.UNNECESSARY.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }
}
