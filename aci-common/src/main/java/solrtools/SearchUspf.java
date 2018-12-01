package solrtools;

import java.io.Serializable;
/**
 * 搜索的商品数据POJO
 * @title SearchItem.java
 * <p>description</p>
 * <p>company: www.itheima.com</p>
 * @author ljh 
 * @version 1.0
 */
public class SearchUspf implements Serializable {
	private Long userid;//商品的id 
	private String username;//商品标题
	private String position;//商品卖点

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}


}
