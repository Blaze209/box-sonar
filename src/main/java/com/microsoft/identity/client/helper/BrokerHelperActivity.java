package com.microsoft.identity.client.helper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.microsoft.identity.common.internal.broker.PackageHelper;
import com.microsoft.identity.msal.R;
import com.microsoft.intune.mam.client.app.MAMActivity;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* JADX INFO: loaded from: classes14.dex */
public class BrokerHelperActivity extends MAMActivity {
    private final String MANIFEST_TEMPLATE = "<activity android:name=\"com.microsoft.identity.client.BrowserTabActivity\">\n    <intent-filter>\n        <action android:name=\"android.intent.action.VIEW\" />\n        <category android:name=\"android.intent.category.DEFAULT\" />\n        <category android:name=\"android.intent.category.BROWSABLE\" />\n        <data\n            android:host=\"%s\"\n            android:path=\"/%s\"\n            android:scheme=\"msauth\" />\n    </intent-filter>\n</activity>";
    TextView mManifest;
    TextView mPackageName;
    TextView mRedirect;
    TextView mSignature;

    public static Intent createStartIntent(Context context) {
        return new Intent(context, (Class<?>) BrokerHelperActivity.class);
    }

    @Override // com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        setContentView(R.layout.broker_helper);
        this.mPackageName = (TextView) findViewById(R.id.txtPackageName);
        this.mSignature = (TextView) findViewById(R.id.txtSignature);
        this.mRedirect = (TextView) findViewById(R.id.txtRedirect);
        this.mManifest = (TextView) findViewById(R.id.txtManifest);
        this.mSignature.append(getSignature(false));
        this.mRedirect.append(PackageHelper.getBrokerRedirectUri(getApplicationContext(), getPackageName()));
        this.mManifest.append(String.format("<activity android:name=\"com.microsoft.identity.client.BrowserTabActivity\">\n    <intent-filter>\n        <action android:name=\"android.intent.action.VIEW\" />\n        <category android:name=\"android.intent.category.DEFAULT\" />\n        <category android:name=\"android.intent.category.BROWSABLE\" />\n        <data\n            android:host=\"%s\"\n            android:path=\"/%s\"\n            android:scheme=\"msauth\" />\n    </intent-filter>\n</activity>", getPackageName(), getSignature(false)));
        this.mPackageName.append(getPackageName());
    }

    private String getSignature(boolean z) {
        String sha1SignatureForPackage = new PackageHelper(getApplicationContext().getPackageManager()).getSha1SignatureForPackage(getPackageName());
        if (!z) {
            return sha1SignatureForPackage;
        }
        try {
            return URLEncoder.encode(sha1SignatureForPackage, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            Log.e("getSignature", "Character encoding UTF-8 is not supported.", e);
            throw new RuntimeException("Unexpected: Unable to get the signature for this application package.");
        }
    }
}
