package com.box.android.activities.urlsinterceptor.router;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import com.box.android.R;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.base.presentation.activities.BoxFragmentActivity;
import com.box.android.base.presentation.utilities.IItemActionHandler;
import com.box.android.common.utilities.IntentConstants;
import com.box.android.coreservices.modelcontroller.BoxAppFutureTask;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxObject;
import com.box.androidsdk.content.requests.BoxRequestsBookmark;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import dagger.hilt.android.AndroidEntryPoint;
import java.io.Serializable;
import java.util.concurrent.ExecutionException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: FileRouterActivity.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\r\u0010\u0015\u001a\u00020\u0016H\u0014¢\u0006\u0002\u0010\u0017R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/box/android/activities/urlsinterceptor/router/FileRouterActivity;", "Lcom/box/android/base/presentation/activities/BoxFragmentActivity;", "<init>", "()V", "mItemActionHandler", "Lcom/box/android/base/presentation/utilities/IItemActionHandler;", "getMItemActionHandler", "()Lcom/box/android/base/presentation/utilities/IItemActionHandler;", "setMItemActionHandler", "(Lcom/box/android/base/presentation/utilities/IItemActionHandler;)V", "mItemActionHandlerFactory", "Lcom/box/android/base/presentation/utilities/IItemActionHandler$Factory;", "getMItemActionHandlerFactory", "()Lcom/box/android/base/presentation/utilities/IItemActionHandler$Factory;", "setMItemActionHandlerFactory", "(Lcom/box/android/base/presentation/utilities/IItemActionHandler$Factory;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initializeNavigation", "getActivityLayoutId", "", "()Ljava/lang/Integer;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class FileRouterActivity extends Hilt_FileRouterActivity {
    public static final int $stable = 8;
    private IItemActionHandler mItemActionHandler;

    @Inject
    public IItemActionHandler.Factory mItemActionHandlerFactory;

    public final IItemActionHandler getMItemActionHandler() {
        return this.mItemActionHandler;
    }

    public final void setMItemActionHandler(IItemActionHandler iItemActionHandler) {
        this.mItemActionHandler = iItemActionHandler;
    }

    public final IItemActionHandler.Factory getMItemActionHandlerFactory() {
        IItemActionHandler.Factory factory = this.mItemActionHandlerFactory;
        if (factory != null) {
            return factory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mItemActionHandlerFactory");
        return null;
    }

    public final void setMItemActionHandlerFactory(IItemActionHandler.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "<set-?>");
        this.mItemActionHandlerFactory = factory;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        this.mItemActionHandler = getMItemActionHandlerFactory().create(this);
        showSpinner(getString(R.string.please_wait_dot_dot_dot));
        initializeNavigation();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.box.android.domain.models.preview.PreviewSource$Unknown] */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.box.android.activities.urlsinterceptor.router.FileRouterActivity$initializeNavigation$2] */
    private final void initializeNavigation() {
        BoxFile boxFile;
        String string;
        String string2;
        String string3;
        BoxResponse boxResponse;
        Object serializable;
        Parcelable parcelable;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = PreviewSource.Unknown.INSTANCE;
        BoxResponse boxResponse2 = null;
        if (getIntent() == null || getIntent().getExtras() == null) {
            boxFile = null;
            string = null;
            string2 = null;
            string3 = null;
        } else {
            Bundle extras = getIntent().getExtras();
            Intrinsics.checkNotNull(extras);
            if (Build.VERSION.SDK_INT >= 33) {
                serializable = extras.getSerializable(IntentConstants.EXTRA_INIT_FILE, BoxFile.class);
            } else {
                Object serializable2 = extras.getSerializable(IntentConstants.EXTRA_INIT_FILE);
                if (!(serializable2 instanceof BoxFile)) {
                    serializable2 = null;
                }
                serializable = (Serializable) ((BoxFile) serializable2);
            }
            boxFile = (BoxFile) serializable;
            Bundle extras2 = getIntent().getExtras();
            Intrinsics.checkNotNull(extras2);
            string = extras2.getString(IntentConstants.EXTRA_INIT_FILE_ID);
            Bundle extras3 = getIntent().getExtras();
            Intrinsics.checkNotNull(extras3);
            string2 = extras3.getString(IntentConstants.EXTRA_INIT_WEB_LINK_ID);
            Bundle extras4 = getIntent().getExtras();
            Intrinsics.checkNotNull(extras4);
            string3 = extras4.getString(BoxFragmentActivity.EXTRA_SHAREDLINK_URL);
            Bundle extras5 = getIntent().getExtras();
            Intrinsics.checkNotNull(extras5);
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) extras5.getParcelable(IntentConstants.EXTRA_ENTRYPOINT, PreviewSource.class);
            } else {
                Parcelable parcelable2 = extras5.getParcelable(IntentConstants.EXTRA_ENTRYPOINT);
                if (!(parcelable2 instanceof PreviewSource)) {
                    parcelable2 = null;
                }
                parcelable = (PreviewSource) parcelable2;
            }
            PreviewSource previewSource = (PreviewSource) parcelable;
            T t = previewSource;
            if (previewSource == null) {
                t = (PreviewSource) objectRef.element;
            }
            objectRef.element = t;
        }
        if (boxFile != null) {
            IItemActionHandler iItemActionHandler = this.mItemActionHandler;
            if (iItemActionHandler != null) {
                iItemActionHandler.onItemClick(boxFile, true, string3, (PreviewSource) objectRef.element);
            }
            finish();
            return;
        }
        if (string != null) {
            BoxRequestsFile.GetFileInfo infoRequest = this.mBoxExtendedApiFile.getInfoRequest(string);
            try {
                IBaseModelController iBaseModelController = this.mBaseMoco;
                Intrinsics.checkNotNull(infoRequest);
                boxResponse2 = (BoxResponse) iBaseModelController.performLocal(infoRequest).get();
            } catch (InterruptedException e) {
                String name = getClass().getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                BoxLogUtils.e(name, e);
            } catch (ExecutionException e2) {
                String name2 = getClass().getName();
                Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                BoxLogUtils.e(name2, e2);
            }
            if (boxResponse2 != null && boxResponse2.isSuccess()) {
                IItemActionHandler iItemActionHandler2 = this.mItemActionHandler;
                if (iItemActionHandler2 != null) {
                    BoxObject result = boxResponse2.getResult();
                    Intrinsics.checkNotNull(result, "null cannot be cast to non-null type com.box.androidsdk.content.models.BoxItem");
                    IItemActionHandler.onItemClick$default(iItemActionHandler2, (BoxItem) result, true, null, (PreviewSource) objectRef.element, 4, null);
                }
                finish();
                return;
            }
            IBaseModelController iBaseModelController2 = this.mBaseMoco;
            Intrinsics.checkNotNull(infoRequest);
            iBaseModelController2.performRemote(infoRequest, new BoxAppFutureTask.OnCompletedListener() { // from class: com.box.android.activities.urlsinterceptor.router.FileRouterActivity$$ExternalSyntheticLambda0
                @Override // com.box.android.coreservices.modelcontroller.BoxAppFutureTask.OnCompletedListener
                public final void onCompleted(BoxResponse boxResponse3) {
                    FileRouterActivity.initializeNavigation$lambda$0(this.f$0, objectRef, boxResponse3);
                }
            });
            return;
        }
        if (string2 != null) {
            BoxRequestsBookmark.GetBookmarkInfo infoRequest2 = this.mBoxApiBookmark.getInfoRequest(string2);
            try {
                IBaseModelController iBaseModelController3 = this.mBaseMoco;
                Intrinsics.checkNotNull(infoRequest2);
                boxResponse = (BoxResponse) iBaseModelController3.performLocal(infoRequest2).get();
                try {
                    IItemActionHandler iItemActionHandler3 = this.mItemActionHandler;
                    if (iItemActionHandler3 != null) {
                        BoxObject result2 = boxResponse.getResult();
                        Intrinsics.checkNotNull(result2, "null cannot be cast to non-null type com.box.androidsdk.content.models.BoxItem");
                        IItemActionHandler.onItemClick$default(iItemActionHandler3, (BoxItem) result2, false, null, PreviewSource.Unknown.INSTANCE, 4, null);
                    }
                } catch (InterruptedException e3) {
                    e = e3;
                    boxResponse2 = boxResponse;
                    BoxLogUtils.logException(e);
                    boxResponse = boxResponse2;
                } catch (ExecutionException e4) {
                    e = e4;
                    boxResponse2 = boxResponse;
                    BoxLogUtils.logException(e);
                    boxResponse = boxResponse2;
                }
            } catch (InterruptedException e5) {
                e = e5;
            } catch (ExecutionException e6) {
                e = e6;
            }
            IBaseModelController iBaseModelController4 = this.mBaseMoco;
            Intrinsics.checkNotNull(infoRequest2);
            final BoxAppFutureTask boxAppFutureTaskPerformRemote = iBaseModelController4.performRemote(infoRequest2);
            if (boxResponse == null || !boxResponse.isSuccess()) {
                new Thread() { // from class: com.box.android.activities.urlsinterceptor.router.FileRouterActivity.initializeNavigation.2
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            BoxResponse boxResponse3 = boxAppFutureTaskPerformRemote.get();
                            IItemActionHandler mItemActionHandler = this.getMItemActionHandler();
                            if (mItemActionHandler != null) {
                                BoxObject result3 = boxResponse3.getResult();
                                Intrinsics.checkNotNullExpressionValue(result3, "getResult(...)");
                                IItemActionHandler.onItemClick$default(mItemActionHandler, (BoxItem) result3, false, null, PreviewSource.Unknown.INSTANCE, 4, null);
                            }
                        } catch (InterruptedException e7) {
                            BoxLogUtils.logException(e7);
                        } catch (ExecutionException e8) {
                            BoxLogUtils.logException(e8);
                        }
                    }
                }.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:12:0x004b  */
    /* JADX WARN: Code duplicated, block: B:14:0x0054  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initializeNavigation$lambda$0(FileRouterActivity fileRouterActivity, Ref.ObjectRef objectRef, BoxResponse boxResponse) {
        FileRouterActivity fileRouterActivity2;
        if (boxResponse.isSuccess()) {
            IItemActionHandler iItemActionHandler = fileRouterActivity.mItemActionHandler;
            if (iItemActionHandler != null) {
                BoxObject result = boxResponse.getResult();
                Intrinsics.checkNotNullExpressionValue(result, "getResult(...)");
                IItemActionHandler.onItemClick$default(iItemActionHandler, (BoxItem) result, true, null, (PreviewSource) objectRef.element, 4, null);
            }
        } else if (boxResponse.getException() instanceof BoxException) {
            Exception exception = boxResponse.getException();
            Intrinsics.checkNotNull(exception, "null cannot be cast to non-null type com.box.androidsdk.content.BoxException");
            if (((BoxException) exception).getResponseCode() == 404) {
                BoxPresentationUtils.displayToast(R.string.error_item_unavailable, fileRouterActivity, new String[0]);
            } else {
                fileRouterActivity2 = fileRouterActivity;
                if (!SdkUtils.isInternetAvailable(fileRouterActivity2)) {
                    BoxPresentationUtils.displayToast(R.string.box_previewsdk_please_check_internet_connection, fileRouterActivity2, new String[0]);
                }
            }
        } else {
            fileRouterActivity2 = fileRouterActivity;
            if (!SdkUtils.isInternetAvailable(fileRouterActivity2)) {
                BoxPresentationUtils.displayToast(R.string.box_previewsdk_please_check_internet_connection, fileRouterActivity2, new String[0]);
            }
        }
        fileRouterActivity.finish();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return Integer.valueOf(R.layout.router_activity);
    }
}
