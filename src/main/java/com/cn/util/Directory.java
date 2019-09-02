package com.cn.util;

/**
 * @author chenyun
 * @projectName springboot
 * @description: 目录实体类
 * @date 2019/8/30 22:49
 */
public class Directory {

	private String name;

	private String path;

	private String type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Directory{" +
				"name='" + name + '\'' +
				", path='" + path + '\'' +
				", type='" + type + '\'' +
				'}';
	}
}
