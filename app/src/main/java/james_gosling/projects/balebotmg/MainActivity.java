package james_gosling.projects.balebotmg;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv2 = (TextView)findViewById(R.id.tv2);

        TelegramBot bot = new TelegramBot("474370142:96de20d2d1c3b26639b3e2d314d81a26fce8b9e9");

        bot.setUpdatesListener(updates -> {

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < updates.size(); i++) {
                        tv2.setText(tv2.getText()+
                                updates.get(i).message().from().firstName()+":"
                                +updates.get(i).message().text()+"\n");
                    }
                }
            });
//            Toast.makeText(this, ""+updates.get(updates.size() - 1).message(), Toast.LENGTH_SHORT).show();

            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });


        findViewById(R.id.message).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        SendResponse response = bot.execute(new SendMessage(238027140, "Hello!"));
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, ""+response.message().text(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
                thread.start();
            }
        });

    }

}