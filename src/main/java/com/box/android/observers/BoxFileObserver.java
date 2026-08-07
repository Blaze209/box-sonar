package com.box.android.observers;

import android.net.Uri;
import android.os.FileObserver;
import com.box.android.application.BoxBaseApplication;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.coreservices.modelcontroller.IMoCoBoxTransfers;
import com.box.android.domain.identity.Crypto;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.usecases.jobs.JobTags;
import com.box.android.domain.utils.MimeTypeHelper;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.utils.BoxItemUtility;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import dagger.hilt.android.EntryPointAccessors;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

/* JADX INFO: loaded from: classes12.dex */
public final class BoxFileObserver extends FileObserver {
    private static final int MINIMUM_SIZE_REQUIREMENT = 5;
    private static Map<String, Integer> blockTypeMap;
    private final IBaseModelController mController;
    private ExpiringToken mExpiringToken;
    private final BoxExtendedApiFile mFileApi;
    private final String mFileId;
    private final String mFileName;
    private final String observedPath;
    public static final Map<Integer, String> FILE_OPS = Collections.unmodifiableMap(new HashMap<Integer, String>() { // from class: com.box.android.observers.BoxFileObserver.1
        private static final long serialVersionUID = 12726354;

        {
            put(1, "ACCESS");
            put(4, "ATTRIB");
            put(16, "CLOSE_NOWRITE");
            put(8, "CLOSE_WRITE");
            put(256, "CREATE");
            put(512, "DELETE");
            put(1024, "DELETE_SELF");
            put(2, "MODIFY");
            put(64, "MOVED_FROM");
            put(128, "MOVED_TO");
            put(2048, "MOVE_SELF");
            put(32, "OPEN");
        }
    });
    private static Map<String, BoxFileObserver> observers = new ConcurrentHashMap();

    interface BoxFileObserverEntryPoint {
        ILocalItemService boxFileObserverLocalItemService();
    }

    public static class ExpiringToken {
        private long mDelayMillis;
        Timer mTimer = new Timer();
        private volatile boolean expired = false;

        ExpiringToken(long j) {
            this.mDelayMillis = j;
        }

        void setExpired() {
            this.expired = true;
        }

        boolean isExpired() {
            return this.expired;
        }

        void cancel() {
            this.mTimer.cancel();
        }

        void startCountDown() {
            if (isExpired()) {
                return;
            }
            this.mTimer.schedule(new TimerTask() { // from class: com.box.android.observers.BoxFileObserver.ExpiringToken.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    ExpiringToken.this.setExpired();
                }
            }, this.mDelayMillis);
        }
    }

    static {
        HashMap map = new HashMap();
        blockTypeMap = map;
        map.put(MimeTypeHelper.getTypeFromExt("pdf"), 5);
        blockTypeMap.put(MimeTypeHelper.getTypeFromExt("doc"), 5);
        blockTypeMap.put(MimeTypeHelper.getTypeFromExt("docx"), 5);
        blockTypeMap.put(MimeTypeHelper.getTypeFromExt("xls"), 5);
        blockTypeMap.put(MimeTypeHelper.getTypeFromExt("xlsx"), 5);
        blockTypeMap.put(MimeTypeHelper.getTypeFromExt("ppt"), 5);
        blockTypeMap.put(MimeTypeHelper.getTypeFromExt("pptx"), 5);
    }

    private BoxFileObserver(String str, String str2, String str3, int i, IBaseModelController iBaseModelController, BoxExtendedApiFile boxExtendedApiFile) {
        super(str, i);
        this.observedPath = str;
        this.mFileId = str2;
        this.mFileName = str3;
        this.mController = iBaseModelController;
        this.mFileApi = boxExtendedApiFile;
        BoxLogUtils.v("BoxFileObserver Constructor path: " + str + " mask: " + i);
    }

    public static void registerObserver(File file, String str, String str2, int i, IMoCoBoxTransfers iMoCoBoxTransfers, IBaseModelController iBaseModelController, BoxExtendedApiFile boxExtendedApiFile) {
        if (observers.containsKey(file.getAbsolutePath())) {
            observers.get(file.getAbsolutePath()).stopWatching();
        }
        BoxFileObserver boxFileObserver = new BoxFileObserver(file.getAbsolutePath(), str, str2, i, iBaseModelController, boxExtendedApiFile);
        boxFileObserver.startWatching();
        observers.put(file.getAbsolutePath(), boxFileObserver);
    }

    public static void removeObserver(File file) {
        BoxFileObserver boxFileObserverRemove = observers.remove(file.getAbsolutePath());
        if (boxFileObserverRemove != null) {
            boxFileObserverRemove.stopWatching();
        }
    }

    public static boolean allowUpload(File file, BoxFile boxFile) {
        if (boxFile == null || !CommonBoxUtil.getFileExtension(boxFile.getName(), "").equalsIgnoreCase(CommonBoxUtil.getFileExtension(file.getName(), ""))) {
            return false;
        }
        String fileExtension = CommonBoxUtil.getFileExtension(boxFile.getName(), "");
        return blockTypeMap.get(MimeTypeHelper.getTypeFromExt(fileExtension)) == null || file.length() > ((long) blockTypeMap.get(MimeTypeHelper.getTypeFromExt(fileExtension)).intValue());
    }

    private void uploadCachedFile(File file) {
        BoxLogUtils.v("uploadCachedFile Write Dectected in BoxFileObserver on observed path:" + file.getAbsolutePath());
        try {
            BoxFile boxFile = (BoxFile) this.mController.performLocal(this.mFileApi.getInfoRequest(this.mFileId)).get().getResult();
            String sha1 = boxFile.getSha1();
            String strSha1 = "";
            if (file.exists() && file.canRead()) {
                if (!allowUpload(file, boxFile)) {
                    return;
                } else {
                    strSha1 = Crypto.sha1(new FileInputStream(file));
                }
            }
            BoxLogUtils.v("uploadFile local path:" + this.observedPath + " path: " + file.getAbsolutePath() + " new SHA1" + strSha1 + " old SHA1" + sha1);
            String name = boxFile.getName();
            BoxLogUtils.v("Write Dectected in BoxFileObserver old file :" + name + " path: old SHA1" + sha1);
            if (strSha1.equals(sha1)) {
                return;
            }
            BoxLogUtils.d("Starting Upload to :" + name);
            ILocalItemService iLocalItemServiceBoxFileObserverLocalItemService = ((BoxFileObserverEntryPoint) EntryPointAccessors.fromApplication(BoxBaseApplication.getInstance(), BoxFileObserverEntryPoint.class)).boxFileObserverLocalItemService();
            BoxFolder itemParentFolder = BoxItemUtility.getItemParentFolder(boxFile);
            String id = itemParentFolder != null ? itemParentFolder.getUserId() : null;
            if (id == null) {
                BoxLogUtils.e("BoxFileObserver", new IllegalStateException("Cannot re-upload cached file without parent folder id"));
                return;
            }
            HashSet hashSet = new HashSet();
            hashSet.add("job_source:" + JobTags.JobSource.UPLOAD_CACHED);
            iLocalItemServiceBoxFileObserverLocalItemService.uploadFile(boxFile.getName(), new ItemId.Remote(id, ItemType.FOLDER), Uri.parse(URLEncoder.encode(file.getAbsolutePath(), "UTF-8")), hashSet, true, new ItemId.Remote(boxFile.getUserId(), ItemType.FILE), new Continuation<Result<FileModel, ? extends DomainError>>() { // from class: com.box.android.observers.BoxFileObserver.2
                @Override // kotlin.coroutines.Continuation
                public void resumeWith(Object obj) {
                }

                @Override // kotlin.coroutines.Continuation
                public CoroutineContext getContext() {
                    return EmptyCoroutineContext.INSTANCE;
                }
            });
        } catch (Exception e) {
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            BoxLogUtils.logException(e);
        }
    }

    @Override // android.os.FileObserver
    public synchronized void onEvent(int i, String str) {
        if (FILE_OPS.containsKey(Integer.valueOf(i)) && str.equals(this.mFileName) && (i == 8 || i == 128)) {
            uploadCachedFile(new File(this.observedPath + "/" + str));
        }
    }

    @Override // android.os.FileObserver
    public void stopWatching() {
        super.stopWatching();
        ExpiringToken expiringToken = this.mExpiringToken;
        if (expiringToken != null) {
            expiringToken.cancel();
        }
    }

    public static void removeAllObservers() {
        Iterator<String> it = observers.keySet().iterator();
        while (it.hasNext()) {
            BoxFileObserver boxFileObserver = observers.get(it.next());
            if (boxFileObserver != null) {
                boxFileObserver.stopWatching();
            }
        }
    }
}
