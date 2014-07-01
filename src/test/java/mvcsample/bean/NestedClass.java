package mvcsample.bean;

import java.util.LinkedList;
import java.util.List;

public class NestedClass {
    private List<InnerClass> inners;// = new LinkedList<InnerClass>();
    public List<InnerClass> getInners() {
		return inners;
	}

	public void setInners(List<InnerClass> inners) {
		this.inners = inners;
	}



	@Override
	public String toString() {
		return "NestedClass [inners=" + inners + "]";
	}



	public  class InnerClass {
        private String innerField;

		public String getInnerField() {
			return innerField;
		}

		public void setInnerField(String innerField) {
			this.innerField = innerField;
		}

		@Override
		public String toString() {
			return "InnerClass [innerField=" + innerField + "]";
		}

        //getter and setter
   }
}