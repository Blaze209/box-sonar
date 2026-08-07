package sdk.pendo.io.x5;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import com.microsoft.intune.mam.client.app.MAMDialogFragment;
import sdk.pendo.io.R;

/* JADX INFO: loaded from: classes6.dex */
public class a extends MAMDialogFragment {
    private static final int b = R.color.pnd_colorTransparent;
    private Dialog a = null;

    /* JADX INFO: renamed from: sdk.pendo.io.x5.a$a, reason: collision with other inner class name */
    class ViewOnClickListenerC0518a implements View.OnClickListener {
        ViewOnClickListenerC0518a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a.dismiss();
        }
    }

    public static a a(int i, int i2) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putInt("layoutID", i);
        bundle.putInt("imageID", i2);
        aVar.setArguments(bundle);
        return aVar;
    }

    @Override // com.microsoft.intune.mam.client.app.MAMDialogFragment, com.microsoft.intune.mam.client.app.HookedFragmentBase
    public void onMAMAttach(Activity activity) {
        super.onMAMAttach(activity);
    }

    @Override // com.microsoft.intune.mam.client.app.MAMDialogFragment, com.microsoft.intune.mam.client.app.HookedDialogFragmentBase
    public Dialog onMAMCreateDialog(Bundle bundle) {
        int i = R.layout.pnd_capture_fail;
        int i2 = R.id.imageViewFail;
        if (getArguments() != null) {
            i = getArguments().getInt("layoutID");
            i2 = getArguments().getInt("imageID");
        }
        setRetainInstance(true);
        setCancelable(true);
        Dialog dialog = new Dialog(getActivity());
        this.a = dialog;
        dialog.requestWindowFeature(1);
        this.a.setContentView(i);
        ((View) ((ImageView) this.a.findViewById(i2)).getParent()).setOnClickListener(new ViewOnClickListenerC0518a());
        Window window = this.a.getWindow();
        if (window != null) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(new ColorDrawable(getResources().getColor(b)));
        }
        return this.a;
    }

    @Override // com.microsoft.intune.mam.client.app.MAMDialogFragment, com.microsoft.intune.mam.client.app.HookedFragmentBase
    public void onMAMDestroyView() {
        if (getDialog() != null && getRetainInstance()) {
            getDialog().setDismissMessage(null);
        }
        super.onMAMDestroyView();
    }
}
