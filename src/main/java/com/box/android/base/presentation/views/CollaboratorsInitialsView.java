package com.box.android.base.presentation.views;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.box.android.base.R;
import com.box.android.coreservices.api.ShareController;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxCollaboration;
import com.box.androidsdk.content.models.BoxCollaborationItem;
import com.box.androidsdk.content.models.BoxCollaborator;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxIteratorCollaborations;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import com.box.androidsdk.content.views.BoxAvatarView;
import com.eclipsesource.json.JsonObject;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes9.dex */
public class CollaboratorsInitialsView extends LinearLayout {
    public static final String EXTRA_COLLABORATORS = "CollaboratorsInitialsView.ExtraCollaborators";
    public static final String EXTRA_SAVED_STATE = "CollaboratorsInitialsView.ExtraSaveState";
    private BoxResponse mBoxResponse;
    protected BoxIteratorCollaborations mCollaborations;
    private BoxFutureTask.OnCompletedListener<BoxIteratorCollaborations> mCollaborationsListener;
    protected ShareController mController;
    private TextView mInitialsListHeader;
    private LinearLayout mInitialsListView;
    private LinearLayout mInitialsListViewSection;
    private ProgressBar mProgressBar;
    protected BoxItem mShareItem;
    private ShowCollaboratorsListener mShowCollaboratorsListener;
    private BoxCollaborator mUnknownCollaborator;

    public interface ShowCollaboratorsListener {
        void onShowCollaborators(BoxIteratorCollaborations boxIteratorCollaborations);
    }

    public CollaboratorsInitialsView(Context context) {
        this(context, null);
    }

    public CollaboratorsInitialsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CollaboratorsInitialsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCollaborationsListener = new BoxFutureTask.OnCompletedListener<BoxIteratorCollaborations>() { // from class: com.box.android.base.presentation.views.CollaboratorsInitialsView.1
            @Override // com.box.androidsdk.content.BoxFutureTask.OnCompletedListener
            public void onCompleted(final BoxResponse<BoxIteratorCollaborations> boxResponse) {
                CollaboratorsInitialsView.this.mBoxResponse = boxResponse;
                final Activity activity = (Activity) CollaboratorsInitialsView.this.getContext();
                if (activity == null) {
                    return;
                }
                activity.runOnUiThread(new Runnable() { // from class: com.box.android.base.presentation.views.CollaboratorsInitialsView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CollaboratorsInitialsView.this.mProgressBar.setVisibility(8);
                        if (boxResponse.isSuccess() && CollaboratorsInitialsView.this.getCollaborationItem() != null) {
                            CollaboratorsInitialsView.this.updateView((BoxIteratorCollaborations) boxResponse.getResult());
                        } else if (((BoxException) boxResponse.getException()).getResponseCode() == 404) {
                            CollaboratorsInitialsView.this.mController.showToast(activity, CollaboratorsInitialsView.this.getString(R.string.box_sharesdk_item_unavailable));
                            activity.finish();
                        } else {
                            BoxLogUtils.e(CollaboratorsInitialsView.class.getName(), "Fetch Collaborators request failed", boxResponse.getException());
                            CollaboratorsInitialsView.this.mController.showToast(activity, CollaboratorsInitialsView.this.getString(R.string.box_sharesdk_network_error));
                        }
                    }
                });
            }
        };
        init();
    }

    public void setArguments(BoxCollaborationItem boxCollaborationItem, ShareController shareController) {
        this.mShareItem = boxCollaborationItem;
        this.mController = shareController;
    }

    private void init() {
        inflate(getContext(), R.layout.view_collaborators_initial, this);
        this.mProgressBar = (ProgressBar) findViewById(R.id.box_sharesdk_activity_progress_bar);
        this.mInitialsListView = (LinearLayout) findViewById(R.id.invite_collaborator_initials_list);
        this.mInitialsListViewSection = (LinearLayout) findViewById(R.id.collaborator_initials_list_section);
        this.mInitialsListHeader = (TextView) findViewById(R.id.invite_collaborator_initials_list_header);
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("name", "");
        this.mUnknownCollaborator = new BoxUser(jsonObject);
    }

    protected BoxCollaborationItem getCollaborationItem() {
        return (BoxCollaborationItem) this.mShareItem;
    }

    public final String getString(int i) {
        return getResources().getString(i);
    }

    public void fetchCollaborations() {
        if (this.mController == null) {
            return;
        }
        if (getCollaborationItem() == null || SdkUtils.isBlank(getCollaborationItem().getUserId())) {
            this.mController.showToast(getContext(), getString(R.string.box_sharesdk_cannot_view_collaborations));
            return;
        }
        this.mProgressBar.setVisibility(0);
        if (this.mBoxResponse == null) {
            this.mController.fetchCollaborations(getCollaborationItem()).addOnCompletedListener(this.mCollaborationsListener);
        } else {
            this.mProgressBar.setVisibility(8);
            updateView((BoxIteratorCollaborations) this.mBoxResponse.getResult());
        }
    }

    public void refreshView() {
        this.mBoxResponse = null;
        fetchCollaborations();
    }

    private void updateViewVisibilityForNoCollaborators() {
        ((TextView) findViewById(R.id.no_collaborators_text)).setVisibility(0);
        this.mInitialsListView.setVisibility(8);
    }

    private void updateViewVisibilityIfCollaboratorsFound() {
        ((TextView) findViewById(R.id.no_collaborators_text)).setVisibility(8);
        this.mInitialsListView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateView(BoxIteratorCollaborations boxIteratorCollaborations) {
        this.mCollaborations = boxIteratorCollaborations;
        if (boxIteratorCollaborations == null || boxIteratorCollaborations.size() == 0) {
            updateViewVisibilityForNoCollaborators();
            return;
        }
        updateViewVisibilityIfCollaboratorsFound();
        this.mInitialsListHeader.setVisibility(0);
        final int size = this.mCollaborations.size();
        if (this.mCollaborations.fullSize() != null) {
            size = this.mCollaborations.fullSize().intValue();
        }
        final int width = this.mInitialsListView.getWidth();
        final ArrayList<E> entries = this.mCollaborations.getEntries();
        clearInitialsView();
        this.mInitialsListView.post(new Runnable() { // from class: com.box.android.base.presentation.views.CollaboratorsInitialsView.2
            @Override // java.lang.Runnable
            public void run() {
                final View viewAddInitialsToList = CollaboratorsInitialsView.this.addInitialsToList(((BoxCollaboration) entries.get(0)).getAccessibleBy());
                viewAddInitialsToList.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.box.android.base.presentation.views.CollaboratorsInitialsView.2.1
                    private boolean initialsAdded = false;

                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        int i;
                        if (!viewAddInitialsToList.isShown() || this.initialsAdded) {
                            return;
                        }
                        this.initialsAdded = true;
                        int width2 = width / viewAddInitialsToList.getWidth();
                        for (int i2 = 1; i2 < width2 && i2 < entries.size(); i2++) {
                            View viewAddInitialsToList2 = CollaboratorsInitialsView.this.addInitialsToList(((BoxCollaboration) entries.get(i2)).getAccessibleBy());
                            if (i2 == width2 - 1 && (i = size - width2) > 0) {
                                BoxAvatarView boxAvatarView = (BoxAvatarView) viewAddInitialsToList2.findViewById(R.id.collaborator_initials);
                                JsonObject jsonObject = new JsonObject();
                                jsonObject.set("name", Integer.toString(i + 1));
                                boxAvatarView.loadUser(new BoxUser(jsonObject), (Serializable) CollaboratorsInitialsView.this.mController.getAvatarController());
                            }
                        }
                    }
                });
            }
        });
    }

    private void clearInitialsView() {
        this.mInitialsListView.removeAllViewsInLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View addInitialsToList(BoxCollaborator boxCollaborator) {
        View viewInflate = LayoutInflater.from((Activity) getContext()).inflate(R.layout.view_initials, (ViewGroup) null);
        BoxAvatarView boxAvatarView = (BoxAvatarView) viewInflate.findViewById(R.id.collaborator_initials);
        if (boxCollaborator == null) {
            boxAvatarView.loadUser(this.mUnknownCollaborator, (Serializable) this.mController.getAvatarController());
        } else {
            boxAvatarView.loadUser(boxCollaborator, (Serializable) this.mController.getAvatarController());
        }
        this.mInitialsListView.addView(viewInflate);
        return viewInflate;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putSerializable("CollaboratorsInitialsView.ExtraCollaborators", this.mBoxResponse);
        bundle.putParcelable("CollaboratorsInitialsView.ExtraSaveState", parcelableOnSaveInstanceState);
        return bundle;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.mBoxResponse = (BoxResponse) bundle.getSerializable("CollaboratorsInitialsView.ExtraCollaborators");
            super.onRestoreInstanceState(bundle.getParcelable("CollaboratorsInitialsView.ExtraSaveState"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        fetchCollaborations();
    }

    public void setShowCollaboratorsListener(ShowCollaboratorsListener showCollaboratorsListener) {
        this.mShowCollaboratorsListener = showCollaboratorsListener;
        this.mInitialsListViewSection.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.base.presentation.views.CollaboratorsInitialsView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CollaboratorsInitialsView.this.mShowCollaboratorsListener != null) {
                    CollaboratorsInitialsView.this.mShowCollaboratorsListener.onShowCollaborators(CollaboratorsInitialsView.this.mCollaborations);
                }
            }
        });
    }
}
