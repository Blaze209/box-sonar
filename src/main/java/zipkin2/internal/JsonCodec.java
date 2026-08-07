package zipkin2.internal;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import zipkin2.internal.gson.stream.JsonToken;

/* JADX INFO: loaded from: classes6.dex */
public final class JsonCodec {
    static final Charset UTF_8 = Charset.forName("UTF-8");

    public interface JsonReaderAdapter<T> {
        T fromJson(JsonReader jsonReader) throws IOException;
    }

    public static final class JsonReader {
        final zipkin2.internal.gson.stream.JsonReader delegate;

        JsonReader(ReadBuffer readBuffer) {
            this.delegate = new zipkin2.internal.gson.stream.JsonReader(new InputStreamReader(readBuffer, JsonCodec.UTF_8));
        }

        public void beginArray() throws IOException {
            this.delegate.beginArray();
        }

        public boolean hasNext() throws IOException {
            return this.delegate.hasNext();
        }

        public void endArray() throws IOException {
            this.delegate.endArray();
        }

        public void beginObject() throws IOException {
            this.delegate.beginObject();
        }

        public void endObject() throws IOException {
            this.delegate.endObject();
        }

        public String nextName() throws IOException {
            return this.delegate.nextName();
        }

        public String nextString() throws IOException {
            return this.delegate.nextString();
        }

        public void skipValue() throws IOException {
            this.delegate.skipValue();
        }

        public long nextLong() throws IOException {
            return this.delegate.nextLong();
        }

        public String getPath() {
            return this.delegate.getPath();
        }

        public boolean nextBoolean() throws IOException {
            return this.delegate.nextBoolean();
        }

        public int nextInt() throws IOException {
            return this.delegate.nextInt();
        }

        public boolean peekString() throws IOException {
            return this.delegate.peek() == JsonToken.STRING;
        }

        public boolean peekBoolean() throws IOException {
            return this.delegate.peek() == JsonToken.BOOLEAN;
        }

        public boolean peekNull() throws IOException {
            return this.delegate.peek() == JsonToken.NULL;
        }

        public String toString() {
            return this.delegate.toString();
        }
    }

    public static <T> boolean read(JsonReaderAdapter<T> jsonReaderAdapter, ReadBuffer readBuffer, Collection<T> collection) {
        if (readBuffer.available() == 0) {
            return false;
        }
        try {
            collection.add(jsonReaderAdapter.fromJson(new JsonReader(readBuffer)));
            return true;
        } catch (Exception e) {
            throw exceptionReading(jsonReaderAdapter.toString(), e);
        }
    }

    @Nullable
    public static <T> T readOne(JsonReaderAdapter<T> jsonReaderAdapter, ReadBuffer readBuffer) {
        ArrayList arrayList = new ArrayList(1);
        if (read(jsonReaderAdapter, readBuffer, arrayList)) {
            return (T) arrayList.get(0);
        }
        return null;
    }

    public static <T> boolean readList(JsonReaderAdapter<T> jsonReaderAdapter, ReadBuffer readBuffer, Collection<T> collection) {
        if (readBuffer.available() == 0) {
            return false;
        }
        JsonReader jsonReader = new JsonReader(readBuffer);
        try {
            jsonReader.beginArray();
            if (!jsonReader.hasNext()) {
                return false;
            }
            while (jsonReader.hasNext()) {
                collection.add(jsonReaderAdapter.fromJson(jsonReader));
            }
            jsonReader.endArray();
            return true;
        } catch (Exception e) {
            throw exceptionReading("List<" + jsonReaderAdapter + SimpleComparison.GREATER_THAN_OPERATION, e);
        }
    }

    static <T> int sizeInBytes(WriteBuffer.Writer<T> writer, List<T> list) {
        int size = list.size();
        int iSizeInBytes = size > 1 ? size + 1 : 2;
        for (int i = 0; i < size; i++) {
            iSizeInBytes += writer.sizeInBytes(list.get(i));
        }
        return iSizeInBytes;
    }

    public static <T> byte[] write(WriteBuffer.Writer<T> writer, T t) {
        int iSizeInBytes = writer.sizeInBytes(t);
        byte[] bArr = new byte[iSizeInBytes];
        try {
            writer.write(t, WriteBuffer.wrap(bArr));
            return bArr;
        } catch (RuntimeException e) {
            int i = 0;
            while (i < iSizeInBytes) {
                if (bArr[i] == 0) {
                    AssertionError assertionError = new AssertionError(String.format("Bug found using %s to write %s as json. Wrote %s/%s bytes: %s", writer.getClass().getSimpleName(), t.getClass().getSimpleName(), Integer.valueOf(i), Integer.valueOf(iSizeInBytes), new String(bArr, 0, i, UTF_8)));
                    assertionError.initCause(e);
                    throw assertionError;
                }
                i++;
            }
            i = iSizeInBytes;
            AssertionError assertionError2 = new AssertionError(String.format("Bug found using %s to write %s as json. Wrote %s/%s bytes: %s", writer.getClass().getSimpleName(), t.getClass().getSimpleName(), Integer.valueOf(i), Integer.valueOf(iSizeInBytes), new String(bArr, 0, i, UTF_8)));
            assertionError2.initCause(e);
            throw assertionError2;
        }
    }

    public static <T> byte[] writeList(WriteBuffer.Writer<T> writer, List<T> list) {
        if (list.isEmpty()) {
            return new byte[]{91, 93};
        }
        byte[] bArr = new byte[sizeInBytes(writer, list)];
        writeList(writer, list, WriteBuffer.wrap(bArr));
        return bArr;
    }

    public static <T> int writeList(WriteBuffer.Writer<T> writer, List<T> list, byte[] bArr, int i) {
        if (list.isEmpty()) {
            bArr[i] = 91;
            bArr[i + 1] = 93;
            return 2;
        }
        WriteBuffer writeBufferWrap = WriteBuffer.wrap(bArr, i);
        writeList(writer, list, writeBufferWrap);
        return writeBufferWrap.pos() - i;
    }

    public static <T> void writeList(WriteBuffer.Writer<T> writer, List<T> list, WriteBuffer writeBuffer) {
        writeBuffer.writeByte(91);
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            writer.write(list.get(i), writeBuffer);
            if (i2 < size) {
                writeBuffer.writeByte(44);
            }
            i = i2;
        }
        writeBuffer.writeByte(93);
    }

    static IllegalArgumentException exceptionReading(String str, Exception exc) {
        String message = exc.getMessage() == null ? "Error" : exc.getMessage();
        if (message.indexOf("Expected BEGIN_OBJECT") != -1 || message.indexOf("malformed") != -1) {
            message = "Malformed";
        }
        throw new IllegalArgumentException(String.format("%s reading %s from json", message, str), exc);
    }
}
