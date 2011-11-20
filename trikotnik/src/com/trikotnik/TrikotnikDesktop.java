package com.trikotnik;


import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;

public class TrikotnikDesktop implements ApplicationListener{
	private Mesh[] faces;
    private OrthographicCamera camera;
    private float rotationSpeed;
    private int total = 0;
    private float movementIncrement = 0.0010f;

    
   

	
	
	@Override
	public void create() {
		
       
		Gdx.gl.glEnable(GL10.GL_DEPTH_TEST);
		rotationSpeed = 1.0f;

      
	if (faces == null) {
	      faces = new Mesh[6];
	 
	      for (int i = 0; i < 6; i++) {
	        faces[i] = new Mesh(true, 4, 4,
	            new VertexAttribute(Usage.Position, 3, "pozicija"),
	            new VertexAttribute(Usage.ColorPacked, 4, "barva"));
	 
	        faces[i].setIndices(new short[] { 0, 1, 2, 3 });
	      }
	    
	 
	      faces[0].setVertices(new float[] {
		          0.5f, 0.5f, 0.5f, Color.toFloatBits(255, 0, 0, 0),
		          -0.5f, 0.5f, 0.5f, Color.toFloatBits(255, 0, 0, 0),
		          0.5f, -0.5f, 0.5f, Color.toFloatBits(255, 0, 0, 0),
		          -0.5f, -0.5f, 0.5f, Color.toFloatBits(255, 0, 0, 0) });
		 
		      faces[1].setVertices(new float[] {
		          0.5f, 0.5f, -0.5f, Color.toFloatBits(255, 255, 0, 0),
		          -0.5f, 0.5f, -0.5f, Color.toFloatBits(255, 255, 0, 0),
		          0.5f, -0.5f, -0.5f,  Color.toFloatBits(255, 255, 0, 0),
		          -0.5f, -0.5f, -0.5f, Color.toFloatBits(255, 255, 0, 0) });
		 
		      faces[2].setVertices(new float[] {
		          0.5f, 0.5f, -0.5f, Color.toFloatBits(0, 255, 0, 0),
		          -0.5f, 0.5f, -0.5f, Color.toFloatBits(0, 255, 0, 0),
		          0.5f, 0.5f, 0.5f, Color.toFloatBits(0, 255, 0, 0),
		          -0.5f, 0.5f, 0.5f, Color.toFloatBits(0, 255, 0, 0) });
		 
		      faces[3].setVertices(new float[] {
		          0.5f, -0.5f, -0.5f, Color.toFloatBits(255, 255, 255, 0),
		          -0.5f, -0.5f, -0.5f, Color.toFloatBits(255, 255, 255, 0),
		          0.5f, -0.5f, 0.5f, Color.toFloatBits(255, 255, 255, 0),
		          -0.5f, -0.5f, 0.5f,  Color.toFloatBits(255, 255, 255, 0) });
		 
		      faces[4].setVertices(new float[] {
		          0.5f, 0.5f, 0.5f, Color.toFloatBits(0, 255, 255, 0),
		          0.5f, -0.5f, 0.5f, Color.toFloatBits(0, 255, 255, 0),
		          0.5f, 0.5f, -0.5f, Color.toFloatBits(0, 255, 255, 0),
		          0.5f, -0.5f, -0.5f, Color.toFloatBits(0, 255, 255, 0) });
		 
		      faces[5].setVertices(new float[] {
		          -0.5f, 0.5f, 0.5f, Color.toFloatBits(0, 0, 255, 0),
		          -0.5f, -0.5f, 0.5f, Color.toFloatBits(0, 0, 255, 0),
		          -0.5f, 0.5f, -0.5f, Color.toFloatBits(0, 0, 255, 0),
		          -0.5f, -0.5f, -0.5f, Color.toFloatBits(0, 0, 255, 0) });
	}
	
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void render() {

		handleInput();

        total += 1;
        if (total > 500) {
            movementIncrement = -movementIncrement;
            total = -200;
        }



        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
       
            camera.update();
            camera.apply(Gdx.gl10);
            
            for (Mesh face : faces) {
            	
            	
                face.render(GL10.GL_TRIANGLE_STRIP, 0,4);
              }
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
		 float aspectRatio = (float) width / (float) height;
         camera = new OrthographicCamera(2f * aspectRatio, 2f);

	}

	@Override
    public void resume() { }
    
    private void handleInput() {
    
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
        	camera.rotate(-rotationSpeed, 0,0 , 1);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                camera.rotate(rotationSpeed, 0, 0, 1);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)) {
            camera.rotate(rotationSpeed, 0, 1, 0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)) {
            camera.rotate(rotationSpeed, 0, -1, 0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            camera.rotate(rotationSpeed, 1, 0, 0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            camera.rotate(-rotationSpeed, 1, 0, 0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)) {
            camera.zoom += 0.02;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.W)) {
            camera.zoom-=0.02;
        }
       
}
}