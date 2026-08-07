package sdk.pendo.io.f6;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0015\b\u0001\u0018\u0000 \u001d2\u00020\u0001:\u0001\u0003B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u000bR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u000bR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001e"}, d2 = {"Lsdk/pendo/io/f6/e;", "", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "", "e", "Landroid/net/ConnectivityManager;", "Landroid/net/ConnectivityManager;", "connectivityManager", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_isNetworkExpensive", "Lkotlinx/coroutines/flow/StateFlow;", "c", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "isNetworkExpensive", "d", "_isOnline", "isOnline", "sdk/pendo/io/f6/e$b", "f", "Lsdk/pendo/io/f6/e$b;", "networkCallback", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "g", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class e {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final ConnectivityManager connectivityManager;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final MutableStateFlow<Boolean> _isNetworkExpensive;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final StateFlow<Boolean> isNetworkExpensive;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final MutableStateFlow<Boolean> _isOnline;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final StateFlow<Boolean> isOnline;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final b networkCallback;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"sdk/pendo/io/f6/e$b", "Landroid/net/ConnectivityManager$NetworkCallback;", "Landroid/net/Network;", "network", "Landroid/net/NetworkCapabilities;", "networkCapabilities", "", "onCapabilitiesChanged", "onLost", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final class b extends ConnectivityManager.NetworkCallback {
        b() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            Intrinsics.checkNotNullParameter(network, "network");
            Intrinsics.checkNotNullParameter(networkCapabilities, "networkCapabilities");
            boolean zHasCapability = networkCapabilities.hasCapability(12);
            boolean zHasCapability2 = networkCapabilities.hasCapability(16);
            boolean z = zHasCapability && zHasCapability2;
            if (((Boolean) e.this._isOnline.getValue()).booleanValue() != z) {
                e.this._isOnline.setValue(Boolean.valueOf(z));
                PendoLogger.d("PendoConnectivityMonitor", "onCapabilitiesChanged: isOnline=" + z + " (internet=" + zHasCapability + ", validated=" + zHasCapability2 + ")");
            }
            boolean z2 = !networkCapabilities.hasCapability(11);
            if (((Boolean) e.this._isNetworkExpensive.getValue()).booleanValue() != z2) {
                e.this._isNetworkExpensive.setValue(Boolean.valueOf(z2));
                PendoLogger.d("PendoConnectivityMonitor", "onCapabilitiesChanged: isNetworkExpensive=" + z2);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            Intrinsics.checkNotNullParameter(network, "network");
            e.this._isOnline.setValue(Boolean.FALSE);
            PendoLogger.d("PendoConnectivityMonitor", "onLost: isOnline=false");
        }
    }

    public e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        this.connectivityManager = connectivityManager;
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(Boolean.valueOf(b()));
        this._isNetworkExpensive = MutableStateFlow;
        StateFlow<Boolean> stateFlowAsStateFlow = FlowKt.asStateFlow(MutableStateFlow);
        this.isNetworkExpensive = stateFlowAsStateFlow;
        MutableStateFlow<Boolean> MutableStateFlow2 = StateFlowKt.MutableStateFlow(Boolean.valueOf(a()));
        this._isOnline = MutableStateFlow2;
        StateFlow<Boolean> stateFlowAsStateFlow2 = FlowKt.asStateFlow(MutableStateFlow2);
        this.isOnline = stateFlowAsStateFlow2;
        if (connectivityManager == null) {
            PendoLogger.d("PendoConnectivityMonitor", "ConnectivityManager not available, defaulting to online and unmetered (fail-open)");
        }
        PendoLogger.d("PendoConnectivityMonitor", "Initial connectivity state: isOnline=" + stateFlowAsStateFlow2.getValue() + ", isNetworkExpensive=" + stateFlowAsStateFlow.getValue());
        this.networkCallback = new b();
    }

    public final StateFlow<Boolean> c() {
        return this.isNetworkExpensive;
    }

    public final StateFlow<Boolean> d() {
        return this.isOnline;
    }

    public final void e() {
        ConnectivityManager connectivityManager = this.connectivityManager;
        if (connectivityManager == null) {
            PendoLogger.w("PendoConnectivityMonitor", "Cannot register network callback, ConnectivityManager not available");
            return;
        }
        PendoLogger.d("PendoConnectivityMonitor", "Registering network callback");
        try {
            connectivityManager.registerDefaultNetworkCallback(this.networkCallback);
        } catch (SecurityException e) {
            PendoLogger.w("PendoConnectivityMonitor", "SecurityException registering network callback: " + e.getMessage());
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004a  */
    private final boolean a() {
        Object objM14780constructorimpl;
        Boolean bool;
        ConnectivityManager connectivityManager = this.connectivityManager;
        boolean z = true;
        if (connectivityManager == null) {
            return true;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork != null) {
                Intrinsics.checkNotNull(activeNetwork);
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
                if (networkCapabilities != null) {
                    Intrinsics.checkNotNull(networkCapabilities);
                    if (!networkCapabilities.hasCapability(12) || !networkCapabilities.hasCapability(16)) {
                    }
                    objM14780constructorimpl = Result.m14780constructorimpl(Boolean.valueOf(z));
                    bool = Boolean.TRUE;
                    if (Result.m14786isFailureimpl(objM14780constructorimpl)) {
                        objM14780constructorimpl = bool;
                    }
                    return ((Boolean) objM14780constructorimpl).booleanValue();
                }
            }
            z = false;
            objM14780constructorimpl = Result.m14780constructorimpl(Boolean.valueOf(z));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14780constructorimpl = Result.m14780constructorimpl(ResultKt.createFailure(th));
        }
        bool = Boolean.TRUE;
        if (Result.m14786isFailureimpl(objM14780constructorimpl)) {
            objM14780constructorimpl = bool;
        }
        return ((Boolean) objM14780constructorimpl).booleanValue();
    }

    private final boolean b() {
        Object objM14780constructorimpl;
        ConnectivityManager connectivityManager = this.connectivityManager;
        boolean z = false;
        if (connectivityManager == null) {
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork != null) {
                Intrinsics.checkNotNull(activeNetwork);
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
                if (networkCapabilities != null) {
                    Intrinsics.checkNotNull(networkCapabilities);
                    if (!networkCapabilities.hasCapability(11)) {
                        z = true;
                    }
                }
            }
            objM14780constructorimpl = Result.m14780constructorimpl(Boolean.valueOf(z));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14780constructorimpl = Result.m14780constructorimpl(ResultKt.createFailure(th));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.m14786isFailureimpl(objM14780constructorimpl)) {
            objM14780constructorimpl = bool;
        }
        return ((Boolean) objM14780constructorimpl).booleanValue();
    }
}
