package pe.pe.pe;

import android.content.Context;
import android.opengl.GLSurfaceView;

import android.opengl.GLES20;

class BasicGLSurfaceView extends GLSurfaceView {
    public BasicGLSurfaceView(Context context) {
        super(context);
        setEGLContextClientVersion(2);
        setRenderer(new GLES20TriangleRenderer(context));
    }
}

