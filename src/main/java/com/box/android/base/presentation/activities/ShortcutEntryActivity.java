package com.box.android.base.presentation.activities;

import androidx.core.app.NotificationCompat;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.coreservices.modelcontroller.messages.BoxUserAuthenticationMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ShortcutEntryActivity.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0014¨\u0006\n"}, d2 = {"Lcom/box/android/base/presentation/activities/ShortcutEntryActivity;", "Lcom/box/android/base/presentation/activities/BoxEntrypointActivity;", "<init>", "()V", "getAuthErrorMessageRes", "", "onAuthenticated", "", NotificationCompat.CATEGORY_MESSAGE, "Lcom/box/android/coreservices/modelcontroller/messages/BoxUserAuthenticationMessage;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class ShortcutEntryActivity extends BoxEntrypointActivity {
    public static final int $stable = 8;

    public abstract int getAuthErrorMessageRes();

    @Override // com.box.android.base.presentation.activities.BoxEntrypointActivity
    protected void onAuthenticated(BoxUserAuthenticationMessage msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (!msg.wasSuccessful()) {
            BoxPresentationUtils.displayToast(getString(getAuthErrorMessageRes()), this);
        }
        finish();
    }
}
