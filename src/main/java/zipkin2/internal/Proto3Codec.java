package zipkin2.internal;

import java.util.Collection;
import java.util.List;
import zipkin2.Span;

/* JADX INFO: loaded from: classes6.dex */
public final class Proto3Codec {
    final Proto3SpanWriter writer = new Proto3SpanWriter();

    public int sizeInBytes(Span span) {
        return this.writer.sizeInBytes(span);
    }

    public byte[] write(Span span) {
        return this.writer.write(span);
    }

    public byte[] writeList(List<Span> list) {
        return this.writer.writeList(list);
    }

    public int writeList(List<Span> list, byte[] bArr, int i) {
        return this.writer.writeList(list, bArr, i);
    }

    public static boolean read(ReadBuffer readBuffer, Collection<Span> collection) {
        if (readBuffer.available() == 0) {
            return false;
        }
        try {
            Span span = Proto3ZipkinFields.SPAN.read(readBuffer);
            if (span == null) {
                return false;
            }
            collection.add(span);
            return true;
        } catch (RuntimeException e) {
            throw exceptionReading("Span", e);
        }
    }

    @Nullable
    public static Span readOne(ReadBuffer readBuffer) {
        try {
            return Proto3ZipkinFields.SPAN.read(readBuffer);
        } catch (RuntimeException e) {
            throw exceptionReading("Span", e);
        }
    }

    public static boolean readList(ReadBuffer readBuffer, Collection<Span> collection) {
        int iAvailable = readBuffer.available();
        if (iAvailable == 0) {
            return false;
        }
        while (readBuffer.pos() < iAvailable) {
            try {
                Span span = Proto3ZipkinFields.SPAN.read(readBuffer);
                if (span == null) {
                    return false;
                }
                collection.add(span);
            } catch (RuntimeException e) {
                throw exceptionReading("List<Span>", e);
            }
        }
        return true;
    }

    static IllegalArgumentException exceptionReading(String str, Exception exc) {
        String message = exc.getMessage() == null ? "Error" : exc.getMessage();
        if (message.indexOf("Malformed") != -1) {
            message = "Malformed";
        }
        throw new IllegalArgumentException(String.format("%s reading %s from proto3", message, str), exc);
    }
}
