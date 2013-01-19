package mvcsample.types;

import java.util.ArrayList;
import java.util.List;

public class TypeWrapper<T> {
    private List<T> data;
    private  Boolean success;
    
    public TypeWrapper(){
    }
    
    public TypeWrapper(List<T> data, Boolean success){
        this.data = data;
        this.success = success;
    }

    public List<T> getData() {
        return data;
    }

    public Boolean getSuccess() {
        return success;
    }

	public void setData(List<T> data) {
		this.data = data;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	@Override
	public String toString() {
		return "TypeWrapper [data=" + data + ", success=" + success + "]";
	}
    
    
        
}
