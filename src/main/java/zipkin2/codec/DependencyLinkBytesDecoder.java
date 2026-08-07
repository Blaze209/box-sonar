package zipkin2.codec;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import zipkin2.DependencyLink;
import zipkin2.internal.JsonCodec;
import zipkin2.internal.Nullable;
import zipkin2.internal.ReadBuffer;

/* JADX INFO: loaded from: classes6.dex */
public enum DependencyLinkBytesDecoder implements BytesDecoder<DependencyLink> {
    JSON_V1 { // from class: zipkin2.codec.DependencyLinkBytesDecoder.1
        @Override // zipkin2.codec.BytesDecoder
        public Encoding encoding() {
            return Encoding.JSON;
        }

        @Override // zipkin2.codec.BytesDecoder
        public boolean decode(byte[] bArr, Collection<DependencyLink> collection) {
            return JsonCodec.read(READER, ReadBuffer.wrap(bArr), collection);
        }

        @Override // zipkin2.codec.BytesDecoder
        @Nullable
        public DependencyLink decodeOne(byte[] bArr) {
            return (DependencyLink) JsonCodec.readOne(READER, ReadBuffer.wrap(bArr));
        }

        @Override // zipkin2.codec.BytesDecoder
        public boolean decodeList(byte[] bArr, Collection<DependencyLink> collection) {
            return JsonCodec.readList(READER, ReadBuffer.wrap(bArr), collection);
        }

        @Override // zipkin2.codec.BytesDecoder
        public List<DependencyLink> decodeList(byte[] bArr) {
            ArrayList arrayList = new ArrayList();
            decodeList(bArr, arrayList);
            return arrayList;
        }
    };

    static final JsonCodec.JsonReaderAdapter<DependencyLink> READER = new JsonCodec.JsonReaderAdapter<DependencyLink>() { // from class: zipkin2.codec.DependencyLinkBytesDecoder.2
        @Override // zipkin2.internal.JsonCodec.JsonReaderAdapter
        public DependencyLink fromJson(JsonCodec.JsonReader jsonReader) throws IOException {
            DependencyLink.Builder builderNewBuilder = DependencyLink.newBuilder();
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (strNextName.equals("parent")) {
                    builderNewBuilder.parent(jsonReader.nextString());
                } else if (strNextName.equals("child")) {
                    builderNewBuilder.child(jsonReader.nextString());
                } else if (strNextName.equals("callCount")) {
                    builderNewBuilder.callCount(jsonReader.nextLong());
                } else if (strNextName.equals("errorCount")) {
                    builderNewBuilder.errorCount(jsonReader.nextLong());
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            return builderNewBuilder.build();
        }

        public String toString() {
            return "DependencyLink";
        }
    };
}
