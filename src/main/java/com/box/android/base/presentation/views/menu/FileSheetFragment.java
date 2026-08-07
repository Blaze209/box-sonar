package com.box.android.base.presentation.views.menu;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.box.android.base.R;
import com.box.android.base.models.BottomSheetMenuItem;
import com.box.android.base.presentation.ThumbnailManager;
import com.box.android.base.presentation.fragments.BottomSheetMenuFragment;
import com.box.android.base.presentation.fragments.models.BottomSheetAttributes;
import com.box.android.coreservices.models.BoxModelOfflineManager;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.mappers.FileModelMapper;
import com.box.android.domain.models.boxai.AiItemAvailabilityStatus;
import com.box.android.domain.models.item.FileModelKt;
import com.box.android.domain.usecases.boxai.GetBoxAiAvailabilityUseCase;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.utils.BoxItemUtility;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes9.dex */
public class FileSheetFragment extends Hilt_FileSheetFragment {
    private static final String EXTRA_BOTTOM_SHEET_AVAILABLE_ACTIONS = "extraBottomSheetMenuAvailableActions";
    private List<Integer> availableActions = Collections.emptyList();
    private BoxFile mBoxFile;

    @Inject
    protected FeatureFlips mFeatureFlips;

    @Inject
    protected GetBoxAiAvailabilityUseCase mGetBoxAiAvailabilityUseCase;

    @Inject
    protected ThumbnailManager mThumbnailManager;

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        this.mBoxFile = (BoxFile) getArguments().getSerializable(BottomSheetMenuFragment.EXTRA_BOX_ITEM);
        if (getArguments().containsKey(EXTRA_BOTTOM_SHEET_AVAILABLE_ACTIONS)) {
            this.availableActions = getArguments().getIntegerArrayList(EXTRA_BOTTOM_SHEET_AVAILABLE_ACTIONS);
        }
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
        ((TextView) upHeader.findViewById(R.id.title)).setText(this.mBoxFile.getName());
        this.mThumbnailManager.loadThumbnail(this.mBoxFile, (ImageView) upHeader.findViewById(R.id.icon));
        this.mRecyclerView.setHasFixedSize(true);
        if (shouldShowBoxAiItem()) {
            updateMenuItemState(R.id.menu_box_ai, BottomSheetMenuItem.State.LOADING);
            this.mGetBoxAiAvailabilityUseCase.getAiAvailabilityForItemWithCallback(this.mBoxFile, false, getLifecycle(), new Function1() { // from class: com.box.android.base.presentation.views.menu.FileSheetFragment$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return this.f$0.lambda$setupDialog$0((AiItemAvailabilityStatus) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setupDialog$0(AiItemAvailabilityStatus aiItemAvailabilityStatus) {
        BottomSheetMenuItem.State state;
        if (aiItemAvailabilityStatus instanceof AiItemAvailabilityStatus.Available) {
            state = BottomSheetMenuItem.State.ENABLED;
        } else {
            state = BottomSheetMenuItem.State.DISABLED;
        }
        updateMenuItemState(R.id.menu_box_ai, state);
        return Unit.INSTANCE;
    }

    @Override // com.box.android.base.presentation.fragments.BottomSheetMenuFragment
    protected String getAction() {
        return BottomSheetMenuFragment.EXTRA_ACTION_BOX_ITEM_OVERFLOW_MENU_ITEM_SET;
    }

    @Override // com.box.android.base.presentation.fragments.BottomSheetMenuFragment
    protected void broadcastClick(Intent intent) {
        intent.putExtra(BottomSheetMenuFragment.EXTRA_BOX_ITEM, this.mBoxFile);
        super.broadcastClick(intent);
    }

    @Override // com.box.android.base.presentation.fragments.BottomSheetMenuFragment
    protected List<MenuItem> filterItems(Menu menu) {
        if (this.mBoxFile.getPermissions().contains(BoxItem.Permission.CAN_DELETE) || !BoxItemUtility.isSharedWithMe(this.mBoxFile, this.mUserContextManager.getUserInfo()) || ((this.mBoxFile.getParent() != null && !this.mBoxFile.getParent().getUserId().equals("0")) || !this.bottomSheetAttributes.canDeleteItemBeShown())) {
            menu.removeItem(R.id.menu_leave_file);
        }
        if (!this.availableActions.contains(Integer.valueOf(R.id.menu_view_containing_folder))) {
            menu.removeItem(R.id.menu_view_containing_folder);
        }
        if (!shouldShowBoxAiItem()) {
            menu.removeItem(R.id.menu_box_ai);
        }
        if (!shouldShowCanEditWatermarkItem()) {
            menu.removeItem(R.id.menu_watermarking);
        }
        if (shouldDisableOfflineForWatermarkedVideo()) {
            menu.removeItem(R.id.menu_save_for_offline);
        }
        List<MenuItem> listFilterItems = super.filterItems(menu);
        BoxFile boxFile = this.mBoxFile;
        return FolderSheetFragment.filter(listFilterItems, boxFile, BoxModelOfflineManager.isSpecificallyUserSaved(boxFile, this.mUserContextManager), this.mUserContextManager);
    }

    private boolean shouldDisableOfflineForWatermarkedVideo() {
        return FileModelKt.isWatermarkedVideo(FileModelMapper.INSTANCE.toFileModel(this.mBoxFile, false));
    }

    private boolean shouldShowBoxAiItem() {
        return this.mFeatureFlips.getBoxAiQuickAction().getEnabled() && this.mGetBoxAiAvailabilityUseCase.isBoxAiEnabled() && this.availableActions.contains(Integer.valueOf(R.id.menu_box_ai));
    }

    private boolean shouldShowCanEditWatermarkItem() {
        BoxUser userInfo = this.mUserContextManager.getUserInfo();
        return this.bottomSheetAttributes.canWatermarkingItemBeShown(this.mFeatureFlips.getCanEditWatermark().getEnabled(), (userInfo == null || userInfo.getEnterprise() == null) ? false : true);
    }

    public static FileSheetFragment newInstance(Activity activity, BoxFile boxFile, BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType, BottomSheetAttributes.LaunchContext launchContext, List<Integer> list, boolean z) {
        int i;
        if (z) {
            i = R.menu.file_redesigned;
        } else {
            i = R.menu.file;
        }
        Bundle bundle = getBundle(activity, i, true);
        bundle.putSerializable(BottomSheetMenuFragment.EXTRA_BOX_ITEM, boxFile);
        bundle.putSerializable(BottomSheetMenuFragment.EXTRA_BOTTOM_SHEET_MENU_TYPE, bottomSheetMenuType);
        bundle.putSerializable(BottomSheetMenuFragment.EXTRA_LAUNCH_CONTEXT, launchContext);
        bundle.putIntegerArrayList(EXTRA_BOTTOM_SHEET_AVAILABLE_ACTIONS, new ArrayList<>(list));
        FileSheetFragment fileSheetFragment = new FileSheetFragment();
        fileSheetFragment.setArguments(bundle);
        return fileSheetFragment;
    }

    @Override // com.box.android.base.presentation.fragments.BottomSheetMenuFragment
    public String getAmplitudePageName() {
        return BoxAnalyticsParams.PAGE_NAME_MORE_OPTIONS_FILE;
    }
}
