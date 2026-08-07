package expo.modules.adapters.react.services;

import android.app.Activity;
import android.content.Intent;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import expo.modules.core.interfaces.ActivityEventListener;
import expo.modules.core.interfaces.ActivityProvider;
import expo.modules.core.interfaces.InternalModule;
import expo.modules.core.interfaces.JavaScriptContextProvider;
import expo.modules.core.interfaces.LifecycleEventListener;
import expo.modules.core.interfaces.services.UIManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class UIManagerModuleWrapper implements ActivityProvider, InternalModule, JavaScriptContextProvider, UIManager {
    private ReactContext mReactContext;
    private Map<LifecycleEventListener, com.facebook.react.bridge.LifecycleEventListener> mLifecycleListenersMap = new WeakHashMap();
    private Map<ActivityEventListener, com.facebook.react.bridge.ActivityEventListener> mActivityEventListenersMap = new WeakHashMap();

    public UIManagerModuleWrapper(ReactContext reactContext) {
        this.mReactContext = reactContext;
    }

    protected ReactContext getContext() {
        return this.mReactContext;
    }

    @Override // expo.modules.core.interfaces.InternalModule
    public List<Class> getExportedInterfaces() {
        return Arrays.asList(ActivityProvider.class, JavaScriptContextProvider.class, UIManager.class);
    }

    @Override // expo.modules.core.interfaces.services.UIManager
    public void runOnUiQueueThread(Runnable runnable) {
        if (getContext().isOnUiQueueThread()) {
            runnable.run();
        } else {
            getContext().runOnUiQueueThread(runnable);
        }
    }

    @Override // expo.modules.core.interfaces.services.UIManager
    public void runOnClientCodeQueueThread(Runnable runnable) {
        if (getContext().isOnJSQueueThread()) {
            runnable.run();
        } else {
            getContext().runOnJSQueueThread(runnable);
        }
    }

    @Override // expo.modules.core.interfaces.services.UIManager
    public void registerLifecycleEventListener(LifecycleEventListener lifecycleEventListener) {
        final WeakReference weakReference = new WeakReference(lifecycleEventListener);
        this.mLifecycleListenersMap.put(lifecycleEventListener, new com.facebook.react.bridge.LifecycleEventListener() { // from class: expo.modules.adapters.react.services.UIManagerModuleWrapper.1
            @Override // com.facebook.react.bridge.LifecycleEventListener
            public void onHostResume() {
                LifecycleEventListener lifecycleEventListener2 = (LifecycleEventListener) weakReference.get();
                if (lifecycleEventListener2 != null) {
                    lifecycleEventListener2.onHostResume();
                }
            }

            @Override // com.facebook.react.bridge.LifecycleEventListener
            public void onHostPause() {
                LifecycleEventListener lifecycleEventListener2 = (LifecycleEventListener) weakReference.get();
                if (lifecycleEventListener2 != null) {
                    lifecycleEventListener2.onHostPause();
                }
            }

            @Override // com.facebook.react.bridge.LifecycleEventListener
            public void onHostDestroy() {
                LifecycleEventListener lifecycleEventListener2 = (LifecycleEventListener) weakReference.get();
                if (lifecycleEventListener2 != null) {
                    lifecycleEventListener2.onHostDestroy();
                }
            }
        });
        this.mReactContext.addLifecycleEventListener(this.mLifecycleListenersMap.get(lifecycleEventListener));
    }

    @Override // expo.modules.core.interfaces.RegistryLifecycleListener
    public void onDestroy() {
        Iterator it = new ArrayList(this.mLifecycleListenersMap.values()).iterator();
        while (it.hasNext()) {
            ((com.facebook.react.bridge.LifecycleEventListener) it.next()).onHostDestroy();
        }
        Iterator<com.facebook.react.bridge.LifecycleEventListener> it2 = this.mLifecycleListenersMap.values().iterator();
        while (it2.hasNext()) {
            this.mReactContext.removeLifecycleEventListener(it2.next());
        }
        this.mLifecycleListenersMap.clear();
    }

    @Override // expo.modules.core.interfaces.services.UIManager
    public void unregisterLifecycleEventListener(LifecycleEventListener lifecycleEventListener) {
        getContext().removeLifecycleEventListener(this.mLifecycleListenersMap.get(lifecycleEventListener));
        this.mLifecycleListenersMap.remove(lifecycleEventListener);
    }

    @Override // expo.modules.core.interfaces.services.UIManager
    public void registerActivityEventListener(ActivityEventListener activityEventListener) {
        final WeakReference weakReference = new WeakReference(activityEventListener);
        this.mActivityEventListenersMap.put(activityEventListener, new com.facebook.react.bridge.ActivityEventListener() { // from class: expo.modules.adapters.react.services.UIManagerModuleWrapper.2
            @Override // com.facebook.react.bridge.ActivityEventListener
            public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
                ActivityEventListener activityEventListener2 = (ActivityEventListener) weakReference.get();
                if (activityEventListener2 != null) {
                    activityEventListener2.onActivityResult(activity, i, i2, intent);
                }
            }

            @Override // com.facebook.react.bridge.ActivityEventListener
            public void onNewIntent(Intent intent) {
                ActivityEventListener activityEventListener2 = (ActivityEventListener) weakReference.get();
                if (activityEventListener2 != null) {
                    activityEventListener2.onNewIntent(intent);
                }
            }
        });
        this.mReactContext.addActivityEventListener(this.mActivityEventListenersMap.get(activityEventListener));
    }

    @Override // expo.modules.core.interfaces.services.UIManager
    public void unregisterActivityEventListener(ActivityEventListener activityEventListener) {
        getContext().removeActivityEventListener(this.mActivityEventListenersMap.get(activityEventListener));
        this.mActivityEventListenersMap.remove(activityEventListener);
    }

    @Override // expo.modules.core.interfaces.JavaScriptContextProvider
    public long getJavaScriptContextRef() {
        return this.mReactContext.getJavaScriptContextHolder().getContext();
    }

    @Override // expo.modules.core.interfaces.JavaScriptContextProvider
    public CallInvokerHolderImpl getJSCallInvokerHolder() {
        return (CallInvokerHolderImpl) this.mReactContext.getCatalystInstance().getJSCallInvokerHolder();
    }

    @Override // expo.modules.core.interfaces.ActivityProvider
    public Activity getCurrentActivity() {
        return getContext().getCurrentActivity();
    }
}
