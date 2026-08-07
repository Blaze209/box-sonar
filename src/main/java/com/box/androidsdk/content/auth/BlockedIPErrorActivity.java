package com.box.androidsdk.content.auth;

import android.os.Bundle;
import android.view.View;
import com.box.android.dataaccess.content.R;
import com.microsoft.intune.mam.client.app.MAMActivity;

/* JADX INFO: loaded from: classes13.dex */
public class BlockedIPErrorActivity extends MAMActivity {
    @Override // com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        setContentView(R.layout.blocked_ip_error);
        findViewById(R.id.ok).setOnClickListener(new View.OnClickListener() { // from class: com.box.androidsdk.content.auth.BlockedIPErrorActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BlockedIPErrorActivity.this.finish();
            }
        });
    }
}
