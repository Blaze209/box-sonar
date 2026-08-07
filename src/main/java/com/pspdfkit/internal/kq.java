package com.pspdfkit.internal;

import android.graphics.Matrix;
import android.view.MotionEvent;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.WidgetAnnotation;
import com.pspdfkit.annotations.actions.Action;
import com.pspdfkit.annotations.actions.ActionResolver;
import com.pspdfkit.ui.overlay.OverlayLayoutParams;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes3.dex */
public final class kq implements nx {
    public static final EnumSet<AnnotationType> o;
    public final au a;
    public final lm b;
    public final ActionResolver c;
    public final nf d;
    public final a e;
    public final HashMap f;
    public final CoroutineScope g;
    public Job h;
    public boolean i;
    public qq.a j;
    public boolean k;
    public boolean l;
    public boolean m;
    public ArrayList n;

    public final class a extends w20 {
        public final Matrix a = new Matrix();
        public boolean b;

        public a() {
        }

        @Override // com.pspdfkit.internal.w20, com.pspdfkit.internal.xi
        public final boolean d(MotionEvent motionEvent) {
            iq iqVarA;
            motionEvent.getClass();
            Annotation annotationA = kq.this.d.a(motionEvent, this.a, true);
            if (annotationA instanceof WidgetAnnotation) {
                Action action = ((WidgetAnnotation) annotationA).getAction();
                if (action == null) {
                    return false;
                }
                kq.this.c.executeAction(action);
                return true;
            }
            if (annotationA == null) {
                return false;
            }
            Iterator it = kq.this.f.keySet().iterator();
            do {
                if (!it.hasNext()) {
                    iqVarA = iq.a(annotationA);
                    break;
                }
                iqVarA = (iq) it.next();
            } while (iqVarA.a != annotationA);
            if (iqVarA == null) {
                return false;
            }
            qq qqVarA = kq.this.a(iqVarA);
            if (qqVarA.i.b()) {
                return false;
            }
            qqVarA.j = 4;
            qqVarA.a();
            return false;
        }

        @Override // com.pspdfkit.internal.w20
        public final boolean h(MotionEvent motionEvent) {
            motionEvent.getClass();
            return this.b;
        }

        @Override // com.pspdfkit.internal.w20, com.pspdfkit.internal.xi
        public final void onDown(MotionEvent motionEvent) {
            motionEvent.getClass();
            kq kqVar = kq.this;
            this.b = kqVar.d.a(motionEvent, kqVar.a.a(this.a), true) != null;
        }
    }

    static {
        EnumSet<AnnotationType> enumSetOf = EnumSet.of(AnnotationType.SCREEN, AnnotationType.RICHMEDIA, AnnotationType.LINK);
        enumSetOf.getClass();
        o = enumSetOf;
    }

    public kq(au auVar, lm lmVar, ActionResolver actionResolver, k2 k2Var) {
        this.a = auVar;
        this.b = lmVar;
        this.c = actionResolver;
        nf nfVar = new nf(k2Var);
        nfVar.c = new lq();
        this.d = nfVar;
        this.e = new a();
        this.f = new HashMap();
        this.g = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
        this.m = true;
    }

    public final void a() {
        Job job = this.h;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.h = null;
        this.k = false;
        for (iq iqVar : this.f.keySet()) {
            qq qqVar = (qq) this.f.get(iqVar);
            if (qqVar != null) {
                qqVar.j = 3;
                qqVar.a();
                qqVar.setMediaContent(null);
                this.f.put(iqVar, null);
                this.a.removeView(qqVar);
            }
        }
    }

    public final void b() {
        if (this.l && this.m && this.k) {
            ArrayList arrayList = this.n;
            if (arrayList == null || arrayList.isEmpty()) {
                for (iq iqVar : this.f.keySet()) {
                    if (iqVar.e) {
                        qq qqVarA = a(iqVar);
                        if (!qqVarA.i.b()) {
                            qqVarA.j = 4;
                            qqVarA.a();
                        }
                    }
                }
            } else {
                ArrayList arrayList2 = this.n;
                if (arrayList2 != null && !arrayList2.isEmpty()) {
                    int size = arrayList2.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList2.get(i);
                        i++;
                        jq jqVar = (jq) obj;
                        for (iq iqVar2 : this.f.keySet()) {
                            Annotation annotation = iqVar2.a;
                            annotation.getClass();
                            if (annotation.getPageIndex() == jqVar.a && annotation.getObjectNumber() == jqVar.b) {
                                if (jqVar.c) {
                                    qq qqVarA2 = a(iqVar2);
                                    if (!qqVarA2.i.b()) {
                                        qqVarA2.j = 4;
                                        qqVarA2.a();
                                    }
                                } else {
                                    qq qqVarA3 = a(iqVar2);
                                    if (qqVarA3.i.b()) {
                                        qqVarA3.j = 5;
                                        qqVarA3.a();
                                    }
                                }
                                a(iqVar2).i.b(jqVar.d);
                                this.n = null;
                            }
                        }
                    }
                }
            }
            for (iq iqVar3 : this.f.keySet()) {
                int i2 = iqVar3.g;
                if (i2 != 4 && !iqVar3.i && i2 != 4) {
                    a(iqVar3);
                }
            }
            this.m = false;
        }
    }

    @Override // com.pspdfkit.internal.nx
    public final void recycle() {
        a();
        this.f.clear();
    }

    public final qq a(iq iqVar) {
        qq qqVar;
        for (iq iqVar2 : this.f.keySet()) {
            if (iqVar2 == iqVar && (qqVar = (qq) this.f.get(iqVar2)) != null) {
                return qqVar;
            }
        }
        qq qqVar2 = new qq(this.a.getContext(), this.b);
        qqVar2.setLayoutParams(new OverlayLayoutParams(iqVar.a.getBoundingBox(), OverlayLayoutParams.SizingMode.LAYOUT));
        qqVar2.setOnMediaPlaybackChangeListener(this.j);
        qqVar2.setMediaContent(iqVar);
        this.f.put(iqVar, qqVar2);
        this.a.addView(qqVar2);
        return qqVar2;
    }

    public final void b(iq iqVar) {
        qq qqVar;
        if (iqVar.g == 4) {
            Iterator it = this.f.keySet().iterator();
            while (it.hasNext()) {
                if (((iq) it.next()) == iqVar && (qqVar = (qq) this.f.get(iqVar)) != null) {
                    qqVar.j = 3;
                    qqVar.a();
                    qqVar.setMediaContent(null);
                    this.f.put(iqVar, null);
                    this.a.removeView(qqVar);
                    return;
                }
            }
            return;
        }
        qq qqVarA = a(iqVar);
        qqVarA.j = 3;
        qqVarA.a();
    }
}
