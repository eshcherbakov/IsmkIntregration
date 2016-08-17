/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package transform;

import java.sql.Date;

public class FactData {
    private int id;
    private Date fdate;
    private double value;
    private String units;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param fdate the fdate to set
     */
    public void setFdate(Date fdate) {
        this.fdate = fdate;
    }

    /**
     * @return the value
     */
    public double getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * @return the units
     */
    public String getUnits() {
        return units;
    }

    /**
     * @param units the units to set
     */
    public void setUnits(String units) {
        this.units = units;
    }

    /**
     * @return the fdate
     */
    public Date getFdate() {
        return fdate;
    }

}
