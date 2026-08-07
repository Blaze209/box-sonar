package com.pspdfkit.signatures;

import android.net.Uri;
import com.pspdfkit.document.providers.ContentResolverDataProvider;
import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.forms.SignatureFormField;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0007\u0018\u00002\u00020\u0001:\u0001'BU\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u0006("}, d2 = {"Lcom/pspdfkit/signatures/SignerOptions;", "", "signatureFormField", "Lcom/pspdfkit/forms/SignatureFormField;", "outputDataProvider", "Lcom/pspdfkit/document/providers/DataProvider;", "type", "Lcom/pspdfkit/signatures/DigitalSignatureType;", "metadata", "Lcom/pspdfkit/signatures/DigitalSignatureMetadata;", "privateKeyEntry", "Ljava/security/KeyStore$PrivateKeyEntry;", "privateKey", "Ljava/security/PrivateKey;", "certificates", "", "Ljava/security/cert/X509Certificate;", "enableLtv", "", "<init>", "(Lcom/pspdfkit/forms/SignatureFormField;Lcom/pspdfkit/document/providers/DataProvider;Lcom/pspdfkit/signatures/DigitalSignatureType;Lcom/pspdfkit/signatures/DigitalSignatureMetadata;Ljava/security/KeyStore$PrivateKeyEntry;Ljava/security/PrivateKey;Ljava/util/List;Z)V", "getSignatureFormField", "()Lcom/pspdfkit/forms/SignatureFormField;", "getOutputDataProvider", "()Lcom/pspdfkit/document/providers/DataProvider;", "getType", "()Lcom/pspdfkit/signatures/DigitalSignatureType;", "getMetadata", "()Lcom/pspdfkit/signatures/DigitalSignatureMetadata;", "getPrivateKeyEntry$annotations", "()V", "getPrivateKeyEntry", "()Ljava/security/KeyStore$PrivateKeyEntry;", "getPrivateKey", "()Ljava/security/PrivateKey;", "getCertificates", "()Ljava/util/List;", "getEnableLtv", "()Z", "Builder", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SignerOptions {
    public static final int $stable = 8;
    private final List<X509Certificate> certificates;
    private final boolean enableLtv;
    private final DigitalSignatureMetadata metadata;
    private final DataProvider outputDataProvider;
    private final PrivateKey privateKey;
    private final KeyStore.PrivateKeyEntry privateKeyEntry;
    private final SignatureFormField signatureFormField;
    private final DigitalSignatureType type;

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u000eJ\u0010\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012J\u0014\u0010\u001c\u001a\u00020\u00002\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u001e\u001a\u00020\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/pspdfkit/signatures/SignerOptions$Builder;", "", "signatureFormField", "Lcom/pspdfkit/forms/SignatureFormField;", "outputDataProvider", "Lcom/pspdfkit/document/providers/DataProvider;", "<init>", "(Lcom/pspdfkit/forms/SignatureFormField;Lcom/pspdfkit/document/providers/DataProvider;)V", "outputFileUri", "Landroid/net/Uri;", "(Lcom/pspdfkit/forms/SignatureFormField;Landroid/net/Uri;)V", "type", "Lcom/pspdfkit/signatures/DigitalSignatureType;", "metadata", "Lcom/pspdfkit/signatures/DigitalSignatureMetadata;", "privateKeyEntry", "Ljava/security/KeyStore$PrivateKeyEntry;", "privateKey", "Ljava/security/PrivateKey;", "certificates", "", "Ljava/security/cert/X509Certificate;", "enableLtv", "", "setType", "setSignatureMetadata", "digitalSignatureMetadata", "setPrivateKey", "setCertificates", "setEnableLtv", "build", "Lcom/pspdfkit/signatures/SignerOptions;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private List<? extends X509Certificate> certificates;
        private boolean enableLtv;
        private DigitalSignatureMetadata metadata;
        private final DataProvider outputDataProvider;
        private PrivateKey privateKey;
        private KeyStore.PrivateKeyEntry privateKeyEntry;
        private final SignatureFormField signatureFormField;
        private DigitalSignatureType type;

        public Builder(SignatureFormField signatureFormField, DataProvider dataProvider) {
            signatureFormField.getClass();
            dataProvider.getClass();
            this.signatureFormField = signatureFormField;
            this.outputDataProvider = dataProvider;
            this.type = DigitalSignatureType.CADES;
            this.certificates = CollectionsKt.emptyList();
            this.enableLtv = true;
        }

        public final SignerOptions build() {
            return new SignerOptions(this.signatureFormField, this.outputDataProvider, this.type, this.metadata, this.privateKeyEntry, this.privateKey, this.certificates, this.enableLtv, null);
        }

        public final Builder setCertificates(List<? extends X509Certificate> certificates) {
            certificates.getClass();
            this.certificates = certificates;
            return this;
        }

        public final Builder setEnableLtv(boolean enableLtv) {
            this.enableLtv = enableLtv;
            return this;
        }

        @Deprecated(message = "Use setPrivateKey(PrivateKey) with setCertificates instead. This will be removed in a future release.")
        public final Builder setPrivateKey(KeyStore.PrivateKeyEntry privateKeyEntry) {
            privateKeyEntry.getClass();
            this.privateKeyEntry = privateKeyEntry;
            return this;
        }

        public final Builder setSignatureMetadata(DigitalSignatureMetadata digitalSignatureMetadata) {
            digitalSignatureMetadata.getClass();
            this.metadata = digitalSignatureMetadata;
            return this;
        }

        public final Builder setType(DigitalSignatureType type) {
            type.getClass();
            this.type = type;
            return this;
        }

        public final Builder setPrivateKey(PrivateKey privateKey) {
            privateKey.getClass();
            this.privateKey = privateKey;
            return this;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(SignatureFormField signatureFormField, Uri uri) {
            this(signatureFormField, new ContentResolverDataProvider(uri));
            signatureFormField.getClass();
            uri.getClass();
        }
    }

    public /* synthetic */ SignerOptions(SignatureFormField signatureFormField, DataProvider dataProvider, DigitalSignatureType digitalSignatureType, DigitalSignatureMetadata digitalSignatureMetadata, KeyStore.PrivateKeyEntry privateKeyEntry, PrivateKey privateKey, List list, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(signatureFormField, dataProvider, digitalSignatureType, digitalSignatureMetadata, privateKeyEntry, privateKey, list, z);
    }

    @Deprecated(message = "Use privateKey and certificates instead. This will be removed in a future release.")
    public static /* synthetic */ void getPrivateKeyEntry$annotations() {
    }

    public final List<X509Certificate> getCertificates() {
        return this.certificates;
    }

    public final boolean getEnableLtv() {
        return this.enableLtv;
    }

    public final DigitalSignatureMetadata getMetadata() {
        return this.metadata;
    }

    public final DataProvider getOutputDataProvider() {
        return this.outputDataProvider;
    }

    public final PrivateKey getPrivateKey() {
        return this.privateKey;
    }

    public final KeyStore.PrivateKeyEntry getPrivateKeyEntry() {
        return this.privateKeyEntry;
    }

    public final SignatureFormField getSignatureFormField() {
        return this.signatureFormField;
    }

    public final DigitalSignatureType getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SignerOptions(SignatureFormField signatureFormField, DataProvider dataProvider, DigitalSignatureType digitalSignatureType, DigitalSignatureMetadata digitalSignatureMetadata, KeyStore.PrivateKeyEntry privateKeyEntry, PrivateKey privateKey, List<? extends X509Certificate> list, boolean z) {
        this.signatureFormField = signatureFormField;
        this.outputDataProvider = dataProvider;
        this.type = digitalSignatureType;
        this.metadata = digitalSignatureMetadata;
        this.privateKeyEntry = privateKeyEntry;
        this.privateKey = privateKey;
        this.certificates = list;
        this.enableLtv = z;
    }
}
