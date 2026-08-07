package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.widget.LinearLayout;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.pspdfkit.R;
import com.pspdfkit.compose.theme.SdkTheme;
import com.pspdfkit.compose.theme.UiColorScheme;
import com.pspdfkit.compose.theme.UiIconScheme;
import com.pspdfkit.compose.theme.UiThemeKt;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.ui.documentinfo.OnDocumentInfoViewModeChangeListener;
import com.pspdfkit.ui.documentinfo.OnDocumentInfoViewSaveListener;
import io.nutrient.ui.theme.ThemeWrapperKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: loaded from: classes3.dex */
public final class qd extends nt<od> {
    public final ud d;
    public final go<OnDocumentInfoViewModeChangeListener> e;
    public final go<OnDocumentInfoViewSaveListener> f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qd(final Context context, ViewModelStoreOwner viewModelStoreOwner) {
        super(context, viewModelStoreOwner);
        context.getClass();
        ViewModelStoreOwner viewModelStoreOwner2 = getViewModelStoreOwner();
        viewModelStoreOwner2.getClass();
        this.d = (ud) new ViewModelProvider(viewModelStoreOwner2, new v70(new Function0() { // from class: com.pspdfkit.internal.qd$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return qd.d();
            }
        })).get(String.valueOf(hashCode()), ud.class);
        this.e = new go<>();
        this.f = new go<>();
        int i = R.style.PSPDFKit_OutlineView;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.pspdf__outlineViewStyle});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, i);
        typedArrayObtainStyledAttributes.recycle();
        addView(y9.a(new ContextThemeWrapper(context, resourceId), ComposableLambdaKt.composableLambdaInstance(1429616111, true, new Function2() { // from class: com.pspdfkit.internal.qd$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return qd.a(this.f$0, context, (Composer) obj, ((Integer) obj2).intValue());
            }
        })), new LinearLayout.LayoutParams(-1, -2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit a(final qd qdVar, final Context context, Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1429616111, i, -1, "com.pspdfkit.internal.views.outline.DocumentInfoListView.<anonymous> (DocumentInfoListView.kt:61)");
            }
            UiColorScheme uiColors = UiThemeKt.getUiColors(composer, 0);
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(qdVar.d.e, (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composer, 0, 7);
            boolean zChanged = composer.changed((UiIconScheme) stateCollectAsStateWithLifecycle.getValue());
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new SdkTheme(uiColors, (UiIconScheme) stateCollectAsStateWithLifecycle.getValue()), null, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            CompositionLocalKt.CompositionLocalProvider(UiThemeKt.getLocalPdfUiScheme().provides((SdkTheme) ((MutableState) objRememberedValue).getValue()), ComposableLambdaKt.rememberComposableLambda(-548095697, true, new Function2() { // from class: com.pspdfkit.internal.qd$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return qd.b(this.f$0, context, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit b(final qd qdVar, final Context context, Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-548095697, i, -1, "com.pspdfkit.internal.views.outline.DocumentInfoListView.<anonymous>.<anonymous> (DocumentInfoListView.kt:65)");
            }
            State stateCollectAsState = SnapshotStateKt.collectAsState(qdVar.d.c, null, composer, 0, 1);
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            rd rdVar = (rd) stateCollectAsState.getValue();
            boolean zChangedInstance = composer.changedInstance(qdVar) | composer.changedInstance(context);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.pspdfkit.internal.qd$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return qd.a(this.f$0, context);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            kd.a(modifierFillMaxSize$default, rdVar, (Function0) objRememberedValue, composer, 6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final ud d() {
        return new ud();
    }

    @Override // com.pspdfkit.internal.nt
    public int getTabButtonId() {
        return R.id.pspdf__menu_pdf_outline_view_document_info;
    }

    @Override // com.pspdfkit.internal.nt
    public String getTitle() {
        String strA = no.a(getContext(), R.string.pspdf__document_info, null);
        strA.getClass();
        return strA;
    }

    public static final Unit a(qd qdVar, Context context) {
        qdVar.d.a(context);
        return Unit.INSTANCE;
    }

    @Override // com.pspdfkit.internal.nt
    public final void a(lm lmVar, PdfConfiguration pdfConfiguration) {
        rd value;
        if (lmVar != null) {
            for (OnDocumentInfoViewModeChangeListener onDocumentInfoViewModeChangeListener : this.e) {
                ud udVar = this.d;
                onDocumentInfoViewModeChangeListener.getClass();
                udVar.getClass();
                udVar.f.a(onDocumentInfoViewModeChangeListener);
            }
            for (OnDocumentInfoViewSaveListener onDocumentInfoViewSaveListener : this.f) {
                ud udVar2 = this.d;
                onDocumentInfoViewSaveListener.getClass();
                udVar2.getClass();
                udVar2.g.a(onDocumentInfoViewSaveListener);
            }
            ud udVar3 = this.d;
            Context context = getContext();
            context.getClass();
            udVar3.getClass();
            udVar3.a = lmVar;
            MutableStateFlow<rd> mutableStateFlow = udVar3.b;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, rd.a(value, lmVar.a(), pd.a(context, lmVar), false, false, 12)));
            return;
        }
        MutableStateFlow<rd> mutableStateFlow2 = this.d.b;
        while (!mutableStateFlow2.compareAndSet(mutableStateFlow2.getValue(), new rd(0))) {
        }
    }

    @Override // com.pspdfkit.internal.nt
    public final void a(ot otVar) {
        UiIconScheme value;
        otVar.getClass();
        ud udVar = this.d;
        udVar.getClass();
        otVar.getClass();
        MutableStateFlow<UiIconScheme> mutableStateFlow = udVar.d;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, value.copy(ThemeWrapperKt.getDocumentInfoIconScheme(otVar.F, otVar.G, otVar.H, otVar.I, otVar.J))));
    }
}
