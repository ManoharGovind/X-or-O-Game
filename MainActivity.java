package com.example.xoro;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.gridlayout.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    int flag=1; // 0 for x and 1 for o
    int[] state={2,2,2,2,2,2,2,2,2};
    int[][] winpos={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void goo(View view){
        int i,j;
        ImageView counter=(ImageView)view;
        Log.i("CLicked",""+counter.getTag().toString());
        int tapped=Integer.parseInt(counter.getTag().toString());
        if(state[tapped]==2){
            counter.setTranslationY(-1500);
            if(flag==1){
                state[tapped]=1;
                counter.setImageResource(R.drawable.lx);
                flag=0;
            }
            else{
                state[tapped]=0;
                counter.setImageResource(R.drawable.lo);
                flag=1;
            }
            counter.animate().translationYBy(1500).setDuration(200);
            for(i=0;i<8;i++){
                if(state[winpos[i][0]]==state[winpos[i][1]] && state[winpos[i][1]]==state[winpos[i][2]] &&state[winpos[i][0]]!=2){
                    String msg="";
                    if(flag==0){
                        msg="X won";
                    }
                    else{
                        msg="O won";
                    }
                    TextView ans=(TextView)findViewById(R.id.textView);
                    ans.setText(msg);
                    ans.setVisibility(View.VISIBLE);

                }
            }
        }
        else{
            Toast.makeText(this, "Invalid move", Toast.LENGTH_SHORT).show();
        }
    }
    public void doo(View view) throws Exception{
        int i;
        GridLayout ans=(GridLayout) findViewById(R.id.gridLayout);
        for(i=0;i<ans.getChildCount();i++){
            Log.i("entered",""+i);
            ImageView counter=(ImageView)ans.getChildAt(i);
            counter.setImageDrawable(null);
            state[i]=2;
        }
        flag=1;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
