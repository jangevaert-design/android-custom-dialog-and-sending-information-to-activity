package edu.cnm.deepdive.customdialogandsendinginformationtoactivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import edu.cnm.deepdive.customdialogandsendinginformationtoactivity.ExampleDialog.ExampleDialogListener;

public class MainActivity extends AppCompatActivity implements ExampleDialogListener {

  private TextView textViewUsername;
  private TextView textViewPassword;
  private Button button;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    textViewUsername = findViewById(R.id.textview_username);
    textViewPassword = findViewById(R.id.textview_password);
    button = findViewById(R.id.button);
    button.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        openDialog();
      }
    });
  }
  public void openDialog() {
    ExampleDialog exampleDialog = new ExampleDialog();
    exampleDialog.show(getSupportFragmentManager(), "example dialog");
  }

  @Override
  public void applyTexts(String username, String password) {
    textViewUsername.setText(username);
    textViewPassword.setText(password);

  }
}
