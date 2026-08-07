package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.pspdfkit.R;
import com.pspdfkit.annotations.StampAnnotation;
import com.pspdfkit.document.image.ImagePicker;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i7 extends p7 implements ImagePicker.OnImagePickedListener, tk {
    public final ek f;
    public ImagePicker g;
    public PointF h;
    public boolean i;
    public final d00 j;
    public final mz k;
    public Disposable l;

    public static class a {
        public final Single<StampAnnotation> a;
        public final Disposable b;
        public final Uri c;
        public final int d;

        public a(Single<StampAnnotation> single, Uri uri, Disposable disposable, int i) {
            this.a = single;
            this.b = disposable;
            this.c = uri;
            this.d = i;
        }
    }

    public i7(q0 q0Var, AnnotationToolVariant annotationToolVariant) {
        super(q0Var, annotationToolVariant);
        this.i = false;
        this.j = new d00(q0Var.f.getParentFragmentManager(), "com.pspdfkit.internal.ImageStampAnnotationCreationMode.SAVED_STATE_FRAGMENT_TAG", this);
        this.k = new mz(q0Var.f.getParentFragmentManager(), "com.pspdfkit.internal.ImageStampAnnotationCreationMode.IMAGE_SINGLE_SAVED_STATE_FRAGMENT_TAG");
        Context context = q0Var.a;
        context.getClass();
        this.f = new ek(context);
    }

    public final void a(StampAnnotation stampAnnotation) throws Throwable {
        if (stampAnnotation != null) {
            q0 q0Var = this.a;
            q0Var.getClass();
            ww.a(q0Var.g, stampAnnotation);
            stampAnnotation.getInternal().setVariant(q0Var.t);
            this.a.f.addAnnotationToPage(stampAnnotation, true, null);
            q0 q0Var2 = this.a;
            AnnotationTool annotationTool = AnnotationTool.NONE;
            AnnotationToolVariant annotationToolVariantDefaultVariant = AnnotationToolVariant.defaultVariant();
            q0Var2.getClass();
            annotationTool.getClass();
            annotationToolVariantDefaultVariant.getClass();
            q0Var2.b.enterAnnotatingMode(annotationTool, annotationToolVariantDefaultVariant);
        }
    }

    public abstract void b(Uri uri);

    @Override // com.pspdfkit.internal.p7, com.pspdfkit.internal.gu
    public final boolean d() {
        yz.a(this.l);
        this.l = null;
        this.a.b(this);
        return false;
    }

    @Override // com.pspdfkit.internal.p7, com.pspdfkit.internal.gu
    public final void g() {
        yz.a(this.l);
        this.l = null;
        this.a.c(this);
    }

    public abstract String o();

    @Override // com.pspdfkit.document.image.ImagePicker.OnImagePickedListener
    public final void onCameraPermissionDeclined(boolean z) {
        this.i = false;
        this.h = null;
    }

    /* JADX WARN: Type inference failed for: r0v15, types: [com.pspdfkit.internal.tk, java.lang.Object] */
    @Override // com.pspdfkit.document.image.ImagePicker.OnImagePickedListener
    public final void onImagePicked(Uri uri) {
        this.i = false;
        d00 d00Var = this.j;
        sk skVar = (sk) d00Var.a.findFragmentByTag(d00Var.b);
        if (skVar != null) {
            ?? r0 = d00Var.c;
            skVar.a = r0;
            Bundle bundle = skVar.b;
            if (bundle != null) {
                skVar.b = bundle;
                if (r0.onRestoreInstanceState(bundle)) {
                    skVar.b = null;
                }
            }
        }
        if (this.h != null) {
            d00 d00Var2 = this.j;
            FragmentManager fragmentManager = d00Var2.a;
            String str = d00Var2.b;
            int i = sk.c;
            fragmentManager.getClass();
            str.getClass();
            if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                throw new IllegalStateException("removeFragment() may only be called from the main thread.");
            }
            Fragment fragmentFindFragmentByTag = fragmentManager.findFragmentByTag(str);
            if (fragmentFindFragmentByTag != null) {
                fi.a(fragmentManager, fragmentFindFragmentByTag);
            }
            Single<StampAnnotation> singleObserveOn = this.f.a(j(), k(), this.h, uri).cache().observeOn(AndroidSchedulers.mainThread());
            a(singleObserveOn, uri);
            mz mzVar = this.k;
            a aVar = new a(singleObserveOn, uri, this.l, k());
            mz.a aVar2 = (mz.a) mzVar.a.findFragmentByTag(mzVar.b);
            if (aVar2 != null) {
                aVar2.a = aVar;
            } else {
                mz.a aVar3 = (mz.a) mzVar.a.findFragmentByTag(mzVar.b);
                if (aVar3 == null) {
                    aVar3 = new mz.a();
                    FragmentManager fragmentManager2 = mzVar.a;
                    String str2 = mzVar.b;
                    fragmentManager2.getClass();
                    if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                        throw new IllegalStateException("addFragment() may only be called from the main thread.");
                    }
                    if (!aVar3.isAdded()) {
                        FragmentTransaction fragmentTransactionAdd = fragmentManager2.beginTransaction().add(aVar3, str2);
                        fragmentTransactionAdd.getClass();
                        fragmentTransactionAdd.commitAllowingStateLoss();
                    }
                }
                aVar3.a = aVar;
            }
            this.h = null;
        }
    }

    @Override // com.pspdfkit.document.image.ImagePicker.OnImagePickedListener
    public final void onImagePickerCancelled() {
        this.i = false;
        this.h = null;
    }

    @Override // com.pspdfkit.document.image.ImagePicker.OnImagePickedListener
    public final void onImagePickerUnknownError() {
        this.i = false;
        this.h = null;
        Context context = this.a.a;
        context.getClass();
        Toast.makeText(context, R.string.pspdf__file_not_available, 1).show();
    }

    @Override // com.pspdfkit.internal.tk
    public final boolean onRestoreInstanceState(Bundle bundle) {
        int i = bundle.getInt("STATE_PAGE_INDEX");
        if (i < 0 || i != k()) {
            return false;
        }
        this.h = (PointF) bundle.getParcelable("STATE_TOUCH_POINT");
        return true;
    }

    @Override // com.pspdfkit.internal.tk
    public final void onSaveInstanceState(Bundle bundle) {
        au auVarL = l();
        if (auVarL == null || auVarL.getState() == null) {
            bundle.putInt("STATE_PAGE_INDEX", -1);
        } else {
            bundle.putInt("STATE_PAGE_INDEX", k());
        }
        bundle.putParcelable("STATE_TOUCH_POINT", this.h);
    }

    public abstract void p();

    public final void a(Uri uri, Throwable th) throws Throwable {
        Context context = this.a.a;
        context.getClass();
        Toast.makeText(context, R.string.pspdf__file_not_available, 1).show();
        b(uri);
    }

    @Override // com.pspdfkit.internal.d3, com.pspdfkit.internal.gu
    public final void a(q30 q30Var) {
        this.b = q30Var;
        this.a.a(this);
        ImagePicker imagePicker = new ImagePicker(this.a.f.getParentFragmentManager(), o());
        this.g = imagePicker;
        imagePicker.setOnImagePickedListener(this);
        mz mzVar = this.k;
        mz.a aVar = (mz.a) mzVar.a.findFragmentByTag(mzVar.b);
        Object obj = null;
        if (aVar != null) {
            Object obj2 = aVar.a;
            aVar.a = null;
            FragmentManager fragmentManager = mzVar.a;
            String str = mzVar.b;
            fragmentManager.getClass();
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                Fragment fragmentFindFragmentByTag = fragmentManager.findFragmentByTag(str);
                if (fragmentFindFragmentByTag != null) {
                    fi.a(fragmentManager, fragmentFindFragmentByTag, true);
                }
                obj = obj2;
            } else {
                throw new IllegalStateException("removeFragmentAllowingStateLoss() may only be called from the main thread.");
            }
        }
        a aVar2 = (a) obj;
        if (aVar2 == null || aVar2.d != k()) {
            return;
        }
        yz.a(aVar2.b);
        a(aVar2.a, aVar2.c);
    }

    @Override // com.pspdfkit.internal.p7
    public final void a(float f, float f2) {
        au auVarL;
        if (this.i || (auVarL = l()) == null) {
            return;
        }
        PointF pointF = new PointF(f, f2);
        this.h = pointF;
        l4.a(auVarL.a((Matrix) null), pointF);
        this.j.a();
        this.i = true;
        p();
    }

    public final void a(Disposable disposable) throws Throwable {
        if (this.d == null) {
            Context context = this.a.a;
            context.getClass();
            cx cxVar = new cx(context);
            this.d = cxVar;
            cxVar.a(true);
            this.d.setCancelable(false);
            this.d.setCanceledOnTouchOutside(false);
            cx cxVar2 = this.d;
            cxVar2.c = 0;
            Context context2 = this.a.a;
            context2.getClass();
            cxVar2.setMessage(no.a(context2, R.string.pspdf__loading, null));
            this.d.show();
        }
    }

    public final void a(Single<StampAnnotation> single, final Uri uri) {
        this.l = single.doOnDispose(new Action() { // from class: com.pspdfkit.internal.i7$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() {
                this.f$0.n();
            }
        }).doOnSubscribe(new Consumer() { // from class: com.pspdfkit.internal.i7$$ExternalSyntheticLambda1
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                this.f$0.a((Disposable) obj);
            }
        }).doAfterTerminate(new Action() { // from class: com.pspdfkit.internal.i7$$ExternalSyntheticLambda2
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() throws Throwable {
                this.f$0.a(uri);
            }
        }).subscribe(new Consumer() { // from class: com.pspdfkit.internal.i7$$ExternalSyntheticLambda3
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                this.f$0.a((StampAnnotation) obj);
            }
        }, new Consumer() { // from class: com.pspdfkit.internal.i7$$ExternalSyntheticLambda4
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                this.f$0.a(uri, (Throwable) obj);
            }
        });
    }

    public final void a(Uri uri) throws Throwable {
        n();
        b(uri);
        mz mzVar = this.k;
        mz.a aVar = (mz.a) mzVar.a.findFragmentByTag(mzVar.b);
        if (aVar != null) {
            aVar.a = null;
        }
        mz mzVar2 = this.k;
        FragmentManager fragmentManager = mzVar2.a;
        String str = mzVar2.b;
        fragmentManager.getClass();
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            Fragment fragmentFindFragmentByTag = fragmentManager.findFragmentByTag(str);
            if (fragmentFindFragmentByTag == null) {
                return;
            }
            fi.a(fragmentManager, fragmentFindFragmentByTag, true);
            return;
        }
        throw new IllegalStateException("removeFragmentAllowingStateLoss() may only be called from the main thread.");
    }
}
