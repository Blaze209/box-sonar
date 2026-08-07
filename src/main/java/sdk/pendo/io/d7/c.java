package sdk.pendo.io.d7;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.b7.g;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J!\u0010\u0003\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0003\u0010\nJ!\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\nJ\u001b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\f\u0010\u000eJ!\u0010\u0003\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0003\u0010\u0012J!\u0010\f\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\f\u0010\u0014J\u0017\u0010\f\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\u0015J\u001f\u0010\u0003\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0003\u0010\u0016J\u001f\u0010\f\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\f\u0010\u0017J\u001f\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\u0018J\u0006\u0010\f\u001a\u00020\u0019R\u001c\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u001a¨\u0006\u001e"}, d2 = {"Lsdk/pendo/io/d7/c;", "", "Ljava/lang/Class;", "b", "Landroid/view/View;", "view", "borderRadiusStyle", "Lsdk/pendo/io/d7/a;", "corner", "", "(Ljava/lang/Object;Lsdk/pendo/io/d7/a;)Ljava/lang/Float;", "borderRadii", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "value", "(Ljava/lang/Object;)Ljava/lang/Float;", "spacing", "Lsdk/pendo/io/d7/b;", SemanticAttributes.NetHostConnectionSubtypeValues.EDGE, "(Ljava/lang/Object;Lsdk/pendo/io/d7/b;)Ljava/lang/Float;", "", "(Ljava/lang/Object;Lsdk/pendo/io/d7/b;)Ljava/lang/Integer;", "(Landroid/view/View;)Ljava/lang/Integer;", "(Landroid/view/View;Lsdk/pendo/io/d7/b;)Ljava/lang/Float;", "(Landroid/view/View;Lsdk/pendo/io/d7/b;)Ljava/lang/Integer;", "(Landroid/view/View;Lsdk/pendo/io/d7/a;)Ljava/lang/Float;", "", "Ljava/lang/Class;", "detectedDrawableClass", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class c {
    public static final c a = new c();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private static Class<?> detectedDrawableClass;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[sdk.pendo.io.d7.a.values().length];
            try {
                iArr[sdk.pendo.io.d7.a.BORDER_TOP_LEFT_RADIUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[sdk.pendo.io.d7.a.BORDER_TOP_RIGHT_RADIUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[sdk.pendo.io.d7.a.BORDER_BOTTOM_RIGHT_RADIUS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[sdk.pendo.io.d7.a.BORDER_BOTTOM_LEFT_RADIUS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
            int[] iArr2 = new int[b.values().length];
            try {
                iArr2[b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[b.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[b.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[b.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            b = iArr2;
        }
    }

    private c() {
    }

    private final Class<?> b() {
        Class<?> cls = detectedDrawableClass;
        if (cls != null) {
            return cls;
        }
        g gVar = g.a;
        Class<?> clsA = gVar.a("com.facebook.react.uimanager.drawable.CSSBackgroundDrawable");
        detectedDrawableClass = clsA;
        if (clsA != null) {
            return clsA;
        }
        Class<?> clsA2 = gVar.a("com.facebook.react.views.view.ReactViewBackgroundDrawable");
        detectedDrawableClass = clsA2;
        if (clsA2 != null) {
            return clsA2;
        }
        Class<?> clsA3 = gVar.a("com.facebook.react.uimanager.drawable.ReactViewBackgroundDrawable");
        detectedDrawableClass = clsA3;
        if (clsA3 != null) {
            return clsA3;
        }
        return null;
    }

    public final String a() {
        Class<?> clsB = b();
        if (clsB == null) {
            return "No React Native background drawable detected";
        }
        return "Detected drawable: " + clsB.getName();
    }

    private final Integer a(Object spacing, b edge) {
        int iLongValue;
        try {
            g gVar = g.a;
            Object objA = gVar.a(gVar.a(spacing.getClass(), PasskeyWebListener.GET_UNIQUE_KEY, Integer.TYPE), spacing, Integer.valueOf(edge.getSpacingType()));
            if (objA instanceof Float) {
                iLongValue = (int) ((Number) objA).floatValue();
            } else {
                if (objA instanceof Integer) {
                    return (Integer) objA;
                }
                if (!(objA instanceof Long)) {
                    return null;
                }
                iLongValue = (int) ((Number) objA).longValue();
            }
            return Integer.valueOf(iLongValue);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x004b A[Catch: Exception -> 0x006c, TRY_LEAVE, TryCatch #0 {Exception -> 0x006c, blocks: (B:3:0x0001, B:6:0x000f, B:8:0x0015, B:10:0x0019, B:16:0x0030, B:17:0x0046, B:13:0x002a, B:19:0x004b), top: B:22:0x0001 }] */
    private final Float b(Object borderRadiusStyle, sdk.pendo.io.d7.a corner) {
        Object objA;
        Object obj;
        try {
            Class<?> clsA = g.a.a("com.facebook.react.uimanager.style.BorderRadiusProp");
            if (clsA == null) {
                g gVar = g.a;
                objA = gVar.a(gVar.a(borderRadiusStyle.getClass(), PasskeyWebListener.GET_UNIQUE_KEY, Integer.TYPE), borderRadiusStyle, Integer.valueOf(corner.ordinal()));
            } else {
                Object[] enumConstants = clsA.getEnumConstants();
                if (enumConstants == null) {
                    obj = null;
                    break;
                }
                int length = enumConstants.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        obj = null;
                        break;
                    }
                    obj = enumConstants[i];
                    if (Intrinsics.areEqual(obj.toString(), corner.getPropName())) {
                        break;
                    }
                    i++;
                }
                if (obj != null) {
                    g gVar2 = g.a;
                    objA = gVar2.a(gVar2.a(borderRadiusStyle.getClass(), PasskeyWebListener.GET_UNIQUE_KEY, clsA), borderRadiusStyle, obj);
                } else {
                    g gVar3 = g.a;
                    objA = gVar3.a(gVar3.a(borderRadiusStyle.getClass(), PasskeyWebListener.GET_UNIQUE_KEY, Integer.TYPE), borderRadiusStyle, Integer.valueOf(corner.ordinal()));
                }
            }
            return a(objA);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0041, code lost:
    
        if ((r4 instanceof java.lang.Float) != false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Float a(java.lang.Object r4) {
        /*
            r3 = this;
            r3 = 0
            if (r4 != 0) goto L4
            return r3
        L4:
            boolean r0 = r4 instanceof java.lang.Float     // Catch: java.lang.Exception -> L45
            if (r0 == 0) goto Lb
        L8:
            java.lang.Float r4 = (java.lang.Float) r4     // Catch: java.lang.Exception -> L45
            return r4
        Lb:
            boolean r0 = r4 instanceof java.lang.Double     // Catch: java.lang.Exception -> L45
            if (r0 == 0) goto L17
            java.lang.Number r4 = (java.lang.Number) r4     // Catch: java.lang.Exception -> L45
            double r0 = r4.doubleValue()     // Catch: java.lang.Exception -> L45
            float r4 = (float) r0     // Catch: java.lang.Exception -> L45
            goto L22
        L17:
            boolean r0 = r4 instanceof java.lang.Integer     // Catch: java.lang.Exception -> L45
            if (r0 == 0) goto L27
            java.lang.Number r4 = (java.lang.Number) r4     // Catch: java.lang.Exception -> L45
            int r4 = r4.intValue()     // Catch: java.lang.Exception -> L45
            float r4 = (float) r4     // Catch: java.lang.Exception -> L45
        L22:
            java.lang.Float r3 = java.lang.Float.valueOf(r4)     // Catch: java.lang.Exception -> L45
            return r3
        L27:
            sdk.pendo.io.b7.g r0 = sdk.pendo.io.b7.g.a     // Catch: java.lang.Exception -> L45
            java.lang.String r1 = "mValue"
            java.lang.Object r1 = r0.a(r4, r1)     // Catch: java.lang.Exception -> L45
            boolean r2 = r1 instanceof java.lang.Float     // Catch: java.lang.Exception -> L45
            if (r2 == 0) goto L36
            java.lang.Float r1 = (java.lang.Float) r1     // Catch: java.lang.Exception -> L45
            goto L37
        L36:
            r1 = r3
        L37:
            if (r1 != 0) goto L44
            java.lang.String r1 = "value"
            java.lang.Object r4 = r0.a(r4, r1)     // Catch: java.lang.Exception -> L45
            boolean r0 = r4 instanceof java.lang.Float     // Catch: java.lang.Exception -> L45
            if (r0 == 0) goto L45
            goto L8
        L44:
            return r1
        L45:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.d7.c.a(java.lang.Object):java.lang.Float");
    }

    private final Float b(Object spacing, b edge) {
        g gVar = g.a;
        int i = 1;
        Object objA = gVar.a(gVar.a(spacing.getClass(), PasskeyWebListener.GET_UNIQUE_KEY, Integer.TYPE), spacing, Integer.valueOf(edge.getSpacingType()));
        Float f = objA instanceof Float ? (Float) objA : null;
        if (f != null && !Float.isNaN(f.floatValue()) && f.floatValue() > 0.0f) {
            return f;
        }
        if (spacing instanceof float[]) {
            int i2 = a.b[edge.ordinal()];
            if (i2 == 1) {
                i = 0;
            } else if (i2 != 2) {
                i = 3;
                if (i2 == 3) {
                    i = 2;
                } else if (i2 != 4) {
                    return null;
                }
            }
            Float orNull = ArraysKt.getOrNull((float[]) spacing, i);
            if (orNull != null && !Float.isNaN(orNull.floatValue()) && orNull.floatValue() > 0.0f) {
                return orNull;
            }
        }
        return null;
    }

    private final Float a(Object borderRadii, sdk.pendo.io.d7.a corner) {
        try {
            if (borderRadii instanceof Object[]) {
                int i = a.a[corner.ordinal()];
                int i2 = 1;
                if (i == 1) {
                    i2 = 0;
                } else if (i != 2) {
                    i2 = 3;
                    if (i == 3) {
                        i2 = 2;
                    } else if (i != 4) {
                        return null;
                    }
                }
                return a(ArraysKt.getOrNull((Object[]) borderRadii, i2));
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private final Object b(View view) {
        Class<?> clsB;
        Drawable background = view.getBackground();
        if (background == null || (clsB = b()) == null || !clsB.isInstance(background)) {
            return null;
        }
        return background;
    }

    public final Integer a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        try {
            Object objB = b(view);
            if (objB == null) {
                return null;
            }
            g gVar = g.a;
            Method methodA = gVar.a(objB.getClass(), "getColor", new Class[0]);
            if (methodA != null) {
                Object objA = gVar.a(methodA, objB, new Object[0]);
                Integer num = objA instanceof Integer ? (Integer) objA : null;
                if (num != null && num.intValue() != 0) {
                    return num;
                }
            }
            Object objA2 = gVar.a(objB, "mColor");
            Integer num2 = objA2 instanceof Integer ? (Integer) objA2 : null;
            if (num2 != null && num2.intValue() != 0) {
                return num2;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public final Float b(View view, b edge) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(edge, "edge");
        try {
            Object objB = b(view);
            if (objB == null) {
                return null;
            }
            g gVar = g.a;
            Method methodA = gVar.a(objB.getClass(), "getBorderWidth", Integer.TYPE);
            if (methodA != null) {
                Object objA = gVar.a(methodA, objB, Integer.valueOf(edge.getSpacingType()));
                Integer num = objA instanceof Integer ? (Integer) objA : null;
                if (num != null && num.intValue() > 0) {
                    return Float.valueOf(num.intValue());
                }
            }
            Object objA2 = gVar.a(objB, "mBorderWidth");
            if (objA2 != null) {
                return b(objA2, edge);
            }
            return null;
        } catch (Exception unused) {
        }
    }

    public final Integer a(View view, b edge) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(edge, "edge");
        try {
            Object objB = b(view);
            if (objB == null) {
                return null;
            }
            g gVar = g.a;
            Method methodA = gVar.a(objB.getClass(), "getBorderColor", Integer.TYPE);
            if (methodA != null) {
                Object objA = gVar.a(methodA, objB, Integer.valueOf(edge.getSpacingType()));
                if (objA instanceof Integer) {
                    return (Integer) objA;
                }
                return null;
            }
            Object objA2 = gVar.a(objB, "mBorderColor");
            if (objA2 != null) {
                return a(objA2, edge);
            }
            return null;
        } catch (Exception unused) {
        }
    }

    public final Float a(View view, sdk.pendo.io.d7.a corner) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(corner, "corner");
        try {
            Object objB = b(view);
            if (objB == null) {
                return null;
            }
            g gVar = g.a;
            Object objA = gVar.a(objB, "mBorderRadius");
            Float f = objA instanceof Float ? (Float) objA : null;
            if (f != null && !Float.isNaN(f.floatValue()) && f.floatValue() > 0.0f) {
                return f;
            }
            Object objA2 = gVar.a(objB, "mBorderRadius");
            if (objA2 != null && !(objA2 instanceof Float)) {
                return b(objA2, corner);
            }
            Object objA3 = gVar.a(objB, "mBorderRadii");
            if (objA3 != null) {
                return a(objA3, corner);
            }
            return null;
        } catch (Exception unused) {
        }
    }
}
