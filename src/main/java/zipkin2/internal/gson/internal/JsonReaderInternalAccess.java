package zipkin2.internal.gson.internal;

import java.io.IOException;
import zipkin2.internal.gson.stream.JsonReader;

/* JADX INFO: loaded from: classes6.dex */
public abstract class JsonReaderInternalAccess {
    public static JsonReaderInternalAccess INSTANCE;

    public abstract void promoteNameToValue(JsonReader jsonReader) throws IOException;
}
