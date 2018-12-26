package commontools;

import java.io.Serializable;
import java.util.Collection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

public class JsonArray extends JSONArray implements Serializable {

	public JsonArray() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JsonArray(Collection<?> collection) {
		super(collection);
		// TODO Auto-generated constructor stub
	}

	public JsonArray(JSONTokener x) throws JSONException {
		super(x);
		// TODO Auto-generated constructor stub
	}

	public JsonArray(Object array) throws JSONException {
		super(array);
		// TODO Auto-generated constructor stub
	}

	public JsonArray(String source) throws JSONException {
		super(source);
		// TODO Auto-generated constructor stub
	}

}
