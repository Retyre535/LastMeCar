package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


@SuppressLint("ViewConstructor")
public class JoystickView extends View {

    Paint backPaint = new Paint();
    // кисточка для внешнего круга

    Paint bubblePaint = new Paint();
    // кисточка для внутреннего круга

    Paint rectfPaint = new Paint();
    // кисточка для внешнего прямоугольника

    /**
     * первоначальная позиция / местоположение центра внутреннего круга
     */

    float bubbleX = 340, bubbleY = 350;

    /**
     * первоначальная позиция / местоположение центра внешнего круга
     */

    float backX = 340, backY = 350;

    /**
     * радиусы обоих кругов
     */

    int radiusBack = 260, radiusBubble = 100;

    // создаем прямоугольник (внутри прямоугольника круг)
    RectF mRectF = new RectF(backX - radiusBack,
            backY - radiusBack,
            backX + radiusBack,
            backY + radiusBack);

    // контекст
    Context mContext;

    // состояние покоя / джойстик никто не трогает
    String orientation = "STOP";

    public JoystickView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
    }

    // отрисовываем
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initPaint();
        canvas.drawCircle(backX, backY, radiusBack, backPaint);

        /*
        Тут закрашиваем области
        if (orientation == "FORWARD") { // вперед
            canvas.drawArc(mRectF, -45, -90, true, rectfPaint);
        } else if (orientation == "BACKWARD") { // назад
            canvas.drawArc(mRectF, 45, 90, true, rectfPaint);
        } else if (orientation == "LEFT") { // налево
            canvas.drawArc(mRectF, 135, 90, true, rectfPaint);
        } else if (orientation == "RIGHT") { // направо
            canvas.drawArc(mRectF, -45, 90, true, rectfPaint);
        } else if (orientation == "STOP") { // стоим на месте
            rectfPaint.setAlpha(0);
            canvas.drawArc(mRectF, -90, 360, true, rectfPaint);
        }
         */
        canvas.drawCircle(bubbleX, bubbleY, radiusBubble, bubblePaint);

    }

    // доп рисовалка (для всяих тонкостей типо прозрачности выделения и тп )
    private void initPaint() {
        backPaint.setAntiAlias(true);
        backPaint.setColor(Color.parseColor("#60ffffff"));

        bubblePaint.setAntiAlias(true);
        bubblePaint.setColor(Color.parseColor("#90ffffff"));

        rectfPaint.setAntiAlias(true);
        rectfPaint.setColor(Color.parseColor("#ffffff"));
        rectfPaint.setAlpha(144); // задаем прозрачность
    }

    // слушатель касаний (грубо говоря)
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            // здесь содержится инфа о последней точке, где находится объект после окончания действия прикосновения ACTION_DOWN
            case MotionEvent.ACTION_MOVE:
                // координаты касания
                float x = (int) event.getX();
                float y = (int) event.getY();
                if (getDistance(x, y, backX, backY) < radiusBack) {
                    bubbleX = x;
                    bubbleY = y;
                } else if (getDistance(x, y, backX, backY) >= radiusBack) {
                    float xAndy[];
                    xAndy = getXY(x, y, backX, backY, getDistance(x, y, backX, backY));
                    bubbleX = xAndy[0];
                    bubbleY = xAndy[1];
                    getOrientation(x, y);
                }
                break;
            case MotionEvent.ACTION_UP:
                bubbleX = backX;
                bubbleY = backY;
                orientation = "STOP";
                break;
        }
        invalidate();
        return true;
    }

    // Определяем расстояние между точкой касания пальца и центром точки
    private float getDistance(float x1, float y1, float x2, float y2) {
        float dis;
        dis = (float) Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        return dis;
    }

    /*
    восстанавливаем положение джойстика
     */
    private float[] getXY(float x1, float y1, float x2, float y2, float dis) {
        float[] xAndy = new float[2];
        float scaleDis;
        float xDis;
        float yDis;

        // в рамках первого квадранта - левая четверть кргуа
        if (x1 > x2 && y1 < y2) {
            scaleDis = radiusBack / dis;
            xDis = Math.abs(x1 - x2);
            yDis = Math.abs(y1 - y2);
            xAndy[0] = x2 + xDis * scaleDis;
            xAndy[1] = y2 - yDis * scaleDis;

        }

        // В рамках второго квадранта - нижняя четверть круга

        else if (x1 < x2 && y1 < y2) {
            scaleDis = radiusBack / dis;
            xDis = Math.abs(x1 - x2);
            yDis = Math.abs(y1 - y2);
            xAndy[0] = x2 - xDis * scaleDis;
            xAndy[1] = y2 - yDis * scaleDis;
        }

        // В рамках второго квадранта - правая четверть круга

        else if (x1 < x2 && y1 > y2) {
            scaleDis = radiusBack / dis;
            xDis = Math.abs(x1 - x2);
            yDis = Math.abs(y1 - y2);
            xAndy[0] = x2 - xDis * scaleDis;
            xAndy[1] = y2 + yDis * scaleDis;
        }


         // В рамках второго квадранта - правя четверть круга

        else if (x1 > x2 && y1 > y2) {
            scaleDis = radiusBack / dis;
            xDis = Math.abs(x1 - x2);
            yDis = Math.abs(y1 - y2);
            xAndy[0] = x2 + xDis * scaleDis;
            xAndy[1] = y2 + yDis * scaleDis;
        }


        // если угол = 0 градусов

        else if (x1 > x2 && y1 == y2) {
            xAndy[0] = x2 + radiusBack;
            xAndy[1] = y2;

        }


         // если угол = 90 градусов

        else if (x1 == x2 && y1 < y2) {
            xAndy[0] = x2;
            xAndy[1] = y2 - radiusBack;
        }


         // если угол = 180 градусам

        else if (x1 < x2 && y1 == y2) {
            xAndy[0] = x2 - radiusBack;
            xAndy[1] = y2;
        }


         // если угол = 270 градусов

        else if (x1 == x2 && y1 > y2) {
            xAndy[0] = x2;
            xAndy[1] = y2 + radiusBack;

        }
        return xAndy;
    }


     // 4 части (направления) (для машинки)

    private void getOrientation(float x, float y) {
        // вертим джойстик в разные стороны - выставляются разные значения - выделяются разные области
        if (y < backY && (x < backX + backX * 0.707 && x > backY - backY * 0.707)) {
            orientation = "FORWARD";

        } else if (x > backX && (y < backY + backY * 0.707 && y > backY - backY * 0.707)) {
            orientation = "RIGHT";
        } else if (y > backY && (x < backX + backX * 0.707 && x > backY - backY * 0.707)) {
            orientation = "BACKWARD";
        } else if (x < backX && (y < backY + backY * 0.707 && y > backY - backY * 0.707)) {
            orientation = "LEFT";
        } else {
            orientation = "STOP";
        }
    }

}