package org.jose4j.json;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jose4j.json.internal.json_simple.JSONValue;
import org.jose4j.json.internal.json_simple.parser.ContainerFactory;
import org.jose4j.json.internal.json_simple.parser.JSONParser;
import org.jose4j.json.internal.json_simple.parser.ParseException;
import org.jose4j.lang.JoseException;

/* JADX INFO: loaded from: classes5.dex */
public class JsonUtil {
    private static final ContainerFactory CONTAINER_FACTORY = new ContainerFactory() { // from class: org.jose4j.json.JsonUtil.1
        @Override // org.jose4j.json.internal.json_simple.parser.ContainerFactory
        public List creatArrayContainer() {
            return new ArrayList();
        }

        @Override // org.jose4j.json.internal.json_simple.parser.ContainerFactory
        public Map createObjectContainer() {
            return new DupeKeyDisallowingLinkedHashMap();
        }
    };

    public static Map<String, Object> parseJson(String str) throws JoseException {
        try {
            Object obj = new JSONParser().parse(str, CONTAINER_FACTORY);
            if (obj == null) {
                throw new JoseException("Parsing returned null");
            }
            return (Map) obj;
        } catch (ClassCastException e) {
            throw new JoseException("Expecting a JSON object at the root but " + e, e);
        } catch (IllegalArgumentException | ParseException e2) {
            throw new JoseException("Parsing error: " + e2, e2);
        }
    }

    public static String toJson(Map<String, ?> map) {
        return JSONValue.toJSONString(map);
    }

    public static void writeJson(Map<String, ?> map, Writer writer) throws IOException {
        JSONValue.writeJSONString(map, writer);
    }

    static class DupeKeyDisallowingLinkedHashMap extends LinkedHashMap<String, Object> {
        DupeKeyDisallowingLinkedHashMap() {
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public Object put(String str, Object obj) {
            if (containsKey(str)) {
                throw new IllegalArgumentException("An entry for '" + str + "' already exists. Names must be unique.");
            }
            return super.put(str, obj);
        }
    }
}
