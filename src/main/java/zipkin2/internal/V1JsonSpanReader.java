package zipkin2.internal;

import io.split.android.client.service.ServiceConstants;
import java.io.IOException;
import java.util.Collection;
import sdk.pendo.io.events.IdentificationData;
import zipkin2.Endpoint;
import zipkin2.Span;
import zipkin2.v1.V1Span;
import zipkin2.v1.V1SpanConverter;

/* JADX INFO: loaded from: classes6.dex */
public final class V1JsonSpanReader implements JsonCodec.JsonReaderAdapter<V1Span> {
    V1Span.Builder builder;

    public boolean readList(ReadBuffer readBuffer, Collection<Span> collection) {
        if (readBuffer.available() == 0) {
            return false;
        }
        V1SpanConverter v1SpanConverterCreate = V1SpanConverter.create();
        JsonCodec.JsonReader jsonReader = new JsonCodec.JsonReader(readBuffer);
        try {
            jsonReader.beginArray();
            if (!jsonReader.hasNext()) {
                return false;
            }
            while (jsonReader.hasNext()) {
                v1SpanConverterCreate.convert(fromJson(jsonReader), collection);
            }
            jsonReader.endArray();
            return true;
        } catch (Exception e) {
            throw JsonCodec.exceptionReading("List<Span>", e);
        }
    }

    @Override // zipkin2.internal.JsonCodec.JsonReaderAdapter
    public V1Span fromJson(JsonCodec.JsonReader jsonReader) throws IOException {
        V1Span.Builder builder = this.builder;
        if (builder == null) {
            this.builder = V1Span.newBuilder();
        } else {
            builder.clear();
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if (strNextName.equals("traceId")) {
                this.builder.traceId(jsonReader.nextString());
            } else if (strNextName.equals("id")) {
                this.builder.id(jsonReader.nextString());
            } else if (jsonReader.peekNull()) {
                jsonReader.skipValue();
            } else if (strNextName.equals("name")) {
                this.builder.name(jsonReader.nextString());
            } else if (strNextName.equals(IdentificationData.FIELD_PARENT_ID)) {
                this.builder.parentId(jsonReader.nextString());
            } else if (strNextName.equals("timestamp")) {
                this.builder.timestamp(jsonReader.nextLong());
            } else if (strNextName.equals("duration")) {
                this.builder.duration(jsonReader.nextLong());
            } else if (strNextName.equals("annotations")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    readAnnotation(jsonReader);
                }
                jsonReader.endArray();
            } else if (strNextName.equals("binaryAnnotations")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    readBinaryAnnotation(jsonReader);
                }
                jsonReader.endArray();
            } else if (strNextName.equals("debug")) {
                if (jsonReader.nextBoolean()) {
                    this.builder.debug(true);
                }
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return this.builder.build();
    }

    void readAnnotation(JsonCodec.JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        Long lValueOf = null;
        String strNextString = null;
        Endpoint endpointFromJson = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if (strNextName.equals("timestamp")) {
                lValueOf = Long.valueOf(jsonReader.nextLong());
            } else if (strNextName.equals("value")) {
                strNextString = jsonReader.nextString();
            } else if (strNextName.equals(ServiceConstants.WORKER_PARAM_ENDPOINT) && !jsonReader.peekNull()) {
                endpointFromJson = V2SpanReader.ENDPOINT_READER.fromJson(jsonReader);
            } else {
                jsonReader.skipValue();
            }
        }
        if (lValueOf == null || strNextString == null) {
            throw new IllegalArgumentException("Incomplete annotation at " + jsonReader.getPath());
        }
        jsonReader.endObject();
        this.builder.addAnnotation(lValueOf.longValue(), strNextString, endpointFromJson);
    }

    public String toString() {
        return "Span";
    }

    void readBinaryAnnotation(JsonCodec.JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        String strNextString = null;
        String strNextString2 = null;
        Boolean boolValueOf = null;
        Endpoint endpointFromJson = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if (jsonReader.peekNull()) {
                jsonReader.skipValue();
            } else if (strNextName.equals("key")) {
                strNextString = jsonReader.nextString();
            } else if (strNextName.equals("value")) {
                if (jsonReader.peekString()) {
                    strNextString2 = jsonReader.nextString();
                } else if (jsonReader.peekBoolean()) {
                    boolValueOf = Boolean.valueOf(jsonReader.nextBoolean());
                } else {
                    jsonReader.skipValue();
                }
            } else if (strNextName.equals(ServiceConstants.WORKER_PARAM_ENDPOINT)) {
                endpointFromJson = V2SpanReader.ENDPOINT_READER.fromJson(jsonReader);
            } else {
                jsonReader.skipValue();
            }
        }
        if (strNextString == null) {
            throw new IllegalArgumentException("No key at " + jsonReader.getPath());
        }
        jsonReader.endObject();
        if (strNextString2 != null) {
            this.builder.addBinaryAnnotation(strNextString, strNextString2, endpointFromJson);
            return;
        }
        if (boolValueOf == null || !boolValueOf.booleanValue() || endpointFromJson == null) {
            return;
        }
        if (strNextString.equals("sa") || strNextString.equals("ca") || strNextString.equals("ma")) {
            this.builder.addBinaryAnnotation(strNextString, endpointFromJson);
        }
    }
}
