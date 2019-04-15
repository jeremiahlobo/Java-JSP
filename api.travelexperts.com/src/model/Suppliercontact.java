package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the suppliercontacts database table.
 * 
 */
@Entity
@Table(name="suppliercontacts")
@NamedQuery(name="Suppliercontact.findAll", query="SELECT s FROM Suppliercontact s")
public class Suppliercontact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int supplierContactId;

	private String affiliationId;

	@Lob
	private String supConAddress;

	private String supConBusPhone;

	@Lob
	private String supConCity;

	@Lob
	private String supConCompany;

	@Lob
	private String supConCountry;

	@Lob
	private String supConEmail;

	private String supConFax;

	private String supConFirstName;

	private String supConLastName;

	@Lob
	private String supConPostal;

	@Lob
	private String supConProv;

	@Lob
	private String supConURL;

	private int supplierId;

	public Suppliercontact() {
	}

	public int getSupplierContactId() {
		return this.supplierContactId;
	}

	public void setSupplierContactId(int supplierContactId) {
		this.supplierContactId = supplierContactId;
	}

	public String getAffiliationId() {
		return this.affiliationId;
	}

	public void setAffiliationId(String affiliationId) {
		this.affiliationId = affiliationId;
	}

	public String getSupConAddress() {
		return this.supConAddress;
	}

	public void setSupConAddress(String supConAddress) {
		this.supConAddress = supConAddress;
	}

	public String getSupConBusPhone() {
		return this.supConBusPhone;
	}

	public void setSupConBusPhone(String supConBusPhone) {
		this.supConBusPhone = supConBusPhone;
	}

	public String getSupConCity() {
		return this.supConCity;
	}

	public void setSupConCity(String supConCity) {
		this.supConCity = supConCity;
	}

	public String getSupConCompany() {
		return this.supConCompany;
	}

	public void setSupConCompany(String supConCompany) {
		this.supConCompany = supConCompany;
	}

	public String getSupConCountry() {
		return this.supConCountry;
	}

	public void setSupConCountry(String supConCountry) {
		this.supConCountry = supConCountry;
	}

	public String getSupConEmail() {
		return this.supConEmail;
	}

	public void setSupConEmail(String supConEmail) {
		this.supConEmail = supConEmail;
	}

	public String getSupConFax() {
		return this.supConFax;
	}

	public void setSupConFax(String supConFax) {
		this.supConFax = supConFax;
	}

	public String getSupConFirstName() {
		return this.supConFirstName;
	}

	public void setSupConFirstName(String supConFirstName) {
		this.supConFirstName = supConFirstName;
	}

	public String getSupConLastName() {
		return this.supConLastName;
	}

	public void setSupConLastName(String supConLastName) {
		this.supConLastName = supConLastName;
	}

	public String getSupConPostal() {
		return this.supConPostal;
	}

	public void setSupConPostal(String supConPostal) {
		this.supConPostal = supConPostal;
	}

	public String getSupConProv() {
		return this.supConProv;
	}

	public void setSupConProv(String supConProv) {
		this.supConProv = supConProv;
	}

	public String getSupConURL() {
		return this.supConURL;
	}

	public void setSupConURL(String supConURL) {
		this.supConURL = supConURL;
	}

	public int getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

}