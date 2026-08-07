package com.box.android.coreservices.jobmanager.dao;

import android.net.Uri;
import android.text.TextUtils;
import androidx.documentfile.provider.DocumentFile;
import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.common.utilities.FileSizeUtils;
import com.box.android.common.utilities.FileUtil;
import com.box.android.coreservices.modelcontroller.MoCoContainerBuilder;
import com.box.android.coreservices.models.BoxStaticUploadModel;
import com.box.android.domain.identity.IUserContextManager;
import com.box.androidsdk.content.models.BoxEntity;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import java.io.File;
import java.text.ParseException;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes9.dex */
public class BoxUploadFile extends BoxFile {
    public static final String FILE_NAME = "mFileName";
    public static final String FILE_SIZE = "mFileSize";
    public static final String ON_CONFLICT_RESOLUTION = "mOnConflictResolution";
    public static final String PARENT_FOLDER = "mParentFolder";
    public static final String PARENT_FOLDER_ID = "mParentFolderId";
    public static final String SOURCE_BOX_FILE = "mSourceBoxFile";
    public static final String SOURCE_BOX_FILE_ID = "mSourceBoxFileId";
    public static final String SOURCE_JAVA_FILE_PATH = "mSourceJavaFilePath";
    public static final String SOURCE_URI = "mSourceUri";
    private static final long serialVersionUID = -3208652104748277043L;
    private transient boolean mIsInitialized;

    public enum ConflictResolution {
        SKIP,
        FAIL,
        RENAME,
        UPLOAD_NEW_VERSION
    }

    public BoxUploadFile() {
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0021 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:8:0x0023  */
    private BoxUploadFile(String str, File file) {
        setFileName(str);
        if (file instanceof UploadModelBoxFile.UriFile) {
            UploadModelBoxFile.UriFile uriFile = (UploadModelBoxFile.UriFile) file;
            if (uriFile.getUri() != null) {
                set(SOURCE_URI, uriFile.getUri().toString());
            } else if (file != null) {
                setSourceJavaFilePath(file.getAbsolutePath());
            }
        } else if (file != null) {
            setSourceJavaFilePath(file.getAbsolutePath());
        }
        setFileSize(Long.valueOf(FileSizeUtils.sizeOf(getDocumentFile())));
    }

    public BoxUploadFile(BoxFolder boxFolder, String str, File file) {
        this(str, file);
        setParentFolder(boxFolder);
        setParentFolderId(boxFolder.getUserId());
    }

    public static BoxUploadFile createFromUri(BoxFolder boxFolder, Uri uri, IUserContextManager iUserContextManager) throws ParseException {
        BoxUploadFile boxUploadFile = new BoxUploadFile();
        UploadModelBoxFile uri2 = BoxStaticUploadModel.parseUri(uri);
        UploadModelBoxFile.UriFile file = uri2.getFile(iUserContextManager);
        boxUploadFile.setFileName(uri2.getFileName());
        if (file != null) {
            boxUploadFile.setSourceJavaFilePath(file.getAbsolutePath());
        }
        boxUploadFile.setFileSize(Long.valueOf(FileSizeUtils.sizeOf(boxUploadFile.getDocumentFile())));
        boxUploadFile.setParentFolder(boxFolder);
        boxUploadFile.setParentFolderId(boxFolder.getUserId());
        return boxUploadFile;
    }

    public BoxUploadFile(BoxFile boxFile, String str, File file) {
        this(str, file);
        setSourceBoxFile(boxFile);
        setSourceBoxFileId(boxFile.getUserId());
    }

    public void init(MoCoContainerBuilder.MoCoContainer moCoContainer) {
        try {
            if (getParentFolderId() != null) {
                setParentFolder((BoxFolder) moCoContainer.getBaseModelController().performLocal(moCoContainer.getFolderApi().getInfoRequest(getParentFolderId()), null).get().getResult());
            }
            if (getSourceBoxFileId() != null) {
                setSourceBoxFile((BoxFile) moCoContainer.getBaseModelController().performLocal(moCoContainer.getFileApi().getInfoRequest(getSourceBoxFileId()), null).get().getResult());
            }
        } catch (InterruptedException e) {
            BoxLogUtils.logException(e);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e2) {
            BoxLogUtils.logException(e2);
        } finally {
            this.mIsInitialized = true;
        }
    }

    @Override // com.box.androidsdk.content.models.BoxItem
    public String getName() {
        return getFileName();
    }

    public String getFileName() {
        return getPropertyAsString(FILE_NAME);
    }

    public void setFileName(String str) {
        set(FILE_NAME, str);
    }

    public void setFileSize(Long l) {
        if (l.longValue() > 0) {
            set(FILE_SIZE, l);
        }
    }

    public Long getFileSize() {
        return getPropertyAsLong(FILE_SIZE);
    }

    public void setOnConflictResolution(ConflictResolution conflictResolution) {
        set(ON_CONFLICT_RESOLUTION, conflictResolution.toString());
    }

    public ConflictResolution getOnConflictResolution() {
        String propertyAsString = getPropertyAsString(ON_CONFLICT_RESOLUTION);
        if (propertyAsString != null) {
            return ConflictResolution.valueOf(propertyAsString);
        }
        return ConflictResolution.FAIL;
    }

    public String getParentFolderId() {
        return getPropertyAsString(PARENT_FOLDER_ID);
    }

    public void setParentFolderId(String str) {
        set(PARENT_FOLDER_ID, str);
    }

    public String getSourceBoxFileId() {
        return getPropertyAsString(SOURCE_BOX_FILE_ID);
    }

    public void setSourceBoxFileId(String str) {
        set(SOURCE_BOX_FILE_ID, str);
    }

    public String getSourceJavaFilePath() {
        return getPropertyAsString(SOURCE_JAVA_FILE_PATH);
    }

    public void setSourceJavaFilePath(String str) {
        set(SOURCE_JAVA_FILE_PATH, str);
    }

    public BoxFolder getParentFolder() {
        return (BoxFolder) getPropertyAsJsonObject(BoxEntity.getBoxJsonObjectCreator(), PARENT_FOLDER);
    }

    public void setParentFolder(BoxFolder boxFolder) {
        set(PARENT_FOLDER, boxFolder);
    }

    public BoxFile getSourceBoxFile() {
        return (BoxFile) getPropertyAsJsonObject(BoxFile.getBoxJsonObjectCreator(), SOURCE_BOX_FILE);
    }

    public Uri getUri() {
        return Uri.parse(getPropertyAsString(SOURCE_URI));
    }

    public void setSourceBoxFile(BoxFile boxFile) {
        set(SOURCE_BOX_FILE, boxFile);
    }

    public boolean isInitialized() {
        return this.mIsInitialized;
    }

    public UploadModelBoxFile.UriFile getUriFile() {
        String sourceJavaFilePath = getSourceJavaFilePath();
        if (SdkUtils.isBlank(sourceJavaFilePath)) {
            return new UploadModelBoxFile.UriFile(getUri());
        }
        return new UploadModelBoxFile.UriFile(new File(sourceJavaFilePath));
    }

    public boolean isUploadNewVersion() {
        return getSourceBoxFile() != null;
    }

    @Override // com.box.androidsdk.content.models.BoxJsonObject
    protected void parseJSONMember(JsonObject.Member member) {
        String name = member.getName();
        JsonValue value = member.getValue();
        if (name.equals(FILE_NAME)) {
            setFileName(value.asString());
            return;
        }
        if (name.equals(PARENT_FOLDER_ID)) {
            setParentFolderId(value.asString());
            return;
        }
        if (name.equals(SOURCE_BOX_FILE_ID)) {
            setSourceBoxFileId(value.asString());
            return;
        }
        if (name.equals(SOURCE_JAVA_FILE_PATH)) {
            setSourceJavaFilePath(value.asString());
            return;
        }
        if (name.equals(FILE_SIZE)) {
            setFileSize(Long.valueOf(value.asLong()));
            return;
        }
        if (name.equals(PARENT_FOLDER)) {
            BoxFolder boxFolder = new BoxFolder();
            boxFolder.createFromJson(value.asObject());
            setParentFolder(boxFolder);
        } else {
            if (name.equals(SOURCE_BOX_FILE)) {
                BoxFile boxFile = new BoxFile();
                boxFile.createFromJson(value.asObject());
                setSourceBoxFile(boxFile);
                return;
            }
            super.parseJSONMember(member);
        }
    }

    public boolean isFolder() {
        DocumentFile documentFile = getDocumentFile();
        if (documentFile != null) {
            return documentFile.isDirectory();
        }
        return false;
    }

    public boolean exists() {
        DocumentFile documentFile = getDocumentFile();
        if (documentFile != null) {
            return documentFile.exists();
        }
        return false;
    }

    public DocumentFile getDocumentFile() {
        String sourceJavaFilePath = getSourceJavaFilePath();
        if (!TextUtils.isEmpty(sourceJavaFilePath)) {
            return DocumentFile.fromFile(new File(sourceJavaFilePath));
        }
        Uri uri = getUri();
        if (uri == null) {
            return null;
        }
        if (FileUtil.isTreeUri(uri)) {
            return DocumentFile.fromTreeUri(ApplicationProvider.getApplication().getApplicationContext(), uri);
        }
        return DocumentFile.fromSingleUri(ApplicationProvider.getApplication().getApplicationContext(), uri);
    }
}
