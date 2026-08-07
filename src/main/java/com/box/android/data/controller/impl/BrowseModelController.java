package com.box.android.data.controller.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.collection.LruCache;
import com.box.android.domain.controller.IBrowseController;
import com.box.androidsdk.content.BoxApiFile;
import com.box.androidsdk.content.BoxApiFolder;
import com.box.androidsdk.content.BoxApiSearch;
import com.box.androidsdk.content.BoxConfig;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxRepresentation;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.requests.BoxCacheableRequest;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import com.box.androidsdk.content.requests.BoxRequestsSearch;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.eclipsesource.json.JsonArray;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes11.dex */
public class BrowseModelController implements IBrowseController {
    protected static final int BITMAP_CACHE_DEFAULT_SIZE = 10000;
    private static final int MAX_RECENT_SEARCHES = 10;
    private static final String RECENT_SEARCHES_KEY = "BoxBrowseController.RecentSearchesKey";
    private static final String TAG = "com.box.android.data.controller.impl.BrowseModelController";
    private static ThreadPoolExecutor mApiExecutor;
    private static ThreadPoolExecutor mThumbnailExecutor;
    protected final BoxApiFile mFileApi;
    protected final BoxApiFolder mFolderApi;
    protected LruCache<Integer, Bitmap> mIconResCache;
    protected BoxFutureTask.OnCompletedListener mListener;
    protected final BoxApiSearch mSearchApi;
    protected final BoxSession mSession;
    protected BitmapLruCache mThumbnailCache;

    public BrowseModelController(BoxSession session, BoxApiFile apiFile, BoxApiFolder apiFolder, BoxApiSearch apiSearch, ThreadPoolExecutor apiExecutor, ThreadPoolExecutor thumbnailExecutor) {
        this.mThumbnailCache = new BitmapLruCache(10000);
        this.mIconResCache = new LruCache<>(10);
        this.mSession = session;
        this.mFileApi = apiFile;
        this.mFolderApi = apiFolder;
        this.mSearchApi = apiSearch;
        mApiExecutor = apiExecutor;
        mThumbnailExecutor = thumbnailExecutor;
        int iMaxMemory = ((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8;
        if (iMaxMemory < 10000) {
            this.mThumbnailCache = new BitmapLruCache(iMaxMemory);
        }
    }

    public BrowseModelController(BoxSession session) {
        this.mThumbnailCache = new BitmapLruCache(10000);
        this.mIconResCache = new LruCache<>(10);
        this.mSession = session;
        this.mFileApi = new BoxApiFile(session);
        this.mFolderApi = new BoxApiFolder(session);
        this.mSearchApi = new BoxApiSearch(session);
    }

    @Override // com.box.android.domain.controller.IBrowseController
    public BoxRequestsSearch.Search getSearchRequest(String query) {
        return this.mSearchApi.getSearchRequest(query);
    }

    @Override // com.box.android.domain.controller.IBrowseController
    public BoxRequestsFile.DownloadThumbnail getThumbnailRequest(String fileId, File downloadFile) {
        try {
            return this.mFileApi.getDownloadThumbnailRequest(downloadFile, fileId).setMinWidth(160).setMinHeight(160);
        } catch (IOException e) {
            BoxLogUtils.e(TAG, e);
            return null;
        }
    }

    @Override // com.box.android.domain.controller.IBrowseController
    public void log(String tag, String msg, Throwable t) {
        if (t == null) {
            BoxLogUtils.d(tag, msg);
        } else {
            BoxLogUtils.e(tag, msg, t);
        }
    }

    @Override // com.box.android.domain.controller.IBrowseController
    public BoxRequestsFile.DownloadRepresentation getRepresentationThumbnailRequest(String fileId, BoxRepresentation representation, File downloadFile) {
        return this.mFileApi.getDownloadRepresentationRequest(fileId, downloadFile, representation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.box.android.domain.controller.IBrowseController
    public void execute(BoxRequest request) {
        ThreadPoolExecutor threadPoolExecutor;
        if (request == 0) {
            return;
        }
        if (BoxConfig.getCache() != null && (request instanceof BoxCacheableRequest)) {
            try {
                BoxFutureTask taskForCachedResult = ((BoxCacheableRequest) request).toTaskForCachedResult();
                BoxFutureTask.OnCompletedListener onCompletedListener = this.mListener;
                if (onCompletedListener != null) {
                    taskForCachedResult.addOnCompletedListener(onCompletedListener);
                }
                mApiExecutor.execute(taskForCachedResult);
            } catch (BoxException e) {
                BoxLogUtils.e("cache task error ", e);
            }
        }
        BoxFutureTask task = request.toTask();
        BoxFutureTask.OnCompletedListener onCompletedListener2 = this.mListener;
        if (onCompletedListener2 != null) {
            task.addOnCompletedListener(onCompletedListener2);
        }
        if (request instanceof BoxRequestsFile.DownloadThumbnail) {
            threadPoolExecutor = mThumbnailExecutor;
        } else {
            threadPoolExecutor = mApiExecutor;
        }
        threadPoolExecutor.submit(task);
    }

    @Override // com.box.android.domain.controller.IBrowseController
    public IBrowseController setCompletedListener(BoxFutureTask.OnCompletedListener listener) {
        this.mListener = listener;
        return this;
    }

    @Override // com.box.android.domain.controller.IBrowseController
    public File getThumbnailCacheDir() {
        File file = new File(this.mSession.getCacheDir(), "BoxThumbnails");
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    @Override // com.box.android.domain.controller.IBrowseController
    public LruCache<File, Bitmap> getThumbnailCache() {
        return this.mThumbnailCache;
    }

    @Override // com.box.android.domain.controller.IBrowseController
    public LruCache<Integer, Bitmap> getIconResourceCache() {
        return this.mIconResCache;
    }

    @Override // com.box.android.domain.controller.IBrowseController
    public ArrayList<String> getRecentSearches(Context context, BoxUser user) {
        String str = RECENT_SEARCHES_KEY + user.getUserId();
        String string = context.getSharedPreferences(str, 0).getString(RECENT_SEARCHES_KEY, null);
        ArrayList<String> arrayList = new ArrayList<>();
        if (string != null) {
            JsonArray from = JsonArray.readFrom(string);
            for (int i = 0; i < from.size(); i++) {
                arrayList.add(from.get(i).asString());
            }
        }
        return arrayList;
    }

    @Override // com.box.android.domain.controller.IBrowseController
    public ArrayList<String> addToRecentSearches(Context context, BoxUser user, String recentSearch) {
        ArrayList<String> recentSearches = getRecentSearches(context, user);
        if (TextUtils.isEmpty(recentSearch)) {
            return recentSearches;
        }
        recentSearches.remove(recentSearch);
        if (recentSearches.size() >= 10) {
            recentSearches.remove(recentSearches.size() - 1);
        }
        recentSearches.add(0, recentSearch);
        saveRecentSearches(context, user, recentSearches);
        return recentSearches;
    }

    @Override // com.box.android.domain.controller.IBrowseController
    public ArrayList<String> deleteFromRecentSearches(Context context, BoxUser user, int indexToRemove) {
        ArrayList<String> recentSearches = getRecentSearches(context, user);
        recentSearches.remove(indexToRemove);
        saveRecentSearches(context, user, recentSearches);
        return recentSearches;
    }

    @Override // com.box.android.domain.controller.IBrowseController
    public void saveRecentSearches(Context context, BoxUser user, ArrayList<String> searches) {
        JsonArray jsonArray = new JsonArray();
        for (int i = 0; i < searches.size(); i++) {
            jsonArray.add(searches.get(i));
        }
        context.getSharedPreferences(RECENT_SEARCHES_KEY + user.getUserId(), 0).edit().putString(RECENT_SEARCHES_KEY, jsonArray.toString()).commit();
    }

    protected class BitmapLruCache extends LruCache<File, Bitmap> {
        public BitmapLruCache(int sizeInKb) {
            super(sizeInKb);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.collection.LruCache
        public int sizeOf(File key, Bitmap value) {
            return value.getByteCount() / 1024;
        }
    }
}
