package com.box.android.data.datasource.observability;

import android.content.Context;
import android.net.Uri;
import androidx.core.content.FileProvider;
import com.box.android.data.api.models.UserMiniDTO;
import com.box.android.data.api.models.items.FileDTO;
import com.box.android.data.api.models.observability.ClientLogMetadata;
import com.box.android.data.api.models.observability.UploadLogMetadataDTO;
import com.box.android.data.constants.AppConstants;
import com.box.android.data.datasource.CacheError;
import com.box.android.data.persistence.IFileSystem;
import com.box.android.data.utilities.ZipUtils;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.logging.FileTree;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.microsoft.identity.common.java.commands.parameters.CommandParameters;
import com.squareup.moshi.Moshi;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: LogsCacheDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 82\u00020\u0001:\u00018B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bJ(\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\b\b\u0001\u0010\u001c\u001a\u00020\u00132\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ.\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u000bH\u0007J.\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u001e\u0010(\u001a\u00020\u00162\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000b0*2\u0006\u0010+\u001a\u00020\u001eH\u0007J\u0010\u0010,\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010*H\u0002J\u0014\u0010-\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u001c\u0010.\u001a\u0004\u0018\u00010\u001a2\b\b\u0001\u0010\u001c\u001a\u00020\u00132\u0006\u0010/\u001a\u00020\u001eH\u0007J\u0010\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\u001eH\u0002J\"\u00102\u001a\u0002032\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0012\u00104\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\n\u00105\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u00106\u001a\u00020\u001eH\u0002J\u0012\u00107\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u00069"}, d2 = {"Lcom/box/android/data/datasource/observability/LogsCacheDataSource;", "", "appContext", "Landroid/content/Context;", "moshi", "Lcom/squareup/moshi/Moshi;", "fileSystem", "Lcom/box/android/data/persistence/IFileSystem;", "<init>", "(Landroid/content/Context;Lcom/squareup/moshi/Moshi;Lcom/box/android/data/persistence/IFileSystem;)V", "logsToUploadDir", "Ljava/io/File;", "getLogsToUploadDir$annotations", "()V", "getLogsToUploadDir", "()Ljava/io/File;", "setLogsToUploadDir", "(Ljava/io/File;)V", "getLogArchiveFileCount", "", "getLogArchiveFileToUpload", "deleteLogArchiveAndMetadataFile", "", "logArchiveFileToDelete", "createLogArchiveFile", "Lcom/box/android/domain/utils/result/Result;", "Landroid/net/Uri;", "Lcom/box/android/data/datasource/CacheError;", "fileProviderAuthorityId", "logTag", "", "createMetadataFile", "user", "Lcom/box/android/data/api/models/UserMiniDTO;", "uploadedFile", "Lcom/box/android/data/api/models/items/FileDTO;", "isFileContentValid", "", "file", "createMetadataFileHelper", "compressFiles", "filesToZip", "", "zipLocation", "getFilesToZip", "getAbsoluteZipFilePath", "getUriForFile", "absoluteFilePath", "getMetadataJSONFileName", "uploadedFileName", "createMetadataFileDTO", "Lcom/box/android/data/api/models/observability/UploadLogMetadataDTO;", "createZipArchiveFileName", "getOrCreateLogsToUploadDirectory", "createFormattedDate", "formatLogTag", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LogsCacheDataSource {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String DATE_FORMAT_STR = "yyyy-MM-dd_HH'h'_mm'm'_ss's'";

    @Deprecated
    public static final String JSON_FILE_NAME_FORMAT = "U-%s_%s.json.txt";

    @Deprecated
    public static final int MAX_METADAFILE_FILE_CREATION_ATTEMPT = 3;

    @Deprecated
    public static final String UNHASHED_USER_INFO = "%s-%s";

    @Deprecated
    public static final String WRITE_ERROR_LOG_TAG = "File Write Error";

    @Deprecated
    public static final String ZIP_FILE_NAME_FORMAT = "U-%s%s-Android_%s.zip";
    private final Context appContext;
    private final IFileSystem fileSystem;
    private File logsToUploadDir;
    private final Moshi moshi;

    public static /* synthetic */ void getLogsToUploadDir$annotations() {
    }

    @Inject
    public LogsCacheDataSource(Context appContext, Moshi moshi, IFileSystem fileSystem) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        this.appContext = appContext;
        this.moshi = moshi;
        this.fileSystem = fileSystem;
        File filesDir = appContext.getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "getFilesDir(...)");
        this.logsToUploadDir = fileSystem.createOrGetFile(filesDir, AppConstants.LOGS_TO_UPLOAD_DIR_NAME);
    }

    /* JADX INFO: compiled from: LogsCacheDataSource.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/box/android/data/datasource/observability/LogsCacheDataSource$Companion;", "", "<init>", "()V", "DATE_FORMAT_STR", "", "JSON_FILE_NAME_FORMAT", "ZIP_FILE_NAME_FORMAT", "UNHASHED_USER_INFO", "WRITE_ERROR_LOG_TAG", "MAX_METADAFILE_FILE_CREATION_ATTEMPT", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final File getLogsToUploadDir() {
        return this.logsToUploadDir;
    }

    public final void setLogsToUploadDir(File file) {
        this.logsToUploadDir = file;
    }

    public final int getLogArchiveFileCount() {
        File[] fileArrListFiles;
        File file = this.logsToUploadDir;
        if (file == null || (fileArrListFiles = file.listFiles()) == null) {
            return 0;
        }
        return fileArrListFiles.length;
    }

    public final File getLogArchiveFileToUpload() {
        File file = this.logsToUploadDir;
        File[] fileArrListFiles = file != null ? file.listFiles() : null;
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return null;
        }
        if (fileArrListFiles.length > 1) {
            ArraysKt.sortWith(fileArrListFiles, new Comparator() { // from class: com.box.android.data.datasource.observability.LogsCacheDataSource$getLogArchiveFileToUpload$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Long.valueOf(((File) t).lastModified()), Long.valueOf(((File) t2).lastModified()));
                }
            });
        }
        return fileArrListFiles[0];
    }

    public final void deleteLogArchiveAndMetadataFile(File logArchiveFileToDelete) {
        File fileCreateOrGetFile;
        Intrinsics.checkNotNullParameter(logArchiveFileToDelete, "logArchiveFileToDelete");
        String name = logArchiveFileToDelete.getName();
        this.fileSystem.deleteFile(logArchiveFileToDelete);
        File file = this.logsToUploadDir;
        if (file != null) {
            IFileSystem iFileSystem = this.fileSystem;
            Intrinsics.checkNotNull(name);
            fileCreateOrGetFile = iFileSystem.createOrGetFile(file, getMetadataJSONFileName(name));
        } else {
            fileCreateOrGetFile = null;
        }
        if (fileCreateOrGetFile != null) {
            this.fileSystem.deleteFile(fileCreateOrGetFile);
        }
    }

    public static /* synthetic */ Result createLogArchiveFile$default(LogsCacheDataSource logsCacheDataSource, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return logsCacheDataSource.createLogArchiveFile(i, str);
    }

    public final Result<Uri, CacheError> createLogArchiveFile(int fileProviderAuthorityId, String logTag) throws IOException {
        List<File> filesToZip = getFilesToZip();
        if (filesToZip == null) {
            return new Result.Error(CacheError.ReadError.INSTANCE);
        }
        String absoluteZipFilePath = getAbsoluteZipFilePath(logTag);
        if (absoluteZipFilePath == null) {
            return new Result.Error(CacheError.ReadError.INSTANCE);
        }
        compressFiles(filesToZip, absoluteZipFilePath);
        Uri uriForFile = getUriForFile(fileProviderAuthorityId, absoluteZipFilePath);
        return uriForFile != null ? new Result.Success(uriForFile) : new Result.Error(CacheError.ReadError.INSTANCE);
    }

    public static /* synthetic */ Result createMetadataFile$default(LogsCacheDataSource logsCacheDataSource, UserMiniDTO userMiniDTO, FileDTO fileDTO, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        return logsCacheDataSource.createMetadataFile(userMiniDTO, fileDTO, str);
    }

    public final Result<File, CacheError> createMetadataFile(UserMiniDTO user, FileDTO uploadedFile, String logTag) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(uploadedFile, "uploadedFile");
        Result.Error errorCreateMetadataFileHelper = null;
        for (int i = 1; i < 4; i++) {
            errorCreateMetadataFileHelper = createMetadataFileHelper(user, uploadedFile, logTag);
            if (errorCreateMetadataFileHelper instanceof Result.Success) {
                File file = (File) ((Result.Success) errorCreateMetadataFileHelper).getValue();
                if (isFileContentValid(file)) {
                    BoxLogUtils.i(ExtensionsKt.getTAG(this), "Metadata file is successfully created and verified");
                    break;
                }
                BoxLogUtils.e(WRITE_ERROR_LOG_TAG, "Metadata File with invalid JSON got created, cleaning up");
                this.fileSystem.deleteFile(file);
                errorCreateMetadataFileHelper = new Result.Error(CacheError.SaveError.INSTANCE);
            } else {
                if (!(errorCreateMetadataFileHelper instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                BoxLogUtils.e(WRITE_ERROR_LOG_TAG, "Failed to create metadata file");
                break;
            }
        }
        Intrinsics.checkNotNull(errorCreateMetadataFileHelper);
        return errorCreateMetadataFileHelper;
    }

    public final boolean isFileContentValid(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        try {
            Reader inputStreamReader = new InputStreamReader(new FileInputStream(file), Charsets.UTF_8);
            this.moshi.adapter(UploadLogMetadataDTO.class).fromJson(CollectionsKt.joinToString$default(TextStreamsKt.readLines(inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192)), "", null, null, 0, null, new Function1() { // from class: com.box.android.data.datasource.observability.LogsCacheDataSource$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LogsCacheDataSource.isFileContentValid$lambda$0((String) obj);
                }
            }, 30, null));
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence isFileContentValid$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return StringsKt.trimIndent(it);
    }

    private final Result<File, CacheError> createMetadataFileHelper(UserMiniDTO user, FileDTO uploadedFile, String logTag) {
        String json = this.moshi.adapter(UploadLogMetadataDTO.class).indent("    ").toJson(createMetadataFileDTO(user, uploadedFile, logTag));
        File file = this.logsToUploadDir;
        if (file != null) {
            IFileSystem iFileSystem = this.fileSystem;
            String name = uploadedFile.getName();
            Intrinsics.checkNotNull(name);
            File fileCreateOrGetFile = iFileSystem.createOrGetFile(file, getMetadataJSONFileName(name));
            if (fileCreateOrGetFile != null) {
                try {
                    IFileSystem iFileSystem2 = this.fileSystem;
                    Intrinsics.checkNotNull(json);
                    iFileSystem2.writeText(fileCreateOrGetFile, json);
                    return new Result.Success(fileCreateOrGetFile);
                } catch (IOException e) {
                    BoxLogUtils.e(WRITE_ERROR_LOG_TAG, "Failed to write into Metadata JSON file associated with the uploaded log archive", e);
                    BoxLogUtils.i(WRITE_ERROR_LOG_TAG, "Cleanup: Deleting local metadata JSON file");
                    if (!this.fileSystem.deleteFile(fileCreateOrGetFile)) {
                        BoxLogUtils.e(WRITE_ERROR_LOG_TAG, "Cleanup: Failed to delete local metadata JSON File");
                    }
                    return new Result.Error(CacheError.SaveError.INSTANCE);
                }
            }
        }
        return new Result.Error(CacheError.SaveError.INSTANCE);
    }

    public final void compressFiles(List<? extends File> filesToZip, String zipLocation) throws IOException {
        Intrinsics.checkNotNullParameter(filesToZip, "filesToZip");
        Intrinsics.checkNotNullParameter(zipLocation, "zipLocation");
        ZipUtils.INSTANCE.compressFiles(filesToZip, zipLocation);
    }

    private final List<File> getFilesToZip() {
        File[] fileArrListFiles;
        IFileSystem iFileSystem = this.fileSystem;
        File filesDir = this.appContext.getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "getFilesDir(...)");
        File fileCreateOrGetDirectory = iFileSystem.createOrGetDirectory(filesDir, FileTree.LOGS_DIR);
        if (fileCreateOrGetDirectory == null || (fileArrListFiles = fileCreateOrGetDirectory.listFiles()) == null) {
            return null;
        }
        return ArraysKt.toList(fileArrListFiles);
    }

    private final String getAbsoluteZipFilePath(String logTag) {
        String absolutePath;
        String strCreateZipArchiveFileName = createZipArchiveFileName(logTag);
        File orCreateLogsToUploadDirectory = getOrCreateLogsToUploadDirectory();
        if (orCreateLogsToUploadDirectory == null || (absolutePath = orCreateLogsToUploadDirectory.getAbsolutePath()) == null) {
            return null;
        }
        String str = String.format(CommandParameters.APPLICATION_IDENTIFIER_FORMAT, Arrays.copyOf(new Object[]{absolutePath, strCreateZipArchiveFileName}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public final Uri getUriForFile(int fileProviderAuthorityId, String absoluteFilePath) {
        Intrinsics.checkNotNullParameter(absoluteFilePath, "absoluteFilePath");
        String string = this.appContext.getResources().getString(fileProviderAuthorityId);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        File fileCreateOrGetFile = this.fileSystem.createOrGetFile(absoluteFilePath);
        if (fileCreateOrGetFile != null) {
            return FileProvider.getUriForFile(this.appContext, string, fileCreateOrGetFile);
        }
        return null;
    }

    private final String getMetadataJSONFileName(String uploadedFileName) {
        String str = String.format(JSON_FILE_NAME_FORMAT, Arrays.copyOf(new Object[]{StringsKt.substringAfter$default(StringsKt.substringBefore$default(uploadedFileName, "_", (String) null, 2, (Object) null), CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR, (String) null, 2, (Object) null), StringsKt.substringBefore$default(StringsKt.substringAfter$default(uploadedFileName, "_", (String) null, 2, (Object) null), ".", (String) null, 2, (Object) null)}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    private final UploadLogMetadataDTO createMetadataFileDTO(UserMiniDTO user, FileDTO uploadedFile, String logTag) {
        String name = uploadedFile.getName();
        Intrinsics.checkNotNull(name);
        String strSubstringAfter$default = StringsKt.substringAfter$default(StringsKt.substringBefore$default(name, "_", (String) null, 2, (Object) null), CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR, (String) null, 2, (Object) null);
        String strSubstringBefore$default = StringsKt.substringBefore$default(name, ".", (String) null, 2, (Object) null);
        String strSubstringBefore$default2 = StringsKt.substringBefore$default(StringsKt.substringAfter$default(name, "_", (String) null, 2, (Object) null), ".", (String) null, 2, (Object) null);
        String login = user.getLogin();
        Intrinsics.checkNotNull(login);
        String id = user.getId();
        String strSubstringAfter$default2 = StringsKt.substringAfter$default(name, ".", (String) null, 2, (Object) null);
        String metadataJSONFileName = getMetadataJSONFileName(name);
        String str = String.format(UNHASHED_USER_INFO, Arrays.copyOf(new Object[]{login, id}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        String str2 = String.format(ZIP_FILE_NAME_FORMAT, Arrays.copyOf(new Object[]{str, formatLogTag(logTag), strSubstringBefore$default2}, 3));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        return new UploadLogMetadataDTO(new ClientLogMetadata(strSubstringBefore$default2, strSubstringAfter$default, metadataJSONFileName, login, str2, id, name, str, name, strSubstringBefore$default, StringsKt.substringBefore$default(str2, ".", (String) null, 2, (Object) null), strSubstringAfter$default2), user, uploadedFile);
    }

    private final String createZipArchiveFileName(String logTag) {
        String strCreateFormattedDate = createFormattedDate();
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String upperCase = string.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        String str = String.format(ZIP_FILE_NAME_FORMAT, Arrays.copyOf(new Object[]{upperCase, formatLogTag(logTag), strCreateFormattedDate}, 3));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    private final File getOrCreateLogsToUploadDirectory() {
        IFileSystem iFileSystem = this.fileSystem;
        File filesDir = this.appContext.getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "getFilesDir(...)");
        return iFileSystem.createOrGetDirectory(filesDir, AppConstants.LOGS_TO_UPLOAD_DIR_NAME);
    }

    private final String createFormattedDate() {
        String str = new SimpleDateFormat(DATE_FORMAT_STR, Locale.US).format(new Date());
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public final String formatLogTag(String logTag) {
        String str = logTag;
        if (str != null && str.length() != 0) {
            return CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + logTag;
        }
        return "";
    }
}
