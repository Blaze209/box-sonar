package zipkin2.internal;

import java.io.IOException;
import sdk.pendo.io.events.IdentificationData;
import zipkin2.Endpoint;
import zipkin2.Span;

/* JADX INFO: loaded from: classes6.dex */
public final class V2SpanReader implements JsonCodec.JsonReaderAdapter<Span> {
    static final JsonCodec.JsonReaderAdapter<Endpoint> ENDPOINT_READER = new JsonCodec.JsonReaderAdapter<Endpoint>() { // from class: zipkin2.internal.V2SpanReader.1
        @Override // zipkin2.internal.JsonCodec.JsonReaderAdapter
        public Endpoint fromJson(JsonCodec.JsonReader jsonReader) throws IOException {
            Endpoint.Builder builderNewBuilder = Endpoint.newBuilder();
            jsonReader.beginObject();
            boolean z = false;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (jsonReader.peekNull()) {
                    jsonReader.skipValue();
                } else {
                    if (strNextName.equals("serviceName")) {
                        builderNewBuilder.serviceName(jsonReader.nextString());
                    } else if (strNextName.equals("ipv4") || strNextName.equals("ipv6")) {
                        builderNewBuilder.parseIp(jsonReader.nextString());
                    } else if (strNextName.equals("port")) {
                        builderNewBuilder.port(jsonReader.nextInt());
                    } else {
                        jsonReader.skipValue();
                    }
                    z = true;
                }
            }
            jsonReader.endObject();
            if (z) {
                return builderNewBuilder.build();
            }
            return null;
        }

        public String toString() {
            return "Endpoint";
        }
    };
    Span.Builder builder;

    @Override // zipkin2.internal.JsonCodec.JsonReaderAdapter
    public Span fromJson(JsonCodec.JsonReader jsonReader) throws IOException {
        Span.Builder builder = this.builder;
        if (builder == null) {
            this.builder = Span.newBuilder();
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
            } else if (strNextName.equals(IdentificationData.FIELD_PARENT_ID)) {
                this.builder.parentId(jsonReader.nextString());
            } else if (strNextName.equals("kind")) {
                this.builder.kind(Span.Kind.valueOf(jsonReader.nextString()));
            } else if (strNextName.equals("name")) {
                this.builder.name(jsonReader.nextString());
            } else if (strNextName.equals("timestamp")) {
                this.builder.timestamp(jsonReader.nextLong());
            } else if (strNextName.equals("duration")) {
                this.builder.duration(jsonReader.nextLong());
            } else if (strNextName.equals("localEndpoint")) {
                this.builder.localEndpoint(ENDPOINT_READER.fromJson(jsonReader));
            } else if (strNextName.equals("remoteEndpoint")) {
                this.builder.remoteEndpoint(ENDPOINT_READER.fromJson(jsonReader));
            } else if (strNextName.equals("annotations")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginObject();
                    Long lValueOf = null;
                    String strNextString = null;
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        if (strNextName2.equals("timestamp")) {
                            lValueOf = Long.valueOf(jsonReader.nextLong());
                        } else if (strNextName2.equals("value")) {
                            strNextString = jsonReader.nextString();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    if (lValueOf == null || strNextString == null) {
                        throw new IllegalArgumentException("Incomplete annotation at " + jsonReader.getPath());
                    }
                    jsonReader.endObject();
                    this.builder.addAnnotation(lValueOf.longValue(), strNextString);
                }
                jsonReader.endArray();
            } else if (strNextName.equals("tags")) {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName3 = jsonReader.nextName();
                    if (jsonReader.peekNull()) {
                        throw new IllegalArgumentException("No value at " + jsonReader.getPath());
                    }
                    this.builder.putTag(strNextName3, jsonReader.nextString());
                }
                jsonReader.endObject();
            } else if (strNextName.equals("debug")) {
                if (jsonReader.nextBoolean()) {
                    this.builder.debug(true);
                }
            } else if (strNextName.equals("shared")) {
                if (jsonReader.nextBoolean()) {
                    this.builder.shared(true);
                }
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return this.builder.build();
    }

    public String toString() {
        return "Span";
    }
}
