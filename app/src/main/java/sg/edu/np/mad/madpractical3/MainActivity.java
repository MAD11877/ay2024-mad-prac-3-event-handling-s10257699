package sg.edu.np.mad.madpractical3;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

import sg.edu.np.mad.madpractical3.R;

public class MainActivity extends AppCompatActivity {

    // Define the TAG variable at the class level
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Initialize a new User object
        User user = new User("MAD " + generateRandomNumber(), "MAD Developer", 1, false);

        // Get the TextViews and buttons from the layout
        TextView tvName = findViewById(R.id.textView); // Update to match the ID in your layout
        TextView tvDescription = findViewById(R.id.textView1); // Update to match the ID in your layout
        Button btnFollow = findViewById(R.id.button1);

        // Set the TextViews with the user's name, description and default button message
        tvName.setText(user.name);
        tvDescription.setText(user.description);
        btnFollow.setText("FOLLOW");

        // Set the click listener for the button
        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check the current text of the button
                String buttonText = btnFollow.getText().toString();

                // Toggle between "Follow" and "Unfollow"
                if (buttonText.equals("Follow") || buttonText.equals("FOLLOW")) {
                    btnFollow.setText("Unfollow");
                    Toast.makeText(MainActivity.this, "Followed", Toast.LENGTH_SHORT).show();
                } else {
                    btnFollow.setText("Follow");
                    Toast.makeText(MainActivity.this, "Unfollowed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private String generateRandomNumber() {
        Random generator = new Random();
        // Generate a random integer between 0 and 999998
        int randomNumber = generator.nextInt(999999);
        return String.valueOf(randomNumber);
    }

}
