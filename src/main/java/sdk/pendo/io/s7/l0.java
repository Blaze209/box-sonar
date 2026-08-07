package sdk.pendo.io.s7;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public class l0 {
    private static int f;
    private static final Object a = new Object();
    private static final Object b = new Object();
    private static final Object c = new Object();
    private static final Object d = new Object();
    private static final Object e = new Object();
    private static sdk.pendo.io.j4.a<Boolean> g = sdk.pendo.io.j4.a.b(Boolean.FALSE);
    private static AtomicBoolean h = new AtomicBoolean(false);
    private static sdk.pendo.io.k3.j<Long> i = null;
    private static sdk.pendo.io.o3.b j = null;

    class a implements sdk.pendo.io.q3.e<sdk.pendo.io.w6.b.c> {

        /* JADX INFO: renamed from: sdk.pendo.io.s7.l0$a$a, reason: collision with other inner class name */
        class C0482a implements sdk.pendo.io.q3.e<Long> {
            C0482a() {
            }

            @Override // sdk.pendo.io.q3.e
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(Long l) {
                l0.i();
            }
        }

        a() {
        }

        @Override // sdk.pendo.io.q3.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(sdk.pendo.io.w6.b.c cVar) {
            if (!cVar.equals(sdk.pendo.io.w6.b.c.IN_BACKGROUND)) {
                if (cVar.equals(sdk.pendo.io.w6.b.c.IN_FOREGROUND) && l0.j == null) {
                    l0.j = (sdk.pendo.io.o3.b) l0.i.c(sdk.pendo.io.t6.d.a(new C0482a(), "PersistenceUtils handle session duration storage observer"));
                    l0.h.set(false);
                    return;
                }
                return;
            }
            l0.h.set(true);
            sdk.pendo.io.o3.b bVar = l0.j;
            if (bVar != null) {
                bVar.dispose();
                l0.j = null;
            }
        }
    }

    class b implements sdk.pendo.io.q3.j<Boolean> {
        b() {
        }

        @Override // sdk.pendo.io.q3.j
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean test(Boolean bool) {
            return bool.booleanValue();
        }
    }

    class c implements sdk.pendo.io.q3.e<Boolean> {
        c() {
        }

        @Override // sdk.pendo.io.q3.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Boolean bool) {
            l0.h();
        }
    }

    public static void a() {
        synchronized (d) {
            n0.a("pendo_persisted_file_name", "app_enters_background_start_time");
        }
    }

    public static void b() {
        d(null);
        b(null);
        a((String) null, (String) null);
    }

    public static String c() {
        synchronized (e) {
            SharedPreferences sharedPreferencesA = n0.a("persisted_visitor_account");
            if (sharedPreferencesA == null) {
                return null;
            }
            return sharedPreferencesA.getString("persisted_account_id", null);
        }
    }

    public static long d() {
        synchronized (d) {
            SharedPreferences sharedPreferencesA = n0.a("pendo_persisted_file_name");
            if (sharedPreferencesA == null) {
                return 0L;
            }
            return sharedPreferencesA.getLong("app_enters_background_start_time", 0L);
        }
    }

    public static String e() {
        SharedPreferences sharedPreferencesA = n0.a("persisted_jwt");
        if (sharedPreferencesA != null) {
            return sharedPreferencesA.getString("persisted_jwt_key", null);
        }
        return null;
    }

    public static String f() {
        SharedPreferences sharedPreferencesA = n0.a("persisted_jwt");
        if (sharedPreferencesA != null) {
            return sharedPreferencesA.getString("persisted_jwt_signingkeyname_key", null);
        }
        return null;
    }

    public static String g() {
        synchronized (e) {
            SharedPreferences sharedPreferencesA = n0.a("persisted_visitor_account");
            if (sharedPreferencesA == null) {
                return null;
            }
            return sharedPreferencesA.getString("persisted_visitor_id", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h() {
        i = f0.a(h, 1000L, TimeUnit.MILLISECONDS);
        sdk.pendo.io.w6.b.e().c().a(sdk.pendo.io.t6.d.a(new a(), "PersistenceUtils appflowChanges observer"));
    }

    public static void i() {
        String str;
        String str2;
        synchronized (c) {
            Set<String> setB = n0.b("persisted_insert_app_session_analytics", "app_session_duration");
            HashSet hashSet = new HashSet();
            if (setB != null) {
                hashSet.addAll(setB);
                Iterator it = hashSet.iterator();
                do {
                    if (it.hasNext()) {
                        str2 = (String) it.next();
                    }
                } while (!str2.startsWith("app_session_duration"));
                int i2 = Integer.parseInt(str2.split(":")[1]);
                hashSet.remove(str2);
                hashSet.add("app_session_duration:" + (i2 + 1));
                str = "persisted_insert_app_session_analytics";
            } else {
                hashSet.add("app_session_duration:0");
                str = "persisted_insert_app_session_analytics";
            }
            n0.a(str, "app_session_duration", (Set<String>) hashSet, true);
        }
    }

    public static void j() {
        k();
        l();
    }

    public static void k() {
        synchronized (b) {
            SharedPreferences sharedPreferencesA = n0.a("persisted_insert_dismissed_analytics");
            if (sharedPreferencesA != null) {
                for (Map.Entry<String, ?> entry : sharedPreferencesA.getAll().entrySet()) {
                    String str = null;
                    String str2 = null;
                    for (String str3 : (Set) entry.getValue()) {
                        if (str3.startsWith("groupId")) {
                            str = str3.split(":")[1];
                        } else if (str3.startsWith("displayDuration")) {
                            str2 = str3.split(":")[1];
                        }
                    }
                    if (str != null && str2 != null) {
                        d.b(entry.getKey(), str2);
                        e(entry.getKey());
                    }
                }
            }
        }
    }

    public static void l() {
        g.a(new b()).f().a(sdk.pendo.io.t6.c.a(new c(), "PersistenceUtils persistAppSessionDuration cleared app session duration observer"));
    }

    public static void m() {
        synchronized (a) {
            for (int i2 = 0; i2 < f; i2++) {
                n0.a("persisted_insert_analytics", Integer.toString(i2));
            }
            f = 0;
        }
    }

    public static String a(String str) {
        synchronized (e) {
            SharedPreferences sharedPreferencesA = n0.a("persisted_visitor_account");
            if (sharedPreferencesA != null) {
                str = sharedPreferencesA.getString("persisted_anonymous_visitor_id", str);
            }
        }
        return str;
    }

    public static void b(String str) {
        synchronized (e) {
            try {
                if (str != null) {
                    n0.a("persisted_visitor_account", "persisted_account_id", str, true);
                } else {
                    n0.a("persisted_visitor_account", "persisted_account_id");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void c(String str) {
        synchronized (e) {
            if (str != null) {
                n0.a("persisted_visitor_account", "persisted_anonymous_visitor_id", str, true);
            }
        }
    }

    public static void d(String str) {
        synchronized (e) {
            try {
                if (str != null) {
                    n0.a("persisted_visitor_account", "persisted_visitor_id", str, true);
                } else {
                    n0.a("persisted_visitor_account", "persisted_visitor_id");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void e(String str) {
        synchronized (b) {
            n0.a("persisted_insert_dismissed_analytics", str);
        }
    }

    public static void a(long j2) {
        synchronized (d) {
            n0.a("pendo_persisted_file_name", "app_enters_background_start_time", j2);
        }
    }

    public static void a(String str, long j2) {
        synchronized (b) {
            HashSet hashSet = new HashSet();
            hashSet.add("displayDuration:" + j2);
            n0.a("persisted_insert_dismissed_analytics", str, (Set<String>) hashSet, false);
        }
    }

    public static void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            n0.a("persisted_jwt", "persisted_jwt_key");
            n0.a("persisted_jwt", "persisted_jwt_signingkeyname_key");
        } else {
            n0.a("persisted_jwt", "persisted_jwt_key", str, true);
            n0.a("persisted_jwt", "persisted_jwt_signingkeyname_key", str2, true);
        }
    }

    public static void a(boolean z) {
        h.set(z);
    }
}
