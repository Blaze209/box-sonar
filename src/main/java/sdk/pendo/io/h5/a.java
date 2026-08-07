package sdk.pendo.io.h5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    private static final Logger a = Logger.getLogger(a.class.getName());

    /* JADX INFO: renamed from: sdk.pendo.io.h5.a$a, reason: collision with other inner class name */
    public static class C0394a {
        public c a;
        public byte[][] b;
    }

    private static Object a(Object obj, List<byte[]> list) {
        Logger logger;
        Level level;
        if (obj == null) {
            return null;
        }
        String str = "An error occured while putting data to JSONObject";
        try {
            if (obj instanceof byte[]) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("_placeholder", true);
                jSONObject.put("num", list.size());
                list.add((byte[]) obj);
                return jSONObject;
            }
            if (!(obj instanceof JSONArray)) {
                if (!(obj instanceof JSONObject)) {
                    return obj;
                }
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = (JSONObject) obj;
                Iterator<String> itKeys = jSONObject3.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObject2.put(next, a(jSONObject3.get(next), list));
                }
                return jSONObject2;
            }
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = (JSONArray) obj;
            int length = jSONArray2.length();
            for (int i = 0; i < length; i++) {
                try {
                    jSONArray.put(i, a(jSONArray2.get(i), list));
                } catch (JSONException e) {
                    e = e;
                    logger = a;
                    level = Level.WARNING;
                    str = "An error occured while putting packet data to JSONObject";
                    logger.log(level, str, (Throwable) e);
                    return null;
                }
            }
            return jSONArray;
        } catch (JSONException e2) {
            e = e2;
            logger = a;
            level = Level.WARNING;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [org.json.JSONObject] */
    private static Object a(Object obj, byte[][] bArr) {
        Logger logger;
        Level level;
        String str;
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    jSONArray.put(i, a(jSONArray.get(i), bArr));
                } catch (JSONException e) {
                    e = e;
                    logger = a;
                    level = Level.WARNING;
                    str = "An error occured while putting packet data to JSONObject";
                }
            }
            return jSONArray;
        }
        if (obj instanceof JSONObject) {
            obj = (JSONObject) obj;
            if (obj.optBoolean("_placeholder")) {
                int iOptInt = obj.optInt("num", -1);
                if (iOptInt < 0 || iOptInt >= bArr.length) {
                    return null;
                }
                return bArr[iOptInt];
            }
            Iterator<String> itKeys = obj.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                try {
                    obj.put(next, a(obj.get(next), bArr));
                } catch (JSONException e2) {
                    e = e2;
                    logger = a;
                    level = Level.WARNING;
                    str = "An error occured while putting data to JSONObject";
                }
            }
        }
        return obj;
        logger.log(level, str, (Throwable) e);
        return null;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object] */
    public static C0394a a(c cVar) {
        ArrayList arrayList = new ArrayList();
        cVar.d = a(cVar.d, arrayList);
        cVar.e = arrayList.size();
        C0394a c0394a = new C0394a();
        c0394a.a = cVar;
        c0394a.b = (byte[][]) arrayList.toArray(new byte[arrayList.size()][]);
        return c0394a;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
    public static c a(c cVar, byte[][] bArr) {
        cVar.d = a(cVar.d, bArr);
        cVar.e = -1;
        return cVar;
    }
}
