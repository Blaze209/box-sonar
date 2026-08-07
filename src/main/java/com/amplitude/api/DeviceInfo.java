package com.amplitude.api;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.LocaleList;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import androidx.autofill.HintConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: loaded from: classes9.dex */
public class DeviceInfo {
    public static final String OS_NAME = "android";
    private static final String SETTING_ADVERTISING_ID = "advertising_id";
    private static final String SETTING_LIMIT_AD_TRACKING = "limit_ad_tracking";
    private static final String TAG = "com.amplitude.api.DeviceInfo";
    private CachedInfo cachedInfo;
    private Context context;
    private boolean locationListening;

    private class CachedInfo {
        private String advertisingId;
        private String appSetId;
        private String brand;
        private String carrier;
        private String country;
        private boolean gpsEnabled;
        private String language;
        private boolean limitAdTrackingEnabled;
        private String manufacturer;
        private String model;
        private String osName;
        private String osVersion;
        private String versionName;

        private CachedInfo() {
            this.advertisingId = getAdvertisingId();
            this.versionName = getVersionName();
            this.osName = getOsName();
            this.osVersion = getOsVersion();
            this.brand = getBrand();
            this.manufacturer = getManufacturer();
            this.model = getModel();
            this.carrier = getCarrier();
            this.country = getCountry();
            this.language = getLanguage();
            this.gpsEnabled = checkGPSEnabled();
            this.appSetId = getAppSetId();
        }

        private String getVersionName() {
            try {
                return MAMPackageManagement.getPackageInfo(DeviceInfo.this.context.getPackageManager(), DeviceInfo.this.context.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException | Exception unused) {
                return null;
            }
        }

        private String getOsName() {
            return "android";
        }

        private String getOsVersion() {
            return Build.VERSION.RELEASE;
        }

        private String getBrand() {
            return Build.BRAND;
        }

        private String getManufacturer() {
            return Build.MANUFACTURER;
        }

        private String getModel() {
            return Build.MODEL;
        }

        private String getCarrier() {
            try {
                return ((TelephonyManager) DeviceInfo.this.context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE)).getNetworkOperatorName();
            } catch (Exception unused) {
                return null;
            }
        }

        private String getCountry() {
            String countryFromLocation = getCountryFromLocation();
            if (!Utils.isEmptyString(countryFromLocation)) {
                return countryFromLocation;
            }
            String countryFromNetwork = getCountryFromNetwork();
            return !Utils.isEmptyString(countryFromNetwork) ? countryFromNetwork : getCountryFromLocale();
        }

        private String getCountryFromLocation() {
            Location mostRecentLocation;
            List<Address> fromLocation;
            if (DeviceInfo.this.isLocationListening() && (mostRecentLocation = DeviceInfo.this.getMostRecentLocation()) != null) {
                try {
                    if (Geocoder.isPresent() && (fromLocation = DeviceInfo.this.getGeocoder().getFromLocation(mostRecentLocation.getLatitude(), mostRecentLocation.getLongitude(), 1)) != null) {
                        for (Address address : fromLocation) {
                            if (address != null) {
                                return address.getCountryCode();
                            }
                        }
                    }
                } catch (IOException | IllegalArgumentException | IllegalStateException | NoSuchMethodError | NullPointerException | SecurityException unused) {
                }
            }
            return null;
        }

        private String getCountryFromNetwork() {
            String networkCountryIso;
            try {
                TelephonyManager telephonyManager = (TelephonyManager) DeviceInfo.this.context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
                if (telephonyManager.getPhoneType() == 2 || (networkCountryIso = telephonyManager.getNetworkCountryIso()) == null) {
                    return null;
                }
                return networkCountryIso.toUpperCase(Locale.US);
            } catch (Exception unused) {
                return null;
            }
        }

        private Locale getLocale() {
            LocaleList locales = Resources.getSystem().getConfiguration().getLocales();
            if (locales.isEmpty()) {
                return Locale.getDefault();
            }
            return locales.get(0);
        }

        private String getCountryFromLocale() {
            return getLocale().getCountry();
        }

        private String getLanguage() {
            return getLocale().getLanguage();
        }

        private String getAdvertisingId() {
            if ("Amazon".equals(getManufacturer())) {
                return getAndCacheAmazonAdvertisingId();
            }
            return getAndCacheGoogleAdvertisingId();
        }

        private String getAppSetId() {
            try {
                Object objInvoke = Class.forName("com.google.android.gms.appset.AppSet").getMethod("getClient", Context.class).invoke(null, DeviceInfo.this.context);
                Object objInvoke2 = Class.forName("com.google.android.gms.tasks.Tasks").getMethod("await", Class.forName("com.google.android.gms.tasks.Task")).invoke(null, objInvoke.getClass().getMethod("getAppSetIdInfo", new Class[0]).invoke(objInvoke, new Object[0]));
                this.appSetId = (String) objInvoke2.getClass().getMethod("getId", new Class[0]).invoke(objInvoke2, new Object[0]);
            } catch (ClassNotFoundException unused) {
                AmplitudeLog.getLogger().w(DeviceInfo.TAG, "Google Play Services SDK not found for app set id!");
            } catch (InvocationTargetException unused2) {
                AmplitudeLog.getLogger().w(DeviceInfo.TAG, "Google Play Services not available for app set id");
            } catch (Exception e) {
                AmplitudeLog.getLogger().e(DeviceInfo.TAG, "Encountered an error connecting to Google Play Services for app set id", e);
            }
            return this.appSetId;
        }

        private String getAndCacheAmazonAdvertisingId() {
            ContentResolver contentResolver = DeviceInfo.this.context.getContentResolver();
            this.limitAdTrackingEnabled = Settings.Secure.getInt(contentResolver, DeviceInfo.SETTING_LIMIT_AD_TRACKING, 0) == 1;
            String string = Settings.Secure.getString(contentResolver, DeviceInfo.SETTING_ADVERTISING_ID);
            this.advertisingId = string;
            return string;
        }

        private String getAndCacheGoogleAdvertisingId() {
            try {
                boolean z = true;
                Object objInvoke = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", Context.class).invoke(null, DeviceInfo.this.context);
                Boolean bool = (Boolean) objInvoke.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(objInvoke, new Object[0]);
                if (bool == null || !bool.booleanValue()) {
                    z = false;
                }
                this.limitAdTrackingEnabled = z;
                this.advertisingId = (String) objInvoke.getClass().getMethod("getId", new Class[0]).invoke(objInvoke, new Object[0]);
            } catch (ClassNotFoundException unused) {
                AmplitudeLog.getLogger().w(DeviceInfo.TAG, "Google Play Services SDK not found for advertising id!");
            } catch (InvocationTargetException unused2) {
                AmplitudeLog.getLogger().w(DeviceInfo.TAG, "Google Play Services not available for advertising id");
            } catch (Exception e) {
                AmplitudeLog.getLogger().e(DeviceInfo.TAG, "Encountered an error connecting to Google Play Services for advertising id", e);
            }
            return this.advertisingId;
        }

        private boolean checkGPSEnabled() {
            try {
                Integer num = (Integer) Class.forName("com.google.android.gms.common.GooglePlayServicesUtil").getMethod("isGooglePlayServicesAvailable", Context.class).invoke(null, DeviceInfo.this.context);
                return num != null && num.intValue() == 0;
            } catch (ClassNotFoundException unused) {
                AmplitudeLog.getLogger().w(DeviceInfo.TAG, "Google Play Services Util not found!");
                return false;
            } catch (IllegalAccessException unused2) {
                AmplitudeLog.getLogger().w(DeviceInfo.TAG, "Google Play Services not available");
                return false;
            } catch (NoClassDefFoundError unused3) {
                AmplitudeLog.getLogger().w(DeviceInfo.TAG, "Google Play Services Util not found!");
                return false;
            } catch (NoSuchMethodException unused4) {
                AmplitudeLog.getLogger().w(DeviceInfo.TAG, "Google Play Services not available");
                return false;
            } catch (InvocationTargetException unused5) {
                AmplitudeLog.getLogger().w(DeviceInfo.TAG, "Google Play Services not available");
                return false;
            } catch (Exception e) {
                AmplitudeLog.getLogger().w(DeviceInfo.TAG, "Error when checking for Google Play Services: " + e);
                return false;
            }
        }
    }

    public DeviceInfo(Context context, boolean z) {
        this.context = context;
        this.locationListening = z;
    }

    private CachedInfo getCachedInfo() {
        if (this.cachedInfo == null) {
            this.cachedInfo = new CachedInfo();
        }
        return this.cachedInfo;
    }

    public void prefetch() {
        getCachedInfo();
    }

    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }

    public String getVersionName() {
        return getCachedInfo().versionName;
    }

    public String getOsName() {
        return getCachedInfo().osName;
    }

    public String getOsVersion() {
        return getCachedInfo().osVersion;
    }

    public String getBrand() {
        return getCachedInfo().brand;
    }

    public String getManufacturer() {
        return getCachedInfo().manufacturer;
    }

    public String getModel() {
        return getCachedInfo().model;
    }

    public String getCarrier() {
        return getCachedInfo().carrier;
    }

    public String getCountry() {
        return getCachedInfo().country;
    }

    public String getLanguage() {
        return getCachedInfo().language;
    }

    public String getAdvertisingId() {
        return getCachedInfo().advertisingId;
    }

    public boolean isLimitAdTrackingEnabled() {
        return getCachedInfo().limitAdTrackingEnabled;
    }

    public String getAppSetId() {
        return getCachedInfo().appSetId;
    }

    public boolean isGooglePlayServicesEnabled() {
        return getCachedInfo().gpsEnabled;
    }

    public Location getMostRecentLocation() {
        LocationManager locationManager;
        List<String> providers;
        Location lastKnownLocation;
        Location location = null;
        if (!isLocationListening() || !Utils.checkLocationPermissionAllowed(this.context) || (locationManager = (LocationManager) this.context.getSystemService(FirebaseAnalytics.Param.LOCATION)) == null) {
            return null;
        }
        try {
            providers = locationManager.getProviders(true);
        } catch (SecurityException | Exception unused) {
            providers = null;
        }
        if (providers == null) {
            return null;
        }
        ArrayList<Location> arrayList = new ArrayList();
        Iterator<String> it = providers.iterator();
        while (it.hasNext()) {
            try {
                lastKnownLocation = locationManager.getLastKnownLocation(it.next());
            } catch (SecurityException unused2) {
                AmplitudeLog.getLogger().w(TAG, "Failed to get most recent location");
                lastKnownLocation = null;
            } catch (Exception unused3) {
                AmplitudeLog.getLogger().w(TAG, "Failed to get most recent location");
                lastKnownLocation = null;
            }
            if (lastKnownLocation != null) {
                arrayList.add(lastKnownLocation);
            }
        }
        long time = -1;
        for (Location location2 : arrayList) {
            if (location2.getTime() > time) {
                time = location2.getTime();
                location = location2;
            }
        }
        return location;
    }

    public boolean isLocationListening() {
        return this.locationListening;
    }

    public void setLocationListening(boolean z) {
        this.locationListening = z;
    }

    protected Geocoder getGeocoder() {
        return new Geocoder(this.context, Locale.ENGLISH);
    }
}
