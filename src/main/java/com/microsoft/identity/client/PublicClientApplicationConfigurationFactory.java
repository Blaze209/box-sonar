package com.microsoft.identity.client;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.microsoft.identity.client.internal.MsalUtils;
import com.microsoft.identity.client.internal.configuration.LogLevelDeserializer;
import com.microsoft.identity.common.components.AndroidPlatformComponentsFactory;
import com.microsoft.identity.common.internal.authorities.AzureActiveDirectoryAudienceDeserializer;
import com.microsoft.identity.common.java.authorities.Authority;
import com.microsoft.identity.common.java.authorities.AuthorityDeserializer;
import com.microsoft.identity.common.java.authorities.AzureActiveDirectoryAudience;
import com.microsoft.identity.common.java.cache.MsalOAuth2TokenCache;
import com.microsoft.identity.common.java.configuration.LibraryConfiguration;
import com.microsoft.identity.msal.R;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes14.dex */
public class PublicClientApplicationConfigurationFactory {
    private static final String TAG = "PublicClientApplicationConfigurationFactory";

    public static PublicClientApplicationConfiguration initializeConfiguration(Context context) {
        return initializeConfigurationInternal(context, null);
    }

    public static PublicClientApplicationConfiguration initializeConfiguration(Context context, int i) {
        return initializeConfigurationInternal(context, loadConfiguration(context, i));
    }

    public static PublicClientApplicationConfiguration initializeConfiguration(Context context, File file) {
        MsalUtils.validateNonNullArgument(file, "configFile");
        return initializeConfigurationInternal(context, loadConfiguration(file));
    }

    private static PublicClientApplicationConfiguration initializeConfigurationInternal(Context context, PublicClientApplicationConfiguration publicClientApplicationConfiguration) {
        MsalUtils.validateNonNullArgument(context, "context");
        PublicClientApplicationConfiguration publicClientApplicationConfigurationLoadDefaultConfiguration = loadDefaultConfiguration(context);
        if (publicClientApplicationConfiguration != null) {
            publicClientApplicationConfigurationLoadDefaultConfiguration.mergeConfiguration(publicClientApplicationConfiguration);
            publicClientApplicationConfigurationLoadDefaultConfiguration.validateConfiguration();
        }
        LibraryConfiguration.intializeLibraryConfiguration(LibraryConfiguration.builder().authorizationInCurrentTask(publicClientApplicationConfigurationLoadDefaultConfiguration.authorizationInCurrentTask().booleanValue()).build());
        publicClientApplicationConfigurationLoadDefaultConfiguration.setOAuth2TokenCache(MsalOAuth2TokenCache.create(AndroidPlatformComponentsFactory.createFromContext(context)));
        return publicClientApplicationConfigurationLoadDefaultConfiguration;
    }

    private static PublicClientApplicationConfiguration loadDefaultConfiguration(Context context) {
        com.microsoft.identity.common.logging.Logger.verbose(TAG + ":loadDefaultConfiguration", "Loading default configuration");
        PublicClientApplicationConfiguration publicClientApplicationConfigurationLoadConfiguration = loadConfiguration(context, R.raw.msal_default_config);
        publicClientApplicationConfigurationLoadConfiguration.setAppContext(context);
        return publicClientApplicationConfigurationLoadConfiguration;
    }

    public static PublicClientApplicationConfiguration loadConfiguration(Context context, int i) {
        return loadConfiguration(context.getResources().openRawResource(i), i == R.raw.msal_default_config);
    }

    static PublicClientApplicationConfiguration loadConfiguration(File file) {
        try {
            return loadConfiguration((InputStream) new FileInputStream(file), false);
        } catch (FileNotFoundException unused) {
            throw new IllegalArgumentException("Provided configuration file path=" + file.getPath() + " not found.");
        }
    }

    private static PublicClientApplicationConfiguration loadConfiguration(InputStream inputStream, boolean z) {
        String str = TAG + ":loadConfiguration";
        try {
            try {
                byte[] bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                try {
                    inputStream.close();
                } catch (IOException unused) {
                    if (z) {
                        com.microsoft.identity.common.logging.Logger.warn(str, "Unable to close default configuration file. This can cause memory leak.");
                    } else {
                        com.microsoft.identity.common.logging.Logger.warn(str, "Unable to close provided configuration file. This can cause memory leak.");
                    }
                }
                try {
                    return (PublicClientApplicationConfiguration) getGsonForLoadingConfiguration().fromJson(new String(bArr), PublicClientApplicationConfiguration.class);
                } catch (Exception e) {
                    if (e instanceof InterruptedException) {
                        Thread.currentThread().interrupt();
                    }
                    throw new IllegalArgumentException("Error while processing configuration", e);
                }
            } catch (IOException e2) {
                if (z) {
                    throw new IllegalStateException("Unable to open default configuration file.", e2);
                }
                throw new IllegalArgumentException("Unable to open provided configuration file.", e2);
            }
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException unused2) {
                if (z) {
                    com.microsoft.identity.common.logging.Logger.warn(str, "Unable to close default configuration file. This can cause memory leak.");
                } else {
                    com.microsoft.identity.common.logging.Logger.warn(str, "Unable to close provided configuration file. This can cause memory leak.");
                }
            }
            throw th;
        }
    }

    private static Gson getGsonForLoadingConfiguration() {
        return new GsonBuilder().registerTypeAdapter(Authority.class, new AuthorityDeserializer()).registerTypeAdapter(AzureActiveDirectoryAudience.class, new AzureActiveDirectoryAudienceDeserializer()).registerTypeAdapter(Logger.LogLevel.class, new LogLevelDeserializer()).create();
    }
}
