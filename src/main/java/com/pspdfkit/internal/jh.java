package com.pspdfkit.internal;

import android.util.SparseArray;
import com.pspdfkit.forms.FormField;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.forms.FormCache", f = "FormCache.kt", i = {0, 0, 0, 0}, l = {106}, m = "populateFormElementsForProvider", n = {"formFields", "formElementsMap", "formField", "providerIndex"}, nl = {107}, s = {"L$0", "L$1", "L$3", "I$0"}, v = 2)
public final class jh extends ContinuationImpl {
    public Object a;
    public SparseArray b;
    public Iterator c;
    public FormField d;
    public int e;
    public /* synthetic */ Object f;
    public final /* synthetic */ kh g;
    public int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jh(kh khVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.g = khVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f = obj;
        this.h |= Integer.MIN_VALUE;
        return kh.a(this.g, null, 0, this);
    }
}
