package com.pspdfkit.internal.ui.dialog.signatures;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.microsoft.intune.mam.client.view.MAMViewGroup;
import com.pspdfkit.R;
import com.pspdfkit.internal.a80;
import com.pspdfkit.internal.g20;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.subjects.CompletableSubject;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class SignatureControllerView extends MAMViewGroup implements View.OnClickListener {
    public a a;
    public FloatingActionButton b;
    public int c;
    public int d;
    public FloatingActionButton e;
    public FloatingActionButton f;
    public FloatingActionButton g;
    public final HashMap h;
    public int i;
    public boolean j;

    public interface a {
        void a(int i);
    }

    public SignatureControllerView(Context context) {
        super(context);
        this.h = new HashMap(3);
        this.j = false;
        a(context);
    }

    public final void a(Context context) {
        this.d = (int) getResources().getDimension(R.dimen.pspdf__signature_layout_padding);
        this.i = (int) getResources().getDimension(R.dimen.pspdf__signature_canvas_controller_picker_circles_padding);
        this.c = (int) getResources().getDimension(R.dimen.pspdf__signature_canvas_controller_picker_circles_size);
        g20 g20Var = new g20(context);
        int i = g20Var.i;
        int i2 = g20Var.j;
        int i3 = g20Var.k;
        FloatingActionButton floatingActionButton = new FloatingActionButton(context);
        this.e = floatingActionButton;
        floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(i));
        this.e.setOnClickListener(this);
        this.h.put(this.e, Integer.valueOf(i));
        addView(this.e);
        FloatingActionButton floatingActionButton2 = new FloatingActionButton(context);
        this.f = floatingActionButton2;
        floatingActionButton2.setBackgroundTintList(ColorStateList.valueOf(i2));
        this.f.setOnClickListener(this);
        this.h.put(this.f, Integer.valueOf(i2));
        addView(this.f);
        FloatingActionButton floatingActionButton3 = new FloatingActionButton(context);
        this.g = floatingActionButton3;
        floatingActionButton3.setBackgroundTintList(ColorStateList.valueOf(i3));
        this.g.setOnClickListener(this);
        this.h.put(this.g, Integer.valueOf(i3));
        addView(this.g);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.c, 1073741824);
        this.e.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        this.f.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        this.g.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        FloatingActionButton floatingActionButton4 = this.e;
        this.b = floatingActionButton4;
        floatingActionButton4.bringToFront();
        this.f.setAlpha(0.0f);
        this.g.setAlpha(0.0f);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        FloatingActionButton floatingActionButton = this.e;
        if (view == floatingActionButton || view == this.f || view == this.g) {
            if (this.j) {
                this.b = (FloatingActionButton) view;
                a aVar = this.a;
                if (aVar != null) {
                    aVar.a(((Integer) this.h.get(view)).intValue());
                }
                this.j = false;
                FloatingActionButton floatingActionButton2 = this.e;
                Completable completableA = a(floatingActionButton2, floatingActionButton2 == this.b);
                FloatingActionButton floatingActionButton3 = this.f;
                Completable completableMergeWith = completableA.mergeWith(a(floatingActionButton3, floatingActionButton3 == this.b));
                FloatingActionButton floatingActionButton4 = this.g;
                completableMergeWith.mergeWith(a(floatingActionButton4, floatingActionButton4 == this.b)).subscribe();
            } else {
                this.j = true;
                a(floatingActionButton, 0).mergeWith(a(this.f, this.c + this.i)).mergeWith(a(this.g, (this.c + this.i) * 2)).subscribe();
            }
        }
        view.bringToFront();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.a = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        if (a80.c(getContext())) {
            int measuredWidth = getMeasuredWidth();
            i5 = this.d;
            i6 = (measuredWidth - i5) - this.c;
        } else {
            i5 = this.d;
            i6 = i5;
        }
        int i7 = this.c;
        int i8 = i6 + i7;
        int i9 = i7 + i5;
        this.e.layout(i6, i5, i8, i9);
        this.f.layout(i6, i5, i8, i9);
        this.g.layout(i6, i5, i8, i9);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        int childCount = (this.i * 2) + (getChildCount() * this.c);
        int i3 = this.d * 2;
        setMeasuredDimension(View.resolveSizeAndState(childCount + i3, i, 0), View.resolveSizeAndState(i3 + this.c, i2, 0));
    }

    public void setCurrentlySelectedColor(int i) {
        for (Map.Entry entry : this.h.entrySet()) {
            if (((Integer) entry.getValue()).intValue() == i) {
                FloatingActionButton floatingActionButton = (FloatingActionButton) entry.getKey();
                this.b = floatingActionButton;
                floatingActionButton.bringToFront();
            }
        }
    }

    public void setListener(a aVar) {
        this.a = aVar;
    }

    public SignatureControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = new HashMap(3);
        this.j = false;
        a(context);
    }

    public SignatureControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = new HashMap(3);
        this.j = false;
        a(context);
    }

    public final Completable a(final FloatingActionButton floatingActionButton, final int i) {
        final boolean zC = a80.c(getContext());
        final CompletableSubject completableSubjectCreate = CompletableSubject.create();
        return completableSubjectCreate.doOnSubscribe(new Consumer() { // from class: com.pspdfkit.internal.ui.dialog.signatures.SignatureControllerView$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                SignatureControllerView.a(floatingActionButton, zC, i, completableSubjectCreate, (Disposable) obj);
            }
        });
    }

    public static /* synthetic */ void a(FloatingActionButton floatingActionButton, boolean z, int i, CompletableSubject completableSubject, Disposable disposable) throws Throwable {
        ViewPropertyAnimator interpolator = floatingActionButton.animate().translationX(z ? -i : i).alpha(1.0f).setDuration(300L).setInterpolator(new AccelerateDecelerateInterpolator());
        Objects.requireNonNull(completableSubject);
        interpolator.withEndAction(new ElectronicSignatureControllerView$$ExternalSyntheticLambda1(completableSubject));
    }

    public static Completable a(final FloatingActionButton floatingActionButton, final boolean z) {
        final CompletableSubject completableSubjectCreate = CompletableSubject.create();
        return completableSubjectCreate.doOnSubscribe(new Consumer() { // from class: com.pspdfkit.internal.ui.dialog.signatures.SignatureControllerView$$ExternalSyntheticLambda1
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                SignatureControllerView.a(floatingActionButton, z, completableSubjectCreate, (Disposable) obj);
            }
        });
    }

    public static /* synthetic */ void a(FloatingActionButton floatingActionButton, boolean z, CompletableSubject completableSubject, Disposable disposable) throws Throwable {
        ViewPropertyAnimator interpolator = floatingActionButton.animate().translationX(0.0f).alpha(z ? 1.0f : 0.0f).setDuration(300L).setInterpolator(new AccelerateDecelerateInterpolator());
        Objects.requireNonNull(completableSubject);
        interpolator.withEndAction(new ElectronicSignatureControllerView$$ExternalSyntheticLambda1(completableSubject));
    }
}
