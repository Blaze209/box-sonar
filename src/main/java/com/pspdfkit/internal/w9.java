package com.pspdfkit.internal;

import com.pspdfkit.jetpack.compose.interactors.DocumentState;
import com.pspdfkit.ui.toolbar.ToolbarCoordinatorLayout;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.jetpack.compose.ComposePdfFragmentInterfacesImpl", f = "ComposePdfFragmentInterfacesImpl.kt", i = {0, 0, 0, 0, 0, 0}, l = {342}, m = "updateMenuConfiguration$suspendImpl", n = {"$this", "context", "onVisibilityChangedListener", "toolbarLifecycleListener", "menuConfig", "newMenuConfig"}, nl = {343}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
public final class w9 extends ContinuationImpl {
    public x9 a;
    public Object b;
    public DocumentState c;
    public ToolbarCoordinatorLayout.OnContextualToolbarLifecycleListener d;
    public Object e;
    public Object f;
    public /* synthetic */ Object g;
    public final /* synthetic */ x9 h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w9(x9 x9Var, Continuation<? super w9> continuation) {
        super(continuation);
        this.h = x9Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.g = obj;
        this.i |= Integer.MIN_VALUE;
        return x9.a(this.h, null, null, null, null, this);
    }
}
