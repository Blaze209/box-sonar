package com.microsoft.identity.common.components;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.microsoft.identity.common.crypto.AndroidAuthSdkStorageEncryptionManager;
import com.microsoft.identity.common.internal.net.cache.HttpCache;
import com.microsoft.identity.common.internal.platform.AndroidBroadcaster;
import com.microsoft.identity.common.internal.platform.AndroidDeviceMetadata;
import com.microsoft.identity.common.internal.platform.AndroidPlatformUtil;
import com.microsoft.identity.common.internal.providers.oauth2.AndroidTaskStateGenerator;
import com.microsoft.identity.common.internal.ui.AndroidAuthorizationStrategyFactory;
import com.microsoft.identity.common.internal.ui.browser.AndroidBrowserSelector;
import com.microsoft.identity.common.internal.util.WorkProfileUtil;
import com.microsoft.identity.common.java.flighting.CommonFlight;
import com.microsoft.identity.common.java.flighting.CommonFlightsManager;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.java.interfaces.PlatformComponents;
import com.microsoft.identity.common.java.net.DefaultHttpClientWrapper;
import com.microsoft.identity.common.java.platform.Device;
import com.microsoft.identity.common.logging.Logger;
import java.io.File;

/* JADX INFO: loaded from: classes14.dex */
public class AndroidPlatformComponentsFactory {
    private static final String TAG = "AndroidPlatformComponentsFactory";
    private static boolean sGlobalStateInitalized = false;

    public static synchronized void initializeGlobalStates(Context context) {
        try {
            if (context == null) {
                throw new NullPointerException("context is marked non-null but is null");
            }
            String str = TAG + ":initializeGlobalStates";
            if (!sGlobalStateInitalized) {
                HttpCache.initialize(context);
                Device.setDeviceMetadata(new AndroidDeviceMetadata());
                if (CommonFlightsManager.INSTANCE.getFlightsProvider().isFlightEnabled(CommonFlight.ENABLE_AM_API_WORKPROFILE_EXTRA_QUERY_PARAMETERS)) {
                    Device.setIsInPersonalProfileButClouddpcWorkProfileAvailable(Boolean.valueOf(WorkProfileUtil.checkIfIsInPersonalProfileButClouddpcWorkProfileAvailable(context)));
                }
                Logger.setAndroidLogger();
                File cacheDir = context.getCacheDir();
                if (cacheDir != null) {
                    HttpCache.initialize(cacheDir);
                } else {
                    Logger.warn(str, "Http caching is not enabled because the cache dir is null");
                }
                sGlobalStateInitalized = true;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static IPlatformComponents createFromContext(Context context) {
        if (context == null) {
            throw new NullPointerException("context is marked non-null but is null");
        }
        return create(context, null, null);
    }

    public static IPlatformComponents createFromActivity(Activity activity, Fragment fragment) {
        if (activity == null) {
            throw new NullPointerException("activity is marked non-null but is null");
        }
        return create(activity.getApplicationContext(), activity, fragment);
    }

    private static IPlatformComponents create(Context context, Activity activity, Fragment fragment) {
        if (context == null) {
            throw new NullPointerException("context is marked non-null but is null");
        }
        initializeGlobalStates(context);
        PlatformComponents.PlatformComponentsBuilder<?, ?> platformComponentsBuilderBuilder = PlatformComponents.builder();
        fillBuilderWithBasicImplementations(platformComponentsBuilderBuilder, context, activity, fragment);
        return platformComponentsBuilderBuilder.build();
    }

    public static void fillBuilderWithBasicImplementations(PlatformComponents.PlatformComponentsBuilder platformComponentsBuilder, Context context, Activity activity, Fragment fragment) {
        if (platformComponentsBuilder == null) {
            throw new NullPointerException("builder is marked non-null but is null");
        }
        if (context == null) {
            throw new NullPointerException("context is marked non-null but is null");
        }
        platformComponentsBuilder.clockSkewManager(new AndroidClockSkewManager(context)).broadcaster(new AndroidBroadcaster(context)).popManagerLoader(new AndroidPopManagerSupplier(context)).storageSupplier(new AndroidStorageSupplier(context, new AndroidAuthSdkStorageEncryptionManager(context))).platformUtil(new AndroidPlatformUtil(context, activity)).httpClientWrapper(new DefaultHttpClientWrapper()).browserSelector(new AndroidBrowserSelector(context));
        if (activity != null) {
            platformComponentsBuilder.authorizationStrategyFactory(AndroidAuthorizationStrategyFactory.builder().context(activity.getApplicationContext()).activity(activity).fragment(fragment).browserSelector(new AndroidBrowserSelector(context)).build()).stateGenerator(new AndroidTaskStateGenerator(activity.getTaskId()));
        }
    }
}
