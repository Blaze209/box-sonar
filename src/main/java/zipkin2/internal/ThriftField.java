package zipkin2.internal;

/* JADX INFO: loaded from: classes6.dex */
final class ThriftField {
    static final byte TYPE_BOOL = 2;
    static final byte TYPE_BYTE = 3;
    static final byte TYPE_DOUBLE = 4;
    static final byte TYPE_I16 = 6;
    static final byte TYPE_I32 = 8;
    static final byte TYPE_I64 = 10;
    static final byte TYPE_LIST = 15;
    static final byte TYPE_MAP = 13;
    static final byte TYPE_SET = 14;
    static final byte TYPE_STOP = 0;
    static final byte TYPE_STRING = 11;
    static final byte TYPE_STRUCT = 12;
    final int id;
    final byte type;

    ThriftField(byte b, int i) {
        this.type = b;
        this.id = i;
    }

    void write(WriteBuffer writeBuffer) {
        writeBuffer.writeByte(this.type);
        writeBuffer.writeByte((this.id >>> 8) & 255);
        writeBuffer.writeByte(this.id & 255);
    }

    static ThriftField read(ReadBuffer readBuffer) {
        byte b = readBuffer.readByte();
        return new ThriftField(b, b == 0 ? (short) 0 : readBuffer.readShort());
    }

    boolean isEqualTo(ThriftField thriftField) {
        return this.type == thriftField.type && this.id == thriftField.id;
    }
}
