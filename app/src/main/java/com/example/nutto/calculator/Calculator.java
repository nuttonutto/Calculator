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

import java.text.DecimalFormat;


public class Calculator extends ActionBarActivity {
    double result = 0;
    enum Operation {plus, minus, multiply, divide}
    Operation operation = Operation.plus;
    boolean opClick = false;
    boolean showResult = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_calculator);

        final Intent intent = new Intent(Calculator.this,Result.class);
        final TextView txt = (TextView) findViewById(R.id.txt);
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
        DecimalFormat format = new DecimalFormat();
        format.setDecimalSeparatorAlwaysShown(false);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!opClick) { txt.setText(txt.getText().toString() + "1");}
                else {txt.setText("1");}
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!opClick) {txt.setText(txt.getText().toString() + "2");}
                else {txt.setText("2");}
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!opClick) {txt.setText(txt.getText().toString() + "3");}
                else {txt.setText("3");}
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!opClick) {txt.setText(txt.getText().toString() + "4");}
                else {txt.setText("4");}
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!opClick) {txt.setText(txt.getText().toString() + "5");}
                else {txt.setText("5");}
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!opClick) {txt.setText(txt.getText().toString() + "6");}
                else {txt.setText("6");}
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!opClick) {txt.setText(txt.getText().toString() + "7");}
                else {txt.setText("7");}
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!opClick) {txt.setText(txt.getText().toString() + "8");}
                else {txt.setText("8");}
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!opClick) {txt.setText(txt.getText().toString() + "9");}
                else {txt.setText("9");}
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txt.getText().toString().isEmpty()&&!opClick){
                    txt.setText(txt.getText().toString()+"");
                }
                else if(!opClick){
                    txt.setText("0");
                }
                else{
                    txt.setText(txt.getText().toString()+"0");
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText("");
                result = 0;
                opClick = false;
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = Operation.plus;
                if (txt.getText().toString().isEmpty()){
                    txt.setText(txt.getText().toString()+"");
                }
                else {
                    if (opClick) {
                        if (txt.getText().toString().equals(Double.toString(result))) {
                            txt.setText(Double.toString(result));
                        } else {
                            result = result + Double.parseDouble(txt.getText().toString());
                            txt.setText(Double.toString(result));
                        }
                    }
                    else{
                        result = Double.parseDouble(txt.getText().toString());
                        txt.setText("");
                        opClick = true;
                    }
                }
            }

        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = Operation.minus;
                if (txt.getText().toString().isEmpty()){
                    txt.setText(txt.getText().toString()+"");
                }
                else {
                    if (opClick){
                        if (txt.getText().toString().equals(Double.toString(result))) {
                            txt.setText(Double.toString(result));
                        } else {
                            result = result - Double.parseDouble(txt.getText().toString());
                            txt.setText(Double.toString(result));
                        }
                    }
                    else{
                        result = Double.parseDouble(txt.getText().toString());
                        txt.setText("");
                        opClick = true;
                    }
                }
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = Operation.multiply;
                if (txt.getText().toString().isEmpty()){
                    txt.setText(txt.getText().toString()+"");
                }
                else {
                    if (opClick){
                        if (txt.getText().toString().equals(Double.toString(result))) {
                            txt.setText(Double.toString(result));
                        } else {
                            result = result * Double.parseDouble(txt.getText().toString());
                            txt.setText(Double.toString(result));
                        }
                    }
                    else{
                        result = Double.parseDouble(txt.getText().toString());
                        txt.setText("");
                        opClick = true;
                    }
                }
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = Operation.divide;
                if (txt.getText().toString().isEmpty()){
                    txt.setText(txt.getText().toString()+"");
                }
                else {
                    if (opClick){
                        if (txt.getText().toString().equals(Double.toString(result))) {
                            txt.setText(Double.toString(result));
                        } else {
                            result = result / Double.parseDouble(txt.getText().toString());
                            txt.setText(Double.toString(result));
                        }
                    }
                    else{
                        result = Double.parseDouble(txt.getText().toString());
                        txt.setText("");
                        opClick = true;
                    }
                }
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txt.getText().toString().isEmpty()) {
                    txt.setText(txt.getText().toString() + "");
                } else {
                    if (opClick) {
                        switch (operation) {
                            case plus:
                                result = result + Double.parseDouble(txt.getText().toString());
                                break;
                            case minus:
                                result = result - Double.parseDouble(txt.getText().toString());
                                break;
                            case multiply:
                                result = result * Double.parseDouble(txt.getText().toString());
                                break;
                            case divide:
                                result = result / Double.parseDouble(txt.getText().toString());
                                break;
                        }

                    }
                    showResult = true;
                    opClick = false;
                    txt.setText("");
                    intent.putExtra("result", Double.toString(result));
                    intent.putExtra("activityName", Calculator.this.getClass().getSimpleName());
                    startActivity(intent);
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
