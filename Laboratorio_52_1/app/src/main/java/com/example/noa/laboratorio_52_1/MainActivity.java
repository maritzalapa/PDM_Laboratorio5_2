package com.example.noa.laboratorio_52_1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton imageButton;
    private Button backButton;
    private Button saveButton;
    private EditText telEditText;
    private CheckBox checkBox;
    private RadioButton redRadio;
    private RadioButton blueRadio;
    private ToggleButton toggleButton;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setUpViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setUpViews(){
        imageButton = (ImageButton) findViewById (R.id.imageButton);
        backButton = (Button) findViewById(R.id.btnBack);
        saveButton = (Button) findViewById(R.id.btnSave);
        telEditText = (EditText) findViewById(R.id.editTextTel);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        redRadio = (RadioButton) findViewById(R.id.radioButtonRed);
        blueRadio = (RadioButton) findViewById(R.id.radioButtonBlue);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        saveButton.setEnabled(false);

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });
    }

    public void sendClick(View v) {
// Perform action on clicks
        String allText = new String("campo:" + telEditText.getText());
        allText = allText + ":checkbox:";
        if (checkBox.isChecked()) {
            allText = allText + "Checked:";
        } else {
            allText = allText + "Not Checked:";
        }
        allText = allText + ":toggle:";
        if (toggleButton.isChecked()) {
            allText = allText + "Checked:";
        } else {
            allText = allText + "Not Checked:";
        }
        allText = allText + "radios:rojo:";
        String redtext = "";
        if (redRadio.isChecked()) {
            redtext = "pulsado:";
        } else {
            redtext = "no pulsado:";
        }
        allText = allText + redtext;
        allText = allText + "azul";
        String bluetext = "";
        if (blueRadio.isChecked()) {
            bluetext = "pulsado:";
        } else {
            bluetext = "no pulsado:";
        }
        allText = allText + bluetext;
        allText = allText + "rating:";
        float f = ratingBar.getRating();
        allText = allText + Float.toString( f ) + ":";

        Log.d("app", allText);
        Toast.makeText(this, allText, Toast.LENGTH_LONG).show();
    }

    public void checkBoxClick(View v) {
        String text = "";
        if (checkBox.isChecked()) {
            text = "Selected";
            saveButton.setEnabled(true);
            Toast.makeText(this,"Ya puedes Salvar",
                    Toast.LENGTH_LONG).show();
        } else {
            saveButton.setEnabled(false);
            Toast.makeText(this, "Hasta que no marques la casilla no podrás salvar",Toast.LENGTH_LONG).show();
            text = "Not selected";
        }
        Toast.makeText(this,text,
                Toast.LENGTH_SHORT).show();
    }

    public void radioClick(View v) {
        String text = "";
        if (redRadio.isChecked()) {
            text = "Presionaste rojo";
            Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);

            View toastView = toast.getView();
            toastView.setBackgroundResource(R.color.colorRed);
            toast.show();

        } else if (blueRadio.isChecked()){
            text = "Presionaste azul";
            Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);

            View toastView = toast.getView();
            toastView.setBackgroundResource(R.color.colorBlue);
            toast.show();
        }
    }

    public void toggleClick(View v) {
        String text = "";
        if (toggleButton.isChecked()) {
            text = "Vibrate on (presionaste el toggle)";
        } else {
            text = "Vibrate off (presionaste el toggle)";
        }
        Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
        toast.show();
    }

}































