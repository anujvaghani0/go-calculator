package com.example.practical_12;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {
    TextView screen;
    Button clear, dot, delete, divide, seven, eight, nine, multiply, four, five, six, minus;
    Button one, two, three, plus, bracket1, zero, bracket2, equal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen = (TextView) findViewById(R.id.screen);
        screen.setMovementMethod(new ScrollingMovementMethod());
        clear = (Button) findViewById(R.id.clear);
        dot = (Button) findViewById(R.id.dot);
        delete = (Button) findViewById(R.id.delete);
        divide = (Button) findViewById(R.id.divide);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        multiply = (Button) findViewById(R.id.multiply);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        minus = (Button) findViewById(R.id.minus);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        plus = (Button) findViewById(R.id.plus);
        bracket1 = (Button) findViewById(R.id.bracket1);
        zero = (Button) findViewById(R.id.zero);
        bracket2 = (Button) findViewById(R.id.bracket2);
        equal = (Button) findViewById(R.id.equal);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                screen.setText("0");
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setText(screen.getText().toString() + ".");
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String current = screen.getText().toString();
                if (current.length() > 1) {
                    screen.setText(current.substring(0, current.length() - 1));
                } else {
                    screen.setText("0");
                }
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                screen.setText(screen.getText().toString() + "/");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!screen.getText().toString().equals("0")) {
                    screen.setText(screen.getText().toString() + "7");
                } else {
                    screen.setText("7");
                }
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!screen.getText().toString().equals("0")) {
                    screen.setText(screen.getText().toString() + "8");
                } else {
                    screen.setText("8");
                }
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!screen.getText().toString().equals("0")) {
                    screen.setText(screen.getText().toString() + "9");
                } else {
                    screen.setText("9");
                }
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setText(screen.getText().toString() + "*");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!screen.getText().toString().equals("0")) {
                    screen.setText(screen.getText().toString() + "4");
                } else {
                    screen.setText("4");
                }
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!screen.getText().toString().equals("0")) {
                    screen.setText(screen.getText().toString() + "5");
                } else {
                    screen.setText("5");
                }
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!screen.getText().toString().equals("0")) {
                    screen.setText(screen.getText().toString() + "6");
                } else {
                    screen.setText("6");
                }
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setText(screen.getText().toString() + "-");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!screen.getText().toString().equals("0")) {
                    screen.setText(screen.getText().toString() + "1");
                } else {
                    screen.setText("1");
                }
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!screen.getText().toString().equals("0")) {
                    screen.setText(screen.getText().toString() + "2");
                } else {
                    screen.setText("2");
                }
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!screen.getText().toString().equals("0")) {
                    screen.setText(screen.getText().toString() + "3");
                } else {
                    screen.setText("3");
                }
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setText(screen.getText().toString() + "+");
            }
        });
        bracket1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setText(screen.getText().toString() + "(");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!screen.getText().toString().equals("0")) {
                    screen.setText(screen.getText().toString() + "0");
                } else {
                    screen.setText("0");
                }
            }
        });
        bracket2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setText(screen.getText().toString() + ")");
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = screen.getText().toString();
                if (!query.equals("0")) {
                    try {
                        Expression exp = new ExpressionBuilder(query).build();
                        double result = exp.evaluate();
                        screen.setText(Double.toString(result));
                    } catch (Exception e) {
                        screen.setText("0");
                        if (e.getMessage() != null) {
                            Toast.makeText(getApplicationContext(), e.getMessage(),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }
}