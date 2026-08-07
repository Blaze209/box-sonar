package com.pspdfkit.signatures;

import android.content.Context;
import com.pspdfkit.internal.m20;
import com.pspdfkit.internal.r20;
import com.pspdfkit.utils.Response;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jk\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2,\b\u0002\u0010\n\u001a&\b\u0001\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013¢\u0006\u0002\u0010\u0014J0\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00180\u00170\u00162\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\u0019J<\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00162\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\u001fJ,\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001b0\u00162\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010!J4\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0\u00162\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010%J4\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0\u00162\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0018H\u0087@¢\u0006\u0002\u0010&J4\u0010'\u001a\b\u0012\u0004\u0012\u00020\f0\u00162\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010%J4\u0010'\u001a\b\u0012\u0004\u0012\u00020\f0\u00162\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0018H\u0087@¢\u0006\u0002\u0010&¨\u0006("}, d2 = {"Lcom/pspdfkit/signatures/SigningManager;", "", "<init>", "()V", "signDocument", "", "context", "Landroid/content/Context;", "signerOptions", "Lcom/pspdfkit/signatures/SignerOptions;", "customSigning", "Lkotlin/Function3;", "", "", "Lkotlin/coroutines/Continuation;", "onFailure", "Lkotlin/Function1;", "", "onSuccess", "Lkotlin/Function0;", "(Landroid/content/Context;Lcom/pspdfkit/signatures/SignerOptions;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "getDataToSign", "Lcom/pspdfkit/utils/Response;", "Lkotlin/Pair;", "Lcom/pspdfkit/signatures/HashAlgorithm;", "(Landroid/content/Context;Lcom/pspdfkit/signatures/SignerOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "embedSignature", "", "signedData", "unsignedData", "hashAlgorithm", "(Landroid/content/Context;Lcom/pspdfkit/signatures/SignerOptions;[B[BLcom/pspdfkit/signatures/HashAlgorithm;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "embedPKCS7Signature", "(Landroid/content/Context;Lcom/pspdfkit/signatures/SignerOptions;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signWithBasicSignature", "signingConfiguration", "Lcom/pspdfkit/signatures/SigningConfiguration;", "(Landroid/content/Context;Lcom/pspdfkit/signatures/SigningConfiguration;[BLcom/pspdfkit/signatures/HashAlgorithm;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroid/content/Context;Lcom/pspdfkit/signatures/SignerOptions;[BLcom/pspdfkit/signatures/HashAlgorithm;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signWithCAdESSignature", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SigningManager {
    public static final int $stable = 0;
    public static final SigningManager INSTANCE = new SigningManager();

    private SigningManager() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void signDocument$default(SigningManager signingManager, Context context, SignerOptions signerOptions, Function3 function3, Function1 function1, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function3 = null;
        }
        signingManager.signDocument(context, signerOptions, function3, function1, function0);
    }

    public final Object embedPKCS7Signature(Context context, SignerOptions signerOptions, byte[] bArr, Continuation<? super Response> continuation) {
        return m20.a.a(context, signerOptions, bArr, continuation);
    }

    public final Object embedSignature(Context context, SignerOptions signerOptions, byte[] bArr, byte[] bArr2, HashAlgorithm hashAlgorithm, Continuation<? super Response> continuation) {
        return m20.a.a(context, signerOptions, bArr, bArr2, hashAlgorithm, continuation);
    }

    public final Object getDataToSign(Context context, SignerOptions signerOptions, Continuation<? super Response<? extends Pair<byte[], ? extends HashAlgorithm>>> continuation) {
        return m20.a.a(context, signerOptions, continuation);
    }

    public final void signDocument(Context context, SignerOptions signerOptions, Function3<? super byte[], ? super String, ? super Continuation<? super byte[]>, ? extends Object> customSigning, Function1<? super Throwable, Unit> onFailure, Function0<Unit> onSuccess) {
        context.getClass();
        signerOptions.getClass();
        onFailure.getClass();
        onSuccess.getClass();
        context.getClass();
        signerOptions.getClass();
        onFailure.getClass();
        onSuccess.getClass();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new r20(signerOptions, context, customSigning, onSuccess, onFailure, null), 3, null);
    }

    public final Object signWithBasicSignature(Context context, SigningConfiguration signingConfiguration, byte[] bArr, HashAlgorithm hashAlgorithm, Continuation<? super Response<byte[]>> continuation) {
        return m20.a.a(context, signingConfiguration, bArr, hashAlgorithm, continuation);
    }

    public final Object signWithCAdESSignature(Context context, SigningConfiguration signingConfiguration, byte[] bArr, HashAlgorithm hashAlgorithm, Continuation<? super Response<byte[]>> continuation) {
        return m20.a.b(context, signingConfiguration, bArr, hashAlgorithm, continuation);
    }

    @Deprecated(message = "Use signWithBasicSignature with SigningConfiguration instead", replaceWith = @ReplaceWith(expression = "signWithBasicSignature(context, signingConfiguration, unsignedData, hashAlgorithm)", imports = {}))
    public final Object signWithBasicSignature(Context context, SignerOptions signerOptions, byte[] bArr, HashAlgorithm hashAlgorithm, Continuation<? super Response<byte[]>> continuation) {
        return signWithBasicSignature(context, SigningConfiguration.INSTANCE.fromSignerOptions(signerOptions), bArr, hashAlgorithm, continuation);
    }

    @Deprecated(message = "Use signWithCAdESSignature with SigningConfiguration instead", replaceWith = @ReplaceWith(expression = "signWithCAdESSignature(context, signingConfiguration, unsignedData, hashAlgorithm)", imports = {}))
    public final Object signWithCAdESSignature(Context context, SignerOptions signerOptions, byte[] bArr, HashAlgorithm hashAlgorithm, Continuation<? super Response<byte[]>> continuation) {
        return signWithCAdESSignature(context, SigningConfiguration.INSTANCE.fromSignerOptions(signerOptions), bArr, hashAlgorithm, continuation);
    }
}
