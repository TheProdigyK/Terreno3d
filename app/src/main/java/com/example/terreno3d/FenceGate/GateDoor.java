package com.example.terreno3d.FenceGate;

import android.content.Context;

import com.example.terreno3d.ObjLoader;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class GateDoor {

    private Context context;
    ObjLoader objLoader, objLoader2;


    private FloatBuffer bufVertices;
    private ShortBuffer bufIndices;
    private ShortBuffer bufIndices2;
    private ByteBuffer bufColores;



    public GateDoor(Context ctx) {
        this.context = ctx;
        /* Lee los v�rtices */
        objLoader = new ObjLoader(context, "FenceGate/Gate Door ver. 1.obj");
        objLoader2 = new ObjLoader(context, "FenceGate/Fence Gate (Right Part) ver. 1.obj");



        ByteBuffer bufByte = ByteBuffer.allocateDirect(objLoader.positions.length * 4);
        bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
        bufVertices = bufByte.asFloatBuffer(); // Convierte de byte a float
        bufVertices.put(objLoader.positions);
        bufVertices.rewind(); // puntero al principio del buffer

        /* Lee los indices */
        bufByte = ByteBuffer.allocateDirect(objLoader.normals.length * 2);
        bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
        bufIndices = bufByte.asShortBuffer(); // Convierte de byte a short
        bufIndices.put(objLoader.normals);
        bufIndices.rewind(); // puntero al principio del buffer


        bufByte = ByteBuffer.allocateDirect(objLoader2.normals.length * 2);
        bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
        bufIndices2 = bufByte.asShortBuffer(); // Convierte de byte a short
        bufIndices2.put(objLoader2.normals);
        bufIndices2.rewind(); // puntero al principio del buffer
    }
    public void dibuja(GL10 gl) {


        /* Se habilita el acceso al arreglo de v�rtices */
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

        /* Se especifica los datos del arreglo de v�rtices */
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);

        gl.glColor4f(0, 1, 0, 0);

        /* Dibuja el cubo */
        gl.glDrawElements(GL10.GL_TRIANGLES, objLoader.normals.length,
                GL10.GL_UNSIGNED_SHORT, bufIndices);




        /* Se deshabilita el acceso al arreglo de v�rtices */
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);


    }

}
