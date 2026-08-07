package com.pspdfkit.internal;

import com.pspdfkit.exceptions.LongTermValidationException;
import com.pspdfkit.forms.SignatureFormElement;
import com.pspdfkit.internal.jni.NativeDocumentProvider;
import com.pspdfkit.internal.jni.NativeKeyStore;
import com.pspdfkit.internal.jni.NativeLongTermValidationAdditionError;
import com.pspdfkit.internal.jni.NativeLongTermValidationAdditionResult;
import com.pspdfkit.internal.jni.NativeLongTermValidationManager;
import com.pspdfkit.internal.jni.NativeX509Certificate;
import com.pspdfkit.signatures.TrustedKeyStore;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.functions.Action;
import java.io.IOException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class o {
    public static final Completable a(final lm lmVar, final SignatureFormElement signatureFormElement, final List<? extends X509Certificate> list) {
        signatureFormElement.getClass();
        list.getClass();
        Completable completableFromAction = Completable.fromAction(new Action() { // from class: com.pspdfkit.internal.o$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() throws IOException {
                o.a(signatureFormElement, lmVar, list);
            }
        });
        completableFromAction.getClass();
        return completableFromAction;
    }

    public static final void a(SignatureFormElement signatureFormElement, lm lmVar, List list) throws IOException {
        if (!signatureFormElement.isSigned()) {
            throw new LongTermValidationException("Form element is not signed");
        }
        if (lmVar.y.getDocumentProviders().isEmpty()) {
            throw new LongTermValidationException("Document does not have any document providers");
        }
        NativeDocumentProvider nativeDocumentProvider = lmVar.y.getDocumentProviders().get(0);
        List listEmptyList = list.isEmpty() ? CollectionsKt.emptyList() : j20.a(list);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listEmptyList) {
            if (((NativeX509Certificate) obj).isCACertificate()) {
                arrayList.add(obj);
            }
        }
        NativeKeyStore nativeKeystore = TrustedKeyStore.toNativeKeystore();
        nativeKeystore.addCertificates(new ArrayList<>(arrayList));
        NativeLongTermValidationAdditionResult nativeLongTermValidationAdditionResultAddLtvInformation = NativeLongTermValidationManager.addLtvInformation(nativeDocumentProvider, signatureFormElement.getFullyQualifiedName(), t8.a(lmVar.y, listEmptyList, nativeKeystore), nativeKeystore);
        nativeLongTermValidationAdditionResultAddLtvInformation.getClass();
        if (!nativeLongTermValidationAdditionResultAddLtvInformation.getHasError()) {
            lmVar.a(lmVar.a(true));
            return;
        }
        NativeLongTermValidationAdditionError error = nativeLongTermValidationAdditionResultAddLtvInformation.getError();
        error.getClass();
        String errorMessage = error.getErrorMessage();
        errorMessage.getClass();
        throw new LongTermValidationException(errorMessage);
    }
}
