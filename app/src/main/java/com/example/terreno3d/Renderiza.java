package com.example.terreno3d;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.view.MotionEvent;

import com.example.terreno3d.FenceGate.Gate1;
import com.example.terreno3d.FenceGate.Gate2;
import com.example.terreno3d.FenceGate.GateLarge;
import com.example.terreno3d.Sprunce.Arbol1;
import com.example.terreno3d.Sprunce.Arbol2;
import com.example.terreno3d.Sprunce.Arbol3;
import com.example.terreno3d.Sprunce.SprunceWood;
import com.example.terreno3d.Tree.Tree1;
import com.example.terreno3d.Tree.Tree2;
import com.example.terreno3d.Tree.Tree3;
import com.example.terreno3d.Tree.TreeWood;

/**
 * Clase Renderiza (OpenGL 1.x)
 * 
 * @author Jhonny Felipez
 * @version 1.0 13/03/2014
 *
 */
public class Renderiza extends GLSurfaceView implements Renderer {
	
	/* Objeto */
	private Rectangulo piramide;
    private Rectangulo2 rectangulo2;
    private Lineas lineas;
    private Punto punto;

    private Objexample2 objexample;

    //Diseños
    private Arbol1 arbol1;
    private Arbol2 arbol2;
    private Arbol3 arbol3;
    private SprunceWood sprunceWood;

    private Tree1 tree1;
    private Tree2 tree2;
    private Tree3 tree3;
    private TreeWood treeWood;

    private Gate1 gate1;
    private Gate2 gate2;

    private GateLarge gateLarge;

    private House house;

	float rotZ = 0;
//	float rotX = 0;
//	float rotY = 0;

    private float rotX;
    private float rotY;
    private float antX;
    private float antY;

    private Context ctx;



    public Renderiza(Context contexto) {

        super(contexto);
        this.ctx = contexto;
        /* Se inicia el renderizado */
        this.setRenderer(this);
        /* La ventana solicita recibir una entrada */
        this.requestFocus();
        /* Se establece que la ventana detecte el modo táctil */
        this.setFocusableInTouchMode(true);
        /* Se renderizará al inicio o cuando se llame a requestRender() */
        this.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }

    @Override
	public void onSurfaceCreated(GL10 gl, EGLConfig arg1) {
	 
		piramide = new Rectangulo();
		lineas = new Lineas();
		punto = new Punto();

        objexample = new Objexample2(ctx);

        rectangulo2 = new Rectangulo2();

        //OBJ
        arbol1 = new Arbol1(ctx);
        arbol2 = new Arbol2(ctx);
        arbol3 = new Arbol3(ctx);
        sprunceWood = new SprunceWood(ctx);

        tree1 = new Tree1(ctx);
        tree2 = new Tree2(ctx);
        tree3 = new Tree3(ctx);
        treeWood = new TreeWood(ctx);

        gate1 = new Gate1(ctx);
        gate2 = new Gate2(ctx);

        gateLarge = new GateLarge(ctx);

        house = new House(ctx);

		gl.glShadeModel(GL10.GL_FLAT);

		gl.glEnable(GL10.GL_DEPTH_TEST);
		
		/* Color de fondo */
		gl.glClearColor(0, 0, 0, 0);
	}
	
	@Override
	public void onDrawFrame(GL10 gl) {
//        arbol1.dibuja(gl);
//        arbol2.dibuja(gl);
//        arbol3.dibuja(gl);
//        sprunceWood.dibuja(gl);
//        tree1.dibuja(gl);
//        tree2.dibuja(gl);
//        treeWood.dibuja(gl);
//        gate1.dibuja(gl);
//        gate2.dibuja(gl);
//        gateLarge.dibuja(gl);
//        house.dibuja(gl);

		/* Inicializa el buffer de color */
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		
		gl.glLoadIdentity();

        gl.glPushMatrix();
		gl.glTranslatef(0, 0, 0);
		gl.glRotatef(rotY, 1.0f, 0.0f, 0.0f);
		gl.glRotatef(rotX, 0.0f, 1.0f, 0.0f);
//		gl.glRotatef(rotZ, 0.0f, 0.0f, 1.0f);
//		gl.glScalef(0.8f,0.8f,0.8f);
        rectangulo2.dibuja(gl);
            gl.glPushMatrix();

            gl.glTranslatef(0, 0, 0);
            gl.glScalef(0.23f,0.23f,0.23f);
            house.dibuja(gl);

            gl.glPopMatrix();

            gl.glPushMatrix();

            gl.glTranslatef(-50, -3, 100);
            gl.glScalef(4f,4f,4f);
            arbol1.dibuja(gl);


            gl.glPopMatrix();

            gl.glPushMatrix();

            gl.glTranslatef(-10, -3, 100);
            gl.glScalef(4f,4f,4f);
            arbol1.dibuja(gl);


            gl.glPopMatrix();

            gl.glPushMatrix();

            gl.glTranslatef(-50, -3, 60);
            gl.glScalef(5.5f,5.5f,5.5f);
            arbol1.dibuja(gl);


            gl.glPopMatrix();

            gl.glPushMatrix();

            gl.glTranslatef(30, 0, 60);
            gl.glScalef(5f,5f,5f);
            arbol2.dibuja(gl);


            gl.glPopMatrix();

            gl.glPushMatrix();

            gl.glTranslatef(10, 0, 100);
            gl.glScalef(4f,4f,4f);
            arbol2.dibuja(gl);

            gl.glPopMatrix();


            gl.glPushMatrix();

            gl.glTranslatef(30, -3, -100);
            gl.glScalef(6f,6f,6f);
            arbol3.dibuja(gl);


            gl.glPopMatrix();

            gl.glPushMatrix();

            gl.glTranslatef(50, -3, -70);
            gl.glScalef(4f,4f,4f);
            arbol3.dibuja(gl);

            gl.glPopMatrix();


            gl.glPushMatrix();

            gl.glTranslatef(-10, -3, -100);
            gl.glScalef(4f,4f,4f);
            arbol3.dibuja(gl);


            gl.glPopMatrix();

            gl.glPushMatrix();

            gl.glTranslatef(35, -5, 100);
            gl.glScalef(4f,4f,4f);
            sprunceWood.dibuja(gl);

            gl.glPopMatrix();

            gl.glPushMatrix();

            gl.glTranslatef(40, -5, 100);
            gl.glScalef(4f,4f,4f);
            sprunceWood.dibuja(gl);

            gl.glPopMatrix();

            gl.glPushMatrix();

            gl.glTranslatef(45, -5, 100);
            gl.glScalef(4f,4f,4f);
            sprunceWood.dibuja(gl);

            gl.glPopMatrix();


            gl.glPushMatrix();

            gl.glTranslatef(-50, -8, -30);
            gl.glScalef(4f,4f,4f);
            tree1.dibuja(gl);

            gl.glPopMatrix();


            gl.glPushMatrix();

            gl.glTranslatef(-37, -8, -50);
            gl.glScalef(5f,5f,5f);
            tree1.dibuja(gl);

            gl.glPopMatrix();


            gl.glPushMatrix();

            gl.glTranslatef(-35, -8, -50);
            gl.glScalef(4f,4f,4f);
            tree2.dibuja(gl);

            gl.glPopMatrix();

            gl.glPushMatrix();

            gl.glTranslatef(60, -8, 0);
            gl.glScalef(4f,4f,4f);
            tree3.dibuja(gl);

            gl.glPopMatrix();


            gl.glPushMatrix();

            gl.glTranslatef(60, -8, 40);
            gl.glScalef(4f,4f,4f);
            tree3.dibuja(gl);

            gl.glPopMatrix();


            gl.glPushMatrix();

            gl.glTranslatef(80, 0, 20);
            gl.glScalef(4f,4f,4f);
            treeWood.dibuja(gl);

            gl.glPopMatrix();


            gl.glPushMatrix();

            gl.glTranslatef(50, -3, 20);
            gl.glScalef(4f,4f,4f);
            gateLarge.dibuja(gl);

            gl.glPopMatrix();

            gl.glPushMatrix();

            gl.glTranslatef(80, -3, -65);
            gl.glRotatef(90,0,1,0);
            gl.glScalef(4f,4f,4f);
            gateLarge.dibuja(gl);

            gl.glPopMatrix();

            gl.glPushMatrix();

            gl.glTranslatef(80, -3, -35);
            gl.glRotatef(90,0,1,0);
            gl.glScalef(4f,4f,4f);
            gateLarge.dibuja(gl);


            gl.glPopMatrix();

            gl.glPushMatrix();

            gl.glTranslatef(50, -3, 90);
            gl.glScalef(4f,4f,4f);
            gateLarge.dibuja(gl);

            gl.glPopMatrix();




        gl.glPopMatrix();

	}
	
	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
	 
		/* Ventana de despliegue */
		gl.glViewport(0, 0, width, height);
	 
		/* Matriz de Proyecci�n */
		gl.glMatrixMode(GL10.GL_PROJECTION);
	 
		/* Inicializa la Matriz de Proyecci�n */
		gl.glLoadIdentity();
	 
		/* Proyecci�n paralela */
		//          -x, x, -y, y, -z, z
		gl.glOrthof(-80, 80, -120, 120, -200, 200);
		//gl.glOrthof
	 
		/* Matriz del Modelo-Vista */
		gl.glMatrixMode(GL10.GL_MODELVIEW);
	 
		/* Inicializa la Matriz del Modelo-Vista */
		gl.glLoadIdentity();
	}

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        float x = e.getX();
        float y = e.getY();
        switch (e.getAction()) {
            case MotionEvent.ACTION_MOVE:

                float dx = x - antX;
                float dy = y - antY;
                rotX = rotX + dx * 0.5625f; // 180 / 320 = 0.5625
                rotY = rotY + dy * 0.5625f;
                requestRender();
        }
        antX = x;
        antY = y;
        return true;
    }
}
