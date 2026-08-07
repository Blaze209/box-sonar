package com.tokenautocomplete;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.base.presentation.components.commentbar.CommentBarInputBoxKt;
import com.pspdfkit.contentediting.models.serializer.ColorSerializer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class TagTokenizer implements Tokenizer {
    public static final Parcelable.Creator<TagTokenizer> CREATOR = new Parcelable.Creator<TagTokenizer>() { // from class: com.tokenautocomplete.TagTokenizer.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TagTokenizer createFromParcel(Parcel parcel) {
            return new TagTokenizer(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TagTokenizer[] newArray(int i) {
            return new TagTokenizer[i];
        }
    };
    private ArrayList<Character> tagPrefixes;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tokenautocomplete.Tokenizer
    public CharSequence wrapTokenValue(CharSequence charSequence) {
        return charSequence;
    }

    TagTokenizer() {
        this((List<Character>) Arrays.asList(Character.valueOf(CommentBarInputBoxKt.MENTION_SYMBOL), Character.valueOf(ColorSerializer.PREFIX)));
    }

    public TagTokenizer(List<Character> list) {
        this.tagPrefixes = new ArrayList<>(list);
    }

    protected boolean isTokenTerminator(char c) {
        return (Character.isLetterOrDigit(c) || c == '_') ? false : true;
    }

    @Override // com.tokenautocomplete.Tokenizer
    public boolean containsTokenTerminator(CharSequence charSequence) {
        for (int i = 0; i < charSequence.length(); i++) {
            if (isTokenTerminator(charSequence.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tokenautocomplete.Tokenizer
    public List<Range> findTokenRanges(CharSequence charSequence, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        if (i != i2) {
            int i3 = Integer.MAX_VALUE;
            while (i < i2) {
                char cCharAt = charSequence.charAt(i);
                if (isTokenTerminator(cCharAt)) {
                    if (i - 1 > i3) {
                        arrayList.add(new Range(i3, i));
                    }
                    i3 = Integer.MAX_VALUE;
                }
                if (this.tagPrefixes.contains(Character.valueOf(cCharAt))) {
                    i3 = i;
                }
                i++;
            }
            if (i2 > i3) {
                arrayList.add(new Range(i3, i2));
            }
        }
        return arrayList;
    }

    TagTokenizer(Parcel parcel) {
        this(parcel.readArrayList(Character.class.getClassLoader()));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.tagPrefixes);
    }
}
