package example;

public class RefectClassExp {

	public static Class createClass(String name) {
		Class clazz = null;
		try {
			clazz = Class.forName(name);
		} catch (ClassNotFoundException e) {
			//
		}
		return clazz;
	}

}
