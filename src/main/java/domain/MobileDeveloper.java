package domain;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("MD")
@Table(name="MOBILE_DEV")
public class MobileDeveloper extends Developer implements Serializable {

	private String Os;

	public MobileDeveloper() {}

	public MobileDeveloper(String os) {
		this.Os = Os;
	}

	public String getOs() {
		return Os;
	}

	public void setOs(String os) {
		Os = os;
	}

}
