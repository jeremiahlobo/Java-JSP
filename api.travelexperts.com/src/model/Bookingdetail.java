package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the bookingdetails database table.
 * 
 */
@Entity
@Table(name="bookingdetails")
@NamedQuery(name="Bookingdetail.findAll", query="SELECT b FROM Bookingdetail b")
public class Bookingdetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int bookingDetailId;

	private BigDecimal agencyCommission;

	private BigDecimal basePrice;

	private int bookingId;

	private String classId;

	@Lob
	private String description;

	@Lob
	private String destination;

	private String feeId;

	private double itineraryNo;

	private int productSupplierId;

	private String regionId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date tripEnd;

	@Temporal(TemporalType.TIMESTAMP)
	private Date tripStart;

	public Bookingdetail() {
	}

	public int getBookingDetailId() {
		return this.bookingDetailId;
	}

	public void setBookingDetailId(int bookingDetailId) {
		this.bookingDetailId = bookingDetailId;
	}

	public BigDecimal getAgencyCommission() {
		return this.agencyCommission;
	}

	public void setAgencyCommission(BigDecimal agencyCommission) {
		this.agencyCommission = agencyCommission;
	}

	public BigDecimal getBasePrice() {
		return this.basePrice;
	}

	public void setBasePrice(BigDecimal basePrice) {
		this.basePrice = basePrice;
	}

	public int getBookingId() {
		return this.bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getClassId() {
		return this.classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getFeeId() {
		return this.feeId;
	}

	public void setFeeId(String feeId) {
		this.feeId = feeId;
	}

	public double getItineraryNo() {
		return this.itineraryNo;
	}

	public void setItineraryNo(double itineraryNo) {
		this.itineraryNo = itineraryNo;
	}

	public int getProductSupplierId() {
		return this.productSupplierId;
	}

	public void setProductSupplierId(int productSupplierId) {
		this.productSupplierId = productSupplierId;
	}

	public String getRegionId() {
		return this.regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public Date getTripEnd() {
		return this.tripEnd;
	}

	public void setTripEnd(Date tripEnd) {
		this.tripEnd = tripEnd;
	}

	public Date getTripStart() {
		return this.tripStart;
	}

	public void setTripStart(Date tripStart) {
		this.tripStart = tripStart;
	}

}