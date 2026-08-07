package com.box.android.base.presentation.fragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import androidx.core.content.res.ResourcesCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.box.android.base.R;
import com.box.android.base.analytics.UploadAnalyticsUtils;
import com.box.android.base.models.BottomSheetMenuItem;
import com.box.android.base.presentation.adapters.BottomMenuAdapter;
import com.box.android.base.presentation.fragments.models.BottomSheetAttributes;
import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.coreservices.models.BoxAccountManager;
import com.box.android.coreservices.utilities.CoreServiceUtils;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import com.box.androidsdk.content.models.BoxItem;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.microsoft.intune.mam.client.widget.MAMPopupMenu;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes9.dex */
public abstract class BottomSheetMenuFragment extends BottomSheetDialogFragment {
    public static final String BOTTOM_SHEET_REQUEST_KEY = "BOTTOM_SHEET_REQUEST_KEY";
    public static final String EXTRA_ACTION_BOX_ITEM_OVERFLOW_MENU_ITEM_SET = "actionBoxItemOverflowMenuItemSet";
    public static final String EXTRA_ACTION_BOX_MENU_ITEM_SET = "actionBoxMenuItemSet";
    public static final String EXTRA_BOTTOM_SHEET_MENU_TYPE = "extraBottomSheetMenuType";
    public static final String EXTRA_BOX_ITEM = "extraUpdatedBoxItem";
    public static final String EXTRA_BOX_MENU_ITEM_DIALOG_TYPE = "extraMenuItemDialogType";
    public static final String EXTRA_BOX_MENU_ITEM_ID = "extraMenuItemId";
    public static final String EXTRA_LAUNCH_CONTEXT = "extraLaunchContext";
    private static final String EXTRA_MENU_ID = "menu";
    private static final String OPEN_EXPANDED = "openExpanded";
    public static final String TAG = "BottomSheetMenuFragment.tag";
    private static boolean menuClickHandled = false;
    protected BottomSheetAttributes bottomSheetAttributes = new BottomSheetAttributes(BottomSheetAttributes.BottomSheetMenuType.Default.INSTANCE);
    private BottomSheetBehavior<View> mBottomSheetBehavior;
    private BoxItem mBoxItem;
    protected View mContentView;

    @Inject
    protected FeatureFlips mFeatureFlips;
    private View.OnClickListener mMenuClickListener;
    private DialogInterface.OnShowListener mOnShowListener;
    protected RecyclerView mRecyclerView;

    @Inject
    protected IUserContextManager mUserContextManager;

    protected boolean isRedesignedStyle() {
        return false;
    }

    @Override // androidx.fragment.app.DialogFragment
    public int getTheme() {
        if (isRedesignedStyle()) {
            return R.style.Theme_Box_BottomSheetDialog;
        }
        return super.getTheme();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Dialog dialog;
        super.onStart();
        if (!this.mFeatureFlips.getMainScreenRedesign().getEnabled() || (dialog = getDialog()) == null || dialog.getWindow() == null) {
            return;
        }
        dialog.getWindow().setDimAmount(0.1f);
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog dialog, int i) {
        int i2;
        if (isRedesignedStyle()) {
            i2 = R.layout.main_bottom_sheet_redesigned;
        } else {
            i2 = R.layout.main_bottom_sheet;
        }
        View viewInflate = View.inflate(getContext(), i2, null);
        this.mContentView = viewInflate;
        dialog.setContentView(viewInflate);
        DialogInterface.OnShowListener onShowListener = this.mOnShowListener;
        if (onShowListener != null) {
            dialog.setOnShowListener(onShowListener);
        }
        this.mBottomSheetBehavior = BottomSheetBehavior.from((View) this.mContentView.getParent());
        this.mRecyclerView = (RecyclerView) this.mContentView.findViewById(R.id.recyclerView);
        Bundle arguments = getArguments();
        int i3 = arguments.getInt(EXTRA_MENU_ID);
        arguments.setClassLoader(getClass().getClassLoader());
        BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType = (BottomSheetAttributes.BottomSheetMenuType) arguments.getSerializable(EXTRA_BOTTOM_SHEET_MENU_TYPE);
        BottomSheetAttributes.LaunchContext launchContext = (BottomSheetAttributes.LaunchContext) arguments.getSerializable(EXTRA_LAUNCH_CONTEXT);
        if (bottomSheetMenuType != null && launchContext != null) {
            this.bottomSheetAttributes = new BottomSheetAttributes(bottomSheetMenuType, launchContext);
        } else if (bottomSheetMenuType != null) {
            this.bottomSheetAttributes.setBottomSheetMenuType(bottomSheetMenuType);
        } else if (launchContext != null) {
            this.bottomSheetAttributes.setLaunchContext(launchContext);
        }
        this.mBoxItem = (BoxItem) arguments.getSerializable(EXTRA_BOX_ITEM);
        boolean z = arguments.getBoolean(OPEN_EXPANDED);
        MAMPopupMenu mAMPopupMenu = new MAMPopupMenu(getContext(), null);
        mAMPopupMenu.inflate(i3);
        final List<BottomSheetMenuItem> listConfigureCollectionsMenu = configureCollectionsMenu(mAMPopupMenu);
        this.mMenuClickListener = new View.OnClickListener() { // from class: com.box.android.base.presentation.fragments.BottomSheetMenuFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BottomSheetMenuItem bottomSheetMenuItem;
                int adapterPosition = BottomSheetMenuFragment.this.mRecyclerView.getChildViewHolder(view).getAdapterPosition();
                if (adapterPosition == -1 || (bottomSheetMenuItem = (BottomSheetMenuItem) listConfigureCollectionsMenu.get(adapterPosition)) == null) {
                    return;
                }
                BottomSheetMenuFragment.menuClickHandled = true;
                Intent intent = new Intent();
                intent.setAction(BottomSheetMenuFragment.this.getAction());
                intent.putExtra(BottomSheetMenuFragment.EXTRA_BOX_MENU_ITEM_ID, bottomSheetMenuItem.getId());
                intent.putExtra(BottomSheetMenuFragment.EXTRA_BOX_MENU_ITEM_DIALOG_TYPE, BottomSheetMenuFragment.this.bottomSheetAttributes.getCompletionDialog());
                BottomSheetMenuFragment.this.broadcastClick(intent);
                BottomSheetMenuFragment.this.mBottomSheetBehavior.setState(3);
                BottomSheetMenuFragment.this.onMenuItemClicked(bottomSheetMenuItem);
            }
        };
        this.mRecyclerView.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() { // from class: com.box.android.base.presentation.fragments.BottomSheetMenuFragment.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void onChildViewAttachedToWindow(View view) {
                view.setOnClickListener(BottomSheetMenuFragment.this.mMenuClickListener);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void onChildViewDetachedFromWindow(View view) {
                view.setOnClickListener(null);
            }
        });
        this.mRecyclerView.setAdapter(new BottomMenuAdapter(listConfigureCollectionsMenu, isRedesignedStyle()));
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.mContentView.requestLayout();
        if (z) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.box.android.base.presentation.fragments.BottomSheetMenuFragment.3
                @Override // java.lang.Runnable
                public void run() {
                    BottomSheetMenuFragment.this.mBottomSheetBehavior.setState(3);
                }
            }, 100L);
        }
    }

    protected String getAction() {
        return EXTRA_ACTION_BOX_MENU_ITEM_SET;
    }

    protected SharedPreferences getUserSharedPrefs() {
        return ((ILocalSharedPreferences) this.mUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_SHARED_PREFERENCES)).getSharedPreferences();
    }

    private List<BottomSheetMenuItem> configureCollectionsMenu(PopupMenu popupMenu) {
        Menu menu = popupMenu.getMenu();
        BottomSheetAttributes.BottomSheetMenuType customMenuType = this.bottomSheetAttributes.getMenuType();
        boolean z = customMenuType instanceof BottomSheetAttributes.BottomSheetMenuType.AddRemoveCollectionItems;
        if (z || (customMenuType instanceof BottomSheetAttributes.BottomSheetMenuType.RemoveCollectionItems)) {
            menu.findItem(R.id.menu_collections).setTitle(this.bottomSheetAttributes.getCustomMenuItemTitle(requireContext()));
            if (!this.bottomSheetAttributes.canDeleteItemBeShown()) {
                menu.removeItem(R.id.menu_delete);
            }
            if (CoreServiceUtils.isItemOutsideTree(this.mBoxItem) && z) {
                menu.removeItem(R.id.menu_collections);
            }
        } else {
            menu.removeItem(R.id.menu_collections);
        }
        List<MenuItem> listFilterItems = filterItems(menu);
        ArrayList arrayList = new ArrayList(listFilterItems.size());
        for (int i = 0; i < listFilterItems.size(); i++) {
            arrayList.add(BottomSheetMenuItem.fromMenuItem(listFilterItems.get(i)));
        }
        return arrayList;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (!menuClickHandled) {
            UploadAnalyticsUtils.logUploadFlowCancelCtaEvent(BoxAnalyticsParams.CTA_PAGE_LOCATION_GRAY_AREA);
        }
        if (getActivity() instanceof IBoxFragmentActivity) {
            ((IBoxFragmentActivity) getActivity()).logAnalyticsCurrentPage();
        }
        getParentFragmentManager().setFragmentResult(BOTTOM_SHEET_REQUEST_KEY, new Bundle());
    }

    protected void broadcastClick(Intent intent) {
        LocalBroadcastManager.getInstance(ApplicationProvider.application).sendBroadcast(intent);
    }

    protected List<MenuItem> filterItems(Menu menu) {
        if (!this.bottomSheetAttributes.canDeleteItemBeShown()) {
            menu.removeItem(R.id.menu_leave_folder);
        }
        if (BoxAccountManager.isSaveOnDeviceAdminDisabled(getUserSharedPrefs())) {
            menu.removeItem(R.id.menu_save_for_offline);
            menu.removeItem(R.id.menu_remove_offline);
            menu.removeItem(R.id.menu_download);
        }
        if (!BoxAccountManager.isMobileOpenInEnabled(this.mUserContextManager)) {
            menu.removeItem(R.id.menu_download);
        }
        ArrayList arrayList = new ArrayList(menu.size());
        for (int i = 0; i < menu.size(); i++) {
            arrayList.add(menu.getItem(i));
        }
        return arrayList;
    }

    protected List<BottomSheetMenuItem> getMenuItems() {
        BottomMenuAdapter bottomMenuAdapter = (BottomMenuAdapter) this.mRecyclerView.getAdapter();
        return bottomMenuAdapter == null ? new ArrayList() : bottomMenuAdapter.getData();
    }

    protected void onMenuItemClicked(BottomSheetMenuItem bottomSheetMenuItem) {
        dismissAllowingStateLoss();
    }

    protected void updateMenuItemIcon(int i, int i2) {
        final Drawable drawable = i2 != 0 ? ResourcesCompat.getDrawable(getResources(), i2, null) : null;
        updateMenuItem(i, new Function() { // from class: com.box.android.base.presentation.fragments.BottomSheetMenuFragment$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((BottomSheetMenuItem) obj).withIcon(drawable);
            }
        });
    }

    protected void updateMenuItemState(int i, final BottomSheetMenuItem.State state) {
        updateMenuItem(i, new Function() { // from class: com.box.android.base.presentation.fragments.BottomSheetMenuFragment$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((BottomSheetMenuItem) obj).withState(state);
            }
        });
    }

    private void updateMenuItem(int i, Function<BottomSheetMenuItem, BottomSheetMenuItem> function) {
        BottomMenuAdapter bottomMenuAdapter = (BottomMenuAdapter) this.mRecyclerView.getAdapter();
        if (bottomMenuAdapter == null) {
            return;
        }
        List<BottomSheetMenuItem> data = bottomMenuAdapter.getData();
        for (int i2 = 0; i2 < data.size(); i2++) {
            BottomSheetMenuItem bottomSheetMenuItem = data.get(i2);
            if (bottomSheetMenuItem.getId() == i) {
                data.set(i2, function.apply(bottomSheetMenuItem));
                bottomMenuAdapter.notifyItemChanged(i2);
                return;
            }
        }
    }

    protected void setAdapter(BottomMenuAdapter bottomMenuAdapter) {
        this.mRecyclerView.setAdapter(bottomMenuAdapter);
        this.mContentView.requestLayout();
    }

    protected static Bundle getBundle(Activity activity, int i) {
        return getBundle(activity, i, false);
    }

    protected static Bundle getBundle(Activity activity, int i, boolean z) {
        new MAMPopupMenu(activity, null).inflate(i);
        Bundle bundle = new Bundle();
        bundle.putInt(EXTRA_MENU_ID, i);
        bundle.putBoolean(OPEN_EXPANDED, z);
        return bundle;
    }

    protected View setUpHeader() {
        int i;
        boolean zIsRedesignedStyle = isRedesignedStyle();
        if (zIsRedesignedStyle) {
            i = R.layout.file_folder_menu_header_redesigned;
        } else {
            i = R.layout.file_folder_menu_header;
        }
        View viewInflate = View.inflate(getContext(), i, null);
        ((LinearLayout) this.mContentView).addView(viewInflate, zIsRedesignedStyle ? 1 : 0);
        return viewInflate;
    }

    public String getAmplitudePageName() {
        return String.format(BoxAnalyticsParams.PAGE_NAME_UNKNOWN, getClass().getSimpleName());
    }

    public String getAmplitudeFlow() {
        return BoxAnalyticsParams.FLOW_FILE_NAVIGATION;
    }

    public BottomSheetMenuFragment setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        this.mOnShowListener = onShowListener;
        return this;
    }
}
