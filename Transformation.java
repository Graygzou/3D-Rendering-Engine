
import algebra.*;

/**
 * author: cdehais
 */
public class Transformation  {

	Matrix worldToCamera;
	Matrix projection;
	Matrix calibration;

	public Transformation () {
		try {
			worldToCamera = new Matrix ("W2C", 4, 4);
			projection = new Matrix ("P", 3, 4);
			calibration = Matrix.createIdentity (3);
			calibration.setName ("K");
		} catch (InstantiationException e) {
			/* should not reach */
		}
	}

	public void setLookAt (Vector3 cam, Vector3 lookAt, Vector3 up) {
		System.out.println ("cam:\n" + cam);
		System.out.println ("lookAt:\n" + lookAt);
		System.out.println ("up:\n" + up);
		try {
			// compute rotation
			// Poi
			Vector3 zc = new Vector3(lookAt);
			// Poi - Peye
			zc.subtract(cam);
			// PeyePoi/norm(PeyePoi)
			zc.normalize();
			// xc = up /\ zc
			Vector3 xc = new Vector3(up.cross(zc));
			xc.normalize();
			// yc = zc /\ xc
			Vector3 yc = new Vector3(zc.cross(xc));
			yc.normalize();
			Matrix rotation = new Matrix(3, 3);
			rotation.set(0, 0, xc.getX());
			rotation.set(0, 1, xc.getY());
			rotation.set(0, 2, xc.getZ());
			rotation.set(1, 0, yc.getX());
			rotation.set(1, 1, yc.getY());
			rotation.set(1, 2, yc.getZ());
			rotation.set(2, 0, zc.getX());
			rotation.set(2, 1, zc.getY());
			rotation.set(2, 2, zc.getZ());
			// compute translation
			Vector3 moinsPeye = new Vector3();
			moinsPeye.set(0,-cam.getX());
			moinsPeye.set(1,-cam.getY());
			moinsPeye.set(2,-cam.getZ());
			Vector translation = rotation.multiply(moinsPeye);
			// Insertion dans worldToCamera
			// ligne 0
			worldToCamera.set(0, 0, rotation.get(0,0));
			worldToCamera.set(0, 1, rotation.get(0,1));
			worldToCamera.set(0, 2, rotation.get(0, 2));
			worldToCamera.set(0, 3, translation.get(0));
			// ligne 1
			worldToCamera.set(1, 0, rotation.get(1, 0));
			worldToCamera.set(1, 1, rotation.get(1, 1));
			worldToCamera.set(1, 2, rotation.get(1, 2));
			worldToCamera.set(1, 3, translation.get(1));
			// ligne 2
			worldToCamera.set(2, 0, rotation.get(2, 0));
			worldToCamera.set(2, 1, rotation.get(2, 1));
			worldToCamera.set(2, 2, rotation.get(2, 2));
			worldToCamera.set(2, 3, translation.get(2));
			// ligne 3
			worldToCamera.set(3, 0, 0);
			worldToCamera.set(3, 1, 0);
			worldToCamera.set(3, 2, 0);
			worldToCamera.set(3, 3, 1);
		} catch (Exception e) { /* unreached */ };
		System.out.println ("Modelview matrix:\n" + worldToCamera);
	}

	public void setProjection () {
		projection.set(0, 0, 1);
		projection.set(1, 1, 1);
		projection.set(2, 2, 1);
		System.out.println ("Projection matrix:\n" + projection);
	}

	public void setCalibration (double focal, double width, double height) {
		try {
			// reset de la matrice par securite
			calibration = Matrix.createIdentity(3);
			calibration.setName ("K");
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			calibration.set(0, 0, focal);
			calibration.set(1, 1, focal);
			calibration.set(0, 2, width/2);
			calibration.set(1, 2, height/2);
		} catch (Exception e) { /* unreached */ };
		System.out.println ("Calibration matrix:\n" + calibration);
	}

	/**
	 * Projects the given homogeneous, 4 dimensional point onto the screen.
	 * The resulting Vector as its (x,y) coordinates in pixel, and its z coordinate
	 * is the depth of the point in the camera coordinate system.
	 */  
	public Vector3 projectPoint (Vector p)
			throws SizeMismatchException, InstantiationException {
		Vector ps = new Vector(3);
		// Passage du repere Monde au repere Camera
		Vector ps4D = worldToCamera.multiply(p);
		// Projection 3D->2D
		ps = projection.multiply(ps4D);
		// Projection 2D-> 2D
		ps = calibration.multiply(ps);
		ps.set(0,ps.get(0)/ps.get(2));
		ps.set(1,ps.get(1)/ps.get(2));
		return new Vector3 (ps);
	}

	/**
	 * Transform a vector from world to camera coordinates.
	 */
	public Vector3 transformVector (Vector3 v)
			throws SizeMismatchException, InstantiationException {
		/* Doing nothing special here because there is no scaling */
		Matrix R = worldToCamera.getSubMatrix (0, 0, 3, 3);
		Vector tv = R.multiply (v);
		return new Vector3 (tv);
	}

}

