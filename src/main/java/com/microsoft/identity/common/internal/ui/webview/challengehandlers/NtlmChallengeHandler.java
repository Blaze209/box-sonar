package com.microsoft.identity.common.internal.ui.webview.challengehandlers;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.microsoft.identity.common.R;
import com.microsoft.identity.common.java.providers.RawAuthorizationResult;
import com.microsoft.identity.common.java.ui.webview.authorization.IAuthorizationCompletionCallback;
import com.microsoft.identity.common.logging.Logger;
import com.microsoft.intune.mam.client.app.MAMAlertDialogBuilder;

/* JADX INFO: loaded from: classes14.dex */
public final class NtlmChallengeHandler implements IChallengeHandler<NtlmChallenge, Void> {
    private static final String TAG = "NtlmChallengeHandler";
    private final Activity mActivity;
    private final IAuthorizationCompletionCallback mChallengeCallback;

    public NtlmChallengeHandler(Activity activity, IAuthorizationCompletionCallback iAuthorizationCompletionCallback) {
        this.mActivity = activity;
        this.mChallengeCallback = iAuthorizationCompletionCallback;
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.challengehandlers.IChallengeHandler
    public Void processChallenge(NtlmChallenge ntlmChallenge) {
        showHttpAuthDialog(ntlmChallenge);
        return null;
    }

    private void showHttpAuthDialog(final NtlmChallenge ntlmChallenge) {
        final String str = TAG + ":showHttpAuthDialog";
        View viewInflate = LayoutInflater.from(this.mActivity).inflate(this.mActivity.getResources().getLayout(R.layout.http_auth_dialog), (ViewGroup) null);
        final EditText editText = (EditText) viewInflate.findViewById(R.id.editUserName);
        final EditText editText2 = (EditText) viewInflate.findViewById(R.id.editPassword);
        new MAMAlertDialogBuilder(this.mActivity).setTitle(this.mActivity.getText(R.string.http_auth_dialog_title).toString()).setView(viewInflate).setPositiveButton(R.string.http_auth_dialog_login, new DialogInterface.OnClickListener() { // from class: com.microsoft.identity.common.internal.ui.webview.challengehandlers.NtlmChallengeHandler.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Logger.info(str, "Proceeding with user supplied username and password.");
                ntlmChallenge.getHandler().proceed(editText.getText().toString(), editText2.getText().toString());
            }
        }).setNegativeButton(R.string.http_auth_dialog_cancel, new DialogInterface.OnClickListener() { // from class: com.microsoft.identity.common.internal.ui.webview.challengehandlers.NtlmChallengeHandler.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                ntlmChallenge.getHandler().cancel();
                NtlmChallengeHandler.this.cancelRequest();
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.microsoft.identity.common.internal.ui.webview.challengehandlers.NtlmChallengeHandler.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                ntlmChallenge.getHandler().cancel();
                NtlmChallengeHandler.this.cancelRequest();
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelRequest() {
        Logger.info(TAG + ":cancelRequest", "Sending intent to cancel authentication activity");
        this.mChallengeCallback.onChallengeResponseReceived(RawAuthorizationResult.fromResultCode(RawAuthorizationResult.ResultCode.CANCELLED));
    }
}
