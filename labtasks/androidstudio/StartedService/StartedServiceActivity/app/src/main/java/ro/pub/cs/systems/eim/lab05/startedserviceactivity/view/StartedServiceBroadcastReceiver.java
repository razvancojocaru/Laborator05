package ro.pub.cs.systems.eim.lab05.startedserviceactivity.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

import java.util.ArrayList;

import ro.pub.cs.systems.eim.lab05.startedserviceactivity.general.Constants;

public class StartedServiceBroadcastReceiver extends BroadcastReceiver {

    private TextView messageTextView;

    // TODO: exercise 8 - default constructor

    public StartedServiceBroadcastReceiver(TextView messageTextView) {
        this.messageTextView = messageTextView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        String data_str;
        int data_int;
        ArrayList<String> data_arr = null;
        if (Constants.ACTION_STRING.equals(action)) {
            data_str = intent.getStringExtra(Constants.DATA);
            if (messageTextView != null) {
                messageTextView.setText(messageTextView.getText().toString() + "\n" + data_str);
            }
        } else if (Constants.ACTION_INTEGER.equals(action)) {
            data_int = intent.getIntExtra(Constants.DATA, 0);
            if (messageTextView != null) {
                messageTextView.setText(messageTextView.getText().toString() + "\n" + data_int);
            }
        } else if (Constants.ACTION_ARRAY_LIST.equals(action)) {
            data_arr = intent.getStringArrayListExtra(Constants.DATA);
            if (messageTextView != null) {
                messageTextView.setText(messageTextView.getText().toString() + "\n" + data_arr);
            }
        }
        // TODO: exercise 6 - get the action and the extra information from the intent
        // and set the text on the messageTextView

        // TODO: exercise 8 - restart the activity through an intent
        // if the messageTextView is not available
    }

}
