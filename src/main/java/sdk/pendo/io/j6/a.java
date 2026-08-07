package sdk.pendo.io.j6;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.function.BooleanSupplier;
import kotlin.Lazy;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.e2.e0;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.network.responses.AuthTokenErrorResponse;
import sdk.pendo.io.network.responses.KillSwitchModel;
import sdk.pendo.io.network.responses.validators.JsonWebTokenValidator;
import sdk.pendo.io.s7.k0;
import sdk.pendo.io.s7.n;
import sdk.pendo.io.s7.u0;
import sdk.pendo.io.utilities.AndroidUtils;
import sdk.pendo.io.w5.b;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    private static Boolean a;
    private static Boolean b;
    private static volatile a c;
    private static int d;
    private static final Lazy<k0> e = b.a(k0.class);

    private a() {
    }

    private static boolean b() throws Throwable {
        Context contextO = PendoInternal.o();
        if (contextO != null) {
            String strD = n.d(contextO, "host_app_version");
            String strD2 = AndroidUtils.d();
            if (strD2 != null) {
                if (strD == null) {
                    n.a(contextO, strD2.getBytes(Charset.forName("UTF-8")), "host_app_version");
                } else if (!strD.equals(strD2)) {
                    n.c(contextO, "host_app_version");
                    n.c(contextO, "pendo_killswitch");
                    n.a(contextO, strD2.getBytes(Charset.forName("UTF-8")), "host_app_version");
                    a = Boolean.TRUE;
                    return true;
                }
            }
        }
        a = Boolean.FALSE;
        return false;
    }

    private static boolean c() throws Throwable {
        Context contextO = PendoInternal.o();
        if (contextO != null) {
            String strD = n.d(contextO, "pendo_killswitch");
            if (!TextUtils.isEmpty(strD)) {
                try {
                    if (a((AuthTokenErrorResponse) e.getValue().a().a(JsonWebTokenValidator.INSTANCE.validate(strD), AuthTokenErrorResponse.class))) {
                        b = Boolean.TRUE;
                        return true;
                    }
                } catch (Exception unused) {
                }
                n.c(contextO, "pendo_killswitch");
            }
        }
        b = Boolean.FALSE;
        return false;
    }

    public static synchronized boolean d() {
        Boolean bool = a;
        if (bool != null && bool.booleanValue()) {
            return false;
        }
        Boolean bool2 = b;
        if (bool2 != null) {
            return bool2.booleanValue();
        }
        if (b()) {
            return false;
        }
        return c();
    }

    protected boolean a(BooleanSupplier booleanSupplier, int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
        return booleanSupplier.getAsBoolean();
    }

    public static synchronized a a() {
        if (c == null) {
            c = new a();
        }
        return c;
    }

    private static void b(AuthTokenErrorResponse authTokenErrorResponse) {
        if (authTokenErrorResponse.getKillSwitchModel() == null) {
            PendoLogger.d("Killswitch response does not contain kill property", new Object[0]);
            return;
        }
        Long expiration = authTokenErrorResponse.getKillSwitchModel().getExpiration();
        List<String> affectedVersions = authTokenErrorResponse.getKillSwitchModel().getAffectedVersions();
        PendoLogger.d("Got kill switch response:   errorId: " + authTokenErrorResponse.getErrorId() + " errorMessage: '" + authTokenErrorResponse.getErrorMessage() + " kill expiration: " + (expiration == null ? "never" : String.valueOf(expiration.longValue())), new Object[0]);
        if (affectedVersions != null) {
            Iterator<String> it = affectedVersions.iterator();
            while (it.hasNext()) {
                PendoLogger.d(" kill version: " + it.next(), new Object[0]);
            }
        }
    }

    public boolean a(e0 e0Var, BooleanSupplier booleanSupplier) {
        if (Looper.myLooper() == Looper.getMainLooper() || a(e0Var) || d >= 3) {
            return false;
        }
        PendoLogger.d("Got a Kill Switch with a body that doesn't apply here, retrying previous api request.", new Object[0]);
        boolean zA = a(booleanSupplier, 3000);
        d++;
        return zA;
    }

    private static boolean a(KillSwitchModel killSwitchModel, String str) {
        if (killSwitchModel == null || killSwitchModel.isExpired() || !killSwitchModel.isCurrentSDKVersionAffected(str)) {
            PendoLogger.d("Kill Switch is OFF for this current SDK", new Object[0]);
            return false;
        }
        PendoLogger.d("Kill Switch is ON", new Object[0]);
        return true;
    }

    private static boolean a(AuthTokenErrorResponse authTokenErrorResponse) {
        b(authTokenErrorResponse);
        return a(authTokenErrorResponse.getKillSwitchModel(), u0.a());
    }

    public static boolean a(e0 e0Var) {
        PendoLogger.d("Test got kill switch http code", new Object[0]);
        try {
            String strA = sdk.pendo.io.s7.a.a.a(e0Var);
            AuthTokenErrorResponse authTokenErrorResponse = (AuthTokenErrorResponse) e.getValue().a().a(JsonWebTokenValidator.INSTANCE.validate(strA), AuthTokenErrorResponse.class);
            a(strA);
            boolean zA = a(authTokenErrorResponse);
            if (zA) {
                PendoInternal.i();
            }
            return zA;
        } catch (Exception e2) {
            PendoLogger.d("Problem with kill switch handling" + e2.getMessage(), new Object[0]);
            return false;
        }
    }

    private static synchronized void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        n.a(PendoInternal.o(), str.getBytes(Charset.forName("UTF-8")), "pendo_killswitch");
        b = null;
    }
}
