package com.nimbusds.jose;

import com.nimbusds.jose.shaded.jcip.Immutable;
import com.nimbusds.jose.util.JSONStringUtils;
import java.io.Serializable;
import java.util.Objects;
import org.jose4j.zip.CompressionAlgorithmIdentifiers;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
public final class CompressionAlgorithm implements Serializable {
    public static final CompressionAlgorithm DEF = new CompressionAlgorithm(CompressionAlgorithmIdentifiers.DEFLATE);
    private static final long serialVersionUID = 1;
    private final String name;

    public CompressionAlgorithm(String str) {
        this.name = (String) Objects.requireNonNull(str);
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public boolean equals(Object obj) {
        return (obj instanceof CompressionAlgorithm) && toString().equals(obj.toString());
    }

    public String toString() {
        return this.name;
    }

    public String toJSONString() {
        return JSONStringUtils.toJSONString(this.name);
    }
}
