package com.pspdfkit.internal;

import android.content.Context;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.internal.jni.NativeDocumentJavaScriptStatus;
import com.pspdfkit.internal.jni.NativeDocumentProvider;
import com.pspdfkit.javascript.JavaScriptProvider;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.functions.Action;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class an implements JavaScriptProvider {
    public final lm a;
    public final or b = new or();
    public final ArrayList<ce> c = new ArrayList<>();
    public boolean d = true;

    public an(lm lmVar) {
        this.a = lmVar;
    }

    public final synchronized boolean a() {
        File fileA;
        boolean zIsEmpty = this.c.isEmpty();
        boolean z = this.d;
        if (z && zIsEmpty) {
            this.a.y.setJavascriptStatus(z ? NativeDocumentJavaScriptStatus.ENABLED : NativeDocumentJavaScriptStatus.DISABLED);
            try {
                Context context = n5.a;
                if (context == null) {
                    throw new IllegalStateException("The application context should not be null. Please call fun setApplicationContext(context: Context) first");
                }
                fileA = wg.a(context, wg.b("dist"), (HashSet) null, "dist");
                if (fileA == null) {
                    PdfLog.w("Nutri.JScriptProvImpl", "The JavaScript API minified bundle is not available on this platform. PDFs containing JavaScript may not work correctly.", new Object[0]);
                }
                Iterator<NativeDocumentProvider> it = this.a.y.getDocumentProviders().iterator();
                it.getClass();
                while (it.hasNext()) {
                    NativeDocumentProvider next = it.next();
                    ArrayList<ce> arrayList = this.c;
                    next.getClass();
                    arrayList.add(new ce(next, fileA != null ? fileA.getAbsolutePath() : null, this.b));
                }
            } catch (IOException unused) {
                fileA = null;
            }
        }
        return this.d;
    }

    @Override // com.pspdfkit.javascript.JavaScriptProvider
    public final void executeDocumentLevelScripts() {
        if (a()) {
            Iterator<ce> it = this.c.iterator();
            it.getClass();
            while (it.hasNext()) {
                ce next = it.next();
                next.getClass();
                next.a.executeDocumentLevelJavascripts();
            }
        }
    }

    @Override // com.pspdfkit.javascript.JavaScriptProvider
    public final Completable executeDocumentLevelScriptsAsync() {
        Completable completableSubscribeOn = Completable.fromAction(new Action() { // from class: com.pspdfkit.internal.an$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() {
                an.a(this.f$0);
            }
        }).subscribeOn(this.a.b(5));
        completableSubscribeOn.getClass();
        return completableSubscribeOn;
    }

    @Override // com.pspdfkit.javascript.JavaScriptProvider
    public final boolean isJavaScriptEnabled() {
        return this.d;
    }

    @Override // com.pspdfkit.javascript.JavaScriptProvider
    public final synchronized void setJavaScriptEnabled(boolean z) {
        if (this.d == z) {
            return;
        }
        this.d = z;
        this.a.y.setJavascriptStatus(z ? NativeDocumentJavaScriptStatus.ENABLED : NativeDocumentJavaScriptStatus.DISABLED);
        a();
    }

    public static final void a(an anVar) {
        if (anVar.a()) {
            Iterator<ce> it = anVar.c.iterator();
            it.getClass();
            while (it.hasNext()) {
                ce next = it.next();
                next.getClass();
                next.a.executeDocumentLevelJavascripts();
            }
        }
    }

    public final ce a(Annotation annotation) {
        int pageIndex = annotation.getPageIndex();
        if (annotation.isAttached() && pageIndex >= 0) {
            int iC = this.a.c(pageIndex);
            if (iC < 0 || iC >= this.c.size()) {
                return null;
            }
            return this.c.get(iC);
        }
        PdfLog.e("Nutri.JScriptProvImpl", "Error executing javascript action for annotation %s. Annotation was not attached to document.", annotation);
        return null;
    }
}
