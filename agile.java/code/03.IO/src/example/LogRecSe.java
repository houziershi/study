package example;

import java.util.*;
import java.io.*;

public class LogRecSe implements Serializable {
	public static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private Date createTime;
	private transient Date updateTime;

	public LogRecSe() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
