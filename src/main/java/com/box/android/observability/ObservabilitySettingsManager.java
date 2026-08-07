package com.box.android.observability;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SpinnerAdapter;
import androidx.appcompat.app.AlertDialog;
import com.box.android.R;
import com.box.android.application.BoxApplication;
import com.box.android.databinding.DialogDiagnosisModeBinding;
import com.box.android.domain.jobs.JobConstants;
import com.box.android.domain.models.observability.DiagnosisMode;
import com.box.android.domain.models.observability.DiagnosisModel;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: compiled from: ObservabilitySettingsManager.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 %2\u00020\u0001:\u0002%&B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0006\u0010\n\u001a\u00020\u0005J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007J\u0006\u0010\u0010\u001a\u00020\u0005J\b\u0010\u0011\u001a\u00020\u0005H\u0007J\b\u0010\u0012\u001a\u00020\u0005H\u0007J \u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u001e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0019J \u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0018\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0019H\u0007J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J \u0010!\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#H\u0002J\u0018\u0010$\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020#H\u0002¨\u0006'"}, d2 = {"Lcom/box/android/observability/ObservabilitySettingsManager;", "", "<init>", "()V", "enableDiagnosisMode", "", "diagnosisModel", "Lcom/box/android/domain/models/observability/DiagnosisModel;", "setFileLoggingLevel", "setLogTag", JobConstants.SHOW_NOTIFICATION, "getLogLevel", "", "parseLogTagValue", "", "logTag", "disableDiagnosisMode", "removeFileLoggingLevel", "removeLogTag", "handleDiagnosisIntent", "context", "Landroid/content/Context;", "data", "Landroid/net/Uri;", "observabilityModeListener", "Lcom/box/android/observability/ObservabilitySettingsManager$ObservabilityModeListener;", "showDefaultDiagnosisModelDialog", "source", "showDiagnosisModeAlertDialog", "inputDiagnosisModel", "onDiagnosisPositiveButtonClicked", "completionListener", "onDiagnosisNegativeButtonClicked", "mapInputModelToUI", "binding", "Lcom/box/android/databinding/DialogDiagnosisModeBinding;", "mapOutputModelFromUI", "Companion", "ObservabilityModeListener", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ObservabilitySettingsManager {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String LOG_TAG = "log_tag";

    /* JADX INFO: compiled from: ObservabilitySettingsManager.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lcom/box/android/observability/ObservabilitySettingsManager$ObservabilityModeListener;", "", "onHandled", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface ObservabilityModeListener {
        void onHandled();
    }

    @Inject
    public ObservabilitySettingsManager() {
    }

    /* JADX INFO: compiled from: ObservabilitySettingsManager.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005J\b\u0010\u000f\u001a\u00020\nH\u0002J\u0012\u0010\u0010\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u0012\u001a\n \u0014*\u0004\u0018\u00010\u00130\u0013H\u0002R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003¨\u0006\u0015"}, d2 = {"Lcom/box/android/observability/ObservabilitySettingsManager$Companion;", "", "<init>", "()V", "LOG_TAG", "", "getLOG_TAG$annotations", "isDiagnosisModeEnabled", "", "removeFileLoggingLevelFromSharedPreferences", "", "addFileLoggingLevelToSharedPreferences", "logLevel", "", "getLogTag", "removeLogTagFromSharedPreferences", "addLogTagToSharedPreferences", "tag", "getObservabilitySharedPref", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getLOG_TAG$annotations() {
        }

        private Companion() {
        }

        public final boolean isDiagnosisModeEnabled() {
            return getObservabilitySharedPref().contains(BoxLogUtils.MIN_FILE_LOGGING_LEVEL);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void removeFileLoggingLevelFromSharedPreferences() {
            getObservabilitySharedPref().edit().remove(BoxLogUtils.MIN_FILE_LOGGING_LEVEL).apply();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void addFileLoggingLevelToSharedPreferences(int logLevel) {
            getObservabilitySharedPref().edit().putInt(BoxLogUtils.MIN_FILE_LOGGING_LEVEL, logLevel).apply();
        }

        public final String getLogTag() {
            return getObservabilitySharedPref().getString(ObservabilitySettingsManager.LOG_TAG, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void removeLogTagFromSharedPreferences() {
            getObservabilitySharedPref().edit().remove(ObservabilitySettingsManager.LOG_TAG).apply();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void addLogTagToSharedPreferences(String tag) {
            getObservabilitySharedPref().edit().putString(ObservabilitySettingsManager.LOG_TAG, tag).apply();
        }

        private final SharedPreferences getObservabilitySharedPref() {
            return BoxApplication.getInstance().getSharedPreferences("OBSERVABILITY", 0);
        }
    }

    public final void enableDiagnosisMode(DiagnosisModel diagnosisModel) {
        Intrinsics.checkNotNullParameter(diagnosisModel, "diagnosisModel");
        setFileLoggingLevel(diagnosisModel);
        setLogTag(diagnosisModel);
        showNotification();
        BoxLogUtils.w(ExtensionsKt.getTAG(this), "Enabled Diagnostic mode with user consent " + diagnosisModel.getSource());
    }

    public final void setFileLoggingLevel(DiagnosisModel diagnosisModel) {
        Intrinsics.checkNotNullParameter(diagnosisModel, "diagnosisModel");
        int logLevel = getLogLevel(diagnosisModel);
        INSTANCE.addFileLoggingLevelToSharedPreferences(logLevel);
        BoxLogUtils.setFileLoggingLevel(logLevel);
    }

    public final void setLogTag(DiagnosisModel diagnosisModel) {
        Intrinsics.checkNotNullParameter(diagnosisModel, "diagnosisModel");
        INSTANCE.addLogTagToSharedPreferences(parseLogTagValue(diagnosisModel.getTag()));
    }

    public final void showNotification() {
        new DiagnosisNotifManager().showNotification();
    }

    public final int getLogLevel(DiagnosisModel diagnosisModel) {
        Intrinsics.checkNotNullParameter(diagnosisModel, "diagnosisModel");
        if (diagnosisModel.getMode() == DiagnosisMode.VERBOSE) {
            return 2;
        }
        return diagnosisModel.getMode() == DiagnosisMode.DEBUG ? 3 : 4;
    }

    public final String parseLogTagValue(String logTag) {
        if (logTag == null) {
            return null;
        }
        return new Regex("[\\\\/?%*:|\"<>\\s]").replace(logTag, CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
    }

    public final void disableDiagnosisMode() {
        removeFileLoggingLevel();
        removeLogTag();
        BoxLogUtils.w(ExtensionsKt.getTAG(this), "Disabled Diagnostic mode");
    }

    public final void removeFileLoggingLevel() {
        INSTANCE.removeFileLoggingLevelFromSharedPreferences();
        BoxLogUtils.setFileLoggingLevel(4);
    }

    public final void removeLogTag() {
        INSTANCE.removeLogTagFromSharedPreferences();
    }

    public final void handleDiagnosisIntent(Context context, Uri data, ObservabilityModeListener observabilityModeListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(observabilityModeListener, "observabilityModeListener");
        if (data != null) {
            showDiagnosisModeAlertDialog(context, DiagnosisParamParser.INSTANCE.parseToModel(data), observabilityModeListener);
        }
    }

    public final void showDefaultDiagnosisModelDialog(Context context, String source, ObservabilityModeListener observabilityModeListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(observabilityModeListener, "observabilityModeListener");
        showDiagnosisModeAlertDialog(context, new DiagnosisModel.Builder(source).build(), observabilityModeListener);
    }

    public final void showDiagnosisModeAlertDialog(Context context, final DiagnosisModel inputDiagnosisModel, final ObservabilityModeListener observabilityModeListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(inputDiagnosisModel, "inputDiagnosisModel");
        Intrinsics.checkNotNullParameter(observabilityModeListener, "observabilityModeListener");
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(context);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.dialog_diagnosis_mode, (ViewGroup) null);
        final DialogDiagnosisModeBinding dialogDiagnosisModeBindingBind = DialogDiagnosisModeBinding.bind(viewInflate);
        Intrinsics.checkNotNullExpressionValue(dialogDiagnosisModeBindingBind, "bind(...)");
        mapInputModelToUI(inputDiagnosisModel, context, dialogDiagnosisModeBindingBind);
        materialAlertDialogBuilder.setView(viewInflate);
        materialAlertDialogBuilder.setMessage(R.string.diagnostic_mode_message);
        materialAlertDialogBuilder.setTitle(R.string.diagnosis_mode_dialog_title);
        materialAlertDialogBuilder.setPositiveButton(R.string.LO_Continue, new DialogInterface.OnClickListener() { // from class: com.box.android.observability.ObservabilitySettingsManager$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ObservabilitySettingsManager.showDiagnosisModeAlertDialog$lambda$0$0(this.f$0, inputDiagnosisModel, dialogDiagnosisModeBindingBind, observabilityModeListener, dialogInterface, i);
            }
        });
        materialAlertDialogBuilder.setNegativeButton(R.string.LO_Cancel, new DialogInterface.OnClickListener() { // from class: com.box.android.observability.ObservabilitySettingsManager$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ObservabilitySettingsManager.showDiagnosisModeAlertDialog$lambda$0$1(this.f$0, observabilityModeListener, dialogInterface, i);
            }
        });
        AlertDialog alertDialogCreate = materialAlertDialogBuilder.create();
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "create(...)");
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDiagnosisModeAlertDialog$lambda$0$0(ObservabilitySettingsManager observabilitySettingsManager, DiagnosisModel diagnosisModel, DialogDiagnosisModeBinding dialogDiagnosisModeBinding, ObservabilityModeListener observabilityModeListener, DialogInterface dialogInterface, int i) {
        BoxLogUtils.i("Tapped Continue on Diagnostic Mode Alert Dialog");
        observabilitySettingsManager.onDiagnosisPositiveButtonClicked(observabilitySettingsManager.mapOutputModelFromUI(diagnosisModel, dialogDiagnosisModeBinding), observabilityModeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDiagnosisModeAlertDialog$lambda$0$1(ObservabilitySettingsManager observabilitySettingsManager, ObservabilityModeListener observabilityModeListener, DialogInterface dialogInterface, int i) {
        BoxLogUtils.i("Tapped Cancel on Diagnostic Mode Alert Dialog");
        observabilitySettingsManager.onDiagnosisNegativeButtonClicked(observabilityModeListener);
    }

    public final void onDiagnosisPositiveButtonClicked(DiagnosisModel inputDiagnosisModel, ObservabilityModeListener completionListener) {
        Intrinsics.checkNotNullParameter(inputDiagnosisModel, "inputDiagnosisModel");
        Intrinsics.checkNotNullParameter(completionListener, "completionListener");
        enableDiagnosisMode(inputDiagnosisModel);
        completionListener.onHandled();
    }

    public final void onDiagnosisNegativeButtonClicked(ObservabilityModeListener observabilityModeListener) {
        Intrinsics.checkNotNullParameter(observabilityModeListener, "observabilityModeListener");
        observabilityModeListener.onHandled();
    }

    private final void mapInputModelToUI(DiagnosisModel inputDiagnosisModel, Context context, DialogDiagnosisModeBinding binding) {
        binding.logsLevelSpinner.setAdapter((SpinnerAdapter) new ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, DiagnosisMode.values()));
        binding.logsLevelSpinner.setSelection(inputDiagnosisModel.getMode().ordinal());
        EditText editText = binding.uniqueTagEdit;
        String tag = inputDiagnosisModel.getTag();
        if (tag == null) {
            tag = "";
        }
        editText.setText(tag);
    }

    private final DiagnosisModel mapOutputModelFromUI(DiagnosisModel inputDiagnosisModel, DialogDiagnosisModeBinding binding) {
        Object selectedItem = binding.logsLevelSpinner.getSelectedItem();
        Intrinsics.checkNotNull(selectedItem, "null cannot be cast to non-null type com.box.android.domain.models.observability.DiagnosisMode");
        return new DiagnosisModel.Builder(inputDiagnosisModel.getSource()).mode((DiagnosisMode) selectedItem).duration(inputDiagnosisModel.getDurationInHours()).shouldUpload(inputDiagnosisModel.getShouldUploadAtCompletion()).shouldClearLogs(inputDiagnosisModel.getShouldClearLogsOnLogout()).tag(binding.uniqueTagEdit.getText().toString()).build();
    }
}
