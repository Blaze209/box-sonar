package com.pspdfkit.internal;

import com.pspdfkit.internal.jni.NativeDigitalSignatureType;
import com.pspdfkit.signatures.HashAlgorithm;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.signatures.SigningManagerInternal", f = "SigningManagerInternal.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2}, l = {396, 399, 407}, m = "genericSigningFunctionality", n = {"context", "type", "signingConfiguration", "unsignedData", "nativeX509Certificate", "hashAlgorithm", "context", "type", "signingConfiguration", "unsignedData", "nativeX509Certificate", "hashAlgorithm", "finalSignedData", "it", "$i$a$-let-SigningManagerInternal$genericSigningFunctionality$timestampCoroutineScope$1", "context", "type", "signingConfiguration", "unsignedData", "nativeX509Certificate", "hashAlgorithm", "finalSignedData", "timestampCoroutineScope"}, nl = {398, 398, 408}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, v = 2)
public final class n20 extends ContinuationImpl {
    public Object a;
    public Object b;
    public Object c;
    public Object d;
    public Object e;
    public HashAlgorithm f;
    public Object g;
    public Object h;
    public NativeDigitalSignatureType i;
    public byte[] j;
    public byte[] k;
    public ArrayList l;
    public /* synthetic */ Object m;
    public final /* synthetic */ m20 n;
    public int o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n20(m20 m20Var, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.n = m20Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.m = obj;
        this.o |= Integer.MIN_VALUE;
        return this.n.a(null, null, null, null, null, null, this);
    }
}
