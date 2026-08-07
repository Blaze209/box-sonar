package com.microsoft.intune.mam.client.strict;

import com.microsoft.intune.mam.client.app.LazyInit;
import com.microsoft.intune.mam.client.app.MAMComponents;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMStrictMode {
    private static final LazyInit<StrictGlobalSettings> GLOBAL = new LazyInit<>(new LazyInit.Provider() { // from class: com.microsoft.intune.mam.client.strict.MAMStrictMode$$ExternalSyntheticLambda0
        @Override // com.microsoft.intune.mam.client.app.LazyInit.Provider
        public final Object get() {
            return MAMStrictMode.lambda$static$0();
        }
    });

    static /* synthetic */ StrictGlobalSettings lambda$static$0() {
        return (StrictGlobalSettings) MAMComponents.get(StrictGlobalSettings.class);
    }

    public static void enable() {
        global().enable();
    }

    public static StrictGlobalSettings global() {
        return GLOBAL.get();
    }

    public static StrictThreadSettings thread() {
        return (StrictThreadSettings) MAMComponents.get(StrictThreadSettings.class);
    }

    private MAMStrictMode() {
    }
}
