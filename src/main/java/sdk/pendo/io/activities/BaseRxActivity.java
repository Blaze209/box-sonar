package sdk.pendo.io.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import sdk.pendo.io.j4.a;
import sdk.pendo.io.t4.d;
import sdk.pendo.io.t4.g;

/* JADX INFO: loaded from: classes4.dex */
public class BaseRxActivity extends AppCompatActivity {
    private final a<sdk.pendo.io.t4.a> a = a.m();

    public final <T> d<T> a() {
        return g.a(this.a);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        this.a.onNext(sdk.pendo.io.t4.a.CREATE);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMDestroy() {
        this.a.onNext(sdk.pendo.io.t4.a.DESTROY);
        super.onMAMDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMPause() {
        this.a.onNext(sdk.pendo.io.t4.a.PAUSE);
        super.onMAMPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMResume() {
        super.onMAMResume();
        this.a.onNext(sdk.pendo.io.t4.a.RESUME);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        this.a.onNext(sdk.pendo.io.t4.a.START);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        this.a.onNext(sdk.pendo.io.t4.a.STOP);
        super.onStop();
    }
}
