package zipkin2.internal;

import java.io.EOFException;
import java.nio.BufferUnderflowException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import zipkin2.Span;
import zipkin2.v1.V1Span;
import zipkin2.v1.V1SpanConverter;

/* JADX INFO: loaded from: classes6.dex */
public final class ThriftCodec {
    static final int MAX_SKIP_DEPTH = Integer.MAX_VALUE;
    final V1ThriftSpanWriter writer = new V1ThriftSpanWriter();

    public int sizeInBytes(Span span) {
        return this.writer.sizeInBytes(span);
    }

    public byte[] write(Span span) {
        return this.writer.write(span);
    }

    static <T> int listSizeInBytes(WriteBuffer.Writer<T> writer, List<T> list) {
        int size = list.size();
        int iSizeInBytes = 5;
        for (int i = 0; i < size; i++) {
            iSizeInBytes += writer.sizeInBytes(list.get(i));
        }
        return iSizeInBytes;
    }

    public static boolean read(ReadBuffer readBuffer, Collection<Span> collection) {
        if (readBuffer.available() == 0) {
            return false;
        }
        try {
            V1SpanConverter.create().convert(new V1ThriftSpanReader().read(readBuffer), collection);
            return true;
        } catch (Exception e) {
            throw exceptionReading("Span", e);
        }
    }

    @Nullable
    public static Span readOne(ReadBuffer readBuffer) {
        if (readBuffer.available() == 0) {
            return null;
        }
        try {
            V1Span v1Span = new V1ThriftSpanReader().read(readBuffer);
            ArrayList arrayList = new ArrayList(1);
            V1SpanConverter.create().convert(v1Span, arrayList);
            return (Span) arrayList.get(0);
        } catch (Exception e) {
            throw exceptionReading("Span", e);
        }
    }

    public static boolean readList(ReadBuffer readBuffer, Collection<Span> collection) {
        if (readBuffer.available() == 0) {
            return false;
        }
        try {
            int listLength = readListLength(readBuffer);
            if (listLength == 0) {
                return false;
            }
            V1ThriftSpanReader v1ThriftSpanReader = new V1ThriftSpanReader();
            V1SpanConverter v1SpanConverterCreate = V1SpanConverter.create();
            for (int i = 0; i < listLength; i++) {
                v1SpanConverterCreate.convert(v1ThriftSpanReader.read(readBuffer), collection);
            }
            return true;
        } catch (Exception e) {
            throw exceptionReading("List<Span>", e);
        }
    }

    static int readListLength(ReadBuffer readBuffer) {
        readBuffer.readByte();
        return readBuffer.readInt();
    }

    static <T> void writeList(WriteBuffer.Writer<T> writer, List<T> list, WriteBuffer writeBuffer) {
        int size = list.size();
        writeListBegin(writeBuffer, size);
        for (int i = 0; i < size; i++) {
            writer.write(list.get(i), writeBuffer);
        }
    }

    static IllegalArgumentException exceptionReading(String str, Exception exc) {
        String message = exc.getMessage() == null ? "Error" : exc.getMessage();
        if (exc instanceof EOFException) {
            message = "EOF";
        }
        if ((exc instanceof IllegalStateException) || (exc instanceof BufferUnderflowException)) {
            message = "Malformed";
        }
        throw new IllegalArgumentException(String.format("%s reading %s from TBinary", message, str), exc);
    }

    static void skip(ReadBuffer readBuffer, byte b) {
        skip(readBuffer, b, Integer.MAX_VALUE);
    }

    static void skip(ReadBuffer readBuffer, byte b, int i) {
        if (i <= 0) {
            throw new IllegalStateException("Maximum skip depth exceeded");
        }
        int i2 = 0;
        switch (b) {
            case 2:
            case 3:
                readBuffer.skip(1L);
                return;
            case 4:
            case 10:
                readBuffer.skip(8L);
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                readBuffer.skip(2L);
                return;
            case 8:
                readBuffer.skip(4L);
                return;
            case 11:
                readBuffer.skip(readBuffer.readInt());
                return;
            case 12:
                break;
            case 13:
                byte b2 = readBuffer.readByte();
                byte b3 = readBuffer.readByte();
                int i3 = readBuffer.readInt();
                while (i2 < i3) {
                    int i4 = i - 1;
                    skip(readBuffer, b2, i4);
                    skip(readBuffer, b3, i4);
                    i2++;
                }
                return;
            case 14:
            case 15:
                byte b4 = readBuffer.readByte();
                int i5 = readBuffer.readInt();
                while (i2 < i5) {
                    skip(readBuffer, b4, i - 1);
                    i2++;
                }
                return;
        }
        while (true) {
            ThriftField thriftField = ThriftField.read(readBuffer);
            if (thriftField.type == 0) {
                return;
            } else {
                skip(readBuffer, thriftField.type, i - 1);
            }
        }
    }

    static void writeListBegin(WriteBuffer writeBuffer, int i) {
        writeBuffer.writeByte(12);
        writeInt(writeBuffer, i);
    }

    static void writeLengthPrefixed(WriteBuffer writeBuffer, String str) {
        writeInt(writeBuffer, WriteBuffer.utf8SizeInBytes(str));
        writeBuffer.writeUtf8(str);
    }

    static void writeInt(WriteBuffer writeBuffer, int i) {
        writeBuffer.writeByte((byte) ((i >>> 24) & 255));
        writeBuffer.writeByte((byte) ((i >>> 16) & 255));
        writeBuffer.writeByte((byte) ((i >>> 8) & 255));
        writeBuffer.writeByte((byte) (i & 255));
    }

    static void writeLong(WriteBuffer writeBuffer, long j) {
        writeBuffer.writeByte((byte) ((j >>> 56) & 255));
        writeBuffer.writeByte((byte) ((j >>> 48) & 255));
        writeBuffer.writeByte((byte) ((j >>> 40) & 255));
        writeBuffer.writeByte((byte) ((j >>> 32) & 255));
        writeBuffer.writeByte((byte) ((j >>> 24) & 255));
        writeBuffer.writeByte((byte) ((j >>> 16) & 255));
        writeBuffer.writeByte((byte) ((j >>> 8) & 255));
        writeBuffer.writeByte((byte) (j & 255));
    }
}
