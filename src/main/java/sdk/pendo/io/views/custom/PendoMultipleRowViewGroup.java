package sdk.pendo.io.views.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.microsoft.intune.mam.client.view.MAMViewGroup;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0010\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0002J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\tH\u0002J\u0010\u0010#\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tH\u0002J\b\u0010$\u001a\u00020\u001eH\u0002J\b\u0010%\u001a\u00020\tH\u0002J\b\u0010&\u001a\u00020\tH\u0002J0\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\tH\u0014J\u0018\u0010-\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0014R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019¨\u0006."}, d2 = {"Lsdk/pendo/io/views/custom/PendoMultipleRowViewGroup;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "childState", "isSingleRow", "", "()Z", "setSingleRow", "(Z)V", "maxChildHeight", "maxChildWidth", "numberOfChildrenInRow", "numberOfRows", "paddingBetween", "getPaddingBetween", "()I", "setPaddingBetween", "(I)V", "paddingLines", "getPaddingLines", "setPaddingLines", "calculateMaxChildWidthAndHeight", "", "widthMeasureSpec", "heightMeasureSpec", "calculateNumberOfChildesInRow", "availableLayoutWidth", "getAvailableLayoutWidth", "init", "measureLayoutHeightDependOnNumberRows", "measureLayoutWidthDependOnNumberOfChildrenInRow", "onLayout", "changed", CmcdData.STREAM_TYPE_LIVE, "t", "r", "b", "onMeasure", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class PendoMultipleRowViewGroup extends MAMViewGroup {
    private int childState;
    private boolean isSingleRow;
    private int maxChildHeight;
    private int maxChildWidth;
    private int numberOfChildrenInRow;
    private int numberOfRows;
    private int paddingBetween;
    private int paddingLines;

    public PendoMultipleRowViewGroup(Context context) {
        super(context);
        this.numberOfRows = 1;
        this.paddingBetween = 70;
        this.paddingLines = 30;
        init();
    }

    private final void calculateMaxChildWidthAndHeight(int widthMeasureSpec, int heightMeasureSpec) {
        this.maxChildHeight = 0;
        this.maxChildWidth = 0;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, widthMeasureSpec, heightMeasureSpec);
                if (this.maxChildWidth < childAt.getMeasuredWidth()) {
                    this.maxChildWidth = childAt.getMeasuredWidth();
                }
                if (this.maxChildHeight < childAt.getMeasuredHeight()) {
                    this.maxChildHeight = childAt.getMeasuredHeight();
                }
                this.childState = View.combineMeasuredStates(this.childState, childAt.getMeasuredState());
            }
        }
    }

    private final void calculateNumberOfChildesInRow(int availableLayoutWidth) {
        int i = this.paddingBetween;
        int iCeil = (availableLayoutWidth + i) / (this.maxChildWidth + i);
        if (this.isSingleRow) {
            this.numberOfRows = 1;
        } else {
            this.numberOfRows = (int) Math.ceil(((double) getChildCount()) / ((double) iCeil));
            iCeil = (int) Math.ceil(((double) getChildCount()) / ((double) this.numberOfRows));
        }
        this.numberOfChildrenInRow = iCeil;
    }

    private final int getAvailableLayoutWidth(int widthMeasureSpec) {
        return (View.MeasureSpec.getSize(widthMeasureSpec) - getPaddingLeft()) - getPaddingRight();
    }

    private final void init() {
    }

    private final int measureLayoutHeightDependOnNumberRows() {
        return RangesKt.coerceAtLeast((this.numberOfRows * this.maxChildHeight) + getPaddingTop() + getPaddingBottom() + ((this.numberOfRows - 1) * this.paddingLines), getSuggestedMinimumHeight());
    }

    private final int measureLayoutWidthDependOnNumberOfChildrenInRow() {
        int i = this.maxChildWidth;
        int i2 = this.paddingBetween;
        return RangesKt.coerceAtLeast((((i + i2) * this.numberOfChildrenInRow) - i2) + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth());
    }

    public final int getPaddingBetween() {
        return this.paddingBetween;
    }

    public final int getPaddingLines() {
        return this.paddingLines;
    }

    /* JADX INFO: renamed from: isSingleRow, reason: from getter */
    public final boolean getIsSingleRow() {
        return this.isSingleRow;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (getChildCount() > 0) {
            int childCount = getChildCount();
            int measuredWidth = getMeasuredWidth() / 2;
            int i = this.numberOfRows;
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = this.numberOfChildrenInRow;
                if (i3 > childCount) {
                    i3 = childCount;
                }
                int paddingTop = getPaddingTop() + (this.maxChildHeight * i2) + (this.paddingLines * i2);
                int i4 = measuredWidth - (((this.maxChildWidth * i3) + ((i3 - 1) * this.paddingBetween)) / 2);
                int i5 = this.numberOfChildrenInRow * i2;
                int i6 = i3 + i5;
                while (i5 < i6) {
                    getChildAt(i5).layout(i4, paddingTop, this.maxChildWidth + i4, this.maxChildHeight + paddingTop);
                    i4 += this.maxChildWidth + this.paddingBetween;
                    i5++;
                }
                childCount -= this.numberOfChildrenInRow;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int availableLayoutWidth = getAvailableLayoutWidth(widthMeasureSpec);
        calculateMaxChildWidthAndHeight(widthMeasureSpec, heightMeasureSpec);
        calculateNumberOfChildesInRow(availableLayoutWidth);
        setMeasuredDimension(View.resolveSizeAndState(measureLayoutWidthDependOnNumberOfChildrenInRow(), widthMeasureSpec, this.childState), View.resolveSizeAndState(measureLayoutHeightDependOnNumberRows(), heightMeasureSpec, this.childState << 16));
    }

    public final void setPaddingBetween(int i) {
        this.paddingBetween = i;
    }

    public final void setPaddingLines(int i) {
        this.paddingLines = i;
    }

    public final void setSingleRow(boolean z) {
        this.isSingleRow = z;
    }

    public PendoMultipleRowViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.numberOfRows = 1;
        this.paddingBetween = 70;
        this.paddingLines = 30;
        init();
    }

    public PendoMultipleRowViewGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.numberOfRows = 1;
        this.paddingBetween = 70;
        this.paddingLines = 30;
        init();
    }
}
