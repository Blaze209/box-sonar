package com.box.androidsdk.content.views;

import android.content.Context;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxDownload;
import java.io.File;

/* JADX INFO: loaded from: classes13.dex */
public class OfflineAvatarController extends DefaultAvatarController {
    final Context mContext;

    @Override // com.box.androidsdk.content.views.DefaultAvatarController, com.box.androidsdk.content.views.BoxAvatarView.AvatarController
    public BoxFutureTask<BoxDownload> executeAvatarDownloadRequest(String str, BoxAvatarView boxAvatarView) {
        return null;
    }

    public OfflineAvatarController(Context context) {
        super(null);
        this.mContext = context.getApplicationContext();
    }

    @Override // com.box.androidsdk.content.views.DefaultAvatarController
    protected File getAvatarDir(String str) {
        File file = new File(this.mContext.getFilesDir().getAbsolutePath() + File.separator + str + File.separator + "avatar");
        cleanOutOldAvatars(file, 30);
        return file;
    }
}
