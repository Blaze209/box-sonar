package com.box.android.activities.settings;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.biometric.BiometricManager;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import com.box.android.R;
import com.box.android.activities.LogoutWarningActivity;
import com.box.android.activities.SwitchAccountActivity;
import com.box.android.application.BoxBaseApplication;
import com.box.android.base.FeatureFlipsToggleFragment;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.base.presentation.activities.CreatePincodeActivity;
import com.box.android.base.presentation.activities.Pincode;
import com.box.android.base.presentation.utilities.EdgeToEdgeUtils;
import com.box.android.base.vm.BiometricsVM;
import com.box.android.capture.fragments.CaptureSettingsFragment;
import com.box.android.common.BuildConfig;
import com.box.android.common.utilities.BuildConfigProvider;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.common.utilities.FileSizeUtils;
import com.box.android.coreservices.jobmanager.JobManager;
import com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection;
import com.box.android.coreservices.jobmanager.jobcollections.ExportBoxJobCollection;
import com.box.android.coreservices.jobmanager.jobcollections.OfflineBoxJobCollection;
import com.box.android.coreservices.jobmanager.jobs.BoxJob;
import com.box.android.coreservices.jobmanager.tasks.BoxTask;
import com.box.android.coreservices.models.BoxModelOfflineManager;
import com.box.android.coreservices.utilities.CoreServiceUtils;
import com.box.android.data.jobs.JobService;
import com.box.android.domain.analytics.BoxAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.configuration.BoxConfigConstants;
import com.box.android.domain.configuration.ISplitConfiguration;
import com.box.android.domain.configuration.SplitConfiguration;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.usecases.observability.CreateLogArchiveInteractor;
import com.box.android.domain.utils.result.Result;
import com.box.android.observability.ObservabilitySettingsManager;
import com.box.android.observability.UploadLogsWorker;
import com.box.android.utilities.BoxUtils;
import com.box.android.utilities.notificationmanager.BoxNotificationHelper;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

/* JADX INFO: loaded from: classes9.dex */
public class SettingsActivity extends Hilt_SettingsActivity {
    private static final int CREATE_PASSCODE = 10;
    private static final int DISABLE_PASSCODE = 100;
    public static final String FILES_AND_FOLDERS_FRAGMENT = "FilesAndFoldersSettingsFragment";
    public static final String FRAGMENT_TO_LOAD_KEY = "FRAGMENT_TO_LOAD_KEY";
    private static final double INFINITE_STORAGE_AMOUNT = 1.0E15d;
    private static final long[] sDurationsInMilliseconds = {TimeUnit.MINUTES.toMillis(1), TimeUnit.MINUTES.toMillis(2), TimeUnit.MINUTES.toMillis(5), TimeUnit.MINUTES.toMillis(15), TimeUnit.HOURS.toMillis(1)};

    @Inject
    protected CreateLogArchiveInteractor createLogArchiveInteractor;

    @Inject
    protected FilesAndFoldersFragmentFactory filesAndFoldersFragmentFactory;

    @Inject
    protected JobManager mJobManager;

    @Inject
    protected JobService mJobService;
    private Toolbar mToolbar;
    private View mainOptionsRootView;
    private View mainOptionsView;

    @Inject
    @Named("global-shared-preference")
    protected SharedPreferences sharedPreferences;

    @Inject
    protected ISplitConfiguration splitConfiguration;
    private final int[] optionsIdArray = {R.id.btnSwitchAccounts, R.id.btnLogout, R.id.requirePasscodeContainer, R.id.changePassCode, R.id.changePassCodeTimeout, R.id.btnClearDownloads, R.id.btnHelpCenter, R.id.btnPrivacyPolicy, R.id.btnTermsOfService, R.id.btnUploadLogs, R.id.allowBiometricsContainer};
    private Map<String, Integer> featureToViewMapping = new HashMap();
    private Map<String, String> splitEnvOverrides = new HashMap();

    @Override // com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, androidx.activity.ComponentActivity, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public /* bridge */ /* synthetic */ ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return super.getDefaultViewModelProviderFactory();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return Integer.valueOf(R.layout.settings_activity);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void onBoxCreate(Bundle bundle) {
        super.onBoxCreate(bundle);
        getSupportFragmentManager().setFragmentFactory(this.filesAndFoldersFragmentFactory);
        this.mainOptionsRootView = findViewById(R.id.mainSettingsLayout);
        this.mainOptionsView = findViewById(R.id.option_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.settingsToolbar);
        this.mToolbar = toolbar;
        toolbar.setNavigationIcon(2131231143);
        this.mToolbar.setTitle(R.string.account_settings);
        setupChildFragmentsAccessibility();
        setSupportActionBar(this.mToolbar);
        setupEdgeToEdge();
        hideDisabledItems(this.mainOptionsView);
        updateFragment();
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) { // from class: com.box.android.activities.settings.SettingsActivity.1
            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                SettingsActivity.this.finish();
            }
        });
        initSplitEnvOverrides();
        if (FILES_AND_FOLDERS_FRAGMENT.equals(getIntent().getStringExtra(FRAGMENT_TO_LOAD_KEY))) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean(FilesAndFoldersSettingsFragmentKt.SHOULD_FINISH_PARENT_ACTIVITY_KEY, true);
            getSupportFragmentManager().beginTransaction().replace(R.id.settings_fragment_container, FilesAndFoldersSettingsFragment.class, bundle2).addToBackStack(null).commit();
        }
    }

    private void setupChildFragmentsAccessibility() {
        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() { // from class: com.box.android.activities.settings.SettingsActivity$$ExternalSyntheticLambda10
            @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
            public final void onBackStackChanged() {
                this.f$0.lambda$setupChildFragmentsAccessibility$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupChildFragmentsAccessibility$0() {
        if (getSupportFragmentManager().findFragmentById(R.id.settings_fragment_container) != null) {
            this.mainOptionsRootView.setImportantForAccessibility(4);
        } else {
            this.mainOptionsRootView.setImportantForAccessibility(1);
        }
    }

    private void initSplitEnvOverrides() {
        this.splitEnvOverrides.put("prod", BuildConfig.CONFIG_SPLIT_API_KEY);
        this.splitEnvOverrides.put("staging", BuildConfig.CONFIG_SPLIT_STAGING_API_KEY);
        this.splitEnvOverrides.put("dev", BuildConfig.CONFIG_SPLIT_DEV_API_KEY);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            getOnBackPressedDispatcher().onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX WARN: Type inference failed for: r0v14, types: [com.box.android.activities.settings.SettingsActivity$2] */
    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    public void handleOnActivityResult(int i, int i2, Intent intent) {
        if (i == 297) {
            if (i2 == -1) {
                clearOfflinedFilesFolders(findViewById(R.id.btnClearDownloads));
                new Thread() { // from class: com.box.android.activities.settings.SettingsActivity.2
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        BoxBaseApplication.getInstance().getJobManager().filter(new JobManager.JobManagerFilter() { // from class: com.box.android.activities.settings.SettingsActivity.2.1
                            @Override // com.box.android.coreservices.jobmanager.JobManager.JobManagerFilter
                            public boolean accept(BoxJob boxJob) {
                                return false;
                            }

                            @Override // com.box.android.coreservices.jobmanager.JobManager.JobManagerFilter
                            public boolean accept(BoxTask boxTask) {
                                return false;
                            }

                            @Override // com.box.android.coreservices.jobmanager.JobManager.JobManagerFilter
                            public boolean accept(BoxJobCollection boxJobCollection) {
                                if (!(boxJobCollection instanceof OfflineBoxJobCollection) && !(boxJobCollection instanceof ExportBoxJobCollection)) {
                                    return false;
                                }
                                boxJobCollection.cancel();
                                return false;
                            }
                        });
                    }
                }.start();
            }
        } else if (i == 10) {
            ((SwitchCompat) findViewById(R.id.requirePasscodeSwitch)).setChecked(CreatePincodeActivity.userHasSetPincode(this.mUserContextManager));
            setPasscodeDurationIntervalIntoView(this.mainOptionsView);
        } else if (i == 100 && i2 == 0) {
            ((SwitchCompat) findViewById(R.id.requirePasscodeSwitch)).setChecked(true);
        } else if (i == 301 && i2 == 100) {
            BoxNotificationHelper.displayDialog(R.string.Feature_disabled, R.string.intune_not_supported_multi_user);
        } else if (i == 204) {
            permissionsMessageHelper(Environment.isExternalStorageManager());
        }
        super.handleOnActivityResult(i, i2, intent);
    }

    private void permissionsMessageHelper(boolean z) {
        if (z) {
            BoxPresentationUtils.displaySnack(this.mainOptionsView, R.string.Please_retry_operation_after_grant_permission, 0, null, 0);
        } else {
            BoxPresentationUtils.displaySnack(this.mainOptionsView, R.string.Please_grant_permission_in_order_to_perform_this_operation, 0, null, 0);
        }
    }

    private void showDurationChooser() {
        String[] strArr = new String[sDurationsInMilliseconds.length];
        long pincodeIgnoreDuration = Pincode.getPincodeIgnoreDuration(this.mUserContextManager);
        int i = 0;
        int i2 = 0;
        while (true) {
            long[] jArr = sDurationsInMilliseconds;
            if (i < jArr.length) {
                long j = jArr[i];
                strArr[i] = CommonBoxUtil.getDuration(j);
                if (j > 0 && CreatePincodeActivity.userHasSetPincode(this.mUserContextManager) && j <= pincodeIgnoreDuration) {
                    i2 = i;
                }
                i++;
            } else {
                MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(this);
                materialAlertDialogBuilder.setTitle((CharSequence) CommonBoxUtil.LS(R.string.Passcode_timeout));
                materialAlertDialogBuilder.setSingleChoiceItems((CharSequence[]) strArr, i2, new DialogInterface.OnClickListener() { // from class: com.box.android.activities.settings.SettingsActivity.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        Pincode.setPincodeIgnoreDuration(SettingsActivity.sDurationsInMilliseconds[i3], SettingsActivity.this.mUserContextManager);
                        try {
                            SettingsActivity settingsActivity = SettingsActivity.this;
                            settingsActivity.setPasscodeDurationIntervalIntoView(settingsActivity.mainOptionsView);
                            dialogInterface.dismiss();
                        } catch (Exception e) {
                            BoxLogUtils.logException(e);
                        }
                    }
                });
                materialAlertDialogBuilder.create().show();
                return;
            }
        }
    }

    private void hideDisabledItems(View view) {
        findViewById(R.id.allowBiometricsContainer).setVisibility(CommonBoxUtil.isBiometricHardwareAvailable(this) ? 0 : 8);
        view.findViewById(R.id.debugGroup).setVisibility(BuildConfigProvider.INSTANCE.isDebugBuild() ? 0 : 8);
    }

    public void updateFragment() {
        setUserStorageInfoIntoView(this.mainOptionsView);
        setVersionIntoView(this.mainOptionsView);
        setSecurityOptionsIntoView(this.mainOptionsView);
        setDownloadSizeIntoView(this.mainOptionsView);
        setCheckBoxListeners(this.mainOptionsView);
        setAccountIntoView(this.mainOptionsView);
        for (int i : this.optionsIdArray) {
            this.mainOptionsView.findViewById(i).setOnClickListener(new View.OnClickListener() { // from class: com.box.android.activities.settings.SettingsActivity$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.clickOnOption(view);
                }
            });
        }
    }

    private void setAccountIntoView(View view) {
        TextView textView = (TextView) view.findViewById(R.id.switchAccountsDescription);
        String login = this.mUserContextManager.getUserInfo().getLogin();
        if (login == null) {
            login = this.mUserContextManager.getUserInfo().getUserName();
        }
        textView.setText(login);
    }

    private void setUserStorageInfoIntoView(View view) {
        TextView textView = (TextView) view.findViewById(R.id.storageInfo);
        String fileSize = FileSizeUtils.getFileSize(getUserInfo().getSpaceAmount());
        try {
            if (getUserInfo().getSpaceAmount().longValue() >= INFINITE_STORAGE_AMOUNT) {
                fileSize = CommonBoxUtil.LS(R.string.Unlimited);
            }
        } catch (NumberFormatException e) {
            BoxLogUtils.logException(e);
        }
        textView.setText(String.format(CommonBoxUtil.LS(R.string.LS_Storage), FileSizeUtils.getFileSize(getUserInfo().getSpaceUsed()), fileSize));
    }

    private void setVersionIntoView(View view) {
        TextView textView = (TextView) view.findViewById(R.id.version);
        try {
            String str = MAMPackageManagement.getPackageInfo(getApplication().getPackageManager(), getPackageName(), 0).versionName;
            String strTrim = CommonBoxUtil.LS(R.string.git_commit_tag).trim();
            if ("".length() > 0) {
                strTrim = strTrim + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR;
            }
            if (strTrim.length() > 0) {
                str = str + " (" + strTrim + ")";
            }
            textView.setText(str);
        } catch (PackageManager.NameNotFoundException e) {
            BoxLogUtils.logException(e);
        }
        final String xPlatformVersion = BuildConfigProvider.INSTANCE.getXPlatformVersion();
        if (xPlatformVersion.isEmpty()) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.activities.settings.SettingsActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$setVersionIntoView$1(xPlatformVersion, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setVersionIntoView$1(String str, View view) {
        new MaterialAlertDialogBuilder(this).setTitle((CharSequence) "X-Platform Version").setMessage((CharSequence) str).setPositiveButton(android.R.string.ok, (DialogInterface.OnClickListener) null).show();
    }

    private void setCheckBoxListeners(View view) {
        SwitchCompat switchCompat = (SwitchCompat) view.findViewById(R.id.requirePasscodeSwitch);
        boolean zUserHasSetPincode = CreatePincodeActivity.userHasSetPincode(this.mUserContextManager);
        this.mainOptionsView.findViewById(R.id.Options_PasscodeOptions).setVisibility(zUserHasSetPincode ? 0 : 8);
        switchCompat.setChecked(zUserHasSetPincode);
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.box.android.activities.settings.SettingsActivity.4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (!CoreServiceUtils.getIsPinRequiredByMAMPolicy()) {
                    boolean zUserHasSetPincode2 = CreatePincodeActivity.userHasSetPincode(SettingsActivity.this.mUserContextManager);
                    if (z) {
                        SettingsActivity.this.mainOptionsView.findViewById(R.id.Options_PasscodeOptions).setVisibility(0);
                        if (zUserHasSetPincode2) {
                            return;
                        }
                        SettingsActivity settingsActivity = SettingsActivity.this;
                        settingsActivity.startActivityForResult(CreatePincodeActivity.createIntent(settingsActivity), 10);
                        return;
                    }
                    SettingsActivity.this.mainOptionsView.findViewById(R.id.Options_PasscodeOptions).setVisibility(8);
                    if (zUserHasSetPincode2) {
                        SettingsActivity settingsActivity2 = SettingsActivity.this;
                        settingsActivity2.startActivityForResult(CreatePincodeActivity.createDisablePinCodeIntent(settingsActivity2), 100);
                        return;
                    }
                    return;
                }
                BoxNotificationHelper.displayDialog(R.string.Feature_disabled, R.string.intune_not_supported_passcode);
                compoundButton.setChecked(false);
            }
        });
        SwitchCompat switchCompat2 = (SwitchCompat) view.findViewById(R.id.allowBiometricsSwitch);
        switchCompat2.setChecked(BiometricsVM.isBiometricsEnabled(this.mUserContextManager));
        switchCompat2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.box.android.activities.settings.SettingsActivity.5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (!z) {
                    BiometricsVM.setBiometricsEnabled(SettingsActivity.this.mUserContextManager, z);
                    return;
                }
                int iCanAuthenticate = BiometricManager.from(SettingsActivity.this).canAuthenticate();
                if (iCanAuthenticate == 0) {
                    BiometricsVM.setBiometricsEnabled(SettingsActivity.this.mUserContextManager, z);
                    return;
                }
                if (iCanAuthenticate == 11) {
                    Toast.makeText(SettingsActivity.this, R.string.add_biometric_msg, 1).show();
                    compoundButton.setChecked(false);
                } else if (iCanAuthenticate == 12) {
                    Toast.makeText(SettingsActivity.this, R.string.Error_no_biometrics_hardware, 1).show();
                    compoundButton.setChecked(false);
                } else if (iCanAuthenticate == 1) {
                    Toast.makeText(SettingsActivity.this, R.string.Error_no_biometrics_hardware, 1).show();
                    compoundButton.setChecked(false);
                }
            }
        });
        ((LinearLayout) view.findViewById(R.id.continous_capture_container)).setOnClickListener(new View.OnClickListener() { // from class: com.box.android.activities.settings.SettingsActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$setCheckBoxListeners$2(view2);
            }
        });
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.files_and_folders_container);
        linearLayout.setVisibility(0);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.activities.settings.SettingsActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$setCheckBoxListeners$3(view2);
            }
        });
        findViewById(R.id.feature_flips).setOnClickListener(new View.OnClickListener() { // from class: com.box.android.activities.settings.SettingsActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$setCheckBoxListeners$4(view2);
            }
        });
        findViewById(R.id.split_environment).setOnClickListener(new View.OnClickListener() { // from class: com.box.android.activities.settings.SettingsActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$setCheckBoxListeners$8(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setCheckBoxListeners$2(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.settings_fragment_container, new CaptureSettingsFragment()).addToBackStack(null).commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setCheckBoxListeners$3(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.settings_fragment_container, FilesAndFoldersSettingsFragment.class, (Bundle) null).addToBackStack(null).commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setCheckBoxListeners$4(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.settings_fragment_container, new FeatureFlipsToggleFragment()).addToBackStack(null).commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setCheckBoxListeners$8(View view) {
        String string = this.sharedPreferences.getString(SplitConfiguration.getSPLIT_ENV_OVERRIDE_KEY(), BuildConfig.CONFIG_SPLIT_API_KEY);
        final ArrayList arrayList = new ArrayList(this.splitEnvOverrides.values());
        final AtomicInteger atomicInteger = new AtomicInteger(arrayList.indexOf(string));
        new MaterialAlertDialogBuilder(this).setTitle(R.string.split_environment_override).setSingleChoiceItems((CharSequence[]) this.splitEnvOverrides.keySet().toArray(new String[0]), atomicInteger.get(), new DialogInterface.OnClickListener() { // from class: com.box.android.activities.settings.SettingsActivity$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                atomicInteger.set(i);
            }
        }).setNegativeButton(R.string.button_cancel, new DialogInterface.OnClickListener() { // from class: com.box.android.activities.settings.SettingsActivity$$ExternalSyntheticLambda7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).setPositiveButton(R.string.button_ok, new DialogInterface.OnClickListener() { // from class: com.box.android.activities.settings.SettingsActivity$$ExternalSyntheticLambda8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$setCheckBoxListeners$7(arrayList, atomicInteger, dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setCheckBoxListeners$7(ArrayList arrayList, AtomicInteger atomicInteger, DialogInterface dialogInterface, int i) {
        this.sharedPreferences.edit().putString(SplitConfiguration.getSPLIT_ENV_OVERRIDE_KEY(), (String) arrayList.get(atomicInteger.get())).apply();
        dialogInterface.dismiss();
        this.splitConfiguration.init(this.mUserContextManager.getUserInfo());
    }

    private void setSecurityOptionsIntoView(View view) {
        setPasscodeDurationIntervalIntoView(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPasscodeDurationIntervalIntoView(View view) {
        TextView textView = (TextView) view.findViewById(R.id.currentPasscodeInterval);
        if (CreatePincodeActivity.userHasSetPincode(this.mUserContextManager)) {
            int pincodeIgnoreDuration = (int) (Pincode.getPincodeIgnoreDuration(this.mUserContextManager) / 60000);
            String strPluralFormat = CommonBoxUtil.pluralFormat(R.array.x_minutes, pincodeIgnoreDuration);
            if (pincodeIgnoreDuration >= 60) {
                strPluralFormat = CommonBoxUtil.pluralFormat(R.array.x_hours, pincodeIgnoreDuration / 60);
            }
            textView.setText(strPluralFormat);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.box.android.activities.settings.SettingsActivity$6] */
    public void setDownloadSizeIntoView(final View view) {
        new Thread() { // from class: com.box.android.activities.settings.SettingsActivity.6
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                final TextView textView = (TextView) view.findViewById(R.id.txtcleardownloads);
                final long totalCacheSize = BoxModelOfflineManager.getTotalCacheSize(SettingsActivity.this.mUserContextManager);
                SettingsActivity.this.runOnUiThread(new Runnable() { // from class: com.box.android.activities.settings.SettingsActivity.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        textView.setText(String.format(CommonBoxUtil.LS(R.string.Clear_offline_files_x), FileSizeUtils.getFileSize(Long.valueOf(totalCacheSize))));
                    }
                });
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.box.android.activities.settings.SettingsActivity$7] */
    private void clearOfflinedFilesFolders(final View view) {
        new Thread() { // from class: com.box.android.activities.settings.SettingsActivity.7
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                SettingsActivity.this.showSpinner();
                try {
                    BoxModelOfflineManager.removeAllOfflineFileFolders(SettingsActivity.this.mUserContextManager, SettingsActivity.this.mUserContextManager.getCurrentContext().getKVStore(), SettingsActivity.this.mJobManager, SettingsActivity.this.mJobService).get();
                } catch (InterruptedException | ExecutionException e) {
                    BoxLogUtils.logException(e);
                    if (e instanceof InterruptedException) {
                        Thread.currentThread().interrupt();
                    }
                }
                SettingsActivity.this.setDownloadSizeIntoView(view);
                SettingsActivity.this.broadcastDismissSpinner();
                SettingsActivity.this.runOnUiThread(new Runnable() { // from class: com.box.android.activities.settings.SettingsActivity.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(SettingsActivity.this.getApplicationContext(), CommonBoxUtil.LS(R.string.LS_Downloads_clear), 1).show();
                    }
                });
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clickOnOption(View view) {
        int id = view.getId();
        if (id == R.id.btnClearDownloads) {
            BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_SETTINGS, BoxAnalyticsParams.ACTION_CLEAR_DOWNLOADS, "");
            clearOfflinedFilesFolders(view);
            return;
        }
        if (id == R.id.changePassCode) {
            CreatePincodeActivity.startActivity();
            return;
        }
        if (id == R.id.requirePasscodeContainer) {
            SwitchCompat switchCompat = (SwitchCompat) findViewById(R.id.requirePasscodeSwitch);
            switchCompat.setChecked(!switchCompat.isChecked());
            return;
        }
        if (id == R.id.btnHelpCenter) {
            BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_SETTINGS, BoxAnalyticsParams.ACTION_HELP_CENTER, "");
            BoxUtils.launchSafeExternalLink(this, BoxBaseApplication.getInstance().getConfigManager().getString(BoxConfigConstants.CONFIG_KEY_HELP_CENTER_URL));
            return;
        }
        if (id == R.id.btnPrivacyPolicy) {
            BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_SETTINGS, BoxAnalyticsParams.ACTION_PRIVACY_POLICY, "");
            BoxUtils.launchSafeExternalLink(this, BoxBaseApplication.getInstance().getConfigManager().getString(BoxConfigConstants.CONFIG_KEY_PRIVACY_POLICY_URL));
            return;
        }
        if (id == R.id.btnTermsOfService) {
            BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_SETTINGS, BoxAnalyticsParams.ACTION_TERMS_OF_SERVICE, "");
            BoxUtils.launchSafeExternalLink(this, BoxBaseApplication.getInstance().getConfigManager().getString(BoxConfigConstants.CONFIG_KEY_TERMS_OF_SERVICE_URL));
            return;
        }
        if (id == R.id.changePassCodeTimeout) {
            showDurationChooser();
            return;
        }
        if (id == R.id.allowBiometricsContainer) {
            SwitchCompat switchCompat2 = (SwitchCompat) findViewById(R.id.allowBiometricsSwitch);
            switchCompat2.setChecked(!switchCompat2.isChecked());
        } else {
            if (id == R.id.btnLogout) {
                LogoutWarningActivity.showLogout();
                return;
            }
            if (id == R.id.btnSwitchAccounts) {
                startActivityForResult(SwitchAccountActivity.newIntent(this), 301);
            } else if (id == R.id.btnUploadLogs) {
                BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_SETTINGS, BoxAnalyticsParams.ACTION_UPLOAD_LOGS, "");
                this.createLogArchiveInteractor.invoke(R.string.fileProviderAuthority, ObservabilitySettingsManager.INSTANCE.getLogTag(), new Continuation<Result<? extends Uri, ? extends DomainError>>() { // from class: com.box.android.activities.settings.SettingsActivity.8
                    @Override // kotlin.coroutines.Continuation
                    public CoroutineContext getContext() {
                        return EmptyCoroutineContext.INSTANCE;
                    }

                    @Override // kotlin.coroutines.Continuation
                    public void resumeWith(Object obj) {
                        if (obj instanceof Result.Success) {
                            UploadLogsWorker.INSTANCE.schedule();
                            BoxPresentationUtils.displayToast(R.string.log_uploads_started, SettingsActivity.this, new String[0]);
                        } else {
                            BoxPresentationUtils.displayToast(R.string.failed_to_prepare_logs_to_upload, SettingsActivity.this, new String[0]);
                        }
                    }
                });
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        boolean z = false;
        if (!strArr[0].equals("android.permission.ACCESS_FINE_LOCATION")) {
            if (iArr.length > 0 && iArr[0] == 0) {
                z = true;
            }
            permissionsMessageHelper(z);
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    public static Intent getStartIntent(Context context) {
        return getStartIntent(context, null);
    }

    public static Intent getStartIntent(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) SettingsActivity.class);
        if (str != null) {
            intent.putExtra(FRAGMENT_TO_LOAD_KEY, str);
        }
        return intent;
    }

    private void setupEdgeToEdge() {
        EdgeToEdgeUtils.INSTANCE.enableDarkEdgeToEdge(this);
        EdgeToEdgeUtils.INSTANCE.setInsets(findViewById(R.id.coordinator_layout), new EdgeToEdgeUtils.OnInsetsAppliedListener() { // from class: com.box.android.activities.settings.SettingsActivity$$ExternalSyntheticLambda0
            @Override // com.box.android.base.presentation.utilities.EdgeToEdgeUtils.OnInsetsAppliedListener
            public final void onInsetsApplied(View view, Insets insets, WindowInsetsCompat windowInsetsCompat) {
                SettingsActivity.lambda$setupEdgeToEdge$9(view, insets, windowInsetsCompat);
            }
        });
    }

    static /* synthetic */ void lambda$setupEdgeToEdge$9(View view, Insets insets, WindowInsetsCompat windowInsetsCompat) {
        View viewFindViewById = view.findViewById(R.id.last_item);
        ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = insets.bottom;
            viewFindViewById.setLayoutParams(marginLayoutParams);
        }
    }
}
