package io.opentelemetry.sdk.metrics;

import io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import javax.annotation.Nullable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
abstract class AbstractInstrument {
    private final InstrumentDescriptor descriptor;

    AbstractInstrument(InstrumentDescriptor instrumentDescriptor) {
        this.descriptor = instrumentDescriptor;
    }

    final InstrumentDescriptor getDescriptor() {
        return this.descriptor;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AbstractInstrument) {
            return this.descriptor.equals(((AbstractInstrument) obj).descriptor);
        }
        return false;
    }

    public int hashCode() {
        return this.descriptor.hashCode();
    }

    public String toString() {
        return getClass().getSimpleName() + "{descriptor=" + getDescriptor() + AbstractJsonLexerKt.END_OBJ;
    }
}
