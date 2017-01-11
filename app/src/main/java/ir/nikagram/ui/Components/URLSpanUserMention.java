
package ir.nikagram.ui.Components;

import android.text.TextPaint;

import ir.nikagram.ui.ActionBar.Theme;

public class URLSpanUserMention extends URLSpanNoUnderline {

    public URLSpanUserMention(String url) {
        super(url);
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        super.updateDrawState(ds);
        ds.setColor(Theme.MSG_LINK_TEXT_COLOR);
        ds.setUnderlineText(false);
    }
}
