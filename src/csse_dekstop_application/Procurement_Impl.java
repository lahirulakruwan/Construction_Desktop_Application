/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package csse_dekstop_application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;

/**
 *
 * @author Lahiru Lakruwan
 */
public class Procurement_Impl implements Procurement_Interface{

  
    
    @Override
      @SuppressWarnings("empty-statement")
    public String validateLoginDetails(String username, String password) {
       StringBuffer response = null;
       try {

            final String POST_PARAMS = "{\n" + "    \"username\":" + "\"" + username + "\",\r\n"
                    + "    \"password\":" + "\"" + password + "\"" + "\n}";

            System.out.println(POST_PARAMS);
            URL obj = new URL("http://constructionwebapp.alwaysdata.net/users/userLogin");
            HttpURLConnection postConnection;

            postConnection = (HttpURLConnection) obj.openConnection();
            postConnection.setRequestMethod("POST");

            postConnection.setRequestProperty("Content-Type", "application/json");
            postConnection.setDoOutput(true);
           try (OutputStream os = postConnection.getOutputStream()) {
               os.write(POST_PARAMS.getBytes());
               os.flush();
           }
            int responseCode = postConnection.getResponseCode();
            System.out.println("POST Response Code :  " + responseCode);
            System.out.println("POST Response Message : " + postConnection.getResponseMessage());
            if (responseCode == HttpURLConnection.HTTP_OK) { try (BufferedReader in = new BufferedReader(new InputStreamReader(
                    postConnection.getInputStream()))) {
                String inputLine;
                response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                }
                // print result
                System.out.println(response.toString());

               Constants.Constants.getDetails = response.toString();
            } else {
                System.out.println("POST NOT WORKED");
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(Procurement_Impl .class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Procurement_Impl .class.getName()).log(Level.SEVERE, null, ex);
        }
        return response.toString();
                           
    }

    public  String  getRequestionIds(){
     
       
     try {
                                                
                         URL urlForGetRequest = new URL("http://constructionwebapp.alwaysdata.net/items/getRequestingNumberList");
                         String readLine = null;
                         HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
                         conection.setRequestMethod("GET");
                   
                        int responseCode = conection.getResponseCode();
                        if (responseCode == HttpURLConnection.HTTP_OK) {
                            BufferedReader in = new BufferedReader(
                                     new InputStreamReader(conection.getInputStream()));
                             StringBuffer response = new StringBuffer();
                            while ((readLine = in .readLine()) != null) {
                                response.append(readLine);
                           } in .close();
                            // print result
                         Constants.Constants.getRequestingNumberList = response.toString();

                         System.out.println("JSON String Result " + response.toString());
                            
                        } else {
                             System.out.println("GET NOT WORKED");
                        }                } catch (MalformedURLException ex) {
                        Logger.getLogger( Procurement_Impl.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Procurement_Impl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                               
      return Constants.Constants.getRequestingNumberList;
      
    
    }
    
     public String getItemByReqNumbers(String ItemId)
     {
         StringBuffer response = null;
       try {

            final String POST_PARAMS = "{\n" + " \"ItemID\":" + "\"" + ItemId + "\"" + "\n}";
                  

            System.out.println(POST_PARAMS);
            URL obj = new URL("http://constructionwebapp.alwaysdata.net/items/getItemsByReqNumbers");
            HttpURLConnection postConnection;

            postConnection = (HttpURLConnection) obj.openConnection();
            postConnection.setRequestMethod("POST");

            postConnection.setRequestProperty("Content-Type", "application/json");
            postConnection.setDoOutput(true);
           try (OutputStream os = postConnection.getOutputStream()) {
               os.write(POST_PARAMS.getBytes());
               os.flush();
           }
            int responseCode = postConnection.getResponseCode();
            System.out.println("POST Response Code :  " + responseCode);
            System.out.println("POST Response Message : " + postConnection.getResponseMessage());
            if (responseCode == HttpURLConnection.HTTP_OK) { try (BufferedReader in = new BufferedReader(new InputStreamReader(
                    postConnection.getInputStream()))) {
                String inputLine;
                response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                }
                // print result
                System.out.println(response.toString());

              Constants.Constants.getitemsbyreqnumber = response.toString();
            } else {
                System.out.println("POST NOT WORKED");
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(Procurement_Impl .class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Procurement_Impl .class.getName()).log(Level.SEVERE, null, ex);
        }
        return Constants.Constants.getitemsbyreqnumber;
            
            
        
     }
        
       public String approveReq(JSONArray jsonarrayOfObjects)
       {
           StringBuffer response = null;
       try {

            final String POST_PARAMS = String.valueOf(jsonarrayOfObjects);
                  

            System.out.println(POST_PARAMS);
            URL obj = new URL("http://constructionwebapp.alwaysdata.net/sitemanager/approveReq");
            HttpURLConnection postConnection;

            postConnection = (HttpURLConnection) obj.openConnection();
            postConnection.setRequestMethod("POST");

            postConnection.setRequestProperty("Content-Type", "application/json");
            postConnection.setDoOutput(true);
           try (OutputStream os = postConnection.getOutputStream()) {
               os.write(POST_PARAMS.getBytes());
               os.flush();
           }
            int responseCode = postConnection.getResponseCode();
            System.out.println("POST Response Code :  " + responseCode);
            System.out.println("POST Response Message : " + postConnection.getResponseMessage());
            if (responseCode == HttpURLConnection.HTTP_OK) { try (BufferedReader in = new BufferedReader(new InputStreamReader(
                    postConnection.getInputStream()))) {
                String inputLine;
                response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                }
                // print result
                System.out.println(response.toString());

               Constants.Constants.getStatus = response.toString();
            } else {
                System.out.println("POST NOT WORKED");
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(Procurement_Impl .class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Procurement_Impl .class.getName()).log(Level.SEVERE, null, ex);
        }
        return Constants.Constants.getStatus;
                   
       }
       
   public String getSuppliernames()
   {
         try {
                                                
                         URL urlForGetRequest = new URL("http://constructionwebapp.alwaysdata.net/supplier/getSuppliers");
                         String readLine = null;
                         HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
                         conection.setRequestMethod("GET");
                   
                        int responseCode = conection.getResponseCode();
                        if (responseCode == HttpURLConnection.HTTP_OK) {
                            BufferedReader in = new BufferedReader(
                                     new InputStreamReader(conection.getInputStream()));
                             StringBuffer response = new StringBuffer();
                            while ((readLine = in .readLine()) != null) {
                                response.append(readLine);
                           } in .close();
                            // print result
                          Constants.Constants.getSuppliernamess = response.toString();

                         System.out.println("JSON String Result " + response.toString());
                            
                        } else {
                             System.out.println("GET NOT WORKED");
                        }                } catch (MalformedURLException ex) {
                        Logger.getLogger( Procurement_Impl.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Procurement_Impl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                               
      return Constants.Constants.getSuppliernamess;
        
   }
       
        public String placePurchaseOrder(String reqId,String supplierName,String addressLine1,String addressLin2,String other,String requiredDate){
            
          StringBuffer response = null;
       try {

            final String POST_PARAMS = "{\n" + "    \"reqID\":" + "\"" + reqId + "\",\r\n"
                    +  " \"supplier\":" + "\"" + supplierName + "\",\r\n"
                    +  " \"addressline1\":" + "\"" + addressLine1 + "\",\r\n"
                    +  " \"addressline2\":" + "\"" + addressLin2 + "\",\r\n"
                    +  " \"other\":" + "\"" + other + "\",\r\n"
                    + "    \"requiredDate\":" + "\"" + requiredDate + "\"" + "\n}";

            System.out.println(POST_PARAMS);
            URL obj = new URL("http://constructionwebapp.alwaysdata.net/sitemanager/placeorders");
            HttpURLConnection postConnection;

            postConnection = (HttpURLConnection) obj.openConnection();
            postConnection.setRequestMethod("POST");

            postConnection.setRequestProperty("Content-Type", "application/json");
            postConnection.setDoOutput(true);
           try (OutputStream os = postConnection.getOutputStream()) {
               os.write(POST_PARAMS.getBytes());
               os.flush();
           }
            int responseCode = postConnection.getResponseCode();
            System.out.println("POST Response Code :  " + responseCode);
            System.out.println("POST Response Message : " + postConnection.getResponseMessage());
            if (responseCode == HttpURLConnection.HTTP_OK) { try (BufferedReader in = new BufferedReader(new InputStreamReader(
                    postConnection.getInputStream()))) {
                String inputLine;
                response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                }
                // print result
                System.out.println(response.toString());

               Constants.Constants.placePurchaseOrder = response.toString();
            } else {
                System.out.println("POST NOT WORKED");
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(Procurement_Impl .class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Procurement_Impl .class.getName()).log(Level.SEVERE, null, ex);
        }
        return  Constants.Constants .placePurchaseOrder;
    
        }
            
    public String getInvoiceIds()
    {
         try {
                                                
                         URL urlForGetRequest = new URL("http://constructionwebapp.alwaysdata.net/invoice/getInvoiceIds");
                         String readLine = null;
                         HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
                         conection.setRequestMethod("GET");
                   
                        int responseCode = conection.getResponseCode();
                        if (responseCode == HttpURLConnection.HTTP_OK) {
                            BufferedReader in = new BufferedReader(
                                     new InputStreamReader(conection.getInputStream()));
                             StringBuffer response = new StringBuffer();
                            while ((readLine = in .readLine()) != null) {
                                response.append(readLine);
                           } in .close();
                            // print result
                          Constants.Constants.getInvoiceIds = response.toString();

                         System.out.println("JSON String Result " + response.toString());
                            
                        } else {
                             System.out.println("GET NOT WORKED");
                        }                } catch (MalformedURLException ex) {
                        Logger.getLogger( Procurement_Impl.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Procurement_Impl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                               
      return Constants.Constants.getInvoiceIds;
     
    
    }
    
     public String getInvoiceInfo(String reqId)
     {
        
        StringBuffer response = null;
       try {

            final String POST_PARAMS = "{\n" + " \"invoiceID\":" + "\"" + reqId + "\"" + "\n}";
                  

            System.out.println(POST_PARAMS);
            URL obj = new URL("http://constructionwebapp.alwaysdata.net/invoice/getInvoiceInfoById");
            HttpURLConnection postConnection;

            postConnection = (HttpURLConnection) obj.openConnection();
            postConnection.setRequestMethod("POST");

            postConnection.setRequestProperty("Content-Type", "application/json");
            postConnection.setDoOutput(true);
           try (OutputStream os = postConnection.getOutputStream()) {
               os.write(POST_PARAMS.getBytes());
               os.flush();
           }
            int responseCode = postConnection.getResponseCode();
            System.out.println("POST Response Code :  " + responseCode);
            System.out.println("POST Response Message : " + postConnection.getResponseMessage());
            if (responseCode == HttpURLConnection.HTTP_OK) { try (BufferedReader in = new BufferedReader(new InputStreamReader(
                    postConnection.getInputStream()))) {
                String inputLine;
                response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                }
                // print result
                System.out.println(response.toString());

               Constants.Constants .getInvoiceinfo = response.toString();
            } else {
                System.out.println("POST NOT WORKED");
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(Procurement_Impl .class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Procurement_Impl .class.getName()).log(Level.SEVERE, null, ex);
        }
        return Constants.Constants.getInvoiceinfo;
            
            
     
     
     
     
     
     
     
     
     }
    
    
    
    
    
    
            
}          
  
     
       












          