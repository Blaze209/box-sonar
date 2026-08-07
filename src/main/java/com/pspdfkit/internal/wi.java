package com.pspdfkit.internal;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class wi {
    public final GestureDetector b;
    public final HashMap c;
    public final HashMap d;
    public xi f;
    public final HashSet a = new HashSet();
    public boolean e = false;

    public class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent motionEvent) {
            Iterator it = ((List) wi.this.d.get(vi.DoubleTap)).iterator();
            boolean zOnDoubleTap = false;
            while (it.hasNext() && !(zOnDoubleTap = ((xi) it.next()).onDoubleTap(motionEvent))) {
            }
            ((List) wi.this.d.get(vi.DoubleTap)).clear();
            return zOnDoubleTap;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent motionEvent) {
            wi wiVar = wi.this;
            boolean z = false;
            wiVar.e = false;
            wiVar.f = null;
            for (xi xiVar : wiVar.a) {
                if (xiVar.a(motionEvent)) {
                    wi.this.f = xiVar;
                    break;
                }
            }
            wi wiVar2 = wi.this;
            xi xiVar2 = wiVar2.f;
            if (xiVar2 != null) {
                xiVar2.onDown(motionEvent);
                for (vi viVar : wi.this.c.keySet()) {
                    List list = (List) wi.this.d.get(viVar);
                    list.clear();
                    if (((yi) wi.this.c.get(viVar)).a().contains(wi.this.f) && wi.this.f.a(viVar, motionEvent)) {
                        list.add(wi.this.f);
                        z = true;
                    }
                }
                return z;
            }
            Iterator it = wiVar2.a.iterator();
            while (it.hasNext()) {
                ((xi) it.next()).onDown(motionEvent);
            }
            for (vi viVar2 : wi.this.c.keySet()) {
                List list2 = (List) wi.this.d.get(viVar2);
                list2.clear();
                for (xi xiVar3 : ((yi) wi.this.c.get(viVar2)).a()) {
                    if (xiVar3.a(viVar2, motionEvent)) {
                        list2.add(xiVar3);
                        z = true;
                    }
                }
            }
            return z;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent motionEvent) {
            int size = ((List) wi.this.d.get(vi.LongPress)).size();
            for (int i = 0; i < size; i++) {
                if (((xi) ((List) wi.this.d.get(vi.LongPress)).get(i)).onLongPress(motionEvent)) {
                    wi.this.e = true;
                    for (int i2 = 0; i2 < size; i2++) {
                        if (i2 != i) {
                            ((xi) ((List) wi.this.d.get(vi.LongPress)).get(i2)).c(motionEvent);
                        }
                    }
                    return;
                }
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            List list = (List) wi.this.d.get(vi.Scroll);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                xi xiVar = (xi) it.next();
                if (xiVar.onScroll(motionEvent, motionEvent2, f, f2)) {
                    if (list.size() > 1) {
                        list.clear();
                        list.add(xiVar);
                    }
                    return true;
                }
                it.remove();
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            Iterator it = ((List) wi.this.d.get(vi.Tap)).iterator();
            boolean zD = false;
            while (it.hasNext() && !(zD = ((xi) it.next()).d(motionEvent))) {
            }
            ((List) wi.this.d.get(vi.Tap)).clear();
            return zD;
        }
    }

    public wi(Context context) {
        GestureDetector gestureDetector = new GestureDetector(context, new a(), null);
        this.b = gestureDetector;
        gestureDetector.setIsLongpressEnabled(true);
        this.c = new HashMap();
        this.d = new HashMap();
        for (vi viVar : vi.values()) {
            this.d.put(viVar, new ArrayList());
        }
    }

    public final void a(vi viVar, xi... xiVarArr) {
        this.c.put(viVar, new yi.a(xiVarArr));
        this.a.clear();
        Iterator it = this.c.values().iterator();
        while (it.hasNext()) {
            this.a.addAll(((yi) it.next()).a());
        }
    }

    public final boolean a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1) {
            xi xiVar = this.f;
            if (xiVar != null) {
                xiVar.b(motionEvent);
            } else {
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    ((xi) it.next()).b(motionEvent);
                }
            }
        } else if (action == 3) {
            xi xiVar2 = this.f;
            if (xiVar2 != null) {
                xiVar2.c(motionEvent);
            } else {
                Iterator it2 = this.a.iterator();
                while (it2.hasNext()) {
                    ((xi) it2.next()).c(motionEvent);
                }
            }
        }
        return this.b.onTouchEvent(motionEvent);
    }
}
