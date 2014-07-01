package mvcsample.bean;

import java.util.HashMap;
import java.util.Map;

public class Model {

    private SubModel submodel = new SubModel();

	public SubModel getSubmodel() {
		return submodel;
	}

	public void setSubmodel(SubModel submodel) {
		this.submodel = submodel;
	}

}

class SubModel {

    private Map<String, String> props = new HashMap<>();

    public SubModel() {
    	props.put("name", "value");
    }
	public Map<String, String> getProps() {
		return props;
	}

	public void setProps(Map<String, String> props) {
		this.props = props;
	}
    
}