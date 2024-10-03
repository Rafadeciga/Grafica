package com.upiita.graficas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.view.animation.PathInterpolator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        VistaGrafico graficas = new VistaGrafico(this);//aqui creamos el activity main(se pinta de verde)
        setContentView(graficas);
    }
    public class VistaGrafico extends View {

        public VistaGrafico(Context context) {
            super(context);
        }
        @Override protected void onDraw(Canvas canvas){
            super.onDraw(canvas);
            Paint pintura = new Paint();
            pintura.setColor(Color.rgb(255,231,146));
            canvas.drawPaint(pintura);
            pintura.setColor(Color.BLUE);
            pintura.setTextSize(80);
            canvas.drawText("HOLA UPIITA",0,300,pintura);

            int ancho,alto;
            ancho = canvas.getWidth();
            alto= canvas.getHeight();
            canvas.drawText("ancho = " + ancho + " alto =" + alto, 0,80,pintura);

            //ancho = 1080
            //alto = 2088 (le quitó 220 )

            //ancho = 2220
            //alto =948 (le quitó 220)
            pintura.setTextAlign(Paint.Align.CENTER);
            canvas.drawText("TELEMÁTICA", ancho/2,alto/2,pintura);


            pintura.setTextSize(200);
            pintura.setStyle(Paint.Style.FILL);//Relleno
            pintura.setColor(Color.rgb(111,28,70));
            canvas.drawText("IPN",ancho/2,alto/2+200,pintura);

            pintura.setColor(Color.WHITE);
            pintura.setTextSize(200);
            pintura.setStyle(Paint.Style.STROKE);//Contorno
            pintura.setStrokeWidth(8);
            canvas.drawText("IPN",ancho/2,alto/2+200,pintura);

            //Trazar lineas
            pintura.setStyle(Paint.Style.FILL_AND_STROKE);
            pintura.setStrokeWidth(15);
            pintura.setColor(Color.GREEN);
            canvas.drawLine(0,0,ancho,alto,pintura);
            canvas.drawLine(ancho,0,0,alto,pintura);

            pintura.setTextSize(40);
            pintura.setStrokeWidth(3);
            for(int a = 0; a<alto; a+=50){
                canvas.drawLine(0,a,ancho,a,pintura);
                canvas.drawText(""+ a,ancho-100,a,pintura);
            }

            pintura.setColor(Color.BLACK);
            pintura.setStyle(Paint.Style.STROKE);
            pintura.setStrokeWidth(10);
            canvas.drawCircle(ancho/4,500,100, pintura);
            canvas.drawCircle(3*ancho/4,500,100,pintura);
            pintura.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawCircle(ancho/4,500,50, pintura);
            canvas.drawCircle(3*ancho/4,500,50,pintura);




            //Trazar rectangulos
            pintura.setStyle(Paint.Style.STROKE);
            RectF rectangulo = new RectF(ancho/4,950,3*ancho/4,1300);
            pintura.setColor(Color.BLUE);
            canvas.drawRect(rectangulo,pintura);


            // Trazar trayectorias
            Path trazo = new Path();
            trazo.addCircle(ancho/2,1550,200,Path.Direction.CCW);
            pintura.setTextSize(40);
            pintura.setStrokeWidth(5);
            canvas.drawCircle(ancho/2,1550,200,pintura);
            canvas.drawTextOnPath("INSTITUTO POLITECNICO NACIONAL",trazo,300,50,pintura);
        }

        }


    }

