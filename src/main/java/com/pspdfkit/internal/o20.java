package com.pspdfkit.internal;

import java.security.PrivateKey;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.signatures.SigningManagerInternal", f = "SigningManagerInternal.kt", i = {0, 0, 0, 0}, l = {347}, m = "internalSignData", n = {"customSigning", "unsignedData", "privateKey", "hashAlgorithm"}, nl = {369}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 2)
public final class o20 extends ContinuationImpl {
    public Object a;
    public Object b;
    public Object c;
    public Object d;
    public /* synthetic */ Object e;
    public final /* synthetic */ m20 f;
    public int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o20(m20 m20Var, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f = m20Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.g |= Integer.MIN_VALUE;
        return this.f.a((Function3) null, (byte[]) null, (PrivateKey) null, (String) null, this);
    }
}
