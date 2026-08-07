package com.box.android.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;
import com.box.android.R;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.modelcontroller.IMoCoBatchOperations;
import com.box.android.domain.utils.BoxTypeIdPair;
import com.box.androidsdk.content.models.BoxCollaborationItem;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.utils.BoxItemUtility;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiWeblink;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes9.dex */
public class DeleteItemsActivity extends Hilt_DeleteItemsActivity implements View.OnClickListener {
    private static final String EXTRA_ITEMS_TO_DELETE = "itemsToDelete";
    private static final String EXTRA_USE_BATCH_MODE = "useBatchMode";
    private static final String OK_CLICKED = "DeleteItemsActivity.OKClicked";

    @Inject
    protected IMoCoBatchOperations mBatchOperationsMoCo;

    @Inject
    protected BoxExtendedApiWeblink mBookmarkApi;
    private boolean mOKClicked = false;
    private ArrayList<BoxTypeIdPair> mTypedIdsToDelete;

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return null;
    }

    @Override // com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, androidx.activity.ComponentActivity, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public /* bridge */ /* synthetic */ ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return super.getDefaultViewModelProviderFactory();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxCreate(Bundle bundle) {
        super.onBoxCreate(bundle);
        if (bundle != null) {
            this.mOKClicked = bundle.getBoolean(OK_CLICKED);
        }
        if (this.mOKClicked) {
            return;
        }
        setContentView(R.layout.layout_dialog_confirm);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMSaveInstanceState(Bundle bundle) {
        super.onMAMSaveInstanceState(bundle);
        bundle.putBoolean(OK_CLICKED, this.mOKClicked);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void onBoxInitialize(Bundle bundle) {
        BoxItem itemLocal;
        super.onBoxInitialize(bundle);
        ArrayList<BoxTypeIdPair> parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(EXTRA_ITEMS_TO_DELETE);
        this.mTypedIdsToDelete = parcelableArrayListExtra;
        if (this.mOKClicked) {
            runDelete(parcelableArrayListExtra);
            return;
        }
        Iterator<BoxTypeIdPair> it = parcelableArrayListExtra.iterator();
        do {
            if (!it.hasNext()) {
                itemLocal = null;
                break;
            }
            itemLocal = it.next().getItemLocal(this.mBoxExtendedApiFolder, this.mBoxExtendedApiFile, this.mBookmarkApi);
        } while (itemLocal == null);
        int foldersCount = getFoldersCount(this.mTypedIdsToDelete);
        int size = this.mTypedIdsToDelete.size() - foldersCount;
        int numExternallyCollaborators = getNumExternallyCollaborators(this.mTypedIdsToDelete);
        if (size + foldersCount == 0 || itemLocal == null) {
            broadcastDismissSpinner();
            BoxPresentationUtils.displayToast(R.string.error_item_unavailable, this, new String[0]);
            finish();
        } else {
            String title = getTitle(foldersCount, size, numExternallyCollaborators);
            CharSequence message = getMessage(foldersCount, size, numExternallyCollaborators);
            initializeButtons();
            setMainText(title, message);
        }
    }

    private String getTitle(int i, int i2, int i3) {
        if (i2 + i != 1) {
            return CommonBoxUtil.LS(R.string.LO_Delete);
        }
        if (i3 == 1) {
            return CommonBoxUtil.LS(R.string.Remove);
        }
        if (i == 1) {
            return CommonBoxUtil.LS(R.string.LS_Delete_folder_);
        }
        return CommonBoxUtil.LS(R.string.LS_Delete_file_);
    }

    private CharSequence getMessage(int i, int i2, int i3) {
        int i4 = i + i2;
        if (i3 == 0) {
            if (i2 == 0) {
                return Html.fromHtml(getResources().getQuantityString(R.plurals.numberOfDeleteFolders, i, Integer.valueOf(i)));
            }
            if (i == 0) {
                return Html.fromHtml(getResources().getQuantityString(R.plurals.numberOfDeleteFiles, i2, Integer.valueOf(i2)));
            }
            return getResources().getQuantityString(R.plurals.numberOfDeleteItems, i4, Integer.valueOf(i4));
        }
        if (i3 != i4) {
            return getResources().getQuantityString(R.plurals.numberOfDeleteAndRemoveSelfFromItems, i4, Integer.valueOf(i4));
        }
        if (i2 == 0) {
            return getResources().getQuantityString(R.plurals.numberOfRemoveSelfFromFolders, i, Integer.valueOf(i));
        }
        if (i == 0) {
            return getResources().getQuantityString(R.plurals.numberOfRemoveSelfFromFiles, i2, Integer.valueOf(i2));
        }
        return getResources().getQuantityString(R.plurals.numberOfRemoveSelfFromItems, i4, Integer.valueOf(i4));
    }

    private int getNumExternallyCollaborators(List<BoxTypeIdPair> list) {
        Iterator<BoxTypeIdPair> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (isExternallyCollabed(it.next())) {
                i++;
            }
        }
        return i;
    }

    private int getFoldersCount(List<BoxTypeIdPair> list) {
        Iterator<BoxTypeIdPair> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().getType().equals("folder")) {
                i++;
            }
        }
        return i;
    }

    private boolean isExternallyCollabed(BoxTypeIdPair boxTypeIdPair) {
        BoxItem itemLocal = boxTypeIdPair.getItemLocal(this.mBoxExtendedApiFolder, this.mBoxExtendedApiFile, this.mBookmarkApi);
        return (itemLocal instanceof BoxCollaborationItem) && BoxItemUtility.isSharedWithMe((BoxCollaborationItem) itemLocal, getUserInfo());
    }

    public static Intent newDeleteTaskIntent(Context context, BoxItem boxItem) {
        Intent intent = new Intent(context, (Class<?>) DeleteItemsActivity.class);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BoxTypeIdPair(boxItem.getType(), boxItem.getUserId()));
        intent.putExtra(EXTRA_ITEMS_TO_DELETE, arrayList);
        return intent;
    }

    public static Intent newDeleteTaskIntent(Context context, List<BoxItem> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<BoxItem> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(BoxTypeIdPair.get(it.next()));
        }
        Intent intent = new Intent(context, (Class<?>) DeleteItemsActivity.class);
        intent.putExtra(EXTRA_ITEMS_TO_DELETE, arrayList);
        intent.putExtra(EXTRA_USE_BATCH_MODE, true);
        return intent;
    }

    private void setMainText(String str, CharSequence charSequence) {
        TextView textView = (TextView) findViewById(R.id.dialog_title);
        TextView textView2 = (TextView) findViewById(R.id.dialog_text);
        textView.setText(str);
        if (charSequence.equals("")) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(charSequence);
        }
    }

    private void initializeButtons() {
        ((Button) findViewById(R.id.btnOK)).setText(R.string.LO_Delete);
        findViewById(R.id.btnOK).setOnClickListener(this);
        findViewById(R.id.btnCancel).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnOK) {
            this.mOKClicked = true;
            view.setEnabled(false);
            runDelete(this.mTypedIdsToDelete);
        } else if (id == R.id.btnCancel) {
            setResult(0);
            finish();
        }
    }

    private void runDelete(List<BoxTypeIdPair> list) {
        this.mBatchOperationsMoCo.deleteTypeIdPairs(list, null);
        setResult(-1);
        finish();
    }
}
