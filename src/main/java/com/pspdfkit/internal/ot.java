package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.internal.view.SupportMenu;
import com.pspdfkit.R;

/* JADX INFO: loaded from: classes3.dex */
public final class ot {
    public final int A;
    public final int B;
    public final int C;
    public final int D;
    public final int E;
    public final int F;
    public final int G;
    public final int H;
    public final int I;
    public final int J;
    public final int K;
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public final int o;
    public final int p;
    public final int q;
    public final int r;
    public final int s;
    public final int t;
    public final Typeface u;
    public final Typeface v;
    public final Typeface w;
    public final int x;
    public final int y;
    public final int z;

    public ot(Context context) {
        Typeface font;
        Typeface font2;
        Typeface font3;
        context.getClass();
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R.styleable.pspdf__OutlineView, R.attr.pspdf__outlineViewStyle, R.style.PSPDFKit_OutlineView);
        typedArrayObtainStyledAttributes.getClass();
        this.a = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__OutlineView_pspdf__backgroundColor, ContextCompat.getColor(context, R.color.pspdf__onPrimaryLight));
        this.b = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__OutlineView_pspdf__listItemSelector, 0);
        this.c = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__OutlineView_pspdf__defaultTextColor, ContextCompat.getColor(context, R.color.pspdf__onBackgroundLight));
        this.d = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__OutlineView_pspdf__bookmarksBarBackgroundColor, ContextCompat.getColor(context, R.color.pspdf__onPrimaryLight));
        this.e = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__OutlineView_pspdf__bookmarksBarIconColor, ContextCompat.getColor(context, R.color.pspdf__onBackgroundLight));
        this.f = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__OutlineView_pspdf__bookmarksCurrentPageColor, ContextCompat.getColor(context, R.color.pspdf__primaryLight));
        this.g = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__OutlineView_pspdf__bookmarksAddIcon, R.drawable.pspdf__ic_add);
        this.h = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__OutlineView_pspdf__bookmarksEditIcon, R.drawable.pspdf__ic_edit);
        this.i = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__OutlineView_pspdf__bookmarksDoneIcon, R.drawable.pspdf__ic_done);
        this.j = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__OutlineView_pspdf__bookmarksGroupIndicatorIconColor, ContextCompat.getColor(context, R.color.pspdf__onBackgroundLight));
        this.k = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__OutlineView_pspdf__bookmarksDeleteIcon, R.drawable.pspdf__ic_delete);
        typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__OutlineView_pspdf__bookmarksDeleteIconColor, -1);
        this.l = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__OutlineView_pspdf__bookmarksDeleteBackgroundColor, SupportMenu.CATEGORY_MASK);
        this.m = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__OutlineView_pspdf__bookmarksDragHandleIcon, R.drawable.pspdf__ic_drag_handle);
        typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__OutlineView_pspdf__bookmarksDragHandleIconColor, ContextCompat.getColor(context, R.color.pspdf__onBackgroundLight));
        this.n = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__OutlineView_pspdf__annotationsBarBackgroundColor, ContextCompat.getColor(context, R.color.pspdf__onPrimaryLight));
        this.o = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__OutlineView_pspdf__annotationsBarIconColor, ContextCompat.getColor(context, R.color.pspdf__onBackgroundLight));
        this.q = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__OutlineView_pspdf__annotationsEditIcon, R.drawable.pspdf__ic_edit);
        this.r = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__OutlineView_pspdf__annotationsDoneIcon, R.drawable.pspdf__ic_done);
        this.p = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__OutlineView_pspdf__annotationsDeleteIcon, R.drawable.pspdf__ic_delete);
        typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__OutlineView_pspdf__annotationsDeleteIconColor, ContextCompat.getColor(context, R.color.pspdf__onBackgroundLight));
        this.s = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__OutlineView_pspdf__annotationsDragHandleIcon, R.drawable.pspdf__ic_drag_handle);
        this.t = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__OutlineView_pspdf__annotationsDragHandleIconColor, ContextCompat.getColor(context, R.color.pspdf__onBackgroundLight));
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__OutlineView_pspdf__outlineViewLabelFont, 0);
        if (resourceId == 0 || (font = ResourcesCompat.getFont(context, resourceId)) == null) {
            font = Typeface.DEFAULT;
        }
        font.getClass();
        this.u = font;
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__OutlineView_pspdf__outlineViewTitleFont, 0);
        if (resourceId2 == 0 || (font2 = ResourcesCompat.getFont(context, resourceId2)) == null) {
            font2 = Typeface.DEFAULT;
        }
        font2.getClass();
        this.v = font2;
        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__OutlineView_pspdf__outlineViewBodyFont, 0);
        if (resourceId3 == 0 || (font3 = ResourcesCompat.getFont(context, resourceId3)) == null) {
            font3 = Typeface.DEFAULT;
        }
        font3.getClass();
        this.w = font3;
        this.x = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__OutlineView_pspdf__navigationTabOutlineIcon, R.drawable.pspdf__ic_outline_view_outline);
        this.y = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__OutlineView_pspdf__navigationTabBookmarksIcon, R.drawable.pspdf__ic_outline_view_bookmarks);
        this.z = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__OutlineView_pspdf__navigationTabAnnotationsIcon, R.drawable.pspdf__ic_outline_view_annotations);
        this.A = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__OutlineView_pspdf__navigationTabEmbeddedFilesIcon, R.drawable.pspdf__file_icon_paperclip);
        this.B = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__OutlineView_pspdf__navigationTabDocumentInfoIcon, R.drawable.pspdf__ic_outline_view_information);
        this.C = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__OutlineView_pspdf__navigationTabIconsColor, ContextCompat.getColor(context, R.color.pspdf__outlineVariantLight));
        this.D = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__OutlineView_pspdf__navigationTabIconsColorSelected, ContextCompat.getColor(context, R.color.pspdf__primaryLight));
        this.E = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__OutlineView_pspdf__navigationTabBackgroundColor, ContextCompat.getColor(context, R.color.pspdf__onPrimaryLight));
        typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__OutlineView_pspdf__documentInfoGroupTitleTextColor, ContextCompat.getColor(context, R.color.pspdf__document_info_group_title_text_color));
        typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__OutlineView_pspdf__documentInfoItemTitleTextColor, ContextCompat.getColor(context, R.color.pspdf__document_info_item_title_text_color));
        typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__OutlineView_pspdf__documentInfoItemValueTextColor, ContextCompat.getColor(context, R.color.pspdf__document_info_item_value_text_color));
        typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__OutlineView_pspdf__documentInfoItemValueHintTextColor, ContextCompat.getColor(context, R.color.pspdf__document_info_item_value_hint_text_color));
        typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__OutlineView_pspdf__documentInfoGroupIconColor, ContextCompat.getColor(context, R.color.pspdf__outlineVariantLight));
        this.F = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__OutlineView_pspdf__documentInfoContentIcon, R.drawable.pspdf__ic_outline);
        this.G = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__OutlineView_pspdf__documentInfoChangesIcon, R.drawable.pspdf__ic_info);
        this.H = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__OutlineView_pspdf__documentInfoSizeIcon, R.drawable.pspdf__ic_size);
        typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__OutlineView_pspdf__documentInfoFabBackgroundColor, ContextCompat.getColor(context, R.color.pspdf__primaryLight));
        typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__OutlineView_pspdf__documentInfoFabIconColor, ContextCompat.getColor(context, R.color.pspdf__onPrimaryLight));
        this.I = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__OutlineView_pspdf__documentInfoFabEditIcon, R.drawable.pspdf__ic_edit);
        this.J = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__OutlineView_pspdf__documentInfoFabDoneIcon, R.drawable.pspdf__ic_check);
        this.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.pspdf__OutlineView_pspdf__width, -1);
        typedArrayObtainStyledAttributes.recycle();
    }
}
