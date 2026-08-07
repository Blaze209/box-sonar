package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.RectF;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import com.pspdfkit.forms.FormElement;
import com.pspdfkit.ui.overlay.OverlayLayoutParams;
import com.pspdfkit.ui.special_mode.controller.FormEditingController;
import java.util.WeakHashMap;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class rj extends View implements uh<FormElement> {
    public final mh a;
    public FormElement b;
    public final xh c;
    public hn.c d;

    public interface a {
        void a(RectF rectF);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rj(Context context, int i, mh mhVar) {
        super(context);
        context.getClass();
        this.a = mhVar;
        this.c = new xh();
        setBackgroundColor(i);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    @Override // com.pspdfkit.internal.uh
    public final View a() {
        return this;
    }

    @Override // com.pspdfkit.internal.uh
    public final Object a(Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(false);
    }

    @Override // com.pspdfkit.internal.uh
    public final void d() {
        hn.c cVar = this.d;
        if (cVar != null) {
            cVar.b();
        }
        this.d = null;
    }

    @Override // com.pspdfkit.internal.uh
    public final void g() {
    }

    @Override // com.pspdfkit.internal.uh
    public FormElement getFormElement() {
        return this.b;
    }

    @Override // com.pspdfkit.internal.uh
    public final void l() {
        final mh mhVar;
        final FormElement formElement = getFormElement();
        if (formElement == null || (mhVar = this.a) == null) {
            return;
        }
        hn.d dVar = new hn.d() { // from class: com.pspdfkit.internal.rj$$ExternalSyntheticLambda0
            @Override // com.pspdfkit.internal.hn.d
            public final void a(boolean z) {
                rj.a(mhVar, formElement, this, z);
            }
        };
        WeakHashMap weakHashMap = hn.a;
        this.d = new hn.c(a80.a(this), dVar);
        getViewTreeObserver().addOnGlobalLayoutListener(new y70(this, new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.pspdfkit.internal.rj$$ExternalSyntheticLambda1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                rj.a(this.f$0, mhVar, formElement);
            }
        }));
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementEditingModeChangeListener
    public final void onChangeFormElementEditingMode(FormEditingController formEditingController) {
        formEditingController.getClass();
        xh xhVar = this.c;
        xhVar.getClass();
        formEditingController.getClass();
        xhVar.b = formEditingController;
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementEditingModeChangeListener
    public final void onEnterFormElementEditingMode(FormEditingController formEditingController) {
        formEditingController.getClass();
        xh xhVar = this.c;
        xhVar.getClass();
        formEditingController.getClass();
        xhVar.b = formEditingController;
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementEditingModeChangeListener
    public final void onExitFormElementEditingMode(FormEditingController formEditingController) {
        formEditingController.getClass();
        xh xhVar = this.c;
        xhVar.getClass();
        formEditingController.getClass();
        xhVar.b = null;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        keyEvent.getClass();
        return this.c.a(i, keyEvent) || super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        keyEvent.getClass();
        return this.c.b(i, keyEvent) || super.onKeyUp(i, keyEvent);
    }

    public void setFormElement(FormElement formElement) {
        if (Intrinsics.areEqual(formElement, this.b)) {
            return;
        }
        this.b = formElement;
        if (formElement != null) {
            setLayoutParams(new OverlayLayoutParams(formElement.getAnnotation().getBoundingBox(), OverlayLayoutParams.SizingMode.LAYOUT));
            hn.c(this);
            requestFocus();
            xh xhVar = this.c;
            xhVar.getClass();
            xhVar.a = formElement;
        }
    }

    public static final void a(a aVar, FormElement formElement, rj rjVar, boolean z) {
        if (z) {
            return;
        }
        aVar.a(formElement.getAnnotation().getBoundingBox());
        hn.c cVar = rjVar.d;
        if (cVar != null) {
            cVar.b();
        }
        rjVar.d = null;
    }

    public static final void a(rj rjVar, a aVar, FormElement formElement) {
        hn.c cVar = rjVar.d;
        if (cVar != null && cVar.g <= 0) {
            cVar.b();
            rjVar.d = null;
        }
        aVar.a(formElement.getAnnotation().getBoundingBox());
    }
}
