/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package transform;

import java.sql.Date;

/**
 *
 * @author Shcherbakov
 */
public class RequestData {
    private int id;
    private Date firstDate;
    private Date lastDate;

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
     * @return the firstDate
     */
    public Date getFirstDate() {
        return firstDate;
    }

    /**
     * @param firstDate the firstDate to set
     */
    public void setFirstDate(Date firstDate) {
        this.firstDate = firstDate;
    }

    /**
     * @return the lastDate
     */
    public Date getLastDate() {
        return lastDate;
    }

    /**
     * @param lastDate the lastDate to set
     */
    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

}
