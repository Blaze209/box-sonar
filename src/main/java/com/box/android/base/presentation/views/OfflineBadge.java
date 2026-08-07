package com.box.android.base.presentation.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.box.android.base.R;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.models.BoxModelOfflineManager;

/* JADX INFO: loaded from: classes9.dex */
public class OfflineBadge extends View {
    private BoxModelOfflineManager.State mState;
    private static final int[] STATE_OFFLINE = {R.attr.state_offlined};
    private static final int[] STATE_OFFLINING = {R.attr.state_offlining};
    private static final int[] STATE_OUT_OF_DATE = {R.attr.state_outofdate};
    private static final int[] STATE_CACHED = {R.attr.state_cached};

    public OfflineBadge(Context context) {
        super(context);
        this.mState = BoxModelOfflineManager.State.NONE;
    }

    public OfflineBadge(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = BoxModelOfflineManager.State.NONE;
        initStyles(context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.OfflineBadge, 0, 0));
    }

    public OfflineBadge(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = BoxModelOfflineManager.State.NONE;
        initStyles(context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.OfflineBadge, i, 0));
    }

    private void initStyles(TypedArray typedArray) {
        BoxModelOfflineManager.State state;
        setBackground(CommonBoxUtil.getDrawable(getContext(), R.drawable.offline_statelist_badge));
        try {
            if (typedArray.getBoolean(R.styleable.OfflineBadge_state_offlined, false)) {
                state = BoxModelOfflineManager.State.OFFLINE;
            } else if (typedArray.getBoolean(R.styleable.OfflineBadge_state_offlining, false)) {
                state = BoxModelOfflineManager.State.OFFLINE_PENDING;
            } else if (typedArray.getBoolean(R.styleable.OfflineBadge_state_outofdate, false)) {
                state = BoxModelOfflineManager.State.OUT_OF_DATE;
            } else {
                state = typedArray.getBoolean(R.styleable.OfflineBadge_state_cached, false) ? BoxModelOfflineManager.State.CACHED : BoxModelOfflineManager.State.NONE;
            }
            setState(state);
        } finally {
            typedArray.recycle();
        }
    }

    @Override // android.view.View
    protected int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 3);
        if (this.mState != null) {
            int i2 = AnonymousClass1.$SwitchMap$com$box$android$coreservices$models$BoxModelOfflineManager$State[this.mState.ordinal()];
            if (i2 == 1) {
                mergeDrawableStates(iArrOnCreateDrawableState, STATE_OFFLINE);
            } else {
                if (i2 == 2) {
                    mergeDrawableStates(iArrOnCreateDrawableState, STATE_OFFLINING);
                    return iArrOnCreateDrawableState;
                }
                if (i2 == 3) {
                    mergeDrawableStates(iArrOnCreateDrawableState, STATE_OUT_OF_DATE);
                    return iArrOnCreateDrawableState;
                }
                if (i2 == 4) {
                    mergeDrawableStates(iArrOnCreateDrawableState, STATE_CACHED);
                    return iArrOnCreateDrawableState;
                }
            }
        }
        return iArrOnCreateDrawableState;
    }

    /* JADX INFO: renamed from: com.box.android.base.presentation.views.OfflineBadge$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$box$android$coreservices$models$BoxModelOfflineManager$State;

        static {
            int[] iArr = new int[BoxModelOfflineManager.State.values().length];
            $SwitchMap$com$box$android$coreservices$models$BoxModelOfflineManager$State = iArr;
            try {
                iArr[BoxModelOfflineManager.State.OFFLINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$models$BoxModelOfflineManager$State[BoxModelOfflineManager.State.OFFLINE_PENDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$models$BoxModelOfflineManager$State[BoxModelOfflineManager.State.OUT_OF_DATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$models$BoxModelOfflineManager$State[BoxModelOfflineManager.State.CACHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$box$android$coreservices$models$BoxModelOfflineManager$State[BoxModelOfflineManager.State.NONE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public void setState(BoxModelOfflineManager.State state) {
        this.mState = state;
        if (state == BoxModelOfflineManager.State.NONE) {
            setVisibility(8);
        } else {
            setVisibility(0);
            refreshDrawableState();
        }
    }
}
