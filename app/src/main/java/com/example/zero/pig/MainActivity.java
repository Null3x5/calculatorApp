package com.example.zero.pig;


import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18;
    private EditText text;
    private String score;
    private char func = '+';
    private double first = 0, second = 0;
    private Boolean number = false , middle = false, rear = false, front = false, error = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (EditText) findViewById(R.id.textView);

        Intent intent = getIntent();
        score = intent.getStringExtra("sofar");

        number = intent.getBooleanExtra("number",false);
        middle = intent.getBooleanExtra("middle", false);
        rear = intent.getBooleanExtra("rear",false);
        front = intent.getBooleanExtra("front", false);
        error = intent.getBooleanExtra("error", false);

        first = intent.getDoubleExtra("first", 0 );
        second = intent.getDoubleExtra("second", 0 );

        func = intent.getCharExtra("func", 't');

        text.setText(score);

        //this is decimal point
        b1 = (Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messWithText('.');
            }
        });
        //this is zero
        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messWithText('0');
            }
        });
        //this is for =
        b3 = (Button) findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messWithText('=');
            }
        });
        //this is for /
        b4 = (Button) findViewById(R.id.button4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messWithText('/');
            }
        });
        //this is for 1
        b5 = (Button) findViewById(R.id.button5);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messWithText('1');
            }
        });
        //this is for 2
        b6 = (Button) findViewById(R.id.button6);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messWithText('2');
            }
        });

        //this is for 3
        b7 = (Button) findViewById(R.id.button7);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messWithText('3');
            }
        });

        //this is for *
        b8 = (Button) findViewById(R.id.button8);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messWithText('*');
            }
        });


        //this is for 4
        b9 = (Button) findViewById(R.id.button9);
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messWithText('4');
            }
        });

        //this is for 5
        b10 = (Button) findViewById(R.id.button10);
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messWithText('5');
            }
        });

        //this is for 6
        b11 = (Button) findViewById(R.id.button11);
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messWithText('6');
            }
        });

        //this is for negation kidding its negative
        b12 = (Button) findViewById(R.id.button12);
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messWithText('-');
            }
        });

        //this is for 7
        b13 = (Button) findViewById(R.id.button13);
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messWithText('7');
            }
        });

        //this is for 8
        b14 = (Button) findViewById(R.id.button14);
        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messWithText('8');
            }
        });

        //this is for 9
        b15 = (Button) findViewById(R.id.button15);
        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messWithText('9');
            }
        });

        //this is for plus plus of course
        b16 = (Button) findViewById(R.id.button16);
        b16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messWithText('+');
            }
        });

        //this is for clear
        b17 = (Button) findViewById(R.id.button17);
        b17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messWithText('c');
            }
        });

        //this is for others
        b18 = (Button) findViewById(R.id.button18);
        b18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messWithText('s');
            }
        });

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

    public void messWithText(char n){
        text = (EditText) findViewById(R.id.textView);
        String c = (String) text.getText().toString();


        if(!middle && !rear && !front) {
            switch (n) {
                case '0':
                    editText(text, "0", c);
                    function('0', false, '`');
                    break;
                case '1':
                    editText(text, "1", c);
                    function('1', false, '`');
                    break;
                case '2':
                    editText(text, "2", c);
                    function('2', false, '`');
                    break;
                case '3':
                    editText(text, "3", c);
                    function('3', false, '`');
                    break;
                case '4':
                    editText(text, "4", c);
                    function('4', false, '`');
                    break;
                case '5':
                    editText(text, "5", c);
                    function('5', false, '`');
                    break;
                case '6':
                    editText(text, "6", c);
                    function('6', false, '`');
                    break;
                case '7':
                    editText(text, "7", c);
                    function('7', false, '`');
                    break;
                case '8':
                    editText(text, "8", c);
                    function('8', false, '`');
                    break;
                case '9':
                    editText(text, "9", c);
                    function('9', false, '`');
                    break;
                case 'c':
                    this.text.setText("0");
                    this.number = false;
                    this.middle = false;
                    this.rear = false;
                    this.front = false;
                    this.error = false;
                    this.first = 0;
                    this.second = 0;
                    break;
                case 's':
                    switchScreen(c);
                    break;
                case '/':
                    editText(text, "/", c);
                    function(0, true, '/');
                    break;
                case '*':
                    editText(text, "*", c);
                    function(0, true, '*');
                    break;
                case '+':
                    editText(text, "+", c);
                    function(0, true, '+');
                    break;
                case '-':
                    editText(text, "-", c);
                    function(0, true, '-');
                    break;
                case '.':
                    editText(text, ".", c);
                    function(0, true, '.');
                    break;
                case '=':
                    equalsWhat(text);
                    break;

                default:
                    break;
            }
        }

    }

    public void equalsWhat(EditText text){
        switch (func) {
            case '/':
                equalsText(text,(first / second));
                break;
            case '*':
                equalsText(text,(first * second));
                break;
            case '+':
                equalsText(text, (first + second));
                break;
            case '-':
                equalsText(text,(first - second));
                break;
            case '.':

                break;
        }
    }

    public void switchScreen(String c){
        Intent intent = new Intent(MainActivity.this,OtherScreen.class);
        intent.putExtra("sofar", c);
        intent.putExtra("number", number );
        intent.putExtra("middle", middle);
        intent.putExtra("rear",rear);
        intent.putExtra("front",front);
        intent.putExtra("error",error);

        intent.putExtra("first",first);
        intent.putExtra("second", second );

        intent.putExtra("func", func);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
    }

    public void equalsText(EditText text, double s){
        String j = String.valueOf(s);
        text.setText(j);

    }
    public void editText(EditText text, String s, String c){
        if(!error){
            if(!c.equals("0")) {
                text.setText(c + s);
            }else{
                text.setText(s);
            }
        }
    }
    public void function(int n , boolean sym, char s) {
        if (!sym) {
            if (!number) {
                switch (n) {
                    case '0':
                        firstNumber(0);
                        break;
                    case '1':
                        firstNumber(1);
                        break;
                    case '2':
                        firstNumber(2);
                        break;
                    case '3':
                        firstNumber(3);
                        break;
                    case '4':
                        firstNumber(4);
                        break;
                    case '5':
                        firstNumber(5);
                        break;
                    case '6':
                        firstNumber(6);
                        break;
                    case '7':
                        firstNumber(7);
                        break;
                    case '8':
                        firstNumber(8);
                        break;
                    case '9':
                        firstNumber(9);
                        break;
                }
            } else {
                switch (n) {
                    case '0':
                        secondNumber(0);
                        break;
                    case '1':
                        secondNumber(1);
                        break;
                    case '2':
                        secondNumber(2);
                        break;
                    case '3':
                        secondNumber(3);
                        break;
                    case '4':
                        secondNumber(4);
                        break;
                    case '5':
                        secondNumber(5);
                        break;
                    case '6':
                        secondNumber(6);
                        break;
                    case '7':
                        secondNumber(7);
                        break;
                    case '8':
                        secondNumber(8);
                        break;
                    case '9':
                        secondNumber(9);
                        break;
                }
            }
        } else {
            switch (s) {
                case '/':
                    this.func = '/';
                    number = true;
                    break;
                case '*':
                    this.func = '*';
                    number = true;
                    break;
                case '+':
                    this.func = '+';
                    number = true;
                    break;
                case '-':
                    this.func = '-';
                    number = true;
                    break;
                case '.':
                    this.func = '.';
                    number = true;
                    break;
            }
        }
    }

    public void firstNumber(double i){
        this.first = first*10 + i;
    }

    public void secondNumber(double i){
        this.second = second*10 + i;
    }
}
