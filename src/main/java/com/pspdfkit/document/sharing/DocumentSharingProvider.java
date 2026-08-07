package com.pspdfkit.document.sharing;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import com.box.android.common.utilities.BoxCommonConstants;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import com.pspdfkit.exceptions.NutrientException;
import com.pspdfkit.internal.h7;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.wg;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class DocumentSharingProvider extends h7 {
    private static final String PROVIDER_PATH_SHARING = "sharing";
    private static final String PROVIDER_PATH_TEMP = "temp";
    private static final DocumentSharingProviderStrategy PROVIDER_STRATEGY = new DocumentSharingProviderStrategy();

    public static class DocumentSharingProviderStrategy implements h7.a {
        private Map<String, File> directories;

        private DocumentSharingProviderStrategy() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void reset() {
            this.directories = null;
        }

        @Override // com.pspdfkit.internal.h7.a
        public String getAuthority(Context context) {
            return context.getPackageName() + ".pdf.share";
        }

        @Override // com.pspdfkit.internal.h7.a
        public Map<String, File> getDirectories(Context context) {
            if (this.directories == null) {
                this.directories = new HashMap(2);
                try {
                    File canonicalFile = new File(wg.a(context), DocumentSharingProvider.PROVIDER_PATH_SHARING).getCanonicalFile();
                    canonicalFile.mkdirs();
                    this.directories.put(DocumentSharingProvider.PROVIDER_PATH_SHARING, canonicalFile);
                    File canonicalFile2 = new File(wg.a(context), "temp").getCanonicalFile();
                    canonicalFile2.mkdirs();
                    this.directories.put("temp", canonicalFile2);
                } catch (IOException e) {
                    throw new IllegalStateException("Couldn't create temporary share directory.", e);
                }
            }
            return Collections.unmodifiableMap(this.directories);
        }
    }

    public DocumentSharingProvider() {
        super(PROVIDER_STRATEGY);
    }

    public static void checkProviderConfiguration(Context context, String str) {
        uw.a(context, "context", null);
        uw.a(str, "featureName", null);
        int i = 0;
        try {
            ProviderInfo[] providerInfoArr = MAMPackageManagement.getPackageInfo(context.getPackageManager(), context.getPackageName(), 8).providers;
            if (providerInfoArr != null) {
                int length = providerInfoArr.length;
                int i2 = 0;
                while (i < length) {
                    try {
                        ProviderInfo providerInfo = providerInfoArr[i];
                        if (DocumentSharingProvider.class.getName().equals(providerInfo.name)) {
                            i2 = 1;
                            DocumentSharingProviderStrategy documentSharingProviderStrategy = PROVIDER_STRATEGY;
                            if (!documentSharingProviderStrategy.getAuthority(context).equals(providerInfo.authority)) {
                                throw new NutrientException("DocumentSharingProvider must have authority: " + documentSharingProviderStrategy.getAuthority(context) + "! Was: " + providerInfo.authority);
                            }
                            if (!providerInfo.grantUriPermissions) {
                                throw new NutrientException("DocumentSharingProvider must allow granting Uri permissions via android:grantUriPermissions=\"true\"!");
                            }
                        }
                        i++;
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                }
                i = i2;
            }
        } catch (PackageManager.NameNotFoundException unused2) {
        }
        if (i == 0) {
            throw new NutrientException("You need to declare DocumentSharingProvider (" + DocumentSharingProvider.class.getName() + ") in AndroidManifest.xml for " + str + " to work!");
        }
    }

    public static Uri createTemporaryFile(Context context, String str, String str2) {
        File fileCreateTempFile;
        uw.a(context, "context", null);
        uw.a(str, BoxCommonConstants.EXTRA_FILE_NAME, null);
        try {
            File tempFileDirectory = getTempFileDirectory(context);
            tempFileDirectory.mkdirs();
            fileCreateTempFile = File.createTempFile(str, str2, tempFileDirectory);
        } catch (IOException unused) {
            fileCreateTempFile = null;
        }
        if (fileCreateTempFile != null) {
            return getUriForFile(context, fileCreateTempFile);
        }
        return null;
    }

    public static boolean deleteFile(Context context, Uri uri) {
        uw.a(context, "context", null);
        uw.a(uri, "sharedFileUri", null);
        try {
            return h7.getFile(context, PROVIDER_STRATEGY, uri).delete();
        } catch (IOException unused) {
            return false;
        }
    }

    public static String getDocumentProviderAuthority(Context context) {
        uw.a(context, "context", null);
        return PROVIDER_STRATEGY.getAuthority(context);
    }

    public static File getSharedFileDirectory(Context context) {
        uw.a(context, "context", null);
        try {
            File file = PROVIDER_STRATEGY.getDirectories(context).get(PROVIDER_PATH_SHARING);
            if (file == null) {
                throw new IllegalStateException("Couldn't create temporary share directory.");
            }
            File canonicalFile = file.getCanonicalFile();
            canonicalFile.mkdirs();
            return canonicalFile;
        } catch (IOException e) {
            throw new IllegalStateException("Couldn't create temporary share directory.", e);
        }
    }

    public static File getTempFileDirectory(Context context) {
        uw.a(context, "context", null);
        try {
            File file = PROVIDER_STRATEGY.getDirectories(context).get("temp");
            if (file == null) {
                throw new IllegalStateException("Couldn't create temporary share directory.");
            }
            File canonicalFile = file.getCanonicalFile();
            canonicalFile.mkdirs();
            return canonicalFile;
        } catch (IOException e) {
            throw new IllegalStateException("Couldn't create temporary share directory.", e);
        }
    }

    public static Uri getUriForFile(Context context, File file) {
        uw.a(context, "context", null);
        uw.a(file, BoxCommonConstants.EXTRA_FILE_NAME, null);
        try {
            return h7.getUriForFile(context, PROVIDER_STRATEGY, file);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Trying to share file \"" + file.getAbsolutePath() + ". For security reasons, only files from shared directories (see DocumentSharingProvider#getSharedFileDirectory and #getTempFileDirectory) may be shared.", e);
        }
    }

    public static void reset() {
        PROVIDER_STRATEGY.reset();
    }

    public static void checkProviderConfiguration(Context context) {
        checkProviderConfiguration(context, PROVIDER_PATH_SHARING);
    }
}
