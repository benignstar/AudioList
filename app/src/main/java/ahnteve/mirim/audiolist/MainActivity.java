package ahnteve.mirim.audiolist;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView list_music;
    Button but_play, but_stop, but_pause;
    TextView text_music;
    ProgressBar progress_music;
    String[] musics={"Home", "Once Upon A Time", "Snowy"};
    int[] musicResIds={R.raw.home, R.raw.once_upon_a_time, R.raw.snowy};
    int selectedMusicId;
    MediaPlayer mediaPlayer;
    boolean selectedPauseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list_music=(ListView)findViewById(R.id.list_music);
        but_play=(Button)findViewById(R.id.but_play);
        but_stop=(Button)findViewById(R.id.but_stop);
        text_music=(TextView)findViewById(R.id.text_music);
        progress_music=(ProgressBar)findViewById(R.id.progress_music);
        but_pause=(Button)findViewById(R.id.but_pause);


        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice,musics);
        list_music.setAdapter(adapter);
        list_music.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        list_music.setItemChecked(0, true);
        selectedMusicId=musicResIds[0];
        mediaPlayer=MediaPlayer.create(this, selectedMusicId);

        list_music.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mediaPlayer.stop();
                selectedPauseButton=false;
                selectedMusicId=musicResIds[position];
                progress_music.setVisibility(View.INVISIBLE);
            }
        });

        but_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
                selectedPauseButton =true;
                progress_music.setVisibility(View.INVISIBLE);
            }
        });
        but_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedPauseButton){
                    selectedPauseButton=false;
                }
                else {
                    mediaPlayer = MediaPlayer.create(MainActivity.this, selectedMusicId);
                }
                mediaPlayer.start();
                progress_music.setVisibility(View.VISIBLE);
            }
        });
        but_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedPauseButton=false;
                mediaPlayer.stop();
                progress_music.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.stop();
    }
}
