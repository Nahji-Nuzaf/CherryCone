
package model;

public class InvoiceItem {
    
    private String StockId;
    private String proName;
    private String qty;
    private String sellingPrice;
    private String mfd;
    private String exp;

    
    public String getStockId() {
        return StockId;
    }

    
    public void setStockId(String StockId) {
        this.StockId = StockId;
    }

    
    public String getProName() {
        return proName;
    }

    
    public void setProName(String proName) {
        this.proName = proName;
    }

   
    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getSellingPrice() {
        return sellingPrice;
    }

 
    public void setSellingPrice(String sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getMfd() {
        return mfd;
    }

    /**
     * @param mfd the mfd to set
     */
    public void setMfd(String mfd) {
        this.mfd = mfd;
    }


    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }
    
    
}
