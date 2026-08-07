package org.jose4j.jwt.consumer;

import java.util.List;
import org.jose4j.jwe.JsonWebEncryption;
import org.jose4j.jwx.JsonWebStructure;

/* JADX INFO: loaded from: classes5.dex */
public interface JweCustomizer {
    void customize(JsonWebEncryption jsonWebEncryption, List<JsonWebStructure> list);
}
