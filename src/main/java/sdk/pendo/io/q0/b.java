package sdk.pendo.io.q0;

import java.security.Security;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class b {
    private static sdk.pendo.io.v4.a a = sdk.pendo.io.v4.b.a((Class<?>) b.class);

    public static boolean a(String str, String str2) {
        Set<String> algorithms = Security.getAlgorithms(str);
        Iterator<String> it = algorithms.iterator();
        while (it.hasNext()) {
            if (it.next().equalsIgnoreCase(str2)) {
                return true;
            }
        }
        a.a("{} is NOT available for {}. Algorithms available from underlying JCE: {}", str2, str, algorithms);
        return false;
    }
}
