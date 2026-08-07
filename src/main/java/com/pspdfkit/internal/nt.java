package com.pspdfkit.internal;

import android.content.Context;
import android.widget.LinearLayout;
import androidx.lifecycle.ViewModelStoreOwner;
import com.pspdfkit.configuration.PdfConfiguration;

/* JADX INFO: loaded from: classes3.dex */
public abstract class nt<T> extends LinearLayout {
    public a a;
    public boolean b;
    public final ViewModelStoreOwner c;

    public interface a {
        void hide();
    }

    public interface b<T> {
        void a(nt<T> ntVar, T t);
    }

    public nt(Context context) {
        super(context);
        this.c = null;
        setOrientation(1);
    }

    public void a() {
    }

    public abstract void a(lm lmVar, PdfConfiguration pdfConfiguration);

    public abstract void a(ot otVar);

    public void b() {
        if (this.b) {
            c();
        }
    }

    public void c() {
    }

    public abstract int getTabButtonId();

    public abstract String getTitle();

    public ViewModelStoreOwner getViewModelStoreOwner() throws IllegalStateException {
        ViewModelStoreOwner viewModelStoreOwner = this.c;
        if (viewModelStoreOwner != null) {
            return viewModelStoreOwner;
        }
        if (getContext() instanceof ViewModelStoreOwner) {
            return (ViewModelStoreOwner) getContext();
        }
        throw new IllegalStateException("ViewModelStoreOwner is not set.");
    }

    public void setOnHideListener(a aVar) {
        this.a = aVar;
    }

    public void setPageSelected(boolean z) {
        this.b = z;
        if (z) {
            c();
        }
    }

    public nt(Context context, ViewModelStoreOwner viewModelStoreOwner) {
        super(context);
        this.c = viewModelStoreOwner;
        setOrientation(1);
    }
}
