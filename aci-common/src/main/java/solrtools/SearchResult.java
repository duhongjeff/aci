package solrtools;

import java.io.Serializable;
import java.util.List;

import com.sg.cp.model.UspfEnh;
/**
 * 商品搜索的分页信息结果对象
 * @title SearchResult.java
 * <p>description</p>
 * <p>company: www.itheima.com</p>
 * @author ljh 
 * @version 1.0
 */
public class SearchResult implements Serializable {
	private List<UspfEnh> uspfList;// 搜索结果列表
	private long recordCount;// 总记录数
	private long pageCount;// 总页数
	public List<UspfEnh> getUspfList() {
		return uspfList;
	}
	public void setUspfList(List<UspfEnh> uspfList) {
		this.uspfList = uspfList;
	}
	public long getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(long recordCount) {
		this.recordCount = recordCount;
	}
	public long getPageCount() {
		return pageCount;
	}
	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}
	
	


}
