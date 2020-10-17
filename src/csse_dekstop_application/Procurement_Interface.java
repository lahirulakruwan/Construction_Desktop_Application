/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package csse_dekstop_application;

import org.json.JSONArray;

/**
 *
 * @author Lahiru Lakruwan
 */
public interface Procurement_Interface {
    
    /**
     * 
     * @param userName
     * @param password
     * @return specific site manager details
     */
    
     public  String  validateLoginDetails(String userName,String password); 
     
     
    
     /**
     * get  Requestion Ids
     * @return Requestion Ids
     */      
     public  String  getRequestionIds();
     
     
     /**
     * get Items by  Requestion Ids
     * @param  ItemId
     * @return item list for a relavant requestion id
     */   
     public String getItemByReqNumbers(String ItemId);
     
     
     /**
     * 
     * @param jsonarrayOfObjects
     * @param password
     * @return status requestion approve or not
     */  
     public String approveReq(JSONArray jsonarrayOfObjects);
     
     
     /**
     * get suppliernames
     * @return suppliernames
     */   
     public String getSuppliernames();
     
     
     /**
     * Place purchase orders
     * @param reqId
     * @param supplierName
     * @param addressLine1
     * @param addressLin2
     * @param other
     * @param requiredDate
     * @return result[place order details saved in db message]
     */
     public String placePurchaseOrder(String reqId,String supplierName,String addressLine1,String addressLin2,String other,String requiredDate);
  
     
     /**
     * get all InvoiceIds
     * @return invoiceids
     */ 
     public String getInvoiceIds();
     
     /**
     * get all InvoiceInformations
     * @param reqId
     * @return invoice information for relavant invoice id
     */        
     public String getInvoiceInfo(String reqId);
}
