package com.pspdfkit.internal.ui.dialog.signatures;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.microsoft.intune.mam.client.view.MAMViewGroup;
import com.pspdfkit.configuration.signatures.SignatureColorOptions;
import com.pspdfkit.internal.a80;
import com.pspdfkit.internal.ct;
import com.pspdfkit.internal.d9;
import com.pspdfkit.internal.g20;
import com.pspdfkit.internal.no;
import com.pspdfkit.ui.fonts.Font;
import com.pspdfkit.ui.signatures.ElectronicSignatureOptions;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.subjects.CompletableSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class ElectronicSignatureControllerView extends MAMViewGroup implements View.OnClickListener {
    public d a;
    public ct b;
    public int c;
    public int d;
    public boolean e;
    public h f;
    public final HashMap g;
    public a h;
    public int i;
    public boolean j;
    public e k;
    public c l;

    public enum a {
        PRIMARY,
        SECONDARY,
        TERTIARY
    }

    public static class b {
        public final View a;
        public final int b;

        public b(View view, int i) {
            this.a = view;
            this.b = i;
            if (!d9.d) {
                throw new AssertionError("ColorButtonDrawableCreator constants have not been initialized");
            }
            int i2 = d9.a;
            int i3 = d9.b;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            gradientDrawable.setColor(0);
            gradientDrawable.setStroke(i3, i2);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(1);
            gradientDrawable2.setColor(i);
            gradientDrawable2.setStroke(0, 0);
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, gradientDrawable2});
            int i4 = d9.c;
            layerDrawable.setLayerInset(1, i4, i4, i4, i4);
            LayerDrawable layerDrawable2 = new LayerDrawable(new Drawable[]{new GradientDrawable(), gradientDrawable2});
            int i5 = d9.c;
            layerDrawable2.setLayerInset(1, i5, i5, i5, i5);
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{R.attr.state_selected}, layerDrawable);
            stateListDrawable.addState(new int[0], layerDrawable2);
            view.setBackground(stateListDrawable);
        }
    }

    public static class c extends ArrayAdapter<Font> {
        public final View a;
        public final String b;
        public String c;

        public c(Context context, ArrayList arrayList) {
            super(context, R.layout.simple_spinner_item, arrayList);
            this.c = null;
            this.a = new View(context);
            this.b = no.a(getContext(), com.pspdfkit.R.string.pspdf__signature, null);
        }

        @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
        public final View getDropDownView(int i, View view, ViewGroup viewGroup) {
            TextView textView = (TextView) super.getDropDownView(i, view, viewGroup);
            Font item = getItem(i);
            if (item != null) {
                textView.setTypeface(item.getDefaultTypeface());
            }
            String str = this.c;
            if (str == null || str.trim().isEmpty()) {
                textView.setText(this.b);
                return textView;
            }
            textView.setText(this.c);
            return textView;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public final View getView(int i, View view, ViewGroup viewGroup) {
            return this.a;
        }
    }

    public interface d {
        void a(int i);
    }

    public enum e {
        HORIZONTAL,
        VERTICAL
    }

    public ElectronicSignatureControllerView(Context context) {
        super(context);
        this.e = false;
        this.g = new HashMap(3);
        this.j = false;
        this.k = e.HORIZONTAL;
        a(context);
    }

    public final void a(Context context) {
        g20 g20Var = new g20(context);
        this.e = g20Var.g;
        int i = g20Var.h;
        this.d = (int) getResources().getDimension(com.pspdfkit.R.dimen.pspdf__electronic_signature_layout_padding);
        this.i = (int) getResources().getDimension(com.pspdfkit.R.dimen.pspdf__electronic_signature_canvas_controller_picker_circles_padding);
        this.c = (int) getResources().getDimension(com.pspdfkit.R.dimen.pspdf__electronic_signature_canvas_controller_picker_circles_size);
        d9.a = i;
        d9.b = (int) context.getResources().getDimension(com.pspdfkit.R.dimen.pspdf__electronic_signature_canvas_controller_picker_circles_border_width);
        d9.c = (int) context.getResources().getDimension(com.pspdfkit.R.dimen.pspdf__electronic_signature_canvas_controller_picker_circles_inner_inset);
        d9.d = true;
        h hVar = new h(context);
        this.f = hVar;
        hVar.setId(com.pspdfkit.R.id.pspdf__electronic_signatures_font_selection_spinner);
        this.f.setBackgroundResource(com.pspdfkit.R.drawable.pspdf__electronic_signature_tt_icon_selector);
        c cVar = new c(getContext(), new ArrayList(ElectronicSignatureOptions.INSTANCE.getAvailableFonts(getContext())));
        cVar.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        this.l = cVar;
        this.f.setAdapter((SpinnerAdapter) cVar);
        this.f.setSpinnerEventsListener(new com.pspdfkit.internal.ui.dialog.signatures.c(this));
        addView(this.f);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.c, 1073741824);
        this.f.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        this.f.setSelected(false);
    }

    public e getOrientation() {
        return this.k;
    }

    public Font getSelectedFont() {
        h hVar = this.f;
        if (hVar != null) {
            return (Font) hVar.getSelectedItem();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        for (Map.Entry entry : this.g.entrySet()) {
            if (view == ((b) entry.getValue()).a) {
                if (!this.j) {
                    this.j = true;
                    if (this.g.size() != 3) {
                        throw new AssertionError("Signature color options have not been initialized correctly.");
                    }
                    a(((b) this.g.get(a.PRIMARY)).a, 0).mergeWith(a(((b) this.g.get(a.SECONDARY)).a, this.c + this.i)).mergeWith(a(((b) this.g.get(a.TERTIARY)).a, (this.c + this.i) * 2)).mergeWith(a((this.c + this.i) * 2)).subscribe();
                    return;
                }
                a aVar = (a) entry.getKey();
                this.h = aVar;
                a(aVar, false);
                d dVar = this.a;
                if (dVar != null) {
                    dVar.a(((b) entry.getValue()).b);
                }
                this.j = false;
                if (this.g.size() != 3) {
                    throw new AssertionError("Signature color options have not been initialized correctly.");
                }
                HashMap map = this.g;
                a aVar2 = a.PRIMARY;
                Completable completableA = a(((b) map.get(aVar2)).a, aVar2 == this.h);
                HashMap map2 = this.g;
                a aVar3 = a.SECONDARY;
                Completable completableMergeWith = completableA.mergeWith(a(((b) map2.get(aVar3)).a, aVar3 == this.h));
                HashMap map3 = this.g;
                a aVar4 = a.TERTIARY;
                completableMergeWith.mergeWith(a(((b) map3.get(aVar4)).a, aVar4 == this.h)).mergeWith(a()).subscribe();
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = a80.c(getContext()) ? (getMeasuredWidth() - this.d) - this.c : this.d;
        int measuredHeight = this.k.equals(e.HORIZONTAL) ? this.d : (getMeasuredHeight() - this.d) - this.c;
        int i5 = this.c;
        int i6 = measuredWidth + i5;
        int i7 = i5 + measuredHeight;
        Iterator it = this.g.entrySet().iterator();
        while (it.hasNext()) {
            ((b) ((Map.Entry) it.next()).getValue()).a.layout(measuredWidth, measuredHeight, i6, i7);
        }
        if (this.e) {
            boolean zC = a80.c(getContext());
            h hVar = this.f;
            int i8 = this.i;
            if (zC) {
                int i9 = measuredWidth - i8;
                hVar.layout(i9 - this.c, measuredHeight, i9, i7);
            } else {
                int i10 = i6 + i8;
                hVar.layout(i10, measuredHeight, this.c + i10, i7);
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        int childCount;
        int i4;
        int i5;
        int i6;
        boolean zEquals = this.k.equals(e.HORIZONTAL);
        boolean z = this.e;
        if (zEquals) {
            int childCount2 = ((z ? 3 : 2) * this.i) + (getChildCount() * this.c);
            int i7 = this.d * 2;
            i6 = childCount2 + i7;
            i5 = i7 + this.c;
        } else {
            int i8 = this.c;
            if (z) {
                i3 = this.i + (this.d * 2) + (i8 * 2);
                childCount = (this.i * 2) + ((getChildCount() - 1) * i8);
                i4 = this.d;
            } else {
                i3 = (this.d * 2) + i8;
                childCount = (this.i * 2) + (getChildCount() * i8);
                i4 = this.d;
            }
            int i9 = i3;
            i5 = childCount + (i4 * 2);
            i6 = i9;
        }
        setMeasuredDimension(View.resolveSizeAndState(i6, i, 0), View.resolveSizeAndState(i5, i2, 0));
    }

    public void setCurrentlySelectedColor(int i) {
        for (Map.Entry entry : this.g.entrySet()) {
            if (((b) entry.getValue()).b == i) {
                a aVar = (a) entry.getKey();
                this.h = aVar;
                a(aVar, true);
            }
        }
    }

    public void setFontSelectionSpinnerVisible(boolean z) {
        this.e = z;
    }

    public void setListener(d dVar) {
        this.a = dVar;
    }

    public void setOnFontSelectionListener(ct ctVar) {
        this.b = ctVar;
    }

    public void setOrientation(e eVar) {
        if (this.k != eVar) {
            this.k = eVar;
            requestLayout();
        }
    }

    public void setTypedSignature(String str) {
        c cVar = this.l;
        if (cVar != null) {
            cVar.c = str;
        }
    }

    public ElectronicSignatureControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = false;
        this.g = new HashMap(3);
        this.j = false;
        this.k = e.HORIZONTAL;
        a(context);
    }

    public final void a(SignatureColorOptions signatureColorOptions) {
        HashMap map = this.g;
        a aVar = a.PRIMARY;
        int i = com.pspdfkit.R.id.pspdf__electronic_signatures_color_option_primary;
        View view = new View(getContext());
        view.setId(i);
        view.setOnClickListener(this);
        addView(view);
        map.put(aVar, new b(view, signatureColorOptions.option1(getContext())));
        HashMap map2 = this.g;
        a aVar2 = a.SECONDARY;
        int i2 = com.pspdfkit.R.id.pspdf__electronic_signatures_color_option_secondary;
        View view2 = new View(getContext());
        view2.setId(i2);
        view2.setOnClickListener(this);
        addView(view2);
        map2.put(aVar2, new b(view2, signatureColorOptions.option2(getContext())));
        HashMap map3 = this.g;
        a aVar3 = a.TERTIARY;
        int i3 = com.pspdfkit.R.id.pspdf__electronic_signatures_color_option_tertiary;
        View view3 = new View(getContext());
        view3.setId(i3);
        view3.setOnClickListener(this);
        addView(view3);
        map3.put(aVar3, new b(view3, signatureColorOptions.option3(getContext())));
        if (this.g.size() == 3) {
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.c, 1073741824);
            ((b) this.g.get(aVar)).a.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            ((b) this.g.get(aVar2)).a.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            ((b) this.g.get(aVar3)).a.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            this.h = aVar;
            a(aVar, true);
            return;
        }
        throw new AssertionError("Signature color options have not been initialized correctly.");
    }

    public final void a(a aVar, boolean z) {
        if (this.g.size() == 3) {
            for (Map.Entry entry : this.g.entrySet()) {
                boolean z2 = entry.getKey() == aVar;
                ((b) entry.getValue()).a.setSelected(z2);
                if (z) {
                    ((b) entry.getValue()).a.setAlpha(z2 ? 1.0f : 0.0f);
                }
                if (z2) {
                    ((b) entry.getValue()).a.bringToFront();
                }
            }
            return;
        }
        throw new AssertionError("Signature color options have not been initialized correctly.");
    }

    public ElectronicSignatureControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = false;
        this.g = new HashMap(3);
        this.j = false;
        this.k = e.HORIZONTAL;
        a(context);
    }

    public final Completable a(final View view, final int i) {
        final CompletableSubject completableSubjectCreate = CompletableSubject.create();
        return completableSubjectCreate.doOnSubscribe(new Consumer() { // from class: com.pspdfkit.internal.ui.dialog.signatures.ElectronicSignatureControllerView$$ExternalSyntheticLambda3
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                this.f$0.a(view, i, completableSubjectCreate, (Disposable) obj);
            }
        });
    }

    public final void a(View view, int i, CompletableSubject completableSubject, Disposable disposable) throws Throwable {
        ViewPropertyAnimator viewPropertyAnimatorTranslationY;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        if (this.k.equals(e.HORIZONTAL)) {
            viewPropertyAnimatorTranslationY = viewPropertyAnimatorAnimate.translationX(a80.c(getContext()) ? -i : i);
        } else {
            viewPropertyAnimatorTranslationY = viewPropertyAnimatorAnimate.translationY(-i);
        }
        ViewPropertyAnimator interpolator = viewPropertyAnimatorTranslationY.alpha(1.0f).setDuration(300L).setInterpolator(new AccelerateDecelerateInterpolator());
        Objects.requireNonNull(completableSubject);
        interpolator.withEndAction(new ElectronicSignatureControllerView$$ExternalSyntheticLambda1(completableSubject));
    }

    public final Completable a(final int i) {
        if (this.e && this.k != e.VERTICAL) {
            final CompletableSubject completableSubjectCreate = CompletableSubject.create();
            return completableSubjectCreate.doOnSubscribe(new Consumer() { // from class: com.pspdfkit.internal.ui.dialog.signatures.ElectronicSignatureControllerView$$ExternalSyntheticLambda0
                @Override // io.reactivex.rxjava3.functions.Consumer
                public final void accept(Object obj) throws Throwable {
                    this.f$0.a(i, completableSubjectCreate, (Disposable) obj);
                }
            });
        }
        return Completable.complete();
    }

    public final void a(int i, CompletableSubject completableSubject, Disposable disposable) throws Throwable {
        ViewPropertyAnimator viewPropertyAnimatorTranslationY;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = this.f.animate();
        if (this.k.equals(e.HORIZONTAL)) {
            viewPropertyAnimatorTranslationY = viewPropertyAnimatorAnimate.translationX(a80.c(getContext()) ? -i : i);
        } else {
            viewPropertyAnimatorTranslationY = viewPropertyAnimatorAnimate.translationY(-i);
        }
        ViewPropertyAnimator interpolator = viewPropertyAnimatorTranslationY.setDuration(300L).setInterpolator(new AccelerateDecelerateInterpolator());
        Objects.requireNonNull(completableSubject);
        interpolator.withEndAction(new ElectronicSignatureControllerView$$ExternalSyntheticLambda1(completableSubject));
    }

    public final Completable a(final View view, final boolean z) {
        final CompletableSubject completableSubjectCreate = CompletableSubject.create();
        return completableSubjectCreate.doOnSubscribe(new Consumer() { // from class: com.pspdfkit.internal.ui.dialog.signatures.ElectronicSignatureControllerView$$ExternalSyntheticLambda2
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                this.f$0.a(view, z, completableSubjectCreate, (Disposable) obj);
            }
        });
    }

    public final void a(View view, boolean z, CompletableSubject completableSubject, Disposable disposable) throws Throwable {
        ViewPropertyAnimator viewPropertyAnimatorTranslationY;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        if (this.k.equals(e.HORIZONTAL)) {
            viewPropertyAnimatorTranslationY = viewPropertyAnimatorAnimate.translationX(0.0f);
        } else {
            viewPropertyAnimatorTranslationY = viewPropertyAnimatorAnimate.translationY(0.0f);
        }
        ViewPropertyAnimator interpolator = viewPropertyAnimatorTranslationY.alpha(z ? 1.0f : 0.0f).setDuration(300L).setInterpolator(new AccelerateDecelerateInterpolator());
        Objects.requireNonNull(completableSubject);
        interpolator.withEndAction(new ElectronicSignatureControllerView$$ExternalSyntheticLambda1(completableSubject));
    }

    public final Completable a() {
        if (this.e && this.k != e.VERTICAL) {
            final CompletableSubject completableSubjectCreate = CompletableSubject.create();
            return completableSubjectCreate.doOnSubscribe(new Consumer() { // from class: com.pspdfkit.internal.ui.dialog.signatures.ElectronicSignatureControllerView$$ExternalSyntheticLambda4
                @Override // io.reactivex.rxjava3.functions.Consumer
                public final void accept(Object obj) throws Throwable {
                    this.f$0.a(completableSubjectCreate, (Disposable) obj);
                }
            });
        }
        return Completable.complete();
    }

    public final void a(CompletableSubject completableSubject, Disposable disposable) throws Throwable {
        ViewPropertyAnimator viewPropertyAnimatorTranslationY;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = this.f.animate();
        if (this.k.equals(e.HORIZONTAL)) {
            viewPropertyAnimatorTranslationY = viewPropertyAnimatorAnimate.translationX(0.0f);
        } else {
            viewPropertyAnimatorTranslationY = viewPropertyAnimatorAnimate.translationY(0.0f);
        }
        ViewPropertyAnimator interpolator = viewPropertyAnimatorTranslationY.setDuration(300L).setInterpolator(new AccelerateDecelerateInterpolator());
        Objects.requireNonNull(completableSubject);
        interpolator.withEndAction(new ElectronicSignatureControllerView$$ExternalSyntheticLambda1(completableSubject));
    }
}
