package com.box.android.base.presentation.views.menu;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.box.android.base.R;
import com.box.android.base.presentation.fragments.BottomSheetMenuFragment;
import com.box.android.base.presentation.fragments.models.BottomSheetAttributes;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.models.BoxModelOfflineManager;
import com.box.android.coreservices.utilities.CoreServiceUtils;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.utils.SupportedFileExtensions;
import com.box.androidsdk.content.models.BoxCollaborationItem;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.utils.BoxItemUtility;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes9.dex */
public class FolderSheetFragment extends Hilt_FolderSheetFragment {
    private static final String ICON_RES = "Folder.Icon";
    private static final SparseArray<BoxItem.Permission> MENU_ID_TO_PERMISSION;

    @Inject
    protected FeatureFlips mFeatureFlips;
    private BoxFolder mFolder;

    static {
        SparseArray<BoxItem.Permission> sparseArray = new SparseArray<>();
        MENU_ID_TO_PERMISSION = sparseArray;
        sparseArray.put(R.id.menu_upload_new_version, BoxItem.Permission.CAN_UPLOAD);
        sparseArray.put(R.id.menu_delete, BoxItem.Permission.CAN_DELETE);
        sparseArray.put(R.id.menu_rename, BoxItem.Permission.CAN_RENAME);
        sparseArray.put(R.id.menu_copy_or_move, BoxItem.Permission.CAN_DOWNLOAD);
        sparseArray.put(R.id.menu_download, BoxItem.Permission.CAN_DOWNLOAD);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        this.mFolder = (BoxFolder) getArguments().getSerializable(BottomSheetMenuFragment.EXTRA_BOX_ITEM);
        return super.onCreateDialog(bundle);
    }

    @Override // com.box.android.base.presentation.fragments.BottomSheetMenuFragment
    protected boolean isRedesignedStyle() {
        return this.mFeatureFlips.getMainScreenRedesign().getEnabled();
    }

    @Override // com.box.android.base.presentation.fragments.BottomSheetMenuFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog dialog, int i) {
        super.setupDialog(dialog, i);
        View upHeader = setUpHeader();
        ((TextView) upHeader.findViewById(R.id.title)).setText(this.mFolder.getName());
        ((ImageView) upHeader.findViewById(R.id.icon)).setImageResource(getArguments().getInt(ICON_RES));
        this.mRecyclerView.setHasFixedSize(true);
    }

    @Override // com.box.android.base.presentation.fragments.BottomSheetMenuFragment
    protected String getAction() {
        return BottomSheetMenuFragment.EXTRA_ACTION_BOX_ITEM_OVERFLOW_MENU_ITEM_SET;
    }

    @Override // com.box.android.base.presentation.fragments.BottomSheetMenuFragment
    protected List<MenuItem> filterItems(Menu menu) {
        if (!shouldShowCanEditWatermarkItem()) {
            menu.removeItem(R.id.menu_watermarking);
        }
        List<MenuItem> listFilterItems = super.filterItems(menu);
        BoxFolder boxFolder = this.mFolder;
        return filter(listFilterItems, boxFolder, BoxModelOfflineManager.isSpecificallyUserSaved(boxFolder, this.mUserContextManager), this.mUserContextManager);
    }

    private boolean shouldShowCanEditWatermarkItem() {
        BoxUser userInfo = this.mUserContextManager.getUserInfo();
        return this.bottomSheetAttributes.canWatermarkingItemBeShown(this.mFeatureFlips.getCanEditWatermark().getEnabled(), (userInfo == null || userInfo.getEnterprise() == null) ? false : true);
    }

    @Override // com.box.android.base.presentation.fragments.BottomSheetMenuFragment
    protected void broadcastClick(Intent intent) {
        intent.putExtra(BottomSheetMenuFragment.EXTRA_BOX_ITEM, this.mFolder);
        super.broadcastClick(intent);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0079  */
    static List<MenuItem> filter(List<MenuItem> list, BoxItem boxItem, boolean z, IUserContextManager iUserContextManager) {
        ArrayList arrayList = new ArrayList();
        int i = z ? R.id.menu_save_for_offline : R.id.menu_remove_offline;
        EnumSet<BoxItem.Permission> permissions = boxItem.getPermissions();
        if (permissions == null) {
            BoxLogUtils.logException("loading folder without permissions! ", boxItem.getUserId(), new RuntimeException("loading invalid folder"));
            return new ArrayList();
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            MenuItem menuItem = list.get(i2);
            if (i == list.get(i2).getItemId()) {
                arrayList.add(menuItem);
            } else if (menuItem.getItemId() == R.id.menu_download || menuItem.getItemId() == R.id.menu_save_for_offline || menuItem.getItemId() == R.id.menu_upload_new_version) {
                String fileExtension = CommonBoxUtil.getFileExtension(boxItem.getName(), "");
                if (SupportedFileExtensions.INSTANCE.isBoxNoteExtension(fileExtension) || SupportedFileExtensions.INSTANCE.isBoxCanvasExtension(fileExtension)) {
                    arrayList.add(menuItem);
                } else if ((menuItem.getItemId() != R.id.menu_save_for_offline || menuItem.getItemId() == R.id.menu_remove_offline) && !CoreServiceUtils.canOfflineFile(boxItem, iUserContextManager.getUserSharedPrefs())) {
                    arrayList.add(menuItem);
                } else if (menuItem.getItemId() == R.id.menu_leave_folder && (permissions.contains(BoxItem.Permission.CAN_DELETE) || !BoxItemUtility.isSharedWithMe((BoxCollaborationItem) boxItem, iUserContextManager.getUserInfo()))) {
                    arrayList.add(menuItem);
                } else {
                    BoxItem.Permission permission = MENU_ID_TO_PERMISSION.get(menuItem.getItemId());
                    if (permission != null && !permissions.contains(permission)) {
                        arrayList.add(menuItem);
                    }
                }
            } else if (menuItem.getItemId() != R.id.menu_save_for_offline) {
                arrayList.add(menuItem);
            } else {
                arrayList.add(menuItem);
            }
        }
        list.removeAll(arrayList);
        return list;
    }

    public static FolderSheetFragment newInstance(Activity activity, BoxFolder boxFolder, BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType, BottomSheetAttributes.LaunchContext launchContext, boolean z) {
        int i;
        if (z) {
            i = R.menu.folder_redesigned;
        } else {
            i = R.menu.folder;
        }
        Bundle bundle = getBundle(activity, i, true);
        bundle.putSerializable(BottomSheetMenuFragment.EXTRA_BOX_ITEM, BoxItemUtility.copyFolderWithNoItems(boxFolder));
        bundle.putSerializable(BottomSheetMenuFragment.EXTRA_BOTTOM_SHEET_MENU_TYPE, bottomSheetMenuType);
        bundle.putSerializable(BottomSheetMenuFragment.EXTRA_LAUNCH_CONTEXT, launchContext);
        if (boxFolder.getHasCollaborations() != null && boxFolder.getHasCollaborations().booleanValue()) {
            if (boxFolder.getIsExternallyOwned().booleanValue()) {
                bundle.putInt(ICON_RES, R.drawable.ic_folder_external);
            } else {
                bundle.putInt(ICON_RES, R.drawable.ic_folder_shared);
            }
        } else {
            bundle.putInt(ICON_RES, R.drawable.ic_folder_personal);
        }
        FolderSheetFragment folderSheetFragment = new FolderSheetFragment();
        folderSheetFragment.setArguments(bundle);
        return folderSheetFragment;
    }

    @Override // com.box.android.base.presentation.fragments.BottomSheetMenuFragment
    public String getAmplitudePageName() {
        return BoxAnalyticsParams.PAGE_NAME_MORE_OPTIONS_FOLDER;
    }
}
