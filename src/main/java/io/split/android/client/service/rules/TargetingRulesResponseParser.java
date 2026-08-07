package io.split.android.client.service.rules;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import io.split.android.client.dtos.SplitChange;
import io.split.android.client.dtos.TargetingRulesChange;
import io.split.android.client.service.http.HttpResponseParser;
import io.split.android.client.service.http.HttpResponseParserException;
import io.split.android.client.utils.Json;
import java.io.StringReader;

/* JADX INFO: loaded from: classes4.dex */
public class TargetingRulesResponseParser implements HttpResponseParser<TargetingRulesChange> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.split.android.client.service.http.HttpResponseParser
    public TargetingRulesChange parse(String responseData) throws HttpResponseParserException {
        if (responseData != null) {
            try {
                if (!responseData.isEmpty()) {
                    if (isNewDto(responseData)) {
                        return (TargetingRulesChange) Json.fromJson(responseData, TargetingRulesChange.class);
                    }
                    SplitChange splitChange = (SplitChange) Json.fromJson(responseData, SplitChange.class);
                    if (splitChange == null) {
                        return null;
                    }
                    return TargetingRulesChange.create(splitChange);
                }
            } catch (Exception e) {
                throw new HttpResponseParserException("Error parsing splitChanges http response: " + e.getLocalizedMessage());
            }
        }
        return null;
    }

    private boolean isNewDto(String json) throws Exception {
        JsonReader jsonReader = new JsonReader(new StringReader(json));
        try {
            jsonReader.setLenient(true);
            if (jsonReader.peek() == JsonToken.BEGIN_OBJECT) {
                jsonReader.beginObject();
                if (jsonReader.hasNext()) {
                    if (!newFieldNameIsPresent(jsonReader.nextName())) {
                        jsonReader.skipValue();
                        while (jsonReader.hasNext()) {
                            if (!newFieldNameIsPresent(jsonReader.nextName())) {
                                jsonReader.skipValue();
                            } else {
                                jsonReader.close();
                                return true;
                            }
                        }
                    } else {
                        jsonReader.close();
                        return true;
                    }
                }
                jsonReader.close();
                return false;
            }
            throw new HttpResponseParserException("Error parsing splitChanges http response: not a JSON object");
        } catch (Throwable th) {
            try {
                jsonReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static boolean newFieldNameIsPresent(String name) {
        return "ff".equals(name) || "rbs".equals(name);
    }
}
