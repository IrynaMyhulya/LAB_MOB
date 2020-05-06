package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    CheckBox cbarea, cbper;
    Button submit;
    RadioButton radioButton;
    TextView textView, resultText;
    ArrayList<String> selection = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.rbGroup);
        cbarea = (CheckBox) findViewById(R.id.cbArea);
        cbper = (CheckBox) findViewById(R.id.cbPerimeter);
        textView=findViewById(R.id.tvSelected);
        resultText=findViewById(R.id.final_par);
        resultText.setEnabled(false);


        submit = (Button) findViewById(R.id.button);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int isSelected = radioGroup.getCheckedRadioButtonId();
                radioButton=findViewById(isSelected);
                textView.setText("Your choice:"+radioButton.getText());

                String final_selection="";

                for (String Selections: selection)
                {
                    final_selection=final_selection+Selections+"\n";

                }
                resultText.setText(final_selection);
                resultText.setEnabled(true);
                validation(v);
            }
        });

    }

    public void selectItem(View v)
    {
        boolean ischecked=((CheckBox) v).isChecked();
        switch (v.getId()){
            case R.id.cbArea:
                if(ischecked)
                {selection.add("Area");}
                else
                {
                    selection.remove("Area");
                }
                break;
            case R.id.cbPerimeter:
                if(ischecked)
                {selection.add("Perimeter");}
                else
                {
                    selection.remove("Perimeter");
                }
                break;
        }
    }


    public void validation(View v){

        //
        int isSelected = radioGroup.getCheckedRadioButtonId();

        radioButton=findViewById(isSelected);

        if(isSelected==-1){
            Toast.makeText(MainActivity.this, "You have not selected any of figures", Toast.LENGTH_LONG).show();
            return;
        }

        if(!cbarea.isChecked() &&!cbper.isChecked()){
            Toast.makeText(MainActivity.this, "Check any of find parameters", Toast.LENGTH_LONG).show();
        }
    }

}
