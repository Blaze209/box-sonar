package retrofit2.converter.moshi;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import java.io.IOException;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.ByteString;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes5.dex */
final class MoshiResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private static final ByteString UTF8_BOM = ByteString.decodeHex("EFBBBF");
    private final JsonAdapter<T> adapter;

    MoshiResponseBodyConverter(JsonAdapter<T> jsonAdapter) {
        this.adapter = jsonAdapter;
    }

    @Override // retrofit2.Converter
    public T convert(ResponseBody responseBody) throws IOException {
        BufferedSource source = responseBody.getSource();
        try {
            ByteString byteString = UTF8_BOM;
            if (source.rangeEquals(0L, byteString)) {
                source.skip(byteString.size());
            }
            JsonReader jsonReaderOf = JsonReader.of(source);
            T tFromJson = this.adapter.fromJson(jsonReaderOf);
            if (jsonReaderOf.peek() != JsonReader.Token.END_DOCUMENT) {
                throw new JsonDataException("JSON document was not fully consumed.");
            }
            responseBody.close();
            return tFromJson;
        } catch (Throwable th) {
            responseBody.close();
            throw th;
        }
    }
}
