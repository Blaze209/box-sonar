package sdk.pendo.io.x5;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.ProgressBar;
import androidx.media3.ui.DefaultTimeBar;
import com.microsoft.intune.mam.client.app.MAMDialogFragment;
import sdk.pendo.io.R;

/* JADX INFO: loaded from: classes6.dex */
public class b extends MAMDialogFragment {
    @Override // com.microsoft.intune.mam.client.app.MAMDialogFragment, com.microsoft.intune.mam.client.app.HookedFragmentBase
    public void onMAMAttach(Activity activity) {
        super.onMAMAttach(activity);
    }

    @Override // com.microsoft.intune.mam.client.app.MAMDialogFragment, com.microsoft.intune.mam.client.app.HookedDialogFragmentBase
    public Dialog onMAMCreateDialog(Bundle bundle) {
        setRetainInstance(true);
        setCancelable(true);
        Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(1);
        dialog.setContentView(R.layout.pnd_activity_pairing_mode);
        ProgressBar progressBar = (ProgressBar) dialog.findViewById(R.id.progress_bar);
        progressBar.setIndeterminate(true);
        progressBar.setIndeterminateDrawable(progressBar.getIndeterminateDrawable());
        Window window = dialog.getWindow();
        window.setLayout(-1, -1);
        window.setBackgroundDrawable(new ColorDrawable(DefaultTimeBar.DEFAULT_BUFFERED_COLOR));
        return dialog;
    }

    @Override // com.microsoft.intune.mam.client.app.MAMDialogFragment, com.microsoft.intune.mam.client.app.HookedFragmentBase
    public void onMAMDestroyView() {
        if (getDialog() != null && getRetainInstance()) {
            getDialog().setDismissMessage(null);
        }
        super.onMAMDestroyView();
    }
}
