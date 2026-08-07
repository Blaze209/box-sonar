package expo.modules.apploader;

import android.content.Context;
import expo.modules.core.interfaces.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public interface HeadlessAppLoader {
    boolean invalidateApp(String str);

    boolean isRunning(String str);

    void loadApp(Context context, Params params, Runnable runnable, Consumer<Boolean> consumer);

    public static final class Params {
        private final String appScopeKey;
        private final String appUrl;

        public Params(String str, String str2) {
            this.appScopeKey = str;
            this.appUrl = str2;
        }

        public String getAppScopeKey() {
            return this.appScopeKey;
        }

        public String getAppUrl() {
            return this.appUrl;
        }
    }
}
