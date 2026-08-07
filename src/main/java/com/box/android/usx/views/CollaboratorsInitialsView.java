package com.box.android.usx.views;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.box.android.R;
import com.box.android.usx.fragments.UsxFragment;
import com.box.android.vm.CollaboratorsInitialsVM;
import com.box.android.vm.PresenterData;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxCollaboration;
import com.box.androidsdk.content.models.BoxCollaborationItem;
import com.box.androidsdk.content.models.BoxCollaborator;
import com.box.androidsdk.content.models.BoxIteratorCollaborations;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.utils.SdkUtils;
import com.box.androidsdk.content.views.BoxAvatarView;
import com.eclipsesource.json.JsonObject;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes13.dex */
public class CollaboratorsInitialsView extends LinearLayout {
    public static final String EXTRA_COLLABORATORS = "CollaboratorsInitialsView.ExtraCollaborators";
    public static final String EXTRA_SAVED_STATE = "CollaboratorsInitialsView.ExtraSaveState";
    protected BoxIteratorCollaborations mCollaborations;
    private CollaboratorsInitialsVM mCollaboratorsInitialsVM;
    private TextView mCollabsCount;
    private LinearLayout mInitialsListView;
    private ProgressBar mProgressBar;
    private UsxFragment.RefreshUserRole mRefreshUserRole;
    private BoxCollaborator mUnknownCollaborator;
    private Observer<PresenterData<BoxIteratorCollaborations>> onCollaborationsChange;

    public CollaboratorsInitialsView(Context context) {
        this(context, null);
    }

    public CollaboratorsInitialsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CollaboratorsInitialsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.onCollaborationsChange = new Observer() { // from class: com.box.android.usx.views.CollaboratorsInitialsView$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$new$0((PresenterData) obj);
            }
        };
        init();
    }

    public void setArguments(CollaboratorsInitialsVM collaboratorsInitialsVM, UsxFragment.RefreshUserRole refreshUserRole) {
        this.mCollaboratorsInitialsVM = collaboratorsInitialsVM;
        collaboratorsInitialsVM.getCollaborations().observe((LifecycleOwner) getContext(), this.onCollaborationsChange);
        this.mRefreshUserRole = refreshUserRole;
    }

    private void init() {
        inflate(getContext(), R.layout.usx_view_collaborators_initial, this);
        this.mInitialsListView = (LinearLayout) findViewById(R.id.invite_collaborator_initials_list);
        this.mProgressBar = (ProgressBar) findViewById(R.id.box_sharesdk_activity_progress_bar);
        this.mCollabsCount = (TextView) findViewById(R.id.collabsCount);
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("name", "");
        this.mUnknownCollaborator = new BoxUser(jsonObject);
    }

    protected BoxCollaborationItem getCollaborationItem() {
        return (BoxCollaborationItem) this.mCollaboratorsInitialsVM.getShareItem();
    }

    public final String getString(int i) {
        return getResources().getString(i);
    }

    public void fetchCollaborations() {
        if (this.mCollaboratorsInitialsVM == null) {
            return;
        }
        if (getCollaborationItem() == null || SdkUtils.isBlank(getCollaborationItem().getUserId())) {
            showToast(getContext(), getString(R.string.box_sharesdk_cannot_view_collaborations));
            return;
        }
        this.mProgressBar.setVisibility(0);
        this.mCollabsCount.setVisibility(8);
        this.mInitialsListView.setVisibility(8);
        this.mCollaboratorsInitialsVM.fetchCollaborations(getCollaborationItem());
    }

    public void refreshView() {
        fetchCollaborations();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(PresenterData presenterData) {
        if (!presenterData.isHandled()) {
            if (presenterData.isSuccess()) {
                updateView((BoxIteratorCollaborations) presenterData.getData());
            } else {
                if (presenterData.getStrCode() != -1) {
                    showToast(getContext(), getString(presenterData.getStrCode()));
                }
                if ((presenterData.getException() instanceof BoxException) && ((BoxException) presenterData.getException()).getResponseCode() == 404) {
                    ((Activity) getContext()).finish();
                }
                PresenterData<BoxIteratorCollaborations> value = this.mCollaboratorsInitialsVM.getCollaborations().getValue();
                if (value != null) {
                    updateView(value.getData());
                }
            }
        } else {
            PresenterData<BoxIteratorCollaborations> value2 = this.mCollaboratorsInitialsVM.getCollaborations().getValue();
            if (value2 != null) {
                updateView(value2.getData());
            } else {
                updateView(null);
            }
        }
        UsxFragment.RefreshUserRole refreshUserRole = this.mRefreshUserRole;
        if (refreshUserRole != null) {
            refreshUserRole.refresh();
        }
    }

    private void updateViewVisibilityForNoCollaborators() {
        this.mInitialsListView.setVisibility(8);
        this.mCollabsCount.setVisibility(0);
        this.mCollabsCount.setText(R.string.box_sharesdk_no_collaborators_initials);
    }

    private void updateViewVisibilityIfCollaboratorsFound() {
        this.mInitialsListView.setVisibility(0);
        this.mCollabsCount.setVisibility(0);
    }

    private void updateView(BoxIteratorCollaborations boxIteratorCollaborations) {
        this.mProgressBar.setVisibility(8);
        this.mCollaborations = boxIteratorCollaborations;
        if (boxIteratorCollaborations == null || boxIteratorCollaborations.size() == 0) {
            updateViewVisibilityForNoCollaborators();
            return;
        }
        updateViewVisibilityIfCollaboratorsFound();
        int size = this.mCollaborations.size();
        if (this.mCollaborations.fullSize() != null) {
            size = this.mCollaborations.fullSize().intValue();
        }
        ArrayList<E> entries = this.mCollaborations.getEntries();
        clearInitialsView();
        int i = 0;
        for (int i2 = 0; i2 < size && i < 6; i2++) {
            BoxCollaborator accessibleBy = ((BoxCollaboration) entries.get(i2)).getAccessibleBy();
            if (accessibleBy != null) {
                addInitialsToList(accessibleBy);
                i++;
            }
        }
        if (i < size) {
            int i3 = size - i;
            if (i < 6) {
                addInitialsToList(null);
            } else {
                i3++;
            }
            int childCount = this.mInitialsListView.getChildCount();
            if (childCount > 0) {
                BoxAvatarView boxAvatarView = (BoxAvatarView) this.mInitialsListView.getChildAt(childCount - 1).findViewById(R.id.collaborator_initials);
                JsonObject jsonObject = new JsonObject();
                jsonObject.set("name", Integer.toString(i3));
                jsonObject.set("id", "collab_initials_number_user");
                boxAvatarView.loadUser(new BoxUser(jsonObject), (Serializable) this.mCollaboratorsInitialsVM.getAvatarController());
            }
        }
        this.mCollabsCount.setText(getResources().getQuantityString(R.plurals.box_sharesdk_collaborators_count_plurals, size, Integer.valueOf(size)));
    }

    private void clearInitialsView() {
        this.mInitialsListView.removeAllViewsInLayout();
    }

    private void addInitialsToList(BoxCollaborator boxCollaborator) {
        View viewInflate = LayoutInflater.from((Activity) getContext()).inflate(R.layout.usx_view_initials, (ViewGroup) null);
        BoxAvatarView boxAvatarView = (BoxAvatarView) viewInflate.findViewById(R.id.collaborator_initials);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = (int) getResources().getDimension(R.dimen.box_sharesdk_initials_offset);
        viewInflate.setLayoutParams(layoutParams);
        if (boxCollaborator == null) {
            boxAvatarView.loadUser(this.mUnknownCollaborator, (Serializable) this.mCollaboratorsInitialsVM.getAvatarController());
        } else {
            boxAvatarView.loadUser(boxCollaborator, (Serializable) this.mCollaboratorsInitialsVM.getAvatarController());
        }
        this.mInitialsListView.addView(viewInflate);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        CollaboratorsInitialsVM collaboratorsInitialsVM = this.mCollaboratorsInitialsVM;
        if (collaboratorsInitialsVM == null || collaboratorsInitialsVM.getCollaborations().getValue() != null) {
            return;
        }
        fetchCollaborations();
    }

    private void showToast(Context context, String str) {
        Toast.makeText(context, str, 0).show();
    }
}
