package sdk.pendo.io.g5;

import com.j256.ormlite.stmt.query.SimpleComparison;
import com.microsoft.identity.client.internal.MsalUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    public static Map<String, String> a(String str) {
        HashMap map = new HashMap();
        for (String str2 : str.split(MsalUtils.QUERY_STRING_DELIMITER)) {
            String[] strArrSplit = str2.split(SimpleComparison.EQUAL_TO_OPERATION);
            map.put(sdk.pendo.io.e5.a.a(strArrSplit[0]), strArrSplit.length > 1 ? sdk.pendo.io.e5.a.a(strArrSplit[1]) : "");
        }
        return map;
    }

    public static String a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append(MsalUtils.QUERY_STRING_DELIMITER);
            }
            sb.append(sdk.pendo.io.e5.a.b(entry.getKey())).append(SimpleComparison.EQUAL_TO_OPERATION).append(sdk.pendo.io.e5.a.b(entry.getValue()));
        }
        return sb.toString();
    }
}
