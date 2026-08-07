package com.google.android.gms.internal.mlkit_vision_text_common;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* JADX INFO: loaded from: classes11.dex */
abstract class zzam implements Map.Entry {
    zzam() {
    }

    @Override // java.util.Map.Entry
    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            if (zzw.zza(getKey(), entry.getKey()) && zzw.zza(getValue(), entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public abstract Object getKey();

    @Override // java.util.Map.Entry
    public abstract Object getValue();

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object key = getKey();
        Object value = getValue();
        return (key == null ? 0 : key.hashCode()) ^ (value != null ? value.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        return String.valueOf(getKey()) + SimpleComparison.EQUAL_TO_OPERATION + String.valueOf(getValue());
    }
}
