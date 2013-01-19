package mvcsample.types;
import java.util.List;

public class ListWrapper<T> {
    private List<T> aaData;
    private int iTotalRecords;
    private int iTotalDisplayRecords;
    private  Boolean success;

    public List<T> getAaData() {
		return aaData;
	}
	public void setAaData(List<T> aaData) {
		this.aaData = aaData;
	}
	public int getiTotalRecords() {
		return iTotalRecords;
	}
	public void setiTotalRecords(int iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}
	public int getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}
	public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	@Override
	public String toString() {
		return "ListWrapper [aaData=" + aaData + ", iTotalRecords="
				+ iTotalRecords + ", iTotalDisplayRecords="
				+ iTotalDisplayRecords + ", success=" + success + "]";
	}

	
      
}