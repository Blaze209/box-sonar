package com.pspdfkit.internal;

import com.pspdfkit.instant.exceptions.InstantException;
import com.pspdfkit.instant.internal.jni.NativeInstantError;
import com.pspdfkit.instant.internal.jni.NativeInstantJWT;
import com.pspdfkit.instant.internal.jni.NativeInstantJWTResult;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public final class wl {
    public final NativeInstantJWT a;

    public wl(NativeInstantJWT nativeInstantJWT) {
        this.a = nativeInstantJWT;
    }

    public static wl a(String str) {
        NativeInstantJWTResult nativeInstantJWTResult = NativeInstantJWT.parse(str);
        if (!nativeInstantJWTResult.isError()) {
            return new wl(nativeInstantJWTResult.value());
        }
        NativeInstantError nativeInstantErrorError = nativeInstantJWTResult.error();
        throw new InstantException(lr.a(nativeInstantErrorError.getCode()), nativeInstantErrorError.getMessage(), nativeInstantErrorError.getUnderlyingError());
    }

    public final String toString() {
        return "InstantJwt{document_id=" + this.a.documentId() + ", layer=" + this.a.layerName() + ", user_id=" + this.a.userId() + AbstractJsonLexerKt.END_OBJ;
    }

    public static wl a(String str, String str2, String str3) {
        wl wlVarA = a(str);
        if (str2 != null) {
            String strDocumentId = wlVarA.a.documentId();
            if (!strDocumentId.equals(str2)) {
                throw new InstantException("Document id: " + str2 + " does not match document id encoded in JWT: " + strDocumentId, null);
            }
        }
        if (str3 != null) {
            String strLayerName = wlVarA.a.layerName();
            if (!strLayerName.equals(str3)) {
                throw new InstantException("Layer name: " + str3 + " does not match layer name encoded in JWT: " + strLayerName, null);
            }
        }
        return wlVarA;
    }
}
