package com.pspdfkit.ui.note;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import androidx.core.content.ContextCompat;
import com.pspdfkit.R;

/* JADX INFO: loaded from: classes3.dex */
public class AnnotationNoteHinterThemeConfiguration {
    private static final boolean DEFAULT_USE_NOTE_HINTER_INTRINSIC_SIZE = false;
    public int instantCommentHinterDrawable;
    public final boolean intrinsicSize;
    public final int noteHinterAlpha;
    public final int noteHinterColor;
    public int noteHinterDrawable;
    public final int noteHinterHeight;
    public final int noteHinterWidth;
    public final int noteMarkupTextLeftPadding;

    public AnnotationNoteHinterThemeConfiguration(Context context) {
        Resources resources = context.getResources();
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R.styleable.pspdf__AnnotationNoteHinter, R.attr.pspdf__annotationNoteHinterStyle, R.style.PSPDFKit_AnnotationNoteHinter);
        this.intrinsicSize = typedArrayObtainStyledAttributes.getBoolean(R.styleable.pspdf__AnnotationNoteHinter_pspdf__useNoteHinterIntrinsicSize, false);
        this.noteHinterWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.pspdf__AnnotationNoteHinter_pspdf__noteHinterWidth, resources.getDimensionPixelSize(R.dimen.pspdf__annotation_note_hinter_width));
        this.noteHinterHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.pspdf__AnnotationNoteHinter_pspdf__noteHinterHeight, resources.getDimensionPixelSize(R.dimen.pspdf__annotation_note_hinter_height));
        this.noteHinterColor = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__AnnotationNoteHinter_pspdf__noteHinterColor, ContextCompat.getColor(context, R.color.pspdf__errorContainerDark));
        this.noteHinterAlpha = typedArrayObtainStyledAttributes.getInteger(R.styleable.pspdf__AnnotationNoteHinter_pspdf__noteHinterAlpha, resources.getInteger(R.integer.pspdf__annotation_note_hinter_alpha));
        this.noteMarkupTextLeftPadding = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.pspdf__AnnotationNoteHinter_pspdf__noteHinterTextMarkupLeftPadding, resources.getDimensionPixelSize(R.dimen.pspdf__annotation_note_hinter_text_markup_left_padding));
        this.noteHinterDrawable = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__AnnotationNoteHinter_pspdf__noteHinterIcon, R.drawable.pspdf__ic_replies);
        this.instantCommentHinterDrawable = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__AnnotationNoteHinter_pspdf__noteHinterInstantCommentIcon, R.drawable.pspdf__ic_instant_comment);
        typedArrayObtainStyledAttributes.recycle();
    }
}
