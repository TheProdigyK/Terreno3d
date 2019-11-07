package com.example.terreno3d;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;

/**
 * Programa que despliega un Tri�ngulo en OpenGL ES 1.x.
 * 
 * @author Jhonny Felipez
 * @version 1.0 13/03/2014
 *
 */
public class MainActivity extends Activity {

	private GLSurfaceView superficie;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/* Ventana sin título */
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		/* Se establece las banderas de la ventana de esta Actividad */
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		/* Se crea el objeto Renderiza */
		superficie = new Renderiza2(this);
		/*
		 * Activity <- GLSurfaceView : Coloca la Vista de la Superficie del
		 * OpenGL como un Contexto de ésta Actividad.
		 */
		setContentView(superficie);
// setContentView(R.layout.activity_main);
	}

	/**
	 * Recuerda que debe reanudar superficie
	 */
	@Override
	protected void onResume() {
		super.onResume();
		superficie.onResume();
	}
	/**
	 * También pausa la superficie
	 */
	@Override
	protected void onPause() {
		super.onPause();
		superficie.onPause();
	}
}
