
package ir.nikagram.ui;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import ir.nikagram.messenger.AndroidUtilities;
import ir.nikagram.messenger.ApplicationLoader;
import ir.nikagram.messenger.LocaleController;
import ir.nikagram.messenger.MessagesController;
import ir.nikagram.messenger.R;
import ir.nikagram.tgnet.ConnectionsManager;
import ir.nikagram.tgnet.RequestDelegate;
import ir.nikagram.tgnet.TLObject;
import ir.nikagram.tgnet.TLRPC;
import ir.nikagram.ui.ActionBar.ActionBar;
import ir.nikagram.ui.ActionBar.ActionBarMenu;
import ir.nikagram.ui.ActionBar.BaseFragment;
import ir.nikagram.ui.Components.LayoutHelper;

public class ReportOtherActivity extends BaseFragment {

    private EditText firstNameField;
    private View headerLabelView;
    private long dialog_id;
    private View doneButton;

    private final static int done_button = 1;

    public ReportOtherActivity(Bundle args) {
        super(args);
        dialog_id = getArguments().getLong("dialog_id", 0);
    }

    @Override
    public View createView(Context context) {
        actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        actionBar.setAllowOverlayTitle(true);
        actionBar.setTitle(LocaleController.getString("ReportChat", R.string.ReportChat));
        actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() {
            @Override
            public void onItemClick(int id) {
                if (id == -1) {
                    finishFragment();
                } else if (id == done_button) {
                    if (firstNameField.getText().length() != 0) {
                        TLRPC.TL_account_reportPeer req = new TLRPC.TL_account_reportPeer();
                        req.peer = MessagesController.getInputPeer((int) dialog_id);
                        req.reason = new TLRPC.TL_inputReportReasonOther();
                        req.reason.text = firstNameField.getText().toString();
                        ConnectionsManager.getInstance().sendRequest(req, new RequestDelegate() {
                            @Override
                            public void run(TLObject response, TLRPC.TL_error error) {

                            }
                        });
                        finishFragment();
                    }
                }
            }
        });

        ActionBarMenu menu = actionBar.createMenu();
        doneButton = menu.addItemWithWidth(done_button, R.drawable.ic_done, AndroidUtilities.dp(56));

        LinearLayout linearLayout = new LinearLayout(context);
        fragmentView = linearLayout;
        fragmentView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        ((LinearLayout) fragmentView).setOrientation(LinearLayout.VERTICAL);
        fragmentView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        firstNameField = new EditText(context);
        firstNameField.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
        firstNameField.setHintTextColor(0xff979797);
        firstNameField.setTextColor(0xff212121);
        firstNameField.setMaxLines(3);
        firstNameField.setPadding(0, 0, 0, 0);
        firstNameField.setGravity(LocaleController.isRTL ? Gravity.RIGHT : Gravity.LEFT);
        firstNameField.setInputType(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES | InputType.TYPE_TEXT_FLAG_MULTI_LINE | InputType.TYPE_TEXT_FLAG_AUTO_CORRECT);
        firstNameField.setImeOptions(EditorInfo.IME_ACTION_DONE);
        firstNameField.setGravity(LocaleController.isRTL ? Gravity.RIGHT : Gravity.LEFT);
        AndroidUtilities.clearCursorDrawable(firstNameField);
        firstNameField.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_DONE && doneButton != null) {
                    doneButton.performClick();
                    return true;
                }
                return false;
            }
        });

        linearLayout.addView(firstNameField, LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT, 36, 24, 24, 24, 0));
        firstNameField.setHint(LocaleController.getString("ReportChatDescription", R.string.ReportChatDescription));
        firstNameField.setSelection(firstNameField.length());

        return fragmentView;
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences preferences = ApplicationLoader.applicationContext.getSharedPreferences("mainconfig", Activity.MODE_PRIVATE);
        boolean animations = preferences.getBoolean("view_animations", true);
        if (!animations) {
            firstNameField.requestFocus();
            AndroidUtilities.showKeyboard(firstNameField);
        }
    }

    @Override
    public void onTransitionAnimationEnd(boolean isOpen, boolean backward) {
        if (isOpen) {
            AndroidUtilities.runOnUIThread(new Runnable() {
                @Override
                public void run() {
                    if (firstNameField != null) {
                        firstNameField.requestFocus();
                        AndroidUtilities.showKeyboard(firstNameField);
                    }
                }
            }, 100);
        }
    }
}
