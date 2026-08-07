package com.pspdfkit.internal;

import android.graphics.Matrix;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationProvider;
import com.pspdfkit.annotations.actions.ActionResolver;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes3.dex */
public final class t1 implements AnnotationProvider.OnAnnotationUpdatedListener {
    public final ActionResolver a;
    public final Function0<Matrix> b;
    public final Function0<Unit> c;
    public m40 d;
    public final MutableStateFlow<List<q1>> e;
    public co f;
    public final MutableStateFlow g;
    public final CoroutineScope h;
    public Job i;

    /* JADX WARN: Multi-variable type inference failed */
    public t1(ActionResolver actionResolver, Function0<? extends Matrix> function0, Function0<Unit> function1) {
        function0.getClass();
        function1.getClass();
        this.a = actionResolver;
        this.b = function0;
        this.c = function1;
        MutableStateFlow<List<q1>> MutableStateFlow = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this.e = MutableStateFlow;
        this.g = MutableStateFlow;
        this.h = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationCreated(Annotation annotation) {
        annotation.getClass();
        onAnnotationUpdated(annotation);
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationRemoved(Annotation annotation) {
        annotation.getClass();
        onAnnotationUpdated(annotation);
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationUpdated(Annotation annotation) {
        m40 m40Var;
        annotation.getClass();
        m40 m40Var2 = this.d;
        if (m40Var2 == null || m40Var2.b != annotation.getPageIndex() || (m40Var = this.d) == null) {
            return;
        }
        Job job = this.i;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.f = null;
        this.i = BuildersKt__Builders_commonKt.launch$default(this.h, null, null, new s1(m40Var, this, null), 3, null);
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationZOrderChanged(int i, List<Annotation> list, List<Annotation> list2) {
        list.getClass();
        list2.getClass();
    }
}
