package sdk.pendo.io.d7;

import android.view.View;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.react.uimanager.BackgroundStyleApplicator;
import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.style.BorderRadiusProp;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.b7.g;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0003\u0010\u0006J\u0017\u0010\u0003\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0003\u0010\nJ\u0017\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u001f\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u000b\u0010\u0013J\u001f\u0010\u0003\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0003\u0010\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0015¨\u0006\u0019"}, d2 = {"Lsdk/pendo/io/d7/d;", "", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "lengthPercentage", "", "(Ljava/lang/Object;)Ljava/lang/Float;", "Landroid/view/View;", "view", "", "(Landroid/view/View;)Ljava/lang/Integer;", "b", "(Landroid/view/View;)Ljava/lang/Float;", "e", "f", "d", "c", "Lsdk/pendo/io/d7/b;", SemanticAttributes.NetHostConnectionSubtypeValues.EDGE, "(Landroid/view/View;Lsdk/pendo/io/d7/b;)Ljava/lang/Float;", "(Landroid/view/View;Lsdk/pendo/io/d7/b;)Ljava/lang/Integer;", "Ljava/lang/Boolean;", "hasBackgroundStyleApplicator", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class d {
    public static final d a = new d();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private static Boolean hasBackgroundStyleApplicator;

    private d() {
    }

    private final Float a(Object lengthPercentage) {
        float fDpToPx;
        g gVar = g.a;
        Object objA = gVar.a(lengthPercentage, "mValue");
        Float f = objA instanceof Float ? (Float) objA : null;
        if (f != null) {
            fDpToPx = PixelUtil.INSTANCE.dpToPx(f.floatValue());
        } else {
            Object objA2 = gVar.a(lengthPercentage, "value");
            Float f2 = objA2 instanceof Float ? (Float) objA2 : null;
            if (f2 == null) {
                return null;
            }
            fDpToPx = PixelUtil.INSTANCE.dpToPx(f2.floatValue());
        }
        return Float.valueOf(fDpToPx);
    }

    public final Float b(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (a()) {
            try {
                LengthPercentage borderRadius = BackgroundStyleApplicator.getBorderRadius(view, BorderRadiusProp.BORDER_RADIUS);
                if (borderRadius != null) {
                    return a.a(borderRadius);
                }
                return null;
            } catch (Exception unused) {
            }
        }
        return c.a.a(view, a.BORDER_RADIUS);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
    
        if (r1 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0033, code lost:
    
        if (r1 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:?, code lost:
    
        return r1.floatValue();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float c(android.view.View r2) {
        /*
            r1 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            boolean r1 = r1.a()
            if (r1 == 0) goto L2b
            com.facebook.react.uimanager.style.BorderRadiusProp r1 = com.facebook.react.uimanager.style.BorderRadiusProp.BORDER_BOTTOM_LEFT_RADIUS     // Catch: java.lang.Exception -> L20
            com.facebook.react.uimanager.LengthPercentage r1 = com.facebook.react.uimanager.BackgroundStyleApplicator.getBorderRadius(r2, r1)     // Catch: java.lang.Exception -> L20
            if (r1 == 0) goto L3a
            sdk.pendo.io.d7.d r0 = sdk.pendo.io.d7.d.a     // Catch: java.lang.Exception -> L20
            java.lang.Float r1 = r0.a(r1)     // Catch: java.lang.Exception -> L20
            if (r1 == 0) goto L3a
            float r1 = r1.floatValue()     // Catch: java.lang.Exception -> L20
            return r1
        L20:
            sdk.pendo.io.d7.c r1 = sdk.pendo.io.d7.c.a
            sdk.pendo.io.d7.a r0 = sdk.pendo.io.d7.a.BORDER_BOTTOM_LEFT_RADIUS
            java.lang.Float r1 = r1.a(r2, r0)
            if (r1 == 0) goto L3a
            goto L35
        L2b:
            sdk.pendo.io.d7.c r1 = sdk.pendo.io.d7.c.a
            sdk.pendo.io.d7.a r0 = sdk.pendo.io.d7.a.BORDER_BOTTOM_LEFT_RADIUS
            java.lang.Float r1 = r1.a(r2, r0)
            if (r1 == 0) goto L3a
        L35:
            float r1 = r1.floatValue()
            goto L3b
        L3a:
            r1 = 0
        L3b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.d7.d.c(android.view.View):float");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
    
        if (r1 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0033, code lost:
    
        if (r1 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:?, code lost:
    
        return r1.floatValue();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float d(android.view.View r2) {
        /*
            r1 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            boolean r1 = r1.a()
            if (r1 == 0) goto L2b
            com.facebook.react.uimanager.style.BorderRadiusProp r1 = com.facebook.react.uimanager.style.BorderRadiusProp.BORDER_BOTTOM_RIGHT_RADIUS     // Catch: java.lang.Exception -> L20
            com.facebook.react.uimanager.LengthPercentage r1 = com.facebook.react.uimanager.BackgroundStyleApplicator.getBorderRadius(r2, r1)     // Catch: java.lang.Exception -> L20
            if (r1 == 0) goto L3a
            sdk.pendo.io.d7.d r0 = sdk.pendo.io.d7.d.a     // Catch: java.lang.Exception -> L20
            java.lang.Float r1 = r0.a(r1)     // Catch: java.lang.Exception -> L20
            if (r1 == 0) goto L3a
            float r1 = r1.floatValue()     // Catch: java.lang.Exception -> L20
            return r1
        L20:
            sdk.pendo.io.d7.c r1 = sdk.pendo.io.d7.c.a
            sdk.pendo.io.d7.a r0 = sdk.pendo.io.d7.a.BORDER_BOTTOM_RIGHT_RADIUS
            java.lang.Float r1 = r1.a(r2, r0)
            if (r1 == 0) goto L3a
            goto L35
        L2b:
            sdk.pendo.io.d7.c r1 = sdk.pendo.io.d7.c.a
            sdk.pendo.io.d7.a r0 = sdk.pendo.io.d7.a.BORDER_BOTTOM_RIGHT_RADIUS
            java.lang.Float r1 = r1.a(r2, r0)
            if (r1 == 0) goto L3a
        L35:
            float r1 = r1.floatValue()
            goto L3b
        L3a:
            r1 = 0
        L3b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.d7.d.d(android.view.View):float");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
    
        if (r1 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0033, code lost:
    
        if (r1 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:?, code lost:
    
        return r1.floatValue();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float e(android.view.View r2) {
        /*
            r1 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            boolean r1 = r1.a()
            if (r1 == 0) goto L2b
            com.facebook.react.uimanager.style.BorderRadiusProp r1 = com.facebook.react.uimanager.style.BorderRadiusProp.BORDER_TOP_LEFT_RADIUS     // Catch: java.lang.Exception -> L20
            com.facebook.react.uimanager.LengthPercentage r1 = com.facebook.react.uimanager.BackgroundStyleApplicator.getBorderRadius(r2, r1)     // Catch: java.lang.Exception -> L20
            if (r1 == 0) goto L3a
            sdk.pendo.io.d7.d r0 = sdk.pendo.io.d7.d.a     // Catch: java.lang.Exception -> L20
            java.lang.Float r1 = r0.a(r1)     // Catch: java.lang.Exception -> L20
            if (r1 == 0) goto L3a
            float r1 = r1.floatValue()     // Catch: java.lang.Exception -> L20
            return r1
        L20:
            sdk.pendo.io.d7.c r1 = sdk.pendo.io.d7.c.a
            sdk.pendo.io.d7.a r0 = sdk.pendo.io.d7.a.BORDER_TOP_LEFT_RADIUS
            java.lang.Float r1 = r1.a(r2, r0)
            if (r1 == 0) goto L3a
            goto L35
        L2b:
            sdk.pendo.io.d7.c r1 = sdk.pendo.io.d7.c.a
            sdk.pendo.io.d7.a r0 = sdk.pendo.io.d7.a.BORDER_TOP_LEFT_RADIUS
            java.lang.Float r1 = r1.a(r2, r0)
            if (r1 == 0) goto L3a
        L35:
            float r1 = r1.floatValue()
            goto L3b
        L3a:
            r1 = 0
        L3b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.d7.d.e(android.view.View):float");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
    
        if (r1 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0033, code lost:
    
        if (r1 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:?, code lost:
    
        return r1.floatValue();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float f(android.view.View r2) {
        /*
            r1 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            boolean r1 = r1.a()
            if (r1 == 0) goto L2b
            com.facebook.react.uimanager.style.BorderRadiusProp r1 = com.facebook.react.uimanager.style.BorderRadiusProp.BORDER_TOP_RIGHT_RADIUS     // Catch: java.lang.Exception -> L20
            com.facebook.react.uimanager.LengthPercentage r1 = com.facebook.react.uimanager.BackgroundStyleApplicator.getBorderRadius(r2, r1)     // Catch: java.lang.Exception -> L20
            if (r1 == 0) goto L3a
            sdk.pendo.io.d7.d r0 = sdk.pendo.io.d7.d.a     // Catch: java.lang.Exception -> L20
            java.lang.Float r1 = r0.a(r1)     // Catch: java.lang.Exception -> L20
            if (r1 == 0) goto L3a
            float r1 = r1.floatValue()     // Catch: java.lang.Exception -> L20
            return r1
        L20:
            sdk.pendo.io.d7.c r1 = sdk.pendo.io.d7.c.a
            sdk.pendo.io.d7.a r0 = sdk.pendo.io.d7.a.BORDER_TOP_RIGHT_RADIUS
            java.lang.Float r1 = r1.a(r2, r0)
            if (r1 == 0) goto L3a
            goto L35
        L2b:
            sdk.pendo.io.d7.c r1 = sdk.pendo.io.d7.c.a
            sdk.pendo.io.d7.a r0 = sdk.pendo.io.d7.a.BORDER_TOP_RIGHT_RADIUS
            java.lang.Float r1 = r1.a(r2, r0)
            if (r1 == 0) goto L3a
        L35:
            float r1 = r1.floatValue()
            goto L3b
        L3a:
            r1 = 0
        L3b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.d7.d.f(android.view.View):float");
    }

    public final Integer a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (a()) {
            try {
                return BackgroundStyleApplicator.getBackgroundColor(view);
            } catch (Exception unused) {
            }
        }
        return c.a.a(view);
    }

    public final Float b(View view, b edge) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(edge, "edge");
        if (a()) {
            try {
                Float borderWidth = BackgroundStyleApplicator.getBorderWidth(view, e.a(edge));
                if (borderWidth != null) {
                    return Float.valueOf(PixelUtil.INSTANCE.dpToPx(borderWidth.floatValue()));
                }
                return null;
            } catch (Exception unused) {
            }
        }
        return c.a.b(view, edge);
    }

    public final Integer a(View view, b edge) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(edge, "edge");
        if (a()) {
            try {
                return BackgroundStyleApplicator.getBorderColor(view, e.a(edge));
            } catch (Exception unused) {
            }
        }
        return c.a.a(view, edge);
    }

    private final boolean a() {
        Boolean bool;
        if (hasBackgroundStyleApplicator == null) {
            if (g.a.a("com.facebook.react.uimanager.BackgroundStyleApplicator") != null) {
                PendoLogger.d("RNStyleAccessor", "Using New Approach (React Native 0.76+)");
                bool = Boolean.TRUE;
            } else {
                PendoLogger.d("RNStyleAccessor", "Using Legacy Approach: " + c.a.a());
                bool = Boolean.FALSE;
            }
            hasBackgroundStyleApplicator = bool;
        }
        Boolean bool2 = hasBackgroundStyleApplicator;
        Intrinsics.checkNotNull(bool2);
        return bool2.booleanValue();
    }
}
