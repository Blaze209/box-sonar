package external.sdk.pendo.io.glide;

import android.content.Context;
import external.sdk.pendo.io.glide.manager.j;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class GeneratedAppGlideModuleImpl extends GeneratedAppGlideModule {
    public GeneratedAppGlideModuleImpl(Context context) {
    }

    @Override // external.sdk.pendo.io.glide.GeneratedAppGlideModule
    Set<Class<?>> getExcludedModuleClasses() {
        return Collections.emptySet();
    }

    @Override // external.sdk.pendo.io.glide.GeneratedAppGlideModule
    j.b getRequestManagerFactory() {
        return null;
    }

    @Override // external.sdk.pendo.io.glide.module.AppGlideModule
    public boolean isManifestParsingEnabled() {
        return false;
    }
}
