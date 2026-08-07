package com.box.android.base.presentation.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.box.android.base.R;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.domain.analytics.BoxAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes9.dex */
public class ShowFTUXDialogFragment extends Hilt_ShowFTUXDialogFragment {
    public static final String ARG_FTUX_TYPE = "argFtuxType";
    public static final String SHARED_PREF_KEY_FTUX_LAST_SHOWN = "sharedPrefKeyLastShown";
    public static final String TAG = "showFTUXDialogFragment";
    private BaseFTUX ftux;

    @Inject
    protected BaseFTUX.FTUXFactory ftuxFactory;
    private boolean gotPositiveFeedback = false;

    @Inject
    protected IntentServices mIntentServices;

    @Inject
    protected IUserContextManager mUserContextManager;

    public static ShowFTUXDialogFragment newInstance(BaseFTUX baseFTUX) {
        ShowFTUXDialogFragment showFTUXDialogFragment = new ShowFTUXDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_FTUX_TYPE, baseFTUX.getType());
        showFTUXDialogFragment.setArguments(bundle);
        return showFTUXDialogFragment;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, R.style.Theme_Box_Custom_Dialog_Alert);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(final LayoutInflater layoutInflater, final ViewGroup viewGroup, Bundle bundle) {
        BaseFTUX.FTUXType fTUXType;
        if (bundle != null) {
            fTUXType = (BaseFTUX.FTUXType) bundle.getSerializable(ARG_FTUX_TYPE);
        } else {
            fTUXType = (BaseFTUX.FTUXType) getArguments().get(ARG_FTUX_TYPE);
        }
        BaseFTUX baseFTUXCreateFTUX = this.ftuxFactory.createFTUX(fTUXType);
        this.ftux = baseFTUXCreateFTUX;
        String title = baseFTUXCreateFTUX.getTitle();
        String description = this.ftux.getDescription();
        View viewInflate = layoutInflater.inflate(R.layout.show_ftux_dialog, viewGroup, false);
        final FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R.id.sceneRoot);
        ((TextView) viewInflate.findViewById(R.id.ftuxTitle)).setText(title);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.ftuxImage);
        if (this.ftux instanceof RateFTUX) {
            imageView.setImageResource(R.drawable.img_ftux_rating_step1);
        } else {
            dismiss();
        }
        ((TextView) viewInflate.findViewById(R.id.description)).setText(description);
        setCancelable(this.ftux.isCancelable());
        this.mUserContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.FTUX).edit().putLong(SHARED_PREF_KEY_FTUX_LAST_SHOWN, System.currentTimeMillis()).apply();
        final Button button = (Button) viewInflate.findViewById(R.id.btnPositive);
        final Button button2 = (Button) viewInflate.findViewById(R.id.btnNegative);
        button.setText(this.ftux.getPositiveBtnString());
        button.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.base.presentation.fragments.ShowFTUXDialogFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ShowFTUXDialogFragment.this.ftux instanceof RateFTUX) {
                    if (ShowFTUXDialogFragment.this.gotPositiveFeedback) {
                        ShowFTUXDialogFragment.this.ftux.onPositiveBtnClicked();
                        BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_AB_TESTING, BoxAnalyticsParams.ACTION_FTUX_RATE_BOX, ShowFTUXDialogFragment.this.ftux.getType().name());
                        ShowFTUXDialogFragment.this.dismiss();
                        return;
                    }
                    View viewInflate2 = layoutInflater.inflate(R.layout.ftux_content, viewGroup, false);
                    TextView textView = (TextView) viewInflate2.findViewById(R.id.ftuxTitle);
                    TextView textView2 = (TextView) viewInflate2.findViewById(R.id.description);
                    ImageView imageView2 = (ImageView) viewInflate2.findViewById(R.id.ftuxImage);
                    textView.setText(R.string.rate_ftux_positive_title);
                    imageView2.setImageResource(R.drawable.img_ftux_rating_step2);
                    textView2.setText(R.string.rate_ftux_positive_description);
                    TransitionManager.go(new Scene(frameLayout, viewInflate2), new Slide(5));
                    button.setText(R.string.rate_box);
                    button2.setText(R.string.later);
                    ShowFTUXDialogFragment.this.gotPositiveFeedback = true;
                    BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_AB_TESTING, BoxAnalyticsParams.ACTION_FTUX_POSITIVE_CLICK, ShowFTUXDialogFragment.this.ftux.getType().name());
                    return;
                }
                ShowFTUXDialogFragment.this.ftux.onPositiveBtnClicked();
                BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_AB_TESTING, BoxAnalyticsParams.ACTION_FTUX_POSITIVE_CLICK, ShowFTUXDialogFragment.this.ftux.getType().name());
                ShowFTUXDialogFragment.this.dismiss();
            }
        });
        if (this.ftux.getNegativeBtnString().isEmpty()) {
            button2.setVisibility(8);
        } else {
            button2.setVisibility(0);
            button2.setText(this.ftux.getNegativeBtnString());
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.base.presentation.fragments.ShowFTUXDialogFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!(ShowFTUXDialogFragment.this.ftux instanceof RateFTUX) || ShowFTUXDialogFragment.this.gotPositiveFeedback) {
                        ShowFTUXDialogFragment.this.ftux.onNegativeBtnClicked();
                        BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_AB_TESTING, BoxAnalyticsParams.ACTION_FTUX_NEGATIVE_CLICK, ShowFTUXDialogFragment.this.ftux.getType().name());
                    } else {
                        if (CommonBoxUtil.isSendEmailIntentAvailable(ShowFTUXDialogFragment.this.getContext())) {
                            ShowFTUXDialogFragment showFTUXDialogFragment = ShowFTUXDialogFragment.this;
                            showFTUXDialogFragment.startActivity(showFTUXDialogFragment.mIntentServices.emailSupportActivityIntent(ShowFTUXDialogFragment.this.getActivity()));
                        } else {
                            BoxPresentationUtils.displayToast(R.string.err_no_installed_application_can_perform, ApplicationProvider.application, new String[0]);
                        }
                        BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_AB_TESTING, BoxAnalyticsParams.ACTION_EMAIL_SUPPORT, ShowFTUXDialogFragment.this.ftux.getType().name());
                    }
                    ShowFTUXDialogFragment.this.dismiss();
                }
            });
        }
        this.ftux.recordDisplayTimestamp();
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        getActivity().setRequestedOrientation(-1);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        this.ftux.onDismiss(dialogInterface);
        BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_AB_TESTING, BoxAnalyticsParams.ACTION_FTUX_DISMISS, this.ftux.getType().name());
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable(ARG_FTUX_TYPE, this.ftux.getType());
        super.onSaveInstanceState(bundle);
    }
}
