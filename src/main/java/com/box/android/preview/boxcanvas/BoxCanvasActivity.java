package com.box.android.preview.boxcanvas;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.box.android.coreservices.models.CustomBoxSession;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.preview.R;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxSession;
import dagger.hilt.android.AndroidEntryPoint;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* JADX INFO: compiled from: BoxCanvasActivity.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0010\u001a\u00020\u0011H\u0014¢\u0006\u0002\u0010\u0012J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/box/android/preview/boxcanvas/BoxCanvasActivity;", "Lcom/box/android/base/presentation/activities/BoxFragmentActivity;", "<init>", "()V", "boxCanvasHelper", "Lcom/box/android/preview/boxcanvas/BoxCanvasIntentBuilder;", "getBoxCanvasHelper", "()Lcom/box/android/preview/boxcanvas/BoxCanvasIntentBuilder;", "setBoxCanvasHelper", "(Lcom/box/android/preview/boxcanvas/BoxCanvasIntentBuilder;)V", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "getUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "setUserContextManager", "(Lcom/box/android/domain/identity/IUserContextManager;)V", "getActivityLayoutId", "", "()Ljava/lang/Integer;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class BoxCanvasActivity extends Hilt_BoxCanvasActivity {
    private static final String BOX_FILE = "BoxCanvasActivity.File";
    private static final String SHARED_LINK_URL = "BoxCanvasActivity.SharedLinkUrl";
    private static final String SHOW_BACKGROUND = "BoxCanvasActivity.ShowBackground";

    @Inject
    public BoxCanvasIntentBuilder boxCanvasHelper;

    @Inject
    public IUserContextManager userContextManager;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public final BoxCanvasIntentBuilder getBoxCanvasHelper() {
        BoxCanvasIntentBuilder boxCanvasIntentBuilder = this.boxCanvasHelper;
        if (boxCanvasIntentBuilder != null) {
            return boxCanvasIntentBuilder;
        }
        Intrinsics.throwUninitializedPropertyAccessException("boxCanvasHelper");
        return null;
    }

    public final void setBoxCanvasHelper(BoxCanvasIntentBuilder boxCanvasIntentBuilder) {
        Intrinsics.checkNotNullParameter(boxCanvasIntentBuilder, "<set-?>");
        this.boxCanvasHelper = boxCanvasIntentBuilder;
    }

    public final IUserContextManager getUserContextManager() {
        IUserContextManager iUserContextManager = this.userContextManager;
        if (iUserContextManager != null) {
            return iUserContextManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("userContextManager");
        return null;
    }

    public final void setUserContextManager(IUserContextManager iUserContextManager) {
        Intrinsics.checkNotNullParameter(iUserContextManager, "<set-?>");
        this.userContextManager = iUserContextManager;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        int i;
        if (getIntent().getBooleanExtra(SHOW_BACKGROUND, false)) {
            i = R.layout.box_canvas_activity;
        } else {
            i = R.layout.box_canvas_activity_without_bg;
        }
        return Integer.valueOf(i);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        BoxFile serializableExtra;
        List listSplit$default;
        super.onMAMCreate(bundle);
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        String str = null;
        if (Build.VERSION.SDK_INT >= 33) {
            serializableExtra = intent.getSerializableExtra(BOX_FILE, BoxFile.class);
        } else {
            Serializable serializableExtra2 = intent.getSerializableExtra(BOX_FILE);
            if (!(serializableExtra2 instanceof BoxFile)) {
                serializableExtra2 = null;
            }
            serializableExtra = (BoxFile) serializableExtra2;
        }
        Intrinsics.checkNotNull(serializableExtra);
        BoxFile boxFile = (BoxFile) serializableExtra;
        BoxSession boxSession = getUserContextManager().getBoxSession(this);
        Intrinsics.checkNotNull(boxSession, "null cannot be cast to non-null type com.box.android.coreservices.models.CustomBoxSession");
        CustomBoxSession customBoxSession = (CustomBoxSession) boxSession;
        String stringExtra = getIntent().getStringExtra(SHARED_LINK_URL);
        if (stringExtra != null && (listSplit$default = StringsKt.split$default((CharSequence) stringExtra, new String[]{"/"}, false, 0, 6, (Object) null)) != null) {
            str = (String) CollectionsKt.last(listSplit$default);
        }
        showSpinner();
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new BoxCanvasActivity$onCreate$1(this, boxFile, customBoxSession, str, null), 3, null);
    }

    /* JADX INFO: compiled from: BoxCanvasActivity.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/box/android/preview/boxcanvas/BoxCanvasActivity$Companion;", "", "<init>", "()V", "BOX_FILE", "", "SHOW_BACKGROUND", "SHARED_LINK_URL", "getLaunchIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "boxCanvas", "Lcom/box/androidsdk/content/models/BoxFile;", "showBackground", "", "sharedLinkUrl", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ Intent getLaunchIntent$default(Companion companion, Context context, BoxFile boxFile, boolean z, String str, int i, Object obj) {
            if ((i & 8) != 0) {
                str = null;
            }
            return companion.getLaunchIntent(context, boxFile, z, str);
        }

        public final Intent getLaunchIntent(Context context, BoxFile boxCanvas, boolean showBackground, String sharedLinkUrl) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(boxCanvas, "boxCanvas");
            Intent intent = new Intent(context, (Class<?>) BoxCanvasActivity.class);
            intent.putExtra(BoxCanvasActivity.BOX_FILE, boxCanvas);
            intent.putExtra(BoxCanvasActivity.SHOW_BACKGROUND, showBackground);
            if (sharedLinkUrl != null) {
                intent.putExtra(BoxCanvasActivity.SHARED_LINK_URL, sharedLinkUrl);
            }
            return intent;
        }
    }
}
