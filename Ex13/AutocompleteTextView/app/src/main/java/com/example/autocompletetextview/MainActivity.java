package com.example.autocompletetextview;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView selection;
    // Khai bao 2 CompleteTextView
    AutoCompleteTextView singleComplete;
    MultiAutoCompleteTextView multiComplete;
    //KHoi tao mang tam de test
    String arr[]={"Hà nội","Huế","Sài Gòn","Hà Giang","Hội An","Kiên Giang","Lâm Đồng","Long Khánh"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        selection = (TextView) findViewById(R.id.selection);
        //Lay doi tuong AutoCompleteTextView ra
        singleComplete = (AutoCompleteTextView) findViewById(R.id.edtauto);
        ArrayAdapter myadapter = new ArrayAdapter<String>
            (
            this,
            android.R.layout.simple_list_item_1,
            arr
            );
        //Thiet lap ArrayAdapter
        singleComplete.setAdapter(myadapter);

        //Lay doi tuong MultiAutoCompleteTextView ra
        multiComplete=(MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView1);
        //Thiet lap ArrayAdapter
        multiComplete.setAdapter(new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                arr
        ));
        //Doi voi MultiAUtoCompleteTextView bat buoc phai goi tu dong lenh nay
        multiComplete.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        singleComplete.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                selection.setText(singleComplete.getText());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}