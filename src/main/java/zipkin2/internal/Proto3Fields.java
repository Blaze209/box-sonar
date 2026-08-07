package zipkin2.internal;

/* JADX INFO: loaded from: classes6.dex */
final class Proto3Fields {
    static final int WIRETYPE_FIXED32 = 5;
    static final int WIRETYPE_FIXED64 = 1;
    static final int WIRETYPE_LENGTH_DELIMITED = 2;
    static final int WIRETYPE_VARINT = 0;

    Proto3Fields() {
    }

    static class Field {
        final int fieldNumber;
        final int key;
        final int wireType;

        Field(int i) {
            this(i >>> 3, i & 7, i);
        }

        Field(int i, int i2, int i3) {
            this.fieldNumber = i;
            this.wireType = i2;
            this.key = i3;
        }

        static int fieldNumber(int i, int i2) {
            int i3 = i >>> 3;
            if (i3 != 0) {
                return i3;
            }
            throw new IllegalArgumentException("Malformed: fieldNumber was zero at byte " + i2);
        }

        static int wireType(int i, int i2) {
            int i3 = i & 7;
            if (i3 == 0 || i3 == 1 || i3 == 2 || i3 == 5) {
                return i3;
            }
            throw new IllegalArgumentException("Malformed: invalid wireType " + i3 + " at byte " + i2);
        }

        static boolean skipValue(ReadBuffer readBuffer, int i) {
            int iAvailable = readBuffer.available();
            if (i == 0) {
                for (int i2 = 0; i2 < iAvailable; i2++) {
                    if (readBuffer.readByte() >= 0) {
                        return true;
                    }
                }
                return false;
            }
            if (i == 1) {
                return readBuffer.skip(8L) == 8;
            }
            if (i == 2) {
                long varint32 = readBuffer.readVarint32();
                return readBuffer.skip(varint32) == varint32;
            }
            if (i == 5) {
                return readBuffer.skip(4L) == 4;
            }
            throw new IllegalArgumentException("Malformed: invalid wireType " + i + " at byte " + readBuffer.pos());
        }
    }

    static abstract class LengthDelimitedField<T> extends Field {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        abstract T readValue(ReadBuffer readBuffer, int i);

        abstract int sizeOfValue(T t);

        abstract void writeValue(WriteBuffer writeBuffer, T t);

        LengthDelimitedField(int i) {
            super(i);
        }

        final int sizeInBytes(T t) {
            if (t == null) {
                return 0;
            }
            return Proto3Fields.sizeOfLengthDelimitedField(sizeOfValue(t));
        }

        final void write(WriteBuffer writeBuffer, T t) {
            if (t == null) {
                return;
            }
            int iSizeOfValue = sizeOfValue(t);
            writeBuffer.writeByte(this.key);
            writeBuffer.writeVarint(iSizeOfValue);
            writeValue(writeBuffer, t);
        }

        final T readLengthPrefixAndValue(ReadBuffer readBuffer) {
            int varint32 = readBuffer.readVarint32();
            if (varint32 == 0) {
                return null;
            }
            return readValue(readBuffer, varint32);
        }
    }

    static class BytesField extends LengthDelimitedField<byte[]> {
        BytesField(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // zipkin2.internal.Proto3Fields.LengthDelimitedField
        public int sizeOfValue(byte[] bArr) {
            return bArr.length;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // zipkin2.internal.Proto3Fields.LengthDelimitedField
        public void writeValue(WriteBuffer writeBuffer, byte[] bArr) {
            writeBuffer.write(bArr);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // zipkin2.internal.Proto3Fields.LengthDelimitedField
        public byte[] readValue(ReadBuffer readBuffer, int i) {
            return readBuffer.readBytes(i);
        }
    }

    static class HexField extends LengthDelimitedField<String> {
        HexField(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // zipkin2.internal.Proto3Fields.LengthDelimitedField
        public int sizeOfValue(String str) {
            if (str == null) {
                return 0;
            }
            return str.length() / 2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // zipkin2.internal.Proto3Fields.LengthDelimitedField
        public void writeValue(WriteBuffer writeBuffer, String str) {
            int length = str.length();
            for (int i = 0; i < length; i += 2) {
                writeBuffer.writeByte((byte) ((decodeLowerHex(str.charAt(i)) << 4) + decodeLowerHex(str.charAt(i + 1))));
            }
        }

        static int decodeLowerHex(char c) {
            if (c >= '0' && c <= '9') {
                return c - '0';
            }
            if (c < 'a' || c > 'f') {
                throw new AssertionError("not lowerHex " + c);
            }
            return c - 'W';
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // zipkin2.internal.Proto3Fields.LengthDelimitedField
        public String readValue(ReadBuffer readBuffer, int i) {
            return readBuffer.readBytesAsHex(i);
        }
    }

    static class Utf8Field extends LengthDelimitedField<String> {
        Utf8Field(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // zipkin2.internal.Proto3Fields.LengthDelimitedField
        public int sizeOfValue(String str) {
            if (str != null) {
                return WriteBuffer.utf8SizeInBytes(str);
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // zipkin2.internal.Proto3Fields.LengthDelimitedField
        public void writeValue(WriteBuffer writeBuffer, String str) {
            writeBuffer.writeUtf8(str);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // zipkin2.internal.Proto3Fields.LengthDelimitedField
        public String readValue(ReadBuffer readBuffer, int i) {
            return readBuffer.readUtf8(i);
        }
    }

    static final class Fixed64Field extends Field {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        int sizeInBytes(long j) {
            return j == 0 ? 0 : 9;
        }

        Fixed64Field(int i) {
            super(i);
        }

        void write(WriteBuffer writeBuffer, long j) {
            if (j == 0) {
                return;
            }
            writeBuffer.writeByte(this.key);
            writeBuffer.writeLongLe(j);
        }

        long readValue(ReadBuffer readBuffer) {
            return readBuffer.readLongLe();
        }
    }

    static class VarintField extends Field {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        VarintField(int i) {
            super(i);
        }

        int sizeInBytes(int i) {
            if (i != 0) {
                return WriteBuffer.varintSizeInBytes(i) + 1;
            }
            return 0;
        }

        void write(WriteBuffer writeBuffer, int i) {
            if (i == 0) {
                return;
            }
            writeBuffer.writeByte(this.key);
            writeBuffer.writeVarint(i);
        }

        int sizeInBytes(long j) {
            if (j != 0) {
                return WriteBuffer.varintSizeInBytes(j) + 1;
            }
            return 0;
        }

        void write(WriteBuffer writeBuffer, long j) {
            if (j == 0) {
                return;
            }
            writeBuffer.writeByte(this.key);
            writeBuffer.writeVarint(j);
        }
    }

    static final class BooleanField extends Field {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        int sizeInBytes(boolean z) {
            return z ? 2 : 0;
        }

        BooleanField(int i) {
            super(i);
        }

        void write(WriteBuffer writeBuffer, boolean z) {
            if (z) {
                writeBuffer.writeByte(this.key);
                writeBuffer.writeByte(1);
            }
        }

        boolean read(ReadBuffer readBuffer) {
            byte b = readBuffer.readByte();
            if (b < 0 || b > 1) {
                throw new IllegalArgumentException("Malformed: invalid boolean value at byte " + readBuffer.pos());
            }
            return b == 1;
        }
    }

    static final class Fixed32Field extends Field {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        int sizeInBytes(int i) {
            return i == 0 ? 0 : 5;
        }

        Fixed32Field(int i) {
            super(i);
        }
    }

    static int sizeOfLengthDelimitedField(int i) {
        return WriteBuffer.varintSizeInBytes(i) + 1 + i;
    }
}
