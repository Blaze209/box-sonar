package external.sdk.pendo.io.glide.manager;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import external.sdk.pendo.io.glide.RequestManager;
import sdk.pendo.io.y.l;

/* JADX INFO: loaded from: classes4.dex */
public class j implements Handler.Callback {
    private static final b f = new a();
    private volatile RequestManager a;
    private final b b;
    private final ArrayMap<View, Fragment> c = new ArrayMap<>();
    private final g d;
    private final h e;

    class a implements b {
        a() {
        }

        @Override // external.sdk.pendo.io.glide.manager.j.b
        public RequestManager a(external.sdk.pendo.io.glide.a aVar, sdk.pendo.io.r.a aVar2, sdk.pendo.io.r.c cVar, Context context) {
            return new RequestManager(aVar, aVar2, cVar, context);
        }
    }

    public interface b {
        RequestManager a(external.sdk.pendo.io.glide.a aVar, sdk.pendo.io.r.a aVar2, sdk.pendo.io.r.c cVar, Context context);
    }

    public j(b bVar) {
        bVar = bVar == null ? f : bVar;
        this.b = bVar;
        this.e = new h(bVar);
        this.d = a();
    }

    private static void a(Activity activity) {
        if (activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    private RequestManager c(Context context) {
        if (this.a == null) {
            synchronized (this) {
                if (this.a == null) {
                    this.a = this.b.a(external.sdk.pendo.io.glide.a.a(context.getApplicationContext()), new external.sdk.pendo.io.glide.manager.a(), new e(), context.getApplicationContext());
                }
            }
        }
        return this.a;
    }

    private static boolean d(Context context) {
        Activity activityA = a(context);
        return activityA == null || !activityA.isFinishing();
    }

    public RequestManager b(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (l.e() && !(context instanceof Application)) {
            if (context instanceof FragmentActivity) {
                return a((FragmentActivity) context);
            }
            if (context instanceof ContextWrapper) {
                ContextWrapper contextWrapper = (ContextWrapper) context;
                if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                    return b(contextWrapper.getBaseContext());
                }
            }
        }
        return c(context);
    }

    @Override // android.os.Handler.Callback
    @Deprecated
    public boolean handleMessage(Message message) {
        return false;
    }

    private static g a() {
        return (external.sdk.pendo.io.glide.load.resource.bitmap.e.f && external.sdk.pendo.io.glide.load.resource.bitmap.e.e) ? new f() : new d();
    }

    private static Activity a(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return a(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public RequestManager a(FragmentActivity fragmentActivity) {
        if (l.d()) {
            return b(fragmentActivity.getApplicationContext());
        }
        a((Activity) fragmentActivity);
        this.d.a(fragmentActivity);
        boolean zD = d(fragmentActivity);
        return this.e.a(fragmentActivity, external.sdk.pendo.io.glide.a.a(fragmentActivity.getApplicationContext()), fragmentActivity.getLifecycle(), fragmentActivity.getSupportFragmentManager(), zD);
    }
}
