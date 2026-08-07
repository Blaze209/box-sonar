package com.box.android.base.presentation.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.box.android.base.R;
import com.box.android.base.presentation.utilities.imagemanager.StaticImageManager;
import com.box.android.coreservices.utilities.CoreServiceUtils;
import com.box.android.coreservices.utilities.DisplayResolveInfo;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes9.dex */
public class IntentChooserActivity extends Hilt_IntentChooserActivity {
    private static final String EXTRA_PREFERRED_PACKAGE_NAMES = "preferredPackageNames";
    private static final int INTENT_REDIRECT_REQUEST = 600;
    private static final String LAUNCH_INTENT = "launchIntent";
    private static Intent mIntent;
    RecyclerView mBottomSheetRecyclerView;
    BottomSheetDialog mDialog;
    View mainBottomSheet;

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return null;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected boolean requiresAuthToken() {
        return false;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected boolean requiresPinCode() {
        return false;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void handleOnActivityResult(int i, int i2, Intent intent) {
        if (i == 600) {
            if (intent != null) {
                intent.setPackage(mIntent.getPackage());
            } else {
                intent = new Intent();
                intent.setPackage(mIntent.getPackage());
            }
            setResult(i2, intent);
            finish();
        }
        super.handleOnActivityResult(i, i2, intent);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxCreate(Bundle bundle) {
        super.onBoxCreate(bundle);
        Intent intent = (Intent) getIntent().getExtras().getParcelable(LAUNCH_INTENT);
        mIntent = intent;
        if (intent == null) {
            finish();
            return;
        }
        ArrayList<String> stringArrayList = getIntent().getExtras().getStringArrayList(EXTRA_PREFERRED_PACKAGE_NAMES);
        ArrayList<DisplayResolveInfo> availableIntents = CoreServiceUtils.getAvailableIntents(mIntent);
        if (stringArrayList != null) {
            HashMap map = new HashMap(stringArrayList.size());
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                map.put(it.next(), null);
            }
            ArrayList<DisplayResolveInfo> arrayList = new ArrayList<>(availableIntents.size());
            for (DisplayResolveInfo displayResolveInfo : availableIntents) {
                if (map.containsKey(displayResolveInfo.getPackageName())) {
                    map.put(displayResolveInfo.getPackageName(), displayResolveInfo);
                } else {
                    arrayList.add(displayResolveInfo);
                }
            }
            for (int size = stringArrayList.size() - 1; size >= 0; size--) {
                DisplayResolveInfo displayResolveInfo2 = (DisplayResolveInfo) map.get(stringArrayList.get(size));
                if (displayResolveInfo2 != null) {
                    arrayList.add(0, displayResolveInfo2);
                }
            }
            availableIntents = arrayList;
        }
        if (availableIntents != null && availableIntents.size() > 1) {
            displayDialog(availableIntents);
        } else if (availableIntents != null && availableIntents.size() > 0) {
            launchActivity(availableIntents.get(0).getPackageName());
        } else {
            finish();
        }
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMDestroy() {
        BottomSheetDialog bottomSheetDialog = this.mDialog;
        if (bottomSheetDialog != null) {
            bottomSheetDialog.dismiss();
        }
        super.onMAMDestroy();
    }

    private void displayDialog(ArrayList<DisplayResolveInfo> arrayList) {
        this.mDialog = new BottomSheetDialog(this);
        View viewInflate = getLayoutInflater().inflate(R.layout.main_bottom_sheet, (ViewGroup) null);
        this.mainBottomSheet = viewInflate;
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.recyclerView);
        this.mBottomSheetRecyclerView = recyclerView;
        recyclerView.setAdapter(new IntentAdapter(getPackageManager(), arrayList, new View.OnClickListener() { // from class: com.box.android.base.presentation.activities.IntentChooserActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IntentChooserActivity.this.launchActivity((String) view.getTag());
            }
        }));
        this.mBottomSheetRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.mDialog.setContentView(this.mainBottomSheet);
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.box.android.base.presentation.activities.IntentChooserActivity.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                IntentChooserActivity.this.setResult(0);
                IntentChooserActivity.this.finish();
            }
        });
        this.mDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launchActivity(String str) {
        Intent intent = mIntent;
        intent.setPackage(str);
        startActivityForResult(intent, 600);
    }

    public static Intent newInstance(Context context, Intent intent) {
        Intent intent2 = new Intent(context, (Class<?>) IntentChooserActivity.class);
        intent2.putExtra(LAUNCH_INTENT, intent);
        return intent2;
    }

    public static Intent newInstance(Context context, Intent intent, ArrayList<String> arrayList) {
        Intent intentNewInstance = newInstance(context, intent);
        intentNewInstance.putStringArrayListExtra(EXTRA_PREFERRED_PACKAGE_NAMES, arrayList);
        return intentNewInstance;
    }

    public static class IntentAdapter extends RecyclerView.Adapter<ViewHolder> {
        View.OnClickListener mClickListener;
        PackageManager mPm;
        private final ArrayList<DisplayResolveInfo> mResolveInfos;

        public IntentAdapter(PackageManager packageManager, ArrayList<DisplayResolveInfo> arrayList, View.OnClickListener onClickListener) {
            this.mResolveInfos = arrayList;
            this.mPm = packageManager;
            this.mClickListener = onClickListener;
        }

        static class ViewHolder extends RecyclerView.ViewHolder {
            ImageView mIcon;
            TextView mTitle;
            View parent;

            public ViewHolder(View view) {
                super(view);
                this.mTitle = (TextView) view.findViewById(R.id.title);
                this.mIcon = (ImageView) view.findViewById(R.id.item_icon);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            DisplayResolveInfo displayResolveInfo = this.mResolveInfos.get(i);
            String packageName = displayResolveInfo.getPackageName();
            try {
                viewHolder.mIcon.setImageDrawable(MAMPackageManagement.getApplicationIcon(this.mPm, packageName));
            } catch (PackageManager.NameNotFoundException unused) {
                viewHolder.mIcon.setImageDrawable(StaticImageManager.getOrAddDrawable(R.drawable.icon_app_cloud));
            }
            viewHolder.mTitle.setText(displayResolveInfo.displayLabel);
            viewHolder.itemView.setTag(packageName);
            viewHolder.itemView.setOnClickListener(this.mClickListener);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.mResolveInfos.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bottom_sheet_list_item, viewGroup, false));
        }
    }
}
