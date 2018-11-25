package ca.csf.pobj.tp2;

import android.os.Bundle;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private View rootView;
    //BEN_CORRECTION : Pour que ce soit une constante, il faut qu'elle soit statique.
    //BEN_CORRECTION : De plus, ce message d'erreur devrait se retrouver dans "strings.xml". Voir https://developer.android.com/guide/topics/resources/string-resource
    private final String ERROR_MESSAGE = "Le nombre doit etre entre 1 et 4999 inclusivement";
    private final String OUTPUT_NUMBER = "outputNumber";
    private String romanNumber;
    private EditText inputEditText;
    private TextView outputTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rootView = findViewById(R.id.rootView);
        inputEditText = findViewById(R.id.inputEditText);
        outputTextView = findViewById(R.id.outPutTextView);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        this.outputTextView.setText(savedInstanceState.getString(this.OUTPUT_NUMBER));
        this.romanNumber = savedInstanceState.getString(this.OUTPUT_NUMBER);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(this.OUTPUT_NUMBER, this.romanNumber);
    }

    public void onRomanNumberButtonClick(View view) {
        if (this.inputEditText.getText().toString().length() > 0) {
            this.checkIfNumberIsValid();
        }
    }

    //BEN_CORRECTION : Cette fonction devrait uniquement retourner un boolean indiquant si la valeur
    //                 saisie est valide. Actuellement, elle valide, démarre la conversion ou affiche
    //                 un message d'erreur, ce qui fait un total de 3 responsabilités.
    private void checkIfNumberIsValid() {
        if (Integer.parseInt(this.inputEditText.getText().toString()) <= 4999 && Integer.parseInt(this.inputEditText.getText().toString()) >= 1) {
            this.convertValidNumber();
        } else {
            generateErrorMessage();
        }
    }

    //BEN_REVIEW : Plutôt que "generate", je l'aurais appeller "show".
    private void generateErrorMessage() {
        Snackbar.make(this.rootView, this.ERROR_MESSAGE,
                Snackbar.LENGTH_SHORT)
                .show();
    }

    private void convertValidNumber() {
        ConvertIntToRoman converter = new ConvertIntToRoman();
        this.romanNumber = converter.convertIntToRoman(Integer.parseInt(this.inputEditText.getText().toString()));
        this.outputTextView.setText(this.romanNumber);
    }
}
