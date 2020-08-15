package edu.cnm.deepdive.customdialogandsendinginformationtoactivity;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class ExampleDialog extends AppCompatDialogFragment {

  private EditText editTextUsername;
  private EditText editTextPassword;
  private ExampleDialogListener listener;

  @NonNull
  @Override
  public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
    AlertDialog.Builder builder = new Builder(getActivity());
    LayoutInflater inflater = getActivity().getLayoutInflater();
    View view = inflater.inflate(R.layout.layout_dialog, null);

    builder.setView(view)
        .setTitle("Login")
        .setNegativeButton("Cancel", new OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {

          }
        })
        .setPositiveButton("ok", new OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
             String username = editTextUsername.getText().toString();
             String password = editTextPassword.getText().toString();
             listener.applyTexts(username, password);
          }
        });
    editTextUsername = view.findViewById(R.id.edit_username);
    editTextPassword = view.findViewById(R.id.edit_password);

    return builder.create();
  }

  @Override
  public void onAttach(@NonNull Context context) {
    super.onAttach(context);

    try {
      listener = (ExampleDialogListener) context;
    } catch (ClassCastException e) {
      throw new ClassCastException(context.toString() +
          "must implement ExampleDialogListener");
    }
  }

  public interface ExampleDialogListener {
    void applyTexts(String username, String password);
  }
}
