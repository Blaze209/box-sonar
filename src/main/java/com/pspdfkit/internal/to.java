package com.pspdfkit.internal;

import android.graphics.Bitmap;
import android.graphics.Point;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.configuration.rendering.PageRenderConfiguration;
import com.pspdfkit.internal.jni.NativePageCache;
import com.pspdfkit.ui.drawable.PdfDrawable;
import com.pspdfkit.utils.PdfLog;
import com.pspdfkit.utils.Size;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.rx3.RxAwaitKt;

/* JADX INFO: loaded from: classes3.dex */
public final class to {
    public m40 a;
    public zo b;
    public zo c;
    public final tm d;

    public to(int i, m40 m40Var) {
        m40Var.getClass();
        this.a = m40Var;
        Size size = m40Var.g;
        int i2 = (int) size.width;
        int i3 = (int) size.height;
        tm tmVar = new tm(i2, i3);
        int i4 = i2 * i3;
        if (i4 == 0 || i == 0) {
            tmVar = tm.c;
        } else if (i4 > i) {
            float fSqrt = (float) Math.sqrt(i / i4);
            tmVar = new tm((int) (i2 * fSqrt), (int) (i3 * fSqrt));
        }
        this.d = tmVar;
    }

    public final boolean a(tm tmVar) {
        int i = tmVar.a;
        if (i > 0 && tmVar.b > 0) {
            return true;
        }
        PdfLog.e("LowResProvider", "Cannot render low-res page " + this.a.b + ": Invalid bitmap size " + i + "x" + tmVar.b, new Object[0]);
        return false;
    }

    public final x7 a(jm jmVar) {
        x7 x7Var;
        Bitmap bitmapC;
        ut utVar = q10.b;
        if (utVar == null) {
            utVar = new ut(NativePageCache.create(15728640));
            q10.b = utVar;
        }
        ri riVar = utVar.b;
        riVar.getClass();
        q8 q8Var = riVar.a.get(ri.a(jmVar.a.a, jmVar.b));
        if (q8Var == null || (bitmapC = q8Var.a.c()) == null) {
            x7Var = null;
        } else if (si.a(jmVar) == q8Var.b) {
            x7Var = new x7(bitmapC, new pi(q8Var.a));
        } else {
            q8Var.a.b();
            x7Var = null;
        }
        if (x7Var == null) {
            return null;
        }
        if (x7Var.a.getWidth() == jmVar.d.getWidth() && x7Var.a.getHeight() == jmVar.d.getHeight()) {
            return x7Var;
        }
        PdfLog.d("LowResProvider", "Cached bitmap size mismatch for page " + this.a.b + ", re-rendering", new Object[0]);
        x7Var.close();
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(az azVar, boolean z, Function2 function2, ContinuationImpl continuationImpl) throws Throwable {
        qo qoVar;
        if (continuationImpl instanceof qo) {
            qoVar = (qo) continuationImpl;
            int i = qoVar.f;
            if ((i & Integer.MIN_VALUE) != 0) {
                qoVar.f = i - Integer.MIN_VALUE;
            } else {
                qoVar = new qo(this, continuationImpl);
            }
        } else {
            qoVar = new qo(this, continuationImpl);
        }
        Object objA = qoVar.d;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = qoVar.f;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            if (!a(this.d)) {
                return Unit.INSTANCE;
            }
            synchronized (this) {
                zo zoVar = this.b;
                if (zoVar == null) {
                    zoVar = this.c;
                }
                this.c = zoVar;
                Unit unit = Unit.INSTANCE;
            }
            v7 v7Var = azVar.b;
            zo managedBitmap = v7Var != null ? v7Var.getManagedBitmap() : null;
            function2.invoke(Boxing.boxInt(1), managedBitmap);
            tm tmVar = this.d;
            qoVar.a = SpillingKt.nullOutSpilledVariable(azVar);
            qoVar.b = function2;
            qoVar.c = SpillingKt.nullOutSpilledVariable(managedBitmap);
            qoVar.f = 1;
            objA = a(tmVar, z, qoVar);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            function2 = qoVar.b;
            ResultKt.throwOnFailure(objA);
        }
        wy wyVar = (wy) objA;
        this.b = wyVar.a;
        ri riVar = q10.a.a().b;
        jm jmVar = wyVar.b;
        zo zoVar2 = wyVar.a;
        riVar.getClass();
        jmVar.getClass();
        riVar.a.put(ri.a(jmVar.a.a, jmVar.b), new q8(zoVar2, jmVar));
        zo zoVar3 = this.c;
        if (zoVar3 != null) {
            zoVar3.b();
        }
        this.c = null;
        zo zoVar4 = this.b;
        if (zoVar4 != null) {
            function2.invoke(Boxing.boxInt(2), zoVar4);
        } else {
            function2.invoke(Boxing.boxInt(0), null);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    public final Object a(tm tmVar, boolean z, ContinuationImpl continuationImpl) throws Throwable {
        po poVar;
        x7 x7VarA;
        x7 x7Var;
        if (continuationImpl instanceof po) {
            poVar = (po) continuationImpl;
            int i = poVar.f;
            if ((i & Integer.MIN_VALUE) != 0) {
                poVar.f = i - Integer.MIN_VALUE;
            } else {
                poVar = new po(this, continuationImpl);
            }
        } else {
            poVar = new po(this, continuationImpl);
        }
        Object objWithContext = poVar.d;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = poVar.f;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            m40 m40Var = this.a;
            boolean z2 = m40Var.d;
            y7 y7Var = q10.c;
            if (y7Var == null) {
                y7Var = new y7();
                q10.c = y7Var;
            }
            Bitmap bitmapA = y7Var.a(tmVar.a, tmVar.b);
            bitmapA.getClass();
            ou ouVar = m40Var.a.c;
            int i3 = m40Var.b;
            android.util.Size size = new android.util.Size(tmVar.a, tmVar.b);
            PageRenderConfiguration pageRenderConfiguration = m40Var.c;
            ouVar.getClass();
            pageRenderConfiguration.getClass();
            oy oyVar = pageRenderConfiguration.renderRegion ? new oy(new Point(pageRenderConfiguration.regionX, pageRenderConfiguration.regionY), new android.util.Size(pageRenderConfiguration.regionFullPageWidth, pageRenderConfiguration.regionFullPageHeight)) : null;
            Bitmap bitmap = pageRenderConfiguration.reuseBitmap;
            int i4 = pageRenderConfiguration.paperColor;
            Integer num = pageRenderConfiguration.formHighlightColor;
            Integer num2 = pageRenderConfiguration.formItemHighlightColor;
            Integer num3 = pageRenderConfiguration.formRequiredFieldBorderColor;
            Integer num4 = pageRenderConfiguration.signHereOverlayBackgroundColor;
            boolean z3 = pageRenderConfiguration.toGrayscale;
            boolean z4 = pageRenderConfiguration.invertColors;
            boolean z5 = pageRenderConfiguration.redactionAnnotationPreviewEnabled;
            List<PdfDrawable> list = pageRenderConfiguration.renderedDrawables;
            list.getClass();
            boolean z6 = pageRenderConfiguration.showSignHereOverlay;
            boolean z7 = pageRenderConfiguration.useCache;
            List<Integer> list2 = pageRenderConfiguration.excludedAnnotations;
            list2.getClass();
            List<AnnotationType> list3 = pageRenderConfiguration.excludedAnnotationTypes;
            list3.getClass();
            jm jmVarA = jm.a(new jm(ouVar, i3, bitmap, size, z7, null, oyVar, 3, i4, num, num2, num3, num4, z4, z3, list2, list3, list, z5, z6, true), bitmapA, null, null, z2 ? 15 : 5, null, (List) m40Var.p.getValue(), m40Var.m, null, m40Var.h, !m40Var.i, 687995);
            x7VarA = z ? null : a(jmVarA);
            m40 m40Var2 = this.a;
            if (x7VarA != null) {
                PdfLog.d("LowResProvider", "Using cached bitmap for page " + m40Var2.b, new Object[0]);
                try {
                    poVar.a = SpillingKt.nullOutSpilledVariable(tmVar);
                    poVar.b = SpillingKt.nullOutSpilledVariable(jmVarA);
                    poVar.c = x7VarA;
                    poVar.f = 1;
                    objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new ro(jmVarA, x7VarA, null), poVar);
                    if (objWithContext != coroutine_suspended) {
                        x7Var = x7VarA;
                    }
                } catch (Throwable th) {
                    th = th;
                    x7VarA.close();
                    throw th;
                }
            } else {
                PdfLog.d("LowResProvider", "Rendering full page " + m40Var2.b + " (skipCache=" + z + ")", new Object[0]);
                poVar.a = SpillingKt.nullOutSpilledVariable(tmVar);
                poVar.b = SpillingKt.nullOutSpilledVariable(jmVarA);
                poVar.c = SpillingKt.nullOutSpilledVariable(x7VarA);
                poVar.f = 2;
                Object objA = a(jmVarA, poVar);
                if (objA != coroutine_suspended) {
                    return objA;
                }
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objWithContext);
            return objWithContext;
        }
        x7Var = (x7) poVar.c;
        try {
            ResultKt.throwOnFailure(objWithContext);
        } catch (Throwable th2) {
            th = th2;
            x7VarA = x7Var;
            x7VarA.close();
            throw th;
        }
        wy wyVar = (wy) objWithContext;
        x7Var.close();
        return wyVar;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(jm jmVar, ContinuationImpl continuationImpl) {
        so soVar;
        if (continuationImpl instanceof so) {
            soVar = (so) continuationImpl;
            int i = soVar.d;
            if ((i & Integer.MIN_VALUE) != 0) {
                soVar.d = i - Integer.MIN_VALUE;
            } else {
                soVar = new so(this, continuationImpl);
            }
        } else {
            soVar = new so(this, continuationImpl);
        }
        Object objAwait = soVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = soVar.d;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objAwait);
            iu iuVar = iu.a;
            soVar.a = jmVar;
            soVar.d = 1;
            objAwait = RxAwaitKt.await(iu.b(jmVar), soVar);
            if (objAwait == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            jmVar = soVar.a;
            ResultKt.throwOnFailure(objAwait);
        }
        return new wy(new zo((Bitmap) objAwait), jmVar);
    }
}
