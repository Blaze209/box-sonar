package sdk.pendo.io.x4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import sdk.pendo.io.v4.ILoggerFactory;

/* JADX INFO: loaded from: classes6.dex */
public class f implements ILoggerFactory {
    boolean a = false;
    final Map<String, e> b = new HashMap();
    final LinkedBlockingQueue<sdk.pendo.io.w4.d> c = new LinkedBlockingQueue<>();

    public void a() {
        this.b.clear();
        this.c.clear();
    }

    public LinkedBlockingQueue<sdk.pendo.io.w4.d> b() {
        return this.c;
    }

    public List<e> c() {
        return new ArrayList(this.b.values());
    }

    public void d() {
        this.a = true;
    }

    @Override // sdk.pendo.io.v4.ILoggerFactory
    public synchronized sdk.pendo.io.v4.a a(String str) {
        e eVar;
        eVar = this.b.get(str);
        if (eVar == null) {
            eVar = new e(str, this.c, this.a);
            this.b.put(str, eVar);
        }
        return eVar;
    }
}
