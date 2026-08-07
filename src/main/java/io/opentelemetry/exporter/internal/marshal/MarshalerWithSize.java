package io.opentelemetry.exporter.internal.marshal;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MarshalerWithSize extends Marshaler {
    private final int size;

    protected MarshalerWithSize(int i) {
        this.size = i;
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Marshaler
    public final int getBinarySerializedSize() {
        return this.size;
    }
}
