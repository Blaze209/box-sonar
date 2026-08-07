package com.pspdfkit.internal;

import com.pspdfkit.document.DocumentPermissions;
import com.pspdfkit.document.DocumentSaveOptions;
import com.pspdfkit.exceptions.InvalidNutrientLicenseException;
import com.pspdfkit.internal.jni.NativeDocumentSecurityOptions;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.jni.NativePDFVersion;
import java.nio.charset.Charset;
import java.util.AbstractCollection;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes3.dex */
public final class sr {
    public static NativeDocumentSecurityOptions a(lm lmVar, DocumentSaveOptions documentSaveOptions) {
        if (lmVar == null) {
            return null;
        }
        boolean zEquals = false;
        String password = lmVar.A.get(0).getPassword();
        String password2 = documentSaveOptions.getPassword();
        Charset charset = u40.a;
        if (password == null && password2 == null) {
            zEquals = true;
        } else if (password != null && password2 != null) {
            zEquals = password.equals(password2);
        }
        if (zEquals && documentSaveOptions.getPdfVersion().getMajorVersion() == lmVar.D.getMajorVersion() && documentSaveOptions.getPdfVersion().getMinorVersion() == lmVar.D.getMinorVersion()) {
            EnumSet<DocumentPermissions> permissions = documentSaveOptions.getPermissions();
            AbstractCollection abstractCollectionClone = lmVar.G.clone();
            abstractCollectionClone.getClass();
            if (permissions.equals(abstractCollectionClone)) {
                return null;
            }
        }
        if (ar.b().a(NativeLicenseFeatures.DOCUMENT_EDITING)) {
            return new NativeDocumentSecurityOptions(documentSaveOptions.getPassword(), documentSaveOptions.getPassword(), documentSaveOptions.getPdfVersion().getMaxEncryptionKeyLength(), mr.b(documentSaveOptions.getPermissions()), new NativePDFVersion((byte) documentSaveOptions.getPdfVersion().getMajorVersion(), (byte) documentSaveOptions.getPdfVersion().getMinorVersion()), null);
        }
        throw new InvalidNutrientLicenseException("Changing document password, permissions or PDF version requires document editor feature in your license!");
    }
}
