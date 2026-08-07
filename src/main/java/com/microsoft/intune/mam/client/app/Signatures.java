package com.microsoft.intune.mam.client.app;

import android.content.pm.Signature;
import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;
import com.google.common.base.Ascii;
import com.microsoft.intune.mam.client.MAMInfo;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import com.yubico.yubikit.core.fido.CtapException;
import java.io.ByteArrayInputStream;
import java.security.KeyFactory;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.X509EncodedKeySpec;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes3.dex */
final class Signatures {
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(Signatures.class);
    private static final byte[] AGENT_SIGNING_PUBLIC_KEY_SPEC = {CtapException.ERR_NOT_ALLOWED, -126, 2, CtapException.ERR_INVALID_CREDENTIAL, CtapException.ERR_NOT_ALLOWED, Ascii.CR, 6, 9, CtapException.ERR_NO_OPERATION_PENDING, -122, 72, -122, -9, Ascii.CR, 1, 1, 1, 5, 0, 3, -126, 2, Ascii.SI, 0, CtapException.ERR_NOT_ALLOWED, -126, 2, 10, 2, -126, 2, 1, 0, -87, 121, -90, -53, -57, -38, 102, -3, -98, 99, CtapException.ERR_PIN_AUTH_INVALID, -43, 7, 80, 69, 125, -44, 20, -102, -27, CtapException.ERR_EXTENSION_FIRST, 4, 81, -89, -48, CtapException.ERR_UNSUPPORTED_ALGORITHM, -85, -127, -62, -41, CtapException.ERR_PIN_NOT_SET, -59, CtapException.ERR_USER_ACTION_TIMEOUT, -86, 2, -50, Ascii.SUB, -70, 102, 75, -114, Ascii.CAN, 90, Ascii.SI, 63, 4, -46, 86, -57, -127, CtapException.ERR_UNSUPPORTED_ALGORITHM, -52, CtapException.ERR_PIN_TOKEN_EXPIRED, 21, CtapException.ERR_UNSUPPORTED_ALGORITHM, -105, -37, 91, 3, 88, -124, -87, -57, -9, CtapException.ERR_USER_ACTION_PENDING, -90, Ascii.SO, -47, -104, -101, -51, -63, -3, 8, 11, -96, 84, -60, CtapException.ERR_PIN_REQUIRED, -112, CtapException.ERR_PIN_BLOCKED, -105, -88, -30, Ascii.DLE, 74, 18, -78, -77, -86, Ascii.FF, -105, 107, 100, -3, Ascii.SUB, 101, 105, -111, CtapException.ERR_UNSUPPORTED_ALGORITHM, -10, 76, -70, 75, CtapException.ERR_VENDOR_FIRST, -118, 75, -74, 76, 98, -121, -49, -122, 7, -81, -12, -12, CtapException.ERR_REQUEST_TOO_LARGE, 23, 71, 93, 8, -81, -25, 4, -8, -9, 100, 119, -2, CtapException.ERR_INVALID_CREDENTIAL, 87, -114, CtapException.ERR_KEY_STORE_FULL, CtapException.ERR_KEY_STORE_FULL, -68, 83, 108, -70, 107, 95, 84, 108, -91, -53, -76, -18, -97, -8, CtapException.ERR_NO_OPERATIONS, CtapException.ERR_NO_CREDENTIALS, -93, CtapException.ERR_UP_REQUIRED, -101, CtapException.ERR_EXTENSION_FIRST, Ascii.CR, 85, 125, CtapException.ERR_ACTION_TIMEOUT, -92, 75, CtapException.ERR_KEEPALIVE_CANCEL, -64, CtapException.ERR_NOT_ALLOWED, -82, 87, -80, -86, -26, -67, -95, CtapException.ERR_NOT_ALLOWED, -37, 2, -97, -26, Ascii.SO, 87, 115, -74, -97, -1, 103, -17, 23, -119, -114, -93, -4, 2, 66, CtapException.ERR_KEY_STORE_FULL, 91, -25, -7, -64, CtapException.ERR_PIN_TOKEN_EXPIRED, -77, -85, CtapException.ERR_REQUEST_TOO_LARGE, -111, -120, -1, -114, -62, -72, -1, 11, 125, -99, -6, CtapException.ERR_REQUEST_TOO_LARGE, 104, 63, 111, 71, CtapException.ERR_PIN_INVALID, CtapException.ERR_PIN_REQUIRED, -113, 98, 8, Ascii.US, 84, -12, 66, CtapException.ERR_INVALID_SUBCOMMAND, -115, CtapException.ERR_KEEPALIVE_CANCEL, CtapException.ERR_PIN_AUTH_INVALID, 113, 7, ByteSourceJsonBootstrapper.UTF8_BOM_3, -120, -113, -89, 114, -112, 79, Ascii.DLE, Ascii.FS, -98, -43, 119, -10, CtapException.ERR_REQUEST_TOO_LARGE, 105, -1, 80, 103, 5, -14, -56, -9, 82, ByteSourceJsonBootstrapper.UTF8_BOM_3, 10, -95, -68, -90, -97, 75, 70, -38, 74, -84, -75, -128, -74, -115, CtapException.ERR_INVALID_OPTION, Ascii.SI, CtapException.ERR_EXTENSION_FIRST, 115, -3, 82, -121, CtapException.ERR_VENDOR_FIRST, 18, 93, -96, -60, -124, -95, -57, 2, -62, -62, -122, 69, 69, 8, 78, -36, 63, 2, -113, -100, 17, -18, 116, -48, 102, 75, -95, -48, -23, -102, CtapException.ERR_PIN_POLICY_VIOLATION, 80, -52, Ascii.CAN, 85, 5, 94, -18, -17, -70, -114, CtapException.ERR_UP_REQUIRED, CtapException.ERR_SPEC_LAST, -93, -120, CtapException.ERR_NO_OPERATION_PENDING, -103, -104, CtapException.ERR_NO_OPERATIONS, CtapException.ERR_PIN_BLOCKED, Ascii.CAN, 115, -123, -85, -98, -112, -38, -57, 87, -35, 68, -8, 105, Ascii.CAN, -36, -47, -121, -39, -63, -61, 17, -70, 91, -105, 66, 64, 1, -43, -84, CtapException.ERR_USER_ACTION_PENDING, -120, -19, CtapException.ERR_NO_OPERATIONS, CtapException.ERR_USER_ACTION_PENDING, 124, 115, -42, CtapException.ERR_UV_BLOCKED, -107, CtapException.ERR_NO_OPERATIONS, -12, -48, CtapException.ERR_INVALID_SUBCOMMAND, -54, 117, Ascii.CR, -115, CtapException.ERR_UNSUPPORTED_ALGORITHM, 22, CtapException.ERR_NO_OPERATIONS, -18, 98, 108, 75, 93, 63, -36, 76, 117, Ascii.GS, -118, -4, -100, CtapException.ERR_PIN_AUTH_BLOCKED, 106, -4, -119, 64, -124, 103, 82, 84, CtapException.ERR_USER_ACTION_TIMEOUT, -22, 115, -44, 100, -75, -10, CtapException.ERR_INVALID_CREDENTIAL, 97, -55, -97, 103, -14, Ascii.RS, -105, -103, -2, CtapException.ERR_NO_OPERATION_PENDING, 68, CtapException.ERR_KEEPALIVE_CANCEL, -42, -53, -21, 23, 84, -61, 8, 118, 32, -3, -73, 2, -20, Ascii.CAN, 66, -62, 86, -88, 107, -125, 110, -46, Ascii.ESC, -53, Ascii.RS, -12, -101, -82, -55, -63, -6, 2, -83, -94, CtapException.ERR_VENDOR_FIRST, -126, -118, 91, CtapException.ERR_NOT_ALLOWED, 63, 0, -89, Ascii.CR, -48, Ascii.CAN, -103, CtapException.ERR_USER_ACTION_PENDING, CtapException.ERR_OPERATION_DENIED, -62, -64, CtapException.ERR_KEEPALIVE_CANCEL, 7, 2, 87, -85, Ascii.DLE, -6, Ascii.GS, 118, -63, 8, -43, -8, 3, -22, -108, -83, Ascii.US, -84, 98, 25, -123, 107, -56, -56, 87, CtapException.ERR_NOT_ALLOWED, 23, 107, -126, CtapException.ERR_PIN_POLICY_VIOLATION, -119, CtapException.ERR_UP_REQUIRED, -43, 66, 68, -17, -83, -1, 88, -82, CtapException.ERR_USER_ACTION_PENDING, -5, 2, 3, 1, 0, 1};

    private Signatures() {
    }

    public static boolean checkSignatures(Signature[] signatureArr) {
        if (MAMInfo.isDebug() || MAMBuildUtils.isDeveloperBuild()) {
            LOGGER.log(Level.WARNING, "Signature check disabled due to testOnly flag or developer build flag.");
            return (signatureArr != null && 1 == signatureArr.length && signatureArr[0].toCharsString().equals("BADSIGNATURE")) ? false : true;
        }
        if (signatureArr != null && 1 == signatureArr.length) {
            try {
                ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).verify(KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(AGENT_SIGNING_PUBLIC_KEY_SPEC)));
                LOGGER.info("Company Portal signature verified.", new Object[0]);
                return true;
            } catch (SignatureException | CertificateException unused) {
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Failed to validate Company Portal signature due to an unexpected error", e);
            }
        }
        return false;
    }
}
