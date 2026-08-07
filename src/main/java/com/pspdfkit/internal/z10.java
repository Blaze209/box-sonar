package com.pspdfkit.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.pspdfkit.annotations.WidgetAnnotation;
import java.util.List;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.signatures.SignatureFormSigningHandler", f = "SignatureFormSigningHandler.kt", i = {0, 0, 0, 0}, l = {254}, m = "findSignatureAnnotationForFormElement", n = {"signatureFormElement", "overlappingSignatures", "doc", TypedValues.Custom.S_REFERENCE}, nl = {253}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 2)
public final class z10 extends ContinuationImpl {
    public Object a;
    public List b;
    public Object c;
    public WidgetAnnotation d;
    public /* synthetic */ Object e;
    public final /* synthetic */ b20 f;
    public int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z10(b20 b20Var, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f = b20Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.g |= Integer.MIN_VALUE;
        return b20.a(this.f, null, null, this);
    }
}
