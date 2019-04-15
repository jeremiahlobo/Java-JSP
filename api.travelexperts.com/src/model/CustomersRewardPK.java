package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the customers_rewards database table.
 * 
 */
@Embeddable
public class CustomersRewardPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int customerId;

	private int rewardId;

	public CustomersRewardPK() {
	}
	public int getCustomerId() {
		return this.customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getRewardId() {
		return this.rewardId;
	}
	public void setRewardId(int rewardId) {
		this.rewardId = rewardId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CustomersRewardPK)) {
			return false;
		}
		CustomersRewardPK castOther = (CustomersRewardPK)other;
		return 
			(this.customerId == castOther.customerId)
			&& (this.rewardId == castOther.rewardId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.customerId;
		hash = hash * prime + this.rewardId;
		
		return hash;
	}
}