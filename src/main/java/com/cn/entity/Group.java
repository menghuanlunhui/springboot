package com.cn.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 组织信息
 */
public class Group implements Serializable {

	/**
	 * 主键id
	 */
	private String id;
	/**
	* 名字
	*/
	private  String name; 
	/**
	* 父ID
	*/
	private  String parentId; 
	/**
	* 编码
	*/
	private  String code; 
	/**
	* 类型
	*/
	private  Integer type; 
	/**
	* 描述
	*/
	private  String desc; 
	/**
	* path_
	*/
	private  String path; 
	/**
	* 排序
	*/
	private  Integer sn;
	
	/**
	 *  前端字段
	 */
	private String parentName;

	private Date createTime;

	private Date  updateTime;

	private String createBy;

	private String updateBy;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getSn() {
		return sn;
	}

	public void setSn(Integer sn) {
		this.sn = sn;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
}