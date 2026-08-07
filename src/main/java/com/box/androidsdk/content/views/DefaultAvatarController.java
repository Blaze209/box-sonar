package com.box.androidsdk.content.views;

import com.box.androidsdk.content.BoxApiUser;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxDownload;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes13.dex */
public class DefaultAvatarController implements BoxAvatarView.AvatarController, Serializable {
    private static final String DEFAULT_AVATAR_DIR_NAME = "avatar";
    private static final String DEFAULT_AVATAR_EXTENSiON = "jpg";
    private static final String DEFAULT_AVATAR_FILE_PREFIX = "avatar_";
    protected static final int DEFAULT_MAX_AGE = 30;
    protected transient BoxApiUser mApiUser;
    protected transient ThreadPoolExecutor mExecutor;
    protected BoxSession mSession;
    protected HashSet<String> mUnavailableAvatars = new HashSet<>();
    protected HashSet<String> mCleanedDirectories = new HashSet<>();

    public DefaultAvatarController(BoxSession boxSession) {
        this.mSession = boxSession;
        this.mApiUser = new BoxApiUser(boxSession);
    }

    protected File getAvatarDir(String str) {
        File file = new File(this.mSession.getCacheDir(), DEFAULT_AVATAR_DIR_NAME);
        if (!file.exists()) {
            file.mkdirs();
        }
        cleanOutOldAvatars(file, 30);
        return file;
    }

    @Override // com.box.androidsdk.content.views.BoxAvatarView.AvatarController
    public File getAvatarFile(String str) {
        return new File(getAvatarDir(str), DEFAULT_AVATAR_FILE_PREFIX + str + ".jpg");
    }

    protected BoxApiUser getApiUser() {
        return this.mApiUser;
    }

    protected BoxSession getSession() {
        return this.mSession;
    }

    protected void cleanOutOldAvatars(File file, int i) {
        if (file == null || this.mCleanedDirectories.contains(file.getAbsolutePath())) {
            return;
        }
        long j = i;
        long jCurrentTimeMillis = System.currentTimeMillis() - (j * TimeUnit.DAYS.toMillis(j));
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.getName().startsWith(DEFAULT_AVATAR_FILE_PREFIX) && file2.lastModified() < jCurrentTimeMillis) {
                    file2.delete();
                }
            }
        }
    }

    @Override // com.box.androidsdk.content.views.BoxAvatarView.AvatarController
    public BoxFutureTask<BoxDownload> executeAvatarDownloadRequest(final String str, BoxAvatarView boxAvatarView) {
        final WeakReference weakReference = new WeakReference(boxAvatarView);
        try {
            final File avatarFile = getAvatarFile(str);
            if (this.mUnavailableAvatars.contains(avatarFile.getAbsolutePath())) {
                return null;
            }
            BoxFutureTask task = getApiUser().getDownloadAvatarRequest(getAvatarDir(str), str).toTask();
            task.addOnCompletedListener(new BoxFutureTask.OnCompletedListener<BoxDownload>() { // from class: com.box.androidsdk.content.views.DefaultAvatarController.1
                @Override // com.box.androidsdk.content.BoxFutureTask.OnCompletedListener
                public void onCompleted(BoxResponse<BoxDownload> boxResponse) {
                    if (boxResponse.isSuccess()) {
                        BoxAvatarView boxAvatarView2 = (BoxAvatarView) weakReference.get();
                        if (boxAvatarView2 != null) {
                            boxAvatarView2.updateAvatar();
                            return;
                        }
                        return;
                    }
                    if ((boxResponse.getException() instanceof BoxException) && ((BoxException) boxResponse.getException()).getResponseCode() == 404) {
                        DefaultAvatarController.this.mUnavailableAvatars.add(DefaultAvatarController.this.getAvatarFile(str).getAbsolutePath());
                    }
                    File file = avatarFile;
                    if (file != null) {
                        file.delete();
                    }
                }
            });
            executeTask(task);
            return task;
        } catch (IOException e) {
            BoxLogUtils.e("unable to createFile ", e);
            return null;
        }
    }

    protected void executeTask(BoxFutureTask boxFutureTask) {
        if (this.mExecutor == null) {
            this.mExecutor = SdkUtils.createDefaultThreadPoolExecutor(2, 2, 3600L, TimeUnit.SECONDS);
        }
        this.mExecutor.execute(boxFutureTask);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        if (getApiUser() == null) {
            this.mApiUser = new BoxApiUser(this.mSession);
        }
    }
}
