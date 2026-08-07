package com.nimbusds.jose.util;

import com.nimbusds.jose.shaded.gson.Gson;
import com.nimbusds.jose.shaded.gson.GsonBuilder;
import com.nimbusds.jose.shaded.gson.Strictness;
import com.nimbusds.jose.shaded.gson.ToNumberPolicy;
import com.nimbusds.jose.shaded.gson.reflect.TypeToken;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class JSONArrayUtils {
    private static final Gson GSON = new GsonBuilder().setStrictness(Strictness.STRICT).serializeNulls().setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE).disableHtmlEscaping().create();

    public static List<Object> parse(String str) throws ParseException {
        if (str == null) {
            throw new ParseException("The JSON array string must not be null", 0);
        }
        if (str.trim().isEmpty()) {
            throw new ParseException("Invalid JSON array", 0);
        }
        try {
            return (List) GSON.fromJson(str, TypeToken.getParameterized(List.class, Object.class).getType());
        } catch (Exception unused) {
            throw new ParseException("Invalid JSON array", 0);
        } catch (StackOverflowError unused2) {
            throw new ParseException("Excessive JSON object and / or array nesting", 0);
        }
    }

    public static String toJSONString(List<?> list) {
        return GSON.toJson(Objects.requireNonNull(list));
    }

    public static List<Object> newJSONArray() {
        return new ArrayList();
    }

    private JSONArrayUtils() {
    }
}
