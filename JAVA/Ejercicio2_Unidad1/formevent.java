package Ejercicio2_Unidad1.src.ejercicio_unidad1;

import java.util.EventObject;

public class formevent extends EventObject{

	private String name;
    private String ocu;
    private int ageCategory;
    private String empCat;

    public formevent(Object source) {
        super(source);
    }

    public formevent(Object source, String name, String ocu, int ageCat, String empCat) {
        super(source);
        this.name = name;
        this.ocu = ocu;
        this.ageCategory = ageCat;
        this.empCat=empCat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOcu() {
        return ocu;
    }

    public void setOcu(String ocu) {
        this.ocu = ocu;
    }

    public int getAgeCategory() {
        return ageCategory;
    }
    public String getEmploymentCategory() {
    	return empCat;
    }
}
