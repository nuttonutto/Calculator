package com.example.nutto.calculator;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculator extends ActionBarActivity {
    double result;
    TextView txt;
    String resultsBoxString;
    enum Operation {plus, minus, multiply, divide}
    Operation operation = Operation.plus;
    boolean opClick = false;
    int opCount;
    boolean showResult = false;

    class Number_Button implements Button.OnClickListener{

        @Override
        public void onClick(View v) {
            if(resultsBoxString.equals("")){
                switch (v.getId()){
                    case R.id.one: resultsBoxString = "1"; break;
                    case R.id.two: resultsBoxString = "2"; break;
                    case R.id.three: resultsBoxString = "3"; break;
                    case R.id.four: resultsBoxString = "4"; break;
                    case R.id.five: resultsBoxString = "5"; break;
                    case R.id.six: resultsBoxString = "6"; break;
                    case R.id.seven: resultsBoxString = "7"; break;
                    case R.id.eight: resultsBoxString = "8"; break;
                    case R.id.nine: resultsBoxString = "9"; break;
                    case R.id.zero: resultsBoxString = ""; break;
                }
            }
            else{
                switch (v.getId()){
                    case R.id.one: resultsBoxString += "1"; break;
                    case R.id.two: resultsBoxString += "2"; break;
                    case R.id.three: resultsBoxString += "3"; break;
                    case R.id.four: resultsBoxString += "4"; break;
                    case R.id.five: resultsBoxString += "5"; break;
                    case R.id.six: resultsBoxString += "6"; break;
                    case R.id.seven: resultsBoxString += "7"; break;
                    case R.id.eight: resultsBoxString += "8"; break;
                    case R.id.nine: resultsBoxString += "9"; break;
                    case R.id.zero: resultsBoxString += "0"; break;
                }
            }
            txt.setText(resultsBoxString);
        }
    }

    class Operand_Button implements Button.OnClickListener{

        @Override
        public void onClick(View v) {

            if(resultsBoxString.equals("")){
                switch (v.getId()){
                    case R.id.add: resultsBoxString = ""; break;
                    case R.id.mul: resultsBoxString = ""; break;
                    case R.id.div: resultsBoxString = ""; break;
                    case R.id.sub: resultsBoxString = "-"; break;
                }
                if(resultsBoxString.equals("-"))
                result = -0;
                txt.setText(resultsBoxString);
            }
            else {
                switch (v.getId()){
                    case R.id.add: operation = Operation.plus; break;
                    case R.id.sub: operation = Operation.minus; break;
                    case R.id.mul: operation = Operation.multiply; break;
                    case R.id.div: operation = Operation.divide; break;
                }
                opCount += 1;
                result = Double.parseDouble(resultsBoxString);
                resultsBoxString = "";

                //Multiple operand without click = yet
                if(opClick){

                }
                //Click operand first time
                else{
                    //Click more than once
                    if(opCount>1){
                        result = Double.parseDouble(resultsBoxString);

                    }
                    txt.setText("");
                    opClick = true;
                }
            }
            txt.setText("");

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_calculator);

        final Intent intent = new Intent(Calculator.this,Result.class);
        Button btn1 = (Button) findViewById(R.id.one);
        Button btn2 = (Button)findViewById(R.id.two);
        Button btn3 = (Button)findViewById(R.id.three);
        Button btn4 = (Button)findViewById(R.id.four);
        Button btn5 = (Button)findViewById(R.id.five);
        Button btn6 = (Button)findViewById(R.id.six);
        Button btn7 = (Button)findViewById(R.id.seven);
        Button btn8 = (Button)findViewById(R.id.eight);
        Button btn9 = (Button)findViewById(R.id.nine);
        Button btn0 = (Button) findViewById(R.id.zero);
        Button btnAdd = (Button)findViewById(R.id.add);
        Button btnSub = (Button)findViewById(R.id.sub);
        Button btnMul = (Button)findViewById(R.id.mul);
        Button btnDiv = (Button)findViewById(R.id.div);
        Button btnClear = (Button)findViewById(R.id.clear);
        Button btnEqual = (Button)findViewById(R.id.equal);

        btn1.setOnClickListener(new Number_Button());
        btn2.setOnClickListener(new Number_Button());
        btn3.setOnClickListener(new Number_Button());
        btn4.setOnClickListener(new Number_Button());
        btn5.setOnClickListener(new Number_Button());
        btn6.setOnClickListener(new Number_Button());
        btn7.setOnClickListener(new Number_Button());
        btn8.setOnClickListener(new Number_Button());
        btn9.setOnClickListener(new Number_Button());
        btn0.setOnClickListener(new Number_Button());

        btnAdd.setOnClickListener(new Operand_Button());
        btnSub.setOnClickListener(new Operand_Button());
        btnMul.setOnClickListener(new Operand_Button());
        btnDiv.setOnClickListener(new Operand_Button());

        txt = (TextView) findViewById(R.id.txt);
        resultsBoxString = "";
        opCount = 0;
        result = 0;

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText("");
                resultsBoxString = "";
                opClick = false;
                opCount = 0;
                result = 0;
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultsBoxString.equals("")) {
                    txt.setText("");
                } else {
                    if (opCount>0) {
                        switch (operation) {
                            case plus:
                                result = result + Double.parseDouble(resultsBoxString);
                                break;
                            case minus:
                                result = result - Double.parseDouble(resultsBoxString);
                                break;
                            case multiply:
                                result = result * Double.parseDouble(resultsBoxString);
                                break;
                            case divide:
                                result = result / Double.parseDouble(resultsBoxString);
                                break;
                        }
                    }
                    //Click equal without clicking operand
                    else{
                        result = Double.parseDouble(resultsBoxString);
                    }
                    opClick = false;
                    opCount = 0;
                    txt.setText("");
                    intent.putExtra("result", Double.toString(result));
                    intent.putExtra("activityName", Calculator.this.getClass().getSimpleName());
                    startActivity(intent);
                    resultsBoxString = "";
                    result = 0;
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
