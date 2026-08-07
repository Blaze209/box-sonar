package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.transition.TransitionManager;
import com.pspdfkit.R;
import com.pspdfkit.internal.bx.a;
import com.pspdfkit.internal.views.document.DocumentView;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.PdfPasswordView;
import com.pspdfkit.ui.rendering.AnnotationOverlayRenderStrategy;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class uv {
    public final PdfFragment a;
    public final a70 c;
    public final b20 d;
    public Drawable e;
    public c5 f;
    public AnnotationOverlayRenderStrategy g;
    public final y5 h;
    public FrameLayout i;
    public ho j;
    public ImageView k;
    public DocumentView n;
    public boolean o;
    public Disposable p;
    public bx q;
    public f3 r;
    public xa s;
    public int b = -1;
    public final pn<b> l = new pn<>();
    public pn<DocumentView> m = new pn<>();

    public class a implements DocumentView.g {
        public final /* synthetic */ DocumentView a;

        public a(DocumentView documentView) {
            this.a = documentView;
        }

        @Override // com.pspdfkit.internal.views.document.DocumentView.g
        public final void a() {
            uv.this.o = true;
            this.a.postOnAnimation(new Runnable() { // from class: com.pspdfkit.internal.uv$a$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b();
                }
            });
            this.a.l0.b(this);
        }

        public final /* synthetic */ void b() {
            uv.this.c(false);
            uv.this.a((Drawable) null);
        }
    }

    public static class b {
        public final FrameLayout a;
        public final DocumentView b;
        public View c;
        public PdfPasswordView d;

        public b(FrameLayout frameLayout, DocumentView documentView) {
            this.a = frameLayout;
            this.b = documentView;
        }
    }

    public interface c {
        void a(DocumentView documentView);
    }

    public interface d {
        void a(b bVar);
    }

    public uv(PdfFragment pdfFragment, a70 a70Var, b20 b20Var, y5 y5Var) {
        this.a = pdfFragment;
        this.c = a70Var;
        this.d = b20Var;
        this.h = y5Var;
    }

    public final /* synthetic */ void a(DocumentView documentView) {
        this.m.a(documentView);
    }

    public final /* synthetic */ void b(DocumentView documentView) {
        c(false);
        documentView.setOnDocumentInteractionListener(null);
    }

    public final void c() {
        final DocumentView documentView = this.n;
        final FrameLayout frameLayout = this.i;
        if (this.l.b() || this.p != null || frameLayout == null || documentView == null) {
            return;
        }
        synchronized (ar.class) {
            q10.c();
        }
        this.q = new bx("pspdfkit-fragment-initialization", 1);
        Completable completableFromAction = Completable.fromAction(new Action() { // from class: com.pspdfkit.internal.uv$$ExternalSyntheticLambda6
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() throws Throwable {
                this.f$0.c(documentView);
            }
        });
        bx bxVar = this.q;
        bxVar.getClass();
        this.p = completableFromAction.subscribeOn(bxVar.new a(5)).observeOn(AndroidSchedulers.mainThread()).doFinally(new Action() { // from class: com.pspdfkit.internal.uv$$ExternalSyntheticLambda7
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() throws Throwable {
                this.f$0.b();
            }
        }).subscribe(new Action() { // from class: com.pspdfkit.internal.uv$$ExternalSyntheticLambda8
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() throws Throwable {
                this.f$0.a(frameLayout, documentView);
            }
        }, new Consumer() { // from class: com.pspdfkit.internal.uv$$ExternalSyntheticLambda9
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                this.f$0.a((Throwable) obj);
            }
        });
    }

    public final void e(final boolean z) {
        a(new d() { // from class: com.pspdfkit.internal.uv$$ExternalSyntheticLambda0
            @Override // com.pspdfkit.internal.uv.d
            public final void a(uv.b bVar) {
                bVar.b.setScrollingEnabled(z);
            }
        }, false);
    }

    public final void f(final boolean z) {
        a(new d() { // from class: com.pspdfkit.internal.uv$$ExternalSyntheticLambda1
            @Override // com.pspdfkit.internal.uv.d
            public final void a(uv.b bVar) {
                bVar.b.setZoomingEnabled(z);
            }
        }, false);
    }

    public final /* synthetic */ void a(FrameLayout frameLayout, DocumentView documentView) throws Throwable {
        this.l.a(new b(frameLayout, documentView));
        bx bxVar = this.q;
        if (bxVar != null) {
            bxVar.b();
            this.q = null;
        }
    }

    public final void d(final boolean z) {
        PdfPasswordView pdfPasswordView;
        if ((this.l.b() && (pdfPasswordView = this.l.a().d) != null && pdfPasswordView.getVisibility() == 0) == z) {
            return;
        }
        pn<b> pnVar = this.l;
        pn.a aVar = new pn.a() { // from class: com.pspdfkit.internal.uv$$ExternalSyntheticLambda5
            @Override // com.pspdfkit.internal.pn.a
            public final void apply(Object obj) {
                this.f$0.b(z, (uv.b) obj);
            }
        };
        tv.a(pnVar, aVar, aVar, false);
    }

    public final /* synthetic */ void b() throws Throwable {
        this.p = null;
    }

    public final void b(final boolean z) {
        View view;
        if ((this.l.b() && (view = this.l.a().c) != null && view.getVisibility() == 0) == z) {
            return;
        }
        pn<b> pnVar = this.l;
        pn.a aVar = new pn.a() { // from class: com.pspdfkit.internal.uv$$ExternalSyntheticLambda3
            @Override // com.pspdfkit.internal.pn.a
            public final void apply(Object obj) {
                uv.a(z, (uv.b) obj);
            }
        };
        tv.a(pnVar, aVar, aVar, false);
    }

    public final /* synthetic */ void a(Throwable th) throws Throwable {
        PdfLog.e("Nutri.PdfFragViewCoord", th, "Can't initialize fragment contents", new Object[0]);
    }

    public final synchronized DocumentView a(boolean z) {
        if (this.n == null && z) {
            c();
        }
        return this.n;
    }

    public final void b(boolean z, b bVar) {
        if (this.i == null) {
            return;
        }
        if (bVar.d == null) {
            PdfPasswordView pdfPasswordView = new PdfPasswordView(bVar.a.getContext());
            bVar.d = pdfPasswordView;
            pdfPasswordView.setId(R.id.pspdf__fragment_password_view);
            bVar.d.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            bVar.d.setVisibility(8);
        }
        PdfPasswordView pdfPasswordView2 = bVar.d;
        if (z) {
            if (pdfPasswordView2.getParent() == null) {
                bVar.a.addView(pdfPasswordView2);
            }
            pdfPasswordView2.setVisibility(0);
        } else {
            hn.c(pdfPasswordView2);
            bVar.a.removeView(pdfPasswordView2);
            pdfPasswordView2.setVisibility(8);
        }
    }

    public final void a(final d dVar, boolean z) {
        pn<b> pnVar = this.l;
        Objects.requireNonNull(dVar);
        pnVar.a(new pn.a() { // from class: com.pspdfkit.internal.uv$$ExternalSyntheticLambda4
            @Override // com.pspdfkit.internal.pn.a
            public final void apply(Object obj) {
                dVar.a((uv.b) obj);
            }
        }, z);
    }

    public final void a(final c cVar, boolean z) {
        this.m.a(new pn.a() { // from class: com.pspdfkit.internal.uv$$ExternalSyntheticLambda2
            @Override // com.pspdfkit.internal.pn.a
            public final void apply(Object obj) {
                cVar.a((DocumentView) obj);
            }
        }, z);
    }

    public final void a() {
        a(new d() { // from class: com.pspdfkit.internal.uv$$ExternalSyntheticLambda10
            @Override // com.pspdfkit.internal.uv.d
            public final void a(uv.b bVar) {
                this.f$0.a(bVar);
            }
        }, false);
    }

    public final /* synthetic */ void a(b bVar) {
        ho hoVar = this.j;
        if (hoVar != null) {
            TransitionManager.beginDelayedTransition((ViewGroup) hoVar.getParent());
            this.j.a();
            c(false);
        }
    }

    public final void a(final int i) {
        a(new c() { // from class: com.pspdfkit.internal.uv$$ExternalSyntheticLambda11
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                this.f$0.a(i, documentView);
            }
        }, false);
    }

    public final /* synthetic */ void a(int i, DocumentView documentView) {
        FrameLayout frameLayout = this.i;
        if (frameLayout != null) {
            frameLayout.setBackgroundColor(i);
            this.b = i;
        }
    }

    public final void a(Drawable drawable) {
        this.e = drawable;
        if (this.i != null) {
            if (this.k == null) {
                ImageView imageView = new ImageView(this.a.requireContext());
                this.k = imageView;
                this.i.addView(imageView, -1, -1);
            }
            this.k.setVisibility(drawable != null ? 0 : 8);
            this.k.setImageDrawable(drawable);
        }
    }

    public final /* synthetic */ void a(lm lmVar, b bVar) {
        bVar.b.b(lmVar, this.a);
    }

    public final void a(final lm lmVar) {
        a(new d() { // from class: com.pspdfkit.internal.uv$$ExternalSyntheticLambda12
            @Override // com.pspdfkit.internal.uv.d
            public final void a(uv.b bVar) {
                this.f$0.a(lmVar, bVar);
            }
        }, false);
    }

    public static void a(boolean z, b bVar) {
        if (bVar.c == null) {
            View viewInflate = LayoutInflater.from(bVar.a.getContext()).inflate(R.layout.pspdf__pdf_fragment_error_view, (ViewGroup) bVar.a, false);
            bVar.c = viewInflate;
            viewInflate.setVisibility(8);
        }
        View view = bVar.c;
        if (z) {
            if (view.getParent() == null) {
                bVar.a.addView(view);
            }
            view.setVisibility(0);
        } else {
            bVar.a.removeView(view);
            view.setVisibility(8);
        }
    }

    public final void c(final DocumentView documentView) throws Throwable {
        c5 c5Var;
        Context context = this.a.getContext();
        if (this.a.isAdded() && context != null) {
            PdfFragment pdfFragment = this.a;
            a70 a70Var = this.c;
            b20 b20Var = this.d;
            synchronized (this) {
                if (this.f == null) {
                    Context contextRequireContext = this.a.requireContext();
                    PdfFragment pdfFragment2 = this.a;
                    c5 c5Var2 = new c5(contextRequireContext, pdfFragment2, pdfFragment2.getConfiguration());
                    this.f = c5Var2;
                    AnnotationOverlayRenderStrategy annotationOverlayRenderStrategy = this.g;
                    if (annotationOverlayRenderStrategy != null) {
                        c5Var2.e = annotationOverlayRenderStrategy;
                    } else {
                        c5Var2.e = c5.t;
                    }
                }
                c5Var = this.f;
            }
            y5 y5Var = this.h;
            if (this.r == null) {
                this.r = new f3(context);
            }
            documentView.a(pdfFragment, a70Var, b20Var, c5Var, y5Var, this.r, new DocumentView.f() { // from class: com.pspdfkit.internal.uv$$ExternalSyntheticLambda13
                @Override // com.pspdfkit.internal.views.document.DocumentView.f
                public final void a() {
                    this.f$0.a(documentView);
                }
            });
            documentView.setDocumentListener(this.a);
            documentView.setDocumentScrollListener(this.a);
            documentView.setOnDocumentInteractionListener(new DocumentView.e() { // from class: com.pspdfkit.internal.uv$$ExternalSyntheticLambda14
                @Override // com.pspdfkit.internal.views.document.DocumentView.e
                public final void a() {
                    this.f$0.b(documentView);
                }
            });
            documentView.l0.a(new a(documentView));
            documentView.o();
            return;
        }
        PdfLog.w("Nutri.PdfFragViewCoord", "Fragment not attached during prepareFragmentContents, aborting initialization", new Object[0]);
    }

    public final void c(boolean z) {
        ho hoVar = this.j;
        if (hoVar != null) {
            int i = 8;
            if (z && hoVar.a.getVisibility() != 8) {
                i = 0;
            }
            hoVar.setVisibility(i);
        }
    }
}
