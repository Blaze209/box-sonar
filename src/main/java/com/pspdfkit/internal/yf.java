package com.pspdfkit.internal;

import android.content.Context;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.ComposeView;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.pspdfkit.R;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.document.files.EmbeddedFile;
import com.pspdfkit.document.files.EmbeddedFilesProvider;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: loaded from: classes3.dex */
public final class yf extends nt<EmbeddedFile> {
    public final nt.b<EmbeddedFile> d;
    public final fg e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yf(Context context, nt.b<EmbeddedFile> bVar, ViewModelStoreOwner viewModelStoreOwner) {
        super(context, viewModelStoreOwner);
        context.getClass();
        bVar.getClass();
        this.d = bVar;
        ViewModelStoreOwner viewModelStoreOwner2 = getViewModelStoreOwner();
        viewModelStoreOwner2.getClass();
        this.e = (fg) new ViewModelProvider(viewModelStoreOwner2, new v70(new Function0() { // from class: com.pspdfkit.internal.yf$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return yf.d();
            }
        })).get(String.valueOf(hashCode()), fg.class);
        ComposeView composeViewA = y9.a(context, p9.a);
        composeViewA.setContent(ComposableLambdaKt.composableLambdaInstance(-1697414092, true, new Function2() { // from class: com.pspdfkit.internal.yf$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return yf.a(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
        addView(composeViewA);
    }

    public static final Unit a(final yf yfVar, Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1697414092, i, -1, "com.pspdfkit.internal.views.outline.embed.EmbeddedFilesListView.<anonymous>.<anonymous> (EmbeddedFilesListView.kt:44)");
            }
            ag agVar = (ag) SnapshotStateKt.collectAsState(yfVar.e.b, null, composer, 0, 1).getValue();
            boolean zChangedInstance = composer.changedInstance(yfVar);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.pspdfkit.internal.yf$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return yf.a(this.f$0, (EmbeddedFile) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            xf.a(agVar, (Function1<? super EmbeddedFile, Unit>) objRememberedValue, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composer, 384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final fg d() {
        return new fg();
    }

    @Override // com.pspdfkit.internal.nt
    public int getTabButtonId() {
        return R.id.pspdf__menu_pdf_outline_embedded_documents;
    }

    @Override // com.pspdfkit.internal.nt
    public String getTitle() {
        String strA = no.a(getContext(), R.string.pspdf__attachments, null);
        strA.getClass();
        return strA;
    }

    public static final Unit a(yf yfVar, EmbeddedFile embeddedFile) {
        embeddedFile.getClass();
        yfVar.d.a(yfVar, embeddedFile);
        return Unit.INSTANCE;
    }

    @Override // com.pspdfkit.internal.nt
    public final void a(lm lmVar, PdfConfiguration pdfConfiguration) {
        ag value;
        ag value2;
        lm lmVar2;
        o3 annotationProvider;
        fg fgVar = this.e;
        eg egVar = fgVar.f;
        if (egVar != null && (lmVar2 = fgVar.e) != null && (annotationProvider = lmVar2.getAnnotationProvider()) != null) {
            annotationProvider.h.b(egVar);
        }
        fgVar.f = null;
        fgVar.e = lmVar;
        if (lmVar == null) {
            fgVar.c = true;
            MutableStateFlow<ag> mutableStateFlow = fgVar.a;
            do {
                value2 = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value2, ag.a(value2, null, CollectionsKt.emptyList(), false, 0, 0, null, null, 120)));
            return;
        }
        eg egVar2 = new eg(fgVar);
        o3 annotationProvider2 = lmVar.getAnnotationProvider();
        annotationProvider2.getClass();
        annotationProvider2.h.a(egVar2);
        fgVar.f = egVar2;
        EmbeddedFilesProvider embeddedFilesProvider = lmVar.h;
        if (embeddedFilesProvider == null) {
            MutableStateFlow<ag> mutableStateFlow2 = fgVar.a;
            do {
                value = mutableStateFlow2.getValue();
            } while (!mutableStateFlow2.compareAndSet(value, ag.a(value, null, null, false, 0, 0, null, null, 122)));
        } else {
            fgVar.c = false;
            fgVar.d.clear();
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(fgVar), Dispatchers.getIO(), null, new cg(fgVar, embeddedFilesProvider, null), 2, null);
        }
    }

    @Override // com.pspdfkit.internal.nt
    public final void a(ot otVar) {
        MutableStateFlow<ag> mutableStateFlow = this.e.a;
        while (true) {
            ag value = mutableStateFlow.getValue();
            ot otVar2 = otVar;
            if (mutableStateFlow.compareAndSet(value, ag.a(value, null, null, false, 0, 0, null, otVar2, 63))) {
                return;
            } else {
                otVar = otVar2;
            }
        }
    }
}
