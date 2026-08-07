package androidx.work.impl.constraints;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import androidx.work.Logger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WorkConstraintsTracker.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eH\u0016J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J4\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\f2\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u0002`\u000bJ\f\u0010$\u001a\u0004\u0018\u00010\u000e*\u00020!R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u0006\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u0002`\u000b\u0012\u0004\u0012\u00020\f0\u00078\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R \u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Landroidx/work/impl/constraints/SharedNetworkCallback;", "Landroid/net/ConnectivityManager$NetworkCallback;", "<init>", "()V", "requestsLock", "", "requests", "", "Lkotlin/Function1;", "Landroidx/work/impl/constraints/ConstraintsState;", "", "Landroidx/work/impl/constraints/OnConstraintState;", "Landroid/net/NetworkRequest;", "cachedCapabilities", "Landroid/net/NetworkCapabilities;", "getCachedCapabilities", "()Landroid/net/NetworkCapabilities;", "setCachedCapabilities", "(Landroid/net/NetworkCapabilities;)V", "capabilitiesInitialized", "", "getCapabilitiesInitialized", "()Z", "setCapabilitiesInitialized", "(Z)V", "onCapabilitiesChanged", "network", "Landroid/net/Network;", "networkCapabilities", "onLost", "addCallback", "Lkotlin/Function0;", "connManager", "Landroid/net/ConnectivityManager;", "networkRequest", "onConstraintState", "getCurrentNetworkCapabilities", "work-runtime_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class SharedNetworkCallback extends ConnectivityManager.NetworkCallback {
    private static NetworkCapabilities cachedCapabilities;
    private static boolean capabilitiesInitialized;
    public static final SharedNetworkCallback INSTANCE = new SharedNetworkCallback();
    private static final Object requestsLock = new Object();
    private static final Map<Function1<ConstraintsState, Unit>, NetworkRequest> requests = new LinkedHashMap();

    private SharedNetworkCallback() {
    }

    public final NetworkCapabilities getCachedCapabilities() {
        return cachedCapabilities;
    }

    public final void setCachedCapabilities(NetworkCapabilities networkCapabilities) {
        cachedCapabilities = networkCapabilities;
    }

    public final boolean getCapabilitiesInitialized() {
        return capabilitiesInitialized;
    }

    public final void setCapabilitiesInitialized(boolean z) {
        capabilitiesInitialized = z;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        ConstraintsState constraintsNotMet;
        Intrinsics.checkNotNullParameter(network, "network");
        Intrinsics.checkNotNullParameter(networkCapabilities, "networkCapabilities");
        Logger.get().debug(WorkConstraintsTrackerKt.TAG, "NetworkRequestConstraintController onCapabilitiesChanged callback");
        synchronized (requestsLock) {
            cachedCapabilities = networkCapabilities;
            Iterator<T> it = requests.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Function1 function1 = (Function1) entry.getKey();
                if (((NetworkRequest) entry.getValue()).canBeSatisfiedBy(networkCapabilities)) {
                    constraintsNotMet = ConstraintsState.ConstraintsMet.INSTANCE;
                } else {
                    constraintsNotMet = new ConstraintsState.ConstraintsNotMet(7);
                }
                function1.invoke(constraintsNotMet);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        Logger.get().debug(WorkConstraintsTrackerKt.TAG, "NetworkRequestConstraintController onLost callback");
        synchronized (requestsLock) {
            cachedCapabilities = null;
            Iterator<T> it = requests.keySet().iterator();
            while (it.hasNext()) {
                ((Function1) it.next()).invoke(new ConstraintsState.ConstraintsNotMet(7));
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final Function0<Unit> addCallback(final ConnectivityManager connManager, NetworkRequest networkRequest, final Function1<? super ConstraintsState, Unit> onConstraintState) {
        ConstraintsState constraintsNotMet;
        Intrinsics.checkNotNullParameter(connManager, "connManager");
        Intrinsics.checkNotNullParameter(networkRequest, "networkRequest");
        Intrinsics.checkNotNullParameter(onConstraintState, "onConstraintState");
        synchronized (requestsLock) {
            Map<Function1<ConstraintsState, Unit>, NetworkRequest> map = requests;
            boolean zIsEmpty = map.isEmpty();
            map.put(onConstraintState, networkRequest);
            if (zIsEmpty) {
                Logger.get().debug(WorkConstraintsTrackerKt.TAG, "NetworkRequestConstraintController register shared callback");
                connManager.registerDefaultNetworkCallback(INSTANCE);
            }
            Logger.get().debug(WorkConstraintsTrackerKt.TAG, "NetworkRequestConstraintController send initial capabilities");
            if (networkRequest.canBeSatisfiedBy(INSTANCE.getCurrentNetworkCapabilities(connManager))) {
                constraintsNotMet = ConstraintsState.ConstraintsMet.INSTANCE;
            } else {
                constraintsNotMet = new ConstraintsState.ConstraintsNotMet(7);
            }
            onConstraintState.invoke(constraintsNotMet);
            Unit unit = Unit.INSTANCE;
        }
        return new Function0() { // from class: androidx.work.impl.constraints.SharedNetworkCallback$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SharedNetworkCallback.addCallback$lambda$6(onConstraintState, connManager);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addCallback$lambda$6(Function1 function1, ConnectivityManager connectivityManager) {
        synchronized (requestsLock) {
            Map<Function1<ConstraintsState, Unit>, NetworkRequest> map = requests;
            map.remove(function1);
            if (map.isEmpty()) {
                Logger.get().debug(WorkConstraintsTrackerKt.TAG, "NetworkRequestConstraintController unregister shared callback");
                connectivityManager.unregisterNetworkCallback(INSTANCE);
                cachedCapabilities = null;
                capabilitiesInitialized = false;
            }
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    public final NetworkCapabilities getCurrentNetworkCapabilities(ConnectivityManager connectivityManager) {
        Intrinsics.checkNotNullParameter(connectivityManager, "<this>");
        if (capabilitiesInitialized) {
            return cachedCapabilities;
        }
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        cachedCapabilities = networkCapabilities;
        capabilitiesInitialized = true;
        return networkCapabilities;
    }
}
