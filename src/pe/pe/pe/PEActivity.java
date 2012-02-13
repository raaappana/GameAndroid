package pe.pe.pe;

import android.app.Activity;
import android.os.Bundle;

public class PEActivity extends Activity 
 {

	private BasicGLSurfaceView mView;

	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		mView = new BasicGLSurfaceView(getApplication());
		setContentView(mView);
	}

	@Override
	protected void onPause() {
		super.onPause();
		mView.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
		mView.onResume();
	}

	/** Called when the activity is first created. */
   /* @Override    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Update();
				Draw();
			}
		}).start();
    }*/
}
