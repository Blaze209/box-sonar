package com.pspdfkit.internal;

import android.content.Context;
import android.os.Bundle;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import com.pspdfkit.R;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.utils.PdfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: loaded from: classes3.dex */
public final class z2 extends nt<Annotation> {
    public final nt.b<Annotation> d;
    public final k5 e;
    public final x2 f;
    public lm g;
    public boolean h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z2(Context context, nt.b<Annotation> bVar, at atVar, ViewModelStoreOwner viewModelStoreOwner) {
        super(context, viewModelStoreOwner);
        context.getClass();
        bVar.getClass();
        this.d = bVar;
        ViewModelStoreOwner viewModelStoreOwner2 = getViewModelStoreOwner();
        viewModelStoreOwner2.getClass();
        this.e = (k5) new ViewModelProvider(viewModelStoreOwner2, new v70(new Function0() { // from class: com.pspdfkit.internal.z2$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return z2.e();
            }
        })).get(String.valueOf(hashCode()), k5.class);
        EnumSet<AnnotationType> default_listed_annotation_types = PdfActivityConfiguration.INSTANCE.getDEFAULT_LISTED_ANNOTATION_TYPES();
        Context applicationContext = context.getApplicationContext();
        applicationContext.getClass();
        this.f = new x2(default_listed_annotation_types, this, atVar, applicationContext);
        addView(y9.a(context, ComposableLambdaKt.composableLambdaInstance(563871028, true, new Function2() { // from class: com.pspdfkit.internal.z2$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return z2.a(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
            }
        })));
    }

    public static final Unit a(final z2 z2Var, Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(563871028, i, -1, "com.pspdfkit.internal.views.outline.AnnotationListView.<anonymous> (AnnotationListView.kt:76)");
            }
            z2Var.setId(R.id.pspdf__annotation_list_view);
            i5 i5Var = (i5) FlowExtKt.collectAsStateWithLifecycle(z2Var.e.b, (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composer, 0, 7).getValue();
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            boolean zChangedInstance = composer.changedInstance(z2Var);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.pspdfkit.internal.z2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return z2.a(this.f$0, (fo) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            boolean zChangedInstance2 = composer.changedInstance(z2Var);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.pspdfkit.internal.z2$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return z2.b(this.f$0, (fo) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function1 function2 = (Function1) objRememberedValue2;
            boolean zChangedInstance3 = composer.changedInstance(z2Var);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function2() { // from class: com.pspdfkit.internal.z2$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return z2.a(this.f$0, ((Long) obj).longValue(), ((Long) obj2).longValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            Function2 function3 = (Function2) objRememberedValue3;
            boolean zChangedInstance4 = composer.changedInstance(z2Var);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function0() { // from class: com.pspdfkit.internal.z2$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return z2.a(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            Function0 function0 = (Function0) objRememberedValue4;
            boolean zChangedInstance5 = composer.changedInstance(z2Var);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChangedInstance5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function0() { // from class: com.pspdfkit.internal.z2$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return z2.b(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            h5.a(i5Var, (Function1<? super fo, Unit>) function1, (Function1<? super fo, Unit>) function2, (Function2<? super Long, ? super Long, Unit>) function3, (Function0<Unit>) function0, (Function0<Unit>) objRememberedValue5, modifierFillMaxSize$default, composer, 1572864);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit b(z2 z2Var, fo foVar) throws InterruptedException {
        o3 annotationProvider;
        foVar.getClass();
        x2 x2Var = z2Var.f;
        x2Var.getClass();
        PdfConfiguration pdfConfiguration = x2Var.i;
        if (pdfConfiguration != null && foVar.a(pdfConfiguration)) {
            if (foVar instanceof fo.a) {
                fo.a aVar = (fo.a) foVar;
                lm lmVar = x2Var.h;
                if (lmVar != null && (annotationProvider = lmVar.getAnnotationProvider()) != null) {
                    BuildersKt__BuildersKt.runBlocking$default(null, new t2(annotationProvider, aVar, null), 1, null);
                }
            } else if (foVar instanceof fo.b) {
                ((fo.b) foVar).c.getFormField().reset();
            }
            x2Var.f.remove(foVar);
        }
        x2Var.b.a(x2Var.f, x2Var.g != null);
        return Unit.INSTANCE;
    }

    public static final k5 e() {
        return new k5();
    }

    @Override // com.pspdfkit.internal.nt
    public final void c() {
        if (this.g == null) {
            this.h = true;
            return;
        }
        this.h = false;
        x2 x2Var = this.f;
        lm lmVar = x2Var.h;
        if (lmVar == null) {
            return;
        }
        Job job = x2Var.g;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        x2Var.f.clear();
        x2Var.b.a(CollectionsKt.emptyList(), true);
        if (lmVar.s > 2000) {
            PdfLog.w("Nutri.AnnotListProvider", "Only loading annotations from first 2000 pages into annotation list.", new Object[0]);
        }
        x2Var.g = lmVar.a(Dispatchers.getIO(), new v2(Math.min(lmVar.s, 2000), x2Var, lmVar, null));
    }

    public final void d() {
        i5 value;
        PdfConfiguration pdfConfiguration;
        if (this.e.b.getValue().i) {
            x2 x2Var = this.f;
            List<fo> list = this.e.b.getValue().b;
            x2Var.getClass();
            list.getClass();
            lm lmVar = x2Var.h;
            if (lmVar != null && (pdfConfiguration = x2Var.i) != null) {
                ArrayList arrayList = x2Var.f;
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    if (!(((fo) obj) instanceof fo.c)) {
                        arrayList2.add(obj);
                    }
                }
                ArrayList arrayList3 = new ArrayList();
                for (Object obj2 : list) {
                    if (!(((fo) obj2) instanceof fo.c)) {
                        arrayList3.add(obj2);
                    }
                }
                if (!Intrinsics.areEqual(arrayList2, arrayList3)) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    int size2 = arrayList3.size();
                    int i2 = 0;
                    while (i2 < size2) {
                        Object obj3 = arrayList3.get(i2);
                        i2++;
                        Integer numValueOf = Integer.valueOf(((fo) obj3).c());
                        Object arrayList4 = linkedHashMap.get(numValueOf);
                        if (arrayList4 == null) {
                            arrayList4 = new ArrayList();
                            linkedHashMap.put(numValueOf, arrayList4);
                        }
                        ((List) arrayList4).add(obj3);
                    }
                    o3 annotationProvider = lmVar.getAnnotationProvider();
                    Iterator it = linkedHashMap.entrySet().iterator();
                    while (it.hasNext()) {
                        List list2 = (List) ((Map.Entry) it.next()).getValue();
                        ArrayList arrayList5 = new ArrayList();
                        for (Object obj4 : list2) {
                            fo foVar = (fo) obj4;
                            if (foVar.a() != null && foVar.b(pdfConfiguration)) {
                                arrayList5.add(obj4);
                            }
                        }
                        if (arrayList5.size() >= 2) {
                            lmVar.a(EmptyCoroutineContext.INSTANCE, new s2(arrayList5, annotationProvider, null));
                        }
                    }
                    x2Var.f.clear();
                    x2Var.f.addAll(list);
                    x2Var.b.a((List<? extends fo>) x2Var.f, false);
                }
            }
            MutableStateFlow<i5> mutableStateFlow = this.e.a;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, i5.a(value, null, null, null, false, false, false, false, false, false, false, 767)));
        }
    }

    @Override // com.pspdfkit.internal.nt
    public int getTabButtonId() {
        return R.id.pspdf__menu_pdf_outline_view_annotations;
    }

    @Override // com.pspdfkit.internal.nt
    public String getTitle() {
        String strA = no.a(getContext(), R.string.pspdf__annotations, null);
        strA.getClass();
        return strA;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    public final void setAnnotationEditingEnabled(boolean z) {
        MutableStateFlow<i5> mutableStateFlow = this.e.a;
        while (true) {
            i5 value = mutableStateFlow.getValue();
            boolean z2 = z;
            if (mutableStateFlow.compareAndSet(value, i5.a(value, null, null, null, false, z2, false, false, false, false, false, 1007))) {
                return;
            } else {
                z = z2;
            }
        }
    }

    public final void setAnnotationListReorderingEnabled(boolean z) {
        MutableStateFlow<i5> mutableStateFlow = this.e.a;
        while (true) {
            i5 value = mutableStateFlow.getValue();
            boolean z2 = z;
            if (mutableStateFlow.compareAndSet(value, i5.a(value, null, null, null, false, false, z2, false, false, false, false, 991))) {
                this.f.e = z2;
                return;
            }
            z = z2;
        }
    }

    public final void setListedAnnotationTypes(EnumSet<AnnotationType> enumSet) {
        enumSet.getClass();
        x2 x2Var = this.f;
        x2Var.getClass();
        enumSet.getClass();
        x2Var.a = enumSet;
        if (this.b) {
            c();
        }
    }

    @Override // com.pspdfkit.internal.nt
    public void setPageSelected(boolean z) {
        if (!z) {
            d();
        }
        super.setPageSelected(z);
    }

    public static final Unit b(z2 z2Var) {
        i5 value;
        if (z2Var.e.b.getValue().i) {
            z2Var.d();
        } else {
            k5 k5Var = z2Var.e;
            MutableStateFlow<i5> mutableStateFlow = k5Var.a;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, i5.a(value, null, null, null, false, false, false, false, false, !k5Var.a.getValue().i, false, 767)));
        }
        return Unit.INSTANCE;
    }

    @Override // com.pspdfkit.internal.nt
    public final void b() {
        i5 value;
        if (this.b) {
            c();
        }
        if (this.b) {
            c();
        }
        MutableStateFlow<i5> mutableStateFlow = this.e.a;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, i5.a(value, null, null, null, false, false, false, true, false, false, false, 959)));
    }

    public static final Unit a(z2 z2Var, fo foVar) {
        foVar.getClass();
        z2Var.getClass();
        Annotation annotationA = foVar.a();
        if (annotationA != null) {
            nt.a aVar = z2Var.a;
            if (aVar != null) {
                aVar.hide();
            } else {
                PdfLog.e("OutlinePagerBaseView", "onHideListener is null! This shouldn't happen.\nMake sure you have called `PdfOutlineView#setDocument()` whenever a new document is loaded.", new Object[0]);
            }
            i0 i0VarA = ar.a();
            Bundle bundleA = z50.a(i0VarA);
            bundleA.putString(Analytics.Data.ANNOTATION_TYPE, annotationA.getType().name());
            bundleA.putInt(Analytics.Data.PAGE_INDEX, annotationA.getPageIndex());
            i0VarA.a(Analytics.Event.TAP_ANNOTATION_IN_OUTLINE_LIST, bundleA);
            z2Var.d.a(z2Var, annotationA);
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(z2 z2Var) {
        lm lmVar;
        x2 x2Var = z2Var.f;
        PdfConfiguration pdfConfiguration = x2Var.i;
        if (pdfConfiguration != null && (lmVar = x2Var.h) != null) {
            ArrayList arrayList = x2Var.f;
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                if (((fo) obj).a(pdfConfiguration)) {
                    arrayList2.add(obj);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            int size2 = arrayList2.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size2) {
                    break;
                }
                Object obj2 = arrayList2.get(i2);
                i2++;
                fo foVar = (fo) obj2;
                fo.b bVar = foVar instanceof fo.b ? (fo.b) foVar : null;
                if (bVar != null) {
                    arrayList3.add(bVar);
                }
            }
            ArrayList arrayList4 = new ArrayList();
            int size3 = arrayList2.size();
            int i3 = 0;
            while (i3 < size3) {
                Object obj3 = arrayList2.get(i3);
                i3++;
                fo foVar2 = (fo) obj3;
                fo.a aVar = foVar2 instanceof fo.a ? (fo.a) foVar2 : null;
                if (aVar != null) {
                    arrayList4.add(aVar);
                }
            }
            lmVar.a(Dispatchers.getDefault(), new w2(arrayList3, x2Var, lmVar, arrayList4, null));
            x2Var.f.removeAll(arrayList2);
            x2Var.b.a(x2Var.f, x2Var.g != null);
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(z2 z2Var, long j, long j2) {
        i5 value;
        i5 i5VarA;
        int i;
        MutableStateFlow<i5> mutableStateFlow = z2Var.e.a;
        do {
            value = mutableStateFlow.getValue();
            i5VarA = value;
            List mutableList = CollectionsKt.toMutableList((Collection) i5VarA.b);
            Iterator it = mutableList.iterator();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                i = -1;
                if (!it.hasNext()) {
                    i3 = -1;
                    break;
                }
                if (((fo) it.next()).b() == j) {
                    break;
                }
                i3++;
            }
            Iterator it2 = mutableList.iterator();
            while (it2.hasNext()) {
                if (((fo) it2.next()).b() == j2) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i3 >= 0 && i >= 0 && i3 != i) {
                fo foVar = (fo) mutableList.get(i3);
                fo foVar2 = (fo) mutableList.get(i);
                if (!(foVar instanceof fo.c) && !(foVar2 instanceof fo.c) && foVar.c() == foVar2.c()) {
                    mutableList.add(i, (fo) mutableList.remove(i3));
                    i5VarA = i5.a(i5VarA, null, mutableList, null, false, false, false, false, false, false, false, 1021);
                }
            }
        } while (!mutableStateFlow.compareAndSet(value, i5VarA));
        return Unit.INSTANCE;
    }

    @Override // com.pspdfkit.internal.nt
    public final void a(lm lmVar, PdfConfiguration pdfConfiguration) {
        i5 value;
        k5 k5Var = this.e;
        k5Var.getClass();
        boolean z = (pdfConfiguration == null || lmVar == null || !ar.b().a(pdfConfiguration)) ? false : true;
        boolean z2 = lmVar instanceof hm;
        MutableStateFlow<i5> mutableStateFlow = k5Var.a;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, i5.a(value, null, null, pdfConfiguration, z, false, false, false, false, false, z2, 499)));
        this.g = lmVar;
        x2 x2Var = this.f;
        x2Var.h = lmVar;
        x2Var.i = pdfConfiguration;
        if (this.h && this.b) {
            c();
        }
    }

    @Override // com.pspdfkit.internal.nt
    public final void a(ot otVar) {
        otVar.getClass();
        k5 k5Var = this.e;
        k5Var.getClass();
        MutableStateFlow<i5> mutableStateFlow = k5Var.a;
        while (true) {
            i5 value = mutableStateFlow.getValue();
            ot otVar2 = otVar;
            if (mutableStateFlow.compareAndSet(value, i5.a(value, otVar2, null, null, false, false, false, false, false, false, false, AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED))) {
                return;
            } else {
                otVar = otVar2;
            }
        }
    }

    @Override // com.pspdfkit.internal.nt
    public final void a() {
        i5 value;
        d();
        MutableStateFlow<i5> mutableStateFlow = this.e.a;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, i5.a(value, null, null, null, false, false, false, false, false, false, false, 959)));
        x2 x2Var = this.f;
        Job job = x2Var.g;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        x2Var.g = null;
        x2Var.b.a((List<? extends fo>) x2Var.f, false);
    }

    public final void a(List<? extends fo> list, boolean z) {
        list.getClass();
        k5 k5Var = this.e;
        k5Var.getClass();
        List<fo> listSortedWith = CollectionsKt.sortedWith(list, new j5());
        ArrayList arrayList = new ArrayList();
        List<fo> list2 = k5Var.a.getValue().b;
        int iC = !list2.isEmpty() ? list2.get(list2.size() - 1).c() : -1;
        for (fo foVar : listSortedWith) {
            if (!(foVar instanceof fo.c)) {
                int iC2 = foVar.c();
                if (iC2 != iC && iC2 > -1) {
                    arrayList.add(new fo.c(iC2));
                    iC = iC2;
                }
                arrayList.add(foVar);
            }
        }
        MutableStateFlow<i5> mutableStateFlow = k5Var.a;
        while (true) {
            i5 value = mutableStateFlow.getValue();
            boolean z2 = z;
            if (mutableStateFlow.compareAndSet(value, i5.a(value, null, arrayList, null, false, false, false, false, z2, false, false, 893))) {
                return;
            } else {
                z = z2;
            }
        }
    }
}
