package io.opentelemetry.exporter.internal.marshal;

import io.opentelemetry.api.internal.OtelEncodingUtils;
import io.opentelemetry.api.trace.SpanId;
import io.opentelemetry.api.trace.TraceId;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes4.dex */
final class ProtoSerializer extends Serializer implements AutoCloseable {
    private static final ThreadLocal<Map<String, byte[]>> THREAD_LOCAL_ID_CACHE = new ThreadLocal<>();
    private final Map<String, byte[]> idCache = getIdCache();
    private final CodedOutputStream output;

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected void writeEndMessage() {
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected void writeEndRepeatedPrimitive() {
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected void writeEndRepeatedVarint() {
    }

    ProtoSerializer(OutputStream outputStream) {
        this.output = CodedOutputStream.newInstance(outputStream);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected void writeTraceId(ProtoFieldInfo protoFieldInfo, String str) throws IOException {
        writeBytes(protoFieldInfo, this.idCache.computeIfAbsent(str, new Function() { // from class: io.opentelemetry.exporter.internal.marshal.ProtoSerializer$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return OtelEncodingUtils.bytesFromBase16((String) obj, TraceId.getLength());
            }
        }));
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected void writeSpanId(ProtoFieldInfo protoFieldInfo, String str) throws IOException {
        writeBytes(protoFieldInfo, this.idCache.computeIfAbsent(str, new Function() { // from class: io.opentelemetry.exporter.internal.marshal.ProtoSerializer$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return OtelEncodingUtils.bytesFromBase16((String) obj, SpanId.getLength());
            }
        }));
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    public void writeBool(ProtoFieldInfo protoFieldInfo, boolean z) throws IOException {
        this.output.writeUInt32NoTag(protoFieldInfo.getTag());
        this.output.writeBoolNoTag(z);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected void writeEnum(ProtoFieldInfo protoFieldInfo, ProtoEnumInfo protoEnumInfo) throws IOException {
        this.output.writeUInt32NoTag(protoFieldInfo.getTag());
        this.output.writeEnumNoTag(protoEnumInfo.getEnumNumber());
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected void writeUint32(ProtoFieldInfo protoFieldInfo, int i) throws IOException {
        this.output.writeUInt32NoTag(protoFieldInfo.getTag());
        this.output.writeUInt32NoTag(i);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected void writeSInt32(ProtoFieldInfo protoFieldInfo, int i) throws IOException {
        this.output.writeUInt32NoTag(protoFieldInfo.getTag());
        this.output.writeSInt32NoTag(i);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected void writeint32(ProtoFieldInfo protoFieldInfo, int i) throws IOException {
        this.output.writeUInt32NoTag(protoFieldInfo.getTag());
        this.output.writeInt32NoTag(i);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    public void writeInt64(ProtoFieldInfo protoFieldInfo, long j) throws IOException {
        this.output.writeUInt32NoTag(protoFieldInfo.getTag());
        this.output.writeInt64NoTag(j);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected void writeFixed64(ProtoFieldInfo protoFieldInfo, long j) throws IOException {
        this.output.writeUInt32NoTag(protoFieldInfo.getTag());
        this.output.writeFixed64NoTag(j);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected void writeFixed64Value(long j) throws IOException {
        this.output.writeFixed64NoTag(j);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected void writeUInt64Value(long j) throws IOException {
        this.output.writeUInt64NoTag(j);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected void writeFixed32(ProtoFieldInfo protoFieldInfo, int i) throws IOException {
        this.output.writeUInt32NoTag(protoFieldInfo.getTag());
        this.output.writeFixed32NoTag(i);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    public void writeDouble(ProtoFieldInfo protoFieldInfo, double d) throws IOException {
        this.output.writeUInt32NoTag(protoFieldInfo.getTag());
        this.output.writeDoubleNoTag(d);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected void writeDoubleValue(double d) throws IOException {
        this.output.writeDoubleNoTag(d);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    public void writeString(ProtoFieldInfo protoFieldInfo, byte[] bArr) throws IOException {
        writeBytes(protoFieldInfo, bArr);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected void writeBytes(ProtoFieldInfo protoFieldInfo, byte[] bArr) throws IOException {
        this.output.writeUInt32NoTag(protoFieldInfo.getTag());
        this.output.writeByteArrayNoTag(bArr);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected void writeStartMessage(ProtoFieldInfo protoFieldInfo, int i) throws IOException {
        this.output.writeUInt32NoTag(protoFieldInfo.getTag());
        this.output.writeUInt32NoTag(i);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected void writeStartRepeatedPrimitive(ProtoFieldInfo protoFieldInfo, int i, int i2) throws IOException {
        this.output.writeUInt32NoTag(protoFieldInfo.getTag());
        this.output.writeUInt32NoTag(i * i2);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected void writeStartRepeatedVarint(ProtoFieldInfo protoFieldInfo, int i) throws IOException {
        this.output.writeUInt32NoTag(protoFieldInfo.getTag());
        this.output.writeUInt32NoTag(i);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    public void serializeRepeatedMessage(ProtoFieldInfo protoFieldInfo, Marshaler[] marshalerArr) throws IOException {
        for (Marshaler marshaler : marshalerArr) {
            serializeMessage(protoFieldInfo, marshaler);
        }
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    public void serializeRepeatedMessage(ProtoFieldInfo protoFieldInfo, List<? extends Marshaler> list) throws IOException {
        Iterator<? extends Marshaler> it = list.iterator();
        while (it.hasNext()) {
            serializeMessage(protoFieldInfo, it.next());
        }
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    public void writeSerializedMessage(byte[] bArr, String str) throws IOException {
        this.output.writeRawBytes(bArr);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer, java.lang.AutoCloseable
    public void close() throws IOException {
        this.output.flush();
        this.idCache.clear();
    }

    private static Map<String, byte[]> getIdCache() {
        ThreadLocal<Map<String, byte[]>> threadLocal = THREAD_LOCAL_ID_CACHE;
        Map<String, byte[]> map = threadLocal.get();
        if (map != null) {
            return map;
        }
        HashMap map2 = new HashMap();
        threadLocal.set(map2);
        return map2;
    }
}
