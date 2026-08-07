package com.box.android.controller;

import android.content.Context;
import android.os.Bundle;
import com.box.android.R;
import com.box.android.application.BoxBaseApplication;
import com.box.android.domain.configuration.BoxConfigConstants;
import com.box.android.domain.configuration.ConfigManager;
import com.box.android.domain.services.IAppRestrictionsManager;
import com.box.android.utilities.BoxUtils;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.util.Locale;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes10.dex */
public class AndroidForWorkController {
    public String mClientId;
    public String mClientSecret;
    public ConfigManager mConfigManager;
    private final Context mContext;
    public final IAppRestrictionsManager mRestrictionsManager;

    public AndroidForWorkController(Context context, IAppRestrictionsManager iAppRestrictionsManager) {
        this.mContext = context;
        this.mRestrictionsManager = iAppRestrictionsManager;
        if (context.getApplicationContext() instanceof BoxBaseApplication) {
            this.mConfigManager = BoxBaseApplication.getInstance().getConfigManager();
            initConfigBasedOnAppRestrictions();
        }
        iAppRestrictionsManager.setAppRestrictions();
    }

    public Bundle initConfigBasedOnAppRestrictions() {
        Bundle savedAppRestrictions;
        if (this.mConfigManager.isConfigSet()) {
            BoxLogUtils.d("AndroidForWork", "Configuration values set -- loading previously saved app restrictions");
            savedAppRestrictions = this.mRestrictionsManager.getSavedAppRestrictions();
        } else {
            BoxLogUtils.d("AndroidForWork", "Configuration values not set -- configuring with latest app restrictions");
            boolean zIsDeviceTypeTablet = this.mConfigManager.isDeviceTypeTablet();
            Bundle latestAppRestrictions = this.mRestrictionsManager.getLatestAppRestrictions();
            if (latestAppRestrictions.isEmpty()) {
                ConfigManager configManager = this.mConfigManager;
                this.mClientId = zIsDeviceTypeTablet ? configManager.getDefaultTabletClientId() : configManager.getDefaultClientId();
                this.mClientSecret = zIsDeviceTypeTablet ? this.mConfigManager.getDefaultTabletClientSecret() : this.mConfigManager.getDefaultClientSecret();
            } else {
                String string = latestAppRestrictions.getString(this.mContext.getString(R.string.restriction_key_EmmName), "");
                if (string.equals(this.mContext.getString(R.string.emm_provider_airwatch))) {
                    this.mClientId = zIsDeviceTypeTablet ? "a3q8sad7xelv4b4hpvmeqj1ufmm1qzzm" : "w2ndash5bh5zgeq3unw0km4bwakdmx8f";
                    this.mClientSecret = zIsDeviceTypeTablet ? "AubFhmTFn2azpHcsMThzlU9MbtogyRr0" : "0SjDcsqugEjE3LZbQpnbxw2tBYeQG7s0";
                } else if (string.equals(this.mContext.getString(R.string.emm_provider_maas360))) {
                    this.mClientId = zIsDeviceTypeTablet ? "a3q8sad7xelv4b4hpvmeqj1ufmm1qzzm" : "w2ndash5bh5zgeq3unw0km4bwakdmx8f";
                    this.mClientSecret = zIsDeviceTypeTablet ? "AubFhmTFn2azpHcsMThzlU9MbtogyRr0" : "0SjDcsqugEjE3LZbQpnbxw2tBYeQG7s0";
                } else if (string.equals(this.mContext.getString(R.string.emm_provider_mobileiron))) {
                    this.mClientId = zIsDeviceTypeTablet ? "a3q8sad7xelv4b4hpvmeqj1ufmm1qzzm" : "w2ndash5bh5zgeq3unw0km4bwakdmx8f";
                    this.mClientSecret = zIsDeviceTypeTablet ? "AubFhmTFn2azpHcsMThzlU9MbtogyRr0" : "0SjDcsqugEjE3LZbQpnbxw2tBYeQG7s0";
                } else {
                    this.mClientId = zIsDeviceTypeTablet ? "a3q8sad7xelv4b4hpvmeqj1ufmm1qzzm" : "w2ndash5bh5zgeq3unw0km4bwakdmx8f";
                    this.mClientSecret = zIsDeviceTypeTablet ? "AubFhmTFn2azpHcsMThzlU9MbtogyRr0" : "0SjDcsqugEjE3LZbQpnbxw2tBYeQG7s0";
                }
                this.mConfigManager.setCustomConfigValue(BoxConfigConstants.CONFIG_KEY_ACCOUNT_SWITCHING_ENABLED_BOOL, false);
                boolean zIsAppFedrampHighCompliant = this.mRestrictionsManager.isAppFedrampHighCompliant();
                this.mConfigManager.setCustomConfigValue(BoxConfigConstants.CONFIG_KEY_OAUTH_URL_AUTHORITY, zIsAppFedrampHighCompliant ? "account.box-gov.com" : "account.box.com");
                this.mConfigManager.setCustomConfigValue(BoxConfigConstants.CONFIG_KEY_API_URL_HOSTNAME, zIsAppFedrampHighCompliant ? BoxConfigConstants.CONFIG_API_URL_HOSTNAME_FEDRAMP_COMPLIANT : BoxConfigConstants.CONFIG_API_URL_HOSTNAME);
                this.mConfigManager.setCustomConfigValue(BoxConfigConstants.CONFIG_KEY_V2_API_URL_HOSTNAME, zIsAppFedrampHighCompliant ? "account.box-gov.com" : "account.box.com");
                this.mConfigManager.setCustomConfigValue(BoxConfigConstants.CONFIG_KEY_V2_UPLOAD_URL_HOSTNAME, zIsAppFedrampHighCompliant ? BoxConfigConstants.CONFIG_V2_UPLOAD_URL_HOSTNAME_FEDRAMP_COMPLIANT : BoxConfigConstants.CONFIG_V2_UPLOAD_URL_HOSTNAME);
                this.mConfigManager.setCustomConfigValue(BoxConfigConstants.CONFIG_KEY_MIME_TYPE_ADDON_URL, zIsAppFedrampHighCompliant ? BoxConfigConstants.CONFIG_MIME_TYPE_ADDON_URL_FEDRAMP_COMPLIANT : BoxConfigConstants.CONFIG_MIME_TYPE_ADDON_URL);
                this.mConfigManager.setCustomConfigValue(BoxConfigConstants.CONFIG_KEY_SURVEY_URL, zIsAppFedrampHighCompliant ? BoxConfigConstants.CONFIG_SURVEY_URL_FEDRAMP_COMPLIANT : BoxConfigConstants.CONFIG_SURVEY_URL);
                this.mConfigManager.setCustomConfigValue(BoxConfigConstants.CONFIG_KEY_PRIVACY_POLICY_URL, zIsAppFedrampHighCompliant ? BoxConfigConstants.CONFIG_PRIVACY_POLICY_URL_FEDRAMP_COMPLIANT : BoxConfigConstants.CONFIG_PRIVACY_POLICY_URL);
                this.mConfigManager.setCustomConfigValue(BoxConfigConstants.CONFIG_KEY_TERMS_OF_SERVICE_URL, zIsAppFedrampHighCompliant ? BoxConfigConstants.CONFIG_TERMS_OF_SERVICE_URL_FEDRAMP_COMPLIANT : BoxConfigConstants.CONFIG_TERMS_OF_SERVICE_URL);
            }
            BoxLogUtils.v("AndroidForWork", String.format(Locale.ENGLISH, "Using ClientID: %s, Secret: %s", this.mClientId, this.mClientSecret != null ? "***(" + this.mClientSecret.length() + " chars)" : AbstractJsonLexerKt.NULL));
            this.mConfigManager.setCustomConfigValue(BoxConfigConstants.CONFIG_KEY_CLIENT_ID, this.mClientId);
            this.mConfigManager.setCustomConfigValue(BoxConfigConstants.CONFIG_KEY_CLIENT_SECRET, this.mClientSecret);
            savedAppRestrictions = latestAppRestrictions;
        }
        BoxUtils.logcatBundle(savedAppRestrictions, this.mContext);
        return savedAppRestrictions;
    }

    public void resetConfigsWithLatestRestrictions() {
        this.mRestrictionsManager.clearAppRestrictions();
        BoxBaseApplication.getInstance().getConfigManager().clearCustomConfigValues();
        initConfigBasedOnAppRestrictions();
        IAppRestrictionsManager iAppRestrictionsManager = this.mRestrictionsManager;
        iAppRestrictionsManager.commitAppRestrictions(iAppRestrictionsManager.getLatestAppRestrictions());
        BoxBaseApplication.getInstance().resetBoxClient();
    }
}
