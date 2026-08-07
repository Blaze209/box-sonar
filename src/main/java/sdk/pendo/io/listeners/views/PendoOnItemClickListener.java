package sdk.pendo.io.listeners.views;

import android.view.View;
import android.widget.AdapterView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.actions.ActivationManager;
import sdk.pendo.io.actions.GuidesActionsManager;
import sdk.pendo.io.actions.PendoCommand;
import sdk.pendo.io.actions.PendoCommandsEventBus;
import sdk.pendo.io.actions.VisualAnimationManager;
import sdk.pendo.io.j6.a;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.o3.b;
import sdk.pendo.io.q3.e;
import sdk.pendo.io.s7.b1;
import sdk.pendo.io.y5.d;

/* JADX INFO: loaded from: classes4.dex */
public final class PendoOnItemClickListener implements AdapterView.OnItemClickListener {
    private static final String TAG = "PendoOnItemClickListener";
    private ArrayList<AdapterView.OnItemClickListener> mOnItemClickListener = new ArrayList<>();
    private b mSubscription = null;

    public boolean addListener(AdapterView.OnItemClickListener onItemClickListener) {
        return this.mOnItemClickListener.add(onItemClickListener);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x007b A[PHI: r3
      0x007b: PHI (r3v2 boolean) = (r3v1 boolean), (r3v0 boolean), (r3v0 boolean), (r3v9 boolean) binds: [B:17:0x0096, B:4:0x002c, B:6:0x0032, B:8:0x006d] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(final AdapterView<?> adapterView, final View view, final int i, final long j) {
        String strHandleClick;
        PendoOnItemClickListener pendoOnItemClickListener;
        PendoLogger.d("PendoOnItemClickListener onItemClick, position: '" + i + "', id: '" + j + "'.", new Object[0]);
        boolean zIsActivityDestroyed = true;
        try {
            if (a.d() || !PendoInternal.Z()) {
                strHandleClick = "";
            } else {
                JSONObject jSONObjectA = b1.a.a(view);
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                int width = iArr[0] + (view.getWidth() / 2);
                int height = iArr[1] + (view.getHeight() / 2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", width);
                jSONObject.put("y", height);
                jSONObjectA.put("tapLocation", jSONObject);
                sdk.pendo.io.w6.a.a.a(jSONObjectA, false);
                zIsActivityDestroyed = GuidesActionsManager.isActivityDestroyed();
                if (zIsActivityDestroyed) {
                    strHandleClick = "";
                } else {
                    strHandleClick = ActivationManager.INSTANCE.handleClick(jSONObjectA, new WeakReference<>(view));
                }
            }
        } catch (Exception e) {
            PendoLogger.e(e, e.getMessage(), "parent: " + (adapterView != null ? adapterView.getClass().getCanonicalName() : "no parent"));
        }
        if (zIsActivityDestroyed || strHandleClick.equals("")) {
            Iterator<AdapterView.OnItemClickListener> it = this.mOnItemClickListener.iterator();
            while (it.hasNext()) {
                it.next().onItemClick(adapterView, view, i, j);
            }
        } else {
            if (this.mSubscription != null) {
                return;
            }
            try {
                pendoOnItemClickListener = this;
                try {
                    pendoOnItemClickListener.mSubscription = PendoCommandsEventBus.getInstance().getCommandEventBus().a(VisualAnimationManager.waitForAnimationDoneAndNotifyClose(strHandleClick)).b().a(new e<PendoCommand>() { // from class: sdk.pendo.io.listeners.views.PendoOnItemClickListener.1
                        @Override // sdk.pendo.io.q3.e
                        public void accept(PendoCommand pendoCommand) throws d {
                            PendoLogger.d(pendoCommand.toString(), new Object[0]);
                            Iterator it2 = PendoOnItemClickListener.this.mOnItemClickListener.iterator();
                            while (it2.hasNext()) {
                                try {
                                    ((AdapterView.OnItemClickListener) it2.next()).onItemClick(adapterView, view, i, j);
                                } catch (Exception e2) {
                                    throw new d(e2);
                                }
                            }
                            PendoOnItemClickListener pendoOnItemClickListener2 = PendoOnItemClickListener.this;
                            if (pendoOnItemClickListener2.mSubscription != null) {
                                pendoOnItemClickListener2.mSubscription = null;
                            }
                        }
                    }, new sdk.pendo.io.q6.a("PendoOnItemClickListener Pendo Command error consumer"));
                } catch (Exception e2) {
                    e = e2;
                    Exception exc = e;
                    pendoOnItemClickListener.mSubscription = null;
                    PendoLogger.e(exc, exc.getMessage(), new Object[0]);
                }
            } catch (Exception e3) {
                e = e3;
                pendoOnItemClickListener = this;
            }
        }
    }
}
