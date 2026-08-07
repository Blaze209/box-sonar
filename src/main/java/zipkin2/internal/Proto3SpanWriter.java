package zipkin2.internal;

import java.util.List;
import zipkin2.Span;

/* JADX INFO: loaded from: classes6.dex */
final class Proto3SpanWriter implements WriteBuffer.Writer<Span> {
    static final byte[] EMPTY_ARRAY = new byte[0];

    Proto3SpanWriter() {
    }

    @Override // zipkin2.internal.WriteBuffer.Writer
    public int sizeInBytes(Span span) {
        return Proto3ZipkinFields.SPAN.sizeInBytes(span);
    }

    @Override // zipkin2.internal.WriteBuffer.Writer
    public void write(Span span, WriteBuffer writeBuffer) {
        Proto3ZipkinFields.SPAN.write(writeBuffer, span);
    }

    public String toString() {
        return "Span";
    }

    public byte[] writeList(List<Span> list) {
        int size = list.size();
        if (size == 0) {
            return EMPTY_ARRAY;
        }
        if (size == 1) {
            return write(list.get(0));
        }
        int[] iArr = new int[size];
        int iSizeOfLengthDelimitedField = 0;
        for (int i = 0; i < size; i++) {
            int iSizeOfValue = Proto3ZipkinFields.SPAN.sizeOfValue(list.get(i));
            iArr[i] = iSizeOfValue;
            iSizeOfLengthDelimitedField += Proto3Fields.sizeOfLengthDelimitedField(iSizeOfValue);
        }
        byte[] bArr = new byte[iSizeOfLengthDelimitedField];
        WriteBuffer writeBufferWrap = WriteBuffer.wrap(bArr);
        for (int i2 = 0; i2 < size; i2++) {
            writeSpan(list.get(i2), iArr[i2], writeBufferWrap);
        }
        return bArr;
    }

    byte[] write(Span span) {
        int iSizeOfValue = Proto3ZipkinFields.SPAN.sizeOfValue(span);
        byte[] bArr = new byte[Proto3Fields.sizeOfLengthDelimitedField(iSizeOfValue)];
        writeSpan(span, iSizeOfValue, WriteBuffer.wrap(bArr));
        return bArr;
    }

    void writeSpan(Span span, int i, WriteBuffer writeBuffer) {
        writeBuffer.writeByte(Proto3ZipkinFields.SPAN.key);
        writeBuffer.writeVarint(i);
        Proto3ZipkinFields.SPAN.writeValue(writeBuffer, span);
    }

    int writeList(List<Span> list, byte[] bArr, int i) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        WriteBuffer writeBufferWrap = WriteBuffer.wrap(bArr, i);
        for (int i2 = 0; i2 < size; i2++) {
            Proto3ZipkinFields.SPAN.write(writeBufferWrap, list.get(i2));
        }
        return writeBufferWrap.pos() - i;
    }
}
