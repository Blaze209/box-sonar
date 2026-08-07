package com.microsoft.identity.common.internal.ui.browser;

import android.content.ComponentName;
import android.content.Context;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import com.microsoft.identity.common.logging.Logger;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes14.dex */
public class CustomTabsManager {
    private static final long CUSTOM_TABS_MAX_CONNECTION_TIMEOUT = 1;
    private static final String TAG = "CustomTabsManager";
    private final WeakReference<Context> mContextRef;
    private CustomTabsIntent mCustomTabsIntent;
    private boolean mCustomTabsServiceIsBound;
    private CustomTabsServiceConnection mCustomTabsServiceConnection = new CustomTabsServiceConnection() { // from class: com.microsoft.identity.common.internal.ui.browser.CustomTabsManager.1
        @Override // androidx.browser.customtabs.CustomTabsServiceConnection
        public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
            Logger.info(CustomTabsManager.TAG + ":onCustomTabsServiceConnection", "CustomTabsService is connected");
            customTabsClient.warmup(0L);
            CustomTabsManager.this.mCustomTabsServiceIsBound = true;
            CustomTabsManager.this.mCustomTabsClient.set(customTabsClient);
            CustomTabsManager.this.mClientLatch.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Logger.info(CustomTabsManager.TAG + ":onServiceDisconnected", "CustomTabsService is disconnected");
            CustomTabsManager.this.mCustomTabsServiceIsBound = false;
            CustomTabsManager.this.mCustomTabsClient.set(null);
            CustomTabsManager.this.mClientLatch.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
            Logger.warn(CustomTabsManager.TAG + ":onBindingDied", "Binding died callback on custom tabs service, there will likely be failures.  Component class that failed: " + (componentName == null ? AbstractJsonLexerKt.NULL : componentName.getClassName()));
            super.onBindingDied(componentName);
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName componentName) {
            Logger.warn(CustomTabsManager.TAG + ":onNullBinding", "Null binding callback on custom tabs service, there will likely be failures. Component class that failed: " + (componentName == null ? AbstractJsonLexerKt.NULL : componentName.getClassName()));
            super.onNullBinding(componentName);
        }
    };
    private final AtomicReference<CustomTabsClient> mCustomTabsClient = new AtomicReference<>();
    private final CountDownLatch mClientLatch = new CountDownLatch(1);

    public CustomTabsIntent getCustomTabsIntent() {
        return this.mCustomTabsIntent;
    }

    public CustomTabsManager(Context context) {
        this.mContextRef = new WeakReference<>(context);
    }

    public synchronized boolean bind(Context context, String str) {
        String str2;
        String str3 = TAG + ":bind";
        if (context != null && CustomTabsClient.bindCustomTabsService(context, str, this.mCustomTabsServiceConnection)) {
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder(createSession(null));
            builder.setSendToExternalDefaultHandlerEnabled(true);
            this.mCustomTabsIntent = builder.setShowTitle(true).build();
            return true;
        }
        if (context == null) {
            str2 = "because the context was null";
        } else {
            str2 = "because the bind call failed";
        }
        Logger.info(str3, "Unable to bind custom tabs service ".concat(str2));
        this.mClientLatch.countDown();
        return false;
    }

    private CustomTabsSession createSession(CustomTabsCallback customTabsCallback) {
        String str = TAG + ":createSession";
        CustomTabsClient client = getClient();
        if (client == null) {
            Logger.warn(str, "Failed to create custom tabs session with null CustomTabClient.");
            return null;
        }
        CustomTabsSession customTabsSessionNewSession = client.newSession(customTabsCallback);
        if (customTabsSessionNewSession == null) {
            Logger.warn(str, "Failed to create custom tabs session through custom tabs client.");
        }
        return customTabsSessionNewSession;
    }

    private CustomTabsClient getClient() {
        String str = TAG + ":getClient";
        try {
            this.mClientLatch.await(1L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            Logger.info(str, "Interrupted while waiting for browser connection");
            this.mClientLatch.countDown();
        }
        return this.mCustomTabsClient.get();
    }

    public synchronized void unbind() {
        String str = TAG + ":unbind";
        Context context = this.mContextRef.get();
        if (context != null && this.mCustomTabsServiceIsBound) {
            try {
                context.unbindService(this.mCustomTabsServiceConnection);
            } catch (Exception e) {
                Logger.warn(str, "Error unbinding custom tabs service, likely failed to bind or previously died: " + e.getMessage());
                if (e instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        this.mCustomTabsServiceIsBound = false;
        this.mCustomTabsClient.set(null);
        Logger.info(str, "CustomTabsService is unbound.");
    }
}
