package com.example.nutto.calculator;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Calculator extends ActionBarActivity {
    double result = 0;
    TextView txt;
    enum Operation {plus, minus, multiply, divide};
    Operation operation = Operation.plus;
    boolean showResult = false;
    boolean opClick = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText(txt.getText().toString()+"1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText(txt.getText().toString()+"2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText(txt.getText().toString()+"3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText(txt.getText().toString()+"4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText(txt.getText().toString()+"5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText(txt.getText().toString()+"6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText(txt.getText().toString()+"7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText(txt.getText().toString()+"8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText(txt.getText().toString()+"9");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txt.getText().toString().isEmpty()){
                    txt.setText(txt.getText().toString()+"");
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
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = Operation.plus;
                result = Double.parseDouble(txt.getText().toString());
                txt.setText("");
                opClick = true;
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = Operation.minus;
                opClick = true;
                result = Double.parseDouble(txt.getText().toString());
                txt.setText("");
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = Operation.multiply;
                opClick = true;
                result = Double.parseDouble(txt.getText().toString());
                txt.setText("");
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = Operation.divide;
                opClick = true;
                result = Double.parseDouble(txt.getText().toString());
                txt.setText("");
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(opClick){
                    switch (operation){
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
                txt.setText(Double.toString(result));
                intent.putExtra("result", Double.toString(result));
                intent.putExtra("activityName", Calculator.this.getClass().getSimpleName());
                startActivity(intent);
            }

        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculator, menu);
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
}
