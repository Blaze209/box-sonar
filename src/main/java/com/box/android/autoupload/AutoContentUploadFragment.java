package com.box.android.autoupload;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.SwitchCompat;
import com.box.android.R;
import com.box.android.activities.filepicker.LocalFolderChooser;
import com.box.android.adapters.listitems.NavigationBarItem;
import com.box.android.application.BoxBaseApplication;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.browse.cpl.itempicker.ItemPickerActivity;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.common.utilities.IntentConstants;
import com.box.android.coreservices.jobmanager.dao.NameIdPair;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.coreservices.utilities.CoreServiceUtils;
import com.box.android.data.service.impl.LocalItemService;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.fragments.AutoUploadUtils;
import com.box.android.localrepo.LocalAutoContentUploadInformation;
import com.box.android.workers.AutoUploadWorkerDispatcher;
import com.box.androidsdk.content.BoxApiFolder;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes9.dex */
public class AutoContentUploadFragment extends Hilt_AutoContentUploadFragment {
    private static final String DEFAULT_UPLOAD_FOLDER_NAME = CommonBoxUtil.LS(R.string.automatic_upload_default_folder_name);
    private static final String EXTRA_COLLAB_WARNING_CHOSEN_FOLDER = "extraCollabWarningChosenFolder";
    private static final String EXTRA_SHOWING_COLLAB_WARNING = "extraShowingCollabWarning";

    @Inject
    AutoUploadSwitchListener.Factory factory;
    private TextView localFolderToMonitorPath;
    private RelativeLayout mAutoContentUploadContainer;
    private SwitchCompat mAutoUploadMainSwitch;
    private RelativeLayout mAutoUploadMeteredSwitchContainer;

    @Inject
    FeatureFlips mFeatureFlips;

    @Inject
    BoxExtendedApiFolder mFolderApi;

    @Inject
    LocalItemService mLocalItemService;
    private AppCompatCheckBox mMeteredUploadCheckbox;
    private AppCompatCheckBox mNotifyUploadCheckbox;
    private RelativeLayout mNotifyUploadSwitchContainer;
    private View mOptionsWrapper;
    private View mainView;
    private TextView remoteFolderToMonitorPath;
    private boolean mShowingCollabFolderWarning = false;
    private String mLastChosenFolderId = null;
    private AlertDialog mAutoUploadCollabWarningDialog = null;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_auto_content_upload, viewGroup);
        this.mainView = viewInflate;
        this.localFolderToMonitorPath = (TextView) viewInflate.findViewById(R.id.localFolderToMonitorPath);
        this.remoteFolderToMonitorPath = (TextView) this.mainView.findViewById(R.id.remoteFolderToMonitorPath);
        this.mAutoUploadMainSwitch = (SwitchCompat) this.mainView.findViewById(R.id.autoUploadMainSwitch);
        this.mAutoContentUploadContainer = (RelativeLayout) this.mainView.findViewById(R.id.autoContentUploadContainer);
        this.mAutoUploadMeteredSwitchContainer = (RelativeLayout) this.mainView.findViewById(R.id.autoUploadMeteredSwitchContainer);
        this.mMeteredUploadCheckbox = (AppCompatCheckBox) this.mainView.findViewById(R.id.autoUploadMeteredSwitch);
        this.mNotifyUploadSwitchContainer = (RelativeLayout) this.mainView.findViewById(R.id.notifyUploadSwitchContainer);
        this.mNotifyUploadCheckbox = (AppCompatCheckBox) this.mainView.findViewById(R.id.notifyUploadSwitch);
        this.mOptionsWrapper = this.mainView.findViewById(R.id.autoContentUploadOptions);
        if (bundle != null) {
            this.mShowingCollabFolderWarning = bundle.getBoolean(EXTRA_SHOWING_COLLAB_WARNING, false);
            this.mLastChosenFolderId = bundle.getString(EXTRA_COLLAB_WARNING_CHOSEN_FOLDER);
        }
        return this.mainView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mainView.findViewById(R.id.localFolderToMonitorPathContainer).setOnClickListener(new View.OnClickListener() { // from class: com.box.android.autoupload.AutoContentUploadFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AutoContentUploadFragment.this.startActivityForResult(LocalFolderChooser.INSTANCE.newLocalFolderChooserIntent(AutoContentUploadFragment.this.mainView.getContext(), AutoContentUploadFragment.this.getLocalAutoContentUploadInformation().getUploadFolder(), AutoContentUploadFragment.this.getString(R.string.pick_source)), BoxCommonConstants.REQUEST_CHOOSE_LOCAL_UPLOAD_DIR);
            }
        });
        this.mainView.findViewById(R.id.remoteFolderToMonitorPathContainer).setOnClickListener(new View.OnClickListener() { // from class: com.box.android.autoupload.AutoContentUploadFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AutoContentUploadFragment.this.startActivityForResult(ItemPickerActivity.getLaunchIntent(AutoContentUploadFragment.this.requireContext(), "0", true, false, AutoContentUploadFragment.this.requireContext().getString(R.string.pick_destination)), BoxCommonConstants.REQUEST_CHOOSE_REMOTE_UPLOAD_DIR);
            }
        });
        this.mAutoContentUploadContainer.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.autoupload.AutoContentUploadFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AutoContentUploadFragment.this.mAutoUploadMainSwitch.setChecked(!AutoContentUploadFragment.this.mAutoUploadMainSwitch.isChecked());
            }
        });
        this.mAutoUploadMainSwitch.setChecked(AutoUploadUtils.isSyncEnabled(this.mUserContextManager));
        this.mAutoUploadMainSwitch.setOnCheckedChangeListener(this.factory.createListener(requireActivity(), new Function1() { // from class: com.box.android.autoupload.AutoContentUploadFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$onResume$0((Boolean) obj);
            }
        }, new Function0() { // from class: com.box.android.autoupload.AutoContentUploadFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onResume$1();
            }
        }));
        this.mAutoUploadMeteredSwitchContainer.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.autoupload.AutoContentUploadFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AutoContentUploadFragment.this.mMeteredUploadCheckbox.setChecked(!AutoContentUploadFragment.this.mMeteredUploadCheckbox.isChecked());
            }
        });
        this.mMeteredUploadCheckbox.setChecked(!getLocalAutoContentUploadInformation().shouldUploadOverWifiOnly());
        this.mMeteredUploadCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.box.android.autoupload.AutoContentUploadFragment.5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AutoContentUploadFragment.this.getLocalAutoContentUploadInformation().setShouldUploadOverWifiOnly(!z);
            }
        });
        this.mNotifyUploadSwitchContainer.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.autoupload.AutoContentUploadFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AutoContentUploadFragment.this.mNotifyUploadCheckbox.setChecked(!AutoContentUploadFragment.this.mNotifyUploadCheckbox.isChecked());
            }
        });
        this.mNotifyUploadCheckbox.setChecked(getLocalAutoContentUploadInformation().isShouldNotify());
        this.mNotifyUploadCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.box.android.autoupload.AutoContentUploadFragment.7
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AutoContentUploadFragment.this.getLocalAutoContentUploadInformation().setShouldNotifyWhenUploading(z);
            }
        });
        this.mOptionsWrapper.setVisibility(this.mAutoUploadMainSwitch.isChecked() ? 0 : 8);
        if (this.mShowingCollabFolderWarning && StringUtils.isNotBlank(this.mLastChosenFolderId)) {
            showAutoUploadCollabWarning(this.mLastChosenFolderId);
        }
        refreshFolderChoices();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onResume$0(Boolean bool) {
        onAutoUploadStatusChanged(bool.booleanValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onResume$1() {
        resetSwitchState();
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        AutoUploadWorkerDispatcher.INSTANCE.setupAutoUpload((LocalAutoContentUploadInformation) this.mUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_AUTO_CONTENT_UPLOAD_INFORMATION), this.mLocalItemService);
        super.onDetach();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LocalAutoContentUploadInformation getLocalAutoContentUploadInformation() {
        return (LocalAutoContentUploadInformation) this.mUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_AUTO_CONTENT_UPLOAD_INFORMATION);
    }

    private void setSyncAutomatically(boolean z, final IUserContextManager iUserContextManager, final IBaseModelController iBaseModelController, final BoxExtendedApiFolder boxExtendedApiFolder) {
        if (z) {
            new Thread() { // from class: com.box.android.autoupload.AutoContentUploadFragment.8
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    AutoContentUploadFragment.this.showSpinner();
                    if (AutoContentUploadFragment.this.setupAutoContentFirstTime(iUserContextManager, iBaseModelController, boxExtendedApiFolder)) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.box.android.autoupload.AutoContentUploadFragment.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Toast.makeText(BoxBaseApplication.getInstance(), CommonBoxUtil.LS(R.string.Only_new_files_will_be_uploaded), 1).show();
                                AutoContentUploadFragment.this.showAutoUploadCollabWarning(AutoContentUploadFragment.this.getLocalAutoContentUploadInformation().getUploadFolderId());
                                AutoContentUploadFragment.this.refreshFolderChoices();
                            }
                        });
                    } else if (AutoContentUploadFragment.this.getActivity() != null) {
                        AutoContentUploadFragment autoContentUploadFragment = AutoContentUploadFragment.this;
                        if (autoContentUploadFragment.canUploadToAllFiles(autoContentUploadFragment.mBaseModelController, AutoContentUploadFragment.this.mFolderApi)) {
                            AutoContentUploadFragment.this.getLocalAutoContentUploadInformation().setUploadFolderId("0");
                            AutoContentUploadFragment.this.getActivity().runOnUiThread(new Runnable() { // from class: com.box.android.autoupload.AutoContentUploadFragment.8.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    AutoContentUploadFragment.this.refreshFolderChoices();
                                }
                            });
                        }
                    }
                    AutoContentUploadFragment.this.broadcastDismissSpinner();
                }
            }.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean setupAutoContentFirstTime(IUserContextManager iUserContextManager, IBaseModelController iBaseModelController, BoxExtendedApiFolder boxExtendedApiFolder) {
        if (StringUtils.isEmpty(((LocalAutoContentUploadInformation) iUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_AUTO_CONTENT_UPLOAD_INFORMATION)).getUploadFolder())) {
            ((LocalAutoContentUploadInformation) iUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_AUTO_CONTENT_UPLOAD_INFORMATION)).setUploadFolder(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath());
        }
        if (((LocalAutoContentUploadInformation) iUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_AUTO_CONTENT_UPLOAD_INFORMATION)).getUploadFolderId() == null && !findAndSetDefaultFolder(iUserContextManager, iBaseModelController, boxExtendedApiFolder)) {
            try {
                BoxResponse boxResponse = iBaseModelController.performRemote(this.mFolderApi.getCreateRequest("0", DEFAULT_UPLOAD_FOLDER_NAME)).get();
                if (boxResponse.isSuccess()) {
                    ((LocalAutoContentUploadInformation) iUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_AUTO_CONTENT_UPLOAD_INFORMATION)).setUploadFolderId(((BoxFolder) boxResponse.getResult()).getUserId());
                } else {
                    if (boxResponse.getException() instanceof BoxException) {
                        int iIntValue = ((BoxException) boxResponse.getException()).getAsBoxError().getStatus().intValue();
                        if (iIntValue == 403) {
                            BoxPresentationUtils.displayToast(R.string.auto_upload_not_sufficient_permissions, getActivity(), new String[0]);
                            return false;
                        }
                        if (iIntValue == 409) {
                            iBaseModelController.performRemote(this.mFolderApi.getInfoRequest("0")).get();
                        }
                    }
                    if (!findAndSetDefaultFolder(iUserContextManager, this.mBaseModelController, this.mFolderApi)) {
                        ((LocalAutoContentUploadInformation) iUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_AUTO_CONTENT_UPLOAD_INFORMATION)).setUploadFolderId("0");
                    }
                }
            } catch (Exception e) {
                if (e instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                BoxPresentationUtils.displayToast(BoxPresentationUtils.localize(R.string.folder_create_error_generic, getActivity(), new Object[0]), BoxBaseApplication.getInstance().getApplicationContext());
            }
        }
        return (StringUtils.isEmpty(((LocalAutoContentUploadInformation) iUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_AUTO_CONTENT_UPLOAD_INFORMATION)).getUploadFolder()) || ((LocalAutoContentUploadInformation) iUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_AUTO_CONTENT_UPLOAD_INFORMATION)).getUploadFolderId() == null) ? false : true;
    }

    private void updateCollabWarningText() {
        try {
            if (!((BoxFolder) this.mBaseModelController.performLocal(this.mFolderApi.getInfoRequest(getLocalAutoContentUploadInformation().getUploadFolderId()), null).get().getResult()).getHasCollaborations().booleanValue()) {
                this.mainView.findViewById(R.id.collabFolderWarning).setVisibility(8);
            } else {
                this.mainView.findViewById(R.id.collabFolderWarning).setVisibility(0);
            }
        } catch (Exception e) {
            BoxLogUtils.logException(e);
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canUploadToAllFiles(IBaseModelController iBaseModelController, BoxExtendedApiFolder boxExtendedApiFolder) {
        BoxFolder boxFolder = null;
        try {
            boxFolder = (BoxFolder) iBaseModelController.performLocal(boxExtendedApiFolder.getInfoRequest("0"), null).get().getResult();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            BoxLogUtils.logException(e);
        } catch (ExecutionException e2) {
            BoxLogUtils.logException(e2);
        }
        if (boxFolder == null || boxFolder.getPermissions() == null) {
            try {
                BoxResponse boxResponse = iBaseModelController.performRemote(boxExtendedApiFolder.getInfoRequest("0")).get();
                if (boxResponse.isSuccess()) {
                    boxFolder = (BoxFolder) boxResponse.getResult();
                }
            } catch (InterruptedException e3) {
                Thread.currentThread().interrupt();
                BoxLogUtils.logException(e3);
            } catch (ExecutionException e4) {
                BoxLogUtils.logException(e4);
            }
        }
        return (boxFolder == null || boxFolder.getPermissions() == null || !boxFolder.getPermissions().contains(BoxItem.Permission.CAN_UPLOAD)) ? false : true;
    }

    private boolean findAndSetDefaultFolder(IUserContextManager iUserContextManager, IBaseModelController iBaseModelController, BoxApiFolder boxApiFolder) {
        try {
            for (BoxItem boxItem : ((BoxFolder) iBaseModelController.performLocal(boxApiFolder.getInfoRequest("0"), null).get().getResult()).getItemCollection()) {
                if (boxItem.getName().equals(DEFAULT_UPLOAD_FOLDER_NAME) && (boxItem instanceof BoxFolder) && ((BoxFolder) boxItem).getOwnedBy().getUserId().equals(getUserInfo().getUserId())) {
                    ((LocalAutoContentUploadInformation) iUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_AUTO_CONTENT_UPLOAD_INFORMATION)).setUploadFolderId(boxItem.getUserId());
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            BoxLogUtils.logException(e);
            return false;
        }
    }

    private void onAutoUploadStatusChanged(boolean z) {
        setSyncAutomatically(z, this.mUserContextManager, this.mBaseModelController, this.mFolderApi);
        getLocalAutoContentUploadInformation().setSyncEnabled(z);
        this.mOptionsWrapper.setVisibility(z ? 0 : 8);
        this.mAutoUploadMainSwitch.setChecked(z);
    }

    private void resetSwitchState() {
        this.mAutoUploadMainSwitch.setChecked(AutoUploadUtils.isSyncEnabled(this.mUserContextManager));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAutoUploadCollabWarning(final String str) {
        AlertDialog alertDialog = this.mAutoUploadCollabWarningDialog;
        if (alertDialog == null || !alertDialog.isShowing()) {
            try {
                if (((BoxFolder) this.mBaseModelController.performLocal(this.mFolderApi.getInfoRequest(str), null).get().getResult()).getHasCollaborations().booleanValue()) {
                    MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(getActivity());
                    View viewInflate = getLayoutInflater().inflate(R.layout.alert_dialog_auto_upload_collab_folder, (ViewGroup) null);
                    final CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.notify_auto_content_upload_check_box);
                    materialAlertDialogBuilder.setView(viewInflate);
                    materialAlertDialogBuilder.setPositiveButton((CharSequence) CommonBoxUtil.LS(R.string.button_ok), new DialogInterface.OnClickListener() { // from class: com.box.android.autoupload.AutoContentUploadFragment.9
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            AutoContentUploadFragment.this.getLocalAutoContentUploadInformation().setUploadFolderId(str);
                            AutoContentUploadFragment.this.mNotifyUploadCheckbox.setChecked(checkBox.isChecked());
                            AutoContentUploadFragment.this.refreshFolderChoices();
                            AutoContentUploadFragment.this.mShowingCollabFolderWarning = false;
                            AutoContentUploadFragment.this.mLastChosenFolderId = null;
                        }
                    });
                    materialAlertDialogBuilder.setNegativeButton((CharSequence) CommonBoxUtil.LS(R.string.button_cancel), new DialogInterface.OnClickListener() { // from class: com.box.android.autoupload.AutoContentUploadFragment.10
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            AutoContentUploadFragment.this.mNotifyUploadCheckbox.setChecked(checkBox.isChecked());
                            if (str.equals(AutoContentUploadFragment.this.getLocalAutoContentUploadInformation().getUploadFolderId())) {
                                AutoContentUploadFragment.this.getLocalAutoContentUploadInformation().setUploadFolderId("0");
                            }
                            AutoContentUploadFragment.this.refreshFolderChoices();
                            AutoContentUploadFragment.this.mShowingCollabFolderWarning = false;
                            AutoContentUploadFragment.this.mLastChosenFolderId = null;
                        }
                    });
                    this.mShowingCollabFolderWarning = true;
                    this.mLastChosenFolderId = str;
                    AlertDialog alertDialogCreate = materialAlertDialogBuilder.create();
                    this.mAutoUploadCollabWarningDialog = alertDialogCreate;
                    alertDialogCreate.show();
                }
            } catch (Exception e) {
                if (e instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                BoxLogUtils.logException(e);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(EXTRA_SHOWING_COLLAB_WARNING, this.mShowingCollabFolderWarning);
        bundle.putString(EXTRA_COLLAB_WARNING_CHOSEN_FOLDER, this.mLastChosenFolderId);
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 295 && i2 == -1) {
            getLocalAutoContentUploadInformation().setUploadFolder(intent.getStringExtra(IntentConstants.LocalFolderChooser.EXTRA_SELECTED_DIR));
            refreshFolderChoices();
            getLocalAutoContentUploadInformation().setSyncEnabled(true);
            setSyncAutomatically(true, this.mUserContextManager, this.mBaseModelController, this.mFolderApi);
        } else if (i == 306 && i2 == -1) {
            getLocalAutoContentUploadInformation().setUploadFolder(CommonBoxUtil.getDirectoryFromDocProviderResult(getContext(), intent));
            refreshFolderChoices();
            getLocalAutoContentUploadInformation().setSyncEnabled(true);
            setSyncAutomatically(true, this.mUserContextManager, this.mBaseModelController, this.mFolderApi);
        } else if (i == 296 && i2 == -1) {
            intent.setExtrasClassLoader(getClass().getClassLoader());
            checkAndSetFolder(((BoxFolder) intent.getSerializableExtra(ItemPickerActivity.EXTRA_FOLDER)).getUserId());
            getLocalAutoContentUploadInformation().setSyncEnabled(true);
            setSyncAutomatically(true, this.mUserContextManager, this.mBaseModelController, this.mFolderApi);
        }
        super.onActivityResult(i, i2, intent);
    }

    private void checkAndSetFolder(final String str) {
        if (str == null) {
            return;
        }
        new Thread(new Runnable() { // from class: com.box.android.autoupload.AutoContentUploadFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkAndSetFolder$3(str);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkAndSetFolder$3(String str) {
        final BoxFolder boxFolder = null;
        try {
            boxFolder = (BoxFolder) this.mBaseModelController.performLocal(this.mFolderApi.getInfoRequest(str), null).get().getResult();
        } catch (Exception e) {
            BoxLogUtils.logException(e);
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
        }
        if (boxFolder == null || boxFolder.getPermissions() == null) {
            try {
                try {
                    showSpinner();
                    boxFolder = (BoxFolder) this.mBaseModelController.performRemote(this.mFolderApi.getInfoRequest(str)).get().getResult();
                    broadcastDismissSpinner();
                } catch (Exception e2) {
                    if (e2 instanceof InterruptedException) {
                        Thread.currentThread().interrupt();
                    }
                    BoxPresentationUtils.displayToast(R.string.Unable_to_select_destination_folder, getActivity(), new String[0]);
                    broadcastDismissSpinner();
                    return;
                }
            } catch (Throwable th) {
                broadcastDismissSpinner();
                throw th;
            }
        }
        if (!boxFolder.getPermissions().contains(BoxItem.Permission.CAN_UPLOAD)) {
            BoxPresentationUtils.displayToast(R.string.Write_Permission_Denied, getActivity(), new String[0]);
        } else if (getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() { // from class: com.box.android.autoupload.AutoContentUploadFragment$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$checkAndSetFolder$2(boxFolder);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkAndSetFolder$2(BoxFolder boxFolder) {
        if (boxFolder.getHasCollaborations().booleanValue()) {
            showAutoUploadCollabWarning(boxFolder.getUserId());
        } else {
            getLocalAutoContentUploadInformation().setUploadFolderId(boxFolder.getUserId());
        }
        refreshFolderChoices();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshFolderChoices() {
        String uploadFolder = getLocalAutoContentUploadInformation().getUploadFolder();
        if (!StringUtils.isEmpty(uploadFolder)) {
            this.localFolderToMonitorPath.setText(uploadFolder);
        }
        String uploadFolderId = getLocalAutoContentUploadInformation().getUploadFolderId();
        if (uploadFolderId != null) {
            this.remoteFolderToMonitorPath.setText(getPathString(uploadFolderId));
        }
        updateCollabWarningText();
    }

    private String getPathString(String str) {
        List<NavigationBarItem> listCalculateNavigationItems = calculateNavigationItems(str);
        Collections.reverse(listCalculateNavigationItems);
        StringBuilder sb = new StringBuilder();
        Iterator<NavigationBarItem> it = listCalculateNavigationItems.iterator();
        while (it.hasNext()) {
            sb.append(it.next().getName());
            sb.append(File.separator);
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    public List<NavigationBarItem> calculateNavigationItems(String str) {
        BoxItem boxItem;
        int i;
        String str2 = "0";
        ArrayList<NameIdPair> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String strLS = CommonBoxUtil.LS(R.string.files);
        int i2 = -1;
        try {
            if ("0".equals(str)) {
                boxItem = null;
                i = -1;
            } else {
                boxItem = (BoxItem) this.mBaseModelController.performLocal(this.mFolderApi.getInfoRequest(str)).get().getResult();
                i = 2;
            }
            if (boxItem != null) {
                arrayList2.add(new NavigationBarItem(i, boxItem.getUserId(), boxItem.getName()));
                try {
                    strLS = CommonBoxUtil.LS(R.string.files);
                    i2 = 3;
                    arrayList.addAll(CoreServiceUtils.getLineage(this.mUserContextManager, boxItem.getUserId(), boxItem.getType()));
                } catch (Exception e) {
                    e = e;
                    if (e instanceof InterruptedException) {
                        Thread.currentThread().interrupt();
                    }
                    BoxLogUtils.logException(e);
                }
            } else {
                str2 = null;
            }
        } catch (Exception e2) {
            e = e2;
            str2 = null;
        }
        boolean z = false;
        for (NameIdPair nameIdPair : arrayList) {
            arrayList2.add(new NavigationBarItem(2, nameIdPair.getId(), nameIdPair.getName()));
            if (nameIdPair.getId().equals(str2)) {
                z = true;
            }
        }
        if (!z && !str.equals(str2)) {
            arrayList2.add(new NavigationBarItem(i2, str2, strLS));
        }
        return arrayList2;
    }
}
