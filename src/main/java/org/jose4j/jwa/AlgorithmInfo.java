package org.jose4j.jwa;

import org.jose4j.keys.KeyPersuasion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AlgorithmInfo implements Algorithm {
    private String algorithmIdentifier;
    private String javaAlgorithm;
    private KeyPersuasion keyPersuasion;
    private String keyType;
    protected final Logger log = LoggerFactory.getLogger(getClass());

    public void setAlgorithmIdentifier(String str) {
        this.algorithmIdentifier = str;
    }

    public void setJavaAlgorithm(String str) {
        this.javaAlgorithm = str;
    }

    @Override // org.jose4j.jwa.Algorithm
    public String getJavaAlgorithm() {
        return this.javaAlgorithm;
    }

    @Override // org.jose4j.jwa.Algorithm
    public String getAlgorithmIdentifier() {
        return this.algorithmIdentifier;
    }

    @Override // org.jose4j.jwa.Algorithm
    public KeyPersuasion getKeyPersuasion() {
        return this.keyPersuasion;
    }

    public void setKeyPersuasion(KeyPersuasion keyPersuasion) {
        this.keyPersuasion = keyPersuasion;
    }

    @Override // org.jose4j.jwa.Algorithm
    public String getKeyType() {
        return this.keyType;
    }

    public void setKeyType(String str) {
        this.keyType = str;
    }
}
