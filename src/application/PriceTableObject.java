package application;

import javafx.beans.property.SimpleStringProperty;

public class PriceTableObject {
	
	private final SimpleStringProperty value;
	private final SimpleStringProperty payMethod;
	private final SimpleStringProperty parkType;
	
	public PriceTableObject(String val, String payMeth, String parkT)
	{
		value = new SimpleStringProperty(val);
		payMethod = new SimpleStringProperty(payMeth);
		parkType = new SimpleStringProperty(parkT);
	}
	
	public String getValue() {
        return value.get();
    }
    public void setValue(String val) {
        value.set(val);
    }
        
    public String getPayMethod() {
        return payMethod.get();
    }
    public void setPayMethod(String pay) {
        payMethod.set(pay);
    }
    
    public String getParkType() {
        return parkType.get();
    }
    public void setParkType(String park) {
        parkType.set(park);
    }
	

}
