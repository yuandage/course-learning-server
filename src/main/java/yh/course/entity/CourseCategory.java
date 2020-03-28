package yh.course.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Entity
@Table(name = "course_category")
public class CourseCategory {
	@Id
	private String id;//ID
	private String name;//名称
	private String parentId;//父节点
	@Transient
	private List<CourseCategory> children;

	public List<CourseCategory> getChildren() {
		return children;
	}

	public void setChildren(List<CourseCategory> children) {
		this.children = children;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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
}
