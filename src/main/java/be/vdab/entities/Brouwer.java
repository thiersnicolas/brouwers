package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import be.vdab.valueobjects.Adres;

public class Brouwer implements Serializable{
	private static final long serialVersionUID = 1L;
	private long id;
	@NotBlank
	@Length(min=1, max=50)
	@SafeHtml
	private String naam;
	@NumberFormat(style=Style.NUMBER)
	@Min(0)
	@NotNull
	@Digits(integer=10, fraction=2)
	private BigDecimal omzet;
	@Valid
	private Adres adres;
	
	public Brouwer() {}
	
	public Brouwer(String naam, BigDecimal omzet, Adres adres) {
		this.naam = naam;
		this.omzet = omzet;
		this.adres = adres;
	}

	public Brouwer(long id, String naam, Adres adres, BigDecimal omzet) {
		this(naam, omzet, adres);
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public BigDecimal getOmzet() {
		return omzet;
	}

	public void setOmzet(BigDecimal omzet) {
		this.omzet = omzet;
	}

	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}
	
	
}
