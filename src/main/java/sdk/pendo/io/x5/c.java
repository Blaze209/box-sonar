package sdk.pendo.io.x5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.microsoft.intune.mam.client.app.MAMDialogFragment;
import sdk.pendo.io.R;

/* JADX INFO: loaded from: classes6.dex */
public final class c extends MAMDialogFragment {
    private static final int a = R.layout.pnd_activity_test_mode;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dismiss();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            sdk.pendo.io.p6.b.d();
            sdk.pendo.io.k6.a aVar = sdk.pendo.io.k6.a.a;
            aVar.f();
            aVar.b();
            Toast.makeText(c.this.getActivity(), c.this.getResources().getString(R.string.pnd_disconnected_permanently), 0).show();
            c.this.dismiss();
        }
    }

    public static c a() {
        return new c();
    }

    @Override // com.microsoft.intune.mam.client.app.MAMDialogFragment, com.microsoft.intune.mam.client.app.HookedFragmentBase
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        setStyle(0, R.style.pnd_Pendo_Dialog_Transparent_Background);
    }

    @Override // com.microsoft.intune.mam.client.app.MAMDialogFragment, com.microsoft.intune.mam.client.app.HookedFragmentBase
    public View onMAMCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(a, viewGroup, false);
        getDialog().getWindow().setBackgroundDrawableResource(R.color.pnd_backgrpund_test_dialog);
        viewInflate.findViewById(R.id.insert_testmode_container).setOnClickListener(new a());
        viewInflate.findViewById(R.id.btnDisconnect).setOnClickListener(new b());
        return viewInflate;
    }
}
