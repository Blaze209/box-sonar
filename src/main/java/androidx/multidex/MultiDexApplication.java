package androidx.multidex;

import android.content.Context;
import com.microsoft.intune.mam.client.app.MAMApplication;

/* JADX INFO: loaded from: classes8.dex */
public class MultiDexApplication extends MAMApplication {
    @Override // com.microsoft.intune.mam.client.app.MAMApplication, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }
}
