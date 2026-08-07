package com.microsoft.intune.mam.client.app.startup;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.microsoft.intune.mam.client.content.pm.PackageManagerCompat;
import com.microsoft.intune.mam.client.telemetry.events.MAMInterfaceError;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class ADALConnectionDetails implements Parcelable {
    public static final String DEFAULT_AUTHORITY = "https://login.windows.net/common/";
    public static final String DEFAULT_CLIENT_ID = "6c7e8096-f593-4d72-807f-a5f86dcc9c77";
    public static final String DEFAULT_NON_BROKER_REDIRECT_URI = "urn:ietf:wg:oauth:2.0:oob";
    public static final boolean DEFAULT_SKIP_BROKER_APP_ADAL = false;
    public static final boolean DEFAULT_SKIP_BROKER_NO_APP_ADAL = true;
    private static final String KEY_AUTHORITY = "com.microsoft.intune.mam.aad.Authority";
    private static final String KEY_CLIENT_ID = "com.microsoft.intune.mam.aad.ClientID";
    private static final String KEY_NON_BROKER_REDIRECT_URI = "com.microsoft.intune.mam.aad.NonBrokerRedirectUri";
    private static final String KEY_NON_BROKER_REDIRECT_URI_ALT = "com.microsoft.intune.mam.aad.NonBrokerRedirectURI";
    private static final String KEY_SKIP_BROKER = "com.microsoft.intune.mam.aad.SkipBroker";
    private final String mAuthority;
    private final String mClientId;
    private final String mNonBrokerRedirectUri;
    private boolean mSkipBroker;
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(ADALConnectionDetails.class);
    public static final Parcelable.Creator<ADALConnectionDetails> CREATOR = new Parcelable.Creator<ADALConnectionDetails>() { // from class: com.microsoft.intune.mam.client.app.startup.ADALConnectionDetails.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ADALConnectionDetails createFromParcel(Parcel parcel) {
            return ADALConnectionDetails.fromJSON(parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ADALConnectionDetails[] newArray(int i) {
            return new ADALConnectionDetails[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ADALConnectionDetails(String str, String str2, String str3, boolean z) {
        this.mAuthority = str;
        this.mClientId = str2;
        this.mNonBrokerRedirectUri = str3;
        this.mSkipBroker = z;
    }

    public String getAuthority() {
        return this.mAuthority;
    }

    public String getClientId() {
        return this.mClientId;
    }

    public String getNonBrokerRedirectUri() {
        return this.mNonBrokerRedirectUri;
    }

    public boolean getSkipBroker() {
        return this.mSkipBroker;
    }

    public static ADALConnectionDetails getAppManifestConnectionDetails(String str, PackageManager packageManager) {
        try {
            Bundle bundle = PackageManagerCompat.getApplicationInfo(packageManager, str, 128L).metaData;
            String string = DEFAULT_AUTHORITY;
            String string2 = DEFAULT_CLIENT_ID;
            String string3 = "urn:ietf:wg:oauth:2.0:oob";
            boolean z = true;
            if (bundle != null) {
                if (bundle.containsKey(KEY_AUTHORITY)) {
                    string = bundle.getString(KEY_AUTHORITY, null);
                }
                if (bundle.containsKey(KEY_CLIENT_ID)) {
                    string2 = bundle.getString(KEY_CLIENT_ID);
                }
                if (bundle.containsKey(KEY_NON_BROKER_REDIRECT_URI)) {
                    string3 = bundle.getString(KEY_NON_BROKER_REDIRECT_URI);
                } else if (bundle.containsKey(KEY_NON_BROKER_REDIRECT_URI_ALT)) {
                    string3 = bundle.getString(KEY_NON_BROKER_REDIRECT_URI_ALT);
                }
                if (bundle.containsKey(KEY_CLIENT_ID) || bundle.containsKey(KEY_SKIP_BROKER)) {
                    z = bundle.getBoolean(KEY_SKIP_BROKER, false);
                }
            }
            return new ADALConnectionDetails(string, string2, string3, z);
        } catch (PackageManager.NameNotFoundException unused) {
            throw new AssertionError("Application info for calling app could not be found");
        }
    }

    public static ADALConnectionDetails tryGetAppManifestConnectionDetails(String str, PackageManager packageManager) {
        try {
            Bundle bundle = PackageManagerCompat.getApplicationInfo(packageManager, str, 128L).metaData;
            if (bundle == null) {
                return null;
            }
            String string = bundle.getString(KEY_AUTHORITY, null);
            String string2 = bundle.getString(KEY_CLIENT_ID, null);
            if (string != null && string2 != null) {
                String string3 = bundle.getString(KEY_NON_BROKER_REDIRECT_URI);
                if (string3 == null) {
                    string3 = bundle.getString(KEY_NON_BROKER_REDIRECT_URI_ALT, "urn:ietf:wg:oauth:2.0:oob");
                }
                return new ADALConnectionDetails(string, string2, string3, (bundle.containsKey(KEY_CLIENT_ID) || bundle.containsKey(KEY_SKIP_BROKER)) ? bundle.getBoolean(KEY_SKIP_BROKER, false) : false);
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public String toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_AUTHORITY, this.mAuthority);
            jSONObject.put(KEY_CLIENT_ID, this.mClientId);
            jSONObject.put(KEY_NON_BROKER_REDIRECT_URI, this.mNonBrokerRedirectUri);
            jSONObject.put(KEY_SKIP_BROKER, this.mSkipBroker);
        } catch (JSONException e) {
            LOGGER.error(MAMInterfaceError.ADAL_CONN_DETAILS_JSON_ERROR, "Error creating ADAL details JSON", e);
        }
        return jSONObject.toString();
    }

    public static ADALConnectionDetails fromJSON(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new ADALConnectionDetails(jSONObject.getString(KEY_AUTHORITY), jSONObject.getString(KEY_CLIENT_ID), jSONObject.getString(KEY_NON_BROKER_REDIRECT_URI), jSONObject.getBoolean(KEY_SKIP_BROKER));
        } catch (JSONException e) {
            LOGGER.error(MAMInterfaceError.ADAL_CONN_DETAILS_JSON_ERROR, "Error parsing ADAL details from JSON", e);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(toJSON());
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ADALConnectionDetails)) {
            ADALConnectionDetails aDALConnectionDetails = (ADALConnectionDetails) obj;
            if (this.mAuthority.equals(aDALConnectionDetails.mAuthority) && this.mClientId.equals(aDALConnectionDetails.mClientId) && this.mNonBrokerRedirectUri.equals(aDALConnectionDetails.mNonBrokerRedirectUri) && this.mSkipBroker == aDALConnectionDetails.mSkipBroker) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return toJSON().hashCode();
    }

    public String toString() {
        return toJSON();
    }
}
