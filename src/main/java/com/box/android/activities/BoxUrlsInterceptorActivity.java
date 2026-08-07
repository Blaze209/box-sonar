package com.box.android.activities;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.compose.DialogNavigator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.box.android.R;
import com.box.android.activities.urlsinterceptor.BoxNotesInterceptorActivity;
import com.box.android.activities.urlsinterceptor.SharedLinkInterceptorActivity;
import com.box.android.activities.urlsinterceptor.WebUrlsInterceptorActivity;
import com.box.android.base.presentation.activities.IntentChooserActivity;
import com.box.android.coreservices.utilities.CoreServiceUtils;
import com.box.android.coreservices.utilities.DisplayResolveInfo;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: BoxUrlsInterceptorActivity.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u000bH\u0014J\u0016\u0010\u000f\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0015H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/box/android/activities/BoxUrlsInterceptorActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", DialogNavigator.NAME, "Landroid/app/Dialog;", "getDialog", "()Landroid/app/Dialog;", "setDialog", "(Landroid/app/Dialog;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "displayDialog", "mList", "Ljava/util/ArrayList;", "Lcom/box/android/coreservices/utilities/DisplayResolveInfo;", "launchActivity", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "", "activityName", "getActivityToHandleIntent", "Companion", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxUrlsInterceptorActivity extends AppCompatActivity {
    private static final String COMPONENT_BOX_URLS_NOTES = "com.box.android.BoxUrlsNotes";
    private static final String COMPONENT_BOX_URLS_SHARED = "com.box.android.BoxUrlsShared";
    private static final String COMPONENT_BOX_URLS_WEB = "com.box.android.BoxUrlsWeb";
    private Dialog dialog;
    public static final int $stable = 8;
    private static final List<String> validPackages = CollectionsKt.listOf((Object[]) new String[]{"com.box.android", "com.box.emm.android", "forgepond.com.box.emm.android"});

    public final Dialog getDialog() {
        return this.dialog;
    }

    public final void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        List<ResolveInfo> listQueryIntentActivities = MAMPackageManagement.queryIntentActivities(getPackageManager(), new Intent("android.intent.action.VIEW", getIntent().getData()), 0);
        Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "queryIntentActivities(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : listQueryIntentActivities) {
            List<String> list = validPackages;
            ActivityInfo activityInfo = ((ResolveInfo) obj).activityInfo;
            if (CollectionsKt.contains(list, activityInfo != null ? activityInfo.packageName : null)) {
                arrayList.add(obj);
            }
        }
        List<ResolveInfo> mutableList = CollectionsKt.toMutableList((Collection) arrayList);
        if (mutableList.size() == 1 || Build.VERSION.SDK_INT < 31) {
            String packageName = getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
            launchActivity(packageName, getActivityToHandleIntent());
            return;
        }
        displayDialog(CoreServiceUtils.INSTANCE.getDisplayResolveInfos(mutableList));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMDestroy() {
        super.onMAMDestroy();
        Dialog dialog = this.dialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    private final void displayDialog(ArrayList<DisplayResolveInfo> mList) {
        BoxUrlsInterceptorActivity boxUrlsInterceptorActivity = this;
        this.dialog = new BottomSheetDialog(boxUrlsInterceptorActivity);
        View viewInflate = getLayoutInflater().inflate(R.layout.main_bottom_sheet, (ViewGroup) null);
        View viewFindViewById = viewInflate.findViewById(R.id.recyclerView);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) viewFindViewById;
        recyclerView.setAdapter(new IntentChooserActivity.IntentAdapter(getPackageManager(), mList, new View.OnClickListener() { // from class: com.box.android.activities.BoxUrlsInterceptorActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BoxUrlsInterceptorActivity.displayDialog$lambda$0(this.f$0, view);
            }
        }));
        recyclerView.setLayoutManager(new LinearLayoutManager(boxUrlsInterceptorActivity));
        Dialog dialog = this.dialog;
        if (dialog != null) {
            dialog.setContentView(viewInflate);
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.box.android.activities.BoxUrlsInterceptorActivity$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    this.f$0.finish();
                }
            });
            dialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void displayDialog$lambda$0(BoxUrlsInterceptorActivity boxUrlsInterceptorActivity, View view) {
        Object tag = view.getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.String");
        boxUrlsInterceptorActivity.launchActivity((String) tag, boxUrlsInterceptorActivity.getActivityToHandleIntent());
    }

    private final void launchActivity(String packageName, String activityName) {
        Intent intent = new Intent();
        intent.setData(getIntent().getData());
        intent.setFlags(335544320);
        intent.setClassName(packageName, activityName);
        startActivity(intent);
        finish();
    }

    /* JADX WARN: Code duplicated, block: B:19:0x004c A[ADDED_TO_REGION, REMOVE] */
    private final String getActivityToHandleIntent() {
        String qualifiedName;
        String className = getComponentName().getClassName();
        int iHashCode = className.hashCode();
        if (iHashCode != -1219697663) {
            if (iHashCode != 980205349) {
                if (iHashCode != 1093709972 || className.equals(COMPONENT_BOX_URLS_WEB)) {
                    qualifiedName = Reflection.getOrCreateKotlinClass(WebUrlsInterceptorActivity.class).getQualifiedName();
                } else {
                    qualifiedName = Reflection.getOrCreateKotlinClass(WebUrlsInterceptorActivity.class).getQualifiedName();
                }
            } else if (className.equals(COMPONENT_BOX_URLS_SHARED)) {
                qualifiedName = Reflection.getOrCreateKotlinClass(SharedLinkInterceptorActivity.class).getQualifiedName();
            } else {
                qualifiedName = Reflection.getOrCreateKotlinClass(WebUrlsInterceptorActivity.class).getQualifiedName();
            }
        } else if (className.equals(COMPONENT_BOX_URLS_NOTES)) {
            qualifiedName = Reflection.getOrCreateKotlinClass(BoxNotesInterceptorActivity.class).getQualifiedName();
        } else {
            qualifiedName = Reflection.getOrCreateKotlinClass(WebUrlsInterceptorActivity.class).getQualifiedName();
        }
        Intrinsics.checkNotNull(qualifiedName);
        return qualifiedName;
    }
}
