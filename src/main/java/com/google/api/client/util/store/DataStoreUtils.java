package com.google.api.client.util.store;

import java.io.IOException;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes10.dex */
public final class DataStoreUtils {
    public static String toString(DataStore<?> dataStore) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
            boolean z = true;
            for (String str : dataStore.keySet()) {
                if (z) {
                    z = false;
                } else {
                    sb.append(", ");
                }
                sb.append(str).append('=').append(dataStore.get(str));
            }
            return sb.append(AbstractJsonLexerKt.END_OBJ).toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private DataStoreUtils() {
    }
}
