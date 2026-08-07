package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeDigitalSignatureCreationErrorList {
    public static final int CANNOT_CREATE_PKCS7 = 7;
    public static final int CANNOT_HASH_CERTIFICATE = 10;
    public static final int DOCUMENT_DIGEST = 3;
    public static final int EMPTY_LIST_OF_CERTIFICATES = 0;
    public static final int EXTRACT_TIMESTAMP_TOKEN = 9;
    public static final int NO_BYTERANGE = 5;
    public static final int PARSE_TIMESTAMP_HTTP_RESPONSE = 8;
    public static final int SIGNATURE_FINISH = 6;
    public static final int SIGNATURE_PLACEHOLDER_WRITE = 1;
    public static final int SIGNATURE_PREPARATION_SAVE = 2;
    public static final int WRITE_ZEROED_SIGNATURE_CONTENTS = 4;
    public static final NativeDigitalSignatureCreationError EMPTY_LIST_OF_CERTS_ERROR = new NativeDigitalSignatureCreationError(0, "The list of certificates to sign cannot be empty");
    public static final NativeDigitalSignatureCreationError SIGNATURE_PLACEHOLDER_WRITE_ERROR = new NativeDigitalSignatureCreationError(1, "An error occurred writing the signature placeholder");
    public static final NativeDigitalSignatureCreationError SIGNATURE_PREPARATION_SAVE_ERROR = new NativeDigitalSignatureCreationError(2, "An error occurred saving the new signature field");
    public static final NativeDigitalSignatureCreationError DOCUMENT_DIGEST_ERROR = new NativeDigitalSignatureCreationError(3, "An error occurred computing the document digest to sign");
    public static final NativeDigitalSignatureCreationError WRITE_ZEROED_SIGNATURE_CONTENTS_ERROR = new NativeDigitalSignatureCreationError(4, "An error occurred writing the zeroed contents to prepare the digital signature");
    public static final NativeDigitalSignatureCreationError NO_BYTERANGE_ERROR = new NativeDigitalSignatureCreationError(5, "The signature does not contain a valid ByteRange. Check that the signature was prepared with `prepare_signature`");
    public static final NativeDigitalSignatureCreationError SIGNATURE_FINISH_ERROR = new NativeDigitalSignatureCreationError(6, "An error occurred embedding the signature into the document");
    public static final NativeDigitalSignatureCreationError CANNOT_CREATE_PKCS7_ERROR = new NativeDigitalSignatureCreationError(7, "An error occurred creating the PKCS#7 signature");
    public static final NativeDigitalSignatureCreationError PARSE_TIMESTAMP_HTTP_RESPONSE_ERROR = new NativeDigitalSignatureCreationError(8, "An error occurred parsing the HTTP response with the signature timestamp");
    public static final NativeDigitalSignatureCreationError EXTRACT_TIMESTAMP_TOKEN_ERROR = new NativeDigitalSignatureCreationError(9, "An error occurred extracting the timestamp token");
    public static final NativeDigitalSignatureCreationError CANNOT_HASH_CERTIFICATE_ERROR = new NativeDigitalSignatureCreationError(10, "An error occurred hashing the certificate to include in a CAdES signature");

    public String toString() {
        return "NativeDigitalSignatureCreationErrorList{}";
    }
}
