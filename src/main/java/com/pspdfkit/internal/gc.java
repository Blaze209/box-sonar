package com.pspdfkit.internal;

import android.content.Context;
import android.os.Bundle;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.document.DocumentSource;
import com.pspdfkit.jetpack.compose.interactors.DocumentState;
import com.pspdfkit.ui.toolbar.ToolbarCoordinatorLayout;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public interface gc {
    Object a(Context context, DocumentState documentState, ToolbarCoordinatorLayout.OnContextualToolbarLifecycleListener onContextualToolbarLifecycleListener, Function2 function2, Continuation continuation);

    void a(int i);

    void a(Bundle bundle);

    void a(PdfActivityConfiguration pdfActivityConfiguration);

    void a(DocumentSource documentSource);

    void b();

    void b(int i);

    int c();

    Bundle e();

    boolean f();

    DocumentSource getDocumentSource();

    PdfActivityConfiguration h();

    void i();
}
