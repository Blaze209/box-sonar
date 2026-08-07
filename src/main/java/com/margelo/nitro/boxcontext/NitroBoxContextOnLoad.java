package com.margelo.nitro.boxcontext;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: NitroBoxContextOnLoad.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/margelo/nitro/boxcontext/NitroBoxContextOnLoad;", "", "<init>", "()V", "Companion", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NitroBoxContextOnLoad {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "NitroBoxContextOnLoad";
    private static boolean didLoad;

    @JvmStatic
    public static final void initializeNative() {
        INSTANCE.initializeNative();
    }

    /* JADX INFO: compiled from: NitroBoxContextOnLoad.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/margelo/nitro/boxcontext/NitroBoxContextOnLoad$Companion;", "", "<init>", "()V", "TAG", "", "didLoad", "", "initializeNative", "", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void initializeNative() {
            if (NitroBoxContextOnLoad.didLoad) {
                return;
            }
            try {
                Log.i(NitroBoxContextOnLoad.TAG, "Loading NitroBoxContext C++ library...");
                System.loadLibrary("NitroBoxContext");
                Log.i(NitroBoxContextOnLoad.TAG, "Successfully loaded NitroBoxContext C++ library!");
                NitroBoxContextOnLoad.didLoad = true;
            } catch (Error e) {
                Log.e(NitroBoxContextOnLoad.TAG, "Failed to load NitroBoxContext C++ library! Is it properly installed and linked? Is the name correct? (see `CMakeLists.txt`, at `add_library(...)`)", e);
                throw e;
            }
        }
    }
}
