package com.example.zero.pig;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class OtherScreen extends ActionBarActivity {
    private Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18;
    private EditText text;
    private String score, add, otherend, fronend;
    private long first = 0, second;
    private char func = '+';

    private Boolean number = false , middle = false, rear = false, front = false, error = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_screen);
        text = (EditText) findViewById(R.id.textView2);

        Intent intent = getIntent();
        score = intent.getStringExtra("sofar");
        number = intent.getBooleanExtra("number",false);
        middle = intent.getBooleanExtra("middle", false);
        rear = intent.getBooleanExtra("rear",false);
        front = intent.getBooleanExtra("front", false);

        first = intent.getLongExtra("first",0);
        second = intent.getLongExtra("second", 0);



        text.setText(score);


        b1 = (Button) findViewById(R.id.button31);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messWithText('(');
            }
        });
        //this is zero
        b2 = (Button) findViewById(R.id.button32);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messWithText(')');
            }
        });
        //this is for =
        b3 = (Button) findViewById(R.id.button33);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messWithText('j');
            }
        });
        //this is for /
        b4 = (Button) findViewById(R.id.button34);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messWithText('k');
            }
        });
        //this is for 1
        b5 = (Button) findViewById(R.id.button35);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messWithText('%');
            }
        });
        //this is for 2
        b6 = (Button) findViewById(R.id.button36);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messWithText('!');
            }
        });

        //this is for 3
        b7 = (Button) findViewById(R.id.button37);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messWithText('r');
            }
        });

        //this is for *
        b8 = (Button) findViewById(R.id.button38);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messWithText('^');
            }
        });


        //this is for 4
        b9 = (Button) findViewById(R.id.button39);
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messWithText('l');
            }
        });

        //this is for 5
        b10 = (Button) findViewById(R.id.button40);
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messWithText('g');
            }
        });

        //this is for 6
        b11 = (Button) findViewById(R.id.button41);
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messWithText('p');
            }
        });

        //this is for negation kidding its negative
        b12 = (Button) findViewById(R.id.button42);
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messWithText('e');
            }
        });

        //this is for 7
        b13 = (Button) findViewById(R.id.button43);
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messWithText('z');
            }
        });

        //this is for 8
        b14 = (Button) findViewById(R.id.button44);
        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messWithText('x');
            }
        });

        //this is for 9
        b15 = (Button) findViewById(R.id.button45);
        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messWithText('t');
            }
        });

        //this is for plus plus of course
        b16 = (Button) findViewById(R.id.button46);
        b16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messWithText('i');
            }
        });

        //this is for clear
        b17 = (Button) findViewById(R.id.button47);
        b17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messWithText('c');
            }
        });

        //this is for others
        b18 = (Button) findViewById(R.id.button48);
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
        getMenuInflater().inflate(R.menu.menu_other_screen, menu);
        return true;
    }
    public void messWithText(char n) {
        text = (EditText) findViewById(R.id.textView2);
        String c = (String) text.getText().toString();
            switch (n) {
                case '(':
                    editText(text, "(", c);
                    break;
                case ')':
                    editText(text, ")", c);
                    break;
                case '%':
                    if (!number && !middle && !front && !rear) {
                        rear = true;
                        editText(text, "%", c);
                    } else {
                        displayError(text);
                    }
                    break;
                case '!':
                    if (!number && !middle && !front && !rear) {
                        rear = true;
                        editText(text, "!", c);
                    } else {
                        displayError(text);
                    }
                    break;
                case 'r':
                    if (!number) {
                        editText(text, "root", c);
                    } else {
                        displayError(text);
                    }
                    break;
                case '^':
                    editText(text, "^", c);
                    break;
                case 'l':
                    editText(text, "Ln", c);
                    break;
                case 'g':
                    editText(text, "Log", c);
                    break;
                case 'p':
                    editText(text, "p", c);
                    break;
                case 'e':
                    editText(text, "e", c);
                    break;
                case 'c':
                    text.setText("0");
                    break;
                case 's':
                    switchScreen(c);
                    break;
                case 'z':
                    editText(text, "Sin", c);
                    break;
                case 'x':
                    editText(text, "Cos", c);
                    break;
                case 't':
                    editText(text, "Tan", c);
                    break;
                case 'i':
                    editText(text, "i", c);
                    break;
                case '.':
                    editText(text, ".", c);
                    break;
        }
    }
    public void switchScreen(String c){
        Intent intent = new Intent(this,MainActivity.class);
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
    public void editText(EditText text, String s, String c){
        if(!error) {
            if (!c.equals("0")) {
                text.setText(c + s);
            } else {
                text.setText(s);
            }
        }
    }

    public void displayError(EditText text){
        text.setText("Error");
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
