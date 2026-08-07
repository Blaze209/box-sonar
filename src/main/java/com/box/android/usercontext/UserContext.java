package com.box.android.usercontext;

import android.content.Context;
import android.provider.DocumentsContract;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.box.android.application.BoxBaseApplication;
import com.box.android.auth.UserContextProxyComponent;
import com.box.android.controller.ExecutorPool;
import com.box.android.data.jobs.JobService;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.identity.IUserContextComponent;
import com.box.android.domain.usecases.UserInteractor;
import com.box.android.domain.usecases.capture.LaunchIntoCaptureUseCase;
import com.box.android.localrepo.DocumentProviderPreferences;
import com.box.android.localrepo.LevelDBKeyValueStore;
import com.box.android.localrepo.LocalAutoContentUploadInformation;
import com.box.android.localrepo.LocalFiles;
import com.box.android.localrepo.LocalSharedPreferences;
import com.box.android.localrepo.LocalStatics;
import com.box.android.localrepo.SQLHelper;
import com.box.android.localrepo.SQLProvider;
import com.box.android.providers.BoxDocumentsProvider;
import dagger.hilt.EntryPoints;
import java.util.Iterator;
import java.util.LinkedHashMap;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes13.dex */
public class UserContext implements IUserContext {
    private final Context mAppContext;
    JobService mJobService;
    LaunchIntoCaptureUseCase mLaunchIntoCaptureUseCase;
    LevelDBKeyValueStore mLevelDBKeyValueStore;
    private LocalSharedPreferences mLocalSharedPreferences;
    UserInteractor mUserInteractor;
    protected LinkedHashMap<IUserContext.UserContextComponent, IUserContextComponent> components = new LinkedHashMap<>();
    private String mContextId = "-1";

    interface UserContextEntryPoint {
        JobService getJobService();

        LaunchIntoCaptureUseCase getLaunchIntoCaptureUseCase();

        LevelDBKeyValueStore getLevelDBKeyValueStore();

        UserInteractor getUserInteractor();
    }

    @Inject
    public UserContext(Context context) {
        this.mAppContext = context;
        UserContextEntryPoint userContextEntryPoint = (UserContextEntryPoint) EntryPoints.get(context, UserContextEntryPoint.class);
        this.mLevelDBKeyValueStore = userContextEntryPoint.getLevelDBKeyValueStore();
        this.mUserInteractor = userContextEntryPoint.getUserInteractor();
        this.mLaunchIntoCaptureUseCase = userContextEntryPoint.getLaunchIntoCaptureUseCase();
        this.mJobService = userContextEntryPoint.getJobService();
        constructComponents();
    }

    @Override // com.box.android.domain.identity.IUserContext
    public LevelDBKeyValueStore getKVStore() {
        return (LevelDBKeyValueStore) this.components.get(IUserContext.UserContextComponent.LEVELDB);
    }

    @Override // com.box.android.domain.identity.IUserContext
    public SQLHelper getSQLHelper() {
        return ((SQLProvider) this.components.get(IUserContext.UserContextComponent.SQL_PROVIDER)).getSQLHelper();
    }

    /* JADX INFO: renamed from: com.box.android.usercontext.UserContext$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$box$android$domain$identity$IUserContext$UserContextComponent;

        static {
            int[] iArr = new int[IUserContext.UserContextComponent.values().length];
            $SwitchMap$com$box$android$domain$identity$IUserContext$UserContextComponent = iArr;
            try {
                iArr[IUserContext.UserContextComponent.EXECUTOR_POOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$box$android$domain$identity$IUserContext$UserContextComponent[IUserContext.UserContextComponent.LOCAL_FILES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$box$android$domain$identity$IUserContext$UserContextComponent[IUserContext.UserContextComponent.LOCAL_AUTO_CONTENT_UPLOAD_INFORMATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$box$android$domain$identity$IUserContext$UserContextComponent[IUserContext.UserContextComponent.LOCAL_SHARED_PREFERENCES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$box$android$domain$identity$IUserContext$UserContextComponent[IUserContext.UserContextComponent.LOCAL_STATIC_VARIABLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$box$android$domain$identity$IUserContext$UserContextComponent[IUserContext.UserContextComponent.DOCUMENT_PROVIDER_PREFERENCES.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @Override // com.box.android.domain.identity.IUserContext
    public IUserContextComponent getUserContextComponent(IUserContext.UserContextComponent userContextComponent) {
        switch (AnonymousClass1.$SwitchMap$com$box$android$domain$identity$IUserContext$UserContextComponent[userContextComponent.ordinal()]) {
            case 1:
                return getExecutorPool();
            case 2:
                return getLocalFiles();
            case 3:
                return getLocalAutoContentUploadInformation();
            case 4:
                return getLocalSharedPreferences();
            case 5:
                return getLocalStaticVariables();
            case 6:
                return getBoxDocumentProviderPrefs();
            default:
                return null;
        }
    }

    public ExecutorPool getExecutorPool() {
        return (ExecutorPool) this.components.get(IUserContext.UserContextComponent.EXECUTOR_POOL);
    }

    public LocalSharedPreferences getLocalSharedPreferences() {
        return this.mLocalSharedPreferences;
    }

    public LocalFiles getLocalFiles() {
        return (LocalFiles) this.components.get(IUserContext.UserContextComponent.LOCAL_FILES);
    }

    private void constructComponents() {
        this.components.put(IUserContext.UserContextComponent.EXECUTOR_POOL, new ExecutorPool(this.mAppContext));
        this.components.put(IUserContext.UserContextComponent.LEVELDB, this.mLevelDBKeyValueStore);
        this.components.put(IUserContext.UserContextComponent.SQL_PROVIDER, new SQLProvider(this.mAppContext));
        this.components.put(IUserContext.UserContextComponent.LOCAL_FILES, new LocalFiles());
        this.components.put(IUserContext.UserContextComponent.LOCAL_STATIC_VARIABLE, new LocalStatics());
        this.components.put(IUserContext.UserContextComponent.LOCAL_AUTO_CONTENT_UPLOAD_INFORMATION, new LocalAutoContentUploadInformation(this.mAppContext));
        this.components.put(IUserContext.UserContextComponent.DOCUMENT_PROVIDER_PREFERENCES, new DocumentProviderPreferences(this.mAppContext));
        this.components.put(IUserContext.UserContextComponent.JOB_SERVICE, this.mJobService);
        this.components.put(IUserContext.UserContextComponent.USER_CONTEXT_PROXY, new UserContextProxyComponent(this.mUserInteractor));
        this.mLocalSharedPreferences = new LocalSharedPreferences();
    }

    public void onCreate(String str) {
        if (this.mContextId.equals(str)) {
            return;
        }
        this.mContextId = str;
        try {
            createAllComponents(str);
        } catch (IUserContextComponent.UserContextComponentCreationException unused) {
            wipeDatabases(str);
            try {
                createAllComponents(str);
            } catch (IUserContextComponent.UserContextComponentCreationException unused2) {
            }
        }
        try {
            this.mLocalSharedPreferences.onCreate(str);
        } catch (IUserContextComponent.UserContextComponentCreationException unused3) {
        }
        BoxBaseApplication.getInstance().getApplicationContext().getContentResolver().notifyChange(DocumentsContract.buildRootsUri(BoxDocumentsProvider.AUTHORITY), null);
    }

    private void createAllComponents(String str) throws IUserContextComponent.UserContextComponentCreationException {
        Iterator<IUserContextComponent> it = this.components.values().iterator();
        while (it.hasNext()) {
            it.next().onCreate(str);
        }
    }

    private void wipeDatabases(String str) {
        try {
            this.components.get(IUserContext.UserContextComponent.LEVELDB).onHardDestroy();
            this.components.get(IUserContext.UserContextComponent.SQL_PROVIDER).onCreate(str);
            this.components.get(IUserContext.UserContextComponent.SQL_PROVIDER).onHardDestroy();
        } catch (Exception unused) {
        }
    }

    public void onSoftDestroy() {
        this.mContextId = "-1";
        Iterator<IUserContextComponent> it = this.components.values().iterator();
        while (it.hasNext()) {
            it.next().onSoftDestroy();
        }
        this.mLocalSharedPreferences.onSoftDestroy();
        wipeWebviewCache();
    }

    public void onHardDestroy() {
        this.mContextId = "-1";
        Iterator<IUserContextComponent> it = this.components.values().iterator();
        while (it.hasNext()) {
            it.next().onHardDestroy();
        }
        this.mLocalSharedPreferences.onHardDestroy();
        this.mLaunchIntoCaptureUseCase.setLaunchIntoCapturePreference(false);
        wipeWebviewCache();
    }

    @Override // com.box.android.domain.identity.IUserContext
    public String getContextId() {
        return this.mContextId;
    }

    public DocumentProviderPreferences getBoxDocumentProviderPrefs() {
        return (DocumentProviderPreferences) this.components.get(IUserContext.UserContextComponent.DOCUMENT_PROVIDER_PREFERENCES);
    }

    public LocalStatics getLocalStaticVariables() {
        return (LocalStatics) this.components.get(IUserContext.UserContextComponent.LOCAL_STATIC_VARIABLE);
    }

    public LocalAutoContentUploadInformation getLocalAutoContentUploadInformation() {
        return (LocalAutoContentUploadInformation) this.components.get(IUserContext.UserContextComponent.LOCAL_AUTO_CONTENT_UPLOAD_INFORMATION);
    }

    private void wipeWebviewCache() {
        CookieSyncManager.createInstance(this.mAppContext);
        CookieManager.getInstance().removeAllCookie();
    }
}
