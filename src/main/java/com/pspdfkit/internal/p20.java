package com.pspdfkit.internal;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.signatures.SigningManagerInternal$internalSignData$2", f = "SigningManagerInternal.kt", i = {0, 0, 0}, l = {348}, m = "invokeSuspend", n = {"$this$coroutineScope", "it", "$i$a$-let-SigningManagerInternal$internalSignData$2$1"}, nl = {348}, s = {"L$0", "L$1", "I$0"}, v = 2)
public final class p20 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super byte[]>, Object> {
    public Object a;
    public int b;
    public /* synthetic */ Object c;
    public final /* synthetic */ Function3<byte[], String, Continuation<? super byte[]>, Object> d;
    public final /* synthetic */ PrivateKey e;
    public final /* synthetic */ String f;
    public final /* synthetic */ byte[] g;

    @DebugMetadata(c = "com.pspdfkit.internal.signatures.SigningManagerInternal$internalSignData$2$1$1", f = "SigningManagerInternal.kt", i = {}, l = {348}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super byte[]>, Object> {
        public int a;
        public final /* synthetic */ Function3<byte[], String, Continuation<? super byte[]>, Object> b;
        public final /* synthetic */ byte[] c;
        public final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(Function3<? super byte[], ? super String, ? super Continuation<? super byte[]>, ? extends Object> function3, byte[] bArr, String str, Continuation<? super a> continuation) {
            super(2, continuation);
            this.b = function3;
            this.c = bArr;
            this.d = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.b, this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super byte[]> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            Function3<byte[], String, Continuation<? super byte[]>, Object> function3 = this.b;
            byte[] bArr = this.c;
            String str = this.d;
            this.a = 1;
            Object objInvoke = function3.invoke(bArr, str, this);
            return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public p20(Function3<? super byte[], ? super String, ? super Continuation<? super byte[]>, ? extends Object> function3, PrivateKey privateKey, String str, byte[] bArr, Continuation<? super p20> continuation) {
        super(2, continuation);
        this.d = function3;
        this.e = privateKey;
        this.f = str;
        this.g = bArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        p20 p20Var = new p20(this.d, this.e, this.f, this.g, continuation);
        p20Var.c = obj;
        return p20Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super byte[]> continuation) {
        return ((p20) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x005c A[Catch: InvalidKeyException -> 0x00b4, SignatureException -> 0x00be, NoSuchAlgorithmException -> 0x00c8, TRY_LEAVE, TryCatch #2 {InvalidKeyException -> 0x00b4, NoSuchAlgorithmException -> 0x00c8, SignatureException -> 0x00be, blocks: (B:17:0x0058, B:19:0x005c, B:22:0x006a, B:24:0x009b, B:23:0x007f, B:26:0x00ac, B:27:0x00b3), top: B:37:0x0058 }] */
    /* JADX WARN: Code duplicated, block: B:22:0x006a A[Catch: InvalidKeyException -> 0x00b4, SignatureException -> 0x00be, NoSuchAlgorithmException -> 0x00c8, TRY_ENTER, TryCatch #2 {InvalidKeyException -> 0x00b4, NoSuchAlgorithmException -> 0x00c8, SignatureException -> 0x00be, blocks: (B:17:0x0058, B:19:0x005c, B:22:0x006a, B:24:0x009b, B:23:0x007f, B:26:0x00ac, B:27:0x00b3), top: B:37:0x0058 }] */
    /* JADX WARN: Code duplicated, block: B:23:0x007f A[Catch: InvalidKeyException -> 0x00b4, SignatureException -> 0x00be, NoSuchAlgorithmException -> 0x00c8, TryCatch #2 {InvalidKeyException -> 0x00b4, NoSuchAlgorithmException -> 0x00c8, SignatureException -> 0x00be, blocks: (B:17:0x0058, B:19:0x005c, B:22:0x006a, B:24:0x009b, B:23:0x007f, B:26:0x00ac, B:27:0x00b3), top: B:37:0x0058 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x00ac A[Catch: InvalidKeyException -> 0x00b4, SignatureException -> 0x00be, NoSuchAlgorithmException -> 0x00c8, TryCatch #2 {InvalidKeyException -> 0x00b4, NoSuchAlgorithmException -> 0x00c8, SignatureException -> 0x00be, blocks: (B:17:0x0058, B:19:0x005c, B:22:0x006a, B:24:0x009b, B:23:0x007f, B:26:0x00ac, B:27:0x00b3), top: B:37:0x0058 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        PrivateKey privateKey;
        boolean zAreEqual;
        String str;
        String str2;
        CoroutineScope coroutineScope = (CoroutineScope) this.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.b;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function3<byte[], String, Continuation<? super byte[]>, Object> function3 = this.d;
                if (function3 != null) {
                    Deferred deferredAsync$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, Dispatchers.getIO(), null, new a(function3, this.g, this.f, null), 2, null);
                    this.c = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.a = SpillingKt.nullOutSpilledVariable(function3);
                    this.b = 1;
                    obj = deferredAsync$default.await(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                privateKey = this.e;
                if (privateKey != null) {
                    throw new RuntimeException("Private key is required for signing");
                }
                zAreEqual = Intrinsics.areEqual(privateKey.getAlgorithm(), "EC");
                str = this.f;
                if (zAreEqual) {
                    str2 = str + "withECDSA";
                } else {
                    str2 = str + "with" + privateKey.getAlgorithm();
                }
                Signature signature = Signature.getInstance(str2);
                byte[] bArr = this.g;
                signature.initSign(privateKey);
                signature.update(bArr);
                return signature.sign();
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            privateKey = this.e;
            if (privateKey != null) {
                throw new RuntimeException("Private key is required for signing");
            }
            zAreEqual = Intrinsics.areEqual(privateKey.getAlgorithm(), "EC");
            str = this.f;
            if (zAreEqual) {
                str2 = str + "withECDSA";
            } else {
                str2 = str + "with" + privateKey.getAlgorithm();
            }
            Signature signature2 = Signature.getInstance(str2);
            byte[] bArr2 = this.g;
            signature2.initSign(privateKey);
            signature2.update(bArr2);
            return signature2.sign();
        } catch (InvalidKeyException e) {
            throw new RuntimeException("Error accessing private key.", e);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException("No appropriate signature algorithm available.", e2);
        } catch (SignatureException e3) {
            throw new RuntimeException("Error while signing data.", e3);
        }
        byte[] bArr3 = (byte[]) obj;
        if (bArr3 != null) {
            return bArr3;
        }
    }
}
