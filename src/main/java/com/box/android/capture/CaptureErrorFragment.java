package com.box.android.capture;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.FragmentActivity;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.capture.databinding.FragmentCaptureErrorBinding;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.common.utilities.IntentUtils;
import com.box.android.domain.models.capture.CaptureMode;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import dagger.hilt.android.AndroidEntryPoint;
import java.io.Serializable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CaptureErrorFragment.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\"\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0017J-\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u000e\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0017¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\tH\u0002J\b\u0010\"\u001a\u00020\u001dH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/box/android/capture/CaptureErrorFragment;", "Lcom/box/android/base/presentation/fragments/BoxFragment;", "<init>", "()V", "captureMode", "Lcom/box/android/domain/models/capture/CaptureMode;", "binding", "Lcom/box/android/capture/databinding/FragmentCaptureErrorBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "showPermissionDialog", "getPermissionDialogMessage", "Companion", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class CaptureErrorFragment extends Hilt_CaptureErrorFragment {
    private static final String CAPTURE_MODE = "capture_mode";
    private static final int REQUEST_CODE_PERMISSIONS = 10;
    private FragmentCaptureErrorBinding binding;
    private CaptureMode captureMode;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: CaptureErrorFragment.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CaptureMode.values().length];
            try {
                iArr[CaptureMode.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CaptureMode.PHOTO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CaptureMode.SCAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CaptureMode.AUDIO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @JvmStatic
    public static final CaptureErrorFragment newInstance(CaptureMode captureMode) {
        return INSTANCE.newInstance(captureMode);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable(CAPTURE_MODE) : null;
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.box.android.domain.models.capture.CaptureMode");
        this.captureMode = (CaptureMode) serializable;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentCaptureErrorBinding fragmentCaptureErrorBindingInflate = FragmentCaptureErrorBinding.inflate(getLayoutInflater(), container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentCaptureErrorBindingInflate, "inflate(...)");
        this.binding = fragmentCaptureErrorBindingInflate;
        if (fragmentCaptureErrorBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentCaptureErrorBindingInflate = null;
        }
        return fragmentCaptureErrorBindingInflate.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        KeyEventDispatcher.Component componentRequireActivity = requireActivity();
        Intrinsics.checkNotNull(componentRequireActivity, "null cannot be cast to non-null type com.box.android.capture.IPermissionHandler");
        final IPermissionHandler iPermissionHandler = (IPermissionHandler) componentRequireActivity;
        FragmentCaptureErrorBinding fragmentCaptureErrorBinding = this.binding;
        FragmentCaptureErrorBinding fragmentCaptureErrorBinding2 = null;
        if (fragmentCaptureErrorBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentCaptureErrorBinding = null;
        }
        fragmentCaptureErrorBinding.captureErrorButton.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.CaptureErrorFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CaptureErrorFragment.onViewCreated$lambda$0(this.f$0, iPermissionHandler, view2);
            }
        });
        FragmentCaptureErrorBinding fragmentCaptureErrorBinding3 = this.binding;
        if (fragmentCaptureErrorBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentCaptureErrorBinding3 = null;
        }
        fragmentCaptureErrorBinding3.captureErrorClose.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.CaptureErrorFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CaptureErrorFragment.onViewCreated$lambda$1(this.f$0, view2);
            }
        });
        CaptureMode captureMode = this.captureMode;
        if (captureMode == null) {
            Intrinsics.throwUninitializedPropertyAccessException("captureMode");
            captureMode = null;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[captureMode.ordinal()];
        if (i == 1) {
            FragmentCaptureErrorBinding fragmentCaptureErrorBinding4 = this.binding;
            if (fragmentCaptureErrorBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentCaptureErrorBinding4 = null;
            }
            fragmentCaptureErrorBinding4.captureErrorReason.setText(getString(R.string.box_capture_error_video_reason));
            FragmentCaptureErrorBinding fragmentCaptureErrorBinding5 = this.binding;
            if (fragmentCaptureErrorBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentCaptureErrorBinding5 = null;
            }
            fragmentCaptureErrorBinding5.captureErrorButton.setText(getString(R.string.box_capture_error_video_button_text));
        } else if (i == 2) {
            FragmentCaptureErrorBinding fragmentCaptureErrorBinding6 = this.binding;
            if (fragmentCaptureErrorBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentCaptureErrorBinding6 = null;
            }
            fragmentCaptureErrorBinding6.captureErrorReason.setText(getString(R.string.box_capture_error_reason));
            FragmentCaptureErrorBinding fragmentCaptureErrorBinding7 = this.binding;
            if (fragmentCaptureErrorBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentCaptureErrorBinding7 = null;
            }
            fragmentCaptureErrorBinding7.captureErrorButton.setText(getString(R.string.box_capture_error_button_text));
        } else if (i == 3) {
            FragmentCaptureErrorBinding fragmentCaptureErrorBinding8 = this.binding;
            if (fragmentCaptureErrorBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentCaptureErrorBinding8 = null;
            }
            fragmentCaptureErrorBinding8.captureErrorReason.setText(getString(R.string.box_document_scanning_error_reason));
            FragmentCaptureErrorBinding fragmentCaptureErrorBinding9 = this.binding;
            if (fragmentCaptureErrorBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentCaptureErrorBinding9 = null;
            }
            fragmentCaptureErrorBinding9.captureErrorButton.setText(getString(R.string.box_capture_error_button_text));
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            FragmentCaptureErrorBinding fragmentCaptureErrorBinding10 = this.binding;
            if (fragmentCaptureErrorBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentCaptureErrorBinding10 = null;
            }
            fragmentCaptureErrorBinding10.captureErrorReason.setText(getString(R.string.box_audio_recording_error_reason));
            FragmentCaptureErrorBinding fragmentCaptureErrorBinding11 = this.binding;
            if (fragmentCaptureErrorBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentCaptureErrorBinding11 = null;
            }
            fragmentCaptureErrorBinding11.captureErrorButton.setText(getString(R.string.box_audio_recording_error_button_text));
        }
        FragmentCaptureErrorBinding fragmentCaptureErrorBinding12 = this.binding;
        if (fragmentCaptureErrorBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentCaptureErrorBinding2 = fragmentCaptureErrorBinding12;
        }
        ConstraintLayout captureErrorParent = fragmentCaptureErrorBinding2.captureErrorParent;
        Intrinsics.checkNotNullExpressionValue(captureErrorParent, "captureErrorParent");
        CommonBoxUtil.addStatusBarPaddingTop(captureErrorParent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(CaptureErrorFragment captureErrorFragment, IPermissionHandler iPermissionHandler, View view) {
        CaptureMode captureMode = captureErrorFragment.captureMode;
        if (captureMode == null) {
            Intrinsics.throwUninitializedPropertyAccessException("captureMode");
            captureMode = null;
        }
        captureErrorFragment.requestPermissions(iPermissionHandler.requiredPermissions(captureMode), 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(CaptureErrorFragment captureErrorFragment, View view) {
        FragmentActivity activity = captureErrorFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Deprecated(message = "Deprecated in Java")
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 10) {
            KeyEventDispatcher.Component activity = getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.box.android.capture.IPermissionHandler");
            IPermissionHandler iPermissionHandler = (IPermissionHandler) activity;
            CaptureMode captureMode = this.captureMode;
            CaptureMode captureMode2 = null;
            if (captureMode == null) {
                Intrinsics.throwUninitializedPropertyAccessException("captureMode");
                captureMode = null;
            }
            if (iPermissionHandler.areAllPermissionsGranted(captureMode)) {
                CaptureMode captureMode3 = this.captureMode;
                if (captureMode3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("captureMode");
                } else {
                    captureMode2 = captureMode3;
                }
                iPermissionHandler.onPermissionsGranted(captureMode2);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Deprecated(message = "Deprecated in Java")
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        if (requestCode == 10) {
            KeyEventDispatcher.Component activity = getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.box.android.capture.IPermissionHandler");
            IPermissionHandler iPermissionHandler = (IPermissionHandler) activity;
            CaptureMode captureMode = this.captureMode;
            CaptureMode captureMode2 = null;
            if (captureMode == null) {
                Intrinsics.throwUninitializedPropertyAccessException("captureMode");
                captureMode = null;
            }
            if (iPermissionHandler.areAllPermissionsGranted(captureMode)) {
                CaptureMode captureMode3 = this.captureMode;
                if (captureMode3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("captureMode");
                } else {
                    captureMode2 = captureMode3;
                }
                iPermissionHandler.onPermissionsGranted(captureMode2);
            } else {
                for (String str : permissions) {
                    if (!shouldShowRequestPermissionRationale(str)) {
                        showPermissionDialog();
                    }
                }
                BoxPresentationUtils.displayToast(R.string.camera__permission_denied, requireActivity(), new String[0]);
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private final void showPermissionDialog() {
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(requireContext());
        materialAlertDialogBuilder.setMessage((CharSequence) getPermissionDialogMessage());
        materialAlertDialogBuilder.setTitle(R.string.job_item_error_type_permission);
        materialAlertDialogBuilder.setPositiveButton(R.string.account_settings, new DialogInterface.OnClickListener() { // from class: com.box.android.capture.CaptureErrorFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                CaptureErrorFragment.showPermissionDialog$lambda$0(this.f$0, dialogInterface, i);
            }
        });
        materialAlertDialogBuilder.setNegativeButton(R.string.dismiss, new DialogInterface.OnClickListener() { // from class: com.box.android.capture.CaptureErrorFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        materialAlertDialogBuilder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPermissionDialog$lambda$0(CaptureErrorFragment captureErrorFragment, DialogInterface dialogInterface, int i) {
        IntentUtils intentUtils = IntentUtils.INSTANCE;
        FragmentActivity fragmentActivityRequireActivity = captureErrorFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        captureErrorFragment.startActivityForResult(intentUtils.getApplicationSettingsIntent(fragmentActivityRequireActivity), 10);
        dialogInterface.dismiss();
    }

    private final String getPermissionDialogMessage() {
        CaptureMode captureMode = this.captureMode;
        if (captureMode == null) {
            Intrinsics.throwUninitializedPropertyAccessException("captureMode");
            captureMode = null;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[captureMode.ordinal()];
        if (i != 1) {
            if (i == 2) {
                String string = getString(R.string.camera_permission_permanently_denied);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                return string;
            }
            if (i == 3) {
                String string2 = getString(R.string.camera_permission_permanently_denied);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                return string2;
            }
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            String string3 = getString(R.string.microphone_permission_permanently_denied);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            return string3;
        }
        boolean z = ContextCompat.checkSelfPermission(requireContext(), "android.permission.CAMERA") != 0;
        boolean z2 = ContextCompat.checkSelfPermission(requireContext(), "android.permission.RECORD_AUDIO") != 0;
        if (z && z2) {
            String string4 = getString(R.string.video_permissions_permanently_denied);
            Intrinsics.checkNotNull(string4);
            return string4;
        }
        if (z) {
            String string5 = getString(R.string.video_camera_permission_permanently_denied);
            Intrinsics.checkNotNull(string5);
            return string5;
        }
        String string6 = getString(R.string.video_record_audio_permission_permanently_denied);
        Intrinsics.checkNotNull(string6);
        return string6;
    }

    /* JADX INFO: compiled from: CaptureErrorFragment.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/box/android/capture/CaptureErrorFragment$Companion;", "", "<init>", "()V", "REQUEST_CODE_PERMISSIONS", "", "CAPTURE_MODE", "", "newInstance", "Lcom/box/android/capture/CaptureErrorFragment;", "captureMode", "Lcom/box/android/domain/models/capture/CaptureMode;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CaptureErrorFragment newInstance(CaptureMode captureMode) {
            Intrinsics.checkNotNullParameter(captureMode, "captureMode");
            CaptureErrorFragment captureErrorFragment = new CaptureErrorFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(CaptureErrorFragment.CAPTURE_MODE, captureMode);
            captureErrorFragment.setArguments(bundle);
            return captureErrorFragment;
        }
    }
}
