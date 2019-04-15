package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the classes database table.
 * 
 */
@Entity
@NamedQuery(name="Classes.findAll", query="SELECT c FROM Classes c")
public class Classes implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String classId;

	private String classDesc;

	private String className;

	public Classes() {
	}

	public String getClassId() {
		return this.classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getClassDesc() {
		return this.classDesc;
	}

	public void setClassDesc(String classDesc) {
		this.classDesc = classDesc;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

}