package ahnteve.mirim.audiolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView list_music;
    Button but_play, but_stop;
    TextView text_music;
    ProgressBar progress_music;
    String[] musics={"Home", "Once Upon A Time", "Snowy"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list_music=(ListView)findViewById(R.id.list_music);
        but_play=(Button)findViewById(R.id.but_play);
        but_stop=(Button)findViewById(R.id.but_stop);
        text_music=(TextView)findViewById(R.id.text_music);
        progress_music=(ProgressBar)findViewById(R.id.progress_music);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice,musics);
        list_music.setAdapter(adapter);
        list_music.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        list_music.setItemChecked(0, true);
    }
}
