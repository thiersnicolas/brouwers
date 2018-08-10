package be.vdab.valueobjects;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.SafeHtml;

public class Adres implements Serializable {
	private static final long serialVersionUID = 1L;
	@NotBlank
	@Length(min=1, max=50)
	@SafeHtml
	private String straat;
	@NotBlank
	@Length(min=1, max=7)
	@SafeHtml
	private String huisNr;
	@NotBlank
	@Length(min=1, max=50)
	@SafeHtml
	private String gemeente;
	@NotNull
	@Range(min=1000, max=9999)
	private Integer postcode;
	
	public Adres() {}
	
	public Adres(String straat, String huisNr, Integer postcode, String gemeente) {
		this.straat = straat;
		this.huisNr = huisNr;
		this.gemeente = gemeente;
		this.postcode = postcode;
	}
	public String getStraat() {
		return straat;
	}
	public String getHuisNr() {
		return huisNr;
	}
	public String getGemeente() {
		return gemeente;
	}
	public Integer getPostcode() {
		return postcode;
	}
	
	

}
