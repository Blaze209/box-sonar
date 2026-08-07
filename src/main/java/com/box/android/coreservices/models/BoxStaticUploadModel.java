package com.box.android.coreservices.models;

import android.content.Intent;
import android.net.Uri;
import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.common.utilities.BoxDateUtils;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.R;
import com.box.android.coreservices.jobmanager.dao.BoxUploadFile;
import com.box.android.coreservices.jobmanager.dao.UploadModelBoxFile;
import com.box.android.coreservices.localrepo.ILocalFiles;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.usecases.jobs.JobTags;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.BoxApiFile;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.requests.BoxRequestsFolder;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.utils.BoxItemUtility;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes9.dex */
public final class BoxStaticUploadModel {
    private static final String UNDERSCORE = "_";
    private static ConcurrentHashMap<String, UploadModelBoxFile> uploadList = new ConcurrentHashMap<>();
    private static BoxFolder currentFolder = null;
    private static HashMap<String, String> nameConflictMap = new HashMap<>();

    private BoxStaticUploadModel() {
    }

    public static boolean isUploading() {
        return !uploadList.isEmpty();
    }

    public static BoxFolder getCurrentFolder() {
        return currentFolder;
    }

    /* JADX WARN: Code duplicated, block: B:63:0x0161  */
    public static void parseIntent(Intent intent, BoxExtendedApiFolder boxExtendedApiFolder, IBaseModelController iBaseModelController, IUserContextManager iUserContextManager) throws ParseException {
        String string;
        boolean z;
        String str;
        if (intent == null) {
            return;
        }
        if (StringUtils.isNotEmpty(intent.getStringExtra("folder_id"))) {
            try {
                setCurrentUploadFolder(intent.getStringExtra("folder_id"), boxExtendedApiFolder, iBaseModelController);
            } catch (Exception e) {
                if (e instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                BoxLogUtils.logException(e);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        if (intent.getAction().equals("android.intent.action.VIEW")) {
            try {
                UploadModelBoxFile uri = parseUri(intent.getData());
                uri.setActionViewIntent(intent, iUserContextManager);
                uploadList.put(uri.getFileAbsolutePath(iUserContextManager), uri);
                return;
            } catch (ParseException e2) {
                BoxLogUtils.logException(e2);
                return;
            }
        }
        if (intent.getAction().equals("android.intent.action.SEND")) {
            Uri data = intent.getData();
            if (data == null && intent.getExtras() != null) {
                if (intent.getExtras().getString("android.intent.extra.TEXT") == null) {
                    string = "";
                } else {
                    string = intent.getExtras().getString("android.intent.extra.TEXT");
                    if (string.startsWith("http")) {
                        String[] strArrSplit = Pattern.compile("[,\\s]+").split(string);
                        for (int i = 0; i < strArrSplit.length; i++) {
                            if (strArrSplit[i].startsWith("http")) {
                                arrayList.add(Uri.parse(strArrSplit[i]));
                            }
                        }
                        addToUploadList(arrayList, iUserContextManager);
                        return;
                    }
                    if (intent.getType().toLowerCase(Locale.US).startsWith("text/")) {
                        String fileItemTime = BoxDateUtils.formatFileItemTime(System.currentTimeMillis(), ApplicationProvider.getApplication().getApplicationContext());
                        if (intent.getType().toLowerCase(Locale.US).equals("text/html")) {
                            str = fileItemTime + ".html";
                        } else {
                            str = fileItemTime + ".txt";
                        }
                        File file = new File(((ILocalFiles) iUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_FILES)).getDownloads().getTempDownloadDir(), str);
                        file.deleteOnExit();
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            try {
                                fileOutputStream.write(intent.getExtras().getString("android.intent.extra.TEXT").getBytes());
                                string = file.toURI().toString();
                                fileOutputStream.close();
                            } catch (Throwable th) {
                                try {
                                    fileOutputStream.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                                throw th;
                            }
                        } catch (IOException unused) {
                            z = true;
                        }
                    }
                    z = true;
                    if (intent.getExtras().get("android.intent.extra.STREAM") != null) {
                        string = intent.getExtras().get("android.intent.extra.STREAM").toString();
                    }
                    if (string.length() >= 1 && z) {
                        throw new ParseException("Problem extracting text", 0);
                    }
                    data = Uri.parse(string);
                }
                z = false;
                if (intent.getExtras().get("android.intent.extra.STREAM") != null) {
                    string = intent.getExtras().get("android.intent.extra.STREAM").toString();
                }
                if (string.length() >= 1) {
                }
                data = Uri.parse(string);
            }
            if (data != null) {
                arrayList.add(data);
            }
        }
        if (intent.getAction().equals("android.intent.action.SEND_MULTIPLE")) {
            arrayList = intent.getParcelableArrayListExtra("android.intent.extra.STREAM");
        }
        addToUploadList(arrayList, iUserContextManager);
    }

    public static void setCurrentUploadFolder(String str, BoxExtendedApiFolder boxExtendedApiFolder, IBaseModelController iBaseModelController) throws ExecutionException, InterruptedException {
        BoxResponse boxResponse = iBaseModelController.performLocal(boxExtendedApiFolder.getInfoRequest(str), null).get();
        if (boxResponse.isSuccess()) {
            currentFolder = (BoxFolder) boxResponse.getResult();
        } else {
            currentFolder = (BoxFolder) iBaseModelController.performLocal(boxExtendedApiFolder.getInfoRequest("0"), null).get().getResult();
        }
        if (currentFolder == null) {
            currentFolder = BoxFolder.createFromIdAndName("0", CommonBoxUtil.LS(R.string.files));
        }
        nameConflictMap = new HashMap<>();
        BoxResponse boxResponse2 = iBaseModelController.performLocal(boxExtendedApiFolder.getInfoRequest(currentFolder.getUserId()), null).get();
        if (boxResponse2.isSuccess()) {
            for (BoxItem boxItem : ((BoxFolder) boxResponse2.getResult()).getItemCollection()) {
                if (boxItem instanceof BoxFile) {
                    nameConflictMap.put(boxItem.getName().toLowerCase(Locale.ENGLISH), boxItem.getUserId());
                }
            }
        }
    }

    public static ArrayList<UploadModelBoxFile> addToUploadList(ArrayList<Uri> arrayList, IUserContextManager iUserContextManager) throws ParseException {
        ArrayList<UploadModelBoxFile> arrayList2 = new ArrayList<>(arrayList.size());
        for (Uri uri : arrayList) {
            if (uri != null) {
                UploadModelBoxFile uri2 = parseUri(uri);
                if (uploadList.put(uri2.getFileAbsolutePath(iUserContextManager), uri2) == null) {
                    arrayList2.add(uri2);
                }
            }
        }
        return arrayList2;
    }

    public static UploadModelBoxFile parseUri(Uri uri) throws ParseException {
        UploadModelBoxFile uploadModelBoxFile = new UploadModelBoxFile();
        uploadModelBoxFile.setUri(uri);
        uploadModelBoxFile.setId(Integer.toString(uri.hashCode()));
        return uploadModelBoxFile;
    }

    public static boolean nameAlreadyExists(String str) {
        return getConflictedFileId(str) != null;
    }

    public static String getConflictedFileId(String str) {
        HashMap<String, String> map = nameConflictMap;
        if (map == null || str == null) {
            return null;
        }
        return map.get(str.toLowerCase(Locale.ENGLISH));
    }

    public static void renameConflictingFiles(List<UploadModelBoxFile> list) {
        while (true) {
            int i = 1;
            for (UploadModelBoxFile uploadModelBoxFile : list) {
                String nameWithoutExtension = uploadModelBoxFile.getNameWithoutExtension();
                while (true) {
                    if (i < Integer.MAX_VALUE) {
                        uploadModelBoxFile.setNameWithoutExtension(nameWithoutExtension + UNDERSCORE + i);
                        if (nameConflictMap.containsKey(uploadModelBoxFile.getFileName().toLowerCase(Locale.ENGLISH))) {
                            i++;
                        }
                    }
                }
            }
            return;
        }
    }

    public static ArrayList<UploadModelBoxFile> getNameConflicts(BoxExtendedApiFolder boxExtendedApiFolder, IBaseModelController iBaseModelController) throws ExecutionException, InterruptedException {
        int i;
        ArrayList<UploadModelBoxFile> arrayList = new ArrayList<>();
        HashMap map = new HashMap();
        for (UploadModelBoxFile uploadModelBoxFile : uploadList.values()) {
            String lowerCase = uploadModelBoxFile.getFileName().toLowerCase(Locale.US);
            int iIntValue = map.get(lowerCase) != null ? ((Integer) map.get(lowerCase)).intValue() : 0;
            if (iIntValue > 0) {
                i = iIntValue + 1;
                uploadModelBoxFile.setNameWithoutExtension(uploadModelBoxFile.getNameWithoutExtension() + " (copy) " + i);
            } else {
                i = 1;
            }
            map.put(lowerCase, Integer.valueOf(i));
        }
        nameConflictMap = new HashMap<>();
        BoxRequestsFolder.GetFolderWithAllItems folderWithAllItems = boxExtendedApiFolder.getFolderWithAllItems(currentFolder.getUserId());
        BoxResponse boxResponse = iBaseModelController.performLocal(folderWithAllItems, null).get();
        if (!boxResponse.isSuccess() || boxResponse.getResult() == null) {
            boxResponse = (BoxResponse) iBaseModelController.performRemote(folderWithAllItems).get();
        }
        if (!boxResponse.isSuccess()) {
            return new ArrayList<>();
        }
        for (BoxItem boxItem : ((BoxFolder) boxResponse.getResult()).getItemCollection()) {
            if ((boxItem instanceof BoxFile) || (boxItem instanceof BoxFolder)) {
                nameConflictMap.put(boxItem.getName().toLowerCase(Locale.US), boxItem.getUserId());
            }
        }
        for (UploadModelBoxFile uploadModelBoxFile2 : uploadList.values()) {
            uploadModelBoxFile2.setFileName(uploadModelBoxFile2.getFileName().trim());
            if (uploadModelBoxFile2.isExistingNameConflict() && uploadModelBoxFile2.isEnabled()) {
                arrayList.add(uploadModelBoxFile2);
            } else if (uploadModelBoxFile2.isInvalidNameConflict() && uploadModelBoxFile2.isEnabled()) {
                arrayList.add(uploadModelBoxFile2);
            }
        }
        return arrayList;
    }

    public static ArrayList<UploadModelBoxFile> getOverUploadLimitFiles(long j, IUserContextManager iUserContextManager) {
        UploadModelBoxFile.UriFile file;
        ArrayList<UploadModelBoxFile> arrayList = new ArrayList<>();
        for (UploadModelBoxFile uploadModelBoxFile : uploadList.values()) {
            if (uploadModelBoxFile.isEnabled() && (file = uploadModelBoxFile.getFile(iUserContextManager)) != null) {
                uploadModelBoxFile.setOverUploadLimit(isOverUploadLimt(file.length(), Long.valueOf(j)));
                if (uploadModelBoxFile.isOverUploadLimit()) {
                    arrayList.add(uploadModelBoxFile);
                    uploadModelBoxFile.setEnabledStatus(false);
                }
            }
        }
        return arrayList;
    }

    public static ArrayList<UploadModelBoxFile> getErroredFiles(IUserContextManager iUserContextManager) {
        ArrayList<UploadModelBoxFile> arrayList = new ArrayList<>();
        for (UploadModelBoxFile uploadModelBoxFile : uploadList.values()) {
            if (uploadModelBoxFile.isEnabled()) {
                uploadModelBoxFile.getFile(iUserContextManager);
                if (uploadModelBoxFile.isFileErrorBackgroundThread(iUserContextManager)) {
                    arrayList.add(uploadModelBoxFile);
                    uploadModelBoxFile.setEnabledStatus(false);
                }
            }
        }
        return arrayList;
    }

    public static List<UploadModelBoxFile> getUploadList() {
        return new ArrayList(uploadList.values());
    }

    public static void doUpload(BoxUploadFile.ConflictResolution conflictResolution, IBaseModelController iBaseModelController, BoxApiFile boxApiFile, IUserContextManager iUserContextManager, JobTags.JobSource jobSource, ILocalItemService iLocalItemService) {
        BoxUploadFile boxUploadFile;
        ArrayList<BoxUploadFile> arrayList = new ArrayList(getUploadList().size());
        Iterator<UploadModelBoxFile> it = getUploadList().iterator();
        while (true) {
            BoxFile boxFile = null;
            if (!it.hasNext()) {
                break;
            }
            UploadModelBoxFile next = it.next();
            if (next.isEnabled()) {
                if (next.isOverwriteExisting()) {
                    try {
                        try {
                            boxFile = (BoxFile) iBaseModelController.performLocal(boxApiFile.getInfoRequest(next.getConflictedFileId())).get().getResult();
                        } catch (Exception e) {
                            e = e;
                            if (e instanceof InterruptedException) {
                                Thread.currentThread().interrupt();
                            }
                            BoxLogUtils.logException(e);
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                }
                UploadModelBoxFile.UriFile file = next.getFile(iUserContextManager);
                if (file != null) {
                    if (boxFile != null) {
                        boxUploadFile = new BoxUploadFile(boxFile, next.getFileName(), file);
                    } else {
                        boxUploadFile = new BoxUploadFile(getCurrentFolder(), next.getFileName(), file);
                    }
                    boxUploadFile.setOnConflictResolution(conflictResolution);
                    arrayList.add(boxUploadFile);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            for (BoxUploadFile boxUploadFile2 : arrayList) {
                String sourceJavaFilePath = boxUploadFile2.getSourceJavaFilePath();
                try {
                    sourceJavaFilePath = URLEncoder.encode(boxUploadFile2.getSourceJavaFilePath(), "UTF-8");
                } catch (UnsupportedEncodingException e3) {
                    BoxLogUtils.logException(e3);
                }
                String sourceBoxFileId = boxUploadFile2.getSourceBoxFileId();
                ItemId remote = !StringUtils.isEmpty(sourceBoxFileId) ? new ItemId.Remote(sourceBoxFileId, ItemType.FILE) : null;
                String parentFolderId = boxUploadFile2.getParentFolderId();
                if (parentFolderId == null) {
                    parentFolderId = BoxItemUtility.getItemParentFolder(boxUploadFile2.getSourceBoxFile()).getUserId();
                }
                ItemId remote2 = new ItemId.Remote(parentFolderId, ItemType.FOLDER);
                HashSet hashSet = new HashSet();
                hashSet.add("job_source:" + jobSource);
                iLocalItemService.uploadFile(boxUploadFile2.getFileName(), remote2, Uri.parse(sourceJavaFilePath), hashSet, true, remote, new Continuation<Result<FileModel, ? extends DomainError>>() { // from class: com.box.android.coreservices.models.BoxStaticUploadModel.1
                    @Override // kotlin.coroutines.Continuation
                    public void resumeWith(Object obj) {
                    }

                    @Override // kotlin.coroutines.Continuation
                    public CoroutineContext getContext() {
                        return EmptyCoroutineContext.INSTANCE;
                    }
                });
            }
        }
        clearUploads();
    }

    public static boolean hasOverwritingFiles(List<UploadModelBoxFile> list) {
        for (UploadModelBoxFile uploadModelBoxFile : list) {
            if (uploadModelBoxFile.isEnabled() && uploadModelBoxFile.isOverwriteExisting()) {
                return true;
            }
        }
        return false;
    }

    public static void clearUploads() {
        uploadList.clear();
    }

    public static void clearUploadFolder() {
        currentFolder = null;
    }

    public static boolean isOverUploadLimt(long j, Long l) {
        return l.longValue() >= 26214400 && l.longValue() <= j;
    }
}
