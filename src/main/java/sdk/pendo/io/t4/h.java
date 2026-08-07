package sdk.pendo.io.t4;

import android.view.View;
import sdk.pendo.io.k3.k;
import sdk.pendo.io.k3.l;

/* JADX INFO: loaded from: classes5.dex */
final class h implements l<Object> {
    static final Object b = new Object();
    final View a;

    class a extends sdk.pendo.io.l3.a implements View.OnAttachStateChangeListener {
        final k<Object> b;

        public a(k<Object> kVar) {
            this.b = kVar;
        }

        @Override // sdk.pendo.io.l3.a
        protected void a() {
            h.this.a.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            this.b.onNext(h.b);
        }
    }

    public h(View view) {
        this.a = view;
    }

    @Override // sdk.pendo.io.k3.l
    public void a(k<Object> kVar) {
        sdk.pendo.io.l3.a.b();
        a aVar = new a(kVar);
        kVar.a(aVar);
        this.a.addOnAttachStateChangeListener(aVar);
    }
}
