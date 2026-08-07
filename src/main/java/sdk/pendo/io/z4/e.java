package sdk.pendo.io.z4;

import com.box.androidsdk.content.models.BoxSimpleMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.hc.core5.http.HeaderElements;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class e extends sdk.pendo.io.a5.a {
    private static final Logger l = Logger.getLogger(e.class.getName());
    protected static final Map<String, Integer> m = new a();
    String b;
    private volatile boolean c;
    private int d;
    private String e;
    private sdk.pendo.io.z4.c f;
    private String g;
    private Queue<sdk.pendo.io.z4.d.b> i;
    private Map<Integer, sdk.pendo.io.z4.a> h = new HashMap();
    private final Queue<List<Object>> j = new LinkedList();
    private final Queue<sdk.pendo.io.h5.c<JSONArray>> k = new LinkedList();

    class a extends HashMap<String, Integer> {
        a() {
            put("connect", 1);
            put("connect_error", 1);
            put("connect_timeout", 1);
            put("connecting", 1);
            put("disconnect", 1);
            put("error", 1);
            put(BoxSimpleMessage.MESSAGE_RECONNECT, 1);
            put("reconnect_attempt", 1);
            put("reconnect_failed", 1);
            put("reconnect_error", 1);
            put("reconnecting", 1);
            put("ping", 1);
            put("pong", 1);
        }
    }

    class b extends LinkedList<sdk.pendo.io.z4.d.b> {
        final /* synthetic */ sdk.pendo.io.z4.c a;

        class a implements sdk.pendo.io.a5.a.InterfaceC0343a {
            a() {
            }

            @Override // sdk.pendo.io.a5.a.InterfaceC0343a
            public void call(Object... objArr) {
                e.this.i();
            }
        }

        /* JADX INFO: renamed from: sdk.pendo.io.z4.e$b$b, reason: collision with other inner class name */
        class C0548b implements sdk.pendo.io.a5.a.InterfaceC0343a {
            C0548b() {
            }

            @Override // sdk.pendo.io.a5.a.InterfaceC0343a
            public void call(Object... objArr) {
                e.this.c((sdk.pendo.io.h5.c) objArr[0]);
            }
        }

        class c implements sdk.pendo.io.a5.a.InterfaceC0343a {
            c() {
            }

            @Override // sdk.pendo.io.a5.a.InterfaceC0343a
            public void call(Object... objArr) {
                e.this.b(objArr.length > 0 ? (String) objArr[0] : null);
            }
        }

        b(sdk.pendo.io.z4.c cVar) {
            this.a = cVar;
            add(sdk.pendo.io.z4.d.a(cVar, "open", new a()));
            add(sdk.pendo.io.z4.d.a(cVar, "packet", new C0548b()));
            add(sdk.pendo.io.z4.d.a(cVar, HeaderElements.CLOSE, new c()));
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.c) {
                return;
            }
            e.this.k();
            e.this.f.i();
            sdk.pendo.io.z4.c.p pVar = sdk.pendo.io.z4.c.p.OPEN;
            e eVar = e.this;
            if (pVar == eVar.f.b) {
                eVar.i();
            }
            e.this.a("connecting", new Object[0]);
        }
    }

    class d implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ Object[] b;

        d(String str, Object[] objArr) {
            this.a = str;
            this.b = objArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            sdk.pendo.io.z4.a aVar;
            if (e.m.containsKey(this.a)) {
                e.super.a(this.a, this.b);
                return;
            }
            Object[] objArr = this.b;
            int length = objArr.length - 1;
            if (objArr.length <= 0 || !(objArr[length] instanceof sdk.pendo.io.z4.a)) {
                aVar = null;
            } else {
                objArr = new Object[length];
                for (int i = 0; i < length; i++) {
                    objArr[i] = this.b[i];
                }
                aVar = (sdk.pendo.io.z4.a) this.b[length];
            }
            e.this.a(this.a, objArr, aVar);
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.z4.e$e, reason: collision with other inner class name */
    class RunnableC0549e implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ Object[] b;
        final /* synthetic */ sdk.pendo.io.z4.a c;

        RunnableC0549e(String str, Object[] objArr, sdk.pendo.io.z4.a aVar) {
            this.a = str;
            this.b = objArr;
            this.c = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.a);
            Object[] objArr = this.b;
            if (objArr != null) {
                for (Object obj : objArr) {
                    jSONArray.put(obj);
                }
            }
            sdk.pendo.io.h5.c cVar = new sdk.pendo.io.h5.c(2, jSONArray);
            if (this.c != null) {
                e.l.fine(String.format(Locale.US, "emitting packet with ack id %d", Integer.valueOf(e.this.d)));
                e eVar = e.this;
                eVar.h.put(Integer.valueOf(eVar.d), this.c);
                e eVar2 = e.this;
                int i = eVar2.d;
                eVar2.d = i + 1;
                cVar.b = i;
            }
            boolean z = e.this.c;
            e eVar3 = e.this;
            if (z) {
                eVar3.d(cVar);
            } else {
                eVar3.k.add(cVar);
            }
        }
    }

    class f implements sdk.pendo.io.z4.a {
        final /* synthetic */ boolean[] a;
        final /* synthetic */ int b;
        final /* synthetic */ e c;

        class a implements Runnable {
            final /* synthetic */ Object[] a;

            a(Object[] objArr) {
                this.a = objArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean[] zArr = f.this.a;
                if (zArr[0]) {
                    return;
                }
                zArr[0] = true;
                Logger logger = e.l;
                if (logger.isLoggable(Level.FINE)) {
                    Object[] objArr = this.a;
                    if (objArr.length == 0) {
                        objArr = null;
                    }
                    logger.fine(String.format("sending ack %s", objArr));
                }
                JSONArray jSONArray = new JSONArray();
                for (Object obj : this.a) {
                    jSONArray.put(obj);
                }
                sdk.pendo.io.h5.c cVar = new sdk.pendo.io.h5.c(3, jSONArray);
                f fVar = f.this;
                cVar.b = fVar.b;
                fVar.c.d(cVar);
            }
        }

        f(boolean[] zArr, int i, e eVar) {
            this.a = zArr;
            this.b = i;
            this.c = eVar;
        }

        @Override // sdk.pendo.io.z4.a
        public void call(Object... objArr) {
            sdk.pendo.io.i5.a.a(new a(objArr));
        }
    }

    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.c) {
                Logger logger = e.l;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(String.format("performing disconnect (%s)", e.this.e));
                }
                e.this.d(new sdk.pendo.io.h5.c(1));
            }
            e.this.d();
            if (e.this.c) {
                e.this.b("io client disconnect");
            }
        }
    }

    public e(sdk.pendo.io.z4.c cVar, String str, sdk.pendo.io.z4.c.o oVar) {
        this.f = cVar;
        this.e = str;
        if (oVar != null) {
            this.g = oVar.p;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Queue<sdk.pendo.io.z4.d.b> queue = this.i;
        if (queue != null) {
            Iterator<sdk.pendo.io.z4.d.b> it = queue.iterator();
            while (it.hasNext()) {
                it.next().destroy();
            }
            this.i = null;
        }
        this.f.a(this);
    }

    private void f() {
        while (true) {
            List<Object> listPoll = this.j.poll();
            if (listPoll == null) {
                break;
            } else {
                super.a((String) listPoll.get(0), listPoll.toArray());
            }
        }
        this.j.clear();
        while (true) {
            sdk.pendo.io.h5.c<JSONArray> cVarPoll = this.k.poll();
            if (cVarPoll == null) {
                this.k.clear();
                return;
            }
            d(cVarPoll);
        }
    }

    private void g() {
        this.c = true;
        a("connect", new Object[0]);
        f();
    }

    private void h() {
        Logger logger = l;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format("server disconnect (%s)", this.e));
        }
        d();
        b("io server disconnect");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        sdk.pendo.io.h5.c cVar;
        l.fine("transport is open - connecting");
        if ("/".equals(this.e)) {
            return;
        }
        String str = this.g;
        if (str == null || str.isEmpty()) {
            cVar = new sdk.pendo.io.h5.c(0);
        } else {
            cVar = new sdk.pendo.io.h5.c(0);
            cVar.f = this.g;
        }
        d(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.i != null) {
            return;
        }
        this.i = new b(this.f);
    }

    public e b() {
        sdk.pendo.io.i5.a.a(new g());
        return this;
    }

    public e c() {
        return j();
    }

    public e e() {
        return b();
    }

    public e j() {
        sdk.pendo.io.i5.a.a(new c());
        return this;
    }

    private sdk.pendo.io.z4.a a(int i) {
        return new f(new boolean[]{false}, i, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        Logger logger = l;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format("close (%s)", str));
        }
        this.c = false;
        this.b = null;
        a("disconnect", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(sdk.pendo.io.h5.c<?> cVar) {
        if (this.e.equals(cVar.c)) {
            switch (cVar.a) {
                case 0:
                    g();
                    break;
                case 1:
                    h();
                    break;
                case 2:
                case 5:
                    b((sdk.pendo.io.h5.c<JSONArray>) cVar);
                    break;
                case 3:
                case 6:
                    a((sdk.pendo.io.h5.c<JSONArray>) cVar);
                    break;
                case 4:
                    a("error", cVar.d);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(sdk.pendo.io.h5.c cVar) {
        cVar.c = this.e;
        this.f.b(cVar);
    }

    private void b(sdk.pendo.io.h5.c<JSONArray> cVar) {
        ArrayList arrayList = new ArrayList(Arrays.asList(a(cVar.d)));
        Logger logger = l;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format("emitting event %s", arrayList));
        }
        if (cVar.b >= 0) {
            logger.fine("attaching ack callback to event");
            arrayList.add(a(cVar.b));
        }
        if (!this.c) {
            this.j.add(arrayList);
        } else {
            if (arrayList.isEmpty()) {
                return;
            }
            super.a(arrayList.remove(0).toString(), arrayList.toArray());
        }
    }

    @Override // sdk.pendo.io.a5.a
    public sdk.pendo.io.a5.a a(String str, Object... objArr) {
        sdk.pendo.io.i5.a.a(new d(str, objArr));
        return this;
    }

    public sdk.pendo.io.a5.a a(String str, Object[] objArr, sdk.pendo.io.z4.a aVar) {
        sdk.pendo.io.i5.a.a(new RunnableC0549e(str, objArr, aVar));
        return this;
    }

    private void a(sdk.pendo.io.h5.c<JSONArray> cVar) {
        sdk.pendo.io.z4.a aVarRemove = this.h.remove(Integer.valueOf(cVar.b));
        if (aVarRemove != null) {
            Logger logger = l;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(String.format("calling ack %s with %s", Integer.valueOf(cVar.b), cVar.d));
            }
            aVarRemove.call(a(cVar.d));
            return;
        }
        Logger logger2 = l;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(String.format("bad ack %s", Integer.valueOf(cVar.b)));
        }
    }

    private static Object[] a(JSONArray jSONArray) {
        Object obj;
        int length = jSONArray.length();
        Object[] objArr = new Object[length];
        for (int i = 0; i < length; i++) {
            Object obj2 = null;
            try {
                obj = jSONArray.get(i);
            } catch (JSONException e) {
                l.log(Level.WARNING, "An error occured while retrieving data from JSONArray", (Throwable) e);
                obj = null;
            }
            if (!JSONObject.NULL.equals(obj)) {
                obj2 = obj;
            }
            objArr[i] = obj2;
        }
        return objArr;
    }
}
