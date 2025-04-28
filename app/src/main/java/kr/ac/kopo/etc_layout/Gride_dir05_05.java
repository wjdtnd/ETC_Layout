package kr.ac.kopo.etc_layout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Gride_dir05_05 extends AppCompatActivity {
    EditText edit1, edit2;
    Button [] btnNums = new Button[10];
    Button btnPlus, btnMinus, btnMulti, btnDivide;
    TextView textResult;
    int[] btnNumIds = {R.id.btn0,R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9};
    String num1="", num2="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.gride_dir05_5);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);

        for (int i = 0 ; i < btnNums.length ; i++){
            btnNums[i] = findViewById(btnNumIds[i]);
        }

        btnPlus = findViewById(R.id.btn_plus);
        btnMinus = findViewById(R.id.btn_minus);
        btnMulti = findViewById(R.id.btn_multi);
        btnDivide = findViewById(R.id.btn_divede);

        textResult = findViewById(R.id.text_result);

        for (int i = 0; i < btnNums.length; i++){
            final int index;
            index = i;

            btnNums[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(edit1.isFocused()){
                        num1 = edit1.getText().toString() + btnNums[index].getText().toString();
                        edit1.setText(num1);
                    }else if(edit2.isFocused()) {
                        num2 = edit2.getText().toString() + btnNums[index].getText().toString();
                        edit2.setText(num2);
                    }else{
                        Toast.makeText(getApplicationContext(), "먼저 EditText를 선택해주세요.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        btnPlus.setOnClickListener(btnListener);
        btnMinus.setOnClickListener(btnListener);
        btnMulti.setOnClickListener(btnListener);
        btnDivide.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button eventBtn = (Button) v;
            String editStr1 = edit1.getText().toString();
            String editStr2 = edit2.getText().toString();

            int editNum1 = Integer.parseInt(editStr1);
            int editNum2 = Integer.parseInt(editStr2);
            int result = 0;

            if(eventBtn == btnPlus){
                result = editNum1 + editNum2;
            }else if(eventBtn == btnMinus){
                result = editNum1 - editNum2;
            }else if(eventBtn == btnMulti){
                result = editNum1 * editNum2;
            }else{
                result = editNum1 / editNum2;
            }

            textResult.setText("계산결과 : " + result);
        }
    };

}