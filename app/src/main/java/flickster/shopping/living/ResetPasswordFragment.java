package flickster.shopping.living;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.ActionCodeEmailInfo;
import com.google.firebase.auth.FirebaseAuth;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ResetPasswordFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResetPasswordFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ResetPasswordFragment() {
        // Required empty public constructor
    }

    private EditText registeredEmail;
    private Button resetPasswordBtn;
    private TextView goBack;
    private FrameLayout parentFrameLayout;
    private FirebaseAuth firebaseAuth;

    private ViewGroup emailIconContainer;
    private ImageView emailIcon;
    private TextView emailIconText;
    private ProgressBar progressBar;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ResetPasswordFragment.
     */

    public class ResetPasswordFragment extends Fragment {

        private OnFragmentInteractionListener mListener;

        private MaterialButton btnGoBack, btnResetPassword;
        private ProgressBar prgLinearSendEmail, prgSendEmail;
        private TextView tvSentEmailSuccessful;
        private EditText edtEmail;

        public ResetPasswordFragment() {
            // Required empty public constructor
        }

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment ResetPasswordFragment.
         */
        // TODO: Rename and change types and number of parameters
        public static ResetPasswordFragment newInstance() {
            return new ResetPasswordFragment();
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_reset_password, container, false);

            btnGoBack = view.findViewById(R.id.btn_go_back);
            btnResetPassword = view.findViewById(R.id.btn_reset_password);
            prgLinearSendEmail = view.findViewById(R.id.prg_linear_reset_password);
            prgSendEmail = view.findViewById(R.id.prg_reset_password);
            tvSentEmailSuccessful = view.findViewById(R.id.tv_sent_email_successful);
            edtEmail = view.findViewById(R.id.edt_email_forgot_password);

            return view;

        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            onTextChangeEdtEmail();

            btnGoBack.setOnClickListener(v -> mListener.onClickGoBack());
            btnResetPassword.setOnClickListener(v -> mListener.resetPassword(edtEmail.getText().toString()));

        }

        @Override
        public void onAttach(Context context) {
            super.onAttach(context);
            if (context instanceof OnFragmentInteractionListener) {
                mListener = (OnFragmentInteractionListener) context;
            } else {
                throw new RuntimeException(context.toString()
                        + " must implement OnFragmentInteractionListener");
            }
        }

        @Override
        public void onDetach() {
            super.onDetach();
            mListener = null;
        }

        /**
         * This interface must be implemented by activities that contain this
         * fragment to allow an interaction in this fragment to be communicated
         * to the activity and potentially other fragments contained in that
         * activity.
         * <p>
         * See the Android Training lesson <a href=
         * "http://developer.android.com/training/basics/fragments/communicating.html"
         * >Communicating with Other Fragments</a> for more information.
         */
        public interface OnFragmentInteractionListener {
            void onClickGoBack();
            void resetPassword(String email);
        }

        void onLoading() {

            btnResetPassword.setText("");
            prgLinearSendEmail.setProgress(50);
            prgSendEmail.setVisibility(View.VISIBLE);
            tvSentEmailSuccessful.setVisibility(View.INVISIBLE);

        }

        void onSentEmailSuccessful() {

            btnResetPassword.setText(getResources().getText(R.string.reset_password));
            prgLinearSendEmail.setProgress(100);
            prgSendEmail.setVisibility(View.GONE);
            tvSentEmailSuccessful.setVisibility(View.VISIBLE);

        }

        private void onTextChangeEdtEmail() {

            edtEmail.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    if (TextUtils.isEmpty(s) || s.toString().length() < 6 || !s.toString().matches(Constant.REGEX_EMAIL)) {

                        edtEmail.setError("Invalid Email");

                        disableButtonResetPassword();

                    } else {
                        edtEmail.setError(null);
                        if (isValidInput()) {

                            enableButtonResetPassword();

                        }

                    }
                }
            });


        }

        private boolean isValidInput() {

            Log.d("ErrorTest", "mail" + edtEmail.getError());

            return edtEmail.getError() == null;
        }

        private void disableButtonResetPassword() {

            btnResetPassword.setEnabled(false);
            btnResetPassword.setTextColor(getResources().getColor(R.color.btnTextColorDisable));

        }

        private void enableButtonResetPassword() {

            btnResetPassword.setEnabled(true);
            btnResetPassword.setTextColor(getResources().getColor(R.color.colorAccent));

        }


    }
