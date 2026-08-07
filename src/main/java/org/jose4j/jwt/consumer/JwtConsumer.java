package org.jose4j.jwt.consumer;

import java.security.Key;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.jose4j.jca.ProviderContext;
import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.jwe.JsonWebEncryption;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.jwx.JsonWebStructure;
import org.jose4j.keys.KeyPersuasion;
import org.jose4j.keys.resolvers.DecryptionKeyResolver;
import org.jose4j.keys.resolvers.VerificationKeyResolver;
import org.jose4j.lang.ExceptionHelp;
import org.jose4j.lang.JoseException;

/* JADX INFO: loaded from: classes5.dex */
public class JwtConsumer {
    private DecryptionKeyResolver decryptionKeyResolver;
    private AlgorithmConstraints jweAlgorithmConstraints;
    private AlgorithmConstraints jweContentEncryptionAlgorithmConstraints;
    private JweCustomizer jweCustomizer;
    private ProviderContext jweProviderContext;
    private AlgorithmConstraints jwsAlgorithmConstraints;
    private JwsCustomizer jwsCustomizer;
    private ProviderContext jwsProviderContext;
    private boolean liberalContentTypeHandling;
    private boolean relaxDecryptionKeyValidation;
    private boolean relaxVerificationKeyValidation;
    private boolean requireEncryption;
    private boolean requireIntegrity;
    private boolean requireSignature = true;
    private boolean skipSignatureVerification;
    private boolean skipVerificationKeyResolutionOnNone;
    private List<ErrorCodeValidator> validators;
    private VerificationKeyResolver verificationKeyResolver;

    JwtConsumer() {
    }

    void setJwsAlgorithmConstraints(AlgorithmConstraints algorithmConstraints) {
        this.jwsAlgorithmConstraints = algorithmConstraints;
    }

    void setJweAlgorithmConstraints(AlgorithmConstraints algorithmConstraints) {
        this.jweAlgorithmConstraints = algorithmConstraints;
    }

    void setJweContentEncryptionAlgorithmConstraints(AlgorithmConstraints algorithmConstraints) {
        this.jweContentEncryptionAlgorithmConstraints = algorithmConstraints;
    }

    void setVerificationKeyResolver(VerificationKeyResolver verificationKeyResolver) {
        this.verificationKeyResolver = verificationKeyResolver;
    }

    void setDecryptionKeyResolver(DecryptionKeyResolver decryptionKeyResolver) {
        this.decryptionKeyResolver = decryptionKeyResolver;
    }

    void setValidators(List<ErrorCodeValidator> list) {
        this.validators = list;
    }

    void setRequireSignature(boolean z) {
        this.requireSignature = z;
    }

    void setRequireEncryption(boolean z) {
        this.requireEncryption = z;
    }

    void setRequireIntegrity(boolean z) {
        this.requireIntegrity = z;
    }

    void setLiberalContentTypeHandling(boolean z) {
        this.liberalContentTypeHandling = z;
    }

    void setSkipSignatureVerification(boolean z) {
        this.skipSignatureVerification = z;
    }

    void setRelaxVerificationKeyValidation(boolean z) {
        this.relaxVerificationKeyValidation = z;
    }

    public void setSkipVerificationKeyResolutionOnNone(boolean z) {
        this.skipVerificationKeyResolutionOnNone = z;
    }

    void setRelaxDecryptionKeyValidation(boolean z) {
        this.relaxDecryptionKeyValidation = z;
    }

    void setJwsProviderContext(ProviderContext providerContext) {
        this.jwsProviderContext = providerContext;
    }

    void setJweProviderContext(ProviderContext providerContext) {
        this.jweProviderContext = providerContext;
    }

    void setJwsCustomizer(JwsCustomizer jwsCustomizer) {
        this.jwsCustomizer = jwsCustomizer;
    }

    void setJweCustomizer(JweCustomizer jweCustomizer) {
        this.jweCustomizer = jweCustomizer;
    }

    public JwtClaims processToClaims(String str) throws InvalidJwtException {
        return process(str).getJwtClaims();
    }

    public void processContext(JwtContext jwtContext) throws InvalidJwtException {
        ArrayList arrayList = new ArrayList(jwtContext.getJoseObjects());
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            List listSubList = arrayList.subList(size + 1, arrayList.size());
            List<JsonWebStructure> listUnmodifiableList = Collections.unmodifiableList(listSubList);
            JsonWebStructure jsonWebStructure = (JsonWebStructure) arrayList.get(size);
            try {
                if (jsonWebStructure instanceof JsonWebSignature) {
                    JsonWebSignature jsonWebSignature = (JsonWebSignature) jsonWebStructure;
                    boolean zEquals = "none".equals(jsonWebSignature.getAlgorithmHeaderValue());
                    if (!this.skipSignatureVerification) {
                        ProviderContext providerContext = this.jwsProviderContext;
                        if (providerContext != null) {
                            jsonWebSignature.setProviderContext(providerContext);
                        }
                        if (this.relaxVerificationKeyValidation) {
                            jsonWebSignature.setDoKeyValidation(false);
                        }
                        AlgorithmConstraints algorithmConstraints = this.jwsAlgorithmConstraints;
                        if (algorithmConstraints != null) {
                            jsonWebSignature.setAlgorithmConstraints(algorithmConstraints);
                        }
                        if (!zEquals || !this.skipVerificationKeyResolutionOnNone) {
                            jsonWebSignature.setKey(this.verificationKeyResolver.resolveKey(jsonWebSignature, listUnmodifiableList));
                        }
                        JwsCustomizer jwsCustomizer = this.jwsCustomizer;
                        if (jwsCustomizer != null) {
                            jwsCustomizer.customize(jsonWebSignature, listUnmodifiableList);
                        }
                        if (!jsonWebSignature.verifySignature()) {
                            throw new InvalidJwtSignatureException(jsonWebSignature, jwtContext);
                        }
                    }
                    if (!zEquals) {
                        z = true;
                    }
                } else {
                    JsonWebEncryption jsonWebEncryption = (JsonWebEncryption) jsonWebStructure;
                    Key keyResolveKey = this.decryptionKeyResolver.resolveKey(jsonWebEncryption, listUnmodifiableList);
                    if (keyResolveKey != null && !keyResolveKey.equals(jsonWebEncryption.getKey())) {
                        throw new InvalidJwtException("The resolved decryption key is different than the one originally used to decrypt the JWE.", Collections.singletonList(new ErrorCodeValidator.Error(17, "Key resolution problem.")), jwtContext);
                    }
                    AlgorithmConstraints algorithmConstraints2 = this.jweAlgorithmConstraints;
                    if (algorithmConstraints2 != null) {
                        algorithmConstraints2.checkConstraint(jsonWebEncryption.getAlgorithmHeaderValue());
                    }
                    AlgorithmConstraints algorithmConstraints3 = this.jweContentEncryptionAlgorithmConstraints;
                    if (algorithmConstraints3 != null) {
                        algorithmConstraints3.checkConstraint(jsonWebEncryption.getEncryptionMethodHeaderParameter());
                    }
                    z3 = jsonWebEncryption.getKeyManagementModeAlgorithm().getKeyPersuasion() == KeyPersuasion.SYMMETRIC;
                    z2 = true;
                }
            } catch (InvalidJwtException e) {
                throw e;
            } catch (JoseException e2) {
                StringBuilder sb = new StringBuilder("Unable to process");
                if (!listSubList.isEmpty()) {
                    sb.append(" nested");
                }
                sb.append(" JOSE object (cause: ").append(e2).append("): ").append(jsonWebStructure);
                throw new InvalidJwtException("JWT processing failed.", new ErrorCodeValidator.Error(17, sb.toString()), e2, jwtContext);
            } catch (Exception e3) {
                StringBuilder sb2 = new StringBuilder("Unexpected exception encountered while processing");
                if (!listSubList.isEmpty()) {
                    sb2.append(" nested");
                }
                sb2.append(" JOSE object (").append(e3).append("): ").append(jsonWebStructure);
                throw new InvalidJwtException("JWT processing failed.", new ErrorCodeValidator.Error(17, sb2.toString()), e3, jwtContext);
            }
        }
        if (this.requireSignature && !z) {
            throw new InvalidJwtException("The JWT has no signature but the JWT Consumer is configured to require one: " + jwtContext.getJwt(), Collections.singletonList(new ErrorCodeValidator.Error(10, "Missing signature.")), jwtContext);
        }
        if (this.requireEncryption && !z2) {
            throw new InvalidJwtException("The JWT has no encryption but the JWT Consumer is configured to require it: " + jwtContext.getJwt(), Collections.singletonList(new ErrorCodeValidator.Error(19, "No encryption.")), jwtContext);
        }
        if (this.requireIntegrity && !z && !z3) {
            throw new InvalidJwtException("The JWT has no integrity protection (signature/MAC or symmetric AEAD encryption) but the JWT Consumer is configured to require it: " + jwtContext.getJwt(), Collections.singletonList(new ErrorCodeValidator.Error(20, "Missing Integrity Protection")), jwtContext);
        }
        validate(jwtContext);
    }

    public JwtContext process(String str) throws InvalidJwtException {
        String payload;
        LinkedList linkedList = new LinkedList();
        JwtClaims jwtClaims = null;
        JwtContext jwtContext = new JwtContext(str, null, Collections.unmodifiableList(linkedList));
        String str2 = str;
        while (jwtClaims == null) {
            try {
                try {
                    try {
                        JsonWebStructure jsonWebStructureFromCompactSerialization = JsonWebStructure.fromCompactSerialization(str2);
                        if (jsonWebStructureFromCompactSerialization instanceof JsonWebSignature) {
                            payload = ((JsonWebSignature) jsonWebStructureFromCompactSerialization).getUnverifiedPayload();
                        } else {
                            JsonWebEncryption jsonWebEncryption = (JsonWebEncryption) jsonWebStructureFromCompactSerialization;
                            ProviderContext providerContext = this.jweProviderContext;
                            if (providerContext != null) {
                                jsonWebEncryption.setProviderContext(providerContext);
                            }
                            if (this.relaxDecryptionKeyValidation) {
                                jsonWebEncryption.setDoKeyValidation(false);
                            }
                            AlgorithmConstraints algorithmConstraints = this.jweContentEncryptionAlgorithmConstraints;
                            if (algorithmConstraints != null) {
                                jsonWebEncryption.setContentEncryptionAlgorithmConstraints(algorithmConstraints);
                            }
                            List<JsonWebStructure> listUnmodifiableList = Collections.unmodifiableList(linkedList);
                            jsonWebEncryption.setKey(this.decryptionKeyResolver.resolveKey(jsonWebEncryption, listUnmodifiableList));
                            AlgorithmConstraints algorithmConstraints2 = this.jweAlgorithmConstraints;
                            if (algorithmConstraints2 != null) {
                                jsonWebEncryption.setAlgorithmConstraints(algorithmConstraints2);
                            }
                            JweCustomizer jweCustomizer = this.jweCustomizer;
                            if (jweCustomizer != null) {
                                jweCustomizer.customize(jsonWebEncryption, listUnmodifiableList);
                            }
                            payload = jsonWebEncryption.getPayload();
                        }
                        if (isNestedJwt(jsonWebStructureFromCompactSerialization)) {
                            str2 = payload;
                        } else {
                            try {
                                jwtClaims = JwtClaims.parse(payload, jwtContext);
                                jwtContext.setJwtClaims(jwtClaims);
                            } catch (InvalidJwtException e) {
                                if (this.liberalContentTypeHandling) {
                                    try {
                                        JsonWebStructure.fromCompactSerialization(str);
                                        str2 = payload;
                                    } catch (JoseException unused) {
                                        throw e;
                                    }
                                } else {
                                    throw e;
                                }
                            }
                        }
                        linkedList.addFirst(jsonWebStructureFromCompactSerialization);
                    } catch (JoseException e2) {
                        StringBuilder sb = new StringBuilder("Unable to process");
                        if (!linkedList.isEmpty()) {
                            sb.append(" nested");
                        }
                        sb.append(" JOSE object (cause: ").append(e2).append("): ").append(str2);
                        throw new InvalidJwtException("JWT processing failed.", new ErrorCodeValidator.Error(17, sb.toString()), e2, jwtContext);
                    }
                } catch (InvalidJwtException e3) {
                    throw e3;
                }
            } catch (Exception e4) {
                StringBuilder sb2 = new StringBuilder("Unexpected exception encountered while processing");
                if (!linkedList.isEmpty()) {
                    sb2.append(" nested");
                }
                sb2.append(" JOSE object (").append(e4).append("): ").append(str2);
                throw new InvalidJwtException("JWT processing failed.", new ErrorCodeValidator.Error(17, sb2.toString()), e4, jwtContext);
            }
        }
        processContext(jwtContext);
        return jwtContext;
    }

    void validate(JwtContext jwtContext) throws InvalidJwtException {
        ErrorCodeValidator.Error error;
        ErrorCodeValidator.Error errorValidate;
        ArrayList arrayList = new ArrayList();
        for (ErrorCodeValidator errorCodeValidator : this.validators) {
            try {
                errorValidate = errorCodeValidator.validate(jwtContext);
            } catch (MalformedClaimException e) {
                error = new ErrorCodeValidator.Error(18, e.getMessage());
                errorValidate = error;
            } catch (Exception e2) {
                error = new ErrorCodeValidator.Error(17, "Unexpected exception thrown from validator " + errorCodeValidator.getClass().getName() + ": " + ExceptionHelp.toStringWithCausesAndAbbreviatedStack(e2, getClass()));
                errorValidate = error;
            }
            if (errorValidate != null) {
                arrayList.add(errorValidate);
            }
        }
        if (!arrayList.isEmpty()) {
            throw new InvalidJwtException("JWT (claims->" + jwtContext.getJwtClaims().getRawJson() + ") rejected due to invalid claims or other invalid content.", arrayList, jwtContext);
        }
    }

    private boolean isNestedJwt(JsonWebStructure jsonWebStructure) {
        String contentTypeHeaderValue = jsonWebStructure.getContentTypeHeaderValue();
        if (contentTypeHeaderValue != null) {
            return contentTypeHeaderValue.equalsIgnoreCase("jwt") || contentTypeHeaderValue.equalsIgnoreCase("application/jwt");
        }
        return false;
    }
}
