
package ir.nikagram.ui.Cells;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import ir.nikagram.messenger.AndroidUtilities;
import ir.nikagram.messenger.LocaleController;
import ir.nikagram.messenger.R;
import ir.nikagram.tgnet.TLRPC;
import ir.nikagram.ui.ActionBar.SimpleTextView;
import ir.nikagram.ui.Components.AvatarDrawable;
import ir.nikagram.ui.Components.BackupImageView;
import ir.nikagram.ui.Components.LayoutHelper;

public class AdminedChannelCell extends FrameLayout {

    private BackupImageView avatarImageView;
    private SimpleTextView nameTextView;
    private SimpleTextView statusTextView;
    private AvatarDrawable avatarDrawable;
    private TLRPC.Chat currentChannel;
    private boolean isLast;

    public AdminedChannelCell(Context context, View.OnClickListener onClickListener) {
        super(context);

        setBackgroundResource(R.drawable.list_selector_white);

        avatarDrawable = new AvatarDrawable();

        avatarImageView = new BackupImageView(context);
        avatarImageView.setRoundRadius(AndroidUtilities.dp(24));
        addView(avatarImageView, LayoutHelper.createFrame(48, 48, (LocaleController.isRTL ? Gravity.RIGHT : Gravity.LEFT) | Gravity.TOP, LocaleController.isRTL ? 0 : 12, 12, LocaleController.isRTL ? 12 : 0, 0));

        nameTextView = new SimpleTextView(context);
        nameTextView.setTextColor(0xff212121);
        nameTextView.setTextSize(17);
        nameTextView.setGravity((LocaleController.isRTL ? Gravity.RIGHT : Gravity.LEFT) | Gravity.TOP);
        addView(nameTextView, LayoutHelper.createFrame(LayoutHelper.MATCH_PARENT, 20, (LocaleController.isRTL ? Gravity.RIGHT : Gravity.LEFT) | Gravity.TOP, LocaleController.isRTL ? 62 : 73, 15.5f, LocaleController.isRTL ? 73 : 62, 0));

        statusTextView = new SimpleTextView(context);
        statusTextView.setTextSize(14);
        statusTextView.setTextColor(0xffa8a8a8);
        statusTextView.setGravity((LocaleController.isRTL ? Gravity.RIGHT : Gravity.LEFT) | Gravity.TOP);
        addView(statusTextView, LayoutHelper.createFrame(LayoutHelper.MATCH_PARENT, 20, (LocaleController.isRTL ? Gravity.RIGHT : Gravity.LEFT) | Gravity.TOP, LocaleController.isRTL ? 62 : 73, 38.5f, LocaleController.isRTL ? 73 : 62, 0));

        ImageView deleteButton = new ImageView(context);
        deleteButton.setScaleType(ImageView.ScaleType.CENTER);
        deleteButton.setImageResource(R.drawable.delete_reply);
        deleteButton.setOnClickListener(onClickListener);
        addView(deleteButton, LayoutHelper.createFrame(48, 48, (LocaleController.isRTL ? Gravity.LEFT : Gravity.RIGHT) | Gravity.TOP, LocaleController.isRTL ? 7 : 0, 12, LocaleController.isRTL ? 0 : 7, 0));
    }

    public void setChannel(TLRPC.Chat channel, boolean last) {
        TLRPC.FileLocation photo = null;
        if (channel.photo != null) {
            photo = channel.photo.photo_small;
        }
        final String url = "telegram.me/";
        currentChannel = channel;
        avatarDrawable.setInfo(channel);
        nameTextView.setText(channel.title);
        SpannableStringBuilder stringBuilder = new SpannableStringBuilder(url + channel.username);
        stringBuilder.setSpan(new ForegroundColorSpan(0xff51C03B), url.length(), stringBuilder.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        statusTextView.setText(stringBuilder);
        avatarImageView.setImage(photo, "50_50", avatarDrawable);
        isLast = last;
    }

    public TLRPC.Chat getCurrentChannel() {
        return currentChannel;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(60 + (isLast ? 12 : 0)), MeasureSpec.EXACTLY));
    }

    @Override
    public boolean hasOverlappingRendering() {
        return false;
    }
}
