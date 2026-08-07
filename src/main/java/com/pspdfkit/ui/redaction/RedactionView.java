package com.pspdfkit.ui.redaction;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.pspdfkit.R;
import com.pspdfkit.internal.no;
import com.pspdfkit.internal.p0;
import com.pspdfkit.internal.y70;

/* JADX INFO: loaded from: classes3.dex */
public class RedactionView extends FrameLayout {
    public static final int REDACTION_BUTTON_ICON_WIDTH_DP = 48;
    private boolean isExpanded;
    private boolean isVisible;
    private View openRedactButton;
    private View redactionActionsContainer;
    private LinearLayout redactionContainer;
    private Button redactionPreviewButton;
    private boolean redactionPreviewEnabled;
    private RedactionViewListener redactionViewListener;

    public interface RedactionViewListener {
        void onPreviewModeChanged(boolean z);

        void onRedactionsApplied();

        void onRedactionsCleared();
    }

    public RedactionView(Context context) {
        super(context);
        this.isVisible = false;
        this.isExpanded = false;
        this.redactionPreviewEnabled = false;
        init();
    }

    private void expandRedactionOptions() {
        this.isExpanded = true;
        this.redactionActionsContainer.setVisibility(0);
        this.redactionActionsContainer.setScaleY(0.0f);
        this.redactionActionsContainer.setScaleX(0.5f);
        this.redactionActionsContainer.setAlpha(0.0f);
        this.redactionActionsContainer.setTranslationY(0.0f);
        View view = this.redactionActionsContainer;
        view.setPivotY(view.getHeight());
        View view2 = this.redactionActionsContainer;
        view2.setPivotX(view2.getWidth());
        this.redactionActionsContainer.animate().setDuration(250L).scaleY(1.0f).scaleX(1.0f).alpha(1.0f).translationY(0.0f).withStartAction(null).withEndAction(null);
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.pspdf__redaction_view, (ViewGroup) this, true);
        this.redactionContainer = (LinearLayout) findViewById(R.id.pspdf__redaction_container);
        View viewFindViewById = findViewById(R.id.pspdf__open_redact_button);
        this.openRedactButton = viewFindViewById;
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.ui.redaction.RedactionView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$init$0(view);
            }
        });
        this.redactionActionsContainer = findViewById(R.id.pspdf__redaction_actions_container);
        ((Button) findViewById(R.id.pspdf__apply_redactions_button)).setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.ui.redaction.RedactionView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$init$1(view);
            }
        });
        ((Button) findViewById(R.id.pspdf__clear_redactions_button)).setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.ui.redaction.RedactionView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$init$2(view);
            }
        });
        Button button = (Button) findViewById(R.id.pspdf__redaction_preview_button);
        this.redactionPreviewButton = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.ui.redaction.RedactionView$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$init$3(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$collapseRedactionOptions$4() {
        this.redactionActionsContainer.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(View view) {
        if (this.isExpanded) {
            collapseRedactionOptions();
        } else {
            expandRedactionOptions();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$1(View view) {
        RedactionViewListener redactionViewListener = this.redactionViewListener;
        if (redactionViewListener != null) {
            redactionViewListener.onRedactionsApplied();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$2(View view) {
        RedactionViewListener redactionViewListener = this.redactionViewListener;
        if (redactionViewListener != null) {
            redactionViewListener.onRedactionsCleared();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$3(View view) {
        this.redactionPreviewEnabled = !this.redactionPreviewEnabled;
        updatePreviewText();
        RedactionViewListener redactionViewListener = this.redactionViewListener;
        if (redactionViewListener != null) {
            redactionViewListener.onPreviewModeChanged(this.redactionPreviewEnabled);
        }
    }

    private void updatePreviewText() {
        boolean z = this.redactionPreviewEnabled;
        Button button = this.redactionPreviewButton;
        if (z) {
            button.setText(no.a(getContext(), R.string.pspdf__redaction_disable_preview, null));
        } else {
            button.setText(no.a(getContext(), R.string.pspdf__redaction_enable_preview, null));
        }
    }

    public void collapseRedactionOptions() {
        this.isExpanded = false;
        this.redactionActionsContainer.animate().setDuration(250L).scaleY(0.0f).scaleX(0.5f).translationY(0.0f).alpha(0.0f).withStartAction(null).withEndAction(new Runnable() { // from class: com.pspdfkit.ui.redaction.RedactionView$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$collapseRedactionOptions$4();
            }
        });
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        super.fitSystemWindows(rect);
        return false;
    }

    public int getRedactionButtonWidth() {
        return this.openRedactButton.getWidth();
    }

    public boolean isButtonRedactionButtonVisible() {
        return this.isVisible;
    }

    public boolean isRedactionAnnotationPreviewEnabled() {
        return this.redactionPreviewEnabled;
    }

    public boolean isRedactionButtonExpanded() {
        return this.isVisible && this.isExpanded;
    }

    public void setBottomOffset(int i) {
        this.redactionContainer.animate().translationY(-i);
    }

    public void setListener(RedactionViewListener redactionViewListener) {
        this.redactionViewListener = redactionViewListener;
    }

    public void setRedactionAnnotationPreviewEnabled(boolean z) {
        this.redactionPreviewEnabled = z;
        updatePreviewText();
    }

    /* JADX INFO: renamed from: setRedactionButtonVisible, reason: merged with bridge method [inline-methods] */
    public void lambda$setRedactionButtonVisible$5(final boolean z, final boolean z2) {
        if (this.redactionContainer.getWidth() == 0) {
            getViewTreeObserver().addOnGlobalLayoutListener(new y70(this, new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.pspdfkit.ui.redaction.RedactionView$$ExternalSyntheticLambda4
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    this.f$0.lambda$setRedactionButtonVisible$5(z, z2);
                }
            }));
            return;
        }
        if (z && !this.isVisible) {
            this.isVisible = true;
            p0.b(this.redactionContainer, z2);
        } else {
            if (z || !this.isVisible) {
                return;
            }
            this.isVisible = false;
            p0.a(this.redactionContainer, z2);
            collapseRedactionOptions();
        }
    }

    public RedactionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isVisible = false;
        this.isExpanded = false;
        this.redactionPreviewEnabled = false;
        init();
    }

    public RedactionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isVisible = false;
        this.isExpanded = false;
        this.redactionPreviewEnabled = false;
        init();
    }

    public RedactionView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.isVisible = false;
        this.isExpanded = false;
        this.redactionPreviewEnabled = false;
        init();
    }
}
