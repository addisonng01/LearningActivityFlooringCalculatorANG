package CIS3334.learningactivityflooringcalculatorang;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etRoomWidth;
    EditText etRoomLength;
    Button buttonShowResult;
    TextView tvResult;
    private ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etRoomWidth = findViewById(R.id.etRoomWidth);
        etRoomLength = findViewById(R.id.etRoomLength);
        tvResult = findViewById(R.id.tvResult);
        setupButton();

        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            String RoomCalc = data.getStringExtra("RoomCalc");
                            tvResult.setText(RoomCalc);
                        }
                    }
                }
        );
    }

    private void setupButton()
    {
        buttonShowResult = findViewById(R.id.buttonShowResult);

        buttonShowResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double width = Double.parseDouble(etRoomWidth.getText().toString());
                Double length = Double.parseDouble(etRoomLength.getText().toString());

                Intent secActIntent = new Intent(MainActivity.this, Output.class);
                secActIntent.putExtra("RoomWidth", width);
                secActIntent.putExtra("RoomLength", length);
                launcher.launch(secActIntent);
            }
        });
    }
}