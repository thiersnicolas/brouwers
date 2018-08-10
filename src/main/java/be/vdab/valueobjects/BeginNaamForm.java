package be.vdab.valueobjects;

import javax.validation.constraints.NotBlank;

public class BeginNaamForm {
	@NotBlank
	private String beginNaam;

	public String getBeginNaam() {
		return beginNaam;
	}

	public void setBeginNaam(String beginNaam) {
		this.beginNaam = beginNaam;
	}
}
