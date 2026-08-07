package sdk.pendo.io.z4;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes6.dex */
public class b {
    private static final Logger a = Logger.getLogger(b.class.getName());
    private static final ConcurrentHashMap<String, c> b = new ConcurrentHashMap<>();
    public static int c = 4;

    public static class a extends c.o {
        public boolean A = true;
        public boolean z;
    }

    private b() {
    }

    public static e a(URI uri, a aVar) {
        c cVar;
        String str;
        if (aVar == null) {
            aVar = new a();
        }
        URL urlA = g.a(uri);
        try {
            URI uri2 = urlA.toURI();
            String strA = g.a(urlA);
            String path = urlA.getPath();
            ConcurrentHashMap<String, c> concurrentHashMap = b;
            boolean z = concurrentHashMap.containsKey(strA) && concurrentHashMap.get(strA).v.containsKey(path);
            if (aVar.z || !aVar.A || z) {
                Logger logger = a;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(String.format("ignoring socket cache for %s", uri2));
                }
                cVar = new c(uri2, aVar);
            } else {
                if (!concurrentHashMap.containsKey(strA)) {
                    Logger logger2 = a;
                    if (logger2.isLoggable(Level.FINE)) {
                        logger2.fine(String.format("new io instance for %s", uri2));
                    }
                    concurrentHashMap.putIfAbsent(strA, new c(uri2, aVar));
                }
                cVar = concurrentHashMap.get(strA);
            }
            String query = urlA.getQuery();
            if (query != null && ((str = aVar.p) == null || str.isEmpty())) {
                aVar.p = query;
            }
            return cVar.a(urlA.getPath(), aVar);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
