package serifenuruysal.com.uicomponents.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import serifenuruysal.com.uicomponents.R;

/**
 * Created by serifenuruysal on 16/06/17.
 */

public class FirstFragment extends Fragment {

    private TextView tvCaptcha,etShowView;
    private EditText etInput;
    private Button btn;
    private CoordinatorLayout coordinatorLayot;
    public static final String EXTRA_MESSAGE="extra_message";


    public static final FirstFragment newInstance(String param) {
        FirstFragment f = new FirstFragment();
        Bundle localBundle = new Bundle();
        localBundle.putString(EXTRA_MESSAGE, param);
        f.setArguments(localBundle);
        return f;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        tvCaptcha=(TextView) view.findViewById(R.id.textView);
        etInput=(EditText) view.findViewById(R.id.etInput);
        etShowView=(TextView) view.findViewById(R.id.textView2);
        btn=(Button) view.findViewById(R.id.button);
        coordinatorLayot=(CoordinatorLayout)view.findViewById(R.id.coordinatorLayout);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input= etInput.getText().toString();
                String captcha=tvCaptcha.getText().toString();

                etShowView.setVisibility(View.VISIBLE);
                if (input.equals(captcha)){
                    etShowView.setText(getArguments().getString(EXTRA_MESSAGE));

                }else{

               etShowView.setText("Yanlış Kelime Girdiniz");
                }
            }
        });

        return view;


    }

}
