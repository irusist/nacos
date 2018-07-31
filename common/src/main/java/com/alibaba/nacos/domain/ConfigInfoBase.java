/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.nacos.domain;

import java.io.PrintWriter;
import java.io.Serializable;

import com.alibaba.nacos.common.util.MD5;

/**
 * 不能增加字段，为了兼容老前台接口（老接口增加一个字段会出现不兼容问题）设置的model。
 * 
 * @author Nacos
 *
 */
public class ConfigInfoBase implements Serializable, Comparable<ConfigInfoBase> {
	static final long serialVersionUID = -1L;
	
	/**
	 *  不能增加字段
	 */
	private long id;
	private String dataId;
	private String group;
	private String content;
	private String md5;

	public ConfigInfoBase() {

	}

	public ConfigInfoBase(String dataId, String group, String content) {
		this.dataId = dataId;
		this.group = group;
		this.content = content;
		if (this.content != null) {
			this.md5 = MD5.getInstance().getMD5String(this.content);
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDataId() {
		return dataId;
	}

	public void setDataId(String dataId) {
		this.dataId = dataId;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public void dump(PrintWriter writer) {
		writer.write(this.content);
	}

	public int compareTo(ConfigInfoBase o) {
		if (o == null) {
			return 1;
		}
		if (this.dataId == null ){
			if (o.getDataId() == null) {
				return 0;
			} else {
				return -1;
			}
		} else {
			if (o.getDataId() == null) {
				return 1;
			} else {
				int cmpDataId = this.dataId.compareTo(o.getDataId());
				if (cmpDataId != 0) {
					return cmpDataId;
				}
			}
		}
		
		if (this.group == null) {
			if (o.getGroup() == null) {
				return 0;
			} else {
				return -1;
			}
		} else {
			if (o.getGroup() == null) {
				return 1;
			} else {
				int cmpGroup = this.group.compareTo(o.getGroup());
				if (cmpGroup != 0) {
					return cmpGroup;
				}
			}
		}
		
		if (this.content == null) {
			if (o.getContent() == null) {
				return 0;
			} else {
				return -1;
			}
		} else {
			if (o.getContent() == null) {
				return 1;
			} else {
				int cmpContent = this.content.compareTo(o.getContent());
				if (cmpContent != 0) {
					return cmpContent;
				}
			}
		}
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((dataId == null) ? 0 : dataId.hashCode());
		result = prime * result + ((group == null) ? 0 : group.hashCode());
		result = prime * result + ((md5 == null) ? 0 : md5.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ConfigInfoBase other = (ConfigInfoBase) obj;
		if (content == null) {
			if (other.content != null) {
				return false;
			}
		} else if (!content.equals(other.content)) {
			return false;
		}
		if (dataId == null) {
			if (other.dataId != null) {
				return false;
			}
		} else if (!dataId.equals(other.dataId)) {
			return false;
		}
		if (group == null) {
			if (other.group != null) {
				return false;
			}
		} else if (!group.equals(other.group)) {
			return false;
		}
		if (md5 == null) {
			if (other.md5 != null) {
				return false;
			}
		} else if (!md5.equals(other.md5)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ConfigInfoBase{" + "id=" + id + ", dataId='" + dataId + '\''
				+ ", group='" + group + '\'' + ", content='" + content + '\''
				+ ", md5='" + md5 + '\'' + '}';
	}
}
