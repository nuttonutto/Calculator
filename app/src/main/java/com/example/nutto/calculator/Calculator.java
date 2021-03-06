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

import java.math.BigInteger;

public class Calculator extends ActionBarActivity {
    private BigInteger result;
    private TextView txt;
    private String resultsBoxString;
    private enum Operation {noop,plus, minus, multiply, divide}
    private Operation tmp,operation = Operation.noop;
    private boolean opClick = false;
    private int opCount;
    private boolean isCalculated = false;

    class Number_Button implements Button.OnClickListener{

        @Override
        public void onClick(View v) {
            if((resultsBoxString.equals(""))||((!resultsBoxString.equals("")&&isCalculated))){
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
                isCalculated = false;

            }
            else if(!resultsBoxString.equals("")){
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
        private String input;
        private BigInteger bigInput;
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.add: operation = Operation.plus; break;
                case R.id.sub: operation = Operation.minus; break;
                case R.id.mul: operation = Operation.multiply; break;
                case R.id.div: operation = Operation.divide; break;
            }

            if(resultsBoxString.equals("")){
                txt.setText(resultsBoxString+"");
            }
            else {
                input = txt.getText().toString();
                bigInput = new BigInteger(input);
                opCount += 1;
                if(opClick){
                    if(!isCalculated) {
                        switch (tmp) {
                            case plus:
                                result = result.add(bigInput);
                                break;
                            case minus:
                                result = result.subtract(bigInput);
                                break;
                            case multiply:
                                result = result.multiply(bigInput);
                                break;
                            case divide:
                                result = result.divide(bigInput);
                                break;
                            case noop:
                                break;
                        }
                        isCalculated = true;
                    }
                    resultsBoxString = result.toString();
                }
                else {
                    result = bigInput;
                    resultsBoxString = "";
                }
            }
            tmp = operation;
            txt.setText(resultsBoxString);
            opClick = true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_calculator);

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
        result = BigInteger.valueOf(0);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText("");
                resultsBoxString = "";
                opClick = false;
                opCount = 0;
                result = BigInteger.valueOf(0);
                isCalculated = false;
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            private String input;
            private BigInteger bigInput;
            @Override
            public void onClick(View v) {
                if (resultsBoxString.equals("")) {
                    txt.setText("");
                } else {
                    input = txt.getText().toString();
                    bigInput = new BigInteger(input);
                    if(opCount>0){
                        switch (operation) {
                            case plus:
                                result = result.add(bigInput);
                                break;
                            case minus:
                                result = result.subtract(bigInput);
                                break;
                            case multiply:
                                result = result.multiply(bigInput);
                                break;
                            case divide:
                                result = result.divide(bigInput);
                                break;
                        }
                    }
                    else{
                        result = bigInput;
                    }
                    opClick = false;
                    opCount = 0;
                    txt.setText("");
                    final Intent intent = new Intent(Calculator.this,Result.class);
                    intent.putExtra("result", result.toString());
                    intent.putExtra("activityName", Calculator.this.getClass().getSimpleName());
                    startActivity(intent);
                    resultsBoxString = "";
                    result = BigInteger.valueOf(0);
                    isCalculated = false;
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