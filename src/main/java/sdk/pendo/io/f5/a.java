package sdk.pendo.io.f5;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    private static final Logger a = Logger.getLogger(a.class.getName());

    private a() {
    }

    private static boolean a(Object obj) {
        Logger logger;
        Level level;
        String str;
        if (obj == null) {
            return false;
        }
        if (obj instanceof byte[]) {
            return true;
        }
        if (!(obj instanceof JSONArray)) {
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    try {
                        if (a(jSONObject.get(itKeys.next()))) {
                            return true;
                        }
                    } catch (JSONException e) {
                        e = e;
                        logger = a;
                        level = Level.WARNING;
                        str = "An error occured while retrieving data from JSONObject";
                        logger.log(level, str, (Throwable) e);
                        return false;
                    }
                }
            }
            return false;
        }
        JSONArray jSONArray = (JSONArray) obj;
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            try {
                if (a(jSONArray.isNull(i) ? null : jSONArray.get(i))) {
                    return true;
                }
            } catch (JSONException e2) {
                e = e2;
                logger = a;
                level = Level.WARNING;
                str = "An error occured while retrieving data from JSONArray";
                logger.log(level, str, (Throwable) e);
                return false;
            }
        }
        return false;
    }

    public static boolean b(Object obj) {
        return a(obj);
    }
}
