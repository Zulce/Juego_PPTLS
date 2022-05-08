package com.example.juegp_pptls;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public TableLayout opt_grid;
    public LinearLayout LL_J1;
    public LinearLayout LL_J2;

    public TextView txtcpu;
    public TextView txtcontador_J1;
    public TextView txtcontador_J2;
    public ImageView image_J1;
    public ImageView image_J2;


    public ImageButton tijeras_btn;
    public ImageButton papel_btn;
    public ImageButton piedra_btn;
    public ImageButton lagarto_btn;
    public ImageButton spock_btn;
    public Button inicio_btn;

    //public int tijeras = 1, papel = 2, piedra = 3, lagarto = 4, spock = 5;
    public int resultado, desicion;
    public int respuesta_aleatoria;
    public int [] opciones={1,2,3,4,5};
    public int contador_J2;
    public int contador_J1;

    public void jugar(int des, int[] opt) {

        Random ran = new Random();
        respuesta_aleatoria = opt[ran.nextInt(opt.length)];
        resultado = des * respuesta_aleatoria;
        image_setup(respuesta_aleatoria,opt);

       if(des==respuesta_aleatoria)
       {
           contador_J1=contador_J1;
       }
        else if (resultado < 0)
        {
            contador_J2++;
            txtcontador_J2.setText(String.valueOf(contador_J2));
        }
        else if (resultado>0)
        {
            contador_J1++;
            txtcontador_J1.setText(String.valueOf(contador_J1));
        }
        Log.d("Resultados", "Los resultados son:"+" "+ des+", "+respuesta_aleatoria+", "+resultado+" ["+opt[0]+","+opt[1]+","+opt[2]+","+opt[3]+","+opt[4]+"]");

        reset_opciones();
    }

    public void inicio_press(View view) {
        contador_J1=0;
        contador_J2=0;
        opt_grid=(TableLayout) findViewById(R.id.lytable);
        opt_grid.setVisibility(View.VISIBLE);

        LL_J1=(LinearLayout) findViewById(R.id.llJ1);
        LL_J1.setVisibility(View.VISIBLE);
        LL_J2=(LinearLayout) findViewById(R.id.llJ2);
        LL_J2.setVisibility(View.VISIBLE);

        tijeras_btn=(ImageButton) findViewById(R.id.btijeras);
        papel_btn=(ImageButton) findViewById(R.id.bpapel);
        piedra_btn=(ImageButton) findViewById(R.id.bpiedra);
        lagarto_btn=(ImageButton) findViewById(R.id.blagarto);
        spock_btn=(ImageButton) findViewById(R.id.bspock);
        inicio_btn=(Button) findViewById(R.id.binicio);

        txtcpu=(TextView) findViewById(R.id.textcpu);
        txtcpu.setVisibility(View.VISIBLE);
        txtcontador_J1=(TextView) findViewById(R.id.textcontador_J1);
        txtcontador_J2=(TextView) findViewById(R.id.textcontador_J2);
        image_J1= (ImageView) findViewById(R.id.imageJ1);
        image_J2=(ImageView) findViewById(R.id.imageJ2);
    }

    public void tijeras_press(View view) {
        //tijeras_btn.setText("TIJERAS");
        opciones[2] = -3;
        opciones[4] = -5;
        image_J1.setImageResource(R.drawable.tijeras);

        jugar(opciones[0],opciones);
    }


    public void papel_press(View view)
    {
        opciones[0] = -1;
        opciones[3] = -4;
        image_J1.setImageResource(R.drawable.papel);

        jugar(opciones[1],opciones);
    }
    //public int tijeras = 1, papel = 2, piedra = 3, lagarto = 4, spock = 5;
    public void piedra_press(View view)
    {
        opciones[1] = -2;
        opciones[4] = -5;
        image_J1.setImageResource(R.drawable.piedra);

        jugar(opciones[2],opciones);
    }

    public void lagarto_press(View view)
    {
        opciones[2] = -3;
        opciones[0] = -1;
        image_J1.setImageResource(R.drawable.lagarto);

        jugar(opciones[3],opciones);
    }

    public void spock_press(View view)
    {
        opciones[3] = -4;
        opciones[1] = -2;
        image_J1.setImageResource(R.drawable.spock);

        jugar(opciones[4],opciones);
    }

    public void image_setup(int respuesta,int [] op)
    {
        if(respuesta==op[0]) image_J2.setImageResource(R.drawable.tijeras);
        if(respuesta==op[1]) image_J2.setImageResource(R.drawable.papel);
        if(respuesta==op[2]) image_J2.setImageResource(R.drawable.piedra);
        if(respuesta==op[3]) image_J2.setImageResource(R.drawable.lagarto);
        if(respuesta==op[4]) image_J2.setImageResource(R.drawable.spock);
    }

    public void reset_opciones()
    {
        for (int i=0;i<=4;i++)
        {
            if(opciones[i]<0)
            {
                opciones[i]=opciones[i]*-1;
            }
        }
    }
}
