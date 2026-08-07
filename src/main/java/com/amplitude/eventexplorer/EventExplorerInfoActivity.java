package com.amplitude.eventexplorer;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.amplitude.R;
import com.amplitude.api.Amplitude;
import com.microsoft.intune.mam.client.app.MAMActivity;
import com.microsoft.intune.mam.client.content.MAMClipboard;

/* JADX INFO: loaded from: classes9.dex */
public class EventExplorerInfoActivity extends MAMActivity {
    private ImageView closeImageView;
    private Button deviceIdCopyButton;
    private TextView deviceIdTextView;
    private Button userIdCopyButton;
    private TextView userIdTextView;

    @Override // com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        setContentView(R.layout.amp_activity_eventexplorer_info);
        ImageView imageView = (ImageView) findViewById(R.id.amp_eeInfo_iv_close);
        this.closeImageView = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.amplitude.eventexplorer.EventExplorerInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventExplorerInfoActivity.this.onBackPressed();
            }
        });
        this.deviceIdTextView = (TextView) findViewById(R.id.amp_eeInfo_tv_deviceId);
        this.userIdTextView = (TextView) findViewById(R.id.amp_eeInfo_tv_userId);
        String string = getIntent().getExtras().getString("instanceName");
        final String deviceId = Amplitude.getInstance(string).getDeviceId();
        final String userId = Amplitude.getInstance(string).getUserId();
        this.deviceIdTextView.setText(deviceId != null ? deviceId : getString(R.string.amp_label_not_avail));
        this.userIdTextView.setText(userId != null ? userId : getString(R.string.amp_label_not_avail));
        Button button = (Button) findViewById(R.id.amp_eeInfo_btn_copyDeviceId);
        this.deviceIdCopyButton = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.amplitude.eventexplorer.EventExplorerInfoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventExplorerInfoActivity.this.copyText(view.getContext(), deviceId);
            }
        });
        Button button2 = (Button) findViewById(R.id.amp_eeInfo_btn_copyUserId);
        this.userIdCopyButton = button2;
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.amplitude.eventexplorer.EventExplorerInfoActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventExplorerInfoActivity.this.copyText(view.getContext(), userId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void copyText(Context context, String str) {
        if (str != null) {
            MAMClipboard.setPrimaryClip((ClipboardManager) getSystemService("clipboard"), ClipData.newPlainText("copied text", str));
            Toast.makeText(context, getString(R.string.amp_label_copied), 0).show();
        }
    }
}
