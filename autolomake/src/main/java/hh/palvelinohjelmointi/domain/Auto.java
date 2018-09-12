package hh.palvelinohjelmointi.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Auto {
	
	@NotNull
	@Size(min=3, max=20)
	private String merkki;
	
    @Size(min=1, max=30)
	private String malli;
    
    @Size(min=3, max=7)
    private String rekno;
    
    
    
    
    public Auto(String merkki, String malli, String rekno) {
    	
    	super();
    	this.merkki = merkki;
    	this.malli = malli;
    	this.rekno = rekno;
    	
    }

	public Auto() {
		// TODO Auto-generated constructor stub
	}

	public String getMerkki() {
		return merkki;
	}

	public void setMerkki(String merkki) {
		this.merkki = merkki;
	}

	public String getMalli() {
		return malli;
	}

	public void setMalli(String malli) {
		this.malli = malli;
	}

	public String getRekno() {
		return rekno;
	}

	public void setRekno(String rekno) {
		this.rekno = rekno;
	}

	@Override
	public String toString() {
		return "Auto [merkki=" + merkki + ", malli=" + malli + ", rekno=" + rekno + "]";
	}
}
