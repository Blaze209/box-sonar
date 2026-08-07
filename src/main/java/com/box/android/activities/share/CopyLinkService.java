package com.box.android.activities.share;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import com.box.android.R;
import com.box.android.application.BoxBaseApplication;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.coreservices.api.ShareController;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.requests.BoxResponse;
import com.microsoft.intune.mam.client.content.MAMClipboard;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes9.dex */
public class CopyLinkService extends Hilt_CopyLinkService {
    private static final String EXTRA_SHARE_ITEM = "com.box.android.activities.share.extra.SHARE_ITEM";

    @Inject
    ShareController mController;

    public CopyLinkService() {
        super("CopyLinkService");
    }

    public static void startCopyLinkService(Context context, BoxItem boxItem) {
        Intent intent = new Intent(context, (Class<?>) CopyLinkService.class);
        intent.putExtra(EXTRA_SHARE_ITEM, boxItem);
        context.startService(intent);
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        BoxItem boxItem = (BoxItem) intent.getSerializableExtra(EXTRA_SHARE_ITEM);
        if (boxItem != null) {
            this.mController.createDefaultSharedLink(boxItem).addOnCompletedListener(new BoxFutureTask.OnCompletedListener<BoxItem>() { // from class: com.box.android.activities.share.CopyLinkService.1
                @Override // com.box.androidsdk.content.BoxFutureTask.OnCompletedListener
                public void onCompleted(BoxResponse<BoxItem> boxResponse) {
                    if (boxResponse.isSuccess()) {
                        MAMClipboard.setPrimaryClip((ClipboardManager) CopyLinkService.this.getSystemService("clipboard"), ClipData.newPlainText("", ((BoxItem) boxResponse.getResult()).getSharedLink().getURL()));
                        BoxPresentationUtils.displayToast(R.string.box_sharesdk_link_copied_to_clipboard, BoxBaseApplication.getInstance().getApplicationContext(), new String[0]);
                        return;
                    }
                    BoxPresentationUtils.displayToast(R.string.box_sharesdk_problem_accessing_this_shared_link, BoxBaseApplication.getInstance().getApplicationContext(), new String[0]);
                }
            });
        } else {
            BoxPresentationUtils.displayToast(R.string.box_sharesdk_problem_accessing_this_shared_link, BoxBaseApplication.getInstance().getApplicationContext(), new String[0]);
        }
    }
}
