package com.box.android.preview.previewtype.boxnote;

import android.content.SharedPreferences;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.domain.configuration.BoxConfigConstants;
import com.box.android.domain.configuration.ConfigManager;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import com.box.android.domain.utils.MimeTypeHelper;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes12.dex */
public class BoxNotesWebviewAssetCache {
    private static final String[] CACHEABLE_FILE_EXTENSIONS = {"css", "js", "svg", "woff2"};
    private static final String SHARED_PREF_KEY_LAST_UPDATED = "boxNotesWebviewAssetCacheLastUpdated";
    private static BoxNotesWebviewAssetCache mAssetCache;
    private final File mAssetDir = getDir();
    private final ConfigManager mConfigManager;
    private boolean mIsSynchingCachedFilesList;

    private BoxNotesWebviewAssetCache(ConfigManager configManager) {
        this.mConfigManager = configManager;
    }

    public static BoxNotesWebviewAssetCache getInstance(ConfigManager configManager) {
        if (mAssetCache == null) {
            mAssetCache = new BoxNotesWebviewAssetCache(configManager);
        }
        return mAssetCache;
    }

    public File getDir() {
        File file = new File(ApplicationProvider.application.getFilesDir(), "box_notes_webview_assets");
        file.mkdirs();
        return file;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.box.android.preview.previewtype.boxnote.BoxNotesWebviewAssetCache$1] */
    public WebResourceResponse shouldInterceptRequest(final String str) {
        if (this.mIsSynchingCachedFilesList) {
            return null;
        }
        String urlFileExt = getUrlFileExt(str);
        if (!isUrlEligibleForCaching(str)) {
            return null;
        }
        File cachedAssetFile = getCachedAssetFile(Uri.parse(str));
        if (cachedAssetFile.exists()) {
            try {
                WebResourceResponse webResourceResponse = new WebResourceResponse(MimeTypeHelper.getTypeFromExt(urlFileExt), null, new BufferedInputStream(new FileInputStream(cachedAssetFile)));
                webResourceResponse.setResponseHeaders(Map.of("Access-Control-Allow-Origin", "*"));
                return webResourceResponse;
            } catch (FileNotFoundException e) {
                BoxLogUtils.logException(e);
                return null;
            }
        }
        new Thread() { // from class: com.box.android.preview.previewtype.boxnote.BoxNotesWebviewAssetCache.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                BoxNotesWebviewAssetCache.this.cacheAsset(str);
            }
        }.start();
        return null;
    }

    private boolean isUrlEligibleForCaching(String str) {
        for (String str2 : CACHEABLE_FILE_EXTENSIONS) {
            if (str.endsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cacheAsset(String str) {
        try {
            Uri uri = Uri.parse(str);
            File file = new File(getDir() + File.separator + "~tmp" + File.separator + uri.getPath());
            FileUtils.copyURLToFile(new URL(str), file);
            file.renameTo(getCachedAssetFile(uri));
        } catch (Exception e) {
            BoxLogUtils.e("BoxNotesWebviewAssetCache.cacheAsset " + str, e);
        }
    }

    private File getCachedAssetFile(Uri uri) {
        File file = new File(getDir() + File.separator + uri.getPath());
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        return file;
    }

    private String getUrlFileExt(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf < 0 || iLastIndexOf >= str.length() - 1) {
            return null;
        }
        return str.substring(iLastIndexOf + 1);
    }

    public void syncCachedFilesListIfNecessary(IUserContextManager iUserContextManager) {
        SharedPreferences userSharedPrefs = iUserContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.GLOBAL);
        if (System.currentTimeMillis() - userSharedPrefs.getLong(SHARED_PREF_KEY_LAST_UPDATED, 0L) > TimeUnit.DAYS.toMillis(1L)) {
            syncCachedFilesList(userSharedPrefs);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.box.android.preview.previewtype.boxnote.BoxNotesWebviewAssetCache$2] */
    private void syncCachedFilesList(final SharedPreferences sharedPreferences) {
        this.mIsSynchingCachedFilesList = true;
        new Thread() { // from class: com.box.android.preview.previewtype.boxnote.BoxNotesWebviewAssetCache.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                ArrayList<File> arrayList = new ArrayList();
                BoxNotesWebviewAssetCache boxNotesWebviewAssetCache = BoxNotesWebviewAssetCache.this;
                boxNotesWebviewAssetCache.recursivelyRetrieveAllFilesInDirectory(boxNotesWebviewAssetCache.mAssetDir, arrayList);
                List<String> assetListFromServer = BoxNotesWebviewAssetCache.this.getAssetListFromServer();
                if (assetListFromServer == null) {
                    return;
                }
                HashMap map = new HashMap(assetListFromServer.size());
                for (String str : assetListFromServer) {
                    map.put(Uri.parse(str).getPath(), str);
                }
                for (File file : arrayList) {
                    String path = BoxNotesWebviewAssetCache.this.mAssetDir.toURI().relativize(file.toURI()).getPath();
                    if (map.containsKey(path)) {
                        map.remove(path);
                    } else {
                        file.delete();
                    }
                }
                Iterator it = map.values().iterator();
                while (it.hasNext()) {
                    BoxNotesWebviewAssetCache.this.cacheAsset((String) it.next());
                }
                sharedPreferences.edit().putLong(BoxNotesWebviewAssetCache.SHARED_PREF_KEY_LAST_UPDATED, System.currentTimeMillis()).apply();
                BoxNotesWebviewAssetCache.this.mIsSynchingCachedFilesList = false;
            }
        }.start();
    }

    private String buildAssetListUrl() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(this.mConfigManager.getString(BoxConfigConstants.CONFIG_KEY_BOX_NOTES_URL_SCHEME));
        builder.authority(this.mConfigManager.getString(BoxConfigConstants.CONFIG_KEY_BOX_NOTES_URL_HOSTNAME));
        builder.path("asset-list");
        return builder.build().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> getAssetListFromServer() {
        String string;
        try {
            string = IOUtils.toString(new URL(buildAssetListUrl()), StandardCharsets.UTF_8);
        } catch (IOException e) {
            BoxLogUtils.logException(e);
            string = null;
        } catch (SecurityException e2) {
            BoxLogUtils.e(BoxNotesWebviewAssetCache.class.getName(), e2);
            string = null;
        } catch (MalformedURLException e3) {
            BoxLogUtils.logException(e3);
            string = null;
        }
        if (StringUtils.isNotBlank(string)) {
            return Arrays.asList(string.split(","));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recursivelyRetrieveAllFilesInDirectory(File file, List<File> list) {
        if (file.isFile()) {
            list.add(file);
            return;
        }
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                recursivelyRetrieveAllFilesInDirectory(file2, list);
            }
        }
    }
}
