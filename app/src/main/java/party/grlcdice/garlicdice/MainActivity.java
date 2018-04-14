package party.grlcdice.garlicdice;

import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int Mybalance=500;
    private int myBet=10;
    private int minBet=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        Button button_even = (Button) findViewById(R.id.button_even);
        Button button_odd = (Button) findViewById(R.id.button_odd);

        button_even.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText bet_amount = (EditText) findViewById(R.id.bet_amount);

                TextView balance = (TextView) findViewById(R.id.balance);
                TextView result = (TextView) findViewById(R.id.result);
                TextView Message = (TextView) findViewById(R.id.Message);

                myBet = Integer.parseInt(bet_amount.getText().toString());
                if(myBet<=Mybalance) {
                    if(myBet >= minBet) {
                        Random r = new Random();
                        int i1 = r.nextInt(6) + 1;
                        result.setText(i1 + "");
                        if ((i1 & 1) == 1) {
                            Mybalance = Mybalance + myBet;
                            Message.setText("You won :)");
                        } else {
                            Mybalance = Mybalance - myBet;
                            Message.setText("You lost :(");
                        }
                        balance.setText(Mybalance + "");
                    }else{
                        Message.setText("the minimum is 2GRLC!");
                    }
                }else{
                    Message.setText("insufficient funds!");
                }
            }
        });

        button_odd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText bet_amount = (EditText) findViewById(R.id.bet_amount);

                TextView balance = (TextView) findViewById(R.id.balance);
                TextView result = (TextView) findViewById(R.id.result);
                TextView Message = (TextView) findViewById(R.id.Message);

                myBet = Integer.parseInt(bet_amount.getText().toString());
                if(myBet<=Mybalance) {
                    if(myBet >= minBet) {
                        Random r = new Random();
                        int i1 = r.nextInt(6) + 1;
                        result.setText(i1 + "");
                        if ((i1 & 1) == 1) {
                            Mybalance = Mybalance - myBet;
                            Message.setText("You lost :(");
                        } else {
                            Mybalance = Mybalance + myBet;
                            Message.setText("You won :)");
                        }
                        balance.setText(Mybalance + "");
                    }else{
                        Message.setText("the minimum is 2GRLC!");
                    }
                }else{
                    Message.setText("insufficient funds!");
                }
            }
        });

    }
}
