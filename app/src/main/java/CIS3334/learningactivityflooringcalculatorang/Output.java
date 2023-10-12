package CIS3334.learningactivityflooringcalculatorang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Output extends AppCompatActivity {

    TextView tvOutput;
    Double width;
    Double length;
    Double total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        tvOutput = findViewById(R.id.tvOutput);

        Bundle extras = getIntent().getExtras();
        width = extras.getDouble("RoomWidth");
        length = extras.getDouble("RoomLength");
        total = width * length;
        tvOutput.setText("Width: " + width + "\n" + "Length: " + length + "\n" + "Total: " + total);
    }
}